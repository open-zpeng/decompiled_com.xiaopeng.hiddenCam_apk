package defpackage;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.os.Build;
import android.os.CancellationSignal;
import android.os.Handler;
import defpackage.k1;
import defpackage.s0;
import defpackage.v0;
/* compiled from: TypefaceCompat.java */
/* renamed from: z0  reason: default package */
/* loaded from: classes.dex */
public class z0 {
    private static final e1 a;
    private static final h0<String, Typeface> b;

    static {
        int i = Build.VERSION.SDK_INT;
        if (i >= 28) {
            a = new d1();
        } else if (i >= 26) {
            a = new c1();
        } else if (i >= 24 && b1.a()) {
            a = new b1();
        } else if (Build.VERSION.SDK_INT >= 21) {
            a = new a1();
        } else {
            a = new e1();
        }
        b = new h0<>(16);
    }

    private static String a(Resources resources, int i, int i2) {
        return resources.getResourcePackageName(i) + "-" + i + "-" + i2;
    }

    public static Typeface b(Resources resources, int i, int i2) {
        return b.b(a(resources, i, i2));
    }

    public static Typeface a(Context context, s0.a aVar, Resources resources, int i, int i2, v0.a aVar2, Handler handler, boolean z) {
        Typeface a2;
        if (aVar instanceof s0.d) {
            s0.d dVar = (s0.d) aVar;
            boolean z2 = false;
            if (!z ? aVar2 == null : dVar.a() == 0) {
                z2 = true;
            }
            a2 = k1.a(context, dVar.b(), aVar2, handler, z2, z ? dVar.c() : -1, i2);
        } else {
            a2 = a.a(context, (s0.b) aVar, resources, i2);
            if (aVar2 != null) {
                if (a2 != null) {
                    aVar2.a(a2, handler);
                } else {
                    aVar2.a(-3, handler);
                }
            }
        }
        if (a2 != null) {
            b.a(a(resources, i, i2), a2);
        }
        return a2;
    }

    public static Typeface a(Context context, Resources resources, int i, String str, int i2) {
        Typeface a2 = a.a(context, resources, i, str, i2);
        if (a2 != null) {
            b.a(a(resources, i, i2), a2);
        }
        return a2;
    }

    public static Typeface a(Context context, CancellationSignal cancellationSignal, k1.f[] fVarArr, int i) {
        return a.a(context, cancellationSignal, fVarArr, i);
    }
}
