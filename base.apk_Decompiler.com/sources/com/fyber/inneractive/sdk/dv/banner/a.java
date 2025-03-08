package com.fyber.inneractive.sdk.dv.banner;

import com.fyber.inneractive.sdk.config.a0;
import com.fyber.inneractive.sdk.config.b0;
import com.fyber.inneractive.sdk.config.enums.UnitDisplayType;
import com.fyber.inneractive.sdk.config.global.s;
import com.fyber.inneractive.sdk.config.t;
import com.fyber.inneractive.sdk.dv.b;
import com.fyber.inneractive.sdk.dv.d;
import com.fyber.inneractive.sdk.dv.f;
import com.fyber.inneractive.sdk.dv.handler.c;
import com.fyber.inneractive.sdk.external.InneractiveAdRequest;
import com.fyber.inneractive.sdk.response.e;
import com.fyber.inneractive.sdk.util.p;
import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.LoadAdError;

public class a extends com.fyber.inneractive.sdk.dv.a<AdView> {
    public boolean j = false;
    public boolean k = false;
    public final AdListener l = new C0090a();

    /* renamed from: com.fyber.inneractive.sdk.dv.banner.a$a  reason: collision with other inner class name */
    public class C0090a extends AdListener {
        public C0090a() {
        }

        public void onAdFailedToLoad(LoadAdError loadAdError) {
            InneractiveAdRequest inneractiveAdRequest = a.this.a;
            String spotId = inneractiveAdRequest != null ? inneractiveAdRequest.getSpotId() : null;
            com.fyber.inneractive.sdk.dv.enums.a aVar = com.fyber.inneractive.sdk.dv.enums.a.Load;
            a aVar2 = a.this;
            c.a(spotId, aVar, aVar2.a, (f) aVar2.b, loadAdError.getMessage());
        }

        public void onAdImpression() {
            a aVar = a.this;
            b bVar = aVar.h;
            if (bVar != null) {
                bVar.w();
            } else {
                boolean unused = aVar.j = true;
            }
        }

        public void onAdLoaded() {
            a aVar = a.this;
            if (aVar.g != null) {
                boolean unused = aVar.k = true;
                ((b) a.this.g).h();
            }
        }

        public void onAdOpened() {
            f fVar;
            com.fyber.inneractive.sdk.cache.session.enums.b bVar;
            b bVar2 = a.this.h;
            if (bVar2 != null) {
                bVar2.D();
                AdContent adcontent = bVar2.b;
                if (adcontent != null && (fVar = (f) ((a) adcontent).b) != null) {
                    bVar2.a((e) fVar);
                    b0 b0Var = ((a) bVar2.b).d;
                    if (b0Var != null) {
                        a0 a0Var = (a0) b0Var;
                        if (a0Var.c != null) {
                            com.fyber.inneractive.sdk.cache.session.enums.a aVar = com.fyber.inneractive.sdk.cache.session.enums.a.CLICK;
                            if (a0Var.c.b == UnitDisplayType.MRECT) {
                                bVar = com.fyber.inneractive.sdk.cache.session.enums.b.RECTANGLE_DISPLAY;
                            } else {
                                bVar = com.fyber.inneractive.sdk.cache.session.enums.b.BANNER_DISPLAY;
                            }
                            bVar2.a(aVar, bVar);
                        }
                    }
                }
            }
        }
    }

    public a(b0 b0Var, s sVar, f fVar) {
        super(b0Var, sVar, fVar);
    }

    public boolean e() {
        return false;
    }

    public boolean g() {
        return this.k;
    }

    public void a(AdRequest adRequest, d dVar) {
        t tVar;
        this.g = dVar;
        T adView = new AdView(p.a);
        this.i = adView;
        AdSize adSize = AdSize.BANNER;
        b0 b0Var = this.d;
        if (!(b0Var == null || (tVar = ((a0) b0Var).c) == null || tVar.b != UnitDisplayType.MRECT)) {
            adSize = AdSize.MEDIUM_RECTANGLE;
        }
        adView.setAdSize(adSize);
        ((AdView) this.i).setAdUnitId("FyberBanner");
        ((AdView) this.i).setAdListener(this.l);
        ((AdView) this.i).loadAd(adRequest);
    }
}
