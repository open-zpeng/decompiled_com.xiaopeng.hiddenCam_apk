package defpackage;
/* renamed from: j6  reason: default package */
/* loaded from: classes.dex */
public final class j6 implements i6 {
    private static final boolean[] d = {true, true, true, false, true, false, false, false};
    private static final int[] e = {0, 1, 2, 2, 3, 3, 3, 3};
    private final boolean a;
    private int b;
    private int c = 0;

    public j6(boolean z, int i) {
        this.a = z;
        this.b = i + 5;
    }

    private static boolean a(byte b) {
        int i = b & 255;
        return i == 0 || i == 255;
    }

    /* JADX WARN: Code restructure failed: missing block: B:16:0x003f, code lost:
        if (a(r11[(r0 + 4) - defpackage.j6.e[r1]]) != false) goto L26;
     */
    @Override // defpackage.i6
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public int a(byte[] r11, int r12, int r13) {
        /*
            Method dump skipped, instructions count: 208
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.j6.a(byte[], int, int):int");
    }
}
