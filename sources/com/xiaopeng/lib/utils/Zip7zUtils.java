package com.xiaopeng.lib.utils;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import org.apache.commons.compress.archivers.sevenz.h;
/* loaded from: classes.dex */
public class Zip7zUtils {
    public static void zip7z(String str, String str2) {
        File file;
        h hVar;
        h hVar2 = null;
        try {
            try {
                File file2 = new File(str2);
                file = new File(str);
                hVar = new h(file2);
            } catch (Throwable th) {
                th = th;
            }
        } catch (IOException e) {
            e = e;
        }
        try {
            if (file.isDirectory()) {
                zip7zDirectory(file, hVar, "");
            } else {
                zip7zFile(file, hVar, "");
            }
            FileUtils.closeQuietly(hVar);
        } catch (IOException e2) {
            e = e2;
            hVar2 = hVar;
            System.out.println(e.toString());
            FileUtils.closeQuietly(hVar2);
        } catch (Throwable th2) {
            th = th2;
            hVar2 = hVar;
            FileUtils.closeQuietly(hVar2);
            throw th;
        }
    }

    private static void zip7zDirectory(File file, h hVar, String str) throws IOException {
        File[] listFiles = file.listFiles();
        if (listFiles == null || listFiles.length <= 0) {
            return;
        }
        for (File file2 : listFiles) {
            if (file2.isDirectory()) {
                zip7zDirectory(file2, hVar, str + file2.getName() + "/");
            } else {
                zip7zFile(file2, hVar, str);
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static void zip7zFile(File file, h hVar, String str) throws IOException {
        BufferedInputStream bufferedInputStream;
        BufferedInputStream bufferedInputStream2 = null;
        try {
            try {
                bufferedInputStream = new BufferedInputStream(new FileInputStream(file));
            } catch (Throwable th) {
                th = th;
                bufferedInputStream = bufferedInputStream2;
            }
        } catch (FileNotFoundException e) {
            e = e;
        } catch (IOException e2) {
            e = e2;
        }
        try {
            StringBuilder sb = new StringBuilder();
            sb.append(str);
            sb.append(file.getName());
            hVar.a((e5) hVar.a(file, sb.toString()));
            byte[] bArr = new byte[4096];
            BufferedInputStream bufferedInputStream3 = sb;
            while (true) {
                int read = bufferedInputStream.read(bArr);
                if (read <= 0) {
                    break;
                }
                bufferedInputStream3 = null;
                hVar.write(bArr, 0, read);
            }
            FileUtils.closeQuietly(bufferedInputStream);
            bufferedInputStream2 = bufferedInputStream3;
            if (hVar == null) {
                return;
            }
        } catch (FileNotFoundException e3) {
            e = e3;
            bufferedInputStream2 = bufferedInputStream;
            e.printStackTrace();
            FileUtils.closeQuietly(bufferedInputStream2);
            bufferedInputStream2 = bufferedInputStream2;
            if (hVar == null) {
                return;
            }
            hVar.a();
        } catch (IOException e4) {
            e = e4;
            bufferedInputStream2 = bufferedInputStream;
            e.printStackTrace();
            FileUtils.closeQuietly(bufferedInputStream2);
            bufferedInputStream2 = bufferedInputStream2;
            if (hVar == null) {
                return;
            }
            hVar.a();
        } catch (Throwable th2) {
            th = th2;
            FileUtils.closeQuietly(bufferedInputStream);
            if (hVar != null) {
                hVar.a();
            }
            throw th;
        }
        hVar.a();
    }
}
