package com.xiaopeng.hiddenCam.speechmodel;

import com.xiaopeng.speech.protocol.bean.recommend.RecommendBean;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class SpeechResult {
    private String event;
    private Object result;

    public SpeechResult(String str, Object obj) {
        this.event = str;
        this.result = obj;
    }

    public String toString() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("event", this.event);
            jSONObject.put(RecommendBean.SHOW_TIME_RESULT, this.result);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jSONObject.toString();
    }
}
