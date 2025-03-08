package com.fyber.inneractive.sdk.web;

import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import com.fyber.inneractive.sdk.config.IAConfigManager;
import com.fyber.inneractive.sdk.config.global.s;
import com.fyber.inneractive.sdk.external.InneractiveAdRequest;
import com.fyber.inneractive.sdk.external.InneractiveErrorCode;
import com.fyber.inneractive.sdk.external.InneractiveInfrastructureError;
import com.fyber.inneractive.sdk.flow.q;
import com.fyber.inneractive.sdk.measurement.a;
import com.fyber.inneractive.sdk.util.IAlog;
import com.fyber.inneractive.sdk.util.b0;
import com.fyber.inneractive.sdk.util.d0;
import com.fyber.inneractive.sdk.util.p0;
import com.fyber.inneractive.sdk.util.t;
import com.fyber.inneractive.sdk.util.u0;
import com.fyber.inneractive.sdk.web.b;
import com.fyber.inneractive.sdk.web.b0;
import com.fyber.inneractive.sdk.web.g;
import com.fyber.inneractive.sdk.web.u;

public abstract class d<L extends b0> implements f, d0.e, g.a, u.a {
    public boolean a = false;
    public g b;
    public p c;
    public q d;
    public boolean e;
    public C0138d f;
    public L g;
    public float h = 0.0f;
    public Rect i = new Rect();
    public boolean j;
    public boolean k;
    public c l;
    public final Runnable m;
    public final Runnable n;
    public com.fyber.inneractive.sdk.util.b<Void, Void, String> o;
    public String p;
    public String q;
    public InneractiveAdRequest r;
    public q s;
    public com.fyber.inneractive.sdk.response.e t;

    public class a implements Runnable {
        public a() {
        }

        public void run() {
            IAlog.d("Removing clicked state after timeout", new Object[0]);
            d.this.j();
        }
    }

    public class b implements Runnable {
        public b() {
        }

        public void run() {
            d dVar = d.this;
            if (dVar.k) {
                IAlog.a("No user web action detected for : %s blocking.", dVar.l);
                d dVar2 = d.this;
                String c = dVar2.l.c();
                String a2 = d.this.l.a();
                L l = dVar2.g;
                if (l != null) {
                    l.a(c, a2);
                }
                int i = IAlog.a;
                IAlog.a(1, (Exception) null, "AD_AUTO_CLICK_DETECTED", new Object[0]);
                d.this.l.b();
                d.this.j();
            } else {
                IAlog.a("User web action detected for: %s", dVar.l);
                d.this.l.d();
            }
            d.this.l = null;
        }
    }

    public interface c {
        String a();

        void b();

        String c();

        void d();
    }

    /* renamed from: com.fyber.inneractive.sdk.web.d$d  reason: collision with other inner class name */
    public interface C0138d {
        void a(d dVar);

        void a(d dVar, InneractiveInfrastructureError inneractiveInfrastructureError);
    }

    public class e implements c {
        public String a;
        public p0 b;

        public e(String str, p0 p0Var) {
            this.b = p0Var;
            this.a = str;
        }

        public String a() {
            return null;
        }

        public void b() {
        }

        public String c() {
            return "open";
        }

        public String toString() {
            return "action: open url: " + this.a;
        }

        public void d() {
            d dVar = d.this;
            String str = this.a;
            p0 p0Var = this.b;
            L l = dVar.g;
            if (l != null) {
                b0.d dVar2 = l.a(str, p0Var, (b.a) null).a;
            }
        }
    }

    public d(boolean z, boolean z2, s sVar) {
        this.k = z;
        this.b = a(sVar);
        this.e = z2;
        this.n = new a();
        this.m = new b();
    }

    public void a(int i2) {
    }

    public void a(WebView webView) {
    }

    public abstract boolean a(String str, p0 p0Var);

