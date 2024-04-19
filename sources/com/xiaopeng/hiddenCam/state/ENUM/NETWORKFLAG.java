package com.xiaopeng.hiddenCam.state.ENUM;
/* loaded from: classes.dex */
public enum NETWORKFLAG {
    NOT_INITIAL(-1),
    LOST(0),
    AVAILABLE(1);
    
    public int value;

    NETWORKFLAG(int i) {
        this.value = i;
    }
}
