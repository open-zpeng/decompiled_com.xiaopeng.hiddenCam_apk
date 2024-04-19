package com.uc.crashsdk.a;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.os.Build;
import com.uc.crashsdk.JNIBridge;
import com.xiaopeng.lib.framework.moduleinterface.carcontroller.IInputController;
import java.io.BufferedReader;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.util.ArrayList;
/* compiled from: ProGuard */
/* loaded from: classes.dex */
public class g {
    private static Context b;
    static final /* synthetic */ boolean a = !g.class.desiredAssertionStatus();
    private static String c = null;
    private static String d = null;
    private static String e = null;
    private static String f = null;
    private static boolean g = false;
    private static final Object h = new Object();

    public static void a(File file, File file2) {
        FileInputStream fileInputStream;
        byte[] bArr = new byte[524288];
        File parentFile = file2.getParentFile();
        if (!parentFile.exists()) {
            parentFile.mkdirs();
        }
        if (file2.isDirectory()) {
            file2 = new File(file2, file.getName());
        }
        FileOutputStream fileOutputStream = null;
        try {
            fileInputStream = new FileInputStream(file);
            try {
                FileOutputStream fileOutputStream2 = new FileOutputStream(file2);
                while (true) {
                    try {
                        int read = fileInputStream.read(bArr);
                        if (read == -1) {
                            a(fileInputStream);
                            a(fileOutputStream2);
                            return;
                        }
                        fileOutputStream2.write(bArr, 0, read);
                    } catch (Throwable th) {
                        th = th;
                        fileOutputStream = fileOutputStream2;
                        a(fileInputStream);
                        a(fileOutputStream);
                        throw th;
                    }
                }
            } catch (Throwable th2) {
                th = th2;
            }
        } catch (Throwable th3) {
            th = th3;
            fileInputStream = null;
        }
    }

    public static String b(File file) {
        FileInputStream fileInputStream;
        String str = "";
        if (file.exists()) {
            try {
                fileInputStream = new FileInputStream(file);
                try {
                    byte[] bArr = new byte[256];
                    StringBuilder sb = new StringBuilder();
                    while (true) {
                        int read = fileInputStream.read(bArr);
                        if (read <= 0) {
                            break;
                        }
                        sb.append(new String(bArr, 0, read));
                    }
                    str = sb.toString();
                } catch (Throwable th) {
                    th = th;
                    try {
                        a(th, false);
                        return str;
                    } finally {
                        a(fileInputStream);
                    }
                }
            } catch (Throwable th2) {
                th = th2;
                fileInputStream = null;
            }
            return str;
        }
        return "";
    }

    public static long c(String str) {
        if (a(str)) {
            return 0L;
        }
        try {
            long parseLong = Long.parseLong(str.trim());
            if (parseLong < 0) {
                return 0L;
            }
            return parseLong;
        } catch (NumberFormatException unused) {
            return 0L;
        }
    }

    public static Object d(String str) {
        return b.getSystemService(str);
    }

    public static boolean e() {
        String str = Build.TAGS;
        return str != null && str.contains("test-keys");
    }

    public static boolean f() {
        int indexOf;
        String h2 = h();
        if (!a(h2) && (indexOf = h2.indexOf(" root ")) > 0) {
            String substring = h2.substring(0, indexOf);
            if (substring.contains("x") || substring.contains("s")) {
                return true;
            }
        }
        return false;
    }

    public static String g() {
        k();
        return a(e) ? "" : e;
    }

    public static String h() {
        k();
        return a(f) ? "" : f;
    }

    public static void i() {
        f.a(0, new e(800), 15000L);
    }

    public static void j() {
        if (com.uc.crashsdk.b.d && g) {
            JNIBridge.nativeSyncInfo("subin", e, 0L, 0L);
            JNIBridge.nativeSyncInfo("supmi", f, 0L, 0L);
        }
    }

    private static void k() {
        String trim;
        int indexOf;
        int indexOf2;
        if (g) {
            return;
        }
        synchronized (h) {
            if (g) {
                return;
            }
            String a2 = a(new String[]{"sh", "-c", "type su"});
            if (!a(a2) && (indexOf = (trim = a2.trim()).indexOf(32)) > 0 && trim.contains("/su") && (indexOf2 = trim.indexOf(47, indexOf + 1)) > 0) {
                e = trim.substring(indexOf2);
                String a3 = a(new String[]{"ls", "-l", e});
                if (!a(a3)) {
                    f = a3.trim();
                }
            }
            g = true;
            j();
        }
    }

    public static boolean a(File file) {
        String[] list;
        if (file.isDirectory() && (list = file.list()) != null) {
            for (String str : list) {
                if (!a(new File(file, str))) {
                    return false;
                }
            }
        }
        return file.delete();
    }

    public static boolean d() {
        if (f()) {
            return true;
        }
        return e();
    }

    public static String c() {
        return d;
    }

    public static String a(File file, int i) {
        FileInputStream fileInputStream;
        try {
            fileInputStream = new FileInputStream(file);
            try {
                byte[] bArr = new byte[i];
                int read = fileInputStream.read(bArr);
                if (read > 0) {
                    String str = new String(bArr, 0, read);
                    a(fileInputStream);
                    return str;
                }
            } catch (Throwable unused) {
            }
        } catch (Throwable unused2) {
            fileInputStream = null;
        }
        a(fileInputStream);
        return null;
    }

