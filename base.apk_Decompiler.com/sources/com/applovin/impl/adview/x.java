package com.applovin.impl.adview;

import android.net.Uri;
import android.os.Bundle;
import android.webkit.WebView;
import com.applovin.impl.sdk.ab;
import com.applovin.impl.sdk.n;
import com.applovin.impl.sdk.utils.s;
import java.lang.ref.WeakReference;

public class x extends ab {
    private WeakReference<a> aip;
    private final com.applovin.impl.sdk.x logger;

    public interface a {
        void a(Uri uri, w wVar);

        void a(w wVar);

        void a(w wVar, Bundle bundle);

        void b(Uri uri, w wVar);

        void b(w wVar);

        void c(w wVar);
    }

    public void a(WeakReference<a> weakReference) {
        this.aip = weakReference;
    }

    public x(n nVar) {
        this.logger = nVar.BN();
    }

    public boolean shouldOverrideUrlLoading(WebView webView, String str) {
        f(webView, str);
        return true;
    }

    private void f(WebView webView, String str) {
        if (com.applovin.impl.sdk.x.Fn()) {
            com.applovin.impl.sdk.x xVar = this.logger;
            xVar.g("WebViewButtonClient", "Processing click on ad URL \"" + str + "\"");
        }
        if (str != null && (webView instanceof w)) {
            w wVar = (w) webView;
            Uri parse = Uri.parse(str);
            String scheme = parse.getScheme();
            String host = parse.getHost();
            String path = parse.getPath();
            a aVar = (a) this.aip.get();
            if ("applovin".equalsIgnoreCase(scheme) && "com.applovin.sdk".equalsIgnoreCase(host) && aVar != null) {
                if ("/track_click".equals(path)) {
                    aVar.a(wVar);
                } else if ("/close_ad".equals(path)) {
                    aVar.b(wVar);
                } else if ("/skip_ad".equals(path)) {
                    aVar.c(wVar);
                } else if ("/direct_download".equals(path)) {
                    aVar.a(wVar, s.t(parse));
                } else if ("/load_url".equals(path)) {
                    aVar.a(parse, wVar);
                } else if ("/template_error".equals(path)) {
                    aVar.b(parse, wVar);
                } else {
                    if (com.applovin.impl.sdk.x.Fn()) {
                        com.applovin.impl.sdk.x xVar2 = this.logger;
                        xVar2.h("WebViewButtonClient", "Unknown URL: " + str);
                    }
                    if (com.applovin.impl.sdk.x.Fn()) {
                        com.applovin.impl.sdk.x xVar3 = this.logger;
                        xVar3.h("WebViewButtonClient", "Path: " + path);
                    }
                }
            }
        }
    }
}
