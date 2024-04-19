package defpackage;
/* renamed from: d6  reason: default package */
/* loaded from: classes.dex */
public final class d6 implements i6 {
    private final boolean a;
    private int b;

    public d6(boolean z, int i) {
        this.a = z;
        this.b = i + 8;
    }

    @Override // defpackage.i6
    public int a(byte[] bArr, int i, int i2) {
        int i3 = (i2 + i) - 4;
        int i4 = i;
        while (i4 <= i3) {
            if ((bArr[i4 + 3] & 255) == 235) {
                int i5 = i4 + 2;
                int i6 = i4 + 1;
                int i7 = ((((bArr[i5] & 255) << 16) | ((bArr[i6] & 255) << 8)) | (bArr[i4] & 255)) << 2;
                int i8 = (this.a ? i7 + ((this.b + i4) - i) : i7 - ((this.b + i4) - i)) >>> 2;
                bArr[i5] = (byte) (i8 >>> 16);
                bArr[i6] = (byte) (i8 >>> 8);
                bArr[i4] = (byte) i8;
            }
            i4 += 4;
        }
        int i9 = i4 - i;
        this.b += i9;
        return i9;
    }
}
