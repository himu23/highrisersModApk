package com.applovin.impl.adview;

import android.content.Context;
import android.view.ViewGroup;
import com.applovin.adview.AppLovinFullscreenAdViewObserver;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class q$$ExternalSyntheticLambda6 implements Runnable {
    public final /* synthetic */ q f$0;
    public final /* synthetic */ Context f$1;
    public final /* synthetic */ ViewGroup f$2;
    public final /* synthetic */ AppLovinFullscreenAdViewObserver f$3;
    public final /* synthetic */ long f$4;

    public /* synthetic */ q$$ExternalSyntheticLambda6(q qVar, Context context, ViewGroup viewGroup, AppLovinFullscreenAdViewObserver appLovinFullscreenAdViewObserver, long j) {
        this.f$0 = qVar;
        this.f$1 = context;
        this.f$2 = viewGroup;
        this.f$3 = appLovinFullscreenAdViewObserver;
        this.f$4 = j;
    }

    public final void run() {
        this.f$0.a(this.f$1, this.f$2, this.f$3, this.f$4);
    }
}
