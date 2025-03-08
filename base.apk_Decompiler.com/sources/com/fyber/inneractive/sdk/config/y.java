package com.fyber.inneractive.sdk.config;

import com.fyber.inneractive.sdk.config.enums.UnitDisplayType;
import com.fyber.inneractive.sdk.util.m0;
import org.json.JSONObject;

public class y implements m0.a {
    public UnitDisplayType a;

    public JSONObject a() {
        JSONObject jSONObject = new JSONObject();
        m0.a(jSONObject, "unitDisplayType", this.a);
        return jSONObject;
    }
}
