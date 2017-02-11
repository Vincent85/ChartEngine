package com.cbs.engine;

import android.content.Context;

import com.cbs.engine.chart.PolyLineChart;
import com.cbs.engine.renderer.LineChartRender;
import com.cbs.engine.series.LineChartSeries;
import com.cbs.engine.view.ChartView;

/**
 * date: 2017/2/11 0011
 * author: cbs
 * 图表工厂
 */

public class ChartFactory {

    public static ChartView getPolyLineChartView(Context context, LineChartSeries dataset, LineChartRender renderer) {
        PolyLineChart chart = new PolyLineChart(dataset, renderer);
        ChartView chartView = new ChartView(context, chart);
        return chartView;
    }
}
