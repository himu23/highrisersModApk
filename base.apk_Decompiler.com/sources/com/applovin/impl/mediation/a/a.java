package com.applovin.impl.mediation.a;

import android.content.Context;
import android.view.View;
import android.widget.FrameLayout;
import com.applovin.impl.adview.s;
import com.applovin.sdk.AppLovinSdkUtils;

public class a extends FrameLayout implements View.OnClickListener {
    private C0066a auo;

    /* renamed from: com.applovin.impl.mediation.a.a$a  reason: collision with other inner class name */
    interface C0066a {
        void a(a aVar);
    }

    public void setListener(C0066a aVar) {
        this.auo = aVar;
    }

    public a(c cVar, Context context) {
        super(context);
        setOnClickListener(this);
        s sVar = new s(context);
        int dpToPx = AppLovinSdkUtils.dpToPx(context, cVar.xp());
        sVar.setLayoutParams(new FrameLayout.LayoutParams(dpToPx, dpToPx, 17));
        sVar.fZ(dpToPx);
        addView(sVar);
        int dpToPx2 = AppLovinSdkUtils.dpToPx(context, cVar.xp() + (cVar.xq() * 2));
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(dpToPx2, dpToPx2, 8388661);
        int dpToPx3 = AppLovinSdkUtils.dpToPx(context, cVar.xn());
        int dpToPx4 = AppLovinSdkUtils.dpToPx(context, cVar.xo());
        layoutParams.setMargins(dpToPx4, dpToPx3, dpToPx4, 0);
        setLayoutParams(layoutParams);
    }

    public void onClick(View view) {
        this.auo.a(this);
    }
}
