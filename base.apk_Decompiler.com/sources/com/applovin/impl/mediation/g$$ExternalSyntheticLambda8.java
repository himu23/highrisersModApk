package com.applovin.impl.mediation;

import android.app.Activity;
import com.applovin.mediation.MaxAdFormat;
import com.applovin.mediation.adapter.parameters.MaxAdapterResponseParameters;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class g$$ExternalSyntheticLambda8 implements Runnable {
    public final /* synthetic */ g f$0;
    public final /* synthetic */ MaxAdapterResponseParameters f$1;
    public final /* synthetic */ MaxAdFormat f$2;
    public final /* synthetic */ Activity f$3;

    public /* synthetic */ g$$ExternalSyntheticLambda8(g gVar, MaxAdapterResponseParameters maxAdapterResponseParameters, MaxAdFormat maxAdFormat, Activity activity) {
        this.f$0 = gVar;
        this.f$1 = maxAdapterResponseParameters;
        this.f$2 = maxAdFormat;
        this.f$3 = activity;
    }

    public final void run() {
        this.f$0.a(this.f$1, this.f$2, this.f$3);
    }
}
