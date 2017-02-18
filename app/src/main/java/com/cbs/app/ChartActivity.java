package com.cbs.app;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;

import com.cbs.engine.ChartFactory;
import com.cbs.engine.renderer.BarChartRenderer;
import com.cbs.engine.renderer.PieChartRenderer;
import com.cbs.engine.renderer.PointChartRenderer;
import com.cbs.engine.renderer.PolyLineChartRender;
import com.cbs.engine.series.LineChartSeries;
import com.cbs.engine.series.PieChartSeries;
import com.cbs.engine.util.SystemUtil;
import com.cbs.engine.view.ChartView;

/**
 * date: 2017/2/11 0011
 * author: cbs
 */

public class ChartActivity extends Activity {

    public static final int POLYLINE = 0;
    public static final int POINT = 1;
    public static final int BAR = 2;
    public static final int PIE = 3;

    public static final String TYPE_KEY = "chart_type";

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        int type = getIntent().getIntExtra(TYPE_KEY, POINT);

        setContentView(getChartViewByType(type));
    }

    private ChartView getChartViewByType(int type) {
        ChartView chartView = null;
        if (type == POINT) {
            chartView = ChartFactory.getPointChartView(this,generateSeries(),generatePointRenderer());
        } else if (type == POLYLINE) {
            chartView = ChartFactory.getPolyLineChartView(this, generateSeries(), generateRender());
        } else if (type == BAR) {
            chartView = ChartFactory.getBarChartView(this, generateSeries(), generateBarChartRenderer());
        } else if (type == PIE) {
            chartView = ChartFactory.getPieChartView(this, generatePieChartSeries(), generatePieChartRenderer());
        }
        return chartView;
    }
    private LineChartSeries generateSeries() {
        String[] xLabels = new String[]{"1","2","Jan","4","five","6","7","8","9","10","11","12"};
        String[] yLabels = new String[]{"-30","very cold","-20","-10","0","10","Nice","30","40"};
        int[] xValues = new int[]{1,2,3,4,5,6,7,8,9,10,11,12};
        int[] yValues = new int[]{12,34,56,34,23,11,6,10,25,67,77,44};
        LineChartSeries series = new LineChartSeries(xValues, yValues, xLabels, yLabels,0,12,0,100);
        return series;
    }

    private PolyLineChartRender generateRender() {
        PolyLineChartRender render = new PolyLineChartRender();
        render.setApplyBgColor(true);
        render.setmBgColor(Color.BLACK);
        render.setmTitle("Monthly temperature");

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

        render.setmXTitle("我是x轴");
        render.setmYTitle("我是y轴");

        render.setmLegendHeight(SystemUtil.dip2px(this, 90));

        return render;
    }

    private BarChartRenderer generateBarChartRenderer() {
        BarChartRenderer renderer = new BarChartRenderer();
        renderer.setApplyBgColor(true);
        renderer.setmBgColor(Color.BLACK);
        renderer.setmTitle("Monthly temperature");

        renderer.setmXTitle("我是x轴");
        renderer.setmYTitle("我是y轴");

        renderer.setmBarWidth(SystemUtil.dip2px(this, 120));
        return renderer;
    }

    private PieChartSeries generatePieChartSeries() {
        int[] values = new int[]{2, 3, 6, 1, 8};
        String[] labels = new String[]{"一月份","二月份","三月份","四月份","五月份"};
        return new PieChartSeries(values,labels);
    }
    private PieChartRenderer generatePieChartRenderer() {
        PieChartRenderer renderer = new PieChartRenderer(getApplicationContext());

        renderer.setApplyBgColor(true);
        renderer.setmBgColor(Color.BLACK);
        renderer.setmTitle("Monthly temperature");
        renderer.setmLegendHeight(SystemUtil.dip2px(this,50));
//        renderer.setmRadius(SystemUtil.dip2px(this,300));
        renderer.setmStartAngle(-90);
        return renderer;
    }
}
