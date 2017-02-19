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

        initSeriesRange();
        validateSeries();

        Path path = new Path();
        path.moveTo(convertToXCoordinate(xValues[0], minX, maxX, getOrigin().x, getEndX().x - mRenderer.getmGridRightPadding()),
                convertToYCoordinate(yValues[0], minY, maxY, getOrigin().y, getEndTickY()));
        for(int i=1; i<xValues.length; ++i) {
            path.lineTo(convertToXCoordinate(xValues[i], minX, maxX, getOrigin().x, getEndX().x - mRenderer.getmGridRightPadding()),
                    convertToYCoordinate(yValues[i], minY, maxY, getOrigin().y, getEndTickY()));
        }
        PolyLineChartRender render = (PolyLineChartRender) mRenderer;
        paint.setStrokeWidth(render.getmLineWidth());
        paint.setColor(render.getmLineColor());
        paint.setStyle(Paint.Style.STROKE);
        canvas.drawPath(path,paint);
    }


}
