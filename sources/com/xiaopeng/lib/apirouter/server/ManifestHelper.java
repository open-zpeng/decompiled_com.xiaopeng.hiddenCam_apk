package com.xiaopeng.lib.apirouter.server;

import android.os.IBinder;
import android.util.Pair;
import androidx.annotation.Keep;
import java.util.HashMap;
@Keep
/* loaded from: classes.dex */
public class ManifestHelper {
    public static HashMap<String, Pair<IBinder, String>> mapping = new HashMap<>();

    static {
        Pair<IBinder, String> pair = new Pair<>(new SpeechOverAllObserver_Stub(), SpeechOverAllObserver_Manifest.toJsonManifest());
        for (String str : SpeechOverAllObserver_Manifest.getKey()) {
            mapping.put(str, pair);
        }
        Pair<IBinder, String> pair2 = new Pair<>(new IpcRouterService_Stub(), IpcRouterService_Manifest.toJsonManifest());
        for (String str2 : IpcRouterService_Manifest.getKey()) {
            mapping.put(str2, pair2);
        }
        Pair<IBinder, String> pair3 = new Pair<>(new RouteSrHdPkmap_Stub(), RouteSrHdPkmap_Manifest.toJsonManifest());
        for (String str3 : RouteSrHdPkmap_Manifest.getKey()) {
            mapping.put(str3, pair3);
        }
    }
}
