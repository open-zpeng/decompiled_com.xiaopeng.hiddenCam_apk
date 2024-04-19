package com.xiaopeng.speech.actorapi;

import android.os.Parcel;
import com.xiaopeng.speech.actor.Actor;
/* loaded from: classes.dex */
public class DataActor extends Actor {
    public static final String NAME = "DataActor";
    protected String c;
    protected String d;
    protected boolean e;

    public DataActor(String str) {
        super(NAME);
        this.c = "";
        this.e = true;
        this.c = str;
    }

    public String a() {
        return this.c;
    }

    public String toString() {
        return "DataActor{mEvent='" + this.c + "', mResultData='" + this.d + "', mIsSupport=" + this.e + '}';
    }

    @Override // com.xiaopeng.speech.actor.Actor, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeString(a());
        parcel.writeString(this.d);
        parcel.writeByte(this.e ? (byte) 1 : (byte) 0);
    }

    public DataActor(String str, Parcel parcel) {
        super(str, parcel);
        this.c = "";
        this.e = true;
        this.c = parcel.readString();
        this.d = parcel.readString();
        this.e = parcel.readByte() != 0;
    }
}
