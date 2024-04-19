package com.xiaopeng.lib.framework.configuration.internal;

import android.app.Application;
import android.content.Context;
import android.content.pm.PackageManager;
import com.xiaopeng.lib.utils.LogUtils;
import java.lang.ref.WeakReference;
/* loaded from: classes.dex */
public class Proxy {
    private static final String TAG = "Proxy";
    private String mAppID;
    private WeakReference<Application> mApplication;
    private Connector mConnector;
    private ContextProvider mContextProvider;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public interface ContextProvider {
        String getAppID();

        String getAppPackageName();

        int getAppVersionCode();

        String getAppVersionName();

        Context getContext();
    }

    /* loaded from: classes.dex */
    private static final class Holder {
        private static final Proxy INSTANCE = new Proxy();

        private Holder() {
        }
    }

    public static Proxy getInstance() {
        return Holder.INSTANCE;
    }

    public String getConfiguration(String str, String str2) {
        LogUtils.v(TAG, "getConfiguration key:" + str + "; default:" + str2);
        String configuration = this.mConnector.getConfiguration(str);
        return configuration == null ? str2 : configuration;
    }

    public synchronized void init(Application application, String str) {
        if (this.mApplication == null) {
            LogUtils.d(TAG, "init appID:" + str);
            this.mApplication = new WeakReference<>(application);
            this.mAppID = str;
            this.mConnector = new Connector(this.mContextProvider);
            this.mConnector.connect();
        } else {
            LogUtils.w(TAG, "Warning! init many times;");
        }
    }

    private Proxy() {
        this.mContextProvider = new ContextProvider() { // from class: com.xiaopeng.lib.framework.configuration.internal.Proxy.1
            @Override // com.xiaopeng.lib.framework.configuration.internal.Proxy.ContextProvider
            public String getAppID() {
                return Proxy.this.mAppID;
            }

            @Override // com.xiaopeng.lib.framework.configuration.internal.Proxy.ContextProvider
            public String getAppPackageName() {
                Application application = (Application) Proxy.this.mApplication.get();
                if (application != null) {
                    return application.getPackageName();
                }
                return null;
            }

            @Override // com.xiaopeng.lib.framework.configuration.internal.Proxy.ContextProvider
            public int getAppVersionCode() {
                Application application = (Application) Proxy.this.mApplication.get();
                if (application != null) {
                    try {
                        return application.getPackageManager().getPackageInfo(application.getPackageName(), 0).versionCode;
                    } catch (PackageManager.NameNotFoundException e) {
                        e.printStackTrace();
                    }
                }
                return 0;
            }

            @Override // com.xiaopeng.lib.framework.configuration.internal.Proxy.ContextProvider
            public String getAppVersionName() {
                Application application = (Application) Proxy.this.mApplication.get();
                if (application != null) {
                    try {
                        return application.getPackageManager().getPackageInfo(application.getPackageName(), 0).versionName;
                    } catch (PackageManager.NameNotFoundException e) {
                        e.printStackTrace();
                        return null;
                    }
                }
                return null;
            }

            @Override // com.xiaopeng.lib.framework.configuration.internal.Proxy.ContextProvider
            public Context getContext() {
                return (Context) Proxy.this.mApplication.get();
            }
        };
    }
}
