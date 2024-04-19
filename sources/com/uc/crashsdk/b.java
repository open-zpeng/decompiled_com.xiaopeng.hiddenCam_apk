package com.uc.crashsdk;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.os.Process;
import android.util.Log;
import com.xiaopeng.lib.framework.moduleinterface.carcontroller.IInputController;
import com.xiaopeng.libconfig.ipc.AccountConfig;
import java.io.File;
import java.io.RandomAccessFile;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;
import java.util.Locale;
import java.util.Map;
import java.util.WeakHashMap;
/* compiled from: ProGuard */
/* loaded from: classes.dex */
public class b {
    static final /* synthetic */ boolean h = !b.class.desiredAssertionStatus();
    private static String i = null;
    private static String j = null;
    private static String k = null;
    private static String l = null;
    private static String m = null;
    private static String n = null;
    private static String o = null;
    private static String p = null;
    private static String q = null;
    private static String r = null;
    private static String s = null;
    private static String t = null;
    public static boolean a = false;
    public static boolean b = false;
    public static boolean c = false;
    public static boolean d = false;
    public static final Object e = new Object();
    public static boolean f = false;
    public static boolean g = false;
    private static boolean u = false;
    private static boolean v = false;
    private static volatile boolean w = false;
    private static boolean x = false;
    private static boolean y = false;
    private static boolean z = false;
    private static final Object A = new Object();
    private static String B = null;
    private static int C = 0;
    private static RandomAccessFile D = null;
    private static boolean E = false;
    private static final Object F = new Object();
    private static String G = null;
    private static boolean H = false;
    private static volatile Object[] I = null;
    private static Runnable J = new com.uc.crashsdk.a.e(101);
    private static boolean K = false;
    private static long L = 0;
    private static final Object M = new Object();
    private static long N = 0;
    private static boolean O = false;
    private static boolean P = false;
    private static boolean Q = false;
    private static final WeakHashMap<Activity, Integer> R = new WeakHashMap<>();
    private static boolean S = false;
    private static boolean T = false;
    private static boolean U = false;
    private static boolean V = false;
    private static boolean W = false;
    private static final Object X = new Object();

    public static boolean A() {
        if (!T) {
            if (!com.uc.crashsdk.a.g.a(a.a) && a.a.equals(e.g())) {
                U = true;
                if (d) {
                    JNIBridge.nativeSetProcessType(true);
                }
            }
            T = true;
        }
        return U;
    }

