package com.ironsource;

import com.ironsource.mediationsdk.e;
import java.net.URL;
import org.json.JSONObject;

public class c1 extends e.a {
    public c1(t0 t0Var, URL url, JSONObject jSONObject, boolean z, int i, long j, boolean z2, boolean z3, int i2) {
        super(t0Var, url, jSONObject, z, i, j, z2, z3, i2);
    }

    /* access modifiers changed from: protected */
    public void a(boolean z, t0 t0Var, long j) {
        if (z) {
            try {
                ((y0) t0Var).a(this.b, this.f + 1, j, this.j, this.i);
            } catch (Exception e) {
                t0Var.a(1009, e.getMessage(), this.f + 1, this.g, j);
            }
        } else {
            t0Var.a(this.c, this.d, this.f + 1, this.g, j);
        }
    }
}
