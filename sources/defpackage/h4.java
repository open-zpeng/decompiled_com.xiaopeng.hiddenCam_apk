package defpackage;

import android.car.Car;
import android.car.CarNotConnectedException;
import android.car.hardware.vcu.CarVcuManager;
import com.xiaopeng.hiddenCam.hardware.EcuEventCallback;
import java.util.Collections;
/* compiled from: CarVcuManagerWrapper.java */
/* renamed from: h4  reason: default package */
/* loaded from: classes.dex */
public class h4 {
    CarVcuManager a;
    EcuEventCallback b;

    public h4(EcuEventCallback ecuEventCallback, Car car) throws CarNotConnectedException {
        this.b = ecuEventCallback;
        this.a = (CarVcuManager) car.getCarManager("xp_vcu");
        a();
    }

    public void a() throws CarNotConnectedException {
        this.a.registerPropCallback(Collections.singletonList(557847045), this.b);
        this.a.registerPropCallback(Collections.singletonList(557847081), this.b);
        this.a.registerPropCallback(Collections.singletonList(557847079), this.b);
    }
}
