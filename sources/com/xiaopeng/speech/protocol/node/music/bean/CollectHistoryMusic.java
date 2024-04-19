package com.xiaopeng.speech.protocol.node.music.bean;

import com.xiaopeng.speech.common.util.DontProguardClass;
import org.json.JSONException;
import org.json.JSONObject;
@DontProguardClass
/* loaded from: classes.dex */
public class CollectHistoryMusic {
    private int type;

    public static CollectHistoryMusic fromJson(String str) {
        CollectHistoryMusic collectHistoryMusic = new CollectHistoryMusic();
        try {
            collectHistoryMusic.setType(new JSONObject(str).optInt("type"));
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return collectHistoryMusic;
    }

    public int getType() {
        return this.type;
    }

    public void setType(int i) {
        this.type = i;
    }
}
