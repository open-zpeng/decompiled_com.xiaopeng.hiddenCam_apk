package defpackage;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;
/* compiled from: SelfDestructiveThread.java */
/* renamed from: l1  reason: default package */
/* loaded from: classes.dex */
public class l1 {
    private HandlerThread b;
    private Handler c;
    private final int f;
    private final int g;
    private final String h;
    private final Object a = new Object();
    private Handler.Callback e = new a();
    private int d = 0;

    /* compiled from: SelfDestructiveThread.java */
    /* renamed from: l1$a */
    /* loaded from: classes.dex */
    class a implements Handler.Callback {
        a() {
        }

        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            int i = message.what;
            if (i == 0) {
                l1.this.a();
                return true;
            } else if (i != 1) {
                return true;
            } else {
                l1.this.a((Runnable) message.obj);
                return true;
            }
        }
    }

    /* compiled from: SelfDestructiveThread.java */
    /* renamed from: l1$b */
    /* loaded from: classes.dex */
    class b implements Runnable {
        final /* synthetic */ Callable b;
        final /* synthetic */ Handler c;
        final /* synthetic */ d d;

        /* compiled from: SelfDestructiveThread.java */
        /* renamed from: l1$b$a */
        /* loaded from: classes.dex */
        class a implements Runnable {
            final /* synthetic */ Object b;

            a(Object obj) {
                this.b = obj;
            }

            @Override // java.lang.Runnable
            public void run() {
                b.this.d.a(this.b);
            }
        }

        b(l1 l1Var, Callable callable, Handler handler, d dVar) {
            this.b = callable;
            this.c = handler;
            this.d = dVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Object obj;
            try {
                obj = this.b.call();
            } catch (Exception unused) {
                obj = null;
            }
            this.c.post(new a(obj));
        }
    }

    /* compiled from: SelfDestructiveThread.java */
    /* renamed from: l1$c */
    /* loaded from: classes.dex */
    class c implements Runnable {
        final /* synthetic */ AtomicReference b;
        final /* synthetic */ Callable c;
        final /* synthetic */ ReentrantLock d;
        final /* synthetic */ AtomicBoolean e;
        final /* synthetic */ Condition f;

        c(l1 l1Var, AtomicReference atomicReference, Callable callable, ReentrantLock reentrantLock, AtomicBoolean atomicBoolean, Condition condition) {
            this.b = atomicReference;
            this.c = callable;
            this.d = reentrantLock;
            this.e = atomicBoolean;
            this.f = condition;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                this.b.set(this.c.call());
            } catch (Exception unused) {
            }
            this.d.lock();
            try {
                this.e.set(false);
                this.f.signal();
            } finally {
                this.d.unlock();
            }
        }
    }

    /* compiled from: SelfDestructiveThread.java */
    /* renamed from: l1$d */
    /* loaded from: classes.dex */
    public interface d<T> {
        void a(T t);
    }

    public l1(String str, int i, int i2) {
        this.h = str;
        this.g = i;
        this.f = i2;
    }

    private void b(Runnable runnable) {
        synchronized (this.a) {
            if (this.b == null) {
                this.b = new HandlerThread(this.h, this.g);
                this.b.start();
                this.c = new Handler(this.b.getLooper(), this.e);
                this.d++;
            }
            this.c.removeMessages(0);
            this.c.sendMessage(this.c.obtainMessage(1, runnable));
        }
    }

    public <T> void a(Callable<T> callable, d<T> dVar) {
        b(new b(this, callable, new Handler(), dVar));
    }

    public <T> T a(Callable<T> callable, int i) throws InterruptedException {
        ReentrantLock reentrantLock = new ReentrantLock();
        Condition newCondition = reentrantLock.newCondition();
        AtomicReference atomicReference = new AtomicReference();
        AtomicBoolean atomicBoolean = new AtomicBoolean(true);
        b(new c(this, atomicReference, callable, reentrantLock, atomicBoolean, newCondition));
        reentrantLock.lock();
        try {
            if (!atomicBoolean.get()) {
                return (T) atomicReference.get();
            }
            long nanos = TimeUnit.MILLISECONDS.toNanos(i);
            do {
                try {
                    nanos = newCondition.awaitNanos(nanos);
                } catch (InterruptedException unused) {
                }
                if (!atomicBoolean.get()) {
                    return (T) atomicReference.get();
                }
            } while (nanos > 0);
            throw new InterruptedException("timeout");
        } finally {
            reentrantLock.unlock();
        }
    }

    void a(Runnable runnable) {
        runnable.run();
        synchronized (this.a) {
            this.c.removeMessages(0);
            this.c.sendMessageDelayed(this.c.obtainMessage(0), this.f);
        }
    }

    void a() {
        synchronized (this.a) {
            if (this.c.hasMessages(1)) {
                return;
            }
            this.b.quit();
            this.b = null;
            this.c = null;
        }
    }
}
