package com.applovin.impl.sdk;

import com.applovin.impl.sdk.ad.AppLovinAdImpl;
import com.applovin.impl.sdk.ad.f;
import java.util.HashMap;
import java.util.Map;

public class d {
    private final Map<com.applovin.impl.sdk.ad.d, z> alu = new HashMap();
    private final Object ayV = new Object();
    private final Map<com.applovin.impl.sdk.ad.d, z> ayW = new HashMap();
    private final x logger;
    private final n sdk;

    d(n nVar) {
        this.sdk = nVar;
        this.logger = nVar.BN();
        for (com.applovin.impl.sdk.ad.d next : com.applovin.impl.sdk.ad.d.FT()) {
            this.alu.put(next, new z());
            this.ayW.put(next, new z());
        }
    }

    public AppLovinAdImpl a(com.applovin.impl.sdk.ad.d dVar) {
        f fVar;
        synchronized (this.ayV) {
            z d = d(dVar);
            if (d.Fq() > 0) {
                e(dVar).c(d.Fr());
                fVar = new f(dVar, this.sdk);
            } else {
                fVar = null;
            }
        }
        if (fVar != null) {
            if (x.Fn()) {
                x xVar = this.logger;
                xVar.f("AdPreloadManager", "Retrieved ad of zone " + dVar + "...");
            }
        } else if (x.Fn()) {
            x xVar2 = this.logger;
            xVar2.f("AdPreloadManager", "Unable to retrieve ad of zone " + dVar + "...");
        }
        return fVar;
    }

    /* access modifiers changed from: package-private */
    public void a(AppLovinAdImpl appLovinAdImpl) {
        synchronized (this.ayV) {
            d(appLovinAdImpl.getAdZone()).c(appLovinAdImpl);
            if (x.Fn()) {
                x xVar = this.logger;
                xVar.f("AdPreloadManager", "Ad enqueued: " + appLovinAdImpl);
            }
        }
    }

    public AppLovinAdImpl b(com.applovin.impl.sdk.ad.d dVar) {
        AppLovinAdImpl Fr;
        synchronized (this.ayV) {
            Fr = f(dVar).Fr();
        }
        return Fr;
    }

    public AppLovinAdBase c(com.applovin.impl.sdk.ad.d dVar) {
        AppLovinAdImpl Fs;
        synchronized (this.ayV) {
            Fs = f(dVar).Fs();
        }
        return Fs;
    }

    public void b(AppLovinAdImpl appLovinAdImpl) {
        synchronized (this.ayV) {
            f(appLovinAdImpl.getAdZone()).d(appLovinAdImpl);
        }
    }

    private z d(com.applovin.impl.sdk.ad.d dVar) {
        z zVar;
        synchronized (this.ayV) {
            zVar = this.alu.get(dVar);
            if (zVar == null) {
                zVar = new z();
                this.alu.put(dVar, zVar);
            }
        }
        return zVar;
    }

    private z e(com.applovin.impl.sdk.ad.d dVar) {
        z zVar;
        synchronized (this.ayV) {
            zVar = this.ayW.get(dVar);
            if (zVar == null) {
                zVar = new z();
                this.ayW.put(dVar, zVar);
            }
        }
        return zVar;
    }

    private z f(com.applovin.impl.sdk.ad.d dVar) {
        synchronized (this.ayV) {
            z e = e(dVar);
            if (e.Fq() > 0) {
                return e;
            }
            z d = d(dVar);
            return d;
        }
    }
}
