package com.xiaopeng.hiddenCam.state.ENUM;
/* loaded from: classes.dex */
public enum YUVPROCSTATUS {
    INITIAL(-1),
    COLLECTING_IMG(0),
    PROCESS_YUV(1);
    
    public int value;

    YUVPROCSTATUS(int i) {
        this.value = i;
    }
}
