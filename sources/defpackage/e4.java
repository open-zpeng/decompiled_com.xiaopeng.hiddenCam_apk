package defpackage;

import android.car.Car;
import android.car.CarNotConnectedException;
import android.car.hardware.mcu.CarMcuManager;
import com.xiaopeng.hiddenCam.hardware.EcuEventCallback;
import java.util.Collections;
/* compiled from: CarMcuManagerWrapper.java */
/* renamed from: e4  reason: default package */
/* loaded from: classes.dex */
public class e4 {
    CarMcuManager a;
    EcuEventCallback b;

    public e4(EcuEventCallback ecuEventCallback, Car car) throws CarNotConnectedException {
        this.b = ecuEventCallback;
        this.a = (CarMcuManager) car.getCarManager("xp_mcu");
        b();
    }

    public CarMcuManager a() {
        return this.a;
    }

    public void b() throws CarNotConnectedException {
        this.a.registerPropCallback(Collections.singletonList(557847561), this.b);
    }
}
