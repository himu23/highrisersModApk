package com.ironsource.sdk.controller;

import com.ironsource.l8;
import com.ironsource.sdk.controller.u;
import org.json.JSONObject;

public class l {
    private u.v.e0 a;

    public l(u.v.e0 e0Var) {
        this.a = e0Var;
    }

    public void a(l8 l8Var, JSONObject jSONObject) {
        this.a.a(false, l8Var.a(), jSONObject);
    }

    public void b(l8 l8Var, JSONObject jSONObject) {
        this.a.a(true, l8Var.d(), jSONObject);
    }
}
