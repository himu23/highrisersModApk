package com.fyber.inneractive.sdk.config;

import com.fyber.inneractive.sdk.config.enums.Orientation;
import com.fyber.inneractive.sdk.config.enums.Skip;
import com.fyber.inneractive.sdk.config.enums.TapAction;
import com.fyber.inneractive.sdk.config.enums.UnitDisplayType;
import com.fyber.inneractive.sdk.util.m0;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

public class c0 implements d0, m0.a {
    public Boolean a;
    public Integer b = 5000;
    public Integer c = 0;
    public Boolean d;
    public Orientation e;
    public Integer f;
    public Integer g;
    public Skip h;
    public TapAction i;
    public UnitDisplayType j;
    public List<Integer> k;

    public c0() {
        Boolean bool = Boolean.TRUE;
        this.a = bool;
        this.d = bool;
        this.f = 0;
        this.g = 2048;
        this.h = Skip.fromValue(0);
        this.k = new ArrayList();
    }

    public JSONObject a() {
        JSONObject jSONObject = new JSONObject();
        m0.a(jSONObject, "autoPlay", this.a);
        m0.a(jSONObject, "maxBitrate", this.b);
        m0.a(jSONObject, "minBitrate", this.c);
        m0.a(jSONObject, "muted", this.d);
        m0.a(jSONObject, "orientation", this.e);
        m0.a(jSONObject, "padding", this.f);
        m0.a(jSONObject, "pivotBitrate", this.g);
        m0.a(jSONObject, "skip", this.h);
        m0.a(jSONObject, "tapAction", this.i);
        m0.a(jSONObject, "unitDisplayType", this.j);
        JSONArray jSONArray = new JSONArray();
        List<Integer> list = this.k;
        if (list != null) {
            for (Integer next : list) {
                if (next != null) {
                    jSONArray.put(next);
                }
            }
        }
        m0.a(jSONObject, "filterApi", jSONArray);
        return jSONObject;
    }

    public Boolean b() {
        return this.a;
    }
}
