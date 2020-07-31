package com.gll.testmvvm;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.DialogFragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;
import android.provider.Settings;
import android.util.Log;
import android.view.View;

import com.gll.testmvvm.bean.User;
import com.gll.testmvvm.databinding.ActivityOtherBinding;
import com.gll.testmvvm.viewmodel.OtherViewModel;

import org.jetbrains.annotations.NotNull;

import java.util.UUID;

public class OtherActivity extends AppCompatActivity {

    String TAG = "OtherActivity";
    ActivityOtherBinding otherBinding;
    OtherViewModel otherViewModel;
    private BtnClick click;
    private DialogFragment dialogFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        dialogFragment = new MyDialog();

        String uniqueID = UUID.randomUUID().toString();

        Log.d(TAG, "onCreate  UUID  ----------->"+uniqueID);//3d4da6da-fba9-4251-b062-5aa95ead284d


        String androidid = Settings.Secure.getString(getContentResolver(),Settings.Secure.ANDROID_ID);

        Log.d(TAG, "onCreate androidid ------------>"+androidid);//a8be8c29b7edbd2a //4e0dc6824a0b9f71
click = new BtnClick() {

    @Override
    public void onClickListener(@NotNull View view, int a) {
        Log.d(TAG, "onClickListener: --------->"+a);
        dialogFragment.show(getSupportFragmentManager(),"test");
    }
};

        otherBinding = DataBindingUtil.setContentView(this,R.layout.activity_other);
        otherViewModel = new ViewModelProvider(this).get(OtherViewModel.class);

        otherBinding.setOther(otherViewModel);
        otherBinding.setClicklistener(click);

        otherBinding.setLifecycleOwner(this);

        otherViewModel.one.observe(this, new Observer<String>() {
            @Override
            public void onChanged(String s) {
                Log.d(TAG, "one onChanged: --------->"+s);
            }
        });

        otherViewModel.two.observe(this, new Observer<String>() {
            @Override
            public void onChanged(String s) {
                Log.d(TAG, "two onChanged: --------->"+s);
            }
        });

        otherViewModel.four.get().observe(this, new Observer<String>() {
            @Override
            public void onChanged(String s) {
                Log.d(TAG, "four  onChanged: ---------->"+s);
            }
        });

        otherViewModel.user.observe(this, new Observer<User>() {
            @Override
            public void onChanged(User user) {
                Log.d(TAG, "onChanged: ------->"+user.getA());
            }
        });
    }
}
