package com.applovin.impl.sdk.nativeAd;

import com.applovin.impl.sdk.AppLovinError;
import com.applovin.impl.sdk.n;
import com.applovin.impl.sdk.utils.JsonUtils;
import com.applovin.impl.sdk.utils.u;
import com.applovin.impl.sdk.x;
import com.applovin.mediation.MaxAdFormat;
import org.json.JSONArray;
import org.json.JSONObject;

public class d extends com.applovin.impl.sdk.e.d {
    private final AppLovinNativeAdLoadListener awg;
    private final JSONObject fullResponse;

    public d(JSONObject jSONObject, AppLovinNativeAdLoadListener appLovinNativeAdLoadListener, n nVar) {
        super("TaskProcessNativeAdResponse", nVar);
        this.fullResponse = jSONObject;
        this.awg = appLovinNativeAdLoadListener;
    }

    public void run() {
        JSONArray jSONArray = JsonUtils.getJSONArray(this.fullResponse, "ads", new JSONArray());
        if (jSONArray.length() > 0) {
            x xVar = this.logger;
            if (x.Fn()) {
                this.logger.f(this.tag, "Processing ad...");
            }
            this.sdk.BO().b((com.applovin.impl.sdk.e.d) new e(JsonUtils.getJSONObject(jSONArray, 0, new JSONObject()), this.fullResponse, this.awg, this.sdk));
            return;
        }
        x xVar2 = this.logger;
        if (x.Fn()) {
            this.logger.h(this.tag, "No ads were returned from the server");
        }
        u.a("native_native", MaxAdFormat.NATIVE, this.fullResponse, this.sdk);
        this.awg.onNativeAdLoadFailed(AppLovinError.NO_FILL);
    }
}
