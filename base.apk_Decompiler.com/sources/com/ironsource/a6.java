package com.ironsource;

import android.os.Build;
import android.text.TextUtils;
import android.util.Log;
import android.webkit.ValueCallback;
import android.webkit.WebView;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public class a6 {
    private y5 a;
    private vc b = new vc();
    /* access modifiers changed from: private */
    public WebView c;
    private String d;
    /* access modifiers changed from: private */
    public String e = "a6";
    private String[] f = {"handleGetViewVisibility"};
    private final String[] g = {w5.h, w5.i, w5.g, "handleGetViewVisibility", w5.j};

    class a implements Runnable {
        final /* synthetic */ String a;
        final /* synthetic */ String b;
        final /* synthetic */ String c;
        final /* synthetic */ JSONObject d;

        a(String str, String str2, String str3, JSONObject jSONObject) {
            this.a = str;
            this.b = str2;
            this.c = str3;
            this.d = jSONObject;
        }

        public void run() {
            try {
                if (!a6.this.b(this.a)) {
                    String str = "ISNAdViewLogic | handleMessageFromController | cannot handle command: " + this.a;
                    Log.e(a6.this.e, str);
                    a6.this.a(this.b, str);
                } else if (this.a.equalsIgnoreCase("handleGetViewVisibility")) {
                    a6.this.e(this.c);
                } else if (this.a.equalsIgnoreCase(w5.j) || this.a.equalsIgnoreCase(w5.i)) {
                    a6.this.a(this.d.getString("params"), this.c, this.b);
                }
            } catch (Exception e2) {
                e2.printStackTrace();
                String str2 = "ISNAdViewLogic | handleMessageFromController | Error while trying handle message: " + this.a;
                Log.e(a6.this.e, str2);
                a6.this.a(this.b, str2);
            }
        }
    }

    class b implements Runnable {
        final /* synthetic */ String a;
        final /* synthetic */ String b;

        b(String str, String str2) {
            this.a = str;
            this.b = str2;
        }

        public void run() {
            try {
                a6.this.c.evaluateJavascript(this.a, (ValueCallback) null);
            } catch (Throwable unused) {
                String a2 = a6.this.e;
                Log.e(a2, "injectJavaScriptIntoWebView | Error while trying inject JS into external adUnit: " + this.b + "Android API level: " + Build.VERSION.SDK_INT);
            }
        }
    }

    private String a(String str) {
        return String.format(w5.u, new Object[]{str});
    }

    private JSONObject a(JSONObject jSONObject) {
        JSONObject jSONObject2 = new JSONObject();
        try {
            jSONObject2.put(w5.x, jSONObject.getString(w5.x));
            jSONObject2.put("data", this.b.a());
        } catch (Exception e2) {
            String str = this.e;
            Log.e(str, "Error while trying execute method buildVisibilityMessageForAdUnit | params: " + jSONObject);
            e2.printStackTrace();
        }
        return jSONObject2;
    }

    /* access modifiers changed from: private */
    public boolean b(String str) {
        for (String equalsIgnoreCase : this.g) {
            if (equalsIgnoreCase.equalsIgnoreCase(str)) {
                return true;
            }
        }
        return false;
    }

    private void d() {
        if (this.a != null && this.b != null) {
            a(w5.a, a());
        }
    }

    private void d(String str) {
        n5.a.c(new b("javascript:try{" + str + "}catch(e){console.log(\"JS exception: \" + JSON.stringify(e));}", str));
    }

    private boolean h(String str) {
        for (String equalsIgnoreCase : this.f) {
            if (equalsIgnoreCase.equalsIgnoreCase(str)) {
                return true;
            }
        }
        return false;
    }

    private boolean i(String str) {
        return str.equalsIgnoreCase(Build.VERSION.SDK_INT <= 22 ? w5.l : w5.k);
    }

    public JSONObject a() {
        JSONObject jSONObject = new JSONObject();
        try {
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put(w5.s, this.b.a());
            jSONObject.put(w5.p, jSONObject2);
            jSONObject.put("adViewId", c());
            return jSONObject;
        } catch (JSONException e2) {
            e2.printStackTrace();
            return new JSONObject();
        }
    }

    public void a(WebView webView) {
        this.c = webView;
    }

    public void a(y5 y5Var) {
        this.a = y5Var;
    }

    public void a(String str, int i, boolean z) {
        this.b.a(str, i, z);
        if (i(str)) {
            d();
        }
    }

    public void a(String str, String str2) {
        y5 y5Var = this.a;
        if (y5Var != null) {
            y5Var.a(str, str2, this.d);
        }
    }

    public void a(String str, String str2, String str3) throws JSONException {
        if (this.c == null) {
            String str4 = "No external adUnit attached to ISNAdView while trying to send message: " + str;
            Log.e(this.e, str4);
            this.a.a(str3, str4, this.d);
            return;
        }
        try {
            new JSONObject(str);
        } catch (JSONException unused) {
            str = "\"" + str + "\"";
        }
        d(a(str));
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("adViewId", this.d);
        a(str2, jSONObject);
    }

    public void a(String str, JSONObject jSONObject) {
        y5 y5Var = this.a;
        if (y5Var != null) {
            y5Var.a(str, jSONObject);
        }
    }

    /* access modifiers changed from: package-private */
    public void a(String str, JSONObject jSONObject, String str2, String str3) {
        if (this.a == null) {
            l6.a(za.t, (Map<String, Object>) new g6().a(z3.x, "mDelegate is null").a());
        } else {
            n5.a.c(new a(str, str3, str2, jSONObject));
        }
    }

    public void a(JSONObject jSONObject, String str, String str2) throws JSONException {
        a(a(jSONObject).toString(), str, str2);
    }

    public void b() {
        this.a = null;
        this.b = null;
    }

    public String c() {
        return this.d;
    }

    public void c(String str) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            String optString = jSONObject.optString("method");
            if (TextUtils.isEmpty(optString) || !h(optString)) {
                a(jSONObject.optString(w5.v, w5.c), jSONObject);
            } else if (optString.equalsIgnoreCase("handleGetViewVisibility")) {
                a(jSONObject, (String) null, (String) null);
            }
        } catch (JSONException e2) {
            String str2 = this.e;
            Log.e(str2, "ISNAdViewLogic | receiveMessageFromExternal | Error while trying handle message: " + str);
            e2.printStackTrace();
        }
    }

    public void e() {
        if (this.a != null && this.b != null) {
            a(w5.b, a());
        }
    }

    public void e(String str) throws JSONException {
        JSONObject a2 = this.b.a();
        a2.put("adViewId", this.d);
        a(str, a2);
    }

    public void f(String str) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("adViewId", this.d);
            a(str, jSONObject);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
    }

    public void g(String str) {
        this.d = str;
    }
}
