package com.xiaopeng.hiddenCam;

import android.os.Bundle;
import androidx.appcompat.app.d;
import com.xiaopeng.hiddenCam.utils.LogUtils;
/* loaded from: classes.dex */
public class MainActivity extends d {
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.appcompat.app.d, androidx.fragment.app.b, androidx.core.app.d, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        LogUtils.i("start activity!!!");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.appcompat.app.d, androidx.fragment.app.b, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.appcompat.app.d, androidx.fragment.app.b, android.app.Activity
    public void onStart() {
        super.onStart();
    }
}
