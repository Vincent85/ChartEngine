package com.cbs.engine.chart;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;

import com.cbs.engine.view.ChartView;

/**
 * date: 2017/2/11 0011
 * author: cbs
 */

public abstract class AbstractChart {

    //动画开始时间
    protected long mAnimatedStart;
    //动画结束时间
    protected long mAnimatedEnd;
    //动画是否已经开始，初始值为false
    protected boolean isAnimatedStart;

    /**
     * 绘制图表，由具体子类实现
     * @param canvas          容器视图画布
     * @param containerView   容器试图
     * @param area            绘制表格区域
     * @param paint           画笔
     */
    public abstract void draw(Canvas canvas, ChartView containerView, Rect area, Paint paint);

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


    /**
     * 计算当前动画过程中间值
     * @param animatedDuration   动画总时长
     * @param elapsedTime        动画当前已进行完的时间
     * @param minValue           变化属性的最小值
     * @param maxValue           变化属性的最大值
     * @return                   变化属性的当前值
     */
    protected int getAnimatedValue(long animatedDuration, long elapsedTime, int minValue, int maxValue) {
        if (elapsedTime > animatedDuration) {
            return maxValue;
        }

        return (int) (minValue + (maxValue - minValue) * ((float) (elapsedTime) / animatedDuration));
    }
}
