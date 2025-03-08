package com.applovin.impl.privacy.a;

import androidx.core.app.NotificationCompat;
import com.applovin.impl.sdk.n;
import com.applovin.impl.sdk.utils.JsonUtils;
import com.ironsource.m2;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

public class g {
    private final JSONObject axU;
    private final n sdk;

    public enum a {
        NEUTRAL,
        POSITIVE,
        NEGATIVE
    }

    public static g h(JSONObject jSONObject, n nVar) {
        String string = JsonUtils.getString(JsonUtils.getJSONObject(jSONObject, m2.h.D0, (JSONObject) null), m2.h.W, (String) null);
        if ("TOS".equalsIgnoreCase(string) && nVar.Cl().getTermsOfServiceUri() == null) {
            return null;
        }
        if (!"PP".equalsIgnoreCase(string) || nVar.Cl().getPrivacyPolicyUri() != null) {
            return new g(jSONObject, nVar);
        }
        return null;
    }

    private g(JSONObject jSONObject, n nVar) {
        this.sdk = nVar;
        this.axU = jSONObject;
    }

    public String getTitle() {
        JSONObject jSONObject = JsonUtils.getJSONObject(this.axU, m2.h.D0, (JSONObject) null);
        return n.b(JsonUtils.getString(jSONObject, m2.h.W, ""), (List<String>) JsonUtils.optList(JsonUtils.getJSONArray(jSONObject, "replacements", (JSONArray) null), (List) null));
    }

    public a Ag() {
        String string = JsonUtils.getString(this.axU, "style", (String) null);
        if ("default".equalsIgnoreCase(string)) {
            return a.POSITIVE;
        }
        if ("destructive".equalsIgnoreCase(string) || "cancel".equalsIgnoreCase(string)) {
            return a.NEGATIVE;
        }
        return a.NEUTRAL;
    }

    public String Ah() {
        return JsonUtils.getString(this.axU, "destination_state_id", (String) null);
    }

    public String Ai() {
        return JsonUtils.getString(this.axU, NotificationCompat.CATEGORY_EVENT, (String) null);
    }

    public String toString() {
        return "ConsentFlowStateAlertAction{title=" + getTitle() + "destinationStateId=" + Ah() + "event=" + Ai() + "}";
    }
}
