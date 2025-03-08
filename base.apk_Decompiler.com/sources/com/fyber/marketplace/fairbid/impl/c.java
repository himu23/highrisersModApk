package com.fyber.marketplace.fairbid.impl;

import com.fyber.inneractive.sdk.response.a;
import com.fyber.inneractive.sdk.util.IAlog;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public class c {
    public String a;
    public final a b;
    public final Map<String, String> c;

    public c(JSONObject jSONObject, a aVar, Map<String, String> map) {
        try {
            this.a = jSONObject.getJSONObject("ad").optString("markup");
        } catch (JSONException e) {
            IAlog.a("Failed extracting markup", e, new Object[0]);
        }
        this.b = aVar;
        this.c = map;
    }
}
