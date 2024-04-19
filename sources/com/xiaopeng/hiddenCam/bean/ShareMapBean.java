package com.xiaopeng.hiddenCam.bean;

import java.util.List;
/* loaded from: classes.dex */
public class ShareMapBean {
    public List<Integer> Dest;
    public int Floor;
    public long mapTime;

    public ShareMapBean(int i, List<Integer> list, long j) {
        this.mapTime = 0L;
        this.Floor = i;
        this.Dest = list;
        this.mapTime = j;
    }
}
