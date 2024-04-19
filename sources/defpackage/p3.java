package defpackage;

import com.xiaopeng.hiddenCam.oss.OssService;
import com.xiaopeng.hiddenCam.state.ENUM.NETWORKFLAG;
import com.xiaopeng.hiddenCam.state.ENUM.SIGNALSTATE;
import com.xiaopeng.hiddenCam.state.ENUM.STOPALLTASK;
import com.xiaopeng.hiddenCam.state.ENUM.YUVPROCSTATUS;
import com.xiaopeng.hiddenCam.state.StateCollection;
import com.xiaopeng.hiddenCam.utils.FileSaver;
import com.xiaopeng.hiddenCam.utils.LogUtils;
import com.xiaopeng.hiddenCam.utils.jni.ImageUtils;
import java.io.File;
/* compiled from: ProcessOngroundYuvRunable.java */
/* renamed from: p3  reason: default package */
/* loaded from: classes.dex */
public class p3 implements Runnable {
    OssService b;
    StateCollection c;
    private YUVPROCSTATUS d = YUVPROCSTATUS.INITIAL;

    public p3(OssService ossService, StateCollection stateCollection, l4 l4Var) {
        this.b = ossService;
        this.c = stateCollection;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.c.getStop_all_task() != STOPALLTASK.NORMAL) {
            return;
        }
        YUVPROCSTATUS yuv_ong_proc_status = this.c.getYuv_ong_proc_status();
        YUVPROCSTATUS yuvprocstatus = YUVPROCSTATUS.PROCESS_YUV;
        if (yuv_ong_proc_status == yuvprocstatus) {
            if (ImageUtils.processOngroundYuvs()) {
                return;
            }
            if (new File(FileSaver.Constant.file_root + FileSaver.Constant.fix_yuv_prefix2 + "/raw_data").exists()) {
                LogUtils.d("onground start del yuv, net: " + this.c.getNetwork_flag());
                FileSaver.deleteYuv(FileSaver.Constant.file_root + FileSaver.Constant.fix_yuv_prefix2 + "/raw_data/");
                FileSaver.save4upload(FileSaver.Constant.fix_yuv_prefix2, this.c);
                FileSaver.deleteDir(FileSaver.Constant.file_root + FileSaver.Constant.fix_yuv_prefix2);
                this.d = YUVPROCSTATUS.PROCESS_YUV;
            }
            this.c.setSignal_state(SIGNALSTATE.INITIAL.value);
            this.c.setYuv_ong_proc_status(YUVPROCSTATUS.INITIAL);
            LogUtils.d("onground yuv_ong_proc_status  " + this.c.getYuv_ong_proc_status());
        } else if (this.d == yuvprocstatus && this.c.getNetwork_flag() == NETWORKFLAG.AVAILABLE.value && this.c.getTbox_rsrp() > -95) {
            this.b.a(this.c.getVinCode(), this.c.getCarType(), 11);
            this.d = YUVPROCSTATUS.INITIAL;
        }
    }
}
