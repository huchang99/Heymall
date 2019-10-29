package com.hc.mymodule.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.hc.baselibrary.utils.Loghc;
import com.hc.mymodule.R;
import com.orhanobut.logger.AndroidLogAdapter;
import com.orhanobut.logger.Logger;


public class FirstActivity extends Activity implements View.OnClickListener {

    private Button cehuaexit_btn; //侧滑退出

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);
        initView();
        initListener();

        //控制日志输出输入开关
        Logger.addLogAdapter(new AndroidLogAdapter() {
            @Override
            public boolean isLoggable(int priority, String tag) {
                return true;
            }
        });
        // Logger.d("hello");
    }

    public void initView() {
        cehuaexit_btn = findViewById(R.id.cehuaexit_btn);
    }

    public void initListener() {
        cehuaexit_btn.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.cehuaexit_btn: {
                Logger.d("SideSlipActivity");
                Intent intent = new Intent();
                intent.setClass(FirstActivity.this,SideSlipActivity.class);
                startActivity(intent);
            }
        }
    }
}
