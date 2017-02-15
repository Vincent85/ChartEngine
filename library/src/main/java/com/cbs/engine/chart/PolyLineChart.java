package com.cbs.engine.chart;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;

import com.cbs.engine.renderer.PolyLineChartRender;
import com.cbs.engine.series.LineChartSeries;

/**
 * date: 2017/2/11 0011
 * author: cbs
 * 折线图图表
 */

public class PolyLineChart extends XYLineChart{

    public PolyLineChart(LineChartSeries series, PolyLineChartRender render) {
        super(series, render);
    }

    @Override
    public void draw(Canvas canvas, Rect area, Paint paint) {
        super.draw(canvas, area, paint);
        //todo 画数据线
        int[] xValues = mSeries.getmXValues();
        int[] yValues = mSeries.getmYValues();

        int maxX = mSeries.getMaxX();
        int minX = mSeries.getMinX();
        int maxY = mSeries.getMaxY();
        int minY = mSeries.getMinY();

        if (xValues.length != yValues.length) {
            throw new RuntimeException("series x values length must be equal with y values length");
        }

        Path path = new Path();
        path.moveTo(convertToXCoordinate(xValues[0], minX, maxX, getOrigin().x, getEndX().x - mRenderer.getmGridRightPadding()),
                convertToYCoordinate(yValues[0], minY, maxY, getOrigin().y, getEndY().y));
        for(int i=1; i<xValues.length; ++i) {
            path.lineTo(convertToXCoordinate(xValues[i], minX, maxX, getOrigin().x, getEndX().x - mRenderer.getmGridRightPadding()),
                    convertToYCoordinate(yValues[i], minY, maxY, getOrigin().y, getEndY().y));
        }
        PolyLineChartRender render = (PolyLineChartRender) mRenderer;
        paint.setStrokeWidth(render.getmLineWidth());
        paint.setColor(render.getmLineColor());
        paint.setStyle(Paint.Style.STROKE);
        canvas.drawPath(path,paint);
    }


}
