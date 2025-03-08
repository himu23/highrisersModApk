package com.ironsource;

import com.ironsource.sdk.utils.SDKUtils;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public class q7 {
    private String a;
    private boolean b = false;
    private boolean c = false;
    private v5 d = null;
    private Map<String, String> e;
    private final r9 f;
    private boolean g;

    public q7(String str, r9 r9Var) throws NullPointerException {
        this.a = SDKUtils.requireNonEmptyOrNull(str, "Instance name can't be null");
        this.f = (r9) SDKUtils.requireNonNull(r9Var, "AdListener name can't be null");
    }

    public p7 a() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("name", this.a);
            jSONObject.put("rewarded", this.b);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        return new p7((this.c || this.g) ? y7.a() : y7.a(jSONObject), this.a, this.b, this.c, this.g, this.e, this.f, this.d);
    }

    public q7 a(v5 v5Var) {
        this.d = v5Var;
        return this;
    }

    public q7 a(Map<String, String> map) {
        this.e = map;
        return this;
    }

    public q7 a(boolean z) {
        this.c = z;
        return this;
    }

    public q7 b() {
        this.b = true;
        return this;
    }

    public q7 b(boolean z) {
        this.g = z;
        return this;
    }
}
