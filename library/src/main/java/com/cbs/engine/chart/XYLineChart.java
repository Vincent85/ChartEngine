package com.cbs.engine.chart;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.Rect;
import android.text.TextPaint;

import com.cbs.engine.renderer.LineChartRender;
import com.cbs.engine.series.LineChartSeries;

/**
 * date: 2017/2/11 0011
 * author: cbs
 */

public abstract class XYLineChart extends AbstractChart {

    protected LineChartSeries mSeries;
    protected LineChartRender mRenderer;

    private int xGap;
    private int yGap;
//    private int startTickX;
    private int startTickY;
    /**
     * 最后一个“钩子”的y坐标
     */
    private int endTickY;

    private Point origin;
    private Point endX;
    private Point endY;

    protected int[] xValues;
    protected int[] yValues;

    protected int maxX;
    protected int minX;
    protected int maxY;
    protected int minY;

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
    protected void drawXTitle(Canvas canvas, String title, int baseX, int baseY, TextPaint paint) {
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
    protected void drawYTitle(Canvas canvas, String title, int baseX, int baseY, TextPaint paint) {
        canvas.drawText(title,baseX,baseY,paint);
    }

    /**
     * 绘制x轴标签和钩子
     * @param canvas            画布
     * @param xLabels           标签字符数组
     * @param start             绘制开始坐标(标签文本基线坐标)
     * @param end               绘制结束坐标(标签文本基线坐标)
     * @param xLabelTickPadding x轴标签和钩子的间距
     * @param textPaint        文本画笔
     * @param drawTick         是否绘制“钩子”
     * @param tickLength       钩子长度
     * @param paint            钩子画笔
     */
    protected void drawXLabelsAndTicks(Canvas canvas, String[] xLabels, Point start, Point end,int xLabelTickPadding,
                                       TextPaint textPaint, boolean drawTick, int tickLength, Paint paint) {
        if (null == xLabels || xLabels.length == 0 || (end.x <= start.x)) {
            return;
        }
        //todo 需要考虑标签画不下去的情况

        int width = end.x - start.x;
        xGap = width / xLabels.length;

//        startTickX = (int) (start.x - paint.getStrokeWidth() / 2);
        for(int i=0; i<xLabels.length; ++i) {
            if (drawTick) {
                int beginX = start.x + (i + 1) * xGap;
                int beginY = (int) (start.y + textPaint.ascent() - xLabelTickPadding);
                canvas.drawLine(beginX,beginY,
                        beginX,beginY - tickLength,paint);
            }
            canvas.drawText(xLabels[i],start.x + (i + 1) * xGap - textPaint.measureText(xLabels[i]) / 2,
                    start.y,textPaint);
        }

    }

    /**
     * 绘制y轴标签和钩子
     * @param canvas
     * @param yLabels
     * @param start              绘制“钩子”起始点，在屏幕下方
     * @param end                绘制“钩子”结束点，在屏幕上方
     * @param titleAxisPadding   y轴标题和y轴的间距
     * @param textPaint
     * @param drawTick
     * @param tickLength
     * @param paint
     */
    protected void drawYLabelsAndTicks(Canvas canvas, String[] yLabels, Point start, Point end,int titleAxisPadding,
                                       TextPaint textPaint, boolean drawTick, int tickLength, Paint paint) {
        if (null == yLabels || yLabels.length == 0 || end.y >= start.y) {
            return;
        }
        int height = start.y - end.y;
        yGap = height / (yLabels.length - 1);

        startTickY = (int) (start.y - paint.getStrokeWidth() / 2);
        //钩子和标签的间距
        int padding = 15;
        int startTextY = (int) (start.y - paint.getStrokeWidth() / 2 - padding);
        for(int i=0; i<yLabels.length; ++i) {
            if (drawTick) {
                canvas.drawLine(start.x - tickLength, startTickY - i * yGap, start.x, startTickY - i * yGap,paint);
            }
            canvas.drawText(yLabels[i],start.x - titleAxisPadding,startTextY + textPaint.descent() - i * yGap,textPaint);
        }
        endTickY = startTickY - (yLabels.length - 1) * yGap;
    }

    /**
     * 绘制网格线
     * @param canvas    画布
     * @param startX    纵向网格线左下第一个点坐标
     * @param stepX     纵向网格线的间距
     * @param xLength   纵向网格线的长度
     * @param endX      纵向网格线右下点坐标
     * @param startY    横向网格线坐上第一个点坐标
     * @param stepY     横向网格线间距
     * @param yLength   横向网格线长度
     * @param endY      横向网格线左下点坐标
     * @param paint     画笔
     */
    protected void drawGrid(Canvas canvas,Point startX, int stepX,int xLength, Point endX,
                            Point startY, int stepY,int yLength, Point endY,Paint paint) {
        if (startX.x < endX.x && stepX < endX.x) {
            while (true) {
                canvas.drawLine(startX.x, startX.y, startX.x, startX.y - xLength, paint);
                startX.x += stepX;
                if (startX.x > endX.x) {
                    break;
                }
            }
        }

        if (startY.y < endY.y && stepY < endY.y) {
            while (true) {
                canvas.drawLine(startY.x, startY.y, startY.x + yLength, startY.y, paint);
                startY.y += stepY;
                if (startY.y > endY.y) {
                    break;
                }
            }
        }
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
        int titleBottom = (int) (top - textPaint.ascent() + textPaint.descent());
        drawTitle(canvas, mRenderer.getmTitle(), titleLeft, (int) (top - textPaint.ascent()), textPaint);

        /**
         * 绘制x轴和y轴标题
         */
        textPaint.setTextSize(mRenderer.getmXtitleSize());
        textPaint.setColor(mRenderer.getmXTitleColor());
        int xTitleBaseX = (int) ((width - textPaint.measureText(mRenderer.getmXTitle())) / 2);
        int xTitleBaseY = (int) (height - (bottom + textPaint.descent() + mRenderer.getmLegendHeight()));
        drawXTitle(canvas, mRenderer.getmXTitle(), xTitleBaseX, xTitleBaseY, textPaint);

        textPaint.setTextSize(mRenderer.getmYTitleSize());
        textPaint.setColor(mRenderer.getmYTitleColor());
        int yTitleBaseX = (int) (left - textPaint.ascent());
        int yTitleBaseY = (int) ((height - textPaint.measureText(mRenderer.getmYTitle())) / 2);
        //y轴标题需要逆时针旋转90度
        canvas.save();
        canvas.rotate(-90, yTitleBaseX, yTitleBaseY);
        drawYTitle(canvas, mRenderer.getmYTitle(), yTitleBaseX, yTitleBaseY, textPaint);
        canvas.restore();

        /**
         * 绘制x轴和y轴
         */
        origin = new Point();
        origin.x = (int) (yTitleBaseX + textPaint.descent() + mRenderer.getmYTitleAxisPadding());
        origin.y = (int) (xTitleBaseY - mRenderer.getmXTitleLabelPadding() - textPaint.descent() + textPaint.ascent()
                - mRenderer.getmXLabelTickPadding() - mRenderer.getmTickLength());

        endY = new Point();
        endY.x = origin.x;
        endY.y = titleBottom + mRenderer.getmTitleYAxisPadding();

        endX = new Point();
        endX.y = origin.y;
        endX.x = width - right;
        paint.setStrokeWidth(mRenderer.getmAxisWidth());
        paint.setColor(mRenderer.getmAxisColor());
        drawYAxis(canvas, origin, endY, paint);
        drawXAxis(canvas, origin, endX, paint);

        /**
         * 绘制x轴和y轴标签
         */
        if(null != mSeries.getmXLabels() && mSeries.getmXLabels().length != 0) {
            Point start = new Point();
            start.x = origin.x + mRenderer.getmXFirstTickPadding();
            start.y = (int) (origin.y + mRenderer.getmTickLength() + mRenderer.getmXLabelTickPadding() - textPaint.ascent());
            Point end = new Point();
            end.x = endX.x - mRenderer.getmGridRightPadding();
            end.y = start.y;
            paint.setStrokeWidth(mRenderer.getmTickWidth());
            paint.setColor(mRenderer.getmTickColor());
            drawXLabelsAndTicks(canvas, mSeries.getmXLabels(), start, end, mRenderer.getmXLabelTickPadding(), textPaint, true, mRenderer.getmTickLength(), paint);
        }
        if(null != mSeries.getmYLabels() && mSeries.getmYLabels().length != 0) {
            Point yTickEnd = new Point();
            yTickEnd.x = origin.x;
            yTickEnd.y = endY.y + mRenderer.getmYLastTickPadding();
            drawYLabelsAndTicks(canvas, mSeries.getmYLabels(), origin, yTickEnd, mRenderer.getmYTitleAxisPadding(),
                    textPaint, true, mRenderer.getmTickLength(), paint);
        }
        /**
         * 绘制网格线
         * todo 存在一个问题：当前网格起始坐标依赖于xy轴绘制标签时的计算
         */
        if (mRenderer.isGridShown()) {
            Point xStartGrid = new Point();
            xStartGrid.x = origin.x + xGap;
            xStartGrid.y = origin.y;
            Point xEndGrid = new Point();
            xEndGrid.x = endX.x - mRenderer.getmGridRightPadding();
            xEndGrid.y = xStartGrid.y;

            Point yEndGrid = new Point();
            yEndGrid.x = origin.x;
            yEndGrid.y = origin.y - yGap;
            Point yStartGrid = new Point();
            yStartGrid.x = origin.x;
            yStartGrid.y = yEndGrid.y - (mSeries.getmYLabels().length - 2) * yGap;
            paint.setStrokeWidth(mRenderer.getmGridWidth());
            paint.setColor(mRenderer.getmGridColor());
            drawGrid(canvas,xStartGrid,xGap,origin.y - endY.y,xEndGrid,yStartGrid,yGap,endX.x - origin.x,yEndGrid,paint);
        }
    }

    /**
     * 将数值转化为特定范围内的X坐标值
     * @param value      要转化的为坐标的数值
     * @param min
     * @param max
     * @param leftValue  坐标左值
     * @param rightValue 坐标右值
     * @return
     */
    public float convertToXCoordinate(int value, int min, int max, int leftValue, int rightValue) {
        float ratio = (float) (value - min) / (max - min);
        return  leftValue + (rightValue - leftValue) * ratio;
    }

    public float convertToYCoordinate(int value,int min,int max,int bottomValue,int topValue) {
        float ratio = (float) (value - min) / (max - min);
        return bottomValue - (bottomValue - topValue) * ratio;
    }

    /**
     * 初始化x/y轴数据及数据边界范围
     */
    protected void initSeriesRange() {
        xValues = mSeries.getmXValues();
        yValues = mSeries.getmYValues();

        maxX = mSeries.getMaxX();
        minX = mSeries.getMinX();
        maxY = mSeries.getMaxY();
        minY = mSeries.getMinY();
    }

    /**
     * 验证x/y轴数据有效性
     */
    protected void validateSeries() {
        if(null == xValues || xValues.length == 0 || null == yValues || yValues.length == 0) {
            throw new RuntimeException("xValues and yValues mustn't be null or empty");
        }
        if (xValues.length != yValues.length) {
            throw new RuntimeException("series x values length must be equal with y values length");
        }
    }

    public Point getOrigin() {
        return origin;
    }

    public void setOrigin(Point origin) {
        this.origin = origin;
    }

    public Point getEndX() {
        return endX;
    }

    public void setEndX(Point endX) {
        this.endX = endX;
    }

    public Point getEndY() {
        return endY;
    }

    public void setEndY(Point endY) {
        this.endY = endY;
    }

    public int getxGap() {
        return xGap;
    }

    public int getEndTickY() {
        return endTickY;
    }
}
