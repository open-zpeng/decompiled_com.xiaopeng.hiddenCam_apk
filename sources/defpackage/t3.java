package defpackage;

import com.xiaopeng.hiddenCam.bean.DrivingData;
import com.xiaopeng.hiddenCam.oss.OssService;
import com.xiaopeng.hiddenCam.state.ENUM.AVMREADYSTATUS;
import com.xiaopeng.hiddenCam.state.ENUM.INDOORSTATUS;
import com.xiaopeng.hiddenCam.state.ENUM.YUVPROCSTATUS;
import com.xiaopeng.hiddenCam.state.StateCollection;
import com.xiaopeng.hiddenCam.utils.FileSaver;
import com.xiaopeng.hiddenCam.utils.LogUtils;
import com.xiaopeng.hiddenCam.utils.jni.JniUtil;
import java.io.File;
/* compiled from: CollectOutDrivingData.java */
/* renamed from: t3  reason: default package */
/* loaded from: classes.dex */
public class t3 extends q3 {
    public t3(OssService ossService, StateCollection stateCollection, l4 l4Var) {
        super(ossService, stateCollection, l4Var);
    }

    @Override // defpackage.q3
    protected int a(DrivingData drivingData) {
        return JniUtil.drivingData(drivingData, 1, 2);
    }

    @Override // defpackage.q3
    public void b() {
        this.a.setYuv_out_proc_status(YUVPROCSTATUS.INITIAL);
        LogUtils.d("yuv yuv_out_proc_status  " + this.a.getYuv_out_proc_status());
        g();
        h();
        DrivingData.getInstance().setPowerModel(0);
    }

    @Override // defpackage.q3
    public void c() {
        LogUtils.e(" ready to process images");
        h();
        g();
        this.a.setYuv_out_proc_status(YUVPROCSTATUS.PROCESS_YUV);
        DrivingData.getInstance().setPowerModel(0);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // defpackage.q3
    public String e() {
        return FileSaver.Constant.fix_yuv_prefix3;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // defpackage.q3
    public void f() {
        LogUtils.d("yuv status switch:  " + FileSaver.is_extrinsic_exist + " avm: " + this.a.getAvm_ready_status());
        if (FileSaver.check_extrinsic_exist() && this.b.d() && this.a.getAvm_ready_status() == AVMREADYSTATUS.ACTIVE.value) {
            if (this.a.getAvmsocket() == null) {
                this.a.setAvmsocket(new n4());
            }
            LogUtils.d("yuv yuv_out_proc_status  " + this.a.getYuv_out_proc_status() + " img_folder: " + this.a.getAvmsocket().j);
            if (this.a.getAvmsocket().j.contains(e()) || this.a.getYuv_out_proc_status() == YUVPROCSTATUS.PROCESS_YUV) {
                return;
            }
            String str = FileSaver.Constant.file_root + e();
            if (new File(str).exists()) {
                return;
            }
            FileSaver.mkdirs(str);
            JniUtil.setChamobinPath(str);
            this.a.getAvmsocket().a(this.a.getCfc(), str);
            this.a.setYuv_out_proc_status(YUVPROCSTATUS.COLLECTING_IMG);
            LogUtils.d("yuv yuv_out_proc_status  " + this.a.getYuv_out_proc_status());
            LogUtils.d(" start collect avm");
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // defpackage.q3
    public void g() {
        if (this.a.getYuv_out_proc_status() == YUVPROCSTATUS.COLLECTING_IMG && this.a.getAvmsocket() != null) {
            this.a.getAvmsocket().b();
        }
        if (!FileSaver.is_chamobin_exists(FileSaver.Constant.file_root + e() + "/raw_data/")) {
            FileSaver.deleteDir(FileSaver.Constant.file_root + e());
            LogUtils.d("yuv reset avm due to outdoor");
        }
        LogUtils.d(" collect out stop");
    }

    @Override // defpackage.q3
    protected void h() {
        this.a.poweron_indoor = INDOORSTATUS.OUTDOOR;
    }
}
