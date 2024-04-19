package com.uc.crashsdk.a;

import com.xiaopeng.lib.framework.moduleinterface.carcontroller.IInputController;
/* compiled from: ProGuard */
/* loaded from: classes.dex */
public class d {
    static final /* synthetic */ boolean a = !d.class.desiredAssertionStatus();
    private static boolean b = true;
    private static final Object c = new Object();
    private static boolean d = false;
    private static String e = "hsdk";
    private static String f = "alid ";
    private static String g = null;
    private static final Object h = new Object();
    private static String i = null;

    public static void a() {
        f.a(0, new e(IInputController.KEYCODE_KNOB_WIND_SPD_UP), 90000L);
    }

    public static String b() {
        try {
            return "inv" + f + "cras" + e;
        } catch (Throwable th) {
            g.b(th);
            return "";
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static byte[] c() {
        return new byte[]{6, 0, 23, 8};
    }

    public static boolean d() {
        if (!com.uc.crashsdk.e.y() && !com.uc.crashsdk.b.D()) {
            a(true);
            return b;
        }
        return true;
    }

    private static String e() {
        if (g.a(i)) {
            synchronized (h) {
                String str = com.uc.crashsdk.h.O() ? "https://wpk-auth.ucweb.com" : "https://woodpecker.uc.cn";
                i = g.a(com.uc.crashsdk.b.i(), str + "/api/crashsdk/validate", true);
            }
        }
        return i;
    }

    private static String f() {
        byte[] bArr;
        String e2;
        byte[] a2;
        byte[] bArr2;
        StringBuilder sb = new StringBuilder();
        a(sb, "platform", com.uc.crashsdk.h.f());
        a(sb, "pkgname", com.uc.crashsdk.a.a);
        a(sb, "process", com.uc.crashsdk.e.g());
        a(sb, "version", com.uc.crashsdk.a.a());
        a(sb, "cver", "2.3.2.2");
        a(sb, "inter", com.uc.crashsdk.h.O() ? "true" : "false");
        a(sb, "os", "android");
        String sb2 = sb.toString();
        byte[] bArr3 = new byte[16];
        c.a(bArr3, 0, h.d());
        c.a(bArr3, 4, c.b());
        c.a(bArr3, 8, c());
        c.a(bArr3, 12, com.uc.crashsdk.a.e());
        try {
            bArr = c.a(sb2.getBytes(), bArr3, true);
        } catch (Throwable th) {
            g.a(th);
            bArr = null;
        }
        if (bArr == null || (e2 = e()) == null || (a2 = c.a(e2, bArr)) == null) {
            return null;
        }
        try {
            bArr2 = c.a(a2, bArr3, false);
        } catch (Throwable th2) {
            g.a(th2);
            bArr2 = null;
        }
        if (bArr2 != null) {
            return new String(bArr2);
        }
        return null;
    }

    public static void a(int i2) {
        if (i2 != 500) {
            if (!a) {
                throw new AssertionError();
            }
            return;
        }
        synchronized (c) {
            g = null;
            a(!com.uc.crashsdk.b.A());
            if (g.b(g)) {
                h.a(g);
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x0061  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0083 A[ADDED_TO_REGION] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static boolean a(boolean r12) {
        /*
            Method dump skipped, instructions count: 396
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.uc.crashsdk.a.d.a(boolean):boolean");
    }

    private static StringBuilder a(StringBuilder sb, String str, String str2) {
        if (sb.length() > 0) {
            sb.append("`");
        }
        sb.append(str);
        sb.append("=");
        sb.append(str2);
        return sb;
    }
}
