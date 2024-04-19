package defpackage;

import android.content.Context;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.graphics.fonts.FontVariationAxis;
import android.net.Uri;
import android.os.CancellationSignal;
import android.os.ParcelFileDescriptor;
import android.util.Log;
import defpackage.k1;
import defpackage.s0;
import java.io.IOException;
import java.lang.reflect.Array;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.nio.ByteBuffer;
import java.util.Map;
/* compiled from: TypefaceCompatApi26Impl.java */
/* renamed from: c1  reason: default package */
/* loaded from: classes.dex */
public class c1 extends a1 {
    protected final Class a;
    protected final Constructor b;
    protected final Method c;
    protected final Method d;
    protected final Method e;
    protected final Method f;
    protected final Method g;

    public c1() {
        Method method;
        Constructor constructor;
        Method method2;
        Method method3;
        Method method4;
        Method method5;
        Class cls = null;
        try {
            Class a = a();
            constructor = e(a);
            method2 = b(a);
            method3 = c(a);
            method4 = f(a);
            method5 = a(a);
            method = d(a);
            cls = a;
        } catch (ClassNotFoundException | NoSuchMethodException e) {
            Log.e("TypefaceCompatApi26Impl", "Unable to collect necessary methods for class " + e.getClass().getName(), e);
            method = null;
            constructor = null;
            method2 = null;
            method3 = null;
            method4 = null;
            method5 = null;
        }
        this.a = cls;
        this.b = constructor;
        this.c = method2;
        this.d = method3;
        this.e = method4;
        this.f = method5;
        this.g = method;
    }

    private boolean a(Context context, Object obj, String str, int i, int i2, int i3, FontVariationAxis[] fontVariationAxisArr) {
        try {
            return ((Boolean) this.c.invoke(obj, context.getAssets(), str, 0, false, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), fontVariationAxisArr)).booleanValue();
        } catch (IllegalAccessException | InvocationTargetException e) {
            throw new RuntimeException(e);
        }
    }

    private boolean b() {
        if (this.c == null) {
            Log.w("TypefaceCompatApi26Impl", "Unable to collect necessary private methods. Fallback to legacy implementation.");
        }
        return this.c != null;
    }

    private Object c() {
        try {
            return this.b.newInstance(new Object[0]);
        } catch (IllegalAccessException | InstantiationException | InvocationTargetException e) {
            throw new RuntimeException(e);
        }
    }

    protected Method d(Class cls) throws NoSuchMethodException {
        Class cls2 = Integer.TYPE;
        Method declaredMethod = Typeface.class.getDeclaredMethod("createFromFamiliesWithDefault", Array.newInstance(cls, 1).getClass(), cls2, cls2);
        declaredMethod.setAccessible(true);
        return declaredMethod;
    }

    protected Constructor e(Class cls) throws NoSuchMethodException {
        return cls.getConstructor(new Class[0]);
    }

    protected Method f(Class cls) throws NoSuchMethodException {
        return cls.getMethod("freeze", new Class[0]);
    }

    private boolean c(Object obj) {
        try {
            return ((Boolean) this.e.invoke(obj, new Object[0])).booleanValue();
        } catch (IllegalAccessException | InvocationTargetException e) {
            throw new RuntimeException(e);
        }
    }

    private void b(Object obj) {
        try {
            this.f.invoke(obj, new Object[0]);
        } catch (IllegalAccessException | InvocationTargetException e) {
            throw new RuntimeException(e);
        }
    }

    protected Method b(Class cls) throws NoSuchMethodException {
        Class<?> cls2 = Integer.TYPE;
        return cls.getMethod("addFontFromAssetManager", AssetManager.class, String.class, Integer.TYPE, Boolean.TYPE, cls2, cls2, cls2, FontVariationAxis[].class);
    }

    protected Method c(Class cls) throws NoSuchMethodException {
        Class<?> cls2 = Integer.TYPE;
        return cls.getMethod("addFontFromBuffer", ByteBuffer.class, cls2, FontVariationAxis[].class, cls2, cls2);
    }

    private boolean a(Object obj, ByteBuffer byteBuffer, int i, int i2, int i3) {
        try {
            return ((Boolean) this.d.invoke(obj, byteBuffer, Integer.valueOf(i), null, Integer.valueOf(i2), Integer.valueOf(i3))).booleanValue();
        } catch (IllegalAccessException | InvocationTargetException e) {
            throw new RuntimeException(e);
        }
    }

    protected Typeface a(Object obj) {
        try {
            Object newInstance = Array.newInstance(this.a, 1);
            Array.set(newInstance, 0, obj);
            return (Typeface) this.g.invoke(null, newInstance, -1, -1);
        } catch (IllegalAccessException | InvocationTargetException e) {
            throw new RuntimeException(e);
        }
    }

    @Override // defpackage.e1
    public Typeface a(Context context, s0.b bVar, Resources resources, int i) {
        s0.c[] a;
        if (!b()) {
            return super.a(context, bVar, resources, i);
        }
        Object c = c();
        for (s0.c cVar : bVar.a()) {
            if (!a(context, c, cVar.a(), cVar.c(), cVar.e(), cVar.f() ? 1 : 0, FontVariationAxis.fromFontVariationSettings(cVar.d()))) {
                b(c);
                return null;
            }
        }
        if (c(c)) {
            return a(c);
        }
        return null;
    }

    @Override // defpackage.a1, defpackage.e1
    public Typeface a(Context context, CancellationSignal cancellationSignal, k1.f[] fVarArr, int i) {
        if (fVarArr.length < 1) {
            return null;
        }
        if (!b()) {
            k1.f a = a(fVarArr, i);
            try {
                ParcelFileDescriptor openFileDescriptor = context.getContentResolver().openFileDescriptor(a.c(), "r", cancellationSignal);
                if (openFileDescriptor == null) {
                    if (openFileDescriptor != null) {
                        openFileDescriptor.close();
                    }
                    return null;
                }
                Typeface build = new Typeface.Builder(openFileDescriptor.getFileDescriptor()).setWeight(a.d()).setItalic(a.e()).build();
                if (openFileDescriptor != null) {
                    openFileDescriptor.close();
                }
                return build;
            } catch (IOException unused) {
                return null;
            }
        }
        Map<Uri, ByteBuffer> a2 = k1.a(context, fVarArr, cancellationSignal);
        Object c = c();
        boolean z = false;
        for (k1.f fVar : fVarArr) {
            ByteBuffer byteBuffer = a2.get(fVar.c());
            if (byteBuffer != null) {
                if (!a(c, byteBuffer, fVar.b(), fVar.d(), fVar.e() ? 1 : 0)) {
                    b(c);
                    return null;
                }
                z = true;
            }
        }
        if (!z) {
            b(c);
            return null;
        } else if (c(c)) {
            return Typeface.create(a(c), i);
        } else {
            return null;
        }
    }

    @Override // defpackage.e1
    public Typeface a(Context context, Resources resources, int i, String str, int i2) {
        if (!b()) {
            return super.a(context, resources, i, str, i2);
        }
        Object c = c();
        if (!a(context, c, str, 0, -1, -1, null)) {
            b(c);
            return null;
        } else if (c(c)) {
            return a(c);
        } else {
            return null;
        }
    }

    protected Class a() throws ClassNotFoundException {
        return Class.forName("android.graphics.FontFamily");
    }

    protected Method a(Class cls) throws NoSuchMethodException {
        return cls.getMethod("abortCreation", new Class[0]);
    }
}
