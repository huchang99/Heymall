package com.hc.heymall.ui.application;

import android.app.Application;

import com.alibaba.android.arouter.launcher.ARouter;
import com.hc.baselibrary.BuildConfig;
import com.hc.baselibrary.myapplication.AppConfig;
import com.hc.baselibrary.myapplication.BaseApplication;

public class MainApplication extends BaseApplication {

    @Override
    public void onCreate() {
        super.onCreate();
        //初始化ARouter
        if (isDebug()) {
            ARouter.openDebug();//打印日志
            ARouter.openDebug();//开启调试模式(如果在InstantRun模式下运行，必须开启调试模式！线上版本需要关闭,否则有安全风险)
        }
        ARouter.init(this);
        //初始化组件Application
        initModuleApp(this);
        //所有Application初始化后的操作
        initModuleData(this);
    }

    private boolean isDebug() {
        return BuildConfig.DEBUG;
    }

    @Override
    public void initModuleApp(Application application) {
        for (String moduleApp : AppConfig.moduleApps) {
            try {
                Class clazz = Class.forName(moduleApp);
                BaseApplication baseApplication = (BaseApplication) clazz.newInstance();
                baseApplication.initModuleApp(this);
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InstantiationException e) {
                e.printStackTrace();
            }
        }

    }

    @Override
    public void initModuleData(Application application) {
        for (String moduleApp : AppConfig.moduleApps) {
            try {
                Class clazz = Class.forName(moduleApp);
                BaseApplication baseApplication = (BaseApplication) clazz.newInstance();
                baseApplication.initModuleApp(this);
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InstantiationException e) {
                e.printStackTrace();
            }
        }
    }
}
