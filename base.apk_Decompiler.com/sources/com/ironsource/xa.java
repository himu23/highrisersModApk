package com.ironsource;

import java.util.Timer;
import java.util.TimerTask;

public class xa {
    private com.ironsource.mediationsdk.utils.a a;
    /* access modifiers changed from: private */
    public ya b;
    private Timer c = null;

    class a extends TimerTask {
        a() {
        }

        public void run() {
            xa.this.b.a();
        }
    }

    class b extends TimerTask {
        b() {
        }

        public void run() {
            xa.this.b.a();
        }
    }

    public xa(com.ironsource.mediationsdk.utils.a aVar, ya yaVar) {
        this.a = aVar;
        this.b = yaVar;
    }

    private void d() {
        Timer timer = this.c;
        if (timer != null) {
            timer.cancel();
            this.c = null;
        }
    }

    public synchronized void a() {
        d();
        Timer timer = new Timer();
        this.c = timer;
        timer.schedule(new b(), this.a.b());
    }

    public void b() {
        synchronized (this) {
            d();
        }
        this.b.a();
    }

    public synchronized void c() {
        d();
        Timer timer = new Timer();
        this.c = timer;
        timer.schedule(new a(), this.a.j());
    }
}
