package com.applovin.impl.privacy.b;

import com.applovin.impl.sdk.n;
import com.applovin.impl.sdk.utils.JsonUtils;
import com.applovin.sdk.AppLovinPrivacySettings;
import com.ironsource.w5;
import org.json.JSONObject;

public class c {
    private final String aow;
    private final a ayE;
    private final Integer ayF;
    private final String ayG;
    private Boolean ayH;

    public enum a {
        TCF_VENDOR,
        ATP_NETWORK,
        OTHER;

        /* access modifiers changed from: private */
        public static a gv(int i) {
            return i != 0 ? i != 1 ? OTHER : ATP_NETWORK : TCF_VENDOR;
        }
    }

    public a Av() {
        return this.ayE;
    }

    public Integer Aw() {
        return this.ayF;
    }

    public String Ax() {
        return this.ayG;
    }

    public Boolean Ay() {
        return this.ayH;
    }

    public void c(Boolean bool) {
        this.ayH = bool;
    }

    public String getDisplayName() {
        return this.aow;
    }

    public c(JSONObject jSONObject, String str) {
        this.aow = str;
        this.ayE = a.gv(JsonUtils.getInt(jSONObject, "type", a.OTHER.ordinal()));
        this.ayF = JsonUtils.getInteger(jSONObject, w5.x, (Integer) null);
        this.ayG = JsonUtils.getString(jSONObject, "name", (String) null);
    }

    public String uI() {
        Boolean bool = this.ayH;
        boolean booleanValue = bool != null ? bool.booleanValue() : AppLovinPrivacySettings.hasUserConsent(n.getApplicationContext());
        return "\n" + this.aow + " - " + booleanValue;
    }
}
