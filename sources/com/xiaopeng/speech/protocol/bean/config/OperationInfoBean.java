package com.xiaopeng.speech.protocol.bean.config;

import com.xiaopeng.speech.common.util.DontProguardClass;
import java.util.Map;
@DontProguardClass
/* loaded from: classes.dex */
public class OperationInfoBean {
    private Map<String, OperationBean> data;
    private boolean isOpened;
    private String subTitle;
    private String title;

    public Map<String, OperationBean> getData() {
        return this.data;
    }

    public String getSubTitle() {
        return this.subTitle;
    }

    public String getTitle() {
        return this.title;
    }

    public boolean isOpened() {
        return this.isOpened;
    }

    public void setData(Map<String, OperationBean> map) {
        this.data = map;
    }

    public void setOpened(boolean z) {
        this.isOpened = z;
    }

    public void setSubTitle(String str) {
        this.subTitle = str;
    }

    public void setTitle(String str) {
        this.title = str;
    }
}
