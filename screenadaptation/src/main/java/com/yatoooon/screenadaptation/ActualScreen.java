package com.yatoooon.screenadaptation;


import android.content.Context;
import android.util.DisplayMetrics;
import android.view.WindowManager;

import static android.content.Context.WINDOW_SERVICE;


public class ActualScreen {

    public int width;
    public int height;

    public ActualScreen(Context context) {
        int[] screenSize = screenWidthHeight(context);
        if (screenSize.length == 2) {
            width = screenSize[0];
            height = screenSize[1];
        }
    }

    public static int[] screenWidthHeight(Context context) {
        DisplayMetrics displayMetrics = new DisplayMetrics();
        WindowManager windowManager = (WindowManager) context.getSystemService(WINDOW_SERVICE);
        windowManager.getDefaultDisplay().getMetrics(displayMetrics);
        return new int[]{displayMetrics.widthPixels, displayMetrics.heightPixels};
    }
}

