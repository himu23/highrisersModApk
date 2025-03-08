package com.ironsource;

import com.ironsource.m2;
import org.json.JSONObject;

public class ob {
    private final JSONObject a;

    public ob(JSONObject jSONObject) {
        this.a = jSONObject == null ? new JSONObject() : jSONObject;
    }

    public boolean a() {
        return this.a.optBoolean("uxt", false);
    }

    public boolean b() {
        return this.a.optBoolean(m2.a.m, false);
    }

    public boolean c() {
        return this.a.optBoolean(m2.a.n, false);
    }

    public boolean d() {
        return this.a.optBoolean(m2.a.j, false);
    }

    public boolean e() {
        return this.a.optBoolean(m2.a.l, false);
    }
}
