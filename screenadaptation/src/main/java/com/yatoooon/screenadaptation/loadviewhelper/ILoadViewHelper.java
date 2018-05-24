package com.yatoooon.screenadaptation.loadviewhelper;

import android.view.View;

/**
 * Created by yatoooon on 2018/5/24.
 */

public interface ILoadViewHelper {
    void loadWidthHeightFont(View view);

     void loadPadding(View view);

     void loadLayoutMargin(View view);

     void loadMaxWidthAndHeight(View view);

     void loadMinWidthAndHeight(View view);

     int loadCustomAttrValue(int px);
}
