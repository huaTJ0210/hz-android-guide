package com.hz.myapp.activity;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.hz.myapp.R;

public class QuizActivity extends AppCompatActivity {

    private Button mTrueButton;
    private Button mFalseButton;
    private Button mNextButton;
    private TextView mTextView;
    private int mCurrentIndex = 0;
    private Question[] mQuestionBank = new Question[]{
            new Question(R.string.question_australia,true),
            new Question(R.string.question_oceans,true),
            new Question(R.string.question_mideast,false),
            new Question(R.string.question_africa,false),
            new Question(R.string.question_americas,true),
            new Question(R.string.question_asia,true),
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);
        // 初始化显示文本
        mTextView = findViewById(R.id.quiz_textView);

        mTrueButton = findViewById(R.id.quiz_yes_button);
        mTrueButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                checkAnswer(true);
            }
        });
        mFalseButton = findViewById(R.id.quiz_no_button);
        mFalseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                checkAnswer(false);
            }
        });
        mNextButton = findViewById(R.id.quiz_next_button);
        mNextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mCurrentIndex = (mCurrentIndex + 1) % mQuestionBank.length;
                updateQuestion();
            }
        });

        // 设置文本的初始值
        updateQuestion();
    }

    private void updateQuestion(){
        int question = mQuestionBank[mCurrentIndex].getTextResId();
        mTextView.setText(question);
    }

    private void checkAnswer(boolean userPressedTrue){
        boolean answerIsTrue = mQuestionBank[mCurrentIndex].isAnswerTrue();
        int resId = 0;
        if(answerIsTrue == userPressedTrue){
            resId = R.string.quiz_correct_toast;
        }else{
            resId = R.string.quiz_incorrect_toast;
        }
        showToast(QuizActivity.this,resId);
    }

    private void showToast(Context context,int resId){
        Toast toast = Toast.makeText(context,resId,Toast.LENGTH_SHORT);
        // 设置Toast的显示位置
        toast.setGravity(Gravity.CENTER,0,0);
        toast.show();
    }
}

/*
*  MVC
*  + Model:（模型对象）存储应用数据和业务逻辑，
*  + Controller： 模型对象与视图对象的中间媒介，负责两者之间的信息传递
*  + View ： 视图对象，绘制需要展示的具体内容，响应用户的输入事件，
* */