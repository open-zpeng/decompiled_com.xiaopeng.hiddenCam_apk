package com.xiaopeng.datalog.bean;

import android.os.SystemProperties;
import androidx.annotation.Keep;
import com.xiaopeng.lib.utils.SystemPropertyUtil;
import com.xiaopeng.lib.utils.info.BuildInfoUtils;
import java.util.List;
@Keep
/* loaded from: classes.dex */
public class LogEvent {
    private String dbcVer;
    private String device;
    private String iccid;
    private String model;
    private List<Object> msg;
    private int packageId;
    private int ref;
    private String sid;
    private String sysVer;
    private long t;
    private long uid;
    private int v = 3;
    private int vid;
    private String vin;

    /* loaded from: classes.dex */
    public enum RefType {
        CAN(2),
        CDU(1);
        
        private int b;

        RefType(int i) {
            this.b = i;
        }

        public int getRefType() {
            return this.b;
        }
    }

    /* loaded from: classes.dex */
    public enum SrcType {
        XMART_ROM(1),
        XMART_APP(2),
        XMART_THIRD_APP(3),
        ANDROID_APP(4);
        
        private int b;

        SrcType(int i) {
            this.b = i;
        }

        public static SrcType from(int i) {
            if (i != 1) {
                if (i != 2) {
                    if (i != 3) {
                        if (i == 4) {
                            return ANDROID_APP;
                        }
                        throw new IllegalArgumentException("Invalid arg:" + i);
                    }
                    return XMART_THIRD_APP;
                }
                return XMART_APP;
            }
            return XMART_ROM;
        }

        public int getSrcType() {
            return this.b;
        }
    }

    private LogEvent() {
    }

    public static LogEvent create(RefType refType) {
        LogEvent logEvent = new LogEvent();
        logEvent.setDevice(SystemPropertyUtil.getHardwareId());
        logEvent.setVin(SystemPropertyUtil.getVIN());
        logEvent.setVid(SystemPropertyUtil.getVehicleId());
        logEvent.setSysVer(getSystemVersion());
        logEvent.setSid(SystemPropertyUtil.getSoftwareId());
        logEvent.setUid(SystemPropertyUtil.getAccountUid());
        logEvent.setT(System.currentTimeMillis());
        logEvent.setRef(refType.getRefType());
        logEvent.setModel(BuildInfoUtils.getHardwareVersionCode() <= 6 ? "David 1.0" : "David 2.0");
        logEvent.setDbcVer(SystemPropertyUtil.getDBCVersion());
        logEvent.setIccid(SystemPropertyUtil.getIccid());
        return logEvent;
    }

    public static SrcType from(int i) {
        if (i != 1) {
            if (i != 2) {
                if (i != 3) {
                    if (i == 4) {
                        return SrcType.ANDROID_APP;
                    }
                    throw new IllegalArgumentException("invalid type " + i + ", must be [1, 4]");
                }
                return SrcType.XMART_THIRD_APP;
            }
            return SrcType.XMART_APP;
        }
        return SrcType.XMART_ROM;
    }

    public static String getSystemVersion() {
        return SystemProperties.get("ro.product.firmware", BuildInfoUtils.UNKNOWN);
    }

    public String getDbcVer() {
        return this.dbcVer;
    }

    public String getDevice() {
        return this.device;
    }

    public String getIccid() {
        return this.iccid;
    }

    public String getModel() {
        return this.model;
    }

    public List<Object> getMsg() {
        return this.msg;
    }

    public int getPackageId() {
        return this.packageId;
    }

    public int getRef() {
        return this.ref;
    }

    public String getSid() {
        return this.sid;
    }

    public String getSysVer() {
        return this.sysVer;
    }

    public long getT() {
        return this.t;
    }

    public long getUid() {
        return this.uid;
    }

    public int getV() {
        return this.v;
    }

    public int getVid() {
        return this.vid;
    }

    public String getVin() {
        return this.vin;
    }

    public void setDbcVer(String str) {
        this.dbcVer = str;
    }

    public void setDevice(String str) {
        this.device = str;
    }

    public void setIccid(String str) {
        this.iccid = str;
    }

    public void setModel(String str) {
        this.model = str;
    }

    public void setMsg(List<Object> list) {
        this.msg = list;
    }

    public void setPackageId(int i) {
        this.packageId = i;
    }

    public void setRef(int i) {
        this.ref = i;
    }

    public void setSid(String str) {
        this.sid = str;
    }

    public void setSysVer(String str) {
        this.sysVer = str;
    }

    public void setT(long j) {
        this.t = j;
    }

    public void setUid(long j) {
        this.uid = j;
    }

    public void setV(int i) {
        this.v = i;
    }

    public void setVid(int i) {
        this.vid = i;
    }

    public void setVin(String str) {
        this.vin = str;
    }
}
