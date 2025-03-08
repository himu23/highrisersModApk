package com.fyber.inneractive.sdk.dv.interstitial;

import android.app.Activity;
import com.fyber.inneractive.sdk.config.b0;
import com.fyber.inneractive.sdk.config.global.s;
import com.fyber.inneractive.sdk.dv.d;
import com.fyber.inneractive.sdk.dv.f;
import com.fyber.inneractive.sdk.dv.handler.c;
import com.fyber.inneractive.sdk.external.InneractiveAdRequest;
import com.fyber.inneractive.sdk.util.p;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.FullScreenContentCallback;
import com.google.android.gms.ads.LoadAdError;
import com.google.android.gms.ads.interstitial.InterstitialAd;
import com.google.android.gms.ads.interstitial.InterstitialAdLoadCallback;

public class b extends com.fyber.inneractive.sdk.a<InterstitialAd> {
    public final InterstitialAdLoadCallback k = new a();
    public final FullScreenContentCallback l = new C0092b();

    public class a extends InterstitialAdLoadCallback {
        public a() {
        }

        public void onAdLoaded(Object obj) {
            T t = (InterstitialAd) obj;
            b bVar = b.this;
            if (bVar.g != null) {
                bVar.i = t;
                bVar.j();
                ((com.fyber.inneractive.sdk.dv.b) b.this.g).h();
            }
        }

        public void onAdFailedToLoad(LoadAdError loadAdError) {
            d dVar = b.this.g;
            if (dVar != null) {
                ((com.fyber.inneractive.sdk.dv.b) dVar).l();
                InneractiveAdRequest inneractiveAdRequest = b.this.a;
                String spotId = inneractiveAdRequest != null ? inneractiveAdRequest.getSpotId() : null;
                com.fyber.inneractive.sdk.dv.enums.a aVar = com.fyber.inneractive.sdk.dv.enums.a.Load;
                b bVar = b.this;
                c.a(spotId, aVar, bVar.a, (f) bVar.b, loadAdError.getMessage());
            }
        }
    }

    /* renamed from: com.fyber.inneractive.sdk.dv.interstitial.b$b  reason: collision with other inner class name */
    public class C0092b extends FullScreenContentCallback {
        public C0092b() {
        }

        public void onAdDismissedFullScreenContent() {
            a aVar = b.this.j;
            if (aVar != null) {
                aVar.i();
            }
        }

        public void onAdShowedFullScreenContent() {
            a aVar = b.this.j;
            if (aVar != null) {
                aVar.w();
            }
        }
    }

    public b(b0 b0Var, s sVar, f fVar) {
        super(b0Var, sVar, fVar);
    }

    public void a(AdRequest adRequest, d dVar) {
        this.g = dVar;
        InterstitialAd.load(p.a, "FyberInterstitial", adRequest, this.k);
    }

    public boolean e() {
        return true;
    }

    public boolean g() {
        return this.i != null;
    }

    public void a(a aVar, Activity activity) {
        this.j = aVar;
        T t = this.i;
        if (t != null) {
            ((InterstitialAd) t).setFullScreenContentCallback(this.l);
            ((InterstitialAd) this.i).show(activity);
        }
    }
}
