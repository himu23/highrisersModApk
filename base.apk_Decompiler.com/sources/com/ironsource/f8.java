package com.ironsource;

import java.util.ArrayList;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

class f8 extends c {
    private final String i = "https://outcome-ssp.supersonicads.com/mediation?adUnit=2";
    private final String j = "super.dwh.mediation_events";
    private final String k = z3.O;
    private final String l = "data";

    f8(int i2) {
        this.g = i2;
    }

    public String a() {
        return "https://outcome-ssp.supersonicads.com/mediation?adUnit=2";
    }

    public String a(ArrayList<y3> arrayList, JSONObject jSONObject) {
        JSONObject jSONObject2 = new JSONObject();
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        this.f = jSONObject;
        try {
            JSONArray jSONArray = new JSONArray();
            if (arrayList != null && !arrayList.isEmpty()) {
                Iterator<y3> it = arrayList.iterator();
                while (it.hasNext()) {
                    JSONObject a = a(it.next());
                    if (a != null) {
                        jSONArray.put(a);
                    }
                }
            }
            jSONObject2.put(z3.O, "super.dwh.mediation_events");
            jSONObject2.put("data", a(jSONArray));
            return jSONObject2.toString();
        } catch (JSONException e) {
            e.printStackTrace();
            return "";
        }
    }

    public String c() {
        return "ironbeast";
    }
}
