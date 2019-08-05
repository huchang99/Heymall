package com.hc.baselibrary.myapplication;

import android.app.Application;

public abstract class BaseApplication extends Application {
    /**
     * Application初始化
     */
    public abstract void initModuleApp(Application application);

    /**
     * 所有Application初始化后自定义操作
     */
    public abstract void initModuleData(Application application);

    @Override
    public void onCreate() {
        super.onCreate();
    }
}
