package com.fyber.inneractive.sdk.activities;

import android.window.OnBackInvokedCallback;

public class b implements OnBackInvokedCallback {
    public final /* synthetic */ InneractiveBaseActivity a;

    public b(InneractiveBaseActivity inneractiveBaseActivity) {
        this.a = inneractiveBaseActivity;
    }

    public void onBackInvoked() {
        this.a.onBackPressed();
    }
}
