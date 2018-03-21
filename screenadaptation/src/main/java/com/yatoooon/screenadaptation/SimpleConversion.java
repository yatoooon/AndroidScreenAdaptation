package com.yatoooon.screenadaptation;

import android.view.View;

/**
 * Created by yosemite on 2018/3/21.
 */

public class SimpleConversion implements IConversion {

    @Override
    public void transform(View view, LoadViewHelper loadViewHelper) {
        if (view.getLayoutParams() != null) {
            loadViewHelper.loadWidthHeightFont(view);
            loadViewHelper.loadPadding(view);
            loadViewHelper.loadLayoutMargin(view);
        }
    }

}
