package com.cbs.engine.chart;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;

import com.cbs.engine.renderer.LineChartRender;
import com.cbs.engine.series.LineChartSeries;

/**
 * date: 2017/2/11 0011
 * author: cbs
 * 折线图图表
 */

public class PolyLineChart extends XYLineChart{

    public PolyLineChart(LineChartSeries series, LineChartRender render) {
        super(series, render);
    }

    @Override
    public void draw(Canvas canvas, Rect area, Paint paint) {
        int[] margins = mRenderer.getmMargins();
        int left = margins[0];
        int top = margins[1];
        int right = margins[2];
        int bottom = margins[3];

        int width = area.width();
        int height = area.height();

        if (mRenderer.isApplyBgColor()) {
            drawBackgroundColor(canvas,mRenderer.getmBgColor());
        }

        /**
         * 绘制标题
         */
        int titleLeft = (int) ((width - paint.measureText(mRenderer.getmTitle())) / 2);
        paint.setTextSize(mRenderer.getmTitleSize());
        paint.setColor(mRenderer.getmTitleColor());
        drawTitle(canvas, mRenderer.getmTitle(), Math.max(titleLeft, left), 30, paint);

        /**
         * todo 绘制x轴和y轴标题
         */

        /**
         * 绘制x轴和y轴
         */


    }


}
