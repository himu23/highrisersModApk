package com.applovin.impl.sdk.e;

import com.applovin.impl.sdk.ad.e;
import com.applovin.impl.sdk.b.c;
import com.applovin.impl.sdk.n;
import com.applovin.impl.sdk.utils.JsonUtils;
import com.applovin.impl.sdk.utils.StringUtils;
import org.json.JSONObject;

public class x extends y {
    private final e aiL;

    /* access modifiers changed from: protected */
    public String zL() {
        return "2.0/cr";
    }

    public x(e eVar, n nVar) {
        super("TaskReportAppLovinReward", nVar);
        this.aiL = eVar;
    }

    /* access modifiers changed from: protected */
    public void x(JSONObject jSONObject) {
        JsonUtils.putString(jSONObject, "zone_id", this.aiL.getAdZone().mQ());
        JsonUtils.putInt(jSONObject, "fire_percent", this.aiL.GU());
        String clCode = this.aiL.getClCode();
        if (!StringUtils.isValidString(clCode)) {
            clCode = "NO_CLCODE";
        }
        JsonUtils.putString(jSONObject, "clcode", clCode);
    }

    /* access modifiers changed from: protected */
    public c yh() {
        return this.aiL.yh();
    }

    /* access modifiers changed from: protected */
    public void y(JSONObject jSONObject) {
        com.applovin.impl.sdk.x xVar = this.logger;
        if (com.applovin.impl.sdk.x.Fn()) {
            com.applovin.impl.sdk.x xVar2 = this.logger;
            String str = this.tag;
            xVar2.f(str, "Reported reward successfully for ad: " + this.aiL);
        }
    }

    /* access modifiers changed from: protected */
    public void gu(int i) {
        super.gu(i);
        com.applovin.impl.sdk.x xVar = this.logger;
        if (com.applovin.impl.sdk.x.Fn()) {
            com.applovin.impl.sdk.x xVar2 = this.logger;
            String str = this.tag;
            xVar2.i(str, "Failed to report reward for ad: " + this.aiL + " - error code: " + i);
        }
    }

    /* access modifiers changed from: protected */
    public void zM() {
        com.applovin.impl.sdk.x xVar = this.logger;
        if (com.applovin.impl.sdk.x.Fn()) {
            com.applovin.impl.sdk.x xVar2 = this.logger;
            String str = this.tag;
            xVar2.i(str, "No reward result was found for ad: " + this.aiL);
        }
    }
}
