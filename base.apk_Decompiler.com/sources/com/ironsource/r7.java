package com.ironsource;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.text.TextUtils;
import com.ironsource.e6;
import com.ironsource.m2;
import com.ironsource.mediationsdk.utils.IronSourceConstants;
import com.ironsource.sdk.controller.FeaturesManager;
import com.ironsource.sdk.utils.IronSourceStorageUtils;
import com.ironsource.sdk.utils.Logger;
import com.ironsource.sdk.utils.SDKUtils;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public final class r7 implements bb, x2, w2, u2, v2, x7, x9 {
    private static final String m = "IronSourceAdsPublisherAgent";
    private static r7 n;
    private final String a = IronSourceConstants.SUPERSONIC_CONFIG_NAME;
    /* access modifiers changed from: private */
    public com.ironsource.sdk.controller.e b;
    /* access modifiers changed from: private */
    public w9 c;
    /* access modifiers changed from: private */
    public String d;
    /* access modifiers changed from: private */
    public String e;
    private long f;
    /* access modifiers changed from: private */
    public i3 g;
    private nc h;
    private k9 i;
    private boolean j = false;
    private o2 k;
    private FeaturesManager l = FeaturesManager.getInstance();

    class a implements Runnable {
        final /* synthetic */ JSONObject a;

        a(JSONObject jSONObject) {
            this.a = jSONObject;
        }

        public void run() {
            r7.this.b.a(this.a, (w2) r7.this);
        }
    }

    class b implements Runnable {
        final /* synthetic */ JSONObject a;

        b(JSONObject jSONObject) {
            this.a = jSONObject;
        }

        public void run() {
            r7.this.b.a(this.a);
        }
    }

    class c implements Runnable {
        final /* synthetic */ p7 a;
        final /* synthetic */ Map b;

        c(p7 p7Var, Map map) {
            this.a = p7Var;
            this.b = map;
        }

        public void run() {
            e6.e eVar = this.a.g() ? e6.e.Banner : e6.e.Interstitial;
            h3 a2 = r7.this.g.a(eVar, this.a);
            g6 g6Var = new g6();
            g6Var.a(z3.w, Boolean.valueOf(this.a.h())).a(z3.F, Boolean.valueOf(this.a.j())).a(z3.u, this.a.e()).a(z3.v, y7.a(this.a)).a(z3.G, Long.valueOf(j.a.b(this.a.d())));
            l6.a(za.h, (Map<String, Object>) g6Var.a());
            if (eVar == e6.e.Banner) {
                r7.this.b.a(r7.this.d, r7.this.e, a2, (v2) r7.this);
                r7.this.b.a(a2, (Map<String, String>) this.b, (v2) r7.this);
                return;
            }
            r7.this.b.a(r7.this.d, r7.this.e, a2, (w2) r7.this);
            r7.this.b.b(a2, this.b, r7.this);
        }
    }

    class d implements Runnable {
        final /* synthetic */ h3 a;
        final /* synthetic */ Map b;

        d(h3 h3Var, Map map) {
            this.a = h3Var;
            this.b = map;
        }

        public void run() {
            r7.this.b.a(this.a, (Map<String, String>) this.b, (w2) r7.this);
        }
    }

    class e implements Runnable {
        final /* synthetic */ p7 a;

        e(p7 p7Var) {
            this.a = p7Var;
        }

        public void run() {
            h3 a2 = r7.this.g.a(e6.e.Banner, this.a);
            g6 g6Var = new g6();
            g6Var.a(z3.w, Boolean.valueOf(this.a.h())).a(z3.u, this.a.e()).a(z3.v, y7.a(this.a));
            l6.a(za.m, (Map<String, Object>) g6Var.a());
            r7.this.b.a(a2);
        }
    }

    class f implements Runnable {
        final /* synthetic */ String a;
        final /* synthetic */ String b;
        final /* synthetic */ h3 c;

        f(String str, String str2, h3 h3Var) {
            this.a = str;
            this.b = str2;
            this.c = h3Var;
        }

        public void run() {
            r7.this.b.a(this.a, this.b, this.c, (x2) r7.this);
        }
    }

    class g implements Runnable {
        final /* synthetic */ JSONObject a;

        g(JSONObject jSONObject) {
            this.a = jSONObject;
        }

        public void run() {
            r7.this.b.a(this.a, (x2) r7.this);
        }
    }

    class h implements Runnable {
        final /* synthetic */ String a;
        final /* synthetic */ String b;
        final /* synthetic */ Map c;
        final /* synthetic */ w9 d;

        h(String str, String str2, Map map, w9 w9Var) {
            this.a = str;
            this.b = str2;
            this.c = map;
            this.d = w9Var;
        }

        public void run() {
            r7.this.b.a(this.a, this.b, (Map<String, String>) this.c, this.d);
        }
    }

    class i implements Runnable {
        final /* synthetic */ Map a;
        final /* synthetic */ w9 b;

        i(Map map, w9 w9Var) {
            this.a = map;
            this.b = w9Var;
        }

        public void run() {
            r7.this.b.a(r7.this.d, r7.this.e, (Map<String, String>) this.a, this.b);
        }
    }

    class j implements Runnable {
        final /* synthetic */ Map a;

        j(Map map) {
            this.a = map;
        }

        public void run() {
            r7.this.b.a((Map<String, String>) this.a, r7.this.c);
        }
    }

    class k implements Runnable {
        final /* synthetic */ String a;
        final /* synthetic */ String b;
        final /* synthetic */ w9 c;

        k(String str, String str2, w9 w9Var) {
            this.a = str;
            this.b = str2;
            this.c = w9Var;
        }

        public void run() {
            r7.this.b.a(this.a, this.b, this.c);
        }
    }

    class l implements Runnable {
        final /* synthetic */ w9 a;

        l(w9 w9Var) {
            this.a = w9Var;
        }

        public void run() {
            r7.this.b.a(r7.this.d, r7.this.e, this.a);
        }
    }

    class m implements Runnable {
        final /* synthetic */ String a;
        final /* synthetic */ String b;
        final /* synthetic */ h3 c;

        m(String str, String str2, h3 h3Var) {
            this.a = str;
            this.b = str2;
            this.c = h3Var;
        }

        public void run() {
            r7.this.b.a(this.a, this.b, this.c, (w2) r7.this);
        }
    }

    class n implements Runnable {
        final /* synthetic */ String a;

        n(String str) {
            this.a = str;
        }

        public void run() {
            r7.this.b.a(this.a, (w2) r7.this);
        }
    }

    private r7(Context context, int i2) {
        c(context);
    }

    r7(String str, String str2, Context context) {
        this.d = str;
        this.e = str2;
        c(context);
    }

    private nc a(Context context) {
        nc d2 = nc.d();
        d2.c();
        d2.a(context, this.d, this.e);
        return d2;
    }

    public static synchronized r7 a(Context context, int i2) throws Exception {
        r7 r7Var;
        synchronized (r7.class) {
            Logger.i(m, "getInstance()");
            if (n == null) {
                n = new r7(context, i2);
            }
            r7Var = n;
        }
        return r7Var;
    }

    private s9 a(h3 h3Var) {
        if (h3Var == null) {
            return null;
        }
        return (s9) h3Var.i();
    }

    public static x7 a(Context context, String str, String str2) {
        return a(str, str2, context);
    }

    public static synchronized x7 a(String str, String str2, Context context) {
        r7 r7Var;
        synchronized (r7.class) {
            if (n == null) {
                l6.a(za.a);
                n = new r7(str, str2, context);
            } else {
                nc.d().a(str);
                nc.d().b(str2);
            }
            r7Var = n;
        }
        return r7Var;
    }

    private Map<String, String> a(Map<String, String> map) {
        map.put("adm", SDKUtils.decodeString(map.get("adm")));
        return map;
    }

    public static synchronized r7 b(Context context) throws Exception {
        r7 a2;
        synchronized (r7.class) {
            a2 = a(context, 0);
        }
        return a2;
    }

    private t9 b(h3 h3Var) {
        if (h3Var == null) {
            return null;
        }
        return (t9) h3Var.i();
    }

    private void b(p7 p7Var, Map<String, String> map) {
        Logger.d(m, "loadOnNewInstance " + p7Var.d());
        this.b.a((Runnable) new c(p7Var, map));
    }

    private z9 c(h3 h3Var) {
        if (h3Var == null) {
            return null;
        }
        return (z9) h3Var.i();
    }

    private void c(Context context) {
        try {
            JSONObject networkConfiguration = SDKUtils.getNetworkConfiguration();
            d8.a(context);
            IronSourceStorageUtils.initializeCacheDirectory(context, new ob(SDKUtils.getNetworkConfiguration().optJSONObject(m2.a.i)));
            d8.e().d(SDKUtils.getSDKVersion());
            this.h = a(context);
            this.g = new i3();
            o2 o2Var = new o2();
            this.k = o2Var;
            if (context instanceof Activity) {
                o2Var.a((Activity) context);
            }
            int debugMode = this.l.getDebugMode();
            this.i = new k9();
            this.b = new com.ironsource.sdk.controller.e(context, this.k, this.h, this.g, n5.a, debugMode, this.l.getDataManagerConfig(), this.d, this.e, this.i);
            Logger.enableLogging(debugMode);
            Logger.i(m, "C'tor");
            a(context, networkConfiguration);
            this.i.d();
            this.i.e();
            this.i.a(context);
            this.i.b();
            this.i.a();
            this.i.b(context);
            this.i.c();
            this.f = 0;
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    private void c(p7 p7Var, Map<String, String> map) {
        try {
            map = a(map);
        } catch (Exception e2) {
            g6 a2 = new g6().a(z3.z, e2.getMessage()).a(z3.w, Boolean.valueOf(p7Var.h())).a(z3.F, Boolean.valueOf(p7Var.j())).a(z3.u, p7Var.e()).a(z3.v, y7.a(p7Var)).a(z3.G, Long.valueOf(j.a.b(p7Var.d())));
            j.a.a(p7Var.d());
            l6.a(za.k, (Map<String, Object>) a2.a());
            e2.printStackTrace();
            Logger.d(m, "loadInAppBiddingAd failed decoding  ADM " + e2.getMessage());
        }
        b(p7Var, map);
    }

    private h3 d(e6.e eVar, String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return this.g.a(eVar, str);
    }

    private void e(JSONObject jSONObject) {
        if (jSONObject != null && jSONObject.has(m2.i.Z)) {
            try {
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("consent", Boolean.parseBoolean(jSONObject.getString(m2.i.Z)));
                this.h.a(jSONObject2);
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
        }
    }

    public com.ironsource.sdk.controller.e a() {
        return this.b;
    }

    public void a(Activity activity) {
        try {
            Logger.i(m, "release()");
            l3.g();
            this.k.b();
            this.b.a((Context) activity);
            this.b.destroy();
            this.b = null;
        } catch (Exception unused) {
        }
        n = null;
    }

    public void a(Activity activity, p7 p7Var, Map<String, String> map) {
        this.k.a(activity);
        Logger.i(m, "showAd " + p7Var.d());
        h3 a2 = this.g.a(e6.e.Interstitial, p7Var.d());
        if (a2 != null) {
            this.b.a((Runnable) new d(a2, map));
        }
    }

    public void a(Activity activity, Map<String, String> map) {
        if (activity != null) {
            this.k.a(activity);
        }
        this.b.a((Runnable) new j(map));
    }

    public void a(Context context, JSONObject jSONObject) {
        boolean optBoolean = jSONObject.optBoolean(m2.a.f, false);
        this.j = optBoolean;
        if (optBoolean) {
            try {
                ((Application) context).registerActivityLifecycleCallbacks(new e(this));
            } catch (Throwable th) {
                g6 g6Var = new g6();
                g6Var.a(z3.x, th.getMessage());
                l6.a(za.u, (Map<String, Object>) g6Var.a());
            }
        }
    }

    public void a(e6.e eVar, String str) {
        t9 b2;
        h3 d2 = d(eVar, str);
        if (d2 == null) {
            return;
        }
        if (eVar == e6.e.RewardedVideo) {
            z9 c2 = c(d2);
            if (c2 != null) {
                c2.c();
            }
        } else if (eVar == e6.e.Interstitial && (b2 = b(d2)) != null) {
            b2.onInterstitialClose();
        }
    }

    public void a(e6.e eVar, String str, e0 e0Var) {
        s9 a2;
        h3 d2 = d(eVar, str);
        if (d2 != null) {
            d2.b(2);
            if (eVar == e6.e.RewardedVideo) {
                z9 c2 = c(d2);
                if (c2 != null) {
                    c2.a(e0Var);
                }
            } else if (eVar == e6.e.Interstitial) {
                t9 b2 = b(d2);
                if (b2 != null) {
                    b2.onInterstitialInitSuccess();
                }
            } else if (eVar == e6.e.Banner && (a2 = a(d2)) != null) {
                a2.onBannerInitSuccess();
            }
        }
    }

    public void a(e6.e eVar, String str, String str2) {
        s9 a2;
        h3 d2 = d(eVar, str);
        g6 a3 = new g6().a(z3.u, str).a(z3.v, eVar).a(z3.z, str2);
        if (d2 != null) {
            j jVar = j.a;
            a3.a(z3.G, Long.valueOf(jVar.b(d2.h())));
            a3.a(z3.w, Boolean.valueOf(m6.a(d2)));
            jVar.a(d2.h());
            d2.b(3);
            if (eVar == e6.e.RewardedVideo) {
                z9 c2 = c(d2);
                if (c2 != null) {
                    c2.b(str2);
                }
            } else if (eVar == e6.e.Interstitial) {
                t9 b2 = b(d2);
                if (b2 != null) {
                    b2.onInterstitialInitFailed(str2);
                }
            } else if (eVar == e6.e.Banner && (a2 = a(d2)) != null) {
                a2.onBannerLoadFail(str2);
            }
        }
        l6.a(za.i, (Map<String, Object>) a3.a());
    }

    public void a(e6.e eVar, String str, String str2, JSONObject jSONObject) {
        s9 a2;
        h3 d2 = d(eVar, str);
        if (d2 != null && !TextUtils.isEmpty(str2)) {
            try {
                Logger.i(m, "Received Event Notification: " + str2 + " for demand source: " + d2.f());
                if (eVar == e6.e.Interstitial) {
                    t9 b2 = b(d2);
                    if (b2 != null) {
                        jSONObject.put("demandSourceName", str);
                        b2.onInterstitialEventNotificationReceived(str2, jSONObject);
                    }
                } else if (eVar == e6.e.RewardedVideo) {
                    z9 c2 = c(d2);
                    if (c2 != null) {
                        jSONObject.put("demandSourceName", str);
                        c2.a(str2, jSONObject);
                    }
                } else if (eVar == e6.e.Banner && (a2 = a(d2)) != null) {
                    jSONObject.put("demandSourceName", str);
                    if (str2.equalsIgnoreCase(m2.h.z)) {
                        a2.onBannerShowSuccess();
                    }
                }
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
        }
    }

    public void a(p7 p7Var, Map<String, String> map) {
        long currentTimeMillis = System.currentTimeMillis();
        map.put(m2.h.y0, String.valueOf(currentTimeMillis));
        j.a.a(p7Var.d(), currentTimeMillis);
        g6 g6Var = new g6();
        g6Var.a(z3.w, Boolean.valueOf(p7Var.h())).a(z3.F, Boolean.valueOf(p7Var.j())).a(z3.u, p7Var.e()).a(z3.v, y7.a(p7Var)).a(z3.G, Long.valueOf(currentTimeMillis));
        l6.a(za.f, (Map<String, Object>) g6Var.a());
        Logger.d(m, "loadAd " + p7Var.d());
        if (p7Var.i()) {
            c(p7Var, map);
        } else {
            b(p7Var, map);
        }
    }

    public void a(w9 w9Var) {
        this.b.a((Runnable) new l(w9Var));
    }

    public void a(String str, int i2) {
        z9 c2;
        h3 d2 = d(e6.e.RewardedVideo, str);
        if (d2 != null && (c2 = c(d2)) != null) {
            c2.a(i2);
        }
    }

    public void a(String str, x5 x5Var) {
        s9 a2;
        h3 d2 = d(e6.e.Banner, str);
        if (d2 != null && (a2 = a(d2)) != null) {
            a2.onBannerLoadSuccess(d2.c(), x5Var);
        }
    }

    public void a(String str, String str2) {
        s9 a2;
        h3 d2 = d(e6.e.Banner, str);
        if (d2 != null && (a2 = a(d2)) != null) {
            a2.onBannerLoadFail(str2);
        }
    }

    public void a(String str, String str2, int i2) {
        e6.e productType;
        h3 a2;
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2) && (productType = SDKUtils.getProductType(str)) != null && (a2 = this.g.a(productType, str2)) != null) {
            a2.c(i2);
        }
    }

    public void a(String str, String str2, w9 w9Var) {
        this.d = str;
        this.e = str2;
        this.b.a((Runnable) new k(str, str2, w9Var));
    }

    public void a(String str, String str2, String str3, Map<String, String> map, t9 t9Var) {
        this.d = str;
        this.e = str2;
        this.b.a((Runnable) new m(str, str2, this.g.a(e6.e.Interstitial, str3, map, t9Var)));
    }

    public void a(String str, String str2, String str3, Map<String, String> map, z9 z9Var) {
        this.d = str;
        this.e = str2;
        this.b.a((Runnable) new f(str, str2, this.g.a(e6.e.RewardedVideo, str3, map, z9Var)));
    }

    public void a(String str, String str2, Map<String, String> map, w9 w9Var) {
        this.d = str;
        this.e = str2;
        this.c = w9Var;
        this.b.a((Runnable) new h(str, str2, map, w9Var));
    }

    public void a(Map<String, String> map, w9 w9Var) {
        this.c = w9Var;
        this.b.a((Runnable) new i(map, w9Var));
    }

    public void a(JSONObject jSONObject) {
        e(jSONObject);
        this.b.a((Runnable) new b(jSONObject));
    }

    public boolean a(p7 p7Var) {
        Logger.d(m, "isAdAvailable " + p7Var.d());
        h3 a2 = this.g.a(e6.e.Interstitial, p7Var.d());
        if (a2 == null) {
            return false;
        }
        return a2.d();
    }

    public boolean a(String str) {
        return this.b.a(str);
    }

    public void b(Activity activity) {
        try {
            this.b.b();
            this.b.a((Context) activity);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public void b(Activity activity, p7 p7Var, Map<String, String> map) {
        this.k.a(activity);
        a(p7Var, map);
    }

    public void b(e6.e eVar, String str) {
        z9 c2;
        h3 d2 = d(eVar, str);
        if (d2 == null) {
            return;
        }
        if (eVar == e6.e.Interstitial) {
            t9 b2 = b(d2);
            if (b2 != null) {
                b2.onInterstitialOpen();
            }
        } else if (eVar == e6.e.RewardedVideo && (c2 = c(d2)) != null) {
            c2.a();
        }
    }

    public void b(p7 p7Var) {
        Logger.d(m, "destroyInstance " + p7Var.d());
        this.b.a((Runnable) new e(p7Var));
    }

    public void b(String str) {
        e6.e eVar = e6.e.Interstitial;
        h3 d2 = d(eVar, str);
        g6 a2 = new g6().a(z3.u, str);
        if (d2 != null) {
            g6 a3 = a2.a(z3.v, m6.a(d2, eVar)).a(z3.w, Boolean.valueOf(m6.a(d2)));
            j jVar = j.a;
            a3.a(z3.G, Long.valueOf(jVar.b(d2.h())));
            jVar.a(d2.h());
            t9 b2 = b(d2);
            if (b2 != null) {
                b2.onInterstitialLoadSuccess();
            }
        }
        l6.a(za.l, (Map<String, Object>) a2.a());
    }

    public void b(String str, String str2) {
        t9 b2;
        h3 d2 = d(e6.e.Interstitial, str);
        if (d2 != null && (b2 = b(d2)) != null) {
            b2.onInterstitialShowFailed(str2);
        }
    }

    public void b(JSONObject jSONObject) {
        this.b.a((Runnable) new g(jSONObject));
    }

    public void c(Activity activity) {
        this.k.a(activity);
        this.b.d();
        this.b.b((Context) activity);
    }

    public void c(e6.e eVar, String str) {
        s9 a2;
        h3 d2 = d(eVar, str);
        if (d2 == null) {
            return;
        }
        if (eVar == e6.e.RewardedVideo) {
            z9 c2 = c(d2);
            if (c2 != null) {
                c2.d();
            }
        } else if (eVar == e6.e.Interstitial) {
            t9 b2 = b(d2);
            if (b2 != null) {
                b2.onInterstitialClick();
            }
        } else if (eVar == e6.e.Banner && (a2 = a(d2)) != null) {
            a2.onBannerClick();
        }
    }

    public void c(String str) {
        t9 b2;
        h3 d2 = d(e6.e.Interstitial, str);
        if (d2 != null && (b2 = b(d2)) != null) {
            b2.onInterstitialShowSuccess();
        }
    }

    public void c(String str, String str2) {
        e6.e eVar = e6.e.Interstitial;
        h3 d2 = d(eVar, str);
        g6 g6Var = new g6();
        g6Var.a(z3.z, str2).a(z3.u, str);
        if (d2 != null) {
            g6 a2 = g6Var.a(z3.v, m6.a(d2, eVar)).a(z3.x, d2.e() == 2 ? z3.D : z3.E).a(z3.w, Boolean.valueOf(m6.a(d2)));
            j jVar = j.a;
            a2.a(z3.G, Long.valueOf(jVar.b(d2.h())));
            jVar.a(d2.h());
            t9 b2 = b(d2);
            if (b2 != null) {
                b2.onInterstitialLoadFailed(str2);
            }
        }
        l6.a(za.g, (Map<String, Object>) g6Var.a());
    }

    public void c(JSONObject jSONObject) {
        if (jSONObject != null) {
            String optString = jSONObject.optString("demandSourceName");
            if (!TextUtils.isEmpty(optString)) {
                this.b.a((Runnable) new n(optString));
            }
        }
    }

    public void d(String str) {
        z9 c2;
        h3 d2 = d(e6.e.RewardedVideo, str);
        if (d2 != null && (c2 = c(d2)) != null) {
            c2.b();
        }
    }

    public void d(String str, String str2) {
        z9 c2;
        h3 d2 = d(e6.e.RewardedVideo, str);
        if (d2 != null && (c2 = c(d2)) != null) {
            c2.a(str2);
        }
    }

    public void d(JSONObject jSONObject) {
        this.b.a((Runnable) new a(jSONObject));
    }

    public void onInterstitialAdRewarded(String str, int i2) {
        h3 d2 = d(e6.e.Interstitial, str);
        t9 b2 = b(d2);
        if (d2 != null && b2 != null) {
            b2.onInterstitialAdRewarded(str, i2);
        }
    }

    public void onPause(Activity activity) {
        if (!this.j) {
            b(activity);
        }
    }

    public void onResume(Activity activity) {
        if (!this.j) {
            c(activity);
        }
    }
}
