package com.xiaopeng.hiddenCam.utils;

import android.util.Log;
/* loaded from: classes.dex */
public final class LogUtils {
    public static final int DEBUG = 3;
    public static final int ERROR = 1;
    public static final int INFO = 4;
    public static final int LOG_LEVEL = 6;
    public static final String PACKAGE_TAG = " chamo]";
    public static final int VERBOSE = 5;
    public static final int WARN = 2;

    private LogUtils() {
    }

    public static void d(String str) {
        Log.d("[" + getCallerName() + PACKAGE_TAG, str);
    }

    public static void e(String str) {
        Log.e("[" + getCallerName() + PACKAGE_TAG, str);
    }

    public static String getCallerName() {
        String className = Thread.currentThread().getStackTrace()[4].getClassName();
        return className.substring(className.lastIndexOf(".") + 1);
    }

    public static void i(String str) {
        Log.i("[" + getCallerName() + PACKAGE_TAG, str);
    }

    public static void v(String str) {
        Log.v("[" + getCallerName() + PACKAGE_TAG, str);
    }

    public static void w(String str) {
        Log.w("[" + getCallerName() + PACKAGE_TAG, str);
    }
}
