package com.xiaopeng.hiddenCam.utils.jni;
/* loaded from: classes.dex */
public class CollectOnground {
    static {
        System.loadLibrary("ndk_image");
    }

    public static native void init(int i);

    public static native void release();
}
