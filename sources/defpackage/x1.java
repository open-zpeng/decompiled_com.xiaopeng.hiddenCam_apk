package defpackage;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.os.Build;
import android.util.Log;
import android.view.MenuItem;
/* compiled from: MenuItemCompat.java */
/* renamed from: x1  reason: default package */
/* loaded from: classes.dex */
public final class x1 {
    public static MenuItem a(MenuItem menuItem, s1 s1Var) {
        if (menuItem instanceof h1) {
            return ((h1) menuItem).a(s1Var);
        }
        Log.w("MenuItemCompat", "setActionProvider: item does not implement SupportMenuItem; ignoring");
        return menuItem;
    }

    public static void b(MenuItem menuItem, CharSequence charSequence) {
        if (menuItem instanceof h1) {
            ((h1) menuItem).setTooltipText(charSequence);
        } else if (Build.VERSION.SDK_INT >= 26) {
            menuItem.setTooltipText(charSequence);
        }
    }

    public static void a(MenuItem menuItem, CharSequence charSequence) {
        if (menuItem instanceof h1) {
            ((h1) menuItem).setContentDescription(charSequence);
        } else if (Build.VERSION.SDK_INT >= 26) {
            menuItem.setContentDescription(charSequence);
        }
    }

    public static void b(MenuItem menuItem, char c, int i) {
        if (menuItem instanceof h1) {
            ((h1) menuItem).setNumericShortcut(c, i);
        } else if (Build.VERSION.SDK_INT >= 26) {
            menuItem.setNumericShortcut(c, i);
        }
    }

    public static void a(MenuItem menuItem, char c, int i) {
        if (menuItem instanceof h1) {
            ((h1) menuItem).setAlphabeticShortcut(c, i);
        } else if (Build.VERSION.SDK_INT >= 26) {
            menuItem.setAlphabeticShortcut(c, i);
        }
    }

    public static void a(MenuItem menuItem, ColorStateList colorStateList) {
        if (menuItem instanceof h1) {
            ((h1) menuItem).setIconTintList(colorStateList);
        } else if (Build.VERSION.SDK_INT >= 26) {
            menuItem.setIconTintList(colorStateList);
        }
    }

    public static void a(MenuItem menuItem, PorterDuff.Mode mode) {
        if (menuItem instanceof h1) {
            ((h1) menuItem).setIconTintMode(mode);
        } else if (Build.VERSION.SDK_INT >= 26) {
            menuItem.setIconTintMode(mode);
        }
    }
}
