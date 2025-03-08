package com.fyber.inneractive.sdk.config;

import com.fyber.inneractive.sdk.cache.session.c;
import com.fyber.inneractive.sdk.cache.session.d;
import com.fyber.inneractive.sdk.cache.session.e;
import com.fyber.inneractive.sdk.cache.session.g;
import com.fyber.inneractive.sdk.cache.session.h;
import com.fyber.inneractive.sdk.config.enums.UnitDisplayType;
import com.fyber.inneractive.sdk.util.q;
import com.ironsource.m2;
import com.unity3d.services.core.device.MimeTypes;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

public class f0 implements g0 {
    public d a;
    public final Map<UnitDisplayType, Map<String, String>> b = new HashMap();
    public final Map<String, String> c = new HashMap();
    public a d;
    public boolean e = false;

    public interface a {
    }

    public enum b {
        NO_CLICK("0"),
        CTA_BUTTON("1"),
        COMPANION("2"),
        VIDEO("3"),
        APP_INFO("4");
        
        public String value;

        /* access modifiers changed from: public */
        b(String str) {
            this.value = str;
        }
    }

    public void a(a aVar) {
        this.d = aVar;
    }

    public String a(UnitDisplayType unitDisplayType, String str) {
        Map map = this.b.get(unitDisplayType);
        if (map == null || map.get(str) == null) {
            return "";
        }
        return (String) map.get(str);
    }

    public void a(UnitDisplayType unitDisplayType, String str, String str2) {
        Map map = this.b.get(unitDisplayType);
        if (map == null) {
            map = new HashMap();
            this.b.put(unitDisplayType, map);
        }
        map.put(str, str2);
        a aVar = this.d;
        if (aVar != null && this.e) {
            ((com.fyber.inneractive.sdk.bidder.a) aVar).b();
        }
    }

    public JSONArray a(UnitDisplayType unitDisplayType) {
        d dVar = this.a;
        if (dVar == null) {
            return null;
        }
        dVar.getClass();
        JSONArray jSONArray = new JSONArray();
        try {
            for (com.fyber.inneractive.sdk.cache.session.enums.b bVar : com.fyber.inneractive.sdk.cache.session.enums.b.values()) {
                if (bVar != com.fyber.inneractive.sdk.cache.session.enums.b.NONE && (unitDisplayType == null || bVar.e() == unitDisplayType)) {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("type", bVar.e().value());
                    jSONObject.put("subType", bVar.name().toLowerCase().contains(MimeTypes.BASE_TYPE_VIDEO) ? MimeTypes.BASE_TYPE_VIDEO : m2.h.d);
                    h hVar = dVar.b.get(bVar);
                    int a2 = dVar.a();
                    if (a2 > 0 && hVar != null && hVar.size() >= a2) {
                        boolean f = bVar.f();
                        JSONArray jSONArray2 = new JSONArray();
                        ArrayList arrayList = new ArrayList(hVar);
                        Collections.sort(arrayList, new g(hVar));
                        Iterator it = arrayList.iterator();
                        int i = 0;
                        while (it.hasNext()) {
                            jSONArray2.put(((e) it.next()).a(false, f));
                            i++;
                            if (i >= a2) {
                                break;
                            }
                        }
                        jSONObject.put("sessionData", jSONArray2);
                        jSONArray.put(jSONObject);
                    }
                }
            }
            return jSONArray;
        } catch (Exception unused) {
            return jSONArray;
        }
    }

    public void a(com.fyber.inneractive.sdk.cache.session.enums.b bVar, com.fyber.inneractive.sdk.cache.session.enums.a aVar) {
        d dVar = this.a;
        if (dVar != null) {
            q.a(new c(dVar, aVar, bVar));
        }
    }

    public void a(UnitDisplayType unitDisplayType, String... strArr) {
        for (String a2 : strArr) {
            a(unitDisplayType, a2, "0");
        }
    }
}
