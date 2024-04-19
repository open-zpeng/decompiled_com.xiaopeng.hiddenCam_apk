package defpackage;
/* renamed from: n5  reason: default package */
/* loaded from: classes.dex */
abstract class n5 {
    final int a;
    final byte[] b = new byte[256];
    int c = 0;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n5(int i) {
        if (i < 1 || i > 256) {
            throw new IllegalArgumentException();
        }
        this.a = i;
    }
}
