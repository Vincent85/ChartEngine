package com.cbs.engine.renderer;

import android.content.Context;
import android.graphics.Color;

import com.cbs.engine.util.SystemUtil;

/**
 * date: 2017/2/16 0016
 * author: cbs
 */

public class PieChartRenderer extends DefaultRenderer {

    private static final int DEFAULT_START_ANGLE = 0;
    private static final int DEFAULT_RADIUS = 120;
    private static final int DEFAULT_LINE_RADIUS_PADDING = 50;
    private static final int DEFAULT_LABEL_LINE_LENGTH_1 = 80;
    private static final int DEFAULT_LABEL_LINE_LENGHT_2 = 50;

    private static final int DEFAULT_LABEL_LINE_WIDTH = 3;
    private static final int DEFAULT_LABEL_LINE_COLOR = Color.LTGRAY;

    private static final int DEFAULT_LABEL_TEXT_SIZE = 15;  //sp unit
    private static final int DEFAULT_LABEL_TEXT_COLOR = Color.LTGRAY;

    private static final int DEFAULT_LABEL_LINE_BOTTOM_PADDING = 10; //dp unit
    private static final int DEFAULT_LABEL_LINE_RIGHT_PADDING = 10;  //dp unit

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
    private int mRadius;

    /**
     * 是否要突出显示某个数据
     * 当前只支持突出显示一个数据饼块
     */
    private boolean isHighlightDisplay = false;

    /**
     * 标签辅助线的两个长度值（折线的两部分）
     */
    private int mLabelLineLength1;
    private int mLabelLineLength2;
    /**
     * 折线和圆心距离
     */
    private int mLineRadiusPadding;
    private int mLabelLineColor;
    private int mLabelLineWidth;

    private int mLabelTextColor;
    private int mLabelTextSize;

    /**
     * 标签文本和折线的下间距
     */
    private int mLabelLineBottomPadding;

    /**
     * 标签文本和折线的右间距
     */
    private int mLabelLineRightPadding;

    public PieChartRenderer(Context context) {
        mRadius = SystemUtil.dip2px(context, DEFAULT_RADIUS);
        mLabelLineLength1 = SystemUtil.dip2px(context,DEFAULT_LABEL_LINE_LENGTH_1);
        mLabelLineLength2 = SystemUtil.dip2px(context, DEFAULT_LABEL_LINE_LENGHT_2);
        mLineRadiusPadding = SystemUtil.dip2px(context, DEFAULT_LINE_RADIUS_PADDING);
        mLabelLineWidth = SystemUtil.dip2px(context, DEFAULT_LABEL_LINE_WIDTH);
        mLabelLineColor = DEFAULT_LABEL_LINE_COLOR;
        mLabelTextColor = DEFAULT_LABEL_TEXT_COLOR;
        mLabelTextSize = (int)SystemUtil.sp2px(context, (float)DEFAULT_LABEL_TEXT_SIZE, SystemUtil.CHINESE);

        mLabelLineBottomPadding = SystemUtil.dip2px(context, DEFAULT_LABEL_LINE_BOTTOM_PADDING);
        mLabelLineRightPadding = SystemUtil.dip2px(context, DEFAULT_LABEL_LINE_RIGHT_PADDING);
    }

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

    public int getmLabelLineLength1() {
        return mLabelLineLength1;
    }

    public void setmLabelLineLength1(int mLabelLineLength1) {
        this.mLabelLineLength1 = mLabelLineLength1;
    }

    public int getmLabelLineLength2() {
        return mLabelLineLength2;
    }

    public void setmLabelLineLength2(int mLabelLineLength2) {
        this.mLabelLineLength2 = mLabelLineLength2;
    }

    public int getmLineRadiusPadding() {
        return mLineRadiusPadding;
    }

    public void setmLineRadiusPadding(int mLineRadiusPadding) {
        this.mLineRadiusPadding = mLineRadiusPadding;
    }

    public int getmLabelLineColor() {
        return mLabelLineColor;
    }

    public void setmLabelLineColor(int mLabelLineColor) {
        this.mLabelLineColor = mLabelLineColor;
    }

    public int getmLabelLineWidth() {
        return mLabelLineWidth;
    }

    public void setmLabelLineWidth(int mLabelLineWidth) {
        this.mLabelLineWidth = mLabelLineWidth;
    }

    public int getmLabelTextColor() {
        return mLabelTextColor;
    }

    public void setmLabelTextColor(int mLabelTextColor) {
        this.mLabelTextColor = mLabelTextColor;
    }

    public int getmLabelTextSize() {
        return mLabelTextSize;
    }

    public void setmLabelTextSize(int mLabelTextSize) {
        this.mLabelTextSize = mLabelTextSize;
    }

    public int getmLabelLineBottomPadding() {
        return mLabelLineBottomPadding;
    }

    public void setmLabelLineBottomPadding(int mLabelLineBottomPadding) {
        this.mLabelLineBottomPadding = mLabelLineBottomPadding;
    }

    public int getmLabelLineRightPadding() {
        return mLabelLineRightPadding;
    }

    public void setmLabelLineRightPadding(int mLabelLineRightPadding) {
        this.mLabelLineRightPadding = mLabelLineRightPadding;
    }
}
