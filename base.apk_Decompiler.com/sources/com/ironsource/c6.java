package com.ironsource;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import android.view.ViewGroup;
import android.webkit.JavascriptInterface;
import android.webkit.WebView;
import com.ironsource.m2;
import com.ironsource.sdk.utils.Logger;
import com.ironsource.v6;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public class c6 implements v6 {
    private static final String g = "loadWithUrl | webView is not null";
    /* access modifiers changed from: private */
    public static final String h = "c6";
    private static final String i = "file://";
    /* access modifiers changed from: private */
    public final String a;
    private String b;
    /* access modifiers changed from: private */
    public WebView c;
    /* access modifiers changed from: private */
    public a6 d;
    private v5 e;
    /* access modifiers changed from: private */
    public Context f;

    class a implements Runnable {
        final /* synthetic */ String a;
        final /* synthetic */ JSONObject b;
        final /* synthetic */ String c;

        a(String str, JSONObject jSONObject, String str2) {
            this.a = str;
            this.b = jSONObject;
            this.c = str2;
        }

        public void run() {
            if (c6.this.c != null) {
                l6.a(za.q, (Map<String, Object>) new g6().a(z3.z, c6.g).a());
            }
            try {
                c6.this.b(this.a);
                c6.this.c.loadUrl(c6.this.a(this.b.getString("urlForWebView")));
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("adViewId", c6.this.a);
                c6.this.d.a(this.c, jSONObject);
            } catch (Exception e) {
                c6.this.b(this.a, e.getMessage());
                l6.a(za.q, (Map<String, Object>) new g6().a(z3.z, e.getMessage()).a());
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
                if (c6.this.c != null) {
                    c6.this.c.destroy();
                }
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("adViewId", c6.this.a);
                if (c6.this.d != null) {
                    c6.this.d.a(this.a, jSONObject);
                    c6.this.d.b();
                }
                a6 unused = c6.this.d = null;
                Context unused2 = c6.this.f = null;
            } catch (Exception e) {
                String a2 = c6.h;
                Log.e(a2, "performCleanup | could not destroy ISNAdView webView ID: " + c6.this.a);
                l6.a(za.r, (Map<String, Object>) new g6().a(z3.z, e.getMessage()).a());
                c6.this.b(this.b, e.getMessage());
            }
        }
    }

    class c implements v6.a {
        final /* synthetic */ String a;

        c(String str) {
            this.a = str;
        }

        public void a(String str) {
            String a2 = c6.h;
            Logger.i(a2, "ISNAdViewWebPresenter | WebViewClient | reportOnError: " + str);
            c6.this.b(this.a, str);
        }

        public void b(String str) {
            String a2 = c6.h;
            Logger.i(a2, "ISNAdViewWebPresenter | WebViewClient | onRenderProcessGone: " + str);
            try {
                ((ViewGroup) c6.this.c.getParent()).removeView(c6.this.c);
            } catch (Exception e) {
                e.printStackTrace();
            }
            c6.this.e();
        }
    }

    public c6(y5 y5Var, Context context, String str, v5 v5Var) {
        this.f = context;
        a6 a6Var = new a6();
        this.d = a6Var;
        a6Var.g(str);
        this.a = str;
        this.d.a(y5Var);
        this.e = v5Var;
    }

    /* access modifiers changed from: private */
    public String a(String str) {
        if (!c(str)) {
            return str;
        }
        return i + this.b + d(str);
    }

    /* access modifiers changed from: private */
    public void b(String str) {
        Logger.i(h, "ISNAdViewWebPresenter | createWebView");
        WebView webView = new WebView(this.f);
        this.c = webView;
        webView.addJavascriptInterface(new z5(this), w5.e);
        this.c.setWebViewClient(new b6(new c(str)));
        hd.a(this.c);
        this.d.a(this.c);
    }

    private boolean c(String str) {
        return str.startsWith(".");
    }

    private String d(String str) {
        String substring = str.substring(str.indexOf("/") + 1);
        return substring.substring(substring.indexOf("/"));
    }

    /* access modifiers changed from: private */
    public synchronized void e() {
        a("", "");
    }

    public synchronized void a(String str, String str2) {
        if (this.f != null) {
            Logger.i(h, "performCleanup");
            n5.a.c(new b(str, str2));
        }
    }

    public void a(String str, String str2, String str3) {
        if (TextUtils.isEmpty(str)) {
            b(str3, m2.c.F);
            return;
        }
        String str4 = h;
        Logger.i(str4, "trying to perform WebView Action: " + str);
        try {
            if (str.equals(m2.h.t0)) {
                this.c.onPause();
            } else if (str.equals(m2.h.u0)) {
                this.c.onResume();
            } else {
                b(str3, m2.c.E);
                return;
            }
            this.d.f(str2);
        } catch (Exception unused) {
            b(str3, m2.c.G);
        }
    }

    public void a(JSONObject jSONObject, String str, String str2) {
        try {
            this.d.e(str);
        } catch (Exception e2) {
            String str3 = h;
            Logger.i(str3, "sendHandleGetViewVisibility fail with reason: " + e2.getMessage());
        }
    }

    public String b() {
        return this.a;
    }

    public void b(String str, String str2) {
        a6 a6Var = this.d;
        if (a6Var != null) {
            a6Var.a(str, str2);
        }
    }

    public void b(JSONObject jSONObject, String str, String str2) {
        n5.a.c(new a(str2, jSONObject, str));
    }

    public a6 c() {
        return this.d;
    }

    public void c(JSONObject jSONObject, String str, String str2) throws JSONException {
        try {
            this.d.a(jSONObject.getString("params"), str, str2);
        } catch (Exception e2) {
            String str3 = h;
            Logger.i(str3, "sendMessageToAd fail message: " + e2.getMessage());
            throw e2;
        }
    }

    public v5 d() {
        return this.e;
    }

    public void e(String str) {
        this.b = str;
    }

    public WebView getPresentingView() {
        return this.c;
    }

    @JavascriptInterface
    public void handleMessageFromAd(String str) {
        this.d.c(str);
    }
}
