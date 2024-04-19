package com.xiaopeng.speech.protocol.bean.skill;

import com.xiaopeng.speech.common.util.DontProguardClass;
import java.util.List;
@DontProguardClass
/* loaded from: classes.dex */
public class DataBean {
    private int endColor;
    private String headInfo;
    private String imageRes;
    private boolean isChange = false;
    private String modeName;
    private List<SkillBean> skill;
    private String skillDetailBg;
    private int startColor;

    public int getEndColor() {
        return this.endColor;
    }

    public String getHeadInfo() {
        return this.headInfo;
    }

    public String getImageRes() {
        return this.imageRes;
    }

    public String getModeName() {
        return this.modeName;
    }

    public List<SkillBean> getSkill() {
        return this.skill;
    }

    public String getSkillDetailBg() {
        return this.skillDetailBg;
    }

    public int getStartColor() {
        return this.startColor;
    }

    public boolean isChange() {
        return this.isChange;
    }

    public void setEndColor(int i) {
        this.endColor = i;
    }

    public void setHeadInfo(String str) {
        this.headInfo = str;
    }

    public void setImageRes(String str) {
        this.imageRes = str;
    }

    public void setIsChange(boolean z) {
        this.isChange = z;
    }

    public void setModeName(String str) {
        this.modeName = str;
    }

    public void setSkill(List<SkillBean> list) {
        this.skill = list;
    }

    public void setSkillDetailBg(String str) {
        this.skillDetailBg = str;
    }

    public void setStartColor(int i) {
        this.startColor = i;
    }
}
