package com.xiaopeng.speech.protocol.bean.skill;

import com.xiaopeng.speech.common.util.DontProguardClass;
import java.util.List;
@DontProguardClass
/* loaded from: classes.dex */
public class SkillData {
    private String aiSubTitle;
    private String aiTitle;
    private List<DataBean> data;
    private String subtitle;
    private int switchSkill;
    private String title;

    public String getAiSubTitle() {
        return this.aiSubTitle;
    }

    public String getAiTitle() {
        return this.aiTitle;
    }

    public List<DataBean> getData() {
        return this.data;
    }

    public String getSubTitle() {
        return this.subtitle;
    }

    public int getSwitchSkill() {
        return this.switchSkill;
    }

    public String getTitle() {
        return this.title;
    }

    public void setAiSubTitle(String str) {
        this.aiSubTitle = str;
    }

    public void setAiTitle(String str) {
        this.aiTitle = str;
    }

    public void setData(List<DataBean> list) {
        this.data = list;
    }

    public void setSubtitle(String str) {
        this.subtitle = str;
    }

    public void setSwitchSkill(int i) {
        this.switchSkill = i;
    }

    public void setTitle(String str) {
        this.title = str;
    }
}
