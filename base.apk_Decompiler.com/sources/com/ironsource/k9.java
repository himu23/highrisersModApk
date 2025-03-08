package com.ironsource;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import com.ironsource.e6;
import com.ironsource.sdk.utils.IronSourceQaProperties;
import com.ironsource.sdk.utils.IronSourceStorageUtils;
import com.ironsource.sdk.utils.SDKUtils;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public class k9 {
    x4 a = new x4();

    public void a() {
        JSONObject jSONObject = new JSONObject(IronSourceQaProperties.getInstance().getParameters());
        if (jSONObject.length() > 0) {
            this.a.a("debug", jSONObject);
        }
    }

    public void a(Context context) {
        if (context instanceof Activity) {
            this.a.a("imm", (Object) Boolean.valueOf(m3.a((Activity) context)));
        }
    }

    public void a(e6.c cVar) {
        this.a.a(t4.X0, (Object) Integer.valueOf(cVar.ordinal()));
    }

    public void a(JSONObject jSONObject) {
        this.a.a(t4.k, jSONObject);
    }

    public void b() {
        String controllerConfig = SDKUtils.getControllerConfig();
        if (!TextUtils.isEmpty(controllerConfig)) {
            try {
                this.a.a(t4.i, new JSONObject(controllerConfig).opt("chinaCDN"));
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    public void b(Context context) {
        this.a.a("gpi", (Object) Boolean.valueOf(ca.d(context)));
    }

    public void c() {
        this.a.a("uxt", (Object) Boolean.valueOf(IronSourceStorageUtils.isUxt()));
    }

    public void d() {
        this.a.a(t4.J, (Object) "7.6.1");
    }

    public void e() {
        HashMap hashMap = new HashMap();
        hashMap.put(t4.w, m9.f);
        hashMap.put(t4.v, m9.e);
        this.a.a((Map<String, Object>) hashMap);
    }
}
