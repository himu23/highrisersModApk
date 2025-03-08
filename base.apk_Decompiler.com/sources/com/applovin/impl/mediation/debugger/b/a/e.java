package com.applovin.impl.mediation.debugger.b.a;

import com.applovin.impl.mediation.debugger.b.c.b;
import com.applovin.impl.sdk.n;
import com.applovin.impl.sdk.utils.JsonUtils;
import com.applovin.mediation.MaxAdFormat;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

public class e {
    private final c aoA;
    private final d aoB;
    private final List<d> aoC;

    public c uR() {
        return this.aoA;
    }

    public d uS() {
        return this.aoB;
    }

    public boolean uT() {
        return this.aoB != null;
    }

    public List<d> uU() {
        return this.aoC;
    }

    public e(JSONObject jSONObject, MaxAdFormat maxAdFormat, b bVar, n nVar) {
        JSONObject jSONObject2 = JsonUtils.getJSONObject(jSONObject, "bidder_placement", (JSONObject) null);
        if (jSONObject2 != null) {
            this.aoB = new d(jSONObject2, nVar);
        } else {
            this.aoB = null;
        }
        this.aoA = new c(JsonUtils.getString(jSONObject, "name", ""), JsonUtils.getString(jSONObject, "display_name", ""), jSONObject2 != null, bVar);
        JSONArray jSONArray = JsonUtils.getJSONArray(jSONObject, "placements", new JSONArray());
        this.aoC = new ArrayList(jSONArray.length());
        for (int i = 0; i < jSONArray.length(); i++) {
            JSONObject jSONObject3 = JsonUtils.getJSONObject(jSONArray, i, (JSONObject) null);
            if (jSONObject3 != null) {
                this.aoC.add(new d(jSONObject3, nVar));
            }
        }
    }
}
