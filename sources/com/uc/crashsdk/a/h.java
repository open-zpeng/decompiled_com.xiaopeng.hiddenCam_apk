package com.uc.crashsdk.a;

import android.os.Build;
import android.os.Process;
import android.support.v4.media.session.PlaybackStateCompat;
import android.util.SparseArray;
import com.xiaopeng.lib.utils.info.BuildInfoUtils;
import com.xiaopeng.libconfig.ipc.AccountConfig;
import java.io.File;
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
/* compiled from: ProGuard */
/* loaded from: classes.dex */
public class h {
    static final /* synthetic */ boolean a = !h.class.desiredAssertionStatus();
    private static final Object b = new Object();
    private static final Map<String, String> c = new HashMap();
    private static int d = 0;
    private static final Map<String, a> e = new HashMap();
    private static final Object f = new Object();
    private static final Object g = new Object();
    private static final SparseArray<String> h = new SparseArray<>();
    private static boolean i = false;
    private static boolean j = false;
    private static final char[] k = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
    private static final Object l = new Object();
    private static String m = null;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: ProGuard */
    /* loaded from: classes.dex */
    public static class a {
        long a = 0;
        int b = 0;
        Map<String, String> c = new HashMap();
        private String d;
        private boolean e;
        private boolean f;

        a(String str, boolean z, boolean z2) {
            this.e = false;
            this.f = false;
            this.d = str;
            this.e = z;
            this.f = z2;
        }

        private long d(String str) {
            return g.c(a(str));
        }

        final void a(String str, String str2) {
            this.c.put(str, str2);
        }

        final String b(String str) {
            String a = a(str);
            return a == null ? "" : a;
        }

        final boolean c(String str) {
            if (g.a(str)) {
                return false;
            }
            String str2 = null;
            HashMap hashMap = new HashMap();
            Map c = h.c(str);
            long j = 0;
            int i = 0;
            for (String str3 : c.keySet()) {
                String str4 = (String) c.get(str3);
                if (str3.equals("lt")) {
                    str2 = str4;
                } else if (this.e && str3.equals(AccountConfig.FaceIDRegisterAction.ORIENTATION_UP)) {
                    j = g.c(str4);
                } else if (this.e && str3.equals("pid")) {
                    i = (int) g.c(str4);
                } else {
                    hashMap.put(str3, str4);
                }
            }
            String str5 = this.d;
            if (str5 == null || str5.equals(str2)) {
                this.a = j;
                this.b = i;
                this.d = str2;
                this.c = hashMap;
                return true;
            }
            return false;
        }

        final void a(String str, long j) {
            long d = d(str) + j;
            if (d <= 100) {
                j = d < 0 ? 0L : d;
            }
            a(str, String.valueOf(j));
        }

        final boolean a(a aVar) {
            if (!this.f) {
                com.uc.crashsdk.a.a.a("crashsdk", String.format(Locale.US, "WaItem '%s' is not mergable!", this.d), null);
                return false;
            }
            for (String str : aVar.c.keySet()) {
                if (str.startsWith("c_")) {
                    a(str, aVar.a(str));
                } else {
                    long d = aVar.d(str);
                    if (d == 0) {
                        a(str, aVar.a(str));
                    } else if (d < 100) {
                        a(str, d);
                    }
                }
            }
            return true;
        }

        final String a(String str) {
            return this.c.get(str);
        }

