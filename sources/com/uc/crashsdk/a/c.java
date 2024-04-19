package com.uc.crashsdk.a;

import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import com.alibaba.sdk.android.oss.common.utils.HttpHeaders;
import com.xiaopeng.libconfig.ipc.IpcConfig;
import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
/* compiled from: ProGuard */
/* loaded from: classes.dex */
public class c {
    static final /* synthetic */ boolean a = !c.class.desiredAssertionStatus();
    private static String b = "";

    public static String a() {
        NetworkInfo c = c();
        if (c == null) {
            return "-1";
        }
        if (c.getType() == 1) {
            return "wifi";
        }
        switch (c.getSubtype()) {
            case 1:
                return "2.5G";
            case 2:
            case 7:
                return "2.75G";
            case 3:
            case 5:
            case 6:
            case 8:
            case 9:
            case 10:
            case 12:
            case 14:
            case 15:
                return "3G";
            case 4:
            case 11:
                return "2G";
            case 13:
                return "4G";
            default:
                String subtypeName = c.getSubtypeName();
                return g.a(subtypeName) ? "0" : (subtypeName.equalsIgnoreCase("TD-SCDMA") || subtypeName.equalsIgnoreCase("WCDMA") || subtypeName.equalsIgnoreCase("CDMA2000")) ? "3G" : subtypeName;
        }
    }

    public static byte[] b() {
        return new byte[]{48, 25, 6, 55};
    }

    private static NetworkInfo c() {
        NetworkInfo[] allNetworkInfo;
        try {
            ConnectivityManager connectivityManager = (ConnectivityManager) g.d("connectivity");
            if (connectivityManager == null) {
                a.c("get CONNECTIVITY_SERVICE is null");
                return null;
            }
            NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
            if ((activeNetworkInfo == null || !activeNetworkInfo.isConnected()) && (allNetworkInfo = connectivityManager.getAllNetworkInfo()) != null) {
                for (int i = 0; i < allNetworkInfo.length; i++) {
                    if (allNetworkInfo[i] != null && allNetworkInfo[i].isConnected()) {
                        return allNetworkInfo[i];
                    }
                }
                return activeNetworkInfo;
            }
            return activeNetworkInfo;
        } catch (Throwable th) {
            g.a(th);
            return null;
        }
    }

    private static boolean b(File file, String str, String str2) {
        try {
            byte[] a2 = a(file);
            if (a2 != null && a2.length != 0) {
                return a(a2, str, str2);
            }
            return false;
        } catch (Exception e) {
            g.a(e);
            return false;
        }
    }

    public static byte[] a(byte[] bArr, byte[] bArr2) {
        return a(bArr, bArr2, true, false);
    }

    public static byte[] a(byte[] bArr, byte[] bArr2, boolean z) {
        return a(bArr, bArr2, z, true);
    }

