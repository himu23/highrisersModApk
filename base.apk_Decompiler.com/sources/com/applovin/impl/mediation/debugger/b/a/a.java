package com.applovin.impl.mediation.debugger.b.a;

import com.applovin.impl.mediation.debugger.b.c.b;
import com.applovin.impl.sdk.n;
import com.applovin.impl.sdk.utils.JsonUtils;
import com.applovin.mediation.MaxAdFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

public class a implements Comparable<a> {
    private final b aop;
    private final List<b> aoq;

    /* renamed from: do  reason: not valid java name */
    private final String f11do;
    private final MaxAdFormat format;
    private final String name;

    public MaxAdFormat getFormat() {
        return this.format;
    }

    public String getName() {
        return this.name;
    }

    public String mQ() {
        return this.f11do;
    }

    public b uG() {
        return this.aop;
    }

    public List<b> uH() {
        return this.aoq;
    }

    public a(JSONObject jSONObject, Map<String, b> map, n nVar) {
        this.f11do = JsonUtils.getString(jSONObject, "name", "");
        this.name = JsonUtils.getString(jSONObject, "display_name", "");
        b bVar = null;
        this.format = MaxAdFormat.formatFromString(JsonUtils.getString(jSONObject, "format", (String) null));
        JSONArray jSONArray = JsonUtils.getJSONArray(jSONObject, "waterfalls", new JSONArray());
        this.aoq = new ArrayList(jSONArray.length());
        for (int i = 0; i < jSONArray.length(); i++) {
            JSONObject jSONObject2 = JsonUtils.getJSONObject(jSONArray, i, (JSONObject) null);
            if (jSONObject2 != null) {
                this.aoq.add(new b(jSONObject2, map, this.format, nVar));
            }
        }
        this.aop = !this.aoq.isEmpty() ? this.aoq.get(0) : bVar;
    }

    public String tG() {
        MaxAdFormat maxAdFormat = this.format;
        return maxAdFormat != null ? maxAdFormat.getLabel() : "Unknown";
    }

    public String uI() {
        return "\n---------- " + this.name + " ----------\nIdentifier - " + this.f11do + "\nFormat     - " + tG();
    }

    /* renamed from: a */
    public int compareTo(a aVar) {
        return this.name.compareToIgnoreCase(aVar.name);
    }
}
