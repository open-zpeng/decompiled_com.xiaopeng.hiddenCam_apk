package com.uc.crashsdk.a;

import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
/* compiled from: ProGuard */
/* loaded from: classes.dex */
public final class b {
    private static final int[] a = {126, 147, 115, 241, 101, 198, 215, 134};
    private static final int[] b = {125, 185, 233, 226, 129, 142, 151, 176};
    private static final int[] c = {238, 185, 233, 179, 129, 142, 151, 167};

    public static String a(String str) {
        FileInputStream fileInputStream;
        FileInputStream fileInputStream2;
        File file = new File(str);
        FileInputStream fileInputStream3 = null;
        if (file.exists()) {
            try {
                fileInputStream2 = new FileInputStream(file);
            } catch (Exception e) {
                e = e;
                fileInputStream = null;
            } catch (Throwable th) {
                th = th;
            }
            try {
                byte[] bArr = new byte[(int) file.length()];
                fileInputStream2.read(bArr);
                g.a(fileInputStream2);
                byte[] a2 = a(bArr, a);
                if (a2 == null || a2.length <= 0) {
                    g.a((Closeable) null);
                    return null;
                }
                int length = a2.length - 1;
                String str2 = a2[length] == 10 ? new String(a2, 0, length) : new String(a2);
                g.a((Closeable) null);
                return str2;
            } catch (Exception e2) {
                fileInputStream = fileInputStream2;
                e = e2;
                try {
                    g.a(e);
                    g.a(fileInputStream);
                    return null;
                } catch (Throwable th2) {
                    th = th2;
                    fileInputStream3 = fileInputStream;
                    g.a(fileInputStream3);
                    throw th;
                }
            } catch (Throwable th3) {
                fileInputStream3 = fileInputStream2;
                th = th3;
                g.a(fileInputStream3);
                throw th;
            }
        }
        return null;
    }

    private static byte[] b(byte[] bArr, int[] iArr) {
        if (bArr != null && iArr != null && iArr.length == 8) {
            int length = bArr.length;
            try {
                byte[] bArr2 = new byte[length + 2];
                byte b2 = 0;
                for (int i = 0; i < length; i++) {
                    byte b3 = bArr[i];
                    bArr2[i] = (byte) (iArr[i % 8] ^ b3);
                    b2 = (byte) (b2 ^ b3);
                }
                bArr2[length] = (byte) (iArr[0] ^ b2);
                bArr2[length + 1] = (byte) (iArr[1] ^ b2);
                return bArr2;
            } catch (Exception e) {
                g.a(e);
            }
        }
        return null;
    }

