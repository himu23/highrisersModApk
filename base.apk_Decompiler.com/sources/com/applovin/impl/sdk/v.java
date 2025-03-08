package com.applovin.impl.sdk;

import com.applovin.impl.sdk.c.a;
import com.applovin.impl.sdk.e.ab;
import com.applovin.impl.sdk.e.d;
import com.applovin.impl.sdk.e.q;
import com.applovin.impl.sdk.r;
import java.util.concurrent.TimeUnit;

public class v {
    private static boolean aFh;

    public static void Fg() {
        aFh = true;
    }

    public static void w(n nVar) {
        Long l = (Long) nVar.a(a.aKe);
        if (l.longValue() > 0) {
            nVar.BO().a((d) new ab(nVar, true, "submitIntegrationErrorReport", new v$$ExternalSyntheticLambda0(nVar)), q.b.MAIN, TimeUnit.SECONDS.toMillis(l.longValue()));
        }
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ void x(n nVar) {
        if (!aFh) {
            nVar.Cs().a(r.a.INTEGRATION_ERROR, "no_ads_loaded", (String) null);
        }
    }
}
