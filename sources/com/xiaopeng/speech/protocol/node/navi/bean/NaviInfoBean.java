package com.xiaopeng.speech.protocol.node.navi.bean;

import com.xiaopeng.speech.common.util.DontProguardClass;
@DontProguardClass
/* loaded from: classes.dex */
public class NaviInfoBean {
    private PoiBean poiBean;
    private long remainderLift;
    private long remainderRange;
    private long remainderTime;

    public PoiBean getPoiBean() {
        return this.poiBean;
    }

    public long getRemainderLift() {
        return this.remainderLift;
    }

    public long getRemainderRange() {
        return this.remainderRange;
    }

    public long getRemainderTime() {
        return this.remainderTime;
    }

    public void setPoiBean(PoiBean poiBean) {
        this.poiBean = poiBean;
    }

    public void setRemainderLift(long j) {
        this.remainderLift = j;
    }

    public void setRemainderRange(long j) {
        this.remainderRange = j;
    }

    public void setRemainderTime(long j) {
        this.remainderTime = j;
    }

    public String toString() {
        return "NaviInfoBean{remainderRange=" + this.remainderRange + ", remainderTime=" + this.remainderTime + ", remainderLift=" + this.remainderLift + ", poiBean=" + this.poiBean + '}';
    }
}
