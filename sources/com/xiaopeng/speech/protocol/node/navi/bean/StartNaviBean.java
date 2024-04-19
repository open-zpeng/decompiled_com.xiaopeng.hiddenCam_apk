package com.xiaopeng.speech.protocol.node.navi.bean;

import com.xiaopeng.speech.common.util.DontProguardClass;
@DontProguardClass
/* loaded from: classes.dex */
public class StartNaviBean {
    public static final int PATH_PREF_AVOID_CONGESTION = 4;
    public static final int PATH_PREF_AVOID_FEE_CONGESTION = 8;
    public static final int PATH_PREF_DEFAULT = 0;
    public static final int PATH_PREF_HIGH_SPEED = 2;
    public static final int PATH_PREF_LOW_FEE = 1;
    public static final int PATH_PREF_NO_HIGH_SPEED = 6;
    public static final int PATH_PREF_NO_HIGH_SPEED_FEE_CONGESTION = 9;
    public static final int PATH_PREF_NO_HIGH_SPEED_NO_FEE = 7;
    private int naviType;
    private int pathRef;
    private PoiBean poiBean;
    private int routeSelectRef;
    private NaviType type;

    /* loaded from: classes.dex */
    public enum NaviType {
        POI,
        WAYPOINT
    }

    public StartNaviBean() {
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    private int convertPathRef(String str) {
        char c;
        switch (str.hashCode()) {
            case -482414100:
                if (str.equals("躲避收费和拥堵")) {
                    c = 5;
                    break;
                }
                c = 65535;
                break;
            case -154630622:
                if (str.equals("不走高速躲避收费和拥堵")) {
                    c = 6;
                    break;
                }
                c = 65535;
                break;
            case 35696354:
                if (str.equals("费用少")) {
                    c = 0;
                    break;
                }
                c = 65535;
                break;
            case 631315594:
                if (str.equals("不走高速")) {
                    c = 3;
                    break;
                }
                c = 65535;
                break;
            case 1124620989:
                if (str.equals("躲避拥堵")) {
                    c = 2;
                    break;
                }
                c = 65535;
                break;
            case 1217019831:
                if (str.equals("高速优先")) {
                    c = 1;
                    break;
                }
                c = 65535;
                break;
            case 2036169147:
                if (str.equals("不走高速且避免收费")) {
                    c = 4;
                    break;
                }
                c = 65535;
                break;
            default:
                c = 65535;
                break;
        }
        switch (c) {
            case 0:
                return 1;
            case 1:
                return 2;
            case 2:
                return 4;
            case 3:
                return 6;
            case 4:
                return 7;
            case 5:
                return 8;
            case 6:
                return 9;
            default:
                return 0;
        }
    }

    public int getNaviType() {
        return this.naviType;
    }

    public int getPathRef() {
        return this.pathRef;
    }

    public PoiBean getPoiBean() {
        return this.poiBean;
    }

    public int getRouteSelectRef() {
        return this.routeSelectRef;
    }

    public NaviType getType() {
        return this.type;
    }

    public void setNaviType(int i) {
        this.naviType = i;
    }

    public void setPathRef(int i) {
        this.pathRef = i;
    }

    public void setPoiBean(PoiBean poiBean) {
        this.poiBean = poiBean;
    }

    public void setRouteSelectRef(int i) {
        this.routeSelectRef = i;
    }

    public void setType(NaviType naviType) {
        this.type = naviType;
    }

    public String toString() {
        return "StartNaviBean{poiBean=" + this.poiBean + ", naviType=" + this.naviType + ", routeSelectRef=" + this.routeSelectRef + ", pathRef='" + this.pathRef + "'}";
    }

    public StartNaviBean(PoiBean poiBean, String str, String str2) {
        this.poiBean = poiBean;
        this.pathRef = convertPathRef(str);
        if ("waypoint".equals(str2)) {
            this.type = NaviType.WAYPOINT;
        } else {
            this.type = NaviType.POI;
        }
    }
}
