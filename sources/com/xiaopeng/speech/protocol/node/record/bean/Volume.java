package com.xiaopeng.speech.protocol.node.record.bean;

import android.os.Parcel;
import android.os.Parcelable;
/* loaded from: classes.dex */
public class Volume implements Parcelable {
    public static final Parcelable.Creator<Volume> CREATOR = new a();
    public double volume;

    /* loaded from: classes.dex */
    static class a implements Parcelable.Creator<Volume> {
        a() {
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public Volume createFromParcel(Parcel parcel) {
            return new Volume(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public Volume[] newArray(int i) {
            return new Volume[i];
        }
    }

    public Volume() {
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeDouble(this.volume);
    }

    protected Volume(Parcel parcel) {
        this.volume = parcel.readDouble();
    }
}
