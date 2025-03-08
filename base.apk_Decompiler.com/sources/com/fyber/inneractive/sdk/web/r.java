package com.fyber.inneractive.sdk.web;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.webkit.JavascriptInterface;
import android.webkit.RenderProcessGoneDetail;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.digitalturbine.ignite.cl.aidl.IIgniteServiceAPI;
import com.fyber.inneractive.sdk.activities.InternalStoreWebpageActivity;
import com.fyber.inneractive.sdk.config.IAConfigManager;
import com.fyber.inneractive.sdk.config.global.s;
import com.fyber.inneractive.sdk.external.InneractiveAdRequest;
import com.fyber.inneractive.sdk.flow.p;
import com.fyber.inneractive.sdk.ignite.c;
import com.fyber.inneractive.sdk.ignite.g;
import com.fyber.inneractive.sdk.ignite.i;
import com.fyber.inneractive.sdk.ignite.j;
import com.fyber.inneractive.sdk.ignite.k;
import com.fyber.inneractive.sdk.ignite.n;
import com.fyber.inneractive.sdk.network.t;
import com.fyber.inneractive.sdk.util.IAlog;
import com.fyber.inneractive.sdk.util.b0;
import com.fyber.inneractive.sdk.util.e0;
import com.fyber.inneractive.sdk.util.q;
import com.fyber.inneractive.sdk.util.u;
import com.google.android.gms.drive.DriveFile;
import java.lang.ref.WeakReference;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

public class r implements n {
    public boolean A = false;
    public boolean B;
    public boolean C = false;
    public boolean D = false;
    public final WebViewClient E = new a();
    public final WebView a;
    public final com.fyber.inneractive.sdk.ignite.c b;
    public final String c;
    public k d;
    public final String e;
    public final String f;
    public final String g;
    public final j h;
    public g i;
    public String j = "invalid_task_id";
    public String k;
    public boolean l = false;
    public s m;
    public long n = 10;
    public long o;
    public Runnable p;
    public WeakReference<InternalStoreWebpageActivity> q;
    public boolean r = false;
    public boolean s = false;
    public final AtomicInteger t = new AtomicInteger(0);
    public final AtomicBoolean u = new AtomicBoolean(false);
    public final AtomicBoolean v = new AtomicBoolean(false);
    public boolean w = false;
    public boolean x = false;
    public boolean y = false;
    public boolean z = false;

    public class a extends WebViewClient {

        /* renamed from: com.fyber.inneractive.sdk.web.r$a$a  reason: collision with other inner class name */
        public class C0140a implements Runnable {
            public C0140a() {
            }

            public void run() {
                r rVar = r.this;
                if (!rVar.y) {
                    rVar.g(rVar.k);
                }
            }
        }

        public a() {
        }

        public boolean shouldOverrideUrlLoading(WebView webView, String str) {
            if (str.endsWith("success")) {
                r rVar = r.this;
                Runnable runnable = rVar.p;
                if (runnable != null) {
                    q.b.removeCallbacks(runnable);
                    rVar.p = null;
                }
                r rVar2 = r.this;
                rVar2.getClass();
                IAlog.a("%sInternalStoreWebpageController: onWebviewLoaded - load took %d msec", IAlog.a((Object) rVar2), Long.valueOf(System.currentTimeMillis() - r.this.o));
                boolean unused = r.this.l = true;
                return true;
            } else if (!str.startsWith("exit")) {
                return false;
            } else {
                Activity activity = (Activity) u.a(r.this.q);
                if (activity == null) {
                    return true;
                }
                try {
                    Uri parse = Uri.parse(str);
                    String queryParameter = parse.getQueryParameter("target");
                    boolean equals = TextUtils.equals("mail", parse.getAuthority());
                    Intent intent = new Intent(equals ? "android.intent.action.SENDTO" : "android.intent.action.VIEW", Uri.parse(queryParameter));
                    if (equals) {
                        intent = Intent.createChooser(intent, "Choose an application");
                    }
                    b0.a((Context) activity, intent);
                } catch (Throwable th) {
                    t.a(th, (InneractiveAdRequest) null, (com.fyber.inneractive.sdk.response.e) null);
                }
                return true;
            }
        }

