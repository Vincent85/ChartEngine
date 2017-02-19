package com.cbs.engine.chart;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.text.TextPaint;

import com.cbs.engine.renderer.PolyLineChartRenderer;
import com.cbs.engine.series.LineChartSeries;

/**
 * date: 2017/2/11 0011
 * author: cbs
 * 折线图图表
 */

public class PolyLineChart extends XYLineChart{

    public PolyLineChart(LineChartSeries series, PolyLineChartRenderer render) {
        super(series, render);
    }

    @Override
    public void draw(Canvas canvas, Rect area, Paint paint) {
        super.draw(canvas, area, paint);

        initSeriesRange();
        validateSeries();

        PolyLineChartRenderer renderer = (PolyLineChartRenderer) mRenderer;

        /**
         * 绘制折线段
         * 以及数据点
         */
        int x;
        int y;
        Path path = new Path();
        x = (int) convertToXCoordinate(xValues[0], minX, maxX, getOrigin().x, getEndX().x - mRenderer.getmGridRightPadding());
        y = (int) convertToYCoordinate(yValues[0], minY, maxY, getOrigin().y, getEndTickY());
        path.moveTo(x,y);
        /**
         * 绘制第一个数值点
         */
        if (renderer.isValuePointShow()) {
            drawValuePoint(canvas,x,y,renderer,paint);
        }
        /**
         * 绘制第一个数值文本
         */
        if (renderer.isValueTextShow()) {
            drawValueText(canvas,x,y,yValues[0] + "",renderer);
        }
        for(int i=1; i<xValues.length; ++i) {
            x = (int) convertToXCoordinate(xValues[i], minX, maxX, getOrigin().x, getEndX().x - mRenderer.getmGridRightPadding());
            y = (int) convertToYCoordinate(yValues[i], minY, maxY, getOrigin().y, getEndTickY());
            path.lineTo(x,y);
        }

        paint.setStrokeWidth(renderer.getmLineWidth());
        paint.setColor(renderer.getmLineColor());
        paint.setStyle(Paint.Style.STROKE);
        canvas.drawPath(path,paint);

        for(int i=1; i<xValues.length; ++i) {
            x = (int) convertToXCoordinate(xValues[i], minX, maxX, getOrigin().x, getEndX().x - mRenderer.getmGridRightPadding());
            y = (int) convertToYCoordinate(yValues[i], minY, maxY, getOrigin().y, getEndTickY());
            if (renderer.isValuePointShow()) {
                drawValuePoint(canvas,x,y,renderer,paint);
            }
            /**
             * 绘制数值文本
             */
            if (renderer.isValueTextShow()) {
                drawValueText(canvas,x,y,yValues[i] + "",renderer);
            }
        }
    }

    private void drawValuePoint(Canvas canvas, int centerX, int centerY, PolyLineChartRenderer renderer, Paint paint) {
        if (renderer.getmPointType() == PolyLineChartRenderer.ValuePointType.SQUARE) {
            paint.setColor(renderer.getmValuePointColor());
            paint.setStyle(Paint.Style.FILL);
            int dimension = renderer.getmValuePointDimension() / 2;
            int left = centerX - dimension;
            int top = centerY - dimension;
            int right = centerX + dimension;
            int bottom = centerY + dimension;

            canvas.drawRect(left,top, right,bottom,paint);
        }
        //todo 支持其他两种类型
    }

    private void drawValueText(Canvas canvas, int x, int y, String text,PolyLineChartRenderer renderer) {
        TextPaint textPaint = renderer.getmTextPaint();
        textPaint.setColor(renderer.getmValueTextColor());
        textPaint.setTextSize(renderer.getmValueTextSize());

        int baseX = (int) (x - textPaint.measureText(text,0,text.length()) / 2);
        int baseY = (int) (y - renderer.getmValuePointDimension() / 2 - renderer.getmValueTextPointPadding() - textPaint.descent());
        canvas.drawText(text, baseX, baseY, textPaint);
    }


}
