package com.ironsource;

import android.content.Context;
import android.text.TextUtils;
import com.ironsource.mediationsdk.IronSource;
import com.ironsource.mediationsdk.WaterfallConfiguration;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public class w7 {
    x4 a = new x4();

    public void a(int i) {
        this.a.a(t4.V, (Object) Integer.valueOf(i));
    }

    public void a(Context context) {
        this.a.a(context);
    }

    public void a(m5 m5Var) {
        try {
            HashMap hashMap = new HashMap();
            hashMap.put(t4.w, m5Var.a());
            hashMap.put(t4.v, m5Var.b());
            hashMap.put(t4.J, m5Var.c());
            this.a.a((Map<String, Object>) hashMap);
        } catch (Exception unused) {
        }
    }

    public void a(IronSource.AD_UNIT ad_unit, WaterfallConfiguration waterfallConfiguration) {
        JSONObject jSONObject = new JSONObject();
        if (waterfallConfiguration != null) {
            try {
                jSONObject.put(t4.T0, waterfallConfiguration.getFloor());
                jSONObject.put(t4.U0, waterfallConfiguration.getCeiling());
            } catch (JSONException unused) {
            }
        }
        if (jSONObject.length() == 0) {
            this.a.a(t4.S0, d0.a(ad_unit));
        } else {
            this.a.a(t4.S0, jSONObject, d0.a(ad_unit));
        }
    }

    public void a(Boolean bool) {
        this.a.a(t4.u0, (Object) bool);
    }

    public void a(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.a.a(t4.r0, (Object) str);
        }
    }

    public void a(JSONObject jSONObject) {
        this.a.a(t4.r, (Object) jSONObject);
    }

    public void a(boolean z) {
        this.a.a(t4.t0, (Object) Boolean.valueOf(z));
    }

    public void b(int i) {
        this.a.a(t4.T, (Object) Integer.valueOf(i));
    }

    public void b(String str) {
        this.a.a(t4.n0, (Object) str);
    }

    public void b(JSONObject jSONObject) {
        this.a.a(t4.F0, (Object) jSONObject);
    }

    public void b(boolean z) {
        this.a.a("gpi", (Object) Boolean.valueOf(z));
    }

    public void c(String str) {
        this.a.a(t4.p0, (Object) str);
    }

    public void d(String str) {
        this.a.a("mt", (Object) str);
    }

    public void e(String str) {
        this.a.a(t4.t, (Object) str);
    }

    public void f(String str) {
        this.a.a(t4.B, (Object) str);
    }

    public void g(String str) {
        this.a.a(t4.D0, (Object) str);
    }

    public void h(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.a.a(t4.S, (Object) str);
        }
    }
}
