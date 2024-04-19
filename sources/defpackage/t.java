package defpackage;

import android.content.Context;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import androidx.appcompat.view.menu.h;
import androidx.appcompat.widget.ActionBarContextView;
import defpackage.q;
import java.lang.ref.WeakReference;
/* compiled from: StandaloneActionMode.java */
/* renamed from: t  reason: default package */
/* loaded from: classes.dex */
public class t extends q implements h.a {
    private Context d;
    private ActionBarContextView e;
    private q.a f;
    private WeakReference<View> g;
    private boolean h;
    private h i;

    public t(Context context, ActionBarContextView actionBarContextView, q.a aVar, boolean z) {
        this.d = context;
        this.e = actionBarContextView;
        this.f = aVar;
        h hVar = new h(actionBarContextView.getContext());
        hVar.c(1);
        this.i = hVar;
        this.i.a(this);
    }

    @Override // defpackage.q
    public void a(CharSequence charSequence) {
        this.e.setSubtitle(charSequence);
    }

    @Override // defpackage.q
    public void b(CharSequence charSequence) {
        this.e.setTitle(charSequence);
    }

    @Override // defpackage.q
    public Menu c() {
        return this.i;
    }

    @Override // defpackage.q
    public MenuInflater d() {
        return new v(this.e.getContext());
    }

    @Override // defpackage.q
    public CharSequence e() {
        return this.e.getSubtitle();
    }

    @Override // defpackage.q
    public CharSequence g() {
        return this.e.getTitle();
    }

    @Override // defpackage.q
    public void i() {
        this.f.a(this, this.i);
    }

    @Override // defpackage.q
    public boolean j() {
        return this.e.b();
    }

    @Override // defpackage.q
    public void a(int i) {
        a((CharSequence) this.d.getString(i));
    }

    @Override // defpackage.q
    public void b(int i) {
        b(this.d.getString(i));
    }

    @Override // defpackage.q
    public void a(boolean z) {
        super.a(z);
        this.e.setTitleOptional(z);
    }

    @Override // defpackage.q
    public View b() {
        WeakReference<View> weakReference = this.g;
        if (weakReference != null) {
            return weakReference.get();
        }
        return null;
    }

    @Override // defpackage.q
    public void a(View view) {
        this.e.setCustomView(view);
        this.g = view != null ? new WeakReference<>(view) : null;
    }

    @Override // defpackage.q
    public void a() {
        if (this.h) {
            return;
        }
        this.h = true;
        this.e.sendAccessibilityEvent(32);
        this.f.a(this);
    }

    @Override // androidx.appcompat.view.menu.h.a
    public boolean a(h hVar, MenuItem menuItem) {
        return this.f.a(this, menuItem);
    }

    @Override // androidx.appcompat.view.menu.h.a
    public void a(h hVar) {
        i();
        this.e.d();
    }
}
