package com.xiaopeng.hiddenCam.state.ENUM;
/* loaded from: classes.dex */
public enum CAMERA {
    CAMERA_STATE_NOT_START(-1),
    CAMERA_STATE_WORKING(0),
    CAMERA_STATE_FINISHED(1);
    
    public int value;

    CAMERA(int i) {
        this.value = i;
    }
}
