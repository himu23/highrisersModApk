package com.ironsource;

import com.ironsource.lifecycle.b;
import java.util.Calendar;
import java.util.Timer;
import java.util.TimerTask;

public class p8 implements h8 {
    private String a = "INTERNAL";
    private Timer b;
    private boolean c;
    private Long d;
    private long e;
    /* access modifiers changed from: private */
    public Runnable f;

    class a extends TimerTask {
        a() {
        }

        public void run() {
            p8.this.f.run();
        }
    }

    public p8(long j, Runnable runnable, boolean z) {
        this.e = j;
        this.f = runnable;
        this.c = false;
        this.d = null;
        if (z) {
            g();
        }
    }

    private void f() {
        Timer timer = this.b;
        if (timer != null) {
            timer.cancel();
            this.b = null;
        }
    }

    private void h() {
        if (this.b == null) {
            Timer timer = new Timer();
            this.b = timer;
            timer.schedule(new a(), this.e);
            Calendar.getInstance().setTimeInMillis(this.d.longValue());
        }
    }

    public void a() {
    }

    public void b() {
        if (this.b != null) {
            f();
        }
    }

    public void c() {
        Long l;
        if (this.b == null && (l = this.d) != null) {
            long longValue = l.longValue() - System.currentTimeMillis();
            this.e = longValue;
            if (longValue <= 0) {
                e();
                this.f.run();
                return;
            }
            h();
        }
    }

    public void d() {
    }

    public void e() {
        f();
        this.c = false;
        this.d = null;
        b.d().b((h8) this);
    }

    public void g() {
        if (!this.c) {
            this.c = true;
            b.d().a((h8) this);
            this.d = Long.valueOf(System.currentTimeMillis() + this.e);
            if (!b.d().e()) {
                h();
            }
        }
    }
}
