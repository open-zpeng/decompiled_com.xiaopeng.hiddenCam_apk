package defpackage;

import java.util.concurrent.Executor;
/* compiled from: ArchTaskExecutor.java */
/* renamed from: y  reason: default package */
/* loaded from: classes.dex */
public class y extends a0 {
    private static volatile y c;
    private a0 b = new z();
    private a0 a = this.b;

    /* compiled from: ArchTaskExecutor.java */
    /* renamed from: y$a */
    /* loaded from: classes.dex */
    static class a implements Executor {
        a() {
        }

        @Override // java.util.concurrent.Executor
        public void execute(Runnable runnable) {
            y.b().b(runnable);
        }
    }

    /* compiled from: ArchTaskExecutor.java */
    /* renamed from: y$b */
    /* loaded from: classes.dex */
    static class b implements Executor {
        b() {
        }

        @Override // java.util.concurrent.Executor
        public void execute(Runnable runnable) {
            y.b().a(runnable);
        }
    }

    static {
        new a();
        new b();
    }

    private y() {
    }

    public static y b() {
        if (c != null) {
            return c;
        }
        synchronized (y.class) {
            if (c == null) {
                c = new y();
            }
        }
        return c;
    }

    @Override // defpackage.a0
    public void a(Runnable runnable) {
        this.a.a(runnable);
    }

    @Override // defpackage.a0
    public boolean a() {
        return this.a.a();
    }

    @Override // defpackage.a0
    public void b(Runnable runnable) {
        this.a.b(runnable);
    }
}
