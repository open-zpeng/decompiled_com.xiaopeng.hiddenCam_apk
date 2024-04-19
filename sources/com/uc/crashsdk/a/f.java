package com.uc.crashsdk.a;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import java.util.HashMap;
/* compiled from: ProGuard */
/* loaded from: classes.dex */
public class f {
    private static volatile HandlerThread b;
    private static volatile HandlerThread c;
    private static Handler d;
    private static Handler e;
    private static Handler f;
    static final /* synthetic */ boolean a = !f.class.desiredAssertionStatus();
    private static final HashMap<Object, Object[]> g = new HashMap<>();

    public static boolean a(int i, Runnable runnable, long j) {
        Handler handler;
        if (runnable == null) {
            return false;
        }
        if (i == 0) {
            if (b == null) {
                a();
            }
            handler = d;
        } else if (i == 1) {
            if (c == null) {
                b();
            }
            handler = e;
        } else if (i == 2) {
            if (f == null) {
                f = new Handler(Looper.getMainLooper());
            }
            handler = f;
        } else {
            throw new RuntimeException("unknown thread type: " + i);
        }
        if (handler == null) {
            return false;
        }
        e eVar = new e(10, new Object[]{runnable});
        synchronized (g) {
            g.put(runnable, new Object[]{eVar, Integer.valueOf(i)});
        }
        return handler.postDelayed(eVar, j);
    }

    public static boolean b(Runnable runnable) {
        Object[] objArr;
        if (runnable == null) {
            return false;
        }
        synchronized (g) {
            objArr = g.get(runnable);
        }
        return objArr != null;
    }

    private static synchronized void b() {
        synchronized (f.class) {
            if (c == null) {
                HandlerThread handlerThread = new HandlerThread("CrashSDKNormalHandler", 0);
                c = handlerThread;
                handlerThread.start();
                e = new Handler(c.getLooper());
            }
        }
    }

    public static void a(int i, Object[] objArr) {
        if (i != 10) {
            if (!a) {
                throw new AssertionError();
            }
        } else if (!a && objArr == null) {
            throw new AssertionError();
        } else {
            Runnable runnable = (Runnable) objArr[0];
            synchronized (g) {
                if (g.get(runnable) != null) {
                    g.remove(runnable);
                }
            }
            runnable.run();
        }
    }

    public static boolean a(int i, Runnable runnable) {
        return a(i, runnable, 0L);
    }

    public static void a(Runnable runnable) {
        Object[] objArr;
        if (runnable == null) {
            return;
        }
        synchronized (g) {
            objArr = g.get(runnable);
        }
        if (objArr == null) {
            return;
        }
        int intValue = ((Integer) objArr[1]).intValue();
        Handler handler = null;
        if (intValue == 0) {
            handler = d;
        } else if (intValue == 1) {
            handler = e;
        } else if (intValue == 2) {
            handler = f;
        }
        if (handler != null) {
            handler.removeCallbacks((Runnable) objArr[0]);
        }
        synchronized (g) {
            if (g.get(runnable) != null) {
                g.remove(runnable);
            }
        }
    }

    private static synchronized void a() {
        synchronized (f.class) {
            if (b == null) {
                HandlerThread handlerThread = new HandlerThread("CrashSDKBkgdHandler", 10);
                b = handlerThread;
                handlerThread.start();
                d = new Handler(b.getLooper());
            }
        }
    }
}
