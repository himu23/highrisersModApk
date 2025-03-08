package com.applovin.impl.mediation.c.a;

import android.text.TextUtils;
import com.applovin.impl.mediation.c.d;
import com.applovin.impl.sdk.ad.AppLovinAdImpl;
import com.applovin.impl.sdk.e.q;
import com.applovin.impl.sdk.e.u;
import com.applovin.impl.sdk.n;
import com.applovin.impl.sdk.utils.JsonUtils;
import com.applovin.impl.sdk.x;
import com.applovin.mediation.MaxAdFormat;
import com.applovin.mediation.adapter.parameters.MaxAdapterResponseParameters;
import com.applovin.sdk.AppLovinAd;
import com.applovin.sdk.AppLovinAdLoadListener;
import com.ironsource.m2;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class b extends d implements AppLovinAdLoadListener {
    private final String avR;
    private final AppLovinAdLoadListener avU;
    private String avV;
    private JSONObject avW;
    private JSONObject avX;
    private String avY;

    public b(JSONObject jSONObject, MaxAdapterResponseParameters maxAdapterResponseParameters, MaxAdFormat maxAdFormat, String str, AppLovinAdLoadListener appLovinAdLoadListener, n nVar) {
        super("TaskProcessNimbusAd", jSONObject, maxAdapterResponseParameters, maxAdFormat, nVar);
        this.avR = str;
        this.avU = appLovinAdLoadListener;
    }

    public void run() {
        String string = JsonUtils.getString(this.avK, "markup", "");
        this.avV = string;
        if (TextUtils.isEmpty(string)) {
            this.avU.failedToReceiveAd(204);
            return;
        }
        String string2 = JsonUtils.getString(this.avK, m2.h.L, "");
        String string3 = JsonUtils.getString(this.avK, "placement_id", "");
        String string4 = JsonUtils.getString(this.avK, "auction_id", "");
        x xVar = this.logger;
        if (x.Fn()) {
            x xVar2 = this.logger;
            xVar2.f("TaskProcessNimbusAd", "Processing Nimbus ad (" + string2 + ") for placement: " + string3 + " with auction id: " + string4 + "...");
        }
        this.avN = JsonUtils.getString(this.avK, "network", "");
        this.avY = JsonUtils.getString(this.avK, "crid", (String) null);
        JSONObject jSONObject = JsonUtils.getJSONObject(this.avK, "trackers", new JSONObject());
        this.avX = c(JsonUtils.getJSONArray(jSONObject, "click_trackers", (JSONArray) null));
        this.avW = c(JsonUtils.getJSONArray(jSONObject, "impression_trackers", (JSONArray) null));
        JSONObject zv = zv();
        JSONObject o = o(zv);
        x xVar3 = this.logger;
        if (x.Fn()) {
            x xVar4 = this.logger;
            xVar4.f("TaskProcessNimbusAd", "Starting render task for Nimbus ad: " + string2 + "...");
        }
        this.sdk.BO().a((com.applovin.impl.sdk.e.d) new u(zv, o, com.applovin.impl.sdk.ad.b.UNKNOWN, this.avU, this.sdk), q.b.MAIN);
    }

    /* access modifiers changed from: protected */
    public JSONObject zv() {
        JSONObject a = a(this.avV, this.avX, this.avW);
        JsonUtils.putString(a, "cache_prefix", "nimbus");
        JsonUtils.putString(a, "type", "nimbus");
        JsonUtils.putJSONObject(a, "http_headers_for_postbacks", zz());
        return a;
    }

    private JSONObject c(JSONArray jSONArray) {
        if (jSONArray == null) {
            return null;
        }
        JSONObject jSONObject = new JSONObject();
        for (int i = 0; i < jSONArray.length(); i++) {
            try {
                String string = jSONArray.getString(i);
                if (!TextUtils.isEmpty(string)) {
                    jSONObject.put(string, "");
                }
            } catch (JSONException e) {
                this.sdk.BN();
                if (x.Fn()) {
                    this.sdk.BN().c(this.tag, "Failed to retrieve tracking url with a non-String value.", e);
                }
            }
        }
        return jSONObject;
    }

    private JSONObject zz() {
        JSONObject jSONObject = new JSONObject();
        JsonUtils.putString(jSONObject, "Nimbus-Session-Id", this.avR);
        return jSONObject;
    }

    public void adReceived(AppLovinAd appLovinAd) {
        ((AppLovinAdImpl) appLovinAd).setMaxAdValue("creative_id", this.avY);
        this.avU.adReceived(appLovinAd);
    }

    public void failedToReceiveAd(int i) {
        this.avU.failedToReceiveAd(i);
    }
}
