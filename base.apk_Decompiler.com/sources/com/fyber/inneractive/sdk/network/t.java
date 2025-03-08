package com.fyber.inneractive.sdk.network;

import com.fyber.inneractive.sdk.external.InneractiveAdRequest;
import com.fyber.inneractive.sdk.network.s;
import com.fyber.inneractive.sdk.response.e;
import com.fyber.inneractive.sdk.util.IAlog;
import com.fyber.inneractive.sdk.util.u;
import org.json.JSONArray;
import org.json.JSONObject;

public class t {
    public static void a(String str, String str2, InneractiveAdRequest inneractiveAdRequest, e eVar) {
        s.a aVar = new s.a(r.CAUGHT_EXCEPTION, inneractiveAdRequest, eVar, (JSONArray) null);
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("exception_name", str);
        } catch (Exception unused) {
            IAlog.e("Got exception adding param to json object: %s, %s", "exception_name", str);
        }
        try {
            jSONObject.put("description", str2);
        } catch (Exception unused2) {
            IAlog.e("Got exception adding param to json object: %s, %s", "description", str2);
        }
        aVar.f.put(jSONObject);
        aVar.a((String) null);
    }

    public static void a(Throwable th, InneractiveAdRequest inneractiveAdRequest, e eVar) {
        String a = u.a(th);
        s.a aVar = new s.a(r.CAUGHT_EXCEPTION, inneractiveAdRequest, eVar, (JSONArray) null);
        JSONObject jSONObject = new JSONObject();
        String cls = th.getClass().toString();
        try {
            jSONObject.put("exception_name", cls);
        } catch (Exception unused) {
            IAlog.e("Got exception adding param to json object: %s, %s", "exception_name", cls);
        }
        String message = th.getMessage();
        try {
            jSONObject.put("description", message);
        } catch (Exception unused2) {
            IAlog.e("Got exception adding param to json object: %s, %s", "description", message);
        }
        try {
            jSONObject.put("stack_trace", a);
        } catch (Exception unused3) {
            IAlog.e("Got exception adding param to json object: %s, %s", "stack_trace", a);
        }
        aVar.f.put(jSONObject);
        aVar.a((String) null);
    }
}
