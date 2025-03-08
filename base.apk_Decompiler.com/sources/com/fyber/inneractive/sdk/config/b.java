package com.fyber.inneractive.sdk.config;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import com.fyber.inneractive.sdk.cache.session.d;
import com.fyber.inneractive.sdk.config.j;
import com.fyber.inneractive.sdk.util.IAlog;
import com.fyber.inneractive.sdk.util.b1;
import com.fyber.inneractive.sdk.util.p;
import com.fyber.inneractive.sdk.util.q;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

public class b implements j.b {
    public final AtomicBoolean a = new AtomicBoolean(false);
    public boolean b = false;
    public b1 c;
    public final g0 d;
    public final Handler e = new Handler(Looper.getMainLooper(), new a());
    public final b1.b f;

    public class a implements Handler.Callback {
        public a() {
        }

        public boolean handleMessage(Message message) {
            if (message.what != 123) {
                return false;
            }
            b bVar = b.this;
            if (bVar.a.compareAndSet(false, true)) {
                if (bVar.a.get() && bVar.c != null) {
                    IAlog.a("startCounting", new Object[0]);
                    bVar.c.c();
                }
                IAlog.a("Pause signal", new Object[0]);
            }
            return true;
        }
    }

    /* renamed from: com.fyber.inneractive.sdk.config.b$b  reason: collision with other inner class name */
    public class C0088b implements Application.ActivityLifecycleCallbacks {
        public C0088b() {
        }

        public void onActivityCreated(Activity activity, Bundle bundle) {
        }

        public void onActivityDestroyed(Activity activity) {
        }

        public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        }

        public void onActivityStarted(Activity activity) {
        }

        public void onActivityStopped(Activity activity) {
        }

        public void onActivityPaused(Activity activity) {
            if (!b.this.e.hasMessages(123) && !b.this.a.get()) {
                b.this.e.sendEmptyMessageDelayed(123, 3000);
            }
        }

        public void onActivityResumed(Activity activity) {
            b.this.e.removeMessages(123);
            b bVar = b.this;
            if (bVar.a.compareAndSet(true, false)) {
                if (bVar.b) {
                    IAlog.a("onActivityResumed: restartSession", new Object[0]);
                    bVar.b = false;
                    g0 g0Var = bVar.d;
                    if (g0Var != null) {
                        d dVar = ((f0) g0Var).a;
                        if (dVar != null) {
                            dVar.a(dVar.a);
                            q.a(new com.fyber.inneractive.sdk.cache.session.c(dVar, com.fyber.inneractive.sdk.cache.session.enums.a.NEW_SESSION, com.fyber.inneractive.sdk.cache.session.enums.b.NONE));
                        }
                        g0 g0Var2 = bVar.d;
                        ((f0) g0Var2).c.put("SESSION_STAMP", Long.toString(SystemClock.elapsedRealtime()));
                        ((f0) bVar.d).b.clear();
                    }
                }
                b1 b1Var = bVar.c;
                if (b1Var != null) {
                    b1Var.d = false;
                    b1Var.f = 0;
                    Handler handler = b1Var.c;
                    if (handler != null) {
                        handler.removeMessages(1932593528);
                    }
                }
            }
        }
    }

    public class c implements b1.b {
        public c() {
        }

        public void a(b1 b1Var) {
            IAlog.a("onVisibleTimeReached: %s", Long.valueOf(System.currentTimeMillis()));
            boolean unused = b.this.b = true;
        }
    }

    public b(g0 g0Var) {
        C0088b bVar = new C0088b();
        this.f = new c();
        this.d = g0Var;
        Application a2 = p.a();
        if (a2 != null) {
            a2.registerActivityLifecycleCallbacks(bVar);
        }
    }

    public void onGlobalConfigChanged(j jVar, i iVar) {
        b1 b1Var = this.c;
        if (b1Var != null) {
            b1Var.d = false;
            b1Var.f = 0;
            Handler handler = b1Var.c;
            if (handler != null) {
                handler.removeMessages(1932593528);
            }
            b1 b1Var2 = new b1(TimeUnit.MINUTES, (long) iVar.a("session_duration", 30, 1), this.c.f);
            this.c = b1Var2;
            b1Var2.e = this.f;
        }
        jVar.c.remove(this);
    }
}
