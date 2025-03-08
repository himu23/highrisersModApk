package com.fyber.inneractive.sdk.flow;

import com.fyber.inneractive.sdk.config.global.s;
import com.fyber.inneractive.sdk.external.InneractiveAdRequest;
import com.fyber.inneractive.sdk.network.q;
import com.fyber.inneractive.sdk.network.s;
import com.fyber.inneractive.sdk.response.e;
import com.fyber.inneractive.sdk.util.IAlog;
import org.json.JSONArray;
import org.json.JSONObject;

public class v implements Runnable {
    public final /* synthetic */ String a;
    public final /* synthetic */ InneractiveAdRequest b;
    public final /* synthetic */ e c;
    public final /* synthetic */ t d;

    public v(t tVar, String str, InneractiveAdRequest inneractiveAdRequest, e eVar) {
        this.d = tVar;
        this.a = str;
        this.b = inneractiveAdRequest;
        this.c = eVar;
    }

    public void run() {
        JSONArray jSONArray;
        s sVar;
        IAlog.a("Firing Event 803 - Stack trace - %s", this.a);
        q qVar = q.IA_AD_DESTROYED_WITHOUT_SHOW;
        InneractiveAdRequest inneractiveAdRequest = this.b;
        e eVar = this.c;
        t tVar = this.d;
        j jVar = tVar.h;
        l lVar = tVar.l;
        s sVar2 = lVar != null ? lVar.c : null;
        if (jVar == null || (sVar = jVar.c) == null) {
            jSONArray = sVar2 != null ? sVar2.c() : null;
        } else {
            jSONArray = sVar.c();
        }
        s.a aVar = new s.a(qVar, inneractiveAdRequest, eVar, jSONArray);
        JSONObject jSONObject = new JSONObject();
        String str = this.a;
        try {
            jSONObject.put("stack_trace", str);
        } catch (Exception unused) {
            IAlog.e("Got exception adding param to json object: %s, %s", "stack_trace", str);
        }
        aVar.f.put(jSONObject);
        aVar.a((String) null);
    }
}
