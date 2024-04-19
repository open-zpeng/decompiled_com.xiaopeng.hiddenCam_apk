package com.xiaopeng.speech.protocol.node.navi.bean;

import android.os.Parcel;
import android.os.Parcelable;
import com.xiaopeng.lib.apirouter.ClientConstants;
import com.xiaopeng.speech.common.util.DontProguardClass;
import org.json.JSONException;
import org.json.JSONObject;
@DontProguardClass
/* loaded from: classes.dex */
public class PoiBean implements Parcelable {
    protected static final Parcelable.Creator<PoiBean> CREATOR = new a();
    private String address;
    private int category;
    private String cityName;
    private String displayDistance;
    private long distance;
    private String dst_name;
    private PoiLocation entrLocation;
    private PoiLocation exitLocation;
    private double latitude;
    private double longitude;
    private String name;
    private double naviLat;
    private double naviLon;
    private PoiExtraBean poiExtra;
    private String poiId;
    private int scenario;
    private String source;
    private String telephone;
    private String typeCode;

    /* loaded from: classes.dex */
    static class a implements Parcelable.Creator<PoiBean> {
        a() {
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public PoiBean createFromParcel(Parcel parcel) {
            return new PoiBean(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public PoiBean[] newArray(int i) {
            return new PoiBean[i];
        }
    }

    public PoiBean() {
        this.entrLocation = new PoiLocation(0.0d, 0.0d);
        this.exitLocation = new PoiLocation(0.0d, 0.0d);
    }

    public static PoiBean fromJson(String str) {
        try {
            PoiBean poiBean = new PoiBean();
            JSONObject jSONObject = new JSONObject(str);
            if (jSONObject.has("poiId")) {
                poiBean.poiId = jSONObject.optString("poiId");
            }
            if (jSONObject.has(ClientConstants.ALIAS.P_NAME)) {
                poiBean.name = jSONObject.optString(ClientConstants.ALIAS.P_NAME);
            }
            if (jSONObject.has("dst_name")) {
                poiBean.dst_name = jSONObject.optString("dst_name");
            }
            if (jSONObject.has("latitude")) {
                poiBean.latitude = jSONObject.optDouble("latitude", 0.0d);
            }
            if (jSONObject.has("longitude")) {
                poiBean.longitude = jSONObject.optDouble("longitude", 0.0d);
            }
            if (jSONObject.has("address")) {
                poiBean.address = jSONObject.optString("address");
            }
            if (jSONObject.has("distance")) {
                poiBean.distance = jSONObject.optLong("distance");
            }
            if (jSONObject.has("displayDistance")) {
                poiBean.displayDistance = jSONObject.optString("displayDistance");
            }
            if (jSONObject.has("tel")) {
                poiBean.telephone = jSONObject.optString("tel");
            }
            if (jSONObject.has("category")) {
                poiBean.category = jSONObject.optInt("category");
            }
            if (jSONObject.has("naviLon")) {
                poiBean.naviLon = jSONObject.optDouble("naviLon", 0.0d);
            }
            if (jSONObject.has("naviLat")) {
                poiBean.naviLat = jSONObject.optDouble("naviLat", 0.0d);
            }
            if (jSONObject.has("typeCode")) {
                poiBean.typeCode = jSONObject.optString("typeCode");
            }
            if (jSONObject.has("source")) {
                poiBean.source = jSONObject.optString("source");
            }
            if (jSONObject.has("scenario")) {
                poiBean.scenario = jSONObject.optInt("scenario");
            }
            if (jSONObject.has("entrLocation")) {
                poiBean.entrLocation = PoiLocation.a(jSONObject.optString("entrLocation"));
            }
            if (jSONObject.has("exitLocation")) {
                poiBean.exitLocation = PoiLocation.a(jSONObject.optString("exitLocation"));
            }
            if (jSONObject.has("poiExtra")) {
                poiBean.poiExtra = PoiExtraBean.fromJson(jSONObject.optString("poiExtra"));
            }
            return poiBean;
        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static PoiBean gcj02_To_Bd09(double d, double d2) {
        double sqrt = Math.sqrt((d2 * d2) + (d * d)) + (Math.sin(d * 52.35987755982988d) * 2.0E-5d);
        double atan2 = Math.atan2(d, d2) + (Math.cos(d2 * 52.35987755982988d) * 3.0E-6d);
        PoiBean poiBean = new PoiBean();
        poiBean.setLatitude((sqrt * Math.sin(atan2)) + 0.006d);
        poiBean.setLongitude((Math.cos(atan2) * sqrt) + 0.0065d);
        return poiBean;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String getAddress() {
        return String.valueOf(this.address);
    }

    public int getCategory() {
        return this.category;
    }

    public String getCityName() {
        return String.valueOf(this.cityName);
    }

    public String getDisplayDistance() {
        return String.valueOf(this.displayDistance);
    }

    public long getDistance() {
        return this.distance;
    }

    public String getDstName() {
        return this.dst_name;
    }

    public PoiLocation getEntrLocation() {
        return this.entrLocation;
    }

    public PoiLocation getExitLocation() {
        return this.exitLocation;
    }

    public double getLatitude() {
        return this.latitude;
    }

    public double getLongitude() {
        return this.longitude;
    }

    public String getName() {
        return String.valueOf(this.name);
    }

    public double getNaviLat() {
        return this.naviLat;
    }

    public double getNaviLon() {
        return this.naviLon;
    }

    public PoiExtraBean getPoiExtra() {
        return this.poiExtra;
    }

    public String getPoiId() {
        return String.valueOf(this.poiId);
    }

    public int getScenario() {
        return this.scenario;
    }

    public String getSource() {
        return this.source;
    }

    public String getTelephone() {
        return String.valueOf(this.telephone);
    }

    public String getTypeCode() {
        return this.typeCode;
    }

    public void setAddress(String str) {
        this.address = str;
    }

    public void setCategory(int i) {
        this.category = i;
    }

    public void setCityName(String str) {
        this.cityName = str;
    }

    public void setDisplayDistance(String str) {
        this.displayDistance = str;
    }

    public void setDistance(long j) {
        this.distance = j;
    }

    public void setDstName(String str) {
        this.dst_name = str;
    }

    public void setEntrLocation(PoiLocation poiLocation) {
        this.entrLocation = poiLocation;
    }

    public void setExitLocation(PoiLocation poiLocation) {
        this.exitLocation = poiLocation;
    }

    public void setLatitude(double d) {
        this.latitude = d;
    }

    public void setLongitude(double d) {
        this.longitude = d;
    }

    public void setName(String str) {
        this.name = str;
    }

    public void setNaviLat(double d) {
        this.naviLat = d;
    }

    public void setNaviLon(double d) {
        this.naviLon = d;
    }

    public void setPoiExtra(PoiExtraBean poiExtraBean) {
        this.poiExtra = poiExtraBean;
    }

    public void setPoiId(String str) {
        this.poiId = str;
    }

    public void setScenario(int i) {
        this.scenario = i;
    }

    public void setSource(String str) {
        this.source = str;
    }

    public void setTelephone(String str) {
        this.telephone = str;
    }

    public void setTypeCode(String str) {
        this.typeCode = str;
    }

    public JSONObject toJson() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put(ClientConstants.ALIAS.P_NAME, getName());
        jSONObject.put("dst_name", getDstName());
        jSONObject.put("latitude", this.latitude);
        jSONObject.put("longitude", this.longitude);
        jSONObject.put("address", this.address);
        jSONObject.put("distance", this.distance);
        jSONObject.put("displayDistance", this.displayDistance);
        jSONObject.put("tel", this.telephone);
        jSONObject.put("category", this.category);
        jSONObject.put("poiId", this.poiId);
        jSONObject.put("naviLon", this.naviLon);
        jSONObject.put("naviLat", this.naviLat);
        jSONObject.put("typeCode", this.typeCode);
        jSONObject.put("source", this.source);
        jSONObject.put("scenario", this.scenario);
        PoiLocation poiLocation = this.entrLocation;
        if (poiLocation != null) {
            jSONObject.put("entrLocation", poiLocation.a());
        }
        PoiLocation poiLocation2 = this.exitLocation;
        if (poiLocation2 != null) {
            jSONObject.put("exitLocation", poiLocation2.a());
        }
        PoiExtraBean poiExtraBean = this.poiExtra;
        if (poiExtraBean != null) {
            jSONObject.put("poiExtra", poiExtraBean.toJson());
        }
        return jSONObject;
    }

    public String toString() {
        return "PoiBean{name='" + this.name + "', dst_name='" + this.dst_name + "', poiId='" + this.poiId + "', latitude=" + this.latitude + ", longitude=" + this.longitude + ", address='" + this.address + "', distance=" + this.distance + ", telephone='" + this.telephone + "', displayDistance='" + this.displayDistance + "', cityName='" + this.cityName + "', naviLon=" + this.naviLon + ", naviLat=" + this.naviLat + ", category=" + this.category + ", typeCode='" + this.typeCode + "', source='" + this.source + "', scenario='" + this.scenario + "', entrLocation=" + this.entrLocation + ", exitLocation=" + this.exitLocation + ", poiExtra=" + this.poiExtra + '}';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.name);
        parcel.writeString(this.dst_name);
        parcel.writeString(this.poiId);
        parcel.writeDouble(this.latitude);
        parcel.writeDouble(this.longitude);
        parcel.writeString(this.address);
        parcel.writeLong(this.distance);
        parcel.writeString(this.telephone);
        parcel.writeString(this.displayDistance);
        parcel.writeString(this.cityName);
        parcel.writeInt(this.category);
        parcel.writeDouble(this.naviLon);
        parcel.writeDouble(this.naviLat);
        parcel.writeString(this.typeCode);
        parcel.writeString(this.source);
        parcel.writeInt(this.scenario);
        parcel.writeParcelable(this.entrLocation, 0);
        parcel.writeParcelable(this.exitLocation, 0);
    }

    public PoiBean(Parcel parcel) {
        this.entrLocation = new PoiLocation(0.0d, 0.0d);
        this.exitLocation = new PoiLocation(0.0d, 0.0d);
        this.name = parcel.readString();
        this.dst_name = parcel.readString();
        this.poiId = parcel.readString();
        this.latitude = parcel.readDouble();
        this.longitude = parcel.readDouble();
        this.address = parcel.readString();
        this.distance = parcel.readLong();
        this.telephone = parcel.readString();
        this.displayDistance = parcel.readString();
        this.cityName = parcel.readString();
        this.category = parcel.readInt();
        this.naviLon = parcel.readDouble();
        this.naviLat = parcel.readDouble();
        this.typeCode = parcel.readString();
        this.source = parcel.readString();
        this.scenario = parcel.readInt();
        this.entrLocation = (PoiLocation) parcel.readParcelable(PoiLocation.class.getClassLoader());
        this.exitLocation = (PoiLocation) parcel.readParcelable(PoiLocation.class.getClassLoader());
        this.poiExtra = (PoiExtraBean) parcel.readParcelable(PoiExtraBean.class.getClassLoader());
    }
}
