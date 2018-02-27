package com.yatoooon.screenadaptation;


import android.content.Context;
import android.util.DisplayMetrics;
import android.view.WindowManager;

import static android.content.Context.WINDOW_SERVICE;


public class ActualScreen {

    public float density;
    public float densityDpi;
    public float width;
    public float height;

    public ActualScreen(Context context) {
        float[] screenInfo = screenWidthHeight(context);
        if (screenInfo.length == 4) {
            width = screenInfo[0];
            height = screenInfo[1];
            density = screenInfo[2];
            densityDpi = screenInfo[3];
        }
    }

    public static float[] screenWidthHeight(Context context) {
        DisplayMetrics displayMetrics = new DisplayMetrics();
        WindowManager windowManager = (WindowManager) context.getSystemService(WINDOW_SERVICE);
        windowManager.getDefaultDisplay().getMetrics(displayMetrics);
        return new float[]{displayMetrics.widthPixels, displayMetrics.heightPixels, displayMetrics.density, displayMetrics.densityDpi};
    }


}

