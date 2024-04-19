package com.xiaopeng.hiddenCam.state.ENUM;
/* loaded from: classes.dex */
public enum CONFIG {
    CONFIG_NOT_INIT(-1),
    CONFIG_FAILED(0),
    CONFIG_SUCCESS(1);
    
    public int value;

    CONFIG(int i) {
        this.value = i;
    }
}
