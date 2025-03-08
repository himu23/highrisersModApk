package com.applovin.impl.mediation;

import android.app.Activity;
import android.view.ViewGroup;
import androidx.lifecycle.Lifecycle;
import com.applovin.impl.mediation.ads.a;
import com.applovin.impl.mediation.b.c;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class MediationServiceImpl$$ExternalSyntheticLambda1 implements Runnable {
    public final /* synthetic */ MediationServiceImpl f$0;
    public final /* synthetic */ c f$1;
    public final /* synthetic */ g f$2;
    public final /* synthetic */ ViewGroup f$3;
    public final /* synthetic */ Lifecycle f$4;
    public final /* synthetic */ Activity f$5;
    public final /* synthetic */ a.C0067a f$6;

    public /* synthetic */ MediationServiceImpl$$ExternalSyntheticLambda1(MediationServiceImpl mediationServiceImpl, c cVar, g gVar, ViewGroup viewGroup, Lifecycle lifecycle, Activity activity, a.C0067a aVar) {
        this.f$0 = mediationServiceImpl;
        this.f$1 = cVar;
        this.f$2 = gVar;
        this.f$3 = viewGroup;
        this.f$4 = lifecycle;
        this.f$5 = activity;
        this.f$6 = aVar;
    }

    public final void run() {
        this.f$0.a(this.f$1, this.f$2, this.f$3, this.f$4, this.f$5, this.f$6);
    }
}
