package com.xiaopeng.speech.protocol.bean.config;

import com.xiaopeng.speech.common.util.DontProguardClass;
@DontProguardClass
/* loaded from: classes.dex */
public class GuideConentBean {
    private String content;
    private String des;
    private String img;
    public Object props;

    public String getContent() {
        return this.content;
    }

    public String getDes() {
        return this.des;
    }

    public String getImg() {
        return this.img;
    }

    public Object getProps() {
        return this.props;
    }

    public void setContent(String str) {
        this.content = str;
    }

    public void setDes(String str) {
        this.des = str;
    }

    public void setImg(String str) {
        this.img = str;
    }

    public void setProps(Object obj) {
        this.props = obj;
    }
}
