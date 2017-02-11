package com.cbs.engine.renderer;

import android.graphics.Color;

/**
 * date: 2017/2/11 0011
 * author: cbs
 */

public class LineChartRender extends DefaultRenderer {

    private static final int DEFAULT_TITLE_SIZE = 30;
    private static final int DEFAULT_LINE_WIDTH = 5;
    private static final int DEFAULT_GRID_WIDTH = 5;

    /**
     * x轴标题
     */
    private String mXTitle;
    /**
     * x轴标题颜色
     */
    private int mXTitleColor = Color.LTGRAY;
    /**
     * x轴标题尺寸
     */
    private int mXTitleSize = DEFAULT_TITLE_SIZE;

    /**
     * y轴标题
     */
    private String mYTitle;
    /**
     * y轴标题颜色
     */
    private int mYTitleColor = Color.LTGRAY;
    /**
     * y轴标题尺寸
     */
    private int mYTitleSize = DEFAULT_TITLE_SIZE;

    /**
     * 数据线宽度
     */
    private int mLineWidth = DEFAULT_LINE_WIDTH;
    /**
     * 数据线颜色
     */
    private int mLineColor = Color.GREEN;

    /**
     * 是否显示网格线
     */
    private boolean isGridShown = true;
    /**
     * 网格线宽度
     */
    private int mGridWidth = DEFAULT_GRID_WIDTH;
    /**
     * 网格线颜色
     */
    private int mGridColor = Color.LTGRAY;

    /**
     * 外边距
     * 按照left,top,right,bottom顺序
     */
    private int[] mMargins = new int[]{10,10,10,10};

    public String getmXTitle() {
        return mXTitle;
    }

    public void setmXTitle(String mXTitle) {
        this.mXTitle = mXTitle;
    }

    public int getmXTitleColor() {
        return mXTitleColor;
    }

    public void setmXTitleColor(int mXTitleColor) {
        this.mXTitleColor = mXTitleColor;
    }

    public int getmXtitleSize() {
        return mXTitleSize;
    }

    public void setmXtitleSize(int mXtitleSize) {
        this.mXTitleSize = mXtitleSize;
    }

    public String getmYTitle() {
        return mYTitle;
    }

    public void setmYTitle(String mYTitle) {
        this.mYTitle = mYTitle;
    }

    public int getmYTitleColor() {
        return mYTitleColor;
    }

    public void setmYTitleColor(int mYTitleColor) {
        this.mYTitleColor = mYTitleColor;
    }

    public int getmYTitleSize() {
        return mYTitleSize;
    }

    public void setmYTitleSize(int mYTitleSize) {
        this.mYTitleSize = mYTitleSize;
    }

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

    public boolean isGridShown() {
        return isGridShown;
    }

    public void setGridShown(boolean gridShown) {
        isGridShown = gridShown;
    }

    public int getmGridWidth() {
        return mGridWidth;
    }

    public void setmGridWidth(int mGridWidth) {
        this.mGridWidth = mGridWidth;
    }

    public int getmGridColor() {
        return mGridColor;
    }

    public void setmGridColor(int mGridColor) {
        this.mGridColor = mGridColor;
    }

    public int[] getmMargins() {
        return mMargins;
    }

    public void setmMargins(int[] mMargins) {
        this.mMargins = mMargins;
    }
}
