package com.applovin.impl.adview;

import android.content.Intent;
import android.webkit.ConsoleMessage;
import android.webkit.JsResult;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import com.applovin.impl.sdk.AppLovinBroadcastManager;
import com.applovin.impl.sdk.ad.e;
import com.applovin.impl.sdk.n;
import com.applovin.impl.sdk.r;
import com.applovin.impl.sdk.x;
import java.util.HashMap;
import java.util.Map;

public class c extends WebChromeClient {
    private final b agH;
    private final x logger;
    private final n sdk;

    public c(b bVar, n nVar) {
        this.sdk = nVar;
        this.logger = nVar.BN();
        this.agH = bVar;
    }

    public void onProgressChanged(WebView webView, int i) {
        b bVar;
        if (i == 100 && (bVar = this.agH) != null) {
            bVar.b(webView);
        }
    }

    public boolean onConsoleMessage(ConsoleMessage consoleMessage) {
        String str = consoleMessage.messageLevel() + ": " + consoleMessage.sourceId() + ": " + consoleMessage.lineNumber() + ": " + consoleMessage.message();
        if (x.Fn()) {
            this.logger.f("AdWebView", str);
        }
        if (consoleMessage.messageLevel() != ConsoleMessage.MessageLevel.ERROR) {
            return true;
        }
        if (!consoleMessage.message().contains("al_onPoststitialShow is not defined") && !consoleMessage.message().contains("al_showPostitial is not defined")) {
            return true;
        }
        rl();
        return true;
    }

    public boolean onJsAlert(WebView webView, String str, String str2, JsResult jsResult) {
        if (!x.Fn()) {
            return true;
        }
        x xVar = this.logger;
        xVar.h("AdWebView", "Alert attempted: " + str2);
        return true;
    }

    public boolean onJsConfirm(WebView webView, String str, String str2, JsResult jsResult) {
        if (!x.Fn()) {
            return true;
        }
        x xVar = this.logger;
        xVar.h("AdWebView", "JS confirm attempted: " + str2);
        return true;
    }

    public boolean onJsBeforeUnload(WebView webView, String str, String str2, JsResult jsResult) {
        if (!x.Fn()) {
            return true;
        }
        x xVar = this.logger;
        xVar.h("AdWebView", "JS onBeforeUnload attempted: " + str2);
        return true;
    }

    public void onConsoleMessage(String str, int i, String str2) {
        if (x.Fn()) {
            x xVar = this.logger;
            xVar.h("AdWebView", "console.log[" + i + "] :" + str);
        }
    }

    private void rl() {
        AppLovinBroadcastManager.sendBroadcast(new Intent("com.applovin.al_onPoststitialShow_undefined"), (Map<String, Object>) null);
        e currentAd = this.agH.getCurrentAd();
        if (currentAd != null) {
            HashMap hashMap = new HashMap();
            hashMap.put("top_main_method", "onPoststitialShowUndefined");
            hashMap.put("details", "size=" + currentAd.getSize() + ",ad_id=" + currentAd.getAdIdNumber() + ",dsp=" + currentAd.getDspName());
            this.sdk.Cs().a(r.a.TEMPLATE_ERROR, (Map<String, String>) hashMap);
        }
    }
}
