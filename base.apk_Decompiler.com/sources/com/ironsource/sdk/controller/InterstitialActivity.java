package com.ironsource.sdk.controller;

import android.os.Bundle;
import com.ironsource.m2;
import com.ironsource.sdk.utils.Logger;

public class InterstitialActivity extends ControllerActivity {
    private static final String q = "InterstitialActivity";

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Logger.i(q, "onCreate");
    }

    /* access modifiers changed from: protected */
    public void onPause() {
        super.onPause();
        Logger.i(q, m2.h.t0);
    }

    /* access modifiers changed from: protected */
    public void onResume() {
        super.onResume();
        Logger.i(q, m2.h.u0);
    }
}
