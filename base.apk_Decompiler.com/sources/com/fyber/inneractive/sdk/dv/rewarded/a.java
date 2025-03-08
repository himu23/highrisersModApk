package com.fyber.inneractive.sdk.dv.rewarded;

import android.app.Activity;
import com.fyber.inneractive.sdk.config.b0;
import com.fyber.inneractive.sdk.config.global.s;
import com.fyber.inneractive.sdk.dv.d;
import com.fyber.inneractive.sdk.dv.f;
import com.fyber.inneractive.sdk.external.InneractiveAdRequest;
import com.fyber.inneractive.sdk.util.p;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.FullScreenContentCallback;
import com.google.android.gms.ads.LoadAdError;
import com.google.android.gms.ads.OnUserEarnedRewardListener;
import com.google.android.gms.ads.rewarded.RewardItem;
import com.google.android.gms.ads.rewarded.RewardedAd;
import com.google.android.gms.ads.rewarded.RewardedAdLoadCallback;

public class a extends com.fyber.inneractive.sdk.a<RewardedAd> {
    public final RewardedAdLoadCallback k = new C0093a();
    public final FullScreenContentCallback l = new b();
    public final OnUserEarnedRewardListener m = new c();

    /* renamed from: com.fyber.inneractive.sdk.dv.rewarded.a$a  reason: collision with other inner class name */
    public class C0093a extends RewardedAdLoadCallback {
        public C0093a() {
        }

        public void onAdLoaded(Object obj) {
            T t = (RewardedAd) obj;
            a aVar = a.this;
            if (aVar.g != null) {
                aVar.i = t;
                aVar.j();
                ((com.fyber.inneractive.sdk.dv.b) a.this.g).h();
            }
        }

        public void onAdFailedToLoad(LoadAdError loadAdError) {
            d dVar = a.this.g;
            if (dVar != null) {
                ((com.fyber.inneractive.sdk.dv.b) dVar).l();
                InneractiveAdRequest inneractiveAdRequest = a.this.a;
                String spotId = inneractiveAdRequest != null ? inneractiveAdRequest.getSpotId() : null;
                com.fyber.inneractive.sdk.dv.enums.a aVar = com.fyber.inneractive.sdk.dv.enums.a.Load;
                a aVar2 = a.this;
                com.fyber.inneractive.sdk.dv.handler.c.a(spotId, aVar, aVar2.a, (f) aVar2.b, loadAdError.getMessage());
            }
        }
    }

    public class b extends FullScreenContentCallback {
        public b() {
        }

        public void onAdDismissedFullScreenContent() {
            com.fyber.inneractive.sdk.dv.interstitial.a aVar = a.this.j;
            if (aVar != null) {
                aVar.i();
            }
        }

        public void onAdImpression() {
            com.fyber.inneractive.sdk.dv.interstitial.a aVar = a.this.j;
            if (aVar != null) {
                aVar.w();
            }
        }
    }

    public class c implements OnUserEarnedRewardListener {
        public c() {
        }

        public void onUserEarnedReward(RewardItem rewardItem) {
            com.fyber.inneractive.sdk.dv.interstitial.a aVar = a.this.j;
            if (aVar != null) {
                aVar.onReward();
            }
        }
    }

    public a(b0 b0Var, s sVar, f fVar) {
        super(b0Var, sVar, fVar);
    }

    public void a(AdRequest adRequest, d dVar) {
        this.g = dVar;
        RewardedAd.load(p.a, "FyberRewarded", adRequest, this.k);
    }

    public boolean e() {
        return true;
    }

    public boolean g() {
        return this.i != null;
    }

    public void a(com.fyber.inneractive.sdk.dv.interstitial.a aVar, Activity activity) {
        this.j = aVar;
        T t = this.i;
        if (t != null) {
            ((RewardedAd) t).setFullScreenContentCallback(this.l);
            ((RewardedAd) this.i).show(activity, this.m);
        }
    }
}