    public static ArrayList<String> b(File file, int i) {
        FileReader fileReader;
        ArrayList<String> arrayList = new ArrayList<>();
        BufferedReader bufferedReader = null;
        try {
            fileReader = new FileReader(file);
            try {
                BufferedReader bufferedReader2 = new BufferedReader(fileReader, IInputController.KEYCODE_BACK_BUTTON);
                int i2 = 0;
                while (true) {
                    try {
                        String readLine = bufferedReader2.readLine();
                        if (readLine == null) {
                            break;
                        }
                        arrayList.add(readLine);
                        i2++;
                        if (i > 0 && i2 >= i) {
                            break;
                        }
                    } catch (Throwable th) {
                        th = th;
                        bufferedReader = bufferedReader2;
                        try {
                            a(th, false);
                            return arrayList;
                        } finally {
                            a(fileReader);
                            a(bufferedReader);
                        }
                    }
                }
                a(fileReader);
                a(bufferedReader2);
            } catch (Throwable th2) {
                th = th2;
            }
        } catch (Throwable th3) {
            th = th3;
            fileReader = null;
        }
        return arrayList;
    }

    public static boolean a(File file, byte[] bArr) {
        FileOutputStream fileOutputStream = null;
        try {
            FileOutputStream fileOutputStream2 = new FileOutputStream(file);
            try {
                fileOutputStream2.write(bArr);
                fileOutputStream2.flush();
                a(fileOutputStream2);
                return true;
            } catch (Throwable th) {
                th = th;
                fileOutputStream = fileOutputStream2;
                try {
                    a(th, false);
                    return false;
                } finally {
                    a(fileOutputStream);
                }
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    public static boolean a(File file, String str) {
        FileWriter fileWriter = null;
        try {
            FileWriter fileWriter2 = new FileWriter(file);
            try {
                fileWriter2.write(str, 0, str.length());
                a(fileWriter2);
                return true;
            } catch (Throwable th) {
                th = th;
                fileWriter = fileWriter2;
                try {
                    a(th, false);
                    return false;
                } finally {
                    a(fileWriter);
                }
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    public static boolean b(String str) {
        return !a(str);
    }

    public static void b(Throwable th) {
        a(th, true);
    }

    public static String b() {
        return c;
    }

    public static void a(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (Throwable th) {
                a(th, true);
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:9:0x0027, code lost:
        if (r2.toLowerCase().startsWith("http") != false) goto L8;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static java.lang.String a(java.lang.String r2, java.lang.String r3, boolean r4) {
        /*
            java.io.File r0 = new java.io.File
            r0.<init>(r2)
            boolean r0 = r0.exists()
            r1 = 0
            if (r0 == 0) goto L2a
            java.lang.String r2 = com.uc.crashsdk.a.b.a(r2)
            boolean r0 = a(r2)
            if (r0 == 0) goto L17
            goto L2a
        L17:
            if (r4 == 0) goto L29
            java.lang.String r2 = r2.trim()
            java.lang.String r4 = r2.toLowerCase()
            java.lang.String r0 = "http"
            boolean r4 = r4.startsWith(r0)
            if (r4 == 0) goto L2a
        L29:
            r1 = r2
        L2a:
            if (r1 != 0) goto L2d
            goto L2e
        L2d:
            r3 = r1
        L2e:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.uc.crashsdk.a.g.a(java.lang.String, java.lang.String, boolean):java.lang.String");
    }

    public static boolean a(String str) {
        return str == null || str.trim().length() == 0;
    }

    public static boolean a(StringBuffer stringBuffer) {
        return stringBuffer == null || stringBuffer.length() == 0;
    }

    public static void a(Throwable th) {
        a(th, false);
    }

    private static void a(Throwable th, boolean z) {
        if (!z) {
            try {
                if (!com.uc.crashsdk.h.K()) {
                    return;
                }
            } catch (Throwable unused) {
                return;
            }
        }
        th.printStackTrace();
    }

    public static void a(Context context) {
        if (b != null) {
            a.c("mContext is existed");
        }
        b = context;
        ApplicationInfo applicationInfo = context.getApplicationInfo();
        c = applicationInfo.dataDir;
        d = applicationInfo.sourceDir;
    }

    public static Context a() {
        return b;
    }

    public static void a(int i) {
        if (i != 800) {
            if (!a) {
                throw new AssertionError();
            }
            return;
        }
        k();
    }

    private static String a(String[] strArr) {
        BufferedReader bufferedReader;
        InputStreamReader inputStreamReader;
        try {
            inputStreamReader = new InputStreamReader(Runtime.getRuntime().exec(strArr).getInputStream());
            try {
                bufferedReader = new BufferedReader(inputStreamReader, IInputController.KEYCODE_BACK_BUTTON);
                try {
                    StringBuilder sb = new StringBuilder();
                    while (true) {
                        String readLine = bufferedReader.readLine();
                        if (readLine != null) {
                            sb.append(readLine);
                        } else {
                            return sb.toString().trim();
                        }
                    }
                } catch (Throwable th) {
                    th = th;
                    try {
                        a(th, false);
                        return null;
                    } finally {
                        a(bufferedReader);
                        a(inputStreamReader);
                    }
                }
            } catch (Throwable th2) {
                th = th2;
                bufferedReader = null;
            }
        } catch (Throwable th3) {
            th = th3;
            bufferedReader = null;
            inputStreamReader = null;
        }
    }
}
