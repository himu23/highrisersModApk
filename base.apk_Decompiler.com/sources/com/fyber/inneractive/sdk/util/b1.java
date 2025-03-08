package com.fyber.inneractive.sdk.util;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import java.lang.ref.WeakReference;
import java.util.concurrent.TimeUnit;

public class b1 {
    public final TimeUnit a;
    public final long b;
    public Handler c;
    public boolean d;
    public b e;
    public long f;

    public static class a extends Handler {
        public final WeakReference<b1> a;

        public a(b1 b1Var) {
            super(Looper.getMainLooper());
            this.a = new WeakReference<>(b1Var);
        }

        public void handleMessage(Message message) {
            super.handleMessage(message);
            b1 b1Var = (b1) this.a.get();
            if (b1Var != null && message.what == 1932593528 && !b1Var.d) {
                b1Var.a(message.getWhen());
            }
        }
    }

    public interface b {
        void a(b1 b1Var);
    }

    public b1(TimeUnit timeUnit, long j) {
        this.d = false;
        this.f = 0;
        this.b = j;
        this.a = timeUnit;
        IAlog.a("Visible time counter init - time %d", Long.valueOf(j));
    }

    public void c() {
        a aVar = new a(this);
        this.c = aVar;
        this.d = false;
        aVar.sendEmptyMessage(1932593528);
    }

    public void b() {
        this.d = false;
        a(SystemClock.uptimeMillis());
    }

    public void a() {
        this.d = true;
        Handler handler = this.c;
        if (handler != null) {
            handler.removeMessages(1932593528);
        }
    }

    public final void a(long j) {
        long uptimeMillis = this.f + (SystemClock.uptimeMillis() - j) + 50;
        this.f = uptimeMillis;
        if (this.e == null || uptimeMillis <= this.a.toMillis(this.b)) {
            Handler handler = this.c;
            if (handler != null && this.e != null) {
                handler.removeMessages(1932593528);
                this.c.sendEmptyMessageDelayed(1932593528, 50);
                return;
            }
            return;
        }
        this.e.a(this);
    }

    public b1(TimeUnit timeUnit, long j, long j2) {
        this.d = false;
        this.b = j;
        this.a = timeUnit;
        this.f = j2;
        IAlog.a("Visible time counter init - time %d", Long.valueOf(j));
    }
}
