package defpackage;

import android.car.Car;
import android.car.CarNotConnectedException;
import android.car.hardware.scu.CarScuManager;
import com.xiaopeng.hiddenCam.bean.DrivingData;
import com.xiaopeng.hiddenCam.hardware.EcuEventCallback;
import com.xiaopeng.hiddenCam.state.StateCollection;
import com.xiaopeng.hiddenCam.utils.LogUtils;
import java.util.Collections;
/* compiled from: CarScuManagerWrapper.java */
/* renamed from: f4  reason: default package */
/* loaded from: classes.dex */
public class f4 {
    CarScuManager a;
    EcuEventCallback b;
    StateCollection c;

    public f4(EcuEventCallback ecuEventCallback, Car car, StateCollection stateCollection) throws CarNotConnectedException {
        this.b = ecuEventCallback;
        this.a = (CarScuManager) car.getCarManager("xp_scu");
        this.c = stateCollection;
        d();
    }

    public void a() {
        try {
            float[] locatDataWithZ = this.a.getLocatDataWithZ();
            if (locatDataWithZ.length < 10) {
                LogUtils.d("traj2.length<9");
                return;
            }
            DrivingData.getInstance().setSCU_Locat_x(locatDataWithZ[0]);
            DrivingData.getInstance().setSCU_Locat_y(locatDataWithZ[1]);
            DrivingData.getInstance().setSCU_Locat_h(locatDataWithZ[2]);
            DrivingData.getInstance().setSCU_Locat_theta(locatDataWithZ[5]);
            DrivingData.getInstance().setSCU_Locat_theta_pitch(locatDataWithZ[8]);
            DrivingData.getInstance().setSCU_Locat_theta_roll(locatDataWithZ[7]);
            DrivingData.getInstance().setSCU_Locat_CurSpd(locatDataWithZ[9]);
            DrivingData.getInstance().setSCU_Locat_S(locatDataWithZ[6]);
            this.c.setScu_locat_S(locatDataWithZ[6]);
            this.c.setScu_locat_spd(locatDataWithZ[9]);
        } catch (Exception e) {
            e.printStackTrace();
            LogUtils.e("read traj2 fail");
        }
    }

    public CarScuManager b() {
        return this.a;
    }

    public void c() {
        try {
            this.a.registerPropCallback(Collections.singletonList(560014876), this.b);
            this.a.registerPropCallback(Collections.singletonList(560014877), this.b);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void d() throws CarNotConnectedException {
        this.a.registerPropCallback(Collections.singletonList(560014942), this.b);
        this.a.registerPropCallback(Collections.singletonList(560014946), this.b);
        this.a.registerPropCallback(Collections.singletonList(560014947), this.b);
        this.a.registerPropCallback(Collections.singletonList(557852386), this.b);
        this.a.registerPropCallback(Collections.singletonList(557852270), this.b);
        this.a.registerPropCallback(Collections.singletonList(557852187), this.b);
    }

    public void e() {
        try {
            this.a.unregisterPropCallback(Collections.singletonList(560014876), this.b);
            this.a.unregisterPropCallback(Collections.singletonList(560014877), this.b);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
