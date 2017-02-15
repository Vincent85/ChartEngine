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
    private static final int DEFAULT_TICK_LENGTH = 15;
    private static final int DEFAULT_TICK_WIDTH = 5;
    private static final int DEFAULT_YTITLE_AXIS_PADDING = 50;
    private static final int DEFAULT_XTITLE_TICK_PADDING = 15;
    private static final int DEFAULT_XTITLE_LABEL_PADDING = 60;
    private static final int DEFAULT_TITLE_YAXIS_PADDING = 25;
    private static final int DEFAULT_X_FIRST_TICK_PADDING = 0;
    private static final int DEFAULT_Y_LAST_TICK_PADDING = 50;
    private static final int DEFAULT_RIGHT_GRID_PADDING = 60;

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

//    /**
//     * 数据线宽度
//     */
//    private int mLineWidth = DEFAULT_LINE_WIDTH;
//    /**
//     * 数据线颜色
//     */
//    private int mLineColor = Color.GREEN;

    private int mAxisWidth = DEFAULT_LINE_WIDTH;
    private int mAxisColor = Color.LTGRAY;
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
    private int mGridColor = Color.DKGRAY;

    /**
     * 外边距
     * 按照left,top,right,bottom顺序
     */
    private int[] mMargins = new int[]{10,10,10,10};

    private int mYTitleAxisPadding = DEFAULT_YTITLE_AXIS_PADDING;
    /**
     * x轴和y轴是否显示"钩子"
     */
    private boolean showTick = true;
    /**
     * 钩子长度
     */
    private int mTickLength = DEFAULT_TICK_LENGTH;
    /**
     * 钩子宽度
     */
    private int mTickWidth = DEFAULT_TICK_WIDTH;

    private int mTickColor = Color.LTGRAY;

    private int mXLabelTickPadding = DEFAULT_XTITLE_TICK_PADDING;

    private int mXTitleLabelPadding = DEFAULT_XTITLE_LABEL_PADDING;

    private int mTitleYAxisPadding = DEFAULT_TITLE_YAXIS_PADDING;

    private int mXFirstTickPadding = DEFAULT_X_FIRST_TICK_PADDING;

    /**
     * 最右端网格线内间距
     */
    private int mGridRightPadding = DEFAULT_RIGHT_GRID_PADDING;

    /**
     * y轴最上面的tick和y轴顶部间距
     */
    private int mYLastTickPadding = DEFAULT_Y_LAST_TICK_PADDING;

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

//    public int getmLineWidth() {
//        return mLineWidth;
//    }
//
//    public void setmLineWidth(int mLineWidth) {
//        this.mLineWidth = mLineWidth;
//    }
//
//    public int getmLineColor() {
//        return mLineColor;
//    }
//
//    public void setmLineColor(int mLineColor) {
//        this.mLineColor = mLineColor;
//    }

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

    public boolean isShowTick() {
        return showTick;
    }

    public void setShowTick(boolean showTick) {
        this.showTick = showTick;
    }

    public int getmTickLength() {
        return mTickLength;
    }

    public void setmTickLength(int mTickLength) {
        this.mTickLength = mTickLength;
    }

    public int getmTickWidth() {
        return mTickWidth;
    }

    public void setmTickWidth(int mTickWidth) {
        this.mTickWidth = mTickWidth;
    }

    public int getmTickColor() {
        return mTickColor;
    }

    public void setmTickColor(int mTickColor) {
        this.mTickColor = mTickColor;
    }

    public int getmYTitleAxisPadding() {
        return mYTitleAxisPadding;
    }

    public void setmYTitleAxisPadding(int mYTitleAxisPadding) {
        this.mYTitleAxisPadding = mYTitleAxisPadding;
    }

    public int getmXLabelTickPadding() {
        return mXLabelTickPadding;
    }

    public void setmXLabelTickPadding(int mXLabelTickPadding) {
        this.mXLabelTickPadding = mXLabelTickPadding;
    }

    public int getmXTitleLabelPadding() {
        return mXTitleLabelPadding;
    }

    public void setmXTitleLabelPadding(int mXTitleLabelPadding) {
        this.mXTitleLabelPadding = mXTitleLabelPadding;
    }

    public int getmTitleYAxisPadding() {
        return mTitleYAxisPadding;
    }

    public void setmTitleYAxisPadding(int mTitleYAxisPadding) {
        this.mTitleYAxisPadding = mTitleYAxisPadding;
    }

    public int getmXFirstTickPadding() {
        return mXFirstTickPadding;
    }

    public void setmXFirstTickPadding(int mXFirstTickPadding) {
        this.mXFirstTickPadding = mXFirstTickPadding;
    }

    public int getmYLastTickPadding() {
        return mYLastTickPadding;
    }

    public void setmYLastTickPadding(int mYLastTickPadding) {
        this.mYLastTickPadding = mYLastTickPadding;
    }

    public int getmAxisWidth() {
        return mAxisWidth;
    }

    public void setmAxisWidth(int mAxisWidth) {
        this.mAxisWidth = mAxisWidth;
    }

    public int getmAxisColor() {
        return mAxisColor;
    }

    public void setmAxisColor(int mAxisColor) {
        this.mAxisColor = mAxisColor;
    }

    public int getmGridRightPadding() {
        return mGridRightPadding;
    }

    public void setmGridRightPadding(int mGridRightPadding) {
        this.mGridRightPadding = mGridRightPadding;
    }
}
