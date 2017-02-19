package com.cbs.engine.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;

import com.cbs.engine.chart.AbstractChart;
import com.cbs.engine.util.SystemUtil;

/**
 * date: 2017/2/11 0011
 * author: cbs
 */

public class ChartView extends View {

    private static final int DEFAULT_MARGIN_DIP = 10;
    private int mDefaultMargin = 0;

    private AbstractChart mChart;
    private Paint mPaint;

    public ChartView(Context context,AbstractChart chart) {
        this(context,null,chart);
    }

    public ChartView(Context context, AttributeSet attrs, AbstractChart chart) {
        super(context, attrs);
        mChart = chart;

        init();
    }

    private void init() {
        mPaint = new Paint();
        mPaint.setAntiAlias(true);

        mDefaultMargin = SystemUtil.dip2px(getContext(), DEFAULT_MARGIN_DIP);
    }

    @Override
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Rect area = new Rect();
        area.left = mDefaultMargin;
        area.top = mDefaultMargin;
        area.right = getWidth() - mDefaultMargin;
        area.bottom = getHeight() - mDefaultMargin;
        mChart.draw(canvas,this,area,mPaint);

    }
}
