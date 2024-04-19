package com.xiaopeng.speech.actorapi;

import android.os.Parcel;
import com.xiaopeng.speech.actor.Actor;
import com.xiaopeng.speech.common.bean.Value;
/* loaded from: classes.dex */
public class ValueActor extends Actor {
    public static final String NAME = "ValueActor";
    protected String c;
    protected Value d;

    public ValueActor(String str) {
        super(NAME);
        this.c = "";
        this.c = str;
    }

    @Override // com.xiaopeng.speech.actor.Actor, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeString(this.c);
        parcel.writeParcelable(this.d, 0);
    }

    public ValueActor(String str, Parcel parcel) {
        super(str, parcel);
        this.c = "";
        this.c = parcel.readString();
        this.d = (Value) parcel.readParcelable(Value.class.getClassLoader());
    }
}
