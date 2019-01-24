package com.example.lawre.week3day3homework;

import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.EventLog;
import android.util.Log;

import com.example.lawre.week3day3homework.events.UserEvent;
import com.example.lawre.week3day3homework.model.datasource.httpUrlConnection.HttpUrlConnTask;
import com.example.lawre.week3day3homework.model.user.Result;
import com.example.lawre.week3day3homework.model.user.UserResponse;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyc;
    RecyclerViewAdapter rva;
    FullFragment fullFrag;
    FragmentManager fm;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyc = findViewById(R.id.rvRecycler);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        recyc.setLayoutManager(layoutManager);
        HttpUrlConnTask httpUrlConnTask = new HttpUrlConnTask();
        httpUrlConnTask.execute();
        fm = getSupportFragmentManager();
    }

    @Override
    protected void onStart() {
        super.onStart();
        EventBus.getDefault().register(this);
    }

    @Override
    protected void onStop() {
        super.onStop();
        EventBus.getDefault().unregister(this);
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void userEvent(UserEvent event)
    {
        if(event != null)
        {
            UserResponse user = event.getUserResponse();
            System.out.println(user.getResults().get(0).getName().getFullName());
            ArrayList<Result> list = new ArrayList<>();
            for(int i=0;i<user.getResults().size();i++)
            {
                list.add(user.getResults().get(i));
                Log.d("MAIN_ACT", "userEvent: "+list.get(i).getName().getFullName());
            }
            rva = new RecyclerViewAdapter(list);
            rva.setFragManager(fm);
            recyc.setAdapter(rva);
        }
    }
}
