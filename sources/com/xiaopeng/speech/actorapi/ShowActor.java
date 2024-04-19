package com.xiaopeng.speech.actorapi;

import android.os.Parcel;
import com.xiaopeng.speech.actor.Actor;
/* loaded from: classes.dex */
public class ShowActor extends Actor {
    public static final String NAME = "ShowActor";
    private String mWidgetData;

    public ShowActor() {
        super(NAME);
    }

    @Override // com.xiaopeng.speech.actor.Actor, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeString(this.mWidgetData);
    }

    public ShowActor(String str, Parcel parcel) {
        super(str, parcel);
        this.mWidgetData = parcel.readString();
    }
}
