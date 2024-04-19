package defpackage;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.os.CancellationSignal;
import defpackage.k1;
import defpackage.s0;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: TypefaceCompatBaseImpl.java */
/* renamed from: e1  reason: default package */
/* loaded from: classes.dex */
public class e1 {

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: TypefaceCompatBaseImpl.java */
    /* renamed from: e1$a */
    /* loaded from: classes.dex */
    public class a implements c<k1.f> {
        a(e1 e1Var) {
        }

        @Override // defpackage.e1.c
        public int a(k1.f fVar) {
            return fVar.d();
        }

        @Override // defpackage.e1.c
        public boolean b(k1.f fVar) {
            return fVar.e();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: TypefaceCompatBaseImpl.java */
    /* renamed from: e1$b */
    /* loaded from: classes.dex */
    public class b implements c<s0.c> {
        b(e1 e1Var) {
        }

        @Override // defpackage.e1.c
        public int a(s0.c cVar) {
            return cVar.e();
        }

        @Override // defpackage.e1.c
        public boolean b(s0.c cVar) {
            return cVar.f();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: TypefaceCompatBaseImpl.java */
    /* renamed from: e1$c */
    /* loaded from: classes.dex */
    public interface c<T> {
        int a(T t);

        boolean b(T t);
    }

    private static <T> T a(T[] tArr, int i, c<T> cVar) {
        int i2 = (i & 1) == 0 ? 400 : 700;
        boolean z = (i & 2) != 0;
        int i3 = Integer.MAX_VALUE;
        T t = null;
        for (T t2 : tArr) {
            int abs = (Math.abs(cVar.a(t2) - i2) * 2) + (cVar.b(t2) == z ? 0 : 1);
            if (t == null || i3 > abs) {
                t = t2;
                i3 = abs;
            }
        }
        return t;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public k1.f a(k1.f[] fVarArr, int i) {
        return (k1.f) a(fVarArr, i, new a(this));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public Typeface a(Context context, InputStream inputStream) {
        File a2 = f1.a(context);
        if (a2 == null) {
            return null;
        }
        try {
            if (f1.a(a2, inputStream)) {
                return Typeface.createFromFile(a2.getPath());
            }
            return null;
        } catch (RuntimeException unused) {
            return null;
        } finally {
            a2.delete();
        }
    }

    public Typeface a(Context context, CancellationSignal cancellationSignal, k1.f[] fVarArr, int i) {
        InputStream inputStream;
        InputStream inputStream2 = null;
        if (fVarArr.length < 1) {
            return null;
        }
        try {
            inputStream = context.getContentResolver().openInputStream(a(fVarArr, i).c());
        } catch (IOException unused) {
            inputStream = null;
        } catch (Throwable th) {
            th = th;
        }
        try {
            Typeface a2 = a(context, inputStream);
            f1.a(inputStream);
            return a2;
        } catch (IOException unused2) {
            f1.a(inputStream);
            return null;
        } catch (Throwable th2) {
            th = th2;
            inputStream2 = inputStream;
            f1.a(inputStream2);
            throw th;
        }
    }

    private s0.c a(s0.b bVar, int i) {
        return (s0.c) a(bVar.a(), i, new b(this));
    }

    public Typeface a(Context context, s0.b bVar, Resources resources, int i) {
        s0.c a2 = a(bVar, i);
        if (a2 == null) {
            return null;
        }
        return z0.a(context, resources, a2.b(), a2.a(), i);
    }

    public Typeface a(Context context, Resources resources, int i, String str, int i2) {
        File a2 = f1.a(context);
        if (a2 == null) {
            return null;
        }
        try {
            if (f1.a(a2, resources, i)) {
                return Typeface.createFromFile(a2.getPath());
            }
            return null;
        } catch (RuntimeException unused) {
            return null;
        } finally {
            a2.delete();
        }
    }
}
