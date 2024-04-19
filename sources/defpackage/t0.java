package defpackage;

import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.LinearGradient;
import android.graphics.RadialGradient;
import android.graphics.Shader;
import android.graphics.SweepGradient;
import android.util.AttributeSet;
import java.io.IOException;
import java.util.List;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: GradientColorInflaterCompat.java */
/* renamed from: t0  reason: default package */
/* loaded from: classes.dex */
public final class t0 {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static Shader a(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) throws IOException, XmlPullParserException {
        String name = xmlPullParser.getName();
        if (name.equals("gradient")) {
            TypedArray a2 = w0.a(resources, theme, attributeSet, n0.GradientColor);
            float a3 = w0.a(a2, xmlPullParser, "startX", n0.GradientColor_android_startX, 0.0f);
            float a4 = w0.a(a2, xmlPullParser, "startY", n0.GradientColor_android_startY, 0.0f);
            float a5 = w0.a(a2, xmlPullParser, "endX", n0.GradientColor_android_endX, 0.0f);
            float a6 = w0.a(a2, xmlPullParser, "endY", n0.GradientColor_android_endY, 0.0f);
            float a7 = w0.a(a2, xmlPullParser, "centerX", n0.GradientColor_android_centerX, 0.0f);
            float a8 = w0.a(a2, xmlPullParser, "centerY", n0.GradientColor_android_centerY, 0.0f);
            int b = w0.b(a2, xmlPullParser, "type", n0.GradientColor_android_type, 0);
            int a9 = w0.a(a2, xmlPullParser, "startColor", n0.GradientColor_android_startColor, 0);
            boolean a10 = w0.a(xmlPullParser, "centerColor");
            int a11 = w0.a(a2, xmlPullParser, "centerColor", n0.GradientColor_android_centerColor, 0);
            int a12 = w0.a(a2, xmlPullParser, "endColor", n0.GradientColor_android_endColor, 0);
            int b2 = w0.b(a2, xmlPullParser, "tileMode", n0.GradientColor_android_tileMode, 0);
            float a13 = w0.a(a2, xmlPullParser, "gradientRadius", n0.GradientColor_android_gradientRadius, 0.0f);
            a2.recycle();
            a a14 = a(b(resources, xmlPullParser, attributeSet, theme), a9, a12, a10, a11);
            if (b != 1) {
                if (b != 2) {
                    return new LinearGradient(a3, a4, a5, a6, a14.a, a14.b, a(b2));
                }
                return new SweepGradient(a7, a8, a14.a, a14.b);
            } else if (a13 > 0.0f) {
                return new RadialGradient(a7, a8, a13, a14.a, a14.b, a(b2));
            } else {
                throw new XmlPullParserException("<gradient> tag requires 'gradientRadius' attribute with radial type");
            }
        }
        throw new XmlPullParserException(xmlPullParser.getPositionDescription() + ": invalid gradient color tag " + name);
    }

    /* JADX WARN: Code restructure failed: missing block: B:21:0x0089, code lost:
        throw new org.xmlpull.v1.XmlPullParserException(r9.getPositionDescription() + ": <item> tag requires a 'color' attribute and a 'offset' attribute!");
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static defpackage.t0.a b(android.content.res.Resources r8, org.xmlpull.v1.XmlPullParser r9, android.util.AttributeSet r10, android.content.res.Resources.Theme r11) throws org.xmlpull.v1.XmlPullParserException, java.io.IOException {
        /*
            int r0 = r9.getDepth()
            r1 = 1
            int r0 = r0 + r1
            java.util.ArrayList r2 = new java.util.ArrayList
            r3 = 20
            r2.<init>(r3)
            java.util.ArrayList r4 = new java.util.ArrayList
            r4.<init>(r3)
        L12:
            int r3 = r9.next()
            if (r3 == r1) goto L8a
            int r5 = r9.getDepth()
            if (r5 >= r0) goto L21
            r6 = 3
            if (r3 == r6) goto L8a
        L21:
            r6 = 2
            if (r3 == r6) goto L25
            goto L12
        L25:
            if (r5 > r0) goto L12
            java.lang.String r3 = r9.getName()
            java.lang.String r5 = "item"
            boolean r3 = r3.equals(r5)
            if (r3 != 0) goto L34
            goto L12
        L34:
            int[] r3 = defpackage.n0.GradientColorItem
            android.content.res.TypedArray r3 = defpackage.w0.a(r8, r11, r10, r3)
            int r5 = defpackage.n0.GradientColorItem_android_color
            boolean r5 = r3.hasValue(r5)
            int r6 = defpackage.n0.GradientColorItem_android_offset
            boolean r6 = r3.hasValue(r6)
            if (r5 == 0) goto L6a
            if (r6 == 0) goto L6a
            int r5 = defpackage.n0.GradientColorItem_android_color
            r6 = 0
            int r5 = r3.getColor(r5, r6)
            int r6 = defpackage.n0.GradientColorItem_android_offset
            r7 = 0
            float r6 = r3.getFloat(r6, r7)
            r3.recycle()
            java.lang.Integer r3 = java.lang.Integer.valueOf(r5)
            r4.add(r3)
            java.lang.Float r3 = java.lang.Float.valueOf(r6)
            r2.add(r3)
            goto L12
        L6a:
            org.xmlpull.v1.XmlPullParserException r8 = new org.xmlpull.v1.XmlPullParserException
            java.lang.StringBuilder r10 = new java.lang.StringBuilder
            r10.<init>()
            java.lang.String r9 = r9.getPositionDescription()
            r10.append(r9)
            java.lang.String r9 = ": <item> tag requires a 'color' attribute and a 'offset' "
            r10.append(r9)
            java.lang.String r9 = "attribute!"
            r10.append(r9)
            java.lang.String r9 = r10.toString()
            r8.<init>(r9)
            throw r8
        L8a:
            int r8 = r4.size()
            if (r8 <= 0) goto L96
            t0$a r8 = new t0$a
            r8.<init>(r4, r2)
            return r8
        L96:
            r8 = 0
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.t0.b(android.content.res.Resources, org.xmlpull.v1.XmlPullParser, android.util.AttributeSet, android.content.res.Resources$Theme):t0$a");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: GradientColorInflaterCompat.java */
    /* renamed from: t0$a */
    /* loaded from: classes.dex */
    public static final class a {
        final int[] a;
        final float[] b;

        a(List<Integer> list, List<Float> list2) {
            int size = list.size();
            this.a = new int[size];
            this.b = new float[size];
            for (int i = 0; i < size; i++) {
                this.a[i] = list.get(i).intValue();
                this.b[i] = list2.get(i).floatValue();
            }
        }

        a(int i, int i2) {
            this.a = new int[]{i, i2};
            this.b = new float[]{0.0f, 1.0f};
        }

        a(int i, int i2, int i3) {
            this.a = new int[]{i, i2, i3};
            this.b = new float[]{0.0f, 0.5f, 1.0f};
        }
    }

    private static a a(a aVar, int i, int i2, boolean z, int i3) {
        if (aVar != null) {
            return aVar;
        }
        if (z) {
            return new a(i, i3, i2);
        }
        return new a(i, i2);
    }

    private static Shader.TileMode a(int i) {
        if (i != 1) {
            if (i != 2) {
                return Shader.TileMode.CLAMP;
            }
            return Shader.TileMode.MIRROR;
        }
        return Shader.TileMode.REPEAT;
    }
}
