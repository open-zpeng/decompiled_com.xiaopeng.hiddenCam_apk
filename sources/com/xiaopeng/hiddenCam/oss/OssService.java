package com.xiaopeng.hiddenCam.oss;

import android.content.Context;
import android.content.Intent;
import com.alibaba.sdk.android.oss.ClientConfiguration;
import com.alibaba.sdk.android.oss.ClientException;
import com.alibaba.sdk.android.oss.OSS;
import com.alibaba.sdk.android.oss.OSSClient;
import com.alibaba.sdk.android.oss.ServiceException;
import com.alibaba.sdk.android.oss.callback.OSSCompletedCallback;
import com.alibaba.sdk.android.oss.common.OSSLog;
import com.alibaba.sdk.android.oss.common.auth.OSSPlainTextAKSKCredentialProvider;
import com.alibaba.sdk.android.oss.model.GetObjectRequest;
import com.alibaba.sdk.android.oss.model.GetObjectResult;
import com.alibaba.sdk.android.oss.model.OSSRequest;
import com.alibaba.sdk.android.oss.model.PutObjectRequest;
import com.alibaba.sdk.android.oss.model.PutObjectResult;
import com.xiaopeng.hiddenCam.state.StateCollection;
import com.xiaopeng.hiddenCam.utils.FileSaver;
import com.xiaopeng.hiddenCam.utils.LogUtils;
import com.xiaopeng.lib.utils.config.CommonConfig;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
/* loaded from: classes.dex */
public class OssService extends com.xiaopeng.hiddenCam.oss.a {
    public static String t = "/mnt/sdcard/fullmap/";
    private String b;
    private String c;
    private String d;
    private String e;
    private String f;
    private Context g;
    public String h = "";
    public String i = "hdmap_config/config.bin";
    public String j = "hdmap_config/local_config/";
    public String k = "data/data/com.xiaopeng.hiddenCam/files";
    public String l = "ap_ota4";
    public String m = "ws_ap_ota4/map/";
    public String n = "maps";
    public String o = this.k + "/config.json";
    public String p = "temp_cache_";
    private HashMap<Integer, OSS> q = new HashMap<>();
    private HashMap<Integer, String> r = new HashMap<>();
    public static String s = "/mnt/sdcard/hdmaps/";
    public static String u = s + "garage_list.csv";

    public OssService() {
        r0 = this.n + "/garage_list.csv";
    }

    private int c() {
        int size;
        synchronized (OssService.class) {
            OSSPlainTextAKSKCredentialProvider oSSPlainTextAKSKCredentialProvider = new OSSPlainTextAKSKCredentialProvider(this.b, this.d);
            ClientConfiguration clientConfiguration = new ClientConfiguration();
            clientConfiguration.setConnectionTimeout(60000);
            clientConfiguration.setSocketTimeout(60000);
            clientConfiguration.setMaxConcurrentRequest(10);
            clientConfiguration.setMaxErrorRetry(1);
            OSSClient oSSClient = new OSSClient(this.g, this.e, oSSPlainTextAKSKCredentialProvider, clientConfiguration);
            size = this.q.size();
            this.q.put(Integer.valueOf(size), oSSClient);
            LogUtils.d(" map size: " + this.q.size());
        }
        return size;
    }

    public void b(String str, int i) {
        int c = c();
        LogUtils.i("fetch remote config");
        String str2 = this.j + "config_" + str + ".bin";
        if (a(str2, c)) {
            LogUtils.i("fetch local config");
            a(str2, this.o, "action.reload.config", c, 2, new long[0]);
            return;
        }
        LogUtils.i("fetch common config");
        this.i = "hdmap_config/config_" + this.r.get(Integer.valueOf(i)) + ".bin";
        a(this.i, this.o, "action.reload.config", c, 1, new long[0]);
    }

    public void d(String str) {
        this.d = str;
    }

    public void e(String str) {
        this.c = str;
    }

    public void f(String str) {
        this.e = str;
    }

    public void g(String str) {
        this.f = str;
    }

