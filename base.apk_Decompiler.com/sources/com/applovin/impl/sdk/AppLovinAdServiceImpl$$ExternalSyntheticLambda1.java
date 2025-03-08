package com.applovin.impl.sdk;

import com.applovin.sdk.AppLovinAdLoadListener;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class AppLovinAdServiceImpl$$ExternalSyntheticLambda1 implements Runnable {
    public final /* synthetic */ AppLovinAdServiceImpl f$0;
    public final /* synthetic */ AppLovinError f$1;
    public final /* synthetic */ AppLovinAdLoadListener f$2;

    public /* synthetic */ AppLovinAdServiceImpl$$ExternalSyntheticLambda1(AppLovinAdServiceImpl appLovinAdServiceImpl, AppLovinError appLovinError, AppLovinAdLoadListener appLovinAdLoadListener) {
        this.f$0 = appLovinAdServiceImpl;
        this.f$1 = appLovinError;
        this.f$2 = appLovinAdLoadListener;
    }

    public final void run() {
        this.f$0.c(this.f$1, this.f$2);
    }
}
