package com.xiaopeng.hiddenCam.speechmodel;

import com.xiaopeng.hiddenCam.CameraService;
import com.xiaopeng.hiddenCam.utils.LogUtils;
import com.xiaopeng.speech.protocol.node.xpu.a;
/* loaded from: classes.dex */
public class XpuSpeechListener implements a {

    /* loaded from: classes.dex */
    private static class LazyHolder {
        private static final XpuSpeechListener INSTANCE = new XpuSpeechListener();

        private LazyHolder() {
        }
    }

    public static XpuSpeechListener getInstance() {
        return LazyHolder.INSTANCE;
    }

    public void laneChange(int i) {
        LogUtils.d("get lanechange signal: " + i);
        try {
            CameraService.z.b().setVoiceLaneChangeCommand(i);
            Thread.sleep(150L);
            CameraService.z.b().setVoiceLaneChangeCommand(0);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
