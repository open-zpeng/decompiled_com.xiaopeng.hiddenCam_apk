package defpackage;

import android.graphics.Rect;
import android.os.Build;
import android.view.accessibility.AccessibilityNodeInfo;
import com.alibaba.sdk.android.oss.common.OSSConstants;
import com.xiaopeng.lib.framework.moduleinterface.carcontroller.IInputController;
/* compiled from: AccessibilityNodeInfoCompat.java */
/* renamed from: q2  reason: default package */
/* loaded from: classes.dex */
public class q2 {
    private final AccessibilityNodeInfo a;

    private q2(AccessibilityNodeInfo accessibilityNodeInfo) {
        this.a = accessibilityNodeInfo;
    }

    public static q2 a(AccessibilityNodeInfo accessibilityNodeInfo) {
        return new q2(accessibilityNodeInfo);
    }

    private static String b(int i) {
        if (i != 1) {
            if (i != 2) {
                switch (i) {
                    case 4:
                        return "ACTION_SELECT";
                    case 8:
                        return "ACTION_CLEAR_SELECTION";
                    case 16:
                        return "ACTION_CLICK";
                    case 32:
                        return "ACTION_LONG_CLICK";
                    case 64:
                        return "ACTION_ACCESSIBILITY_FOCUS";
                    case 128:
                        return "ACTION_CLEAR_ACCESSIBILITY_FOCUS";
                    case 256:
                        return "ACTION_NEXT_AT_MOVEMENT_GRANULARITY";
                    case IInputController.KEYCODE_BACK_BUTTON /* 512 */:
                        return "ACTION_PREVIOUS_AT_MOVEMENT_GRANULARITY";
                    case 1024:
                        return "ACTION_NEXT_HTML_ELEMENT";
                    case 2048:
                        return "ACTION_PREVIOUS_HTML_ELEMENT";
                    case 4096:
                        return "ACTION_SCROLL_FORWARD";
                    case OSSConstants.DEFAULT_BUFFER_SIZE /* 8192 */:
                        return "ACTION_SCROLL_BACKWARD";
                    case 16384:
                        return "ACTION_COPY";
                    case 32768:
                        return "ACTION_PASTE";
                    case 65536:
                        return "ACTION_CUT";
                    case OSSConstants.DEFAULT_STREAM_BUFFER_SIZE /* 131072 */:
                        return "ACTION_SET_SELECTION";
                    default:
                        return "ACTION_UNKNOWN";
                }
            }
            return "ACTION_CLEAR_FOCUS";
        }
        return "ACTION_FOCUS";
    }

    public void b(Rect rect) {
        this.a.getBoundsInScreen(rect);
    }

    public CharSequence c() {
        return this.a.getContentDescription();
    }

    public CharSequence d() {
        return this.a.getPackageName();
    }

    public CharSequence e() {
        return this.a.getText();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && q2.class == obj.getClass()) {
            q2 q2Var = (q2) obj;
            AccessibilityNodeInfo accessibilityNodeInfo = this.a;
            if (accessibilityNodeInfo == null) {
                if (q2Var.a != null) {
                    return false;
                }
            } else if (!accessibilityNodeInfo.equals(q2Var.a)) {
                return false;
            }
            return true;
        }
        return false;
    }

    public String f() {
        if (Build.VERSION.SDK_INT >= 18) {
            return this.a.getViewIdResourceName();
        }
        return null;
    }

    public boolean g() {
        return this.a.isCheckable();
    }

    public boolean h() {
        return this.a.isChecked();
    }

    public int hashCode() {
        AccessibilityNodeInfo accessibilityNodeInfo = this.a;
        if (accessibilityNodeInfo == null) {
            return 0;
        }
        return accessibilityNodeInfo.hashCode();
    }

    public boolean i() {
        return this.a.isClickable();
    }

    public boolean j() {
        return this.a.isEnabled();
    }

    public boolean k() {
        return this.a.isFocusable();
    }

    public boolean l() {
        return this.a.isFocused();
    }

    public boolean m() {
        return this.a.isLongClickable();
    }

    public boolean n() {
        return this.a.isPassword();
    }

    public boolean o() {
        return this.a.isScrollable();
    }

    public boolean p() {
        return this.a.isSelected();
    }

    public AccessibilityNodeInfo q() {
        return this.a;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(super.toString());
        Rect rect = new Rect();
        a(rect);
        sb.append("; boundsInParent: " + rect);
        b(rect);
        sb.append("; boundsInScreen: " + rect);
        sb.append("; packageName: ");
        sb.append(d());
        sb.append("; className: ");
        sb.append(b());
        sb.append("; text: ");
        sb.append(e());
        sb.append("; contentDescription: ");
        sb.append(c());
        sb.append("; viewId: ");
        sb.append(f());
        sb.append("; checkable: ");
        sb.append(g());
        sb.append("; checked: ");
        sb.append(h());
        sb.append("; focusable: ");
        sb.append(k());
        sb.append("; focused: ");
        sb.append(l());
        sb.append("; selected: ");
        sb.append(p());
        sb.append("; clickable: ");
        sb.append(i());
        sb.append("; longClickable: ");
        sb.append(m());
        sb.append("; enabled: ");
        sb.append(j());
        sb.append("; password: ");
        sb.append(n());
        sb.append("; scrollable: " + o());
        sb.append("; [");
        int a = a();
        while (a != 0) {
            int numberOfTrailingZeros = 1 << Integer.numberOfTrailingZeros(a);
            a &= ~numberOfTrailingZeros;
            sb.append(b(numberOfTrailingZeros));
            if (a != 0) {
                sb.append(", ");
            }
        }
        sb.append("]");
        return sb.toString();
    }

    public int a() {
        return this.a.getActions();
    }

    public CharSequence b() {
        return this.a.getClassName();
    }

    public void a(int i) {
        this.a.addAction(i);
    }

    public void a(Rect rect) {
        this.a.getBoundsInParent(rect);
    }

    public void a(boolean z) {
        this.a.setScrollable(z);
    }

    public void a(CharSequence charSequence) {
        this.a.setClassName(charSequence);
    }
}
