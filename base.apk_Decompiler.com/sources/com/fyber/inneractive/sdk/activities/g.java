package com.fyber.inneractive.sdk.activities;

import android.view.View;

public class g implements View.OnClickListener {
    public final /* synthetic */ InneractiveInternalBrowserActivity a;

    public g(InneractiveInternalBrowserActivity inneractiveInternalBrowserActivity) {
        this.a = inneractiveInternalBrowserActivity;
    }

    public void onClick(View view) {
        if (this.a.e.canGoBack()) {
            this.a.e.goBack();
        }
    }
}
