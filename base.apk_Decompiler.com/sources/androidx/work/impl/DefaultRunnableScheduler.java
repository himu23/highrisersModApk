package androidx.work.impl;

import android.os.Handler;
import android.os.Looper;
import androidx.core.os.HandlerCompat;
import androidx.work.RunnableScheduler;

public class DefaultRunnableScheduler implements RunnableScheduler {
    private final Handler mHandler;

    public Handler getHandler() {
        return this.mHandler;
    }

    public DefaultRunnableScheduler() {
        this.mHandler = HandlerCompat.createAsync(Looper.getMainLooper());
    }

    public DefaultRunnableScheduler(Handler handler) {
        this.mHandler = handler;
    }

    public void scheduleWithDelay(long j, Runnable runnable) {
        this.mHandler.postDelayed(runnable, j);
    }

    public void cancel(Runnable runnable) {
        this.mHandler.removeCallbacks(runnable);
    }
}
