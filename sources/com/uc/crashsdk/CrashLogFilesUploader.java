package com.uc.crashsdk;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import android.os.Process;
import com.xiaopeng.speech.protocol.bean.stats.StatCommonBean;
import java.io.File;
/* compiled from: ProGuard */
/* loaded from: classes.dex */
public class CrashLogFilesUploader extends Service {
    static final /* synthetic */ boolean a = !CrashLogFilesUploader.class.desiredAssertionStatus();
    private boolean b = false;

    public static void a(int i, Object[] objArr) {
        if (i == 600) {
            try {
                com.uc.crashsdk.a.a.b("Service uploading logs ...");
                e.a(e.i(), true, true);
            } catch (Throwable th) {
                com.uc.crashsdk.a.g.a(th);
            }
            com.uc.crashsdk.a.f.a(2, new com.uc.crashsdk.a.e(StatCommonBean.EVENT_SCENE_SETTING_ID, objArr));
        } else if (i != 601) {
            if (!a) {
                throw new AssertionError();
            }
        } else if (!a && objArr == null) {
            throw new AssertionError();
        } else {
            com.uc.crashsdk.a.a.b("Crash log upload service done, exiting");
            ((Service) objArr[0]).stopSelf();
            Process.killProcess(Process.myPid());
        }
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override // android.app.Service
    public int onStartCommand(Intent intent, int i, int i2) {
        if (h.a()) {
            if (this.b) {
                return 2;
            }
            this.b = true;
            com.uc.crashsdk.a.f.a(1, new com.uc.crashsdk.a.e(600, new Object[]{this}));
            return 2;
        }
        throw new RuntimeException("Must initialize crashsdk for current process (" + e.g() + ", " + Process.myPid() + "), or set CustomInfo.mUploadUcebuCrashLog as false!");
    }

    public static void a(Context context) {
        String T = h.T();
        File file = new File(T);
        if (file.exists() && file.isDirectory()) {
            File[] listFiles = file.listFiles();
            if (listFiles == null) {
                com.uc.crashsdk.a.a.c("Ucebu can not list folder: " + T);
                return;
            }
            for (File file2 : listFiles) {
                if (file2.isFile() && file2.getName().contains("ucebu")) {
                    try {
                        context.startService(new Intent(context, CrashLogFilesUploader.class));
                        return;
                    } catch (Exception e) {
                        com.uc.crashsdk.a.g.a(e);
                        return;
                    }
                }
            }
        }
    }
}
