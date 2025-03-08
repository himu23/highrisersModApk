package com.applovin.impl.sdk;

import android.app.Activity;
import com.applovin.sdk.AppLovinUserService;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class m$$ExternalSyntheticLambda1 implements Runnable {
    public final /* synthetic */ m f$0;
    public final /* synthetic */ AppLovinUserService.OnConsentDialogDismissListener f$1;
    public final /* synthetic */ Activity f$2;

    public /* synthetic */ m$$ExternalSyntheticLambda1(m mVar, AppLovinUserService.OnConsentDialogDismissListener onConsentDialogDismissListener, Activity activity) {
        this.f$0 = mVar;
        this.f$1 = onConsentDialogDismissListener;
        this.f$2 = activity;
    }

    public final void run() {
        this.f$0.a(this.f$1, this.f$2);
    }
}
