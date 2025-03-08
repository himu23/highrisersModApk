package com.fyber.inneractive.sdk.model.vast;

import com.applovin.sdk.AppLovinEventTypes;
import com.fyber.inneractive.sdk.response.i;
import com.fyber.inneractive.sdk.util.IAlog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public class c implements i {
    public h a;
    public i b;
    public int c;
    public int d;
    public String e;
    public String f;
    public String g;
    public Map<t, List<String>> h = new HashMap();

    public c(h hVar, int i, int i2, String str) {
        this.a = hVar;
        this.c = i;
        this.d = i2;
        this.e = str;
    }

    public void a(t tVar, String str) {
        List list = this.h.get(tVar);
        if (list == null) {
            list = new ArrayList();
            this.h.put(tVar, list);
        }
        list.add(str);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("Companion:  w:");
        sb.append(this.c);
        sb.append(" h:");
        sb.append(this.d);
        sb.append(" type:");
        sb.append(this.a.toString());
        sb.append(" creativeType: ");
        i iVar = this.b;
        sb.append(iVar != null ? iVar.e() : "none");
        sb.append(" ctr:");
        sb.append(this.g);
        sb.append(" events:");
        sb.append(this.h);
        return sb.toString();
    }

    public List<String> a(t tVar) {
        Map<t, List<String>> map = this.h;
        if (map == null) {
            return null;
        }
        return map.get(tVar);
    }

    public JSONObject a() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("w", this.c);
            jSONObject.put("h", this.d);
            jSONObject.put("type", this.a.toString());
            i iVar = this.b;
            jSONObject.put("creativeType", iVar != null ? iVar.e() : "none");
            jSONObject.put(AppLovinEventTypes.USER_VIEWED_CONTENT, this.f);
        } catch (JSONException e2) {
            IAlog.a("Vast Parser: Failed creating Companion json object: %s", e2.getMessage());
        }
        return jSONObject;
    }
}
