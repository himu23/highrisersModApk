package com.applovin.impl.mediation.ads;

import com.applovin.impl.mediation.ads.MaxFullscreenAdImpl;
import com.applovin.impl.mediation.b.c;
import com.applovin.mediation.MaxAd;
import com.applovin.mediation.MaxError;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class MaxFullscreenAdImpl$b$$ExternalSyntheticLambda1 implements Runnable {
    public final /* synthetic */ MaxFullscreenAdImpl.b f$0;
    public final /* synthetic */ MaxAd f$1;
    public final /* synthetic */ boolean f$2;
    public final /* synthetic */ c f$3;
    public final /* synthetic */ MaxError f$4;

    public /* synthetic */ MaxFullscreenAdImpl$b$$ExternalSyntheticLambda1(MaxFullscreenAdImpl.b bVar, MaxAd maxAd, boolean z, c cVar, MaxError maxError) {
        this.f$0 = bVar;
        this.f$1 = maxAd;
        this.f$2 = z;
        this.f$3 = cVar;
        this.f$4 = maxError;
    }

    public final void run() {
        this.f$0.a(this.f$1, this.f$2, this.f$3, this.f$4);
    }
}
