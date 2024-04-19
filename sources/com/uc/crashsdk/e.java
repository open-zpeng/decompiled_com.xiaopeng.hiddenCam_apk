package com.uc.crashsdk;

import android.app.ActivityManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Build;
import android.os.Debug;
import android.os.Looper;
import android.os.ParcelFileDescriptor;
import android.os.Process;
import android.os.StatFs;
import android.os.StrictMode;
import com.alibaba.sdk.android.oss.common.OSSConstants;
import com.uc.crashsdk.export.LogType;
import com.xiaopeng.lib.framework.moduleinterface.carcontroller.IInputController;
import com.xiaopeng.lib.utils.info.BuildInfoUtils;
import com.xiaopeng.speech.protocol.bean.stats.SceneSettingStatisticsBean;
import com.xiaopeng.speech.protocol.bean.stats.StatCommonBean;
import java.io.BufferedReader;
import java.io.Closeable;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintStream;
import java.io.RandomAccessFile;
import java.lang.Thread;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
/* compiled from: ProGuard */
/* loaded from: classes.dex */
public class e implements Thread.UncaughtExceptionHandler {
    private static long b;
    private static String h;
    private final List<FileInputStream> e = new ArrayList();
    static final /* synthetic */ boolean a = !e.class.desiredAssertionStatus();
    private static volatile boolean c = false;
    private static boolean d = false;
    private static long f = 0;
    private static boolean g = true;
    private static boolean i = false;
    private static String j = null;
    private static String k = null;
    private static String l = null;
    private static String m = null;
    private static final Object n = new Object();
    private static final Object o = new Object();
    private static final Object p = new Object();
    private static final Object q = new Object();
    private static final ArrayList<String> r = new ArrayList<>();
    private static int s = 0;
    private static String t = null;
    private static boolean u = false;
    private static String v = null;
    private static String w = null;
    private static String x = null;
    private static final Object y = new Object();
    private static final Object z = new Object();
    private static Map<String, Integer> A = null;
    private static String B = null;
    private static int C = -1;
    private static int D = -1;
    private static int E = -1;
    private static int F = -1;
    private static int G = -1;
    private static int H = -1;
    private static int I = -1;
    private static String J = "?";
    private static boolean K = false;
    private static boolean L = false;
    private static int M = 0;
    private static com.uc.crashsdk.a.e N = new com.uc.crashsdk.a.e(405);
    private static a O = new a((byte) 0);
    private static boolean P = false;
    private static final com.uc.crashsdk.a.e Q = new com.uc.crashsdk.a.e(412);
    private static Thread.UncaughtExceptionHandler R = null;
    private static Throwable S = null;
    private static boolean T = false;
    private static boolean U = false;
    private static Runnable V = null;
    private static final Object W = new Object();
    private static Runnable X = new com.uc.crashsdk.a.e(407);
    private static final Object Y = new Object();
    private static boolean Z = false;
    private static boolean aa = false;
    private static ParcelFileDescriptor ab = null;
    private static boolean ac = false;
    private static boolean ad = false;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: ProGuard */
    /* loaded from: classes.dex */
    public static class a extends BroadcastReceiver {
        private a() {
        }

        @Override // android.content.BroadcastReceiver
        public final void onReceive(Context context, Intent intent) {
            String action = intent.getAction();
            if ("android.intent.action.BATTERY_CHANGED".equals(action)) {
                int unused = e.C = intent.getIntExtra("level", -1);
                int unused2 = e.D = intent.getIntExtra("scale", -1);
                int unused3 = e.E = intent.getIntExtra("voltage", -1);
                int unused4 = e.F = intent.getIntExtra("health", -1);
                int unused5 = e.G = intent.getIntExtra("plugged", -1);
                int unused6 = e.H = intent.getIntExtra("status", -1);
                int unused7 = e.I = intent.getIntExtra("temperature", -1);
                String unused8 = e.J = intent.getStringExtra("technology");
                if (e.B() >= 2) {
                    e.C();
                    e.D();
                }
            } else if ("android.intent.action.BATTERY_LOW".equals(action) || "android.intent.action.BATTERY_OKAY".equals(action)) {
                boolean unused9 = e.K = "android.intent.action.BATTERY_LOW".equals(action);
                e.C();
            }
        }

