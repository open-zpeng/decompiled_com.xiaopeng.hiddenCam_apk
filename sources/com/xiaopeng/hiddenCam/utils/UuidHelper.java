package com.xiaopeng.hiddenCam.utils;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.OutputStreamWriter;
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class UuidHelper {
    private static final String ksSalt1 = "aEdGX9Ez";
    private static final String ksSalt2 = "tDrFDr2h";
    public static List<String> arr_vins = new ArrayList();
    public static List<String> arr_uuids = new ArrayList();

    public static void Test_vinTxt(String str) {
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(str));
            while (true) {
                String readLine = bufferedReader.readLine();
                if (readLine == null) {
                    break;
                }
                String vin2uuid = vin2uuid(readLine);
                arr_vins.add(readLine);
                arr_uuids.add(vin2uuid);
                LogUtils.e(" uuid vin " + readLine + " uuid: " + vin2uuid);
            }
            bufferedReader.close();
            BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(new File("/mnt/sdcard/test/vin_uuid.txt")), "UTF-8"));
            for (int i = 0; i < arr_uuids.size(); i++) {
                bufferedWriter.write(arr_vins.get(i) + " " + arr_uuids.get(i));
                bufferedWriter.newLine();
                bufferedWriter.flush();
            }
            bufferedWriter.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static String bytesToHexString(byte[] bArr) {
        StringBuilder sb = new StringBuilder();
        if (bArr == null || bArr.length <= 0) {
            return null;
        }
        for (byte b : bArr) {
            String lowerCase = Integer.toHexString(b & 255).toLowerCase();
            if (lowerCase.length() < 2) {
                sb.append(0);
            }
            sb.append(lowerCase);
        }
        return sb.toString();
    }

    public static String encrypt2MD5(String str) {
        try {
            return bytesToHexString(MessageDigest.getInstance("MD5").digest(str.getBytes("utf-8")));
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }

    public static String vin2uuid(String str) {
        String encrypt2MD5 = encrypt2MD5(str + ksSalt1);
        return encrypt2MD5(encrypt2MD5 + ksSalt2).toUpperCase();
    }
}
