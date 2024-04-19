package com.xiaopeng.hiddenCam;

import android.app.Service;
import android.car.Car;
import android.car.hardware.CarEcuManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.location.GpsStatus;
import android.location.LocationManager;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import android.os.SystemProperties;
import android.view.SurfaceView;
import android.view.WindowManager;
import com.alibaba.sdk.android.oss.common.RequestParameters;
import com.google.gson.JsonParser;
import com.xiaopeng.hiddenCam.bean.DrivingData;
import com.xiaopeng.hiddenCam.hardware.EcuEventCallback;
import com.xiaopeng.hiddenCam.oss.OssService;
import com.xiaopeng.hiddenCam.state.ENUM.CAMERA;
import com.xiaopeng.hiddenCam.state.ENUM.CARTYPE;
import com.xiaopeng.hiddenCam.state.ENUM.CFC;
import com.xiaopeng.hiddenCam.state.ENUM.INDOORSTATUS;
import com.xiaopeng.hiddenCam.state.ENUM.SIGNALSTATE;
import com.xiaopeng.hiddenCam.state.ENUM.XPUREADY;
import com.xiaopeng.hiddenCam.state.StateCollection;
import com.xiaopeng.hiddenCam.utils.FileSaver;
import com.xiaopeng.hiddenCam.utils.LogUtils;
import com.xiaopeng.hiddenCam.utils.NetworkUtils;
import com.xiaopeng.hiddenCam.utils.PropertiesUtil;
import com.xiaopeng.hiddenCam.utils.UuidHelper;
import com.xiaopeng.hiddenCam.utils.jni.ImageUtils;
import com.xiaopeng.hiddenCam.utils.jni.JniUtil;
import com.xiaopeng.lib.framework.moduleinterface.ipcmodule.IIpcService;
import com.xiaopeng.libconfig.ipc.IpcConfig;
import defpackage.x3;
import java.io.File;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import org.greenrobot.eventbus.ThreadMode;
import org.greenrobot.eventbus.l;
/* loaded from: classes.dex */
public class CameraService extends Service implements l4 {
    public static i4 A;
    public static f4 z;
    Messenger b;
    private Car c;
    public h4 d;
    public b4 e;
    public e4 f;
    public c4 g;
    public a4 h;
    public d4 i;
    public g4 j;
    public j4 k;
    public ScheduledExecutorService l = null;
    private LocationManager m = null;
    GpsStatus.Listener n = null;
    Handler o;
    private CarEcuManager.CarEcuEventCallback p;
    public com.xiaopeng.hiddenCam.oss.c q;
    private m3 r;
    private u3 s;
    private w3 t;
    private v3 u;
    private o3 v;
    private p3 w;
    private z3 x;
    public static StateCollection y = StateCollection.getInstance();
    public static float B = 0.0f;
    static OssService C = null;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class a implements GpsStatus.Listener {
        a() {
        }

        @Override // android.location.GpsStatus.Listener
        public void onGpsStatusChanged(int i) {
            if (i == 4) {
                DrivingData.getInstance().setGSV_info(CameraService.this.m.getGpsStatus(null));
                JniUtil.setGsvFlag(true);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class b implements ServiceConnection {
        b() {
        }

        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            try {
                CameraService.z = new f4((EcuEventCallback) CameraService.this.p, CameraService.this.c, CameraService.y);
                CameraService.this.d = new h4((EcuEventCallback) CameraService.this.p, CameraService.this.c);
                CameraService.this.e = new b4((EcuEventCallback) CameraService.this.p, CameraService.this.c);
                CameraService.this.f = new e4((EcuEventCallback) CameraService.this.p, CameraService.this.c);
                CameraService.this.g = new c4((EcuEventCallback) CameraService.this.p, CameraService.this.c);
                CameraService.A = new i4((EcuEventCallback) CameraService.this.p, CameraService.this.c, CameraService.y);
                CameraService.this.h = new a4((EcuEventCallback) CameraService.this.p, CameraService.this.c);
                CameraService.this.i = new d4((EcuEventCallback) CameraService.this.p, CameraService.this.c, CameraService.y);
                CameraService.this.j = new g4((EcuEventCallback) CameraService.this.p, CameraService.this.c);
                CameraService.this.k = new j4((EcuEventCallback) CameraService.this.p, CameraService.this.c);
                CameraService.y.setVinCode(CameraService.this.f.a().getVinCode());
                LogUtils.d(" vincode: " + CameraService.y.getVinCode());
                if (CameraService.y.getVinCode() == "") {
                    CameraService.y.setVinCode("chamovins");
                    CameraService.y.setVinCode("chamovins");
                }
                String vin2uuid = UuidHelper.vin2uuid(CameraService.y.getVinCode());
                LogUtils.d("vin uuid = " + vin2uuid);
                CameraService.y.setVinCode(vin2uuid);
                CameraService.C.h = CameraService.y.getVinCode();
                LogUtils.d(" onServiceConnected() called with: name = [" + componentName + "], service = [" + iBinder + "]");
            } catch (Exception e) {
                LogUtils.e(e.getMessage());
            }
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
            LogUtils.d("onServiceDisconnected() called with: name = [" + componentName + "]");
        }
    }

    /* loaded from: classes.dex */
    static class c implements Runnable {
        final /* synthetic */ int b;

        c(int i) {
            this.b = i;
        }

        @Override // java.lang.Runnable
        public void run() {
            CameraService.C.a("Venue" + String.valueOf(this.b) + ".bin");
        }
    }

    /* loaded from: classes.dex */
    static class d extends Handler {
        d(Context context) {
            context.getApplicationContext();
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (message.what != 1) {
                super.handleMessage(message);
            }
        }
    }

    private boolean m() {
        for (int i = 0; i < x3.k.length; i++) {
            if (Math.abs(y.getLast_gps().a - x3.k[i].a) < 0.002d && Math.abs(y.getLast_gps().b - x3.k[i].b) < 0.002d) {
                LogUtils.d("black gps");
                return false;
            }
        }
        return true;
    }

    public static void n() {
        LogUtils.e("powerModelOff");
        DrivingData.getInstance().setBCM_DriverDroorLockSt(1);
        DrivingData.getInstance().setPowerModel(1);
        if (y.getAvmsocket() != null) {
            y.getAvmsocket().b();
        }
        if (y.getAvmsocket_on() != null) {
            y.getAvmsocket_on().b();
        }
        y.setSignal_state(SIGNALSTATE.ACTIVE_STUDDY.value);
        y.poweron_indoor = INDOORSTATUS.INITIAL;
    }

    private void o() {
        if (this.n != null) {
            return;
        }
        LogUtils.d("registerGnss");
        this.n = new a();
        this.m.addGpsStatusListener(this.n);
    }

    private boolean p() {
        try {
            String hardwareCarType = Car.getHardwareCarType();
            LogUtils.d(" 车型: " + hardwareCarType);
            LogUtils.d(" strCarType: " + hardwareCarType);
            int i = SystemProperties.getInt("persist.sys.xiaopeng.XPU", 0);
            int i2 = SystemProperties.getInt("persist.sys.xiaopeng.SCU", 0);
            int i3 = SystemProperties.getInt("persist.sys.xiaopeng.Lidar_F", 0);
            int i4 = SystemProperties.getInt("persist.sys.xiaopeng.Lidar_R", 0);
            if (hardwareCarType.contains("D21")) {
                y.setCarType(CARTYPE.D21.value);
                y.setCfc(SystemProperties.getInt("persist.sys.xiaopeng.configCode", 0));
                if (y.getCfc() == CFC.LOW.value) {
                    return false;
                }
            } else if (hardwareCarType.contains("E28")) {
                y.setCarType(CARTYPE.E28.value);
                if (i == 1) {
                    y.setCfc(CFC.HIGH.value);
                    if (i3 == 1 || i4 == 1) {
                        y.setCfc(4);
                    }
                } else if (i2 != 1) {
                    return false;
                } else {
                    y.setCfc(CFC.MID.value);
                }
                LogUtils.d(" cfc scu val = " + i2 + ", xpu val = " + i + ", cfc val = " + y.getCfc());
            } else if (hardwareCarType.contains("D55")) {
                y.setCarType(CARTYPE.D55.value);
                if (i == 1) {
                    y.setCfc(CFC.HIGH.value);
                    if (i3 == 1 || i4 == 1) {
                        y.setCfc(4);
                    }
                    LogUtils.d(" cfc scu val = " + y.getCfc());
                } else {
                    y.setCfc(CFC.LOW.value);
                    return false;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        this.c = Car.createCar(this, new b());
        this.c.connect();
        if (y.getCarType() >= CARTYPE.E28.value) {
            this.l.scheduleWithFixedDelay(this.s, 3000L, 100L, TimeUnit.MILLISECONDS);
            this.l.scheduleWithFixedDelay(this.t, 3000L, 300L, TimeUnit.MILLISECONDS);
            this.l.scheduleWithFixedDelay(this.x, 3000L, 1000L, TimeUnit.MILLISECONDS);
            this.l.scheduleWithFixedDelay(this.u, 3000L, 300L, TimeUnit.MILLISECONDS);
            if (y.getCfc() >= CFC.HIGH.value) {
                this.l.scheduleWithFixedDelay(this.v, 5000L, 100L, TimeUnit.MILLISECONDS);
                this.l.scheduleWithFixedDelay(this.w, 5000L, 300L, TimeUnit.MILLISECONDS);
            }
        }
        return true;
    }

    private void q() {
        GpsStatus.Listener listener;
        LocationManager locationManager = this.m;
        if (locationManager == null || (listener = this.n) == null) {
            return;
        }
        locationManager.removeGpsStatusListener(listener);
        this.n = null;
    }

    @Override // defpackage.l4
    public boolean d() {
        return m();
    }

    @Override // defpackage.l4
    public LocationManager e() {
        return this.m;
    }

    @Override // defpackage.l4
    public Handler f() {
        return this.o;
    }

    @Override // defpackage.l4
    public void g() {
        l();
    }

    @Override // defpackage.l4
    public GpsStatus.Listener h() {
        return this.n;
    }

    @Override // defpackage.l4
    public f4 i() {
        return z;
    }

    @Override // defpackage.l4
    public void j() {
        o();
    }

    @Override // defpackage.l4
    public void k() {
        z.a();
    }

    public void l() {
        try {
            int size = FileSaver.mapDownloadedInfos.size();
            if (size < 100) {
                return;
            }
            LogUtils.d("check the garage quantity: " + size);
            File file = new File(FileSaver.Constant.file_root + "downloaded_info.json");
            if (file.exists()) {
                A.a(33, FileSaver.Constant.file_root, "downloaded_info.json");
                file.delete();
                FileSaver.mapDownloadedInfos.clear();
                LogUtils.d("downloaded_info.json deleted successfully!");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        this.b = new Messenger(new d(this));
        return this.b.getBinder();
    }

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        JniUtil.init(1);
        ImageUtils.init();
        this.o = new Handler(getApplicationContext().getMainLooper());
        this.l = new ScheduledThreadPoolExecutor(5);
        if (this.m == null) {
            this.m = (LocationManager) getSystemService(RequestParameters.SUBRESOURCE_LOCATION);
        }
        if (C == null) {
            C = new OssService(getApplicationContext());
        }
        new NetworkUtils(this, y, this.o);
        y.setCamera_inited(false);
        this.r = new m3(y, this);
        this.r.e();
        this.p = new EcuEventCallback(C, y, this.r);
        this.q = new com.xiaopeng.hiddenCam.oss.c(C, y, this, this, this.r);
        C.a((com.xiaopeng.hiddenCam.oss.b) this.q);
        PropertiesUtil.loadProperties(this, C);
        LogUtils.d("BuildConfig.FLAVOR_CODE = 4");
        this.s = new u3(C, y, this);
        this.t = new w3(C, y, this, this.r);
        this.u = new v3(C, y, this, this.r);
        this.v = new o3(C, y, this);
        this.w = new p3(C, y, this);
        this.x = new z3(C, y, this);
        if (p()) {
            y.setStop_cam(CAMERA.CAMERA_STATE_NOT_START.value);
            y.setLast_gps(new x3.b());
            y.getLast_gps().a = 0.0d;
            y.getLast_gps().b = 0.0d;
            org.greenrobot.eventbus.c.c().c(this);
        }
    }

    @Override // android.app.Service
    public void onDestroy() {
        super.onDestroy();
        this.l.shutdown();
        this.r.a(true);
        JniUtil.release();
        LogUtils.d(" onDestroy called");
        this.c.disconnect();
        if (this.r.c() != null && this.r.b() != null) {
            this.r.c().removeViewImmediate(this.r.b());
            LogUtils.d("check release windomanger");
            this.r.a((WindowManager) null);
            this.r.a((SurfaceView) null);
        }
        JniUtil.release();
    }

    @l(threadMode = ThreadMode.POSTING)
    public void onEvent(IIpcService.IpcMessageEvent ipcMessageEvent) {
        if (ipcMessageEvent == null || ipcMessageEvent.getPayloadData() == null) {
            return;
        }
        LogUtils.d("[chamo Ipc], onReceiverData: " + ipcMessageEvent);
        String string = ipcMessageEvent.getPayloadData().getString(IpcConfig.IPCKey.STRING_MSG);
        if (string == null) {
            return;
        }
        LogUtils.d(string);
        int asInt = new JsonParser().parse(string).getAsJsonObject().get("bizType").getAsInt();
        if (y.isScreen_light() && asInt == 19) {
            LogUtils.d("[chamo Ipc], onReceiverData: " + y.isScreen_light());
            y.setXpu_ready_flag(XPUREADY.NOT_READY);
        }
    }

    public static void a(int i) {
        if (C != null) {
            new Thread(new c(i)).start();
        }
    }

    @Override // defpackage.l4
    public c4 b() {
        return this.g;
    }

    @Override // defpackage.l4
    public void c() {
        q();
    }

    public static void a(int i, int i2) {
        i4.a(i, i2);
    }

    @Override // defpackage.l4
    public boolean a(int i, String str, String str2) {
        return A.a(i, str, str2);
    }

    @Override // defpackage.l4
    public void a() {
        this.i.a();
    }
}
