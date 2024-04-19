package defpackage;

import com.xiaopeng.hiddenCam.utils.LogUtils;
import com.xiaopeng.libconfig.ipc.AccountConfig;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* compiled from: HdmapConfig.java */
/* renamed from: x3  reason: default package */
/* loaded from: classes.dex */
public class x3 {
    public static int a = 0;
    public static int b = 1;
    public static int c = 1;
    public static int d = 0;
    public static double e = 2.0d;
    public static int f = 120;
    public static int g = 40;
    public static int h = 95;
    public static int i = 20;
    public static int j = 64;
    public static b[] k = null;
    public static int l = 0;
    public static double m = 0.01d;
    public static double n = 0.1d;
    public static a o;

    /* compiled from: HdmapConfig.java */
    /* renamed from: x3$a */
    /* loaded from: classes.dex */
    public static class a {
        public int a = 1;
        public int b = 1;
        public int c = 1;
        public int d = 1;
    }

    /* compiled from: HdmapConfig.java */
    /* renamed from: x3$b */
    /* loaded from: classes.dex */
    public static class b {
        public double a;
        public double b;
    }

    public static boolean a(String str) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            a = jSONObject.getInt("collect_img");
            if (jSONObject.has("collect_out_img")) {
                b = jSONObject.getInt("collect_out_img");
            }
            if (jSONObject.has("event_report")) {
                jSONObject.getInt("event_report");
            }
            e = jSONObject.getDouble("min_img_save_distance");
            f = jSONObject.getInt("img_block_w");
            g = jSONObject.getInt("img_block_h");
            h = jSONObject.getInt("jpg_quality");
            i = jSONObject.getInt("img_batch_size");
            JSONArray jSONArray = jSONObject.getJSONArray("gps_blacklist");
            m = jSONObject.getDouble("entry_img_rate");
            n = jSONObject.getDouble("exit_img_rate");
            JSONObject jSONObject2 = jSONObject.getJSONObject("camEnable");
            if (jSONObject.has("download_map")) {
                c = jSONObject.getInt("download_map");
                LogUtils.d("download_map: " + c);
            }
            if (jSONObject.has("fence_collect")) {
                d = jSONObject.getInt("fence_collect");
                LogUtils.d("fence_collect: " + d);
            }
            k = new b[jSONArray.length()];
            for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                JSONObject jSONObject3 = jSONArray.getJSONObject(i2);
                b bVar = new b();
                bVar.a = jSONObject3.getDouble("lat");
                bVar.b = jSONObject3.getDouble("lng");
                k[i2] = bVar;
            }
            o = new a();
            o.a = jSONObject2.getInt(AccountConfig.FaceIDRegisterAction.ORIENTATION_FRONT);
            o.b = jSONObject2.getInt("rear");
            o.c = jSONObject2.getInt(AccountConfig.FaceIDRegisterAction.ORIENTATION_LEFT);
            o.d = jSONObject2.getInt(AccountConfig.FaceIDRegisterAction.ORIENTATION_RIGHT);
            LogUtils.i("front : " + o.a + "rear : " + o.b + "left : " + o.c + "right : " + o.d);
            l = jSONObject.getInt("upload_ext_cali");
            if (e >= 0.1d && e <= 10.0d) {
                if (f >= 10 && f <= 1000) {
                    if (g >= 10 && g <= 1000) {
                        if (h <= 100 && h >= 50) {
                            if (i <= 200 && i >= 5) {
                                if (k.length > 1000) {
                                    LogUtils.i("gps_blacklist err");
                                    return false;
                                }
                                if (m >= 0.0d && m <= 1.0d) {
                                    if (n >= 0.0d && n <= 1.0d) {
                                        LogUtils.i("java read json done");
                                        return true;
                                    }
                                    LogUtils.i("exit_img_rate err");
                                    return false;
                                }
                                LogUtils.i("entry_img_rate err");
                                return false;
                            }
                            LogUtils.i("img_batch_size err");
                            return false;
                        }
                        LogUtils.i("jpg_quality err");
                        return false;
                    }
                    LogUtils.i("img_block_h err");
                    return false;
                }
                LogUtils.i("img_block_w err");
                return false;
            }
            LogUtils.i("min_img_save_distance err");
            return false;
        } catch (JSONException e2) {
            e2.printStackTrace();
            LogUtils.i("read json wrong");
            return false;
        }
    }
}
