package com.fyber.inneractive.sdk.config;

import com.fyber.inneractive.sdk.config.enums.Track;
import com.fyber.inneractive.sdk.util.m0;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONObject;

public class x implements m0.a {
    public Set<Track> a = null;

    public JSONObject a() {
        JSONObject jSONObject = new JSONObject();
        JSONArray jSONArray = new JSONArray();
        Set<Track> set = this.a;
        if (set != null) {
            for (Track put : set) {
                jSONArray.put(put);
            }
        }
        m0.a(jSONObject, "track", jSONArray);
        return jSONObject;
    }
}
