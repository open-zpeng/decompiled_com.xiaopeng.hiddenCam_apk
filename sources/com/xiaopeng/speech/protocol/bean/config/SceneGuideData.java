package com.xiaopeng.speech.protocol.bean.config;

import com.xiaopeng.speech.common.util.DontProguardClass;
import java.util.List;
@DontProguardClass
/* loaded from: classes.dex */
public class SceneGuideData {
    private List<GuideDataBean> data;
    private boolean isOpened;
    private String subtitle;
    private String title;

    public List<GuideDataBean> getData() {
        return this.data;
    }

    public String getSubtitle() {
        return this.subtitle;
    }

    public String getTitle() {
        return this.title;
    }

    public boolean isOpened() {
        return this.isOpened;
    }

    public void setData(List<GuideDataBean> list) {
        this.data = list;
    }

    public void setOpened(boolean z) {
        this.isOpened = z;
    }

    public void setSubtitle(String str) {
        this.subtitle = str;
    }

    public void setTitle(String str) {
        this.title = str;
    }
}
