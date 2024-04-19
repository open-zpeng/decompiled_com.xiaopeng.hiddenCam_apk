package com.xiaopeng.hiddenCam;

import com.google.gson.Gson;
import com.xiaopeng.hiddenCam.apirouterClient.RouteHdPkMap2NaviClient;
import com.xiaopeng.hiddenCam.bean.AutoBumpBean;
import com.xiaopeng.hiddenCam.bean.DownloadInfo;
import com.xiaopeng.hiddenCam.bean.DrivingData;
import com.xiaopeng.hiddenCam.bean.EvaluateBean;
import com.xiaopeng.hiddenCam.bean.HdmapConfirmBean;
import com.xiaopeng.hiddenCam.bean.IntValue;
import com.xiaopeng.hiddenCam.bean.ShareMapBean;
import com.xiaopeng.hiddenCam.state.ENUM.DRIVEMODEFB;
import com.xiaopeng.hiddenCam.utils.FileSaver;
import com.xiaopeng.hiddenCam.utils.LogUtils;
import com.xiaopeng.lib.apirouter.server.IServicePublisher;
import com.xiaopeng.lib.apirouter.server.Publish;
import java.io.File;
/* loaded from: classes.dex */
public class RouteSrHdPkmap implements IServicePublisher {
    private static Gson gson = new Gson();

    @Publish
    public void routeNavi2HdPkmapApplyListF() {
        LogUtils.d("[chamo proto], receive apply listF ver: ");
        RouteHdPkMap2NaviClient.routeHdPkMap2NaviListFVersion(CameraService.y.getListF_ver());
    }

    @Publish
    public void routeSr2HdPkmapBump(String str) {
        AutoBumpBean autoBumpBean = (AutoBumpBean) gson.fromJson(str, (Class<Object>) AutoBumpBean.class);
        DrivingData.getInstance().setBump_x((float) autoBumpBean.getX());
        DrivingData.getInstance().setBump_y((float) autoBumpBean.getY());
        DrivingData.getInstance().setBump_s((float) autoBumpBean.getS());
        DrivingData.getInstance().setBump_heading((float) autoBumpBean.getTheta());
    }

    @Publish
    public void routeSr2HdPkmapConfirmInfo(String str) {
        LogUtils.e("proto receive comfirm info: " + str);
        HdmapConfirmBean hdmapConfirmBean = (HdmapConfirmBean) gson.fromJson(str, (Class<Object>) HdmapConfirmBean.class);
        CameraService.a((int) hdmapConfirmBean.mapid, hdmapConfirmBean.confirm);
        if (new File(FileSaver.Constant.file_root + "pre1/raw_data/").exists()) {
            LogUtils.e("[chamo] ConfirmInfo, dir exist:");
            CameraService.n();
        }
    }

    @Publish
    public void routeSr2HdPkmapEvaluation(String str) {
        LogUtils.i("proto receive Evaluation info: " + str);
        try {
            EvaluateBean evaluateBean = (EvaluateBean) gson.fromJson(str, (Class<Object>) EvaluateBean.class);
            String str2 = evaluateBean.mapName;
            int i = evaluateBean.evaluation;
            int i2 = evaluateBean.type;
            boolean save_evaluation_info = FileSaver.save_evaluation_info(FileSaver.Constant.file_root + "pre1/raw_data/", str2, i, i2, evaluateBean.mapTime);
            if (i != -1 && i2 == 3 && save_evaluation_info) {
                if (i == 3) {
                    i4 i4Var = CameraService.A;
                    i4.a(15, Integer.valueOf(str2).intValue(), 3);
                }
                String str3 = "Venue" + str2;
                if (FileSaver.mapDownloadedInfos.containsKey(str3)) {
                    DownloadInfo downloadInfo = FileSaver.mapDownloadedInfos.get(str3);
                    downloadInfo.eval = i;
                    FileSaver.mapDownloadedInfos.put(str3, downloadInfo);
                }
            }
            if (save_evaluation_info) {
                CameraService.n();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Publish
    public void routeSr2HdPkmapShareInfo(String str) {
        LogUtils.i("proto receive share info: " + str);
        try {
            ShareMapBean shareMapBean = (ShareMapBean) gson.fromJson(str, (Class<Object>) ShareMapBean.class);
            boolean save_share_info = FileSaver.save_share_info(FileSaver.Constant.file_root + "pre1/raw_data/", shareMapBean.Dest, shareMapBean.Floor, shareMapBean.mapTime);
            if (CameraService.y.getStudy_map_name() != "" && save_share_info) {
                FileSaver.renameFile(FileSaver.Constant.file_root + "pre1/raw_data/" + CameraService.y.getStudy_map_name(), FileSaver.Constant.file_root + "pre1/raw_data/Venue_share.json");
            } else if (CameraService.y.getDrive_mode_fb() == DRIVEMODEFB.ACTIVE.value && CameraService.y.getLast_pk_map_id() != 0) {
                i4 i4Var = CameraService.A;
                i4.a(13, CameraService.y.getLast_pk_map_id(), 0);
            }
            if (save_share_info) {
                CameraService.n();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Publish
    public void routeSr2HdPkmapTrainingTips(String str) {
        LogUtils.d("proto receive tips info: " + str);
        IntValue intValue = (IntValue) gson.fromJson(str, (Class<Object>) IntValue.class);
    }

    @Publish
    public void routeZGAutoPilot2HdMapApplyMap(String str) {
        LogUtils.d("[chamo proto], routeZGAutoPilot2HdMapApplyMap: " + str);
        CameraService.a(Integer.valueOf(str).intValue());
    }
}
