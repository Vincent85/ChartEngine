package com.cbs.engine.renderer;

import android.graphics.Color;

/**
 * date: 2017/2/16 0016
 * author: cbs
 */

public class BarChartRenderer extends LineChartRender {

    private static final int DEFAULT_BAR_WIDTH = 120;
    /**
     * 柱体颜色
     */
    private int mBarColor = Color.GREEN;
    /**
     * 柱体宽度
     */
    private int mBarWidth = DEFAULT_BAR_WIDTH;

    public int getmBarColor() {
        return mBarColor;
    }

    public void setmBarColor(int mBarColor) {
        this.mBarColor = mBarColor;
    }

    public int getmBarWidth() {
        return mBarWidth;
    }

    public void setmBarWidth(int mBarWidth) {
        this.mBarWidth = mBarWidth;
    }
}
