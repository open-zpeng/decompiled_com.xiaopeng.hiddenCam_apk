package defpackage;

import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.accessibility.AccessibilityNodeProvider;
/* compiled from: AccessibilityDelegateCompat.java */
/* renamed from: r1  reason: default package */
/* loaded from: classes.dex */
public class r1 {
    private static final View.AccessibilityDelegate b = new View.AccessibilityDelegate();
    private final View.AccessibilityDelegate a = new a(this);

    /* compiled from: AccessibilityDelegateCompat.java */
    /* renamed from: r1$a */
    /* loaded from: classes.dex */
    private static final class a extends View.AccessibilityDelegate {
        private final r1 a;

        a(r1 r1Var) {
            this.a = r1Var;
        }

        @Override // android.view.View.AccessibilityDelegate
        public boolean dispatchPopulateAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
            return this.a.a(view, accessibilityEvent);
        }

        @Override // android.view.View.AccessibilityDelegate
        public AccessibilityNodeProvider getAccessibilityNodeProvider(View view) {
            r2 a = this.a.a(view);
            if (a != null) {
                return (AccessibilityNodeProvider) a.a();
            }
            return null;
        }

        @Override // android.view.View.AccessibilityDelegate
        public void onInitializeAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
            this.a.b(view, accessibilityEvent);
        }

        @Override // android.view.View.AccessibilityDelegate
        public void onInitializeAccessibilityNodeInfo(View view, AccessibilityNodeInfo accessibilityNodeInfo) {
            this.a.a(view, q2.a(accessibilityNodeInfo));
        }

        @Override // android.view.View.AccessibilityDelegate
        public void onPopulateAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
            this.a.c(view, accessibilityEvent);
        }

        @Override // android.view.View.AccessibilityDelegate
        public boolean onRequestSendAccessibilityEvent(ViewGroup viewGroup, View view, AccessibilityEvent accessibilityEvent) {
            return this.a.a(viewGroup, view, accessibilityEvent);
        }

        @Override // android.view.View.AccessibilityDelegate
        public boolean performAccessibilityAction(View view, int i, Bundle bundle) {
            return this.a.a(view, i, bundle);
        }

        @Override // android.view.View.AccessibilityDelegate
        public void sendAccessibilityEvent(View view, int i) {
            this.a.a(view, i);
        }

        @Override // android.view.View.AccessibilityDelegate
        public void sendAccessibilityEventUnchecked(View view, AccessibilityEvent accessibilityEvent) {
            this.a.d(view, accessibilityEvent);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public View.AccessibilityDelegate a() {
        return this.a;
    }

    public void b(View view, AccessibilityEvent accessibilityEvent) {
        b.onInitializeAccessibilityEvent(view, accessibilityEvent);
    }

    public void c(View view, AccessibilityEvent accessibilityEvent) {
        b.onPopulateAccessibilityEvent(view, accessibilityEvent);
    }

    public void d(View view, AccessibilityEvent accessibilityEvent) {
        b.sendAccessibilityEventUnchecked(view, accessibilityEvent);
    }

    public void a(View view, int i) {
        b.sendAccessibilityEvent(view, i);
    }

    public boolean a(View view, AccessibilityEvent accessibilityEvent) {
        return b.dispatchPopulateAccessibilityEvent(view, accessibilityEvent);
    }

    public void a(View view, q2 q2Var) {
        b.onInitializeAccessibilityNodeInfo(view, q2Var.q());
    }

    public boolean a(ViewGroup viewGroup, View view, AccessibilityEvent accessibilityEvent) {
        return b.onRequestSendAccessibilityEvent(viewGroup, view, accessibilityEvent);
    }

    public r2 a(View view) {
        AccessibilityNodeProvider accessibilityNodeProvider;
        if (Build.VERSION.SDK_INT < 16 || (accessibilityNodeProvider = b.getAccessibilityNodeProvider(view)) == null) {
            return null;
        }
        return new r2(accessibilityNodeProvider);
    }

    public boolean a(View view, int i, Bundle bundle) {
        if (Build.VERSION.SDK_INT >= 16) {
            return b.performAccessibilityAction(view, i, bundle);
        }
        return false;
    }
}
