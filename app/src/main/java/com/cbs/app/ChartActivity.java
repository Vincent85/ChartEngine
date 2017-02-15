package com.cbs.app;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;

import com.cbs.engine.ChartFactory;
import com.cbs.engine.renderer.PointChartRenderer;
import com.cbs.engine.renderer.PolyLineChartRender;
import com.cbs.engine.series.LineChartSeries;
import com.cbs.engine.util.SystemUtil;
import com.cbs.engine.view.ChartView;

/**
 * date: 2017/2/11 0011
 * author: cbs
 */

public class ChartActivity extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ChartView chartView = ChartFactory.getPolyLineChartView(this, generateSeries(), generateRender());
//        ChartView chartView = ChartFactory.getPointChartView(this,generateSeries(),generatePointRenderer());
        setContentView(chartView);
    }

    private LineChartSeries generateSeries() {
        String[] xLabels = new String[]{"1","2","Jan","4","five","6","7","8","9","10","11","12"};
        String[] yLabels = new String[]{"-30","very cold","-20","-10","0","10","Nice","30","40"};
        int[] xValues = new int[]{1,2,3,4,5,6,7,8,9,10,11,12};
        int[] yValues = new int[]{12,34,56,34,23,11,6,10,25,67,77,44};
//        Random random = new Random();
//        for(int i=0; i<xValues.length; ++i) {
//            xValues[i] = random.nextInt(100);
//            yValues[i] = random.nextInt(100);
//            Log.d(TAG, "x[" + i + "] = " + xValues[i] + ",y[" + i + "] = " + yValues[i]);
//        }
        LineChartSeries series = new LineChartSeries(xValues, yValues, xLabels, yLabels,0,12,0,100);
        return series;
    }

    private PolyLineChartRender generateRender() {
        PolyLineChartRender render = new PolyLineChartRender();
        render.setApplyBgColor(true);
        render.setmBgColor(Color.BLACK);
        render.setmTitle("Monthly temperature");
        //todo more properties
        int[] margins = new int[4];
        int margin = SystemUtil.dip2px(this, 15);
        for(int i=0; i<margins.length; ++i) {
            margins[i] = margin;
        }
        render.setmMargins(margins);

        render.setmXTitle("我是x轴");
        render.setmYTitle("我是y轴");

        render.setmLegendHeight(SystemUtil.dip2px(this, 90));

        return render;
    }

    private PointChartRenderer generatePointRenderer() {
        PointChartRenderer render = new PointChartRenderer();
        render.setApplyBgColor(true);
        render.setmBgColor(Color.BLACK);
        render.setmTitle("Monthly temperature");
        //todo more properties
        int[] margins = new int[4];
        int margin = SystemUtil.dip2px(this, 15);
        for(int i=0; i<margins.length; ++i) {
            margins[i] = margin;
        }
        render.setmMargins(margins);

        render.setmXTitle("我是x轴");
        render.setmYTitle("我是y轴");

        render.setmLegendHeight(SystemUtil.dip2px(this, 90));

        return render;
    }
}
