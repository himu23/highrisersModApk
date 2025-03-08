package com.ironsource;

import java.util.Timer;
import java.util.TimerTask;

public abstract class d<T> {
    private Timer a;
    protected long b;
    protected T c;

    class a extends TimerTask {
        a() {
        }

        public void run() {
            d.this.b();
        }
    }

    public d() {
    }

    public d(long j) {
        this.b = j;
    }

    /* access modifiers changed from: protected */
    public void a(T t) {
        if (!a() && t != null) {
            this.c = t;
            c();
            Timer timer = new Timer();
            this.a = timer;
            timer.schedule(new a(), this.b);
        }
    }

    /* access modifiers changed from: protected */
    public boolean a() {
        return this.b <= 0;
    }

    /* access modifiers changed from: protected */
    public abstract void b();

    /* access modifiers changed from: protected */
    public void c() {
        Timer timer = this.a;
        if (timer != null) {
            timer.cancel();
            this.a = null;
        }
    }

    public void d() {
        this.c = null;
    }
}
