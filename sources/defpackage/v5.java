package defpackage;

import com.uc.crashsdk.export.LogType;
import java.lang.reflect.Array;
/* renamed from: v5  reason: default package */
/* loaded from: classes.dex */
abstract class v5 {
    final int a;
    final int[] b = new int[4];
    final a6 c = new a6();
    final short[][] d = (short[][]) Array.newInstance(short.class, 12, 16);
    final short[] e = new short[12];
    final short[] f = new short[12];
    final short[] g = new short[12];
    final short[] h = new short[12];
    final short[][] i = (short[][]) Array.newInstance(short.class, 12, 16);
    final short[][] j = (short[][]) Array.newInstance(short.class, 4, 64);
    final short[][] k = {new short[2], new short[2], new short[4], new short[4], new short[8], new short[8], new short[16], new short[16], new short[32], new short[32]};
    final short[] l = new short[16];

    /* renamed from: v5$a */
    /* loaded from: classes.dex */
    abstract class a {
        final short[] a = new short[2];
        final short[][] b = (short[][]) Array.newInstance(short.class, 16, 8);
        final short[][] c = (short[][]) Array.newInstance(short.class, 16, 8);
        final short[] d = new short[256];

        /* JADX INFO: Access modifiers changed from: package-private */
        public a(v5 v5Var) {
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public void a() {
            b6.a(this.a);
            int i = 0;
            while (true) {
                short[][] sArr = this.b;
                if (i >= sArr.length) {
                    break;
                }
                b6.a(sArr[i]);
                i++;
            }
            for (int i2 = 0; i2 < this.b.length; i2++) {
                b6.a(this.c[i2]);
            }
            b6.a(this.d);
        }
    }

    /* renamed from: v5$b */
    /* loaded from: classes.dex */
    abstract class b {
        private final int a;
        private final int b;

        /* renamed from: v5$b$a */
        /* loaded from: classes.dex */
        abstract class a {
            final short[] a = new short[LogType.UNEXP_OTHER];

            /* JADX INFO: Access modifiers changed from: package-private */
            public a(b bVar) {
            }

            /* JADX INFO: Access modifiers changed from: package-private */
            public void a() {
                b6.a(this.a);
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public b(v5 v5Var, int i, int i2) {
            this.a = i;
            this.b = (1 << i2) - 1;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public final int a(int i, int i2) {
            int i3 = this.a;
            return (i >> (8 - i3)) + ((i2 & this.b) << i3);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public v5(int i) {
        this.a = (1 << i) - 1;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final int a(int i) {
        if (i < 6) {
            return i - 2;
        }
        return 3;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a() {
        int[] iArr = this.b;
        int i = 0;
        iArr[0] = 0;
        iArr[1] = 0;
        iArr[2] = 0;
        iArr[3] = 0;
        this.c.c();
        int i2 = 0;
        while (true) {
            short[][] sArr = this.d;
            if (i2 >= sArr.length) {
                break;
            }
            b6.a(sArr[i2]);
            i2++;
        }
        b6.a(this.e);
        b6.a(this.f);
        b6.a(this.g);
        b6.a(this.h);
        int i3 = 0;
        while (true) {
            short[][] sArr2 = this.i;
            if (i3 >= sArr2.length) {
                break;
            }
            b6.a(sArr2[i3]);
            i3++;
        }
        int i4 = 0;
        while (true) {
            short[][] sArr3 = this.j;
            if (i4 >= sArr3.length) {
                break;
            }
            b6.a(sArr3[i4]);
            i4++;
        }
        while (true) {
            short[][] sArr4 = this.k;
            if (i >= sArr4.length) {
                b6.a(this.l);
                return;
            } else {
                b6.a(sArr4[i]);
                i++;
            }
        }
    }
}
