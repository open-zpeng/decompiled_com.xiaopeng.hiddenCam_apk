package defpackage;

import android.os.Build;
import android.view.ViewGroup;
/* compiled from: MarginLayoutParamsCompat.java */
/* renamed from: w1  reason: default package */
/* loaded from: classes.dex */
public final class w1 {
    public static int a(ViewGroup.MarginLayoutParams marginLayoutParams) {
        if (Build.VERSION.SDK_INT >= 17) {
            return marginLayoutParams.getMarginEnd();
        }
        return marginLayoutParams.rightMargin;
    }

    public static int b(ViewGroup.MarginLayoutParams marginLayoutParams) {
        if (Build.VERSION.SDK_INT >= 17) {
            return marginLayoutParams.getMarginStart();
        }
        return marginLayoutParams.leftMargin;
    }
}
