package com.applovin.impl.sdk.e;

import com.applovin.impl.b.a;
import com.applovin.impl.b.c;
import com.applovin.impl.b.d;
import com.applovin.impl.b.e;
import com.applovin.impl.b.f;
import com.applovin.impl.b.j;
import com.applovin.impl.b.k;
import com.applovin.impl.b.m;
import com.applovin.impl.sdk.c.b;
import com.applovin.impl.sdk.e.q;
import com.applovin.impl.sdk.n;
import com.applovin.impl.sdk.utils.y;
import com.applovin.impl.sdk.x;
import com.applovin.sdk.AppLovinAdLoadListener;
import com.applovin.sdk.AppLovinAdType;
import java.util.HashSet;
import java.util.Set;

class v extends d {
    private final AppLovinAdLoadListener aTG;
    private final e aUX;

    v(e eVar, AppLovinAdLoadListener appLovinAdLoadListener, n nVar) {
        super("TaskRenderVastAd", nVar);
        this.aTG = appLovinAdLoadListener;
        this.aUX = eVar;
    }

    public void run() {
        x xVar = this.logger;
        if (x.Fn()) {
            this.logger.f(this.tag, "Rendering VAST ad...");
        }
        int size = this.aUX.Ms().size();
        HashSet hashSet = new HashSet(size);
        HashSet hashSet2 = new HashSet(size);
        String str = "";
        j jVar = null;
        com.applovin.impl.b.n nVar = null;
        d dVar = null;
        c cVar = null;
        String str2 = str;
        for (y next : this.aUX.Ms()) {
            y dL = next.dL(m.d(next) ? "Wrapper" : "InLine");
            if (dL != null) {
                y dL2 = dL.dL("AdSystem");
                if (dL2 != null) {
                    jVar = j.a(dL2, jVar, this.sdk);
                }
                str = m.a(dL, "AdTitle", str);
                str2 = m.a(dL, "Description", str2);
                m.a(dL.dJ("Impression"), (Set<k>) hashSet, this.aUX, this.sdk);
                y dK = dL.dK("ViewableImpression");
                if (dK != null) {
                    m.a(dK.dJ("Viewable"), (Set<k>) hashSet, this.aUX, this.sdk);
                }
                y dL3 = dL.dL("AdVerifications");
                if (dL3 != null) {
                    cVar = c.a(dL3, cVar, this.aUX, this.sdk);
                }
                m.a(dL.dJ("Error"), (Set<k>) hashSet2, this.aUX, this.sdk);
                y dK2 = dL.dK("Creatives");
                if (dK2 != null) {
                    for (y next2 : dK2.LL()) {
                        y dK3 = next2.dK("Linear");
                        if (dK3 != null) {
                            nVar = com.applovin.impl.b.n.a(dK3, nVar, this.aUX, this.sdk);
                        } else {
                            y dL4 = next2.dL("CompanionAds");
                            if (dL4 != null) {
                                y dL5 = dL4.dL("Companion");
                                if (dL5 != null) {
                                    dVar = d.a(dL5, dVar, this.aUX, this.sdk);
                                }
                            } else {
                                x xVar2 = this.logger;
                                if (x.Fn()) {
                                    this.logger.i(this.tag, "Received and will skip rendering for an unidentified creative: " + next2);
                                }
                            }
                        }
                    }
                }
            } else {
                x xVar3 = this.logger;
                if (x.Fn()) {
                    this.logger.i(this.tag, "Did not find wrapper or inline response for node: " + next);
                }
            }
        }
        a Mi = new a.C0064a().R(this.sdk).V(this.aUX.Mt()).W(this.aUX.FR()).a(this.aUX.getSource()).cc(this.aUX.getCreatedAtMillis()).dP(str).dQ(str2).a(jVar).a(nVar).a(dVar).a(cVar).b((Set<k>) hashSet).a(cVar).c((Set<k>) hashSet2).Mi();
        f a = m.a(Mi);
        if (a == null) {
            x xVar4 = this.logger;
            if (x.Fn()) {
                this.logger.f(this.tag, "Finished rendering VAST ad: " + Mi);
            }
            Mi.getAdEventTracker().IJ();
            h hVar = new h(Mi, this.sdk, this.aTG);
            q.b bVar = q.b.CACHING_OTHER;
            if (((Boolean) this.sdk.a(b.aLH)).booleanValue()) {
                if (Mi.getType() == AppLovinAdType.REGULAR) {
                    bVar = q.b.CACHING_INTERSTITIAL;
                } else if (Mi.getType() == AppLovinAdType.INCENTIVIZED) {
                    bVar = q.b.CACHING_INCENTIVIZED;
                } else if (Mi.getType() == AppLovinAdType.NATIVE) {
                    bVar = q.b.CACHING_NATIVE;
                }
            }
            this.sdk.BO().a((d) hVar, bVar);
            return;
        }
        m.a(this.aUX, this.aTG, a, -6, this.sdk);
    }
}
