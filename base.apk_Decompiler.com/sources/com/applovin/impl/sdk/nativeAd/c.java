package com.applovin.impl.sdk.nativeAd;

import com.applovin.impl.sdk.AppLovinError;
import com.applovin.impl.sdk.ad.d;
import com.applovin.impl.sdk.e.k;
import com.applovin.impl.sdk.n;
import com.applovin.impl.sdk.utils.i;
import org.json.JSONObject;

public class c extends k {
    private final AppLovinNativeAdLoadListener awg;

    public c(d dVar, String str, AppLovinNativeAdLoadListener appLovinNativeAdLoadListener, n nVar) {
        super(dVar, str, nVar);
        this.awg = appLovinNativeAdLoadListener;
    }

    /* access modifiers changed from: protected */
    public String zC() {
        return i.I(this.sdk);
    }

    /* access modifiers changed from: protected */
    public String zD() {
        return i.J(this.sdk);
    }

    /* access modifiers changed from: protected */
    public com.applovin.impl.sdk.e.d I(JSONObject jSONObject) {
        return new d(jSONObject, this.awg, this.sdk);
    }

    /* access modifiers changed from: protected */
    public void e(int i, String str) {
        super.e(i, str);
        this.awg.onNativeAdLoadFailed(new AppLovinError(i, str));
    }
}
