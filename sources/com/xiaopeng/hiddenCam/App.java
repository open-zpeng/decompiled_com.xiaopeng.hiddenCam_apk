package com.xiaopeng.hiddenCam;

import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.os.StrictMode;
import android.os.UserHandle;
import android.provider.Settings;
import com.xiaopeng.lib.framework.ipcmodule.IpcModuleEntry;
import com.xiaopeng.lib.framework.module.Module;
import com.xiaopeng.lib.framework.moduleinterface.ipcmodule.IIpcService;
import com.xiaopeng.lib.utils.info.BuildInfoUtils;
/* loaded from: classes.dex */
public class App extends Application {
    private static App b;

    public static App a() {
        return b;
    }

    @Override // android.app.Application
    public void onCreate() {
        super.onCreate();
        b = this;
        Context applicationContext = getApplicationContext();
        Settings.Secure.putString(applicationContext.getContentResolver(), "accessibility_enabled", BuildInfoUtils.BID_WAN);
        Intent intent = new Intent(applicationContext, CameraService.class);
        intent.setPackage(applicationContext.getPackageName());
        intent.setAction(null);
        StrictMode.setThreadPolicy(new StrictMode.ThreadPolicy.Builder().permitAll().build());
        Module.register(IpcModuleEntry.class, new IpcModuleEntry(this));
        ((IIpcService) Module.get(IpcModuleEntry.class).get(IIpcService.class)).init();
        applicationContext.startServiceAsUser(intent, UserHandle.CURRENT);
    }
}
