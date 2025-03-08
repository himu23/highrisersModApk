package com.applovin.impl.sdk;

import com.applovin.impl.sdk.ad.g;
import com.applovin.impl.sdk.b;
import com.applovin.impl.sdk.utils.r;
import java.lang.ref.WeakReference;

public class c {
    private final WeakReference<g> ayS;
    private final WeakReference<b.a> ayT;
    private r ayU;
    private final n sdk;

    public static c a(g gVar, b.a aVar, n nVar) {
        c cVar = new c(gVar, aVar, nVar);
        cVar.bJ(gVar.getTimeToLiveMillis());
        return cVar;
    }

    private c(g gVar, b.a aVar, n nVar) {
        this.ayS = new WeakReference<>(gVar);
        this.ayT = new WeakReference<>(aVar);
        this.sdk = nVar;
    }

    public g AD() {
        return (g) this.ayS.get();
    }

    public void bJ(long j) {
        tT();
        if (((Boolean) this.sdk.a(com.applovin.impl.sdk.c.b.aMc)).booleanValue() || !this.sdk.Ce().isApplicationPaused()) {
            this.ayU = r.b(j, this.sdk, new c$$ExternalSyntheticLambda0(this));
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void AF() {
        AE();
        this.sdk.Cb().a(this);
    }

    public void tT() {
        r rVar = this.ayU;
        if (rVar != null) {
            rVar.tT();
            this.ayU = null;
        }
    }

    public void AE() {
        tT();
        g AD = AD();
        if (AD != null) {
            AD.setExpired();
            b.a aVar = (b.a) this.ayT.get();
            if (aVar != null) {
                aVar.onAdExpired(AD);
            }
        }
    }
}
