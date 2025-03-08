package com.ironsource.mediationsdk.demandOnly;

import android.text.TextUtils;
import com.ironsource.d3;
import com.ironsource.m7;
import com.ironsource.mediationsdk.AbstractAdapter;
import com.ironsource.mediationsdk.c;
import com.ironsource.mediationsdk.demandOnly.e;
import com.ironsource.mediationsdk.demandOnly.h;
import com.ironsource.mediationsdk.demandOnly.i;
import com.ironsource.mediationsdk.demandOnly.o;
import com.ironsource.mediationsdk.e;
import com.ironsource.mediationsdk.logger.IronLog;
import com.ironsource.mediationsdk.logger.IronSourceError;
import com.ironsource.mediationsdk.model.NetworkSettings;
import com.ironsource.mediationsdk.utils.ErrorBuilder;
import com.ironsource.mediationsdk.utils.IronSourceAES;
import com.ironsource.mediationsdk.utils.IronSourceUtils;
import com.ironsource.r5;
import com.ironsource.u3;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

public class f implements i.b {
    private final d3 a;
    private final ConcurrentHashMap<String, g> b = new ConcurrentHashMap<>();
    private final r5<ISDemandOnlyInterstitialListener> c;

    public f(List<NetworkSettings> list, m7 m7Var, c cVar, r5<ISDemandOnlyInterstitialListener> r5Var, String str, String str2, d3 d3Var) {
        String sessionId = IronSourceUtils.getSessionId();
        boolean k = m7Var.k();
        com.ironsource.mediationsdk.f fVar = new com.ironsource.mediationsdk.f(m7Var.g(), k, sessionId);
        this.a = d3Var;
        this.c = r5Var;
        for (NetworkSettings next : list) {
            if (next.isIronSource()) {
                AbstractAdapter a2 = cVar.a(next, next.getInterstitialSettings(), true);
                if (a2 != null) {
                    g gVar = new g(str, str2, next, this.c.a(next.getSubProviderId()), m7Var.e(), a2, new e(fVar));
                    gVar.a(k);
                    this.b.put(next.getSubProviderId(), gVar);
                }
            } else {
                c cVar2 = cVar;
                IronLog ironLog = IronLog.INTERNAL;
                ironLog.error("cannot load " + next.getProviderTypeForReflection());
            }
        }
    }

    public ConcurrentHashMap<String, g> a() {
        return this.b;
    }

    public void a(h.d dVar) {
        String b2 = dVar.b();
        String a2 = dVar.a();
        try {
            g gVar = this.b.get(b2);
            if (gVar == null) {
                this.a.a(e.b.q, b2);
                IronSourceError buildNonExistentInstanceError = ErrorBuilder.buildNonExistentInstanceError("Interstitial");
                IronLog.API.error(buildNonExistentInstanceError.getErrorMessage());
                this.c.a(b2).onInterstitialAdLoadFailed(b2, buildNonExistentInstanceError);
            } else if (TextUtils.isEmpty(a2)) {
                gVar.c();
            } else {
                gVar.a((o) new o.a(IronSourceAES.decode(u3.b().c(), a2)));
            }
        } catch (Exception e) {
            IronSourceError buildLoadFailedError = ErrorBuilder.buildLoadFailedError("loadInterstitial exception " + e.getMessage());
            IronLog.API.error(buildLoadFailedError.getErrorMessage());
            this.c.a(b2).onInterstitialAdLoadFailed(b2, buildLoadFailedError);
        }
    }

    public void a(String str) {
        try {
            g gVar = this.b.get(str);
            if (gVar == null) {
                this.a.a(e.b.r, str);
                IronSourceError buildNonExistentInstanceError = ErrorBuilder.buildNonExistentInstanceError("Interstitial");
                IronLog.API.error(buildNonExistentInstanceError.getErrorMessage());
                this.c.a(str).onInterstitialAdShowFailed(str, buildNonExistentInstanceError);
                return;
            }
            gVar.b();
        } catch (Exception e) {
            IronSourceError buildShowFailedError = ErrorBuilder.buildShowFailedError("Interstitial", "showInterstitial exception " + e.getMessage());
            IronLog.API.error(buildShowFailedError.getErrorMessage());
            this.c.a(str).onInterstitialAdShowFailed(str, buildShowFailedError);
        }
    }

    public boolean b(String str) {
        g gVar = this.b.get(str);
        if (gVar != null) {
            return gVar.a();
        }
        this.a.a(e.b.p, str);
        return false;
    }
}
