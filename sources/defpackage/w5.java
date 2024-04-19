package defpackage;

import defpackage.v5;
import java.lang.reflect.Array;
/* renamed from: w5  reason: default package */
/* loaded from: classes.dex */
public abstract class w5 extends v5 {
    static /* synthetic */ Class B;
    private int A;
    private final c6 m;
    final t5 n;
    final c o;
    final b p;
    final b q;
    final int r;
    private int s;
    private int t;
    private final int u;
    private final int[][] v;
    private final int[][] w;
    private final int[] x;
    int y;
    int z;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: w5$b */
    /* loaded from: classes.dex */
    public class b extends v5.a {
        private final int[] e;
        private final int[][] f;

        b(int i, int i2) {
            super(w5.this);
            int i3 = 1 << i;
            this.e = new int[i3];
            this.f = (int[][]) Array.newInstance(int.class, i3, Math.max((i2 - 2) + 1, 16));
        }

        private void a(int i) {
            int b = c6.b(this.a[0], 0);
            int i2 = 0;
            while (i2 < 8) {
                this.f[i][i2] = c6.c(this.b[i], i2) + b;
                i2++;
            }
            int b2 = c6.b(this.a[0], 1);
            int b3 = c6.b(this.a[1], 0);
            while (i2 < 16) {
                this.f[i][i2] = b2 + b3 + c6.c(this.c[i], i2 - 8);
                i2++;
            }
            int b4 = c6.b(this.a[1], 1);
            while (true) {
                int[][] iArr = this.f;
                if (i2 >= iArr[i].length) {
                    return;
                }
                iArr[i][i2] = b2 + b4 + c6.c(this.d, (i2 - 8) - 8);
                i2++;
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // defpackage.v5.a
        public void a() {
            super.a();
            int i = 0;
            while (true) {
                int[] iArr = this.e;
                if (i >= iArr.length) {
                    return;
                }
                iArr[i] = 0;
                i++;
            }
        }

        void a(int i, int i2) {
            int i3 = i - 2;
            if (i3 < 8) {
                w5.this.m.a(this.a, 0, 0);
                w5.this.m.a(this.b[i2], i3);
            } else {
                w5.this.m.a(this.a, 0, 1);
                int i4 = i3 - 8;
                if (i4 < 8) {
                    w5.this.m.a(this.a, 1, 0);
                    w5.this.m.a(this.c[i2], i4);
                } else {
                    w5.this.m.a(this.a, 1, 1);
                    w5.this.m.a(this.d, i4 - 8);
                }
            }
            int[] iArr = this.e;
            iArr[i2] = iArr[i2] - 1;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public int b(int i, int i2) {
            return this.f[i2][i - 2];
        }

        void b() {
            int i = 0;
            while (true) {
                int[] iArr = this.e;
                if (i >= iArr.length) {
                    return;
                }
                if (iArr[i] <= 0) {
                    iArr[i] = 32;
                    a(i);
                }
                i++;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: w5$c */
    /* loaded from: classes.dex */
    public class c extends v5.b {
        a[] c;

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: w5$c$a */
        /* loaded from: classes.dex */
        public class a extends v5.b.a {
            private a() {
                super(c.this);
            }

            int a(int i) {
                int i2 = i | 256;
                int i3 = 0;
                do {
                    i3 += c6.b(this.a[i2 >>> 8], (i2 >>> 7) & 1);
                    i2 <<= 1;
                } while (i2 < 65536);
                return i3;
            }

            int a(int i, int i2) {
                int i3 = 256;
                int i4 = i | 256;
                int i5 = 0;
                do {
                    i2 <<= 1;
                    i5 += c6.b(this.a[(i2 & i3) + i3 + (i4 >>> 8)], (i4 >>> 7) & 1);
                    i4 <<= 1;
                    i3 &= ~(i2 ^ i4);
                } while (i4 < 65536);
                return i5;
            }

            void b() {
                int i = 256;
                int a = w5.this.n.a(w5.this.z) | 256;
                if (w5.this.c.b()) {
                    do {
                        w5.this.m.a(this.a, a >>> 8, (a >>> 7) & 1);
                        a <<= 1;
                    } while (a < 65536);
                } else {
                    int a2 = w5.this.n.a(w5.this.b[0] + 1 + w5.this.z);
                    do {
                        a2 <<= 1;
                        w5.this.m.a(this.a, (a2 & i) + i + (a >>> 8), (a >>> 7) & 1);
                        a <<= 1;
                        i &= ~(a2 ^ a);
                    } while (a < 65536);
                }
                w5.this.c.d();
            }
        }

        static {
            if (w5.B == null) {
                w5.B = w5.a("org.tukaani.xz.lzma.LZMAEncoder");
            }
        }

        c(int i, int i2) {
            super(w5.this, i, i2);
            this.c = new a[1 << (i + i2)];
            int i3 = 0;
            while (true) {
                a[] aVarArr = this.c;
                if (i3 >= aVarArr.length) {
                    return;
                }
                aVarArr[i3] = new a();
                i3++;
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public int a(int i, int i2, int i3, int i4, a6 a6Var) {
            int b = c6.b(w5.this.d[a6Var.a()][w5.this.a & i4], 0);
            int a2 = a(i3, i4);
            return b + (a6Var.b() ? this.c[a2].a(i) : this.c[a2].a(i, i2));
        }

        void a() {
            w5 w5Var = w5.this;
            this.c[a(w5Var.n.a(w5Var.z + 1), w5.this.n.c() - w5.this.z)].b();
        }

        void b() {
            this.c[0].b();
        }

        void c() {
            int i = 0;
            while (true) {
                a[] aVarArr = this.c;
                if (i >= aVarArr.length) {
                    return;
                }
                aVarArr[i].a();
                i++;
            }
        }
    }

    static {
        if (B == null) {
            B = a("org.tukaani.xz.lzma.LZMAEncoder");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public w5(c6 c6Var, t5 t5Var, int i, int i2, int i3, int i4, int i5) {
        super(i3);
        this.s = 0;
        this.t = 0;
        this.w = (int[][]) Array.newInstance(int.class, 4, 128);
        this.x = new int[16];
        this.y = 0;
        this.z = -1;
        this.A = 0;
        this.m = c6Var;
        this.n = t5Var;
        this.r = i5;
        this.o = new c(i, i2);
        this.p = new b(i3, i5);
        this.q = new b(i3, i5);
        this.u = c(i4 - 1) + 1;
        this.v = (int[][]) Array.newInstance(int.class, 4, this.u);
        a();
    }

    static /* synthetic */ Class a(String str) {
        try {
            return Class.forName(str);
        } catch (ClassNotFoundException e) {
            throw new NoClassDefFoundError().initCause(e);
        }
    }

    public static w5 a(c6 c6Var, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9) {
        if (i4 != 1) {
            if (i4 == 2) {
                return new y5(c6Var, i, i2, i3, i5, i6, i7, i8, i9);
            }
            throw new IllegalArgumentException();
        }
        return new x5(c6Var, i, i2, i3, i5, i6, i7, i8, i9);
    }

    private void a(int i, int i2, int i3) {
        this.c.f();
        this.p.a(i2, i3);
        int c2 = c(i);
        this.m.a(this.j[v5.a(i2)], c2);
        if (c2 >= 4) {
            int i4 = (c2 >>> 1) - 1;
            int i5 = i - (((c2 & 1) | 2) << i4);
            if (c2 < 14) {
                this.m.b(this.k[c2 - 4], i5);
            } else {
                this.m.a(i5 >>> 4, i4 - 4);
                this.m.b(this.l, i5 & 15);
                this.t--;
            }
        }
        int[] iArr = this.b;
        iArr[3] = iArr[2];
        iArr[2] = iArr[1];
        iArr[1] = iArr[0];
        iArr[0] = i;
        this.s--;
    }

    private void b(int i, int i2, int i3) {
        if (i == 0) {
            this.m.a(this.f, this.c.a(), 0);
            this.m.a(this.i[this.c.a()], i3, i2 != 1 ? 1 : 0);
        } else {
            int i4 = this.b[i];
            this.m.a(this.f, this.c.a(), 1);
            if (i == 1) {
                this.m.a(this.g, this.c.a(), 0);
            } else {
                this.m.a(this.g, this.c.a(), 1);
                this.m.a(this.h, this.c.a(), i - 2);
                if (i == 3) {
                    int[] iArr = this.b;
                    iArr[3] = iArr[2];
                }
                int[] iArr2 = this.b;
                iArr2[2] = iArr2[1];
            }
            int[] iArr3 = this.b;
            iArr3[1] = iArr3[0];
            iArr3[0] = i4;
        }
        if (i2 == 1) {
            this.c.g();
            return;
        }
        this.q.a(i2, i3);
        this.c.e();
    }

    public static int c(int i) {
        int i2;
        int i3;
        if (i <= 4) {
            return i;
        }
        if (((-65536) & i) == 0) {
            i3 = i << 16;
            i2 = 15;
        } else {
            i2 = 31;
            i3 = i;
        }
        if (((-16777216) & i3) == 0) {
            i3 <<= 8;
            i2 -= 8;
        }
        if (((-268435456) & i3) == 0) {
            i3 <<= 4;
            i2 -= 4;
        }
        if (((-1073741824) & i3) == 0) {
            i3 <<= 2;
            i2 -= 2;
        }
        if ((i3 & Integer.MIN_VALUE) == 0) {
            i2--;
        }
        return (i2 << 1) + ((i >>> (i2 - 1)) & 1);
    }

    private boolean i() {
        if (this.n.b(0)) {
            b(1);
            this.m.a(this.d[this.c.a()], 0, 0);
            this.o.b();
            this.z--;
            this.A++;
            return true;
        }
        return false;
    }

    private boolean j() {
        if (this.n.b(this.z + 1)) {
            int e = e();
            int c2 = (this.n.c() - this.z) & this.a;
            if (this.y == -1) {
                this.m.a(this.d[this.c.a()], c2, 0);
                this.o.a();
            } else {
                this.m.a(this.d[this.c.a()], c2, 1);
                if (this.y < 4) {
                    this.m.a(this.e, this.c.a(), 1);
                    b(this.y, e, c2);
                } else {
                    this.m.a(this.e, this.c.a(), 0);
                    a(this.y - 4, e, c2);
                }
            }
            this.z -= e;
            this.A += e;
            return true;
        }
        return false;
    }

    private void k() {
        this.t = 16;
        for (int i = 0; i < 16; i++) {
            this.x[i] = c6.d(this.l, i);
        }
    }

    private void l() {
        this.s = 128;
        int i = 0;
        while (true) {
            if (i >= 4) {
                break;
            }
            for (int i2 = 0; i2 < this.u; i2++) {
                this.v[i][i2] = c6.c(this.j[i], i2);
            }
            for (int i3 = 14; i3 < this.u; i3++) {
                int[] iArr = this.v[i];
                iArr[i3] = iArr[i3] + c6.a(((i3 >>> 1) - 1) - 4);
            }
            for (int i4 = 0; i4 < 4; i4++) {
                this.w[i][i4] = this.v[i][i4];
            }
            i++;
        }
        int i5 = 4;
        int i6 = 4;
        while (i5 < 14) {
            int i7 = ((i5 & 1) | 2) << ((i5 >>> 1) - 1);
            int i8 = i5 - 4;
            int length = this.k[i8].length;
            int i9 = i6;
            for (int i10 = 0; i10 < length; i10++) {
                int d = c6.d(this.k[i8], i9 - i7);
                for (int i11 = 0; i11 < 4; i11++) {
                    this.w[i11][i9] = this.v[i11][i5] + d;
                }
                i9++;
            }
            i5++;
            i6 = i9;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int a(int i, int i2, int i3, int i4) {
        int b2 = i + this.p.b(i3, i4);
        int a2 = v5.a(i3);
        if (i2 < 128) {
            return b2 + this.w[a2][i2];
        }
        return b2 + this.v[a2][c(i2)] + this.x[i2 & 15];
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int a(int i, int i2, a6 a6Var, int i3) {
        return b(a(a(a6Var, i3), a6Var), i, a6Var, i3) + this.q.b(i2, i3);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int a(int i, a6 a6Var) {
        return i + c6.b(this.e[a6Var.a()], 1);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int a(int i, a6 a6Var, int i2) {
        return i + c6.b(this.f[a6Var.a()], 0) + c6.b(this.i[a6Var.a()][i2], 0);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int a(a6 a6Var, int i) {
        return c6.b(this.d[a6Var.a()][i], 1);
    }

    @Override // defpackage.v5
    public void a() {
        super.a();
        this.o.c();
        this.p.a();
        this.q.a();
        this.s = 0;
        this.t = 0;
        this.A += this.z + 1;
        this.z = -1;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int b(int i, int i2, a6 a6Var, int i3) {
        int b2;
        if (i2 == 0) {
            b2 = c6.b(this.f[a6Var.a()], 0) + c6.b(this.i[a6Var.a()][i3], 1);
        } else {
            i += c6.b(this.f[a6Var.a()], 1);
            if (i2 != 1) {
                return i + c6.b(this.g[a6Var.a()], 1) + c6.b(this.h[a6Var.a()], i2 - 2);
            }
            b2 = c6.b(this.g[a6Var.a()], 0);
        }
        return i + b2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int b(int i, a6 a6Var) {
        return i + c6.b(this.e[a6Var.a()], 0);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b(int i) {
        this.z += i;
        this.n.c(i);
    }

    public boolean b() {
        if (this.n.d() || i()) {
            while (this.A <= 2096879 && this.m.b() <= 65510) {
                if (!j()) {
                    return false;
                }
            }
            return true;
        }
        return false;
    }

    public t5 c() {
        return this.n;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public u5 d() {
        this.z++;
        return this.n.b();
    }

    abstract int e();

    public int f() {
        return this.A;
    }

    public void g() {
        this.A = 0;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void h() {
        if (this.s <= 0) {
            l();
        }
        if (this.t <= 0) {
            k();
        }
        this.p.b();
        this.q.b();
    }
}
