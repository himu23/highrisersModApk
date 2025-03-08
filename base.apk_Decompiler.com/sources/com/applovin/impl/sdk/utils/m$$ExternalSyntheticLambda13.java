package com.applovin.impl.sdk.utils;

import com.applovin.impl.sdk.nativeAd.AppLovinNativeAd;
import com.applovin.impl.sdk.nativeAd.AppLovinNativeAdEventListener;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class m$$ExternalSyntheticLambda13 implements Runnable {
    public final /* synthetic */ AppLovinNativeAdEventListener f$0;
    public final /* synthetic */ AppLovinNativeAd f$1;

    public /* synthetic */ m$$ExternalSyntheticLambda13(AppLovinNativeAdEventListener appLovinNativeAdEventListener, AppLovinNativeAd appLovinNativeAd) {
        this.f$0 = appLovinNativeAdEventListener;
        this.f$1 = appLovinNativeAd;
    }

    public final void run() {
        m.b(this.f$0, this.f$1);
    }
}
