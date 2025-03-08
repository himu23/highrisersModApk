package com.applovin.impl.sdk.utils;

import com.applovin.adview.AppLovinAdView;
import com.applovin.adview.AppLovinAdViewDisplayErrorCode;
import com.applovin.adview.AppLovinAdViewEventListener;
import com.applovin.sdk.AppLovinAd;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class m$$ExternalSyntheticLambda32 implements Runnable {
    public final /* synthetic */ AppLovinAdViewEventListener f$0;
    public final /* synthetic */ AppLovinAd f$1;
    public final /* synthetic */ AppLovinAdView f$2;
    public final /* synthetic */ AppLovinAdViewDisplayErrorCode f$3;

    public /* synthetic */ m$$ExternalSyntheticLambda32(AppLovinAdViewEventListener appLovinAdViewEventListener, AppLovinAd appLovinAd, AppLovinAdView appLovinAdView, AppLovinAdViewDisplayErrorCode appLovinAdViewDisplayErrorCode) {
        this.f$0 = appLovinAdViewEventListener;
        this.f$1 = appLovinAd;
        this.f$2 = appLovinAdView;
        this.f$3 = appLovinAdViewDisplayErrorCode;
    }

    public final void run() {
        m.b(this.f$0, this.f$1, this.f$2, this.f$3);
    }
}
