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
}
