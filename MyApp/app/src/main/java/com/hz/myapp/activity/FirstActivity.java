package com.hz.myapp.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.hz.myapp.R;

public class FirstActivity extends AppCompatActivity {

    // 活动被第一次创建的时候使用：加载布局、绑定事件
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.first_layout);

        Intent intent = getIntent();
        String data = intent.getStringExtra("data");
        Toast.makeText(this, data, Toast.LENGTH_SHORT).show();
    }

    public void  toastMessage(View v){
        Toast.makeText(this, "FirstActivity", Toast.LENGTH_SHORT).show();

        // 1
        Intent intent = new Intent();
        intent.putExtra("data_return","Hello FirstActivity");
        setResult(RESULT_OK,intent);
        finish();
    }

    // 对于back键的监听
    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Intent intent = new Intent();
        intent.putExtra("data_return_data","hello MainActivity");
        setResult(RESULT_OK,intent);
        finish();
    }

    // 活动的生命周期

    // activity由不可见变为可见
    @Override
    protected void onStart() {
        super.onStart();
    }

    // activity准备好与用户进行交互，activity处于栈顶，并且处于运行状态
    @Override
    protected void onResume() {
        super.onResume();
    }
    // 系统在准备去启动或者恢复另一个activity活动的时候去调用
    @Override
    protected void onPause() {
        super.onPause();
    }
   // 活动完全不可见
    @Override
    protected void onStop() {
        super.onStop();
    }
    // 活动销毁之前调用
    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
    // 这个活动由停止状态变为运行状态之前调用
    @Override
    protected void onRestart() {
        super.onRestart();
    }
}
