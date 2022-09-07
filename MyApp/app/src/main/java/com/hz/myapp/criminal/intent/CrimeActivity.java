package com.hz.myapp.criminal.intent;

import android.content.Context;
import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.hz.myapp.R;

import java.util.UUID;

public class CrimeActivity extends SingleFragmentActivity {

    private static final String EXTRA_CRIME_ID = "criminal_intent.crime_id";
    private CrimeFragment mCrimeFragment;

    @Override
    protected Fragment createFragment() {
        UUID uuid = (UUID) getIntent().getSerializableExtra(EXTRA_CRIME_ID);
        mCrimeFragment = CrimeFragment.newInstance(uuid);
        return  mCrimeFragment;
    }

    public static Intent newIntent(Context context, UUID crimeId){
        Intent intent = new Intent(context,CrimeActivity.class);
        intent.putExtra(EXTRA_CRIME_ID,crimeId);
        return  intent;
    }

    @Override
    public void onBackPressed() {
//        super.onBackPressed(); 此方法不能调用
         mCrimeFragment.returnResult();
        finish();
    }
}

/*
*   fragment:控制器对象，可以管理用户界面，
*   Activity预留位置给fragment视图插入
* */