    public void b(boolean z) {
        IAlog.a("%s destroy is fatal: %b", IAlog.a((Object) this), Boolean.valueOf(z));
        com.fyber.inneractive.sdk.util.b<Void, Void, String> bVar = this.o;
        if (bVar != null && !bVar.b()) {
            this.o.c();
            this.o = null;
        }
        g gVar = this.b;
        if (gVar != null) {
            d0.d.a.a(gVar);
            com.fyber.inneractive.sdk.util.u.a((View) this.b);
            this.b.setWebChromeClient((WebChromeClient) null);
            if (d() == null) {
                this.b.destroy();
            } else {
                ((com.fyber.inneractive.sdk.measurement.tracker.c) d()).a(z);
            }
        }
        q qVar = this.d;
        if (qVar != null) {
            qVar.e = null;
        }
        Runnable runnable = this.n;
        if (runnable != null) {
            com.fyber.inneractive.sdk.util.q.b.removeCallbacks(runnable);
        }
        Runnable runnable2 = this.m;
        if (runnable2 != null) {
            com.fyber.inneractive.sdk.util.q.b.removeCallbacks(runnable2);
        }
        this.g = null;
        if (!z) {
            this.f = null;
        }
        this.b = null;
        this.c = null;
        this.d = null;
        this.s = null;
        this.r = null;
    }

    public void c() {
        b(false);
    }

    public abstract a.C0101a d();

    public g e() {
        return this.b;
    }

    public void h() {
        WebSettings settings = this.b.getSettings();
        settings.setJavaScriptEnabled(true);
        settings.setLoadsImagesAutomatically(true);
        settings.setJavaScriptCanOpenWindowsAutomatically(true);
        if (!IAConfigManager.M.r && t.a()) {
            settings.setMixedContentMode(2);
        }
        if (this.e) {
            settings.setMediaPlaybackRequiresUserGesture(false);
        }
        g gVar = this.b;
        gVar.setHorizontalScrollBarEnabled(false);
        gVar.setHorizontalScrollbarOverlay(false);
        gVar.setVerticalScrollBarEnabled(false);
        gVar.setVerticalScrollbarOverlay(false);
        gVar.getSettings().setSupportZoom(false);
        this.b.getClass();
        this.b.setFocusable(true);
        this.b.setBackgroundColor(0);
        p pVar = new p();
        this.c = pVar;
        this.b.setWebChromeClient(pVar);
        try {
            WebView.setWebContentsDebuggingEnabled(true);
        } catch (Exception unused) {
            IAlog.a("Could not set web contents debugging flag", new Object[0]);
        }
        this.b.setListener(this);
    }

    public void i() {
        this.b.setTapListener(this);
    }

    public void j() {
        IAlog.a("IAWebViewController resetClick()", new Object[0]);
        Runnable runnable = this.n;
        if (runnable != null) {
            com.fyber.inneractive.sdk.util.q.b.removeCallbacks(runnable);
        }
        Runnable runnable2 = this.m;
        if (runnable2 != null) {
            com.fyber.inneractive.sdk.util.q.b.removeCallbacks(runnable2);
        }
        this.j = false;
    }

    public void setAdContent(q qVar) {
        this.s = qVar;
    }

    public void setAdRequest(InneractiveAdRequest inneractiveAdRequest) {
        this.r = inneractiveAdRequest;
    }

    public void setAdResponse(com.fyber.inneractive.sdk.response.e eVar) {
        this.t = eVar;
    }

    public void setListener(L l2) {
        this.g = l2;
    }

    public p0 f() {
        g gVar = this.b;
        return gVar != null ? gVar.getLastClickedLocation() : p0.a();
    }

    public void g() {
        C0138d dVar = this.f;
        if (dVar != null) {
            dVar.a(this);
        }
    }

    public void a(String str, String str2, String str3, String str4, C0138d dVar, boolean z) {
        this.f = dVar;
        try {
            h();
            e eVar = new e(this, str2, z, str3, str4, str);
            this.o = eVar;
            eVar.a().post(new com.fyber.inneractive.sdk.util.c(eVar, (Object[]) null));
        } catch (Throwable th) {
            InneractiveInfrastructureError inneractiveInfrastructureError = new InneractiveInfrastructureError(InneractiveErrorCode.SDK_INTERNAL_ERROR, com.fyber.inneractive.sdk.flow.g.COULD_NOT_CONFIGURE_WEBVIEW, th);
            C0138d dVar2 = this.f;
            if (dVar2 != null) {
                dVar2.a(this, inneractiveInfrastructureError);
            }
            b(true);
        }
    }

