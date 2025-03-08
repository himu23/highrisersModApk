package com.applovin.impl.sdk.utils;

import com.applovin.impl.sdk.ad.h;
import com.applovin.sdk.AppLovinAdDisplayListener;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class m$$ExternalSyntheticLambda21 implements Runnable {
    public final /* synthetic */ AppLovinAdDisplayListener f$0;
    public final /* synthetic */ String f$1;

    public /* synthetic */ m$$ExternalSyntheticLambda21(AppLovinAdDisplayListener appLovinAdDisplayListener, String str) {
        this.f$0 = appLovinAdDisplayListener;
        this.f$1 = str;
    }

    public final void run() {
        ((h) this.f$0).onAdDisplayFailed(this.f$1);
    }
}
