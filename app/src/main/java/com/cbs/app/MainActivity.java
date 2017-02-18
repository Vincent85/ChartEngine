package com.cbs.app;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

/**
 * date: 2017/2/13 0013
 * author: cbs
 */

public class MainActivity extends Activity implements View.OnClickListener{

    private Button mPointBtn;
    private Button mPolyLineBtn;
    private Button mBarBtn;
    private Button mPieBtn;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_layout);

        initView();
    }

    private void initView() {
        mPointBtn = (Button) findViewById(R.id.point_btn);
        mPolyLineBtn = (Button) findViewById(R.id.polyline_btn);
        mBarBtn = (Button) findViewById(R.id.bar_btn);
        mPieBtn = (Button) findViewById(R.id.pie_btn);

        mPointBtn.setOnClickListener(this);
        mPolyLineBtn.setOnClickListener(this);
        mBarBtn.setOnClickListener(this);
        mPieBtn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        int type ;
        switch (v.getId()) {
            case R.id.point_btn:
                type = ChartActivity.POINT;
                break;
            case R.id.polyline_btn:
                type = ChartActivity.POLYLINE;
                break;
            case R.id.bar_btn:
                type = ChartActivity.BAR;
                break;
            case R.id.pie_btn:
                type = ChartActivity.PIE;
                break;
            default :
                type = ChartActivity.POINT;
                break;
        }
        Intent intent = new Intent(this, ChartActivity.class);
        intent.putExtra(ChartActivity.TYPE_KEY, type);
        startActivity(intent);
    }


}
