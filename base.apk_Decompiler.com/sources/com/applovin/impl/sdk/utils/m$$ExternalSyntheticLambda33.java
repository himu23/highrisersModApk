package com.applovin.impl.sdk.utils;

import com.applovin.mediation.MaxAd;
import com.applovin.mediation.MaxAdListener;
import com.applovin.mediation.MaxError;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class m$$ExternalSyntheticLambda33 implements Runnable {
    public final /* synthetic */ boolean f$0;
    public final /* synthetic */ MaxAdListener f$1;
    public final /* synthetic */ MaxAd f$2;
    public final /* synthetic */ MaxError f$3;

    public /* synthetic */ m$$ExternalSyntheticLambda33(boolean z, MaxAdListener maxAdListener, MaxAd maxAd, MaxError maxError) {
        this.f$0 = z;
        this.f$1 = maxAdListener;
        this.f$2 = maxAd;
        this.f$3 = maxError;
    }

    public final void run() {
        m.a(this.f$0, this.f$1, this.f$2, this.f$3);
    }
}
