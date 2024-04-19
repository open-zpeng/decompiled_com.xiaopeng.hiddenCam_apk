package com.xiaopeng.hiddenCam.state.ENUM;
/* loaded from: classes.dex */
public enum REGFENCEFILESTATUS {
    INITIAL(-1),
    DOWNLOADING(1),
    FINISH_DOWNLOADING(2);
    
    public int value;

    REGFENCEFILESTATUS(int i) {
        this.value = i;
    }
}
