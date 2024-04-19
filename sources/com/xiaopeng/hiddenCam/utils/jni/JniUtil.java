package com.xiaopeng.hiddenCam.utils.jni;

import com.xiaopeng.hiddenCam.bean.DrivingData;
/* loaded from: classes.dex */
public class JniUtil {
    static {
        System.loadLibrary("ndk_image");
    }

    public static native void clearSaveDataCache();

    public static native int drivingData(DrivingData drivingData, int i, int i2);

    public static native float getExitDist();

    public static native int getIndoorStatus();

    public static native int getPowerOffFlag();

    public static native int getSaveImgFlag();

    public static native int getSuperStatus();

    public static native void init(int i);

    public static native int isInit();

    public static native void release();

    public static native void resetPartStatus();

    public static native void resetStatus();

    public static native int saveChamoBin(int i);

    public static native int saveDriveDataToFile(int i);

    public static native void setCarInInfo(String str);

    public static native void setChamobinPath(String str);

    public static native void setComfirmed(int i, int i2);

    public static native void setFenceId(int i);

    public static native void setGsvFlag(boolean z);

    public static native void setInfenceStatus(int i);

    public static native void setOngroundChamoPath(String str);

    public static native void setSuperStatus(int i);

    public static native int updateInOutStatus();
}
