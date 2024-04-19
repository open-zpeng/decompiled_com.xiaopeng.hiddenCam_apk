package defpackage;

import android.car.Car;
import android.car.CarNotConnectedException;
import android.car.hardware.xpu.CarXpuManager;
import com.xiaopeng.hiddenCam.hardware.EcuEventCallback;
import com.xiaopeng.hiddenCam.state.ENUM.XPUREADYSTATUS;
import com.xiaopeng.hiddenCam.state.StateCollection;
import com.xiaopeng.hiddenCam.utils.IntUtils;
import com.xiaopeng.hiddenCam.utils.LogUtils;
import com.xiaopeng.hiddenCam.utils.jni.JniUtil;
import java.io.File;
import java.io.FileInputStream;
import java.util.Collections;
import org.json.JSONArray;
import org.json.JSONObject;
/* compiled from: CarXpuManagerWrapper.java */
/* renamed from: i4  reason: default package */
/* loaded from: classes.dex */
public class i4 {
    static CarXpuManager c;
    EcuEventCallback a;
    StateCollection b;

    public i4(EcuEventCallback ecuEventCallback, Car car, StateCollection stateCollection) throws CarNotConnectedException {
        this.a = ecuEventCallback;
        c = (CarXpuManager) car.getCarManager("xp_xpu");
        this.b = stateCollection;
        a();
    }

    public void a() throws CarNotConnectedException {
        c.registerPropCallback(Collections.singletonList(557856773), this.a);
        c.registerPropCallback(Collections.singletonList(561002511), this.a);
        c.registerPropCallback(Collections.singletonList(561002515), this.a);
        c.registerPropCallback(Collections.singletonList(557856777), this.a);
        c.registerPropCallback(Collections.singletonList(557856815), this.a);
    }

    public static void a(int i, int i2) {
        int i3 = 1;
        if (i2 != 1) {
            if (i2 != 2) {
                return;
            }
            i3 = 3;
        }
        try {
            JniUtil.setComfirmed(i3, i);
            String str = "Venue" + String.valueOf(i) + ".json";
            LogUtils.e("Venue name: " + str);
            String str2 = "/mnt/sdcard/hdmaps/" + str;
            if (!new File(str2).exists()) {
                LogUtils.e("map doesn't exist, Error");
                return;
            }
            FileInputStream fileInputStream = new FileInputStream(str2);
            byte[] bArr = new byte[fileInputStream.available()];
            fileInputStream.read(bArr);
            fileInputStream.close();
            JSONObject jSONObject = new JSONObject(new String(bArr, "UTF-8"));
            JSONArray jSONArray = jSONObject.getJSONArray("Slots");
            LogUtils.d("4444444444444444 :" + jSONArray.length());
            for (int i4 = 0; i4 < jSONArray.length(); i4++) {
                JSONObject jSONObject2 = jSONArray.getJSONObject(i4).getJSONObject("Favorate");
                if (jSONObject2.getInt("Maturity") >= 2) {
                    LogUtils.d("write to comfirm " + i3);
                    jSONObject2.put("Favorslotconfirmed", i3);
                }
            }
            byte[] bytes = jSONObject.toString().getBytes();
            byte[] bytes2 = str.getBytes();
            byte[] int2Bytes = IntUtils.int2Bytes(0);
            byte[] int2Bytes2 = IntUtils.int2Bytes(bytes2.length);
            byte[] int2Bytes3 = IntUtils.int2Bytes(bytes.length);
            byte[] bArr2 = new byte[bytes2.length + 12 + bytes.length];
            System.arraycopy(int2Bytes, 0, bArr2, 0, 4);
            System.arraycopy(int2Bytes2, 0, bArr2, 4, 4);
            System.arraycopy(int2Bytes3, 0, bArr2, 8, 4);
            System.arraycopy(bytes2, 0, bArr2, 12, bytes2.length);
            System.arraycopy(bytes, 0, bArr2, bytes2.length + 12, bytes.length);
            c.sendHdMapData(bArr2);
        } catch (Exception unused) {
            LogUtils.e("json wrong, Error");
        }
    }

    public boolean a(int i, String str, String str2) {
        if (this.b.getXpu_ready_status() != XPUREADYSTATUS.READY.value) {
            return false;
        }
        try {
            LogUtils.d("File type sent to XPU is: " + i);
            String str3 = str + str2;
            File file = new File(str3);
            if (!file.exists()) {
                LogUtils.e("66666this path doesn't exist: " + str3);
                return false;
            }
            byte[] bArr = new byte[(int) file.length()];
            byte[] bytes = str2.getBytes();
            byte[] int2Bytes = IntUtils.int2Bytes(i);
            byte[] int2Bytes2 = IntUtils.int2Bytes(bytes.length);
            byte[] int2Bytes3 = IntUtils.int2Bytes((int) file.length());
            byte[] bArr2 = new byte[bytes.length + 12 + ((int) file.length())];
            FileInputStream fileInputStream = new FileInputStream(file);
            fileInputStream.read(bArr);
            System.arraycopy(int2Bytes, 0, bArr2, 0, 4);
            System.arraycopy(int2Bytes2, 0, bArr2, 4, 4);
            System.arraycopy(int2Bytes3, 0, bArr2, 8, 4);
            System.arraycopy(bytes, 0, bArr2, 12, bytes.length);
            System.arraycopy(bArr, 0, bArr2, bytes.length + 12, (int) file.length());
            c.sendHdMapData(bArr2);
            fileInputStream.close();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public static boolean a(int i, int i2, int i3) {
        byte[] bArr = new byte[12];
        byte[] int2Bytes = IntUtils.int2Bytes(i);
        byte[] int2Bytes2 = IntUtils.int2Bytes(i2);
        IntUtils.int2Bytes(i3);
        System.arraycopy(int2Bytes, 0, bArr, 0, 4);
        System.arraycopy(int2Bytes2, 0, bArr, 4, 4);
        System.arraycopy(int2Bytes2, 0, bArr, 8, 4);
        LogUtils.e("sendToXpuSignal,type = " + i + " mapid: " + i2 + " val: " + i3);
        c.sendHdMapData(bArr);
        return true;
    }
}
