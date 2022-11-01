package com.hz.myapp.activity;

import android.app.Dialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.text.method.ScrollingMovementMethod;
import android.util.Log;
import android.view.Display;
import android.view.Gravity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.hz.myapp.R;


public class AlertActivity extends AppCompatActivity {

    private static final String TAG = "AlertActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alert);

    }

    public void openAlertView(View view){
       show();
    }


    public void show() {
        //引入自定义布局
        View view1 = this.getLayoutInflater().inflate(R.layout.jjz_dialog_layout, null);
        //自定义的style 在里面进行了圆角背景的设置
        final Dialog dialog = new Dialog(this, R.style.MyDialogStyle);
        dialog.setContentView(view1);
        dialog.show();
        Window dialogWindow = dialog.getWindow();
        WindowManager m = getWindowManager();
        Display d = m.getDefaultDisplay();
        // 获取对话框当前的参数值
        WindowManager.LayoutParams p = dialogWindow.getAttributes();
        //设置高度和宽度  高度设置为屏幕的0.3
        p.height = (int) (d.getHeight() * 0.75);
        // 宽度设置为屏幕的0.8
        p.width = (int) (d.getWidth() * 0.9);
        //设置位置
        p.gravity = Gravity.CENTER;
        dialogWindow.setAttributes(p);
        dialog.setCanceledOnTouchOutside(true);
        // 设置提示的具体内容
        TextView mTextView = dialog.findViewById(R.id.jjz_tips_content_tv);
        mTextView.setMovementMethod(ScrollingMovementMethod.getInstance());

       String str = "<p>各位驾驶员：<br>1、为严格落实《新型冠状病毒肺炎防控方案(第九版)》，我市对进返京政策做出调整：国内其他口岸入境进京人员，未满10天的，严格限制进京；7天内有1例及以上本土新冠病毒感染者所在县(市、区、旗)旅居史人员，严格限制进京；除限制进返京人员外，持48小时内有效核酸阴性证明、“北京健康宝”绿码，可自行进返京。<br>2、申请进京证后，<span style=\"color:red;\">请您务必在出行前，查看进京证是否审核成功，</span>如进京证申请不成功，请按提示信息修改。<span style=\"color:red;\">在未办理进京通行证情况下，外埠机动车禁止在限行区域内行驶。</span><br>3、按照《北京市机动车停车条例》规定，如您在北京道路停放车辆，请停车入位、停车付费，建议您下载注册“<span style=\"color:red;\">北京交通APP</span>”，绑定车辆查询缴费。<br>感谢您的理解与支持！</p>";
       mTextView.setText(Html.fromHtml(str));
       // 获取选择的项目
        RadioGroup radgroup =  dialog.findViewById(R.id.radioGroup);
        radgroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                RadioButton radbtn = (RadioButton) dialog.findViewById(checkedId);
                Toast.makeText(getApplicationContext(), "按钮组值发生改变,你选了" + radbtn.getText(), Toast.LENGTH_LONG).show();
            }
        });

    }
}