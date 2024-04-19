package defpackage;

import com.xiaopeng.hiddenCam.oss.OssService;
import com.xiaopeng.hiddenCam.state.ENUM.SIGNALSTATE;
import com.xiaopeng.hiddenCam.state.ENUM.YUVPROCSTATUS;
import com.xiaopeng.hiddenCam.state.StateCollection;
import com.xiaopeng.hiddenCam.utils.FileSaver;
import com.xiaopeng.hiddenCam.utils.LogUtils;
import com.xiaopeng.hiddenCam.utils.jni.ImageUtils;
import java.io.File;
/* compiled from: ProcessAvmYuvsOutRunable.java */
/* renamed from: v3  reason: default package */
/* loaded from: classes.dex */
public class v3 extends r3 {
    public v3(OssService ossService, StateCollection stateCollection, l4 l4Var, m3 m3Var) {
        super(ossService, stateCollection, l4Var, m3Var);
    }

    @Override // defpackage.r3
    protected boolean a(String str) {
        if (FileSaver.is_chamobin_exists(str)) {
            return ImageUtils.processYuvsOutStitch();
        }
        return false;
    }

    @Override // defpackage.r3
    protected String b() {
        return FileSaver.Constant.fix_yuv_prefix3;
    }

    @Override // defpackage.r3
    protected void c() {
    }

    @Override // defpackage.r3
    protected void d() {
        if (this.c.getYuv_out_proc_status() == YUVPROCSTATUS.PROCESS_YUV) {
            String str = FileSaver.Constant.file_root + b() + "/raw_data/";
            if (a(str)) {
                return;
            }
            if (new File(str).exists()) {
                LogUtils.d("yuv out start del yuv, net: " + this.c.getNetwork_flag());
                FileSaver.deleteYuv(str);
                FileSaver.save4upload(b(), this.c);
                FileSaver.deleteDir(FileSaver.Constant.file_root + b());
                this.c.setYuv_out_finish_status(YUVPROCSTATUS.PROCESS_YUV);
            }
            this.c.setSignal_state(SIGNALSTATE.INITIAL.value);
            this.c.setYuv_out_proc_status(YUVPROCSTATUS.INITIAL);
            LogUtils.d("yuv yuv_out_proc_status  " + this.c.getYuv_out_proc_status());
        } else if (this.c.getYuv_out_finish_status() == YUVPROCSTATUS.PROCESS_YUV && this.c.getNetwork_flag() == 1 && this.c.getTbox_rsrp() > -95) {
            LogUtils.d("yuv upload all " + b());
            this.b.a(this.c.getVinCode(), this.c.getCarType(), 13);
            this.c.setYuv_out_finish_status(YUVPROCSTATUS.INITIAL);
            e();
        }
    }

    @Override // defpackage.r3
    protected void e() {
    }

    @Override // defpackage.r3
    protected boolean a() {
        return FileSaver.is_extrinsic_exist;
    }
}
