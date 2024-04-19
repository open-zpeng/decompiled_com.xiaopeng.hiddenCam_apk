package defpackage;

import java.io.IOException;
import java.io.OutputStream;
/* renamed from: t5  reason: default package */
/* loaded from: classes.dex */
public abstract class t5 {
    static /* synthetic */ Class k;
    private final int a;
    private final int b;
    final int c;
    final int d;
    final byte[] e;
    int f = -1;
    private int g = -1;
    private boolean h = false;
    private int i = 0;
    private int j = 0;

    static {
        if (k == null) {
            k = a("org.tukaani.xz.lz.LZEncoder");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public t5(int i, int i2, int i3, int i4, int i5) {
        this.e = new byte[a(i, i2, i3, i5)];
        this.a = i2 + i;
        this.b = i3 + i5;
        this.c = i5;
        this.d = i4;
    }

    private static int a(int i, int i2, int i3, int i4) {
        return i2 + i + i3 + i4 + Math.min((i / 2) + 262144, 536870912);
    }

    static /* synthetic */ Class a(String str) {
        try {
            return Class.forName(str);
        } catch (ClassNotFoundException e) {
            throw new NoClassDefFoundError().initCause(e);
        }
    }

    public static t5 a(int i, int i2, int i3, int i4, int i5, int i6, int i7) {
        if (i6 != 4) {
            if (i6 == 20) {
                return new p5(i, i2, i3, i4, i5, i7);
            }
            throw new IllegalArgumentException();
        }
        return new r5(i, i2, i3, i4, i5, i7);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(int[] iArr, int i) {
        for (int i2 = 0; i2 < iArr.length; i2++) {
            if (iArr[i2] <= i) {
                iArr[i2] = 0;
            } else {
                iArr[i2] = iArr[i2] - i;
            }
        }
    }

    private void g() {
        int i = ((this.f + 1) - this.a) & (-16);
        byte[] bArr = this.e;
        System.arraycopy(bArr, i, bArr, 0, this.i - i);
        this.f -= i;
        this.g -= i;
        this.i -= i;
    }

    private void h() {
        int i;
        int i2 = this.j;
        if (i2 <= 0 || (i = this.f) >= this.g) {
            return;
        }
        this.f = i - i2;
        this.j = 0;
        c(i2);
    }

    public int a() {
        return this.i - this.f;
    }

    public int a(int i) {
        return this.e[this.f - i] & 255;
    }

    public int a(int i, int i2) {
        return this.e[(this.f + i) - i2] & 255;
    }

    public int a(int i, int i2, int i3) {
        int i4 = this.f + i;
        int i5 = (i4 - i2) - 1;
        int i6 = 0;
        while (i6 < i3) {
            byte[] bArr = this.e;
            if (bArr[i4 + i6] != bArr[i5 + i6]) {
                break;
            }
            i6++;
        }
        return i6;
    }

    public int a(byte[] bArr, int i, int i2) {
        if (this.f >= this.e.length - this.b) {
            g();
        }
        byte[] bArr2 = this.e;
        int length = bArr2.length;
        int i3 = this.i;
        if (i2 > length - i3) {
            i2 = bArr2.length - i3;
        }
        System.arraycopy(bArr, i, this.e, this.i, i2);
        this.i += i2;
        int i4 = this.i;
        int i5 = this.b;
        if (i4 >= i5) {
            this.g = i4 - i5;
        }
        h();
        return i2;
    }

    public void a(int i, byte[] bArr) {
        if (bArr != null) {
            int min = Math.min(bArr.length, i);
            System.arraycopy(bArr, bArr.length - min, this.e, 0, min);
            this.i += min;
            c(min);
        }
    }

    public void a(OutputStream outputStream, int i, int i2) throws IOException {
        outputStream.write(this.e, (this.f + 1) - i, i2);
    }

    public int b(int i, int i2) {
        int i3 = (this.f - i) - 1;
        int i4 = 0;
        while (i4 < i2) {
            byte[] bArr = this.e;
            if (bArr[this.f + i4] != bArr[i3 + i4]) {
                break;
            }
            i4++;
        }
        return i4;
    }

    public abstract u5 b();

    public boolean b(int i) {
        return this.f - i < this.g;
    }

    public int c() {
        return this.f;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int c(int i, int i2) {
        this.f++;
        int i3 = this.i - this.f;
        if (i3 < i) {
            if (i3 < i2 || !this.h) {
                this.j++;
                return 0;
            }
            return i3;
        }
        return i3;
    }

    public abstract void c(int i);

    public boolean d() {
        return this.f != -1;
    }

    public void e() {
        this.g = this.i - 1;
        this.h = true;
        h();
    }

    public void f() {
        this.g = this.i - 1;
        h();
    }
}
