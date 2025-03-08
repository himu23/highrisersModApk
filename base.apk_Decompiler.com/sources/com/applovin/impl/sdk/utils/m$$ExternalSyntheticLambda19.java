package com.applovin.impl.sdk.utils;

import com.applovin.sdk.AppLovinAd;
import com.applovin.sdk.AppLovinAdRewardListener;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class m$$ExternalSyntheticLambda19 implements Runnable {
    public final /* synthetic */ AppLovinAdRewardListener f$0;
    public final /* synthetic */ AppLovinAd f$1;
    public final /* synthetic */ int f$2;

    public /* synthetic */ m$$ExternalSyntheticLambda19(AppLovinAdRewardListener appLovinAdRewardListener, AppLovinAd appLovinAd, int i) {
        this.f$0 = appLovinAdRewardListener;
        this.f$1 = appLovinAd;
        this.f$2 = i;
    }

    public final void run() {
        m.b(this.f$0, this.f$1, this.f$2);
    }
}
