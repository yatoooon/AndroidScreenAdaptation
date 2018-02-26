package com.yatoooon.screenadaptation;

import android.content.Context;

/**
 * Created by yatoooon on 2018/2/6.
 */

public class ScreenAdapterTools {

    private LoadViewHelper loadViewHelper;

    public LoadViewHelper getInstance() {
        return loadViewHelper;
    }

    public ScreenAdapterTools(Context context, int drawingsize, int drawingdpi,float fontsize, String unit) {
        loadViewHelper = new LoadViewHelper(context, drawingsize, drawingdpi,fontsize, unit);
    }

}
