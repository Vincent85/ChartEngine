package com.cbs.engine.renderer;

import android.content.Context;
import android.graphics.Color;

import com.cbs.engine.util.SystemUtil;

/**
 * date: 2017/2/12 0012
 * author: cbs
 */

public class PolyLineChartRenderer extends LineChartRender {

    /**
     * 数据点类型，暂时只支持square
     * todo 实现其他两种
     */
    public enum ValuePointType {
        CIRCLE,SQUARE,TRIANGLE
    }

    private static final int DEFAULT_LINE_WIDTH = 2;  //dp unit
    private static final int DEFAULT_VALUE_POINT_DIMEN = 10; //dp unit
    private static final int DEFAULT_VALUE_POINT_COLOR = Color.RED;
    private static final int DEFAULT_VALUE_TEXT_SIZE = 10; //sp unit
    private static final int DEFAULT_VALUE_TEXT_COLOR = Color.LTGRAY;
    private static final int DEFAULT_VALUE_TEXT_POINT_PADDING = 5; //dp unit
    /**
     * 数据线宽度
     */
    private int mLineWidth;
    /**
     * 数据线颜色
     */
    private int mLineColor = Color.GREEN;

    /**
     * 是否显示数据点
     */
    private boolean isValuePointShow;
    /**
     * 数据点类型，默认为方框
     */
    private ValuePointType mPointType = ValuePointType.SQUARE;
    /**
     * 数据点尺寸，
     * 圆对应直径，三角形和正方形对应外边框边长
     */
    private int mValuePointDimension ;

    private int mValuePointColor;

    private boolean isValueTextShow;

    private int mValueTextSize;

    private int mValueTextColor;

    private int mValueTextPointPadding;

    public PolyLineChartRenderer(Context context) {
        super(context);
        mLineWidth = SystemUtil.dip2px(context, DEFAULT_LINE_WIDTH);
        mValuePointDimension = SystemUtil.dip2px(context, DEFAULT_VALUE_POINT_DIMEN);

        mValuePointColor = DEFAULT_VALUE_POINT_COLOR;
        isValuePointShow = true;

        isValueTextShow = true;
        mValueTextSize = (int) SystemUtil.sp2px(context, (float) DEFAULT_VALUE_TEXT_SIZE, SystemUtil.CHINESE);
        mValueTextColor = DEFAULT_VALUE_TEXT_COLOR;

        mValueTextPointPadding = SystemUtil.dip2px(context, DEFAULT_VALUE_TEXT_POINT_PADDING);
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

    public int getmValuePointDimension() {
        return mValuePointDimension;
    }

    public void setmValuePointDimension(int mValuePointDimension) {
        this.mValuePointDimension = mValuePointDimension;
    }

    public ValuePointType getmPointType() {
        return mPointType;
    }

    public void setmPointType(ValuePointType mPointType) {
        this.mPointType = mPointType;
    }

    public boolean isValuePointShow() {
        return isValuePointShow;
    }

    public void setValuePointShow(boolean valuePointShow) {
        isValuePointShow = valuePointShow;
    }

    public int getmValuePointColor() {
        return mValuePointColor;
    }

    public void setmValuePointColor(int mValuePointColor) {
        this.mValuePointColor = mValuePointColor;
    }

    @Override
    public boolean isValueTextShow() {
        return isValueTextShow;
    }

    @Override
    public void setValueTextShow(boolean valueTextShow) {
        isValueTextShow = valueTextShow;
    }

    @Override
    public int getmValueTextSize() {
        return mValueTextSize;
    }

    @Override
    public void setmValueTextSize(int mValueTextSize) {
        this.mValueTextSize = mValueTextSize;
    }

    @Override
    public int getmValueTextColor() {
        return mValueTextColor;
    }

    @Override
    public void setmValueTextColor(int mValueTextColor) {
        this.mValueTextColor = mValueTextColor;
    }

    public int getmValueTextPointPadding() {
        return mValueTextPointPadding;
    }

    public void setmValueTextPointPadding(int mValueTextPointPadding) {
        this.mValueTextPointPadding = mValueTextPointPadding;
    }
}
