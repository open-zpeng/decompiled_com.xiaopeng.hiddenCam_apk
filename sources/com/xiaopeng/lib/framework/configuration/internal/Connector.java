package com.xiaopeng.lib.framework.configuration.internal;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.IBinder;
import android.os.RemoteException;
import com.xiaopeng.lib.framework.configuration.ConfigurationDataImpl;
import com.xiaopeng.lib.framework.configuration.IConfigurationServiceCallback;
import com.xiaopeng.lib.framework.configuration.IConfigurationServiceInterface;
import com.xiaopeng.lib.framework.configuration.internal.Proxy;
import com.xiaopeng.lib.framework.moduleinterface.configurationmodule.ConfigurationChangeEvent;
import com.xiaopeng.lib.utils.LogUtils;
import java.util.ArrayList;
import java.util.List;
import org.greenrobot.eventbus.c;
/* loaded from: classes.dex */
final class Connector {
    private static final String REMOTE_CLASS_NAME = "com.xiaopeng.configurationcenter.connector.RemoteService";
    private static final String REMOTE_PACKAGE_NAME = "com.xiaopeng.configurationcenter";
    private static final String REMOTE_SERVICE_ACTION = "com.xiaopeng.configurationcenter.connector.RemoteService.CONNECT";
    private static final String TAG = "Connector";
    private Handler mHandler;
    private Proxy.ContextProvider mProvider;
    private volatile IConfigurationServiceInterface mService;
    private final byte[] mLock = new byte[0];
    private ServiceConnection mServiceConnection = new ServiceConnection() { // from class: com.xiaopeng.lib.framework.configuration.internal.Connector.3
        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            synchronized (Connector.this.mLock) {
                Connector.this.mService = IConfigurationServiceInterface.Stub.asInterface(iBinder);
                LogUtils.v(Connector.TAG, "onServiceConnected:" + componentName.getPackageName() + "; service:" + Connector.this.mService);
                if (Connector.this.mService == null) {
                    return;
                }
                try {
                    Connector.this.mService.subscribe(Connector.this.mProvider.getAppID(), Connector.this.mProvider.getAppVersionName(), Connector.this.mProvider.getAppVersionCode(), Connector.this.mCallback);
                    Connector.this.mService.asBinder().linkToDeath(Connector.this.mDeathRecipient, 0);
                } catch (RemoteException e) {
                    e.printStackTrace();
                }
            }
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
            LogUtils.v(Connector.TAG, "onServiceDisconnected:" + componentName.getPackageName() + "; service:" + Connector.this.mService);
            synchronized (Connector.this.mLock) {
                if (Connector.this.mService != null) {
                    try {
                        Connector.this.mService.unsubscribe(Connector.this.mProvider.getAppID());
                        Connector.this.mService.asBinder().unlinkToDeath(Connector.this.mDeathRecipient, 0);
                    } catch (RemoteException e) {
                        e.printStackTrace();
                    }
                    Connector.this.mService = null;
                }
            }
            Connector.this.tryReconnect();
        }
    };
    private IBinder.DeathRecipient mDeathRecipient = new IBinder.DeathRecipient() { // from class: com.xiaopeng.lib.framework.configuration.internal.Connector.4
        @Override // android.os.IBinder.DeathRecipient
        public void binderDied() {
            LogUtils.v(Connector.TAG, "DeathRecipient binderDied, service:" + Connector.this.mService);
            synchronized (Connector.this.mLock) {
                if (Connector.this.mService == null) {
                    return;
                }
                Connector.this.mService.asBinder().unlinkToDeath(Connector.this.mDeathRecipient, 0);
                Connector.this.mService = null;
                Connector.this.tryReconnect();
            }
        }
    };
    private IConfigurationServiceCallback mCallback = new IConfigurationServiceCallback.Stub() { // from class: com.xiaopeng.lib.framework.configuration.internal.Connector.5
        @Override // com.xiaopeng.lib.framework.configuration.IConfigurationServiceCallback
        public void onConfigurationChanged(List<ConfigurationDataImpl> list) throws RemoteException {
            ArrayList arrayList;
            ConfigurationChangeEvent configurationChangeEvent = new ConfigurationChangeEvent();
            if (list != null) {
                arrayList = new ArrayList(list.size());
                arrayList.addAll(list);
            } else {
                arrayList = null;
            }
            configurationChangeEvent.setChangeList(arrayList);
            LogUtils.v(Connector.TAG, "onConfigurationChanged event:" + configurationChangeEvent);
            c.c().a(configurationChangeEvent);
        }
    };

    /* JADX INFO: Access modifiers changed from: package-private */
    public Connector(Proxy.ContextProvider contextProvider) {
        this.mProvider = contextProvider;
        HandlerThread handlerThread = new HandlerThread("thread-connector");
        handlerThread.start();
        this.mHandler = new Handler(handlerThread.getLooper());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bindService() {
        Context context = this.mProvider.getContext();
        LogUtils.d(TAG, "bindService context:" + context);
        if (context != null) {
            Intent intent = new Intent();
            intent.setComponent(new ComponentName("com.xiaopeng.configurationcenter", REMOTE_CLASS_NAME));
            intent.setAction(REMOTE_SERVICE_ACTION);
            context.bindService(intent, this.mServiceConnection, 1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void tryReconnect() {
        this.mHandler.postDelayed(new Runnable() { // from class: com.xiaopeng.lib.framework.configuration.internal.Connector.2
            @Override // java.lang.Runnable
            public void run() {
                synchronized (Connector.this.mLock) {
                    if (Connector.this.mService != null) {
                        return;
                    }
                    Connector.this.bindService();
                }
            }
        }, 2000L);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void connect() {
        LogUtils.v(TAG, "connect");
        this.mHandler.post(new Runnable() { // from class: com.xiaopeng.lib.framework.configuration.internal.Connector.1
            @Override // java.lang.Runnable
            public void run() {
                Connector.this.bindService();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String getConfiguration(String str) {
        String configuration;
        synchronized (this.mLock) {
            if (this.mService != null) {
                try {
                    configuration = this.mService.getConfiguration(this.mProvider.getAppID(), str);
                } catch (RemoteException e) {
                    e.printStackTrace();
                }
            } else {
                LogUtils.e(TAG, "getConfiguration key:" + str + " but service is null, has the service been connected?");
            }
            configuration = null;
        }
        return configuration;
    }
}
