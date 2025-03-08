package com.applovin.impl.mediation.d;

import com.applovin.impl.mediation.b.c;
import com.applovin.impl.sdk.e.ad;
import com.applovin.impl.sdk.n;
import com.applovin.impl.sdk.utils.JsonUtils;
import com.applovin.impl.sdk.utils.StringUtils;
import org.json.JSONObject;

public class h extends ad {
    private final c aut;

    /* access modifiers changed from: protected */
    public String zL() {
        return "2.0/mvr";
    }

    public h(c cVar, n nVar) {
        super("TaskValidateMaxReward", nVar);
        this.aut = cVar;
    }

    /* access modifiers changed from: protected */
    public void x(JSONObject jSONObject) {
        JsonUtils.putString(jSONObject, "ad_unit_id", this.aut.getAdUnitId());
        JsonUtils.putString(jSONObject, "placement", this.aut.getPlacement());
        JsonUtils.putString(jSONObject, "custom_data", this.aut.yG());
        JsonUtils.putString(jSONObject, "ad_format", this.aut.getFormat().getLabel());
        String ye = this.aut.ye();
        if (!StringUtils.isValidString(ye)) {
            ye = "NO_MCODE";
        }
        JsonUtils.putString(jSONObject, "mcode", ye);
        String xs = this.aut.xs();
        if (!StringUtils.isValidString(xs)) {
            xs = "NO_BCODE";
        }
        JsonUtils.putString(jSONObject, "bcode", xs);
    }

    /* access modifiers changed from: protected */
    public void b(com.applovin.impl.sdk.b.c cVar) {
        this.aut.a(cVar);
    }

    /* access modifiers changed from: protected */
    public void gu(int i) {
        super.gu(i);
        this.aut.a(com.applovin.impl.sdk.b.c.dn((i < 400 || i >= 500) ? "network_timeout" : "rejected"));
    }

    /* access modifiers changed from: protected */
    public boolean zN() {
        return this.aut.yf();
    }
}
