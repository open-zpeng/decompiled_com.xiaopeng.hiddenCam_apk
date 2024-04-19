package defpackage;

import com.xiaopeng.hiddenCam.oss.OssService;
import java.io.File;
import java.util.ArrayList;
/* compiled from: MapMgr.java */
/* renamed from: m4  reason: default package */
/* loaded from: classes.dex */
public class m4 {
    private static ArrayList<Object> a = new ArrayList<>();

    public static boolean a() {
        a.clear();
        return new File(OssService.u).exists();
    }
}
