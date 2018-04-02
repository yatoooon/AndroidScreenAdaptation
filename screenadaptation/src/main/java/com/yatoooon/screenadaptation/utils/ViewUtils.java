package com.yatoooon.screenadaptation.utils;

import android.os.Build;
import android.view.View;

import java.lang.reflect.Method;

/**
 * Created by zhangyuwan0 on 2018/3/20.
 */

public class ViewUtils {

    private static final String METHOD_GET_MAX_WIDTH = "getMaxWidth";
    private static final String METHOD_GET_MAX_HEIGHT = "getMaxHeight";
    private static final String METHOD_GET_MIN_WIDTH = "getMinWidth";
    private static final String METHOD_GET_MIN_HEIGHT = "getMinHeight";
    private static final String METHOD_SET_MAX_WIDTH = "setMaxWidth";
    private static final String METHOD_SET_MAX_HEIGHT = "setMaxHeight";

    public static void setMaxWidth(View view, int value) {
        setValue(view, METHOD_SET_MAX_WIDTH, value);
    }

    public static void setMaxHeight(View view, int value) {
        setValue(view, METHOD_SET_MAX_HEIGHT, value);
    }

    public static void setMinWidth(View view, int value) {
        view.setMinimumWidth(value);
    }

    public static void setMinHeight(View view, int value) {
        view.setMinimumHeight(value);
    }

    public static int getMaxWidth(View view) {
        return getValue(view, METHOD_GET_MAX_WIDTH);
    }

    public static int getMaxHeight(View view) {
        return getValue(view, METHOD_GET_MAX_HEIGHT);
    }

    public static int getMinWidth(View view) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
            return view.getMinimumWidth();
        } else {
            return getValue(view, METHOD_GET_MIN_WIDTH);
        }
    }

    public static int getMinHeight(View view) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
            return view.getMinimumHeight();
        } else {
            return getValue(view, METHOD_GET_MIN_HEIGHT);
        }
    }

    private static int getValue(View view, String getterMethodName) {
        int result = 0;
        try {
            Method getValueMethod = view.getClass().getMethod(getterMethodName);
            result = (int) getValueMethod.invoke(view);
        } catch (Exception e) {
            // do nothing
        }
        return result;
    }

    private static void setValue(View view, String setterMethodName, int value) {
        try {
            Method setValueMethod = view.getClass().getMethod(setterMethodName);
            setValueMethod.invoke(view, value);
        } catch (Exception e) {
            // do nothing
        }
    }

}
