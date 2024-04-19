package defpackage;

import android.car.Car;
import android.car.CarNotConnectedException;
import android.car.diagnostic.XpDiagnosticManager;
import com.xiaopeng.hiddenCam.hardware.EcuEventCallback;
import java.util.Collections;
/* compiled from: XpDiagnosticManagerWrapper.java */
/* renamed from: j4  reason: default package */
/* loaded from: classes.dex */
public class j4 {
    XpDiagnosticManager a;
    EcuEventCallback b;

    public j4(EcuEventCallback ecuEventCallback, Car car) throws CarNotConnectedException {
        this.b = ecuEventCallback;
        this.a = (XpDiagnosticManager) car.getCarManager("xp_diagnostic");
        a();
    }

    public void a() throws CarNotConnectedException {
        this.a.registerPropCallback(Collections.singletonList(557852274), this.b);
    }
}
