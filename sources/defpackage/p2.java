package defpackage;

import android.os.Build;
import android.view.WindowInsets;
/* compiled from: WindowInsetsCompat.java */
/* renamed from: p2  reason: default package */
/* loaded from: classes.dex */
public class p2 {
    private final Object a;

    private p2(Object obj) {
        this.a = obj;
    }

    public int a() {
        if (Build.VERSION.SDK_INT >= 20) {
            return ((WindowInsets) this.a).getSystemWindowInsetBottom();
        }
        return 0;
    }

    public int b() {
        if (Build.VERSION.SDK_INT >= 20) {
            return ((WindowInsets) this.a).getSystemWindowInsetLeft();
        }
        return 0;
    }

    public int c() {
        if (Build.VERSION.SDK_INT >= 20) {
            return ((WindowInsets) this.a).getSystemWindowInsetRight();
        }
        return 0;
    }

    public int d() {
        if (Build.VERSION.SDK_INT >= 20) {
            return ((WindowInsets) this.a).getSystemWindowInsetTop();
        }
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || p2.class != obj.getClass()) {
            return false;
        }
        Object obj2 = this.a;
        Object obj3 = ((p2) obj).a;
        return obj2 == null ? obj3 == null : obj2.equals(obj3);
    }

    public int hashCode() {
        Object obj = this.a;
        if (obj == null) {
            return 0;
        }
        return obj.hashCode();
    }

    public p2 a(int i, int i2, int i3, int i4) {
        if (Build.VERSION.SDK_INT >= 20) {
            return new p2(((WindowInsets) this.a).replaceSystemWindowInsets(i, i2, i3, i4));
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static p2 a(Object obj) {
        if (obj == null) {
            return null;
        }
        return new p2(obj);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Object a(p2 p2Var) {
        if (p2Var == null) {
            return null;
        }
        return p2Var.a;
    }
}
