package com.hc.baselibrary.utils;

import android.util.Log;

public class Loghc {

    /**
     * 日志的开关，当项目上线时，关闭掉开关,把isShowing设为false
     *
     */
    private static boolean isShowing = true;

    public static  void v (String tag,String text){
        if (isShowing) {
            Log.v(tag,text);
        }
    }
    public static  void d (String tag,String text){
        if (isShowing) {
            Log.d(tag,text);
        }
    }
    public static  void i (String tag,String text){
        if (isShowing) {
            Log.i(tag,text);
        }
    }
    public static  void w (String tag,String text){
        if (isShowing) {
            Log.w(tag,text);
        }
    }
    public static  void e (String tag,String text){
        if (isShowing) {
            Log.e(tag,text);
        }
    }
}
