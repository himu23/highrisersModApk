package com.fyber.inneractive.sdk.activities;

import com.fyber.inneractive.sdk.click.b;
import com.fyber.inneractive.sdk.click.l;

public class f implements l.b {
    public final /* synthetic */ InneractiveInternalBrowserActivity a;

    public f(InneractiveInternalBrowserActivity inneractiveInternalBrowserActivity) {
        this.a = inneractiveInternalBrowserActivity;
    }

    public void a(b bVar) {
        if (bVar != null && bVar.a != l.d.FAILED) {
            InneractiveInternalBrowserActivity.a(this.a, bVar);
            this.a.finish();
        }
    }
}