        public boolean onRenderProcessGone(WebView webView, RenderProcessGoneDetail renderProcessGoneDetail) {
            Activity activity = (Activity) u.a(r.this.q);
            if (activity != null) {
                activity.finish();
            }
            q.b.postDelayed(new C0140a(), 1000);
            return true;
        }
    }

    public class b implements Runnable {
        public final /* synthetic */ String a;

        public b(String str) {
            this.a = str;
        }

        public void run() {
            IAlog.a("injecting JS: %s", this.a);
            try {
                if (this.a != null) {
                    WebView webView = r.this.a;
                    webView.loadUrl("javascript:" + this.a);
                }
            } catch (Exception unused) {
                IAlog.a("Failed to inject JS", new Object[0]);
            }
        }
    }

    public class c implements com.fyber.inneractive.sdk.ignite.h {
        public final /* synthetic */ String a;
        public final /* synthetic */ String b;

        public c(String str, String str2) {
            this.a = str;
            this.b = str2;
        }

        public void a() {
            r.this.b();
            r rVar = r.this;
            ((p.a) rVar.h).a(com.fyber.inneractive.sdk.network.q.IGNITE_FLOW_FAILED_TO_INSTALL_APP, this.a, this.b, rVar.d);
        }

        public void b() {
            r rVar = r.this;
            rVar.b.a(rVar.c, new c.d(rVar.f, rVar.d, p.this));
            r.this.f("onShowInstallStarted();");
        }
    }

    public class d implements com.fyber.inneractive.sdk.ignite.h {
        public final /* synthetic */ String a;

        public d(String str) {
            this.a = str;
        }

        public void a() {
        }

        public void b() {
            r.this.e(this.a);
        }
    }

    public class e implements g.b {
        public e() {
        }

        public void a(boolean z) {
            if (r.this.u.compareAndSet(false, true)) {
                r rVar = r.this;
                rVar.f("onCancelResult(" + z + ");");
                r.this.v.set(false);
            }
        }
    }

    public class f implements Runnable {
        public f() {
        }

        public void run() {
            if (r.this.u.compareAndSet(false, true)) {
                r.this.f("onCancelResult(true);");
                r.this.v.set(false);
            }
        }
    }

    public interface g {
    }

    public class h {
        public h() {
        }

        @JavascriptInterface
        public void onNavigatedInsideStorePage() {
            boolean unused = r.this.w = true;
        }

        @JavascriptInterface
        public void onNavigatedToMainPage() {
            boolean unused = r.this.w = false;
        }

        @JavascriptInterface
        public void onTransitionEnded() {
            boolean unused = r.this.x = false;
        }

        @JavascriptInterface
        public void onTransitionStarting() {
            boolean unused = r.this.x = true;
        }

        @JavascriptInterface
        public void onBackButtonPressed() {
            WeakReference<InternalStoreWebpageActivity> weakReference = r.this.q;
            if (weakReference != null && weakReference.get() != null) {
                ((InternalStoreWebpageActivity) r.this.q.get()).finish();
            }
        }

        @JavascriptInterface
        public void onCancelButtonPressed() {
            r rVar = r.this;
            rVar.d = rVar.B ? k.TRUE_SINGLE_TAP : k.SINGLE_TAP;
            rVar.e(rVar.j);
            r rVar2 = r.this;
            if (rVar2.h != null && !rVar2.r && rVar2.d != null) {
                boolean unused = rVar2.r = true;
                r rVar3 = r.this;
                ((p.a) rVar3.h).a(com.fyber.inneractive.sdk.network.r.IGNITE_FLOW_CANCEL_INSTALL_CLICKED, rVar3.d);
            }
        }

        @JavascriptInterface
        public void onInstallButtonPressed() {
            r rVar = r.this;
            k kVar = rVar.B ? k.TRUE_SINGLE_TAP : k.SINGLE_TAP;
            rVar.d = kVar;
            rVar.b.a(rVar.c, new c.d(rVar.f, kVar, p.this));
            r rVar2 = r.this;
            if (rVar2.h != null && !rVar2.s && rVar2.d != null) {
                boolean unused = rVar2.s = true;
                r rVar3 = r.this;
                ((p.a) rVar3.h).a(com.fyber.inneractive.sdk.network.r.IGNITE_FLOW_INSTALL_CLICKED, rVar3.d);
            }
        }

