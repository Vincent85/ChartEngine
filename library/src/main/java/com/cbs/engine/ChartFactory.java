package com.cbs.engine;

import android.content.Context;

import com.cbs.engine.chart.PointChart;
import com.cbs.engine.chart.PolyLineChart;
import com.cbs.engine.renderer.PointChartRenderer;
import com.cbs.engine.renderer.PolyLineChartRender;
import com.cbs.engine.series.LineChartSeries;
import com.cbs.engine.view.ChartView;

/**
 * date: 2017/2/11 0011
 * author: cbs
 * 图表工厂
 */

public class ChartFactory {

    public static ChartView getPolyLineChartView(Context context, LineChartSeries dataset, PolyLineChartRender renderer) {
        PolyLineChart chart = new PolyLineChart(dataset, renderer);
        ChartView chartView = new ChartView(context, chart);
        return chartView;
    }

    public static ChartView getPointChartView(Context context, LineChartSeries dataset, PointChartRenderer renderer) {
        PointChart chart = new PointChart(dataset, renderer);
        ChartView chartView = new ChartView(context,chart);
        return chartView;
    }


}
