package defpackage;

import com.xiaopeng.lib.framework.moduleinterface.carcontroller.IInputController;
import java.io.IOException;
import java.io.OutputStream;
import java.lang.reflect.Array;
/* compiled from: BZip2CompressorOutputStream.java */
/* renamed from: g5  reason: default package */
/* loaded from: classes.dex */
public class g5 extends f5 implements h5 {
    private int b;
    private final int c;
    private int d;
    private int e;
    private int g;
    private int h;
    private int k;
    private int l;
    private final int m;
    private a n;
    private i5 o;
    private OutputStream p;
    private volatile boolean q;
    private final j5 f = new j5();
    private int i = -1;
    private int j = 0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: BZip2CompressorOutputStream.java */
    /* renamed from: g5$a */
    /* loaded from: classes.dex */
    public static final class a {
        final boolean[] a = new boolean[256];
        final byte[] b = new byte[256];
        final int[] c = new int[258];
        final byte[] d = new byte[18002];
        final byte[] e = new byte[18002];
        final byte[] f = new byte[256];
        final byte[][] g = (byte[][]) Array.newInstance(byte.class, 6, 258);
        final int[][] h = (int[][]) Array.newInstance(int.class, 6, 258);
        final int[] i = new int[6];
        final short[] j = new short[6];
        final int[][] k = (int[][]) Array.newInstance(int.class, 6, 258);
        final byte[] l = new byte[6];
        final boolean[] m = new boolean[16];
        final int[] n = new int[260];
        final int[] o = new int[IInputController.KEYCODE_LEFT_OK_BUTTON];
        final int[] p = new int[IInputController.KEYCODE_LEFT_OK_BUTTON];
        final byte[] q;
        final int[] r;
        final char[] s;
        int t;

        a(int i) {
            int i2 = i * 100000;
            this.q = new byte[i2 + 1 + 20];
            this.r = new int[i2];
            this.s = new char[i2 * 2];
        }
    }

    public g5(OutputStream outputStream, int i) throws IOException {
        if (i < 1) {
            throw new IllegalArgumentException("blockSize(" + i + ") < 1");
        } else if (i <= 9) {
            this.c = i;
            this.p = outputStream;
            this.m = (this.c * 100000) - 20;
            g();
        } else {
            throw new IllegalArgumentException("blockSize(" + i + ") > 9");
        }
    }

