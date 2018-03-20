package com.yatoooon.screenadaptation;

import android.content.Context;
import android.view.View;

/**
 * Created by yatoooon on 2018/2/6.
 */

public class Conversion {

    Context context;

    public Conversion(Context context) {
        this.context = context;
    }

    public void transform(View view, LoadViewHelper loadViewHelper) {
        if (view.getLayoutParams() != null) {
            loadViewHelper.loadWidthHeightFont(view);
            loadViewHelper.loadPadding(view);
            loadViewHelper.loadLayoutMargin(view);
            loadViewHelper.loadMaxWidthAndHeight(view);
            loadViewHelper.loadMinWidthAndHeight(view);
        }
    }

}
