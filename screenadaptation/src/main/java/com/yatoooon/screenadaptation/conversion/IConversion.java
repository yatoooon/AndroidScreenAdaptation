package com.yatoooon.screenadaptation.conversion;

import android.view.View;

import com.yatoooon.screenadaptation.AbsLoadViewHelper;
import com.yatoooon.screenadaptation.LoadViewHelper;

/**
 * Conversion接口
 * Created by 章鱼小丸子 on 2018/3/21.
 */

public interface IConversion {

    void transform(View view, AbsLoadViewHelper loadViewHelper);

}
