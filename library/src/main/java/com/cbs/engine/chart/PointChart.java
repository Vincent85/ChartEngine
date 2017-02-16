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

    public static final String TAG = "PointChart";

    public PointChart(LineChartSeries series, PointChartRenderer render) {
        super(series, render);
    }

    @Override
    public void draw(Canvas canvas, Rect area, Paint paint) {
        super.draw(canvas, area, paint);

        initSeriesRange();
        validateSeries();

        //画数据点
        PointChartRenderer renderer = (PointChartRenderer) getmRenderer();
        paint.setColor(renderer.getmPointColor());
        paint.setStyle(Paint.Style.FILL);
        for(int i=0; i<xValues.length; ++i) {
            canvas.drawCircle(convertToXCoordinate(xValues[i], minX, maxX, getOrigin().x, getEndX().x - mRenderer.getmGridRightPadding()),
                    convertToYCoordinate(yValues[i], minY, maxY, getOrigin().y, getEndY().y), renderer.getmRadius(), paint);
        }

    }

}
