package com.yatoooon.screenadaptation;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;

/**
 * Created by yatoooon on 2018/2/6.
 */

public class ScreenAdapterTools {

    private static AbsLoadViewHelper sLoadViewHelper;

    public static AbsLoadViewHelper getInstance() {
        return sLoadViewHelper;
    }

    public static void init(Context context) {
        init(context, new IProvider() {
            @Override
            public AbsLoadViewHelper provide(Context context, int designWidth, int designDpi, float fontSize, String unit) {
                return new LoadViewHelper(context, designWidth, designDpi, fontSize, unit);
            }
        });
    }

    public static void init(Context context, IProvider provider) {
        ApplicationInfo applicationInfo = null;
        try {
            applicationInfo = context.getPackageManager().getApplicationInfo(context
                    .getPackageName(), PackageManager.GET_META_DATA);
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
        int designwidth = applicationInfo.metaData.getInt("designwidth");
        int designdpi = applicationInfo.metaData.getInt("designdpi");
        float fontsize = applicationInfo.metaData.getFloat("fontsize");
        String unit = applicationInfo.metaData.getString("unit");
        sLoadViewHelper = provider.provide(context, designwidth, designdpi, fontsize, unit);
    }

    public interface IProvider {
        AbsLoadViewHelper provide(Context context, int designWidth, int designDpi, float fontSize, String unit);
    }
}
