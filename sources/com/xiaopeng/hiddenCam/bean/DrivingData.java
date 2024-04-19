package com.xiaopeng.hiddenCam.bean;

import android.location.GnssStatus;
import android.location.GpsSatellite;
import android.location.GpsStatus;
import com.google.gson.GsonBuilder;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class DrivingData {
    private static DrivingData _instance;
    public float ARR_CCP1_y1;
    public float ARR_CCP1_y2;
    public int ARR_DIR_CCP;
    public int ARR_NUM_CCP;
    public int AVM_Slot_Type;
    public float A_ARR_CCP1_x1;
    public float A_ARR_CCP1_x2;
    public int BCM_DriverDroorLockSt;
    public float Bump_heading;
    public float Bump_s;
    public float Bump_x;
    public float Bump_y;
    public float CDU_SCU_GPS_ALtitude;
    public float CDU_SCU_GPS_Accuracy;
    public float CDU_SCU_GPS_LONG_itude;
    public float CDU_SCU_GPS_Latitude;
    public int CDU_Slot_Type;
    public float EPS_SAS_SteeringAngle;
    public float GPS_Velocity;
    public float GSV_Sat_Cnt;
    public float GSV_Total_Cno;
    public float SCU_Locat_CurSpd;
    public float SCU_Locat_S;
    public float SCU_Locat_h;
    public float SCU_Locat_theta;
    public float SCU_Locat_theta_pitch;
    public float SCU_Locat_theta_roll;
    public float SCU_Locat_x;
    public float SCU_Locat_y;
    public float SCU_ParkingPt_Far_X;
    public float SCU_ParkingPt_Far_Y;
    public float SCU_ParkingPt_NearFront_X;
    public float SCU_ParkingPt_NearFront_Y;
    public float SCU_ParkingPt_NearRear_X;
    public float SCU_ParkingPt_NearRear_Y;
    public float SCU_URadar_Dist_FSL;
    public float SCU_URadar_Dist_FSR;
    public float SCU_URadar_Dist_RSL;
    public float SCU_URadar_Dist_RSR;
    public int Tbox_rsrp;
    public int VCU_CurrentGearLev;
    public int XPUSCUSlotIndex;
    public int XPU_Brightness;
    public float XPU_PkPtFarFrontX;
    public float XPU_PkPtFarFrontY;
    public float XPU_PkPtNearFrontX;
    public float XPU_PkPtNearFrontY;
    public float XPU_PkPtNearRearX;
    public float XPU_PkPtNearRearY;
    public String XPU_PkText;
    public float XPU_PkTextCenterX;
    public float XPU_PkTextCenterY;
    public float XPU_PkTextConf;
    public float XPU_PkTextSlopeX;
    public float XPU_PkTextSlopeY;
    public String gsv_info;
    public int power_Model;

    /* loaded from: classes.dex */
    public class GSV {
        public float az;
        public float cno;
        public float elv;
        public String svid;

        public GSV() {
        }
    }

    public DrivingData(float f) {
        this.SCU_Locat_x = f;
    }

    private float calcuateleY(float f, float f2) {
        return this.SCU_ParkingPt_NearRear_Y + ((float) (f * Math.sin(f2)));
    }

    private float calculateEx(float f, float f2) {
        return this.SCU_ParkingPt_NearRear_X + ((float) (f * Math.cos(f2)));
    }

    public static DrivingData getInstance() {
        if (_instance == null) {
            _instance = new DrivingData();
        }
        return _instance;
    }

    public int getPower_Model() {
        return this.power_Model;
    }

    public void init(float f, float f2, float f3, float f4, float f5, float f6, float f7, float f8, float f9, float f10, float f11, int i, int i2, int i3, float f12, int i4, int i5, float f13, float f14, float f15, float f16, String str) {
        this.SCU_Locat_x = f;
        this.SCU_Locat_y = f2;
        this.SCU_Locat_theta = f3;
        this.SCU_Locat_S = f4;
        this.SCU_Locat_CurSpd = f5;
        this.SCU_Locat_theta_roll = f6;
        this.SCU_Locat_theta_pitch = f7;
        this.SCU_ParkingPt_NearRear_X = f8;
        this.SCU_ParkingPt_NearRear_Y = f9;
        this.SCU_ParkingPt_NearFront_X = f10;
        this.SCU_ParkingPt_NearFront_Y = f11;
        this.AVM_Slot_Type = i;
        this.CDU_Slot_Type = i2;
        this.VCU_CurrentGearLev = i3;
        this.EPS_SAS_SteeringAngle = f12;
        this.BCM_DriverDroorLockSt = i4;
        this.power_Model = i5;
        this.CDU_SCU_GPS_LONG_itude = f13;
        this.CDU_SCU_GPS_Latitude = f14;
        this.CDU_SCU_GPS_ALtitude = f15;
        this.CDU_SCU_GPS_Accuracy = f16;
    }

    public void setARR_CCP1_y1(float f) {
        this.ARR_CCP1_y1 = f;
    }

    public void setARR_CCP1_y2(float f) {
        this.ARR_CCP1_y2 = f;
    }

    public void setARR_DIR_CCP(int i) {
        this.ARR_DIR_CCP = i;
    }

    public void setARR_NUM_CCP(int i) {
        this.ARR_NUM_CCP = i;
    }

    public void setAVM_Slot_Type(int i) {
        this.AVM_Slot_Type = i;
    }

    public void setA_ARR_CCP1_x1(float f) {
        this.A_ARR_CCP1_x1 = f;
    }

    public void setA_ARR_CCP1_x2(float f) {
        this.A_ARR_CCP1_x2 = f;
    }

    public void setBCM_DriverDroorLockSt(int i) {
        this.BCM_DriverDroorLockSt = i;
    }

    public void setBump_heading(float f) {
        this.Bump_heading = f;
    }

    public void setBump_s(float f) {
        this.Bump_s = f;
    }

    public void setBump_x(float f) {
        this.Bump_x = f;
    }

    public void setBump_y(float f) {
        this.Bump_y = f;
    }

    public void setCDU_SCU_GPS_ALtitude(float f) {
        this.CDU_SCU_GPS_ALtitude = f;
    }

    public void setCDU_SCU_GPS_Accuracy(float f) {
        this.CDU_SCU_GPS_Accuracy = f;
    }

    public void setCDU_SCU_GPS_LONG_itude(float f) {
        this.CDU_SCU_GPS_LONG_itude = f;
    }

    public void setCDU_SCU_GPS_Latitude(float f) {
        this.CDU_SCU_GPS_Latitude = f;
    }

    public void setCDU_Slot_Type(int i) {
        this.CDU_Slot_Type = i;
    }

    public void setEPS_SAS_SteeringAngle(float f) {
        this.EPS_SAS_SteeringAngle = f;
    }

    public void setGPS_Velocity(float f) {
        this.GPS_Velocity = f;
    }

    public void setGSV_Sat_Cnt(float f) {
        this.GSV_Sat_Cnt = f;
    }

    public void setGSV_Total_Cno(float f) {
        this.GSV_Total_Cno = f;
    }

    public void setGSV_info(GpsStatus gpsStatus) {
        Iterable<GpsSatellite> satellites;
        if (gpsStatus == null || (satellites = gpsStatus.getSatellites()) == null) {
            return;
        }
        new ArrayList();
        float f = 0.0f;
        String str = "[";
        for (GpsSatellite gpsSatellite : satellites) {
            int prn = gpsSatellite.getPrn();
            float elevation = gpsSatellite.getElevation();
            float azimuth = gpsSatellite.getAzimuth();
            float snr = gpsSatellite.getSnr();
            if (gpsSatellite.usedInFix()) {
                f += 1.0f;
            }
            str = str + "{\"az\":" + azimuth + ",\"cno\":" + snr + ",\"elv\":" + elevation + ",\"svid\":" + prn + "}";
        }
        this.gsv_info = str + "]";
        setGSV_Sat_Cnt(f);
    }

    public void setGsv_info(GnssStatus gnssStatus) {
        if (gnssStatus != null) {
            int satelliteCount = gnssStatus.getSatelliteCount();
            ArrayList arrayList = new ArrayList();
            for (int i = 0; i < satelliteCount; i++) {
                int svid = gnssStatus.getSvid(i);
                float elevationDegrees = gnssStatus.getElevationDegrees(i);
                float azimuthDegrees = gnssStatus.getAzimuthDegrees(i);
                float cn0DbHz = gnssStatus.getCn0DbHz(i);
                GSV gsv = new GSV();
                gsv.svid = svid + "";
                gsv.elv = elevationDegrees;
                gsv.az = azimuthDegrees;
                gsv.cno = cn0DbHz;
                arrayList.add(gsv);
            }
            if (arrayList.size() > 0) {
                this.gsv_info = new GsonBuilder().create().toJson(arrayList);
            }
        }
    }

    public void setPowerModel(int i) {
        this.power_Model = i;
    }

    public void setSCU_Locat_CurSpd(float f) {
        this.SCU_Locat_CurSpd = f;
    }

    public void setSCU_Locat_S(float f) {
        this.SCU_Locat_S = f;
    }

    public void setSCU_Locat_h(float f) {
        this.SCU_Locat_h = f;
    }

    public void setSCU_Locat_theta(float f) {
        this.SCU_Locat_theta = f;
    }

    public void setSCU_Locat_theta_pitch(float f) {
        this.SCU_Locat_theta_pitch = f;
    }

    public void setSCU_Locat_theta_roll(float f) {
        this.SCU_Locat_theta_roll = f;
    }

    public void setSCU_Locat_x(float f) {
        this.SCU_Locat_x = f;
    }

    public void setSCU_Locat_y(float f) {
        this.SCU_Locat_y = f;
    }

    public void setSCU_ParkingPt_Far_X(float f) {
        this.SCU_ParkingPt_Far_X = f;
    }

    public void setSCU_ParkingPt_Far_Y(float f) {
        this.SCU_ParkingPt_Far_Y = f;
    }

    public void setSCU_ParkingPt_NearFront_X(float f) {
        this.SCU_ParkingPt_NearFront_X = f;
    }

    public void setSCU_ParkingPt_NearFront_Y(float f) {
        this.SCU_ParkingPt_NearFront_Y = f;
    }

    public void setSCU_ParkingPt_NearRear_X(float f) {
        this.SCU_ParkingPt_NearRear_X = f;
    }

    public void setSCU_ParkingPt_NearRear_Y(float f) {
        this.SCU_ParkingPt_NearRear_Y = f;
    }

    public void setSCU_URadar_Dist_FSL(float f) {
        this.SCU_URadar_Dist_FSL = f;
    }

    public void setSCU_URadar_Dist_FSR(float f) {
        this.SCU_URadar_Dist_FSR = f;
    }

    public void setSCU_URadar_Dist_RSL(float f) {
        this.SCU_URadar_Dist_RSL = f;
    }

    public void setSCU_URadar_Dist_RSR(float f) {
        this.SCU_URadar_Dist_RSR = f;
    }

    public void setTbox_rsrp(int i) {
        this.Tbox_rsrp = i;
    }

    public void setVCU_CurrentGearLev(int i) {
        this.VCU_CurrentGearLev = i;
    }

    public void setXPUSCUSlotIndex(int i) {
        this.XPUSCUSlotIndex = i;
    }

    public void setXPU_Brightness(int i) {
        this.XPU_Brightness = i;
    }

    public void setXPU_PkPtFarFrontX(float f) {
        this.XPU_PkPtFarFrontX = f;
    }

    public void setXPU_PkPtFarFrontY(float f) {
        this.XPU_PkPtFarFrontY = f;
    }

    public void setXPU_PkPtNearFrontX(float f) {
        this.XPU_PkPtNearFrontX = f;
    }

    public void setXPU_PkPtNearFrontY(float f) {
        this.XPU_PkPtNearFrontY = f;
    }

    public void setXPU_PkPtNearRearX(float f) {
        this.XPU_PkPtNearRearX = f;
    }

    public void setXPU_PkPtNearRearY(float f) {
        this.XPU_PkPtNearRearY = f;
    }

    public void setXPU_PkText(String str) {
        this.XPU_PkText = str;
    }

    public void setXPU_PkTextCenterX(float f) {
        this.XPU_PkTextCenterX = f;
    }

    public void setXPU_PkTextCenterY(float f) {
        this.XPU_PkTextCenterY = f;
    }

    public void setXPU_PkTextConf(float f) {
        this.XPU_PkTextConf = f;
    }

    public void setXPU_PkTextSlopeX(float f) {
        this.XPU_PkTextSlopeX = f;
    }

    public void setXPU_PkTextSlopeY(float f) {
        this.XPU_PkTextSlopeY = f;
    }

    public String toString() {
        return "DrivingData{SCU_Locat_x=" + this.SCU_Locat_x + ", SCU_Locat_y=" + this.SCU_Locat_y + ", SCU_Locat_h=" + this.SCU_Locat_h + ", SCU_Locat_theta=" + this.SCU_Locat_theta + ", SCU_Locat_S=" + this.SCU_Locat_S + ", SCU_Locat_CurSpd=" + this.SCU_Locat_CurSpd + ", SCU_Locat_theta_roll=" + this.SCU_Locat_theta_roll + ", SCU_Locat_theta_pitch=" + this.SCU_Locat_theta_pitch + ", SCU_ParkingPt_NearRear_X=" + this.SCU_ParkingPt_NearRear_X + ", SCU_ParkingPt_NearRear_Y=" + this.SCU_ParkingPt_NearRear_Y + ", SCU_ParkingPt_NearFront_X=" + this.SCU_ParkingPt_NearFront_X + ", SCU_ParkingPt_NearFront_Y=" + this.SCU_ParkingPt_NearFront_Y + ", SCU_ParkingPt_Far_X=" + this.SCU_ParkingPt_Far_X + ", SCU_ParkingPt_Far_Y=" + this.SCU_ParkingPt_Far_Y + ", AVM_Slot_Type=" + this.AVM_Slot_Type + ", CDU_Slot_Type=" + this.CDU_Slot_Type + ", VCU_CurrentGearLev=" + this.VCU_CurrentGearLev + ", EPS_SAS_SteeringAngle=" + this.EPS_SAS_SteeringAngle + ", BCM_DriverDroorLockSt=" + this.BCM_DriverDroorLockSt + ", CDU_SCU_GPS_LONG_itude=" + this.CDU_SCU_GPS_LONG_itude + ", CDU_SCU_GPS_Latitude=" + this.CDU_SCU_GPS_Latitude + ", CDU_SCU_GPS_ALtitude=" + this.CDU_SCU_GPS_ALtitude + ", CDU_SCU_GPS_Accuracy=" + this.CDU_SCU_GPS_Accuracy + ", GPS_Velocity=" + this.GPS_Velocity + ", SCU_URadar_Dist_FSL=" + this.SCU_URadar_Dist_FSL + ", SCU_URadar_Dist_FSR=" + this.SCU_URadar_Dist_FSR + ", SCU_URadar_Dist_RSL=" + this.SCU_URadar_Dist_RSL + ", SCU_URadar_Dist_RSR=" + this.SCU_URadar_Dist_RSR + ", GSV_Sat_Cnt=" + this.GSV_Sat_Cnt + ", GSV_Total_Cno=" + this.GSV_Total_Cno + ", Bump_x=" + this.Bump_x + ", Bump_y=" + this.Bump_y + ", Bump_s=" + this.Bump_s + ", Bump_heading=" + this.Bump_heading + ", Tbox_rsrp=" + this.Tbox_rsrp + ", XPU_Brightness=" + this.XPU_Brightness + '}';
    }

    private DrivingData() {
    }
}
