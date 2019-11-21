package com.hc.baselibrary.utils;

import android.content.Context;
import android.widget.Toast;

public class ToastUtils {

    private static Toast mToast;

    public static void showShortToast(Context mContext, String str) {
        if (mToast == null) {
            mToast = Toast.makeText(mContext, str, Toast.LENGTH_SHORT);
            mToast.show();
        }
    }

    public static void showLongToast(Context mContext, String str) {
        if (mToast == null) {
            mToast = Toast.makeText(mContext, str, Toast.LENGTH_LONG);
            mToast.show();
        }
    }


}
