package com.cbs.app;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;

import com.cbs.engine.ChartFactory;
import com.cbs.engine.renderer.LineChartRender;
import com.cbs.engine.series.LineChartSeries;
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
        setContentView(chartView);
    }

    private LineChartSeries generateSeries() {
        return new LineChartSeries();
    }

    private LineChartRender generateRender() {
        LineChartRender render = new LineChartRender();
        render.setApplyBgColor(true);
        render.setmBgColor(Color.BLACK);
        render.setmTitle("Hello world");
        //todo more properties
        return render;
    }
}
