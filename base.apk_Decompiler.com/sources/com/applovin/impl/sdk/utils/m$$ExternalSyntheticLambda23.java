package com.applovin.impl.sdk.utils;

import com.applovin.sdk.AppLovinAd;
import com.applovin.sdk.AppLovinAdRewardListener;
import java.util.Map;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class m$$ExternalSyntheticLambda23 implements Runnable {
    public final /* synthetic */ AppLovinAdRewardListener f$0;
    public final /* synthetic */ AppLovinAd f$1;
    public final /* synthetic */ Map f$2;

    public /* synthetic */ m$$ExternalSyntheticLambda23(AppLovinAdRewardListener appLovinAdRewardListener, AppLovinAd appLovinAd, Map map) {
        this.f$0 = appLovinAdRewardListener;
        this.f$1 = appLovinAd;
        this.f$2 = map;
    }

    public final void run() {
        m.d(this.f$0, this.f$1, this.f$2);
    }
}
