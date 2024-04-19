package defpackage;

import com.xiaopeng.hiddenCam.oss.OssService;
import com.xiaopeng.hiddenCam.state.StateCollection;
import com.xiaopeng.hiddenCam.utils.FileSaver;
import com.xiaopeng.hiddenCam.utils.LogUtils;
/* compiled from: CollectInDrivingData.java */
/* renamed from: s3  reason: default package */
/* loaded from: classes.dex */
public class s3 extends q3 {
    public s3(OssService ossService, StateCollection stateCollection, l4 l4Var) {
        super(ossService, stateCollection, l4Var);
    }

    @Override // defpackage.q3
    protected String e() {
        return FileSaver.Constant.fix_yuv_prefix1;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // defpackage.q3
    public void g() {
        LogUtils.d(" stopCollecting in img ");
        super.g();
    }

    @Override // defpackage.q3
    protected void h() {
    }
}
