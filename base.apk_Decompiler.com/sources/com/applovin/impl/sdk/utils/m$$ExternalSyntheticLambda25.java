package com.applovin.impl.sdk.utils;

import com.applovin.impl.sdk.AppLovinError;
import com.applovin.impl.sdk.nativeAd.AppLovinNativeAdLoadListener;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class m$$ExternalSyntheticLambda25 implements Runnable {
    public final /* synthetic */ AppLovinNativeAdLoadListener f$0;
    public final /* synthetic */ AppLovinError f$1;

    public /* synthetic */ m$$ExternalSyntheticLambda25(AppLovinNativeAdLoadListener appLovinNativeAdLoadListener, AppLovinError appLovinError) {
        this.f$0 = appLovinNativeAdLoadListener;
        this.f$1 = appLovinError;
    }

    public final void run() {
        m.b(this.f$0, this.f$1);
    }
}
