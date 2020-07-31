package com.gll.testmvvm.viewmodel;

import android.util.Log;

import com.gll.testmvvm.bean.User;

import androidx.databinding.ObservableField;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

/**
 * User: highsixty
 * Date: 2020-02-26 10:46
 * email: gaolulin@sunmi.com
 */
public class OtherViewModel extends ViewModel  {

    private String TAG = OtherViewModel.class.getSimpleName();

    public MutableLiveData<String> one =new MutableLiveData<>("aaaaaaa") ;

    public MutableLiveData<String> two = new MutableLiveData<>("bbbbbbb");


    public MutableLiveData<User> user = new MutableLiveData<User>();

    public ObservableField<String> three = new ObservableField<>("cccccccccccc");

    public ObservableField<MutableLiveData<String>> four = new ObservableField<>(two);

    public void change(){
//        Log.d(TAG, "change: ---------->");
//        one.setValue("ddddddddd");
//        two.setValue("eeeeeeeee");
//        three.set("ffffffffffff");
//        four.set(one);
        user.postValue(new User(true));
    }
}
