package com.applovin.impl.privacy.a;

import com.applovin.impl.sdk.n;
import com.applovin.impl.sdk.utils.JsonUtils;
import java.util.Map;
import org.json.JSONObject;

public class h extends e {
    private Map<String, String> ayl;

    public Map<String, String> Aj() {
        return this.ayl;
    }

    public h(JSONObject jSONObject, n nVar) {
        super(jSONObject, nVar);
    }

    public String getName() {
        return JsonUtils.getString(this.axU, "name", (String) null);
    }

    public String toString() {
        return "ConsentFlowState{id=" + mQ() + "type=" + Ac() + "isInitialState=" + Ae() + "name=" + getName() + "}";
    }
}
