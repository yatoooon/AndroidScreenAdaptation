package com.yatoooon.androidscreenadaptation;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.yatoooon.screenadaptation.ScreenAdapterTools;

/**
 * Created by yatoooon on 2018/2/27.
 */

public class TestActivity extends AppCompatActivity {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.test_px);
        ScreenAdapterTools.getInstance().reset(this);//如果希望android7.0分屏也适配的话,加上这句
        ScreenAdapterTools.getInstance().loadView(getWindow().getDecorView());
    }

}