        /* synthetic */ a(byte b) {
            this();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: ProGuard */
    /* loaded from: classes.dex */
    public static class c implements Comparator<File> {
        private c() {
        }

        @Override // java.util.Comparator
        public final /* synthetic */ int compare(File file, File file2) {
            File file3 = file;
            File file4 = file2;
            if (file3.lastModified() > file4.lastModified()) {
                return 1;
            }
            return file3.lastModified() < file4.lastModified() ? -1 : 0;
        }

        /* synthetic */ c(byte b) {
            this();
        }
    }

    public e() {
        try {
            E();
        } catch (Throwable th) {
            com.uc.crashsdk.a.g.a(th);
        }
    }

    static /* synthetic */ boolean A() {
        if (h.L()) {
            return true;
        }
        return a();
    }

    static /* synthetic */ int B() {
        int i2 = M + 1;
        M = i2;
        return i2;
    }

    static /* synthetic */ void C() {
        StringBuilder L2;
        if (com.uc.crashsdk.b.d && (L2 = L()) != null) {
            JNIBridge.nativeSyncStatus("bati", L2.toString(), 0);
        }
        L = true;
        M();
    }

    static /* synthetic */ int D() {
        M = 0;
        return 0;
    }

    private void E() {
        int F2 = h.F();
        for (int i2 = 0; i2 < F2; i2++) {
            try {
                this.e.add(new FileInputStream("/dev/null"));
            } catch (Exception e) {
                com.uc.crashsdk.a.g.a(e);
                return;
            }
        }
    }

    private static String F() {
        return h.f() + "_";
    }

    private static String G() {
        return com.uc.crashsdk.b.y() ? "fg" : "bg";
    }

    private static byte[] H() {
        byte[] bArr = null;
        int i2 = 1024;
        while (bArr == null && i2 > 0) {
            try {
                bArr = new byte[i2];
            } catch (Throwable unused) {
                i2 /= 2;
                if (i2 < 16) {
                    break;
                }
            }
        }
        return bArr;
    }

    private static String I() {
        return (!com.uc.crashsdk.b.A() || d) ? LogType.JAVA_TYPE : "ucebujava";
    }

    private static void J() {
        String str;
        BufferedReader bufferedReader;
        Throwable th;
        FileReader fileReader;
        String str2 = "-";
        try {
            str = Build.HARDWARE;
        } catch (Throwable th2) {
            com.uc.crashsdk.a.g.a(th2);
            str = "-";
        }
        try {
            fileReader = new FileReader(new File("/proc/cpuinfo"));
            try {
                bufferedReader = new BufferedReader(fileReader, IInputController.KEYCODE_BACK_BUTTON);
                int i2 = 0;
                do {
                    try {
                        String readLine = bufferedReader.readLine();
                        if (readLine == null) {
                            break;
                        }
                        if (readLine.startsWith("Hardware")) {
                            str = readLine.substring(readLine.indexOf(":") + 1).trim();
                        } else if (readLine.startsWith("Processor")) {
                            str2 = readLine.substring(readLine.indexOf(":") + 1).trim();
                        }
                        i2++;
                    } catch (Throwable th3) {
                        th = th3;
                        try {
                            com.uc.crashsdk.a.g.a(th);
                            com.uc.crashsdk.a.g.a(fileReader);
                            com.uc.crashsdk.a.g.a(bufferedReader);
                            k = str;
                            l = str2;
                        } catch (Throwable th4) {
                            com.uc.crashsdk.a.g.a(fileReader);
                            com.uc.crashsdk.a.g.a(bufferedReader);
                            throw th4;
                        }
                    }
                } while (i2 < 2);
                com.uc.crashsdk.a.g.a(fileReader);
            } catch (Throwable th5) {
                bufferedReader = null;
                th = th5;
            }
        } catch (Throwable th6) {
            bufferedReader = null;
            th = th6;
            fileReader = null;
        }
        com.uc.crashsdk.a.g.a(bufferedReader);
        k = str;
        l = str2;
    }

    private static String K() {
        return h.S() + "bytes";
    }

    private static StringBuilder L() {
        String str;
        try {
            StringBuilder sb = new StringBuilder();
            sb.append("level: ");
            sb.append(C);
            sb.append("\n");
            sb.append("scale: ");
            sb.append(D);
            sb.append("\n");
            switch (F) {
                case 1:
                    str = " (Unknown)";
                    break;
                case 2:
                    str = " (Good)";
                    break;
                case 3:
                    str = " (Overheat)";
                    break;
                case 4:
                    str = " (Dead)";
                    break;
                case 5:
                    str = " (Over voltage)";
                    break;
                case 6:
                    str = " (Unspecified failure)";
                    break;
                case 7:
                    str = " (Cold)";
                    break;
                default:
                    str = " (?)";
                    break;
            }
            sb.append("health: ");
            sb.append(F);
            sb.append(str);
            sb.append("\n");
            int i2 = G;
            String str2 = i2 != 0 ? i2 != 1 ? i2 != 2 ? i2 != 4 ? " (?)" : " (Wireless)" : " (USB port)" : " (AC charger)" : " (None)";
            sb.append("pluged: ");
            sb.append(G);
            sb.append(str2);
            sb.append("\n");
            int i3 = H;
            String str3 = i3 != 1 ? i3 != 2 ? i3 != 3 ? i3 != 4 ? i3 != 5 ? " (?)" : " (Full)" : " (Not charging)" : " (Discharging)" : " (Charging)" : " (Unknown)";
            sb.append("status: ");
            sb.append(H);
            sb.append(str3);
            sb.append("\n");
            sb.append("voltage: ");
            sb.append(E);
            sb.append("\n");
            sb.append("temperature: ");
            sb.append(I);
            sb.append("\n");
            sb.append("technology: ");
            sb.append(J);
            sb.append("\n");
            sb.append("battery low: ");
            sb.append(K);
            sb.append("\n");
            return sb;
        } catch (Throwable th) {
            com.uc.crashsdk.a.g.a(th);
            return null;
        }
    }

    private static void M() {
        if (com.uc.crashsdk.b.c && L && com.uc.crashsdk.a.c) {
            L = false;
            if (com.uc.crashsdk.a.f.b(N)) {
                return;
            }
            com.uc.crashsdk.a.f.a(0, N, 2000L);
        }
    }

    private static void N() {
        String U2 = h.U();
        File file = new File(U2);
        if (file.isDirectory()) {
            try {
                File[] listFiles = file.listFiles();
                if (listFiles != null && listFiles.length > 150) {
                    Arrays.sort(listFiles, new c((byte) 0));
                    int length = listFiles.length - 150;
                    if (length < 0) {
                        length = 0;
                    }
                    long currentTimeMillis = System.currentTimeMillis();
                    int i2 = 0;
                    int i3 = 0;
                    while (i2 < listFiles.length) {
                        File file2 = listFiles[i2];
                        boolean z2 = i2 < length;
                        if (!z2 && currentTimeMillis - file2.lastModified() >= 432000000) {
                            z2 = true;
                        }
                        if (!z2) {
                            break;
                        }
                        file2.delete();
                        i3++;
                        if (0 >= 3) {
                            break;
                        }
                        i2++;
                    }
                    com.uc.crashsdk.a.a.a("Removed " + i3 + " logs in " + U2);
                }
            } catch (Throwable th) {
                com.uc.crashsdk.a.g.a(th);
            }
        }
    }

    public static boolean a() {
        if (f == 0) {
            f = 2L;
            try {
                Method declaredMethod = Class.forName("android.os.SystemProperties").getDeclaredMethod("getLong", String.class, Long.TYPE);
                if (declaredMethod != null) {
                    declaredMethod.setAccessible(true);
                    if (((Long) declaredMethod.invoke(null, "debug.crs.logs", 0)).longValue() == 1) {
                        f = 1L;
                    }
                }
            } catch (Throwable th) {
                com.uc.crashsdk.a.g.a(th);
            }
        }
        return f == 1;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void b() {
        h = null;
    }

    public static String d(boolean z2) {
        return z2 ? "https://up4-intl.ucweb.com/upload" : "https://up4.ucweb.com/upload";
    }

    private static String j(String str) {
        if (str == null) {
            str = String.valueOf(System.currentTimeMillis());
        }
        return String.format(Locale.US, "%s%s_%s_%s_%s_%s_", F(), h.P(), h.R(), i(Build.MODEL), i(Build.VERSION.RELEASE), str);
    }

    private static String k(String str) {
        return String.format(Locale.US, "%s%s_%s_%s%s.log", c(), k(), G(), str, a(h.M()));
    }

    private static String l(String str) {
        if (com.uc.crashsdk.a.g.b(str)) {
            int indexOf = str.indexOf(0);
            if (indexOf >= 0) {
                str = str.substring(0, indexOf);
            }
            return str.trim();
        }
        return "";
    }

    private static String m(String str) {
        String a2 = com.uc.crashsdk.a.b.a(str, h.x(), h.w());
        if (!str.equals(a2)) {
            File file = new File(str);
            if (file.exists()) {
                file.delete();
            }
        }
        return a2;
    }

    private static String n(String str) {
        int lastIndexOf;
        if (h.w() && !com.uc.crashsdk.a.g.a(h.x()) && (lastIndexOf = str.lastIndexOf(".log")) > 0 && lastIndexOf + 4 == str.length()) {
            int lastIndexOf2 = str.lastIndexOf(File.separatorChar);
            int i2 = 0;
            if (lastIndexOf2 < 0) {
                lastIndexOf2 = 0;
            }
            do {
                lastIndexOf2 = str.indexOf(95, lastIndexOf2);
                if (lastIndexOf2 >= 0) {
                    i2++;
                    lastIndexOf2++;
                    continue;
                }
            } while (lastIndexOf2 >= 0);
            if (i2 != 8) {
                return str;
            }
            int lastIndexOf3 = str.lastIndexOf(95);
            if (a || lastIndexOf3 > 0) {
                if (str.indexOf(".log", lastIndexOf3) != lastIndexOf) {
                    return str;
                }
                try {
                    return m(str);
                } catch (Throwable th) {
                    com.uc.crashsdk.a.g.a(th);
                    return str;
                }
            }
            throw new AssertionError();
        }
        return str;
    }

    /* JADX WARN: Can't wrap try/catch for region: R(12:3|4|(3:6|(3:9|(1:11)(17:12|13|14|(13:48|49|18|(1:47)(1:21)|22|(1:24)|25|26|27|29|30|31|32)(1:16)|17|18|(0)|47|22|(0)|25|26|27|29|30|31|32)|7)|53)|54|(0)|25|26|27|29|30|31|32) */
    /* JADX WARN: Can't wrap try/catch for region: R(7:(3:6|(3:9|(1:11)(17:12|13|14|(13:48|49|18|(1:47)(1:21)|22|(1:24)|25|26|27|29|30|31|32)(1:16)|17|18|(0)|47|22|(0)|25|26|27|29|30|31|32)|7)|53)|26|27|29|30|31|32) */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x00d9, code lost:
        r0 = th;
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x00da, code lost:
        r1 = r4;
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x00dc, code lost:
        r0 = e;
     */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x00dd, code lost:
        r1 = r4;
     */
    /* JADX WARN: Code restructure failed: missing block: B:41:0x00e1, code lost:
        r0 = e;
     */
    /* JADX WARN: Code restructure failed: missing block: B:42:0x00e2, code lost:
        com.uc.crashsdk.a.g.a(r0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:43:0x00e5, code lost:
        com.uc.crashsdk.a.g.a(r1);
     */
    /* JADX WARN: Code restructure failed: missing block: B:46:0x00ea, code lost:
        com.uc.crashsdk.a.g.a(r1);
     */
    /* JADX WARN: Code restructure failed: missing block: B:47:0x00ed, code lost:
        throw r0;
     */
    /* JADX WARN: Removed duplicated region for block: B:29:0x00ae A[Catch: all -> 0x00ee, TRY_LEAVE, TryCatch #2 {, blocks: (B:4:0x0005, B:6:0x0033, B:7:0x0041, B:9:0x0047, B:11:0x0051, B:12:0x0056, B:15:0x0068, B:21:0x0078, B:26:0x0083, B:29:0x00ae, B:33:0x00d5, B:44:0x00e8, B:46:0x00ea, B:47:0x00ed, B:43:0x00e5, B:18:0x0072), top: B:51:0x0005, inners: #5 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static boolean o(java.lang.String r17) {
        /*
            Method dump skipped, instructions count: 241
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.uc.crashsdk.e.o(java.lang.String):boolean");
    }

    /* JADX WARN: Removed duplicated region for block: B:33:0x0098 A[Catch: all -> 0x00fe, TryCatch #0 {, blocks: (B:4:0x0003, B:6:0x0008, B:7:0x0018, B:9:0x0023, B:10:0x002d, B:36:0x00a6, B:47:0x00cb, B:54:0x00e6, B:50:0x00d6, B:65:0x00fc, B:61:0x00f1, B:11:0x0033, B:13:0x003b, B:14:0x0044, B:16:0x004c, B:18:0x0054, B:24:0x0062, B:26:0x006c, B:28:0x0079, B:30:0x0083, B:31:0x008e, B:33:0x0098), top: B:70:0x0003 }] */
    /* JADX WARN: Removed duplicated region for block: B:34:0x00a3  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x00a6 A[Catch: all -> 0x00fe, TryCatch #0 {, blocks: (B:4:0x0003, B:6:0x0008, B:7:0x0018, B:9:0x0023, B:10:0x002d, B:36:0x00a6, B:47:0x00cb, B:54:0x00e6, B:50:0x00d6, B:65:0x00fc, B:61:0x00f1, B:11:0x0033, B:13:0x003b, B:14:0x0044, B:16:0x004c, B:18:0x0054, B:24:0x0062, B:26:0x006c, B:28:0x0079, B:30:0x0083, B:31:0x008e, B:33:0x0098), top: B:70:0x0003 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static boolean p(java.lang.String r14) {
        /*
            Method dump skipped, instructions count: 257
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.uc.crashsdk.e.p(java.lang.String):boolean");
    }

    private static Map<String, Integer> q(String str) {
        HashMap hashMap = new HashMap();
        for (String str2 : str.split("\\|", 30)) {
            String[] split = str2.split(":", 3);
            if (split.length == 2) {
                String trim = split[0].trim();
                if (!com.uc.crashsdk.a.g.a(trim)) {
                    int i2 = 1;
                    try {
                        i2 = Integer.parseInt(split[1].trim(), 10);
                    } catch (Throwable th) {
                        com.uc.crashsdk.a.g.a(th);
                    }
                    hashMap.put(trim, Integer.valueOf(i2));
                }
            }
        }
        return hashMap;
    }

    private static void r(String str) {
        if (h.r()) {
            try {
                N();
            } catch (Throwable th) {
                com.uc.crashsdk.a.g.a(th);
            }
            if (str == null || "".equals(str)) {
                return;
            }
            try {
                File file = new File(h.U());
                if (!file.exists()) {
                    file.mkdirs();
                }
                com.uc.crashsdk.a.a.b("copy log to: " + file);
                com.uc.crashsdk.a.g.a(new File(str), file);
            } catch (Throwable th2) {
                com.uc.crashsdk.a.g.a(th2);
            }
        }
    }

    private static String s(String str) {
        return String.format("$^%s^$", str);
    }

    public static boolean t() {
        synchronized (W) {
            if (V == null || U) {
                return false;
            }
            com.uc.crashsdk.a.f.a(V);
            V = null;
            return true;
        }
    }

    public static void u() {
        if (h.r()) {
            com.uc.crashsdk.a.f.a(0, new com.uc.crashsdk.a.e(403), 10000L);
        }
    }

    public static void v() {
        if (Z) {
            return;
        }
        com.uc.crashsdk.a.f.a(1, new com.uc.crashsdk.a.e(408), 1000L);
    }

    public static void w() {
        int i2 = 0;
        int i3 = 1;
        if (com.uc.crashsdk.b.D()) {
            i2 = 1;
        } else if (Looper.getMainLooper() != Looper.myLooper()) {
            com.uc.crashsdk.a.f.a(2, new com.uc.crashsdk.a.e(413));
        } else {
            i3 = 0;
        }
        JNIBridge.nativeInstallBreakpad(i2, i3);
    }

    public static ParcelFileDescriptor x() {
        if (!com.uc.crashsdk.b.d) {
            com.uc.crashsdk.a.a.c("crashsdk", "Crash so is not loaded!");
            return null;
        }
        ParcelFileDescriptor parcelFileDescriptor = ab;
        if (parcelFileDescriptor != null) {
            return parcelFileDescriptor;
        }
        int nativeGetOrSetHostFd = JNIBridge.nativeGetOrSetHostFd(2, -1);
        if (nativeGetOrSetHostFd == -1) {
            return null;
        }
        ab = ParcelFileDescriptor.adoptFd(nativeGetOrSetHostFd);
        ac = true;
        return ab;
    }

    public static boolean y() {
        return ad;
    }

    @Override // java.lang.Thread.UncaughtExceptionHandler
    public void uncaughtException(Thread thread, Throwable th) {
        a(thread, th, false);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void b(String str) {
        com.uc.crashsdk.a.f.a(0, new com.uc.crashsdk.a.e(404, new Object[]{str}));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String c() {
        String str = h;
        if (str != null) {
            return str;
        }
        String j2 = j(null);
        h = j2;
        return j2;
    }

    public static String d() {
        if (com.uc.crashsdk.a.g.a(j)) {
            if (Build.VERSION.SDK_INT >= 21) {
                try {
                    Field declaredField = Build.class.getDeclaredField("SUPPORTED_ABIS");
                    declaredField.setAccessible(true);
                    Object obj = declaredField.get(null);
                    if (obj != null && (obj instanceof String[])) {
                        String[] strArr = (String[]) obj;
                        StringBuilder sb = new StringBuilder();
                        int length = strArr.length;
                        boolean z2 = true;
                        int i2 = 0;
                        while (i2 < length) {
                            String str = strArr[i2];
                            if (!z2) {
                                sb.append(",");
                            }
                            sb.append(str);
                            i2++;
                            z2 = false;
                        }
                        j = sb.toString();
                    }
                } catch (Throwable unused) {
                }
            }
            if (com.uc.crashsdk.a.g.a(j)) {
                try {
                    j = Build.CPU_ABI;
                } catch (Throwable unused2) {
                }
            }
        }
        return j;
    }

    public static String e() {
        if (com.uc.crashsdk.a.g.a(k)) {
            J();
        }
        return k;
    }

    public static String g() {
        String str = m;
        if (str != null) {
            return str;
        }
        String a2 = a(Process.myPid());
        m = a2;
        return a2;
    }

    private static String i(String str) {
        try {
            return str.replaceAll("[^0-9a-zA-Z-.]", "-");
        } catch (Throwable unused) {
            return BuildInfoUtils.UNKNOWN;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void s() {
        if (com.uc.crashsdk.b.c && com.uc.crashsdk.a.c && !com.uc.crashsdk.a.f.b(X)) {
            com.uc.crashsdk.a.f.a(0, X, 1000L);
        }
    }

    public static boolean b(int i2, Object[] objArr) {
        if (i2 == 451) {
            if (a || objArr != null) {
                return a((String) objArr[0], (d) objArr[1]);
            }
            throw new AssertionError();
        } else if (i2 != 452) {
            if (a) {
                return false;
            }
            throw new AssertionError();
        } else if (a || objArr != null) {
            d dVar = (d) objArr[1];
            return com.uc.crashsdk.a.g.a(new File((String) objArr[0]), String.format(Locale.US, "%d %d %d %d", Long.valueOf(dVar.a), Long.valueOf(dVar.b), Integer.valueOf(dVar.c), Integer.valueOf(dVar.d)).getBytes());
        } else {
            throw new AssertionError();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String f() {
        try {
            StringBuilder sb = new StringBuilder();
            sb.append("JavaMax:    ");
            sb.append(Runtime.getRuntime().maxMemory() / 1024);
            sb.append(" kB\n");
            sb.append("JavaTotal:  ");
            sb.append(Runtime.getRuntime().totalMemory() / 1024);
            sb.append(" kB\n");
            sb.append("JavaFree:   ");
            sb.append(Runtime.getRuntime().freeMemory() / 1024);
            sb.append(" kB\n");
            sb.append("NativeHeap: ");
            sb.append(Debug.getNativeHeapSize() / 1024);
            sb.append(" kB\n");
            sb.append("NativeAllocated: ");
            sb.append(Debug.getNativeHeapAllocatedSize() / 1024);
            sb.append(" kB\n");
            sb.append("NativeFree: ");
            sb.append(Debug.getNativeHeapFreeSize() / 1024);
            sb.append(" kB\n");
            ActivityManager activityManager = (ActivityManager) com.uc.crashsdk.a.g.a().getSystemService("activity");
            if (activityManager != null) {
                ActivityManager.MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();
                activityManager.getMemoryInfo(memoryInfo);
                sb.append("\n");
                sb.append("availMem:   ");
                sb.append(memoryInfo.availMem / 1024);
                sb.append(" kB\n");
                sb.append("threshold:  ");
                sb.append(memoryInfo.threshold / 1024);
                sb.append(" kB\n");
                sb.append("lowMemory:  ");
                sb.append(memoryInfo.lowMemory);
                sb.append("\n");
            }
            return sb.toString();
        } catch (Throwable th) {
            com.uc.crashsdk.a.g.a(th);
            return "exception exists.";
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean h() {
        return d;
    }

    public static String i() {
        if (com.uc.crashsdk.a.g.a(w)) {
            synchronized (y) {
                w = com.uc.crashsdk.a.g.a(com.uc.crashsdk.b.h(), x, true);
            }
        }
        return w;
    }

    /* JADX WARN: Removed duplicated region for block: B:30:0x006e A[Catch: all -> 0x0080, TryCatch #0 {all -> 0x0080, blocks: (B:24:0x004d, B:26:0x0065, B:28:0x006b, B:30:0x006e, B:32:0x0076), top: B:38:0x004d }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static void c(java.io.OutputStream r7) {
        /*
            java.lang.String r0 = "UTF-8"
            java.lang.String r1 = "disk info:\n"
            byte[] r1 = r1.getBytes(r0)     // Catch: java.lang.Throwable -> Lc
            r7.write(r1)     // Catch: java.lang.Throwable -> Lc
            goto L10
        Lc:
            r1 = move-exception
            a(r1, r7)
        L10:
            boolean r1 = com.uc.crashsdk.e.ad
            r2 = 0
            if (r1 == 0) goto L2d
            com.uc.crashsdk.e.g = r2
            java.lang.String r1 = "FSSTAT"
            java.lang.String r1 = s(r1)     // Catch: java.lang.Throwable -> L25
            byte[] r0 = r1.getBytes(r0)     // Catch: java.lang.Throwable -> L25
            r7.write(r0)     // Catch: java.lang.Throwable -> L25
            goto L29
        L25:
            r0 = move-exception
            a(r0, r7)
        L29:
            r0 = 1
            com.uc.crashsdk.e.g = r0
            goto L84
        L2d:
            r0 = 0
            java.util.HashSet r1 = new java.util.HashSet     // Catch: java.lang.Throwable -> L46
            r1.<init>()     // Catch: java.lang.Throwable -> L46
            java.io.File r0 = new java.io.File     // Catch: java.lang.Throwable -> L44
            java.lang.String r3 = com.uc.crashsdk.a.g.b()     // Catch: java.lang.Throwable -> L44
            r0.<init>(r3)     // Catch: java.lang.Throwable -> L44
            java.lang.String r0 = a(r0)     // Catch: java.lang.Throwable -> L44
            a(r7, r0, r1)     // Catch: java.lang.Throwable -> L44
            goto L4d
        L44:
            r0 = move-exception
            goto L4a
        L46:
            r1 = move-exception
            r6 = r1
            r1 = r0
            r0 = r6
        L4a:
            a(r0, r7)
        L4d:
            java.io.File r0 = android.os.Environment.getExternalStorageDirectory()     // Catch: java.lang.Throwable -> L80
            java.lang.String r0 = a(r0)     // Catch: java.lang.Throwable -> L80
            a(r7, r0, r1)     // Catch: java.lang.Throwable -> L80
            java.io.File r0 = new java.io.File     // Catch: java.lang.Throwable -> L80
            java.lang.String r3 = "/storage"
            r0.<init>(r3)     // Catch: java.lang.Throwable -> L80
            boolean r3 = r0.exists()     // Catch: java.lang.Throwable -> L80
            if (r3 == 0) goto L84
            java.io.File[] r0 = r0.listFiles()     // Catch: java.lang.Throwable -> L80
            if (r0 == 0) goto L84
            int r3 = r0.length     // Catch: java.lang.Throwable -> L80
        L6c:
            if (r2 >= r3) goto L84
            r4 = r0[r2]     // Catch: java.lang.Throwable -> L80
            boolean r5 = r4.isDirectory()     // Catch: java.lang.Throwable -> L80
            if (r5 == 0) goto L7d
            java.lang.String r4 = a(r4)     // Catch: java.lang.Throwable -> L80
            a(r7, r4, r1)     // Catch: java.lang.Throwable -> L80
        L7d:
            int r2 = r2 + 1
            goto L6c
        L80:
            r0 = move-exception
            a(r0, r7)
        L84:
            a(r7)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.uc.crashsdk.e.c(java.io.OutputStream):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x0025 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0026 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static void e(java.io.OutputStream r12) {
        /*
            java.lang.String r0 = "UTF-8"
            r1 = 0
            r2 = 0
            int r3 = com.uc.crashsdk.h.H()     // Catch: java.lang.Throwable -> L1c
            java.io.File r4 = new java.io.File     // Catch: java.lang.Throwable -> L1a
            java.lang.String r5 = "/proc/self/task"
            r4.<init>(r5)     // Catch: java.lang.Throwable -> L1a
            java.io.File[] r2 = r4.listFiles()     // Catch: java.lang.Throwable -> L1a
            if (r2 != 0) goto L16
            return
        L16:
            int r4 = r2.length     // Catch: java.lang.Throwable -> L1a
            if (r4 >= r3) goto L23
            return
        L1a:
            r4 = move-exception
            goto L1f
        L1c:
            r4 = move-exception
            r3 = 300(0x12c, float:4.2E-43)
        L1f:
            com.uc.crashsdk.a.g.a(r4)
            r4 = r1
        L23:
            if (r2 != 0) goto L26
            return
        L26:
            java.lang.String r5 = "threads info:\n"
            byte[] r5 = r5.getBytes(r0)     // Catch: java.lang.Throwable -> L8e
            r12.write(r5)     // Catch: java.lang.Throwable -> L8e
            java.util.Locale r5 = java.util.Locale.US     // Catch: java.lang.Throwable -> L8e
            java.lang.String r6 = "threads count: %d, dump limit: %d.\n"
            r7 = 2
            java.lang.Object[] r8 = new java.lang.Object[r7]     // Catch: java.lang.Throwable -> L8e
            java.lang.Integer r4 = java.lang.Integer.valueOf(r4)     // Catch: java.lang.Throwable -> L8e
            r8[r1] = r4     // Catch: java.lang.Throwable -> L8e
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)     // Catch: java.lang.Throwable -> L8e
            r4 = 1
            r8[r4] = r3     // Catch: java.lang.Throwable -> L8e
            java.lang.String r3 = java.lang.String.format(r5, r6, r8)     // Catch: java.lang.Throwable -> L8e
            byte[] r3 = r3.getBytes(r0)     // Catch: java.lang.Throwable -> L8e
            r12.write(r3)     // Catch: java.lang.Throwable -> L8e
            java.lang.String r3 = " tid     name\n"
            byte[] r3 = r3.getBytes(r0)     // Catch: java.lang.Throwable -> L8e
            r12.write(r3)     // Catch: java.lang.Throwable -> L8e
            int r3 = r2.length     // Catch: java.lang.Throwable -> L8e
            r5 = r1
        L59:
            if (r5 >= r3) goto L92
            r6 = r2[r5]     // Catch: java.lang.Throwable -> L8e
            java.io.File r8 = new java.io.File     // Catch: java.lang.Throwable -> L8e
            java.lang.String r9 = r6.getPath()     // Catch: java.lang.Throwable -> L8e
            java.lang.String r10 = "comm"
            r8.<init>(r9, r10)     // Catch: java.lang.Throwable -> L8e
            r9 = 128(0x80, float:1.794E-43)
            java.lang.String r8 = com.uc.crashsdk.a.g.a(r8, r9)     // Catch: java.lang.Throwable -> L8e
            java.lang.String r8 = l(r8)     // Catch: java.lang.Throwable -> L8e
            java.util.Locale r9 = java.util.Locale.US     // Catch: java.lang.Throwable -> L8e
            java.lang.String r10 = "%5s %s\n"
            java.lang.Object[] r11 = new java.lang.Object[r7]     // Catch: java.lang.Throwable -> L8e
            java.lang.String r6 = r6.getName()     // Catch: java.lang.Throwable -> L8e
            r11[r1] = r6     // Catch: java.lang.Throwable -> L8e
            r11[r4] = r8     // Catch: java.lang.Throwable -> L8e
            java.lang.String r6 = java.lang.String.format(r9, r10, r11)     // Catch: java.lang.Throwable -> L8e
            byte[] r6 = r6.getBytes(r0)     // Catch: java.lang.Throwable -> L8e
            r12.write(r6)     // Catch: java.lang.Throwable -> L8e
            int r5 = r5 + 1
            goto L59
        L8e:
            r0 = move-exception
            a(r0, r12)
        L92:
            a(r12)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.uc.crashsdk.e.e(java.io.OutputStream):void");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static StringBuilder g(String str) {
        return a(Thread.currentThread().getStackTrace(), str);
    }

    public static void l() {
        b = System.currentTimeMillis();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String k() {
        return a(new Date());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: ProGuard */
    /* loaded from: classes.dex */
    public static class b extends OutputStream {
        private final long a;
        private final OutputStream b;
        private int c = 0;
        private int d = 0;
        private boolean e = false;

        b(long j, OutputStream outputStream) {
            this.a = j;
            this.b = outputStream;
        }

        /* JADX WARN: Removed duplicated region for block: B:14:0x0027  */
        /* JADX WARN: Removed duplicated region for block: B:15:0x0030  */
        /* JADX WARN: Removed duplicated region for block: B:17:0x0037  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        private int a(byte[] r6, int r7, int r8) {
            /*
                r5 = this;
                int r0 = r5.d
                int r0 = r0 + r8
                r5.d = r0
                boolean r0 = r5.e
                if (r0 == 0) goto Lb
                r6 = 0
                return r6
            Lb:
                int r0 = com.uc.crashsdk.h.y()
                if (r0 <= 0) goto L19
                int r1 = r5.c
                int r2 = r1 + r8
                if (r2 <= r0) goto L19
                int r0 = r0 - r1
                goto L1a
            L19:
                r0 = r8
            L1a:
                int r1 = r5.c
                int r1 = r1 + r0
                r5.c = r1
                long r1 = r5.a
                r3 = 0
                int r1 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
                if (r1 == 0) goto L30
                java.lang.String r1 = new java.lang.String
                r1.<init>(r6, r7, r0)
                r5.b(r1)
                goto L35
            L30:
                java.io.OutputStream r1 = r5.b
                r1.write(r6, r7, r0)
            L35:
                if (r0 >= r8) goto L3a
                r6 = 1
                r5.e = r6
            L3a:
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: com.uc.crashsdk.e.b.a(byte[], int, int):int");
        }

        private void b(String str) {
            if (com.uc.crashsdk.b.d) {
                JNIBridge.nativeClientWriteData(this.a, str);
            }
        }

        @Override // java.io.OutputStream
        public final void write(int i) {
            if (e.g && e.A()) {
                com.uc.crashsdk.a.a.c("DEBUG", String.format(Locale.US, "%c", Integer.valueOf(i)));
            }
            if (this.a != 0) {
                b(String.format(Locale.US, "%c", Integer.valueOf(i)));
            } else {
                this.b.write(i);
            }
            this.c++;
            this.d++;
        }

        @Override // java.io.OutputStream
        public final void write(byte[] bArr, int i, int i2) {
            if (e.g && e.A()) {
                byte[] bArr2 = new byte[i2];
                System.arraycopy(bArr, i, bArr2, 0, i2);
                if (i2 != 1 || bArr2[0] != 10) {
                    try {
                        com.uc.crashsdk.a.a.c("DEBUG", new String(bArr2));
                    } catch (Throwable unused) {
                    }
                }
            }
            a(bArr, i, i2);
        }

        final void a() {
            try {
                if (this.d - this.c > 0) {
                    a("\n");
                    a("--- --- --- --- --- --- --- --- --- --- --- --- --- --- --- ---\n");
                }
                a(String.format(Locale.US, "Full: %d bytes, write: %d bytes, limit: %d bytes, reject: %d bytes.\n", Integer.valueOf(this.d), Integer.valueOf(this.c), Integer.valueOf(h.y()), Integer.valueOf(this.d - this.c)));
            } catch (Throwable th) {
                com.uc.crashsdk.a.g.a(th);
            }
        }

        @Override // java.io.OutputStream
        public final void write(byte[] bArr) {
            if (e.g && e.A() && (bArr.length != 1 || bArr[0] != 10)) {
                try {
                    com.uc.crashsdk.a.a.c("DEBUG", new String(bArr));
                } catch (Throwable unused) {
                }
            }
            a(bArr, 0, bArr.length);
        }

        final void a(String str) {
            if (e.g && e.A()) {
                com.uc.crashsdk.a.a.c("DEBUG", str);
            }
            if (this.a != 0) {
                b(str);
            } else {
                this.b.write(str.getBytes("UTF-8"));
            }
        }
    }

    public static void j() {
        if (ad) {
            return;
        }
        com.uc.crashsdk.a.f.a(1, new com.uc.crashsdk.a.e(411), 1000L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: ProGuard */
    /* loaded from: classes.dex */
    public static class d {
        long a;
        long b;
        int c;
        int d;
        boolean e;
        boolean f;
        boolean g;

        private d() {
            this.a = 0L;
            this.b = 0L;
            this.c = 0;
            this.d = 0;
            this.e = false;
            this.f = false;
            this.g = false;
        }

        /* synthetic */ d(byte b) {
            this();
        }
    }

    public static void m() {
        if (com.uc.crashsdk.a.g.a(B)) {
            String str = null;
            try {
                File file = new File(h.S() + "unique");
                if (file.exists()) {
                    String a2 = com.uc.crashsdk.a.g.a(file, 48);
                    try {
                        if (a2 != null) {
                            try {
                                if (a2.length() == 36) {
                                    str = a2.replaceAll("[^0-9a-zA-Z-]", "-");
                                }
                            } catch (Exception e) {
                                com.uc.crashsdk.a.g.a(e);
                            }
                        }
                        str = a2;
                    } catch (Throwable th) {
                        th = th;
                        str = a2;
                        com.uc.crashsdk.a.g.a(th);
                        B = str;
                    }
                }
                if (com.uc.crashsdk.a.g.a(str)) {
                    str = UUID.randomUUID().toString();
                    if (!com.uc.crashsdk.a.g.a(str)) {
                        com.uc.crashsdk.a.g.a(file, str.getBytes());
                    }
                }
            } catch (Throwable th2) {
                th = th2;
            }
            B = str;
        }
    }

    public static void p() {
        Thread.setDefaultUncaughtExceptionHandler(R);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String a(String str) {
        if (com.uc.crashsdk.a.g.a(str)) {
            return "";
        }
        if (str.length() > 128) {
            str = str.substring(0, 128);
        }
        String i2 = i(str);
        if (i2.startsWith(".")) {
            return i2;
        }
        return "." + i2;
    }

    public static Throwable q() {
        return S;
    }

    private static void b(OutputStream outputStream, String str, String str2) {
        String str3;
        try {
            outputStream.write("*** *** *** *** *** *** *** *** *** *** *** *** *** *** *** ***\n".getBytes("UTF-8"));
        } catch (Throwable th) {
            a(th, outputStream);
        }
        try {
            outputStream.write(String.format(Locale.US, "Basic Information: 'pid: %d/tid: %d/time: %s'\n", Integer.valueOf(Process.myPid()), Integer.valueOf(Process.myTid()), k()).getBytes("UTF-8"));
            Locale locale = Locale.US;
            Object[] objArr = new Object[3];
            objArr[0] = d();
            if (com.uc.crashsdk.a.g.a(l)) {
                J();
            }
            objArr[1] = l;
            objArr[2] = e();
            outputStream.write(String.format(locale, "Cpu Information: 'abi: %s/processor: %s/hardware: %s'\n", objArr).getBytes("UTF-8"));
        } catch (Throwable th2) {
            a(th2, outputStream);
        }
        try {
            outputStream.write(String.format(Locale.US, "Mobile Information: 'model: %s/version: %s/sdk: %d'\n", Build.MODEL, Build.VERSION.RELEASE, Integer.valueOf(Build.VERSION.SDK_INT)).getBytes("UTF-8"));
            outputStream.write(("Build fingerprint: '" + Build.FINGERPRINT + "'\n").getBytes("UTF-8"));
            outputStream.write(String.format(Locale.US, "Runtime Information: 'start: %s/maxheap: %s'\n", a(new Date(b)), Long.valueOf(Runtime.getRuntime().maxMemory())).getBytes("UTF-8"));
        } catch (Throwable th3) {
            a(th3, outputStream);
        }
        try {
            outputStream.write(String.format(Locale.US, "Application Information: 'version: %s/subversion: %s/buildseq: %s'\n", h.P(), h.Q(), h.R()).getBytes("UTF-8"));
            outputStream.write(String.format(Locale.US, "CrashSDK Information: 'version: %s/nativeseq: %s/javaseq: %s/target: %s'\n", "2.3.2.2", com.uc.crashsdk.b.d ? JNIBridge.nativeGetNativeBuildseq() : "0", "190513114645", "release").getBytes("UTF-8"));
            if (str == null) {
                str = "";
            }
            outputStream.write(("Report Name: " + str.substring(str.lastIndexOf(47) + 1) + "\n").getBytes("UTF-8"));
        } catch (Throwable th4) {
            a(th4, outputStream);
        }
        try {
            if (ad) {
                str3 = s("UUID");
            } else {
                str3 = B;
            }
            outputStream.write(String.format("UUID: %s\n", str3).getBytes("UTF-8"));
            outputStream.write(("Log Type: " + str2 + "\n").getBytes("UTF-8"));
        } catch (Throwable th5) {
            a(th5, outputStream);
        }
        a(outputStream);
        try {
            com.uc.crashsdk.a.a(outputStream, "UTF-8");
            if (ad) {
                g = false;
                outputStream.write(s("HEADER").getBytes("UTF-8"));
                g = true;
            }
        } catch (Throwable th6) {
            a(th6, outputStream);
        }
        a(outputStream);
    }

    public static String n() {
        return B;
    }

    public static void r() {
        long p2 = h.p();
        if (p2 < 0) {
            return;
        }
        boolean z2 = com.uc.crashsdk.b.B() == 5;
        com.uc.crashsdk.a.f.a(0, new com.uc.crashsdk.a.e(StatCommonBean.EVENT_RECOMMEND_ID));
        if (z2) {
            V = new com.uc.crashsdk.a.e(402);
            com.uc.crashsdk.a.f.a(0, V, p2);
        }
    }

    public static void a(int i2, Object[] objArr) {
        int i3;
        switch (i2) {
            case StatCommonBean.EVENT_RECOMMEND_ID /* 401 */:
                JNIBridge.nativePrepareUnexpInfos(com.uc.crashsdk.b.B() == 5);
                com.uc.crashsdk.a.c = true;
                com.uc.crashsdk.a.a(false);
                L = true;
                M();
                s();
                return;
            case 402:
                synchronized (W) {
                    if (V == null) {
                        return;
                    }
                    U = true;
                    if (com.uc.crashsdk.b.o()) {
                        return;
                    }
                    if (!com.uc.crashsdk.a.d.d()) {
                        com.uc.crashsdk.a.a.b("DEBUG", com.uc.crashsdk.a.d.b());
                        return;
                    } else if (!d(LogType.UNEXP_TYPE)) {
                        com.uc.crashsdk.a.a.c("DEBUG", "unexp sample miss");
                        return;
                    } else {
                        int nativeGenerateUnexpLog = JNIBridge.nativeGenerateUnexpLog(h.p(), h.q());
                        if (nativeGenerateUnexpLog != 0) {
                            f.a(11);
                            if ((nativeGenerateUnexpLog & LogType.UNEXP_ANR) != 0) {
                                i3 = 10;
                            } else if ((nativeGenerateUnexpLog & LogType.UNEXP_LOW_MEMORY) != 0) {
                                i3 = 29;
                            } else if ((nativeGenerateUnexpLog & LogType.UNEXP_KILL_PROCESS) != 0) {
                                i3 = 30;
                            } else if ((nativeGenerateUnexpLog & LogType.UNEXP_EXIT) != 0) {
                                i3 = 31;
                            } else {
                                if ((nativeGenerateUnexpLog & LogType.UNEXP_RESTART) != 0) {
                                    i3 = 32;
                                }
                                a(true);
                            }
                            f.a(i3);
                            a(true);
                        }
                        synchronized (W) {
                            V = null;
                        }
                        return;
                    }
                }
            case 403:
                N();
                return;
            case 404:
                if (!a && objArr == null) {
                    throw new AssertionError();
                }
                String str = (String) objArr[0];
                File file = new File(com.uc.crashsdk.b.e());
                if (!i) {
                    i = true;
                    JNIBridge.nativeSyncInfo("mLogTypeSuffix", file.exists() ? a(com.uc.crashsdk.a.g.a(file, 128)) : null, 1L, 0L);
                }
                if (com.uc.crashsdk.a.g.a(str)) {
                    com.uc.crashsdk.a.g.a(file);
                    return;
                } else {
                    com.uc.crashsdk.a.g.a(file, str.getBytes());
                    return;
                }
            case 405:
                L = false;
                StringBuilder L2 = L();
                String f2 = com.uc.crashsdk.b.f();
                if (L2 != null) {
                    com.uc.crashsdk.a.g.a(new File(f2), L2.toString());
                    return;
                }
                return;
            case 406:
                if (!a && objArr == null) {
                    throw new AssertionError();
                }
                b((String) objArr[0], ((Boolean) objArr[1]).booleanValue(), ((Boolean) objArr[2]).booleanValue());
                return;
            case 407:
                try {
                    com.uc.crashsdk.a.c();
                    return;
                } catch (Throwable th) {
                    com.uc.crashsdk.a.g.a(th);
                    return;
                }
            case 408:
                synchronized (Y) {
                    if (!Z && h.N() && com.uc.crashsdk.b.w()) {
                        Z = true;
                        com.uc.crashsdk.b.p();
                        com.uc.crashsdk.a.h.b();
                        f.d();
                        if (com.uc.crashsdk.b.A()) {
                            com.uc.crashsdk.a.f.a(1, new com.uc.crashsdk.a.e(409), 7000L);
                            return;
                        }
                        return;
                    }
                    return;
                }
            case 409:
                b(false, false);
                return;
            case 410:
                a(false, true);
                return;
            case 411:
                if (com.uc.crashsdk.b.d) {
                    JNIBridge.nativeSyncStatus("jnisampl", null, d(LogType.NATIVE_TYPE) ? 1 : 0);
                    return;
                }
                return;
            case 412:
                if (!P && com.uc.crashsdk.b.y() && h.J()) {
                    a(com.uc.crashsdk.a.g.a());
                    return;
                } else if (P) {
                    if (com.uc.crashsdk.b.y() && h.J()) {
                        return;
                    }
                    try {
                        com.uc.crashsdk.a.g.a().unregisterReceiver(O);
                        P = false;
                        return;
                    } catch (Throwable th2) {
                        com.uc.crashsdk.a.g.a(th2);
                        return;
                    }
                } else {
                    return;
                }
            case 413:
                JNIBridge.nativeInstallBreakpad(com.uc.crashsdk.b.D() ? 1 : 0, 2);
                return;
            default:
                if (!a) {
                    throw new AssertionError();
                }
                return;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:35:0x004a A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static void d(java.io.OutputStream r9) {
        /*
            java.lang.String r0 = "UTF-8"
            r1 = 0
            r2 = 0
            int r3 = com.uc.crashsdk.h.G()     // Catch: java.lang.Throwable -> L42
            java.io.File r4 = new java.io.File     // Catch: java.lang.Throwable -> L40
            java.lang.String r5 = "/proc/self/fd"
            r4.<init>(r5)     // Catch: java.lang.Throwable -> L40
            java.io.File[] r2 = r4.listFiles()     // Catch: java.lang.Throwable -> L40
            if (r2 == 0) goto L36
            java.util.Locale r4 = java.util.Locale.US     // Catch: java.lang.Throwable -> L40
            java.lang.String r5 = "opened file count: %d, write limit: %d.\n"
            r6 = 2
            java.lang.Object[] r6 = new java.lang.Object[r6]     // Catch: java.lang.Throwable -> L40
            int r7 = r2.length     // Catch: java.lang.Throwable -> L40
            java.lang.Integer r7 = java.lang.Integer.valueOf(r7)     // Catch: java.lang.Throwable -> L40
            r6[r1] = r7     // Catch: java.lang.Throwable -> L40
            java.lang.Integer r7 = java.lang.Integer.valueOf(r3)     // Catch: java.lang.Throwable -> L40
            r8 = 1
            r6[r8] = r7     // Catch: java.lang.Throwable -> L40
            java.lang.String r4 = java.lang.String.format(r4, r5, r6)     // Catch: java.lang.Throwable -> L40
            byte[] r4 = r4.getBytes(r0)     // Catch: java.lang.Throwable -> L40
            r9.write(r4)     // Catch: java.lang.Throwable -> L40
            goto L48
        L36:
            java.lang.String r4 = "[DEBUG] listFiles failed!\n"
            byte[] r4 = r4.getBytes(r0)     // Catch: java.lang.Throwable -> L40
            r9.write(r4)     // Catch: java.lang.Throwable -> L40
            goto L48
        L40:
            r4 = move-exception
            goto L45
        L42:
            r4 = move-exception
            r3 = 900(0x384, float:1.261E-42)
        L45:
            a(r4, r9)
        L48:
            if (r2 == 0) goto L8f
            int r4 = r2.length     // Catch: java.lang.Throwable -> L8b
            if (r4 < r3) goto L8f
            java.lang.String r3 = "opened files:\n"
            byte[] r3 = r3.getBytes(r0)     // Catch: java.lang.Throwable -> L8b
            r9.write(r3)     // Catch: java.lang.Throwable -> L8b
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L8b
            r3.<init>()     // Catch: java.lang.Throwable -> L8b
            int r4 = r2.length     // Catch: java.lang.Throwable -> L7b
        L5c:
            if (r1 >= r4) goto L7f
            r5 = r2[r1]     // Catch: java.lang.Throwable -> L7b
            java.lang.String r6 = r5.getName()     // Catch: java.lang.Throwable -> L7b
            r3.append(r6)     // Catch: java.lang.Throwable -> L7b
            java.lang.String r6 = " -> "
            r3.append(r6)     // Catch: java.lang.Throwable -> L7b
            java.lang.String r5 = r5.getCanonicalPath()     // Catch: java.lang.Throwable -> L7b
            r3.append(r5)     // Catch: java.lang.Throwable -> L7b
            java.lang.String r5 = "\n"
            r3.append(r5)     // Catch: java.lang.Throwable -> L7b
            int r1 = r1 + 1
            goto L5c
        L7b:
            r1 = move-exception
            a(r1, r9)     // Catch: java.lang.Throwable -> L8b
        L7f:
            java.lang.String r1 = r3.toString()     // Catch: java.lang.Throwable -> L8b
            byte[] r0 = r1.getBytes(r0)     // Catch: java.lang.Throwable -> L8b
            r9.write(r0)     // Catch: java.lang.Throwable -> L8b
            goto L8f
        L8b:
            r0 = move-exception
            a(r0, r9)
        L8f:
            a(r9)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.uc.crashsdk.e.d(java.io.OutputStream):void");
    }

    private static void f(OutputStream outputStream) {
        String l2;
        try {
            outputStream.write("Recent Status:\n".getBytes("UTF-8"));
        } catch (Throwable th) {
            a(th, outputStream);
        }
        try {
            if (ad) {
                l2 = s("LASTVER");
            } else {
                l2 = com.uc.crashsdk.a.l();
            }
            outputStream.write(String.format(Locale.US, "last version: '%s'\n", l2).getBytes("UTF-8"));
        } catch (Throwable th2) {
            a(th2, outputStream);
        }
        try {
            synchronized (r) {
                if (t != null) {
                    outputStream.write(String.format(Locale.US, "generating log: %s\n", t).getBytes("UTF-8"));
                }
                if (s > 0 || r.size() > 0) {
                    outputStream.write(String.format(Locale.US, "generated %d logs, recent are:\n", Integer.valueOf(s)).getBytes("UTF-8"));
                    Iterator<String> it = r.iterator();
                    while (it.hasNext()) {
                        outputStream.write(String.format(Locale.US, "* %s\n", it.next()).getBytes("UTF-8"));
                    }
                }
            }
            outputStream.write(String.format(Locale.US, "dumping all threads: %s\n", Boolean.valueOf(u)).getBytes("UTF-8"));
            if (v != null) {
                outputStream.write(String.format(Locale.US, "dumping threads: %s\n", v).getBytes("UTF-8"));
            }
        } catch (Throwable th3) {
            a(th3, outputStream);
        }
        a(outputStream);
    }

    public static void c(String str) {
        synchronized (z) {
            String k2 = com.uc.crashsdk.b.k();
            com.uc.crashsdk.a.b.a(k2, str + "\n");
        }
    }

    public static boolean e(String str) {
        File file = new File(str);
        boolean z2 = false;
        try {
            if (file.exists()) {
                System.load(file.getAbsolutePath());
                z2 = true;
            }
        } catch (Throwable th) {
            com.uc.crashsdk.a.g.a(th);
        }
        if (z2) {
            return z2;
        }
        try {
            if (f(file.getName())) {
                return true;
            }
            return z2;
        } catch (Throwable th2) {
            com.uc.crashsdk.a.g.a(th2);
            return z2;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void c(boolean z2) {
        boolean z3 = true;
        if (!P ? !z2 || !h.J() : z2 && h.J()) {
            z3 = false;
        }
        if (z3) {
            if (com.uc.crashsdk.a.f.b(Q)) {
                com.uc.crashsdk.a.f.a(Q);
            }
            com.uc.crashsdk.a.f.a(0, Q, 3000L);
        }
    }

    public static int e(boolean z2) {
        int b2;
        if (z2) {
            b2 = f.b(com.uc.crashsdk.b.c()) ? 1 : 0;
        } else {
            b2 = f.b();
        }
        int b3 = f.b(z2);
        return b3 > b2 ? b3 : b2;
    }

    public static void o() {
        R = Thread.getDefaultUncaughtExceptionHandler();
        Thread.setDefaultUncaughtExceptionHandler(new e());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(boolean z2) {
        File[] listFiles;
        try {
            if (com.uc.crashsdk.b.v() && (listFiles = new File(h.T()).listFiles()) != null) {
                int m2 = h.m();
                int n2 = h.n();
                if (listFiles.length < Math.min(m2, n2)) {
                    return;
                }
                int i2 = 0;
                int i3 = 0;
                for (File file : listFiles) {
                    if (b(file)) {
                        i2++;
                    } else {
                        i3++;
                    }
                }
                int i4 = (!z2 || i2 < m2) ? 0 : (i2 - m2) + 1;
                int i5 = (z2 || i3 < n2) ? 0 : (i3 - n2) + 1;
                if (i4 == 0 && i5 == 0) {
                    return;
                }
                Arrays.sort(listFiles, new c((byte) 0));
                int i6 = i5;
                int i7 = i4;
                for (File file2 : listFiles) {
                    boolean b2 = b(file2);
                    if (b2 && i7 > 0) {
                        com.uc.crashsdk.a.a.b("Delete oldest crash log: " + file2.getPath());
                        file2.delete();
                        i7 += -1;
                    } else if (!b2 && i6 > 0) {
                        com.uc.crashsdk.a.a.b("Delete oldest custom log: " + file2.getPath());
                        file2.delete();
                        i6 += -1;
                    }
                    if (i7 == 0 && i6 == 0) {
                        break;
                    }
                }
                f.a(16, i4 + i5);
                if (i4 > 0) {
                    f.a(22, i4);
                }
                if (i5 > 0) {
                    f.a(23, i5);
                }
            }
        } catch (Throwable th) {
            com.uc.crashsdk.a.g.a(th);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean d(String str) {
        if (ad) {
            return true;
        }
        try {
            return p(str);
        } catch (Throwable th) {
            com.uc.crashsdk.a.g.a(th);
            return true;
        }
    }

    public static boolean f(String str) {
        try {
            if (com.uc.crashsdk.a.g.b(str) && str.startsWith("lib") && str.endsWith(".so")) {
                System.loadLibrary(str.substring(3, str.length() - 3));
                return true;
            }
            return false;
        } catch (Throwable th) {
            com.uc.crashsdk.a.g.a(th);
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x0063, code lost:
        r3.write(r4.getBytes("UTF-8"));
        r3.write("\n".getBytes("UTF-8"));
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static java.lang.String a(java.lang.String r8, java.lang.String r9) {
        /*
            int r0 = android.os.Build.VERSION.SDK_INT     // Catch: java.lang.Throwable -> L79
            r1 = 26
            java.lang.String r2 = "ps"
            if (r0 < r1) goto Lf
            java.lang.String r0 = "-ef"
            java.lang.String[] r0 = new java.lang.String[]{r2, r0}     // Catch: java.lang.Throwable -> L79
            goto L13
        Lf:
            java.lang.String[] r0 = new java.lang.String[]{r2}     // Catch: java.lang.Throwable -> L79
        L13:
            java.lang.Runtime r1 = java.lang.Runtime.getRuntime()     // Catch: java.lang.Throwable -> L79
            java.lang.Process r0 = r1.exec(r0)     // Catch: java.lang.Throwable -> L79
            java.io.BufferedReader r1 = new java.io.BufferedReader     // Catch: java.lang.Throwable -> L79
            java.io.InputStreamReader r2 = new java.io.InputStreamReader     // Catch: java.lang.Throwable -> L79
            java.io.InputStream r0 = r0.getInputStream()     // Catch: java.lang.Throwable -> L79
            r2.<init>(r0)     // Catch: java.lang.Throwable -> L79
            r1.<init>(r2)     // Catch: java.lang.Throwable -> L79
            boolean r0 = com.uc.crashsdk.a.g.b(r8)     // Catch: java.lang.Throwable -> L79
            boolean r2 = com.uc.crashsdk.a.g.b(r9)     // Catch: java.lang.Throwable -> L79
            java.io.ByteArrayOutputStream r3 = new java.io.ByteArrayOutputStream     // Catch: java.lang.Throwable -> L79
            r3.<init>()     // Catch: java.lang.Throwable -> L79
        L36:
            java.lang.String r4 = r1.readLine()     // Catch: java.lang.Throwable -> L79
            java.lang.String r5 = "UTF-8"
            if (r4 == 0) goto L74
            r6 = 1
            if (r0 == 0) goto L47
            boolean r7 = r4.contains(r8)     // Catch: java.lang.Throwable -> L79
            if (r7 != 0) goto L61
        L47:
            if (r2 == 0) goto L50
            boolean r7 = r4.contains(r9)     // Catch: java.lang.Throwable -> L79
            if (r7 == 0) goto L50
            goto L61
        L50:
            r7 = 47
            int r7 = r4.indexOf(r7)     // Catch: java.lang.Throwable -> L79
            if (r7 >= 0) goto L60
            r7 = 46
            int r7 = r4.indexOf(r7)     // Catch: java.lang.Throwable -> L79
            if (r7 > 0) goto L61
        L60:
            r6 = 0
        L61:
            if (r6 == 0) goto L36
            byte[] r4 = r4.getBytes(r5)     // Catch: java.lang.Throwable -> L79
            r3.write(r4)     // Catch: java.lang.Throwable -> L79
            java.lang.String r4 = "\n"
            byte[] r4 = r4.getBytes(r5)     // Catch: java.lang.Throwable -> L79
            r3.write(r4)     // Catch: java.lang.Throwable -> L79
            goto L36
        L74:
            java.lang.String r8 = r3.toString(r5)     // Catch: java.lang.Throwable -> L79
            return r8
        L79:
            r8 = move-exception
            com.uc.crashsdk.a.g.a(r8)
            java.lang.String r8 = "exception exists."
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.uc.crashsdk.e.a(java.lang.String, java.lang.String):java.lang.String");
    }

    private static void b(OutputStream outputStream) {
        BufferedReader bufferedReader = null;
        try {
            outputStream.write("logcat: \n".getBytes("UTF-8"));
        } finally {
            try {
                com.uc.crashsdk.a.g.a(bufferedReader);
                a(outputStream);
            } finally {
            }
        }
        if (h.o() <= 0) {
            outputStream.write("[DEBUG] custom java logcat lines count is 0!\n".getBytes("UTF-8"));
            a(outputStream);
            return;
        }
        int o2 = h.o();
        bufferedReader = a(new InputStreamReader(Runtime.getRuntime().exec(new String[]{"logcat", "-d", "-b", "events", "-b", "main", "-v", "threadtime", "-t", String.valueOf(o2)}).getInputStream()));
        if (bufferedReader == null) {
            outputStream.write("[DEBUG] alloc buffer failed!\n".getBytes("UTF-8"));
            a(outputStream);
            return;
        }
        g = false;
        int i2 = 0;
        int i3 = 0;
        while (true) {
            String readLine = bufferedReader.readLine();
            if (readLine == null) {
                break;
            }
            i2++;
            if (i3 < o2 && !readLine.contains(" I auditd ") && !readLine.contains(" I liblog ")) {
                outputStream.write(readLine.getBytes("UTF-8"));
                outputStream.write("\n".getBytes("UTF-8"));
                i3++;
            }
        }
        outputStream.write(String.format(Locale.US, "[DEBUG] Read %d lines, wrote %d lines.\n", Integer.valueOf(i2), Integer.valueOf(i3)).getBytes("UTF-8"));
        g = true;
        com.uc.crashsdk.a.g.a(bufferedReader);
        a(outputStream);
    }

    private static BufferedReader a(InputStreamReader inputStreamReader) {
        BufferedReader bufferedReader = null;
        int i2 = OSSConstants.DEFAULT_BUFFER_SIZE;
        while (bufferedReader == null && i2 > 0) {
            try {
                bufferedReader = new BufferedReader(inputStreamReader, i2);
            } catch (Throwable unused) {
                i2 /= 2;
                if (i2 < 512) {
                    break;
                }
            }
        }
        return bufferedReader;
    }

    private static void a(OutputStream outputStream) {
        try {
            outputStream.write("--- --- --- --- --- --- --- --- --- --- --- --- --- --- --- ---\n".getBytes("UTF-8"));
        } catch (Throwable th) {
            a(th, outputStream);
        }
    }

    private static String a(File file) {
        String str;
        try {
            str = file.getCanonicalPath();
        } catch (Throwable unused) {
            str = null;
        }
        return com.uc.crashsdk.a.g.a(str) ? file.getPath() : str;
    }

    private static void a(OutputStream outputStream, String str, Set<String> set) {
        if (com.uc.crashsdk.a.g.a(str) || set.contains(str) || str.equals("/storage/emulated")) {
            return;
        }
        set.add(str);
        try {
            StatFs statFs = new StatFs(str);
            long a2 = a(statFs, "getBlockCountLong", "getBlockCount");
            long a3 = a(statFs, "getBlockSizeLong", "getBlockSize");
            if ((a2 / 1024) * a3 < 10240) {
                return;
            }
            long a4 = a(statFs, "getAvailableBlocksLong", "getAvailableBlocks");
            long a5 = a(statFs, "getFreeBlocksLong", "getFreeBlocks");
            try {
                outputStream.write(String.format(Locale.US, "%s:\n", str).getBytes("UTF-8"));
                double d2 = a3;
                outputStream.write(String.format(Locale.US, "  total:      %d kB\n", Long.valueOf((long) (((a2 * 1.0d) * d2) / 1024.0d))).getBytes("UTF-8"));
                outputStream.write(String.format(Locale.US, "  available:  %d kB\n", Long.valueOf((long) (((a4 * 1.0d) * d2) / 1024.0d))).getBytes("UTF-8"));
                outputStream.write(String.format(Locale.US, "  free:       %d kB\n", Long.valueOf((long) (((a5 * 1.0d) * d2) / 1024.0d))).getBytes("UTF-8"));
                outputStream.write(String.format(Locale.US, "  block size: %d B\n\n", Long.valueOf(a3)).getBytes("UTF-8"));
            } catch (Throwable th) {
                a(th, outputStream);
            }
        } catch (Throwable unused) {
        }
    }

    private static void b(b bVar) {
        g = false;
        try {
            bVar.write((s("LOG_END") + "\n").getBytes("UTF-8"));
        } catch (Throwable th) {
            com.uc.crashsdk.a.g.a(th);
        }
        g = true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int b(OutputStream outputStream, String str, int i2) {
        int i3;
        DataInputStream dataInputStream;
        int i4;
        DataInputStream dataInputStream2 = null;
        try {
            File file = new File(str);
            if (file.exists()) {
                byte[] H2 = H();
                if (H2 == null) {
                    outputStream.write("(alloc buffer failed!)\n".getBytes("UTF-8"));
                    return 0;
                }
                dataInputStream = new DataInputStream(new FileInputStream(file));
                i4 = 0;
                i3 = 0;
                boolean z2 = false;
                while (true) {
                    try {
                        int read = dataInputStream.read(H2);
                        if (read == -1) {
                            break;
                        }
                        i4 += read;
                        int i5 = i2 - i3;
                        if (read <= i5 + 32) {
                            i5 = read;
                        }
                        if (i5 > 0 && !z2) {
                            outputStream.write(H2, 0, i5);
                            i3 += i5;
                        }
                        if (!z2) {
                            z2 = i5 < read || i3 >= i2;
                        }
                    } catch (Throwable th) {
                        th = th;
                        dataInputStream2 = dataInputStream;
                        try {
                            a(th, outputStream);
                            a(outputStream);
                            return i3;
                        } finally {
                            com.uc.crashsdk.a.g.a(dataInputStream2);
                        }
                    }
                }
            } else {
                outputStream.write(("file: '" + str + "' not exists!\n").getBytes("UTF-8"));
                dataInputStream = null;
                i4 = 0;
                i3 = 0;
            }
            if (i3 > 0) {
                outputStream.write("\n".getBytes("UTF-8"));
            }
            if (i3 < i4) {
                outputStream.write(String.format(Locale.US, "(truncated %d bytes)\n", Integer.valueOf(i4 - i3)).getBytes("UTF-8"));
            }
            com.uc.crashsdk.a.g.a(dataInputStream);
        } catch (Throwable th2) {
            th = th2;
            i3 = 0;
        }
        a(outputStream);
        return i3;
    }

    private static long a(StatFs statFs, String str, String str2) {
        try {
            if (Build.VERSION.SDK_INT >= 18) {
                Method declaredMethod = StatFs.class.getDeclaredMethod(str, new Class[0]);
                declaredMethod.setAccessible(true);
                Object invoke = declaredMethod.invoke(statFs, new Object[0]);
                if (invoke != null && (invoke instanceof Long)) {
                    return ((Long) invoke).longValue();
                }
            }
        } catch (Throwable unused) {
        }
        try {
            Method declaredMethod2 = StatFs.class.getDeclaredMethod(str2, new Class[0]);
            declaredMethod2.setAccessible(true);
            Object invoke2 = declaredMethod2.invoke(statFs, new Object[0]);
            if (invoke2 == null || !(invoke2 instanceof Integer)) {
                return 0L;
            }
            return ((Integer) invoke2).intValue();
        } catch (Throwable th) {
            com.uc.crashsdk.a.g.a(th);
            return 0L;
        }
    }

    private static void a(b bVar) {
        try {
            bVar.a(String.format(Locale.US, "log end: %s\n", k()));
        } catch (Throwable th) {
            a(th, bVar);
        }
    }

    private static void b(String str, boolean z2, boolean z3) {
        com.uc.crashsdk.a.a.b("crashsdk uploading logs");
        synchronized (n) {
            try {
                if (com.uc.crashsdk.a.g.b(str)) {
                    a(str, z2, false);
                } else {
                    com.uc.crashsdk.a.a.b("upload url is empty!");
                }
                if (z3) {
                    n.notify();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int a(OutputStream outputStream, String str, int i2) {
        Throwable th;
        int i3;
        if (str == null) {
            a(outputStream);
            return 0;
        }
        try {
            String a2 = com.uc.crashsdk.a.b.a(str);
            if (a2 == null) {
                a2 = "file: '" + str + "' not found or decode failed!";
            }
            i3 = a2.length();
            if (i3 > i2 + 32) {
                i3 = i2;
            }
            if (i3 > 0) {
                try {
                    outputStream.write(a2.getBytes("UTF-8"), 0, i3);
                    outputStream.write("\n".getBytes("UTF-8"));
                } catch (Throwable th2) {
                    th = th2;
                    a(th, outputStream);
                    a(outputStream);
                    return i3;
                }
            }
            if (i3 < a2.length()) {
                outputStream.write(String.format(Locale.US, "(truncated %d bytes)\n", Integer.valueOf(a2.length() - i3)).getBytes("UTF-8"));
            }
        } catch (Throwable th3) {
            th = th3;
            i3 = 0;
        }
        a(outputStream);
        return i3;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void b(boolean z2) {
        try {
            if (h.t() && com.uc.crashsdk.b.A() && !d) {
                if (z2) {
                    String i2 = i();
                    if (com.uc.crashsdk.a.g.a(i2)) {
                        return;
                    }
                    StrictMode.setThreadPolicy(new StrictMode.ThreadPolicy.Builder(StrictMode.getThreadPolicy()).permitNetwork().build());
                    b(i2, false, false);
                    return;
                }
                a(true, false);
            }
        } catch (Throwable th) {
            com.uc.crashsdk.a.g.a(th);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String a(int i2) {
        try {
            String a2 = com.uc.crashsdk.a.g.a(new File(String.format(Locale.US, "/proc/%d/cmdline", Integer.valueOf(i2))), 128);
            return com.uc.crashsdk.a.g.b(a2) ? l(a2) : BuildInfoUtils.UNKNOWN;
        } catch (Throwable th) {
            com.uc.crashsdk.a.g.a(th);
            return BuildInfoUtils.UNKNOWN;
        }
    }

    private static boolean b(File file) {
        int indexOf;
        String name = file.getName();
        int lastIndexOf = name.lastIndexOf(95);
        if (lastIndexOf > 0 && (indexOf = name.indexOf(46, lastIndexOf)) > 0) {
            String substring = name.substring(lastIndexOf + 1, indexOf);
            return LogType.JAVA_TYPE.equals(substring) || "ucebujava".equals(substring) || LogType.NATIVE_TYPE.equals(substring) || "ucebujni".equals(substring) || LogType.UNEXP_TYPE.equals(substring);
        }
        return false;
    }

    private static boolean a(String str, String str2, int i2) {
        if (com.uc.crashsdk.b.d) {
            return JNIBridge.nativeSyncStatus(str, str2, i2);
        }
        return false;
    }

    /* JADX WARN: Code restructure failed: missing block: B:187:0x034e, code lost:
        if (r13 == 0) goto L76;
     */
    /* JADX WARN: Code restructure failed: missing block: B:195:0x035c, code lost:
        if (r19 == 0) goto L76;
     */
    /* JADX WARN: Code restructure failed: missing block: B:196:0x035e, code lost:
        b(r14);
     */
    /* JADX WARN: Code restructure failed: missing block: B:197:0x0361, code lost:
        com.uc.crashsdk.a.g.a(r14);
     */
    /* JADX WARN: Code restructure failed: missing block: B:198:0x0366, code lost:
        if (com.uc.crashsdk.e.ad != false) goto L79;
     */
    /* JADX WARN: Code restructure failed: missing block: B:199:0x0368, code lost:
        r(r18);
     */
    /* JADX WARN: Code restructure failed: missing block: B:201:0x036d, code lost:
        if (com.uc.crashsdk.e.ad != false) goto L87;
     */
    /* JADX WARN: Code restructure failed: missing block: B:202:0x036f, code lost:
        r0 = m(r18);
     */
    /* JADX WARN: Code restructure failed: missing block: B:203:0x0374, code lost:
        r0 = r18;
     */
    /* JADX WARN: Code restructure failed: missing block: B:204:0x0375, code lost:
        b(r0, com.uc.crashsdk.export.LogType.JAVA_TYPE);
     */
    /* JADX WARN: Code restructure failed: missing block: B:206:0x037b, code lost:
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:207:0x037c, code lost:
        com.uc.crashsdk.a.g.a(r0);
     */
    /* JADX WARN: Finally extract failed */
    /* JADX WARN: Removed duplicated region for block: B:157:0x02fd A[Catch: all -> 0x0351, TRY_LEAVE, TryCatch #10 {all -> 0x0351, blocks: (B:18:0x003d, B:52:0x0105, B:82:0x01a4, B:88:0x01b3, B:90:0x01b7, B:95:0x01cb, B:101:0x01d6, B:120:0x021c, B:125:0x0230, B:149:0x02e7, B:155:0x02f9, B:157:0x02fd, B:162:0x0311, B:173:0x0325, B:175:0x0329, B:180:0x033d, B:181:0x033f, B:130:0x0248, B:78:0x015f, B:64:0x011c, B:29:0x0091, B:36:0x00bd, B:38:0x00c3, B:40:0x00cd, B:30:0x009a, B:32:0x00ab, B:121:0x0222, B:107:0x01e2, B:83:0x01aa, B:44:0x00ea, B:150:0x02f0, B:70:0x0127, B:176:0x032b, B:12:0x002f, B:14:0x0033, B:48:0x00f7, B:91:0x01b9, B:182:0x0345, B:20:0x0046, B:53:0x0108, B:158:0x02ff, B:25:0x0050, B:96:0x01cd, B:58:0x0111, B:163:0x0313, B:111:0x01f0, B:113:0x01f4, B:114:0x0206, B:116:0x020c, B:74:0x013a, B:102:0x01d9, B:168:0x031c), top: B:219:0x002f }] */
    /* JADX WARN: Removed duplicated region for block: B:175:0x0329 A[Catch: all -> 0x0351, TRY_LEAVE, TryCatch #10 {all -> 0x0351, blocks: (B:18:0x003d, B:52:0x0105, B:82:0x01a4, B:88:0x01b3, B:90:0x01b7, B:95:0x01cb, B:101:0x01d6, B:120:0x021c, B:125:0x0230, B:149:0x02e7, B:155:0x02f9, B:157:0x02fd, B:162:0x0311, B:173:0x0325, B:175:0x0329, B:180:0x033d, B:181:0x033f, B:130:0x0248, B:78:0x015f, B:64:0x011c, B:29:0x0091, B:36:0x00bd, B:38:0x00c3, B:40:0x00cd, B:30:0x009a, B:32:0x00ab, B:121:0x0222, B:107:0x01e2, B:83:0x01aa, B:44:0x00ea, B:150:0x02f0, B:70:0x0127, B:176:0x032b, B:12:0x002f, B:14:0x0033, B:48:0x00f7, B:91:0x01b9, B:182:0x0345, B:20:0x0046, B:53:0x0108, B:158:0x02ff, B:25:0x0050, B:96:0x01cd, B:58:0x0111, B:163:0x0313, B:111:0x01f0, B:113:0x01f4, B:114:0x0206, B:116:0x020c, B:74:0x013a, B:102:0x01d9, B:168:0x031c), top: B:219:0x002f }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static java.lang.String a(java.lang.Throwable r17, java.lang.String r18, long r19, boolean r21) {
        /*
            Method dump skipped, instructions count: 911
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.uc.crashsdk.e.a(java.lang.Throwable, java.lang.String, long, boolean):java.lang.String");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void b(String str, String str2, boolean z2) {
        com.uc.crashsdk.a.h.a(str, str2, false, z2);
    }

    private static void b(String str, String str2) {
        try {
            com.uc.crashsdk.d.a(str, g(), str2);
        } catch (Throwable th) {
            com.uc.crashsdk.a.g.a(th);
        }
    }

    public static void b(int i2) {
        com.uc.crashsdk.a.f.a(0, new com.uc.crashsdk.a.e(410), i2 * 1000);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static int b(boolean z2, boolean z3) {
        int i2;
        if (!aa || z3) {
            if (z3) {
                aa = true;
                if (!Z) {
                    f.c();
                }
            }
            if (z2) {
                boolean a2 = f.a(com.uc.crashsdk.b.c());
                com.uc.crashsdk.a.h.c();
                i2 = a2;
            } else {
                int a3 = f.a();
                com.uc.crashsdk.a.h.c();
                i2 = a3;
            }
            return z3 ? f.a(z2) : i2;
        }
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(Throwable th, OutputStream outputStream) {
        if (outputStream != null) {
            try {
                outputStream.write("[DEBUG] CrashHandler occurred new exception:\n".getBytes("UTF-8"));
                th.printStackTrace(new PrintStream(outputStream));
                outputStream.write("\n\n".getBytes("UTF-8"));
            } catch (Throwable th2) {
                com.uc.crashsdk.a.g.a(th2);
            }
        }
        com.uc.crashsdk.a.g.a(th);
    }

    /*  JADX ERROR: JadxRuntimeException in pass: BlockProcessor
        jadx.core.utils.exceptions.JadxRuntimeException: Unreachable block: B:52:0x0179
        	at jadx.core.dex.visitors.blocks.BlockProcessor.checkForUnreachableBlocks(BlockProcessor.java:81)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.processBlocksTree(BlockProcessor.java:47)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.visit(BlockProcessor.java:39)
        */
    static void a(java.lang.String r28, boolean r29, boolean r30) {
        /*
            Method dump skipped, instructions count: 941
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.uc.crashsdk.e.a(java.lang.String, boolean, boolean):void");
    }

    public static boolean a(boolean z2, boolean z3) {
        if (!d) {
            if (com.uc.crashsdk.b.d) {
                JNIBridge.nativeSetCrashLogFilesUploaded();
            }
            d = true;
        }
        try {
            String i2 = i();
            if (com.uc.crashsdk.a.g.a(i2)) {
                com.uc.crashsdk.a.a.b("CrashHandler url is empty!");
                return false;
            }
            synchronized (n) {
                if (com.uc.crashsdk.a.f.a(z2 ? 1 : 0, new com.uc.crashsdk.a.e(406, new Object[]{i2, Boolean.valueOf(z3), Boolean.valueOf(z2)})) && z2) {
                    try {
                        n.wait();
                    } catch (InterruptedException e) {
                        com.uc.crashsdk.a.g.a(e);
                    }
                }
            }
            return true;
        } catch (Throwable th) {
            com.uc.crashsdk.a.g.a(th);
            return false;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v0, types: [java.io.File] */
    /* JADX WARN: Type inference failed for: r1v1 */
    /* JADX WARN: Type inference failed for: r1v2, types: [java.io.Closeable] */
    private static boolean a(String str, com.uc.crashsdk.a.e eVar) {
        boolean z2;
        FileChannel fileChannel;
        Exception e;
        synchronized (o) {
            ?? file = new File(str);
            if (!file.exists()) {
                try {
                    file.createNewFile();
                } catch (Exception e2) {
                    com.uc.crashsdk.a.g.a(e2);
                }
            }
            FileLock fileLock = null;
            z2 = false;
            try {
                try {
                    try {
                        fileChannel = new RandomAccessFile((File) file, "rw").getChannel();
                    } catch (Throwable th) {
                        th = th;
                        com.uc.crashsdk.a.g.a((Closeable) file);
                        throw th;
                    }
                } catch (Exception e3) {
                    try {
                        com.uc.crashsdk.a.g.a(e3);
                        fileChannel = null;
                    } catch (Exception e4) {
                        fileChannel = null;
                        e = e4;
                        com.uc.crashsdk.a.g.a(e);
                        com.uc.crashsdk.a.g.a(fileChannel);
                        return z2;
                    }
                }
                if (fileChannel != null) {
                    try {
                        fileLock = fileChannel.lock();
                    } catch (Exception e5) {
                        try {
                            com.uc.crashsdk.a.g.a(e5);
                        } catch (Exception e6) {
                            e = e6;
                            com.uc.crashsdk.a.g.a(e);
                            com.uc.crashsdk.a.g.a(fileChannel);
                            return z2;
                        }
                    }
                }
                try {
                    z2 = eVar.a();
                    com.uc.crashsdk.a.g.a(fileChannel);
                } finally {
                    if (fileLock != null) {
                        try {
                            fileLock.release();
                        } catch (Exception e7) {
                            com.uc.crashsdk.a.g.a(e7);
                        }
                    }
                }
            } catch (Throwable th2) {
                th = th2;
                file = 0;
            }
        }
        return z2;
    }

    private static boolean a(String str, d dVar) {
        String a2 = com.uc.crashsdk.a.g.a(new File(str), 64);
        if (a2 == null) {
            return false;
        }
        try {
            Matcher matcher = Pattern.compile("(\\d+)\\s+(\\d+)\\s+(\\d+)\\s+(\\d+)").matcher(a2);
            if (matcher.find()) {
                long parseLong = Long.parseLong(matcher.group(1));
                if (System.currentTimeMillis() - parseLong < 86400000) {
                    dVar.b = Long.parseLong(matcher.group(2));
                    dVar.c = Integer.parseInt(matcher.group(3));
                    dVar.d = Integer.parseInt(matcher.group(4));
                    dVar.a = parseLong;
                }
            }
        } catch (Throwable th) {
            com.uc.crashsdk.a.g.a(th);
        }
        return true;
    }

    public static boolean a(StringBuffer stringBuffer, String str, boolean z2, boolean z3, boolean z4, boolean z5, boolean z6, ArrayList<String> arrayList, ArrayList<String> arrayList2, ArrayList<String> arrayList3, String str2) {
        long j2;
        boolean a2;
        long j3;
        if (c) {
            com.uc.crashsdk.a.a.c("Processing java crash, skip generate custom log: " + str);
            return false;
        }
        Object[] objArr = (ad || com.uc.crashsdk.b.D()) ? 1 : null;
        if (objArr == null && !com.uc.crashsdk.a.d.d()) {
            com.uc.crashsdk.a.a.b("DEBUG", com.uc.crashsdk.a.d.b());
            return false;
        } else if (!d(str)) {
            com.uc.crashsdk.a.a.c("DEBUG", "custom log sample miss: " + str);
            return false;
        } else if (com.uc.crashsdk.b.d && JNIBridge.nativeIsCrashing()) {
            com.uc.crashsdk.a.a.c("Processing native crash, skip generate custom log: " + str);
            return false;
        } else if (stringBuffer == null || str == null) {
            return false;
        } else {
            String str3 = h.T() + k(str);
            if (objArr != null) {
                if (com.uc.crashsdk.b.d) {
                    j3 = JNIBridge.nativeClientCreateConnection(str3, SceneSettingStatisticsBean.PAGE_CUSTOM, str, z6 ? 1 : 0);
                } else {
                    j3 = 0;
                }
                if (j3 == 0) {
                    com.uc.crashsdk.a.a.c("DEBUG", "skip custom log: " + str);
                    return false;
                }
                j2 = j3;
            } else if (a(g(), str, z6)) {
                return false;
            } else {
                h.b();
                a(false);
                j2 = 0;
            }
            synchronized (p) {
                a2 = a(str3, j2, stringBuffer, str, z2, z3, z4, z5, arrayList, arrayList2, arrayList3, str2);
            }
            if (a2 && objArr == null) {
                b(g(), str, z6);
            }
            if (j2 != 0) {
                JNIBridge.nativeClientCloseConnection(j2);
            }
            if (a2) {
                if (objArr == null) {
                    r(str3);
                }
                b(objArr == null ? m(str3) : str3, str);
                if (z6 && objArr == null) {
                    try {
                        a(true, false);
                        return true;
                    } catch (Throwable th) {
                        com.uc.crashsdk.a.g.a(th);
                        return true;
                    }
                }
                return true;
            }
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean a(String str, String str2, boolean z2) {
        if (o(str2)) {
            com.uc.crashsdk.a.h.a(str, str2, true, z2);
            com.uc.crashsdk.a.a.c(String.format(Locale.US, "Custom log '%s' has reach max count!", str2));
            return true;
        }
        return false;
    }

    private static void a(b bVar, String str, long j2) {
        String nativeDumpThreads;
        String str2 = null;
        if (com.uc.crashsdk.b.d) {
            try {
                bVar.flush();
            } catch (Throwable th) {
                com.uc.crashsdk.a.g.a(th);
            }
            nativeDumpThreads = JNIBridge.nativeDumpThreads(str, j2);
            if (ad || nativeDumpThreads == null || nativeDumpThreads.length() >= 512 || !nativeDumpThreads.startsWith("/") || nativeDumpThreads.indexOf(10) >= 0) {
                str2 = nativeDumpThreads;
            } else {
                if (!new File(nativeDumpThreads).exists()) {
                    str2 = "Can not found " + nativeDumpThreads;
                }
                String str3 = str2;
                str2 = nativeDumpThreads;
                nativeDumpThreads = str3;
            }
        } else {
            nativeDumpThreads = "Native not initialized, skip dump!";
        }
        if (nativeDumpThreads != null) {
            try {
                bVar.write(nativeDumpThreads.getBytes("UTF-8"));
                bVar.write("\n".getBytes("UTF-8"));
            } catch (Throwable th2) {
                com.uc.crashsdk.a.g.a(th2);
            }
            a((OutputStream) bVar);
        } else if (str2 != null && !ad) {
            b(bVar, str2, 1048576);
            File file = new File(str2);
            if (file.exists()) {
                file.delete();
            }
        }
        try {
            bVar.flush();
        } catch (Throwable th3) {
            com.uc.crashsdk.a.g.a(th3);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:24:0x003f A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0040  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static boolean a(java.lang.String r16, long r17, java.lang.StringBuffer r19, java.lang.String r20, boolean r21, boolean r22, boolean r23, boolean r24, java.util.ArrayList<java.lang.String> r25, java.util.ArrayList<java.lang.String> r26, java.util.ArrayList<java.lang.String> r27, java.lang.String r28) {
        /*
            Method dump skipped, instructions count: 346
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.uc.crashsdk.e.a(java.lang.String, long, java.lang.StringBuffer, java.lang.String, boolean, boolean, boolean, boolean, java.util.ArrayList, java.util.ArrayList, java.util.ArrayList, java.lang.String):boolean");
    }

    public static void a(String str, boolean z2) {
        if (z2) {
            x = str;
            return;
        }
        synchronized (y) {
            w = str;
            com.uc.crashsdk.a.b.a(com.uc.crashsdk.b.h(), str + "\n");
        }
    }

    private static String a(Date date) {
        return String.format(Locale.US, "%d%02d%02d%02d%02d%02d", Integer.valueOf(date.getYear() + 1900), Integer.valueOf(date.getMonth() + 1), Integer.valueOf(date.getDate()), Integer.valueOf(date.getHours()), Integer.valueOf(date.getMinutes()), Integer.valueOf(date.getSeconds()));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(OutputStream outputStream, String str, String str2, int i2, boolean z2) {
        g = false;
        try {
            Locale locale = Locale.US;
            Object[] objArr = new Object[4];
            objArr[0] = str;
            objArr[1] = str2;
            objArr[2] = Integer.valueOf(i2);
            objArr[3] = Integer.valueOf(z2 ? 1 : 0);
            outputStream.write(String.format(locale, "$^%s`%s`%d`%d^$", objArr).getBytes("UTF-8"));
        } catch (Throwable th) {
            com.uc.crashsdk.a.g.a(th);
        }
        g = true;
        a(outputStream);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(OutputStream outputStream, String str, String str2) {
        g = false;
        try {
            outputStream.write(String.format(Locale.US, "$^%s`%s^$", str, str2).getBytes("UTF-8"));
        } catch (Throwable th) {
            com.uc.crashsdk.a.g.a(th);
        }
        g = true;
    }

    public static void a(Context context) {
        if (h.J()) {
            try {
                IntentFilter intentFilter = new IntentFilter();
                intentFilter.addAction("android.intent.action.BATTERY_CHANGED");
                intentFilter.addAction("android.intent.action.BATTERY_LOW");
                intentFilter.addAction("android.intent.action.BATTERY_OKAY");
                context.registerReceiver(O, intentFilter);
                P = true;
            } catch (Throwable th) {
                com.uc.crashsdk.a.g.a(th);
            }
        }
    }

    /* JADX WARN: Can't wrap try/catch for region: R(13:(1:345)|(3:372|373|(13:376|377|378|348|349|(1:351)|352|(1:356)|357|(1:360)|(1:364)|365|(2:367|368)(1:369)))|347|348|349|(0)|352|(2:354|356)|357|(1:360)|(1:364)|365|(0)(0)) */
    /* JADX WARN: Can't wrap try/catch for region: R(13:124|(3:151|152|(13:155|156|157|127|128|(1:130)|131|(1:135)|136|(1:139)|(1:143)|144|(2:146|147)(1:148)))|126|127|128|(0)|131|(2:133|135)|136|(1:139)|(1:143)|144|(0)(0)) */
    /* JADX WARN: Can't wrap try/catch for region: R(13:14|(3:42|43|(13:46|47|48|17|18|(1:20)|21|(1:25)|26|(1:29)|(1:33)|34|(2:36|37)(1:39)))|16|17|18|(0)|21|(2:23|25)|26|(1:29)|(1:33)|34|(0)(0)) */
    /* JADX WARN: Can't wrap try/catch for region: R(13:81|(3:108|109|(13:112|113|114|84|85|(1:87)|88|(1:92)|93|(1:96)|(1:100)|101|(2:103|104)(1:105)))|83|84|85|(0)|88|(2:90|92)|93|(1:96)|(1:100)|101|(0)(0)) */
    /* JADX WARN: Can't wrap try/catch for region: R(15:386|387|(1:391)|(3:418|419|(13:422|423|424|394|395|(1:397)|398|(1:402)|403|(1:406)|(1:410)|411|(2:413|414)(1:415)))|393|394|395|(0)|398|(2:400|402)|403|(1:406)|(1:410)|411|(0)(0)) */
    /* JADX WARN: Can't wrap try/catch for region: R(16:281|282|(1:286)|(3:313|314|(15:317|318|319|320|289|290|(0)|293|(2:295|297)|298|(1:301)|(1:306)|307|(0)|310))|288|289|290|(0)|293|(0)|298|(0)|(0)|307|(0)|310) */
    /* JADX WARN: Can't wrap try/catch for region: R(16:452|(5:455|456|457|(1:459)|453)|501|460|(3:487|488|(13:491|492|493|463|464|(1:466)|467|(1:471)|472|(1:475)|(1:479)|480|(2:482|483)(1:484)))|462|463|464|(0)|467|(2:469|471)|472|(1:475)|(1:479)|480|(0)(0)) */
    /* JADX WARN: Code restructure failed: missing block: B:167:0x023e, code lost:
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:168:0x023f, code lost:
        com.uc.crashsdk.a.g.a(r0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:204:0x02b2, code lost:
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:205:0x02b3, code lost:
        com.uc.crashsdk.a.g.a(r0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:257:0x034e, code lost:
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:258:0x034f, code lost:
        com.uc.crashsdk.a.g.a(r0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:298:0x03c6, code lost:
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:299:0x03c7, code lost:
        com.uc.crashsdk.a.g.a(r0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:450:0x05ea, code lost:
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:451:0x05eb, code lost:
        com.uc.crashsdk.a.g.a(r0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:52:0x009f, code lost:
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:53:0x00a0, code lost:
        com.uc.crashsdk.a.g.a(r0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:94:0x0122, code lost:
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:95:0x0123, code lost:
        com.uc.crashsdk.a.g.a(r0);
     */
    /* JADX WARN: Removed duplicated region for block: B:101:0x0135  */
    /* JADX WARN: Removed duplicated region for block: B:128:0x01c4 A[Catch: all -> 0x01e7, TRY_ENTER, TRY_LEAVE, TryCatch #37 {all -> 0x02d9, blocks: (B:141:0x01ed, B:176:0x0259, B:178:0x025f, B:215:0x02d3, B:222:0x02e2, B:128:0x01c4, B:136:0x01da, B:129:0x01c7, B:131:0x01cd, B:132:0x01d2), top: B:515:0x01c2 }] */
    /* JADX WARN: Removed duplicated region for block: B:156:0x0213  */
    /* JADX WARN: Removed duplicated region for block: B:159:0x0225 A[Catch: all -> 0x023e, TryCatch #21 {all -> 0x023e, blocks: (B:154:0x0209, B:157:0x0214, B:159:0x0225, B:161:0x0229, B:162:0x022e, B:165:0x0236), top: B:489:0x0209 }] */
    /* JADX WARN: Removed duplicated region for block: B:164:0x0234 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:170:0x0244 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:174:0x0251  */
    /* JADX WARN: Removed duplicated region for block: B:193:0x0287  */
    /* JADX WARN: Removed duplicated region for block: B:196:0x0299 A[Catch: all -> 0x02b2, TryCatch #15 {all -> 0x02b2, blocks: (B:191:0x027d, B:194:0x0288, B:196:0x0299, B:198:0x029d, B:199:0x02a2, B:202:0x02aa), top: B:478:0x027d }] */
    /* JADX WARN: Removed duplicated region for block: B:201:0x02a8 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:207:0x02b8 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:211:0x02c5  */
    /* JADX WARN: Removed duplicated region for block: B:214:0x02d1  */
    /* JADX WARN: Removed duplicated region for block: B:246:0x0323  */
    /* JADX WARN: Removed duplicated region for block: B:249:0x0335 A[Catch: all -> 0x034e, TryCatch #31 {all -> 0x034e, blocks: (B:244:0x0319, B:247:0x0324, B:249:0x0335, B:251:0x0339, B:252:0x033e, B:255:0x0346), top: B:505:0x0319 }] */
    /* JADX WARN: Removed duplicated region for block: B:254:0x0344 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:260:0x0354 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:264:0x0361  */
    /* JADX WARN: Removed duplicated region for block: B:287:0x039b  */
    /* JADX WARN: Removed duplicated region for block: B:290:0x03ad A[Catch: all -> 0x03c6, TryCatch #27 {all -> 0x03c6, blocks: (B:285:0x0391, B:288:0x039c, B:290:0x03ad, B:292:0x03b1, B:293:0x03b6, B:296:0x03be), top: B:497:0x0391 }] */
    /* JADX WARN: Removed duplicated region for block: B:295:0x03bc A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:301:0x03cc A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:305:0x03d9  */
    /* JADX WARN: Removed duplicated region for block: B:315:0x0411 A[Catch: all -> 0x04dc, TryCatch #38 {all -> 0x04dc, blocks: (B:308:0x03e3, B:311:0x03f3, B:313:0x03f9, B:315:0x0411, B:316:0x0414, B:322:0x0444, B:317:0x043b), top: B:516:0x03e3 }] */
    /* JADX WARN: Removed duplicated region for block: B:343:0x0492  */
    /* JADX WARN: Removed duplicated region for block: B:346:0x04a4 A[Catch: all -> 0x04bd, TryCatch #19 {all -> 0x04bd, blocks: (B:341:0x0488, B:344:0x0493, B:346:0x04a4, B:348:0x04a8, B:349:0x04ad, B:352:0x04b5), top: B:485:0x0488 }] */
    /* JADX WARN: Removed duplicated region for block: B:351:0x04b3 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:357:0x04c3 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:362:0x04d4  */
    /* JADX WARN: Removed duplicated region for block: B:376:0x04fd A[Catch: all -> 0x058b, TRY_LEAVE, TryCatch #30 {all -> 0x058b, blocks: (B:374:0x04e7, B:376:0x04fd), top: B:503:0x04e7 }] */
    /* JADX WARN: Removed duplicated region for block: B:379:0x0515  */
    /* JADX WARN: Removed duplicated region for block: B:397:0x0541  */
    /* JADX WARN: Removed duplicated region for block: B:400:0x0553 A[Catch: all -> 0x056c, TryCatch #11 {all -> 0x056c, blocks: (B:395:0x0537, B:398:0x0542, B:400:0x0553, B:402:0x0557, B:403:0x055c, B:406:0x0564), top: B:470:0x0537 }] */
    /* JADX WARN: Removed duplicated region for block: B:405:0x0562 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:411:0x0572 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:416:0x0583  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x0074  */
    /* JADX WARN: Removed duplicated region for block: B:439:0x05bf  */
    /* JADX WARN: Removed duplicated region for block: B:442:0x05d1 A[Catch: all -> 0x05ea, TryCatch #9 {all -> 0x05ea, blocks: (B:437:0x05b5, B:440:0x05c0, B:442:0x05d1, B:444:0x05d5, B:445:0x05da, B:448:0x05e2), top: B:466:0x05b5 }] */
    /* JADX WARN: Removed duplicated region for block: B:447:0x05e0 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:44:0x0086 A[Catch: all -> 0x009f, TryCatch #41 {all -> 0x009f, blocks: (B:39:0x006a, B:42:0x0075, B:44:0x0086, B:46:0x008a, B:47:0x008f, B:50:0x0097), top: B:520:0x006a }] */
    /* JADX WARN: Removed duplicated region for block: B:453:0x05f0 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:458:0x0601  */
    /* JADX WARN: Removed duplicated region for block: B:476:0x051e A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:493:0x046f A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:49:0x0095 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:535:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:536:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:537:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:538:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:539:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:540:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:541:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:542:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:55:0x00a5 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:59:0x00b2  */
    /* JADX WARN: Removed duplicated region for block: B:83:0x00f7  */
    /* JADX WARN: Removed duplicated region for block: B:86:0x0109 A[Catch: all -> 0x0122, TryCatch #40 {all -> 0x0122, blocks: (B:81:0x00ed, B:84:0x00f8, B:86:0x0109, B:88:0x010d, B:89:0x0112, B:92:0x011a), top: B:526:0x00ed }] */
    /* JADX WARN: Removed duplicated region for block: B:91:0x0118 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:97:0x0128 A[ADDED_TO_REGION] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void a(java.lang.Thread r22, java.lang.Throwable r23, boolean r24) {
        /*
            Method dump skipped, instructions count: 1545
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.uc.crashsdk.e.a(java.lang.Thread, java.lang.Throwable, boolean):void");
    }

    private static void a(Throwable th) {
        try {
            com.uc.crashsdk.a.a.c("DEBUG", a(th.getStackTrace(), (String) null).toString());
        } catch (Throwable unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static StringBuilder a(StackTraceElement[] stackTraceElementArr, String str) {
        StringBuilder sb = new StringBuilder();
        int i2 = 0;
        if (stackTraceElementArr != null && stackTraceElementArr.length > 0) {
            int i3 = 0;
            boolean z2 = str == null;
            for (StackTraceElement stackTraceElement : stackTraceElementArr) {
                i3++;
                sb.append("  at ");
                sb.append(stackTraceElement.toString());
                sb.append("\n");
                if (!z2 && stackTraceElement.getMethodName().contains(str)) {
                    sb.delete(0, sb.length());
                    i3 = 0;
                    z2 = true;
                }
            }
            i2 = i3;
        }
        if (i2 == 0) {
            sb.append("  (no java stack)\n");
        }
        return sb;
    }

    public static boolean a(ParcelFileDescriptor parcelFileDescriptor) {
        if (ac) {
            com.uc.crashsdk.a.a.c("crashsdk", "Can not call setHostFd and getHostFd in the same process!");
            return false;
        } else if (!com.uc.crashsdk.b.d) {
            com.uc.crashsdk.a.a.c("crashsdk", "Crash so is not loaded!");
            return false;
        } else {
            if (ab != null) {
                com.uc.crashsdk.a.a.b("crashsdk", "Has already set host fd!");
            }
            ab = parcelFileDescriptor;
            int fd = parcelFileDescriptor.getFd();
            int nativeGetOrSetHostFd = JNIBridge.nativeGetOrSetHostFd(1, fd);
            ad = nativeGetOrSetHostFd != -1;
            return fd == -1 || nativeGetOrSetHostFd != -1;
        }
    }
}
