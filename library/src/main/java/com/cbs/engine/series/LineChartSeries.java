package com.cbs.engine.series;

/**
 * date: 2017/2/11 0011
 * author: cbs
 */

public class LineChartSeries extends DefaultSeries{

    /**
     * x轴数据
     */
    private int[] mXValues;
    /**
     * y轴数据
     */
    private int[] mYValues;

    private String[] mXLabels;
    private String[] mYLabels;

    private int minX;
    private int minY;
    private int maxX;
    private int maxY;

    public LineChartSeries(int[] xValues, int[] yValues) {
        this.mXValues = xValues;
        this.mYValues = yValues;
        updateRange();
    }

    public LineChartSeries(int[] xValues, int[] yValues, String[] xLabels, String[] ylabels) {
        this.mXValues = xValues;
        this.mYValues = yValues;
        this.mXLabels = xLabels;
        this.mYLabels = ylabels;
        updateRange();
    }

    public LineChartSeries(int[] xValues,int[] yValues,String[] xLabels,String[] yLabels,
                           int xMin,int xMax,int yMin,int yMax) {
        this(xValues, yValues, xLabels, yLabels);
        checkParameter(xMin, xMax, yMin, yMax);
    }

    private void checkParameter(int xMin, int xMax, int yMin, int yMax) {
        if (xMin > getMinX() || xMax < getMaxX() || yMin > getMinY() || yMax < getMaxY()) {
            throw new RuntimeException("init x/y value range error");
        }
        setMinX(xMin);
        setMaxX(xMax);
        setMinY(yMin);
        setMaxY(yMax);
    }

    private void updateRange() {
        minX= Integer.MAX_VALUE;
        maxX = Integer.MIN_VALUE;

        for(int i=0; i<mXValues.length; ++i) {
            if (mXValues[i] > maxX) {
                maxX = mXValues[i];
            }
            if (mXValues[i] < minX) {
                minX = mXValues[i];
            }
        }

        minY = Integer.MAX_VALUE;
        maxY = Integer.MIN_VALUE;
        for(int i=0; i<mYValues.length; ++i) {
            if (mYValues[i] > maxY) {
                maxY = mYValues[i];
            }
            if (mYValues[i] < minY) {
                minY = mYValues[i];
            }
        }
    }

    public int[] getmXValues() {
        return mXValues;
    }

    public void setmXValues(int[] mXValues) {
        this.mXValues = mXValues;
    }

    public int[] getmYValues() {
        return mYValues;
    }

    public void setmYValues(int[] mYValues) {
        this.mYValues = mYValues;
    }

    public String[] getmXLabels() {
        return mXLabels;
    }

    public void setmXLabels(String[] mXLabels) {
        this.mXLabels = mXLabels;
    }

    public String[] getmYLabels() {
        return mYLabels;
    }

    public void setmYLabels(String[] mYLabels) {
        this.mYLabels = mYLabels;
    }

    public int getMinX() {
        return minX;
    }

    public void setMinX(int minX) {
        this.minX = minX;
    }

    public int getMinY() {
        return minY;
    }

    public void setMinY(int minY) {
        this.minY = minY;
    }

    public int getMaxX() {
        return maxX;
    }

    public void setMaxX(int maxX) {
        this.maxX = maxX;
    }

    public int getMaxY() {
        return maxY;
    }

    public void setMaxY(int maxY) {
        this.maxY = maxY;
    }
}
