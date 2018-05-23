package com.yatoooon.androidscreenadaptation;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.yatoooon.screenadaptation.ScreenAdapterTools;

/**
 * Created by yatoooon on 2018/3/16.
 */

public class TestCustomViewActivity extends AppCompatActivity {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customview);
        ScreenAdapterTools.getInstance().loadView(getWindow().getDecorView());

    }
}
