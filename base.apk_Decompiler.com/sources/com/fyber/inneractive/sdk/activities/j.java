package com.fyber.inneractive.sdk.activities;

import android.view.View;

public class j implements View.OnClickListener {
    public final /* synthetic */ InneractiveInternalBrowserActivity a;

    public j(InneractiveInternalBrowserActivity inneractiveInternalBrowserActivity) {
        this.a = inneractiveInternalBrowserActivity;
    }

    public void onClick(View view) {
        this.a.finish();
    }
}
