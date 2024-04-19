package com.xiaopeng.hiddenCam.utils.jni;
/* loaded from: classes.dex */
public class ImageUtils {
    static {
        System.loadLibrary("ndk_image");
    }

    public static native int getImage(int[] iArr, byte[] bArr, byte[] bArr2, int i, int i2, int i3, int i4);

    public static native boolean init();

    public static native boolean processOngroundYuvs();

    public static native int processYuvs(int[] iArr, byte[] bArr, byte[] bArr2, int i, int i2, int i3);

    public static native boolean processYuvsOutStitch();

    public static native boolean processYuvsStitch();
}
