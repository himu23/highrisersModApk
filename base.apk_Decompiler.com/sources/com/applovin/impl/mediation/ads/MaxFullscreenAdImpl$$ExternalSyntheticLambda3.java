package com.applovin.impl.mediation.ads;

import android.app.Activity;
import android.view.ViewGroup;
import androidx.lifecycle.Lifecycle;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class MaxFullscreenAdImpl$$ExternalSyntheticLambda3 implements Runnable {
    public final /* synthetic */ MaxFullscreenAdImpl f$0;
    public final /* synthetic */ String f$1;
    public final /* synthetic */ String f$2;
    public final /* synthetic */ Activity f$3;
    public final /* synthetic */ ViewGroup f$4;
    public final /* synthetic */ Lifecycle f$5;

    public /* synthetic */ MaxFullscreenAdImpl$$ExternalSyntheticLambda3(MaxFullscreenAdImpl maxFullscreenAdImpl, String str, String str2, Activity activity, ViewGroup viewGroup, Lifecycle lifecycle) {
        this.f$0 = maxFullscreenAdImpl;
        this.f$1 = str;
        this.f$2 = str2;
        this.f$3 = activity;
        this.f$4 = viewGroup;
        this.f$5 = lifecycle;
    }

    public final void run() {
        this.f$0.a(this.f$1, this.f$2, this.f$3, this.f$4, this.f$5);
    }
}
