package defpackage;

import android.animation.ObjectAnimator;
import android.animation.TimeInterpolator;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import android.util.StateSet;
import defpackage.m;
import defpackage.o;
import java.io.IOException;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
/* compiled from: AnimatedStateListDrawableCompat.java */
/* renamed from: l  reason: default package */
/* loaded from: classes.dex */
public class l extends o {
    private c p;
    private g q;
    private int r;
    private int s;
    private boolean t;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: AnimatedStateListDrawableCompat.java */
    /* renamed from: l$b */
    /* loaded from: classes.dex */
    public static class b extends g {
        private final Animatable a;

        b(Animatable animatable) {
            super();
            this.a = animatable;
        }

        @Override // defpackage.l.g
        public void c() {
            this.a.start();
        }

        @Override // defpackage.l.g
        public void d() {
            this.a.stop();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: AnimatedStateListDrawableCompat.java */
    /* renamed from: l$c */
    /* loaded from: classes.dex */
    public static class c extends o.a {
        g0<Long> K;
        k0<Integer> L;

        c(c cVar, l lVar, Resources resources) {
            super(cVar, lVar, resources);
            if (cVar != null) {
                this.K = cVar.K;
                this.L = cVar.L;
                return;
            }
            this.K = new g0<>();
            this.L = new k0<>();
        }

        private static long f(int i, int i2) {
            return i2 | (i << 32);
        }

        int a(int i, int i2, Drawable drawable, boolean z) {
            int a = super.a(drawable);
            long f = f(i, i2);
            long j = z ? 8589934592L : 0L;
            long j2 = a;
            this.K.a(f, Long.valueOf(j2 | j));
            if (z) {
                this.K.a(f(i2, i), Long.valueOf(4294967296L | j2 | j));
            }
            return a;
        }

        int b(int[] iArr) {
            int a = super.a(iArr);
            return a >= 0 ? a : super.a(StateSet.WILD_CARD);
        }

        int c(int i, int i2) {
            return (int) this.K.b(f(i, i2), -1L).longValue();
        }

        int d(int i) {
            if (i < 0) {
                return 0;
            }
            return this.L.b(i, 0).intValue();
        }

        boolean e(int i, int i2) {
            return (this.K.b(f(i, i2), -1L).longValue() & 8589934592L) != 0;
        }

        @Override // defpackage.o.a, defpackage.m.c
        void n() {
            this.K = this.K.m4clone();
            this.L = this.L.clone();
        }

        @Override // defpackage.o.a, android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable() {
            return new l(this, null);
        }

        boolean d(int i, int i2) {
            return (this.K.b(f(i, i2), -1L).longValue() & 4294967296L) != 0;
        }

        @Override // defpackage.o.a, android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable(Resources resources) {
            return new l(this, resources);
        }

