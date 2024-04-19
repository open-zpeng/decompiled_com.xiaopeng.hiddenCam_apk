package com.xiaopeng.hiddenCam.utils.jni;

import com.xiaopeng.hiddenCam.bean.CityInfoBean;
import com.xiaopeng.hiddenCam.bean.GarageInfoBean;
/* loaded from: classes.dex */
public class GpsUtils {
    static {
        System.loadLibrary("ndk_image");
    }

    public static native int fenceinit();

    public static native int getCityInfo(CityInfoBean cityInfoBean);

    public static native int getFenceId();

    public static native int getGarageInfo(GarageInfoBean garageInfoBean);

    public static native int init();

    public static native int knnSearch(float f, float f2);

    public static native int knnSearchfence(float f, float f2);

    public static native void release();
}
