package com.ironsource;

import org.json.JSONObject;

public class q2 {
    private String a;
    private JSONObject b;
    private String c;
    private String d;

    public q2(String str) {
        this.a = str;
    }

    public q2(String str, String str2, String str3) {
        this.a = str;
        this.c = str2;
        this.d = str3;
    }

    public q2(String str, JSONObject jSONObject) {
        this.a = str;
        this.b = jSONObject;
    }

    public q2(String str, JSONObject jSONObject, String str2, String str3) {
        this.a = str;
        this.b = jSONObject;
        this.c = str2;
        this.d = str3;
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
}
