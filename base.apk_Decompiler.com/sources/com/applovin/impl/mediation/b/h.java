package com.applovin.impl.mediation.b;

import com.applovin.impl.sdk.n;
import java.util.Map;
import org.json.JSONObject;

public class h extends f {
    public h(Map<String, Object> map, JSONObject jSONObject, JSONObject jSONObject2, n nVar) {
        super(map, jSONObject, jSONObject2, nVar);
    }

    public boolean yK() {
        return b("only_collect_signal_when_initialized", (Boolean) false).booleanValue();
    }

    public boolean yL() {
        return b("use_cached_adapter", (Boolean) true).booleanValue();
    }

    public String toString() {
        return "SignalProviderSpec{adObject=" + yz() + '}';
    }
}
