package com.xiaopeng.speech.protocol.bean.stats;

import com.xiaopeng.speech.common.util.DontProguardClass;
@DontProguardClass
/* loaded from: classes.dex */
public class RecommendStatBean extends StatCommonBean {
    private int clickPosition;
    private String clickText;
    private long clickTime;
    private String firstText;
    private String msgId;
    private String refMsgId;
    private String secondText;
    private long showTime;
    private String subType;
    private String thirdText;
    private String type;

    public RecommendStatBean() {
        super(StatCommonBean.EVENT_RECOMMEND_ID);
    }

    public int getClickPosition() {
        return this.clickPosition;
    }

    public String getClickText() {
        return this.clickText;
    }

    public long getClickTime() {
        return this.clickTime;
    }

    public String getFirstText() {
        return this.firstText;
    }

    public String getMsgId() {
        return this.msgId;
    }

    public String getRefMsgId() {
        return this.refMsgId;
    }

    public String getSecondText() {
        return this.secondText;
    }

    public long getShowTime() {
        return this.showTime;
    }

    public String getSubType() {
        return this.subType;
    }

    public String getThirdText() {
        return this.thirdText;
    }

    public String getType() {
        return this.type;
    }

    public void setClickPosition(int i) {
        this.clickPosition = i;
    }

    public void setClickText(String str) {
        this.clickText = str;
    }

    public void setClickTime(long j) {
        this.clickTime = j;
    }

    public void setFirstText(String str) {
        this.firstText = str;
    }

    public void setMsgId(String str) {
        this.msgId = str;
    }

    public void setRefMsgId(String str) {
        this.refMsgId = str;
    }

    public void setSecondText(String str) {
        this.secondText = str;
    }

    public void setShowTime(long j) {
        this.showTime = j;
    }

    public void setSubType(String str) {
        this.subType = str;
    }

    public void setThirdText(String str) {
        this.thirdText = str;
    }

    public void setType(String str) {
        this.type = str;
    }

    public String toString() {
        return "RecommendStatBean{type='" + this.type + "', showTime='" + this.showTime + "', firstText='" + this.firstText + "', secondText='" + this.secondText + "', thirdText='" + this.thirdText + "'}";
    }
}
