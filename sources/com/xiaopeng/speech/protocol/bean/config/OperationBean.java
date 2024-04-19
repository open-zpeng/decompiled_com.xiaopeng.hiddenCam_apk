package com.xiaopeng.speech.protocol.bean.config;

import com.xiaopeng.speech.common.util.DontProguardClass;
@DontProguardClass
/* loaded from: classes.dex */
public class OperationBean {
    private String des;
    private String imgDisable;
    private String imgEnable;
    private boolean isOpened;
    private String tag;
    private String tips;
    private String title;
    private String type;

    public String getDes() {
        return this.des;
    }

    public String getImgDisable() {
        return this.imgDisable;
    }

    public String getImgEnable() {
        return this.imgEnable;
    }

    public String getTag() {
        return this.tag;
    }

    public String getTips() {
        return this.tips;
    }

    public String getTitle() {
        return this.title;
    }

    public String getType() {
        return this.type;
    }

    public boolean isOpened() {
        return this.isOpened;
    }

    public void setDes(String str) {
        this.des = str;
    }

    public void setImgDisable(String str) {
        this.imgDisable = str;
    }

    public void setImgEnable(String str) {
        this.imgEnable = str;
    }

    public void setOpened(boolean z) {
        this.isOpened = z;
    }

    public void setTag(String str) {
        this.tag = str;
    }

    public void setTips(String str) {
        this.tips = str;
    }

    public void setTitle(String str) {
        this.title = str;
    }

    public void setType(String str) {
        this.type = str;
    }
}
