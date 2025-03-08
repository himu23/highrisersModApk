package com.ironsource.sdk.controller;

import android.content.Context;
import com.ironsource.ab;
import com.ironsource.k0;
import com.ironsource.sdk.controller.u;
import com.ironsource.sdk.utils.Logger;
import org.json.JSONException;
import org.json.JSONObject;

public class p {
    private static final String b = "p";
    private static final String c = "getPermissions";
    private static final String d = "isPermissionGranted";
    private static final String e = "permissions";
    private static final String f = "permission";
    private static final String g = "status";
    private static final String h = "functionName";
    private static final String i = "functionParams";
    private static final String j = "success";
    private static final String k = "fail";
    private static final String l = "unhandledPermission";
    private Context a;

    private static class b {
        String a;
        JSONObject b;
        String c;
        String d;

        private b() {
        }
    }

    public p(Context context) {
        this.a = context;
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

    /* access modifiers changed from: package-private */
    public void a(String str, u.v.e0 e0Var) throws Exception {
        b a2 = a(str);
        if (c.equals(a2.a)) {
            a(a2.b, a2, e0Var);
        } else if (d.equals(a2.a)) {
            b(a2.b, a2, e0Var);
        } else {
            String str2 = b;
            Logger.i(str2, "PermissionsJSAdapter unhandled API request " + str);
        }
    }

    public void a(JSONObject jSONObject, b bVar, u.v.e0 e0Var) {
        ab abVar = new ab();
        try {
            abVar.a(e, k0.a(this.a, jSONObject.getJSONArray(e)));
            e0Var.a(true, bVar.c, abVar);
        } catch (Exception e2) {
            e2.printStackTrace();
            String str = b;
            Logger.i(str, "PermissionsJSAdapter getPermissions JSON Exception when getting permissions parameter " + e2.getMessage());
            abVar.b("errMsg", e2.getMessage());
            e0Var.a(false, bVar.d, abVar);
        }
    }

    public void b(JSONObject jSONObject, b bVar, u.v.e0 e0Var) {
        String str;
        boolean z;
        ab abVar = new ab();
        try {
            String string = jSONObject.getString(f);
            abVar.b(f, string);
            if (k0.d(this.a, string)) {
                abVar.b("status", String.valueOf(k0.c(this.a, string)));
                str = bVar.c;
                z = true;
            } else {
                abVar.b("status", l);
                str = bVar.d;
                z = false;
            }
            e0Var.a(z, str, abVar);
        } catch (Exception e2) {
            e2.printStackTrace();
            abVar.b("errMsg", e2.getMessage());
            e0Var.a(false, bVar.d, abVar);
        }
    }
}
