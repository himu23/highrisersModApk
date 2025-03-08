package com.applovin.impl.sdk.e;

import com.applovin.impl.sdk.ad.e;
import com.applovin.impl.sdk.b.c;
import com.applovin.impl.sdk.n;
import com.applovin.impl.sdk.utils.JsonUtils;
import com.applovin.impl.sdk.utils.StringUtils;
import com.applovin.sdk.AppLovinAdRewardListener;
import com.applovin.sdk.AppLovinErrorCodes;
import java.util.Collections;
import java.util.Map;
import org.json.JSONObject;

public class ac extends ad {
    private final AppLovinAdRewardListener aIY;
    private final e aiL;

    public String zL() {
        return "2.0/vr";
    }

    public ac(e eVar, AppLovinAdRewardListener appLovinAdRewardListener, n nVar) {
        super("TaskValidateAppLovinReward", nVar);
        this.aiL = eVar;
        this.aIY = appLovinAdRewardListener;
    }

    /* access modifiers changed from: protected */
    public void x(JSONObject jSONObject) {
        JsonUtils.putString(jSONObject, "zone_id", this.aiL.getAdZone().mQ());
        String clCode = this.aiL.getClCode();
        if (!StringUtils.isValidString(clCode)) {
            clCode = "NO_CLCODE";
        }
        JsonUtils.putString(jSONObject, "clcode", clCode);
    }

    /* access modifiers changed from: protected */
    public void b(c cVar) {
        this.aiL.a(cVar);
        String JC = cVar.JC();
        Map<String, String> JB = cVar.JB();
        if (JC.equals("accepted")) {
            this.aIY.userRewardVerified(this.aiL, JB);
        } else if (JC.equals("quota_exceeded")) {
            this.aIY.userOverQuota(this.aiL, JB);
        } else if (JC.equals("rejected")) {
            this.aIY.userRewardRejected(this.aiL, JB);
        } else {
            this.aIY.validationRequestFailed(this.aiL, AppLovinErrorCodes.INCENTIVIZED_UNKNOWN_SERVER_ERROR);
        }
    }

    /* access modifiers changed from: protected */
    public void gu(int i) {
        String str;
        super.gu(i);
        if (i < 400 || i >= 500) {
            this.aIY.validationRequestFailed(this.aiL, i);
            str = "network_timeout";
        } else {
            this.aIY.userRewardRejected(this.aiL, Collections.emptyMap());
            str = "rejected";
        }
        this.aiL.a(c.dn(str));
    }

    /* access modifiers changed from: protected */
    public boolean zN() {
        return this.aiL.yf();
    }
}
