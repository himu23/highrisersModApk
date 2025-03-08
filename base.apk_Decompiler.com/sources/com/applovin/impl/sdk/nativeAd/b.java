package com.applovin.impl.sdk.nativeAd;

import com.applovin.impl.sdk.ad.c;
import com.applovin.impl.sdk.ad.d;
import com.applovin.impl.sdk.n;
import java.util.HashMap;
import java.util.Map;

public class b extends c {
    private final c aHk;

    public b(c cVar, AppLovinNativeAdLoadListener appLovinNativeAdLoadListener, n nVar) {
        super(d.cQ("adtoken_zone"), "TaskFetchNativeTokenAd", appLovinNativeAdLoadListener, nVar);
        this.aHk = cVar;
    }

    /* access modifiers changed from: protected */
    public Map<String, String> HI() {
        HashMap hashMap = new HashMap(2);
        hashMap.put("adtoken", this.aHk.mQ());
        hashMap.put("adtoken_prefix", this.aHk.FQ());
        return hashMap;
    }
}
