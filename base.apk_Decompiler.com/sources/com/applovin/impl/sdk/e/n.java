package com.applovin.impl.sdk.e;

import com.applovin.impl.sdk.AppLovinError;
import com.applovin.impl.sdk.ad.d;
import com.applovin.impl.sdk.utils.i;
import com.applovin.sdk.AppLovinAdLoadListener;
import org.json.JSONObject;

public class n extends k {
    private final AppLovinAdLoadListener agz;

    public n(d dVar, AppLovinAdLoadListener appLovinAdLoadListener, com.applovin.impl.sdk.n nVar) {
        this(dVar, appLovinAdLoadListener, "TaskFetchNextAd", nVar);
    }

    public n(d dVar, AppLovinAdLoadListener appLovinAdLoadListener, String str, com.applovin.impl.sdk.n nVar) {
        super(dVar, str, nVar);
        this.agz = appLovinAdLoadListener;
    }

    /* access modifiers changed from: protected */
    public String zC() {
        return i.b(this.sdk);
    }

    /* access modifiers changed from: protected */
    public String zD() {
        return i.c(this.sdk);
    }

    /* access modifiers changed from: protected */
    public d I(JSONObject jSONObject) {
        return new r(jSONObject, this.azA, getSource(), this.agz, this.sdk);
    }

    /* access modifiers changed from: protected */
    public void e(int i, String str) {
        super.e(i, str);
        AppLovinAdLoadListener appLovinAdLoadListener = this.agz;
        if (appLovinAdLoadListener instanceof com.applovin.impl.sdk.ad.i) {
            ((com.applovin.impl.sdk.ad.i) this.agz).failedToReceiveAdV2(new AppLovinError(i, str));
            return;
        }
        appLovinAdLoadListener.failedToReceiveAd(i);
    }
}
