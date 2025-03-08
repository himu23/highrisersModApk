package com.ironsource.sdk.controller;

import android.app.Activity;
import android.content.Context;
import com.ironsource.e6;
import com.ironsource.h3;
import com.ironsource.n5;
import com.ironsource.sdk.controller.f;
import com.ironsource.sdk.controller.k;
import com.ironsource.v2;
import com.ironsource.w2;
import com.ironsource.w9;
import com.ironsource.x2;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public class n implements k {
    private final n5 a;
    /* access modifiers changed from: private */
    public final String b;

    class a implements Runnable {
        final /* synthetic */ w2 a;
        final /* synthetic */ h3 b;

        a(w2 w2Var, h3 h3Var) {
            this.a = w2Var;
            this.b = h3Var;
        }

        public void run() {
            this.a.b(this.b.h(), n.this.b);
        }
    }

    class b implements Runnable {
        final /* synthetic */ v2 a;
        final /* synthetic */ Map b;

        b(v2 v2Var, Map map) {
            this.a = v2Var;
            this.b = map;
        }

        public void run() {
            this.a.a((String) this.b.get("demandSourceName"), n.this.b);
        }
    }

    class c implements Runnable {
        final /* synthetic */ v2 a;
        final /* synthetic */ JSONObject b;

        c(v2 v2Var, JSONObject jSONObject) {
            this.a = v2Var;
            this.b = jSONObject;
        }

        public void run() {
            this.a.a(this.b.optString("demandSourceName"), n.this.b);
        }
    }

    class d implements Runnable {
        final /* synthetic */ k.a a;
        final /* synthetic */ f.c b;

        d(k.a aVar, f.c cVar) {
            this.a = aVar;
            this.b = cVar;
        }

        public void run() {
            try {
                if (this.a != null) {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("success", false);
                    jSONObject.put("reason", n.this.b);
                    this.a.a(new f.a(this.b.f(), jSONObject));
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    class e implements Runnable {
        final /* synthetic */ w9 a;

        e(w9 w9Var) {
            this.a = w9Var;
        }

        public void run() {
            this.a.onOfferwallInitFail(n.this.b);
        }
    }

    class f implements Runnable {
        final /* synthetic */ w9 a;

        f(w9 w9Var) {
            this.a = w9Var;
        }

        public void run() {
            this.a.onOWShowFail(n.this.b);
            this.a.onOfferwallInitFail(n.this.b);
        }
    }

    class g implements Runnable {
        final /* synthetic */ w9 a;

        g(w9 w9Var) {
            this.a = w9Var;
        }

        public void run() {
            this.a.onGetOWCreditsFailed(n.this.b);
        }
    }

    class h implements Runnable {
        final /* synthetic */ x2 a;
        final /* synthetic */ h3 b;

        h(x2 x2Var, h3 h3Var) {
            this.a = x2Var;
            this.b = h3Var;
        }

        public void run() {
            this.a.a(e6.e.RewardedVideo, this.b.h(), n.this.b);
        }
    }

    class i implements Runnable {
        final /* synthetic */ x2 a;
        final /* synthetic */ JSONObject b;

        i(x2 x2Var, JSONObject jSONObject) {
            this.a = x2Var;
            this.b = jSONObject;
        }

        public void run() {
            this.a.d(this.b.optString("demandSourceName"), n.this.b);
        }
    }

    class j implements Runnable {
        final /* synthetic */ w2 a;
        final /* synthetic */ h3 b;

        j(w2 w2Var, h3 h3Var) {
            this.a = w2Var;
            this.b = h3Var;
        }

        public void run() {
            this.a.a(e6.e.Interstitial, this.b.h(), n.this.b);
        }
    }

    class k implements Runnable {
        final /* synthetic */ w2 a;
        final /* synthetic */ String b;

        k(w2 w2Var, String str) {
            this.a = w2Var;
            this.b = str;
        }

        public void run() {
            this.a.c(this.b, n.this.b);
        }
    }

    class l implements Runnable {
        final /* synthetic */ w2 a;
        final /* synthetic */ h3 b;

        l(w2 w2Var, h3 h3Var) {
            this.a = w2Var;
            this.b = h3Var;
        }

        public void run() {
            this.a.c(this.b.h(), n.this.b);
        }
    }

    class m implements Runnable {
        final /* synthetic */ w2 a;
        final /* synthetic */ JSONObject b;

        m(w2 w2Var, JSONObject jSONObject) {
            this.a = w2Var;
            this.b = jSONObject;
        }

        public void run() {
            this.a.b(this.b.optString("demandSourceName"), n.this.b);
        }
    }

    n(String str, n5 n5Var) {
        this.a = n5Var;
        this.b = str;
    }

    public void a(Activity activity) {
    }

    public void a(Context context) {
    }

    public void a(h3 h3Var) {
    }

    public void a(h3 h3Var, Map<String, String> map, v2 v2Var) {
        if (v2Var != null) {
            a((Runnable) new b(v2Var, map));
        }
    }

    public void a(h3 h3Var, Map<String, String> map, w2 w2Var) {
        if (w2Var != null) {
            a((Runnable) new a(w2Var, h3Var));
        }
    }

    public void a(f.c cVar, k.a aVar) {
        a((Runnable) new d(aVar, cVar));
    }

    /* access modifiers changed from: package-private */
    public void a(Runnable runnable) {
        n5 n5Var = this.a;
        if (n5Var != null) {
            n5Var.b(runnable);
        }
    }

    public void a(String str, w2 w2Var) {
        if (w2Var != null) {
            a((Runnable) new k(w2Var, str));
        }
    }

    public void a(String str, String str2, h3 h3Var, v2 v2Var) {
        if (v2Var != null) {
            v2Var.a(e6.e.Banner, h3Var.h(), this.b);
        }
    }

    public void a(String str, String str2, h3 h3Var, w2 w2Var) {
        if (w2Var != null) {
            a((Runnable) new j(w2Var, h3Var));
        }
    }

    public void a(String str, String str2, h3 h3Var, x2 x2Var) {
        if (x2Var != null) {
            a((Runnable) new h(x2Var, h3Var));
        }
    }

    public void a(String str, String str2, w9 w9Var) {
        if (w9Var != null) {
            a((Runnable) new g(w9Var));
        }
    }

    public void a(String str, String str2, Map<String, String> map, w9 w9Var) {
        if (w9Var != null) {
            a((Runnable) new e(w9Var));
        }
    }

    public void a(Map<String, String> map, w9 w9Var) {
        if (w9Var != null) {
            a((Runnable) new f(w9Var));
        }
    }

    public void a(JSONObject jSONObject) {
    }

    public void a(JSONObject jSONObject, v2 v2Var) {
        if (v2Var != null) {
            a((Runnable) new c(v2Var, jSONObject));
        }
    }

    public void a(JSONObject jSONObject, w2 w2Var) {
        if (w2Var != null) {
            a((Runnable) new m(w2Var, jSONObject));
        }
    }

    public void a(JSONObject jSONObject, x2 x2Var) {
        if (x2Var != null) {
            a((Runnable) new i(x2Var, jSONObject));
        }
    }

    public boolean a(String str) {
        return false;
    }

    public void b() {
    }

    public void b(Context context) {
    }

    public void b(h3 h3Var, Map<String, String> map, w2 w2Var) {
        if (w2Var != null) {
            a((Runnable) new l(w2Var, h3Var));
        }
    }

    public void b(JSONObject jSONObject) {
    }

    public void c() {
    }

    public void d() {
    }

    public void destroy() {
    }

    public void e() {
    }

    public e6.c getType() {
        return e6.c.Native;
    }
}
