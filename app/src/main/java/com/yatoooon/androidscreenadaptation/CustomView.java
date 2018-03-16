package com.yatoooon.androidscreenadaptation;


import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

import com.yatoooon.screenadaptation.ScreenAdapterTools;

/**
 * Created by yatoooon on 2018/3/16.
 */

public class CustomView extends RelativeLayout {

    public CustomView(Context context) {
        this(context, null);
    }

    public CustomView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public CustomView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        View view = LayoutInflater.from(context).inflate(R.layout.customview, this, true);
        //自定义view需要先进行是否预览模式的判断,不然预览会有问题.
        if (!isInEditMode()) {
            ScreenAdapterTools.getInstance().loadView((ViewGroup) view);
        }
    }

}

