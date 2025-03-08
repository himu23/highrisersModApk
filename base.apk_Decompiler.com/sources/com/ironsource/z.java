package com.ironsource;

import com.ironsource.mediationsdk.logger.IronLog;
import com.ironsource.y;
import java.util.Timer;
import java.util.TimerTask;

public class z {
    private final y a;
    /* access modifiers changed from: private */
    public final s8 b;
    private final o8 c = b();
    private Timer d;

    class a implements Runnable {
        a() {
        }

        public void run() {
            z.this.b.a();
        }
    }

    class b extends TimerTask {
        b() {
        }

        public void run() {
            z.this.b.a();
        }
    }

    public z(y yVar, s8 s8Var) {
        this.a = yVar;
        this.b = s8Var;
    }

    private void a(long j) {
        this.c.a(j);
    }

    private o8 b() {
        return new o8(new a(), com.ironsource.lifecycle.b.d(), new hc());
    }

    private void b(long j) {
        h();
        Timer timer = new Timer();
        this.d = timer;
        timer.schedule(new b(), j);
    }

    private void g() {
        this.c.b();
    }

    private void h() {
        Timer timer = this.d;
        if (timer != null) {
            timer.cancel();
            this.d = null;
        }
    }

    public void a() {
        if (this.a.a() == y.a.MANUAL_WITH_AUTOMATIC_RELOAD) {
            g();
        }
    }

    public void c() {
        if (this.a.e()) {
            IronLog.INTERNAL.verbose();
            b(this.a.c());
        }
    }

    public void d() {
        if (this.a.a() == y.a.AUTOMATIC_LOAD_AFTER_CLOSE) {
            IronLog.INTERNAL.verbose();
            b(this.a.d());
        }
    }

    public void e() {
        if (this.a.e()) {
            IronLog.INTERNAL.verbose();
            b(0);
        }
    }

    public void f() {
        if (this.a.a() == y.a.AUTOMATIC_LOAD_WHILE_SHOW) {
            IronLog.INTERNAL.verbose();
            b(this.a.d());
        }
    }

    public void i() {
        if (this.a.a() == y.a.MANUAL_WITH_AUTOMATIC_RELOAD && this.a.b() > 0) {
            IronLog.INTERNAL.verbose();
            a(this.a.b());
        }
    }
}
