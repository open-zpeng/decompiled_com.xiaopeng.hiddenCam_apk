package defpackage;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.os.Build;
import android.view.View;
import android.view.animation.Interpolator;
import java.lang.ref.WeakReference;
/* compiled from: ViewPropertyAnimatorCompat.java */
/* renamed from: l2  reason: default package */
/* loaded from: classes.dex */
public final class l2 {
    private WeakReference<View> a;
    Runnable b = null;
    Runnable c = null;
    int d = -1;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ViewPropertyAnimatorCompat.java */
    /* renamed from: l2$a */
    /* loaded from: classes.dex */
    public class a extends AnimatorListenerAdapter {
        final /* synthetic */ m2 a;
        final /* synthetic */ View b;

        a(l2 l2Var, m2 m2Var, View view) {
            this.a = m2Var;
            this.b = view;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            this.a.a(this.b);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            this.a.b(this.b);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            this.a.c(this.b);
        }
    }

    /* compiled from: ViewPropertyAnimatorCompat.java */
    /* renamed from: l2$b */
    /* loaded from: classes.dex */
    class b implements ValueAnimator.AnimatorUpdateListener {
        final /* synthetic */ o2 a;
        final /* synthetic */ View b;

        b(l2 l2Var, o2 o2Var, View view) {
            this.a = o2Var;
            this.b = view;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            this.a.a(this.b);
        }
    }

    /* compiled from: ViewPropertyAnimatorCompat.java */
    /* renamed from: l2$c */
    /* loaded from: classes.dex */
    static class c implements m2 {
        l2 a;
        boolean b;

        c(l2 l2Var) {
            this.a = l2Var;
        }

        @Override // defpackage.m2
        public void a(View view) {
            Object tag = view.getTag(2113929216);
            m2 m2Var = tag instanceof m2 ? (m2) tag : null;
            if (m2Var != null) {
                m2Var.a(view);
            }
        }

        @Override // defpackage.m2
        public void b(View view) {
            int i = this.a.d;
            if (i > -1) {
                view.setLayerType(i, null);
                this.a.d = -1;
            }
            if (Build.VERSION.SDK_INT >= 16 || !this.b) {
                l2 l2Var = this.a;
                Runnable runnable = l2Var.c;
                if (runnable != null) {
                    l2Var.c = null;
                    runnable.run();
                }
                Object tag = view.getTag(2113929216);
                m2 m2Var = tag instanceof m2 ? (m2) tag : null;
                if (m2Var != null) {
                    m2Var.b(view);
                }
                this.b = true;
            }
        }

        @Override // defpackage.m2
        public void c(View view) {
            this.b = false;
            if (this.a.d > -1) {
                view.setLayerType(2, null);
            }
            l2 l2Var = this.a;
            Runnable runnable = l2Var.b;
            if (runnable != null) {
                l2Var.b = null;
                runnable.run();
            }
            Object tag = view.getTag(2113929216);
            m2 m2Var = tag instanceof m2 ? (m2) tag : null;
            if (m2Var != null) {
                m2Var.c(view);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public l2(View view) {
        this.a = new WeakReference<>(view);
    }

    public l2 a(long j) {
        View view = this.a.get();
        if (view != null) {
            view.animate().setDuration(j);
        }
        return this;
    }

    public l2 b(float f) {
        View view = this.a.get();
        if (view != null) {
            view.animate().translationY(f);
        }
        return this;
    }

    public void c() {
        View view = this.a.get();
        if (view != null) {
            view.animate().start();
        }
    }

    public l2 a(float f) {
        View view = this.a.get();
        if (view != null) {
            view.animate().alpha(f);
        }
        return this;
    }

    public long b() {
        View view = this.a.get();
        if (view != null) {
            return view.animate().getDuration();
        }
        return 0L;
    }

    public l2 a(Interpolator interpolator) {
        View view = this.a.get();
        if (view != null) {
            view.animate().setInterpolator(interpolator);
        }
        return this;
    }

    public l2 b(long j) {
        View view = this.a.get();
        if (view != null) {
            view.animate().setStartDelay(j);
        }
        return this;
    }

    public void a() {
        View view = this.a.get();
        if (view != null) {
            view.animate().cancel();
        }
    }

    public l2 a(m2 m2Var) {
        View view = this.a.get();
        if (view != null) {
            if (Build.VERSION.SDK_INT >= 16) {
                a(view, m2Var);
            } else {
                view.setTag(2113929216, m2Var);
                a(view, new c(this));
            }
        }
        return this;
    }

    private void a(View view, m2 m2Var) {
        if (m2Var != null) {
            view.animate().setListener(new a(this, m2Var, view));
        } else {
            view.animate().setListener(null);
        }
    }

    public l2 a(o2 o2Var) {
        View view = this.a.get();
        if (view != null && Build.VERSION.SDK_INT >= 19) {
            view.animate().setUpdateListener(o2Var != null ? new b(this, o2Var, view) : null);
        }
        return this;
    }
}
