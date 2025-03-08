package com.fyber.inneractive.sdk.web;

import android.graphics.Bitmap;
import android.text.TextUtils;
import android.webkit.RenderProcessGoneDetail;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import androidx.webkit.ProxyConfig;
import com.fyber.inneractive.sdk.util.IAlog;
import com.fyber.inneractive.sdk.util.f0;
import com.fyber.inneractive.sdk.util.h;
import com.fyber.inneractive.sdk.util.t;
import com.ironsource.i9;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.SocketTimeoutException;
import java.net.URL;
import java.net.UnknownHostException;
import java.nio.ByteBuffer;

public class q extends WebViewClient {
    public final boolean a;
    public final int b;
    public final int c;
    public final int d;
    public f e;

    public q(f fVar, boolean z, int i, int i2, int i3) {
        this.e = fVar;
        this.a = z;
        this.b = i;
        this.c = i2;
        this.d = i3;
    }

    public void onLoadResource(WebView webView, String str) {
        super.onLoadResource(webView, str);
        IAlog.d("Resources to load: %s", str);
        int i = IAlog.a;
        IAlog.a(1, (Exception) null, "%s %s", "RESOURCES", str);
        f fVar = this.e;
        if (fVar != null) {
            d dVar = (d) fVar;
            dVar.getClass();
            if (!TextUtils.isEmpty(str) && str.startsWith("http://") && !t.a()) {
                IAlog.a("%s Found a portential unsecure resource url: %s", IAlog.a((Object) dVar), str);
            }
        }
    }

    public void onPageFinished(WebView webView, String str) {
        super.onPageFinished(webView, str);
        IAlog.d("onPageFinished - url: %s", str);
        f fVar = this.e;
        if (fVar != null) {
            fVar.a(webView);
        }
    }

    public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
        super.onPageStarted(webView, str, bitmap);
        IAlog.d("onPageStarted - url: %s", str);
    }

    public boolean onRenderProcessGone(WebView webView, RenderProcessGoneDetail renderProcessGoneDetail) {
        IAlog.a("onWebViewRenderProcessGone called for web view! %s", webView);
        f0.a(webView);
        f fVar = this.e;
        if (fVar != null) {
            d dVar = (d) fVar;
            L l = dVar.g;
            if (l != null) {
                l.b();
            }
            dVar.b(true);
        }
        return true;
    }

    public boolean shouldOverrideUrlLoading(WebView webView, String str) {
        super.shouldOverrideUrlLoading(webView, str);
        f fVar = this.e;
        return fVar != null && fVar.a(webView, str);
    }

    public void onReceivedError(WebView webView, int i, String str, String str2) {
        IAlog.d("%sError: code = %d text = %s WebView = %s", IAlog.a((Object) this), Integer.valueOf(i), str, webView);
        super.onReceivedError(webView, i, str, str2);
        f fVar = this.e;
        if (fVar != null) {
            fVar.a(i);
        }
    }

    public WebResourceResponse shouldInterceptRequest(WebView webView, WebResourceRequest webResourceRequest) {
        URL url;
        HttpURLConnection httpURLConnection;
        if (this.a && webResourceRequest != null) {
            IAlog.d("shouldInterceptRequest, method = %s", webResourceRequest.getMethod());
            x xVar = x.c;
            int i = this.b;
            int i2 = this.c;
            int i3 = this.d;
            xVar.getClass();
            WebResourceResponse webResourceResponse = null;
            if (webResourceRequest.getUrl() != null && webResourceRequest.getUrl().getScheme() != null && webResourceRequest.getUrl().getScheme().startsWith(ProxyConfig.MATCH_HTTP) && TextUtils.equals(webResourceRequest.getMethod(), i9.a)) {
                y yVar = (y) xVar.a.get(new z(webResourceRequest));
                if (yVar != null) {
                    webResourceResponse = yVar.b();
                } else {
                    try {
                        url = new URL(webResourceRequest.getUrl().toString());
                    } catch (MalformedURLException unused) {
                        url = null;
                    }
                    if (url != null) {
                        ByteBuffer b2 = h.b.b();
                        try {
                            httpURLConnection = (HttpURLConnection) url.openConnection();
                            try {
                                httpURLConnection.setRequestMethod(webResourceRequest.getMethod());
                                httpURLConnection.setInstanceFollowRedirects(false);
                                x.a(webResourceRequest, httpURLConnection);
                            } catch (Throwable unused2) {
                            }
                        } catch (Throwable unused3) {
                            httpURLConnection = null;
                        }
                        if (httpURLConnection != null) {
                            httpURLConnection.setConnectTimeout(i);
                            httpURLConnection.setReadTimeout(i2);
                            y yVar2 = null;
                            while (i3 > 0) {
                                try {
                                    yVar2 = x.a(httpURLConnection, b2);
                                } catch (SocketTimeoutException | UnknownHostException unused4) {
                                } catch (Throwable unused5) {
                                    i3 = 0;
                                }
                                if (yVar2 != null) {
                                    break;
                                }
                                i3--;
                            }
                            if (yVar2 != null) {
                                try {
                                    if (yVar2.a()) {
                                        xVar.a.put(new z(webResourceRequest), yVar2);
                                    }
                                    webResourceResponse = yVar2.b();
                                    httpURLConnection.disconnect();
                                    h.b.a.offer(b2);
                                } catch (Throwable unused6) {
                                }
                            }
                            httpURLConnection.disconnect();
                            h.b.a.offer(b2);
                        }
                    }
                }
            }
            if (webResourceResponse != null) {
                return webResourceResponse;
            }
            IAlog.d("shouldInterceptRequest did not intercept %s", webResourceRequest.getUrl());
        }
        return super.shouldInterceptRequest(webView, webResourceRequest);
    }
}
