package com.cbs.engine.renderer;

import android.graphics.Color;

/**
 * date: 2017/2/12 0012
 * author: cbs
 */

public class PolyLineChartRender extends LineChartRender {

    private static final int DEFAULT_LINE_WIDTH = 5;
    /**
     * 数据线宽度
     */
    private int mLineWidth = DEFAULT_LINE_WIDTH;
    /**
     * 数据线颜色
     */
    private int mLineColor = Color.GREEN;

    public int getmLineWidth() {
        return mLineWidth;
    }

    public void setmLineWidth(int mLineWidth) {
        this.mLineWidth = mLineWidth;
    }

    public int getmLineColor() {
        return mLineColor;
    }

    public void setmLineColor(int mLineColor) {
        this.mLineColor = mLineColor;
    }
}
