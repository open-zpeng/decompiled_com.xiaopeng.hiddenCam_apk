package com.xiaopeng.speech.protocol.bean;

import com.xiaopeng.speech.common.util.DontProguardClass;
import org.json.JSONObject;
@DontProguardClass
/* loaded from: classes.dex */
public class WindowAnimState {
    private int from;
    private int state;

    public WindowAnimState() {
    }

    public static WindowAnimState fromJson(String str) {
        WindowAnimState windowAnimState = new WindowAnimState();
        try {
            JSONObject jSONObject = new JSONObject(str);
            windowAnimState.from = jSONObject.optInt("from");
            windowAnimState.state = jSONObject.optInt("state");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return windowAnimState;
    }

    public int getFrom() {
        return this.from;
    }

    public int getState() {
        return this.state;
    }

    public void setFrom(int i) {
        this.from = i;
    }

    public void setState(int i) {
        this.state = i;
    }

    public WindowAnimState(int i, int i2) {
        this.from = i;
        this.state = i2;
    }
}
