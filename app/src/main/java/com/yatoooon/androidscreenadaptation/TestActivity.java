package com.yatoooon.androidscreenadaptation;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.ViewGroup;

import com.yatoooon.screenadaptation.ScreenAdapterTools;

/**
 * Created by yatoooon on 2018/2/27.
 */

public class TestActivity extends AppCompatActivity {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.test_dp);
        ScreenAdapterTools.reset(this);
        ScreenAdapterTools.adaptView((ViewGroup) getWindow().getDecorView());
    }

}
