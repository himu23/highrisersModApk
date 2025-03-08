package com.applovin.impl.privacy.a;

import com.applovin.impl.sdk.n;
import com.applovin.impl.sdk.utils.JsonUtils;
import com.ironsource.m2;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

public class f extends e {
    public f(JSONObject jSONObject, n nVar) {
        super(jSONObject, nVar);
    }

    public String getTitle() {
        return cl(m2.h.D0);
    }

    public String getMessage() {
        return cl("message");
    }

    public List<g> Af() {
        g h;
        JSONArray jSONArray = JsonUtils.getJSONArray(this.axU, "transitions", (JSONArray) null);
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < jSONArray.length(); i++) {
            JSONObject jSONObject = JsonUtils.getJSONObject(jSONArray, i, (JSONObject) null);
            if (!(jSONObject == null || (h = g.h(jSONObject, this.sdk)) == null)) {
                arrayList.add(h);
            }
        }
        return arrayList;
    }

    public String toString() {
        return "ConsentFlowState{id=" + mQ() + "type=" + Ac() + "isInitialState=" + Ae() + "title=" + getTitle() + "message=" + getMessage() + "actions=" + Af() + "}";
    }
}
