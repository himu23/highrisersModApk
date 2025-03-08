package com.applovin.impl.adview;

import android.content.Context;
import android.view.ViewGroup;
import com.applovin.adview.AppLovinFullscreenAdViewObserver;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class q$$ExternalSyntheticLambda0 implements Runnable {
    public final /* synthetic */ q f$0;
    public final /* synthetic */ ViewGroup f$1;
    public final /* synthetic */ Context f$2;
    public final /* synthetic */ AppLovinFullscreenAdViewObserver f$3;

    public /* synthetic */ q$$ExternalSyntheticLambda0(q qVar, ViewGroup viewGroup, Context context, AppLovinFullscreenAdViewObserver appLovinFullscreenAdViewObserver) {
        this.f$0 = qVar;
        this.f$1 = viewGroup;
        this.f$2 = context;
        this.f$3 = appLovinFullscreenAdViewObserver;
    }

    public final void run() {
        this.f$0.a(this.f$1, this.f$2, this.f$3);
    }
}
