package com.xiaopeng.speech.protocol.node.navi.bean;

import android.text.TextUtils;
import com.xiaopeng.speech.common.util.DontProguardClass;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
@DontProguardClass
/* loaded from: classes.dex */
public class PathBean {
    private PoiBean destPoint;
    private int distance;
    private int naviType;
    private String rawAmapJson;
    private int routeSelectRef;
    private PoiBean startPoint;
    private int strategy;
    private int time;
    private int toll;
    private ArrayList<ViaBean> viaPoints;

    public static PathBean fromJson(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            JSONObject optJSONObject = new JSONObject(str).optJSONObject("pathBean");
            if (optJSONObject != null) {
                PathBean pathBean = new PathBean();
                pathBean.startPoint = PoiBean.fromJson(optJSONObject.optString("startPoint"));
                pathBean.destPoint = PoiBean.fromJson(optJSONObject.optString("destPoint"));
                pathBean.strategy = optJSONObject.optInt("strategy");
                pathBean.distance = optJSONObject.optInt("distance");
                pathBean.time = optJSONObject.optInt("time");
                pathBean.toll = optJSONObject.optInt("toll");
                pathBean.rawAmapJson = optJSONObject.optString("rawAmapJson");
                pathBean.naviType = optJSONObject.optInt("naviType");
                pathBean.routeSelectRef = optJSONObject.optInt("routeSelectRef");
                JSONArray optJSONArray = optJSONObject.optJSONArray("viaPoints");
                if (optJSONArray != null && optJSONArray.length() > 0) {
                    pathBean.viaPoints = new ArrayList<>(optJSONArray.length());
                    for (int i = 0; i < optJSONArray.length(); i++) {
                        JSONObject jSONObject = optJSONArray.getJSONObject(i);
                        ViaBean viaBean = new ViaBean();
                        viaBean.a(PoiBean.fromJson(jSONObject.optString("pointInfo")));
                        viaBean.a(jSONObject.optInt("viaType"));
                        pathBean.viaPoints.add(viaBean);
                    }
                }
                return pathBean;
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return null;
    }

    public PoiBean getDestPoint() {
        return this.destPoint;
    }

    public int getDistance() {
        return this.distance;
    }

    public int getNaviType() {
        return this.naviType;
    }

    public String getRawAmapJson() {
        return this.rawAmapJson;
    }

    public int getRouteSelectRef() {
        return this.routeSelectRef;
    }

    public PoiBean getStartPoint() {
        return this.startPoint;
    }

    public int getStrategy() {
        return this.strategy;
    }

    public int getTime() {
        return this.time;
    }

    public int getToll() {
        return this.toll;
    }

    public ArrayList<ViaBean> getViaPoints() {
        return this.viaPoints;
    }

    public void setDestPoint(PoiBean poiBean) {
        this.destPoint = poiBean;
    }

    public void setDistance(int i) {
        this.distance = i;
    }

    public void setNaviType(int i) {
        this.naviType = i;
    }

    public void setRawAmapJson(String str) {
        this.rawAmapJson = str;
    }

    public void setRouteSelectRef(int i) {
        this.routeSelectRef = i;
    }

    public void setStartPoint(PoiBean poiBean) {
        this.startPoint = poiBean;
    }

    public void setStrategy(int i) {
        this.strategy = i;
    }

    public void setTime(int i) {
        this.time = i;
    }

    public void setToll(int i) {
        this.toll = i;
    }

    public void setViaPoints(ArrayList<ViaBean> arrayList) {
        this.viaPoints = arrayList;
    }

    public String toString() {
        return "PathBean{destPoint=" + this.destPoint + ", viaPoints=" + this.viaPoints + ", strategy=" + this.strategy + ", distance=" + this.distance + ", time=" + this.time + ", toll=" + this.toll + ", naviType=" + this.naviType + ", routeSelectRef=" + this.routeSelectRef + ", rawAmapJson='" + this.rawAmapJson + "'}";
    }
}