        @JavascriptInterface
        public void onOpenButtonPressed() {
            Intent intent;
            if (!TextUtils.isEmpty(r.this.c)) {
                if (!TextUtils.isEmpty(r.this.g)) {
                    intent = new Intent("android.intent.action.MAIN");
                    r rVar = r.this;
                    intent.setClassName(rVar.c, rVar.g);
                } else {
                    intent = com.fyber.inneractive.sdk.util.p.a.getPackageManager().getLaunchIntentForPackage(r.this.c);
                }
                if (intent != null) {
                    intent.setFlags(DriveFile.MODE_READ_ONLY);
                    try {
                        com.fyber.inneractive.sdk.util.p.a.startActivity(intent);
                    } catch (Exception e) {
                        j jVar = r.this.h;
                        if (jVar != null) {
                            String simpleName = e.getClass().getSimpleName();
                            String message = e.getMessage();
                            p pVar = p.this;
                            t.a(simpleName, message, pVar.a, pVar.b);
                        }
                    }
                } else {
                    r rVar2 = r.this;
                    rVar2.getClass();
                    IAlog.e("%sPackage %s not found", IAlog.a((Object) rVar2), r.this.c);
                }
            } else {
                r rVar3 = r.this;
                rVar3.getClass();
                IAlog.e("%smPackageName is null", IAlog.a((Object) rVar3));
            }
        }
    }

    public r(t tVar) {
        this.c = tVar.a;
        this.d = tVar.b;
        this.e = tVar.c;
        this.m = tVar.d;
        this.f = tVar.e;
        this.g = tVar.f;
        this.h = tVar.g;
        com.fyber.inneractive.sdk.ignite.c d2 = IAConfigManager.d();
        this.b = d2;
        d2.a((n) this);
        this.a = new WebView(com.fyber.inneractive.sdk.util.p.a());
    }

    public void b(String str) {
    }

    public void d(String str) {
    }

    public void f(String str) {
        q.b.post(new b(str));
    }

