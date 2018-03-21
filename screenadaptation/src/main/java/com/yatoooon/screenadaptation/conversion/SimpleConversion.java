package com.yatoooon.screenadaptation.conversion;

import android.view.View;

import com.yatoooon.screenadaptation.AbsLoadViewHelper;
import com.yatoooon.screenadaptation.LoadViewHelper;

/**
 * 仅适配width/height/padding/margin
 * Created by 章鱼小丸子 on 2018/3/21.
 */

public class SimpleConversion implements IConversion {

    @Override
    public void transform(View view, AbsLoadViewHelper loadViewHelper) {
        if (view.getLayoutParams() != null) {
            loadViewHelper.loadWidthHeightFont(view);
            loadViewHelper.loadPadding(view);
            loadViewHelper.loadLayoutMargin(view);
        }
    }

}
