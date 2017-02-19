package com.cbs.engine.renderer;

import android.content.Context;
import android.graphics.Color;

import com.cbs.engine.util.SystemUtil;

/**
 * date: 2017/2/16 0016
 * author: cbs
 */

public class BarChartRenderer extends LineChartRender {

    private static final int DEFAULT_BAR_WIDTH = 80;  //dp unit

    private static final int DEFAULT_BAR_COLOR = Color.GREEN;

    private static final int DEFAULT_VALUE_TEXT_SIZE = 10; //sp unit
    private static final int DEFAULT_VALUE_TEXT_COLOR = Color.LTGRAY;

    private static final int DEFAULT_BAR_VALUE_TOP_PADDING = 5; //dp unit
    /**
     * 柱体颜色
     */
    private int mBarColor;
    /**
     * 柱体宽度
     */
    private int mBarWidth;

    /**
     * 柱体顶部和数据文本的上间距
     */
    private int mBarValueTopPadding;

    public BarChartRenderer(Context context) {
        mBarWidth = SystemUtil.dip2px(context, DEFAULT_BAR_WIDTH);
        mBarColor = DEFAULT_BAR_COLOR;

        mBarValueTopPadding = SystemUtil.dip2px(context, DEFAULT_BAR_VALUE_TOP_PADDING);
        setmValueTextSize((int)(SystemUtil.sp2px(context, (float) DEFAULT_VALUE_TEXT_SIZE, SystemUtil.CHINESE)));
        setmValueTextColor(DEFAULT_VALUE_TEXT_COLOR);
    }

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

    public int getmBarValueTopPadding() {
        return mBarValueTopPadding;
    }

    public void setmBarValueTopPadding(int mBarValueTopPadding) {
        this.mBarValueTopPadding = mBarValueTopPadding;
    }
}
