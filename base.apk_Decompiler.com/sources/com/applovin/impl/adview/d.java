package com.applovin.impl.adview;

import android.content.Context;
import android.graphics.Paint;
import android.net.Uri;
import android.view.MotionEvent;
import android.view.View;
import android.webkit.RenderProcessGoneDetail;
import android.webkit.ValueCallback;
import android.webkit.WebSettings;
import android.webkit.WebView;
import com.applovin.impl.b.i;
import com.applovin.impl.sdk.ab;
import com.applovin.impl.sdk.ad.a;
import com.applovin.impl.sdk.ad.e;
import com.applovin.impl.sdk.c.b;
import com.applovin.impl.sdk.n;
import com.applovin.impl.sdk.utils.StringUtils;
import com.applovin.impl.sdk.utils.h;
import com.applovin.impl.sdk.utils.u;
import com.applovin.impl.sdk.x;
import com.applovin.sdk.AppLovinPostbackListener;
import com.applovin.sdk.AppLovinSdkUtils;
import com.unity3d.ads.adplayer.AndroidWebViewClient;
import java.util.ArrayList;
import java.util.List;

public class d extends i {
    /* access modifiers changed from: private */
    public static WebView agI;
    private boolean agJ;
    private boolean agK;
    private final List<String> agL = new ArrayList();
    private final Object agM = new Object();
    private com.applovin.impl.sdk.d.d agj;
    private e agq;
    private final x logger;
    private final n sdk;

    public void computeScroll() {
    }

    /* access modifiers changed from: package-private */
    public e getCurrentAd() {
        return this.agq;
    }

    public com.applovin.impl.sdk.d.d getStatsManagerHelper() {
        return this.agj;
    }

    /* access modifiers changed from: protected */
    public void onScrollChanged(int i, int i2, int i3, int i4) {
    }

    public void scrollTo(int i, int i2) {
    }

    public void setStatsManagerHelper(com.applovin.impl.sdk.d.d dVar) {
        this.agj = dVar;
    }

