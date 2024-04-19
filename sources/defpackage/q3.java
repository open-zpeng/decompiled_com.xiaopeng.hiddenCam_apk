package defpackage;

import android.location.Location;
import com.xiaopeng.hiddenCam.bean.DrivingData;
import com.xiaopeng.hiddenCam.oss.OssService;
import com.xiaopeng.hiddenCam.state.ENUM.APTIPS;
import com.xiaopeng.hiddenCam.state.ENUM.AVMREADYSTATUS;
import com.xiaopeng.hiddenCam.state.ENUM.CHARGESTATUS;
import com.xiaopeng.hiddenCam.state.ENUM.DRIVEMODEFB;
import com.xiaopeng.hiddenCam.state.ENUM.YUVPROCSTATUS;
import com.xiaopeng.hiddenCam.state.StateCollection;
import com.xiaopeng.hiddenCam.utils.FileSaver;
import com.xiaopeng.hiddenCam.utils.LogUtils;
import com.xiaopeng.hiddenCam.utils.jni.JniUtil;
import java.io.File;
/* compiled from: BaseCollectDrivingData.java */
/* renamed from: q3  reason: default package */
/* loaded from: classes.dex */
public class q3 {
    StateCollection a;
    l4 b;

    public q3(OssService ossService, StateCollection stateCollection, l4 l4Var) {
        this.a = stateCollection;
        this.b = l4Var;
    }

    protected void a(boolean z) {
        if (z) {
            this.b.i().c();
        } else {
            this.b.i().e();
        }
    }

    public void b() {
        this.a.setYuv_proc_status(YUVPROCSTATUS.INITIAL);
        LogUtils.d("yuv yuv_proc_status  " + this.a.getYuv_proc_status());
        if (this.a.getAvmsocket() != null) {
            LogUtils.e(" drivingdata return error!!! " + this.a.getYuv_proc_status());
            this.a.getAvmsocket().b();
        }
        h();
        DrivingData.getInstance().setPowerModel(0);
    }

    public void c() {
        LogUtils.e(" ready to process images, yuv_out_status: " + this.a.getYuv_out_proc_status());
        h();
        g();
        this.a.setYuv_proc_status(YUVPROCSTATUS.PROCESS_YUV);
        DrivingData.getInstance().setPowerModel(0);
        String modifiedDate = FileSaver.getModifiedDate(FileSaver.Constant.file_root + e() + "/raw_data/chamo.bin");
        if (this.a.getYuv_out_proc_status() == YUVPROCSTATUS.INITIAL) {
            FileSaver.save_car_in_info(((("{\"strDate\": \"" + modifiedDate + "\",") + "\"lat\": " + StateCollection.getInstance().getLast_gps().a + ",") + "\"lng\": " + StateCollection.getInstance().getLast_gps().b) + "}");
        }
    }

    protected DrivingData d() {
        return DrivingData.getInstance();
    }

    protected String e() {
        throw null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void f() {
        LogUtils.d("yuv status switch:  " + FileSaver.is_extrinsic_exist + " avm: " + this.a.getAvm_ready_status());
        if (FileSaver.check_extrinsic_exist() && this.b.d() && this.a.getAvm_ready_status() == AVMREADYSTATUS.ACTIVE.value) {
            if (this.a.getAvmsocket() == null) {
                this.a.setAvmsocket(new n4());
            }
            this.a.getAvmsocket().a();
            a(true);
            LogUtils.d("yuv yuv_proc_status  " + this.a.getYuv_proc_status() + " img_folder: " + this.a.getAvmsocket().j);
            if (this.a.getAvmsocket().j.contains(e()) || this.a.getYuv_proc_status() == YUVPROCSTATUS.PROCESS_YUV) {
                return;
            }
            String str = FileSaver.Constant.file_root + e();
            if (new File(str).exists()) {
                return;
            }
            FileSaver.mkdirs(str);
            JniUtil.setChamobinPath(str);
            this.a.getAvmsocket().a(this.a.getCfc(), str);
            this.a.setYuv_proc_status(YUVPROCSTATUS.COLLECTING_IMG);
            LogUtils.d("yuv yuv_proc_status  " + this.a.getYuv_proc_status());
            LogUtils.d(" start collect avm");
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void g() {
        if (this.a.getYuv_proc_status() == YUVPROCSTATUS.COLLECTING_IMG) {
            if (this.a.getAvmsocket() != null) {
                this.a.getAvmsocket().b();
            }
            a(false);
        }
        if (FileSaver.is_chamobin_exists(FileSaver.Constant.file_root + e() + "/raw_data/")) {
            return;
        }
        FileSaver.deleteDir(FileSaver.Constant.file_root + e());
        this.a.setDrive_mode_fb(DRIVEMODEFB.INITIAL.value);
        this.a.setAp_tips_(APTIPS.INITIAL.value);
        this.a.setIshdmap_(-1);
        this.a.setXpu_map_time_(0L);
        this.a.setLast_pk_map_id(0);
        this.a.setCharge_status(CHARGESTATUS.INITIAL.value);
        this.a.setYuv_proc_status(YUVPROCSTATUS.INITIAL);
        LogUtils.d("yuv yuv_proc_status  " + this.a.getYuv_proc_status());
        this.a.setStudy_map_name("");
        LogUtils.d("yuv reset avm due to outdoor");
    }

    protected void h() {
        throw null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a() {
        DrivingData d = d();
        Location lastKnownLocation = this.b.e().getLastKnownLocation("gps");
        if (lastKnownLocation != null) {
            double longitude = lastKnownLocation.getLongitude();
            double latitude = lastKnownLocation.getLatitude();
            double altitude = lastKnownLocation.getAltitude();
            float speed = lastKnownLocation.getSpeed();
            d.setCDU_SCU_GPS_LONG_itude((float) longitude);
            d.setCDU_SCU_GPS_Latitude((float) latitude);
            d.setCDU_SCU_GPS_ALtitude((float) altitude);
            d.setCDU_SCU_GPS_Accuracy(lastKnownLocation.getAccuracy());
            d.setGPS_Velocity(speed);
            this.a.getLast_gps().a = latitude;
            this.a.getLast_gps().b = longitude;
        }
        try {
            d.setEPS_SAS_SteeringAngle(this.b.b().a().getSteeringAngle());
            this.b.k();
            this.b.a();
        } catch (Exception e) {
            LogUtils.e(e.getMessage());
        }
        int a = a(d);
        if (a == 1) {
            c();
        }
        if (a == -1) {
            b();
        }
    }

    protected int a(DrivingData drivingData) {
        return JniUtil.drivingData(drivingData, 1, 1);
    }
}
