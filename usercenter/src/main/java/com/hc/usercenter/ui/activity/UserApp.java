package com.hc.usercenter.ui.activity;

import android.app.Application;
import android.util.Log;

import com.hc.baselibrary.font.FontEcModel;
import com.hc.baselibrary.myapplication.BaseApplication;
import com.joanzapata.iconify.Iconify;
import com.joanzapata.iconify.fonts.FontAwesomeModule;

public class UserApp extends BaseApplication {

    @Override
    public void onCreate() {
        super.onCreate();
        initModuleApp(this);
        initModuleData(this);
        Log.d("userapp","userapp");

    }

    @Override
    public void initModuleApp(Application application) {
        Iconify.with(new FontEcModel());
    }

    @Override
    public void initModuleData(Application application) {

    }
}
