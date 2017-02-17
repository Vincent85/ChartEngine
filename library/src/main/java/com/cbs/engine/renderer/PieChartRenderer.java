package com.cbs.engine.renderer;

import android.graphics.Color;

/**
 * date: 2017/2/16 0016
 * author: cbs
 */

public class PieChartRenderer extends DefaultRenderer {

    private static final int DEFAULT_START_ANGLE = 0;
    private static final int DEFAULT_RADIUS = 150;
    /**
     * 绘制开始角度
     */
    private int mStartAngle = DEFAULT_START_ANGLE;

    /**
     * 饼图填充颜色，
     * 最少设置两种填充颜色
     */
    private int[] mFillColors = new int[]{Color.RED,Color.GREEN,Color.MAGENTA,Color.BLUE,Color.YELLOW,Color.CYAN};

    /**
     * 饼图半径
     */
    private int mRadius = DEFAULT_RADIUS;

    /**
     * 是否要突出显示某个数据
     * 当前只支持突出显示一个数据饼块
     */
    private boolean isHighlightDisplay = false;

    public int getmStartAngle() {
        return mStartAngle;
    }

    public void setmStartAngle(int mStartAngle) {
        this.mStartAngle = mStartAngle;
    }

    public int[] getmFillColors() {
        return mFillColors;
    }

    public void setmFillColors(int[] mFillColors) {
        if (null == mFillColors || mFillColors.length < 2) {
            throw new RuntimeException("PieChart fill Color type must great than two...");
        }
        this.mFillColors = mFillColors;
    }

    public int getmRadius() {
        return mRadius;
    }

    public void setmRadius(int mRadius) {
        this.mRadius = mRadius;
    }

    public boolean isHighlightDisplay() {
        return isHighlightDisplay;
    }

    public void setHighlightDisplay(boolean highlightDisplay) {
        isHighlightDisplay = highlightDisplay;
    }
}
