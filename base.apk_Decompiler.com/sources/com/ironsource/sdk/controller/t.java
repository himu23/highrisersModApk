package com.ironsource.sdk.controller;

import android.content.Context;
import com.ironsource.ab;
import com.ironsource.environment.StringUtils;
import com.ironsource.k9;
import com.ironsource.lc;
import com.ironsource.nc;
import com.ironsource.sdk.controller.u;
import com.ironsource.sdk.utils.Logger;
import com.ironsource.sdk.utils.SDKUtils;
import java.util.Iterator;
import org.json.JSONException;
import org.json.JSONObject;

public class t {
    private static final String f = "t";
    private static final String g = "updateToken";
    private static final String h = "getToken";
    private static final String i = "functionName";
    private static final String j = "functionParams";
    private static final String k = "success";
    private static final String l = "fail";
    private final String a = "oneToken";
    private nc b;
    private k9 c;
    private Context d;
    private lc e;

    private static class b {
        String a;
        JSONObject b;
        String c;
        String d;

        private b() {
        }
    }

    public t(Context context, nc ncVar) {
        this.b = ncVar;
        this.d = context;
        this.c = new k9();
        this.e = new lc();
    }

    private b a(String str) throws JSONException {
        JSONObject jSONObject = new JSONObject(str);
        b bVar = new b();
        bVar.a = jSONObject.optString("functionName");
        bVar.b = jSONObject.optJSONObject("functionParams");
        bVar.c = jSONObject.optString("success");
        bVar.d = jSONObject.optString("fail");
        return bVar;
    }

    private JSONObject a() throws JSONException {
        JSONObject a2 = this.e.a();
        Iterator<String> keys = a2.keys();
        while (keys.hasNext()) {
            String next = keys.next();
            Object obj = a2.get(next);
            if (obj instanceof String) {
                a2.put(next, StringUtils.encodeURI((String) obj));
            }
        }
        return a2;
    }

    private void a(b bVar, u.v.e0 e0Var) {
        try {
            e0Var.a(true, bVar.c, SDKUtils.getControllerConfigAsJSONObject().optBoolean("oneToken") ? a() : this.b.c(this.d));
        } catch (Exception e2) {
            e0Var.a(false, bVar.d, e2.getMessage());
        }
    }

    /* access modifiers changed from: package-private */
    public void a(String str, u.v.e0 e0Var) throws Exception {
        b a2 = a(str);
        if (g.equals(a2.a)) {
            a(a2.b, a2, e0Var);
        } else if (h.equals(a2.a)) {
            a(a2, e0Var);
        } else {
            String str2 = f;
            Logger.i(str2, "unhandled API request " + str);
        }
    }

    public void a(JSONObject jSONObject, b bVar, u.v.e0 e0Var) {
        ab abVar = new ab();
        try {
            this.c.a(jSONObject);
            this.b.a(jSONObject);
            e0Var.a(true, bVar.c, abVar);
        } catch (Exception e2) {
            e2.printStackTrace();
            String str = f;
            Logger.i(str, "updateToken exception " + e2.getMessage());
            e0Var.a(false, bVar.d, abVar);
        }
    }
}
