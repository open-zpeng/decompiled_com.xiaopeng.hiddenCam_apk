package com.xiaopeng.hiddenCam.speechmodel;

import com.xiaopeng.hiddenCam.CameraService;
import com.xiaopeng.hiddenCam.state.ENUM.NGPSTATUS;
import com.xiaopeng.speech.protocol.query.xpu.a;
/* loaded from: classes.dex */
public class XpuSpeechCaller implements a {
    public static int aLCStatus;
    public static int autoPilotStatus;

    /* loaded from: classes.dex */
    private static class LazyHolder {
        private static final XpuSpeechCaller INSTANCE = new XpuSpeechCaller();

        private LazyHolder() {
        }
    }

    public static XpuSpeechCaller getInstance() {
        return LazyHolder.INSTANCE;
    }

    public int getALCStatus() {
        return (CameraService.y.getAlc_ctrl_status() == 15 || CameraService.y.getAlc_ctrl_status() == 1 || CameraService.y.getAlc_ctrl_status() == 2) ? 1 : 0;
    }

    public int getAutoPilotStatus() {
        return (CameraService.y.getNgp_status_() == NGPSTATUS.AUTO_PILOT_5.value || CameraService.y.getNgp_status_() == NGPSTATUS.AUTO_PILOT_6.value) ? 1 : 0;
    }
}
