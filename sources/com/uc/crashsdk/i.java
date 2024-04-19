package com.uc.crashsdk;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import java.io.File;
import java.io.FileInputStream;
/* compiled from: ProGuard */
/* loaded from: classes.dex */
public final class i {
    private static PendingIntent a;

    public static void a() {
        if (e.y() || b.D() || a != null || h.i() < 0) {
            return;
        }
        try {
            Context a2 = com.uc.crashsdk.a.g.a();
            Intent launchIntentForPackage = a2.getPackageManager().getLaunchIntentForPackage(a2.getPackageName());
            launchIntentForPackage.addFlags(335544320);
            a = PendingIntent.getActivity(a2, 0, launchIntentForPackage, 0);
        } catch (Throwable th) {
            com.uc.crashsdk.a.g.a(th);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean b() {
        if (a == null) {
            com.uc.crashsdk.a.a.c("Restart intent is null!");
            return false;
        }
        try {
            com.uc.crashsdk.a.a.b("restarting ...");
            ((AlarmManager) com.uc.crashsdk.a.g.a().getSystemService("alarm")).set(1, System.currentTimeMillis() + 200, a);
            return true;
        } catch (Throwable th) {
            com.uc.crashsdk.a.g.a(th);
            return false;
        }
    }

    private static int c() {
        FileInputStream fileInputStream;
        Throwable th;
        Exception e;
        File file = new File(b.d());
        int i = -1;
        if (file.exists()) {
            try {
                try {
                    fileInputStream = new FileInputStream(file);
                    try {
                        byte[] bArr = new byte[(int) file.length()];
                        if (fileInputStream.read(bArr) > 0) {
                            i = Integer.parseInt(new String(bArr));
                        }
                    } catch (Exception e2) {
                        e = e2;
                        com.uc.crashsdk.a.g.b(e);
                        com.uc.crashsdk.a.g.a(fileInputStream);
                        return i;
                    }
                } catch (Throwable th2) {
                    th = th2;
                    com.uc.crashsdk.a.g.a(fileInputStream);
                    throw th;
                }
            } catch (Exception e3) {
                fileInputStream = null;
                e = e3;
            } catch (Throwable th3) {
                fileInputStream = null;
                th = th3;
                com.uc.crashsdk.a.g.a(fileInputStream);
                throw th;
            }
            com.uc.crashsdk.a.g.a(fileInputStream);
            return i;
        }
        return -1;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0087 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:41:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static void a(android.content.Context r11) {
        /*
            java.lang.String r0 = "restartBrowser"
            com.uc.crashsdk.a.a.a(r0)
            if (r11 != 0) goto L8
            return
        L8:
            r11 = 0
            int r0 = c()
            long r1 = java.lang.System.currentTimeMillis()
            r3 = 1000(0x3e8, double:4.94E-321)
            long r1 = r1 / r3
            int r5 = com.uc.crashsdk.h.i()
            r6 = 1
            if (r5 < 0) goto L64
            if (r0 <= 0) goto L29
            long r7 = (long) r0
            long r7 = r1 - r7
            int r5 = com.uc.crashsdk.h.i()
            long r9 = (long) r5
            int r5 = (r7 > r9 ? 1 : (r7 == r9 ? 0 : -1))
            if (r5 <= 0) goto L64
        L29:
            long r7 = java.lang.System.currentTimeMillis()
            long r7 = r7 / r3
            com.uc.crashsdk.b.u()
            java.io.File r11 = new java.io.File
            java.lang.String r3 = com.uc.crashsdk.b.d()
            r11.<init>(r3)
            r3 = 0
            java.io.FileOutputStream r4 = new java.io.FileOutputStream     // Catch: java.lang.Throwable -> L55 java.lang.Exception -> L57
            r4.<init>(r11)     // Catch: java.lang.Throwable -> L55 java.lang.Exception -> L57
            java.lang.String r11 = java.lang.String.valueOf(r7)     // Catch: java.lang.Throwable -> L4f java.lang.Exception -> L52
            byte[] r11 = r11.getBytes()     // Catch: java.lang.Throwable -> L4f java.lang.Exception -> L52
            r4.write(r11)     // Catch: java.lang.Throwable -> L4f java.lang.Exception -> L52
            com.uc.crashsdk.a.g.a(r4)
            goto L5e
        L4f:
            r11 = move-exception
            r3 = r4
            goto L60
        L52:
            r11 = move-exception
            r3 = r4
            goto L58
        L55:
            r11 = move-exception
            goto L60
        L57:
            r11 = move-exception
        L58:
            com.uc.crashsdk.a.g.b(r11)     // Catch: java.lang.Throwable -> L55
            com.uc.crashsdk.a.g.a(r3)
        L5e:
            r11 = r6
            goto L64
        L60:
            com.uc.crashsdk.a.g.a(r3)
            throw r11
        L64:
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            java.lang.String r4 = "restartBrowser, lastTime: "
            r3.<init>(r4)
            r3.append(r0)
            java.lang.String r0 = ", currentTime: "
            r3.append(r0)
            r3.append(r1)
            java.lang.String r0 = ", needRestart: "
            r3.append(r0)
            r3.append(r11)
            java.lang.String r0 = r3.toString()
            com.uc.crashsdk.a.a.a(r0)
            if (r11 == 0) goto L92
            com.uc.crashsdk.d.a(r6)     // Catch: java.lang.Throwable -> L8b
            goto L8f
        L8b:
            r11 = move-exception
            com.uc.crashsdk.a.g.a(r11)
        L8f:
            b()
        L92:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.uc.crashsdk.i.a(android.content.Context):void");
    }
}
