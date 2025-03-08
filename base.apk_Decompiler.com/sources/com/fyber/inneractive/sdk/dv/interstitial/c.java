package com.fyber.inneractive.sdk.dv.interstitial;

import android.app.Activity;
import com.fyber.inneractive.sdk.config.b0;
import com.fyber.inneractive.sdk.config.global.s;
import com.fyber.inneractive.sdk.dv.d;
import com.fyber.inneractive.sdk.dv.f;
import com.fyber.inneractive.sdk.external.InneractiveAdRequest;
import com.fyber.inneractive.sdk.util.p;
import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.InterstitialAd;

public class c extends com.fyber.inneractive.sdk.a<InterstitialAd> {
    public final AdListener k = new a();
    public final AdListener l = new b();

    public class a extends AdListener {
        public a() {
        }

        public void onAdFailedToLoad(int i) {
            d dVar = c.this.g;
            if (dVar != null) {
                ((com.fyber.inneractive.sdk.dv.b) dVar).l();
                InneractiveAdRequest inneractiveAdRequest = c.this.a;
                String spotId = inneractiveAdRequest != null ? inneractiveAdRequest.getSpotId() : null;
                com.fyber.inneractive.sdk.dv.enums.a aVar = com.fyber.inneractive.sdk.dv.enums.a.Load;
                c cVar = c.this;
                com.fyber.inneractive.sdk.dv.handler.c.a(spotId, aVar, cVar.a, (f) cVar.b, String.format("errorCode - %d", new Object[]{Integer.valueOf(i)}));
            }
        }

        public void onAdLoaded() {
            c cVar = c.this;
            if (cVar.g != null) {
                cVar.j();
                ((com.fyber.inneractive.sdk.dv.b) c.this.g).h();
            }
        }
    }

    public class b extends AdListener {
        public b() {
        }

        public void onAdClicked() {
            a aVar = c.this.j;
            if (aVar != null) {
                aVar.d();
            }
        }

        public void onAdClosed() {
            a aVar = c.this.j;
            if (aVar != null) {
                aVar.i();
            }
        }

        public void onAdImpression() {
            a aVar = c.this.j;
            if (aVar != null) {
                aVar.w();
            }
        }

        public void onAdOpened() {
            a aVar = c.this.j;
            if (aVar != null) {
                aVar.w();
            }
        }
    }

    public c(b0 b0Var, s sVar, f fVar) {
        super(b0Var, sVar, fVar);
    }

    public void a(AdRequest adRequest, d dVar) {
        this.g = dVar;
        T interstitialAd = new InterstitialAd(p.a);
        this.i = interstitialAd;
        interstitialAd.setAdListener(this.k);
        ((InterstitialAd) this.i).setAdUnitId("FyberInterstitial");
        ((InterstitialAd) this.i).loadAd(adRequest);
    }

    public boolean e() {
        return true;
    }

    public boolean g() {
        T t = this.i;
        return t != null && ((InterstitialAd) t).isLoaded();
    }

    public void a(a aVar, Activity activity) {
        this.j = aVar;
        T t = this.i;
        if (t != null) {
            ((InterstitialAd) t).setAdListener(this.l);
            ((InterstitialAd) this.i).show();
        }
    }
}
