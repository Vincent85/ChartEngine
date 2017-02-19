package com.cbs.engine.renderer;

import android.content.Context;
import android.graphics.Color;
import android.text.TextPaint;

import com.cbs.engine.util.SystemUtil;

import java.util.List;

/**
 * date: 2017/2/11 0011
 * author: cbs
 * 默认渲染类
 */

public class DefaultRenderer {

    private static final int DEFAULT_TITLE_SIZE = 20;         //sp unit
    private static final int DEFAULT_LEGEND_TEXT_SIZE = 15;   //sp unit
    private static final int DEFAULT_LEGEND_HEIGHT = 50;      //dp unit
    private static final int DEFAULT_ANIMATED_DURATION = 2500; //ms unit
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
    private int mTitleTextSize;

    /**
     * 图例文本
     */
    private List<String> mLegendTexts;
    /**
     * 图例文本尺寸
     */
    private int mLegendTextSize;
    /**
     * 图例文本颜色
     */
    private int mLegendColor = Color.LTGRAY;

    /**
     * 图例区域高度
     */
    private int mLegendHeight;

    /**
     * 绘制文本的画笔
     */
    private TextPaint mTextPaint = new TextPaint();

    /**
     * 是否以动画形式呈现
     */
    private boolean isAnimated;

    /**
     * 动画呈现事件，单位ms
     */
    private int mAnimatedDuration;

    public DefaultRenderer(Context context) {
        mTitleTextSize = (int) SystemUtil.sp2px(context, (float)DEFAULT_TITLE_SIZE,SystemUtil.CHINESE);
        mLegendTextSize = (int) SystemUtil.sp2px(context, DEFAULT_LEGEND_TEXT_SIZE,SystemUtil.CHINESE);
        mLegendHeight = SystemUtil.dip2px(context, DEFAULT_LEGEND_HEIGHT);

        isAnimated = true;
        mAnimatedDuration = DEFAULT_ANIMATED_DURATION;
    }

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

    public int getmTitleTextSize() {
        return mTitleTextSize;
    }

    public void setmTitleTextSize(int mTitleTextSize) {
        this.mTitleTextSize = mTitleTextSize;
    }

    public List<String> getmLegendTexts() {
        return mLegendTexts;
    }

    public void setmLegendTexts(List<String> mLegendTexts) {
        this.mLegendTexts = mLegendTexts;
    }

    public int getmLegendTextSize() {
        return mLegendTextSize;
    }

    public void setmLegendTextSize(int mLegendTextSize) {
        this.mLegendTextSize = mLegendTextSize;
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

    public boolean isAnimated() {
        return isAnimated;
    }

    public void setAnimated(boolean animated) {
        isAnimated = animated;
    }

    public int getmAnimatedDuration() {
        return mAnimatedDuration;
    }

    public void setmAnimatedDuration(int mAnimatedDuration) {
        this.mAnimatedDuration = mAnimatedDuration;
    }
}
