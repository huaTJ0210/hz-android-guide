package com.hz.myapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.hz.myapp.activity.AlertActivity;
import com.hz.myapp.activity.DemoActivity;
import com.hz.myapp.criminal.intent.CrimeActivity;
import com.hz.myapp.criminal.intent.CrimeListActivity;

import java.util.ArrayList;
import java.util.Arrays;


public class MainActivity extends AppCompatActivity {

    private static final ArrayList<String > activities = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initData();
        RecyclerView recyclerView = findViewById(R.id.recycle_view);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);
        MainActivityRecyclerviewAdapter adapter = new MainActivityRecyclerviewAdapter(activities);
        adapter.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onClick(int position) {
                openActivity(position);
            }
        });
        recyclerView.setAdapter(adapter);
    }

    public void openActivity(int index){
        String activityName = activities.get(index);
        Intent intent = null;
        switch (activityName){
            case "DemoActivity" :
                intent = new Intent(MainActivity.this, DemoActivity.class);
                break;
            case "CrimeActivity":
                intent = new Intent(MainActivity.this, CrimeActivity.class);
                break;
            case "CrimeListActivity":
                intent = new Intent(MainActivity.this, CrimeListActivity.class);
                break;
            case "AlertActivity":
                intent = new Intent(MainActivity.this, AlertActivity.class);
                break;
            default:
                break;
        }
       startActivity(intent);
    }

    public void initData(){
        String[] list = {"DemoActivity","CrimeActivity","CrimeListActivity","AlertActivity"};
        activities.addAll(Arrays.asList(list));
    }


}
