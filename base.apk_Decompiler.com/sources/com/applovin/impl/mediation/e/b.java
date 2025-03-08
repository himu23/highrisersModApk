package com.applovin.impl.mediation.e;

import com.applovin.impl.sdk.c.a;
import com.applovin.impl.sdk.n;
import com.applovin.impl.sdk.utils.JsonUtils;
import com.applovin.impl.sdk.utils.i;
import com.ironsource.mediationsdk.d;
import org.json.JSONObject;

public class b extends i {
    private static final String[] axg = {"ads", d.f, "auto_init_adapters", "test_mode_idfas", "test_mode_auto_init_adapters", "ad_unit_signal_providers"};
    private static final String[] axh = {"ads", d.f, "signal_providers", "ad_unit_signal_providers"};

    public static void z(JSONObject jSONObject) {
    }

    public static void d(JSONObject jSONObject, n nVar) {
        if (JsonUtils.valueExists(jSONObject, "signal_providers")) {
            JSONObject shallowCopy = JsonUtils.shallowCopy(jSONObject);
            JsonUtils.removeObjectsForKeys(shallowCopy, axg);
            nVar.a(com.applovin.impl.sdk.c.d.aRK, shallowCopy.toString());
            com.applovin.impl.mediation.d.b.p(shallowCopy);
        }
    }

    public static void e(JSONObject jSONObject, n nVar) {
        if (JsonUtils.valueExists(jSONObject, "ad_unit_signal_providers")) {
            com.applovin.impl.mediation.d.b.c(jSONObject, nVar);
        }
    }

    public static void f(JSONObject jSONObject, n nVar) {
        if (jSONObject.length() != 0) {
            if (JsonUtils.valueExists(jSONObject, "auto_init_adapters") || JsonUtils.valueExists(jSONObject, "test_mode_auto_init_adapters")) {
                JSONObject shallowCopy = JsonUtils.shallowCopy(jSONObject);
                JsonUtils.removeObjectsForKeys(shallowCopy, axh);
                nVar.a(com.applovin.impl.sdk.c.d.aRL, shallowCopy.toString());
                return;
            }
            nVar.b(com.applovin.impl.sdk.c.d.aRL);
        }
    }

    public static String b(n nVar) {
        return i.a((String) nVar.a(a.aJg), "1.0/mediate", nVar);
    }

    public static String c(n nVar) {
        return i.a((String) nVar.a(a.aJh), "1.0/mediate", nVar);
    }

    public static String d(n nVar) {
        return i.a((String) nVar.a(a.aJg), "1.0/mediate_debug", nVar);
    }

    public static String e(n nVar) {
        return i.a((String) nVar.a(a.aJh), "1.0/mediate_debug", nVar);
    }
}