    public void h(String str) {
        this.p = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i) {
        synchronized (OssService.class) {
            LogUtils.d("remove map:" + i);
            this.q.remove(Integer.valueOf(i));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class b implements OSSCompletedCallback<PutObjectRequest, PutObjectResult> {
        final /* synthetic */ String a;
        final /* synthetic */ int b;

        b(String str, int i) {
            this.a = str;
            this.b = i;
        }

        @Override // com.alibaba.sdk.android.oss.callback.OSSCompletedCallback
        /* renamed from: a */
        public void onSuccess(PutObjectRequest putObjectRequest, PutObjectResult putObjectResult) {
            LogUtils.d(" UploadSuccess file: " + this.a);
            File file = new File(this.a);
            if (!file.delete()) {
                LogUtils.d(" delete file failed, try again: " + this.a);
                file.delete();
            }
            OssService.this.a(this.b);
        }

        @Override // com.alibaba.sdk.android.oss.callback.OSSCompletedCallback
        /* renamed from: a */
        public void onFailure(PutObjectRequest putObjectRequest, ClientException clientException, ServiceException serviceException) {
            if (clientException != null) {
                clientException.printStackTrace();
                String exc = clientException.toString();
                LogUtils.e("[chamo] error message: " + exc);
            }
            if (serviceException != null) {
                LogUtils.e("UploadFailure：表示在OSS服务端发生错误:");
            }
            OssService.this.a(this.b);
        }
    }

    public void a(String str, String str2, String str3, int i) {
        LogUtils.d(" enter oss service ");
        int c = c();
        a(this.p + str3 + "/" + str, str2, c, i);
        LogUtils.d(" upload done ");
    }

    public boolean b(String str) {
        LogUtils.e("fetch_listF");
        String str2 = t + "listF.bin";
        int c = c();
        if (a("ws_parking_hdmap/recommend/listF.bin", c)) {
            a("ws_parking_hdmap/recommend/listF.bin", str2, "action.fetch.LISTF", c, 6, new long[0]);
            return true;
        }
        a(c);
        LogUtils.e("cannot find listF");
        return false;
    }

    public void a(Context context, String str) {
        File file = new File(s);
        if (!file.exists()) {
            file.mkdirs();
        }
        int c = c();
        String str2 = this.m + this.h + "/cloudmap/" + str;
        if (a(str2, c)) {
            String replace = str.replace(".bin", ".json");
            LogUtils.i("ready to get map: " + this.m + this.h + "/cloudmap/" + str);
            StringBuilder sb = new StringBuilder();
            sb.append(s);
            sb.append(replace);
            a(str2, sb.toString(), "action.update.map", c, 5, new long[0]);
        }
    }

    public OssService(Context context) {
        String str = this.n + "/garage_list.csv";
        this.g = context;
        this.r.put(1, "");
        this.r.put(2, "e28");
        this.r.put(4, "d55");
    }

    public void c(String str, int i) {
        File[] listFiles = new File(str).listFiles(new FileSaver.myFilter2());
        if (listFiles != null) {
            for (File file : listFiles) {
                if (file.length() > CommonConfig.MAX_LOG_LENGTH) {
                    LogUtils.i(" map size > 10M: " + file.length());
                    file.delete();
                } else {
                    String path = file.getPath();
                    LogUtils.i("oss upload full path: " + path);
                    if (file.getName().contains("upload_on")) {
                        this.l = "traj_outdoor";
                    } else {
                        this.l = "ap_ota4";
                    }
                    a(file.getName(), path, this.l, i);
                    LogUtils.i("oss " + file.getName() + " upload finished");
                }
            }
        }
    }

    public void b() {
        this.q.clear();
    }

    public void a(Context context, String str, String str2, long j, long j2) {
        int c = c();
        a(this.m + this.h + "/cloudmap/" + str, str2, "action.transport2xpu.map", c, 9, j, j2);
    }

    public boolean a(String str, int i) {
        LogUtils.i("22222222222 " + str);
        boolean z = false;
        try {
            LogUtils.i("jjjjjjjjjjjjjjj");
            if (this.q.get(Integer.valueOf(i)).doesObjectExist(this.c, str)) {
                LogUtils.i("33333333 " + str);
                z = true;
            } else {
                LogUtils.i("4444444 " + str);
            }
        } catch (ClientException e) {
            e.printStackTrace();
        } catch (ServiceException unused) {
        }
        return z;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class a implements OSSCompletedCallback<GetObjectRequest, GetObjectResult> {
        final /* synthetic */ String a;
        final /* synthetic */ String b;
        final /* synthetic */ int c;
        final /* synthetic */ long[] d;
        final /* synthetic */ String e;
        final /* synthetic */ int f;

        a(String str, String str2, int i, long[] jArr, String str3, int i2) {
            this.a = str;
            this.b = str2;
            this.c = i;
            this.d = jArr;
            this.e = str3;
            this.f = i2;
        }

        @Override // com.alibaba.sdk.android.oss.callback.OSSCompletedCallback
        /* renamed from: a */
        public void onSuccess(GetObjectRequest getObjectRequest, GetObjectResult getObjectResult) {
            long j;
            long j2;
            long contentLength = getObjectResult.getContentLength();
            LogUtils.e("len: " + contentLength);
            int i = (int) contentLength;
            byte[] bArr = new byte[i];
            int i2 = 0;
            while (i2 < contentLength) {
                try {
                    i2 += getObjectResult.getObjectContent().read(bArr, i2, i - i2);
                } catch (Exception e) {
                    OSSLog.logInfo(e.toString());
                }
            }
            try {
                LogUtils.i("start writing " + this.a);
                FileOutputStream fileOutputStream = new FileOutputStream(this.a);
                fileOutputStream.write(bArr);
                fileOutputStream.close();
                getObjectResult.getObjectContent().close();
                LogUtils.e("finish writing " + this.a);
                String str = this.a;
                if (this.b == "action.transport2xpu.map" || this.b == "action.fetch.garage" || this.b == "action.fetch.fullmap" || this.b == "action.fetch.LISTF" || this.b == "action.fetch.fence" || this.b == "action.fetch.factorymap") {
                    LogUtils.i("2 files " + this.a + " and " + this.a.replace(".bin", ".json"));
                    FileSaver.unzip(this.a, this.a.replace(".bin", ".json"));
                    str = this.a.replace(".bin", ".json");
                }
                if (this.b != "") {
                    Intent intent = new Intent(this.b);
                    String[] split = str.split("/");
                    intent.putExtra("map_file", split[split.length - 1]);
                    OssService.this.a(intent);
                }
                OssService.this.a(this.c);
                if (this.d.length >= 2) {
                    long j3 = this.d[0];
                    j2 = this.d[1];
                    j = j3;
                } else {
                    j = 0;
                    j2 = 0;
                }
                k4.a(this.a, this.e, "", this.f, 0, OssService.this.f, StateCollection.getInstance(), j, j2);
            } catch (Exception e2) {
                OSSLog.logInfo(e2.toString());
                OssService.this.a(this.c);
            }
        }

        @Override // com.alibaba.sdk.android.oss.callback.OSSCompletedCallback
        /* renamed from: a */
        public void onFailure(GetObjectRequest getObjectRequest, ClientException clientException, ServiceException serviceException) {
            String str;
            long j;
            long j2;
            String str2 = this.b;
            if (str2 == "action.fetch.garage" || str2 == "action.fetch.fence") {
                Intent intent = new Intent(this.b);
                String[] split = this.a.split("/");
                intent.putExtra("map_file", split[split.length - 1]);
                OssService.this.a(intent);
            }
            if (clientException != null) {
                clientException.printStackTrace();
                str = clientException.toString();
                LogUtils.e("download error message: " + str);
            } else {
                str = "";
            }
            if (serviceException != null) {
                LogUtils.e("download error message：表示在OSS服务端发生错误:");
            }
            long[] jArr = this.d;
            if (jArr.length >= 2) {
                long j3 = jArr[0];
                j2 = jArr[1];
                j = j3;
            } else {
                j = 0;
                j2 = 0;
            }
            k4.a(str + "-", this.a, this.e, "", this.f, -1, OssService.this.f, StateCollection.getInstance(), j, j2);
        }
    }

    public void c(String str) {
        this.b = str;
    }

    private void a(String str, String str2, String str3, int i, int i2, long... jArr) {
        GetObjectRequest getObjectRequest = new GetObjectRequest(this.c, str);
        getObjectRequest.setCRC64(OSSRequest.CRC64Config.YES);
        OSS oss = this.q.get(Integer.valueOf(i));
        if (oss == null) {
            LogUtils.e("oss nullptr Error!!!");
        } else {
            oss.asyncGetObject(getObjectRequest, new a(str2, str3, i, jArr, str, i2));
        }
    }

    public void a(String str, String str2, int i, int i2) {
        LogUtils.d(" begin Upload file: " + str2);
        OSS oss = this.q.get(Integer.valueOf(i));
        if (oss == null) {
            LogUtils.e("oss nullptr Error!!!");
        } else if (str != null && !str.equals("") && !str2.equals("")) {
            PutObjectRequest putObjectRequest = new PutObjectRequest(this.c, str, str2);
            if (str2 != null && !str2.equals("")) {
                oss.asyncPutObject(putObjectRequest, new b(str2, i));
            } else {
                a(i);
            }
        } else {
            a(i);
        }
    }

    public boolean a() {
        LogUtils.d("find garages_info.bin");
        String str = this.k + "/garages_info.bin";
        int c = c();
        if (a("garage_list/garages_info.bin", c)) {
            a("garage_list/garages_info.bin", str, "action.fetch.garage", c, 4, new long[0]);
            return true;
        }
        a(c);
        LogUtils.e("cannot find garage bin");
        return false;
    }

    public int a(String str, String str2) {
        LogUtils.d("onground find fence file virfence.json");
        String str3 = "ws_virtual_fence/" + (str + "-" + str2) + "/virfence" + str + ".bin";
        String str4 = this.k + "/virfence.bin";
        int c = c();
        if (a(str3, c)) {
            a(str3, str4, "action.fetch.fence", c, 8, new long[0]);
            return 1;
        }
        a(c);
        LogUtils.e("onground cannot find fence file");
        return 0;
    }

    public boolean a(String str, String str2, int i, String str3) {
        LogUtils.e("fetch_neareast_recommend_map");
        String str4 = "ws_parking_hdmap/recommend/" + (str + "-" + str2 + "/" + i + "/" + str3 + ".bin");
        LogUtils.e("[chamo oss] recommend map path: " + str4);
        String str5 = t + str3 + ".bin";
        LogUtils.e("[chamo oss] recommend local map path: " + str5);
        int c = c();
        if (a(str4, c)) {
            a(str4, str5, "action.fetch.fullmap", c, 7, new long[0]);
            return true;
        }
        a(c);
        LogUtils.e("cannot find neareast_recommend_map");
        return false;
    }

    public boolean a(String str) {
        String str2 = "ws_parking_hdmap/complete/factory/" + str;
        String str3 = t + str;
        LogUtils.e("[chamo oss] recommend local map path: " + str3);
        int c = c();
        if (a(str2, c)) {
            a(str2, str3, "action.fetch.factorymap", c, 3, new long[0]);
            return true;
        }
        a(c);
        LogUtils.e("cannot find neareast_recommend_map");
        return false;
    }

    public void a(String str, int i, int i2) {
        LogUtils.e(" succ upload map");
        long currentTimeMillis = System.currentTimeMillis();
        c(FileSaver.Constant.file_root, i2);
        if (i2 == 12) {
            b(str, i);
        }
        LogUtils.d("oss upload time cost88888: " + (System.currentTimeMillis() - currentTimeMillis));
    }

    public boolean a(boolean z, String str, int i) {
        if (!new File(this.o).exists()) {
            if (z) {
                LogUtils.d("new fetch");
                b(str, i);
            }
            return false;
        }
        try {
            FileInputStream fileInputStream = new FileInputStream(this.o);
            byte[] bArr = new byte[fileInputStream.available()];
            fileInputStream.read(bArr);
            fileInputStream.close();
            String str2 = new String(bArr, "UTF-8");
            LogUtils.d("about to parse json");
            return x3.a(str2);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            return false;
        } catch (IOException e2) {
            e2.printStackTrace();
            return false;
        }
    }
}
