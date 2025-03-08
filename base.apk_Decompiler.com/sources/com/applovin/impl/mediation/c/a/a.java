package com.applovin.impl.mediation.c.a;

import android.text.TextUtils;
import com.applovin.impl.mediation.c.b;
import com.applovin.impl.mediation.c.c;
import com.applovin.impl.sdk.e.d;
import com.applovin.impl.sdk.e.w;
import com.applovin.impl.sdk.n;
import com.applovin.impl.sdk.utils.JsonUtils;
import com.applovin.impl.sdk.utils.StringUtils;
import com.applovin.impl.sdk.x;
import com.applovin.mediation.MaxAdFormat;
import com.applovin.mediation.adapter.parameters.MaxAdapterInitializationParameters;
import com.applovin.mediation.adapter.parameters.MaxAdapterParameters;
import com.applovin.mediation.adapter.parameters.MaxAdapterResponseParameters;
import com.applovin.sdk.AppLovinAdLoadListener;
import com.ironsource.m2;
import com.ironsource.t4;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.UUID;
import org.json.JSONObject;

public class a extends b {
    private final String avO;
    private final String avP;
    private final String avQ;
    /* access modifiers changed from: private */
    public String avR = UUID.randomUUID().toString().toLowerCase(Locale.US);

    public a(String str, String str2, String str3, n nVar) {
        super("NimbusApiService", nVar);
        this.avO = str;
        nVar.BN();
        if (x.Fn()) {
            x BN = nVar.BN();
            String str4 = this.tag;
            BN.f(str4, "Initializing Nimbus with apiKey=" + str + ", pubId=" + str2 + ", sessionId=" + this.avR);
        }
        str3 = !StringUtils.isValidString(str3) ? "adsbynimbus.com/rta/v1" : str3;
        this.avP = "https://" + str2 + "." + str3;
        String str5 = (String) nVar.b(c.avG, null, this.avw);
        if (TextUtils.isEmpty(str5)) {
            str5 = UUID.randomUUID().toString();
            nVar.a(c.avG, str5, this.avw);
        }
        this.avQ = str5;
        nVar.BN();
        if (x.Fn()) {
            x BN2 = nVar.BN();
            String str6 = this.tag;
            BN2.f(str6, "Setting Nimbus instanceId=" + str5);
        }
    }

    public void a(MaxAdapterInitializationParameters maxAdapterInitializationParameters) {
        a((MaxAdapterParameters) maxAdapterInitializationParameters);
    }

    public void a(MaxAdapterResponseParameters maxAdapterResponseParameters, MaxAdFormat maxAdFormat, AppLovinAdLoadListener appLovinAdLoadListener) {
        Map<String, Object> map;
        this.sdk.BN();
        if (x.Fn()) {
            x BN = this.sdk.BN();
            String str = this.tag;
            BN.f(str, "Loading Nimbus " + maxAdFormat.getLabel() + " ad with position: " + maxAdapterResponseParameters.getThirdPartyAdPlacementId());
        }
        a((MaxAdapterParameters) maxAdapterResponseParameters);
        if (this.sdk.BV() != null) {
            map = this.sdk.BV().CV();
        } else {
            map = this.sdk.BS().CV();
        }
        HashMap hashMap = new HashMap();
        hashMap.put("x-openrtb-version", "2.5");
        hashMap.put("Nimbus-Api-Key", this.avO);
        hashMap.put("Nimbus-Sdkv", "2.0.0");
        hashMap.put("Nimbus-Instance-Id", this.avQ);
        hashMap.put("User-Agent", String.valueOf(map.get(t4.R)));
        JSONObject jSONObject = new JSONObject();
        JsonUtils.putString(jSONObject, "session_id", this.avR);
        JSONObject jSONObject2 = new JSONObject();
        JsonUtils.putString(jSONObject2, m2.h.L, maxAdapterResponseParameters.getThirdPartyAdPlacementId());
        b.a zu = b.a.zt().k(jSONObject).n(zq()).l(jSONObject2).m(zr()).zu();
        com.applovin.impl.sdk.network.c a = a(this.avP, UUID.randomUUID().toString().toLowerCase(Locale.US), maxAdapterResponseParameters, maxAdFormat, zu, hashMap, true, this.sdk);
        final MaxAdapterResponseParameters maxAdapterResponseParameters2 = maxAdapterResponseParameters;
        final MaxAdFormat maxAdFormat2 = maxAdFormat;
        final AppLovinAdLoadListener appLovinAdLoadListener2 = appLovinAdLoadListener;
        this.sdk.BO().b((d) new w<JSONObject>(a, this.sdk) {
            /* renamed from: a */
            public void d(JSONObject jSONObject, int i) {
                if (i != 200 || jSONObject == null) {
                    x xVar = this.logger;
                    if (x.Fn()) {
                        x xVar2 = this.logger;
                        String str = this.tag;
                        xVar2.i(str, "Unable to fetch " + maxAdapterResponseParameters2.getThirdPartyAdPlacementId() + " Nimbus ad: server returned " + i);
                    }
                    appLovinAdLoadListener2.failedToReceiveAd(i);
                    return;
                }
                this.sdk.BO().b((d) new b(jSONObject, maxAdapterResponseParameters2, maxAdFormat2, a.this.avR, appLovinAdLoadListener2, this.sdk));
            }

            public void a(int i, String str, JSONObject jSONObject) {
                if (jSONObject != null && "No Bid".equalsIgnoreCase(JsonUtils.getString(jSONObject, "message", (String) null))) {
                    Object object = JsonUtils.getObject(jSONObject, "nbr", (Object) null);
                    x xVar = this.logger;
                    if (x.Fn()) {
                        x xVar2 = this.logger;
                        String str2 = this.tag;
                        xVar2.i(str2, "Nimbus request for " + maxAdapterResponseParameters2.getThirdPartyAdPlacementId() + " returned with no fill code: " + object);
                    }
                    appLovinAdLoadListener2.failedToReceiveAd(204);
                }
                x xVar3 = this.logger;
                if (x.Fn()) {
                    x xVar4 = this.logger;
                    String str3 = this.tag;
                    xVar4.i(str3, "Unable to fetch " + maxAdapterResponseParameters2.getThirdPartyAdPlacementId() + " Nimbus ad: server returned " + i);
                }
                appLovinAdLoadListener2.failedToReceiveAd(i);
            }
        });
    }

    private void a(MaxAdapterParameters maxAdapterParameters) {
        Object obj = maxAdapterParameters.getLocalExtraParameters().get("session_id");
        if (obj instanceof String) {
            String str = (String) obj;
            if (StringUtils.isValidString(str)) {
                this.sdk.BN();
                if (x.Fn()) {
                    x BN = this.sdk.BN();
                    String str2 = this.tag;
                    BN.f(str2, "Updating Nimbus sessionId to " + obj);
                }
                this.avR = str;
            }
        }
    }
}
