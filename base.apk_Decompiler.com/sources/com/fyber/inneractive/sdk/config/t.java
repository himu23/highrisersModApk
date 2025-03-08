package com.fyber.inneractive.sdk.config;

import com.fyber.inneractive.sdk.config.enums.UnitDisplayType;
import com.fyber.inneractive.sdk.util.m0;
import org.json.JSONObject;

public class t implements m0.a {
    public Integer a = null;
    public UnitDisplayType b;
    public Boolean c;
    public Integer d;

    public JSONObject a() {
        JSONObject jSONObject = new JSONObject();
        m0.a(jSONObject, "refresh", this.a);
        m0.a(jSONObject, "unitDisplayType", this.b);
        m0.a(jSONObject, "close", this.c);
        m0.a(jSONObject, "hideDelay", this.d);
        return jSONObject;
    }
}
