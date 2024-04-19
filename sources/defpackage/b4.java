package defpackage;

import android.car.Car;
import android.car.CarNotConnectedException;
import android.car.hardware.bcm.CarBcmManager;
import com.xiaopeng.hiddenCam.hardware.EcuEventCallback;
import java.util.Collections;
/* compiled from: CarBcmManagerWrapper.java */
/* renamed from: b4  reason: default package */
/* loaded from: classes.dex */
public class b4 {
    CarBcmManager a;
    EcuEventCallback b;

    public b4(EcuEventCallback ecuEventCallback, Car car) throws CarNotConnectedException {
        this.b = ecuEventCallback;
        this.a = (CarBcmManager) car.getCarManager("xp_bcm");
        a();
    }

    public void a() throws CarNotConnectedException {
        this.a.registerPropCallback(Collections.singletonList(557849609), this.b);
    }
}
