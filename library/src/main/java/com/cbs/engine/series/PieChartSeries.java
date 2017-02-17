package com.cbs.engine.series;

/**
 * date: 2017/2/16 0016
 * author: cbs
 */

public class PieChartSeries extends DefaultSeries {

    /**
     * 饼图数据
     */
    private int[] mValues;
    /**
     * 饼图对应的标签，可选
     */
    private String[] mLabels;

    /**
     * 饼图数据转化
     * 为对应的百分比数值
     */
    private int[] mPercents;

    /**
     * 要突出显示的数据下标，
     * 0 -- （length - 1）
     */
    private int mHighlightIndex = -1;

    public PieChartSeries(int[] values) {
        if (null == values || values.length < 1) {
            throw new RuntimeException("data size must greater than 1");
        }

        this.mValues = values;
        values2Percents();
    }

    public PieChartSeries(int[] values,String[] labels) {
        this(values);
        mLabels = labels;
    }

    /**
     * 原始数据转化为百分比数据
     */
    private void values2Percents() {
        mPercents = new int[mValues.length];
        int sum = 0;

        for(int i=0; i<mValues.length; ++i) {
            sum += mValues[i];
        }
        int aggregate = 0;
        for(int i=0; i<mValues.length - 1; ++i) {
            mPercents[i] = (int) (((float)mValues[i] / sum) * 100);
            aggregate += mPercents[i];
        }
        mPercents[mPercents.length-1] = 100 - aggregate;
    }

    public int[] getmValues() {
        return mValues;
    }

    public void setmValues(int[] mValues) {
        this.mValues = mValues;
    }

    public String[] getmLabels() {
        return mLabels;
    }

    public void setmLabels(String[] mLabels) {
        this.mLabels = mLabels;
    }

    public int[] getmPercents() {
        return mPercents;
    }

    public int getmHighlightIndex() {
        return mHighlightIndex;
    }

    public void setmHighlightIndex(int highlightIndex) {
        if(null == mValues) {
            throw new RuntimeException("PieChart series values mustn't be null");
        }
        if (highlightIndex >= mValues.length) {
            throw new RuntimeException("highlight index mustn't greater than series length");
        }
        this.mHighlightIndex = highlightIndex;
    }
}
