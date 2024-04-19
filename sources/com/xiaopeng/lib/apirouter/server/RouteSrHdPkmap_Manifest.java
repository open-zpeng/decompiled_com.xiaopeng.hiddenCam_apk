package com.xiaopeng.lib.apirouter.server;

import java.util.HashSet;
import java.util.Set;
/* loaded from: classes.dex */
public class RouteSrHdPkmap_Manifest {
    public static final String DESCRIPTOR = "com.xiaopeng.hiddenCam.RouteSrHdPkmap";
    public static final int TRANSACTION_routeNavi2HdPkmapApplyListF = 0;
    public static final int TRANSACTION_routeSr2HdPkmapBump = 6;
    public static final int TRANSACTION_routeSr2HdPkmapConfirmInfo = 2;
    public static final int TRANSACTION_routeSr2HdPkmapEvaluation = 5;
    public static final int TRANSACTION_routeSr2HdPkmapShareInfo = 4;
    public static final int TRANSACTION_routeSr2HdPkmapTrainingTips = 1;
    public static final int TRANSACTION_routeZGAutoPilot2HdMapApplyMap = 3;

    public static Set<String> getKey() {
        HashSet hashSet = new HashSet(2);
        hashSet.add("RouteSrHdPkmap");
        return hashSet;
    }

    public static String toJsonManifest() {
        return "{\"authority\":\"com.xiaopeng.hiddenCam.RouteSrHdPkmap\",\"DESCRIPTOR\":\"com.xiaopeng.hiddenCam.RouteSrHdPkmap\",\"TRANSACTION\":[{\"path\":\"routeNavi2HdPkmapApplyListF\",\"METHOD\":\"routeNavi2HdPkmapApplyListF\",\"ID\":0,\"parameter\":[]},{\"path\":\"routeSr2HdPkmapTrainingTips\",\"METHOD\":\"routeSr2HdPkmapTrainingTips\",\"ID\":1,\"parameter\":[{\"alias\":\"info\",\"name\":\"info\"}]},{\"path\":\"routeSr2HdPkmapConfirmInfo\",\"METHOD\":\"routeSr2HdPkmapConfirmInfo\",\"ID\":2,\"parameter\":[{\"alias\":\"info\",\"name\":\"info\"}]},{\"path\":\"routeZGAutoPilot2HdMapApplyMap\",\"METHOD\":\"routeZGAutoPilot2HdMapApplyMap\",\"ID\":3,\"parameter\":[{\"alias\":\"info\",\"name\":\"info\"}]},{\"path\":\"routeSr2HdPkmapShareInfo\",\"METHOD\":\"routeSr2HdPkmapShareInfo\",\"ID\":4,\"parameter\":[{\"alias\":\"info\",\"name\":\"info\"}]},{\"path\":\"routeSr2HdPkmapEvaluation\",\"METHOD\":\"routeSr2HdPkmapEvaluation\",\"ID\":5,\"parameter\":[{\"alias\":\"info\",\"name\":\"info\"}]},{\"path\":\"routeSr2HdPkmapBump\",\"METHOD\":\"routeSr2HdPkmapBump\",\"ID\":6,\"parameter\":[{\"alias\":\"info\",\"name\":\"info\"}]}]}";
    }
}
