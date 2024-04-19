package com.xiaopeng.speech.protocol.bean.skill;

import com.xiaopeng.speech.common.util.DontProguardClass;
@DontProguardClass
/* loaded from: classes.dex */
public class TipsBean {
    private String action;
    private String tipName;

    public String getAction() {
        return this.action;
    }

    public String getTipName() {
        return this.tipName;
    }

    public void setAction(String str) {
        this.action = str;
    }

    public void setTipName(String str) {
        this.tipName = str;
    }
}
