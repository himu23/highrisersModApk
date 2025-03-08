package com.applovin.impl.mediation;

import com.applovin.impl.mediation.g;
import com.applovin.mediation.MaxAdListener;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class g$a$$ExternalSyntheticLambda0 implements Runnable {
    public final /* synthetic */ g.a f$0;
    public final /* synthetic */ Runnable f$1;
    public final /* synthetic */ MaxAdListener f$2;
    public final /* synthetic */ String f$3;

    public /* synthetic */ g$a$$ExternalSyntheticLambda0(g.a aVar, Runnable runnable, MaxAdListener maxAdListener, String str) {
        this.f$0 = aVar;
        this.f$1 = runnable;
        this.f$2 = maxAdListener;
        this.f$3 = str;
    }

    public final void run() {
        this.f$0.a(this.f$1, this.f$2, this.f$3);
    }
}
