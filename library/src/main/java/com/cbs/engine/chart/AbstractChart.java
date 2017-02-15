package com.cbs.engine.chart;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;

/**
 * date: 2017/2/11 0011
 * author: cbs
 */

public abstract class AbstractChart {

    /**
     * 绘制图表，由具体子类实现
     * @param canvas
     * @param area
     * @param paint
     */
    public abstract void draw(Canvas canvas, Rect area, Paint paint);

    /**
     * 绘制背景颜色
     * @param canvas
     * @param backgroundColor
     */
    protected void drawBackgroundColor(Canvas canvas, int backgroundColor) {
        canvas.drawColor(backgroundColor);
    }

    /**
     * 绘制图表标题
     * @param canvas
     * @param title
     * @param left
     * @param top
     * @param paint
     */
    protected void drawTitle(Canvas canvas, String title,int left,int top, Paint paint) {
        canvas.drawText(title,left,top,paint);
    }

}
