package com.xiaopeng.speech.protocol.node.record.bean;

import android.os.Parcel;
import android.os.Parcelable;
/* loaded from: classes.dex */
public class AsrResult implements Parcelable {
    public static final Parcelable.Creator<AsrResult> CREATOR = new a();
    public String filePath;
    public String text;
    public String token;

    /* loaded from: classes.dex */
    static class a implements Parcelable.Creator<AsrResult> {
        a() {
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public AsrResult createFromParcel(Parcel parcel) {
            return new AsrResult(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public AsrResult[] newArray(int i) {
            return new AsrResult[i];
        }
    }

    public AsrResult() {
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.text);
    }

    protected AsrResult(Parcel parcel) {
        this.text = parcel.readString();
    }
}
