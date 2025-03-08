package com.applovin.impl.privacy.a;

import androidx.core.app.NotificationCompat;
import com.applovin.impl.sdk.n;
import com.applovin.impl.sdk.utils.AppLovinSdkExtraParameterKey;
import com.applovin.impl.sdk.utils.JsonUtils;
import com.applovin.impl.sdk.utils.StringUtils;
import com.ironsource.m2;
import com.ironsource.w5;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

public class e {
    protected final JSONObject axU;
    protected final n sdk;

    public enum a {
        NONE,
        IS_AL_GDPR
    }

    public enum b {
        ALERT,
        EVENT,
        HAS_USER_CONSENT,
        REINIT,
        CMP_LOAD,
        CMP_SHOW,
        DECISION,
        TERMS_FLOW
    }

    public e(JSONObject jSONObject, n nVar) {
        this.sdk = nVar;
        this.axU = jSONObject;
    }

    public static e g(JSONObject jSONObject, n nVar) {
        b cj = cj(JsonUtils.getString(jSONObject, "type", (String) null));
        if (cj == b.ALERT) {
            return new f(jSONObject, nVar);
        }
        if (cj == b.EVENT) {
            return new h(jSONObject, nVar);
        }
        return new e(jSONObject, nVar);
    }

    public String mQ() {
        return JsonUtils.getString(this.axU, w5.x, (String) null);
    }

    public b Ac() {
        return cj(JsonUtils.getString(this.axU, "type", (String) null));
    }

    public a Ad() {
        return ck(JsonUtils.getString(this.axU, "decision_type", (String) null));
    }

    public boolean Ae() {
        return JsonUtils.getBoolean(this.axU, "is_initial_state", false).booleanValue();
    }

    public String b(Boolean bool) {
        String string = JsonUtils.getString(this.axU, "destination_state_id", (String) null);
        if (StringUtils.isValidString(string)) {
            return string;
        }
        if (bool == null) {
            throw new IllegalStateException("Decision needed for state: " + string);
        } else if (bool.booleanValue()) {
            return JsonUtils.getString(this.axU, "destination_state_id_true", (String) null);
        } else {
            return JsonUtils.getString(this.axU, "destination_state_id_false", (String) null);
        }
    }

    private static b cj(String str) {
        if ("alert".equalsIgnoreCase(str)) {
            return b.ALERT;
        }
        if (NotificationCompat.CATEGORY_EVENT.equalsIgnoreCase(str)) {
            return b.EVENT;
        }
        if ("cmp_load".equalsIgnoreCase(str)) {
            return b.CMP_LOAD;
        }
        if ("cmp_show".equalsIgnoreCase(str)) {
            return b.CMP_SHOW;
        }
        if ("decision".equalsIgnoreCase(str)) {
            return b.DECISION;
        }
        if ("terms_flow".equalsIgnoreCase(str)) {
            return b.TERMS_FLOW;
        }
        if (AppLovinSdkExtraParameterKey.HAS_USER_CONSENT.equalsIgnoreCase(str)) {
            return b.HAS_USER_CONSENT;
        }
        if ("reinit".equalsIgnoreCase(str)) {
            return b.REINIT;
        }
        throw new IllegalArgumentException("Invalid type provided: " + str);
    }

    private static a ck(String str) {
        if ("is_al_gdpr".equalsIgnoreCase(str)) {
            return a.IS_AL_GDPR;
        }
        return a.NONE;
    }

    /* access modifiers changed from: protected */
    public String cl(String str) {
        String str2;
        JSONObject jSONObject = JsonUtils.getJSONObject(this.axU, str, (JSONObject) null);
        JSONArray jSONArray = JsonUtils.getJSONArray(jSONObject, "replacements", new JSONArray());
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < jSONArray.length(); i++) {
            String obj = JsonUtils.getObjectAtIndex(jSONArray, i, "").toString();
            if ("<APP_NAME>".equalsIgnoreCase(obj)) {
                if (this.sdk.BV() != null) {
                    str2 = this.sdk.BU().Ej().getName();
                } else {
                    str2 = (String) this.sdk.BS().CU().get("app_name");
                }
                if (StringUtils.isValidString(str2)) {
                    arrayList.add(str2);
                } else {
                    arrayList.add(n.cl("THIS_APP"));
                }
            } else {
                arrayList.add(obj);
            }
        }
        return n.b(JsonUtils.getString(jSONObject, m2.h.W, (String) null), (List<String>) arrayList);
    }

    public String toString() {
        return "ConsentFlowState{id=" + mQ() + "type=" + Ac() + "isInitialState=" + Ae() + "}";
    }
}
