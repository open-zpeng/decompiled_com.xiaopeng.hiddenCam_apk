package com.xiaopeng.hiddenCam.apirouterClient;

import android.net.Uri;
import android.os.RemoteException;
import com.xiaopeng.hiddenCam.utils.LogUtils;
import com.xiaopeng.lib.apirouter.ApiRouter;
/* loaded from: classes.dex */
public class RouteHdPkMap2NaviClient {
    private static final String navi_SERVICE_CLASS = "com.xiaopeng.montecarlo.MapVPAService";

    public static void routeHdPkMap2NaviListFVersion(String str) {
        LogUtils.e("send to navi: " + str);
        Uri.Builder builder = new Uri.Builder();
        builder.authority(navi_SERVICE_CLASS).path("update").appendQueryParameter("version", str);
        try {
            ApiRouter.route(builder.build());
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }
}
