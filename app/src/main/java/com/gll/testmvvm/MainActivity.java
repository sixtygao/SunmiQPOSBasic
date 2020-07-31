package com.gll.testmvvm;

import android.os.Bundle;
import android.util.Log;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class MainActivity extends AppCompatActivity {


    private String TAG = "TAG" ;
    private RecyclerView recyclerView;
    CommenRecycleViewAdapter<MyBean> adapter;
    private List<MyBean> beans =new ArrayList<>();
    MyBeanModule myBeanModule;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = findViewById(R.id.rcv);

        for(int i=0;i<10;i++){

            MyBean bean = new MyBean("aaaaaaaa"+i,"bbbbbbbb"+i);
            beans.add(bean);
        }

        myBeanModule = new MyBeanModule();
        myBeanModule.setBeans(beans);

         adapter = new CommenRecycleViewAdapter<>(this,getLayoutInflater(), BR.bean,myBeanModule.getBeans());

        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        recyclerView.setAdapter(adapter);
    }

    public void change(View view){
        Log.d(TAG, "change: --------->");

        MyBean bean = new MyBean("ccccccccccc","ddddddddddd");
        beans.add(bean);
        myBeanModule.setBeans(beans);
        adapter.notifyDataSetChanged();
    }
}
