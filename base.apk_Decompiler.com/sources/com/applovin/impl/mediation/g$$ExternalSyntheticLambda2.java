package com.applovin.impl.mediation;

import android.app.Activity;
import com.applovin.impl.mediation.b.h;
import com.applovin.impl.mediation.g;
import com.applovin.mediation.adapter.MaxSignalProvider;
import com.applovin.mediation.adapter.parameters.MaxAdapterSignalCollectionParameters;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class g$$ExternalSyntheticLambda2 implements Runnable {
    public final /* synthetic */ g f$0;
    public final /* synthetic */ MaxSignalProvider f$1;
    public final /* synthetic */ MaxAdapterSignalCollectionParameters f$2;
    public final /* synthetic */ Activity f$3;
    public final /* synthetic */ g.c f$4;
    public final /* synthetic */ h f$5;

    public /* synthetic */ g$$ExternalSyntheticLambda2(g gVar, MaxSignalProvider maxSignalProvider, MaxAdapterSignalCollectionParameters maxAdapterSignalCollectionParameters, Activity activity, g.c cVar, h hVar) {
        this.f$0 = gVar;
        this.f$1 = maxSignalProvider;
        this.f$2 = maxAdapterSignalCollectionParameters;
        this.f$3 = activity;
        this.f$4 = cVar;
        this.f$5 = hVar;
    }

    public final void run() {
        this.f$0.a(this.f$1, this.f$2, this.f$3, this.f$4, this.f$5);
    }
}
