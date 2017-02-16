package com.cbs.engine.chart;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;

import com.cbs.engine.renderer.BarChartRenderer;
import com.cbs.engine.series.LineChartSeries;

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
    public void draw(Canvas canvas, Rect area, Paint paint) {
        super.draw(canvas, area, paint);

        initSeriesRange();
        validateSeries();

        /**
         * 绘制柱体
         */
        BarChartRenderer render = (BarChartRenderer) mRenderer;
        paint.setColor(render.getmBarColor());
        paint.setStyle(Paint.Style.FILL);

        int barWidth = validateBarWidth(render.getmBarWidth());
        Rect rect = new Rect();
        rect.bottom = getOrigin().y;
        int y;
        for (int i=0; i<xValues.length; ++i) {
            y = (int) convertToYCoordinate(yValues[i], minY, maxY, getOrigin().y, getEndY().y);
            rect.left = getOrigin().x + (i + 1) * getxGap() - barWidth / 2;
            rect.right = getOrigin().x + (i + 1) * getxGap() + barWidth / 2;
            rect.top = y;
            canvas.drawRect(rect,paint);
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
