package com.cbs.engine.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;

import com.cbs.engine.chart.AbstractChart;

/**
 * date: 2017/2/11 0011
 * author: cbs
 */

public class ChartView extends View {

    private AbstractChart mChart;
    private Paint mPaint;

    public ChartView(Context context,AbstractChart chart) {
        this(context,null,chart);
    }

    public ChartView(Context context, AttributeSet attrs, AbstractChart chart) {
        super(context, attrs);
        mChart = chart;

        mPaint = new Paint();
        mPaint.setAntiAlias(true);

    }

    @Override
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Rect area = new Rect();
        area.left = 10;
        area.top = 10;
        area.right = area.left + getWidth();
        area.bottom = area.top + getHeight();
        mChart.draw(canvas,area,mPaint);
    }
}
