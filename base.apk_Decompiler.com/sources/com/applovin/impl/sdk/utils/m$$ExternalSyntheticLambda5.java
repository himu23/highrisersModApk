package com.applovin.impl.sdk.utils;

import com.applovin.mediation.MaxAd;
import com.applovin.mediation.MaxAdExpirationListener;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class m$$ExternalSyntheticLambda5 implements Runnable {
    public final /* synthetic */ boolean f$0;
    public final /* synthetic */ MaxAdExpirationListener f$1;
    public final /* synthetic */ MaxAd f$2;
    public final /* synthetic */ MaxAd f$3;

    public /* synthetic */ m$$ExternalSyntheticLambda5(boolean z, MaxAdExpirationListener maxAdExpirationListener, MaxAd maxAd, MaxAd maxAd2) {
        this.f$0 = z;
        this.f$1 = maxAdExpirationListener;
        this.f$2 = maxAd;
        this.f$3 = maxAd2;
    }

    public final void run() {
        m.a(this.f$0, this.f$1, this.f$2, this.f$3);
    }
}
