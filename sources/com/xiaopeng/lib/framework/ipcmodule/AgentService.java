package com.xiaopeng.lib.framework.ipcmodule;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.Service;
import android.content.Intent;
import android.os.Build;
import android.os.IBinder;
import android.util.Log;
import androidx.core.app.g;
/* loaded from: classes.dex */
public class AgentService extends Service {
    private static final String CHANNEL_ID = "XPENG";
    private static final String CHANNEL_NAME = "IPC";
    private static final String CONTENT = "IPC application is running";
    private static final String TAG = "AgentService";
    private static final String TITLE = "Xmart";

    private void startNotification() {
        if (Build.VERSION.SDK_INT < 26) {
            return;
        }
        Log.i(TAG, "startNotification");
        NotificationChannel notificationChannel = new NotificationChannel(CHANNEL_ID, CHANNEL_NAME, 3);
        ((NotificationManager) getApplicationContext().getSystemService("notification")).createNotificationChannel(notificationChannel);
        g.b bVar = new g.b(this, notificationChannel.getId());
        bVar.b(R.mipmap.icon_notification);
        bVar.b(TITLE);
        bVar.a((CharSequence) CONTENT);
        bVar.a(3);
        bVar.a("service");
        startForeground(100, bVar.a());
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override // android.app.Service
    public void onCreate() {
        Log.i(TAG, "onCreate");
        startNotification();
        super.onCreate();
    }

    @Override // android.app.Service
    public int onStartCommand(Intent intent, int i, int i2) {
        Log.i(TAG, "onStartCommand:\t" + i2 + "\tflgs:\t" + i);
        IpcServiceImpl.getInstance().init();
        return super.onStartCommand(intent, i, i2);
    }
}
