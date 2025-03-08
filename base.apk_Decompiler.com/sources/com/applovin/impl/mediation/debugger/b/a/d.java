package com.applovin.impl.mediation.debugger.b.a;

import com.applovin.impl.sdk.n;
import com.applovin.impl.sdk.utils.JsonUtils;
import com.ironsource.w5;
import org.json.JSONObject;

public class d {
    private final String aoz;

    /* renamed from: do  reason: not valid java name */
    private final String f12do;

    public String mQ() {
        return this.f12do;
    }

    public String uQ() {
        return this.aoz;
    }

    public d(JSONObject jSONObject, n nVar) {
        this.f12do = JsonUtils.getString(jSONObject, w5.x, "");
        this.aoz = JsonUtils.getString(jSONObject, "price", (String) null);
    }
}
