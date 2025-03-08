package com.fyber.inneractive.sdk.activities;

import android.view.View;

public class k implements View.OnClickListener {
    public final /* synthetic */ InneractiveRichMediaVideoPlayerActivityCore a;

    public k(InneractiveRichMediaVideoPlayerActivityCore inneractiveRichMediaVideoPlayerActivityCore) {
        this.a = inneractiveRichMediaVideoPlayerActivityCore;
    }

    public void onClick(View view) {
        this.a.finish();
    }
}
