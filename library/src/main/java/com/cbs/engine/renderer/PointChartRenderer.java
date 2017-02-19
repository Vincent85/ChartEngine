package com.cbs.engine.renderer;

import android.content.Context;
import android.graphics.Color;

import com.cbs.engine.util.SystemUtil;

/**
 * date: 2017/2/12 0012
 * author: cbs
 */

public class PointChartRenderer extends LineChartRender {

    private static final int DEFAULT_RADIUS = 5;  //dp unit
    private static final int DEFAULT_POINT_TEXT_PADDING = 5; //dp unit
    private static final int DEFAULT_VALUE_TEXT_SIZE = 10; // sp unit
    private static final int DEFAULT_VALUE_TEXT_COLOR = Color.LTGRAY;

    /**
     * 数据点半径
     */
    private int mRadius;
    /**
     * 数据点颜色
     */
    private int mPointColor = Color.GREEN;

    /**
     * 数据点和数值文本间距
     */
    private int mPointTextPadding;

    public PointChartRenderer(Context context) {
        mRadius = SystemUtil.dip2px(context,DEFAULT_RADIUS);
        mPointTextPadding = SystemUtil.dip2px(context, DEFAULT_POINT_TEXT_PADDING);
        setmValueTextSize((int) SystemUtil.sp2px(context, (float) DEFAULT_VALUE_TEXT_SIZE, SystemUtil.CHINESE));
        setmValueTextColor(DEFAULT_VALUE_TEXT_COLOR);
    }

    public int getmRadius() {
        return mRadius;
    }

    public void setmRadius(int mRadius) {
        this.mRadius = mRadius;
    }

    public int getmPointColor() {
        return mPointColor;
    }

    public void setmPointColor(int mPointColor) {
        this.mPointColor = mPointColor;
    }

    public int getmPointTextPadding() {
        return mPointTextPadding;
    }

    public void setmPointTextPadding(int mPointTextPadding) {
        this.mPointTextPadding = mPointTextPadding;
    }


}
