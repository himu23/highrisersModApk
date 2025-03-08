package com.applovin.sdk;

import android.app.Activity;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.webkit.RenderProcessGoneDetail;
import android.webkit.WebSettings;
import android.webkit.WebView;
import com.applovin.impl.sdk.ab;
import com.applovin.impl.sdk.c.b;
import com.applovin.impl.sdk.n;
import com.applovin.impl.sdk.utils.StringUtils;
import com.applovin.impl.sdk.utils.u;
import com.applovin.impl.sdk.x;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;

public class AppLovinWebViewActivity extends Activity {
    public static final String EVENT_DISMISSED_VIA_BACK_BUTTON = "dismissed_via_back_button";
    public static final String INTENT_EXTRA_KEY_IMMERSIVE_MODE_ON = "immersive_mode_on";
    public static final String INTENT_EXTRA_KEY_LOAD_URL = "load_url";
    public static final String INTENT_EXTRA_KEY_SDK_KEY = "sdk_key";
    public static final String URI_PATH_WEBVIEW_EVENT = "webview_event";
    /* access modifiers changed from: private */
    public final AtomicBoolean aZB = new AtomicBoolean();
    /* access modifiers changed from: private */
    public String aZC;
    /* access modifiers changed from: private */
    public EventListener aZD;
    /* access modifiers changed from: private */
    public WebView webView;

    public interface EventListener {
        void onReceivedEvent(String str);
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        String stringExtra = getIntent().getStringExtra(INTENT_EXTRA_KEY_SDK_KEY);
        if (TextUtils.isEmpty(stringExtra)) {
            x.H("AppLovinWebViewActivity", "No SDK key specified");
            finish();
            return;
        }
        S(AppLovinSdk.getInstance(stringExtra, new AppLovinSdkSettings(getApplicationContext()), getApplicationContext()).a());
        if (getIntent().getBooleanExtra(INTENT_EXTRA_KEY_IMMERSIVE_MODE_ON, false)) {
            getWindow().getDecorView().setSystemUiVisibility(5894);
        }
        String stringExtra2 = getIntent().getStringExtra(INTENT_EXTRA_KEY_LOAD_URL);
        this.aZC = stringExtra2;
        if (StringUtils.isValidString(stringExtra2)) {
            this.webView.loadUrl(this.aZC);
        }
    }

    public void onBackPressed() {
        EventListener eventListener = this.aZD;
        if (eventListener != null) {
            eventListener.onReceivedEvent(EVENT_DISMISSED_VIA_BACK_BUTTON);
        }
        super.onBackPressed();
    }

    public void loadUrl(String str, EventListener eventListener) {
        this.aZD = eventListener;
        this.aZC = str;
        this.aZB.set(false);
        WebView webView2 = this.webView;
        if (webView2 != null) {
            webView2.loadUrl(str);
        }
    }

    /* access modifiers changed from: private */
    public void S(final n nVar) {
        WebView b = u.b((Context) this, "WebView Activity");
        this.webView = b;
        if (b == null) {
            finish();
            return;
        }
        setContentView(b);
        WebSettings settings = this.webView.getSettings();
        settings.setSupportMultipleWindows(false);
        settings.setJavaScriptEnabled(true);
        this.webView.setVerticalScrollBarEnabled(true);
        this.webView.setHorizontalScrollBarEnabled(true);
        this.webView.setScrollBarStyle(33554432);
        this.webView.setWebViewClient(new ab() {
            public boolean shouldOverrideUrlLoading(WebView webView, String str) {
                Uri parse = Uri.parse(str);
                String scheme = parse.getScheme();
                String host = parse.getHost();
                String path = parse.getPath();
                nVar.BN();
                if (x.Fn()) {
                    x BN = nVar.BN();
                    BN.f("AppLovinWebViewActivity", "Handling url load: " + str);
                }
                if (!"applovin".equalsIgnoreCase(scheme) || !"com.applovin.sdk".equalsIgnoreCase(host) || AppLovinWebViewActivity.this.aZD == null) {
                    return super.shouldOverrideUrlLoading(webView, str);
                }
                if (!path.endsWith(AppLovinWebViewActivity.URI_PATH_WEBVIEW_EVENT)) {
                    return true;
                }
                Set<String> queryParameterNames = parse.getQueryParameterNames();
                String str2 = queryParameterNames.isEmpty() ? "" : (String) queryParameterNames.toArray()[0];
                if (StringUtils.isValidString(str2)) {
                    String queryParameter = parse.getQueryParameter(str2);
                    nVar.BN();
                    if (x.Fn()) {
                        x BN2 = nVar.BN();
                        BN2.f("AppLovinWebViewActivity", "Parsed WebView event parameter name: " + str2 + " and value: " + queryParameter);
                    }
                    AppLovinWebViewActivity.this.aZD.onReceivedEvent(queryParameter);
                    return true;
                }
                nVar.BN();
                if (!x.Fn()) {
                    return true;
                }
                nVar.BN().i("AppLovinWebViewActivity", "Failed to parse WebView event parameter");
                return true;
            }

            public boolean onRenderProcessGone(WebView webView, RenderProcessGoneDetail renderProcessGoneDetail) {
                if (AppLovinWebViewActivity.this.webView == webView) {
                    AppLovinWebViewActivity.this.webView.destroy();
                    WebView unused = AppLovinWebViewActivity.this.webView = null;
                    AppLovinWebViewActivity.this.runOnUiThread(new AppLovinWebViewActivity$1$$ExternalSyntheticLambda0(this, nVar));
                }
                return super.onRenderProcessGone(webView, renderProcessGoneDetail);
            }

            /* access modifiers changed from: private */
            public /* synthetic */ void T(n nVar) {
                if (!((Boolean) nVar.a(b.aQq)).booleanValue() || !AppLovinWebViewActivity.this.aZB.compareAndSet(false, true)) {
                    AppLovinWebViewActivity.this.finish();
                    return;
                }
                AppLovinWebViewActivity.this.S(nVar);
                if (StringUtils.isValidString(AppLovinWebViewActivity.this.aZC)) {
                    AppLovinWebViewActivity.this.webView.loadUrl(AppLovinWebViewActivity.this.aZC);
                }
            }
        });
    }
}
