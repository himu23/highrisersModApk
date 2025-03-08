package com.applovin.impl.sdk.e;

import com.applovin.impl.sdk.AppLovinError;
import com.applovin.impl.sdk.ad.b;
import com.applovin.impl.sdk.ad.d;
import com.applovin.impl.sdk.ad.i;
import com.applovin.impl.sdk.n;
import com.applovin.impl.sdk.utils.JsonUtils;
import com.applovin.impl.sdk.utils.u;
import com.applovin.impl.sdk.x;
import com.applovin.sdk.AppLovinAd;
import com.applovin.sdk.AppLovinAdLoadListener;
import com.applovin.sdk.AppLovinErrorCodes;
import org.json.JSONArray;
import org.json.JSONObject;

public class r extends d implements i {
    private final AppLovinAdLoadListener avU;
    private final JSONObject awB;
    private final d azA;
    private final b source;

    public r(JSONObject jSONObject, d dVar, b bVar, AppLovinAdLoadListener appLovinAdLoadListener, n nVar) {
        super("TaskProcessAdResponse", nVar);
        if (jSONObject == null) {
            throw new IllegalArgumentException("No response specified");
        } else if (dVar != null) {
            this.awB = jSONObject;
            this.azA = dVar;
            this.source = bVar;
            this.avU = appLovinAdLoadListener;
        } else {
            throw new IllegalArgumentException("No zone specified");
        }
    }

    public void run() {
        JSONArray jSONArray = JsonUtils.getJSONArray(this.awB, "ads", new JSONArray());
        if (jSONArray.length() > 0) {
            x xVar = this.logger;
            if (x.Fn()) {
                this.logger.f(this.tag, "Processing ad...");
            }
            R(JsonUtils.getJSONObject(jSONArray, 0, new JSONObject()));
            return;
        }
        x xVar2 = this.logger;
        if (x.Fn()) {
            this.logger.h(this.tag, "No ads were returned from the server");
        }
        u.a(this.azA.mQ(), this.azA.getFormat(), this.awB, this.sdk);
        failedToReceiveAdV2(AppLovinError.NO_FILL);
    }

    private void R(JSONObject jSONObject) {
        String string = JsonUtils.getString(jSONObject, "type", "undefined");
        if ("applovin".equalsIgnoreCase(string)) {
            x xVar = this.logger;
            if (x.Fn()) {
                this.logger.f(this.tag, "Starting task for AppLovin ad...");
            }
            this.sdk.BO().b((d) new u(jSONObject, this.awB, this.source, this, this.sdk));
        } else if ("vast".equalsIgnoreCase(string)) {
            x xVar2 = this.logger;
            if (x.Fn()) {
                this.logger.f(this.tag, "Starting task for VAST ad...");
            }
            this.sdk.BO().b((d) t.a(jSONObject, this.awB, this.source, this, this.sdk));
        } else if ("js_tag".equalsIgnoreCase(string)) {
            x xVar3 = this.logger;
            if (x.Fn()) {
                this.logger.f(this.tag, "Starting task for JS tag ad...");
            }
            this.sdk.BO().b((d) new s(jSONObject, this.awB, this.source, this, this.sdk));
        } else {
            x xVar4 = this.logger;
            if (x.Fn()) {
                x xVar5 = this.logger;
                String str = this.tag;
                xVar5.i(str, "Unable to process ad of unknown type: " + string);
            }
            failedToReceiveAdV2(new AppLovinError(AppLovinErrorCodes.INVALID_RESPONSE, "Unknown ad type: " + string));
        }
    }

    public void adReceived(AppLovinAd appLovinAd) {
        AppLovinAdLoadListener appLovinAdLoadListener = this.avU;
        if (appLovinAdLoadListener != null) {
            appLovinAdLoadListener.adReceived(appLovinAd);
        }
    }

    public void failedToReceiveAd(int i) {
        failedToReceiveAdV2(new AppLovinError(i, ""));
    }

    public void failedToReceiveAdV2(AppLovinError appLovinError) {
        AppLovinAdLoadListener appLovinAdLoadListener = this.avU;
        if (appLovinAdLoadListener != null) {
            if (appLovinAdLoadListener instanceof i) {
                ((i) appLovinAdLoadListener).failedToReceiveAdV2(appLovinError);
            } else {
                appLovinAdLoadListener.failedToReceiveAd(appLovinError.getCode());
            }
        }
    }
}
