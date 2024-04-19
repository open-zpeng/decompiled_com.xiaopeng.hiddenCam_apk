package com.xiaopeng.hiddenCam;

import com.xiaopeng.hiddenCam.state.ENUM.XPUREADY;
import com.xiaopeng.hiddenCam.utils.LogUtils;
import com.xiaopeng.lib.apirouter.server.IServicePublisher;
import com.xiaopeng.lib.apirouter.server.Publish;
/* compiled from: IpcRouterService.java */
/* loaded from: classes.dex */
public class a implements IServicePublisher {

    /* compiled from: IpcRouterService.java */
    /* renamed from: com.xiaopeng.hiddenCam.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0016a {
        public C0016a(int i, String str) {
        }
    }

    @Publish
    public void a(int i, String str) {
        LogUtils.d("[chamo Ipc], onReceiverData: " + str);
        new C0016a(i, str);
        if (CameraService.y.isScreen_light()) {
            LogUtils.d("[chamo Ipc], onReceiverData: " + CameraService.y.isScreen_light());
            CameraService.y.setXpu_ready_flag(XPUREADY.NOT_READY);
        }
    }
}
