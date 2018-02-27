package com.yatoooon.androidscreenadaptation;

import android.app.Application;

import com.yatoooon.screenadaptation.ScreenAdapterTools;

/**
 * Created by yatoooon on 2018/2/6.
 */

public class App extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        ScreenAdapterTools.init(this);
    }

}
