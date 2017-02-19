package com.cbs.engine.chart;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.os.SystemClock;
import android.text.TextPaint;

import com.cbs.engine.renderer.PointChartRenderer;
import com.cbs.engine.series.LineChartSeries;
import com.cbs.engine.view.ChartView;

/**
 * date: 2017/2/12 0012
 * author: cbs
 * 仅显示数据点图表
 */

public class PointChart extends XYLineChart {

    public static final String TAG = "PointChart";

    public PointChart(LineChartSeries series, PointChartRenderer render) {
        super(series, render);
    }

    @Override
    public void draw(Canvas canvas, ChartView parent, Rect area, Paint paint) {
        super.draw(canvas,parent, area, paint);

        initSeriesRange();
        validateSeries();

        /**
         * 画数据点
         * 及文本
         */
        PointChartRenderer renderer = (PointChartRenderer) getmRenderer();

        /**
         * 数据点绘制的最高坐标值
         */
        int maxHeightValue = getEndTickY();

        if (renderer.isAnimated()) {
            if (!isAnimatedStart) {
                mAnimatedStart = SystemClock.uptimeMillis();
                mAnimatedEnd = mAnimatedStart + renderer.getmAnimatedDuration();
                isAnimatedStart = true;
            }
            maxHeightValue = getAnimatedValue(renderer.getmAnimatedDuration(),
                    SystemClock.uptimeMillis() - mAnimatedStart,
                    getOrigin().y, getEndTickY());
        }

        paint.setColor(renderer.getmPointColor());
        paint.setStyle(Paint.Style.FILL);
        TextPaint textPaint = new TextPaint();
        for(int i=0; i<xValues.length; ++i) {
            float centerX = convertToXCoordinate(xValues[i], minX, maxX, getOrigin().x, getEndX().x - mRenderer.getmGridRightPadding());
            float centerY = convertToYCoordinate(yValues[i], minY, maxY, getOrigin().y, maxHeightValue);
            canvas.drawCircle(centerX,centerY, renderer.getmRadius(), paint);
            /**
             * 绘制数值
             */
            if (renderer.isValueTextShow()) {
                textPaint.setTextSize(renderer.getmValueTextSize());
                textPaint.setColor(renderer.getmValueTextColor());
                String value = yValues[i] + "";
                int baseX = (int)(centerX - textPaint.measureText(value,0,value.length()) / 2);
                int baseY = (int)(centerY - renderer.getmRadius() - renderer.getmPointTextPadding() - textPaint.descent());
                canvas.drawText(value,baseX,baseY,textPaint);
            }
        }

        if (renderer.isAnimated() && SystemClock.uptimeMillis() <= mAnimatedEnd) {
            parent.invalidate();
        }
    }

}