        final String a(boolean z, boolean z2, boolean z3) {
            if (this.d == null) {
                return null;
            }
            StringBuilder sb = new StringBuilder();
            if (z) {
                h.b(sb, "lt", "uc");
                h.b(sb, "pre", com.uc.crashsdk.h.f());
                h.b(sb, "pkg", com.uc.crashsdk.a.a);
                h.b(sb, "rom", Build.VERSION.RELEASE);
                h.b(sb, "brd", Build.BRAND);
                h.b(sb, "model", Build.MODEL);
                h.a(sb, "sdk", Build.VERSION.SDK_INT);
                h.b(sb, "cpu", com.uc.crashsdk.e.d());
                h.b(sb, "hdw", com.uc.crashsdk.e.e());
                long e = h.e();
                h.a(sb, "ram", e);
                h.b(sb, "aram", h.a(e));
                h.b(sb, "nett", c.a());
                h.b(sb, "cver", "2.3.2.2");
                h.b(sb, "cseq", "190513114645");
                h.b(sb, "aver", com.uc.crashsdk.a.a());
                h.b(sb, "ver", com.uc.crashsdk.h.P());
                h.b(sb, "sver", com.uc.crashsdk.h.Q());
                h.b(sb, "seq", com.uc.crashsdk.h.R());
                h.b(sb, "grd", com.uc.crashsdk.b.x() ? "fg" : "bg");
                h.b(sb, "os", "android");
                sb.append("\n");
            }
            h.b(sb, "lt", this.d);
            h.a(sb, this.c);
            if (this.e && !z2) {
                long j = this.a;
                if (j != 0) {
                    h.b(sb, AccountConfig.FaceIDRegisterAction.ORIENTATION_UP, String.valueOf(j));
                }
                if (z3) {
                    h.b(sb, "pid", String.format(Locale.US, "%d", Integer.valueOf(Process.myPid())));
                } else {
                    int i = this.b;
                    if (i != 0) {
                        h.b(sb, "pid", String.format(Locale.US, "%d", Integer.valueOf(i)));
                    }
                }
            }
            sb.append("\n");
            return sb.toString();
        }
    }

    static /* synthetic */ String a(long j2) {
        return j2 < PlaybackStateCompat.ACTION_SET_SHUFFLE_MODE_ENABLED ? "512M" : String.format(Locale.US, "%dG", Long.valueOf(((j2 / 1024) + 512) / 1024));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void b(StringBuilder sb, String str, String str2) {
        sb.append(str);
        sb.append("=");
        sb.append(str2);
        sb.append("`");
    }

    static /* synthetic */ Map c(String str) {
        String[] split;
        HashMap hashMap = new HashMap();
        for (String str2 : str.split("`")) {
            if (str2.length() > 1) {
                String[] split2 = str2.split("=", 3);
                if (split2.length == 2) {
                    hashMap.put(split2[0], split2[1]);
                }
            }
        }
        return hashMap;
    }

    private static boolean d(String str) {
        File file = new File(str);
        Iterator<a> it = a(file, "cst", 30).iterator();
        while (it.hasNext()) {
            a next = it.next();
            String a2 = next.a("prc");
            if (!g.a(a2)) {
                a aVar = e.get(a2);
                if (aVar != null) {
                    aVar.a(next);
                } else {
                    e.put(a2, next);
                }
            }
        }
        boolean b2 = b(com.uc.crashsdk.e.n(), a((Iterable<a>) e.values(), true, false).toString());
        g.a(file);
        if (b2 || g.a(file, a((Iterable<a>) e.values(), false, true).toString())) {
            e.clear();
        }
        return true;
    }

    static /* synthetic */ long e() {
        return h();
    }

    private static String f() {
        return com.uc.crashsdk.h.S() + "pv.wa";
    }

    private static String g() {
        return com.uc.crashsdk.h.S() + "cdt.wa";
    }

    private static long h() {
        Iterator<String> it = g.b(new File("/proc/meminfo"), 2).iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            String next = it.next();
            if (next.contains("MemTotal:")) {
                try {
                    return Long.parseLong(next.replaceAll("\\D+", ""));
                } catch (NumberFormatException e2) {
                    g.a(e2);
                }
            }
        }
        return 0L;
    }

    private static String i() {
        if (g.a(m)) {
            synchronized (l) {
                m = g.a(com.uc.crashsdk.b.j(), com.uc.crashsdk.h.O() ? "https://gjapplog.ucweb.com/collect" : "https://applog.uc.cn/collect", true);
            }
        }
        return m;
    }

    static /* synthetic */ void a(StringBuilder sb, String str, long j2) {
        b(sb, str, String.valueOf(j2));
    }

    public static void b() {
        if (com.uc.crashsdk.h.N()) {
            f.a(1, new e(301), 2000L);
        }
    }

    public static void c() {
        if (com.uc.crashsdk.h.N()) {
            f.a(1, new e(303));
        }
    }

