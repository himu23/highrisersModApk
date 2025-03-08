package com.fyber.inneractive.sdk.config;

import android.content.Context;
import com.fyber.inneractive.sdk.measurement.b;
import com.fyber.inneractive.sdk.measurement.c;
import com.fyber.inneractive.sdk.util.q;

public class n implements Runnable {
    public final /* synthetic */ IAConfigManager a;
    public final /* synthetic */ Context b;

    public class a implements Runnable {
        public a() {
        }

        public void run() {
            n.this.a.J = new b();
            n nVar = n.this;
            com.fyber.inneractive.sdk.measurement.a aVar = nVar.a.J;
            Context context = nVar.b;
            if (!aVar.a) {
                aVar.a = true;
                q.b.post(new c((b) aVar, context));
            }
        }
    }

    public n(IAConfigManager iAConfigManager, Context context) {
        this.a = iAConfigManager;
        this.b = context;
    }

    public void run() {
        try {
            Class.forName("com.iab.omid.library.fyber.Omid");
            q.b.post(new a());
        } catch (Throwable unused) {
        }
    }
}
