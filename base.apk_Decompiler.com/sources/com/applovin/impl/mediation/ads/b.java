package com.applovin.impl.mediation.ads;

import android.view.ViewGroup;
import com.applovin.impl.mediation.ads.a;
import com.applovin.impl.mediation.b.d;
import com.applovin.impl.sdk.ac;
import com.applovin.impl.sdk.ad;
import com.applovin.impl.sdk.ad.g;
import com.applovin.impl.sdk.n;
import com.applovin.impl.sdk.x;

public class b implements ad.a {
    private final ac amW;
    private final ad amX;
    private final d anP;
    private final a.C0067a anQ;
    private final n sdk;

    public d uz() {
        return this.anP;
    }

    public b(d dVar, ViewGroup viewGroup, a.C0067a aVar, n nVar) {
        this.sdk = nVar;
        this.anP = dVar;
        this.anQ = aVar;
        this.amW = new ac(viewGroup, nVar);
        ad adVar = new ad(viewGroup, nVar, this);
        this.amX = adVar;
        adVar.b(dVar);
        nVar.BN();
        if (x.Fn()) {
            x BN = nVar.BN();
            BN.f("MaxNativeAdView", "Created new MaxNativeAdView (" + this + ")");
        }
    }

    public void destroy() {
        this.amX.Fw();
    }

    public void uy() {
        this.sdk.BN();
        if (x.Fn()) {
            this.sdk.BN().f("MaxNativeAdView", "Handling view attached to window");
        }
        if (this.anP.yo().compareAndSet(false, true)) {
            this.sdk.BN();
            if (x.Fn()) {
                this.sdk.BN().f("MaxNativeAdView", "Scheduling impression for ad manually...");
            }
            if (this.anP.getNativeAd().isExpired()) {
                x.H("MaxNativeAdView", "Attempting to display an expired native ad. Check if an ad is expired before displaying using `MaxAd.getNativeAd().isExpired()`");
            } else {
                this.sdk.Cb().a((g) this.anP);
            }
            this.sdk.Cy().processRawAdImpressionPostback(this.anP, this.anQ);
        }
    }

    public void onLogVisibilityImpression() {
        bI(this.amW.a(this.anP));
    }

    private void bI(long j) {
        if (this.anP.yp().compareAndSet(false, true)) {
            this.sdk.BN();
            if (x.Fn()) {
                this.sdk.BN().f("MaxNativeAdView", "Scheduling viewability impression for ad...");
            }
            this.sdk.Cy().processViewabilityAdImpressionPostback(this.anP, j, this.anQ);
        }
    }
}
