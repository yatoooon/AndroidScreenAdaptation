package com.yatoooon.androidscreenadaptation;

import android.app.Application;

import com.yatoooon.screenadaptation.ScreenAdapterTools;

/**
 * Created by yatoooon on 2018/2/6.
 */

public class App extends Application {

    public static ScreenAdapterTools screenAdapterTools;

    @Override
    public void onCreate() {
        super.onCreate();
        screenAdapterTools = new ScreenAdapterTools(this, 1080, 1);
    }
}
