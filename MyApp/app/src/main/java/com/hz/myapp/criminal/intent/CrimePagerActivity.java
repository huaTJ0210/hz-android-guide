package com.hz.myapp.criminal.intent;

import android.content.Context;
import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.hz.myapp.R;

import java.util.List;
import java.util.UUID;

public class CrimePagerActivity extends AppCompatActivity {

    private static final String EXTRA_CRIME_ID = "criminal_intent.crime_id";
    private ViewPager mViewPager;
    private List<Crime> mCrimes;
    private CrimeFragment mCrimeFragment;

    private static final String TAG = "CrimePagerActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crime_pager);

        mViewPager = findViewById(R.id.activity_crime_pager_view_pager);
        mCrimes = CrimeLab.get(this).getCrimeList();
        FragmentManager fragmentManager = getSupportFragmentManager();
        // FragmentStatePagerAdapter 负责管理与ViewPager的对话并协同工作
        mViewPager.setAdapter(new FragmentStatePagerAdapter(fragmentManager) {
            @Override
            public Fragment getItem(int i) {
                Crime crime = mCrimes.get(i);
                 mCrimeFragment =  CrimeFragment.newInstance(crime.getId());
                return mCrimeFragment;
            }

            @Override
            public int getCount() {
                return mCrimes.size();
            }
        });
        // 设置默认选中的项
         UUID uuid = (UUID) getIntent().getSerializableExtra(EXTRA_CRIME_ID);
         Crime crime = CrimeLab.get(this).getCrime(uuid);
         mViewPager.setCurrentItem(mCrimes.indexOf(crime));
    }

    public static Intent newIntent(Context context, UUID crimeId){
        Intent intent = new Intent(context,CrimePagerActivity.class);
        intent.putExtra(EXTRA_CRIME_ID,crimeId);
        return  intent;
    }

    @Override
    public void onBackPressed() {
        mCrimeFragment.returnResult();
        finish();
    }
}