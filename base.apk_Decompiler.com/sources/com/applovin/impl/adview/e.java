package com.applovin.impl.adview;

import android.content.Intent;
import android.net.Uri;
import android.net.http.SslError;
import android.os.Bundle;
import android.view.MotionEvent;
import android.webkit.RenderProcessGoneDetail;
import android.webkit.SslErrorHandler;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import androidx.tracing.Trace$$ExternalSyntheticApiModelOutline0;
import com.applovin.adview.AppLovinAdView;
import com.applovin.impl.b.a;
import com.applovin.impl.b.d;
import com.applovin.impl.b.m;
import com.applovin.impl.sdk.AppLovinBroadcastManager;
import com.applovin.impl.sdk.ab;
import com.applovin.impl.sdk.d.b;
import com.applovin.impl.sdk.n;
import com.applovin.impl.sdk.r;
import com.applovin.impl.sdk.utils.AppLovinSdkExtraParameterKey;
import com.applovin.impl.sdk.utils.StringUtils;
import com.applovin.impl.sdk.utils.h;
import com.applovin.impl.sdk.utils.s;
import com.applovin.impl.sdk.utils.u;
import com.applovin.impl.sdk.x;
import com.applovin.sdk.AppLovinAdSize;
import com.ironsource.g$$ExternalSyntheticApiModelOutline0;
import com.ironsource.mediationsdk.utils.IronSourceConstants;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class e extends ab {
    private final b agH;
    private final x logger;
    private final n sdk;

    /* access modifiers changed from: protected */
    public b rr() {
        return this.agH;
    }

    public e(b bVar, n nVar) {
        this.sdk = nVar;
        this.logger = nVar.BN();
        this.agH = bVar;
    }

    public boolean shouldOverrideUrlLoading(WebView webView, WebResourceRequest webResourceRequest) {
        Uri url = webResourceRequest.getUrl();
        if (url != null) {
            return e(webView, url.toString());
        }
        if (!x.Fn()) {
            return false;
        }
        this.logger.i("AdWebView", "No url found for request");
        return false;
    }

    public boolean shouldOverrideUrlLoading(WebView webView, String str) {
        return e(webView, str);
    }

    public void onLoadResource(WebView webView, String str) {
        super.onLoadResource(webView, str);
        if (x.Fn()) {
            x xVar = this.logger;
            xVar.g("AdWebView", "Loaded resource: " + str);
        }
    }

    public void onPageFinished(WebView webView, String str) {
        super.onPageFinished(webView, str);
        if (x.Fn()) {
            x xVar = this.logger;
            xVar.g("AdWebView", "Loaded URL: " + str);
        }
        b bVar = this.agH;
        if (bVar != null) {
            bVar.d(webView, str);
        }
    }

    public void onReceivedError(WebView webView, WebResourceRequest webResourceRequest, WebResourceError webResourceError) {
        super.onReceivedError(webView, webResourceRequest, webResourceError);
        onReceivedError(webView, Trace$$ExternalSyntheticApiModelOutline0.m(webResourceError), Trace$$ExternalSyntheticApiModelOutline0.m(webResourceError).toString(), webResourceRequest.getUrl().toString());
    }

    public void onReceivedError(WebView webView, int i, String str, String str2) {
        super.onReceivedError(webView, i, str, str2);
        b bVar = this.agH;
        if (bVar != null) {
            com.applovin.impl.sdk.ad.e currentAd = bVar.getCurrentAd();
            String str3 = "Received error with error code: " + i + " with description \\'" + str + "\\' for URL: " + str2;
            if (currentAd != null) {
                this.sdk.Cd().a(currentAd).a(b.aSA, str3).JL();
            }
            if (x.Fn()) {
                this.logger.i("AdWebView", str3 + " for ad: " + currentAd);
            }
        }
        if (u.dI(str2)) {
            this.sdk.Cs().b(str2, "adWebViewReceivedError", i);
        }
    }

    public void onReceivedHttpError(WebView webView, WebResourceRequest webResourceRequest, WebResourceResponse webResourceResponse) {
        super.onReceivedHttpError(webView, webResourceRequest, webResourceResponse);
        b bVar = this.agH;
        if (bVar != null) {
            com.applovin.impl.sdk.ad.e currentAd = bVar.getCurrentAd();
            this.sdk.Cd().a(currentAd).a(b.aSB).JL();
            if (x.Fn()) {
                x xVar = this.logger;
                xVar.i("AdWebView", "Received HTTP error: " + webResourceResponse + "for url: " + webResourceRequest.getUrl() + " and ad: " + currentAd);
            }
        }
        if (u.dI(webResourceRequest.getUrl().toString())) {
            this.sdk.Cs().b(webResourceRequest.getUrl().toString(), "adWebViewReceivedHttpError", webResourceResponse.getStatusCode());
        }
    }

    public void onReceivedSslError(WebView webView, SslErrorHandler sslErrorHandler, SslError sslError) {
        super.onReceivedSslError(webView, sslErrorHandler, sslError);
        b bVar = this.agH;
        if (bVar != null) {
            com.applovin.impl.sdk.ad.e currentAd = bVar.getCurrentAd();
            String str = "Received SSL error: " + sslError;
            this.sdk.Cd().a(currentAd).a(b.aSD, str).JL();
            if (x.Fn()) {
                this.logger.i("AdWebView", str + " for ad: " + currentAd);
            }
        }
    }

    public boolean onRenderProcessGone(WebView webView, RenderProcessGoneDetail renderProcessGoneDetail) {
        AppLovinBroadcastManager.sendBroadcast(new Intent("com.applovin.render_process_gone"), (Map<String, Object>) null);
        if (this.agH == null) {
            return true;
        }
        x.H("AdWebView", "Render process gone for ad: " + this.agH.getCurrentAd() + ". Process did crash: " + g$$ExternalSyntheticApiModelOutline0.m(renderProcessGoneDetail));
        com.applovin.impl.sdk.ad.e currentAd = this.agH.getCurrentAd();
        if (currentAd != null) {
            this.sdk.Cd().a(currentAd).a(b.aSC).JL();
            HashMap hashMap = new HashMap();
            hashMap.put("top_main_method", "onRenderProcessGone");
            hashMap.put("details", "size=" + currentAd.getSize() + ",ad_id=" + currentAd.getAdIdNumber() + ",dsp=" + currentAd.getDspName());
            if (h.La()) {
                hashMap.put("source", g$$ExternalSyntheticApiModelOutline0.m(renderProcessGoneDetail) ? "crash" : "non_crash");
            }
            this.sdk.Cs().a(r.a.WEB_VIEW_ERROR, (Map<String, String>) hashMap);
        }
        if (((Boolean) this.sdk.a(com.applovin.impl.sdk.c.b.aQp)).booleanValue()) {
            if (g$$ExternalSyntheticApiModelOutline0.m(renderProcessGoneDetail) && ((Boolean) this.sdk.a(com.applovin.impl.sdk.c.b.aQs)).booleanValue()) {
                String valueOf = currentAd != null ? String.valueOf(currentAd.getAdIdNumber()) : "null";
                throw new RuntimeException("Render process crashed. This is likely caused by a crash in an AppLovin ad with ID: " + valueOf);
            } else if (webView != null && webView.equals(this.agH.qZ())) {
                this.agH.destroy();
                AppLovinAdSize size = this.agH.getSize();
                if (u.c(size)) {
                    this.agH.a(size);
                    this.agH.resume();
                }
            }
        }
        return super.onRenderProcessGone(webView, renderProcessGoneDetail);
    }

    /* access modifiers changed from: protected */
    public boolean e(WebView webView, String str) {
        if (this.agH == null) {
            return true;
        }
        if (x.Fn()) {
            x xVar = this.logger;
            xVar.g("AdWebView", "Processing click on ad URL \"" + str + "\"");
        }
        if (str != null && (webView instanceof d)) {
            Uri parse = Uri.parse(str);
            d dVar = (d) webView;
            String scheme = parse.getScheme();
            String host = parse.getHost();
            String path = parse.getPath();
            com.applovin.impl.sdk.ad.e currentAd = this.agH.getCurrentAd();
            if (currentAd == null) {
                if (x.Fn()) {
                    this.logger.i("AdWebView", "Unable to process click, ad not found!");
                }
                return true;
            }
            boolean rz = dVar.rz();
            boolean z = !currentAd.Gz() || rz;
            if (!"applovin".equals(scheme) || !"com.applovin.sdk".equals(host)) {
                if (z) {
                    List<String> Hr = currentAd.Hr();
                    List<String> Hs = currentAd.Hs();
                    if ((Hr.isEmpty() || Hr.contains(scheme)) && (Hs.isEmpty() || Hs.contains(host))) {
                        if (currentAd instanceof a) {
                            a aVar = (a) currentAd;
                            if (aVar.Ma()) {
                                a(aVar, dVar);
                            }
                        }
                        a(dVar, parse);
                    } else if (x.Fn()) {
                        this.logger.i("AdWebView", "URL is not whitelisted - bypassing click");
                    }
                }
            } else if ("/adservice/close_ad".equals(path)) {
                String str2 = this.sdk.getSettings().getExtraParameters().get(AppLovinSdkExtraParameterKey.CLOSE_URL_AD_VALUE);
                if (StringUtils.isValidString(str2) && Boolean.parseBoolean(str2)) {
                    currentAd.setMaxAdValue("close_url", str);
                }
                rs();
            } else if ("/adservice/expand_ad".equals(path)) {
                if (!currentAd.Gy() || rz) {
                    b(dVar.getLastClickEvent());
                } else {
                    if (x.Fn()) {
                        this.logger.i("AdWebView", "Skipping expand command without user interaction");
                    }
                    return true;
                }
            } else if ("/adservice/contract_ad".equals(path)) {
                qT();
            } else if ("/adservice/no_op".equals(path)) {
                return true;
            } else {
                if ("/adservice/load_url".equals(path)) {
                    if (!currentAd.Gy() || rz) {
                        s.a(parse, this.agH, this.sdk);
                    } else {
                        if (x.Fn()) {
                            this.logger.i("AdWebView", "Skipping URL load command without user interaction");
                        }
                        return true;
                    }
                } else if ("/adservice/track_click_now".equals(path)) {
                    if (currentAd.Gy() && !rz) {
                        if (x.Fn()) {
                            this.logger.i("AdWebView", "Skipping click tracking command without user interaction");
                        }
                        return true;
                    } else if (currentAd instanceof a) {
                        a((a) currentAd, dVar);
                    } else {
                        a(dVar, Uri.parse("/adservice/track_click_now"));
                    }
                } else if ("/adservice/deeplink".equals(path)) {
                    if (!currentAd.Gy() || rz) {
                        if (currentAd instanceof a) {
                            a aVar2 = (a) currentAd;
                            if (aVar2.Ma()) {
                                a(aVar2, dVar);
                            }
                        }
                        a(dVar, parse);
                    } else {
                        if (x.Fn()) {
                            this.logger.i("AdWebView", "Skipping deep link plus command without user interaction");
                        }
                        return true;
                    }
                } else if ("/adservice/postback".equals(path)) {
                    s.a(parse, currentAd, this.sdk);
                } else if ("/playable_event".equals(path)) {
                    i(parse);
                } else if ("/adservice/direct_download".equals(path)) {
                    Bundle t = s.t(parse);
                    if (currentAd instanceof a) {
                        a aVar3 = (a) currentAd;
                        if (aVar3.Ma()) {
                            a(aVar3, dVar, t);
                        }
                    }
                    a(dVar, currentAd.FK(), t);
                } else if ("/template_error".equals(path)) {
                    s.b(parse, currentAd, this.sdk);
                } else if (this.agH.qR() == null) {
                    if (x.Fn()) {
                        x xVar2 = this.logger;
                        xVar2.h("AdWebView", "Unknown URL: " + str);
                    }
                    if (x.Fn()) {
                        x xVar3 = this.logger;
                        xVar3.h("AdWebView", "Path: " + path);
                    }
                } else if ("/video_began".equals(path)) {
                    this.agH.qR().a(u.a(parse.getQueryParameter(IronSourceConstants.EVENTS_DURATION), 0.0d));
                } else if ("/video_completed".equals(path)) {
                    this.agH.qR().ru();
                } else if ("/video_progress".equals(path)) {
                    this.agH.qR().b(u.a(parse.getQueryParameter("percent_viewed"), 0.0d));
                } else if ("/video_waiting".equals(path)) {
                    this.agH.qR().rv();
                } else if ("/video_resumed".equals(path)) {
                    this.agH.qR().rw();
                }
            }
        }
        return true;
    }

    private void rs() {
        this.agH.qU();
    }

    private void b(MotionEvent motionEvent) {
        this.agH.b(motionEvent);
    }

    private void qT() {
        this.agH.qT();
    }

    private void a(a aVar, d dVar) {
        a(aVar, dVar, (Bundle) null);
    }

    private void a(a aVar, d dVar, Bundle bundle) {
        d LX = aVar.LX();
        if (LX != null) {
            m.a(LX.Mp(), this.agH.getSdk());
            a(dVar, LX.Mn(), bundle);
        }
    }

    private void a(d dVar, Uri uri) {
        a(dVar, uri, (Bundle) null);
    }

    private void a(d dVar, Uri uri, Bundle bundle) {
        com.applovin.impl.sdk.ad.e currentAd = dVar.getCurrentAd();
        AppLovinAdView qY = this.agH.qY();
        if (qY != null && currentAd != null) {
            com.applovin.impl.sdk.d.d statsManagerHelper = dVar.getStatsManagerHelper();
            if (statsManagerHelper != null) {
                statsManagerHelper.JN();
            }
            if (currentAd instanceof a) {
                ((a) currentAd).getAdEventTracker().Jg();
            }
            this.agH.a(currentAd, qY, uri, dVar.getAndClearLastClickEvent(), bundle);
        } else if (x.Fn()) {
            x xVar = this.logger;
            xVar.i("AdWebView", "Attempting to track click that is null or not an ApplovinAdView instance for clickedUri = " + uri);
        }
    }

    private void i(Uri uri) {
        String str;
        boolean booleanQueryParameter = uri.getBooleanQueryParameter("success", false);
        String queryParameter = uri.getQueryParameter("type");
        if (booleanQueryParameter) {
            str = "Tracked event: " + queryParameter;
        } else {
            str = "Failed to track event: " + queryParameter;
        }
        u.e(str, n.getApplicationContext());
    }
}
