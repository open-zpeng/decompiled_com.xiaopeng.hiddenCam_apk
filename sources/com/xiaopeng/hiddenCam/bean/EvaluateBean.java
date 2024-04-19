package com.xiaopeng.hiddenCam.bean;
/* loaded from: classes.dex */
public class EvaluateBean {
    public int evaluation;
    public String mapName;
    public long mapTime;
    public int type;

    public EvaluateBean(String str, int i, int i2, long j) {
        this.mapName = str;
        this.evaluation = i;
        this.type = i2;
        this.mapTime = j;
    }
}
