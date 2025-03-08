package com.applovin.impl.sdk.utils;

import com.applovin.sdk.AppLovinAd;
import com.applovin.sdk.AppLovinAdVideoPlaybackListener;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class m$$ExternalSyntheticLambda4 implements Runnable {
    public final /* synthetic */ AppLovinAdVideoPlaybackListener f$0;
    public final /* synthetic */ AppLovinAd f$1;
    public final /* synthetic */ double f$2;
    public final /* synthetic */ boolean f$3;

    public /* synthetic */ m$$ExternalSyntheticLambda4(AppLovinAdVideoPlaybackListener appLovinAdVideoPlaybackListener, AppLovinAd appLovinAd, double d, boolean z) {
        this.f$0 = appLovinAdVideoPlaybackListener;
        this.f$1 = appLovinAd;
        this.f$2 = d;
        this.f$3 = z;
    }

    public final void run() {
        m.b(this.f$0, this.f$1, this.f$2, this.f$3);
    }
}
