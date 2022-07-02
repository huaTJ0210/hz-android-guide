package com.hz.myapp;

import android.content.Intent;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.hz.myapp.activity.FirstActivity;

public class MainActivity extends AppCompatActivity {

    // Log的标记
    private static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // 取出临时保存的数据信息
        if (savedInstanceState !=null){
            String tempData = savedInstanceState.getString("data_key");
            Log.d(TAG, "onCreate: ");
        }


        // 获取app的名称
        /*
        *  R.string.app_name 获取的为int值：2131427367
        *  java编译的时候会把string类型变量存放在栈的临时变量表中，并给出一个int类型的ID指向此变量
        * */
        String appName = getString(R.string.app_name);
        Log.d(TAG, "onCreate: "+ appName);

        Button button = (Button)findViewById(R.id.mainActivity_button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
    }

    public void  pushToFirstActivity(View view){

//        Intent intent = new Intent(MainActivity.this, FirstActivity.class);
//        // 跨界面传值
//        intent.putExtra("data","dataFromMainActivity");
//        startActivity(intent);

        // 返回数据给上一个活动：
        Intent intent = new Intent(MainActivity.this,FirstActivity.class);
        startActivityForResult(intent,1);
    }

    public void pushNewActivity(){
        Intent intent = new Intent(MainActivity.this,FirstActivity.class);
        startActivityForResult(intent,1);
        startActivity(intent);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        switch(requestCode){
            case 1:
                if (resultCode == RESULT_OK){
                String returnedData = data.getStringExtra("data_return");
                Toast.makeText(this, returnedData, Toast.LENGTH_SHORT).show();
            }
        }
    }

    // 将临时数据进行保存
    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        String tempData = "Something you just typed";
        outState.putString("data_key",tempData);
    }
}
