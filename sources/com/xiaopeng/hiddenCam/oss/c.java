package com.xiaopeng.hiddenCam.oss;

import android.content.Context;
import android.content.Intent;
import com.xiaopeng.hiddenCam.App;
import com.xiaopeng.hiddenCam.CameraService;
import com.xiaopeng.hiddenCam.apirouterClient.RouteHdPkMap2NaviClient;
import com.xiaopeng.hiddenCam.state.ENUM.CONFIG;
import com.xiaopeng.hiddenCam.state.ENUM.IMAGEPRO;
import com.xiaopeng.hiddenCam.state.ENUM.REGLISTF;
import com.xiaopeng.hiddenCam.state.StateCollection;
import com.xiaopeng.hiddenCam.utils.FileSaver;
import com.xiaopeng.hiddenCam.utils.LogUtils;
import com.xiaopeng.hiddenCam.utils.jni.GpsUtils;
import com.xiaopeng.hiddenCam.utils.jni.JniUtil;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.nio.channels.FileChannel;
import java.util.Iterator;
import org.json.JSONObject;
/* compiled from: OssServiceObserver.java */
/* loaded from: classes.dex */
public class c implements b {
    OssService a;
    StateCollection b;
    l4 c;
    Context d;
    m3 e;

    public c(OssService ossService, StateCollection stateCollection, l4 l4Var, Context context, m3 m3Var) {
        this.a = ossService;
        this.b = stateCollection;
        this.c = l4Var;
        this.d = context;
        this.e = m3Var;
    }