    private static String e(String str) {
        try {
            byte[] bytes = str.getBytes("utf-8");
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            messageDigest.update(bytes);
            byte[] digest = messageDigest.digest();
            int length = digest.length;
            StringBuilder sb = new StringBuilder(length * 2);
            int i2 = length + 0;
            for (int i3 = 0; i3 < i2; i3++) {
                byte b2 = digest[i3];
                char c2 = k[(b2 & 240) >> 4];
                char c3 = k[b2 & 15];
                sb.append(c2);
                sb.append(c3);
            }
            return sb.toString();
        } catch (Exception e2) {
            com.uc.crashsdk.a.a.a("crashsdk", "getMD5: ", e2);
            return null;
        }
    }

    static /* synthetic */ void a(StringBuilder sb, Map map) {
        for (String str : map.keySet()) {
            b(sb, str, (String) map.get(str));
        }
    }

    private static boolean b(String str, String str2, boolean z, boolean z2) {
        a aVar;
        File file = new File(g());
        ArrayList<a> a2 = a(file, "cst", 30);
        String str3 = str + str2;
        Iterator<a> it = a2.iterator();
        while (true) {
            if (!it.hasNext()) {
                aVar = null;
                break;
            }
            aVar = it.next();
            if (str3.equals(aVar.b("prc") + aVar.b("typ"))) {
                break;
            }
        }
        if (aVar == null) {
            aVar = new a("cst", false, true);
            aVar.a("prc", str);
            aVar.a("typ", str2);
            a(aVar);
            a2.add(aVar);
        }
        aVar.a("cnt", 1L);
        if (z) {
            aVar.a("lim", 1L);
        }
        if (z2) {
            aVar.a("syu", 1L);
        }
        return g.a(file, a((Iterable<a>) a2, false, false).toString());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(String str) {
        synchronized (b) {
            File file = new File(f());
            a aVar = new a("pv", true, true);
            String b2 = g.b(file);
            if (!g.a(b2)) {
                aVar.c(b2);
            }
            aVar.a(str, 1L);
            aVar.a("aujv", 1L);
            g.a(file, aVar.a(false, false, false));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static byte[] d() {
        return new byte[]{Byte.MAX_VALUE, 100, 110, 31};
    }

    public static void a() {
        if (com.uc.crashsdk.b.A()) {
            f.a(0, new e(302), 70000L);
        }
    }

    public static boolean a(String str, String str2) {
        try {
            String str3 = "c_" + str.replaceAll("[^0-9a-zA-Z-_]", "-");
            String replaceAll = g.a(str2) ? "" : str2.replaceAll("[`=]", "-");
            synchronized (c) {
                if (c.get(str3) == null) {
                    if (d >= 20) {
                        return false;
                    }
                    d++;
                }
                c.put(str3, replaceAll);
                return true;
            }
        } catch (Throwable th) {
            g.a(th);
            return false;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0042  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x004a  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x004d  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x00ad  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static boolean b(java.lang.String r9, java.lang.String r10) {
        /*
            boolean r0 = com.uc.crashsdk.a.g.a(r10)
            r1 = 1
            if (r0 == 0) goto L8
            return r1
        L8:
            byte[] r10 = r10.getBytes()
            r0 = 16
            r2 = 8
            r3 = 0
            byte[] r0 = new byte[r0]     // Catch: java.lang.Throwable -> L3a
            byte[] r4 = com.uc.crashsdk.a.c.b()     // Catch: java.lang.Throwable -> L3a
            com.uc.crashsdk.a.c.a(r0, r3, r4)     // Catch: java.lang.Throwable -> L3a
            r4 = 4
            byte[] r5 = d()     // Catch: java.lang.Throwable -> L3a
            com.uc.crashsdk.a.c.a(r0, r4, r5)     // Catch: java.lang.Throwable -> L3a
            byte[] r4 = com.uc.crashsdk.a.e()     // Catch: java.lang.Throwable -> L3a
            com.uc.crashsdk.a.c.a(r0, r2, r4)     // Catch: java.lang.Throwable -> L3a
            r4 = 12
            byte[] r5 = com.uc.crashsdk.a.d.c()     // Catch: java.lang.Throwable -> L3a
            com.uc.crashsdk.a.c.a(r0, r4, r5)     // Catch: java.lang.Throwable -> L3a
            byte[] r0 = com.uc.crashsdk.a.c.a(r10, r0)     // Catch: java.lang.Throwable -> L3a
            if (r0 == 0) goto L3e
            r10 = r1
            goto L40
        L3a:
            r0 = move-exception
            com.uc.crashsdk.a.g.a(r0)
        L3e:
            r0 = r10
            r10 = r3
        L40:
            if (r9 != 0) goto L44
            java.lang.String r9 = "unknown"
        L44:
            boolean r4 = com.uc.crashsdk.h.O()
            if (r4 == 0) goto L4d
            java.lang.String r4 = "4ea4e41a3993"
            goto L4f
        L4d:
            java.lang.String r4 = "28ef1713347d"
        L4f:
            long r5 = java.lang.System.currentTimeMillis()
            java.lang.String r5 = java.lang.String.valueOf(r5)
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>()
            r6.append(r4)
            r6.append(r9)
            r6.append(r5)
            java.lang.String r7 = "AppChk#2014"
            r6.append(r7)
            java.lang.String r6 = r6.toString()
            java.lang.String r6 = e(r6)
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            r7.<init>()
            java.lang.String r8 = i()
            r7.append(r8)
            java.lang.String r8 = "?chk="
            r7.append(r8)
            int r8 = r6.length()
            int r8 = r8 - r2
            int r2 = r6.length()
            java.lang.String r2 = r6.substring(r8, r2)
            r7.append(r2)
            java.lang.String r2 = "&vno="
            r7.append(r2)
            r7.append(r5)
            java.lang.String r2 = "&uuid="
            r7.append(r2)
            r7.append(r9)
            java.lang.String r9 = "&app="
            r7.append(r9)
            r7.append(r4)
            if (r10 == 0) goto Lb2
            java.lang.String r9 = "&enc=aes"
            r7.append(r9)
        Lb2:
            java.lang.String r9 = r7.toString()
            byte[] r9 = com.uc.crashsdk.a.c.a(r9, r0)
            if (r9 != 0) goto Lbd
            return r3
        Lbd:
            java.lang.String r10 = new java.lang.String
            r10.<init>(r9)
            java.lang.String r9 = "retcode=0"
            boolean r9 = r10.contains(r9)
            if (r9 == 0) goto Lcb
            return r1
        Lcb:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.uc.crashsdk.a.h.b(java.lang.String, java.lang.String):boolean");
    }

    private static void a(a aVar) {
        synchronized (c) {
            for (String str : c.keySet()) {
                aVar.a(str, c.get(str));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void b(String str) {
        synchronized (l) {
            m = str;
            String j2 = com.uc.crashsdk.b.j();
            b.a(j2, m + "\n");
        }
    }

    public static void a(int i2) {
        switch (i2) {
            case 301:
                String str = com.uc.crashsdk.h.S() + "cr.wa";
                com.uc.crashsdk.b.a(b, str, new e(351, new Object[]{str}));
                return;
            case 302:
                synchronized (b) {
                    if (!i) {
                        i = true;
                        if (!com.uc.crashsdk.a.b.equals("2.0") || !com.uc.crashsdk.b.c(268435456)) {
                            File file = new File(f());
                            String b2 = g.b(file);
                            a aVar = new a("pv", true, true);
                            if (!g.a(b2)) {
                                aVar.c(b2);
                            }
                            if (!(aVar.b == Process.myPid())) {
                                aVar.a("pv", 1L);
                                aVar.a("fjv", 1L);
                                String n = com.uc.crashsdk.e.n();
                                long j2 = aVar.a;
                                if ((j2 == 0 || System.currentTimeMillis() - j2 >= 28800000) ? b(n, aVar.a(true, true, false)) : false) {
                                    aVar.c = new HashMap();
                                    aVar.a = System.currentTimeMillis();
                                    aVar.b = Process.myPid();
                                }
                                g.a(file, aVar.a(false, false, true));
                            }
                        }
                    }
                }
                return;
            case 303:
                String str2 = com.uc.crashsdk.h.S() + "dt.wa";
                com.uc.crashsdk.b.a(f, str2, new e(352, new Object[]{str2}));
                String g2 = g();
                com.uc.crashsdk.b.a(g, g2, new e(354, new Object[]{g2}));
                return;
            default:
                if (!a) {
                    throw new AssertionError();
                }
                return;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean a(int i2, Object[] objArr) {
        switch (i2) {
            case 351:
                if (a || objArr != null) {
                    String str = (String) objArr[0];
                    if (j) {
                        return false;
                    }
                    j = true;
                    File file = new File(str);
                    ArrayList<a> a2 = a(file, "crp", 100);
                    a aVar = new a("crp", false, false);
                    aVar.a("et", String.valueOf(com.uc.crashsdk.b.B()));
                    aVar.a("prc", com.uc.crashsdk.e.g());
                    aVar.a("imp", com.uc.crashsdk.b.A() ? BuildInfoUtils.BID_WAN : "0");
                    a(aVar);
                    a2.add(0, aVar);
                    boolean b2 = b(com.uc.crashsdk.e.n(), a((Iterable<a>) a2, true, false).toString());
                    g.a(file);
                    if (!b2) {
                        g.a(file, a((Iterable<a>) a2, false, true).toString());
                    }
                    return true;
                }
                throw new AssertionError();
            case 352:
                if (a || objArr != null) {
                    return d((String) objArr[0]);
                }
                throw new AssertionError();
            case 353:
                if (a || objArr != null) {
                    return b((String) objArr[0], (String) objArr[1], ((Boolean) objArr[2]).booleanValue(), ((Boolean) objArr[3]).booleanValue());
                }
                throw new AssertionError();
            case 354:
                if (a || objArr != null) {
                    File file2 = new File((String) objArr[0]);
                    boolean b3 = b(com.uc.crashsdk.e.n(), a((Iterable<a>) a(file2, "cst", 30), true, false).toString());
                    if (b3) {
                        g.a(file2);
                    }
                    return b3;
                }
                throw new AssertionError();
            default:
                return false;
        }
    }

    private static StringBuilder a(Iterable<a> iterable, boolean z, boolean z2) {
        StringBuilder sb = new StringBuilder();
        boolean z3 = true;
        for (a aVar : iterable) {
            if (z3) {
                sb.append(aVar.a(z, z, z2));
                z3 = false;
            } else {
                sb.append(aVar.a(false, z, z2));
            }
        }
        return sb;
    }

    public static void a(String str, int i2, int i3) {
        if (com.uc.crashsdk.h.N()) {
            synchronized (f) {
                a aVar = e.get(str);
                if (aVar == null) {
                    aVar = new a("cst", false, true);
                    e.put(str, aVar);
                    a(aVar);
                }
                synchronized (h) {
                    if (h.size() == 0) {
                        a(100, "pv");
                        a(1, "all");
                        a(2, "afg");
                        a(3, "jfg");
                        a(4, "jbg");
                        a(7, "nfg");
                        a(8, "nbg");
                        a(27, "nafg");
                        a(28, "nabg");
                        a(9, "nho");
                        a(10, "uar");
                        a(29, "ulm");
                        a(30, "ukt");
                        a(31, "uet");
                        a(32, "urs");
                        a(11, "ufg");
                        a(12, "ubg");
                        a(13, "lup");
                        a(14, "luf");
                        a(15, "lef");
                        a(16, "laf");
                        a(22, "lac");
                        a(23, "lau");
                        a(17, "llf");
                        a(18, "lul");
                        a(19, "lub");
                        a(20, "luc");
                        a(21, "luu");
                        a(24, "lzc");
                        a(25, "lrc");
                        a(26, "lss");
                    }
                }
                String str2 = h.get(i2);
                if (str2 == null) {
                    com.uc.crashsdk.a.a.a("crashsdk", "map key is not set with: " + i2, null);
                }
                aVar.a("prc", str);
                if (str2 != null) {
                    aVar.a(str2, String.valueOf(i3));
                }
            }
        }
    }

    public static boolean a(String str, String str2, boolean z, boolean z2) {
        if (com.uc.crashsdk.h.N()) {
            return com.uc.crashsdk.b.a(g, g(), new e(353, new Object[]{str, str2, Boolean.valueOf(z), Boolean.valueOf(z2)}));
        }
        return false;
    }

    private static void a(int i2, String str) {
        h.put(i2, str);
    }

    private static ArrayList<a> a(File file, String str, int i2) {
        ArrayList<String> b2 = g.b(file, i2);
        ArrayList<a> arrayList = new ArrayList<>();
        Iterator<String> it = b2.iterator();
        while (it.hasNext()) {
            a aVar = new a(str, false, false);
            if (aVar.c(it.next())) {
                arrayList.add(aVar);
            }
        }
        return arrayList;
    }
}
