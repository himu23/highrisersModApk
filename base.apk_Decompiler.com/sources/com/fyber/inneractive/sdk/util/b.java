package com.fyber.inneractive.sdk.util;

import android.os.Handler;
import android.os.Looper;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;

public abstract class b<Params, Progress, Result> {
    public final ExecutorService a = Executors.newSingleThreadExecutor(new a(this));
    public Handler b = null;
    public Runnable c;
    public Runnable d;
    public final Object e = new Object();
    public boolean f = false;

    public class a implements ThreadFactory {
        public a(b bVar) {
        }

        public Thread newThread(Runnable runnable) {
            Thread thread = new Thread(runnable);
            thread.setDaemon(true);
            return thread;
        }
    }

    public abstract Result a(Params... paramsArr);

    public abstract void a(Result result);

    public boolean b() {
        return this.a.isTerminated() || this.a.isShutdown();
    }

    public Handler a() {
        if (this.b == null) {
            synchronized (this.e) {
                this.b = new Handler(Looper.getMainLooper());
            }
        }
        return this.b;
    }

    public void c() {
        this.f = true;
        this.a.shutdownNow();
        Handler handler = this.b;
        if (handler != null) {
            Runnable runnable = this.d;
            if (runnable != null) {
                handler.removeCallbacks(runnable);
            }
            Runnable runnable2 = this.c;
            if (runnable2 != null) {
                this.b.removeCallbacks(runnable2);
            }
            this.b = null;
        }
    }
}
