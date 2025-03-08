package com.fyber.inneractive.sdk.activities;

import android.view.View;
import com.fyber.inneractive.sdk.util.IAlog;

public class i implements View.OnClickListener {
    public final /* synthetic */ InneractiveInternalBrowserActivity a;

    public i(InneractiveInternalBrowserActivity inneractiveInternalBrowserActivity) {
        this.a = inneractiveInternalBrowserActivity;
    }

    public void onClick(View view) {
        this.a.e.reload();
        int i = IAlog.a;
        IAlog.a(1, (Exception) null, "%s %s", "AD_INTERNAL_BROWSER_REFRESH", this.a.e.getUrl());
    }
}