    private static byte[] a(byte[] bArr, byte[] bArr2, boolean z, boolean z2) {
        IvParameterSpec ivParameterSpec = new IvParameterSpec(new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0});
        SecretKeySpec secretKeySpec = new SecretKeySpec(bArr2, "AES");
        Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
        cipher.init(z ? 1 : 2, secretKeySpec, ivParameterSpec);
        if (z) {
            if (!z2) {
                bArr = a(bArr);
            }
            return cipher.doFinal(bArr);
        }
        return cipher.doFinal(bArr);
    }

    private static byte[] a(byte[] bArr) {
        byte[] bArr2 = new byte[bArr.length + 16];
        int length = bArr.length;
        bArr2[0] = (byte) ((length >> 0) & 255);
        bArr2[1] = (byte) ((length >> 8) & 255);
        bArr2[2] = (byte) ((length >> 16) & 255);
        bArr2[3] = (byte) ((length >> 24) & 255);
        for (int i = 4; i < 16; i++) {
            bArr2[i] = 0;
        }
        System.arraycopy(bArr, 0, bArr2, 16, bArr.length);
        return bArr2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:49:0x0098 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r4v0 */
    /* JADX WARN: Type inference failed for: r4v1, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r4v2 */
    /* JADX WARN: Type inference failed for: r4v3 */
    /* JADX WARN: Type inference failed for: r4v4, types: [java.io.ByteArrayOutputStream, java.io.Closeable] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static byte[] a(java.lang.String r7, byte[] r8) {
        /*
            r0 = 0
            java.net.URL r1 = new java.net.URL     // Catch: java.lang.Throwable -> L89
            r1.<init>(r7)     // Catch: java.lang.Throwable -> L89
            java.net.URLConnection r7 = r1.openConnection()     // Catch: java.lang.Throwable -> L89
            java.net.HttpURLConnection r7 = (java.net.HttpURLConnection) r7     // Catch: java.lang.Throwable -> L89
            r1 = 5000(0x1388, float:7.006E-42)
            r7.setConnectTimeout(r1)     // Catch: java.lang.Throwable -> L87
            r7.setReadTimeout(r1)     // Catch: java.lang.Throwable -> L87
            r1 = 1
            r7.setDoInput(r1)     // Catch: java.lang.Throwable -> L87
            r7.setDoOutput(r1)     // Catch: java.lang.Throwable -> L87
            java.lang.String r1 = "POST"
            r7.setRequestMethod(r1)     // Catch: java.lang.Throwable -> L87
            r1 = 0
            r7.setUseCaches(r1)     // Catch: java.lang.Throwable -> L87
            java.lang.String r2 = "Content-Type"
            java.lang.String r3 = "application/x-www-form-urlencoded"
            r7.setRequestProperty(r2, r3)     // Catch: java.lang.Throwable -> L87
            java.lang.String r2 = "Content-Length"
            int r3 = r8.length     // Catch: java.lang.Throwable -> L87
            java.lang.String r3 = java.lang.String.valueOf(r3)     // Catch: java.lang.Throwable -> L87
            r7.setRequestProperty(r2, r3)     // Catch: java.lang.Throwable -> L87
            java.io.OutputStream r2 = r7.getOutputStream()     // Catch: java.lang.Throwable -> L87
            r2.write(r8)     // Catch: java.lang.Throwable -> L84
            int r8 = r7.getResponseCode()     // Catch: java.lang.Throwable -> L84
            r3 = 200(0xc8, float:2.8E-43)
            if (r8 == r3) goto L53
            com.uc.crashsdk.a.g.a(r2)
            com.uc.crashsdk.a.g.a(r0)
            com.uc.crashsdk.a.g.a(r0)
            if (r7 == 0) goto L52
            r7.disconnect()     // Catch: java.lang.Throwable -> L52
        L52:
            return r0
        L53:
            java.io.InputStream r8 = r7.getInputStream()     // Catch: java.lang.Throwable -> L84
            r3 = 1024(0x400, float:1.435E-42)
            byte[] r3 = new byte[r3]     // Catch: java.lang.Throwable -> L82
            java.io.ByteArrayOutputStream r4 = new java.io.ByteArrayOutputStream     // Catch: java.lang.Throwable -> L82
            int r5 = r8.available()     // Catch: java.lang.Throwable -> L82
            r4.<init>(r5)     // Catch: java.lang.Throwable -> L82
        L64:
            int r5 = r8.read(r3)     // Catch: java.lang.Throwable -> L8d
            r6 = -1
            if (r5 == r6) goto L6f
            r4.write(r3, r1, r5)     // Catch: java.lang.Throwable -> L8d
            goto L64
        L6f:
            byte[] r0 = r4.toByteArray()     // Catch: java.lang.Throwable -> L8d
            com.uc.crashsdk.a.g.a(r2)
            com.uc.crashsdk.a.g.a(r8)
            com.uc.crashsdk.a.g.a(r4)
            if (r7 == 0) goto L81
            r7.disconnect()     // Catch: java.lang.Throwable -> L81
        L81:
            return r0
        L82:
            r4 = r0
            goto L8d
        L84:
            r8 = r0
            r4 = r8
            goto L8d
        L87:
            r8 = r0
            goto L8b
        L89:
            r7 = r0
            r8 = r7
        L8b:
            r2 = r8
            r4 = r2
        L8d:
            com.uc.crashsdk.a.g.a(r2)
            com.uc.crashsdk.a.g.a(r8)
            com.uc.crashsdk.a.g.a(r4)
            if (r7 == 0) goto L9b
            r7.disconnect()     // Catch: java.lang.Throwable -> L9b
        L9b:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.uc.crashsdk.a.c.a(java.lang.String, byte[]):byte[]");
    }

    public static void a(byte[] bArr, int i, byte[] bArr2) {
        if (!a && bArr2.length != 4) {
            throw new AssertionError();
        }
        for (int i2 = 0; i2 < 4; i2++) {
            bArr[i2 + i] = bArr2[i2];
        }
    }

    private static byte[] a(File file) {
        FileInputStream fileInputStream;
        byte[] bArr;
        int length;
        BufferedInputStream bufferedInputStream;
        BufferedInputStream bufferedInputStream2 = null;
        byte[] bArr2 = null;
        bufferedInputStream2 = null;
        bufferedInputStream2 = null;
        bufferedInputStream2 = null;
        if (file.isFile()) {
            try {
                length = (int) file.length();
                fileInputStream = new FileInputStream(file);
                try {
                    try {
                        bufferedInputStream = new BufferedInputStream(fileInputStream);
                    } catch (Exception e) {
                        e = e;
                        bArr = null;
                    }
                } catch (Throwable th) {
                    th = th;
                }
            } catch (Exception e2) {
                e = e2;
                bArr = null;
                fileInputStream = null;
            } catch (Throwable th2) {
                th = th2;
                fileInputStream = null;
            }
            try {
                bArr2 = new byte[length];
                int i = 0;
                while (i < length) {
                    int read = bufferedInputStream.read(bArr2, i, length - i);
                    if (-1 == read) {
                        break;
                    }
                    i += read;
                }
                g.a(bufferedInputStream);
                g.a(fileInputStream);
                return bArr2;
            } catch (Exception e3) {
                e = e3;
                byte[] bArr3 = bArr2;
                bufferedInputStream2 = bufferedInputStream;
                bArr = bArr3;
                g.b(e);
                g.a(bufferedInputStream2);
                g.a(fileInputStream);
                return bArr;
            } catch (Throwable th3) {
                th = th3;
                bufferedInputStream2 = bufferedInputStream;
                g.a(bufferedInputStream2);
                g.a(fileInputStream);
                throw th;
            }
        }
        return null;
    }

    public static boolean a(File file, String str, String str2) {
        for (int i = 0; i < 2; i++) {
            if (b(file, str, str2)) {
                return true;
            }
            a.b("upload try again: " + str);
        }
        return false;
    }

    private static boolean a(byte[] bArr, String str, String str2) {
        InputStream inputStream;
        HttpURLConnection httpURLConnection;
        ByteArrayOutputStream byteArrayOutputStream;
        byte[] byteArray;
        a.a("Uploading to " + str2);
        OutputStream outputStream = null;
        try {
            httpURLConnection = (HttpURLConnection) new URL(str2).openConnection();
            try {
                httpURLConnection.setConnectTimeout(IpcConfig.MessageCenterConfig.IPC_ID_SUBSCRIBE);
                httpURLConnection.setReadTimeout(60000);
                httpURLConnection.setDoInput(true);
                httpURLConnection.setDoOutput(true);
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setUseCaches(false);
                StringBuilder sb = new StringBuilder();
                sb.append("------------izQ290kHh6g3Yn2IeyJCoc\r\n");
                sb.append("Content-Disposition: form-data; name=\"file\";");
                sb.append(" filename=\"");
                sb.append(str);
                sb.append("\"\r\n");
                sb.append("Content-Type: application/octet-stream\r\n");
                sb.append("\r\n");
                httpURLConnection.setRequestProperty("Content-Type", "multipart/form-data; boundary=----------izQ290kHh6g3Yn2IeyJCoc");
                httpURLConnection.setRequestProperty(HttpHeaders.CONTENT_DISPOSITION, "form-data; name=\"file\"; filename=" + str);
                httpURLConnection.setRequestProperty(HttpHeaders.CONTENT_LENGTH, String.valueOf(sb.length() + 40 + bArr.length));
                OutputStream outputStream2 = httpURLConnection.getOutputStream();
                try {
                    outputStream2.write(sb.toString().getBytes());
                    outputStream2.write(bArr);
                    outputStream2.write("\r\n------------izQ290kHh6g3Yn2IeyJCoc--\r\n".getBytes());
                    int responseCode = httpURLConnection.getResponseCode();
                    a.b("Response code: " + responseCode);
                    if (responseCode != 200) {
                        g.a(outputStream2);
                        g.a((Closeable) null);
                        g.a((Closeable) null);
                        if (httpURLConnection != null) {
                            try {
                                httpURLConnection.disconnect();
                            } catch (Throwable unused) {
                            }
                        }
                        return false;
                    }
                    InputStream inputStream2 = httpURLConnection.getInputStream();
                    try {
                        byte[] bArr2 = new byte[1024];
                        byteArrayOutputStream = new ByteArrayOutputStream(inputStream2.available());
                        while (true) {
                            try {
                                int read = inputStream2.read(bArr2);
                                if (read == -1) {
                                    break;
                                }
                                byteArrayOutputStream.write(bArr2, 0, read);
                            } catch (Throwable th) {
                                inputStream = inputStream2;
                                th = th;
                                outputStream = outputStream2;
                                try {
                                    g.b(th);
                                    if (httpURLConnection != null) {
                                        try {
                                            httpURLConnection.disconnect();
                                        } catch (Throwable unused2) {
                                        }
                                    }
                                    return false;
                                } finally {
                                    g.a(outputStream);
                                    g.a(inputStream);
                                    g.a(byteArrayOutputStream);
                                    if (httpURLConnection != null) {
                                        try {
                                            httpURLConnection.disconnect();
                                        } catch (Throwable unused3) {
                                        }
                                    }
                                }
                            }
                        }
                        if (byteArrayOutputStream.toByteArray() != null) {
                            a.b("Log upload response: " + new String(byteArray));
                            g.a(outputStream2);
                            g.a(inputStream2);
                            g.a(byteArrayOutputStream);
                            if (httpURLConnection != null) {
                                try {
                                    httpURLConnection.disconnect();
                                } catch (Throwable unused4) {
                                }
                            }
                            return true;
                        }
                        g.a(outputStream2);
                        g.a(inputStream2);
                        g.a(byteArrayOutputStream);
                        if (httpURLConnection != null) {
                            try {
                                httpURLConnection.disconnect();
                            } catch (Throwable unused5) {
                            }
                        }
                        return false;
                    } catch (Throwable th2) {
                        byteArrayOutputStream = null;
                        outputStream = outputStream2;
                        inputStream = inputStream2;
                        th = th2;
                    }
                } catch (Throwable th3) {
                    th = th3;
                    byteArrayOutputStream = null;
                    outputStream = outputStream2;
                    inputStream = null;
                }
            } catch (Throwable th4) {
                th = th4;
                inputStream = null;
                byteArrayOutputStream = null;
            }
        } catch (Throwable th5) {
            th = th5;
            inputStream = null;
            httpURLConnection = null;
            byteArrayOutputStream = null;
        }
    }
}
