package com.hz.myapp.activity;

import android.content.Intent;
import android.os.Build;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.hz.myapp.R;

public class DemoActivity extends AppCompatActivity {

    private static final String TAG = "DemoActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_demo);

        // 取出临时保存的数据信息
        if (savedInstanceState !=null){
            String tempData = savedInstanceState.getString("data_key");
            Log.d(TAG, "onCreate: ");
        }

        // 当前设备运行API级别
        int level = Build.VERSION.SDK_INT;
        Log.d(TAG, "onCreate: "+level);



        // 获取app的名称
        /*
         *  R.string.app_name 获取的为int值：2131427367
         *  java编译的时候会把string类型变量存放在栈的临时变量表中，并给出一个int类型的ID指向此变量
         * */
    }

    public void  pushToFirstActivity(View view){

        Intent intent = new Intent(DemoActivity.this, FirstActivity.class);
        // 跨界面传值
        intent.putExtra("data","dataFromMainActivity");
        startActivity(intent);

    }

    public void  pushToQuizActivity(View view){
        Intent intent = new Intent(DemoActivity.this, QuizActivity.class);
        startActivity(intent);
    }


    // ---- 返回数据给上一个活动：----
    public void pushNewActivity(){
        Intent intent = new Intent(DemoActivity.this,FirstActivity.class);
        startActivityForResult(intent,1);
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

    /*
     *   活动的启动模式
     *   1、standard：创建activity然后压入到栈中
     *   2、singleTop ：若创建的activity与栈顶一致，则直接使用不再创建
     *   3、singleTask：保证导航栈中不存在重复的activity
     *   4、singleInstance：设置该标识，则表明要单独创建一个新的导航栈
     * */
}