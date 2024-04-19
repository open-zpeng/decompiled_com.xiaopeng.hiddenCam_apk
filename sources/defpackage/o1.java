package defpackage;

import android.util.Log;
import java.io.Writer;
/* compiled from: LogWriter.java */
/* renamed from: o1  reason: default package */
/* loaded from: classes.dex */
public class o1 extends Writer {
    private final String b;
    private StringBuilder c = new StringBuilder(128);

    public o1(String str) {
        this.b = str;
    }

    private void a() {
        if (this.c.length() > 0) {
            Log.d(this.b, this.c.toString());
            StringBuilder sb = this.c;
            sb.delete(0, sb.length());
        }
    }

    @Override // java.io.Writer, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        a();
    }

    @Override // java.io.Writer, java.io.Flushable
    public void flush() {
        a();
    }

    @Override // java.io.Writer
    public void write(char[] cArr, int i, int i2) {
        for (int i3 = 0; i3 < i2; i3++) {
            char c = cArr[i + i3];
            if (c == '\n') {
                a();
            } else {
                this.c.append(c);
            }
        }
    }
}
