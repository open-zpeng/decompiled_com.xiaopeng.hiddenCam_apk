package com.xiaopeng.hiddenCam.hardware;

import android.car.hardware.CarEcuManager;
import androidx.annotation.Keep;
import com.google.gson.Gson;
import com.xiaopeng.hiddenCam.oss.OssService;
import com.xiaopeng.hiddenCam.state.StateCollection;
import com.xiaopeng.hiddenCam.utils.LogUtils;
/* loaded from: classes.dex */
public class EcuEventCallback implements CarEcuManager.CarEcuEventCallback {
    private Integer[] a = {0, 0, 0, 0};
    private Integer[] b = {0, 0, 0, 0};
    private Float[] c;
    private Float[] d;
    private int e;
    private int f;
    OssService g;
    StateCollection h;
    m3 i;
    Gson j;

    public EcuEventCallback(OssService ossService, StateCollection stateCollection, m3 m3Var) {
        Float valueOf = Float.valueOf(0.0f);
        this.c = new Float[]{valueOf, valueOf, valueOf, valueOf, valueOf, valueOf};
        this.d = new Float[]{valueOf, valueOf, valueOf, valueOf, valueOf, valueOf};
        this.e = 0;
        this.f = 0;
        this.j = new Gson();
        this.g = ossService;
        this.h = stateCollection;
        this.i = m3Var;
    }

    /* JADX WARN: Code restructure failed: missing block: B:38:0x00e6, code lost:
        r3 = com.xiaopeng.hiddenCam.proto.HDMapMsgProto.HDMapXpuFsdApaFrontSlot.class.getDeclaredMethod("setSCULocatH", java.lang.Float.TYPE);
        r3.setAccessible(true);
        r3.invoke(r0, java.lang.Float.valueOf(com.xiaopeng.hiddenCam.bean.DrivingData.getInstance().SCU_Locat_h));
     */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x0106, code lost:
        r1 = com.xiaopeng.hiddenCam.proto.HDMapMsgProto.HDMapXpuFsdApaFrontSlot.class.getDeclaredMethod("setSCULocatS", java.lang.Float.TYPE);
        r1.setAccessible(true);
        r1.invoke(r0, java.lang.Float.valueOf(com.xiaopeng.hiddenCam.bean.DrivingData.getInstance().SCU_Locat_S));
        r14.h.fsd_slot.add(r0);
        com.xiaopeng.hiddenCam.utils.LogUtils.d("twice check");
     */
    @androidx.annotation.Keep
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void onChangeEvent(android.car.hardware.CarPropertyValue r15) {
        /*
            Method dump skipped, instructions count: 2382
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xiaopeng.hiddenCam.hardware.EcuEventCallback.onChangeEvent(android.car.hardware.CarPropertyValue):void");
    }

    @Keep
    public void onErrorEvent(int i, int i2) {
        LogUtils.e("onErrorEvent() called with: i = [" + i + "], i1 = [" + i2 + "]");
    }
}