    private static byte[] a(File file) {
        FileInputStream fileInputStream;
        if (!file.exists()) {
            return null;
        }
        try {
            byte[] bArr = new byte[(int) file.length()];
            fileInputStream = new FileInputStream(file);
            try {
                fileInputStream.read(bArr);
                return bArr;
            } catch (Throwable th) {
                th = th;
                try {
                    g.a(th);
                    return null;
                } finally {
                    g.a(fileInputStream);
                }
            }
        } catch (Throwable th2) {
            th = th2;
            fileInputStream = null;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:12:0x0022, code lost:
        r1 = a(r0);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static java.lang.String a(java.lang.String r7, java.lang.String r8, boolean r9) {
        /*
            if (r9 != 0) goto L3
            return r7
        L3:
            boolean r0 = com.uc.crashsdk.a.g.a(r7)
            if (r0 == 0) goto La
            return r7
        La:
            java.io.File r0 = new java.io.File
            r0.<init>(r7)
            boolean r1 = r0.exists()
            if (r1 == 0) goto Lc4
            long r1 = r0.length()
            r3 = 3145728(0x300000, double:1.554196E-317)
            int r1 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r1 <= 0) goto L22
            goto Lc4
        L22:
            byte[] r1 = a(r0)
            if (r1 == 0) goto Lc4
            int r2 = r1.length
            if (r2 > 0) goto L2d
            goto Lc4
        L2d:
            r2 = 1
            r3 = 0
            if (r9 == 0) goto L89
            r9 = 0
            java.io.ByteArrayOutputStream r4 = new java.io.ByteArrayOutputStream     // Catch: java.lang.Throwable -> L50
            r4.<init>()     // Catch: java.lang.Throwable -> L50
            java.util.zip.GZIPOutputStream r5 = new java.util.zip.GZIPOutputStream     // Catch: java.lang.Throwable -> L4b
            r5.<init>(r4)     // Catch: java.lang.Throwable -> L4b
            r5.write(r1)     // Catch: java.lang.Throwable -> L49
            r4.flush()     // Catch: java.lang.Throwable -> L49
            com.uc.crashsdk.a.g.a(r4)
        L45:
            com.uc.crashsdk.a.g.a(r5)
            goto L5b
        L49:
            r9 = move-exception
            goto L54
        L4b:
            r5 = move-exception
            r6 = r5
            r5 = r9
            r9 = r6
            goto L54
        L50:
            r4 = move-exception
            r5 = r9
            r9 = r4
            r4 = r5
        L54:
            com.uc.crashsdk.a.g.a(r9)     // Catch: java.lang.Throwable -> L81
            com.uc.crashsdk.a.g.a(r4)
            goto L45
        L5b:
            byte[] r1 = r4.toByteArray()     // Catch: java.lang.Throwable -> L61
            r9 = r2
            goto L66
        L61:
            r9 = move-exception
            com.uc.crashsdk.a.g.a(r9)
            r9 = r3
        L66:
            if (r9 == 0) goto L80
            if (r1 == 0) goto L80
            int r9 = r1.length
            if (r9 > 0) goto L6e
            goto L80
        L6e:
            java.lang.StringBuilder r9 = new java.lang.StringBuilder
            r9.<init>()
            r9.append(r7)
            r9.append(r8)
            java.lang.String r8 = r9.toString()
            r9 = r8
            r8 = r2
            goto L8b
        L80:
            return r7
        L81:
            r7 = move-exception
            com.uc.crashsdk.a.g.a(r4)
            com.uc.crashsdk.a.g.a(r5)
            throw r7
        L89:
            r9 = r7
            r8 = r3
        L8b:
            if (r8 == 0) goto Lc4
            java.lang.String r8 = r0.getName()
            boolean r8 = r9.equals(r8)
            if (r8 == 0) goto Laa
            java.lang.StringBuilder r8 = new java.lang.StringBuilder
            r8.<init>()
            r8.append(r9)
            java.lang.String r4 = ".tmp"
            r8.append(r4)
            java.lang.String r8 = r8.toString()
            r4 = r2
            goto Lac
        Laa:
            r8 = r9
            r4 = r3
        Lac:
            java.io.File r5 = new java.io.File
            r5.<init>(r8)
            boolean r8 = com.uc.crashsdk.a.g.a(r5, r1)
            if (r8 != 0) goto Lb9
            r2 = r3
            goto Lc1
        Lb9:
            if (r4 == 0) goto Lc1
            r0.delete()
            r5.renameTo(r0)
        Lc1:
            if (r2 == 0) goto Lc4
            return r9
        Lc4:
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.uc.crashsdk.a.b.a(java.lang.String, java.lang.String, boolean):java.lang.String");
    }

    private static byte[] a(byte[] bArr, int[] iArr) {
        if (bArr.length - 0 >= 2 && iArr != null && iArr.length == 8) {
            int length = (bArr.length - 2) - 0;
            try {
                byte[] bArr2 = new byte[length];
                byte b2 = 0;
                for (int i = 0; i < length; i++) {
                    byte b3 = (byte) (bArr[i + 0] ^ iArr[i % 8]);
                    bArr2[i] = b3;
                    b2 = (byte) (b2 ^ b3);
                }
                if (bArr[length + 0] == ((byte) ((iArr[0] ^ b2) & 255)) && bArr[length + 1 + 0] == ((byte) ((iArr[1] ^ b2) & 255))) {
                    return bArr2;
                }
                return null;
            } catch (Exception e) {
                g.a(e);
            }
        }
        return null;
    }

    public static boolean a(String str, String str2) {
        FileOutputStream fileOutputStream;
        try {
            File file = new File(str);
            if (file.exists()) {
                file.delete();
            }
            fileOutputStream = new FileOutputStream(file);
        } catch (Throwable th) {
            g.a(th);
            fileOutputStream = null;
        }
        boolean z = false;
        if (fileOutputStream == null) {
            return false;
        }
        byte[] b2 = b(str2.getBytes(), a);
        if (b2 == null) {
            return false;
        }
        try {
            fileOutputStream.write(b2);
            z = true;
        } finally {
            try {
                return z;
            } finally {
            }
        }
        return z;
    }
}
