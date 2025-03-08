package com.fyber.inneractive.sdk.flow;

import android.os.Handler;
import com.fyber.inneractive.sdk.interfaces.a;
import com.fyber.inneractive.sdk.util.IAlog;
import com.fyber.inneractive.sdk.util.q;

public class b {
    public Handler a;
    public final a.b b;
    public final Runnable c = new a();
    public final Runnable d = new C0097b();

    public class a implements Runnable {
        public a() {
        }

        public void run() {
            IAlog.a("%s : ContentLoadTimeoutHandler Executing timeout task", IAlog.a((Object) b.this));
            b.this.b.b();
        }
    }

    /* renamed from: com.fyber.inneractive.sdk.flow.b$b  reason: collision with other inner class name */
    public class C0097b implements Runnable {
        public C0097b() {
        }

        public void run() {
            q.b.post(b.this.c);
        }
    }

    public b(a.b bVar) {
        this.b = bVar;
    }

    public void a() {
        IAlog.a("%s : ContentLoadTimeoutHandler destroying timeout handler", IAlog.a((Object) this));
        if (this.a != null) {
            b();
            this.a.getLooper().quitSafely();
            this.a = null;
        }
    }

    public void b() {
        IAlog.a("%s : ContentLoadTimeoutHandler stopping timeout handler", IAlog.a((Object) this));
        Handler handler = this.a;
        if (handler != null) {
            handler.removeCallbacks(this.d);
        }
    }
}
