package com.applovin.impl.sdk.utils;

import com.applovin.mediation.MaxAd;
import com.applovin.mediation.nativeAds.MaxNativeAdListener;
import com.applovin.mediation.nativeAds.MaxNativeAdView;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class m$$ExternalSyntheticLambda2 implements Runnable {
    public final /* synthetic */ boolean f$0;
    public final /* synthetic */ MaxNativeAdListener f$1;
    public final /* synthetic */ MaxNativeAdView f$2;
    public final /* synthetic */ MaxAd f$3;

    public /* synthetic */ m$$ExternalSyntheticLambda2(boolean z, MaxNativeAdListener maxNativeAdListener, MaxNativeAdView maxNativeAdView, MaxAd maxAd) {
        this.f$0 = z;
        this.f$1 = maxNativeAdListener;
        this.f$2 = maxNativeAdView;
        this.f$3 = maxAd;
    }

    public final void run() {
        m.a(this.f$0, this.f$1, this.f$2, this.f$3);
    }
}
