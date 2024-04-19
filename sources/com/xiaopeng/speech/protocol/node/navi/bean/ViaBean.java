package com.xiaopeng.speech.protocol.node.navi.bean;

import android.os.Parcel;
import android.os.Parcelable;
/* loaded from: classes.dex */
public class ViaBean implements Parcelable {
    public static final int WAYPOINT_TYPE_CHARGING_STATION = 1;
    public static final int WAYPOINT_TYPE_EXTRA = 0;
    public static final int WAYPOINT_TYPE_USER_POI = 2;
    public static final int WAYPOINT_TYPE_USER_ROAD = 3;
    private PoiBean pointInfo;
    private int viaType;

    /* loaded from: classes.dex */
    static class a implements Parcelable.Creator<ViaBean> {
        a() {
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public ViaBean createFromParcel(Parcel parcel) {
            return new ViaBean(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public ViaBean[] newArray(int i) {
            return new ViaBean[i];
        }
    }

    static {
        new a();
    }

    public ViaBean() {
    }

    public void a(PoiBean poiBean) {
        this.pointInfo = poiBean;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String toString() {
        return "ViaBean{pointInfo=" + this.pointInfo + ", viaType=" + this.viaType + '}';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeParcelable(this.pointInfo, i);
        parcel.writeInt(this.viaType);
    }

    public ViaBean(Parcel parcel) {
        this.pointInfo = (PoiBean) parcel.readParcelable(PoiBean.class.getClassLoader());
        this.viaType = parcel.readInt();
    }

    public void a(int i) {
        this.viaType = i;
    }
}
