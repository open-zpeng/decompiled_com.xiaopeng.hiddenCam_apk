package defpackage;

import java.io.IOException;
import java.io.OutputStream;
/* renamed from: c6  reason: default package */
/* loaded from: classes.dex */
public final class c6 extends b6 {
    private static final int[] g;
    static /* synthetic */ Class h;
    private long a;
    private int b;
    private int c;
    private byte d;
    private final byte[] e;
    private int f;

    static {
        if (h == null) {
            h = a("org.tukaani.xz.rangecoder.RangeEncoder");
        }
        g = new int[128];
        for (int i = 8; i < 2048; i += 16) {
            int i2 = i;
            int i3 = 0;
            for (int i4 = 0; i4 < 4; i4++) {
                i2 *= i2;
                i3 <<= 1;
                while (((-65536) & i2) != 0) {
                    i2 >>>= 1;
                    i3++;
                }
            }
            g[i >> 4] = 161 - i3;
        }
    }

    public c6(int i) {
        this.e = new byte[i];
        c();
    }

    public static int a(int i) {
        return i << 4;
    }

    static /* synthetic */ Class a(String str) {
        try {
            return Class.forName(str);
        } catch (ClassNotFoundException e) {
            throw new NoClassDefFoundError().initCause(e);
        }
    }

    public static int b(int i, int i2) {
        return g[(i ^ ((-i2) & 2047)) >>> 4];
    }

    public static int c(short[] sArr, int i) {
        int length = i | sArr.length;
        int i2 = 0;
        do {
            int i3 = length & 1;
            length >>>= 1;
            i2 += b(sArr[length], i3);
        } while (length != 1);
        return i2;
    }

    public static int d(short[] sArr, int i) {
        int length = i | sArr.length;
        int i2 = 0;
        int i3 = 1;
        do {
            int i4 = length & 1;
            length >>>= 1;
            i2 += b(sArr[i3], i4);
            i3 = (i3 << 1) | i4;
        } while (length != 1);
        return i2;
    }

    private void d() {
        int i;
        long j = this.a;
        int i2 = (int) (j >>> 32);
        if (i2 != 0 || j < 4278190080L) {
            byte b = this.d;
            do {
                byte[] bArr = this.e;
                int i3 = this.f;
                this.f = i3 + 1;
                bArr[i3] = (byte) (b + i2);
                b = 255;
                i = this.c - 1;
                this.c = i;
            } while (i != 0);
            this.d = (byte) (this.a >>> 24);
        }
        this.c++;
        this.a = (this.a & 16777215) << 8;
    }

    public int a() {
        for (int i = 0; i < 5; i++) {
            d();
        }
        return this.f;
    }

    public void a(int i, int i2) {
        do {
            this.b >>>= 1;
            long j = this.a;
            int i3 = this.b;
            i2--;
            this.a = j + ((0 - ((i >>> i2) & 1)) & i3);
            if (((-16777216) & i3) == 0) {
                this.b = i3 << 8;
                d();
                continue;
            }
        } while (i2 != 0);
    }

    public void a(OutputStream outputStream) throws IOException {
        outputStream.write(this.e, 0, this.f);
    }

    public void a(short[] sArr, int i) {
        int length = sArr.length;
        int i2 = 1;
        do {
            length >>>= 1;
            int i3 = i & length;
            a(sArr, i2, i3);
            i2 <<= 1;
            if (i3 != 0) {
                i2 |= 1;
                continue;
            }
        } while (length != 1);
    }

    public void a(short[] sArr, int i, int i2) {
        short s = sArr[i];
        int i3 = this.b;
        int i4 = (i3 >>> 11) * s;
        if (i2 == 0) {
            this.b = i4;
            sArr[i] = (short) (s + ((2048 - s) >>> 5));
        } else {
            this.a += i4 & 4294967295L;
            this.b = i3 - i4;
            sArr[i] = (short) (s - (s >>> 5));
        }
        int i5 = this.b;
        if (((-16777216) & i5) == 0) {
            this.b = i5 << 8;
            d();
        }
    }

    public int b() {
        return ((this.f + this.c) + 5) - 1;
    }

    public void b(short[] sArr, int i) {
        int length = i | sArr.length;
        int i2 = 1;
        do {
            int i3 = length & 1;
            length >>>= 1;
            a(sArr, i2, i3);
            i2 = (i2 << 1) | i3;
        } while (length != 1);
    }

    public void c() {
        this.a = 0L;
        this.b = -1;
        this.d = (byte) 0;
        this.c = 1;
        this.f = 0;
    }
}
