package com.cbs.engine.chart;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.os.SystemClock;
import android.text.TextPaint;

import com.cbs.engine.renderer.BarChartRenderer;
import com.cbs.engine.series.LineChartSeries;
import com.cbs.engine.view.ChartView;

/**
 * date: 2017/2/16 0016
 * author: cbs
 * 柱状图
 */

public class BarChart extends XYLineChart {

    public BarChart(LineChartSeries series, BarChartRenderer render) {
        super(series, render);
    }

    @Override
    public void draw(Canvas canvas, ChartView parent,Rect area, Paint paint) {
        super.draw(canvas,parent, area, paint);

        initSeriesRange();
        validateSeries();

        /**
         * 绘制柱体
         * 及数值
         */
        BarChartRenderer renderer = (BarChartRenderer) mRenderer;
        paint.setColor(renderer.getmBarColor());
        paint.setStyle(Paint.Style.FILL);

        /**
         * 柱体绘制的最大高度
         */
        int maxHeight = getEndTickY();
        /**
         * 动画处理
         */
        if (renderer.isAnimated()) {
            if (!isAnimatedStart) {
                mAnimatedStart = SystemClock.uptimeMillis();
                mAnimatedEnd = mAnimatedStart + renderer.getmAnimatedDuration();
                isAnimatedStart = true;
            }
            maxHeight = getAnimatedValue(renderer.getmAnimatedDuration(),
                    SystemClock.uptimeMillis() - mAnimatedStart,
                    getOrigin().y, getEndTickY());
        }

        int barWidth = validateBarWidth(renderer.getmBarWidth());
        Rect rect = new Rect();
        rect.bottom = getOrigin().y;
        int y;
        for (int i=0; i<xValues.length; ++i) {
            y = (int) convertToYCoordinate(yValues[i], minY, maxY, getOrigin().y, maxHeight);
            rect.left = getOrigin().x + (i + 1) * getxGap() - barWidth / 2;
            rect.right = getOrigin().x + (i + 1) * getxGap() + barWidth / 2;
            rect.top = y;
            canvas.drawRect(rect,paint);
            /**
             * 绘制数值文本
             */
            if (renderer.isValueTextShow()) {
                TextPaint textPaint = renderer.getmTextPaint();
                textPaint.setTextSize(renderer.getmValueTextSize());
                textPaint.setColor(renderer.getmValueTextColor());
                String value = yValues[i] + "";
                int baseX = (int) (((rect.left + rect.right) - textPaint.measureText(value, 0, value.length())) / 2);
                int baseY = (int)(rect.top - renderer.getmBarValueTopPadding() - textPaint.descent());
                canvas.drawText(value,baseX,baseY,textPaint);

            }
        }

        if (renderer.isAnimated() && SystemClock.uptimeMillis() <= mAnimatedEnd) {
            parent.invalidate();
        }
    }

    /**
     * 检查设置的柱体宽度是否超出有效范围
     * @return 返回有效范围的宽度值
     */
    private int validateBarWidth(int defaultBarWidth) {
        /**
         * 柱体宽度上限值
         */
        int maxWidth = (int) (2.0 / 3 * getxGap());
        /**
         * 柱体宽度下限值
         */
        int minWidth = (int) (1.0 / 3 * getxGap());
        return Math.min(maxWidth, Math.max(defaultBarWidth, minWidth));
    }
}
