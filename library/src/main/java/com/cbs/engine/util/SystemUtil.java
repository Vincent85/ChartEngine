package com.cbs.engine.util;

import android.content.Context;

/**
 * date: 2017/2/11 0011
 * author: cbs
 */

public class SystemUtil {

    public static final int CHINESE = 0;
    public static final int NUMBER_OR_CHARACTER = 1;

    /**
     * 根据手机的分辨率从 dp 的单位 转成为 px(像素)
     *
     * @param context
     * @param dpValue
     * @return
     */
    public static int dip2px(Context context, float dpValue) {
        final float scale = context.getResources().getDisplayMetrics().density;
        return (int) (dpValue * scale + 0.5f);
    }

    /**
     * 根据手机的分辨率从 px(像素) 的单位 转成为 dp
     *
     * @param context
     * @param pxValue
     * @return
     */
    public static int px2dip(Context context, float pxValue) {
        final float scale = context.getResources().getDisplayMetrics().density;
        return (int) (pxValue / scale + 0.5f);
    }

    /**
     * sp转成px
     * @param spValue
     * @param type
     * @return
     */
    public static float sp2px(Context context,float spValue, int type) {
        float scaledDensity = context.getResources().getDisplayMetrics().scaledDensity;
        switch (type) {
            case CHINESE:
                return spValue * scaledDensity;
            case NUMBER_OR_CHARACTER:
                return spValue * scaledDensity * 10.0f / 18.0f;
            default:
                return spValue * scaledDensity;
        }
    }
}
