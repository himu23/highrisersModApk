package com.ironsource;

import com.ironsource.m2;
import org.json.JSONException;
import org.json.JSONObject;

public class l8 {
    private String a;
    private JSONObject b;
    private String c;
    private String d;

    public l8(JSONObject jSONObject) {
        this.a = jSONObject.optString(m2.f.b);
        this.b = jSONObject.optJSONObject(m2.f.c);
        this.c = jSONObject.optString("success");
        this.d = jSONObject.optString(m2.f.e);
    }

    public String a() {
        return this.d;
    }

    public String b() {
        return this.a;
    }

    public JSONObject c() {
        return this.b;
    }

    public String d() {
        return this.c;
    }

    public JSONObject e() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(m2.f.b, this.a);
            jSONObject.put(m2.f.c, this.b);
            jSONObject.put("success", this.c);
            jSONObject.put(m2.f.e, this.d);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jSONObject;
    }
}
