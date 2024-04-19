package defpackage;

import android.os.Build;
import android.view.ViewGroup;
/* compiled from: ViewGroupCompat.java */
/* renamed from: j2  reason: default package */
/* loaded from: classes.dex */
public final class j2 {
    public static boolean a(ViewGroup viewGroup) {
        if (Build.VERSION.SDK_INT >= 21) {
            return viewGroup.isTransitionGroup();
        }
        Boolean bool = (Boolean) viewGroup.getTag(m0.tag_transition_group);
        return ((bool == null || !bool.booleanValue()) && viewGroup.getBackground() == null && h2.f(viewGroup) == null) ? false : true;
    }
}
