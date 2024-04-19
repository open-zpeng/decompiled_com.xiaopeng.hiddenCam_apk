package defpackage;

import com.google.protobuf.Reader;
/* renamed from: r5  reason: default package */
/* loaded from: classes.dex */
final class r5 extends t5 {
    static /* synthetic */ Class s;
    private final s5 l;
    private final int[] m;
    private final u5 n;
    private final int o;
    private final int p;
    private int q;
    private int r;

    static {
        if (s == null) {
            s = a("org.tukaani.xz.lz.HC4");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public r5(int i, int i2, int i3, int i4, int i5, int i6) {
        super(i, i2, i3, i4, i5);
        this.q = -1;
        this.l = new s5(i);
        this.p = i + 1;
        int i7 = this.p;
        this.m = new int[i7];
        this.r = i7;
        this.n = new u5(i4 - 1);
        this.o = i6 <= 0 ? (i4 / 4) + 4 : i6;
    }

    static /* synthetic */ Class a(String str) {
        try {
            return Class.forName(str);
        } catch (ClassNotFoundException e) {
            throw new NoClassDefFoundError().initCause(e);
        }
    }

    private int g() {
        int c = c(4, 4);
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

    /* JADX WARN: Removed duplicated region for block: B:22:0x007c  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0092 A[LOOP:0: B:25:0x0092->B:28:0x00a2, LOOP_START, PHI: r7 
      PHI: (r7v13 int) = (r7v5 int), (r7v14 int) binds: [B:24:0x0090, B:28:0x00a2] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:34:0x00b4  */
    @Override // defpackage.t5
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public defpackage.u5 b() {
        /*
            Method dump skipped, instructions count: 279
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.r5.b():u5");
    }

    @Override // defpackage.t5
    public void c(int i) {
        while (true) {
            int i2 = i - 1;
            if (i <= 0) {
                return;
            }
            if (g() != 0) {
                this.l.a(this.e, this.f);
                this.m[this.q] = this.l.c();
                this.l.b(this.r);
            }
            i = i2;
        }
    }
}
