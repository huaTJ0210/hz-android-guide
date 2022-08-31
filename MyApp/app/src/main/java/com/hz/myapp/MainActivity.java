package com.hz.myapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.hz.myapp.activity.DemoActivity;

import java.util.ArrayList;


public class MainActivity extends AppCompatActivity {

    private static final ArrayList<String > activities = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initData();
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recycle_view);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);
        MainActivityRecyclerviewAdapter adapter = new MainActivityRecyclerviewAdapter(activities,this);
        recyclerView.setAdapter(adapter);
    }

    public void openActivity(int index){
        String activityName = activities.get(index);
        Intent intent = null;
        switch (activityName){
            case "DemoActivity" :
                intent = new Intent(MainActivity.this, DemoActivity.class);
                break;
            default:
                break;
        }
       startActivity(intent);
    }

    public void initData(){
        activities.add("DemoActivity");
    }
}
