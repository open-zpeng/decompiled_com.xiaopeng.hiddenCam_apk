package defpackage;

import com.xiaopeng.hiddenCam.App;
import com.xiaopeng.hiddenCam.oss.OssService;
import com.xiaopeng.hiddenCam.state.ENUM.CFC;
import com.xiaopeng.hiddenCam.state.ENUM.CONFIG;
import com.xiaopeng.hiddenCam.state.ENUM.INDOORSTATUS;
import com.xiaopeng.hiddenCam.state.ENUM.NETWORKFLAG;
import com.xiaopeng.hiddenCam.state.ENUM.STOPALLTASK;
import com.xiaopeng.hiddenCam.state.ENUM.XPUREADY;
import com.xiaopeng.hiddenCam.state.ENUM.XPUREADYSTATUS;
import com.xiaopeng.hiddenCam.state.ENUM.YUVPROCSTATUS;
import com.xiaopeng.hiddenCam.state.StateCollection;
import com.xiaopeng.hiddenCam.utils.FileSaver;
import com.xiaopeng.hiddenCam.utils.LogUtils;
import com.xiaopeng.hiddenCam.utils.jni.JniUtil;
import java.io.File;
/* compiled from: CollecteDrivingDataE28Runable.java */
/* renamed from: u3  reason: default package */
/* loaded from: classes.dex */
public class u3 implements Runnable {
    OssService b;
    StateCollection c;
    l4 d;
    q3 e;
    s3 f;
    t3 g;
    private int h = -1;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: CollecteDrivingDataE28Runable.java */
    /* renamed from: u3$a */
    /* loaded from: classes.dex */
    public class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            u3.this.d.c();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: CollecteDrivingDataE28Runable.java */
    /* renamed from: u3$b */
    /* loaded from: classes.dex */
    public class b implements Runnable {
        b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            u3.this.d.j();
        }
    }

    public u3(OssService ossService, StateCollection stateCollection, l4 l4Var) {
        this.b = ossService;
        this.c = stateCollection;
        this.d = l4Var;
        this.f = new s3(ossService, stateCollection, l4Var);
        this.g = new t3(ossService, stateCollection, l4Var);
        this.e = this.f;
    }

    private boolean b(int i) {
        int i2;
        float scu_locat_spd = this.c.getScu_locat_spd();
        if (this.c.getCfc() == CFC.MID.value) {
            if (scu_locat_spd == 0.0f) {
                this.c.setKeep_slow_count(0);
                this.h++;
                if (this.h < 10) {
                    return false;
                }
                this.h = 0;
                if (this.d.h() != null) {
                    this.d.f().post(new a());
                }
            } else {
                StateCollection stateCollection = this.c;
                stateCollection.setKeep_slow_count(stateCollection.getKeep_slow_count() + 1);
                if (this.c.getKeep_slow_count() > 10 && this.d.h() == null) {
                    this.d.f().post(new b());
                }
            }
        } else if (this.c.getCfc() >= CFC.HIGH.value && (scu_locat_spd == 0.0f || i == 0)) {
            this.h++;
            if (scu_locat_spd < 10.0f && i2 > 0) {
                this.h += 4;
            }
            if (this.h < 10) {
                return false;
            }
            this.h = 0;
        }
        return true;
    }

    protected void a(int i) {
        LogUtils.d("collect start poweron_indoor:" + this.c.poweron_indoor + " Yuv_out_proc_status:" + this.c.getYuv_out_proc_status() + " indoor_status:" + i + " Last_indoor_status:" + this.c.getLast_indoor_status() + " Yuv_proc_status " + this.c.getYuv_proc_status());
        if (this.c.getYuv_proc_status() == YUVPROCSTATUS.INITIAL && i == 1 && this.c.getLast_indoor_status() == INDOORSTATUS.OUTDOOR.value) {
            if (this.c.getYuv_out_proc_status() != YUVPROCSTATUS.PROCESS_YUV) {
                this.c.setYuv_out_proc_status(YUVPROCSTATUS.INITIAL);
            }
            this.c.fsd_slot.clear();
            FileSaver.delete_save_car_info();
            this.e = this.f;
            LogUtils.d("collect in start");
            this.e.f();
        } else if (i != 0 && this.c.getYuv_out_proc_status() == YUVPROCSTATUS.INITIAL && this.c.getYuv_proc_status() != YUVPROCSTATUS.COLLECTING_IMG && x3.b == 1 && FileSaver.check_save_car_in_info_exist() && this.c.getScu_locat_spd() > 0.1d) {
            this.c.setCar_in_info(FileSaver.read_car_in_info());
            FileSaver.delete_save_car_info();
            JniUtil.setCarInInfo(this.c.getCar_in_info());
            this.c.fsd_slot.clear();
            FileSaver.deleteDir(FileSaver.Constant.file_root + this.g.e());
            this.e = this.g;
            this.e.f();
            LogUtils.d("collect out start");
            StateCollection stateCollection = this.c;
            stateCollection.setFirst_tbox_rsrp(stateCollection.getTbox_rsrp());
        }
        this.e.a();
        if (i == 0 && this.c.getLast_indoor_status() == INDOORSTATUS.INDOOR.value && (this.e instanceof s3)) {
            LogUtils.d("collect in stop: useless collect");
            this.e.g();
        }
    }

    @Override // java.lang.Runnable
    public void run() {
        if (b() && this.c.getStop_all_task() == STOPALLTASK.NORMAL) {
            a();
            int indoorStatus = JniUtil.getIndoorStatus();
            if (b(indoorStatus)) {
                if (x3.a == 1) {
                    a(indoorStatus);
                }
                this.c.setLast_indoor_status(indoorStatus);
            }
        }
    }

    protected boolean b() {
        if (this.c.getIs_config_init() != CONFIG.CONFIG_SUCCESS.value) {
            if (this.c.getIs_config_init() == CONFIG.CONFIG_NOT_INIT.value) {
                boolean a2 = this.b.a(true, this.c.getVinCode(), this.c.getCarType());
                LogUtils.d("config result =" + a2);
                if (a2) {
                    this.c.setIs_config_init(CONFIG.CONFIG_SUCCESS.value);
                    return true;
                }
                File file = new File(this.b.o);
                if (file.exists()) {
                    file.delete();
                }
                this.c.setIs_config_init(CONFIG.CONFIG_FAILED.value);
                return false;
            } else if (this.c.getIs_config_init() == CONFIG.CONFIG_FAILED.value) {
                return false;
            }
        } else if (this.c.getIs_config_init() == CONFIG.CONFIG_SUCCESS.value) {
            return true;
        }
        return false;
    }

    protected void a() {
        if (this.c.getXpu_ready_status() == XPUREADYSTATUS.READY.value && this.c.getXpu_ready_flag() == XPUREADY.NOT_READY && this.c.getNetwork_flag() == NETWORKFLAG.AVAILABLE.value && x3.c == 1 && this.c.getCurrent_gear_() == 4) {
            this.c.setXpu_ready_flag(XPUREADY.READY);
            LogUtils.d("949494949 enter update ");
            this.b.a(App.a().getApplicationContext(), "updateList.bin");
        }
    }
}
