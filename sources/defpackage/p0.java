package defpackage;

import android.content.Context;
import android.os.Process;
import androidx.core.app.b;
/* compiled from: PermissionChecker.java */
/* renamed from: p0  reason: default package */
/* loaded from: classes.dex */
public final class p0 {
    public static int a(Context context, String str, int i, int i2, String str2) {
        if (context.checkPermission(str, i, i2) == -1) {
            return -1;
        }
        String a = b.a(str);
        if (a == null) {
            return 0;
        }
        if (str2 == null) {
            String[] packagesForUid = context.getPackageManager().getPackagesForUid(i2);
            if (packagesForUid == null || packagesForUid.length <= 0) {
                return -1;
            }
            str2 = packagesForUid[0];
        }
        return b.a(context, a, str2) != 0 ? -2 : 0;
    }

    public static int a(Context context, String str) {
        return a(context, str, Process.myPid(), Process.myUid(), context.getPackageName());
    }
}
