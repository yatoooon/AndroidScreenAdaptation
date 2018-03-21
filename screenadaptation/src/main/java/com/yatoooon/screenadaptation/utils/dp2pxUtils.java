package com.yatoooon.screenadaptation.utils;

import android.content.Context;
import android.util.Log;

/**
 * Created by yatoooon on 2018/2/11.
 */

public class dp2pxUtils {
    private static final String TAG = "dp2pxUtils";

    public static int dip2px(Context context, float dpValue) {
        final float scale = context.getResources().getDisplayMetrics().density;
        return (int) (dpValue * scale + 0.5f);
    }

    public static int dip2px(float density, float dpValue) {
        return (int) (dpValue * density + 0.5f);
    }

    public static int px2dip(Context context, float pxValue) {
        final float scale = context.getResources().getDisplayMetrics().density;
        return (int) (pxValue / scale + 0.5f);
    }

    public static int px2dip(float density, float pxValue) {
        return (int) (pxValue / density + 0.5f);
    }
}
