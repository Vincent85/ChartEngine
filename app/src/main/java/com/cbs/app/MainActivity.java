package com.cbs.app;

import android.app.Activity;
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
        switch (v.getId()) {

        }
    }
}
