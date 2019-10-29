package com.hc.mymodule.activity;

import android.app.Application;
import android.util.Log;

import com.hc.baselibrary.myapplication.BaseApplication;
import com.orhanobut.logger.AndroidLogAdapter;
import com.orhanobut.logger.Logger;

public class MyModuleApp extends BaseApplication {
    @Override
    public void onCreate() {
        super.onCreate();
        initModuleApp(this);
        initModuleData(this);
        Log.d("mymoduleapp","mymoduleapp");

    }

    @Override
    public void initModuleApp(Application application) {
        Logger.addLogAdapter(new AndroidLogAdapter());

    }

    @Override
    public void initModuleData(Application application) {

    }
}
