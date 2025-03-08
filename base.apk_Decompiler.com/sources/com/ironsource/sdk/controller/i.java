package com.ironsource.sdk.controller;

import android.content.Context;
import com.ironsource.ab;
import com.ironsource.m3;
import com.ironsource.sdk.controller.u;
import com.ironsource.sdk.utils.Logger;
import com.ironsource.sdk.utils.SDKUtils;
import org.json.JSONException;
import org.json.JSONObject;

public class i {
    private static final String b = "i";
    private static final String c = "getDeviceData";
    private static final String d = "deviceDataFunction";
    private static final String e = "deviceDataParams";
    private static final String f = "success";
    private static final String g = "fail";
    private Context a;

    private static class b {
        String a;
        JSONObject b;
        String c;
        String d;

        private b() {
        }
    }

    public i(Context context) {
        this.a = context;
    }

    private ab a() {
        ab abVar = new ab();
        abVar.b(SDKUtils.encodeString("sdCardAvailable"), SDKUtils.encodeString(String.valueOf(m3.r())));
        abVar.b(SDKUtils.encodeString("totalDeviceRAM"), SDKUtils.encodeString(String.valueOf(m3.D(this.a))));
        abVar.b(SDKUtils.encodeString("isCharging"), SDKUtils.encodeString(String.valueOf(m3.G(this.a))));
        abVar.b(SDKUtils.encodeString("chargingType"), SDKUtils.encodeString(String.valueOf(m3.a(this.a))));
        abVar.b(SDKUtils.encodeString("airplaneMode"), SDKUtils.encodeString(String.valueOf(m3.F(this.a))));
        abVar.b(SDKUtils.encodeString("stayOnWhenPluggedIn"), SDKUtils.encodeString(String.valueOf(m3.K(this.a))));
        return abVar;
    }

    private b a(String str) throws JSONException {
        JSONObject jSONObject = new JSONObject(str);
        b bVar = new b();
        bVar.a = jSONObject.optString(d);
        bVar.b = jSONObject.optJSONObject(e);
        bVar.c = jSONObject.optString("success");
        bVar.d = jSONObject.optString("fail");
        return bVar;
    }

    /* access modifiers changed from: package-private */
    public void a(String str, u.v.e0 e0Var) throws Exception {
        b a2 = a(str);
        if (c.equals(a2.a)) {
            e0Var.a(true, a2.c, a());
            return;
        }
        String str2 = b;
        Logger.i(str2, "unhandled API request " + str);
    }
}
