package defpackage;
/* renamed from: q5  reason: default package */
/* loaded from: classes.dex */
class q5 {
    static final int[] a = new int[256];

    static {
        for (int i = 0; i < 256; i++) {
            int i2 = i;
            for (int i3 = 0; i3 < 8; i3++) {
                int i4 = i2 & 1;
                i2 >>>= 1;
                if (i4 != 0) {
                    i2 ^= -306674912;
                }
            }
            a[i] = i2;
        }
    }
}
