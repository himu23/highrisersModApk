package com.applovin.impl.mediation;

import com.applovin.impl.mediation.a;
import com.applovin.impl.mediation.c;
import com.applovin.impl.sdk.n;
import com.applovin.impl.sdk.utils.AppLovinSdkExtraParameterKey;
import com.applovin.impl.sdk.utils.m;
import com.applovin.mediation.MaxAd;
import com.applovin.mediation.MaxAdListener;
import com.applovin.sdk.AppLovinSdkUtils;

public class b implements a.C0065a, c.a {
    private final a akS;
    private final c akT;
    private final n sdk;

    public b(n nVar) {
        this.sdk = nVar;
        this.akS = new a(nVar);
        this.akT = new c(nVar, this);
    }

    public void b(com.applovin.impl.mediation.b.c cVar) {
        long xW = cVar.xW();
        if (xW >= 0) {
            this.akT.a(cVar, xW);
        }
        boolean parseBoolean = Boolean.parseBoolean(this.sdk.getSettings().getExtraParameters().get(AppLovinSdkExtraParameterKey.SHOULD_SCHEDULE_AD_HIDDEN_ON_AD_DESTROY));
        if (cVar.xX() || cVar.xY() || parseBoolean) {
            this.akS.ay(parseBoolean);
            this.akS.a(cVar, this);
        }
    }

    public void tS() {
        this.akT.tT();
        this.akS.W();
    }

    public void c(com.applovin.impl.mediation.b.c cVar) {
        e(cVar);
    }

    public void a(com.applovin.impl.mediation.b.c cVar) {
        AppLovinSdkUtils.runOnUiThreadDelayed(new b$$ExternalSyntheticLambda0(this, cVar), cVar.xZ());
    }

    /* access modifiers changed from: private */
    /* renamed from: d */
    public void e(com.applovin.impl.mediation.b.c cVar) {
        if (cVar != null && cVar.xP().compareAndSet(false, true)) {
            m.c((MaxAdListener) cVar.xC().uf(), (MaxAd) cVar);
        }
    }
}