    public static int B() {
        boolean I2 = I();
        return q() ? I2 ? 3 : 6 : p() ? I2 ? 2 : 5 : I2 ? 4 : 1;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void C() {
        if (d) {
            JNIBridge.nativeSyncStatus("logType", "12", C);
        }
    }

    public static boolean D() {
        if (!W) {
            synchronized (X) {
                if (!W) {
                    V = P();
                    W = true;
                }
            }
        }
        return V;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ boolean E() {
        S = true;
        return true;
    }

    private static String G() {
        if (i == null) {
            i = a("ss");
        }
        return i;
    }

    private static void H() {
        if (w || v) {
            return;
        }
        synchronized (A) {
            if (w) {
                return;
            }
            b(h.S());
            String n2 = n();
            File file = new File(b());
            x = "f".equals(n2);
            y = "b".equals(n2);
            z = file.exists();
            if (w()) {
                K();
            }
            w = true;
        }
    }

    private static boolean I() {
        H();
        return z;
    }

    private static void J() {
        if (d) {
            JNIBridge.nativeSyncStatus("exit", null, u ? 1 : 0);
        }
    }

    private static void K() {
        if (!K) {
            K = true;
            try {
                new File(b()).delete();
            } catch (Throwable th) {
                com.uc.crashsdk.a.g.a(th);
            }
        }
        Object[] M2 = M();
        if (!M2[0].equals(G) && I == null) {
            a(M2);
            return;
        }
        H = true;
        L();
    }

    private static void L() {
        if (!com.uc.crashsdk.a.f.b(J)) {
            com.uc.crashsdk.a.f.a(1, J);
            return;
        }
        Object[] objArr = I;
        if (objArr == null || !M()[0].equals(objArr[0])) {
            com.uc.crashsdk.a.f.a(J);
            com.uc.crashsdk.a.f.a(1, J);
        }
    }

    private static Object[] M() {
        synchronized (M) {
            N++;
            if (u) {
                return new Object[]{"e", Long.valueOf(N)};
            } else if (y()) {
                return new Object[]{"f", Long.valueOf(N)};
            } else {
                return new Object[]{"b", Long.valueOf(N)};
            }
        }
    }

    private static Object N() {
        Method declaredMethod;
        Object a2;
        Object a3 = a((Application) com.uc.crashsdk.a.g.a(), Application.class, "mLoadedApk");
        if (a3 == null || (a2 = a(a3, (Class<?>) null, "mActivityThread")) == null) {
            try {
                Class<?> cls = Class.forName("android.app.ActivityThread");
                if (cls != null && (declaredMethod = cls.getDeclaredMethod("currentActivityThread", new Class[0])) != null) {
                    declaredMethod.setAccessible(true);
                    return declaredMethod.invoke(null, new Object[0]);
                }
            } catch (Throwable th) {
                com.uc.crashsdk.a.g.a(th);
            }
            return null;
        }
        return a2;
    }

    private static boolean O() {
        String a2 = com.uc.crashsdk.a.g.a(new File("/proc/self/cgroup"), (int) IInputController.KEYCODE_BACK_BUTTON);
        if (com.uc.crashsdk.a.g.a(a2)) {
            return false;
        }
        return a2.contains("/bg_non_interactive") || a2.contains("/background");
    }

    private static boolean P() {
        try {
            Method declaredMethod = Process.class.getDeclaredMethod("isIsolated", new Class[0]);
            if (declaredMethod != null) {
                declaredMethod.setAccessible(true);
                Object invoke = declaredMethod.invoke(null, new Object[0]);
                if (invoke != null && (invoke instanceof Boolean)) {
                    return ((Boolean) invoke).booleanValue();
                }
            }
        } catch (Throwable th) {
            com.uc.crashsdk.a.g.a(th);
        }
        int myUid = Process.myUid() % 100000;
        return myUid >= 99000 && myUid <= 99999;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String a() {
        int i2;
        String str = B;
        if (str != null) {
            return str;
        }
        String g2 = e.g();
        if (com.uc.crashsdk.a.g.a(g2)) {
            B = "LLUN";
        } else {
            if (g2.length() > 48) {
                i2 = g2.length() - 48;
                g2 = g2.substring(0, 48);
            } else {
                i2 = 0;
            }
            StringBuilder sb = new StringBuilder();
            byte[] bytes = g2.getBytes();
            for (int length = bytes.length - 1; length >= 0; length--) {
                byte b2 = bytes[length];
                if (b2 == 46) {
                    sb.append('0');
                } else if (b2 == 58) {
                    sb.append('1');
                } else if (b2 >= 97 && b2 <= 122) {
                    sb.append((char) ((b2 + 65) - 97));
                } else if (b2 >= 65 && b2 <= 90) {
                    sb.append((char) b2);
                } else if (b2 >= 48 && b2 <= 57) {
                    sb.append((char) b2);
                } else {
                    sb.append('2');
                }
            }
            if (i2 > 0) {
                sb.append(String.valueOf(i2));
            }
            B = sb.toString();
        }
        return B;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String b() {
        if (j == null) {
            j = a("ct");
        }
        return j;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String c() {
        if (k == null) {
            k = a("st");
        }
        return k;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String d() {
        if (l == null) {
            l = a("rt");
        }
        return l;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String e() {
        if (r == null) {
            r = a("lgsuf");
        }
        return r;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String f() {
        if (s == null) {
            s = a("bati");
        }
        return s;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String g() {
        if (t == null) {
            t = a("hdr");
        }
        return t;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String h() {
        if (m == null) {
            m = h.S() + AccountConfig.FaceIDRegisterAction.ORIENTATION_UP;
        }
        return m;
    }

    public static String i() {
        if (n == null) {
            n = h.S() + "authu";
        }
        return n;
    }

    public static String j() {
        if (o == null) {
            o = h.S() + "statu";
        }
        return o;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String k() {
        if (p == null) {
            p = h.S() + "poli";
        }
        return p;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String l() {
        if (q == null) {
            q = h.S() + "ver";
        }
        return q;
    }

    public static String m() {
        return h.S() + "bvu";
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String n() {
        return com.uc.crashsdk.a.g.a(new File(G()), 8);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean o() {
        return v;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean p() {
        H();
        return x;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean q() {
        H();
        return y;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean r() {
        return u;
    }

    public static void s() {
        boolean z2;
        b(h.S());
        v = true;
        x = false;
        y = false;
        z = false;
        String[] strArr = {".st", ".wa", ".callback", ".ct", ".signal"};
        String[] strArr2 = {AccountConfig.FaceIDRegisterAction.ORIENTATION_UP, "authu", "statu", "poli"};
        File[] listFiles = new File(h.S()).listFiles();
        if (listFiles != null) {
            for (File file : listFiles) {
                String name = file.getName();
                int i2 = 0;
                while (true) {
                    if (i2 >= 5) {
                        z2 = false;
                        break;
                    } else if (name.endsWith(strArr[i2])) {
                        z2 = true;
                        break;
                    } else {
                        i2++;
                    }
                }
                if (!z2) {
                    int i3 = 0;
                    while (true) {
                        if (i3 >= 4) {
                            break;
                        } else if (name.equals(strArr2[i3])) {
                            z2 = true;
                            break;
                        } else {
                            i3++;
                        }
                    }
                }
                if (z2) {
                    com.uc.crashsdk.a.a.b("delete file: " + file.getPath());
                    com.uc.crashsdk.a.g.a(file);
                }
            }
        }
        K();
    }

    public static void t() {
        if (u) {
            return;
        }
        u = true;
        if (D()) {
            return;
        }
        b(h.S());
        J();
        K();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean u() {
        return b(h.S());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean v() {
        return b(h.T());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean w() {
        return O || !O();
    }

    public static boolean x() {
        return P || !O();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean y() {
        return P && !u;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void z() {
        com.uc.crashsdk.a.f.a(2, new com.uc.crashsdk.a.e(100));
    }

    private static boolean b(String str) {
        File file = new File(str);
        if (!file.exists()) {
            file.mkdirs();
        }
        if (file.isDirectory()) {
            return true;
        }
        com.uc.crashsdk.a.a.a("crashsdk", "Crash log directory was placed by a file!", null);
        if (file.delete()) {
            file.mkdirs();
            return true;
        }
        return false;
    }

    public static boolean c(int i2) {
        return (i2 & C) != 0;
    }

    public static void b(int i2) {
        C = i2;
        C();
    }

    private static String a(String str) {
        return h.S() + a() + "." + str;
    }

    private static void a(Object[] objArr) {
        I = objArr;
        synchronized (F) {
            String str = (String) objArr[0];
            long longValue = ((Long) objArr[1]).longValue();
            if (longValue < L) {
                com.uc.crashsdk.a.a.b("crashsdk", String.format(Locale.US, "Update state generation %d, last is: %d", Long.valueOf(longValue), Long.valueOf(L)));
                return;
            }
            L = longValue;
            String G2 = G();
            if (d) {
                if (D != null) {
                    com.uc.crashsdk.a.g.a(D);
                    D = null;
                }
                boolean nativeChangeState = JNIBridge.nativeChangeState(G2, str, E);
                E = false;
                if (!nativeChangeState) {
                    com.uc.crashsdk.a.a.c("write state failed: " + str);
                }
            } else {
                if (D == null || E) {
                    if (D != null) {
                        com.uc.crashsdk.a.g.a(D);
                        D = null;
                    }
                    try {
                        RandomAccessFile randomAccessFile = new RandomAccessFile(G2, "rw");
                        D = randomAccessFile;
                        randomAccessFile.seek(0L);
                        E = false;
                    } catch (Exception e2) {
                        com.uc.crashsdk.a.g.a(e2);
                    }
                }
                try {
                    D.write(str.getBytes());
                    D.seek(0L);
                } catch (Exception e3) {
                    com.uc.crashsdk.a.g.a(e3);
                }
            }
            G = str;
            I = null;
        }
    }

    public static void a(boolean z2) {
        if (z2 && u) {
            if (h.K()) {
                Log.v("crashsdk", "setForeground, reset sExited to false!!!");
            }
            u = false;
            J();
        }
        if (u) {
            return;
        }
        boolean z3 = e.y() || D();
        if (!z3) {
            H();
        }
        P = z2;
        if (z2) {
            O = true;
        }
        if (d) {
            JNIBridge.nativeSetForeground(z2);
        }
        if (z3) {
            return;
        }
        K();
        if (z2) {
            a.a(false);
            if (!Q) {
                e.v();
                Q = true;
            }
        }
        if (!E) {
            L();
        }
        e.c(z2);
    }

    public static boolean a(Context context) {
        try {
            ((Application) context).registerActivityLifecycleCallbacks(new c());
            if (h.I()) {
                z();
                return true;
            }
            return true;
        } catch (Throwable th) {
            com.uc.crashsdk.a.g.a(th);
            return false;
        }
    }

    public static void a(int i2) {
        Object a2;
        Activity activity;
        int i3;
        boolean z2 = true;
        boolean z3 = false;
        if (i2 != 100) {
            if (i2 != 101) {
                if (!h) {
                    throw new AssertionError();
                }
                return;
            }
            try {
                if (new File(G()).exists()) {
                    z2 = false;
                }
                E = z2;
                if (z2 || H) {
                    a(M());
                    H = false;
                    return;
                }
                return;
            } catch (Throwable th) {
                com.uc.crashsdk.a.g.a(th);
                return;
            }
        }
        Object N2 = N();
        if (N2 == null || (a2 = a(N2, (Class<?>) null, "mActivities")) == null) {
            return;
        }
        try {
            boolean z4 = false;
            for (Map.Entry entry : ((Map) a2).entrySet()) {
                Object value = entry.getValue();
                if (value != null && (activity = (Activity) a(value, (Class<?>) null, "activity")) != null) {
                    boolean booleanValue = ((Boolean) a(value, (Class<?>) null, "paused")).booleanValue();
                    boolean booleanValue2 = ((Boolean) a(value, (Class<?>) null, "stopped")).booleanValue();
                    synchronized (R) {
                        if (booleanValue || booleanValue2) {
                            i3 = 2;
                        } else {
                            i3 = 1;
                            z4 = true;
                        }
                        R.put(activity, Integer.valueOf(i3));
                    }
                }
                z3 = true;
            }
            if (z3) {
                a(z4);
            }
        } catch (Throwable th2) {
            com.uc.crashsdk.a.g.a(th2);
        }
    }

    private static Object a(Object obj, Class<?> cls, String str) {
        if (obj == null) {
            return null;
        }
        if (cls == null) {
            cls = obj.getClass();
        }
        try {
            Field declaredField = cls.getDeclaredField(str);
            declaredField.setAccessible(true);
            return declaredField.get(obj);
        } catch (Throwable th) {
            com.uc.crashsdk.a.g.a(th);
            return null;
        }
    }

    public static boolean a(Object obj, String str, com.uc.crashsdk.a.e eVar) {
        Throwable th;
        FileChannel fileChannel;
        synchronized (obj) {
            FileChannel fileChannel2 = null;
            r1 = null;
            FileLock lock = null;
            fileChannel2 = null;
            boolean z2 = false;
            if (d) {
                int nativeOpenFile = JNIBridge.nativeOpenFile(str);
                if (nativeOpenFile < 0) {
                    com.uc.crashsdk.a.a.a("crashsdk", "Can not open file: " + str, null);
                    return false;
                }
                boolean nativeLockFile = JNIBridge.nativeLockFile(nativeOpenFile, true);
                try {
                    boolean a2 = eVar.a();
                    JNIBridge.nativeCloseFile(nativeOpenFile);
                    z2 = a2;
                } finally {
                    if (nativeLockFile) {
                        JNIBridge.nativeLockFile(nativeOpenFile, false);
                    }
                }
            } else {
                File file = new File(str);
                if (!file.exists()) {
                    try {
                        file.createNewFile();
                    } catch (Exception e2) {
                        com.uc.crashsdk.a.g.a(e2);
                    }
                }
                try {
                    try {
                        fileChannel = new RandomAccessFile(file, "rw").getChannel();
                    } catch (Exception e3) {
                        try {
                            com.uc.crashsdk.a.g.a(e3);
                            fileChannel = null;
                        } catch (Exception e4) {
                            e = e4;
                            com.uc.crashsdk.a.g.a(e);
                            com.uc.crashsdk.a.g.a(fileChannel2);
                            return z2;
                        }
                    }
                    if (fileChannel != null) {
                        try {
                            try {
                                lock = fileChannel.lock();
                            } catch (Exception e5) {
                                try {
                                    com.uc.crashsdk.a.g.a(e5);
                                } catch (Exception e6) {
                                    e = e6;
                                    fileChannel2 = fileChannel;
                                    com.uc.crashsdk.a.g.a(e);
                                    com.uc.crashsdk.a.g.a(fileChannel2);
                                    return z2;
                                }
                            }
                        } catch (Throwable th2) {
                            th = th2;
                            com.uc.crashsdk.a.g.a(fileChannel);
                            throw th;
                        }
                    }
                    try {
                        z2 = eVar.a();
                        com.uc.crashsdk.a.g.a(fileChannel);
                    } finally {
                        if (lock != null) {
                            try {
                                lock.release();
                            } catch (Exception e7) {
                                com.uc.crashsdk.a.g.a(e7);
                            }
                        }
                    }
                } catch (Throwable th3) {
                    th = th3;
                    fileChannel = fileChannel2;
                    com.uc.crashsdk.a.g.a(fileChannel);
                    throw th;
                }
            }
            return z2;
        }
    }
}