    public void a(ViewGroup viewGroup, ViewGroup.LayoutParams layoutParams) {
        g gVar = this.b;
        if (gVar != null) {
            if (layoutParams != null) {
                viewGroup.addView(gVar, layoutParams);
            } else {
                viewGroup.addView(gVar);
            }
            d0.d.a.a(viewGroup.getContext(), (View) this.b, (d0.e) this);
            this.b.setTapListener(this);
        }
    }

    public g a(s sVar) {
        int i2;
        int i3;
        int i4;
        boolean z;
        g gVar = new g();
        int i5 = 500;
        int i6 = 2;
        if (sVar != null) {
            com.fyber.inneractive.sdk.config.global.features.e eVar = (com.fyber.inneractive.sdk.config.global.features.e) sVar.a(com.fyber.inneractive.sdk.config.global.features.e.class);
            boolean a2 = eVar.a("agg_res", false);
            Integer b2 = eVar.b("agg_res_ct");
            int max = Math.max(b2 != null ? b2.intValue() : 500, 50);
            Integer b3 = eVar.b("agg_res_rt");
            if (b3 != null) {
                i5 = b3.intValue();
            }
            int max2 = Math.max(i5, 50);
            Integer b4 = eVar.b("agg_res_retries");
            if (b4 != null) {
                i6 = b4.intValue();
            }
            z = a2;
            i3 = max2;
            i2 = Math.max(i6, 1);
            i4 = max;
        } else {
            z = false;
            i4 = 500;
            i3 = 500;
            i2 = 2;
        }
        q qVar = new q(this, z, i4, i3, i2);
        this.d = qVar;
        gVar.setWebViewClient(qVar);
        return gVar;
    }

    public void a(View view, float f2, Rect rect) {
        if (f2 != this.h || !rect.equals(this.i)) {
            this.h = f2;
            this.i.set(rect);
            g gVar = this.b;
            if (gVar != null) {
                gVar.a();
            }
        }
    }

    public boolean a(WebView webView, String str) {
        IAlog.a("%shandleUrl called with: %s", IAlog.a((Object) this), str);
        if (this.b == null) {
            IAlog.a("handleUrl: web view already destroyed. Cannot handle url", new Object[0]);
            return false;
        } else if (u0.a(str)) {
            this.b.loadUrl("chrome://crash");
            return true;
        } else {
            p0 f2 = f();
            if (a(str, f2)) {
                return true;
            }
            a((c) new e(str, f2));
            return true;
        }
    }

    public void a(boolean z) {
        IAlog.a("%sonWebViewVisibilityChanged called with: %s", IAlog.a((Object) this), Boolean.valueOf(z));
        L l2 = this.g;
        if (l2 != null) {
            l2.a(z);
        }
    }

    public boolean a(c cVar) {
        IAlog.d("IAWebViewController Web view click detected", new Object[0]);
        if (this.j) {
            IAlog.d("IAWebViewController Native click detected before web view request. Processing click", new Object[0]);
            cVar.d();
            j();
            return true;
        }
        if (this.k) {
            IAlog.d("IAWebViewController Native click was not detected yet. Caching click request and waiting", new Object[0]);
            Runnable runnable = this.m;
            if (runnable != null) {
                com.fyber.inneractive.sdk.util.q.b.removeCallbacks(runnable);
            }
            this.l = cVar;
            if (this.m != null) {
                com.fyber.inneractive.sdk.util.q.b.postDelayed(this.m, (long) IAConfigManager.M.u.b.a("click_timeout", 1000, 1000));
            }
        } else {
            Runnable runnable2 = this.m;
            if (runnable2 != null) {
                com.fyber.inneractive.sdk.util.q.b.removeCallbacks(runnable2);
            }
            this.l = null;
            cVar.d();
        }
        return false;
    }
}
