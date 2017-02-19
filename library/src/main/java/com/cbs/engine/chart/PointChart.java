package com.cbs.engine.chart;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.text.TextPaint;

import com.cbs.engine.renderer.PointChartRenderer;
import com.cbs.engine.series.LineChartSeries;

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
    public void draw(Canvas canvas, Rect area, Paint paint) {
        super.draw(canvas, area, paint);

        initSeriesRange();
        validateSeries();

        /**
         * 画数据点
         * 及文本
         */
        PointChartRenderer renderer = (PointChartRenderer) getmRenderer();
        paint.setColor(renderer.getmPointColor());
        paint.setStyle(Paint.Style.FILL);
        TextPaint textPaint = new TextPaint();
        for(int i=0; i<xValues.length; ++i) {
            float centerX = convertToXCoordinate(xValues[i], minX, maxX, getOrigin().x, getEndX().x - mRenderer.getmGridRightPadding());
            float centerY = convertToYCoordinate(yValues[i], minY, maxY, getOrigin().y, getEndTickY());
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

    }

}
