package defpackage;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PathMeasure;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.Rect;
import android.graphics.Shader;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.VectorDrawable;
import android.os.Build;
import android.util.AttributeSet;
import android.util.Log;
import android.util.Xml;
import com.xiaopeng.lib.apirouter.ClientConstants;
import defpackage.y0;
import java.io.IOException;
import java.util.ArrayDeque;
import java.util.ArrayList;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
/* compiled from: VectorDrawableCompat.java */
/* renamed from: l3  reason: default package */
/* loaded from: classes.dex */
public class l3 extends k3 {
    static final PorterDuff.Mode k = PorterDuff.Mode.SRC_IN;
    private h c;
    private PorterDuffColorFilter d;
    private ColorFilter e;
    private boolean f;
    private boolean g;
    private final float[] h;
    private final Matrix i;
    private final Rect j;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: VectorDrawableCompat.java */
    /* renamed from: l3$b */
    /* loaded from: classes.dex */
    public static class b extends f {
        public b() {
        }

        public void a(Resources resources, AttributeSet attributeSet, Resources.Theme theme, XmlPullParser xmlPullParser) {
            if (w0.a(xmlPullParser, "pathData")) {
                TypedArray a = w0.a(resources, theme, attributeSet, d3.d);
                a(a);
                a.recycle();
            }
        }

        @Override // defpackage.l3.f
        public boolean b() {
            return true;
        }

        public b(b bVar) {
            super(bVar);
        }

