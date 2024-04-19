package com.xiaopeng.hiddenCam.state.ENUM;
/* loaded from: classes.dex */
public enum SIGNALSTATE {
    INITIAL(-1),
    ACTIVE_STUDDY(0),
    POWER_ON(1),
    DELAY_MINUTE(2);
    
    public int value;

    SIGNALSTATE(int i) {
        this.value = i;
    }
}
