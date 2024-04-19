package defpackage;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.CancellationSignal;
import android.util.Log;
import defpackage.k1;
import defpackage.s0;
import java.lang.reflect.Array;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.nio.ByteBuffer;
import java.util.List;
/* compiled from: TypefaceCompatApi24Impl.java */
/* renamed from: b1  reason: default package */
/* loaded from: classes.dex */
class b1 extends e1 {
    private static final Class a;
    private static final Constructor b;
    private static final Method c;
    private static final Method d;

    static {
        Class<?> cls;
        Method method;
        Method method2;
        Constructor<?> constructor = null;
        try {
            cls = Class.forName("android.graphics.FontFamily");
            Constructor<?> constructor2 = cls.getConstructor(new Class[0]);
            method2 = cls.getMethod("addFontWeightStyle", ByteBuffer.class, Integer.TYPE, List.class, Integer.TYPE, Boolean.TYPE);
            method = Typeface.class.getMethod("createFromFamiliesWithDefault", Array.newInstance(cls, 1).getClass());
            constructor = constructor2;
        } catch (ClassNotFoundException | NoSuchMethodException e) {
            Log.e("TypefaceCompatApi24Impl", e.getClass().getName(), e);
            cls = null;
            method = null;
            method2 = null;
        }
        b = constructor;
        a = cls;
        c = method2;
        d = method;
    }

    public static boolean a() {
        if (c == null) {
            Log.w("TypefaceCompatApi24Impl", "Unable to collect necessary private methods.Fallback to legacy implementation.");
        }
        return c != null;
    }

    private static Object b() {
        try {
            return b.newInstance(new Object[0]);
        } catch (IllegalAccessException | InstantiationException | InvocationTargetException e) {
            throw new RuntimeException(e);
        }
    }

    private static boolean a(Object obj, ByteBuffer byteBuffer, int i, int i2, boolean z) {
        try {
            return ((Boolean) c.invoke(obj, byteBuffer, Integer.valueOf(i), null, Integer.valueOf(i2), Boolean.valueOf(z))).booleanValue();
        } catch (IllegalAccessException | InvocationTargetException e) {
            throw new RuntimeException(e);
        }
    }

    private static Typeface a(Object obj) {
        try {
            Object newInstance = Array.newInstance(a, 1);
            Array.set(newInstance, 0, obj);
            return (Typeface) d.invoke(null, newInstance);
        } catch (IllegalAccessException | InvocationTargetException e) {
            throw new RuntimeException(e);
        }
    }

    @Override // defpackage.e1
    public Typeface a(Context context, CancellationSignal cancellationSignal, k1.f[] fVarArr, int i) {
        Object b2 = b();
        j0 j0Var = new j0();
        for (k1.f fVar : fVarArr) {
            Uri c2 = fVar.c();
            ByteBuffer byteBuffer = (ByteBuffer) j0Var.get(c2);
            if (byteBuffer == null) {
                byteBuffer = f1.a(context, cancellationSignal, c2);
                j0Var.put(c2, byteBuffer);
            }
            if (!a(b2, byteBuffer, fVar.b(), fVar.d(), fVar.e())) {
                return null;
            }
        }
        return Typeface.create(a(b2), i);
    }

    @Override // defpackage.e1
    public Typeface a(Context context, s0.b bVar, Resources resources, int i) {
        s0.c[] a2;
        Object b2 = b();
        for (s0.c cVar : bVar.a()) {
            ByteBuffer a3 = f1.a(context, resources, cVar.b());
            if (a3 == null || !a(b2, a3, cVar.c(), cVar.e(), cVar.f())) {
                return null;
            }
        }
        return a(b2);
    }
}
