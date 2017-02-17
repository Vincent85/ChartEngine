package com.cbs.engine.chart;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.text.TextPaint;

import com.cbs.engine.renderer.PieChartRenderer;
import com.cbs.engine.series.PieChartSeries;

/**
 * date: 2017/2/16 0016
 * author: cbs
 * 饼图
 */

public class PieChart extends AbstractChart {

    private PieChartSeries mSeries;
    private PieChartRenderer mRenderer;

    public PieChart(PieChartSeries series,PieChartRenderer renderer) {
        mSeries = series;
        mRenderer = renderer;
    }

    @Override
    public void draw(Canvas canvas, Rect area, Paint paint) {
        int left = area.left;
        int top = area.top;
        int right = area.right;
        int bottom = area.bottom;

        int width = area.width();
        int height = area.height();

        TextPaint textPaint = mRenderer.getmTextPaint();

        if (mRenderer.isApplyBgColor()) {
            drawBackgroundColor(canvas,mRenderer.getmBgColor());
        }

        /**
         * 绘制标题
         */
        textPaint.setTextSize(mRenderer.getmTitleSize());
        textPaint.setColor(mRenderer.getmTitleColor());
        int titleLeft = (int) ((width - textPaint.measureText(mRenderer.getmTitle())) / 2);
        int titleBottom = (int) (top - textPaint.ascent());
        drawTitle(canvas, mRenderer.getmTitle(), titleLeft, titleBottom, textPaint);

        /**
         * 绘制饼图
         */
        float centerX = left + width / 2;
        float centerY = titleBottom + textPaint.descent() + (bottom - titleBottom - textPaint.descent() - mRenderer.getmLegendHeight()) / 2;
        int validHeight = (int) (bottom - titleBottom - textPaint.descent() - mRenderer.getmLegendHeight());
        int radius = getValidRadius(width, validHeight, mRenderer.getmRadius());
        float leftEdge = centerX - radius;
        float rightEdge = centerX + radius;
        float topEdge = centerY - radius;
        float bottomEdge = centerY + radius;

        paint.setStyle(Paint.Style.FILL);
        int[] values = mSeries.getmPercents();
        float startAngle = mRenderer.getmStartAngle();
        for(int i=0; i<values.length; ++i) {
            paint.setColor(getArcFillColor(mRenderer.getmFillColors()));
            float sweepAngle = convertToAngle(values[i]);
            canvas.drawArc(new RectF(leftEdge, topEdge, rightEdge, bottomEdge),startAngle, sweepAngle, true, paint);
            startAngle += sweepAngle;
        }
    }

    /**
     * 获取有效范围的半径值
     * @param width
     * @param heigth
     * @param radius
     * @return
     */
    private int getValidRadius(int width,int heigth,int radius) {
        int maxRadius = (int) (Math.min(width,heigth) / 2.5);
        int minRadius = Math.min(width,heigth) / 4;

        return Math.min(maxRadius, Math.max(radius, minRadius));
    }

    private float convertToAngle(int value) {
        return 360 * value / 100f;
    }

    /**
     * 循环取饼块颜色值
     */
    int index = 0;
    private int getArcFillColor(int[] colors) {
        if (index >= colors.length) {
            index = 0;
        }
        return colors[index++];
    }
}
