package defpackage;

import android.car.Car;
import android.car.CarNotConnectedException;
import android.car.hardware.imu.CarImuManager;
import com.xiaopeng.hiddenCam.bean.DrivingData;
import com.xiaopeng.hiddenCam.hardware.EcuEventCallback;
import com.xiaopeng.hiddenCam.state.ENUM.CARTYPE;
import com.xiaopeng.hiddenCam.state.ENUM.CFC;
import com.xiaopeng.hiddenCam.state.StateCollection;
/* compiled from: CarImuManagerWrapper.java */
/* renamed from: d4  reason: default package */
/* loaded from: classes.dex */
public class d4 {
    CarImuManager a;
    StateCollection b;

    public d4(EcuEventCallback ecuEventCallback, Car car, StateCollection stateCollection) throws CarNotConnectedException {
        this.a = (CarImuManager) car.getCarManager("xp_imu");
        this.b = stateCollection;
    }

    public void a() {
        if (this.b.getCfc() >= CFC.HIGH.value) {
            try {
                int navigationSatellitesNumber = this.a.getNavigationSatellitesNumber();
                int navigationSatellitesRssi = this.a.getNavigationSatellitesRssi();
                if (this.b.getCarType() == CARTYPE.E28.value) {
                    navigationSatellitesRssi /= 10;
                }
                DrivingData.getInstance().setGSV_Sat_Cnt(navigationSatellitesNumber);
                DrivingData.getInstance().setGSV_Total_Cno(navigationSatellitesRssi);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
