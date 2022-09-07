package com.hz.myapp.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

import com.hz.myapp.R;

public class SecondActivity extends AppCompatActivity {

    private static final String TAG = "SecondActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        Log.d(TAG, "onCreate: ");
    }

    public void getEditText(View view){
        EditText editText  = (EditText)findViewById(R.id.second_activity_edit_text);
        Log.d(TAG, "getEditText: "+ editText.getText());
    }
    // ---------------- 活动的生命周期 ----------------

    // activity由不可见变为可见
    @Override
    protected void onStart() {
        super.onStart();
        Log.d(TAG, "onStart: ");
    }

    // activity准备好与用户进行交互，activity处于栈顶，并且处于运行状态
    @Override
    protected void onResume() {
        super.onResume();
        Log.d(TAG, "onResume: ");
    }

    // 系统在准备去启动或者恢复另一个activity活动的时候去调用
    @Override
    protected void onPause() {

        super.onPause();
        Log.d(TAG, "onPause: ");
    }
    // 活动完全不可见
    @Override
    protected void onStop() {

        super.onStop();
        Log.d(TAG, "onStop: ");
    }
    // 活动销毁之前调用
    @Override
    protected void onDestroy() {

        super.onDestroy();
        Log.d(TAG, "onDestroy: ");
    }
    // 这个活动由停止状态变为运行状态之前调用
    @Override
    protected void onRestart() {

        super.onRestart();
        Log.d(TAG, "onRestart: ");
    }
}