    @Override // com.xiaopeng.hiddenCam.oss.b
    public void a(a aVar, Object obj) {
        JSONObject jSONObject;
        Intent intent = (Intent) obj;
        String action = intent.getAction();
        LogUtils.d("action = " + action);
        this.a.getClass();
        if (action.equals("action.reload.config")) {
            this.e.a(false);
            this.b.setResetImgProcFlag(IMAGEPRO.IMAGE_PROC_FLAG_RESET.value);
            JniUtil.resetPartStatus();
            this.b.setIs_config_init(CONFIG.CONFIG_NOT_INIT.value);
            LogUtils.e("fetch new config");
            return;
        }
        this.a.getClass();
        if (action.equals("action.reload.maplist")) {
            m4.a();
            this.d.sendBroadcast(new Intent("hdmap.get.garagelist"));
            return;
        }
        this.a.getClass();
        if (action.equals("action.reload.map")) {
            String stringExtra = intent.getStringExtra("filename");
            Intent intent2 = new Intent("hdmap.get.garage");
            intent2.putExtra("garage_name", stringExtra);
            this.d.sendBroadcast(intent2);
            LogUtils.d("12312312");
            return;
        }
        this.a.getClass();
        if (action.equals("action.fetch.garage")) {
            try {
                LogUtils.d("garage_file" + intent.getStringExtra("map_file"));
                GpsUtils.init();
                return;
            } catch (Exception e) {
                e.printStackTrace();
                return;
            }
        }
        this.a.getClass();
        if (action.equals("action.fetch.fence")) {
            try {
                LogUtils.d(" onground fence_file" + intent.getStringExtra("map_file"));
                GpsUtils.fenceinit();
                this.b.setbFetchFence(true);
                return;
            } catch (Exception e2) {
                e2.printStackTrace();
                return;
            }
        }
        this.a.getClass();
        if (action.equals("action.transport2xpu.map")) {
            String stringExtra2 = intent.getStringExtra("map_file");
            LogUtils.d("8888888888 garage: " + stringExtra2);
            this.c.a(0, OssService.s, stringExtra2);
            return;
        }
        this.a.getClass();
        if (action.equals("action.update.map")) {
            intent.getStringExtra("map_file");
            String str = OssService.s;
            try {
            } catch (Exception e3) {
                e3.printStackTrace();
            }
            if (!new File(str + "updateList.json").exists()) {
                LogUtils.d("update_list.json doesn't exist: " + str + "updateList.json");
                return;
            }
            FileInputStream fileInputStream = new FileInputStream(str + "updateList.json");
            byte[] bArr = new byte[fileInputStream.available()];
            fileInputStream.read(bArr);
            fileInputStream.close();
            JSONObject jSONObject2 = new JSONObject(new String(bArr, "UTF-8"));
            File file = new File(str + "updateList_raw.json");
            Iterator<String> keys = jSONObject2.keys();
            if (!file.exists()) {
                while (keys.hasNext()) {
                    String str2 = keys.next() + ".bin";
                    String str3 = str + str2;
                    LogUtils.d("55555555555 " + str3 + "," + str2);
                    this.a.a(App.a().getApplicationContext(), str2, str3, 0L, 0L);
                }
            } else {
                FileInputStream fileInputStream2 = new FileInputStream(str + "updateList_raw.json");
                byte[] bArr2 = new byte[fileInputStream2.available()];
                fileInputStream2.read(bArr2);
                fileInputStream2.close();
                JSONObject jSONObject3 = new JSONObject(new String(bArr2, "UTF-8"));
                while (keys.hasNext()) {
                    String next = keys.next();
                    long j = jSONObject2.getLong(next);
                    if (jSONObject3.has(next)) {
                        long j2 = jSONObject3.getLong(next);
                        LogUtils.d(next + ":compare res = " + j2 + "," + j);
                        if (j2 != j) {
                            String str4 = next + ".bin";
                            this.a.a(App.a().getApplicationContext(), str4, str + str4, j2, j);
                        }
                        jSONObject = jSONObject3;
                    } else {
                        String str5 = next + ".bin";
                        String str6 = str + str5;
                        jSONObject = jSONObject3;
                        this.a.a(App.a().getApplicationContext(), str5, str6, 0L, j);
                        LogUtils.d("66666666 " + str6 + "," + str5);
                    }
                    jSONObject3 = jSONObject;
                }
            }
            FileSaver.copy(str + "updateList.json", str + "updateList_raw.json");
            return;
        }
        this.a.getClass();
        if (action.equals("action.fetch.LISTF")) {
            String stringExtra3 = intent.getStringExtra("map_file");
            LogUtils.e("ACTION_FETCH_LISTF: " + stringExtra3);
            this.c.a(2, OssService.t, stringExtra3);
            this.b.setReg_listF_status(REGLISTF.FINISH_DOWNLOADING);
            String str7 = OssService.t + stringExtra3;
            try {
                if (!new File(str7).exists()) {
                    LogUtils.e("listF.json doesn't exist: " + str7);
                    return;
                }
                FileInputStream fileInputStream3 = new FileInputStream(str7);
                byte[] bArr3 = new byte[fileInputStream3.available()];
                fileInputStream3.read(bArr3);
                fileInputStream3.close();
                JSONObject jSONObject4 = new JSONObject(new String(bArr3, "UTF-8"));
                if (jSONObject4.has("version")) {
                    this.b.setListF_ver(jSONObject4.getString("version"));
                    LogUtils.e("listF version: " + this.b.getListF_ver());
                    FileChannel channel = new FileInputStream(new File(str7)).getChannel();
                    FileChannel channel2 = new FileOutputStream(new File(OssService.t + "listF_" + this.b.getListF_ver() + ".json")).getChannel();
                    channel2.transferFrom(channel, 0L, channel.size());
                    channel.close();
                    channel2.close();
                    RouteHdPkMap2NaviClient.routeHdPkMap2NaviListFVersion(this.b.getListF_ver());
                    return;
                }
                return;
            } catch (Exception e4) {
                e4.printStackTrace();
                return;
            }
        }
        this.a.getClass();
        if (action.equals("action.fetch.fullmap")) {
            this.c.a(32, OssService.t, intent.getStringExtra("map_file"));
            return;
        }
        this.a.getClass();
        if (action.equals("action.fetch.factorymap")) {
            LogUtils.d("fetch factory ");
            CameraService.A.a(19, OssService.t, intent.getStringExtra("map_file"));
        }
    }
}
