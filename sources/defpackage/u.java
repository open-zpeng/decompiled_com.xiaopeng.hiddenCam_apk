package defpackage;

import android.content.Context;
import android.view.ActionMode;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import androidx.appcompat.view.menu.r;
import defpackage.q;
import java.util.ArrayList;
/* compiled from: SupportActionModeWrapper.java */
/* renamed from: u  reason: default package */
/* loaded from: classes.dex */
public class u extends ActionMode {
    final Context a;
    final q b;

    public u(Context context, q qVar) {
        this.a = context;
        this.b = qVar;
    }

    @Override // android.view.ActionMode
    public void finish() {
        this.b.a();
    }

    @Override // android.view.ActionMode
    public View getCustomView() {
        return this.b.b();
    }

    @Override // android.view.ActionMode
    public Menu getMenu() {
        return r.a(this.a, (g1) this.b.c());
    }

    @Override // android.view.ActionMode
    public MenuInflater getMenuInflater() {
        return this.b.d();
    }

    @Override // android.view.ActionMode
    public CharSequence getSubtitle() {
        return this.b.e();
    }

    @Override // android.view.ActionMode
    public Object getTag() {
        return this.b.f();
    }

    @Override // android.view.ActionMode
    public CharSequence getTitle() {
        return this.b.g();
    }

    @Override // android.view.ActionMode
    public boolean getTitleOptionalHint() {
        return this.b.h();
    }

    @Override // android.view.ActionMode
    public void invalidate() {
        this.b.i();
    }

    @Override // android.view.ActionMode
    public boolean isTitleOptional() {
        return this.b.j();
    }

    @Override // android.view.ActionMode
    public void setCustomView(View view) {
        this.b.a(view);
    }

    @Override // android.view.ActionMode
    public void setSubtitle(CharSequence charSequence) {
        this.b.a(charSequence);
    }

    @Override // android.view.ActionMode
    public void setTag(Object obj) {
        this.b.a(obj);
    }

    @Override // android.view.ActionMode
    public void setTitle(CharSequence charSequence) {
        this.b.b(charSequence);
    }

    @Override // android.view.ActionMode
    public void setTitleOptionalHint(boolean z) {
        this.b.a(z);
    }

    @Override // android.view.ActionMode
    public void setSubtitle(int i) {
        this.b.a(i);
    }

    @Override // android.view.ActionMode
    public void setTitle(int i) {
        this.b.b(i);
    }

    /* compiled from: SupportActionModeWrapper.java */
    /* renamed from: u$a */
    /* loaded from: classes.dex */
    public static class a implements q.a {
        final ActionMode.Callback a;
        final Context b;
        final ArrayList<u> c = new ArrayList<>();
        final j0<Menu, Menu> d = new j0<>();

        public a(Context context, ActionMode.Callback callback) {
            this.b = context;
            this.a = callback;
        }

        @Override // defpackage.q.a
        public boolean a(q qVar, Menu menu) {
            return this.a.onPrepareActionMode(b(qVar), a(menu));
        }

        @Override // defpackage.q.a
        public boolean b(q qVar, Menu menu) {
            return this.a.onCreateActionMode(b(qVar), a(menu));
        }

        @Override // defpackage.q.a
        public boolean a(q qVar, MenuItem menuItem) {
            return this.a.onActionItemClicked(b(qVar), r.a(this.b, (h1) menuItem));
        }

        public ActionMode b(q qVar) {
            int size = this.c.size();
            for (int i = 0; i < size; i++) {
                u uVar = this.c.get(i);
                if (uVar != null && uVar.b == qVar) {
                    return uVar;
                }
            }
            u uVar2 = new u(this.b, qVar);
            this.c.add(uVar2);
            return uVar2;
        }

        @Override // defpackage.q.a
        public void a(q qVar) {
            this.a.onDestroyActionMode(b(qVar));
        }

        private Menu a(Menu menu) {
            Menu menu2 = this.d.get(menu);
            if (menu2 == null) {
                Menu a = r.a(this.b, (g1) menu);
                this.d.put(menu, a);
                return a;
            }
            return menu2;
        }
    }
}
