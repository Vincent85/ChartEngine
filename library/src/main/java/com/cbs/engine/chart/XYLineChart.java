package com.cbs.engine.chart;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Point;

import com.cbs.engine.renderer.LineChartRender;
import com.cbs.engine.series.LineChartSeries;

/**
 * date: 2017/2/11 0011
 * author: cbs
 */

public abstract class XYLineChart extends AbstractChart {

    protected LineChartSeries mSeries;
    protected LineChartRender mRenderer;

    public XYLineChart(LineChartSeries series, LineChartRender render) {
        checkParameter(series,render);
        setmSeries(series);
        setmRenderer(render);
    }

    private void checkParameter(LineChartSeries series,LineChartRender render) {
        if (null == series || null == render) {
            throw new RuntimeException("series and render mustn't be null");
        }
    }

    public LineChartSeries getmSeries() {
        return mSeries;
    }

    public void setmSeries(LineChartSeries mSeries) {
        this.mSeries = mSeries;
    }

    public LineChartRender getmRenderer() {
        return mRenderer;
    }

    public void setmRenderer(LineChartRender mRenderer) {
        this.mRenderer = mRenderer;
    }

    /**
     * 绘制x轴
     * @param canvas 画布
     * @param start  开始坐标
     * @param end    终点坐标
     * @param paint  画笔
     */
    protected void drawXAxis(Canvas canvas, Point start, Point end, Paint paint) {
        canvas.drawLine(start.x,start.y,end.x,end.y,paint);
    }

    /**
     * 绘制y轴
     * @param canvas
     * @param start
     * @param end
     * @param paint
     */
    protected void drawYAxis(Canvas canvas, Point start, Point end, Paint paint) {
        canvas.drawLine(start.x,start.y,end.x,end.y,paint);
    }

    /**
     * 绘制x轴标题
     * @param canvas 画布
     * @param title  标题文本
     * @param baseX  x基线坐标
     * @param baseY  y基线坐标
     * @param paint  画笔
     */
    protected void drawXTitle(Canvas canvas, String title, int baseX, int baseY, Paint paint) {
        canvas.drawText(title,baseX,baseY,paint);
    }

    /**
     * 绘制y轴标题
     * @param canvas
     * @param title
     * @param baseX
     * @param baseY
     * @param paint
     */
    protected void drawYTitle(Canvas canvas, String title, int baseX, int baseY, Paint paint) {
        canvas.drawText(title,baseX,baseY,paint);
    }

    /**
     * 绘制网格线
     * @param canvas
     * @param startX
     * @param stepX
     * @param xLength
     * @param endX
     * @param startY
     * @param stepY
     * @param yLength
     * @param endY
     * @param paint
     */
    protected void drawGrid(Canvas canvas,Point startX, int stepX,int xLength, Point endX,
                            Point startY, int stepY,int yLength, Point endY,Paint paint) {
        if (startX.x < endX.x && stepX < endX.x) {
            while (true) {
                canvas.drawLine(startX.x, startX.y, startX.x, startX.y - xLength, paint);
                startX.x += stepX;
                if (startX.x >= endX.x) {
                    break;
                }
            }
        }

        if (startY.y < endY.y && stepY < endY.y) {
            while (true) {
                canvas.drawLine(startY.x, startY.y, startY.x + yLength, startY.y, paint);
                startY.y += stepY;
                if (startY.y >= endY.y) {
                    break;
                }
            }
        }
    }


}
