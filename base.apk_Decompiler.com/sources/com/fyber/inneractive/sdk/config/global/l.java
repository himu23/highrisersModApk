package com.fyber.inneractive.sdk.config.global;

import com.fyber.inneractive.sdk.util.IAlog;
import com.ironsource.w5;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

public class l {
    public final Map<String, q> a = new HashMap();

    public q a(String str) {
        return this.a.get(str);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || l.class != obj.getClass()) {
            return false;
        }
        return this.a.equals(((l) obj).a);
    }

    public int hashCode() {
        return this.a.hashCode();
    }

    public String toString() {
        return String.format("remoteConfig - features: %s", new Object[]{this.a.values()});
    }

    public static l a(JSONObject jSONObject) throws Exception {
        l lVar = new l();
        JSONArray optJSONArray = jSONObject.optJSONArray("features");
        char c = 0;
        int i = 0;
        while (i < optJSONArray.length()) {
            JSONObject jSONObject2 = optJSONArray.getJSONObject(i);
            q qVar = new q();
            qVar.b = jSONObject2.getString(w5.x);
            JSONObject optJSONObject = jSONObject2.optJSONObject("params");
            if (optJSONObject != null) {
                qVar.a = new o(optJSONObject);
            } else {
                Object[] objArr = new Object[1];
                objArr[c] = qVar.b;
                IAlog.a("RemoteFeature fromJson. feature %s has no params!", objArr);
            }
            JSONArray optJSONArray2 = jSONObject2.optJSONArray("experiments");
            if (optJSONArray2 != null) {
                for (int i2 = 0; i2 < optJSONArray2.length(); i2++) {
                    JSONObject jSONObject3 = optJSONArray2.getJSONObject(i2);
                    b bVar = new b();
                    bVar.a = jSONObject3.getString(w5.x);
                    bVar.b = jSONObject3.optInt("perc", 10);
                    JSONArray jSONArray = jSONObject3.getJSONArray("variants");
                    for (int i3 = 0; i3 < jSONArray.length(); i3++) {
                        JSONObject jSONObject4 = jSONArray.getJSONObject(i3);
                        k kVar = new k();
                        kVar.b = jSONObject4.getString(w5.x);
                        kVar.c = jSONObject4.getInt("perc");
                        JSONObject optJSONObject2 = jSONObject4.optJSONObject("params");
                        if (optJSONObject2 != null) {
                            kVar.a = new o(optJSONObject2);
                        }
                        bVar.c.add(kVar);
                    }
                    b.a(bVar, jSONObject3.optJSONObject("include"), true);
                    b.a(bVar, jSONObject3.optJSONObject("exclude"), false);
                    qVar.c.put(bVar.a, bVar);
                }
            }
            lVar.a.put(qVar.b, qVar);
            i++;
            c = 0;
        }
        return lVar;
    }
}
