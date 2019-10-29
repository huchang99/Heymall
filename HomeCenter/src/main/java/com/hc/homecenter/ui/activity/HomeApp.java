package com.hc.homecenter.ui.activity;

import android.app.Application;
import android.util.Log;

import com.hc.baselibrary.font.FontEcModel;
import com.hc.baselibrary.myapplication.BaseApplication;
import com.joanzapata.iconify.Iconify;

public class HomeApp extends BaseApplication {
    @Override
    public void onCreate() {
        super.onCreate();
        initModuleApp(this);
        initModuleData(this);
        Log.d("hchcHomeApp","HomeApp");
        Iconify.with(new FontEcModel());
    }

    @Override
    public void initModuleApp(Application application) {

    }

    @Override
    public void initModuleData(Application application) {

    }
}
