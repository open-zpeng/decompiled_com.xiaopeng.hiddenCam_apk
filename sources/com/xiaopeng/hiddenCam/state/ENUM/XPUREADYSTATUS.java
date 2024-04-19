package com.xiaopeng.hiddenCam.state.ENUM;
/* loaded from: classes.dex */
public enum XPUREADYSTATUS {
    INITIAL(-1),
    NOT_READY(0),
    READY(1),
    FINISH_SENDING(2);
    
    public int value;

    XPUREADYSTATUS(int i) {
        this.value = i;
    }
}
