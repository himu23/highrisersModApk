package com.ironsource;

import android.content.Context;
import com.ironsource.m2;
import com.ironsource.sdk.utils.IronSourceStorageUtils;
import com.ironsource.sdk.utils.Logger;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public class d6 implements g0 {
    private static final String b = "d6";
    private static d6 c;
    /* access modifiers changed from: private */
    public final Map<String, v6> a = Collections.synchronizedMap(new HashMap());

    class a implements Runnable {
        final /* synthetic */ c6 a;
        final /* synthetic */ Context b;
        final /* synthetic */ String c;

        a(c6 c6Var, Context context, String str) {
            this.a = c6Var;
            this.b = context;
            this.c = str;
        }

        public void run() {
            d6.this.a.put(this.c, new x5(this.a, this.b));
        }
    }

    public static synchronized d6 a() {
        d6 d6Var;
        synchronized (d6.class) {
            if (c == null) {
                c = new d6();
            }
            d6Var = c;
        }
        return d6Var;
    }

    private v5 a(JSONObject jSONObject) {
        try {
            JSONObject jSONObject2 = new JSONObject(jSONObject.getString(m2.h.O));
            String obj = jSONObject2.get("height").toString();
            String obj2 = jSONObject2.get("width").toString();
            return new v5(Integer.parseInt(obj2), Integer.parseInt(obj), jSONObject2.get("label").toString());
        } catch (Exception unused) {
            return new v5();
        }
    }

    private v5 b(JSONObject jSONObject) {
        v5 v5Var = new v5();
        try {
            return a(jSONObject);
        } catch (Exception e) {
            e.printStackTrace();
            return v5Var;
        }
    }

    private boolean d(JSONObject jSONObject) {
        try {
            return jSONObject.getBoolean(m2.h.s0);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public v6 a(String str) {
        if (str.isEmpty() || !this.a.containsKey(str)) {
            return null;
        }
        return this.a.get(str);
    }

    public void a(y5 y5Var, JSONObject jSONObject, Context context, String str, String str2) throws Exception {
        String string = jSONObject.getString("adViewId");
        if (!string.isEmpty()) {
            v5 b2 = b(jSONObject);
            if (!this.a.containsKey(string)) {
                c6 c6Var = new c6(y5Var, context, string, b2);
                c6Var.e(IronSourceStorageUtils.getNetworkStorageDir(context));
                c6Var.b(jSONObject, str, str2);
                if (d(jSONObject)) {
                    n5.a.c(new a(c6Var, context, string));
                } else {
                    this.a.put(string, c6Var);
                }
            } else {
                Logger.i(b, "sendMessageToAd fail - collection already contain adViewId");
                throw new Exception("collection already contain adViewId");
            }
        } else {
            Logger.i(b, "loadWithUrl fail - adViewId is empty");
            throw new Exception("adViewId is empty");
        }
    }

    public void a(JSONObject jSONObject, String str, String str2) throws Exception {
        String string = jSONObject.getString("adViewId");
        if (string.isEmpty()) {
            Logger.i(b, "removeAdView fail - adViewId is empty");
            throw new Exception("adViewId is empty");
        } else if (this.a.containsKey(string)) {
            v6 v6Var = this.a.get(string);
            if (v6Var != null) {
                v6Var.a(jSONObject, str, str2);
            }
        } else {
            Logger.i(b, "removeAdView fail - collection does not contain adViewId");
            throw new Exception("collection does not contain adViewId");
        }
    }

    public void b(JSONObject jSONObject, String str, String str2) throws Exception {
        String string = jSONObject.getString("adViewId");
        if (string.isEmpty()) {
            Logger.i(b, "performWebViewAction fail - adViewId is empty");
            throw new Exception("adViewId is empty");
        } else if (this.a.containsKey(string)) {
            v6 v6Var = this.a.get(string);
            String string2 = jSONObject.getString(m2.h.v0);
            if (v6Var != null) {
                v6Var.a(string2, str, str2);
            }
        } else {
            Logger.i(b, "performWebViewAction fail - collection does not contain adViewId");
            throw new Exception("collection does not contain adViewId");
        }
    }

    public String c(JSONObject jSONObject) throws JSONException {
        return (jSONObject == null || !jSONObject.has("adViewId")) ? (jSONObject == null || !jSONObject.has("params")) ? "" : new JSONObject(jSONObject.getString("params")).getString("adViewId") : jSONObject.getString("adViewId");
    }

    public void c(JSONObject jSONObject, String str, String str2) throws Exception {
        String string = jSONObject.getString("adViewId");
        if (string.isEmpty()) {
            Logger.i(b, "removeAdView fail - adViewId is empty");
            throw new Exception("adViewId is empty");
        } else if (this.a.containsKey(string)) {
            v6 v6Var = this.a.get(string);
            this.a.remove(string);
            if (v6Var != null) {
                v6Var.a(str, str2);
            }
        } else {
            Logger.i(b, "removeAdView fail - collection does not contain adViewId");
            throw new Exception("collection does not contain adViewId");
        }
    }

    public void d(JSONObject jSONObject, String str, String str2) throws Exception {
        String string = new JSONObject(jSONObject.getString("params")).getString("adViewId");
        if (string.isEmpty()) {
            Logger.i(b, "sendMessageToAd fail - adViewId is empty");
            throw new Exception("adViewId is empty");
        } else if (this.a.containsKey(string)) {
            v6 v6Var = this.a.get(string);
            if (v6Var != null) {
                v6Var.c(jSONObject, str, str2);
            }
        } else {
            Logger.i(b, "sendMessageToAd fail - collection does not contain adViewId");
            throw new Exception("collection does not contain adViewId");
        }
    }
}
