package com.fyber.inneractive.sdk.config;

import android.content.Context;
import android.webkit.RenderProcessGoneDetail;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.fyber.inneractive.sdk.cache.i;
import com.fyber.inneractive.sdk.config.enums.Vendor;
import com.fyber.inneractive.sdk.config.global.l;
import com.fyber.inneractive.sdk.config.global.s;
import com.fyber.inneractive.sdk.external.InneractiveMediationName;
import com.fyber.inneractive.sdk.external.InneractiveUserConfig;
import com.fyber.inneractive.sdk.network.c0;
import com.fyber.inneractive.sdk.network.r0;
import com.fyber.inneractive.sdk.network.y;
import com.fyber.inneractive.sdk.util.IAlog;
import com.fyber.inneractive.sdk.util.f0;
import com.fyber.inneractive.sdk.util.j0;
import com.fyber.inneractive.sdk.util.o;
import com.fyber.inneractive.sdk.util.p;
import com.fyber.inneractive.sdk.util.q;
import com.fyber.inneractive.sdk.util.w;
import com.fyber.inneractive.sdk.util.x;
import com.fyber.inneractive.sdk.util.z0;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArrayList;

public class IAConfigManager {
    public static final IAConfigManager M = new IAConfigManager();
    public static long N;
    public static final Runnable O = new b();
    public final j0 A;
    public c0<c> B;
    public c0<l> C;
    public d D;
    public final com.fyber.inneractive.sdk.ignite.c E;
    public final com.fyber.inneractive.sdk.dv.handler.a F;
    public final i G;
    public final com.fyber.inneractive.sdk.network.c H;
    public final Map<x, w> I;
    public com.fyber.inneractive.sdk.measurement.a J;
    public WebView K;
    public final s L;
    public Map<String, z> a = new HashMap();
    public Map<String, a0> b = new HashMap();
    public String c;
    public String d;
    public String e;
    public Context f;
    public List<OnConfigurationReadyAndValidListener> g;
    public boolean h;
    public final s i;
    public InneractiveUserConfig j;
    public String k;
    public boolean l;
    public String m;
    public InneractiveMediationName n;
    public String o;
    public String p;
    public List<String> q;
    public boolean r;
    public final y s;
    public String t;
    public j u;
    public e v;
    public k w;
    public final f0 x;
    public z0 y;
    public com.fyber.inneractive.sdk.config.global.a z;

    public interface OnConfigurationReadyAndValidListener {
        void onConfigurationReadyAndValid(IAConfigManager iAConfigManager, boolean z, Exception exc);
    }

    public class a extends WebViewClient {
        public a(IAConfigManager iAConfigManager) {
        }

        public boolean onRenderProcessGone(WebView webView, RenderProcessGoneDetail renderProcessGoneDetail) {
            IAConfigManager iAConfigManager = IAConfigManager.M;
            if (iAConfigManager.K == webView) {
                iAConfigManager.K = null;
            }
            f0.a(webView);
            return true;
        }
    }

    public class b implements Runnable {
        public void run() {
            IAConfigManager iAConfigManager = IAConfigManager.M;
            WebView webView = iAConfigManager.K;
            if (webView != null && iAConfigManager.f != null) {
                webView.destroy();
                iAConfigManager.K = iAConfigManager.a(iAConfigManager.f);
            }
        }
    }

    public static class c {
        public String a;
        public String b;
        public String c;
        public Map<String, z> d = new HashMap();
        public Map<String, a0> e = new HashMap();
        public e f = new e();
    }

    public static class d extends Exception {
    }

    public static class e {
        public Set<Vendor> a = new HashSet();
    }

    public IAConfigManager() {
        com.fyber.inneractive.sdk.dv.handler.a aVar;
        new HashSet();
        this.h = false;
        this.i = new s();
        this.l = false;
        this.r = false;
        this.s = new y();
        this.t = "";
        this.x = new f0();
        this.A = new j0();
        this.E = new com.fyber.inneractive.sdk.ignite.c();
        if (p.a("com.google.android.gms.ads.MobileAds", "com.google.android.gms.ads.query.QueryInfoGenerationCallback")) {
            aVar = new com.fyber.inneractive.sdk.dv.handler.c();
        } else {
            aVar = new com.fyber.inneractive.sdk.dv.handler.d();
        }
        this.F = aVar;
        this.G = new i();
        this.H = new com.fyber.inneractive.sdk.network.c();
        this.I = new HashMap();
        this.L = s.b();
        this.g = new CopyOnWriteArrayList();
    }

    public static void a(String str, String str2) {
        q.b.post(new r(str, str2));
    }

    public static void addListener(OnConfigurationReadyAndValidListener onConfigurationReadyAndValidListener) {
        M.g.add(onConfigurationReadyAndValidListener);
    }

    public static e b() {
        return M.v;
    }

    public static j c() {
        return M.u;
    }

    public static com.fyber.inneractive.sdk.ignite.c d() {
        return M.E;
    }

    public static f0 e() {
        return M.x;
    }

    public static z0 f() {
        return M.y;
    }

    public static String g() {
        return M.D.d;
    }

    public static boolean h() {
        return M.e != null;
    }

    public static boolean i() {
        boolean h2 = h();
        int i2 = f.a;
        boolean booleanValue = Boolean.valueOf(System.getProperty("ia.testEnvironmentConfiguration.forceConfigRefresh", Boolean.toString(false))).booleanValue();
        if ((h2 && System.currentTimeMillis() - N > 3600000) || booleanValue) {
            if (booleanValue) {
                j jVar = M.u;
                jVar.d = false;
                q.a(new o(jVar.e));
            }
            a();
            M.G.a();
            com.fyber.inneractive.sdk.web.x xVar = com.fyber.inneractive.sdk.web.x.c;
            xVar.getClass();
            q.a(new com.fyber.inneractive.sdk.web.w(xVar));
        }
        return h2;
    }

    public static void removeListener(OnConfigurationReadyAndValidListener onConfigurationReadyAndValidListener) {
        M.g.remove(onConfigurationReadyAndValidListener);
    }

    public final WebView a(Context context) {
        try {
            WebView webView = new WebView(context);
            webView.setWebViewClient(new a(this));
            return webView;
        } catch (Throwable unused) {
            IAlog.a("failed to create a new webview", new Object[0]);
            return null;
        }
    }

    public final void a(Exception exc) {
        for (OnConfigurationReadyAndValidListener next : this.g) {
            if (next != null) {
                boolean h2 = h();
                IAlog.d("notifying listener configuration state has been resolved", new Object[0]);
                next.onConfigurationReadyAndValid(this, h2, !h2 ? exc : null);
            }
        }
    }

    public static void a() {
        IAConfigManager iAConfigManager = M;
        c0<c> c0Var = iAConfigManager.B;
        if (c0Var != null) {
            iAConfigManager.s.a.offer(c0Var);
            c0Var.a(r0.QUEUED);
        }
        j jVar = iAConfigManager.u;
        if (!jVar.d) {
            jVar.b();
        }
    }
}
