package com.fyber.inneractive.sdk.dv.rewarded;

import android.app.Activity;
import com.fyber.inneractive.sdk.config.b0;
import com.fyber.inneractive.sdk.config.global.s;
import com.fyber.inneractive.sdk.dv.d;
import com.fyber.inneractive.sdk.dv.f;
import com.fyber.inneractive.sdk.dv.handler.c;
import com.fyber.inneractive.sdk.external.InneractiveAdRequest;
import com.fyber.inneractive.sdk.util.p;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.rewarded.RewardItem;
import com.google.android.gms.ads.rewarded.RewardedAd;
import com.google.android.gms.ads.rewarded.RewardedAdCallback;
import com.google.android.gms.ads.rewarded.RewardedAdLoadCallback;

public class b extends com.fyber.inneractive.sdk.a<RewardedAd> {
    public final RewardedAdLoadCallback k = new a();
    public final RewardedAdCallback l = new C0094b();

    public class a extends RewardedAdLoadCallback {
        public a() {
        }

        public void onRewardedAdFailedToLoad(int i) {
            d dVar = b.this.g;
            if (dVar != null) {
                ((com.fyber.inneractive.sdk.dv.b) dVar).l();
                InneractiveAdRequest inneractiveAdRequest = b.this.a;
                String spotId = inneractiveAdRequest != null ? inneractiveAdRequest.getSpotId() : null;
                com.fyber.inneractive.sdk.dv.enums.a aVar = com.fyber.inneractive.sdk.dv.enums.a.Load;
                b bVar = b.this;
                c.a(spotId, aVar, bVar.a, (f) bVar.b, String.format("errorCode - %d", new Object[]{Integer.valueOf(i)}));
            }
        }

        public void onRewardedAdLoaded() {
            b bVar = b.this;
            if (bVar.g != null) {
                bVar.j();
                ((com.fyber.inneractive.sdk.dv.b) b.this.g).h();
            }
        }
    }

    /* renamed from: com.fyber.inneractive.sdk.dv.rewarded.b$b  reason: collision with other inner class name */
    public class C0094b extends RewardedAdCallback {
        public C0094b() {
        }

        public void onRewardedAdFailedToShow(int i) {
        }

        public void onRewardedAdClosed() {
            com.fyber.inneractive.sdk.dv.interstitial.a aVar = b.this.j;
            if (aVar != null) {
                aVar.i();
            }
        }

        public void onRewardedAdOpened() {
            com.fyber.inneractive.sdk.dv.interstitial.a aVar = b.this.j;
            if (aVar != null) {
                aVar.w();
            }
        }

        public void onUserEarnedReward(RewardItem rewardItem) {
            com.fyber.inneractive.sdk.dv.interstitial.a aVar = b.this.j;
            if (aVar != null) {
                aVar.onReward();
            }
        }
    }

    public b(b0 b0Var, s sVar, f fVar) {
        super(b0Var, sVar, fVar);
    }

    public void a(AdRequest adRequest, d dVar) {
        this.g = dVar;
        T rewardedAd = new RewardedAd(p.a, "FyberRewarded");
        this.i = rewardedAd;
        rewardedAd.loadAd(adRequest, this.k);
    }

    public boolean e() {
        return true;
    }

    public boolean g() {
        T t = this.i;
        if (t != null) {
            return ((RewardedAd) t).isLoaded();
        }
        return false;
    }

    public void a(com.fyber.inneractive.sdk.dv.interstitial.a aVar, Activity activity) {
        this.j = aVar;
        ((RewardedAd) this.i).show(activity, this.l);
    }
}
