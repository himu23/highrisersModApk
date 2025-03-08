package com.fyber.inneractive.sdk.measurement.tracker;

import android.webkit.RenderProcessGoneDetail;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.fyber.inneractive.sdk.external.InneractiveAdRequest;
import com.fyber.inneractive.sdk.flow.q;
import com.fyber.inneractive.sdk.measurement.a;
import com.fyber.inneractive.sdk.network.t;
import com.fyber.inneractive.sdk.response.e;
import com.fyber.inneractive.sdk.util.IAlog;
import com.iab.omid.library.fyber.adsession.AdEvents;
import com.iab.omid.library.fyber.adsession.AdSession;
import com.iab.omid.library.fyber.adsession.AdSessionConfiguration;
import com.iab.omid.library.fyber.adsession.AdSessionContext;
import com.iab.omid.library.fyber.adsession.Partner;
import com.iab.omid.library.fyber.publisher.AdSessionStatePublisher;

public abstract class c implements a.C0101a {
    public AdSession a;
    public AdEvents b;
    public q c;
    public boolean d = false;
    public final Partner e;
    public WebView f;
    public WebViewClient g = new a();

    public class a extends WebViewClient {
        public a() {
        }

        public boolean onRenderProcessGone(WebView webView, RenderProcessGoneDetail renderProcessGoneDetail) {
            c.this.a(true);
            return true;
        }
    }

    public class b implements Runnable {
        public b() {
        }

        public void run() {
            IAlog.a("clearing webview", new Object[0]);
            WebView webView = c.this.f;
            if (webView != null) {
                webView.destroy();
                c.this.f = null;
            }
        }
    }

    /* renamed from: com.fyber.inneractive.sdk.measurement.tracker.c$c  reason: collision with other inner class name */
    public enum C0103c {
        CloseButton,
        ProgressOverlay,
        IdentifierView
    }

    public c(Partner partner, WebView webView, q<?> qVar) {
        this.e = partner;
        this.f = webView;
        this.c = qVar;
    }

    public void a(Throwable th) {
        String format = String.format("%s - %s", new Object[]{"OpenMeasurementTracker", th.getMessage()});
        String simpleName = th.getClass().getSimpleName();
        q qVar = this.c;
        e eVar = null;
        InneractiveAdRequest inneractiveAdRequest = qVar != null ? qVar.a : null;
        if (qVar != null) {
            eVar = qVar.d();
        }
        t.a(simpleName, format, inneractiveAdRequest, eVar);
    }

    public abstract AdSessionConfiguration c();

    public void a(boolean z) {
        AdSession adSession = this.a;
        if (adSession != null) {
            try {
                adSession.finish();
            } catch (Throwable th) {
                a(th);
            }
            com.fyber.inneractive.sdk.util.q.b.postDelayed(new b(), (long) (z ? 0 : 1000));
            this.a = null;
            this.b = null;
        }
    }

    public void a(WebView webView) {
        AdSessionConfiguration c2;
        AdSessionContext adSessionContext;
        WebView webView2;
        try {
            c2 = c();
            adSessionContext = AdSessionContext.createHtmlAdSessionContext(this.e, webView, "", "");
        } catch (Throwable th) {
            a(th);
            return;
        }
        AdSession createAdSession = AdSession.createAdSession(c2, adSessionContext);
        this.a = createAdSession;
        AdSessionStatePublisher adSessionStatePublisher = createAdSession.getAdSessionStatePublisher();
        if (!(adSessionStatePublisher == null || (webView2 = adSessionStatePublisher.getWebView()) == null || webView2 == webView)) {
            webView2.setWebViewClient(this.g);
        }
        this.a.registerAdView(webView);
        this.a.start();
    }
}
