package com.applovin.impl.sdk;

import com.applovin.sdk.AppLovinAd;
import com.applovin.sdk.AppLovinAdLoadListener;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class AppLovinAdServiceImpl$$ExternalSyntheticLambda2 implements Runnable {
    public final /* synthetic */ AppLovinAdServiceImpl f$0;
    public final /* synthetic */ AppLovinAdLoadListener f$1;
    public final /* synthetic */ AppLovinAd f$2;

    public /* synthetic */ AppLovinAdServiceImpl$$ExternalSyntheticLambda2(AppLovinAdServiceImpl appLovinAdServiceImpl, AppLovinAdLoadListener appLovinAdLoadListener, AppLovinAd appLovinAd) {
        this.f$0 = appLovinAdServiceImpl;
        this.f$1 = appLovinAdLoadListener;
        this.f$2 = appLovinAd;
    }

    public final void run() {
        this.f$0.a(this.f$1, this.f$2);
    }
}
