package com.yatoooon.androidscreenadaptation;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by yatoooon on 2018/2/27.
 */

public class TestFragmentActivity extends AppCompatActivity {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment_test_dp);
        FragmentManager fragmentManager = getSupportFragmentManager();
        TestFragment testFragment = new TestFragment();
        fragmentManager.beginTransaction().replace(R.id.main_container,testFragment).commit();

    }
}