        int a(int[] iArr, Drawable drawable, int i) {
            int a = super.a(iArr, drawable);
            this.L.c(a, Integer.valueOf(i));
            return a;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: AnimatedStateListDrawableCompat.java */
    /* renamed from: l$d */
    /* loaded from: classes.dex */
    public static class d extends g {
        private final f3 a;

        d(f3 f3Var) {
            super();
            this.a = f3Var;
        }

        @Override // defpackage.l.g
        public void c() {
            this.a.start();
        }

        @Override // defpackage.l.g
        public void d() {
            this.a.stop();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: AnimatedStateListDrawableCompat.java */
    /* renamed from: l$e */
    /* loaded from: classes.dex */
    public static class e extends g {
        private final ObjectAnimator a;
        private final boolean b;

        e(AnimationDrawable animationDrawable, boolean z, boolean z2) {
            super();
            int numberOfFrames = animationDrawable.getNumberOfFrames();
            int i = z ? numberOfFrames - 1 : 0;
            int i2 = z ? 0 : numberOfFrames - 1;
            f fVar = new f(animationDrawable, z);
            ObjectAnimator ofInt = ObjectAnimator.ofInt(animationDrawable, "currentIndex", i, i2);
            if (Build.VERSION.SDK_INT >= 18) {
                ofInt.setAutoCancel(true);
            }
            ofInt.setDuration(fVar.a());
            ofInt.setInterpolator(fVar);
            this.b = z2;
            this.a = ofInt;
        }

        @Override // defpackage.l.g
        public boolean a() {
            return this.b;
        }

        @Override // defpackage.l.g
        public void b() {
            this.a.reverse();
        }

        @Override // defpackage.l.g
        public void c() {
            this.a.start();
        }

        @Override // defpackage.l.g
        public void d() {
            this.a.cancel();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: AnimatedStateListDrawableCompat.java */
    /* renamed from: l$g */
    /* loaded from: classes.dex */
    public static abstract class g {
        private g() {
        }

        public boolean a() {
            return false;
        }

        public void b() {
        }

        public abstract void c();

        public abstract void d();
    }

    public l() {
        this(null, null);
    }

    public static l b(Context context, Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) throws IOException, XmlPullParserException {
        String name = xmlPullParser.getName();
        if (name.equals("animated-selector")) {
            l lVar = new l();
            lVar.a(context, resources, xmlPullParser, attributeSet, theme);
            return lVar;
        }
        throw new XmlPullParserException(xmlPullParser.getPositionDescription() + ": invalid animated-selector tag " + name);
    }

    private void c() {
        onStateChange(getState());
    }

    private int d(Context context, Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) throws XmlPullParserException, IOException {
        int next;
        TypedArray a2 = w0.a(resources, theme, attributeSet, j.AnimatedStateListDrawableItem);
        int resourceId = a2.getResourceId(j.AnimatedStateListDrawableItem_android_id, 0);
        int resourceId2 = a2.getResourceId(j.AnimatedStateListDrawableItem_android_drawable, -1);
        Drawable c2 = resourceId2 > 0 ? k.c(context, resourceId2) : null;
        a2.recycle();
        int[] a3 = a(attributeSet);
        if (c2 == null) {
            do {
                next = xmlPullParser.next();
            } while (next == 4);
            if (next == 2) {
                if (xmlPullParser.getName().equals("vector")) {
                    c2 = l3.createFromXmlInner(resources, xmlPullParser, attributeSet, theme);
                } else if (Build.VERSION.SDK_INT >= 21) {
                    c2 = Drawable.createFromXmlInner(resources, xmlPullParser, attributeSet, theme);
                } else {
                    c2 = Drawable.createFromXmlInner(resources, xmlPullParser, attributeSet);
                }
            } else {
                throw new XmlPullParserException(xmlPullParser.getPositionDescription() + ": <item> tag requires a 'drawable' attribute or child tag defining a drawable");
            }
        }
        if (c2 != null) {
            return this.p.a(a3, c2, resourceId);
        }
        throw new XmlPullParserException(xmlPullParser.getPositionDescription() + ": <item> tag requires a 'drawable' attribute or child tag defining a drawable");
    }

    private int e(Context context, Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) throws XmlPullParserException, IOException {
        int next;
        TypedArray a2 = w0.a(resources, theme, attributeSet, j.AnimatedStateListDrawableTransition);
        int resourceId = a2.getResourceId(j.AnimatedStateListDrawableTransition_android_fromId, -1);
        int resourceId2 = a2.getResourceId(j.AnimatedStateListDrawableTransition_android_toId, -1);
        int resourceId3 = a2.getResourceId(j.AnimatedStateListDrawableTransition_android_drawable, -1);
        Drawable c2 = resourceId3 > 0 ? k.c(context, resourceId3) : null;
        boolean z = a2.getBoolean(j.AnimatedStateListDrawableTransition_android_reversible, false);
        a2.recycle();
        if (c2 == null) {
            do {
                next = xmlPullParser.next();
            } while (next == 4);
            if (next == 2) {
                if (xmlPullParser.getName().equals("animated-vector")) {
                    c2 = f3.a(context, resources, xmlPullParser, attributeSet, theme);
                } else if (Build.VERSION.SDK_INT >= 21) {
                    c2 = Drawable.createFromXmlInner(resources, xmlPullParser, attributeSet, theme);
                } else {
                    c2 = Drawable.createFromXmlInner(resources, xmlPullParser, attributeSet);
                }
            } else {
                throw new XmlPullParserException(xmlPullParser.getPositionDescription() + ": <transition> tag requires a 'drawable' attribute or child tag defining a drawable");
            }
        }
        if (c2 == null) {
            throw new XmlPullParserException(xmlPullParser.getPositionDescription() + ": <transition> tag requires a 'drawable' attribute or child tag defining a drawable");
        } else if (resourceId != -1 && resourceId2 != -1) {
            return this.p.a(resourceId, resourceId2, c2, z);
        } else {
            throw new XmlPullParserException(xmlPullParser.getPositionDescription() + ": <transition> tag requires 'fromId' & 'toId' attributes");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // defpackage.o, defpackage.m
    public void clearMutated() {
        super.clearMutated();
        this.t = false;
    }

    @Override // defpackage.o, android.graphics.drawable.Drawable
    public boolean isStateful() {
        return true;
    }

    @Override // defpackage.m, android.graphics.drawable.Drawable
    public void jumpToCurrentState() {
        super.jumpToCurrentState();
        g gVar = this.q;
        if (gVar != null) {
            gVar.d();
            this.q = null;
            a(this.r);
            this.r = -1;
            this.s = -1;
        }
    }

    @Override // defpackage.o, defpackage.m, android.graphics.drawable.Drawable
    public Drawable mutate() {
        if (!this.t) {
            super.mutate();
            if (this == this) {
                this.p.n();
                this.t = true;
            }
        }
        return this;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // defpackage.o, defpackage.m, android.graphics.drawable.Drawable
    public boolean onStateChange(int[] iArr) {
        int b2 = this.p.b(iArr);
        boolean z = b2 != b() && (b(b2) || a(b2));
        Drawable current = getCurrent();
        return current != null ? z | current.setState(iArr) : z;
    }

    @Override // defpackage.m, android.graphics.drawable.Drawable
    public boolean setVisible(boolean z, boolean z2) {
        boolean visible = super.setVisible(z, z2);
        if (this.q != null && (visible || z2)) {
            if (z) {
                this.q.c();
            } else {
                jumpToCurrentState();
            }
        }
        return visible;
    }

    l(c cVar, Resources resources) {
        super(null);
        this.r = -1;
        this.s = -1;
        a(new c(cVar, this, resources));
        onStateChange(getState());
        jumpToCurrentState();
    }

    private void c(Context context, Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) throws XmlPullParserException, IOException {
        int depth = xmlPullParser.getDepth() + 1;
        while (true) {
            int next = xmlPullParser.next();
            if (next == 1) {
                return;
            }
            int depth2 = xmlPullParser.getDepth();
            if (depth2 < depth && next == 3) {
                return;
            }
            if (next == 2 && depth2 <= depth) {
                if (xmlPullParser.getName().equals("item")) {
                    d(context, resources, xmlPullParser, attributeSet, theme);
                } else if (xmlPullParser.getName().equals("transition")) {
                    e(context, resources, xmlPullParser, attributeSet, theme);
                }
            }
        }
    }

    public void a(Context context, Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) throws XmlPullParserException, IOException {
        TypedArray a2 = w0.a(resources, theme, attributeSet, j.AnimatedStateListDrawableCompat);
        setVisible(a2.getBoolean(j.AnimatedStateListDrawableCompat_android_visible, true), true);
        a(a2);
        a(resources);
        a2.recycle();
        c(context, resources, xmlPullParser, attributeSet, theme);
        c();
    }

    private boolean b(int i) {
        int b2;
        int c2;
        g bVar;
        g gVar = this.q;
        if (gVar != null) {
            if (i == this.r) {
                return true;
            }
            if (i == this.s && gVar.a()) {
                gVar.b();
                this.r = this.s;
                this.s = i;
                return true;
            }
            b2 = this.r;
            gVar.d();
        } else {
            b2 = b();
        }
        this.q = null;
        this.s = -1;
        this.r = -1;
        c cVar = this.p;
        int d2 = cVar.d(b2);
        int d3 = cVar.d(i);
        if (d3 == 0 || d2 == 0 || (c2 = cVar.c(d2, d3)) < 0) {
            return false;
        }
        boolean e2 = cVar.e(d2, d3);
        a(c2);
        Drawable current = getCurrent();
        if (current instanceof AnimationDrawable) {
            bVar = new e((AnimationDrawable) current, cVar.d(d2, d3), e2);
        } else if (current instanceof f3) {
            bVar = new d((f3) current);
        } else {
            if (current instanceof Animatable) {
                bVar = new b((Animatable) current);
            }
            return false;
        }
        bVar.c();
        this.q = bVar;
        this.s = b2;
        this.r = i;
        return true;
    }

    /* compiled from: AnimatedStateListDrawableCompat.java */
    /* renamed from: l$f */
    /* loaded from: classes.dex */
    private static class f implements TimeInterpolator {
        private int[] a;
        private int b;
        private int c;

        f(AnimationDrawable animationDrawable, boolean z) {
            a(animationDrawable, z);
        }

        int a(AnimationDrawable animationDrawable, boolean z) {
            int numberOfFrames = animationDrawable.getNumberOfFrames();
            this.b = numberOfFrames;
            int[] iArr = this.a;
            if (iArr == null || iArr.length < numberOfFrames) {
                this.a = new int[numberOfFrames];
            }
            int[] iArr2 = this.a;
            int i = 0;
            for (int i2 = 0; i2 < numberOfFrames; i2++) {
                int duration = animationDrawable.getDuration(z ? (numberOfFrames - i2) - 1 : i2);
                iArr2[i2] = duration;
                i += duration;
            }
            this.c = i;
            return i;
        }

        @Override // android.animation.TimeInterpolator
        public float getInterpolation(float f) {
            int i = (int) ((f * this.c) + 0.5f);
            int i2 = this.b;
            int[] iArr = this.a;
            int i3 = 0;
            while (i3 < i2 && i >= iArr[i3]) {
                i -= iArr[i3];
                i3++;
            }
            return (i3 / i2) + (i3 < i2 ? i / this.c : 0.0f);
        }

        int a() {
            return this.c;
        }
    }

    private void a(TypedArray typedArray) {
        c cVar = this.p;
        if (Build.VERSION.SDK_INT >= 21) {
            cVar.d |= typedArray.getChangingConfigurations();
        }
        cVar.b(typedArray.getBoolean(j.AnimatedStateListDrawableCompat_android_variablePadding, cVar.i));
        cVar.a(typedArray.getBoolean(j.AnimatedStateListDrawableCompat_android_constantSize, cVar.l));
        cVar.b(typedArray.getInt(j.AnimatedStateListDrawableCompat_android_enterFadeDuration, cVar.A));
        cVar.c(typedArray.getInt(j.AnimatedStateListDrawableCompat_android_exitFadeDuration, cVar.B));
        setDither(typedArray.getBoolean(j.AnimatedStateListDrawableCompat_android_dither, cVar.x));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // defpackage.o, defpackage.m
    public c a() {
        return new c(this.p, this, null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // defpackage.o, defpackage.m
    public void a(m.c cVar) {
        super.a(cVar);
        if (cVar instanceof c) {
            this.p = (c) cVar;
        }
    }
}
