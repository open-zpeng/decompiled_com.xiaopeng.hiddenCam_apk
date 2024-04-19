package defpackage;

import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.OutputStream;
/* compiled from: CountingOutputStream.java */
/* renamed from: k5  reason: default package */
/* loaded from: classes.dex */
public class k5 extends FilterOutputStream {
    private long b;

    public k5(OutputStream outputStream) {
        super(outputStream);
        this.b = 0L;
    }

    protected void a(long j) {
        if (j != -1) {
            this.b += j;
        }
    }

    @Override // java.io.FilterOutputStream, java.io.OutputStream
    public void write(int i) throws IOException {
        ((FilterOutputStream) this).out.write(i);
        a(1L);
    }

    public long a() {
        return this.b;
    }

    @Override // java.io.FilterOutputStream, java.io.OutputStream
    public void write(byte[] bArr) throws IOException {
        write(bArr, 0, bArr.length);
    }

    @Override // java.io.FilterOutputStream, java.io.OutputStream
    public void write(byte[] bArr, int i, int i2) throws IOException {
        ((FilterOutputStream) this).out.write(bArr, i, i2);
        a(i2);
    }
}
