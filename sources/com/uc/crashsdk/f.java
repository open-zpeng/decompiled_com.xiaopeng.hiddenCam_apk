package com.uc.crashsdk;

import android.util.SparseArray;
import android.util.SparseIntArray;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.HashMap;
import java.util.Map;
/* compiled from: ProGuard */
/* loaded from: classes.dex */
public class f {
    static final /* synthetic */ boolean a = !f.class.desiredAssertionStatus();
    private static final Map<String, SparseIntArray> b = new HashMap();
    private static final Object c = new Object();
    private static final SparseArray<String> d = new SparseArray<>();
    private static final Object e = new Object();
    private static boolean f = false;

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(int i) {
        a(i, 1);
    }

    private static boolean b(int i, int i2) {
        try {
            b.u();
        } catch (Throwable th) {
            com.uc.crashsdk.a.g.a(th);
        }
        try {
            String c2 = c(i);
            if (c2 == null) {
                com.uc.crashsdk.a.a.a("crashsdk", "Stat type not exists: " + i, null);
                return false;
            }
            File file = new File(b.c());
            if (!file.exists()) {
                file.createNewFile();
            }
            StringBuffer a2 = a(file);
            if (com.uc.crashsdk.a.g.a(a2)) {
                if (a2 == null) {
                    a2 = new StringBuffer();
                }
                a2.append("[");
                a2.append(e.g());
                a2.append("]\n");
            }
            a(a2, c2, a(a2, c2) + i2);
            return a(file, a2);
        } catch (Exception e2) {
            com.uc.crashsdk.a.g.a(e2);
            return false;
        }
    }

    private static boolean c(String str) {
        f();
        synchronized (d) {
            File file = new File(str);
            StringBuffer a2 = a(file);
            if (com.uc.crashsdk.a.g.a(a2)) {
                return false;
            }
            int indexOf = a2.indexOf("[");
            if (indexOf < 0) {
                com.uc.crashsdk.a.a.a("crashsdk", "Can not found process name start!", null);
                return false;
            }
            int i = indexOf + 1;
            int indexOf2 = a2.indexOf("]", i);
            if (indexOf2 < 0) {
                com.uc.crashsdk.a.a.a("crashsdk", "Can not found process name end!", null);
                return false;
            }
            String substring = a2.substring(i, indexOf2);
            boolean z = false;
            for (int i2 = 0; i2 < d.size(); i2++) {
                int keyAt = d.keyAt(i2);
                String str2 = d.get(keyAt);
                int a3 = a(a2, str2);
                if (a3 > 0) {
                    com.uc.crashsdk.a.h.a(substring, keyAt, a3);
                    synchronized (b) {
                        SparseIntArray sparseIntArray = b.get(substring);
                        if (sparseIntArray == null) {
                            sparseIntArray = new SparseIntArray();
                            b.put(substring, sparseIntArray);
                        }
                        sparseIntArray.put(keyAt, sparseIntArray.get(keyAt, 0) + a3);
                    }
                    a(a2, str2, 0);
                    z = true;
                }
            }
            if (z) {
                a(file, a2);
            }
            return true;
        }
    }

    private static boolean d(String str) {
        SparseIntArray sparseIntArray = b.get(str);
        if (sparseIntArray == null) {
            return false;
        }
        for (int i = 0; i < sparseIntArray.size(); i++) {
            int keyAt = sparseIntArray.keyAt(i);
            d.a(str, keyAt, sparseIntArray.get(keyAt));
        }
        return true;
    }

    private static char[] e() {
        char[] cArr = null;
        int i = 1024;
        while (cArr == null && i > 0) {
            try {
                cArr = new char[i];
            } catch (Throwable unused) {
                i /= 2;
                if (i < 512) {
                    break;
                }
            }
        }
        return cArr;
    }

