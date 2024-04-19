package com.xiaopeng.hiddenCam.utils;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkCapabilities;
import android.os.Handler;
import com.xiaopeng.hiddenCam.state.ENUM.NETWORKFLAG;
import com.xiaopeng.hiddenCam.state.StateCollection;
/* loaded from: classes.dex */
public class NetworkUtils {
    private Context context;
    private ConnectivityManager mConnectivityMgr;
    private Handler mainHandler;
    StateCollection stateCollection;

    /* loaded from: classes.dex */
    private class NetworkCallbackImpl extends ConnectivityManager.NetworkCallback {
        ConnectivityManager mConnectivityMgr;

        private NetworkCallbackImpl() {
            this.mConnectivityMgr = (ConnectivityManager) NetworkUtils.this.context.getSystemService("connectivity");
        }

        @Override // android.net.ConnectivityManager.NetworkCallback
        public void onAvailable(Network network) {
            NetworkCapabilities networkCapabilities = this.mConnectivityMgr.getNetworkCapabilities(network);
            if (networkCapabilities != null) {
                if (networkCapabilities.hasTransport(1) || networkCapabilities.hasTransport(3)) {
                    NetworkUtils.this.stateCollection.setNetwork_flag(NETWORKFLAG.AVAILABLE.value);
                    LogUtils.d("network_flag = " + NetworkUtils.this.stateCollection.getNetwork_flag());
                }
            }
        }

        @Override // android.net.ConnectivityManager.NetworkCallback
        public void onLost(Network network) {
            this.mConnectivityMgr.getNetworkCapabilities(network);
            NetworkUtils.this.stateCollection.setNetwork_flag(NETWORKFLAG.LOST.value);
            LogUtils.d(" network_flag2 = " + NetworkUtils.this.stateCollection.getNetwork_flag());
        }
    }

    public NetworkUtils(Context context, StateCollection stateCollection, Handler handler) {
        this.mConnectivityMgr = null;
        this.context = context;
        this.stateCollection = stateCollection;
        this.mainHandler = handler;
        if (this.mConnectivityMgr == null) {
            this.mConnectivityMgr = (ConnectivityManager) context.getSystemService("connectivity");
        }
        this.mConnectivityMgr.registerDefaultNetworkCallback(new NetworkCallbackImpl(), this.mainHandler);
    }
}
