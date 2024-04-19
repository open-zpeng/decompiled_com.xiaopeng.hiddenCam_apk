package com.xiaopeng.speech.protocol.node.navi.bean;

import android.os.Parcel;
import android.os.Parcelable;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class PoiLocation implements Parcelable {
    public static final Parcelable.Creator<PoiLocation> CREATOR = new a();
    private double latitude;
    private double longitude;

    /* loaded from: classes.dex */
    static class a implements Parcelable.Creator<PoiLocation> {
        a() {
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public PoiLocation createFromParcel(Parcel parcel) {
            return new PoiLocation(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public PoiLocation[] newArray(int i) {
            return new PoiLocation[i];
        }
    }

    public PoiLocation() {
    }

    public static PoiLocation a(String str) {
        PoiLocation poiLocation = new PoiLocation();
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (jSONObject.has("latitude")) {
                Double valueOf = Double.valueOf(jSONObject.optDouble("latitude"));
                if (valueOf != null) {
                    poiLocation.latitude = valueOf.doubleValue();
                } else {
                    poiLocation.latitude = 0.0d;
                }
            }
            if (jSONObject.has("longitude")) {
                Double valueOf2 = Double.valueOf(jSONObject.optDouble("longitude"));
                if (valueOf2 != null) {
                    poiLocation.longitude = valueOf2.doubleValue();
                } else {
                    poiLocation.longitude = 0.0d;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return poiLocation;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String toString() {
        return "PoiLocation{latitude=" + this.latitude + ", longitude=" + this.longitude + '}';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeDouble(this.latitude);
        parcel.writeDouble(this.longitude);
    }

    public PoiLocation(double d, double d2) {
        this.latitude = d;
        this.longitude = d2;
    }

    public PoiLocation(Parcel parcel) {
        this.latitude = parcel.readDouble();
        this.longitude = parcel.readDouble();
    }

    public JSONObject a() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("latitude", this.latitude);
        jSONObject.put("longitude", this.longitude);
        return jSONObject;
    }
}
