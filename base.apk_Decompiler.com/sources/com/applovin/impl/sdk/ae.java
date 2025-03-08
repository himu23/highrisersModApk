package com.applovin.impl.sdk;

import android.webkit.RenderProcessGoneDetail;
import android.webkit.ValueCallback;
import android.webkit.WebView;
import com.applovin.impl.sdk.c.b;
import com.applovin.impl.sdk.network.i;
import com.applovin.impl.sdk.utils.StringUtils;
import com.applovin.impl.sdk.utils.h;
import com.applovin.impl.sdk.utils.u;
import com.applovin.sdk.AppLovinPostbackListener;
import com.applovin.sdk.AppLovinSdkUtils;
import java.util.Collections;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class ae extends ab {
    private WebView aFW;
    private final Set<WebView> aFX = Collections.synchronizedSet(new HashSet());
    private final x logger;
    private final n sdk;

    public ae(n nVar) {
        this.sdk = nVar;
        this.logger = nVar.BN();
    }

    public void a(i iVar, AppLovinPostbackListener appLovinPostbackListener) {
        AppLovinSdkUtils.runOnUiThread(new ae$$ExternalSyntheticLambda3(this, iVar, appLovinPostbackListener));
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void b(i iVar, AppLovinPostbackListener appLovinPostbackListener) {
        String appendQueryParameters = StringUtils.appendQueryParameters(iVar.zL(), iVar.HR(), ((Boolean) this.sdk.a(b.aOb)).booleanValue());
        if (this.aFW == null) {
            WebView cN = cN("<script>window.al_firePostback = function(url) {\n    setTimeout(function() {\n        var img = new Image();\n        img.src = url;\n    }, 100);\n}\n</script>");
            this.aFW = cN;
            if (cN == null) {
                if (x.Fn()) {
                    this.logger.i("WebTrackerManager", "Failed to fire postback since web view could not be created");
                }
                appLovinPostbackListener.onPostbackFailure(appendQueryParameters, -1);
                return;
            }
        }
        String str = "al_firePostback('" + appendQueryParameters + "')";
        if (h.KW()) {
            this.aFW.evaluateJavascript(str, (ValueCallback) null);
        } else {
            this.aFW.loadUrl("javascript:" + str);
        }
        appLovinPostbackListener.onPostbackSuccess(appendQueryParameters);
    }

    public void cM(String str) {
        if (!AppLovinSdkUtils.isValidString(str)) {
            if (x.Fn()) {
                this.logger.i("WebTrackerManager", "Failed to fire tracker due to empty script string");
            }
        } else if (str.startsWith("<script")) {
            AppLovinSdkUtils.runOnUiThread(new ae$$ExternalSyntheticLambda2(this, str));
        } else if (x.Fn()) {
            this.logger.i("WebTrackerManager", "Failed to fire tracker due to improperly formatted script tag");
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void cO(String str) {
        WebView cN = cN(str);
        if (cN != null) {
            this.aFX.add(cN);
            AppLovinSdkUtils.runOnUiThreadDelayed(new ae$$ExternalSyntheticLambda4(this, cN), (long) ((Integer) this.sdk.a(b.aNG)).intValue());
        } else if (x.Fn()) {
            this.logger.i("WebTrackerManager", "Failed to fire tracker since web view could not be created");
        }
    }

    private WebView cN(String str) {
        u.LF();
        WebView b = u.b(n.getApplicationContext(), "web tracker");
        if (b == null) {
            return null;
        }
        b.getSettings().setJavaScriptEnabled(true);
        b.setWebViewClient(this);
        b.loadData("<html><head><link rel=\"icon\" href=\"data:,\">" + str + "</head><body></body></html>", "text/html", "UTF-8");
        return b;
    }

    /* access modifiers changed from: private */
    /* renamed from: f */
    public void g(WebView webView) {
        if (webView != null && this.aFX.remove(webView)) {
            Objects.requireNonNull(webView);
            AppLovinSdkUtils.runOnUiThread(new ae$$ExternalSyntheticLambda1(webView));
        }
    }

    public boolean onRenderProcessGone(WebView webView, RenderProcessGoneDetail renderProcessGoneDetail) {
        if (webView == this.aFW) {
            AppLovinSdkUtils.runOnUiThread(new ae$$ExternalSyntheticLambda0(this));
        } else {
            g(webView);
        }
        return super.onRenderProcessGone(webView, renderProcessGoneDetail);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void Fx() {
        this.aFW.destroy();
        this.aFW = null;
    }
}
