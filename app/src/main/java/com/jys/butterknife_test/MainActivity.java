package com.jys.butterknife_test;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.jys.testlibrary.MyActivity;

import butterknife.BindView;

public class MainActivity extends MyActivity {

    @BindView(R.id.tv)
    TextView mTv;


    @Override
    protected int layoutId() {
        return R.layout.activity_main;
    }

    @Override
    protected void initCon() {
        super.initCon();
        mTv.setText("Library中配置ButterKnife");
    }
}
