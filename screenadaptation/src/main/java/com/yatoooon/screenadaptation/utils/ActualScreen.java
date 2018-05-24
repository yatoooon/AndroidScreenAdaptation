package com.yatoooon.screenadaptation.utils;


import android.content.Context;
import android.util.DisplayMetrics;
import android.view.WindowManager;

import static android.content.Context.WINDOW_SERVICE;

public class ActualScreen {

    public static float[] screenInfo(Context context) {
        DisplayMetrics displayMetrics = new DisplayMetrics();
        WindowManager windowManager = (WindowManager) context.getSystemService(WINDOW_SERVICE);
        windowManager.getDefaultDisplay().getMetrics(displayMetrics);
        return new float[]{displayMetrics.widthPixels, displayMetrics.heightPixels, displayMetrics.density, displayMetrics.densityDpi};
    }

}

