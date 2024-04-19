package com.xiaopeng.speech.actorapi;

import android.os.Parcel;
/* loaded from: classes.dex */
public class SupportActor extends ResultActor {
    public static final String NAME = "SupportActor";
    public static final String TTS_DEFAULT_NOT_SUPPORT = "暂不支持此功能";
    public static final String TTS_DEFAULT_SUPPORT = "好的";

    public SupportActor(String str) {
        super(str);
        this.b = NAME;
    }

    public SupportActor(String str, Parcel parcel) {
        super(str, parcel);
    }
}
