package com.applovin.impl.mediation.d;

import com.applovin.impl.mediation.b.c;
import com.applovin.impl.sdk.e.y;
import com.applovin.impl.sdk.n;
import com.applovin.impl.sdk.utils.JsonUtils;
import com.applovin.impl.sdk.utils.StringUtils;
import com.applovin.impl.sdk.x;
import org.json.JSONObject;

public class g extends y {
    private final c aut;

    /* access modifiers changed from: protected */
    public String zL() {
        return "2.0/mcr";
    }

    public g(c cVar, n nVar) {
        super("TaskReportMaxReward", nVar);
        this.aut = cVar;
    }

    /* access modifiers changed from: protected */
    public void x(JSONObject jSONObject) {
        JsonUtils.putString(jSONObject, "ad_unit_id", this.aut.getAdUnitId());
        JsonUtils.putString(jSONObject, "placement", this.aut.getPlacement());
        JsonUtils.putString(jSONObject, "custom_data", this.aut.yG());
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
    public com.applovin.impl.sdk.b.c yh() {
        return this.aut.yh();
    }

    /* access modifiers changed from: protected */
    public void y(JSONObject jSONObject) {
        x xVar = this.logger;
        if (x.Fn()) {
            x xVar2 = this.logger;
            String str = this.tag;
            xVar2.f(str, "Reported reward successfully for mediated ad: " + this.aut);
        }
    }

    /* access modifiers changed from: protected */
    public void gu(int i) {
        super.gu(i);
        x xVar = this.logger;
        if (x.Fn()) {
            x xVar2 = this.logger;
            String str = this.tag;
            xVar2.f(str, "Failed to report reward for mediated ad: " + this.aut + " - error code: " + i);
        }
    }

    /* access modifiers changed from: protected */
    public void zM() {
        x xVar = this.logger;
        if (x.Fn()) {
            x xVar2 = this.logger;
            String str = this.tag;
            xVar2.i(str, "No reward result was found for mediated ad: " + this.aut);
        }
    }
}
