package defpackage;

import com.xiaopeng.hiddenCam.oss.OssService;
import com.xiaopeng.hiddenCam.state.StateCollection;
import com.xiaopeng.hiddenCam.utils.FileSaver;
import com.xiaopeng.hiddenCam.utils.jni.ImageUtils;
/* compiled from: ProcessAvmYuvsRunable.java */
/* renamed from: w3  reason: default package */
/* loaded from: classes.dex */
public class w3 extends r3 {
    public w3(OssService ossService, StateCollection stateCollection, l4 l4Var, m3 m3Var) {
        super(ossService, stateCollection, l4Var, m3Var);
    }

    @Override // defpackage.r3
    protected boolean a(String str) {
        return ImageUtils.processYuvsStitch();
    }

    @Override // defpackage.r3
    protected String b() {
        return FileSaver.Constant.fix_yuv_prefix1;
    }

    @Override // defpackage.r3
    protected void d() {
        super.d();
    }

    @Override // defpackage.r3
    protected void e() {
    }
}
