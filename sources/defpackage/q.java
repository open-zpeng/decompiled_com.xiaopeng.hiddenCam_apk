package defpackage;

import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
/* compiled from: ActionMode.java */
/* renamed from: q  reason: default package */
/* loaded from: classes.dex */
public abstract class q {
    private Object b;
    private boolean c;

    /* compiled from: ActionMode.java */
    /* renamed from: q$a */
    /* loaded from: classes.dex */
    public interface a {
        void a(q qVar);

        boolean a(q qVar, Menu menu);

        boolean a(q qVar, MenuItem menuItem);

        boolean b(q qVar, Menu menu);
    }

    public abstract void a();

    public abstract void a(int i);

    public abstract void a(View view);

    public abstract void a(CharSequence charSequence);

    public void a(Object obj) {
        this.b = obj;
    }

    public abstract View b();

    public abstract void b(int i);

    public abstract void b(CharSequence charSequence);

    public abstract Menu c();

    public abstract MenuInflater d();

    public abstract CharSequence e();

    public Object f() {
        return this.b;
    }

    public abstract CharSequence g();

    public boolean h() {
        return this.c;
    }

    public abstract void i();

    public abstract boolean j();

    public void a(boolean z) {
        this.c = z;
    }
}
