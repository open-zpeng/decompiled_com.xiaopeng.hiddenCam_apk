package defpackage;

import android.view.View;
import android.view.animation.Interpolator;
import java.util.ArrayList;
import java.util.Iterator;
/* compiled from: ViewPropertyAnimatorCompatSet.java */
/* renamed from: w  reason: default package */
/* loaded from: classes.dex */
public class w {
    private Interpolator c;
    m2 d;
    private boolean e;
    private long b = -1;
    private final n2 f = new a();
    final ArrayList<l2> a = new ArrayList<>();

    /* compiled from: ViewPropertyAnimatorCompatSet.java */
    /* renamed from: w$a */
    /* loaded from: classes.dex */
    class a extends n2 {
        private boolean a = false;
        private int b = 0;

        a() {
        }

        void a() {
            this.b = 0;
            this.a = false;
            w.this.b();
        }

        @Override // defpackage.m2
        public void b(View view) {
            int i = this.b + 1;
            this.b = i;
            if (i == w.this.a.size()) {
                m2 m2Var = w.this.d;
                if (m2Var != null) {
                    m2Var.b(null);
                }
                a();
            }
        }

        @Override // defpackage.n2, defpackage.m2
        public void c(View view) {
            if (this.a) {
                return;
            }
            this.a = true;
            m2 m2Var = w.this.d;
            if (m2Var != null) {
                m2Var.c(null);
            }
        }
    }

    public w a(l2 l2Var) {
        if (!this.e) {
            this.a.add(l2Var);
        }
        return this;
    }

    void b() {
        this.e = false;
    }

    public void c() {
        if (this.e) {
            return;
        }
        Iterator<l2> it = this.a.iterator();
        while (it.hasNext()) {
            l2 next = it.next();
            long j = this.b;
            if (j >= 0) {
                next.a(j);
            }
            Interpolator interpolator = this.c;
            if (interpolator != null) {
                next.a(interpolator);
            }
            if (this.d != null) {
                next.a(this.f);
            }
            next.c();
        }
        this.e = true;
    }

    public w a(l2 l2Var, l2 l2Var2) {
        this.a.add(l2Var);
        l2Var2.b(l2Var.b());
        this.a.add(l2Var2);
        return this;
    }

    public void a() {
        if (this.e) {
            Iterator<l2> it = this.a.iterator();
            while (it.hasNext()) {
                it.next().a();
            }
            this.e = false;
        }
    }

    public w a(long j) {
        if (!this.e) {
            this.b = j;
        }
        return this;
    }

    public w a(Interpolator interpolator) {
        if (!this.e) {
            this.c = interpolator;
        }
        return this;
    }

    public w a(m2 m2Var) {
        if (!this.e) {
            this.d = m2Var;
        }
        return this;
    }
}
