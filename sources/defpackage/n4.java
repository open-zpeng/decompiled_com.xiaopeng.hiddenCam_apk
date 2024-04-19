package defpackage;

import com.alibaba.sdk.android.oss.common.OSSConstants;
import com.xiaopeng.hiddenCam.CameraService;
import com.xiaopeng.hiddenCam.state.ENUM.APSTATUS;
import com.xiaopeng.hiddenCam.utils.FileSaver;
import com.xiaopeng.hiddenCam.utils.LogUtils;
import com.xiaopeng.hiddenCam.utils.ThreadPoolHelper;
import java.io.DataInputStream;
import java.io.OutputStream;
import java.math.BigInteger;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.Arrays;
/* compiled from: AvmSocket.java */
/* renamed from: n4  reason: default package */
/* loaded from: classes.dex */
public class n4 {
    public static Socket l;
    private String a = "18 00 00 00 68 00 00 00 04 2d 00 00 00 00 00 00 00 00 00 00 0D 00 5a 00 00 00 00 00";
    private String b = "18 00 00 00 68 00 00 00 04 2d 00 00 00 00 00 00 00 00 00 00 0F 00 5a 00 00 00 00 00";
    private byte[] c = null;
    private byte[] d = null;
    private int e = OSSConstants.DEFAULT_BUFFER_SIZE;
    private int f = 2457600;
    private byte[] g = new byte[this.f];
    private int h = 0;
    private int i = 0;
    public String j = "";
    private Runnable k = new a();

    /* compiled from: AvmSocket.java */
    /* renamed from: n4$a */
    /* loaded from: classes.dex */
    class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            LogUtils.d(" enter while loop in socket!!! cfc_level = " + n4.this.h);
            while (n4.this.j.length() != 0) {
                try {
                    if (Math.abs(CameraService.y.getScu_locat_S() - CameraService.B) < x3.e) {
                        Thread.sleep(10L);
                    } else {
                        CameraService.B = CameraService.y.getScu_locat_S();
                        if (!n4.this.a("172.20.1.57", 5000)) {
                            LogUtils.e("cannot connect to avm !!");
                            return;
                        }
                        if (n4.l.isConnected() && n4.this.c != null) {
                            long currentTimeMillis = System.currentTimeMillis();
                            OutputStream outputStream = n4.l.getOutputStream();
                            outputStream.write(n4.this.c);
                            outputStream.flush();
                            DataInputStream dataInputStream = new DataInputStream(n4.l.getInputStream());
                            byte[] bArr = new byte[n4.this.e];
                            boolean z = false;
                            int i = 0;
                            while (true) {
                                int read = dataInputStream.read(bArr);
                                if (read == -1) {
                                    z = true;
                                    break;
                                }
                                int i2 = i + read;
                                if (i2 <= n4.this.f) {
                                    System.arraycopy(bArr, 0, n4.this.g, i, read);
                                    i = i2;
                                } else {
                                    LogUtils.e("read bytes count larger than max = " + read);
                                    break;
                                }
                            }
                            LogUtils.d("time: " + (System.currentTimeMillis() - currentTimeMillis) + " len: " + (i / 1024) + " img_cnt: " + n4.this.i);
                            if (z && i >= 100) {
                                int i3 = i - 36;
                                n4.this.d = new byte[i3];
                                n4.this.d = Arrays.copyOfRange(n4.this.g, 36, i);
                                if (n4.this.j.length() == 0) {
                                    return;
                                }
                                n4.this.a(n4.this.d, i3);
                                n4.this.i++;
                                outputStream.close();
                                if (n4.this.i <= 2500 && CameraService.y.getAp_status_() != APSTATUS.APSTATUS_3.value && CameraService.y.getAp_status_() != APSTATUS.APSTATUS_4.value) {
                                }
                                return;
                            }
                        }
                        LogUtils.e("cannot connect to server!!!");
                        return;
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                    return;
                }
            }
        }
    }

    public n4() {
        new String[]{"Front_", "Rear_", "Left_", "Right_"};
        c();
    }

    private void c() {
        String[] split = (x3.o.a == 1 ? this.b : this.a).split("\\s+");
        int length = split.length;
        this.c = new byte[length];
        for (int i = 0; i < length; i++) {
            this.c[i] = (byte) (a(split[i]) & 255);
        }
    }

    public void b() {
        this.j = "";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a(String str, int i) {
        try {
            InetSocketAddress inetSocketAddress = new InetSocketAddress(str, i);
            l = new Socket();
            l.connect(inetSocketAddress, 5000);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public void a(int i, String str) {
        this.h = i;
        this.j = str + "/raw_data/";
        this.i = 0;
        ThreadPoolHelper.getInstance().executeBySequence(this.k);
    }

    public int a(String str) {
        return new BigInteger(str, 16).intValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(byte[] bArr, int i) {
        String valueOf = String.valueOf(this.i + 100000);
        FileSaver.copyAvmInfo(this.j, valueOf + "_.yuv", bArr);
    }

    public void a() {
        this.i = 0;
    }
}
