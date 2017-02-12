package com.cbs.engine.renderer;

import android.graphics.Color;

/**
 * date: 2017/2/12 0012
 * author: cbs
 */

public class PointChartRenderer extends LineChartRender {

    private static final int DEFAULT_RADIUS = 10;

    /**
     * 数据点半径
     */
    private int mRadius = DEFAULT_RADIUS;
    /**
     * 数据点颜色
     */
    private int mPointColor = Color.GREEN;

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
}
