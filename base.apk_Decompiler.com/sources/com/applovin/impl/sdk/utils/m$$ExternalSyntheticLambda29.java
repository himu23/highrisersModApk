package com.applovin.impl.sdk.utils;

import com.applovin.mediation.MaxAdListener;
import com.applovin.mediation.MaxError;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class m$$ExternalSyntheticLambda29 implements Runnable {
    public final /* synthetic */ boolean f$0;
    public final /* synthetic */ MaxAdListener f$1;
    public final /* synthetic */ String f$2;
    public final /* synthetic */ MaxError f$3;

    public /* synthetic */ m$$ExternalSyntheticLambda29(boolean z, MaxAdListener maxAdListener, String str, MaxError maxError) {
        this.f$0 = z;
        this.f$1 = maxAdListener;
        this.f$2 = str;
        this.f$3 = maxError;
    }

    public final void run() {
        m.a(this.f$0, this.f$1, this.f$2, this.f$3);
    }
}
