package com.ironsource;

import android.util.Log;
import java.util.Timer;
import java.util.TimerTask;

public class o8 {
    private static final String g = "o8";
    /* access modifiers changed from: private */
    public final com.ironsource.lifecycle.b a;
    /* access modifiers changed from: private */
    public final Runnable b;
    /* access modifiers changed from: private */
    public final hc c;
    private final Object d = new Object();
    private Timer e;
    /* access modifiers changed from: private */
    public final h8 f = new a();

    class a implements h8 {
        a() {
        }

        public void a() {
        }

        public void b() {
            o8.this.c.c(System.currentTimeMillis());
            o8.this.c();
        }

        public void c() {
            o8.this.c.b(System.currentTimeMillis());
            o8 o8Var = o8.this;
            o8Var.b(o8Var.c.a());
        }

        public void d() {
        }
    }

    class b extends TimerTask {
        b() {
        }

        public void run() {
            o8.this.a.b(o8.this.f);
            o8.this.c.b();
            o8.this.b.run();
        }
    }

    public o8(Runnable runnable, com.ironsource.lifecycle.b bVar, hc hcVar) {
        this.b = runnable;
        this.a = bVar;
        this.c = hcVar;
    }

    /* access modifiers changed from: private */
    public void b(long j) {
        synchronized (this.d) {
            c();
            Timer timer = new Timer();
            this.e = timer;
            timer.schedule(new b(), j);
        }
    }

    /* access modifiers changed from: private */
    public void c() {
        synchronized (this.d) {
            Timer timer = this.e;
            if (timer != null) {
                timer.cancel();
                this.e = null;
            }
        }
    }

    public void a() {
        a(0);
    }

    public void a(long j) {
        if (j < 0) {
            Log.d(g, "cannot start timer with delay < 0");
            return;
        }
        this.a.a(this.f);
        this.c.a(j);
        if (this.a.e()) {
            this.c.c(System.currentTimeMillis());
        } else {
            b(j);
        }
    }

    public void b() {
        c();
        this.a.b(this.f);
        this.c.b();
    }
}
