package com.yatoooon.screenadaptation;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by yatoooon on 2018/2/6.
 */

public class Conversion {

    //    public static final int MATCH_PARENT = -1;
    //    public static final int WRAP_CONTENT = -2;
    Context context;

    public Conversion(Context context) {
        this.context = context;
    }


    public void transform(View view, LoadViewHelper loadViewHelper) {
        if (view.getLayoutParams() != null) {
            System.out.println("Start WidthHeight               " + view.getLayoutParams().width + "      " + view.getLayoutParams().height);
            loadViewHelper.loadWidthHeightFont(view);
            System.out.println("End  WidthHeight             " + view.getLayoutParams().width + "      " + view.getLayoutParams().height);
            System.out.println("Start  Padding               " + view.getPaddingLeft() + "      " + view.getPaddingTop() + "     " + view.getPaddingRight() + "     " + view.getPaddingBottom() + "     ");
            loadViewHelper.loadPadding(view);
            System.out.println("End  Padding               " + view.getPaddingLeft() + "      " + view.getPaddingTop() + "     " + view.getPaddingRight() + "     " + view.getPaddingBottom() + "     ");
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
            System.out.println("Start  Margin               " + marginLayoutParams.leftMargin + "      " + marginLayoutParams.topMargin + "     " + marginLayoutParams.rightMargin + "     " + marginLayoutParams.bottomMargin);
            loadViewHelper.loadLayoutMargin(view);
            System.out.println("End  Margin               " + marginLayoutParams.leftMargin + "      " + marginLayoutParams.topMargin + "     " + marginLayoutParams.rightMargin + "     " + marginLayoutParams.bottomMargin);
        }


    }
}
