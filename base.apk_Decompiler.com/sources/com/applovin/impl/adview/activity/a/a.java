package com.applovin.impl.adview.activity.a;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.core.view.ViewCompat;
import com.applovin.impl.sdk.ad.e;
import com.applovin.impl.sdk.n;

abstract class a {
    final Activity ahM;
    final e aiL;
    final ViewGroup aiM;
    final FrameLayout.LayoutParams aiN;
    final n sdk;

    a(e eVar, Activity activity, n nVar) {
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1, 17);
        this.aiN = layoutParams;
        this.aiL = eVar;
        this.sdk = nVar;
        this.ahM = activity;
        FrameLayout frameLayout = new FrameLayout(activity);
        this.aiM = frameLayout;
        frameLayout.setBackgroundColor(ViewCompat.MEASURED_STATE_MASK);
        frameLayout.setLayoutParams(layoutParams);
    }

    public void k(View view) {
        this.aiM.removeView(view);
    }

    public void a(com.applovin.impl.adview.n nVar) {
        if (nVar != null && nVar.getParent() == null) {
            a(this.aiL.GN(), (this.aiL.GR() ? 3 : 5) | 48, nVar);
        }
    }

    /* access modifiers changed from: package-private */
    public void a(e.c cVar, int i, com.applovin.impl.adview.n nVar) {
        nVar.d(cVar.aGN, cVar.aGR, cVar.aGQ, i);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(nVar.getLayoutParams());
        layoutParams.setMargins(cVar.aGP, cVar.aGO, cVar.aGP, 0);
        layoutParams.gravity = i;
        this.aiM.addView(nVar, layoutParams);
    }
}
