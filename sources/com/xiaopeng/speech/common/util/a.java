package com.xiaopeng.speech.common.util;

import android.app.ActivityThread;
import android.util.Log;
/* compiled from: LogUtils.java */
/* loaded from: classes.dex */
public class a {
    public static int a = 2;
    public static String b = a();
    public static c c = new b();
    public static boolean d = true;

    /* compiled from: LogUtils.java */
    /* loaded from: classes.dex */
    private static class b implements c {
        private b() {
        }

        @Override // com.xiaopeng.speech.common.util.a.c
        public void logByLevel(int i, String str, String str2, String str3) {
            if (i == 2) {
                Log.v(str2, str);
            } else if (i == 3) {
                Log.d(str2, str);
                String str4 = "DEBUG: " + str;
            } else if (i == 4) {
                Log.i(str2, str);
                String str5 = "INFO: " + str;
            } else if (i == 5) {
                Log.w(str2, str);
                String str6 = "WARN: " + str;
            } else if (i != 6) {
            } else {
                Log.e(str2, str);
                String str7 = "ERROR: " + str;
            }
        }
    }

    /* compiled from: LogUtils.java */
    /* loaded from: classes.dex */
    public interface c {
        void logByLevel(int i, String str, String str2, String str3);
    }

    public static boolean a(int i) {
        return a <= i && b();
    }

    public static boolean b() {
        return d;
    }

    public static void a(Object obj, String str, Throwable th) {
        if (a(6)) {
            a(6, obj, str, th, true);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x002f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static void a(int r4, java.lang.Object r5, java.lang.String r6, java.lang.Throwable r7, boolean r8) {
        /*
            if (r8 == 0) goto L1e
            java.lang.Thread r0 = java.lang.Thread.currentThread()
            java.lang.StackTraceElement[] r0 = r0.getStackTrace()
            r1 = 0
            if (r0 == 0) goto L13
            int r2 = r0.length
            r3 = 4
            if (r2 <= r3) goto L13
            r1 = r0[r3]
        L13:
            if (r1 == 0) goto L1e
            java.lang.String r0 = r1.getFileName()
            int r1 = r1.getLineNumber()
            goto L21
        L1e:
            java.lang.String r0 = ""
            r1 = 0
        L21:
            java.lang.String r6 = a(r0, r1, r6, r7, r8)
            java.lang.String r5 = a(r5)
            boolean r7 = android.text.TextUtils.isEmpty(r5)
            if (r7 == 0) goto L30
            r5 = r0
        L30:
            a(r4, r5, r6)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xiaopeng.speech.common.util.a.a(int, java.lang.Object, java.lang.String, java.lang.Throwable, boolean):void");
    }

    private static void a(int i, String str, String str2) {
        c.logByLevel(i, str2, str, null);
    }

    private static String a(String str, int i, String str2, Throwable th, boolean z) {
        StringBuilder sb = new StringBuilder();
        sb.append(str2);
        if (z) {
            sb.append("(T:");
            sb.append(Thread.currentThread().getId());
            sb.append(")");
            if (b != null) {
                sb.append("(C:");
                sb.append(b);
                sb.append(")");
            }
            sb.append("at (");
            sb.append(str);
            sb.append(":");
            sb.append(i);
            sb.append(")");
        }
        if (th != null) {
            sb.append('\n');
            sb.append(Log.getStackTraceString(th));
        }
        return sb.toString();
    }

    private static String a(Object obj) {
        if (obj == null) {
            return null;
        }
        if (obj instanceof String) {
            return (String) obj;
        }
        if (obj instanceof Class) {
            return ((Class) obj).getSimpleName();
        }
        return obj.getClass().getSimpleName();
    }

    private static String a() {
        String[] split = ActivityThread.currentApplication().getPackageName().split("\\.");
        return split[split.length - 1];
    }
}
