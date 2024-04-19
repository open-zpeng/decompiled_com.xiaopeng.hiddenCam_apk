package defpackage;

import android.content.Context;
import android.hardware.Camera;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.WindowManager;
import com.uc.crashsdk.export.LogType;
import com.xiaopeng.hiddenCam.state.ENUM.CAMERA;
import com.xiaopeng.hiddenCam.state.ENUM.CARTYPE;
import com.xiaopeng.hiddenCam.state.StateCollection;
import com.xiaopeng.hiddenCam.utils.LogUtils;
/* compiled from: CarCamera.java */
/* renamed from: m3  reason: default package */
/* loaded from: classes.dex */
public class m3 {
    StateCollection a;
    public Camera b = null;
    private SurfaceHolder c = null;
    private WindowManager d = null;
    private SurfaceView e = null;
    Context f;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: CarCamera.java */
    /* renamed from: m3$b */
    /* loaded from: classes.dex */
    public class b implements SurfaceHolder.Callback {
        private b() {
        }

        @Override // android.view.SurfaceHolder.Callback
        public void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i2, int i3) {
        }

        @Override // android.view.SurfaceHolder.Callback
        public void surfaceCreated(SurfaceHolder surfaceHolder) {
        }

        @Override // android.view.SurfaceHolder.Callback
        public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
            LogUtils.d("surface destroyed");
            m3.this.c = null;
            m3.this.a();
        }
    }

    public m3(StateCollection stateCollection, Context context) {
        this.a = stateCollection;
        this.f = context;
    }

    public SurfaceView b() {
        return this.e;
    }

    public WindowManager c() {
        return this.d;
    }

    public Camera d() {
        return this.b;
    }

    public void e() {
        LogUtils.d(" init camera ING");
        if (this.a.isCamera_inited()) {
            this.a.setCamera_inited(false);
            return;
        }
        this.a.setCamera_inited(true);
        this.e = new SurfaceView(this.f);
        SurfaceHolder holder = this.e.getHolder();
        this.c = holder;
        this.e.setZOrderOnTop(true);
        holder.setFormat(-3);
        holder.addCallback(new b());
        this.d = (WindowManager) this.f.getSystemService("window");
        WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams(1, 1, 2006, 0, -2);
        layoutParams.gravity = 51;
        layoutParams.flags = 40;
        layoutParams.format = 1;
        this.d.addView(this.e, layoutParams);
    }

    public void f() {
        LogUtils.i("stop_cam status: " + this.a.getStop_cam());
        this.a.setStop_cam(CAMERA.CAMERA_STATE_WORKING.value);
        if (this.a.getCarType() == CARTYPE.NOT_INITIAL.value) {
            return;
        }
        LogUtils.e("start cam");
        try {
            this.b = Camera.open(2);
            if (this.b == null) {
                LogUtils.d("camera is null!!");
                return;
            }
            this.a.setFirst_start_cam(true);
            this.b.setPreviewCallbackWithBuffer(new n3(this.a, this));
            int i = this.a.getCarType() == CARTYPE.D21.value ? 722 : 724;
            LogUtils.d("carType555555: " + this.a.getCarType());
            int i2 = i * LogType.UNEXP_ANR * 2;
            if (this.a.getmPreBuffer() == null) {
                this.a.setmPreBuffer(new byte[i2]);
            }
            this.b.addCallbackBuffer(this.a.getmPreBuffer());
            try {
                this.b.setPreviewDisplay(this.c);
                this.b.startPreview();
            } catch (Exception e) {
                e.printStackTrace();
                Camera camera = this.b;
                if (camera != null) {
                    this.b = null;
                    camera.release();
                }
            }
        } catch (Exception e2) {
            LogUtils.d("camera open failed!!");
            e2.printStackTrace();
        }
    }

    public void a(Camera camera) {
        this.b = camera;
    }

    public void a(WindowManager windowManager) {
        this.d = windowManager;
    }

    public void a(SurfaceView surfaceView) {
        this.e = surfaceView;
    }

    public void a() {
        LogUtils.e("close camera");
        this.a.setStop_cam(CAMERA.CAMERA_STATE_FINISHED.value);
        LogUtils.e("close camera");
        Camera camera = this.b;
        if (camera != null) {
            this.b = null;
            camera.stopPreview();
            camera.release();
        }
    }

    public void a(boolean z) {
        if (this.a.getStop_cam() == CAMERA.CAMERA_STATE_FINISHED.value) {
            this.a.setStop_cam(CAMERA.CAMERA_STATE_NOT_START.value);
        }
        this.a.setContinus_img_proc_fail_count(0);
    }
}
