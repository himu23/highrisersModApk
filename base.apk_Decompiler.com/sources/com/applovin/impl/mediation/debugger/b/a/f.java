package com.applovin.impl.mediation.debugger.b.a;

import com.applovin.impl.sdk.utils.JsonUtils;
import com.fyber.inneractive.sdk.external.InneractiveMediationDefs;
import java.util.List;
import org.json.JSONObject;

public class f {
    private final String aoD;
    private final String aoE;
    private final String aoF;
    private final String aoG;
    private final List<String> aoH;
    private final List<String> aoI;

    public List<String> getKeywords() {
        return this.aoI;
    }

    public String uV() {
        return this.aoD;
    }

    public String uW() {
        return this.aoE;
    }

    public String uX() {
        return this.aoF;
    }

    public String uY() {
        return this.aoG;
    }

    public List<String> uZ() {
        return this.aoH;
    }

    public f(JSONObject jSONObject) {
        this.aoD = JsonUtils.getString(jSONObject, "user_type", "all");
        this.aoE = JsonUtils.getString(jSONObject, "device_type", "all");
        this.aoF = JsonUtils.getString(jSONObject, "min_age", (String) null);
        this.aoG = JsonUtils.getString(jSONObject, "max_age", (String) null);
        this.aoH = JsonUtils.getList(jSONObject, InneractiveMediationDefs.KEY_GENDER, (List) null);
        this.aoI = JsonUtils.getList(jSONObject, "keywords", (List) null);
    }
}
