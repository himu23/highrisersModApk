package com.fyber.inneractive.sdk.activities;

import android.view.View;

public class h implements View.OnClickListener {
    public final /* synthetic */ InneractiveInternalBrowserActivity a;

    public h(InneractiveInternalBrowserActivity inneractiveInternalBrowserActivity) {
        this.a = inneractiveInternalBrowserActivity;
    }

    public void onClick(View view) {
        if (this.a.e.canGoForward()) {
            this.a.e.goForward();
        }
    }
}
