package defpackage;

import android.content.res.Resources;
import android.graphics.ColorFilter;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.Region;
import android.graphics.drawable.Drawable;
import androidx.core.graphics.drawable.a;
import androidx.core.graphics.drawable.b;
/* compiled from: VectorDrawableCommon.java */
/* renamed from: k3  reason: default package */
/* loaded from: classes.dex */
abstract class k3 extends Drawable implements b {
    Drawable b;

    @Override // android.graphics.drawable.Drawable
    public void applyTheme(Resources.Theme theme) {
        Drawable drawable = this.b;
        if (drawable != null) {
            a.a(drawable, theme);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void clearColorFilter() {
        Drawable drawable = this.b;
        if (drawable != null) {
            drawable.clearColorFilter();
        } else {
            super.clearColorFilter();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public ColorFilter getColorFilter() {
        Drawable drawable = this.b;
        if (drawable != null) {
            return a.c(drawable);
        }
        return null;
    }

    @Override // android.graphics.drawable.Drawable
    public Drawable getCurrent() {
        Drawable drawable = this.b;
        if (drawable != null) {
            return drawable.getCurrent();
        }
        return super.getCurrent();
    }

    @Override // android.graphics.drawable.Drawable
    public int getMinimumHeight() {
        Drawable drawable = this.b;
        if (drawable != null) {
            return drawable.getMinimumHeight();
        }
        return super.getMinimumHeight();
    }

    @Override // android.graphics.drawable.Drawable
    public int getMinimumWidth() {
        Drawable drawable = this.b;
        if (drawable != null) {
            return drawable.getMinimumWidth();
        }
        return super.getMinimumWidth();
    }

    @Override // android.graphics.drawable.Drawable
    public boolean getPadding(Rect rect) {
        Drawable drawable = this.b;
        if (drawable != null) {
            return drawable.getPadding(rect);
        }
        return super.getPadding(rect);
    }

    @Override // android.graphics.drawable.Drawable
    public int[] getState() {
        Drawable drawable = this.b;
        if (drawable != null) {
            return drawable.getState();
        }
        return super.getState();
    }

    @Override // android.graphics.drawable.Drawable
    public Region getTransparentRegion() {
        Drawable drawable = this.b;
        if (drawable != null) {
            return drawable.getTransparentRegion();
        }
        return super.getTransparentRegion();
    }

    @Override // android.graphics.drawable.Drawable
    public void jumpToCurrentState() {
        Drawable drawable = this.b;
        if (drawable != null) {
            a.f(drawable);
        }
    }

    @Override // android.graphics.drawable.Drawable
    protected boolean onLevelChange(int i) {
        Drawable drawable = this.b;
        if (drawable != null) {
            return drawable.setLevel(i);
        }
        return super.onLevelChange(i);
    }

    @Override // android.graphics.drawable.Drawable
    public void setChangingConfigurations(int i) {
        Drawable drawable = this.b;
        if (drawable != null) {
            drawable.setChangingConfigurations(i);
        } else {
            super.setChangingConfigurations(i);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(int i, PorterDuff.Mode mode) {
        Drawable drawable = this.b;
        if (drawable != null) {
            drawable.setColorFilter(i, mode);
        } else {
            super.setColorFilter(i, mode);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setFilterBitmap(boolean z) {
        Drawable drawable = this.b;
        if (drawable != null) {
            drawable.setFilterBitmap(z);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setHotspot(float f, float f2) {
        Drawable drawable = this.b;
        if (drawable != null) {
            a.a(drawable, f, f2);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setHotspotBounds(int i, int i2, int i3, int i4) {
        Drawable drawable = this.b;
        if (drawable != null) {
            a.a(drawable, i, i2, i3, i4);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public boolean setState(int[] iArr) {
        Drawable drawable = this.b;
        if (drawable != null) {
            return drawable.setState(iArr);
        }
        return super.setState(iArr);
    }
}