        private void a(TypedArray typedArray) {
            String string = typedArray.getString(0);
            if (string != null) {
                this.b = string;
            }
            String string2 = typedArray.getString(1);
            if (string2 != null) {
                this.a = y0.a(string2);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: VectorDrawableCompat.java */
    /* renamed from: l3$e */
    /* loaded from: classes.dex */
    public static abstract class e {
        private e() {
        }

        public boolean a() {
            return false;
        }

        public boolean a(int[] iArr) {
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: VectorDrawableCompat.java */
    /* renamed from: l3$h */
    /* loaded from: classes.dex */
    public static class h extends Drawable.ConstantState {
        int a;
        g b;
        ColorStateList c;
        PorterDuff.Mode d;
        boolean e;
        Bitmap f;
        ColorStateList g;
        PorterDuff.Mode h;
        int i;
        boolean j;
        boolean k;
        Paint l;

        public h(h hVar) {
            this.c = null;
            this.d = l3.k;
            if (hVar != null) {
                this.a = hVar.a;
                this.b = new g(hVar.b);
                Paint paint = hVar.b.e;
                if (paint != null) {
                    this.b.e = new Paint(paint);
                }
                Paint paint2 = hVar.b.d;
                if (paint2 != null) {
                    this.b.d = new Paint(paint2);
                }
                this.c = hVar.c;
                this.d = hVar.d;
                this.e = hVar.e;
            }
        }

        public void a(Canvas canvas, ColorFilter colorFilter, Rect rect) {
            canvas.drawBitmap(this.f, (Rect) null, rect, a(colorFilter));
        }

        public boolean b() {
            return this.b.getRootAlpha() < 255;
        }

        public void c(int i, int i2) {
            this.f.eraseColor(0);
            this.b.a(new Canvas(this.f), i, i2, (ColorFilter) null);
        }

        public void d() {
            this.g = this.c;
            this.h = this.d;
            this.i = this.b.getRootAlpha();
            this.j = this.e;
            this.k = false;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public int getChangingConfigurations() {
            return this.a;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable() {
            return new l3(this);
        }

        public void b(int i, int i2) {
            if (this.f == null || !a(i, i2)) {
                this.f = Bitmap.createBitmap(i, i2, Bitmap.Config.ARGB_8888);
                this.k = true;
            }
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable(Resources resources) {
            return new l3(this);
        }

        public Paint a(ColorFilter colorFilter) {
            if (b() || colorFilter != null) {
                if (this.l == null) {
                    this.l = new Paint();
                    this.l.setFilterBitmap(true);
                }
                this.l.setAlpha(this.b.getRootAlpha());
                this.l.setColorFilter(colorFilter);
                return this.l;
            }
            return null;
        }

        public boolean c() {
            return this.b.a();
        }

        public boolean a(int i, int i2) {
            return i == this.f.getWidth() && i2 == this.f.getHeight();
        }

        public boolean a() {
            return !this.k && this.g == this.c && this.h == this.d && this.j == this.e && this.i == this.b.getRootAlpha();
        }

        public h() {
            this.c = null;
            this.d = l3.k;
            this.b = new g();
        }

        public boolean a(int[] iArr) {
            boolean a = this.b.a(iArr);
            this.k |= a;
            return a;
        }
    }

    l3() {
        this.g = true;
        this.h = new float[9];
        this.i = new Matrix();
        this.j = new Rect();
        this.c = new h();
    }

    public static l3 createFromXmlInner(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) throws XmlPullParserException, IOException {
        l3 l3Var = new l3();
        l3Var.inflate(resources, xmlPullParser, attributeSet, theme);
        return l3Var;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Object a(String str) {
        return this.c.b.p.get(str);
    }

    @Override // android.graphics.drawable.Drawable
    public boolean canApplyTheme() {
        Drawable drawable = this.b;
        if (drawable != null) {
            androidx.core.graphics.drawable.a.a(drawable);
            return false;
        }
        return false;
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        Drawable drawable = this.b;
        if (drawable != null) {
            drawable.draw(canvas);
            return;
        }
        copyBounds(this.j);
        if (this.j.width() <= 0 || this.j.height() <= 0) {
            return;
        }
        ColorFilter colorFilter = this.e;
        if (colorFilter == null) {
            colorFilter = this.d;
        }
        canvas.getMatrix(this.i);
        this.i.getValues(this.h);
        float abs = Math.abs(this.h[0]);
        float abs2 = Math.abs(this.h[4]);
        float abs3 = Math.abs(this.h[1]);
        float abs4 = Math.abs(this.h[3]);
        if (abs3 != 0.0f || abs4 != 0.0f) {
            abs = 1.0f;
            abs2 = 1.0f;
        }
        int min = Math.min(2048, (int) (this.j.width() * abs));
        int min2 = Math.min(2048, (int) (this.j.height() * abs2));
        if (min <= 0 || min2 <= 0) {
            return;
        }
        int save = canvas.save();
        Rect rect = this.j;
        canvas.translate(rect.left, rect.top);
        if (a()) {
            canvas.translate(this.j.width(), 0.0f);
            canvas.scale(-1.0f, 1.0f);
        }
        this.j.offsetTo(0, 0);
        this.c.b(min, min2);
        if (!this.g) {
            this.c.c(min, min2);
        } else if (!this.c.a()) {
            this.c.c(min, min2);
            this.c.d();
        }
        this.c.a(canvas, colorFilter, this.j);
        canvas.restoreToCount(save);
    }

    @Override // android.graphics.drawable.Drawable
    public int getAlpha() {
        Drawable drawable = this.b;
        if (drawable != null) {
            return androidx.core.graphics.drawable.a.b(drawable);
        }
        return this.c.b.getRootAlpha();
    }

    @Override // android.graphics.drawable.Drawable
    public int getChangingConfigurations() {
        Drawable drawable = this.b;
        if (drawable != null) {
            return drawable.getChangingConfigurations();
        }
        return super.getChangingConfigurations() | this.c.getChangingConfigurations();
    }

    @Override // android.graphics.drawable.Drawable
    public Drawable.ConstantState getConstantState() {
        Drawable drawable = this.b;
        if (drawable != null && Build.VERSION.SDK_INT >= 24) {
            return new i(drawable.getConstantState());
        }
        this.c.a = getChangingConfigurations();
        return this.c;
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        Drawable drawable = this.b;
        if (drawable != null) {
            return drawable.getIntrinsicHeight();
        }
        return (int) this.c.b.j;
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        Drawable drawable = this.b;
        if (drawable != null) {
            return drawable.getIntrinsicWidth();
        }
        return (int) this.c.b.i;
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        Drawable drawable = this.b;
        if (drawable != null) {
            return drawable.getOpacity();
        }
        return -3;
    }

    @Override // android.graphics.drawable.Drawable
    public void inflate(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet) throws XmlPullParserException, IOException {
        Drawable drawable = this.b;
        if (drawable != null) {
            drawable.inflate(resources, xmlPullParser, attributeSet);
        } else {
            inflate(resources, xmlPullParser, attributeSet, null);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void invalidateSelf() {
        Drawable drawable = this.b;
        if (drawable != null) {
            drawable.invalidateSelf();
        } else {
            super.invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isAutoMirrored() {
        Drawable drawable = this.b;
        if (drawable != null) {
            return androidx.core.graphics.drawable.a.e(drawable);
        }
        return this.c.e;
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isStateful() {
        h hVar;
        ColorStateList colorStateList;
        Drawable drawable = this.b;
        if (drawable != null) {
            return drawable.isStateful();
        }
        return super.isStateful() || ((hVar = this.c) != null && (hVar.c() || ((colorStateList = this.c.c) != null && colorStateList.isStateful())));
    }

    @Override // android.graphics.drawable.Drawable
    public Drawable mutate() {
        Drawable drawable = this.b;
        if (drawable != null) {
            drawable.mutate();
            return this;
        }
        if (!this.f && super.mutate() == this) {
            this.c = new h(this.c);
            this.f = true;
        }
        return this;
    }

    @Override // android.graphics.drawable.Drawable
    protected void onBoundsChange(Rect rect) {
        Drawable drawable = this.b;
        if (drawable != null) {
            drawable.setBounds(rect);
        }
    }

    @Override // android.graphics.drawable.Drawable
    protected boolean onStateChange(int[] iArr) {
        PorterDuff.Mode mode;
        Drawable drawable = this.b;
        if (drawable != null) {
            return drawable.setState(iArr);
        }
        boolean z = false;
        h hVar = this.c;
        ColorStateList colorStateList = hVar.c;
        if (colorStateList != null && (mode = hVar.d) != null) {
            this.d = updateTintFilter(this.d, colorStateList, mode);
            invalidateSelf();
            z = true;
        }
        if (hVar.c() && hVar.a(iArr)) {
            invalidateSelf();
            return true;
        }
        return z;
    }

    @Override // android.graphics.drawable.Drawable
    public void scheduleSelf(Runnable runnable, long j) {
        Drawable drawable = this.b;
        if (drawable != null) {
            drawable.scheduleSelf(runnable, j);
        } else {
            super.scheduleSelf(runnable, j);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i2) {
        Drawable drawable = this.b;
        if (drawable != null) {
            drawable.setAlpha(i2);
        } else if (this.c.b.getRootAlpha() != i2) {
            this.c.b.setRootAlpha(i2);
            invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setAutoMirrored(boolean z) {
        Drawable drawable = this.b;
        if (drawable != null) {
            androidx.core.graphics.drawable.a.a(drawable, z);
        } else {
            this.c.e = z;
        }
    }

    @Override // android.graphics.drawable.Drawable, androidx.core.graphics.drawable.b
    public void setTint(int i2) {
        Drawable drawable = this.b;
        if (drawable != null) {
            androidx.core.graphics.drawable.a.b(drawable, i2);
        } else {
            setTintList(ColorStateList.valueOf(i2));
        }
    }

    @Override // android.graphics.drawable.Drawable, androidx.core.graphics.drawable.b
    public void setTintList(ColorStateList colorStateList) {
        Drawable drawable = this.b;
        if (drawable != null) {
            androidx.core.graphics.drawable.a.a(drawable, colorStateList);
            return;
        }
        h hVar = this.c;
        if (hVar.c != colorStateList) {
            hVar.c = colorStateList;
            this.d = updateTintFilter(this.d, colorStateList, hVar.d);
            invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Drawable, androidx.core.graphics.drawable.b
    public void setTintMode(PorterDuff.Mode mode) {
        Drawable drawable = this.b;
        if (drawable != null) {
            androidx.core.graphics.drawable.a.a(drawable, mode);
            return;
        }
        h hVar = this.c;
        if (hVar.d != mode) {
            hVar.d = mode;
            this.d = updateTintFilter(this.d, hVar.c, mode);
            invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public boolean setVisible(boolean z, boolean z2) {
        Drawable drawable = this.b;
        if (drawable != null) {
            return drawable.setVisible(z, z2);
        }
        return super.setVisible(z, z2);
    }

    @Override // android.graphics.drawable.Drawable
    public void unscheduleSelf(Runnable runnable) {
        Drawable drawable = this.b;
        if (drawable != null) {
            drawable.unscheduleSelf(runnable);
        } else {
            super.unscheduleSelf(runnable);
        }
    }

    PorterDuffColorFilter updateTintFilter(PorterDuffColorFilter porterDuffColorFilter, ColorStateList colorStateList, PorterDuff.Mode mode) {
        if (colorStateList == null || mode == null) {
            return null;
        }
        return new PorterDuffColorFilter(colorStateList.getColorForState(getState(), 0), mode);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: VectorDrawableCompat.java */
    /* renamed from: l3$f */
    /* loaded from: classes.dex */
    public static abstract class f extends e {
        protected y0.b[] a;
        String b;
        int c;

        public f() {
            super();
            this.a = null;
        }

        public void a(Path path) {
            path.reset();
            y0.b[] bVarArr = this.a;
            if (bVarArr != null) {
                y0.b.a(bVarArr, path);
            }
        }

        public boolean b() {
            return false;
        }

        public y0.b[] getPathData() {
            return this.a;
        }

        public String getPathName() {
            return this.b;
        }

        public void setPathData(y0.b[] bVarArr) {
            if (!y0.a(this.a, bVarArr)) {
                this.a = y0.a(bVarArr);
            } else {
                y0.b(this.a, bVarArr);
            }
        }

        public f(f fVar) {
            super();
            this.a = null;
            this.b = fVar.b;
            this.c = fVar.c;
            this.a = y0.a(fVar.a);
        }
    }

    /* compiled from: VectorDrawableCompat.java */
    /* renamed from: l3$i */
    /* loaded from: classes.dex */
    private static class i extends Drawable.ConstantState {
        private final Drawable.ConstantState a;

        public i(Drawable.ConstantState constantState) {
            this.a = constantState;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public boolean canApplyTheme() {
            return this.a.canApplyTheme();
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public int getChangingConfigurations() {
            return this.a.getChangingConfigurations();
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable() {
            l3 l3Var = new l3();
            l3Var.b = (VectorDrawable) this.a.newDrawable();
            return l3Var;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable(Resources resources) {
            l3 l3Var = new l3();
            l3Var.b = (VectorDrawable) this.a.newDrawable(resources);
            return l3Var;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable(Resources resources, Resources.Theme theme) {
            l3 l3Var = new l3();
            l3Var.b = (VectorDrawable) this.a.newDrawable(resources, theme);
            return l3Var;
        }
    }

    public static l3 a(Resources resources, int i2, Resources.Theme theme) {
        int next;
        if (Build.VERSION.SDK_INT >= 24) {
            l3 l3Var = new l3();
            l3Var.b = v0.a(resources, i2, theme);
            new i(l3Var.b.getConstantState());
            return l3Var;
        }
        try {
            XmlResourceParser xml = resources.getXml(i2);
            AttributeSet asAttributeSet = Xml.asAttributeSet(xml);
            while (true) {
                next = xml.next();
                if (next == 2 || next == 1) {
                    break;
                }
            }
            if (next == 2) {
                return createFromXmlInner(resources, (XmlPullParser) xml, asAttributeSet, theme);
            }
            throw new XmlPullParserException("No start tag found");
        } catch (IOException e2) {
            Log.e("VectorDrawableCompat", "parser error", e2);
            return null;
        } catch (XmlPullParserException e3) {
            Log.e("VectorDrawableCompat", "parser error", e3);
            return null;
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        Drawable drawable = this.b;
        if (drawable != null) {
            drawable.setColorFilter(colorFilter);
            return;
        }
        this.e = colorFilter;
        invalidateSelf();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: VectorDrawableCompat.java */
    /* renamed from: l3$c */
    /* loaded from: classes.dex */
    public static class c extends f {
        private int[] d;
        r0 e;
        float f;
        r0 g;
        float h;
        int i;
        float j;
        float k;
        float l;
        float m;
        Paint.Cap n;
        Paint.Join o;
        float p;

        public c() {
            this.f = 0.0f;
            this.h = 1.0f;
            this.i = 0;
            this.j = 1.0f;
            this.k = 0.0f;
            this.l = 1.0f;
            this.m = 0.0f;
            this.n = Paint.Cap.BUTT;
            this.o = Paint.Join.MITER;
            this.p = 4.0f;
        }

        private Paint.Cap a(int i, Paint.Cap cap) {
            if (i != 0) {
                if (i != 1) {
                    return i != 2 ? cap : Paint.Cap.SQUARE;
                }
                return Paint.Cap.ROUND;
            }
            return Paint.Cap.BUTT;
        }

        float getFillAlpha() {
            return this.j;
        }

        int getFillColor() {
            return this.g.a();
        }

        float getStrokeAlpha() {
            return this.h;
        }

        int getStrokeColor() {
            return this.e.a();
        }

        float getStrokeWidth() {
            return this.f;
        }

        float getTrimPathEnd() {
            return this.l;
        }

        float getTrimPathOffset() {
            return this.m;
        }

        float getTrimPathStart() {
            return this.k;
        }

        void setFillAlpha(float f) {
            this.j = f;
        }

        void setFillColor(int i) {
            this.g.a(i);
        }

        void setStrokeAlpha(float f) {
            this.h = f;
        }

        void setStrokeColor(int i) {
            this.e.a(i);
        }

        void setStrokeWidth(float f) {
            this.f = f;
        }

        void setTrimPathEnd(float f) {
            this.l = f;
        }

        void setTrimPathOffset(float f) {
            this.m = f;
        }

        void setTrimPathStart(float f) {
            this.k = f;
        }

        private Paint.Join a(int i, Paint.Join join) {
            if (i != 0) {
                if (i != 1) {
                    return i != 2 ? join : Paint.Join.BEVEL;
                }
                return Paint.Join.ROUND;
            }
            return Paint.Join.MITER;
        }

        public void a(Resources resources, AttributeSet attributeSet, Resources.Theme theme, XmlPullParser xmlPullParser) {
            TypedArray a = w0.a(resources, theme, attributeSet, d3.c);
            a(a, xmlPullParser, theme);
            a.recycle();
        }

        private void a(TypedArray typedArray, XmlPullParser xmlPullParser, Resources.Theme theme) {
            this.d = null;
            if (w0.a(xmlPullParser, "pathData")) {
                String string = typedArray.getString(0);
                if (string != null) {
                    this.b = string;
                }
                String string2 = typedArray.getString(2);
                if (string2 != null) {
                    this.a = y0.a(string2);
                }
                this.g = w0.a(typedArray, xmlPullParser, theme, "fillColor", 1, 0);
                this.j = w0.a(typedArray, xmlPullParser, "fillAlpha", 12, this.j);
                this.n = a(w0.b(typedArray, xmlPullParser, "strokeLineCap", 8, -1), this.n);
                this.o = a(w0.b(typedArray, xmlPullParser, "strokeLineJoin", 9, -1), this.o);
                this.p = w0.a(typedArray, xmlPullParser, "strokeMiterLimit", 10, this.p);
                this.e = w0.a(typedArray, xmlPullParser, theme, "strokeColor", 3, 0);
                this.h = w0.a(typedArray, xmlPullParser, "strokeAlpha", 11, this.h);
                this.f = w0.a(typedArray, xmlPullParser, "strokeWidth", 4, this.f);
                this.l = w0.a(typedArray, xmlPullParser, "trimPathEnd", 6, this.l);
                this.m = w0.a(typedArray, xmlPullParser, "trimPathOffset", 7, this.m);
                this.k = w0.a(typedArray, xmlPullParser, "trimPathStart", 5, this.k);
                this.i = w0.b(typedArray, xmlPullParser, "fillType", 13, this.i);
            }
        }

        public c(c cVar) {
            super(cVar);
            this.f = 0.0f;
            this.h = 1.0f;
            this.i = 0;
            this.j = 1.0f;
            this.k = 0.0f;
            this.l = 1.0f;
            this.m = 0.0f;
            this.n = Paint.Cap.BUTT;
            this.o = Paint.Join.MITER;
            this.p = 4.0f;
            this.d = cVar.d;
            this.e = cVar.e;
            this.f = cVar.f;
            this.h = cVar.h;
            this.g = cVar.g;
            this.i = cVar.i;
            this.j = cVar.j;
            this.k = cVar.k;
            this.l = cVar.l;
            this.m = cVar.m;
            this.n = cVar.n;
            this.o = cVar.o;
            this.p = cVar.p;
        }

        @Override // defpackage.l3.e
        public boolean a() {
            return this.g.d() || this.e.d();
        }

        @Override // defpackage.l3.e
        public boolean a(int[] iArr) {
            return this.e.a(iArr) | this.g.a(iArr);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: VectorDrawableCompat.java */
    /* renamed from: l3$d */
    /* loaded from: classes.dex */
    public static class d extends e {
        final Matrix a;
        final ArrayList<e> b;
        float c;
        private float d;
        private float e;
        private float f;
        private float g;
        private float h;
        private float i;
        final Matrix j;
        int k;
        private int[] l;
        private String m;

        public d(d dVar, d0<String, Object> d0Var) {
            super();
            f bVar;
            this.a = new Matrix();
            this.b = new ArrayList<>();
            this.c = 0.0f;
            this.d = 0.0f;
            this.e = 0.0f;
            this.f = 1.0f;
            this.g = 1.0f;
            this.h = 0.0f;
            this.i = 0.0f;
            this.j = new Matrix();
            this.m = null;
            this.c = dVar.c;
            this.d = dVar.d;
            this.e = dVar.e;
            this.f = dVar.f;
            this.g = dVar.g;
            this.h = dVar.h;
            this.i = dVar.i;
            this.l = dVar.l;
            this.m = dVar.m;
            this.k = dVar.k;
            String str = this.m;
            if (str != null) {
                d0Var.put(str, this);
            }
            this.j.set(dVar.j);
            ArrayList<e> arrayList = dVar.b;
            for (int i = 0; i < arrayList.size(); i++) {
                e eVar = arrayList.get(i);
                if (eVar instanceof d) {
                    this.b.add(new d((d) eVar, d0Var));
                } else {
                    if (eVar instanceof c) {
                        bVar = new c((c) eVar);
                    } else if (eVar instanceof b) {
                        bVar = new b((b) eVar);
                    } else {
                        throw new IllegalStateException("Unknown object in the tree!");
                    }
                    this.b.add(bVar);
                    String str2 = bVar.b;
                    if (str2 != null) {
                        d0Var.put(str2, bVar);
                    }
                }
            }
        }

        private void b() {
            this.j.reset();
            this.j.postTranslate(-this.d, -this.e);
            this.j.postScale(this.f, this.g);
            this.j.postRotate(this.c, 0.0f, 0.0f);
            this.j.postTranslate(this.h + this.d, this.i + this.e);
        }

        public void a(Resources resources, AttributeSet attributeSet, Resources.Theme theme, XmlPullParser xmlPullParser) {
            TypedArray a = w0.a(resources, theme, attributeSet, d3.b);
            a(a, xmlPullParser);
            a.recycle();
        }

        public String getGroupName() {
            return this.m;
        }

        public Matrix getLocalMatrix() {
            return this.j;
        }

        public float getPivotX() {
            return this.d;
        }

        public float getPivotY() {
            return this.e;
        }

        public float getRotation() {
            return this.c;
        }

        public float getScaleX() {
            return this.f;
        }

        public float getScaleY() {
            return this.g;
        }

        public float getTranslateX() {
            return this.h;
        }

        public float getTranslateY() {
            return this.i;
        }

        public void setPivotX(float f) {
            if (f != this.d) {
                this.d = f;
                b();
            }
        }

        public void setPivotY(float f) {
            if (f != this.e) {
                this.e = f;
                b();
            }
        }

        public void setRotation(float f) {
            if (f != this.c) {
                this.c = f;
                b();
            }
        }

        public void setScaleX(float f) {
            if (f != this.f) {
                this.f = f;
                b();
            }
        }

        public void setScaleY(float f) {
            if (f != this.g) {
                this.g = f;
                b();
            }
        }

        public void setTranslateX(float f) {
            if (f != this.h) {
                this.h = f;
                b();
            }
        }

        public void setTranslateY(float f) {
            if (f != this.i) {
                this.i = f;
                b();
            }
        }

        private void a(TypedArray typedArray, XmlPullParser xmlPullParser) {
            this.l = null;
            this.c = w0.a(typedArray, xmlPullParser, "rotation", 5, this.c);
            this.d = typedArray.getFloat(1, this.d);
            this.e = typedArray.getFloat(2, this.e);
            this.f = w0.a(typedArray, xmlPullParser, "scaleX", 3, this.f);
            this.g = w0.a(typedArray, xmlPullParser, "scaleY", 4, this.g);
            this.h = w0.a(typedArray, xmlPullParser, "translateX", 6, this.h);
            this.i = w0.a(typedArray, xmlPullParser, "translateY", 7, this.i);
            String string = typedArray.getString(0);
            if (string != null) {
                this.m = string;
            }
            b();
        }

        @Override // defpackage.l3.e
        public boolean a() {
            for (int i = 0; i < this.b.size(); i++) {
                if (this.b.get(i).a()) {
                    return true;
                }
            }
            return false;
        }

        @Override // defpackage.l3.e
        public boolean a(int[] iArr) {
            boolean z = false;
            for (int i = 0; i < this.b.size(); i++) {
                z |= this.b.get(i).a(iArr);
            }
            return z;
        }

        public d() {
            super();
            this.a = new Matrix();
            this.b = new ArrayList<>();
            this.c = 0.0f;
            this.d = 0.0f;
            this.e = 0.0f;
            this.f = 1.0f;
            this.g = 1.0f;
            this.h = 0.0f;
            this.i = 0.0f;
            this.j = new Matrix();
            this.m = null;
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void inflate(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) throws XmlPullParserException, IOException {
        Drawable drawable = this.b;
        if (drawable != null) {
            androidx.core.graphics.drawable.a.a(drawable, resources, xmlPullParser, attributeSet, theme);
            return;
        }
        h hVar = this.c;
        hVar.b = new g();
        TypedArray a2 = w0.a(resources, theme, attributeSet, d3.a);
        a(a2, xmlPullParser);
        a2.recycle();
        hVar.a = getChangingConfigurations();
        hVar.k = true;
        a(resources, xmlPullParser, attributeSet, theme);
        this.d = updateTintFilter(this.d, hVar.c, hVar.d);
    }

    l3(h hVar) {
        this.g = true;
        this.h = new float[9];
        this.i = new Matrix();
        this.j = new Rect();
        this.c = hVar;
        this.d = updateTintFilter(this.d, hVar.c, hVar.d);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: VectorDrawableCompat.java */
    /* renamed from: l3$g */
    /* loaded from: classes.dex */
    public static class g {
        private static final Matrix q = new Matrix();
        private final Path a;
        private final Path b;
        private final Matrix c;
        Paint d;
        Paint e;
        private PathMeasure f;
        private int g;
        final d h;
        float i;
        float j;
        float k;
        float l;
        int m;
        String n;
        Boolean o;
        final d0<String, Object> p;

        public g() {
            this.c = new Matrix();
            this.i = 0.0f;
            this.j = 0.0f;
            this.k = 0.0f;
            this.l = 0.0f;
            this.m = 255;
            this.n = null;
            this.o = null;
            this.p = new d0<>();
            this.h = new d();
            this.a = new Path();
            this.b = new Path();
        }

        private static float a(float f, float f2, float f3, float f4) {
            return (f * f4) - (f2 * f3);
        }

        private void a(d dVar, Matrix matrix, Canvas canvas, int i, int i2, ColorFilter colorFilter) {
            dVar.a.set(matrix);
            dVar.a.preConcat(dVar.j);
            canvas.save();
            for (int i3 = 0; i3 < dVar.b.size(); i3++) {
                e eVar = dVar.b.get(i3);
                if (eVar instanceof d) {
                    a((d) eVar, dVar.a, canvas, i, i2, colorFilter);
                } else if (eVar instanceof f) {
                    a(dVar, (f) eVar, canvas, i, i2, colorFilter);
                }
            }
            canvas.restore();
        }

        public float getAlpha() {
            return getRootAlpha() / 255.0f;
        }

        public int getRootAlpha() {
            return this.m;
        }

        public void setAlpha(float f) {
            setRootAlpha((int) (f * 255.0f));
        }

        public void setRootAlpha(int i) {
            this.m = i;
        }

        public void a(Canvas canvas, int i, int i2, ColorFilter colorFilter) {
            a(this.h, q, canvas, i, i2, colorFilter);
        }

        public g(g gVar) {
            this.c = new Matrix();
            this.i = 0.0f;
            this.j = 0.0f;
            this.k = 0.0f;
            this.l = 0.0f;
            this.m = 255;
            this.n = null;
            this.o = null;
            this.p = new d0<>();
            this.h = new d(gVar.h, this.p);
            this.a = new Path(gVar.a);
            this.b = new Path(gVar.b);
            this.i = gVar.i;
            this.j = gVar.j;
            this.k = gVar.k;
            this.l = gVar.l;
            this.g = gVar.g;
            this.m = gVar.m;
            this.n = gVar.n;
            String str = gVar.n;
            if (str != null) {
                this.p.put(str, this);
            }
            this.o = gVar.o;
        }

        private void a(d dVar, f fVar, Canvas canvas, int i, int i2, ColorFilter colorFilter) {
            float f = i / this.k;
            float f2 = i2 / this.l;
            float min = Math.min(f, f2);
            Matrix matrix = dVar.a;
            this.c.set(matrix);
            this.c.postScale(f, f2);
            float a = a(matrix);
            if (a == 0.0f) {
                return;
            }
            fVar.a(this.a);
            Path path = this.a;
            this.b.reset();
            if (fVar.b()) {
                this.b.addPath(path, this.c);
                canvas.clipPath(this.b);
                return;
            }
            c cVar = (c) fVar;
            if (cVar.k != 0.0f || cVar.l != 1.0f) {
                float f3 = cVar.k;
                float f4 = cVar.m;
                float f5 = (f3 + f4) % 1.0f;
                float f6 = (cVar.l + f4) % 1.0f;
                if (this.f == null) {
                    this.f = new PathMeasure();
                }
                this.f.setPath(this.a, false);
                float length = this.f.getLength();
                float f7 = f5 * length;
                float f8 = f6 * length;
                path.reset();
                if (f7 > f8) {
                    this.f.getSegment(f7, length, path, true);
                    this.f.getSegment(0.0f, f8, path, true);
                } else {
                    this.f.getSegment(f7, f8, path, true);
                }
                path.rLineTo(0.0f, 0.0f);
            }
            this.b.addPath(path, this.c);
            if (cVar.g.e()) {
                r0 r0Var = cVar.g;
                if (this.e == null) {
                    this.e = new Paint(1);
                    this.e.setStyle(Paint.Style.FILL);
                }
                Paint paint = this.e;
                if (r0Var.c()) {
                    Shader b = r0Var.b();
                    b.setLocalMatrix(this.c);
                    paint.setShader(b);
                    paint.setAlpha(Math.round(cVar.j * 255.0f));
                } else {
                    paint.setColor(l3.a(r0Var.a(), cVar.j));
                }
                paint.setColorFilter(colorFilter);
                this.b.setFillType(cVar.i == 0 ? Path.FillType.WINDING : Path.FillType.EVEN_ODD);
                canvas.drawPath(this.b, paint);
            }
            if (cVar.e.e()) {
                r0 r0Var2 = cVar.e;
                if (this.d == null) {
                    this.d = new Paint(1);
                    this.d.setStyle(Paint.Style.STROKE);
                }
                Paint paint2 = this.d;
                Paint.Join join = cVar.o;
                if (join != null) {
                    paint2.setStrokeJoin(join);
                }
                Paint.Cap cap = cVar.n;
                if (cap != null) {
                    paint2.setStrokeCap(cap);
                }
                paint2.setStrokeMiter(cVar.p);
                if (r0Var2.c()) {
                    Shader b2 = r0Var2.b();
                    b2.setLocalMatrix(this.c);
                    paint2.setShader(b2);
                    paint2.setAlpha(Math.round(cVar.h * 255.0f));
                } else {
                    paint2.setColor(l3.a(r0Var2.a(), cVar.h));
                }
                paint2.setColorFilter(colorFilter);
                paint2.setStrokeWidth(cVar.f * min * a);
                canvas.drawPath(this.b, paint2);
            }
        }

        private float a(Matrix matrix) {
            float[] fArr = {0.0f, 1.0f, 1.0f, 0.0f};
            matrix.mapVectors(fArr);
            float a = a(fArr[0], fArr[1], fArr[2], fArr[3]);
            float max = Math.max((float) Math.hypot(fArr[0], fArr[1]), (float) Math.hypot(fArr[2], fArr[3]));
            if (max > 0.0f) {
                return Math.abs(a) / max;
            }
            return 0.0f;
        }

        public boolean a() {
            if (this.o == null) {
                this.o = Boolean.valueOf(this.h.a());
            }
            return this.o.booleanValue();
        }

        public boolean a(int[] iArr) {
            return this.h.a(iArr);
        }
    }

    static int a(int i2, float f2) {
        return (i2 & 16777215) | (((int) (Color.alpha(i2) * f2)) << 24);
    }

    private static PorterDuff.Mode a(int i2, PorterDuff.Mode mode) {
        if (i2 != 3) {
            if (i2 != 5) {
                if (i2 != 9) {
                    switch (i2) {
                        case 14:
                            return PorterDuff.Mode.MULTIPLY;
                        case 15:
                            return PorterDuff.Mode.SCREEN;
                        case 16:
                            return PorterDuff.Mode.ADD;
                        default:
                            return mode;
                    }
                }
                return PorterDuff.Mode.SRC_ATOP;
            }
            return PorterDuff.Mode.SRC_IN;
        }
        return PorterDuff.Mode.SRC_OVER;
    }

    private void a(TypedArray typedArray, XmlPullParser xmlPullParser) throws XmlPullParserException {
        h hVar = this.c;
        g gVar = hVar.b;
        hVar.d = a(w0.b(typedArray, xmlPullParser, "tintMode", 6, -1), PorterDuff.Mode.SRC_IN);
        ColorStateList colorStateList = typedArray.getColorStateList(1);
        if (colorStateList != null) {
            hVar.c = colorStateList;
        }
        hVar.e = w0.a(typedArray, xmlPullParser, "autoMirrored", 5, hVar.e);
        gVar.k = w0.a(typedArray, xmlPullParser, "viewportWidth", 7, gVar.k);
        gVar.l = w0.a(typedArray, xmlPullParser, "viewportHeight", 8, gVar.l);
        if (gVar.k > 0.0f) {
            if (gVar.l > 0.0f) {
                gVar.i = typedArray.getDimension(3, gVar.i);
                gVar.j = typedArray.getDimension(2, gVar.j);
                if (gVar.i > 0.0f) {
                    if (gVar.j > 0.0f) {
                        gVar.setAlpha(w0.a(typedArray, xmlPullParser, "alpha", 4, gVar.getAlpha()));
                        String string = typedArray.getString(0);
                        if (string != null) {
                            gVar.n = string;
                            gVar.p.put(string, gVar);
                            return;
                        }
                        return;
                    }
                    throw new XmlPullParserException(typedArray.getPositionDescription() + "<vector> tag requires height > 0");
                }
                throw new XmlPullParserException(typedArray.getPositionDescription() + "<vector> tag requires width > 0");
            }
            throw new XmlPullParserException(typedArray.getPositionDescription() + "<vector> tag requires viewportHeight > 0");
        }
        throw new XmlPullParserException(typedArray.getPositionDescription() + "<vector> tag requires viewportWidth > 0");
    }

    private void a(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) throws XmlPullParserException, IOException {
        h hVar = this.c;
        g gVar = hVar.b;
        ArrayDeque arrayDeque = new ArrayDeque();
        arrayDeque.push(gVar.h);
        int eventType = xmlPullParser.getEventType();
        int depth = xmlPullParser.getDepth() + 1;
        boolean z = true;
        while (eventType != 1 && (xmlPullParser.getDepth() >= depth || eventType != 3)) {
            if (eventType == 2) {
                String name = xmlPullParser.getName();
                d dVar = (d) arrayDeque.peek();
                if (ClientConstants.ALIAS.PATH.equals(name)) {
                    c cVar = new c();
                    cVar.a(resources, attributeSet, theme, xmlPullParser);
                    dVar.b.add(cVar);
                    if (cVar.getPathName() != null) {
                        gVar.p.put(cVar.getPathName(), cVar);
                    }
                    z = false;
                    hVar.a = cVar.c | hVar.a;
                } else if ("clip-path".equals(name)) {
                    b bVar = new b();
                    bVar.a(resources, attributeSet, theme, xmlPullParser);
                    dVar.b.add(bVar);
                    if (bVar.getPathName() != null) {
                        gVar.p.put(bVar.getPathName(), bVar);
                    }
                    hVar.a = bVar.c | hVar.a;
                } else if ("group".equals(name)) {
                    d dVar2 = new d();
                    dVar2.a(resources, attributeSet, theme, xmlPullParser);
                    dVar.b.add(dVar2);
                    arrayDeque.push(dVar2);
                    if (dVar2.getGroupName() != null) {
                        gVar.p.put(dVar2.getGroupName(), dVar2);
                    }
                    hVar.a = dVar2.k | hVar.a;
                }
            } else if (eventType == 3 && "group".equals(xmlPullParser.getName())) {
                arrayDeque.pop();
            }
            eventType = xmlPullParser.next();
        }
        if (z) {
            throw new XmlPullParserException("no path defined");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(boolean z) {
        this.g = z;
    }

    private boolean a() {
        return Build.VERSION.SDK_INT >= 17 && isAutoMirrored() && androidx.core.graphics.drawable.a.d(this) == 1;
    }
}
