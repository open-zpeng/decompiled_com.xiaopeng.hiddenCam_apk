package com.xiaopeng.ipc;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
/* loaded from: classes.dex */
public class IpcMessage implements Parcelable {
    public static final Parcelable.Creator<IpcMessage> CREATOR = new a();
    String b;
    int c;
    Bundle d;

    /* loaded from: classes.dex */
    static class a implements Parcelable.Creator<IpcMessage> {
        a() {
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public IpcMessage createFromParcel(Parcel parcel) {
            return new IpcMessage(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public IpcMessage[] newArray(int i) {
            return new IpcMessage[i];
        }
    }

    public IpcMessage() {
    }

    public void a(String str) {
        this.b = str;
    }

    public String b() {
        return this.b;
    }

    public Bundle c() {
        return this.d;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.b);
        parcel.writeInt(this.c);
        parcel.writeBundle(this.d);
    }

    protected IpcMessage(Parcel parcel) {
        this.b = parcel.readString();
        this.c = parcel.readInt();
        this.d = parcel.readBundle();
    }

    public int a() {
        return this.c;
    }

    public void a(int i) {
        this.c = i;
    }

    public void a(Bundle bundle) {
        this.d = bundle;
    }
}
