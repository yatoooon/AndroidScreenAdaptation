package com.yatoooon.screenadaptation;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by yatoooon on 2018/2/6.
 */

public class LoadViewHelper {

    public float actualdensity;
    public float actualdensityDpi;
    public float actualwidth;
    public float actualheight;

    private Context context;
    private int designwidth;
    private int designdpi;
    private float fontsize;
    private String unit;

    public LoadViewHelper(Context context, int designwidth, int designdpi, float fontsize, String unit) {
        this.context = context;
        this.designwidth = designwidth;
        this.designdpi = designdpi;
        this.fontsize = fontsize;
        this.unit = unit;
        float[] actualScreenInfo = ActualScreen.screenInfo(context);
        if (actualScreenInfo.length == 4) {
            actualwidth = actualScreenInfo[0];
            actualheight = actualScreenInfo[1];
            actualdensity = actualScreenInfo[2];
            actualdensityDpi = actualScreenInfo[3];
        }
    }

    public void loadView(ViewGroup viewGroup) {
        loadView(viewGroup, new Conversion(context));
    }

    public void loadView(ViewGroup viewGroup, Conversion conversion) {
        conversion.transform(viewGroup, this);
        for (int i = 0; i < viewGroup.getChildCount(); i++) {
            if (viewGroup.getChildAt(i) instanceof ViewGroup) {
                loadView((ViewGroup) viewGroup.getChildAt(i), conversion);
            } else {
                conversion.transform(viewGroup.getChildAt(i), this);
            }
        }
    }

    public void loadWidthHeightFont(View view) {
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams.width > 0) {
            layoutParams.width = setValue(layoutParams.width);
        }
        if (layoutParams.height > 0) {
            layoutParams.height = setValue(layoutParams.height);
        }
        loadViewFont(view);
    }


    private void loadViewFont(View view) {
        if ((view instanceof TextView)) {
            TextView textView = (TextView) view;
            ((TextView) view).setTextSize(0, setFontSize(textView));
        }
    }

    private float setFontSize(TextView textView) {
        return calculateValue(textView.getTextSize() * fontsize);
    }


    public void loadPadding(View view) {
        view.setPadding(setValue(view.getPaddingLeft()), setValue(view.getPaddingTop()), setValue(view.getPaddingRight()), setValue(view.getPaddingBottom()));
    }


    public void loadLayoutMargin(View view) {
        ViewGroup.LayoutParams params = view.getLayoutParams();
        ViewGroup.MarginLayoutParams marginLayoutParams = null;
        if (params instanceof ViewGroup.MarginLayoutParams) {
            marginLayoutParams = (ViewGroup.MarginLayoutParams) params;
        } else {
            marginLayoutParams = new ViewGroup.MarginLayoutParams(params);
        }
        marginLayoutParams.leftMargin = setValue(marginLayoutParams.leftMargin);
        marginLayoutParams.topMargin = setValue(marginLayoutParams.topMargin);
        marginLayoutParams.rightMargin = setValue(marginLayoutParams.rightMargin);
        marginLayoutParams.bottomMargin = setValue(marginLayoutParams.bottomMargin);
        view.setLayoutParams(marginLayoutParams);
    }

    public int setValue(int value) {
        if (value == 0) {
            return 0;
        }
        return (int) calculateValue(value);
    }

    private float calculateValue(float value) {
        if ("px".equals(unit)) {
            return value * ((float) actualwidth / (float) designwidth);
        } else if ("dp".equals(unit)) {
            int dip = dp2pxutils.px2dip(context, value);
            value = ((float) designdpi / 160) * dip;
            return value * ((float) actualwidth / (float) designwidth);

        }
        return 0;
    }


}
