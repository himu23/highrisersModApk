package com.fyber.inneractive.sdk.cache.session;

import com.applovin.sdk.AppLovinEventTypes;
import com.fyber.inneractive.sdk.cache.session.enums.b;
import com.ironsource.m2;
import com.unity3d.services.core.device.MimeTypes;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

public class f {
    public HashMap<b, e> a = new a(this);

    public class a extends HashMap<b, e> {
        public a(f fVar) {
            for (b bVar : b.values()) {
                if (bVar != b.NONE) {
                    put(bVar, new e());
                }
            }
        }
    }

    public JSONObject a() {
        JSONObject jSONObject = new JSONObject();
        try {
            JSONArray jSONArray = new JSONArray();
            for (Map.Entry next : this.a.entrySet()) {
                b bVar = (b) next.getKey();
                try {
                    JSONObject jSONObject2 = new JSONObject();
                    jSONObject2.put("type", bVar.e().value());
                    jSONObject2.put("subType", bVar.name().toLowerCase().contains(MimeTypes.BASE_TYPE_VIDEO) ? MimeTypes.BASE_TYPE_VIDEO : m2.h.d);
                    jSONObject2.put("session_data", ((e) next.getValue()).a(true, true));
                    jSONArray.put(jSONObject2);
                } catch (Exception unused) {
                }
            }
            jSONObject.put(AppLovinEventTypes.USER_VIEWED_CONTENT, jSONArray);
        } catch (Exception unused2) {
        }
        return jSONObject;
    }
}
