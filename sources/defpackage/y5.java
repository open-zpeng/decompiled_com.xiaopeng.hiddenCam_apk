package defpackage;
/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: y5  reason: default package */
/* loaded from: classes.dex */
public final class y5 extends w5 {
    private static int I;
    private static int J;
    static /* synthetic */ Class K;
    private final z5[] C;
    private int D;
    private int E;
    private u5 F;
    private final int[] G;
    private final a6 H;

    static {
        if (K == null) {
            K = a("org.tukaani.xz.lzma.LZMAEncoderNormal");
        }
        I = 4096;
        J = 4096;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public y5(c6 c6Var, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
        super(c6Var, t5.a(i4, Math.max(i5, I), J, i6, 273, i7, i8), i, i2, i3, i4, i6);
        this.C = new z5[4096];
        this.D = 0;
        this.E = 0;
        this.G = new int[4];
        this.H = new a6();
        for (int i9 = 0; i9 < 4096; i9++) {
            this.C[i9] = new z5();
        }
    }

    static /* synthetic */ Class a(String str) {
        try {
            return Class.forName(str);
        } catch (ClassNotFoundException e) {
            throw new NoClassDefFoundError().initCause(e);
        }
    }

    private void a(int i, int i2, int i3, int i4, int i5) {
        int i6;
        u5 u5Var;
        int[] iArr;
        int i7;
        int i8 = i5;
        u5 u5Var2 = this.F;
        if (u5Var2.a[u5Var2.c - 1] > i3) {
            u5Var2.c = 0;
            while (true) {
                u5Var = this.F;
                iArr = u5Var.a;
                i7 = u5Var.c;
                if (iArr[i7] >= i3) {
                    break;
                }
                u5Var.c = i7 + 1;
            }
            u5Var.c = i7 + 1;
            iArr[i7] = i3;
        }
        u5 u5Var3 = this.F;
        if (u5Var3.a[u5Var3.c - 1] < i8) {
            return;
        }
        while (true) {
            int i9 = this.E;
            i6 = this.D;
            u5 u5Var4 = this.F;
            if (i9 >= u5Var4.a[u5Var4.c - 1] + i6) {
                break;
            }
            z5[] z5VarArr = this.C;
            int i10 = i9 + 1;
            this.E = i10;
            z5VarArr[i10].a();
        }
        int b = b(i4, this.C[i6].a);
        int i11 = 0;
        while (i8 > this.F.a[i11]) {
            i11++;
        }
        while (true) {
            int i12 = this.F.b[i11];
            int a = a(b, i12, i8, i2);
            z5[] z5VarArr2 = this.C;
            int i13 = this.D;
            if (a < z5VarArr2[i13 + i8].c) {
                z5VarArr2[i13 + i8].a(a, i13, i12 + 4);
            }
            if (i8 == this.F.a[i11]) {
                int a2 = this.n.a(i8 + 1, i12, Math.min(this.r, (i3 - i8) - 1));
                if (a2 >= 2) {
                    this.H.a(this.C[this.D].a);
                    this.H.f();
                    int i14 = i + i8;
                    int a3 = a + this.o.a(this.n.a(i8, 0), this.n.a(0), this.n.a(i8, 1), i14, this.H);
                    this.H.d();
                    int a4 = a3 + a(0, a2, this.H, (i14 + 1) & this.a);
                    int i15 = this.D + i8 + 1 + a2;
                    while (true) {
                        int i16 = this.E;
                        if (i16 >= i15) {
                            break;
                        }
                        z5[] z5VarArr3 = this.C;
                        int i17 = i16 + 1;
                        this.E = i17;
                        z5VarArr3[i17].a();
                    }
                    z5[] z5VarArr4 = this.C;
                    if (a4 < z5VarArr4[i15].c) {
                        z5VarArr4[i15].a(a4, this.D, i12 + 4, i8, 0);
                    }
                }
                i11++;
                if (i11 == this.F.c) {
                    return;
                }
            }
            i8++;
        }
    }

    private void b(int i, int i2, int i3, int i4) {
        boolean z;
        int a = this.n.a(0);
        int a2 = this.n.a(this.C[this.D].b[0] + 1);
        int a3 = this.C[this.D].c + this.o.a(a, a2, this.n.a(1), i, this.C[this.D].a);
        z5[] z5VarArr = this.C;
        int i5 = this.D;
        if (a3 < z5VarArr[i5 + 1].c) {
            z5VarArr[i5 + 1].a(a3, i5, -1);
            z = true;
        } else {
            z = false;
        }
        if (a2 == a) {
            z5[] z5VarArr2 = this.C;
            int i6 = this.D;
            if (z5VarArr2[i6 + 1].d == i6 || z5VarArr2[i6 + 1].e != 0) {
                int a4 = a(i4, this.C[this.D].a, i2);
                z5[] z5VarArr3 = this.C;
                int i7 = this.D;
                if (a4 <= z5VarArr3[i7 + 1].c) {
                    z5VarArr3[i7 + 1].a(a4, i7, 0);
                    z = true;
                }
            }
        }
        if (z || a2 == a || i3 <= 2) {
            return;
        }
        int a5 = this.n.a(1, this.C[this.D].b[0], Math.min(this.r, i3 - 1));
        if (a5 >= 2) {
            this.H.a(this.C[this.D].a);
            this.H.d();
            int a6 = a3 + a(0, a5, this.H, (i + 1) & this.a);
            int i8 = this.D + 1 + a5;
            while (true) {
                int i9 = this.E;
                if (i9 >= i8) {
                    break;
                }
                z5[] z5VarArr4 = this.C;
                int i10 = i9 + 1;
                this.E = i10;
                z5VarArr4[i10].a();
            }
            z5[] z5VarArr5 = this.C;
            if (a6 < z5VarArr5[i8].c) {
                z5VarArr5[i8].b(a6, this.D, 0);
            }
        }
    }

    private int c(int i, int i2, int i3, int i4) {
        int i5;
        int min = Math.min(i3, this.r);
        int i6 = 2;
        for (int i7 = 0; i7 < 4; i7++) {
            int b = this.n.b(this.C[this.D].b[i7], min);
            if (b >= 2) {
                while (true) {
                    int i8 = this.E;
                    i5 = this.D;
                    if (i8 >= i5 + b) {
                        break;
                    }
                    z5[] z5VarArr = this.C;
                    int i9 = i8 + 1;
                    this.E = i9;
                    z5VarArr[i9].a();
                }
                int b2 = b(i4, i7, this.C[i5].a, i2);
                for (int i10 = b; i10 >= 2; i10--) {
                    int b3 = this.q.b(i10, i2) + b2;
                    z5[] z5VarArr2 = this.C;
                    int i11 = this.D;
                    if (b3 < z5VarArr2[i11 + i10].c) {
                        z5VarArr2[i11 + i10].a(b3, i11, i7);
                    }
                }
                if (i7 == 0) {
                    i6 = b + 1;
                }
                int i12 = i6;
                int a = this.n.a(b + 1, this.C[this.D].b[i7], Math.min(this.r, (i3 - b) - 1));
                if (a >= 2) {
                    int b4 = b2 + this.q.b(b, i2);
                    this.H.a(this.C[this.D].a);
                    this.H.e();
                    int i13 = i + b;
                    int a2 = b4 + this.o.a(this.n.a(b, 0), this.n.a(0), this.n.a(b, 1), i13, this.H);
                    this.H.d();
                    int a3 = a2 + a(0, a, this.H, (i13 + 1) & this.a);
                    int i14 = this.D + b + 1 + a;
                    while (true) {
                        int i15 = this.E;
                        if (i15 >= i14) {
                            break;
                        }
                        z5[] z5VarArr3 = this.C;
                        int i16 = i15 + 1;
                        this.E = i16;
                        z5VarArr3[i16].a();
                    }
                    z5[] z5VarArr4 = this.C;
                    if (a3 < z5VarArr4[i14].c) {
                        z5VarArr4[i14].a(a3, this.D, i7, b, 0);
                    }
                }
                i6 = i12;
            }
        }
        return i6;
    }

    private int i() {
        int i = this.D;
        this.E = i;
        int i2 = this.C[i].d;
        while (true) {
            z5[] z5VarArr = this.C;
            int i3 = this.D;
            z5 z5Var = z5VarArr[i3];
            if (z5Var.f) {
                z5VarArr[i2].d = i3;
                z5VarArr[i2].e = -1;
                int i4 = i2 - 1;
                this.D = i2;
                if (z5Var.g) {
                    z5VarArr[i4].d = i4 + 1;
                    z5VarArr[i4].e = z5Var.i;
                    this.D = i4;
                    i2 = z5Var.h;
                } else {
                    i2 = i4;
                }
            }
            z5[] z5VarArr2 = this.C;
            int i5 = z5VarArr2[i2].d;
            z5VarArr2[i2].d = this.D;
            this.D = i2;
            if (this.D <= 0) {
                this.D = z5VarArr2[0].d;
                int i6 = this.D;
                this.y = z5VarArr2[i6].e;
                return i6;
            }
            i2 = i5;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:32:0x00ca  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0102  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void j() {
        /*
            Method dump skipped, instructions count: 278
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.y5.j():void");
    }

    @Override // defpackage.w5, defpackage.v5
    public void a() {
        this.D = 0;
        this.E = 0;
        super.a();
    }

    @Override // defpackage.w5
    int e() {
        int i;
        int i2 = this.D;
        if (i2 < this.E) {
            z5[] z5VarArr = this.C;
            int i3 = z5VarArr[i2].d - i2;
            this.D = z5VarArr[i2].d;
            this.y = z5VarArr[this.D].e;
            return i3;
        }
        this.D = 0;
        this.E = 0;
        this.y = -1;
        if (this.z == -1) {
            this.F = d();
        }
        int min = Math.min(this.n.a(), 273);
        if (min < 2) {
            return 1;
        }
        int i4 = 0;
        for (int i5 = 0; i5 < 4; i5++) {
            this.G[i5] = this.n.b(this.b[i5], min);
            int[] iArr = this.G;
            if (iArr[i5] < 2) {
                iArr[i5] = 0;
            } else if (iArr[i5] > iArr[i4]) {
                i4 = i5;
            }
        }
        int[] iArr2 = this.G;
        int i6 = iArr2[i4];
        int i7 = this.r;
        if (i6 >= i7) {
            this.y = i4;
            b(iArr2[i4] - 1);
            return this.G[i4];
        }
        u5 u5Var = this.F;
        int i8 = u5Var.c;
        if (i8 > 0) {
            i = u5Var.a[i8 - 1];
            int i9 = u5Var.b[i8 - 1];
            if (i >= i7) {
                this.y = i9 + 4;
                b(i - 1);
                return i;
            }
        } else {
            i = 0;
        }
        int a = this.n.a(0);
        int a2 = this.n.a(this.b[0] + 1);
        if (i >= 2 || a == a2 || this.G[i4] >= 2) {
            int c = this.n.c();
            int i10 = c & this.a;
            this.C[1].a(this.o.a(a, a2, this.n.a(1), c, this.c), 0, -1);
            int a3 = a(this.c, i10);
            int a4 = a(a3, this.c);
            if (a2 == a) {
                int a5 = a(a4, this.c, i10);
                z5[] z5VarArr2 = this.C;
                if (a5 < z5VarArr2[1].c) {
                    z5VarArr2[1].a(a5, 0, 0);
                }
            }
            this.E = Math.max(i, this.G[i4]);
            if (this.E < 2) {
                this.y = this.C[1].e;
                return 1;
            }
            h();
            this.C[0].a.a(this.c);
            System.arraycopy(this.b, 0, this.C[0].b, 0, 4);
            for (int i11 = this.E; i11 >= 2; i11--) {
                this.C[i11].a();
            }
            int i12 = 0;
            for (int i13 = 4; i12 < i13; i13 = 4) {
                int i14 = this.G[i12];
                if (i14 >= 2) {
                    int b = b(a4, i12, this.c, i10);
                    while (true) {
                        int b2 = this.q.b(i14, i10) + b;
                        z5[] z5VarArr3 = this.C;
                        if (b2 < z5VarArr3[i14].c) {
                            z5VarArr3[i14].a(b2, 0, i12);
                        }
                        i14--;
                        if (i14 < 2) {
                            break;
                        }
                    }
                }
                i12++;
            }
            int max = Math.max(this.G[0] + 1, 2);
            if (max <= i) {
                int b3 = b(a3, this.c);
                int i15 = 0;
                while (max > this.F.a[i15]) {
                    i15++;
                }
                while (true) {
                    int i16 = this.F.b[i15];
                    int a6 = a(b3, i16, max, i10);
                    z5[] z5VarArr4 = this.C;
                    if (a6 < z5VarArr4[max].c) {
                        z5VarArr4[max].a(a6, 0, i16 + 4);
                    }
                    u5 u5Var2 = this.F;
                    if (max == u5Var2.a[i15] && (i15 = i15 + 1) == u5Var2.c) {
                        break;
                    }
                    max++;
                }
            }
            int min2 = Math.min(this.n.a(), 4095);
            while (true) {
                int i17 = this.D + 1;
                this.D = i17;
                if (i17 >= this.E) {
                    break;
                }
                this.F = d();
                u5 u5Var3 = this.F;
                int i18 = u5Var3.c;
                if (i18 > 0 && u5Var3.a[i18 - 1] >= this.r) {
                    break;
                }
                int i19 = min2 - 1;
                int i20 = c + 1;
                int i21 = i20 & this.a;
                j();
                z5[] z5VarArr5 = this.C;
                int i22 = this.D;
                int a7 = z5VarArr5[i22].c + a(z5VarArr5[i22].a, i21);
                int a8 = a(a7, this.C[this.D].a);
                b(i20, i21, i19, a8);
                if (i19 >= 2) {
                    int c2 = c(i20, i21, i19, a8);
                    if (this.F.c > 0) {
                        a(i20, i21, i19, a7, c2);
                    }
                }
                min2 = i19;
                c = i20;
            }
            return i();
        }
        return 1;
    }
}
