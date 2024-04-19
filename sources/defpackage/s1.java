package defpackage;

import android.content.Context;
import android.util.Log;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
/* compiled from: ActionProvider.java */
/* renamed from: s1  reason: default package */
/* loaded from: classes.dex */
public abstract class s1 {
    private b a;

    /* compiled from: ActionProvider.java */
    /* renamed from: s1$a */
    /* loaded from: classes.dex */
    public interface a {
    }

    /* compiled from: ActionProvider.java */
    /* renamed from: s1$b */
    /* loaded from: classes.dex */
    public interface b {
        void onActionProviderVisibilityChanged(boolean z);
    }

    public s1(Context context) {
    }

    public View a(MenuItem menuItem) {
        return c();
    }

    public void a(SubMenu subMenu) {
    }

    public void a(a aVar) {
    }

    public boolean a() {
        return false;
    }

    public boolean b() {
        return true;
    }

    public abstract View c();

    public boolean d() {
        return false;
    }

    public boolean e() {
        return false;
    }

    public void f() {
        this.a = null;
    }

    public void a(b bVar) {
        if (this.a != null && bVar != null) {
            Log.w("ActionProvider(support)", "setVisibilityListener: Setting a new ActionProvider.VisibilityListener when one is already set. Are you reusing this " + getClass().getSimpleName() + " instance while it is still in use somewhere else?");
        }
        this.a = bVar;
    }
}
