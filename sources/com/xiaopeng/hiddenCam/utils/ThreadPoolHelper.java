package com.xiaopeng.hiddenCam.utils;

import android.os.Handler;
import android.os.Looper;
import android.os.PowerManager;
import com.xiaopeng.hiddenCam.App;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
/* loaded from: classes.dex */
public class ThreadPoolHelper {
    private static final String TAG = "ThreadPoolHelper";
    private ExecutorService cachedThreadPool;
    private Runnable mKillTask;
    private Handler mMainHandler;
    private ExecutorService mSingleThreadPool;
    private ExecutorService mSingleThreadPool2;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class SingletonHolder {
        private static ThreadPoolHelper INSTANCE = new ThreadPoolHelper();

        private SingletonHolder() {
        }
    }

    public static ThreadPoolHelper getInstance() {
        return SingletonHolder.INSTANCE;
    }

    protected void clearKillProcess() {
        getInstance().removeCallbacksOnMainThread(this.mKillTask);
    }

    protected void delayKillProcess() {
        ((PowerManager) App.a().getSystemService("power")).newWakeLock(1, "okTag").acquire(30000L);
    }

    public void executeBySequence(Runnable runnable) {
        this.mSingleThreadPool.execute(runnable);
    }

    public void postDelayedOnMainThread(Runnable runnable, long j) {
        this.mMainHandler.postDelayed(runnable, j);
    }

    public void removeCallbacksOnMainThread(Runnable runnable) {
        this.mMainHandler.removeCallbacks(runnable);
    }

    private ThreadPoolHelper() {
        this.mKillTask = new Runnable() { // from class: com.xiaopeng.hiddenCam.utils.ThreadPoolHelper.1
            @Override // java.lang.Runnable
            public void run() {
                if (ThreadPoolHelper.this.mSingleThreadPool != null) {
                    LogUtils.d("kill execute service!!!");
                    ThreadPoolHelper.this.mSingleThreadPool.shutdown();
                    ThreadPoolHelper.this.mSingleThreadPool = null;
                }
            }
        };
        this.mSingleThreadPool = Executors.newSingleThreadExecutor();
        this.mMainHandler = new Handler(Looper.getMainLooper());
    }
}
