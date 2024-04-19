package defpackage;

import android.car.Car;
import android.car.CarNotConnectedException;
import android.car.hardware.tbox.CarTboxManager;
import com.xiaopeng.hiddenCam.hardware.EcuEventCallback;
import java.util.Collections;
/* compiled from: CarTboxManagerWrapper.java */
/* renamed from: g4  reason: default package */
/* loaded from: classes.dex */
public class g4 {
    CarTboxManager a;
    EcuEventCallback b;

    public g4(EcuEventCallback ecuEventCallback, Car car) throws CarNotConnectedException {
        this.b = ecuEventCallback;
        this.a = (CarTboxManager) car.getCarManager("xp_tbox");
        a();
    }

    public void a() throws CarNotConnectedException {
        this.a.registerPropCallback(Collections.singletonList(554700817), this.b);
    }
}
