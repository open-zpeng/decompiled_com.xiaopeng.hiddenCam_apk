package defpackage;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.XmlResourceParser;
import android.graphics.Shader;
import android.util.AttributeSet;
import android.util.Log;
import android.util.Xml;
import java.io.IOException;
import org.xmlpull.v1.XmlPullParserException;
/* compiled from: ComplexColorCompat.java */
/* renamed from: r0  reason: default package */
/* loaded from: classes.dex */
public final class r0 {
    private final Shader a;
    private final ColorStateList b;
    private int c;

    private r0(Shader shader, ColorStateList colorStateList, int i) {
        this.a = shader;
        this.b = colorStateList;
        this.c = i;
    }

    static r0 a(Shader shader) {
        return new r0(shader, null, 0);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static r0 b(int i) {
        return new r0(null, null, i);
    }

    public boolean c() {
        return this.a != null;
    }

    public boolean d() {
        ColorStateList colorStateList;
        return this.a == null && (colorStateList = this.b) != null && colorStateList.isStateful();
    }

    public boolean e() {
        return c() || this.c != 0;
    }

    static r0 a(ColorStateList colorStateList) {
        return new r0(null, colorStateList, colorStateList.getDefaultColor());
    }

    public Shader b() {
        return this.a;
    }

    public static r0 b(Resources resources, int i, Resources.Theme theme) {
        try {
            return a(resources, i, theme);
        } catch (Exception e) {
            Log.e("ComplexColorCompat", "Failed to inflate ComplexColor.", e);
            return null;
        }
    }

    public int a() {
        return this.c;
    }

    public void a(int i) {
        this.c = i;
    }

    public boolean a(int[] iArr) {
        if (d()) {
            ColorStateList colorStateList = this.b;
            int colorForState = colorStateList.getColorForState(iArr, colorStateList.getDefaultColor());
            if (colorForState != this.c) {
                this.c = colorForState;
                return true;
            }
        }
        return false;
    }

    private static r0 a(Resources resources, int i, Resources.Theme theme) throws IOException, XmlPullParserException {
        int next;
        XmlResourceParser xml = resources.getXml(i);
        AttributeSet asAttributeSet = Xml.asAttributeSet(xml);
        do {
            next = xml.next();
            if (next == 2) {
                break;
            }
        } while (next != 1);
        if (next == 2) {
            String name = xml.getName();
            char c = 65535;
            int hashCode = name.hashCode();
            if (hashCode != 89650992) {
                if (hashCode == 1191572447 && name.equals("selector")) {
                    c = 0;
                }
            } else if (name.equals("gradient")) {
                c = 1;
            }
            if (c != 0) {
                if (c == 1) {
                    return a(t0.a(resources, xml, asAttributeSet, theme));
                }
                throw new XmlPullParserException(xml.getPositionDescription() + ": unsupported complex color tag " + name);
            }
            return a(q0.a(resources, xml, asAttributeSet, theme));
        }
        throw new XmlPullParserException("No start tag found");
    }
}
