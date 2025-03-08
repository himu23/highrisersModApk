package com.applovin.impl.adview.activity.a;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.applovin.adview.AppLovinAdView;
import com.applovin.impl.adview.a;
import com.applovin.impl.adview.n;
import com.applovin.impl.adview.v;
import com.applovin.impl.sdk.ad.e;
import com.applovin.impl.sdk.c.b;
import com.applovin.sdk.AppLovinSdkUtils;

public class d extends a {
    public /* bridge */ /* synthetic */ void a(n nVar) {
        super.a(nVar);
    }

    public /* bridge */ /* synthetic */ void k(View view) {
        super.k(view);
    }

    public d(e eVar, Activity activity, com.applovin.impl.sdk.n nVar) {
        super(eVar, activity, nVar);
    }

    public void a(ImageView imageView, n nVar, n nVar2, a aVar, v vVar, AppLovinAdView appLovinAdView, ViewGroup viewGroup) {
        this.aiM.addView(appLovinAdView);
        int i = 3;
        if (nVar != null) {
            a(this.aiL.GN(), (this.aiL.GS() ? 3 : 5) | 48, nVar);
        }
        if (nVar2 != null) {
            if (!this.aiL.GR()) {
                i = 5;
            }
            a(this.aiL.GN(), i | 48, nVar2);
        }
        if (imageView != null) {
            int dpToPx = AppLovinSdkUtils.dpToPx(this.ahM, ((Integer) this.sdk.a(b.aNj)).intValue());
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(dpToPx, dpToPx, ((Integer) this.sdk.a(b.aNl)).intValue());
            int dpToPx2 = AppLovinSdkUtils.dpToPx(this.ahM, ((Integer) this.sdk.a(b.aNk)).intValue());
            layoutParams.setMargins(dpToPx2, dpToPx2, dpToPx2, dpToPx2);
            this.aiM.addView(imageView, layoutParams);
        }
        if (aVar != null) {
            this.aiM.addView(aVar, this.aiN);
        }
        if (vVar != null) {
            this.aiM.addView(vVar, new ViewGroup.LayoutParams(-1, -1));
        }
        if (viewGroup != null) {
            viewGroup.addView(this.aiM);
        } else {
            this.ahM.setContentView(this.aiM);
        }
    }
}
