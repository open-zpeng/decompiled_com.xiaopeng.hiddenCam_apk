package com.xiaopeng.speech.actorapi;

import android.os.Parcel;
import com.xiaopeng.speech.actor.Actor;
/* loaded from: classes.dex */
public class ResultActor extends Actor {
    public static final String NAME = "ResultActor";
    protected String c;
    protected String d;

    public ResultActor(String str) {
        super(NAME);
        this.c = "";
        this.c = str;
    }

    public String a() {
        return this.c;
    }

    @Override // com.xiaopeng.speech.actor.Actor, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeString(a());
        parcel.writeString(this.d);
    }

    public ResultActor(String str, Parcel parcel) {
        super(str, parcel);
        this.c = "";
        this.c = parcel.readString();
        this.d = parcel.readString();
    }
}
