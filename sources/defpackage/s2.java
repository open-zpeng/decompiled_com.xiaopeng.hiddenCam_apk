package defpackage;

import android.os.Build;
import android.view.accessibility.AccessibilityRecord;
/* compiled from: AccessibilityRecordCompat.java */
/* renamed from: s2  reason: default package */
/* loaded from: classes.dex */
public class s2 {
    public static void a(AccessibilityRecord accessibilityRecord, int i) {
        if (Build.VERSION.SDK_INT >= 15) {
            accessibilityRecord.setMaxScrollX(i);
        }
    }

    public static void b(AccessibilityRecord accessibilityRecord, int i) {
        if (Build.VERSION.SDK_INT >= 15) {
            accessibilityRecord.setMaxScrollY(i);
        }
    }
}
