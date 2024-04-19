package defpackage;

import android.car.Car;
import android.car.CarNotConnectedException;
import android.car.hardware.avm.CarAvmManager;
import com.xiaopeng.hiddenCam.hardware.EcuEventCallback;
import java.util.Collections;
/* compiled from: CarAvmManagerWrapper.java */
/* renamed from: a4  reason: default package */
/* loaded from: classes.dex */
public class a4 {
    CarAvmManager a;
    EcuEventCallback b;

    public a4(EcuEventCallback ecuEventCallback, Car car) throws CarNotConnectedException {
        this.b = ecuEventCallback;
        this.a = (CarAvmManager) car.getCarManager("xp_avm");
        a();
    }

    public void a() throws CarNotConnectedException {
        this.a.registerPropCallback(Collections.singletonList(557855760), this.b);
    }
}
