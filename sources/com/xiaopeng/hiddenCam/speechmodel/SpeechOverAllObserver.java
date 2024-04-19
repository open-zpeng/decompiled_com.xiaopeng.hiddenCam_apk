package com.xiaopeng.hiddenCam.speechmodel;

import android.net.Uri;
import android.os.RemoteException;
import com.xiaopeng.hiddenCam.CameraService;
import com.xiaopeng.hiddenCam.state.ENUM.NGPSTATUS;
import com.xiaopeng.hiddenCam.utils.LogUtils;
import com.xiaopeng.lib.apirouter.ApiRouter;
import com.xiaopeng.lib.apirouter.server.IServicePublisher;
import com.xiaopeng.lib.apirouter.server.Publish;
import com.xiaopeng.speech.protocol.bean.recommend.RecommendBean;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class SpeechOverAllObserver implements IServicePublisher {
    public static final String VOICE_CHANEGE_LANE = "command://voice.change.lane";
    public static final String XPU_IS_ON_ALC = "xpu.is.on.alc";
    public static final String XPU_IS_ON_AUTOPILOT = "xpu.is.on.autopilot";

    @Publish
    public void onEvent(String str, String str2) {
        String optString;
        LogUtils.i("onEvent 消息接收 event== " + str + ",data:" + str2);
        if (VOICE_CHANEGE_LANE.equals(str)) {
            try {
                JSONObject jSONObject = new JSONObject(str2);
                if (!jSONObject.has("direction") || (optString = jSONObject.optString("direction")) == "") {
                    return;
                }
                CameraService.z.b().setVoiceLaneChangeCommand(Integer.parseInt(optString));
                Thread.sleep(150L);
                CameraService.z.b().setVoiceLaneChangeCommand(0);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @Publish
    public void onQuery(String str, String str2, String str3) {
        LogUtils.i("onQuery 消息接收 event== " + str + " data: " + str2);
        int i = 0;
        if (!XPU_IS_ON_AUTOPILOT.equals(str)) {
            if (XPU_IS_ON_ALC.equals(str)) {
                try {
                    if (CameraService.y.getAlc_ctrl_status() == 15 || CameraService.y.getAlc_ctrl_status() == 1 || CameraService.y.getAlc_ctrl_status() == 2) {
                        i = 1;
                    }
                    ApiRouter.route(Uri.parse(str3).buildUpon().appendQueryParameter(RecommendBean.SHOW_TIME_RESULT, new SpeechResult(str, Integer.valueOf(i)).toString()).build());
                } catch (RemoteException e) {
                    LogUtils.i("remote exception : " + e.getMessage());
                    e.printStackTrace();
                }
            }
        } else if (str3 != "") {
            LogUtils.i(" callback : " + str3);
            try {
                if (CameraService.y.getNgp_status_() != NGPSTATUS.AUTO_PILOT_5.value && CameraService.y.getNgp_status_() != NGPSTATUS.AUTO_PILOT_6.value) {
                    if (CameraService.y.getNgp_status_() == NGPSTATUS.AUTO_PILOT_8.value || CameraService.y.getNgp_status_() == NGPSTATUS.AUTO_PILOT_9.value) {
                        i = 2;
                    }
                    ApiRouter.route(Uri.parse(str3).buildUpon().appendQueryParameter(RecommendBean.SHOW_TIME_RESULT, new SpeechResult(str, Integer.valueOf(i)).toString()).build());
                }
                i = 1;
                ApiRouter.route(Uri.parse(str3).buildUpon().appendQueryParameter(RecommendBean.SHOW_TIME_RESULT, new SpeechResult(str, Integer.valueOf(i)).toString()).build());
            } catch (RemoteException e2) {
                LogUtils.i("remote exception : " + e2.getMessage());
                e2.printStackTrace();
            }
        }
    }
}
