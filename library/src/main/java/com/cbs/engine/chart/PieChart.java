package com.cbs.engine.chart;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.RectF;
import android.text.TextPaint;

import com.cbs.engine.renderer.PieChartRenderer;
import com.cbs.engine.series.PieChartSeries;
import com.cbs.engine.view.ChartView;

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
    public void draw(Canvas canvas, ChartView parent,Rect area, Paint paint) {
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
        textPaint.setTextSize(mRenderer.getmTitleTextSize());
        textPaint.setColor(mRenderer.getmTitleColor());
        int titleLeft = (int) ((width - textPaint.measureText(mRenderer.getmTitle())) / 2);
        int titleBottom = (int) (top - textPaint.ascent());
        drawTitle(canvas, mRenderer.getmTitle(), titleLeft, titleBottom, textPaint);

        /**
         * 绘制饼图,标签
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
        RectF rectF = new RectF(leftEdge,topEdge,rightEdge,bottomEdge);
        /**
         * 标签折线坐标点
         */
        Point start = new Point();
        Point middle = new Point();
        Point end = new Point();
        for(int i=0; i<values.length; ++i) {
            paint.setColor(getArcFillColor(mRenderer.getmFillColors()));
            float sweepAngle = convertToAngle(values[i]);
            canvas.drawArc(rectF,startAngle, sweepAngle, true, paint);
            /**
             * 绘制标签
             */
            double centerAngle = degree2radian(startAngle + sweepAngle / 2);

            start.x = (int) (centerX + mRenderer.getmLineRadiusPadding() * Math.cos(centerAngle));
            start.y = (int) (centerY + mRenderer.getmLineRadiusPadding() * Math.sin(centerAngle));
            middle.x = (int) (start.x + mRenderer.getmLabelLineLength1() * Math.cos(centerAngle));
            middle.y = (int) (start.y + mRenderer.getmLabelLineLength1() * Math.sin(centerAngle));

            //标签文本开始基线坐标
            int baseX;
            int baseY;
            String label = mSeries.getmLabels()[i];
            textPaint.setTextSize(mRenderer.getmLabelTextSize());
            textPaint.setColor(mRenderer.getmLabelTextColor());
            int labelLength = (int)textPaint.measureText(label, 0, label.length());

            if (centerAngle >= (Math.PI / 2) && centerAngle <= (Math.PI * 3 / 2)) {
                baseX = Math.max(left,middle.x - mRenderer.getmLabelLineRightPadding() - labelLength);
                end.x = baseX;
                end.y = middle.y;
            }else {
                baseX = middle.x + mRenderer.getmLabelLineRightPadding();
                end.x = baseX + labelLength;
                end.y = middle.y;
            }
            baseY = (int)(middle.y - mRenderer.getmLabelLineBottomPadding() - textPaint.descent());

            paint.setStrokeWidth(mRenderer.getmLabelLineWidth());
            paint.setColor(mRenderer.getmLabelLineColor());
            canvas.drawLine(start.x, start.y, middle.x, middle.y, paint);
            canvas.drawLine(middle.x, middle.y, end.x, end.y, paint);

            canvas.drawText(label,baseX,baseY,textPaint);

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
        int maxRadius = Math.min(width,heigth) / 3;
        int minRadius = Math.min(width,heigth) / 6;

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

    /**
     * 角度转为弧度
     * @param degree
     * @return
     */
    private double degree2radian(float degree) {
        return Math.PI * 2 * (degree / 360);
    }
}
