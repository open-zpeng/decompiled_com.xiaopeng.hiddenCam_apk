package defpackage;

import android.os.Build;
import java.util.Arrays;
import java.util.Objects;
/* compiled from: ObjectsCompat.java */
/* renamed from: p1  reason: default package */
/* loaded from: classes.dex */
public class p1 {
    public static int a(Object... objArr) {
        if (Build.VERSION.SDK_INT >= 19) {
            return Objects.hash(objArr);
        }
        return Arrays.hashCode(objArr);
    }
}
