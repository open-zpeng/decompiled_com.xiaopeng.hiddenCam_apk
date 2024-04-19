package defpackage;

import android.hardware.Camera;
import com.xiaopeng.hiddenCam.CameraService;
import com.xiaopeng.hiddenCam.state.ENUM.CARTYPE;
import com.xiaopeng.hiddenCam.state.ENUM.IMAGEPRO;
import com.xiaopeng.hiddenCam.state.StateCollection;
import com.xiaopeng.hiddenCam.utils.FileSaver;
import com.xiaopeng.hiddenCam.utils.LogUtils;
import com.xiaopeng.hiddenCam.utils.jni.ImageUtils;
/* compiled from: PreviewCallback.java */
/* renamed from: n3  reason: default package */
/* loaded from: classes.dex */
public class n3 implements Camera.PreviewCallback {
    StateCollection a;
    m3 b;

    public n3(StateCollection stateCollection, m3 m3Var) {
        this.a = stateCollection;
        this.b = m3Var;
    }

    @Override // android.hardware.Camera.PreviewCallback
    public void onPreviewFrame(byte[] bArr, Camera camera) {
        LogUtils.d("onPreviewFrame");
        if (this.a.isFirst_start_cam()) {
            this.a.setFirst_start_cam(false);
            if (camera == null) {
                return;
            }
            Camera.Parameters cmdControlParameters = camera.getCmdControlParameters();
            cmdControlParameters.setAvmDisplayMode(this.a.getCarType() == CARTYPE.D21.value ? 14 : 8);
            camera.setCmdControlParameters(cmdControlParameters);
            this.a.setResetImgProcFlag(IMAGEPRO.IMAGE_PROC_FLAG_RESET.value);
            camera.addCallbackBuffer(this.a.getmPreBuffer());
            LogUtils.d(" set avm type finished");
            return;
        }
        long currentTimeMillis = System.currentTimeMillis();
        int[] iArr = new int[x3.f * x3.g * 4];
        byte[] bArr2 = new byte[x3.j];
        LogUtils.d(" log time cost11111: " + (System.currentTimeMillis() - currentTimeMillis));
        int image = ImageUtils.getImage(iArr, bArr, bArr2, this.a.getResetImgProcFlag(), x3.f, x3.g, this.a.getCarType());
        LogUtils.d(" log time cost22222: " + (System.currentTimeMillis() - currentTimeMillis) + " return val = " + image);
        this.a.setResetImgProcFlag(IMAGEPRO.IMAGE_PROC_FLAG_IDEL.value);
        if (image == 1) {
            this.a.setContinus_img_proc_fail_count(0);
        } else if (image <= -1) {
            StateCollection stateCollection = this.a;
            stateCollection.setContinus_img_proc_fail_count(stateCollection.getContinus_img_proc_fail_count() + 1);
            LogUtils.e("continus_img_proc_fail_count " + this.a.getContinus_img_proc_fail_count());
            if (this.a.getContinus_img_proc_fail_count() > 12 || image == -2) {
                this.b.a();
                FileSaver.check_extrinsic_exist();
                CameraService.A.a(11, FileSaver.Constant.file_root, "extrinsicParam.json");
                return;
            }
        }
        camera.addCallbackBuffer(this.a.getmPreBuffer());
    }
}