    private static void f() {
        synchronized (d) {
            if (d.size() != 0) {
                return;
            }
            d.put(100, "start_pv");
            d.put(1, "all_all");
            d.put(2, "all_fg");
            d.put(3, "java_fg");
            d.put(4, "java_bg");
            d.put(7, "native_fg");
            d.put(8, "native_bg");
            d.put(27, "native_anr_fg");
            d.put(28, "native_anr_bg");
            d.put(9, "native_ok");
            d.put(10, "unexp_anr");
            d.put(29, "unexp_lowmem");
            d.put(30, "unexp_killed");
            d.put(31, "unexp_exit");
            d.put(32, "unexp_restart");
            d.put(11, "unexp_fg");
            d.put(12, "unexp_bg");
            d.put(13, "log_up_succ");
            d.put(14, "log_up_fail");
            d.put(15, "log_empty");
            d.put(16, "log_abd_all");
            d.put(22, "log_abd_crash");
            d.put(23, "log_abd_custom");
            d.put(17, "log_large");
            d.put(18, "log_up_all");
            d.put(19, "log_up_bytes");
            d.put(20, "log_up_crash");
            d.put(21, "log_up_custom");
            d.put(24, "log_zipped");
            d.put(25, "log_renamed");
            d.put(26, "log_safe_skip");
        }
    }

