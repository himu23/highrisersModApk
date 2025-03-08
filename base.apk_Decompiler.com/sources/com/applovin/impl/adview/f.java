package com.applovin.impl.adview;

import android.webkit.WebView;
import android.webkit.WebViewRenderProcess;
import android.webkit.WebViewRenderProcessClient;
import com.applovin.impl.sdk.ad.e;
import com.applovin.impl.sdk.d.b;
import com.applovin.impl.sdk.n;
import com.applovin.impl.sdk.x;

class f {
    private final WebViewRenderProcessClient agN = new WebViewRenderProcessClient() {
        public void onRenderProcessResponsive(WebView webView, WebViewRenderProcess webViewRenderProcess) {
        }

        public void onRenderProcessUnresponsive(WebView webView, WebViewRenderProcess webViewRenderProcess) {
            if (webView instanceof d) {
                e currentAd = ((d) webView).getCurrentAd();
                f.this.sdk.Cd().a(currentAd).a(b.aSE).JL();
                f.this.sdk.BN();
                if (x.Fn()) {
                    x BN = f.this.sdk.BN();
                    BN.i("AdWebViewRenderProcessClient", "WebView render process unresponsive for ad: " + currentAd);
                }
            }
        }
    };
    /* access modifiers changed from: private */
    public final n sdk;

    /* access modifiers changed from: package-private */
    public WebViewRenderProcessClient rt() {
        return this.agN;
    }

    f(n nVar) {
        this.sdk = nVar;
    }
}
