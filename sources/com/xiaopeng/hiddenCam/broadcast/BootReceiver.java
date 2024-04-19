package com.xiaopeng.hiddenCam.broadcast;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.xiaopeng.lib.utils.LogUtils;
/* loaded from: classes.dex */
public class BootReceiver extends BroadcastReceiver {
    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        intent.getAction();
        LogUtils.i("chamo init", "onReceive");
    }
}