    private static File[] g() {
        return new File(h.S()).listFiles(new g());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(int i, int i2) {
        if (i2 == 0) {
            com.uc.crashsdk.a.a.c("Add stat for type " + i + " with count 0!");
            return;
        }
        a(b.c(), new com.uc.crashsdk.a.e(751, new Object[]{Integer.valueOf(i), Integer.valueOf(i2)}));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void d() {
        com.uc.crashsdk.a.f.a(1, new com.uc.crashsdk.a.e(700), 3000L);
    }

    private static StringBuffer a(File file) {
        FileReader fileReader;
        FileReader fileReader2 = null;
        if (file.exists()) {
            char[] e2 = e();
            if (e2 == null) {
                com.uc.crashsdk.a.a.a("crashsdk", "readCrashStatData alloc buffer failed!", null);
                return null;
            }
            StringBuffer stringBuffer = new StringBuffer();
            try {
                try {
                    fileReader = new FileReader(file);
                } catch (Throwable th) {
                    th = th;
                }
            } catch (Exception e3) {
                e = e3;
            }
            try {
                int read = fileReader.read(e2);
                if (read > 0) {
                    fileReader2 = null;
                    stringBuffer.append(e2, 0, read);
                }
                com.uc.crashsdk.a.g.a(fileReader);
            } catch (Exception e4) {
                e = e4;
                fileReader2 = fileReader;
                com.uc.crashsdk.a.g.a(e);
                com.uc.crashsdk.a.g.a(fileReader2);
                return stringBuffer;
            } catch (Throwable th2) {
                th = th2;
                fileReader2 = fileReader;
                com.uc.crashsdk.a.g.a(fileReader2);
                throw th;
            }
            return stringBuffer;
        }
        return null;
    }

    private static int a(StringBuffer stringBuffer, String str) {
        int indexOf = stringBuffer.indexOf(str);
        if (indexOf < 0) {
            return 0;
        }
        int indexOf2 = stringBuffer.indexOf("=", indexOf + str.length());
        if (indexOf2 < 0) {
            com.uc.crashsdk.a.a.c(str + " line not contain '='!");
            return 0;
        }
        int i = indexOf2 + 1;
        int indexOf3 = stringBuffer.indexOf("\n", i);
        if (indexOf3 < 0) {
            indexOf3 = stringBuffer.length();
        }
        try {
            int parseInt = Integer.parseInt(stringBuffer.substring(i, indexOf3));
            if (parseInt < 0) {
                return 0;
            }
            return parseInt;
        } catch (NumberFormatException e2) {
            com.uc.crashsdk.a.g.a(e2);
            return 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int b(boolean z) {
        int size;
        synchronized (b) {
            if (z) {
                String g = e.g();
                if (b.containsKey(g)) {
                    b.remove(g);
                    size = 1;
                } else {
                    size = 0;
                }
            } else {
                size = b.size();
                b.clear();
            }
        }
        return size;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean b(String str) {
        return a(str, new com.uc.crashsdk.a.e(753, new Object[]{str}));
    }

    private static void a(StringBuffer stringBuffer, String str, int i) {
        int indexOf = stringBuffer.indexOf(str);
        if (indexOf < 0) {
            if (i > 0) {
                stringBuffer.append(str);
                stringBuffer.append("=");
                stringBuffer.append(i);
                stringBuffer.append("\n");
                return;
            }
            return;
        }
        int indexOf2 = stringBuffer.indexOf("\n", indexOf);
        if (indexOf2 < 0) {
            indexOf2 = stringBuffer.length();
        }
        stringBuffer.replace(indexOf, indexOf2, str + "=" + String.valueOf(i));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int b() {
        File[] g = g();
        if (g != null) {
            int i = 0;
            for (File file : g) {
                if (b(file.getAbsolutePath())) {
                    i++;
                }
            }
            return i;
        }
        return 0;
    }

    public static void b(int i) {
        if (i != 700) {
            return;
        }
        c();
    }

    private static boolean a(File file, StringBuffer stringBuffer) {
        FileWriter fileWriter;
        FileWriter fileWriter2 = null;
        try {
            try {
                fileWriter = new FileWriter(file);
            } catch (Exception e2) {
                e = e2;
            }
        } catch (Throwable th) {
            th = th;
        }
        try {
            String stringBuffer2 = stringBuffer.toString();
            fileWriter.write(stringBuffer2, 0, stringBuffer2.length());
            com.uc.crashsdk.a.g.a(fileWriter);
            return true;
        } catch (Exception e3) {
            e = e3;
            fileWriter2 = fileWriter;
            com.uc.crashsdk.a.g.a(e);
            com.uc.crashsdk.a.g.a(fileWriter2);
            return false;
        } catch (Throwable th2) {
            th = th2;
            fileWriter2 = fileWriter;
            com.uc.crashsdk.a.g.a(fileWriter2);
            throw th;
        }
    }

    private static String c(int i) {
        String str;
        f();
        synchronized (d) {
            str = d.get(i);
        }
        return str;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void c() {
        if (f) {
            return;
        }
        synchronized (e) {
            if (f) {
                return;
            }
            f = true;
            if (b.p() || b.q()) {
                a(1, 1);
                if (b.p()) {
                    a(2, 1);
                }
            }
            a(100, 1);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Multi-variable type inference failed */
    public static int a(boolean z) {
        int i;
        synchronized (b) {
            if (z) {
                String g = e.g();
                boolean d2 = d(g);
                b.remove(g);
                i = d2;
            } else {
                int i2 = 0;
                for (String str : b.keySet()) {
                    if (d(str)) {
                        i2++;
                    }
                }
                b.clear();
                i = i2;
            }
        }
        return i;
    }

    private static boolean a(String str, com.uc.crashsdk.a.e eVar) {
        return b.a(c, str, eVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean a(String str) {
        return a(str, new com.uc.crashsdk.a.e(752, new Object[]{str}));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int a() {
        File[] g = g();
        if (g != null) {
            int i = 0;
            for (File file : g) {
                if (a(file.getAbsolutePath())) {
                    i++;
                }
            }
            return i;
        }
        return 0;
    }

    public static boolean a(int i, Object[] objArr) {
        switch (i) {
            case 751:
                if (a || objArr != null) {
                    return b(((Integer) objArr[0]).intValue(), ((Integer) objArr[1]).intValue());
                }
                throw new AssertionError();
            case 752:
                if (a || objArr != null) {
                    return c((String) objArr[0]);
                }
                throw new AssertionError();
            case 753:
                if (a || objArr != null) {
                    File file = new File((String) objArr[0]);
                    if (file.exists()) {
                        file.delete();
                        return true;
                    }
                    return false;
                }
                throw new AssertionError();
            default:
                return false;
        }
    }
}
