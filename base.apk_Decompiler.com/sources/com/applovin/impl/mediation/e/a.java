package com.applovin.impl.mediation.e;

import com.applovin.impl.mediation.ads.a;
import com.applovin.impl.sdk.utils.m;
import com.applovin.mediation.MaxAd;
import com.applovin.mediation.MaxAdListener;
import com.applovin.mediation.MaxAdRequestListener;
import com.applovin.mediation.MaxAdRevenueListener;
import com.applovin.mediation.MaxAdViewAdListener;
import com.applovin.mediation.MaxError;
import com.applovin.mediation.MaxReward;
import com.applovin.mediation.MaxRewardedAdListener;

public class a implements a.C0067a, MaxAdListener, MaxAdRevenueListener, MaxAdViewAdListener, MaxRewardedAdListener {
    private final a.C0067a axf;

    public a(a.C0067a aVar) {
        this.axf = aVar;
    }

    public void onAdExpanded(MaxAd maxAd) {
        m.g((MaxAdListener) this.axf, maxAd);
    }

    public void onAdCollapsed(MaxAd maxAd) {
        m.h((MaxAdListener) this.axf, maxAd);
    }

    public void onRewardedVideoStarted(MaxAd maxAd) {
        m.e(this.axf, maxAd);
    }

    public void onRewardedVideoCompleted(MaxAd maxAd) {
        m.f(this.axf, maxAd);
    }

    public void onUserRewarded(MaxAd maxAd, MaxReward maxReward) {
        m.a((MaxAdListener) this.axf, maxAd, maxReward);
    }

    public void onAdLoaded(MaxAd maxAd) {
        m.a((MaxAdListener) this.axf, maxAd);
    }

    public void onAdLoadFailed(String str, MaxError maxError) {
        m.a((MaxAdListener) this.axf, str, maxError);
    }

    public void onAdDisplayed(MaxAd maxAd) {
        m.b((MaxAdListener) this.axf, maxAd);
    }

    public void onAdHidden(MaxAd maxAd) {
        m.c((MaxAdListener) this.axf, maxAd);
    }

    public void onAdClicked(MaxAd maxAd) {
        m.d((MaxAdListener) this.axf, maxAd);
    }

    public void onAdRevenuePaid(MaxAd maxAd) {
        m.a((MaxAdRevenueListener) this.axf, maxAd);
    }

    public void onAdDisplayFailed(MaxAd maxAd, MaxError maxError) {
        m.a((MaxAdListener) this.axf, maxAd, maxError);
    }

    public void onAdRequestStarted(String str) {
        m.a((MaxAdRequestListener) this.axf, str);
    }
}
