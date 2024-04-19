package com.uc.crashsdk;

import android.content.pm.PackageInfo;
import android.util.SparseArray;
import com.uc.crashsdk.export.LogType;
import com.xiaopeng.libconfig.remotecontrol.RemoteControlFeedbackConstant;
import java.io.OutputStream;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.Callable;
/* compiled from: ProGuard */
/* loaded from: classes.dex */
public class a {
    static final /* synthetic */ boolean d = !a.class.desiredAssertionStatus();
    public static String a = "";
    public static String b = "";
    private static final Map<String, String> e = new HashMap();
    private static final List<String> f = new ArrayList();
    private static String g = "";
    private static String h = null;
    private static long i = 0;
    private static final HashMap<String, Object[]> j = new HashMap<>();
    private static final List<String> k = new ArrayList();
    private static int l = 0;
    private static int m = 0;
    private static int n = 0;
    private static final HashMap<String, Object[]> o = new HashMap<>();
    private static final List<String> p = new ArrayList();
    private static int q = 0;
    private static int r = 0;
    private static int s = 0;
    private static int t = 0;
    private static int u = 0;
    private static final SparseArray<Object[]> v = new SparseArray<>();
    private static final List<Integer> w = new ArrayList();
    private static final HashMap<String, Object[]> x = new HashMap<>();
    private static final List<String> y = new ArrayList();
    private static int z = 0;
    private static int A = 0;
    static boolean c = false;
    private static Runnable B = new com.uc.crashsdk.a.e(RemoteControlFeedbackConstant.SUCCESS_WAKE_UP);
    private static boolean C = false;
    private static boolean D = false;

