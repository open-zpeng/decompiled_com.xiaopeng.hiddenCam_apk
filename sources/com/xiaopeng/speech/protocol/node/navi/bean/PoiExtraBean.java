package com.xiaopeng.speech.protocol.node.navi.bean;

import com.xiaopeng.lib.apirouter.ClientConstants;
import com.xiaopeng.speech.common.util.DontProguardClass;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
@DontProguardClass
/* loaded from: classes.dex */
public class PoiExtraBean {
    private static final String TAG = "PoiExtraBean";
    private int acFreeNums;
    private int acNums;
    private boolean busiState;
    private String busiTime;
    private List<ChargeBean> content;
    private int dcFreeNums;
    private int dcNums;
    private String payment;
    private int selfSupportFlag;

    public static PoiExtraBean fromJson(String str) {
        new PoiExtraBean();
        y4.a();
        throw null;
    }

    private static ChargeBean parseChargeBean(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        ChargeBean chargeBean = new ChargeBean();
        chargeBean.setTotal(jSONObject.optInt("total"));
        chargeBean.setAvailable(jSONObject.optInt("available"));
        chargeBean.setPower(jSONObject.optString("power"));
        return chargeBean;
    }

    public int getAcFreeNums() {
        return this.acFreeNums;
    }

    public int getAcNums() {
        return this.acNums;
    }

    public boolean getBusiState() {
        return this.busiState;
    }

    public String getBusiTime() {
        return this.busiTime;
    }

    public List<ChargeBean> getContent() {
        return this.content;
    }

    public int getDcFreeNums() {
        return this.dcFreeNums;
    }

    public int getDcNums() {
        return this.dcNums;
    }

    public String getPayment() {
        return this.payment;
    }

    public int getSelfSupportFlag() {
        return this.selfSupportFlag;
    }

    public void setAcFreeNums(int i) {
        this.acFreeNums = i;
    }

    public void setAcNums(int i) {
        this.acNums = i;
    }

    public void setBusiState(boolean z) {
        this.busiState = z;
    }

    public void setBusiTime(String str) {
        this.busiTime = str;
    }

    public void setContent(List<ChargeBean> list) {
        this.content = list;
    }

    public void setDcFreeNums(int i) {
        this.dcFreeNums = i;
    }

    public void setDcNums(int i) {
        this.dcNums = i;
    }

    public void setPayment(String str) {
        this.payment = str;
    }

    public void setSelfSupportFlag(int i) {
        this.selfSupportFlag = i;
    }

    public JSONObject toJson() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("dcNums", this.dcNums);
        jSONObject.put("dcFreeNums", this.dcFreeNums);
        jSONObject.put("acNums", this.acNums);
        jSONObject.put("acFreeNums", this.acFreeNums);
        jSONObject.put("selfSupportFlag", this.selfSupportFlag);
        jSONObject.put("busiState", this.busiState);
        jSONObject.put("busiTime", this.busiTime);
        jSONObject.put("payment", this.payment);
        JSONArray jSONArray = new JSONArray();
        List<ChargeBean> list = this.content;
        if (list != null && list.size() > 0) {
            for (ChargeBean chargeBean : this.content) {
                jSONArray.put(chargeBean.toJson());
            }
        }
        jSONObject.put(ClientConstants.BINDER.SCHEME, jSONArray);
        return jSONObject;
    }

    public String toString() {
        return "PoiExtraBean{dcNums='" + this.dcNums + "', dcFreeNums='" + this.dcFreeNums + "', acNums='" + this.acNums + "', acFreeNums=" + this.acFreeNums + ", selfSupportFlag=" + this.selfSupportFlag + ", busiState='" + this.busiState + "', busiTime=" + this.busiTime + ", payment='" + this.payment + "', content='" + this.content + '}';
    }
}
