package com.hc.mymodule.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.hc.mymodule.R;
import com.hc.mymodule.launcher.LauncherActivity;
import com.hc.mymodule.loadlargepic.LoadLargePicActivity;
import com.hc.mymodule.sideslip.SideSlipActivity;
import com.hc.mymodule.updatephoto.UpdatePhotoActivity;
import com.orhanobut.logger.AndroidLogAdapter;
import com.orhanobut.logger.Logger;


public class FirstActivity extends Activity implements View.OnClickListener {

    private Button cehuaexit_btn; //侧滑退出
    private Button launcher_btn; //启动页
    private Button load_large_pic_btn;//高清加载巨图
    private Button update_photo_btn;//更新头像


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
        launcher_btn = findViewById(R.id.launcher_btn);
        load_large_pic_btn = findViewById(R.id.load_large_pic_btn);
        update_photo_btn = findViewById(R.id.update_photo_btn);
    }

    public void initListener() {
        cehuaexit_btn.setOnClickListener(this);
        launcher_btn.setOnClickListener(this);
        load_large_pic_btn.setOnClickListener(this);
        update_photo_btn.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.cehuaexit_btn: {
                Logger.d("SideSlipActivity");
                Intent intent = new Intent();
                intent.setClass(FirstActivity.this, SideSlipActivity.class);
                startActivity(intent);
                break;
            }
            case R.id.launcher_btn: {
                Logger.d("LauncherActivity");
                Intent intent = new Intent();
                intent.setClass(FirstActivity.this, LauncherActivity.class);
                startActivity(intent);
                break;
            }
            case R.id.load_large_pic_btn: {
                Logger.d("LoadLargePicActivity");
                Intent intent = new Intent();
                intent.setClass(FirstActivity.this, LoadLargePicActivity.class);
                startActivity(intent);
                break;
            }
            case R.id.update_photo_btn:{
                Logger.d("UpdatePhotoActivity");
                Intent intent = new Intent();
                intent.setClass(FirstActivity.this, UpdatePhotoActivity.class);
                startActivity(intent);
                break;
            }
        }
    }
}
