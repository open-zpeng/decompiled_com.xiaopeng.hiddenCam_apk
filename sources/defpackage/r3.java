package defpackage;

import com.xiaopeng.hiddenCam.CameraService;
import com.xiaopeng.hiddenCam.oss.OssService;
import com.xiaopeng.hiddenCam.state.ENUM.AVMREADYSTATUS;
import com.xiaopeng.hiddenCam.state.ENUM.CAMERA;
import com.xiaopeng.hiddenCam.state.ENUM.CFC;
import com.xiaopeng.hiddenCam.state.ENUM.CONFIG;
import com.xiaopeng.hiddenCam.state.ENUM.SIGNALSTATE;
import com.xiaopeng.hiddenCam.state.ENUM.STOPALLTASK;
import com.xiaopeng.hiddenCam.state.ENUM.XPUREADYSTATUS;
import com.xiaopeng.hiddenCam.state.ENUM.YUVPROCSTATUS;
import com.xiaopeng.hiddenCam.state.StateCollection;
import com.xiaopeng.hiddenCam.utils.FileSaver;
import com.xiaopeng.hiddenCam.utils.LogUtils;
import java.io.File;
/* compiled from: BaseProcessAvmYuvsRunable.java */
/* renamed from: r3  reason: default package */
/* loaded from: classes.dex */
public class r3 implements Runnable {
    OssService b;
    StateCollection c;
    m3 d;

    public r3(OssService ossService, StateCollection stateCollection, l4 l4Var, m3 m3Var) {
        this.b = ossService;
        this.c = stateCollection;
        this.d = m3Var;
    }

    protected boolean a() {
        if (!FileSaver.is_extrinsic_exist) {
            if (this.c.getStop_cam() == CAMERA.CAMERA_STATE_WORKING.value && System.currentTimeMillis() - this.c.getStart_cam_time() > 5000) {
                this.d.a();
            }
            if (this.c.getStop_cam() == CAMERA.CAMERA_STATE_NOT_START.value && this.c.getAvm_ready_status() == AVMREADYSTATUS.ACTIVE.value && this.c.getIs_config_init() == CONFIG.CONFIG_SUCCESS.value) {
                if ((this.c.getCfc() >= CFC.HIGH.value && this.c.getXpu_ready_status() == XPUREADYSTATUS.READY.value) || this.c.getCfc() == CFC.MID.value) {
                    this.d.f();
                    this.c.setStart_cam_time(System.currentTimeMillis());
                    LogUtils.e(" start collect camera extrinsic");
                    return false;
                }
            } else if (!this.c.is_extrinsic_send_to_xpu() && this.c.getStop_cam() == CAMERA.CAMERA_STATE_FINISHED.value && CameraService.A.a(11, FileSaver.Constant.file_root, "extrinsicParam.json")) {
                LogUtils.e("send extrinsic to xpu succeed");
                this.c.setExtrinsic_send_to_xpu(true);
            }
        }
        return true;
    }

    protected boolean a(String str) {
        throw null;
    }

    protected String b() {
        throw null;
    }

    protected void c() {
        if (this.c.getSignal_state() == SIGNALSTATE.POWER_ON.value) {
            long currentTimeMillis = (System.currentTimeMillis() - this.c.getPower_on_time()) / 40000;
            LogUtils.d(" record time = " + currentTimeMillis + " yuv_proc_status: " + this.c.getYuv_proc_status());
            if (currentTimeMillis >= 1) {
                this.c.setSignal_state(SIGNALSTATE.DELAY_MINUTE.value);
                LogUtils.d(" minute is = [" + currentTimeMillis + "]");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void d() {
        if (this.c.getYuv_proc_status() == YUVPROCSTATUS.PROCESS_YUV) {
            String str = FileSaver.Constant.file_root + b() + "/raw_data/";
            if (a(str)) {
                return;
            }
            if (new File(str).exists()) {
                LogUtils.d("yuv start del yuv, net: " + this.c.getNetwork_flag());
                FileSaver.deleteYuv(str);
                FileSaver.save4upload(b(), this.c);
                FileSaver.deleteDir(FileSaver.Constant.file_root + b());
                this.c.setYuv_finish_status(YUVPROCSTATUS.PROCESS_YUV.value);
            }
            this.c.setSignal_state(SIGNALSTATE.INITIAL.value);
            this.c.setYuv_proc_status(YUVPROCSTATUS.INITIAL);
            LogUtils.d("yuv yuv_proc_status  " + this.c.getYuv_proc_status());
        } else if (this.c.getYuv_finish_status() == YUVPROCSTATUS.PROCESS_YUV.value && this.c.getNetwork_flag() == 1 && this.c.getTbox_rsrp() > -95) {
            LogUtils.d("yuv upload all " + b());
            this.b.a(this.c.getVinCode(), this.c.getCarType(), 12);
            this.c.setYuv_finish_status(YUVPROCSTATUS.INITIAL.value);
            e();
        }
    }

    protected void e() {
        throw null;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.c.getStop_all_task() == STOPALLTASK.NORMAL && a()) {
            c();
            d();
        }
    }
}
