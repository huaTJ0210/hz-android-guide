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
    }

    public void getEditText(View view){
        EditText editText  = (EditText)findViewById(R.id.second_activity_edit_text);
        Log.d(TAG, "getEditText: "+ editText.getText());
    }
}