    public d(e eVar, n nVar, Context context) {
        super(context);
        ab abVar;
        if (nVar != null) {
            this.sdk = nVar;
            this.logger = nVar.BN();
            setBackgroundColor(0);
            WebSettings settings = getSettings();
            settings.setSupportMultipleWindows(false);
            settings.setJavaScriptEnabled(true);
            if (eVar != null) {
                abVar = eVar;
            } else {
                abVar = new ab();
            }
            setWebViewClient(abVar);
            setWebChromeClient(new c(eVar != null ? eVar.rr() : null, nVar));
            setVerticalScrollBarEnabled(false);
            setHorizontalScrollBarEnabled(false);
            setScrollBarStyle(33554432);
            if (h.Lc() && ((Boolean) nVar.a(b.aQt)).booleanValue()) {
                setWebViewRenderProcessClient(new f(nVar).rt());
            }
            setOnTouchListener(new d$$ExternalSyntheticLambda2());
            setOnLongClickListener(new d$$ExternalSyntheticLambda3(this));
            return;
        }
        throw new IllegalArgumentException("No sdk specified.");
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ boolean a(View view, MotionEvent motionEvent) {
        if (view.hasFocus()) {
            return false;
        }
        view.requestFocus();
        return false;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ boolean h(View view) {
        if (!x.Fn()) {
            return true;
        }
        this.logger.f("AdWebView", "Received a LongClick event.");
        return true;
    }

    public void a(e eVar) {
        if (!this.agJ) {
            this.agq = eVar;
            try {
                b(eVar);
                if (u.c(eVar.getSize())) {
                    setVisibility(0);
                }
                if (eVar instanceof a) {
                    a aVar = (a) eVar;
                    String FB = aVar.FB();
                    if (!aVar.shouldInjectOpenMeasurementScriptDuringCaching() && aVar.isOpenMeasurementEnabled()) {
                        FB = this.sdk.Cp().dl(FB);
                    }
                    if (u.al(n.getApplicationContext())) {
                        FB = u.dH(FB);
                    }
                    loadDataWithBaseURL(eVar.Hn(), FB, "text/html", (String) null, "");
                    if (x.Fn()) {
                        this.logger.f("AdWebView", "AppLovinAd rendered");
                    }
                } else if (eVar instanceof com.applovin.impl.b.a) {
                    com.applovin.impl.b.a aVar2 = (com.applovin.impl.b.a) eVar;
                    com.applovin.impl.b.d LX = aVar2.LX();
                    if (LX != null) {
                        i Mo = LX.Mo();
                        Uri MB = Mo.MB();
                        String uri = MB != null ? MB.toString() : "";
                        String MC = Mo.MC();
                        String Mb = aVar2.Mb();
                        if (!StringUtils.isValidString(uri)) {
                            if (!StringUtils.isValidString(MC)) {
                                if (x.Fn()) {
                                    this.logger.i("AdWebView", "Unable to load companion ad. No resources provided.");
                                    return;
                                }
                                return;
                            }
                        }
                        if (Mo.MA() == i.a.STATIC) {
                            if (x.Fn()) {
                                this.logger.f("AdWebView", "Rendering WebView for static VAST ad");
                            }
                            String n = n((String) this.sdk.a(b.aPp), uri);
                            if (aVar2.LM() && aVar2.isOpenMeasurementEnabled() && aVar2.LN()) {
                                n = this.sdk.Cp().dl(n);
                            }
                            loadDataWithBaseURL(eVar.Hn(), n, "text/html", (String) null, "");
                        } else if (Mo.MA() == i.a.HTML) {
                            if (StringUtils.isValidString(MC)) {
                                String n2 = n(Mb, MC);
                                if (StringUtils.isValidString(n2)) {
                                    MC = n2;
                                }
                                if (aVar2.LM() && aVar2.isOpenMeasurementEnabled() && !aVar2.shouldInjectOpenMeasurementScriptDuringCaching()) {
                                    MC = this.sdk.Cp().dl(MC);
                                }
                                if (x.Fn()) {
                                    x xVar = this.logger;
                                    xVar.f("AdWebView", "Rendering WebView for HTML VAST ad with resourceContents: " + MC);
                                }
                                loadDataWithBaseURL(eVar.Hn(), MC, "text/html", (String) null, "");
                            } else if (StringUtils.isValidString(uri)) {
                                if (x.Fn()) {
                                    this.logger.f("AdWebView", "Preparing to load HTML VAST ad resourceUri");
                                }
                                a(uri, eVar.Hn(), Mb, this.sdk, aVar2);
                            }
                        } else if (Mo.MA() == i.a.IFRAME) {
                            if (StringUtils.isValidString(uri)) {
                                if (x.Fn()) {
                                    this.logger.f("AdWebView", "Preparing to load iFrame VAST ad resourceUri");
                                }
                                a(uri, eVar.Hn(), Mb, this.sdk, aVar2);
                            } else if (StringUtils.isValidString(MC)) {
                                String n3 = n(Mb, MC);
                                if (StringUtils.isValidString(n3)) {
                                    MC = n3;
                                }
                                if (aVar2.LM() && aVar2.isOpenMeasurementEnabled() && !aVar2.shouldInjectOpenMeasurementScriptDuringCaching()) {
                                    MC = this.sdk.Cp().dl(MC);
                                }
                                if (x.Fn()) {
                                    x xVar2 = this.logger;
                                    xVar2.f("AdWebView", "Rendering WebView for iFrame VAST ad with resourceContents: " + MC);
                                }
                                loadDataWithBaseURL(eVar.Hn(), MC, "text/html", (String) null, "");
                            }
                        } else if (x.Fn()) {
                            this.logger.i("AdWebView", "Failed to render VAST companion ad of invalid type");
                        }
                    } else if (x.Fn()) {
                        this.logger.f("AdWebView", "No companion ad provided.");
                    }
                }
            } catch (Throwable th) {
                String valueOf = eVar != null ? String.valueOf(eVar.getAdIdNumber()) : "null";
                throw new RuntimeException("Unable to render AppLovin ad (" + valueOf + ") - " + th);
            }
        } else {
            x.H("AdWebView", "Ad can not be loaded in a destroyed webview");
        }
    }

    private void b(e eVar) {
        Boolean sw;
        loadUrl(AndroidWebViewClient.BLANK_PAGE);
        int Hq = this.agq.Hq();
        if (Hq >= 0) {
            setLayerType(Hq, (Paint) null);
        }
        if (h.KV()) {
            getSettings().setMediaPlaybackRequiresUserGesture(eVar.Hm());
        }
        if (h.KW() && eVar.Ho()) {
            setWebContentsDebuggingEnabled(true);
        }
        y Hp = eVar.Hp();
        if (Hp != null) {
            WebSettings settings = getSettings();
            WebSettings.PluginState sj = Hp.sj();
            if (sj != null) {
                settings.setPluginState(sj);
            }
            Boolean sk = Hp.sk();
            if (sk != null) {
                settings.setAllowFileAccess(sk.booleanValue());
            }
            Boolean sl = Hp.sl();
            if (sl != null) {
                settings.setLoadWithOverviewMode(sl.booleanValue());
            }
            Boolean sm = Hp.sm();
            if (sm != null) {
                settings.setUseWideViewPort(sm.booleanValue());
            }
            Boolean sn = Hp.sn();
            if (sn != null) {
                settings.setAllowContentAccess(sn.booleanValue());
            }
            Boolean so = Hp.so();
            if (so != null) {
                settings.setBuiltInZoomControls(so.booleanValue());
            }
            Boolean sp = Hp.sp();
            if (sp != null) {
                settings.setDisplayZoomControls(sp.booleanValue());
            }
            Boolean sq = Hp.sq();
            if (sq != null) {
                settings.setSaveFormData(sq.booleanValue());
            }
            Boolean sr = Hp.sr();
            if (sr != null) {
                settings.setGeolocationEnabled(sr.booleanValue());
            }
            Boolean ss = Hp.ss();
            if (ss != null) {
                settings.setNeedInitialFocus(ss.booleanValue());
            }
            Boolean st = Hp.st();
            if (st != null) {
                settings.setAllowFileAccessFromFileURLs(st.booleanValue());
            }
            Boolean su = Hp.su();
            if (su != null) {
                settings.setAllowUniversalAccessFromFileURLs(su.booleanValue());
            }
            Boolean sx = Hp.sx();
            if (sx != null) {
                settings.setLoadsImagesAutomatically(sx.booleanValue());
            }
            Boolean sy = Hp.sy();
            if (sy != null) {
                settings.setBlockNetworkImage(sy.booleanValue());
            }
            if (h.KX()) {
                Integer si = Hp.si();
                if (si != null) {
                    settings.setMixedContentMode(si.intValue());
                }
                if (h.KY()) {
                    Boolean sv = Hp.sv();
                    if (sv != null) {
                        settings.setOffscreenPreRaster(sv.booleanValue());
                    }
                    if (h.Lf() && (sw = Hp.sw()) != null) {
                        settings.setAlgorithmicDarkeningAllowed(sw.booleanValue());
                    }
                }
            }
        }
    }

    public void bq(String str) {
        if (!((Boolean) this.sdk.a(b.aQS)).booleanValue()) {
            br(str);
        } else if (this.agK) {
            br(str);
        } else {
            synchronized (this.agL) {
                this.agL.add(str);
            }
        }
    }

    private void br(String str) {
        try {
            if (x.Fn()) {
                x xVar = this.logger;
                xVar.f("AdWebView", "Forwarding \"" + str + "\" to ad template");
            }
            loadUrl(str);
        } catch (Throwable th) {
            if (x.Fn()) {
                this.logger.c("AdWebView", "Unable to forward to template", th);
            }
            this.sdk.Cs().d("AdWebView", str, th);
        }
    }

    private void rm() {
        synchronized (this.agM) {
            for (String br : this.agL) {
                br(br);
            }
            this.agL.clear();
        }
    }

    public void destroy() {
        this.agJ = true;
        this.agK = false;
        super.destroy();
    }

    private void a(String str, String str2, String str3, n nVar, com.applovin.impl.b.a aVar) {
        String n = n(str3, str);
        if (StringUtils.isValidString(n)) {
            if (aVar.LM() && aVar.isOpenMeasurementEnabled() && !aVar.shouldInjectOpenMeasurementScriptDuringCaching()) {
                n = nVar.Cp().dl(n);
            }
            String str4 = n;
            if (x.Fn()) {
                x xVar = this.logger;
                xVar.f("AdWebView", "Rendering webview for VAST ad with resourceContents : " + str4);
            }
            loadDataWithBaseURL(str2, str4, "text/html", (String) null, "");
            return;
        }
        String n2 = n((String) nVar.a(b.aPq), str);
        if (StringUtils.isValidString(n2)) {
            if (aVar.LM() && aVar.isOpenMeasurementEnabled()) {
                n2 = nVar.Cp().dl(n2);
            }
            String str5 = n2;
            if (x.Fn()) {
                x xVar2 = this.logger;
                xVar2.f("AdWebView", "Rendering webview for VAST ad with resourceContents : " + str5);
            }
            loadDataWithBaseURL(str2, str5, "text/html", (String) null, "");
            return;
        }
        if (x.Fn()) {
            x xVar3 = this.logger;
            xVar3.f("AdWebView", "Rendering webview for VAST ad with resourceURL : " + str);
        }
        loadUrl(str);
    }

    private String n(String str, String str2) {
        if (StringUtils.isValidString(str)) {
            return str.replace("{SOURCE}", str2);
        }
        return null;
    }

    public static void a(com.applovin.impl.sdk.network.i iVar, n nVar, AppLovinPostbackListener appLovinPostbackListener) {
        AppLovinSdkUtils.runOnUiThread(new d$$ExternalSyntheticLambda4(iVar, appLovinPostbackListener, nVar));
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ void a(com.applovin.impl.sdk.network.i iVar, AppLovinPostbackListener appLovinPostbackListener, n nVar) {
        String zL = iVar.zL();
        rn();
        if (agI == null) {
            appLovinPostbackListener.onPostbackFailure(zL, -1);
            return;
        }
        if (iVar.HR() != null) {
            zL = StringUtils.appendQueryParameters(zL, iVar.HR(), ((Boolean) nVar.a(b.aOb)).booleanValue());
        }
        String str = "al_firePostback('" + zL + "');";
        if (h.KW()) {
            agI.evaluateJavascript(str, (ValueCallback) null);
        } else {
            agI.loadUrl("javascript:" + str);
        }
        appLovinPostbackListener.onPostbackSuccess(zL);
    }

    /* access modifiers changed from: private */
    public static void rn() {
        if (agI == null) {
            WebView b = u.b(n.getApplicationContext(), "postbacks");
            agI = b;
            if (b != null) {
                b.getSettings().setJavaScriptEnabled(true);
                agI.loadData("<html><head>\n<script type=\"text/javascript\">\n    window.al_firePostback = function(postback) {\n    setTimeout(function() {\n        var img = new Image();\n        img.src = postback;\n    }, 100);\n};\n</script></head>\n<body></body></html>", "text/html", "UTF-8");
                agI.setWebViewClient(new ab() {
                    public boolean onRenderProcessGone(WebView webView, RenderProcessGoneDetail renderProcessGoneDetail) {
                        if (webView == d.agI) {
                            d.agI.destroy();
                            WebView unused = d.agI = null;
                            AppLovinSdkUtils.runOnUiThread(new d$1$$ExternalSyntheticLambda0());
                        }
                        return super.onRenderProcessGone(webView, renderProcessGoneDetail);
                    }
                });
            }
        }
    }

    public void setAdHtmlLoaded(boolean z) {
        this.agK = z;
        if (z && ((Boolean) this.sdk.a(b.aQS)).booleanValue()) {
            rm();
        }
    }
}
