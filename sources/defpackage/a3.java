package defpackage;

import androidx.lifecycle.f;
import androidx.lifecycle.r;
import java.io.FileDescriptor;
import java.io.PrintWriter;
/* compiled from: LoaderManager.java */
/* renamed from: a3  reason: default package */
/* loaded from: classes.dex */
public abstract class a3 {
    public static <T extends f & r> a3 a(T t) {
        return new b3(t, t.b());
    }

    public abstract void a();

    @Deprecated
    public abstract void a(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr);
}
