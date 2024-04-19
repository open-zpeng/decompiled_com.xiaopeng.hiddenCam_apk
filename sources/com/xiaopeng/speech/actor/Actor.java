package com.xiaopeng.speech.actor;

import android.os.Parcel;
import android.os.Parcelable;
import com.xiaopeng.speech.actorapi.AvatarActor;
import com.xiaopeng.speech.actorapi.DataActor;
import com.xiaopeng.speech.actorapi.DialogActor;
import com.xiaopeng.speech.actorapi.ResultActor;
import com.xiaopeng.speech.actorapi.ShowActor;
import com.xiaopeng.speech.actorapi.SupportActor;
import com.xiaopeng.speech.actorapi.TextActor;
import com.xiaopeng.speech.actorapi.ValueActor;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes.dex */
public class Actor implements Parcelable {
    protected String b;
    public static Map<String, Class<? extends Actor>> sActorMap = new HashMap<String, Class<? extends Actor>>() { // from class: com.xiaopeng.speech.actor.Actor.1
        {
            put(AvatarActor.NAME, AvatarActor.class);
            put(DialogActor.NAME, DialogActor.class);
            put(ResultActor.NAME, ResultActor.class);
            put(TextActor.NAME, TextActor.class);
            put(ShowActor.NAME, ShowActor.class);
            put(SupportActor.NAME, SupportActor.class);
            put(DataActor.NAME, DataActor.class);
            put(ValueActor.NAME, ValueActor.class);
        }
    };
    public static final Parcelable.Creator<Actor> CREATOR = new a();

    /* loaded from: classes.dex */
    static class a implements Parcelable.Creator<Actor> {
        a() {
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public Actor createFromParcel(Parcel parcel) {
            String readString = parcel.readString();
            try {
                return Actor.sActorMap.get(readString).getConstructor(String.class, Parcel.class).newInstance(readString, parcel);
            } catch (Exception e) {
                com.xiaopeng.speech.common.util.a.a(this, "createFromParcel error:", e);
                return new Actor(readString, parcel);
            }
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public Actor[] newArray(int i) {
            return new Actor[i];
        }
    }

    public Actor() {
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.b);
    }

    public Actor(String str) {
        this.b = str;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public Actor(String str, Parcel parcel) {
        this.b = str;
    }
}
