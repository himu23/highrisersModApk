package com.applovin.impl.adview.activity.a;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import com.applovin.adview.AppLovinAdView;
import com.applovin.impl.adview.n;
import com.applovin.impl.adview.v;
import com.applovin.impl.sdk.ad.e;

public class b extends a {
    public /* bridge */ /* synthetic */ void a(n nVar) {
        super.a(nVar);
    }

    public /* bridge */ /* synthetic */ void k(View view) {
        super.k(view);
    }

    public b(e eVar, Activity activity, com.applovin.impl.sdk.n nVar) {
        super(eVar, activity, nVar);
    }

    public void a(n nVar, v vVar, AppLovinAdView appLovinAdView, ViewGroup viewGroup) {
        this.aiM.addView(appLovinAdView);
        if (nVar != null) {
            a(this.aiL.GN(), (this.aiL.GR() ? 3 : 5) | 48, nVar);
        }
        if (vVar != null) {
            this.aiM.addView(vVar, this.aiN);
        }
        if (viewGroup != null) {
            viewGroup.addView(this.aiM);
        } else {
            this.ahM.setContentView(this.aiM);
        }
    }
}
