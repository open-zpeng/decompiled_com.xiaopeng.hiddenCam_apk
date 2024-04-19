package defpackage;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
/* compiled from: TintableBackgroundView.java */
/* renamed from: g2  reason: default package */
/* loaded from: classes.dex */
public interface g2 {
    ColorStateList getSupportBackgroundTintList();

    PorterDuff.Mode getSupportBackgroundTintMode();

    void setSupportBackgroundTintList(ColorStateList colorStateList);

    void setSupportBackgroundTintMode(PorterDuff.Mode mode);
}
