package defpackage;

import com.xiaopeng.hiddenCam.bean.DrivingData;
import com.xiaopeng.hiddenCam.oss.OssService;
import com.xiaopeng.hiddenCam.state.ENUM.AVMREADYSTATUS;
import com.xiaopeng.hiddenCam.state.ENUM.INDOORSTATUS;
import com.xiaopeng.hiddenCam.state.ENUM.INFENCESTATUS;
import com.xiaopeng.hiddenCam.state.ENUM.STOPALLTASK;
import com.xiaopeng.hiddenCam.state.ENUM.SUPERACTIVATE;
import com.xiaopeng.hiddenCam.state.ENUM.YUVPROCSTATUS;
import com.xiaopeng.hiddenCam.state.StateCollection;
import com.xiaopeng.hiddenCam.utils.FileSaver;
import com.xiaopeng.hiddenCam.utils.LogUtils;
import com.xiaopeng.hiddenCam.utils.jni.JniUtil;
import java.io.File;
/* compiled from: CollecteDrivingDataOngRunable.java */
/* renamed from: o3  reason: default package */
/* loaded from: classes.dex */
public class o3 implements Runnable {
    StateCollection b;
    l4 c;
    private int d = -1;

    public o3(OssService ossService, StateCollection stateCollection, l4 l4Var) {
        this.b = stateCollection;
        this.c = l4Var;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.b.getStop_all_task() != STOPALLTASK.NORMAL) {
            return;
        }
        float scu_locat_spd = this.b.getScu_locat_spd();
        int i = (scu_locat_spd > 0.0f ? 1 : (scu_locat_spd == 0.0f ? 0 : -1));
        if (i == 0 || (this.b.getSuper_activate().value <= SUPERACTIVATE.SUPERACTIVATE_0.value && this.b.getInfence_status() != INFENCESTATUS.INFENCE_INSIDE.value)) {
            this.d++;
            if (scu_locat_spd < 10.0f && i > 0) {
                this.d += 4;
            }
            if (this.d < 10) {
                return;
            }
            this.d = 0;
        }
        int indoorStatus = JniUtil.getIndoorStatus();
        if ((this.b.getInfence_status() == INFENCESTATUS.INFENCE_INSIDE.value && this.b.getLast_infence_status() == INFENCESTATUS.INFENCE_OUTSIDE.value && indoorStatus == INDOORSTATUS.OUTDOOR.value) || (this.b.getSuper_activate() == SUPERACTIVATE.SUPERACTIVATE_1 && indoorStatus == INDOORSTATUS.OUTDOOR.value)) {
            LogUtils.d("onground status switch:  " + FileSaver.is_extrinsic_exist + " avm: " + this.b.getAvm_ready_status());
            if (FileSaver.check_extrinsic_exist() && this.c.d() && this.b.getAvm_ready_status() == AVMREADYSTATUS.ACTIVE.value) {
                if (this.b.getAvmsocket_on() == null) {
                    this.b.setAvmsocket_on(new o4());
                }
                LogUtils.d("yuv onround yuv_ong_proc_status  " + this.b.getYuv_ong_proc_status() + " img_folder: " + this.b.getAvmsocket_on().j);
                if (this.b.getAvmsocket_on().j.length() == 0 && this.b.getYuv_ong_proc_status() != YUVPROCSTATUS.PROCESS_YUV && this.b.getYuv_proc_status() == YUVPROCSTATUS.INITIAL && this.b.getYuv_out_proc_status() != YUVPROCSTATUS.COLLECTING_IMG) {
                    String str = FileSaver.Constant.file_root + FileSaver.Constant.fix_yuv_prefix2;
                    if (!new File(str).exists()) {
                        FileSaver.mkdirs(str);
                        LogUtils.d("yuv onround img_save_folder :%s " + str);
                        JniUtil.setOngroundChamoPath(str);
                        this.b.getAvmsocket_on().a(this.b.getCfc(), str);
                        this.b.setYuv_ong_proc_status(YUVPROCSTATUS.COLLECTING_IMG);
                        LogUtils.d("onground start collect avm");
                    }
                }
            }
            if (this.b.getSuper_activate() == SUPERACTIVATE.SUPERACTIVATE_1 && ((int) (System.currentTimeMillis() - this.b.getOnground_apa_time())) / 60000 >= 5) {
                LogUtils.d("beyond 5 minutes");
                this.b.setSuper_activate(SUPERACTIVATE.SUPERACTIVATE_0);
            }
        } else if ((this.b.getInfence_status() == INFENCESTATUS.INFENCE_OUTSIDE.value && this.b.getLast_infence_status() != INFENCESTATUS.INFENCE_OUTSIDE.value) || ((this.b.getSuper_activate() == SUPERACTIVATE.SUPERACTIVATE_0 && scu_locat_spd > 0.1d) || (indoorStatus == 1 && this.b.getLast_indoor_status() == INDOORSTATUS.OUTDOOR.value))) {
            LogUtils.d("onground infence status: " + this.b.getInfence_status() + " super_activate: " + this.b.getSuper_activate());
            this.b.setSuper_activate(SUPERACTIVATE.INITIAL);
            JniUtil.setSuperStatus(-1);
            if (this.b.getYuv_ong_proc_status() == YUVPROCSTATUS.COLLECTING_IMG && this.b.getAvmsocket_on() != null) {
                this.b.getAvmsocket_on().b();
            }
            if (!FileSaver.is_chamobin_exists(FileSaver.Constant.file_root + FileSaver.Constant.fix_yuv_prefix2 + "/raw_data/")) {
                FileSaver.deleteDir(FileSaver.Constant.file_root + FileSaver.Constant.fix_yuv_prefix2);
            }
        }
        DrivingData drivingData = DrivingData.getInstance();
        if (this.b.getYuv_ong_proc_status() != YUVPROCSTATUS.PROCESS_YUV && indoorStatus != 1) {
            int drivingData2 = JniUtil.drivingData(drivingData, 2, 1);
            if (drivingData2 == 1) {
                LogUtils.e("onground ready to process images");
                this.b.setYuv_ong_proc_status(YUVPROCSTATUS.PROCESS_YUV);
            }
            if (drivingData2 == -1) {
                this.b.setYuv_ong_proc_status(YUVPROCSTATUS.INITIAL);
                if (this.b.getAvmsocket_on() != null) {
                    LogUtils.e("onground drivingdata return error!!! " + this.b.getYuv_ong_proc_status());
                    this.b.getAvmsocket_on().b();
                }
            }
        }
        StateCollection stateCollection = this.b;
        stateCollection.setLast_infence_status(stateCollection.getInfence_status());
    }
}
