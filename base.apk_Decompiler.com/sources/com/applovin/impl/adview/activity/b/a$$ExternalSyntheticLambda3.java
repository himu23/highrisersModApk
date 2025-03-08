package com.applovin.impl.adview.activity.b;

import com.applovin.impl.adview.n;
import com.applovin.sdk.AppLovinSdkUtils;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class a$$ExternalSyntheticLambda3 implements Runnable {
    public final /* synthetic */ n f$0;
    public final /* synthetic */ Runnable f$1;

    public /* synthetic */ a$$ExternalSyntheticLambda3(n nVar, Runnable runnable) {
        this.f$0 = nVar;
        this.f$1 = runnable;
    }

    public final void run() {
        AppLovinSdkUtils.runOnUiThread(new a$$ExternalSyntheticLambda5(this.f$0, this.f$1));
    }
}
