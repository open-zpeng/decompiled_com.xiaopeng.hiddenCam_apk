package defpackage;

import android.os.Handler;
import android.os.Looper;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;
/* compiled from: DefaultTaskExecutor.java */
/* renamed from: z  reason: default package */
/* loaded from: classes.dex */
public class z extends a0 {
    private final Object a = new Object();
    private final ExecutorService b = Executors.newFixedThreadPool(2, new a(this));
    private volatile Handler c;

    /* compiled from: DefaultTaskExecutor.java */
    /* renamed from: z$a */
    /* loaded from: classes.dex */
    class a implements ThreadFactory {
        private final AtomicInteger a = new AtomicInteger(0);

        a(z zVar) {
        }

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable runnable) {
            Thread thread = new Thread(runnable);
            thread.setName(String.format("arch_disk_io_%d", Integer.valueOf(this.a.getAndIncrement())));
            return thread;
        }
    }

    @Override // defpackage.a0
    public void a(Runnable runnable) {
        this.b.execute(runnable);
    }

    @Override // defpackage.a0
    public void b(Runnable runnable) {
        if (this.c == null) {
            synchronized (this.a) {
                if (this.c == null) {
                    this.c = new Handler(Looper.getMainLooper());
                }
            }
        }
        this.c.post(runnable);
    }

    @Override // defpackage.a0
    public boolean a() {
        return Looper.getMainLooper().getThread() == Thread.currentThread();
    }
}
