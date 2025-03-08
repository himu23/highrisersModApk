package com.fyber.inneractive.sdk.flow;

import com.fyber.inneractive.sdk.util.IAlog;
import com.fyber.inneractive.sdk.util.b1;
import com.fyber.inneractive.sdk.util.q;
import java.util.concurrent.TimeUnit;

public class y implements Runnable {
    public final /* synthetic */ long a;
    public final /* synthetic */ z b;

    public class a implements Runnable {
        public a() {
        }

        public void run() {
            z zVar = y.this.b;
            zVar.e(!zVar.u);
            y.this.b.o = null;
        }
    }

    public y(z zVar, long j) {
        this.b = zVar;
        this.a = j;
    }

    public void run() {
        if (this.b.J()) {
            z zVar = this.b;
            zVar.o = new a();
            long a2 = zVar.a(this.a);
            z zVar2 = this.b;
            zVar2.getClass();
            b1 b1Var = new b1(TimeUnit.MILLISECONDS, a2);
            zVar2.p = b1Var;
            b1Var.e = new a0(zVar2);
            b1Var.c();
            z zVar3 = this.b;
            zVar3.getClass();
            IAlog.a("%sad contains custom close. Will show transparent x in %d", IAlog.a((Object) zVar3), Long.valueOf(a2));
            this.b.m = null;
        } else {
            z zVar4 = this.b;
            zVar4.getClass();
            IAlog.a("%sad does not contain custom close. Showing close button", IAlog.a((Object) zVar4));
            this.b.e(false);
        }
        Runnable runnable = this.b.m;
        if (runnable != null) {
            q.b.removeCallbacks(runnable);
            this.b.m = null;
        }
    }
}
