package com.fyber.inneractive.sdk.config;

import java.util.HashMap;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

public class i {
    public final Map<String, String> a = new HashMap();
    public final Map<String, h> b = new HashMap();

    public static i a(JSONObject jSONObject) {
        i iVar = new i();
        JSONObject optJSONObject = jSONObject.optJSONObject("params");
        JSONObject optJSONObject2 = jSONObject.optJSONObject("overrides");
        JSONArray names = optJSONObject.names();
        for (int i = 0; i < names.length(); i++) {
            String optString = names.optString(i, (String) null);
            String optString2 = optJSONObject.optString(optString, (String) null);
            if (!(optString == null || optString2 == null)) {
                iVar.a.put(optString, optString2);
            }
        }
        if (optJSONObject2 != null) {
            JSONArray names2 = optJSONObject2.names();
            for (int i2 = 0; i2 < names2.length(); i2++) {
                String optString3 = names2.optString(i2, (String) null);
                JSONObject optJSONObject3 = optJSONObject2.optJSONObject(optString3);
                if (!(optString3 == null || optJSONObject3 == null)) {
                    iVar.b.put(optString3, new h(optJSONObject3));
                }
            }
        }
        return iVar;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || i.class != obj.getClass()) {
            return false;
        }
        i iVar = (i) obj;
        if (!this.a.equals(iVar.a) || !this.b.equals(iVar.b)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        return this.a.hashCode();
    }

    public int a(String str, int i, int i2) {
        String num = Integer.toString(i);
        if (this.a.containsKey(str)) {
            num = this.a.get(str);
        }
        try {
            i = Integer.parseInt(num);
        } catch (Throwable unused) {
        }
        return Math.max(i, i2);
    }

    public boolean a(String str, boolean z) {
        String bool = Boolean.toString(z);
        if (this.a.containsKey(str)) {
            bool = this.a.get(str);
        }
        try {
            return Boolean.parseBoolean(bool);
        } catch (Throwable unused) {
            return z;
        }
    }

    public g a(String str) {
        h hVar;
        String str2 = IAConfigManager.M.d;
        if (this.b.containsKey(str2)) {
            hVar = this.b.get(str2);
        } else {
            hVar = new h();
        }
        hVar.getClass();
        return hVar.a.containsKey(str) ? hVar.a.get(str) : new g();
    }
}
