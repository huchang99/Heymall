package com.hc.baselibrary.common;

import android.app.Activity;
import android.content.Context;
import android.support.v7.widget.AppCompatImageView;
import android.util.Log;

import java.util.List;
import java.util.Stack;

/**
 * Activity管理类
 */
public class AppManager {

    private static Stack<Activity> activityStack;
    private int size;

    private AppManager() {
    }

    private static class AppManagerHolder {
        private static final AppManager instance = new AppManager();
    }

    public static AppManager getInstance() {
        return AppManagerHolder.instance;
    }

    /**
     * 添加Activity
     */
    public void addActivity(Activity activity) {
        if (activityStack == null) {
            activityStack = new Stack<Activity>();
        }
        activityStack.add(activity);
    }

    /**
     * 获取当前的Activity
     */
    public Activity currentActivity() {
        if (activityStack == null) {
            return null;
        }
        Activity activity = activityStack.lastElement();
        return activity;
    }

    /**
     * 结束当前的Activity
     */
    public void finishCurrentActivity() {
        try {
            if (activityStack == null)
                return;
            Activity activity = activityStack.lastElement();
            finishActivity(activity);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 结束指定的Activity
     */
    public void finishActivity(Activity activity) {
        if (activity != null) {
            activityStack.remove(activity);
            activity.finish();
            activity = null;
        }
    }

    /**
     * 结束指定类的Acticity
     */
    public void finishActivity(Class<?> cls) {
        for (Activity activity : activityStack) {
            if (activity.getClass().equals(cls)) {
                finishActivity(activity);
            }
        }
    }

    /**
     * 结束指定的多个Activity
     */
    public void finishActivityList(List<Class<?>> clsList) {
        for (int i = 0; i < clsList.size(); i++) {
            Class<?> cls = clsList.get(i);
            for (int j = 0, size = activityStack.size(); j < size; j++)
                if (activityStack.get(i).getClass().equals(cls)) {
                    activityStack.get(i).finish();
                }
        }
    }

    /**
     * 结束所有的Activity
     */
    public void finishAllActivity() {
        for (int i = 0, size = activityStack.size(); i < size; i++) {
            if (null != activityStack.get(i)) {
                activityStack.get(i).finish();
            }
        }
        activityStack.clear();
    }

    /**
     * 退出应用程序
     */
    public void AppExit(Context mContext) {
        try {
            finishAllActivity();
            //退出程序
            android.os.Process.killProcess(android.os.Process.myPid());
            System.exit(1);
        } catch (Exception e) {
            Log.d("AppManager", "AppExit");
        }
    }
}
