package defpackage;

import com.google.protobuf.Reader;
/* renamed from: p5  reason: default package */
/* loaded from: classes.dex */
final class p5 extends t5 {
    private final s5 l;
    private final int[] m;
    private final u5 n;
    private final int o;
    private final int p;
    private int q;
    private int r;

    /* JADX INFO: Access modifiers changed from: package-private */
    public p5(int i, int i2, int i3, int i4, int i5, int i6) {
        super(i, i2, i3, i4, i5);
        this.q = -1;
        this.p = i + 1;
        this.r = this.p;
        this.l = new s5(i);
        this.m = new int[this.p * 2];
        this.n = new u5(i4 - 1);
        this.o = i6 <= 0 ? (i4 / 2) + 16 : i6;
    }

    /* JADX WARN: Code restructure failed: missing block: B:25:0x007c, code lost:
        r13 = r12.m;
        r13[r2] = 0;
        r13[r1] = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x0082, code lost:
        return;
     */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0067  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0072  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void d(int r13, int r14) {
        /*
            r12 = this;
            int r0 = r12.o
            int r1 = r12.q
            int r2 = r1 << 1
            int r2 = r2 + 1
            int r1 = r1 << 1
            r3 = 0
            r4 = r3
            r5 = r4
        Ld:
            int r6 = r12.r
            int r6 = r6 - r14
            int r7 = r0 + (-1)
            if (r0 == 0) goto L7c
            int r0 = r12.p
            if (r6 < r0) goto L19
            goto L7c
        L19:
            int r8 = r12.q
            int r9 = r8 - r6
            if (r6 <= r8) goto L20
            goto L21
        L20:
            r0 = r3
        L21:
            int r9 = r9 + r0
            int r0 = r9 << 1
            int r8 = java.lang.Math.min(r4, r5)
            byte[] r9 = r12.e
            int r10 = r12.f
            int r11 = r10 + r8
            int r11 = r11 - r6
            r11 = r9[r11]
            int r10 = r10 + r8
            r9 = r9[r10]
            if (r11 != r9) goto L55
        L36:
            int r8 = r8 + 1
            if (r8 != r13) goto L47
            int[] r13 = r12.m
            r14 = r13[r0]
            r13[r1] = r14
            int r0 = r0 + 1
            r14 = r13[r0]
            r13[r2] = r14
            return
        L47:
            byte[] r9 = r12.e
            int r10 = r12.f
            int r11 = r10 + r8
            int r11 = r11 - r6
            r11 = r9[r11]
            int r10 = r10 + r8
            r9 = r9[r10]
            if (r11 == r9) goto L36
        L55:
            byte[] r9 = r12.e
            int r10 = r12.f
            int r11 = r10 + r8
            int r11 = r11 - r6
            r6 = r9[r11]
            r6 = r6 & 255(0xff, float:3.57E-43)
            int r10 = r10 + r8
            r9 = r9[r10]
            r9 = r9 & 255(0xff, float:3.57E-43)
            if (r6 >= r9) goto L72
            int[] r5 = r12.m
            r5[r1] = r14
            int r0 = r0 + 1
            r14 = r5[r0]
            r1 = r0
            r5 = r8
            goto L7a
        L72:
            int[] r4 = r12.m
            r4[r2] = r14
            r14 = r4[r0]
            r2 = r0
            r4 = r8
        L7a:
            r0 = r7
            goto Ld
        L7c:
            int[] r13 = r12.m
            r13[r2] = r3
            r13[r1] = r3
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.p5.d(int, int):void");
    }

    private int g() {
        int c = c(this.d, 4);
        if (c != 0) {
            int i = this.r + 1;
            this.r = i;
            if (i == Integer.MAX_VALUE) {
                int i2 = Reader.READ_DONE - this.p;
                this.l.a(i2);
                t5.a(this.m, i2);
                this.r -= i2;
            }
            int i3 = this.q + 1;
            this.q = i3;
            if (i3 == this.p) {
                this.q = 0;
            }
        }
        return c;
    }

    /* JADX WARN: Code restructure failed: missing block: B:65:0x014f, code lost:
        r1 = r17.m;
        r1[r8] = 0;
        r1[r5] = 0;
     */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0078  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x008e A[LOOP:0: B:25:0x008e->B:28:0x009e, LOOP_START, PHI: r8 
      PHI: (r8v11 int) = (r8v4 int), (r8v12 int) binds: [B:24:0x008c, B:28:0x009e] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:36:0x00b5  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x0136  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x0142  */
    @Override // defpackage.t5
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public defpackage.u5 b() {
        /*
            Method dump skipped, instructions count: 344
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.p5.b():u5");
    }

    @Override // defpackage.t5
    public void c(int i) {
        while (true) {
            int i2 = i - 1;
            if (i <= 0) {
                return;
            }
            int i3 = this.d;
            int g = g();
            if (g < i3) {
                if (g == 0) {
                    i = i2;
                } else {
                    i3 = g;
                }
            }
            this.l.a(this.e, this.f);
            int c = this.l.c();
            this.l.b(this.r);
            d(i3, c);
            i = i2;
        }
    }
}
