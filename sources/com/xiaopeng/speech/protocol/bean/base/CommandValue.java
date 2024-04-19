package com.xiaopeng.speech.protocol.bean.base;

import com.xiaopeng.speech.common.util.DontProguardClass;
import org.json.JSONObject;
@DontProguardClass
/* loaded from: classes.dex */
public class CommandValue {
    private int color;
    private int number;
    private int percent;

    public CommandValue(String str) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (jSONObject.has("color")) {
                this.color = Integer.valueOf(jSONObject.getString("color")).intValue();
            }
            if (jSONObject.has("number")) {
                this.number = jSONObject.getInt("number");
            }
            if (jSONObject.has("percent")) {
                this.percent = jSONObject.getInt("percent");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public int getColor() {
        return this.color;
    }

    public int getNumber() {
        return this.number;
    }

    public int getPercent() {
        return this.percent;
    }

    public void setColor(int i) {
        this.color = i;
    }

    public void setNumber(int i) {
        this.number = i;
    }

    public void setPercent(int i) {
        this.percent = i;
    }
}
