package com.xiaopeng.speech.protocol.node.record.bean;

import android.os.Parcel;
import android.os.Parcelable;
/* loaded from: classes.dex */
public class RecordErrReason implements Parcelable {
    public static final Parcelable.Creator<RecordErrReason> CREATOR = new a();
    public String msg;

    /* loaded from: classes.dex */
    static class a implements Parcelable.Creator<RecordErrReason> {
        a() {
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public RecordErrReason createFromParcel(Parcel parcel) {
            return new RecordErrReason(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public RecordErrReason[] newArray(int i) {
            return new RecordErrReason[i];
        }
    }

    public RecordErrReason() {
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.msg);
    }

    protected RecordErrReason(Parcel parcel) {
        this.msg = parcel.readString();
    }
}
