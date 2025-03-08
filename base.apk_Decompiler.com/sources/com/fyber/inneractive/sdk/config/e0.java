package com.fyber.inneractive.sdk.config;

import com.fyber.inneractive.sdk.config.enums.Vendor;
import com.fyber.inneractive.sdk.util.m0;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONObject;

public class e0 implements m0.a {
    public Integer a = 50;
    public Integer b = 50;
    public Set<Vendor> c = null;

    public JSONObject a() {
        JSONObject jSONObject = new JSONObject();
        m0.a(jSONObject, "pausePct", this.a);
        m0.a(jSONObject, "playPct", this.b);
        JSONArray jSONArray = new JSONArray();
        Set<Vendor> set = this.c;
        if (set != null) {
            for (Vendor next : set) {
                if (next != null) {
                    jSONArray.put(next);
                }
            }
        }
        m0.a(jSONObject, "vendor", jSONArray);
        return jSONObject;
    }

    public Integer b() {
        return this.b;
    }

    public Set<Vendor> c() {
        return this.c;
    }
}
