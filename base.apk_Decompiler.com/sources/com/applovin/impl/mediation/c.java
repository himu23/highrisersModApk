package com.applovin.impl.mediation;

import com.applovin.impl.sdk.n;
import com.applovin.impl.sdk.utils.f;
import com.applovin.impl.sdk.x;

public class c {
    private final a akU;
    private f akV;
    private final x logger;
    private final n sdk;

    public interface a {
        void c(com.applovin.impl.mediation.b.c cVar);
    }

    c(n nVar, a aVar) {
        this.sdk = nVar;
        this.logger = nVar.BN();
        this.akU = aVar;
    }

    public void a(com.applovin.impl.mediation.b.c cVar, long j) {
        if (x.Fn()) {
            x xVar = this.logger;
            xVar.f("AdHiddenCallbackTimeoutManager", "Scheduling in " + j + "ms...");
        }
        this.akV = f.a(j, this.sdk, new c$$ExternalSyntheticLambda0(this, cVar));
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void f(com.applovin.impl.mediation.b.c cVar) {
        if (x.Fn()) {
            this.logger.f("AdHiddenCallbackTimeoutManager", "Timing out...");
        }
        this.akU.c(cVar);
    }

    public void tT() {
        if (x.Fn()) {
            this.logger.f("AdHiddenCallbackTimeoutManager", "Cancelling timeout");
        }
        f fVar = this.akV;
        if (fVar != null) {
            fVar.tT();
            this.akV = null;
        }
    }
}
