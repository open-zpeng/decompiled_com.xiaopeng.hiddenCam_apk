package com.xiaopeng.hiddenCam.utils;

import com.xiaopeng.hiddenCam.bean.DownloadInfo;
import com.xiaopeng.hiddenCam.state.ENUM.APTIPS;
import com.xiaopeng.hiddenCam.state.ENUM.CHARGESTATUS;
import com.xiaopeng.hiddenCam.state.ENUM.DRIVEMODEFB;
import com.xiaopeng.hiddenCam.state.ENUM.YUVPROCSTATUS;
import com.xiaopeng.hiddenCam.state.StateCollection;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileFilter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.CopyOption;
import java.nio.file.Files;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class FileSaver {
    public static boolean is_extrinsic_exist = false;
    public static HashMap<String, DownloadInfo> mapDownloadedInfos = new HashMap<>();

    /* loaded from: classes.dex */
    public static class Constant {
        public static String fix_yuv_prefix1 = "pre1";
        public static String fix_yuv_prefix2 = "pre2";
        public static String fix_yuv_prefix3 = "pre3";
        public static String mnt_full_root = "/mnt/sdcard/fullmap/";
        public static String mnt_root = "/mnt/sdcard/hdmaps/";
        public static String file_root = "/data/data/com.xiaopeng.hiddenCam/files/";
        private static String extrinsic_path = file_root + "extrinsicParam.json";
        public static String pre_env = "/mnt/sdcard/pre_env.ini";
    }

    /* loaded from: classes.dex */
    public static class myFilter2 implements FileFilter {
        @Override // java.io.FileFilter
        public boolean accept(File file) {
            return file.getName().toLowerCase().contains(".tar");
        }
    }

    /* loaded from: classes.dex */
    public static class myFilter4 implements FileFilter {
        @Override // java.io.FileFilter
        public boolean accept(File file) {
            return file.getName().toLowerCase().contains("pre");
        }
    }

    public static void check_before_start() {
        try {
            File file = new File(Constant.file_root);
            if (!file.exists()) {
                file.mkdirs();
            }
            File file2 = new File(Constant.mnt_root);
            if (!file2.exists()) {
                file2.mkdirs();
            }
            File file3 = new File(Constant.mnt_full_root);
            if (!file3.exists()) {
                file3.mkdirs();
            }
            LogUtils.d("[chamo] check_before_start   22222 = ");
            File[] listFiles = new File(Constant.file_root).listFiles(new myFilter4());
            if (listFiles != null && listFiles.length > 0) {
                for (File file4 : listFiles) {
                    String str = file4.getAbsolutePath() + "/raw_data/";
                    if (!is_chamobin_exists(str)) {
                        if (file4.getAbsolutePath().contains("pre1")) {
                            LogUtils.i(" del folder: " + str);
                            deleteDir(file4.getAbsolutePath());
                        } else if (file4.getAbsolutePath().contains("pre3") && StateCollection.getInstance().getYuv_out_proc_status() == YUVPROCSTATUS.INITIAL) {
                            LogUtils.i(" del folder: " + str);
                            deleteDir(file4.getAbsolutePath());
                        } else if (file4.getAbsolutePath().contains("pre2")) {
                            LogUtils.i(" del folder: " + str);
                            deleteDir(file4.getAbsolutePath());
                        }
                    }
                }
            }
            File[] listFiles2 = new File(Constant.file_root).listFiles(new myFilter2());
            if (listFiles2 != null && listFiles2.length > 5) {
                for (File file5 : listFiles2) {
                    file5.delete();
                }
            }
            LogUtils.e("[chamo] rmfiletag = ");
            rmFilesWithTag(Constant.mnt_full_root, "Venue");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static boolean check_extrinsic_exist() {
        if (new File(Constant.extrinsic_path).exists()) {
            is_extrinsic_exist = true;
        } else {
            is_extrinsic_exist = false;
        }
        return is_extrinsic_exist;
    }

    public static void check_hdmap_complete() {
        try {
            String str = Constant.mnt_root + "updateList.json";
            String str2 = Constant.mnt_root + "updateList_raw.json";
            File file = new File(str);
            LogUtils.i("kdkdkdkdkd: " + str);
            if (file.exists()) {
                boolean z = true;
                FileInputStream fileInputStream = new FileInputStream(str);
                byte[] bArr = new byte[fileInputStream.available()];
                fileInputStream.read(bArr);
                fileInputStream.close();
                Iterator<String> keys = new JSONObject(new String(bArr, "UTF-8")).keys();
                while (keys.hasNext()) {
                    if (!new File(Constant.mnt_root + (keys.next() + ".json")).exists()) {
                        z = false;
                    }
                }
                if (z) {
                    return;
                }
                LogUtils.i(" del file: " + str);
                File file2 = new File(str);
                File file3 = new File(str2);
                file2.delete();
                if (file3.exists()) {
                    file3.delete();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static boolean check_save_car_in_info_exist() {
        StringBuilder sb = new StringBuilder();
        sb.append(Constant.file_root);
        sb.append("save_car_in_info.txt");
        return new File(sb.toString()).exists();
    }

    public static void copy(String str, String str2) {
        try {
            FileInputStream fileInputStream = new FileInputStream(str);
            FileOutputStream fileOutputStream = new FileOutputStream(str2);
            byte[] bArr = new byte[1024];
            while (true) {
                int read = fileInputStream.read(bArr);
                if (read > 0) {
                    fileOutputStream.write(bArr, 0, read);
                } else {
                    fileOutputStream.close();
                    fileInputStream.close();
                    return;
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e2) {
            e2.printStackTrace();
        }
    }

    public static void copyAvmInfo(String str, String str2, byte[] bArr) {
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(str + str2, true);
            try {
                fileOutputStream.write(bArr);
                fileOutputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (FileNotFoundException e2) {
            e2.printStackTrace();
        }
    }

    public static void deleteDir(String str) {
        if (str == "") {
            return;
        }
        try {
            File file = new File(str);
            if (file.isFile()) {
                file.delete();
                return;
            }
            File[] listFiles = file.listFiles();
            if (listFiles == null) {
                file.delete();
                return;
            }
            for (File file2 : listFiles) {
                deleteDir(file2.getAbsolutePath());
            }
            file.delete();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void deleteYuv(String str) {
        try {
            File[] listFiles = new File(str).listFiles();
            if (listFiles == null) {
                return;
            }
            for (int i = 0; i < listFiles.length; i++) {
                if (listFiles[i].isFile() && listFiles[i].getName().contains("_.yuv")) {
                    listFiles[i].delete();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void delete_save_car_info() {
        LogUtils.e(" delete_save_car_info ");
        File file = new File(Constant.file_root + "save_car_in_info.txt");
        if (file.exists()) {
            file.delete();
        }
    }

    public static String getLastPathComponent(String str) {
        String[] split = str.split("/");
        return split.length == 0 ? "" : split[split.length - 1];
    }

    public static String getModifiedDate(String str) {
        File file = new File(str);
        if (!file.exists()) {
            LogUtils.e("[chamo] chamo bin not exists! " + str);
            return "";
        }
        return new SimpleDateFormat("dd-MM-yyyy-HH-mm-ss").format(new Date(Long.valueOf(file.lastModified()).longValue()));
    }

    public static List<String> get_pre_folder() {
        File[] listFiles = new File(Constant.file_root).listFiles(new myFilter4());
        ArrayList arrayList = new ArrayList();
        if (listFiles != null) {
            if (listFiles.length > 0) {
                Collections.sort(Arrays.asList(listFiles), new Comparator<File>() { // from class: com.xiaopeng.hiddenCam.utils.FileSaver.1
                    @Override // java.util.Comparator
                    public int compare(File file, File file2) {
                        return file.getName().compareTo(file2.getName());
                    }
                });
            }
            for (File file : listFiles) {
                arrayList.add(file.getName());
            }
        }
        return arrayList;
    }

    public static boolean is_chamobin_exists(String str) {
        return new File(str + "chamo.bin").exists();
    }

    public static void loadDownloadedInfo() {
        try {
            String str = Constant.file_root + "downloaded_info.json";
            File file = new File(str);
            LogUtils.d("kdkdkdkdkd: " + str);
            if (file.exists()) {
                FileInputStream fileInputStream = new FileInputStream(str);
                int available = fileInputStream.available();
                byte[] bArr = new byte[available];
                fileInputStream.read(bArr);
                fileInputStream.close();
                JSONObject jSONObject = new JSONObject(new String(bArr, "UTF-8"));
                Iterator<String> keys = jSONObject.keys();
                LogUtils.d("rtrtrtrrtr: " + available);
                while (keys.hasNext()) {
                    String next = keys.next();
                    LogUtils.d("download key: " + next);
                    JSONObject jSONObject2 = jSONObject.getJSONObject(next);
                    DownloadInfo downloadInfo = new DownloadInfo();
                    downloadInfo.update_time = jSONObject2.getLong("update_time");
                    downloadInfo.eval = jSONObject2.getInt("eval");
                    mapDownloadedInfos.put(next, downloadInfo);
                }
                LogUtils.d("load downloadinfo file successfully! size = " + mapDownloadedInfos.size());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void mkdirs(String str) {
        File file = new File(str);
        if (!file.exists()) {
            file.mkdirs();
        }
        File file2 = new File(str + "/raw_data");
        if (file2.exists()) {
            return;
        }
        file2.mkdirs();
    }

    public static String read_car_in_info() {
        String str = Constant.file_root + "save_car_in_info.txt";
        if (new File(str).exists()) {
            StringBuffer stringBuffer = new StringBuffer();
            try {
                FileInputStream fileInputStream = new FileInputStream(str);
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(fileInputStream));
                for (String readLine = bufferedReader.readLine(); readLine != null; readLine = bufferedReader.readLine()) {
                    stringBuffer.append(readLine);
                    stringBuffer.append("\n");
                }
                bufferedReader.close();
                fileInputStream.close();
                return stringBuffer.toString();
            } catch (FileNotFoundException e) {
                LogUtils.e(e.getMessage());
                return "";
            } catch (IOException e2) {
                LogUtils.e(e2.getMessage());
                return "";
            }
        }
        return "";
    }

    public static boolean renameFile(String str, String str2) {
        File file = new File(str);
        if (!file.exists()) {
            LogUtils.e(" not exist: " + str);
            return false;
        }
        try {
            Files.move(file.toPath(), new File(str2).toPath(), new CopyOption[0]);
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            LogUtils.e("cannot rename file " + str2);
            return false;
        }
    }

    public static void resetMap(StateCollection stateCollection) {
        stateCollection.setDrive_mode_fb(DRIVEMODEFB.INITIAL.value);
        stateCollection.setAp_tips_(APTIPS.INITIAL.value);
        stateCollection.setIshdmap_(-1);
        stateCollection.setXpu_map_time_(0L);
        stateCollection.setLast_pk_map_id(0);
        stateCollection.setCharge_status(CHARGESTATUS.INITIAL.value);
        stateCollection.setStudy_map_name("");
    }

    public static void rmFilesWithTag(String str, String str2) {
        try {
            LogUtils.e("rmFilesWithTag: dir = " + str + " tag = " + str2);
            File[] listFiles = new File(str).listFiles();
            if (listFiles != null) {
                for (int i = 0; i < listFiles.length; i++) {
                    if (listFiles[i].isFile() && listFiles[i].getName().contains(str2)) {
                        listFiles[i].delete();
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void rmOldVerListF(final String str) {
        try {
            LogUtils.e("rmOldVerListF: 3333ver = " + str);
            File[] listFiles = new File(Constant.mnt_full_root).listFiles(new FileFilter() { // from class: com.xiaopeng.hiddenCam.utils.FileSaver.2
                @Override // java.io.FileFilter
                public boolean accept(File file) {
                    String name = file.getName();
                    if (name.contains("listF")) {
                        LogUtils.e("filename2222: " + name);
                        if (!name.contains(str) && !name.contains("listF.json")) {
                            return true;
                        }
                    }
                    return false;
                }
            });
            if (listFiles != null) {
                for (File file : listFiles) {
                    file.delete();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void save(String str, String str2) {
        if (str == "") {
            return;
        }
        copy(Constant.file_root + "config.json", str2 + "/config.json");
        copy(Constant.file_root + "downloaded_info.json", str2 + "/downloaded_info.json");
        zipFileAtPath(str2 + "/", Constant.file_root + str);
        deleteDir(Constant.file_root + str2);
    }

    public static void save4upload(String str, StateCollection stateCollection) {
        try {
            LogUtils.d("[chamo] ready to save to upload bin ");
            String modifiedDate = getModifiedDate(Constant.file_root + str + "/raw_data/chamo.bin");
            boolean contains = str.contains("pre1");
            if (modifiedDate == "") {
                LogUtils.e("[chamo] chamo bin doesn't exist, check what happend ");
                if (contains) {
                    resetMap(stateCollection);
                    return;
                }
                return;
            }
            LogUtils.d("[chamo] upload_path: " + str);
            String str2 = modifiedDate + "_" + stateCollection.getVinCode() + "_upload.tar";
            String valueOf = String.valueOf(stateCollection.getTbox_rsrp());
            if (str.contains("pre2")) {
                str2 = modifiedDate + "_" + stateCollection.getVinCode() + "_upload_on.tar";
            }
            save_car_info(((((((((((("{\"version_id\": \"" + y3.a + "\",") + "\"car_type\": " + String.valueOf(stateCollection.getCarType()) + ",") + "\"cfc_value\": " + String.valueOf(stateCollection.getCfc()) + ",") + "\"rand_re\": " + String.valueOf(stateCollection.isAllow_to_open()) + ",") + "\"AP_MODE\": " + String.valueOf(stateCollection.getDrive_mode_fb()) + ",") + "\"Study Mode\": " + String.valueOf(stateCollection.getAp_tips_()) + ",") + "\"ChargeSt\": " + String.valueOf(stateCollection.getCharge_status()) + ",") + "\"tbox_rsrp\": " + valueOf + ",") + "\"map_type\": " + String.valueOf(stateCollection.getIshdmap_()) + ",") + "\"maptime\": " + String.valueOf(stateCollection.getXpu_map_time_()) + ",") + "\"map_id\": " + String.valueOf(stateCollection.getLast_pk_map_id())) + "}", Constant.file_root + str + "/raw_data/");
            if (x3.l != 0) {
                if (new File(Constant.file_root + "extrinsicParam.json").exists()) {
                    copy(Constant.file_root + "extrinsicParam.json", Constant.file_root + str + "/raw_data/extrinsicParam.json");
                }
            }
            if (stateCollection.getDrive_mode_fb() == 1) {
                LogUtils.d("[chamo save] wait 3 sec");
                Thread.sleep(3000L);
            }
            save(str2, Constant.file_root + str + "/raw_data");
            if (true == contains) {
                resetMap(stateCollection);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void saveDownloadedInfo() {
        try {
            if (mapDownloadedInfos.size() < 1) {
                return;
            }
            LogUtils.e("Start to proceed the Download info!");
            String str = Constant.file_root + "downloaded_info.json";
            JSONObject jSONObject = new JSONObject();
            for (String str2 : mapDownloadedInfos.keySet()) {
                int i = mapDownloadedInfos.get(str2).eval;
                long j = mapDownloadedInfos.get(str2).update_time;
                LogUtils.d("map_name = " + str2);
                LogUtils.d("eval_info = " + i);
                LogUtils.d("update_time = " + j);
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("eval", i);
                jSONObject2.put("update_time", j);
                jSONObject.put(str2, jSONObject2);
            }
            FileOutputStream fileOutputStream = new FileOutputStream(str);
            fileOutputStream.write(jSONObject.toString().getBytes("UTF-8"));
            fileOutputStream.flush();
            fileOutputStream.close();
        } catch (Exception e) {
            LogUtils.e("process Download info error!");
            e.printStackTrace();
        }
    }

    public static void save_car_in_info(String str) {
        writeTextToFile(str, Constant.file_root + "save_car_in_info.txt");
    }

    public static void save_car_info(String str, String str2) {
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(str2 + "car_info_e28.txt", false);
            try {
                fileOutputStream.write(str.getBytes());
                fileOutputStream.close();
                LogUtils.i(" save car info succeed ");
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (FileNotFoundException e2) {
            e2.printStackTrace();
        }
    }

    public static boolean save_evaluation_info(String str, String str2, int i, int i2, long j) {
        if (!new File(str).exists()) {
            LogUtils.e(" not exist: " + str);
            return false;
        } else if (i2 < 2) {
            LogUtils.e("evaluation maptype wrong: " + i2);
            return false;
        } else {
            try {
                String str3 = (((("{\"mapid\": \"" + str2 + "\",") + "\"maptime\": " + String.valueOf(j) + ",") + "\"maptype\": " + String.valueOf(i2) + ",") + "\"evaluation\": " + String.valueOf(i)) + "}";
                FileOutputStream fileOutputStream = new FileOutputStream(str + "share_info.txt", false);
                try {
                    fileOutputStream.write(str3.getBytes());
                    fileOutputStream.close();
                    LogUtils.d(" save share_info.txt succeed ");
                } catch (IOException e) {
                    e.printStackTrace();
                }
                return true;
            } catch (FileNotFoundException e2) {
                e2.printStackTrace();
                return true;
            }
        }
    }

    public static boolean save_share_info(String str, List<Integer> list, int i, long j) {
        if (!new File(str).exists()) {
            LogUtils.e(" not exist: " + str);
            return false;
        }
        try {
            int size = list.size();
            String str2 = (("{\"maptime\": " + j + ",") + "\"floor\": " + i + ",") + "\"destination\": [";
            for (int i2 = 0; i2 < size; i2++) {
                str2 = i2 != size - 1 ? str2 + String.valueOf(list.get(i2)) + "," : str2 + String.valueOf(list.get(i2));
            }
            String str3 = (str2 + "]") + "}";
            FileOutputStream fileOutputStream = new FileOutputStream(str + "share_info.txt", false);
            try {
                fileOutputStream.write(str3.getBytes());
                fileOutputStream.close();
                LogUtils.d(" save share_info.txt succeed ");
                return true;
            } catch (IOException e) {
                e.printStackTrace();
                return true;
            }
        } catch (FileNotFoundException e2) {
            e2.printStackTrace();
            return true;
        }
    }

    public static void unzip(String str, String str2) {
        if (str2 == null) {
            return;
        }
        LogUtils.i(" zip file = " + str + " output path = " + str2);
        byte[] bArr = new byte[1024];
        try {
            ZipInputStream zipInputStream = new ZipInputStream(new FileInputStream(str));
            ZipEntry nextEntry = zipInputStream.getNextEntry();
            while (nextEntry != null) {
                String name = nextEntry.getName();
                if (!name.contains("/")) {
                    LogUtils.i("ze name = " + name);
                    File file = new File(str2);
                    if (!nextEntry.isDirectory()) {
                        FileOutputStream fileOutputStream = new FileOutputStream(file);
                        while (true) {
                            int read = zipInputStream.read(bArr);
                            if (read == -1) {
                                break;
                            }
                            fileOutputStream.write(bArr, 0, read);
                        }
                        fileOutputStream.close();
                    }
                    nextEntry = zipInputStream.getNextEntry();
                }
            }
            zipInputStream.closeEntry();
            zipInputStream.close();
        } catch (FileNotFoundException e) {
            LogUtils.i(" something wrong happend111");
            e.printStackTrace();
        } catch (IOException e2) {
            LogUtils.i(" something wrong happend222");
            e2.printStackTrace();
        }
    }

    public static void writeTextToFile(String str, String str2) {
        try {
            File file = new File(str2);
            if (file.exists()) {
                file.delete();
                file.createNewFile();
            }
            FileOutputStream fileOutputStream = new FileOutputStream(str2, false);
            try {
                fileOutputStream.write(str.getBytes());
                fileOutputStream.close();
                LogUtils.i(" save text to file succeed ");
            } catch (IOException e) {
                LogUtils.e(e.getMessage());
            }
        } catch (FileNotFoundException e2) {
            LogUtils.e(e2.getMessage());
        } catch (IOException e3) {
            LogUtils.e(e3.getMessage());
        }
    }

    public static boolean zipFileAtPath(String str, String str2) {
        File file = new File(str);
        try {
            ZipOutputStream zipOutputStream = new ZipOutputStream(new BufferedOutputStream(new FileOutputStream(str2)));
            if (file.isDirectory()) {
                zipSubFolder(zipOutputStream, file, file.getParent().length());
            } else {
                byte[] bArr = new byte[2196608];
                BufferedInputStream bufferedInputStream = new BufferedInputStream(new FileInputStream(str), 2196608);
                ZipEntry zipEntry = new ZipEntry(getLastPathComponent(str));
                zipEntry.setTime(file.lastModified());
                zipOutputStream.putNextEntry(zipEntry);
                while (true) {
                    int read = bufferedInputStream.read(bArr, 0, 2196608);
                    if (read == -1) {
                        break;
                    }
                    zipOutputStream.write(bArr, 0, read);
                }
            }
            zipOutputStream.close();
            LogUtils.i(" llldllddldldldl finish tar" + str2);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    private static void zipSubFolder(ZipOutputStream zipOutputStream, File file, int i) throws IOException {
        try {
            File[] listFiles = file.listFiles();
            if (listFiles == null) {
                return;
            }
            for (File file2 : listFiles) {
                if (file2.isDirectory()) {
                    zipSubFolder(zipOutputStream, file2, i);
                } else {
                    byte[] bArr = new byte[2048];
                    String path = file2.getPath();
                    String substring = path.substring(i);
                    BufferedInputStream bufferedInputStream = new BufferedInputStream(new FileInputStream(path), 2048);
                    ZipEntry zipEntry = new ZipEntry(substring);
                    zipEntry.setTime(file2.lastModified());
                    zipOutputStream.putNextEntry(zipEntry);
                    while (true) {
                        int read = bufferedInputStream.read(bArr, 0, 2048);
                        if (read == -1) {
                            break;
                        }
                        zipOutputStream.write(bArr, 0, read);
                    }
                    bufferedInputStream.close();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
