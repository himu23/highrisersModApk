package com.applovin.impl.sdk.e;

import com.applovin.impl.sdk.ad.a;
import com.applovin.impl.sdk.ad.b;
import com.applovin.impl.sdk.e.q;
import com.applovin.impl.sdk.n;
import com.applovin.impl.sdk.utils.JsonUtils;
import com.applovin.impl.sdk.x;
import com.applovin.sdk.AppLovinAdLoadListener;
import com.applovin.sdk.AppLovinAdSize;
import com.applovin.sdk.AppLovinAdType;
import org.json.JSONObject;

public class u extends d {
    private final AppLovinAdLoadListener aTG;
    private final JSONObject adObject;
    private final JSONObject awB;
    private final b source;

    public u(JSONObject jSONObject, JSONObject jSONObject2, b bVar, AppLovinAdLoadListener appLovinAdLoadListener, n nVar) {
        super("TaskRenderAppLovinAd", nVar);
        this.adObject = jSONObject;
        this.awB = jSONObject2;
        this.source = bVar;
        this.aTG = appLovinAdLoadListener;
    }

    public void run() {
        x xVar = this.logger;
        if (x.Fn()) {
            this.logger.f(this.tag, "Rendering ad...");
        }
        a aVar = new a(this.adObject, this.awB, this.source, this.sdk);
        boolean booleanValue = JsonUtils.getBoolean(this.adObject, "gs_load_immediately", false).booleanValue();
        boolean booleanValue2 = JsonUtils.getBoolean(this.adObject, "vs_load_immediately", true).booleanValue();
        g gVar = new g(aVar, this.sdk, this.aTG);
        gVar.bg(booleanValue2);
        gVar.bh(booleanValue);
        q.b bVar = q.b.CACHING_OTHER;
        if (((Boolean) this.sdk.a(com.applovin.impl.sdk.c.b.aLH)).booleanValue()) {
            if (aVar.getSize() == AppLovinAdSize.INTERSTITIAL && aVar.getType() == AppLovinAdType.REGULAR) {
                bVar = q.b.CACHING_INTERSTITIAL;
            } else if (aVar.getSize() == AppLovinAdSize.INTERSTITIAL && aVar.getType() == AppLovinAdType.INCENTIVIZED) {
                bVar = q.b.CACHING_INCENTIVIZED;
            } else if (aVar.getSize() == AppLovinAdSize.NATIVE && aVar.getType() == AppLovinAdType.NATIVE) {
                bVar = q.b.CACHING_NATIVE;
            }
        }
        this.sdk.BO().a((d) gVar, bVar);
    }
}
