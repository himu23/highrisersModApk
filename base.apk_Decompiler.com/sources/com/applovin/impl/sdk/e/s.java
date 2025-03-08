package com.applovin.impl.sdk.e;

import android.net.Uri;
import android.webkit.WebView;
import com.applovin.impl.adview.d;
import com.applovin.impl.adview.e;
import com.applovin.impl.mediation.h;
import com.applovin.impl.sdk.ad.b;
import com.applovin.impl.sdk.n;
import com.applovin.impl.sdk.x;
import com.applovin.sdk.AppLovinAdLoadListener;
import com.applovin.sdk.AppLovinSdkUtils;
import org.json.JSONObject;

public class s extends d implements h.a {
    private d aUR;
    /* access modifiers changed from: private */
    public AppLovinAdLoadListener agz;
    /* access modifiers changed from: private */
    public final com.applovin.impl.sdk.ad.a ahO;

    public s(JSONObject jSONObject, JSONObject jSONObject2, b bVar, AppLovinAdLoadListener appLovinAdLoadListener, n nVar) {
        super("TaskProcessJavaScriptTagAd", nVar);
        this.ahO = new com.applovin.impl.sdk.ad.a(jSONObject, jSONObject2, bVar, nVar);
        this.agz = appLovinAdLoadListener;
        nVar.CA().a(this);
    }

    public void run() {
        x xVar = this.logger;
        if (x.Fn()) {
            x xVar2 = this.logger;
            String str = this.tag;
            xVar2.f(str, "Rendering AppLovin ad #" + this.ahO.getAdIdNumber());
        }
        AppLovinSdkUtils.runOnUiThread(new s$$ExternalSyntheticLambda0(this));
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void zJ() {
        try {
            d dVar = new d(new a(this.sdk), this.sdk, rQ());
            this.aUR = dVar;
            dVar.loadDataWithBaseURL(this.ahO.Hn(), this.ahO.FB(), "text/html", (String) null, "");
        } catch (Throwable th) {
            this.sdk.CA().b(this);
            x xVar = this.logger;
            if (x.Fn()) {
                this.logger.c(this.tag, "Failed to initialize WebView", th);
            }
            AppLovinAdLoadListener appLovinAdLoadListener = this.agz;
            if (appLovinAdLoadListener != null) {
                appLovinAdLoadListener.failedToReceiveAd(-1);
                this.agz = null;
            }
        }
    }

    public void f(com.applovin.impl.mediation.b.a aVar) {
        if (aVar.xA().equalsIgnoreCase(this.ahO.GB())) {
            this.sdk.CA().b(this);
            AppLovinAdLoadListener appLovinAdLoadListener = this.agz;
            if (appLovinAdLoadListener != null) {
                appLovinAdLoadListener.adReceived(this.ahO);
                this.agz = null;
            }
        }
    }

    private class a extends e {
        private a(n nVar) {
            super((com.applovin.impl.adview.b) null, nVar);
        }

        /* access modifiers changed from: protected */
        public boolean e(WebView webView, String str) {
            x xVar = s.this.logger;
            if (x.Fn()) {
                x xVar2 = s.this.logger;
                String str2 = s.this.tag;
                xVar2.g(str2, "Processing click on ad URL \"" + str + "\"");
            }
            if (str == null || !(webView instanceof d)) {
                return true;
            }
            Uri parse = Uri.parse(str);
            String scheme = parse.getScheme();
            String host = parse.getHost();
            if (!b(scheme, com.applovin.impl.sdk.c.b.aMK)) {
                return true;
            }
            if (b(host, com.applovin.impl.sdk.c.b.aML)) {
                x xVar3 = s.this.logger;
                if (x.Fn()) {
                    s.this.logger.f(s.this.tag, "Ad load succeeded");
                }
                if (s.this.agz == null) {
                    return true;
                }
                s.this.agz.adReceived(s.this.ahO);
                AppLovinAdLoadListener unused = s.this.agz = null;
                return true;
            } else if (b(host, com.applovin.impl.sdk.c.b.aMM)) {
                x xVar4 = s.this.logger;
                if (x.Fn()) {
                    s.this.logger.f(s.this.tag, "Ad load failed");
                }
                if (s.this.agz == null) {
                    return true;
                }
                s.this.agz.failedToReceiveAd(204);
                AppLovinAdLoadListener unused2 = s.this.agz = null;
                return true;
            } else {
                x xVar5 = s.this.logger;
                if (!x.Fn()) {
                    return true;
                }
                s.this.logger.i(s.this.tag, "Unrecognized webview event");
                return true;
            }
        }

        private boolean b(String str, com.applovin.impl.sdk.c.b<String> bVar) {
            for (String equalsIgnoreCase : s.this.sdk.b(bVar)) {
                if (equalsIgnoreCase.equalsIgnoreCase(str)) {
                    return true;
                }
            }
            return false;
        }
    }
}