    public static String a() {
        String str = h;
        if (str != null) {
            return str;
        }
        try {
            PackageInfo packageInfo = com.uc.crashsdk.a.g.a().getPackageManager().getPackageInfo(a, 0);
            h = packageInfo.versionName;
            i = packageInfo.lastUpdateTime;
            return h;
        } catch (Throwable th) {
            com.uc.crashsdk.a.g.b(th);
            return "";
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static long b() {
        return i;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void c() {
        StringBuilder sb = new StringBuilder();
        synchronized (e) {
            for (String str : f) {
                String str2 = e.get(str);
                sb.append(str);
                sb.append(": ");
                if (str2 != null) {
                    sb.append(str2);
                }
                sb.append("\n");
            }
        }
        sb.append(String.format(Locale.US, "(saved at %s)\n", e.k()));
        com.uc.crashsdk.a.b.a(b.g(), sb.toString());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void d() {
        if (!d && !b.d) {
            throw new AssertionError();
        }
        synchronized (e) {
            for (String str : f) {
                JNIBridge.nativeAddHeaderInfo(str, e.get(str));
            }
        }
    }

    public static byte[] e() {
        return new byte[]{24, 99, 121, 60};
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void f() {
        if (!d && !b.d) {
            throw new AssertionError();
        }
        synchronized (j) {
            for (String str : k) {
                Object[] objArr = j.get(str);
                int intValue = ((Integer) objArr[0]).intValue();
                if (LogType.isForNative(intValue) || LogType.isForUnexp(intValue)) {
                    JNIBridge.nativeAddDumpFile(str, (String) objArr[1], ((Boolean) objArr[2]).booleanValue(), ((Boolean) objArr[3]).booleanValue(), LogType.isForNative(intValue), LogType.isForUnexp(intValue), ((Boolean) objArr[4]).booleanValue());
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String g() {
        StringBuilder sb = new StringBuilder();
        synchronized (j) {
            boolean z2 = true;
            for (String str : k) {
                if (LogType.isForJava(((Integer) j.get(str)[0]).intValue())) {
                    if (!z2) {
                        sb.append("`");
                    }
                    sb.append(str);
                    z2 = false;
                }
            }
        }
        return sb.toString();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void h() {
        if (!d && !b.d) {
            throw new AssertionError();
        }
        synchronized (o) {
            for (String str : p) {
                Object[] objArr = o.get(str);
                int intValue = ((Integer) objArr[0]).intValue();
                if (LogType.isForNative(intValue) || LogType.isForUnexp(intValue)) {
                    JNIBridge.nativeAddCallbackInfo(str, LogType.isForNative(intValue), LogType.isForUnexp(intValue), ((Long) objArr[2]).longValue(), ((Integer) objArr[3]).intValue());
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String i() {
        String sb;
        synchronized (o) {
            StringBuilder sb2 = new StringBuilder();
            synchronized (p) {
                boolean z2 = true;
                for (String str : p) {
                    if (LogType.isForJava(((Integer) o.get(str)[0]).intValue())) {
                        if (!z2) {
                            sb2.append("`");
                        }
                        sb2.append(str);
                        z2 = false;
                    }
                }
            }
            sb = sb2.toString();
        }
        return sb;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void j() {
        if (!d && !b.d) {
            throw new AssertionError();
        }
        synchronized (x) {
            for (String str : y) {
                Object[] objArr = x.get(str);
                int intValue = ((Integer) objArr[0]).intValue();
                int intValue2 = ((Integer) objArr[1]).intValue();
                List list = (List) objArr[2];
                if (LogType.isForNative(intValue2) && JNIBridge.nativeCreateCachedInfo(str, intValue)) {
                    Iterator it = list.iterator();
                    while (it.hasNext() && JNIBridge.nativeAddCachedInfo(str, (String) it.next())) {
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String k() {
        StringBuilder sb = new StringBuilder();
        synchronized (x) {
            boolean z2 = true;
            for (String str : y) {
                if (LogType.isForJava(((Integer) x.get(str)[1]).intValue())) {
                    if (!z2) {
                        sb.append("`");
                    }
                    sb.append(str);
                    z2 = false;
                }
            }
        }
        return sb.toString();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String l() {
        if (!C) {
            g = com.uc.crashsdk.a.b.a(b.l());
            C = true;
            if (g == null) {
                g = "";
            }
        }
        return g;
    }

    public static void m() {
        if (D) {
            if (b.d) {
                JNIBridge.nativeSyncStatus("ver", g, 0);
                return;
            }
            return;
        }
        D = true;
        com.uc.crashsdk.a.f.a(0, new com.uc.crashsdk.a.e(202));
    }

    private static StringBuilder b(String str, boolean z2) {
        String a2;
        StringBuilder sb = new StringBuilder();
        try {
            Object[] objArr = o.get(str);
            if (objArr == null) {
                a2 = "Unknown callback: " + str;
            } else {
                Callable callable = (Callable) objArr[1];
                if (callable != null) {
                    a2 = (String) callable.call();
                } else {
                    a2 = d.a(str, z2);
                }
            }
            if (a2 != null) {
                sb.append(a2);
            }
        } catch (Throwable th) {
            com.uc.crashsdk.a.g.a(th);
        }
        try {
            if (sb.length() == 0) {
                sb.append("(data is null)\n");
            }
        } catch (Throwable th2) {
            com.uc.crashsdk.a.g.a(th2);
        }
        return sb;
    }

    public static void a(String str, String str2) {
        synchronized (e) {
            if (!e.containsKey(str)) {
                f.add(str);
            }
            e.put(str, str2);
            if (b.d) {
                JNIBridge.nativeAddHeaderInfo(str, str2);
            }
            e.s();
        }
    }

    public static int b(String str, String str2) {
        int i2 = 0;
        if (str == null || str2 == null) {
            return 0;
        }
        if (str2.length() > 2048) {
            str2 = str2.substring(0, 2048);
        }
        synchronized (x) {
            Object[] objArr = x.get(str);
            if (objArr != null) {
                int intValue = ((Integer) objArr[0]).intValue();
                int intValue2 = ((Integer) objArr[1]).intValue();
                List list = (List) objArr[2];
                if (list.size() >= intValue) {
                    list.remove(0);
                }
                list.add(str2);
                i2 = LogType.addType(0, 16);
                if (!b.d && LogType.isForNative(intValue2)) {
                    i2 = LogType.addType(i2, 1);
                }
            }
            if (b.d && JNIBridge.nativeAddCachedInfo(str, str2)) {
                i2 = LogType.addType(i2, 1);
            }
        }
        return i2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static ArrayList<String> c(String str) {
        if (com.uc.crashsdk.a.g.a(str)) {
            return null;
        }
        String[] split = str.split(";", 20);
        ArrayList<String> arrayList = new ArrayList<>();
        for (String str2 : split) {
            if (!com.uc.crashsdk.a.g.a(str2)) {
                arrayList.add(str2);
            }
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(OutputStream outputStream, String str) {
        synchronized (e) {
            for (String str2 : f) {
                StringBuilder sb = new StringBuilder(11);
                sb.append(str2);
                sb.append(": ");
                String str3 = e.get(str2);
                if (str3 != null) {
                    sb.append(str3);
                }
                sb.append("\n");
                outputStream.write(sb.toString().getBytes(str));
            }
        }
    }

    public static int a(String str, String str2, boolean z2, boolean z3, int i2, boolean z4) {
        int i3;
        int i4;
        int i5;
        boolean z5;
        if (str == null || str2 == null) {
            return 0;
        }
        if (str.length() > 256) {
            com.uc.crashsdk.a.a.a("crashsdk", "addDumpFile: description is too long!", null);
            return 0;
        }
        synchronized (j) {
            if (j.containsKey(str)) {
                i4 = ((Integer) j.get(str)[0]).intValue();
                i3 = LogType.addType(i4, i2);
            } else {
                i3 = i2;
                i4 = 0;
            }
            if (LogType.isForJava(i3) && !LogType.isForJava(i4)) {
                if (l >= 10) {
                    i3 = LogType.removeType(i3, 16);
                } else {
                    l++;
                }
            }
            if (LogType.isForNative(i3) && !LogType.isForNative(i4)) {
                if (m >= 10) {
                    i3 = LogType.removeType(i3, 1);
                } else {
                    m++;
                }
            }
            if (LogType.isForUnexp(i3) && !LogType.isForUnexp(i4)) {
                if (n >= 10) {
                    i3 = LogType.removeType(i3, 256);
                } else {
                    n++;
                }
            }
            i5 = i3;
            if ((i5 & 273) == 0) {
                z5 = false;
            } else {
                if (i4 == 0) {
                    k.add(str);
                }
                z5 = true;
            }
            if (z5) {
                if (b.d && (LogType.isForNative(i2) || LogType.isForUnexp(i2))) {
                    int nativeAddDumpFile = JNIBridge.nativeAddDumpFile(str, str2, z2, z3, LogType.isForNative(i2), LogType.isForUnexp(i2), z4);
                    if (!LogType.isForNative(nativeAddDumpFile)) {
                        i5 = LogType.removeType(i5, 1);
                    }
                    if (!LogType.isForUnexp(nativeAddDumpFile)) {
                        i5 = LogType.removeType(i5, 256);
                    }
                }
                j.put(str, new Object[]{Integer.valueOf(i5), str2, Boolean.valueOf(z2), Boolean.valueOf(z3), Boolean.valueOf(z4)});
            }
        }
        return i5;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0076 A[Catch: all -> 0x008d, LOOP:1: B:19:0x0070->B:21:0x0076, LOOP_END, TRY_LEAVE, TryCatch #2 {, blocks: (B:4:0x0003, B:5:0x0009, B:7:0x000f, B:9:0x0036, B:12:0x003d, B:30:0x00ab, B:32:0x00b1, B:33:0x00b5, B:35:0x00bb, B:37:0x00c9, B:38:0x00cf, B:25:0x0091, B:14:0x0043, B:18:0x006c, B:19:0x0070, B:21:0x0076), top: B:43:0x0003 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static void b(java.io.OutputStream r11, java.lang.String r12, java.lang.String r13, java.util.ArrayList<java.lang.String> r14) {
        /*
            java.util.HashMap<java.lang.String, java.lang.Object[]> r0 = com.uc.crashsdk.a.x
            monitor-enter(r0)
            java.util.List<java.lang.String> r1 = com.uc.crashsdk.a.y     // Catch: java.lang.Throwable -> Ld1
            java.util.Iterator r1 = r1.iterator()     // Catch: java.lang.Throwable -> Ld1
        L9:
            boolean r2 = r1.hasNext()     // Catch: java.lang.Throwable -> Ld1
            if (r2 == 0) goto La9
            java.lang.Object r2 = r1.next()     // Catch: java.lang.Throwable -> Ld1
            java.lang.String r2 = (java.lang.String) r2     // Catch: java.lang.Throwable -> Ld1
            java.util.HashMap<java.lang.String, java.lang.Object[]> r3 = com.uc.crashsdk.a.x     // Catch: java.lang.Throwable -> Ld1
            java.lang.Object r3 = r3.get(r2)     // Catch: java.lang.Throwable -> Ld1
            java.lang.Object[] r3 = (java.lang.Object[]) r3     // Catch: java.lang.Throwable -> Ld1
            r4 = 0
            r5 = r3[r4]     // Catch: java.lang.Throwable -> Ld1
            java.lang.Integer r5 = (java.lang.Integer) r5     // Catch: java.lang.Throwable -> Ld1
            int r5 = r5.intValue()     // Catch: java.lang.Throwable -> Ld1
            r6 = 1
            r7 = r3[r6]     // Catch: java.lang.Throwable -> Ld1
            java.lang.Integer r7 = (java.lang.Integer) r7     // Catch: java.lang.Throwable -> Ld1
            int r7 = r7.intValue()     // Catch: java.lang.Throwable -> Ld1
            r8 = 2
            r3 = r3[r8]     // Catch: java.lang.Throwable -> Ld1
            java.util.List r3 = (java.util.List) r3     // Catch: java.lang.Throwable -> Ld1
            if (r14 != 0) goto L3d
            boolean r7 = com.uc.crashsdk.export.LogType.isForJava(r7)     // Catch: java.lang.Throwable -> Ld1
            if (r7 != 0) goto L43
            goto L9
        L3d:
            boolean r7 = a(r14, r2)     // Catch: java.lang.Throwable -> Ld1
            if (r7 == 0) goto L9
        L43:
            java.util.Locale r7 = java.util.Locale.US     // Catch: java.lang.Throwable -> L68
            java.lang.String r9 = "%s (%d/%d)\n"
            r10 = 3
            java.lang.Object[] r10 = new java.lang.Object[r10]     // Catch: java.lang.Throwable -> L68
            r10[r4] = r2     // Catch: java.lang.Throwable -> L68
            int r2 = r3.size()     // Catch: java.lang.Throwable -> L68
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)     // Catch: java.lang.Throwable -> L68
            r10[r6] = r2     // Catch: java.lang.Throwable -> L68
            java.lang.Integer r2 = java.lang.Integer.valueOf(r5)     // Catch: java.lang.Throwable -> L68
            r10[r8] = r2     // Catch: java.lang.Throwable -> L68
            java.lang.String r2 = java.lang.String.format(r7, r9, r10)     // Catch: java.lang.Throwable -> L68
            byte[] r2 = r2.getBytes(r12)     // Catch: java.lang.Throwable -> L68
            r11.write(r2)     // Catch: java.lang.Throwable -> L68
            goto L6c
        L68:
            r2 = move-exception
            com.uc.crashsdk.e.a(r2, r11)     // Catch: java.lang.Throwable -> Ld1
        L6c:
            java.util.Iterator r2 = r3.iterator()     // Catch: java.lang.Throwable -> L8d
        L70:
            boolean r3 = r2.hasNext()     // Catch: java.lang.Throwable -> L8d
            if (r3 == 0) goto L91
            java.lang.Object r3 = r2.next()     // Catch: java.lang.Throwable -> L8d
            java.lang.String r3 = (java.lang.String) r3     // Catch: java.lang.Throwable -> L8d
            byte[] r3 = r3.getBytes(r12)     // Catch: java.lang.Throwable -> L8d
            r11.write(r3)     // Catch: java.lang.Throwable -> L8d
            java.lang.String r3 = "\n"
            byte[] r3 = r3.getBytes(r12)     // Catch: java.lang.Throwable -> L8d
            r11.write(r3)     // Catch: java.lang.Throwable -> L8d
            goto L70
        L8d:
            r2 = move-exception
            com.uc.crashsdk.e.a(r2, r11)     // Catch: java.lang.Throwable -> Ld1
        L91:
            java.lang.String r2 = "\n"
            byte[] r2 = r2.getBytes(r12)     // Catch: java.lang.Throwable -> La3
            r11.write(r2)     // Catch: java.lang.Throwable -> La3
            byte[] r2 = r13.getBytes(r12)     // Catch: java.lang.Throwable -> La3
            r11.write(r2)     // Catch: java.lang.Throwable -> La3
            goto L9
        La3:
            r2 = move-exception
            com.uc.crashsdk.e.a(r2, r11)     // Catch: java.lang.Throwable -> Ld1
            goto L9
        La9:
            if (r14 == 0) goto Lcf
            boolean r12 = com.uc.crashsdk.e.y()     // Catch: java.lang.Throwable -> Ld1
            if (r12 == 0) goto Lcf
            java.util.Iterator r12 = r14.iterator()     // Catch: java.lang.Throwable -> Ld1
        Lb5:
            boolean r13 = r12.hasNext()     // Catch: java.lang.Throwable -> Ld1
            if (r13 == 0) goto Lcf
            java.lang.Object r13 = r12.next()     // Catch: java.lang.Throwable -> Ld1
            java.lang.String r13 = (java.lang.String) r13     // Catch: java.lang.Throwable -> Ld1
            java.util.List<java.lang.String> r14 = com.uc.crashsdk.a.y     // Catch: java.lang.Throwable -> Ld1
            boolean r14 = a(r14, r13)     // Catch: java.lang.Throwable -> Ld1
            if (r14 != 0) goto Lb5
            java.lang.String r14 = "CUSTOMCACHEDINFO"
            com.uc.crashsdk.e.a(r11, r14, r13)     // Catch: java.lang.Throwable -> Ld1
            goto Lb5
        Lcf:
            monitor-exit(r0)     // Catch: java.lang.Throwable -> Ld1
            return
        Ld1:
            r11 = move-exception
            monitor-exit(r0)     // Catch: java.lang.Throwable -> Ld1
            throw r11
        */
        throw new UnsupportedOperationException("Method not decompiled: com.uc.crashsdk.a.b(java.io.OutputStream, java.lang.String, java.lang.String, java.util.ArrayList):void");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String b(String str) {
        StringBuilder sb = new StringBuilder();
        synchronized (x) {
            Object[] objArr = x.get(str);
            int intValue = ((Integer) objArr[0]).intValue();
            List<String> list = (List) objArr[2];
            sb.append(String.format(Locale.US, "%s (%d/%d)\n", str, Integer.valueOf(list.size()), Integer.valueOf(intValue)));
            for (String str2 : list) {
                sb.append(str2);
                sb.append("\n");
            }
        }
        return sb.toString();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Removed duplicated region for block: B:22:0x004c A[Catch: all -> 0x00ba, TryCatch #2 {, blocks: (B:8:0x000e, B:9:0x0015, B:11:0x001b, B:47:0x00c4, B:48:0x00c8, B:50:0x00ce, B:52:0x00dc, B:53:0x00e2, B:12:0x0021, B:14:0x002b, B:20:0x0041, B:22:0x004c, B:26:0x006a, B:28:0x0080, B:30:0x0088, B:35:0x009b, B:39:0x00aa, B:41:0x00b5, B:32:0x0090, B:33:0x0094, B:34:0x0096, B:17:0x003a), top: B:58:0x000e }] */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0069  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0090 A[Catch: all -> 0x00ba, TryCatch #2 {, blocks: (B:8:0x000e, B:9:0x0015, B:11:0x001b, B:47:0x00c4, B:48:0x00c8, B:50:0x00ce, B:52:0x00dc, B:53:0x00e2, B:12:0x0021, B:14:0x002b, B:20:0x0041, B:22:0x004c, B:26:0x006a, B:28:0x0080, B:30:0x0088, B:35:0x009b, B:39:0x00aa, B:41:0x00b5, B:32:0x0090, B:33:0x0094, B:34:0x0096, B:17:0x003a), top: B:58:0x000e }] */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0096 A[Catch: all -> 0x00ba, TryCatch #2 {, blocks: (B:8:0x000e, B:9:0x0015, B:11:0x001b, B:47:0x00c4, B:48:0x00c8, B:50:0x00ce, B:52:0x00dc, B:53:0x00e2, B:12:0x0021, B:14:0x002b, B:20:0x0041, B:22:0x004c, B:26:0x006a, B:28:0x0080, B:30:0x0088, B:35:0x009b, B:39:0x00aa, B:41:0x00b5, B:32:0x0090, B:33:0x0094, B:34:0x0096, B:17:0x003a), top: B:58:0x000e }] */
    /* JADX WARN: Removed duplicated region for block: B:68:0x00b5 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:76:0x0015 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static void a(java.io.OutputStream r12, java.lang.String r13, java.util.ArrayList<java.lang.String> r14) {
        /*
            Method dump skipped, instructions count: 231
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.uc.crashsdk.a.a(java.io.OutputStream, java.lang.String, java.util.ArrayList):void");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String a(String str) {
        synchronized (j) {
            Object[] objArr = j.get(str);
            if (objArr == null) {
                return null;
            }
            int i2 = 1;
            boolean booleanValue = ((Boolean) objArr[2]).booleanValue();
            boolean booleanValue2 = ((Boolean) objArr[3]).booleanValue();
            Locale locale = Locale.US;
            Object[] objArr2 = new Object[4];
            objArr2[0] = (String) objArr[1];
            objArr2[1] = "`";
            objArr2[2] = Integer.valueOf(booleanValue ? 1 : 0);
            if (!booleanValue2) {
                i2 = 0;
            }
            objArr2[3] = Integer.valueOf(i2);
            return String.format(locale, "%s%s%d%d", objArr2);
        }
    }

    private static boolean a(List<String> list, String str) {
        if (com.uc.crashsdk.a.g.a(str)) {
            return false;
        }
        for (String str2 : list) {
            if (str.equals(str2)) {
                return true;
            }
        }
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B:32:0x0066 A[Catch: all -> 0x0151, TryCatch #0 {, blocks: (B:7:0x0009, B:9:0x0011, B:11:0x0029, B:14:0x002f, B:16:0x0039, B:18:0x003f, B:32:0x0066, B:23:0x004b, B:26:0x0050, B:30:0x005e, B:27:0x0056, B:33:0x006c, B:35:0x0073, B:37:0x0079, B:51:0x00aa, B:54:0x00b3, B:56:0x00bb, B:58:0x00c1, B:60:0x00c5, B:61:0x00ca, B:63:0x00d4, B:70:0x00e4, B:72:0x00e8, B:74:0x00ee, B:76:0x00f4, B:78:0x010e, B:80:0x0114, B:82:0x011b, B:83:0x0120, B:85:0x0126, B:87:0x012c, B:89:0x0132, B:90:0x014f, B:67:0x00dc, B:42:0x0085, B:45:0x008a, B:46:0x0098, B:49:0x00a0), top: B:95:0x0009 }] */
    /* JADX WARN: Removed duplicated region for block: B:51:0x00aa A[Catch: all -> 0x0151, TryCatch #0 {, blocks: (B:7:0x0009, B:9:0x0011, B:11:0x0029, B:14:0x002f, B:16:0x0039, B:18:0x003f, B:32:0x0066, B:23:0x004b, B:26:0x0050, B:30:0x005e, B:27:0x0056, B:33:0x006c, B:35:0x0073, B:37:0x0079, B:51:0x00aa, B:54:0x00b3, B:56:0x00bb, B:58:0x00c1, B:60:0x00c5, B:61:0x00ca, B:63:0x00d4, B:70:0x00e4, B:72:0x00e8, B:74:0x00ee, B:76:0x00f4, B:78:0x010e, B:80:0x0114, B:82:0x011b, B:83:0x0120, B:85:0x0126, B:87:0x012c, B:89:0x0132, B:90:0x014f, B:67:0x00dc, B:42:0x0085, B:45:0x008a, B:46:0x0098, B:49:0x00a0), top: B:95:0x0009 }] */
    /* JADX WARN: Removed duplicated region for block: B:65:0x00d8  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x00da  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x00e4 A[Catch: all -> 0x0151, TryCatch #0 {, blocks: (B:7:0x0009, B:9:0x0011, B:11:0x0029, B:14:0x002f, B:16:0x0039, B:18:0x003f, B:32:0x0066, B:23:0x004b, B:26:0x0050, B:30:0x005e, B:27:0x0056, B:33:0x006c, B:35:0x0073, B:37:0x0079, B:51:0x00aa, B:54:0x00b3, B:56:0x00bb, B:58:0x00c1, B:60:0x00c5, B:61:0x00ca, B:63:0x00d4, B:70:0x00e4, B:72:0x00e8, B:74:0x00ee, B:76:0x00f4, B:78:0x010e, B:80:0x0114, B:82:0x011b, B:83:0x0120, B:85:0x0126, B:87:0x012c, B:89:0x0132, B:90:0x014f, B:67:0x00dc, B:42:0x0085, B:45:0x008a, B:46:0x0098, B:49:0x00a0), top: B:95:0x0009 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static int a(java.lang.String r16, int r17, java.util.concurrent.Callable<java.lang.String> r18, long r19, int r21) {
        /*
            Method dump skipped, instructions count: 340
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.uc.crashsdk.a.a(java.lang.String, int, java.util.concurrent.Callable, long, int):int");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Removed duplicated region for block: B:18:0x005d A[Catch: all -> 0x008d, TryCatch #2 {, blocks: (B:4:0x0003, B:5:0x0009, B:7:0x000f, B:33:0x00ab, B:35:0x00b1, B:36:0x00b5, B:38:0x00bb, B:40:0x00c9, B:41:0x00cf, B:28:0x0091, B:8:0x0015, B:10:0x0028, B:16:0x0036, B:18:0x005d, B:21:0x0075, B:23:0x007b, B:24:0x0083, B:19:0x006b, B:13:0x002f), top: B:46:0x0003 }] */
    /* JADX WARN: Removed duplicated region for block: B:19:0x006b A[Catch: all -> 0x008d, TryCatch #2 {, blocks: (B:4:0x0003, B:5:0x0009, B:7:0x000f, B:33:0x00ab, B:35:0x00b1, B:36:0x00b5, B:38:0x00bb, B:40:0x00c9, B:41:0x00cf, B:28:0x0091, B:8:0x0015, B:10:0x0028, B:16:0x0036, B:18:0x005d, B:21:0x0075, B:23:0x007b, B:24:0x0083, B:19:0x006b, B:13:0x002f), top: B:46:0x0003 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static void a(java.io.OutputStream r9, java.lang.String r10, java.lang.String r11, java.util.ArrayList<java.lang.String> r12) {
        /*
            java.util.HashMap<java.lang.String, java.lang.Object[]> r0 = com.uc.crashsdk.a.o
            monitor-enter(r0)
            java.util.List<java.lang.String> r1 = com.uc.crashsdk.a.p     // Catch: java.lang.Throwable -> Ld1
            java.util.Iterator r1 = r1.iterator()     // Catch: java.lang.Throwable -> Ld1
        L9:
            boolean r2 = r1.hasNext()     // Catch: java.lang.Throwable -> Ld1
            if (r2 == 0) goto La9
            java.lang.Object r2 = r1.next()     // Catch: java.lang.Throwable -> Ld1
            java.lang.String r2 = (java.lang.String) r2     // Catch: java.lang.Throwable -> Ld1
            java.util.HashMap<java.lang.String, java.lang.Object[]> r3 = com.uc.crashsdk.a.o     // Catch: java.lang.Throwable -> L8d
            java.lang.Object r3 = r3.get(r2)     // Catch: java.lang.Throwable -> L8d
            java.lang.Object[] r3 = (java.lang.Object[]) r3     // Catch: java.lang.Throwable -> L8d
            r4 = 0
            r5 = r3[r4]     // Catch: java.lang.Throwable -> L8d
            java.lang.Integer r5 = (java.lang.Integer) r5     // Catch: java.lang.Throwable -> L8d
            int r5 = r5.intValue()     // Catch: java.lang.Throwable -> L8d
            if (r12 != 0) goto L2f
            boolean r5 = com.uc.crashsdk.export.LogType.isForJava(r5)     // Catch: java.lang.Throwable -> L8d
            if (r5 != 0) goto L36
            goto L9
        L2f:
            boolean r5 = a(r12, r2)     // Catch: java.lang.Throwable -> L8d
            if (r5 != 0) goto L36
            goto L9
        L36:
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L8d
            r5.<init>()     // Catch: java.lang.Throwable -> L8d
            r5.append(r2)     // Catch: java.lang.Throwable -> L8d
            java.lang.String r6 = "\n"
            r5.append(r6)     // Catch: java.lang.Throwable -> L8d
            java.lang.String r5 = r5.toString()     // Catch: java.lang.Throwable -> L8d
            byte[] r5 = r5.getBytes(r10)     // Catch: java.lang.Throwable -> L8d
            r9.write(r5)     // Catch: java.lang.Throwable -> L8d
            r5 = 2
            r5 = r3[r5]     // Catch: java.lang.Throwable -> L8d
            java.lang.Long r5 = (java.lang.Long) r5     // Catch: java.lang.Throwable -> L8d
            long r5 = r5.longValue()     // Catch: java.lang.Throwable -> L8d
            r7 = 0
            int r7 = (r5 > r7 ? 1 : (r5 == r7 ? 0 : -1))
            if (r7 == 0) goto L6b
            r7 = 3
            r3 = r3[r7]     // Catch: java.lang.Throwable -> L8d
            java.lang.Integer r3 = (java.lang.Integer) r3     // Catch: java.lang.Throwable -> L8d
            int r3 = r3.intValue()     // Catch: java.lang.Throwable -> L8d
            java.lang.String r2 = com.uc.crashsdk.JNIBridge.nativeGetCallbackInfo(r2, r5, r3, r4)     // Catch: java.lang.Throwable -> L8d
            goto L73
        L6b:
            java.lang.StringBuilder r2 = b(r2, r4)     // Catch: java.lang.Throwable -> L8d
            java.lang.String r2 = r2.toString()     // Catch: java.lang.Throwable -> L8d
        L73:
            if (r2 == 0) goto L83
            int r3 = r2.length()     // Catch: java.lang.Throwable -> L8d
            if (r3 <= 0) goto L83
            byte[] r2 = r2.getBytes(r10)     // Catch: java.lang.Throwable -> L8d
            r9.write(r2)     // Catch: java.lang.Throwable -> L8d
            goto L91
        L83:
            java.lang.String r2 = "(data is null)\n"
            byte[] r2 = r2.getBytes(r10)     // Catch: java.lang.Throwable -> L8d
            r9.write(r2)     // Catch: java.lang.Throwable -> L8d
            goto L91
        L8d:
            r2 = move-exception
            com.uc.crashsdk.e.a(r2, r9)     // Catch: java.lang.Throwable -> Ld1
        L91:
            java.lang.String r2 = "\n"
            byte[] r2 = r2.getBytes(r10)     // Catch: java.lang.Throwable -> La3
            r9.write(r2)     // Catch: java.lang.Throwable -> La3
            byte[] r2 = r11.getBytes(r10)     // Catch: java.lang.Throwable -> La3
            r9.write(r2)     // Catch: java.lang.Throwable -> La3
            goto L9
        La3:
            r2 = move-exception
            com.uc.crashsdk.e.a(r2, r9)     // Catch: java.lang.Throwable -> Ld1
            goto L9
        La9:
            if (r12 == 0) goto Lcf
            boolean r10 = com.uc.crashsdk.e.y()     // Catch: java.lang.Throwable -> Ld1
            if (r10 == 0) goto Lcf
            java.util.Iterator r10 = r12.iterator()     // Catch: java.lang.Throwable -> Ld1
        Lb5:
            boolean r11 = r10.hasNext()     // Catch: java.lang.Throwable -> Ld1
            if (r11 == 0) goto Lcf
            java.lang.Object r11 = r10.next()     // Catch: java.lang.Throwable -> Ld1
            java.lang.String r11 = (java.lang.String) r11     // Catch: java.lang.Throwable -> Ld1
            java.util.List<java.lang.String> r12 = com.uc.crashsdk.a.p     // Catch: java.lang.Throwable -> Ld1
            boolean r12 = a(r12, r11)     // Catch: java.lang.Throwable -> Ld1
            if (r12 != 0) goto Lb5
            java.lang.String r12 = "CUSTOMCALLBACKINFO"
            com.uc.crashsdk.e.a(r9, r12, r11)     // Catch: java.lang.Throwable -> Ld1
            goto Lb5
        Lcf:
            monitor-exit(r0)     // Catch: java.lang.Throwable -> Ld1
            return
        Ld1:
            r9 = move-exception
            monitor-exit(r0)     // Catch: java.lang.Throwable -> Ld1
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.uc.crashsdk.a.a(java.io.OutputStream, java.lang.String, java.lang.String, java.util.ArrayList):void");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String a(String str, boolean z2) {
        String sb;
        synchronized (o) {
            Object[] objArr = o.get(str);
            long longValue = ((Long) objArr[2]).longValue();
            if (longValue != 0) {
                sb = JNIBridge.nativeGetCallbackInfo(str, longValue, ((Integer) objArr[3]).intValue(), z2);
            } else {
                sb = b(str, z2).toString();
            }
        }
        return sb;
    }

    private static boolean a(String str, Thread thread) {
        if (thread == null) {
            return false;
        }
        synchronized (v) {
            int id = (int) thread.getId();
            if (v.get(id) == null) {
                w.add(Integer.valueOf(id));
            }
            v.put(id, new Object[]{new WeakReference(thread), str});
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0084  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0087  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x00cc A[Catch: all -> 0x0102, TryCatch #7 {, blocks: (B:4:0x0003, B:5:0x000d, B:7:0x0013, B:25:0x0068, B:50:0x011e, B:26:0x006b, B:30:0x0089, B:34:0x00c5, B:36:0x00cc, B:37:0x00d5, B:39:0x00da, B:41:0x00de, B:42:0x00e7, B:46:0x0106), top: B:57:0x0003 }] */
    /* JADX WARN: Removed duplicated region for block: B:39:0x00da A[Catch: all -> 0x0102, TryCatch #7 {, blocks: (B:4:0x0003, B:5:0x000d, B:7:0x0013, B:25:0x0068, B:50:0x011e, B:26:0x006b, B:30:0x0089, B:34:0x00c5, B:36:0x00cc, B:37:0x00d5, B:39:0x00da, B:41:0x00de, B:42:0x00e7, B:46:0x0106), top: B:57:0x0003 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static void a(java.io.OutputStream r13, java.lang.String r14, java.lang.String r15) {
        /*
            Method dump skipped, instructions count: 291
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.uc.crashsdk.a.a(java.io.OutputStream, java.lang.String, java.lang.String):void");
    }

    public static int a(String str, int i2, int i3) {
        int i4;
        int i5;
        boolean z2;
        if (str == null || i2 <= 0) {
            return 0;
        }
        if (i2 > 1500) {
            com.uc.crashsdk.a.a.a("crashsdk", "createCachedInfo: capacity is too large!", null);
            return 0;
        }
        synchronized (x) {
            if (x.containsKey(str)) {
                i5 = ((Integer) x.get(str)[1]).intValue();
                i4 = LogType.addType(i5, i3);
            } else {
                i4 = i3;
                i5 = 0;
            }
            if (LogType.isForJava(i4) && !LogType.isForJava(i5)) {
                if (z >= 8) {
                    i4 = LogType.removeType(i4, 16);
                } else {
                    z++;
                }
            }
            if (LogType.isForNative(i4) && !LogType.isForNative(i5)) {
                if (A >= 8) {
                    i4 = LogType.removeType(i4, 1);
                } else {
                    A++;
                }
            }
            if ((i4 & 273) == 0) {
                z2 = false;
            } else {
                if (i5 == 0) {
                    y.add(str);
                }
                z2 = true;
            }
            if (z2) {
                if (b.d && LogType.isForNative(i3) && !JNIBridge.nativeCreateCachedInfo(str, i2)) {
                    i4 = LogType.removeType(i4, 1);
                }
                x.put(str, new Object[]{Integer.valueOf(i2), Integer.valueOf(i4), new ArrayList()});
            }
        }
        return i4;
    }

    public static int a(int i2, String str) {
        if (com.uc.crashsdk.a.g.a(str)) {
            str = Thread.currentThread().getName();
        }
        int i3 = 0;
        if (LogType.isForNative(i2)) {
            if (b.d) {
                synchronized (v) {
                    JNIBridge.nativeRegisterCurrentThread(str);
                }
                i3 = 1;
            } else {
                com.uc.crashsdk.a.a.a("crashsdk", "crashsdk so has not loaded!", null);
            }
        }
        if (LogType.isForJava(i2)) {
            a(str, Thread.currentThread());
            return i3 | 16;
        }
        return i3;
    }

    public static boolean a(boolean z2) {
        int E;
        if (!b.c) {
            com.uc.crashsdk.a.a.b("Unexp log not enabled, skip update unexp info!");
            return false;
        } else if (e.y() || b.D()) {
            return false;
        } else {
            if (z2) {
                com.uc.crashsdk.a.f.a(B);
                E = 0;
            } else if (!b.y()) {
                com.uc.crashsdk.a.a.b("Stop update unexp info in background!");
                return false;
            } else if (h.E() <= 0) {
                return false;
            } else {
                if (com.uc.crashsdk.a.f.b(B)) {
                    return true;
                }
                E = h.E() * 1000;
            }
            com.uc.crashsdk.a.f.a(0, B, E);
            return true;
        }
    }

    public static void a(int i2) {
        if (i2 == 201) {
            com.uc.crashsdk.a.a.b("Begin update unexp info ...");
            long currentTimeMillis = System.currentTimeMillis();
            if (b.d && c) {
                JNIBridge.nativeUpdateUnexpInfo(h.E());
            }
            com.uc.crashsdk.a.a.b("Update unexp info took " + (System.currentTimeMillis() - currentTimeMillis) + " ms");
            a(false);
        } else if (i2 != 202) {
            if (!d) {
                throw new AssertionError();
            }
        } else {
            String format = String.format(Locale.US, "%s/%s/%s", h.P(), h.Q(), h.R());
            if (e.a()) {
                com.uc.crashsdk.a.a.a("crashsdk", "UUID: " + e.n());
                com.uc.crashsdk.a.a.a("crashsdk", "Version: " + format);
                com.uc.crashsdk.a.a.a("crashsdk", "Process Name: " + e.g());
            }
            g = l();
            if (b.d) {
                JNIBridge.nativeSyncStatus("ver", g, 0);
            }
            boolean z2 = !format.equals(g);
            if (z2) {
                com.uc.crashsdk.a.b.a(b.l(), format);
            }
            if (z2 && h.v()) {
                com.uc.crashsdk.a.a.b(String.format(Locale.US, "Is new version ('%s' -> '%s'), deleting old stats data!", g, format));
                b.s();
            }
        }
    }
}
