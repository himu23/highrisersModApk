package com.applovin.impl.sdk.utils;

import com.applovin.adview.AppLovinAdView;
import com.applovin.adview.AppLovinAdViewEventListener;
import com.applovin.sdk.AppLovinAd;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class m$$ExternalSyntheticLambda26 implements Runnable {
    public final /* synthetic */ AppLovinAdViewEventListener f$0;
    public final /* synthetic */ AppLovinAd f$1;
    public final /* synthetic */ AppLovinAdView f$2;

    public /* synthetic */ m$$ExternalSyntheticLambda26(AppLovinAdViewEventListener appLovinAdViewEventListener, AppLovinAd appLovinAd, AppLovinAdView appLovinAdView) {
        this.f$0 = appLovinAdViewEventListener;
        this.f$1 = appLovinAd;
        this.f$2 = appLovinAdView;
    }

    public final void run() {
        m.e(this.f$0, this.f$1, this.f$2);
    }
}
