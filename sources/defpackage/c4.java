package defpackage;

import android.car.Car;
import android.car.CarNotConnectedException;
import android.car.hardware.eps.CarEpsManager;
import com.xiaopeng.hiddenCam.hardware.EcuEventCallback;
/* compiled from: CarEpsManagerWrapper.java */
/* renamed from: c4  reason: default package */
/* loaded from: classes.dex */
public class c4 {
    CarEpsManager a;

    public c4(EcuEventCallback ecuEventCallback, Car car) throws CarNotConnectedException {
        this.a = (CarEpsManager) car.getCarManager("xp_eps");
    }

    public CarEpsManager a() {
        return this.a;
    }
}
