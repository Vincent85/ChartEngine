package com.cbs.engine.renderer;

import android.graphics.Color;
import android.text.TextPaint;

import java.util.List;

/**
 * date: 2017/2/11 0011
 * author: cbs
 * 默认渲染类
 */

public class DefaultRenderer {

    private static final int DEFAULT_TITLE_SIZE = 45;
    private static final int DEFAULT_LEGEND_SIZE = 25;
    private static final int DEFAULT_LEGEND_HEIGHT = 60;
    /**
     * 是否使用自定义背景颜色
     */
    private boolean isApplyBgColor = false;
    /**
     * 自定义背景颜色
     */
    private int mBgColor = Color.BLACK;

    /**
     * 图表标题文本
     */
    private String mTitle;
    /**
     图表文本颜色
     */
    private int mTitleColor = Color.LTGRAY;
    /**
     图表文本尺寸
     */
    private int mTitleSize = DEFAULT_TITLE_SIZE;

    /**
     * 图例文本
     */
    private List<String> mLegendTexts;
    /**
     * 图例文本尺寸
     */
    private int mLegendSize = DEFAULT_LEGEND_SIZE;
    /**
     * 图例文本颜色
     */
    private int mLegendColor = Color.LTGRAY;

    /**
     * 图例区域高度
     */
    private int mLegendHeight = DEFAULT_LEGEND_HEIGHT;

    /**
     * 绘制文本的画笔
     */
    private TextPaint mTextPaint = new TextPaint();

    public boolean isApplyBgColor() {
        return isApplyBgColor;
    }

    public void setApplyBgColor(boolean applyBgColor) {
        isApplyBgColor = applyBgColor;
    }

    public int getmBgColor() {
        return mBgColor;
    }

    public void setmBgColor(int mBgColor) {
        this.mBgColor = mBgColor;
    }

    public String getmTitle() {
        return mTitle;
    }

    public void setmTitle(String mTitle) {
        this.mTitle = mTitle;
    }

    public int getmTitleColor() {
        return mTitleColor;
    }

    public void setmTitleColor(int mTitleColor) {
        this.mTitleColor = mTitleColor;
    }

    public int getmTitleSize() {
        return mTitleSize;
    }

    public void setmTitleSize(int mTitleSize) {
        this.mTitleSize = mTitleSize;
    }

    public List<String> getmLegendTexts() {
        return mLegendTexts;
    }

    public void setmLegendTexts(List<String> mLegendTexts) {
        this.mLegendTexts = mLegendTexts;
    }

    public int getmLegendSize() {
        return mLegendSize;
    }

    public void setmLegendSize(int mLegendSize) {
        this.mLegendSize = mLegendSize;
    }

    public int getmLegendColor() {
        return mLegendColor;
    }

    public void setmLegendColor(int mLegendColor) {
        this.mLegendColor = mLegendColor;
    }

    public int getmLegendHeight() {
        return mLegendHeight;
    }

    public void setmLegendHeight(int mLegendHeight) {
        this.mLegendHeight = mLegendHeight;
    }

    public TextPaint getmTextPaint() {
        return mTextPaint;
    }

    public void setmTextPaint(TextPaint mTextPaint) {
        this.mTextPaint = mTextPaint;
    }
}
