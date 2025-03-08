package com.fyber.inneractive.sdk.cache.session;

import com.fyber.inneractive.sdk.cache.session.enums.b;
import com.fyber.inneractive.sdk.config.IAConfigManager;
import com.fyber.inneractive.sdk.config.i;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.PriorityQueue;
import org.json.JSONArray;
import org.json.JSONObject;

public class d {
    public f a = new f();
    public HashMap<b, h> b;
    public final Object c = new Object();
    public final Object d = new Object();
    public a e;

    public interface a {
        void a(d dVar, boolean z, JSONObject jSONObject);
    }

    public d(int i, a aVar) {
        this.b = new a(this, i);
        this.e = null;
    }

    public static JSONObject a(d dVar) {
        dVar.getClass();
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("currentSession", dVar.a.a());
            for (Map.Entry next : dVar.b.entrySet()) {
                JSONArray jSONArray = new JSONArray();
                b bVar = (b) next.getKey();
                Iterator it = ((PriorityQueue) next.getValue()).iterator();
                while (it.hasNext()) {
                    jSONArray.put(((e) it.next()).a(true, true));
                }
                jSONObject.put(bVar.name(), jSONArray);
            }
        } catch (Exception unused) {
        }
        return jSONObject;
    }

    public final void a(b bVar, e eVar) {
        synchronized (this.d) {
            h hVar = this.b.get(bVar);
            if (hVar != null) {
                hVar.add(eVar);
            }
        }
    }

    public final void a(f fVar) {
        e eVar;
        for (b bVar : b.values()) {
            if (!(bVar == b.NONE || (eVar = fVar.a.get(bVar)) == null || eVar.a == 0)) {
                a(bVar, eVar);
            }
        }
    }

    public int a() {
        int i;
        i iVar = IAConfigManager.M.u.b;
        String num = Integer.toString(5);
        if (iVar.a.containsKey("number_of_sessions")) {
            num = iVar.a.get("number_of_sessions");
        }
        try {
            i = Integer.parseInt(num);
        } catch (Throwable unused) {
            i = 5;
        }
        if (i < 0) {
            return 5;
        }
        return i;
    }
}