    public void g(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.k = str;
            WebSettings settings = this.a.getSettings();
            settings.setJavaScriptEnabled(true);
            settings.setUseWideViewPort(true);
            this.a.setInitialScale(1);
            this.a.setBackgroundColor(-1);
            this.a.setWebViewClient(this.E);
            WebView webView = this.a;
            webView.setLongClickable(false);
            webView.setOnLongClickListener(new e0());
            this.a.addJavascriptInterface(new h(), "nativeInterface");
            this.a.loadUrl(str);
            s sVar = this.m;
            if (sVar != null) {
                TimeUnit timeUnit = TimeUnit.SECONDS;
                Integer b2 = ((com.fyber.inneractive.sdk.config.global.features.p) sVar.a(com.fyber.inneractive.sdk.config.global.features.p.class)).b("load_timeout");
                int i2 = 10;
                int intValue = b2 != null ? b2.intValue() : 10;
                if (intValue < 30 && intValue > 2) {
                    i2 = intValue;
                }
                long millis = timeUnit.toMillis((long) i2);
                this.n = millis;
                IAlog.a("InternalStoreWebpageController: Starting load timeout with %d", Long.valueOf(millis));
            }
            this.o = System.currentTimeMillis();
            s sVar2 = new s(this);
            this.p = sVar2;
            q.b.postDelayed(sVar2, this.n);
        }
    }

    public void a(String str, String str2) {
        if (str != null && str2 != null && str2.equals(this.c)) {
            this.j = str;
        }
    }

    public void e(String str) {
        k kVar;
        if (str != null) {
            this.v.set(true);
            this.u.set(false);
            com.fyber.inneractive.sdk.ignite.c cVar = this.b;
            e eVar = new e();
            if (!cVar.d() || cVar.f()) {
                for (n next : cVar.i) {
                    if (next != null) {
                        next.a((String) null, (cVar.f() ? i.SESSION_EXPIRED : i.NOT_CONNECTED).e(), (String) null);
                    }
                }
            } else {
                try {
                    IIgniteServiceAPI iIgniteServiceAPI = cVar.b;
                    Bundle bundle = cVar.g;
                    cVar.h.getClass();
                    iIgniteServiceAPI.cancel(str, bundle, new com.fyber.inneractive.sdk.ignite.b(eVar));
                } catch (Exception unused) {
                    IAlog.a("Failed to cancel task", new Object[0]);
                    eVar.a(false);
                }
            }
            q.b.postDelayed(new f(), 2500);
            j jVar = this.h;
            if (jVar != null && !this.r && (kVar = this.d) != null) {
                this.r = true;
                ((p.a) jVar).a(com.fyber.inneractive.sdk.network.r.IGNITE_FLOW_CANCEL_INSTALL_CLICKED, kVar);
            }
        }
    }

    public void c(String str) {
        this.z = false;
        this.A = true;
        if (this.j.equals(str)) {
            this.b.b();
            f("onInstallationSuccess();");
        }
    }

    public void a(String str) {
        this.z = true;
        if (this.j.equals(str)) {
            this.b.b();
            f("onInstallStart();");
        }
    }

    public void b(String str, String str2, String str3) {
        if (this.D) {
            this.z = false;
            if (this.j.equals(str)) {
                this.b.b();
                if (!this.v.get() && !TextUtils.isEmpty(str2) && !TextUtils.isEmpty(str2) && str2.equals("App already installed")) {
                    f("onInstallationSuccess();");
                    this.A = true;
                    return;
                }
            }
            if ((str2 == null || (!str2.equals(i.NOT_CONNECTED.e()) && !str2.equals(i.SESSION_EXPIRED.e()))) && this.b.d()) {
                if (!TextUtils.equals(str2, i.DOWNLOAD_IS_CANCELLED.e())) {
                    b();
                }
            } else if (this.t.getAndIncrement() < 2) {
                this.b.a((com.fyber.inneractive.sdk.ignite.h) new c(str2, str3));
                return;
            } else {
                b();
                if (!this.b.e()) {
                    a((String) null, i.FAILED_TO_BIND_SERVICE);
                }
            }
            k kVar = this.d;
            if (kVar != null) {
                ((p.a) this.h).a(com.fyber.inneractive.sdk.network.q.IGNITE_FLOW_FAILED_TO_INSTALL_APP, str2, str3, kVar);
            }
        }
    }

    public void a(String str, int i2, double d2) {
        if (!this.j.equals(str)) {
            return;
        }
        if (i2 == 0) {
            f(String.format("onDownloadProgress(%f);", new Object[]{Double.valueOf(d2)}));
        } else if (i2 == 1) {
            f("onInstallationProgress();");
        }
    }

    public void a(String str, String str2, String str3) {
        if (!this.v.get() || str2 == null) {
            return;
        }
        if (!str2.equals(i.NOT_CONNECTED.e()) && !str2.equals(i.SESSION_EXPIRED.e())) {
            return;
        }
        if (this.t.getAndIncrement() < 2) {
            this.b.a((com.fyber.inneractive.sdk.ignite.h) new d(str));
        } else if (!this.b.e()) {
            a((String) null, i.FAILED_TO_BIND_SERVICE);
        }
    }

    public void a(String str, i iVar) {
        j jVar;
        com.fyber.inneractive.sdk.ignite.c cVar = this.b;
        if (!cVar.j && (jVar = this.h) != null) {
            cVar.j = true;
            ((p.a) jVar).a(com.fyber.inneractive.sdk.network.q.IGNITE_FLOW_FAILED_TO_START, (String) null, iVar.e(), (k) null);
        }
    }

    public void a() {
        this.y = true;
        this.D = false;
        this.b.i.remove(this);
        this.i = null;
        IAlog.a("destroy internalStoreWebpageController", new Object[0]);
    }

    public final void b() {
        this.b.b();
        f("onInstallationFailed();");
    }
}
