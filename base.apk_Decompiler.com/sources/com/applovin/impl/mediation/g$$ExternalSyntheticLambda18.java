package com.applovin.impl.mediation;

import android.app.Activity;
import com.applovin.mediation.adapter.parameters.MaxAdapterInitializationParameters;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class g$$ExternalSyntheticLambda18 implements Runnable {
    public final /* synthetic */ g f$0;
    public final /* synthetic */ Runnable f$1;
    public final /* synthetic */ MaxAdapterInitializationParameters f$2;
    public final /* synthetic */ Activity f$3;

    public /* synthetic */ g$$ExternalSyntheticLambda18(g gVar, Runnable runnable, MaxAdapterInitializationParameters maxAdapterInitializationParameters, Activity activity) {
        this.f$0 = gVar;
        this.f$1 = runnable;
        this.f$2 = maxAdapterInitializationParameters;
        this.f$3 = activity;
    }

    public final void run() {
        this.f$0.a(this.f$1, this.f$2, this.f$3);
    }
}
