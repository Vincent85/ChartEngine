package com.cbs.engine.chart;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;

import com.cbs.engine.renderer.PointChartRenderer;
import com.cbs.engine.series.LineChartSeries;

/**
 * date: 2017/2/12 0012
 * author: cbs
 * 仅显示数据点图表
 */

public class PointChart extends XYLineChart {

    public PointChart(LineChartSeries series, PointChartRenderer render) {
        super(series, render);
    }

    @Override
    public void draw(Canvas canvas, Rect area, Paint paint) {
        super.draw(canvas, area, paint);
        //画数据点
        int[] xValues = mSeries.getmXValues();
        int[] yValues = mSeries.getmYValues();

        int maxX = mSeries.getMaxX();
        int minX = mSeries.getMinX();
        int maxY = mSeries.getMaxY();
        int minY = mSeries.getMinY();

        if (xValues.length != yValues.length) {
            throw new RuntimeException("series x values length must be equal with y values length");
        }

        PointChartRenderer renderer = (PointChartRenderer) getmRenderer();
        paint.setColor(renderer.getmPointColor());
        paint.setStyle(Paint.Style.FILL);
        for(int i=1; i<xValues.length; ++i) {
            canvas.drawCircle(convertToCoordinate(xValues[i], minX, maxX, getOrigin().x, getEndX().x),
                    convertToCoordinate(yValues[i], minY, maxY, getOrigin().y, getEndY().y), renderer.getmRadius(), paint);
        }

    }

}
