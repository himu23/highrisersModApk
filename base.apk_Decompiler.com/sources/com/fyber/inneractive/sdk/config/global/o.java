package com.fyber.inneractive.sdk.config.global;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public class o implements n {
    public JSONObject a;

    public o(JSONObject jSONObject) {
        this.a = jSONObject;
    }

    public Double a(String str) {
        return Double.valueOf(this.a.optDouble(str, 0.0d));
    }

    public Integer b(String str) {
        if (this.a.has(str)) {
            try {
                return Integer.valueOf(this.a.getInt(str));
            } catch (JSONException unused) {
            }
        }
        return null;
    }

    public String c(String str) {
        if (this.a.has(str)) {
            try {
                return this.a.getString(str);
            } catch (JSONException unused) {
            }
        }
        return null;
    }

    public Boolean d(String str) {
        if (this.a.has(str)) {
            try {
                return Boolean.valueOf(this.a.getBoolean(str));
            } catch (JSONException unused) {
            }
        }
        return null;
    }

    public String toString() {
        JSONObject jSONObject = this.a;
        return jSONObject != null ? jSONObject.toString() : "no params";
    }

    public String a(String str, String str2) {
        return this.a.optString(str, str2);
    }

    public Map<String, Object> a() {
        HashMap hashMap = new HashMap();
        Iterator<String> keys = this.a.keys();
        while (keys.hasNext()) {
            String next = keys.next();
            try {
                hashMap.put(next, this.a.get(next));
            } catch (Exception unused) {
            }
        }
        return hashMap;
    }
}
