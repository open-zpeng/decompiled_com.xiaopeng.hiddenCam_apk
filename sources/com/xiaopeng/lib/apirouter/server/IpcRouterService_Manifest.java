package com.xiaopeng.lib.apirouter.server;

import java.util.HashSet;
import java.util.Set;
/* loaded from: classes.dex */
public class IpcRouterService_Manifest {
    public static final String DESCRIPTOR = "com.xiaopeng.hiddenCam.IpcRouterService";
    public static final int TRANSACTION_onReceiverData = 0;

    public static Set<String> getKey() {
        HashSet hashSet = new HashSet(2);
        hashSet.add("IpcRouterService");
        return hashSet;
    }

    public static String toJsonManifest() {
        return "{\"authority\":\"com.xiaopeng.hiddenCam.IpcRouterService\",\"DESCRIPTOR\":\"com.xiaopeng.hiddenCam.IpcRouterService\",\"TRANSACTION\":[{\"path\":\"onReceiverData\",\"METHOD\":\"onReceiverData\",\"ID\":0,\"parameter\":[{\"alias\":\"id\",\"name\":\"id\"},{\"alias\":\"bundle\",\"name\":\"bundle\"}]}]}";
    }
}