    /*  JADX ERROR: JadxOverflowException in pass: LoopRegionVisitor
        jadx.core.utils.exceptions.JadxOverflowException: LoopRegionVisitor.assignOnlyInLoop endless recursion
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:56)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:30)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:18)
        */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x0093, code lost:
        if (r3[r2[r11]] < r3[r2[r10]]) goto L41;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static void a(byte[] r17, int[] r18, defpackage.g5.a r19, int r20, int r21) {
        /*
            Method dump skipped, instructions count: 282
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.g5.a(byte[], int[], g5$a, int, int):void");
    }

    private void b(int i) throws IOException {
        a(8, i);
    }

    private void c(int i) throws IOException {
        int i2 = this.i;
        if (i2 == -1) {
            this.i = i & 255;
            this.j++;
            return;
        }
        int i3 = i & 255;
        if (i2 == i3) {
            int i4 = this.j + 1;
            this.j = i4;
            if (i4 > 254) {
                m();
                this.i = -1;
                this.j = 0;
                return;
            }
            return;
        }
        m();
        this.j = 1;
        this.i = i3;
    }

    private void d() throws IOException {
        this.k = this.f.a();
        int i = this.l;
        this.l = (i >>> 31) | (i << 1);
        this.l ^= this.k;
        if (this.b == -1) {
            return;
        }
        b();
        b(49);
        b(65);
        b(89);
        b(38);
        b(83);
        b(89);
        a(this.k);
        a(1, 0);
        i();
    }

    private void e() throws IOException {
        b(23);
        b(114);
        b(69);
        b(56);
        b(80);
        b(144);
        a(this.l);
        c();
    }

    private void f(int i, int i2) throws IOException {
        a(3, i);
        a(15, i2);
        OutputStream outputStream = this.p;
        byte[] bArr = this.n.e;
        int i3 = this.e;
        int i4 = this.d;
        int i5 = i3;
        for (int i6 = 0; i6 < i2; i6++) {
            int i7 = bArr[i6] & 255;
            int i8 = i5;
            int i9 = i4;
            for (int i10 = 0; i10 < i7; i10++) {
                while (i8 >= 8) {
                    outputStream.write(i9 >> 24);
                    i9 <<= 8;
                    i8 -= 8;
                }
                i9 |= 1 << ((32 - i8) - 1);
                i8++;
            }
            i4 = i9;
            while (i8 >= 8) {
                outputStream.write(i4 >> 24);
                i4 <<= 8;
                i8 -= 8;
            }
            i5 = i8 + 1;
        }
        this.d = i4;
        this.e = i5;
    }

    private void g() throws IOException {
        b(66);
        b(90);
        this.n = new a(this.c);
        this.o = new i5(this.n);
        b(104);
        b(this.c + 48);
        this.l = 0;
        h();
    }

    private void h() {
        this.f.b();
        this.b = -1;
        boolean[] zArr = this.n.a;
        int i = 256;
        while (true) {
            i--;
            if (i < 0) {
                return;
            }
            zArr[i] = false;
        }
    }

    private void i() throws IOException {
        a(24, this.n.t);
        f();
        j();
    }

    private void j() throws IOException {
        byte[][] bArr = this.n.g;
        int i = this.g + 2;
        int i2 = 6;
        while (true) {
            i2--;
            if (i2 < 0) {
                break;
            }
            byte[] bArr2 = bArr[i2];
            int i3 = i;
            while (true) {
                i3--;
                if (i3 >= 0) {
                    bArr2[i3] = 15;
                }
            }
        }
        int i4 = this.h;
        int i5 = i4 >= 200 ? i4 < 600 ? 3 : i4 < 1200 ? 4 : i4 < 2400 ? 5 : 6 : 2;
        b(i5, i);
        int c = c(i5, i);
        d(i5, c);
        e(i5, i);
        k();
        f(i5, c);
        g(i5, i);
        l();
    }

    private void k() throws IOException {
        a aVar = this.n;
        boolean[] zArr = aVar.a;
        boolean[] zArr2 = aVar.m;
        int i = 16;
        while (true) {
            i--;
            if (i < 0) {
                break;
            }
            zArr2[i] = false;
            int i2 = i * 16;
            int i3 = 16;
            while (true) {
                i3--;
                if (i3 >= 0) {
                    if (zArr[i2 + i3]) {
                        zArr2[i] = true;
                    }
                }
            }
        }
        for (int i4 = 0; i4 < 16; i4++) {
            a(1, zArr2[i4] ? 1 : 0);
        }
        OutputStream outputStream = this.p;
        int i5 = this.e;
        int i6 = this.d;
        int i7 = i5;
        for (int i8 = 0; i8 < 16; i8++) {
            if (zArr2[i8]) {
                int i9 = i8 * 16;
                int i10 = i6;
                for (int i11 = 0; i11 < 16; i11++) {
                    while (i7 >= 8) {
                        outputStream.write(i10 >> 24);
                        i10 <<= 8;
                        i7 -= 8;
                    }
                    if (zArr[i9 + i11]) {
                        i10 |= 1 << ((32 - i7) - 1);
                    }
                    i7++;
                }
                i6 = i10;
            }
        }
        this.d = i6;
        this.e = i7;
    }

    private void l() throws IOException {
        a aVar = this.n;
        byte[][] bArr = aVar.g;
        int[][] iArr = aVar.k;
        OutputStream outputStream = this.p;
        byte[] bArr2 = aVar.d;
        char[] cArr = aVar.s;
        int i = this.h;
        int i2 = this.e;
        int i3 = this.d;
        int i4 = 0;
        int i5 = 0;
        while (i4 < i) {
            int min = Math.min((i4 + 50) - 1, i - 1);
            int i6 = bArr2[i5] & 255;
            int[] iArr2 = iArr[i6];
            byte[] bArr3 = bArr[i6];
            while (i4 <= min) {
                char c = cArr[i4];
                while (i2 >= 8) {
                    outputStream.write(i3 >> 24);
                    i3 <<= 8;
                    i2 -= 8;
                }
                int i7 = bArr3[c] & 255;
                i3 |= iArr2[c] << ((32 - i2) - i7);
                i2 += i7;
                i4++;
            }
            i4 = min + 1;
            i5++;
        }
        this.d = i3;
        this.e = i2;
    }

    private void m() throws IOException {
        int i = this.b;
        if (i < this.m) {
            int i2 = this.i;
            a aVar = this.n;
            aVar.a[i2] = true;
            byte b = (byte) i2;
            int i3 = this.j;
            this.f.a(i2, i3);
            if (i3 == 1) {
                aVar.q[i + 2] = b;
                this.b = i + 1;
                return;
            } else if (i3 == 2) {
                byte[] bArr = aVar.q;
                int i4 = i + 2;
                bArr[i4] = b;
                bArr[i + 3] = b;
                this.b = i4;
                return;
            } else if (i3 != 3) {
                int i5 = i3 - 4;
                aVar.a[i5] = true;
                byte[] bArr2 = aVar.q;
                bArr2[i + 2] = b;
                bArr2[i + 3] = b;
                bArr2[i + 4] = b;
                int i6 = i + 5;
                bArr2[i6] = b;
                bArr2[i + 6] = (byte) i5;
                this.b = i6;
                return;
            } else {
                byte[] bArr3 = aVar.q;
                bArr3[i + 2] = b;
                int i7 = i + 3;
                bArr3[i7] = b;
                bArr3[i + 4] = b;
                this.b = i7;
                return;
            }
        }
        d();
        h();
        m();
    }

    @Override // java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        if (this.q) {
            return;
        }
        OutputStream outputStream = this.p;
        a();
        outputStream.close();
    }

    protected void finalize() throws Throwable {
        if (!this.q) {
            System.err.println("Unclosed BZip2CompressorOutputStream detected, will *not* close it");
        }
        super.finalize();
    }

    @Override // java.io.OutputStream, java.io.Flushable
    public void flush() throws IOException {
        OutputStream outputStream = this.p;
        if (outputStream != null) {
            outputStream.flush();
        }
    }

    @Override // java.io.OutputStream
    public void write(int i) throws IOException {
        if (!this.q) {
            c(i);
            return;
        }
        throw new IOException("closed");
    }

    private void b(int i, int i2) {
        int i3;
        a aVar = this.n;
        byte[][] bArr = aVar.g;
        int[] iArr = aVar.c;
        int i4 = this.h;
        int i5 = 0;
        for (int i6 = i; i6 > 0; i6--) {
            int i7 = i4 / i6;
            int i8 = i2 - 1;
            int i9 = i5 - 1;
            int i10 = 0;
            while (i10 < i7 && i9 < i8) {
                i9++;
                i10 += iArr[i9];
            }
            if (i9 <= i5 || i6 == i || i6 == 1 || (1 & (i - i6)) == 0) {
                i3 = i9;
            } else {
                i3 = i9 - 1;
                i10 -= iArr[i9];
            }
            byte[] bArr2 = bArr[i6 - 1];
            int i11 = i2;
            while (true) {
                i11--;
                if (i11 >= 0) {
                    if (i11 >= i5 && i11 <= i3) {
                        bArr2[i11] = 0;
                    } else {
                        bArr2[i11] = 15;
                    }
                }
            }
            i5 = i3 + 1;
            i4 -= i10;
        }
    }

    @Override // java.io.OutputStream
    public void write(byte[] bArr, int i, int i2) throws IOException {
        if (i < 0) {
            throw new IndexOutOfBoundsException("offs(" + i + ") < 0.");
        } else if (i2 >= 0) {
            int i3 = i + i2;
            if (i3 <= bArr.length) {
                if (this.q) {
                    throw new IOException("stream closed");
                }
                while (i < i3) {
                    c(bArr[i]);
                    i++;
                }
                return;
            }
            throw new IndexOutOfBoundsException("offs(" + i + ") + len(" + i2 + ") > buf.length(" + bArr.length + ").");
        } else {
            throw new IndexOutOfBoundsException("len(" + i2 + ") < 0.");
        }
    }

    private void e(int i, int i2) {
        a aVar = this.n;
        int[][] iArr = aVar.k;
        byte[][] bArr = aVar.g;
        for (int i3 = 0; i3 < i; i3++) {
            byte[] bArr2 = bArr[i3];
            int i4 = 0;
            int i5 = 32;
            int i6 = i2;
            while (true) {
                i6--;
                if (i6 >= 0) {
                    int i7 = bArr2[i6] & 255;
                    if (i7 > i4) {
                        i4 = i7;
                    }
                    if (i7 < i5) {
                        i5 = i7;
                    }
                }
            }
            a(iArr[i3], bArr[i3], i5, i4, i2);
        }
    }

    private void g(int i, int i2) throws IOException {
        byte[][] bArr = this.n.g;
        OutputStream outputStream = this.p;
        int i3 = this.e;
        int i4 = this.d;
        int i5 = 0;
        while (i5 < i) {
            byte[] bArr2 = bArr[i5];
            int i6 = bArr2[0] & 255;
            while (i3 >= 8) {
                outputStream.write(i4 >> 24);
                i4 <<= 8;
                i3 -= 8;
            }
            i3 += 5;
            int i7 = i4 | (i6 << ((32 - i3) - 5));
            int i8 = i6;
            for (int i9 = 0; i9 < i2; i9++) {
                int i10 = bArr2[i9] & 255;
                while (i8 < i10) {
                    while (i3 >= 8) {
                        outputStream.write(i7 >> 24);
                        i7 <<= 8;
                        i3 -= 8;
                    }
                    i7 |= 2 << ((32 - i3) - 2);
                    i3 += 2;
                    i8++;
                }
                while (i8 > i10) {
                    while (i3 >= 8) {
                        outputStream.write(i7 >> 24);
                        i7 <<= 8;
                        i3 -= 8;
                    }
                    i7 |= 3 << ((32 - i3) - 2);
                    i3 += 2;
                    i8--;
                }
                while (i3 >= 8) {
                    outputStream.write(i7 >> 24);
                    i7 <<= 8;
                    i3 -= 8;
                }
                i3++;
            }
            i5++;
            i4 = i7;
        }
        this.d = i4;
        this.e = i3;
    }

    private void b() {
        this.o.a(this.n, this.b);
    }

    private void c() throws IOException {
        while (this.e > 0) {
            this.p.write(this.d >> 24);
            this.d <<= 8;
            this.e -= 8;
        }
    }

    private void f() {
        int i = this.b;
        a aVar = this.n;
        boolean[] zArr = aVar.a;
        byte[] bArr = aVar.q;
        int[] iArr = aVar.r;
        char[] cArr = aVar.s;
        int[] iArr2 = aVar.c;
        byte[] bArr2 = aVar.b;
        byte[] bArr3 = aVar.f;
        int i2 = 0;
        for (int i3 = 0; i3 < 256; i3++) {
            if (zArr[i3]) {
                bArr2[i3] = (byte) i2;
                i2++;
            }
        }
        this.g = i2;
        int i4 = i2 + 1;
        for (int i5 = i4; i5 >= 0; i5--) {
            iArr2[i5] = 0;
        }
        while (true) {
            i2--;
            if (i2 < 0) {
                break;
            }
            bArr3[i2] = (byte) i2;
        }
        int i6 = 0;
        int i7 = 0;
        for (int i8 = 0; i8 <= i; i8++) {
            byte b = bArr2[bArr[iArr[i8]] & 255];
            byte b2 = bArr3[0];
            int i9 = 0;
            while (b != b2) {
                i9++;
                byte b3 = bArr3[i9];
                bArr3[i9] = b2;
                b2 = b3;
            }
            bArr3[0] = b2;
            if (i9 == 0) {
                i6++;
            } else {
                if (i6 > 0) {
                    int i10 = i6 - 1;
                    while (true) {
                        if ((i10 & 1) == 0) {
                            cArr[i7] = 0;
                            i7++;
                            iArr2[0] = iArr2[0] + 1;
                        } else {
                            cArr[i7] = 1;
                            i7++;
                            iArr2[1] = iArr2[1] + 1;
                        }
                        if (i10 < 2) {
                            break;
                        }
                        i10 = (i10 - 2) >> 1;
                    }
                    i6 = 0;
                }
                int i11 = i9 + 1;
                cArr[i7] = (char) i11;
                i7++;
                iArr2[i11] = iArr2[i11] + 1;
            }
        }
        if (i6 > 0) {
            int i12 = i6 - 1;
            while (true) {
                if ((i12 & 1) == 0) {
                    cArr[i7] = 0;
                    i7++;
                    iArr2[0] = iArr2[0] + 1;
                } else {
                    cArr[i7] = 1;
                    i7++;
                    iArr2[1] = iArr2[1] + 1;
                }
                if (i12 < 2) {
                    break;
                }
                i12 = (i12 - 2) >> 1;
            }
        }
        cArr[i7] = (char) i4;
        iArr2[i4] = iArr2[i4] + 1;
        this.h = i7 + 1;
    }

    private void d(int i, int i2) {
        a aVar = this.n;
        byte[] bArr = aVar.l;
        while (true) {
            i--;
            if (i < 0) {
                break;
            }
            bArr[i] = (byte) i;
        }
        for (int i3 = 0; i3 < i2; i3++) {
            byte b = aVar.d[i3];
            byte b2 = bArr[0];
            int i4 = 0;
            while (b != b2) {
                i4++;
                byte b3 = bArr[i4];
                bArr[i4] = b2;
                b2 = b3;
            }
            bArr[0] = b2;
            aVar.e[i3] = (byte) i4;
        }
    }

    private int c(int i, int i2) {
        byte[] bArr;
        int i3;
        g5 g5Var = this;
        a aVar = g5Var.n;
        int[][] iArr = aVar.h;
        int[] iArr2 = aVar.i;
        short[] sArr = aVar.j;
        char[] cArr = aVar.s;
        byte[] bArr2 = aVar.d;
        byte[][] bArr3 = aVar.g;
        int i4 = 0;
        byte[] bArr4 = bArr3[0];
        byte[] bArr5 = bArr3[1];
        byte[] bArr6 = bArr3[2];
        byte[] bArr7 = bArr3[3];
        int i5 = 4;
        byte[] bArr8 = bArr3[4];
        byte[] bArr9 = bArr3[5];
        int i6 = g5Var.h;
        int i7 = 0;
        int i8 = 0;
        while (i7 < i5) {
            int i9 = i;
            while (true) {
                i9--;
                if (i9 < 0) {
                    break;
                }
                iArr2[i9] = i4;
                int[] iArr3 = iArr[i9];
                int i10 = i2;
                while (true) {
                    i10--;
                    if (i10 >= 0) {
                        iArr3[i10] = i4;
                    }
                }
            }
            int i11 = i4;
            i8 = i11;
            while (i11 < g5Var.h) {
                int i12 = i11;
                int min = Math.min((i11 + 50) - 1, i6 - 1);
                if (i == 6) {
                    int i13 = i12;
                    short s = 0;
                    short s2 = 0;
                    short s3 = 0;
                    short s4 = 0;
                    short s5 = 0;
                    short s6 = 0;
                    while (i13 <= min) {
                        char c = cArr[i13];
                        byte[] bArr10 = bArr4;
                        short s7 = (short) (s2 + (bArr5[c] & 255));
                        short s8 = (short) (s3 + (bArr6[c] & 255));
                        short s9 = (short) (s4 + (bArr7[c] & 255));
                        short s10 = (short) (s5 + (bArr8[c] & 255));
                        i13++;
                        s6 = (short) (s6 + (bArr9[c] & 255));
                        s5 = s10;
                        bArr4 = bArr10;
                        s4 = s9;
                        s3 = s8;
                        s2 = s7;
                        s = (short) (s + (bArr4[c] & 255));
                        i6 = i6;
                    }
                    bArr = bArr4;
                    i3 = i6;
                    sArr[0] = s;
                    sArr[1] = s2;
                    sArr[2] = s3;
                    sArr[3] = s4;
                    sArr[4] = s5;
                    sArr[5] = s6;
                } else {
                    bArr = bArr4;
                    i3 = i6;
                    int i14 = i;
                    while (true) {
                        i14--;
                        if (i14 < 0) {
                            break;
                        }
                        sArr[i14] = 0;
                    }
                    for (int i15 = i12; i15 <= min; i15++) {
                        char c2 = cArr[i15];
                        int i16 = i;
                        while (true) {
                            i16--;
                            if (i16 >= 0) {
                                sArr[i16] = (short) (sArr[i16] + (bArr3[i16][c2] & 255));
                            }
                        }
                    }
                }
                short s11 = 999999999;
                int i17 = -1;
                int i18 = i;
                while (true) {
                    i18--;
                    if (i18 < 0) {
                        break;
                    }
                    byte[] bArr11 = bArr5;
                    short s12 = sArr[i18];
                    if (s12 < s11) {
                        i17 = i18;
                        s11 = s12;
                    }
                    bArr5 = bArr11;
                }
                byte[] bArr12 = bArr5;
                iArr2[i17] = iArr2[i17] + 1;
                bArr2[i8] = (byte) i17;
                i8++;
                int[] iArr4 = iArr[i17];
                for (int i19 = i12; i19 <= min; i19++) {
                    char c3 = cArr[i19];
                    iArr4[c3] = iArr4[c3] + 1;
                }
                i11 = min + 1;
                bArr5 = bArr12;
                i6 = i3;
                bArr4 = bArr;
            }
            byte[] bArr13 = bArr4;
            byte[] bArr14 = bArr5;
            int i20 = i6;
            int i21 = 0;
            while (i21 < i) {
                a(bArr3[i21], iArr[i21], g5Var.n, i2, 20);
                i21++;
                g5Var = this;
            }
            i7++;
            g5Var = this;
            i5 = 4;
            bArr5 = bArr14;
            i6 = i20;
            bArr4 = bArr13;
            i4 = 0;
        }
        return i8;
    }

    /* JADX WARN: Type inference failed for: r0v2, types: [java.io.OutputStream, g5$a, i5] */
    public void a() throws IOException {
        if (this.q) {
            return;
        }
        this.q = true;
        try {
            if (this.j > 0) {
                m();
            }
            this.i = -1;
            d();
            e();
        } finally {
            this.p = null;
            this.o = null;
            this.n = null;
        }
    }

    private static void a(int[] iArr, byte[] bArr, int i, int i2, int i3) {
        int i4 = 0;
        while (i <= i2) {
            int i5 = i4;
            for (int i6 = 0; i6 < i3; i6++) {
                if ((bArr[i6] & 255) == i) {
                    iArr[i6] = i5;
                    i5++;
                }
            }
            i4 = i5 << 1;
            i++;
        }
    }

    private void a(int i, int i2) throws IOException {
        OutputStream outputStream = this.p;
        int i3 = this.e;
        int i4 = this.d;
        while (i3 >= 8) {
            outputStream.write(i4 >> 24);
            i4 <<= 8;
            i3 -= 8;
        }
        this.d = (i2 << ((32 - i3) - i)) | i4;
        this.e = i3 + i;
    }

    private void a(int i) throws IOException {
        a(8, (i >> 24) & 255);
        a(8, (i >> 16) & 255);
        a(8, (i >> 8) & 255);
        a(8, i & 255);
    }
}
