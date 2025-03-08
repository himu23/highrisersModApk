package com.ironsource.mediationsdk;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import com.ironsource.environment.ContextProvider;
import com.ironsource.environment.StringUtils;
import com.ironsource.jc;
import com.ironsource.k0;
import com.ironsource.k8;
import com.ironsource.m3;
import com.ironsource.mediationsdk.IronSource;
import com.ironsource.mediationsdk.config.ConfigFile;
import com.ironsource.mediationsdk.logger.IronLog;
import com.ironsource.mediationsdk.utils.IronSourceConstants;
import com.ironsource.mediationsdk.utils.IronSourceUtils;
import com.ironsource.w6;
import com.ironsource.w8;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONException;
import org.json.JSONObject;

class c0 {
    private static c0 c;
    private JSONObject a = new JSONObject();
    private final w6 b = w8.e().b();

    class a implements Runnable {
        a() {
        }

        public void run() {
            try {
                c0 c0Var = c0.this;
                c0Var.a(c0Var.c());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private c0() {
    }

    /* access modifiers changed from: private */
    public void a(JSONObject jSONObject) {
        Iterator<String> keys = jSONObject.keys();
        while (keys.hasNext()) {
            String next = keys.next();
            a(next, jSONObject.opt(next));
        }
    }

    private void b() {
        a(e());
        a(d());
    }

    /* access modifiers changed from: private */
    public JSONObject c() {
        String str;
        JSONObject jSONObject = new JSONObject();
        Context applicationContext = ContextProvider.getInstance().getApplicationContext();
        if (applicationContext != null) {
            try {
                String N = m3.N(applicationContext);
                String O = m3.O(applicationContext);
                if (!TextUtils.isEmpty(N)) {
                    str = IronSourceConstants.TYPE_GAID;
                } else {
                    N = m3.z(applicationContext);
                    str = !TextUtils.isEmpty(N) ? IronSourceConstants.TYPE_UUID : "";
                }
                if (!TextUtils.isEmpty(N)) {
                    jSONObject.put(jc.b, N);
                    jSONObject.put(jc.D, str);
                }
                if (!TextUtils.isEmpty(O)) {
                    jSONObject.put(jc.E, Boolean.parseBoolean(O));
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return jSONObject;
    }

    public static synchronized c0 f() {
        c0 c0Var;
        synchronized (c0.class) {
            if (c == null) {
                c = new c0();
            }
            c0Var = c;
        }
        return c0Var;
    }

    /* access modifiers changed from: package-private */
    public void a() {
        try {
            new Thread(new a()).start();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* access modifiers changed from: package-private */
    public synchronized void a(String str, Object obj) {
        try {
            this.a.put(str, obj);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return;
    }

    /* access modifiers changed from: package-private */
    public JSONObject d() {
        JSONObject jSONObject = new JSONObject();
        Context applicationContext = ContextProvider.getInstance().getApplicationContext();
        int q = m3.q();
        int p = m3.p();
        float g = m3.g();
        if (applicationContext != null) {
            try {
                ConcurrentHashMap<String, List<String>> c2 = c.b().c();
                c2.putAll(k8.b().c());
                JSONObject jSONObject2 = new JSONObject();
                for (Map.Entry next : c2.entrySet()) {
                    jSONObject2.put((String) next.getKey(), next.getValue());
                }
                Boolean j = p.o().j();
                if (j != null) {
                    jSONObject.put("consent", j.booleanValue());
                }
                String P = m3.P(applicationContext);
                if (!TextUtils.isEmpty(P)) {
                    jSONObject.put("asid", P);
                }
                jSONObject.put(jc.f, IronSourceUtils.getConnectionType(applicationContext));
                jSONObject.put(jc.V, (double) m3.B(applicationContext));
                jSONObject.put(jc.y, m3.s());
                jSONObject.put("bat", m3.h(applicationContext));
                jSONObject.put(jc.z, m3.e());
                jSONObject.put(jc.B, jSONObject2);
                jSONObject.put(jc.j, new Date().getTime());
                jSONObject.put(jc.g, q);
                jSONObject.put(jc.h, p);
                jSONObject.put(jc.M, String.valueOf(g));
                jSONObject.put(jc.l, this.b.a(IronSource.AD_UNIT.INTERSTITIAL));
                jSONObject.put(jc.k, this.b.a(IronSource.AD_UNIT.REWARDED_VIDEO));
                jSONObject.put(jc.G, m3.f());
            } catch (JSONException e) {
                IronLog ironLog = IronLog.INTERNAL;
                ironLog.error("got the following error " + e.getMessage());
                e.printStackTrace();
            }
        }
        return jSONObject;
    }

    /* access modifiers changed from: package-private */
    public JSONObject e() {
        JSONObject jSONObject = new JSONObject();
        Context applicationContext = ContextProvider.getInstance().getApplicationContext();
        if (applicationContext != null) {
            try {
                String language = applicationContext.getResources().getConfiguration().locale.getLanguage();
                if (!TextUtils.isEmpty(language)) {
                    jSONObject.put(jc.A, StringUtils.toUpperCase(language));
                }
                String pluginType = ConfigFile.getConfigFile().getPluginType();
                if (!TextUtils.isEmpty(pluginType)) {
                    jSONObject.put(jc.n, pluginType);
                }
                String c2 = m3.c();
                if (c2 != null) {
                    jSONObject.put(jc.p, c2);
                    jSONObject.put(jc.o, c2.replaceAll("[^0-9/.]", ""));
                }
                String f = m3.f(applicationContext);
                if (f != null) {
                    jSONObject.put("auid", f);
                }
                jSONObject.put(jc.m, IronSourceUtils.getSessionId());
                jSONObject.put("appKey", p.o().p());
                jSONObject.put(jc.d, m3.x(applicationContext));
                jSONObject.put(jc.e, IronSourceUtils.getSDKVersion());
                jSONObject.put(jc.i, Build.MODEL);
                jSONObject.put(jc.q, "android");
                jSONObject.put(jc.r, Build.MANUFACTURER);
                jSONObject.put(jc.s, String.valueOf(Build.VERSION.SDK_INT));
                jSONObject.put(jc.t, applicationContext.getPackageName());
                jSONObject.put(jc.u, k0.b(applicationContext, applicationContext.getPackageName()));
                String q = p.o().q();
                if (!TextUtils.isEmpty(q)) {
                    jSONObject.put(jc.v, q);
                }
            } catch (JSONException e) {
                IronLog ironLog = IronLog.INTERNAL;
                ironLog.error("got the following error " + e.getMessage());
                e.printStackTrace();
            }
        }
        return jSONObject;
    }

    /* access modifiers changed from: package-private */
    public JSONObject g() {
        b();
        return this.a;
    }
}
