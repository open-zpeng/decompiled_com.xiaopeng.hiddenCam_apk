package com.xiaopeng.speech.protocol.bean.recommend;

import com.xiaopeng.speech.common.util.DontProguardClass;
import com.xiaopeng.speech.protocol.bean.base.ButtonBean;
import java.io.Serializable;
import java.util.List;
@DontProguardClass
/* loaded from: classes.dex */
public class RecommendBean implements Serializable {
    public static final String SHOW_TIME_GLOBAL = "global";
    public static final String SHOW_TIME_RESULT = "result";
    public static final String SHOW_TIME_TTS = "tts";
    public static final String SHOW_TIME_WAKEUP = "wakeup";
    private int cardType;
    private String duiWidget;
    private String hitText;
    private String hitTips;
    private boolean isHit;
    private String msgId;
    private String refMsgId;
    private List<ButtonBean> relateList;
    private String relateText;
    private String showStage;
    private String showType;
    private String subType;
    private String type;
    private String updateType;

    public int getCardType() {
        return this.cardType;
    }

    public String getDuiWidget() {
        return this.duiWidget;
    }

    public String getHitText() {
        return this.hitText;
    }

    public String getHitTips() {
        return this.hitTips;
    }

    public String getMsgId() {
        return this.msgId;
    }

    public String getRefMsgId() {
        return this.refMsgId;
    }

    public List<ButtonBean> getRelateList() {
        return this.relateList;
    }

    public String getRelateText() {
        return this.relateText;
    }

    public String getShowStage() {
        return this.showStage;
    }

    public String getShowType() {
        return this.showType;
    }

    public String getSubType() {
        return this.subType;
    }

    public String getType() {
        return this.type;
    }

    public String getUpdateType() {
        return this.updateType;
    }

    public boolean isHit() {
        return this.isHit;
    }

    public void setCardType(int i) {
        this.cardType = i;
    }

    public void setDuiWidget(String str) {
        this.duiWidget = str;
    }

    public void setHit(boolean z) {
        this.isHit = z;
    }

    public void setHitText(String str) {
        this.hitText = str;
    }

    public void setHitTips(String str) {
        this.hitTips = str;
    }

    public void setMsgId(String str) {
        this.msgId = str;
    }

    public void setRefMsgId(String str) {
        this.refMsgId = str;
    }

    public void setRelateList(List<ButtonBean> list) {
        this.relateList = list;
    }

    public void setRelateText(String str) {
        this.relateText = str;
    }

    public void setShowStage(String str) {
        this.showStage = str;
    }

    public void setShowType(String str) {
        this.showType = str;
    }

    public void setSubType(String str) {
        this.subType = str;
    }

    public void setType(String str) {
        this.type = str;
    }

    public void setUpdateType(String str) {
        this.updateType = str;
    }

    public String toString() {
        return "RecommendBean{relateText='" + this.relateText + "', relateList=" + this.relateList + ", showStage=" + this.showStage + ", showType=" + this.showType + ", isHit=" + this.isHit + ", hitTips=" + this.hitTips + ", cardType=" + this.cardType + '}';
    }
}
