package com.applovin.impl.sdk.e;

import com.applovin.impl.sdk.ad.b;
import com.applovin.impl.sdk.ad.c;
import com.applovin.impl.sdk.ad.d;
import com.applovin.impl.sdk.n;
import com.applovin.sdk.AppLovinAdLoadListener;
import java.util.HashMap;
import java.util.Map;

public class o extends n {
    private final c aUk;

    public o(c cVar, AppLovinAdLoadListener appLovinAdLoadListener, n nVar) {
        super(d.cQ("adtoken_zone"), appLovinAdLoadListener, "TaskFetchTokenAd", nVar);
        this.aUk = cVar;
    }

    /* access modifiers changed from: protected */
    public Map<String, String> HI() {
        HashMap hashMap = new HashMap(2);
        hashMap.put("adtoken", this.aUk.mQ());
        hashMap.put("adtoken_prefix", this.aUk.FQ());
        return hashMap;
    }

    /* access modifiers changed from: protected */
    public b getSource() {
        return b.REGULAR_AD_TOKEN;
    }
}
