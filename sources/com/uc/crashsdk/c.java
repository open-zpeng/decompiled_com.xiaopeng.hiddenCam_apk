package com.uc.crashsdk;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import java.util.Iterator;
import java.util.Map;
import java.util.WeakHashMap;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ProGuard */
/* loaded from: classes.dex */
public final class c implements Application.ActivityLifecycleCallbacks {
    private boolean a = false;
    private boolean b = false;

    private void a(Activity activity, int i) {
        WeakHashMap weakHashMap;
        WeakHashMap weakHashMap2;
        if (h.I()) {
            b.E();
            weakHashMap = b.R;
            synchronized (weakHashMap) {
                weakHashMap2 = b.R;
                weakHashMap2.put(activity, Integer.valueOf(i));
                a(i);
            }
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityCreated(Activity activity, Bundle bundle) {
        a(activity, 2);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityDestroyed(Activity activity) {
        WeakHashMap weakHashMap;
        WeakHashMap weakHashMap2;
        if (h.I()) {
            b.E();
            weakHashMap = b.R;
            synchronized (weakHashMap) {
                weakHashMap2 = b.R;
                weakHashMap2.remove(activity);
                a(2);
            }
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityPaused(Activity activity) {
        a(activity, 2);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityResumed(Activity activity) {
        a(activity, 1);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityStarted(Activity activity) {
        a(activity, 1);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityStopped(Activity activity) {
        a(activity, 2);
    }

    private void a(int i) {
        WeakHashMap weakHashMap;
        WeakHashMap weakHashMap2;
        boolean z = 1 == i;
        if (!z) {
            weakHashMap2 = b.R;
            Iterator it = weakHashMap2.entrySet().iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                Object value = ((Map.Entry) it.next()).getValue();
                if (value != null && ((Integer) value).intValue() == 1) {
                    z = true;
                    break;
                }
            }
        }
        if (this.a != z) {
            b.a(z);
            this.a = z;
        }
        weakHashMap = b.R;
        boolean isEmpty = weakHashMap.isEmpty();
        if (this.b != isEmpty) {
            if (isEmpty) {
                b.t();
            }
            this.b = isEmpty;
        }
    }
}
