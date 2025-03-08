package com.ironsource.sdk.controller;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Message;
import android.text.TextUtils;
import android.util.Log;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.webkit.ConsoleMessage;
import android.webkit.DownloadListener;
import android.webkit.JavascriptInterface;
import android.webkit.RenderProcessGoneDetail;
import android.webkit.ValueCallback;
import android.webkit.WebBackForwardList;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.FrameLayout;
import android.widget.Toast;
import com.google.android.gms.drive.DriveFile;
import com.ironsource.aa;
import com.ironsource.ab;
import com.ironsource.ca;
import com.ironsource.d6;
import com.ironsource.d8;
import com.ironsource.e6;
import com.ironsource.f0;
import com.ironsource.f6;
import com.ironsource.g$$ExternalSyntheticApiModelOutline0;
import com.ironsource.g6;
import com.ironsource.gd;
import com.ironsource.h3;
import com.ironsource.hd;
import com.ironsource.i2;
import com.ironsource.i3;
import com.ironsource.j6;
import com.ironsource.jc;
import com.ironsource.k0;
import com.ironsource.k2;
import com.ironsource.l2;
import com.ironsource.l3;
import com.ironsource.l6;
import com.ironsource.m2;
import com.ironsource.m3;
import com.ironsource.mediationsdk.utils.IronSourceConstants;
import com.ironsource.n2;
import com.ironsource.n5;
import com.ironsource.n6;
import com.ironsource.o2;
import com.ironsource.pc;
import com.ironsource.q3;
import com.ironsource.sdk.controller.f;
import com.ironsource.sdk.controller.k;
import com.ironsource.sdk.controller.m;
import com.ironsource.sdk.utils.IronSourceStorageUtils;
import com.ironsource.sdk.utils.Logger;
import com.ironsource.sdk.utils.SDKUtils;
import com.ironsource.t4;
import com.ironsource.u2;
import com.ironsource.uc;
import com.ironsource.v2;
import com.ironsource.v6;
import com.ironsource.w2;
import com.ironsource.w9;
import com.ironsource.x2;
import com.ironsource.x5;
import com.ironsource.x8;
import com.ironsource.y2;
import com.ironsource.y9;
import com.ironsource.z3;
import com.ironsource.za;
import com.unity3d.ads.metadata.InAppPurchaseMetaData;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class u extends WebView implements k, y9, DownloadListener {
    private static final String a0 = "about:blank";
    public static int b0 = 0;
    public static String c0 = "is_store";
    public static String d0 = "external_url";
    public static String e0 = "secondary_web_view";
    /* access modifiers changed from: private */
    public static String f0 = "success";
    /* access modifiers changed from: private */
    public static String g0 = "fail";
    /* access modifiers changed from: private */
    public v2 A;
    /* access modifiers changed from: private */
    public Boolean B = null;
    /* access modifiers changed from: private */
    public String C;
    /* access modifiers changed from: private */
    public d D;
    /* access modifiers changed from: private */
    public uc E;
    /* access modifiers changed from: private */
    public f0 F;
    private Object G = new Object();
    /* access modifiers changed from: private */
    public boolean H = false;
    /* access modifiers changed from: private */
    public i3 I;
    /* access modifiers changed from: private */
    public o J;
    /* access modifiers changed from: private */
    public p K;
    /* access modifiers changed from: private */
    public t L;
    /* access modifiers changed from: private */
    public i M;
    /* access modifiers changed from: private */
    public a N;
    /* access modifiers changed from: private */
    public j O;
    private gd P;
    /* access modifiers changed from: private */
    public c Q;
    /* access modifiers changed from: private */
    public i2 R;
    /* access modifiers changed from: private */
    public JSONObject S;
    /* access modifiers changed from: private */
    public k.a T;
    /* access modifiers changed from: private */
    public k.b U;
    o2 V;
    /* access modifiers changed from: private */
    public aa W;
    private final n5 a;
    /* access modifiers changed from: private */
    public String b = "u";
    /* access modifiers changed from: private */
    public String c = IronSourceConstants.IRONSOURCE_CONFIG_NAME;
    private final String d = "We're sorry, some error occurred. we will investigate it";
    /* access modifiers changed from: private */
    public String e;
    /* access modifiers changed from: private */
    public String f;
    private Map<String, String> g;
    /* access modifiers changed from: private */
    public final q3 h;
    /* access modifiers changed from: private */
    public boolean i;
    /* access modifiers changed from: private */
    public t j;
    /* access modifiers changed from: private */
    public boolean k;
    /* access modifiers changed from: private */
    public CountDownTimer l;
    public CountDownTimer m;
    /* access modifiers changed from: private */
    public int n = 50;
    /* access modifiers changed from: private */
    public int o = 50;
    /* access modifiers changed from: private */
    public String p = m2.e.b;
    private final s q;
    /* access modifiers changed from: private */
    public View r;
    /* access modifiers changed from: private */
    public FrameLayout s;
    /* access modifiers changed from: private */
    public WebChromeClient.CustomViewCallback t;
    /* access modifiers changed from: private */
    public FrameLayout u;
    /* access modifiers changed from: private */
    public y v;
    private String w;
    /* access modifiers changed from: private */
    public x2 x;
    /* access modifiers changed from: private */
    public w2 y;
    /* access modifiers changed from: private */
    public w9 z;

    class a implements Runnable {
        final /* synthetic */ e6.e a;
        final /* synthetic */ h3 b;
        final /* synthetic */ String c;

        a(e6.e eVar, h3 h3Var, String str) {
            this.a = eVar;
            this.b = h3Var;
            this.c = str;
        }

        public void run() {
            e6.e eVar = e6.e.RewardedVideo;
            e6.e eVar2 = this.a;
            if (eVar == eVar2 || e6.e.Interstitial == eVar2 || e6.e.Banner == eVar2) {
                h3 h3Var = this.b;
                if (h3Var != null && !TextUtils.isEmpty(h3Var.h())) {
                    u2 a2 = u.this.a(this.a);
                    String z = u.this.b;
                    Log.d(z, "onAdProductInitFailed (message:" + this.c + ")(" + this.a + ")");
                    if (a2 != null) {
                        a2.a(this.a, this.b.h(), this.c);
                    }
                }
            } else if (e6.e.OfferWall == eVar2) {
                u.this.z.onOfferwallInitFail(this.c);
            } else if (e6.e.OfferWallCredits == eVar2) {
                u.this.z.onGetOWCreditsFailed(this.c);
            }
        }
    }

    private class a0 extends WebViewClient {
        private a0() {
        }

        /* synthetic */ a0(u uVar, j jVar) {
            this();
        }

        public void onPageFinished(WebView webView, String str) {
            Logger.i("onPageFinished", str);
            if (str.contains("adUnit") || str.contains("index.html")) {
                u.this.m();
            }
            super.onPageFinished(webView, str);
        }

        public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
            Logger.i("onPageStarted", str);
            super.onPageStarted(webView, str, bitmap);
        }

        public void onReceivedError(WebView webView, int i, String str, String str2) {
            Logger.i("onReceivedError", str2 + " " + str);
            if (str2.contains(m2.g) && u.this.Q != null) {
                c b = u.this.Q;
                b.b("controller html - web-view receivedError on loading - " + str + " (errorCode: " + i + ")");
            }
            super.onReceivedError(webView, i, str, str2);
        }

        public boolean onRenderProcessGone(WebView webView, RenderProcessGoneDetail renderProcessGoneDetail) {
            String z = u.this.b;
            Log.e(z, "Chromium process crashed - detail.didCrash(): " + g$$ExternalSyntheticApiModelOutline0.m(renderProcessGoneDetail));
            String str = g$$ExternalSyntheticApiModelOutline0.m(renderProcessGoneDetail) ? "Render process was observed to crash" : "Render process was killed by the system";
            if (u.this.Q != null) {
                u.this.Q.c(str);
            }
            u.this.i();
            return true;
        }

        /* JADX WARNING: No exception handlers in catch block: Catch:{  } */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public android.webkit.WebResourceResponse shouldInterceptRequest(android.webkit.WebView r6, java.lang.String r7) {
            /*
                r5 = this;
                java.lang.String r0 = "mraid.js"
                java.lang.String r1 = "shouldInterceptRequest"
                com.ironsource.sdk.utils.Logger.i(r1, r7)
                java.net.URL r1 = new java.net.URL     // Catch:{ MalformedURLException -> 0x004e }
                r1.<init>(r7)     // Catch:{ MalformedURLException -> 0x004e }
                java.lang.String r1 = r1.getFile()     // Catch:{ MalformedURLException -> 0x004e }
                boolean r1 = r1.contains(r0)     // Catch:{ MalformedURLException -> 0x004e }
                if (r1 == 0) goto L_0x004e
                java.lang.StringBuilder r1 = new java.lang.StringBuilder
                java.lang.String r2 = "file://"
                r1.<init>(r2)
                com.ironsource.sdk.controller.u r2 = com.ironsource.sdk.controller.u.this
                java.lang.String r2 = r2.C
                r1.append(r2)
                java.lang.String r2 = java.io.File.separator
                r1.append(r2)
                r1.append(r0)
                java.lang.String r0 = r1.toString()
                java.io.File r1 = new java.io.File
                r1.<init>(r0)
                java.io.FileInputStream r2 = new java.io.FileInputStream     // Catch:{  }
                r2.<init>(r1)     // Catch:{  }
                android.webkit.WebResourceResponse r1 = new android.webkit.WebResourceResponse     // Catch:{  }
                java.lang.String r2 = "text/javascript"
                java.lang.String r3 = "UTF-8"
                java.lang.Class r4 = r5.getClass()     // Catch:{  }
                java.io.InputStream r0 = r4.getResourceAsStream(r0)     // Catch:{  }
                r1.<init>(r2, r3, r0)     // Catch:{  }
                return r1
            L_0x004e:
                android.webkit.WebResourceResponse r6 = super.shouldInterceptRequest(r6, r7)
                return r6
            */
            throw new UnsupportedOperationException("Method not decompiled: com.ironsource.sdk.controller.u.a0.shouldInterceptRequest(android.webkit.WebView, java.lang.String):android.webkit.WebResourceResponse");
        }

        public boolean shouldOverrideUrlLoading(WebView webView, String str) {
            Logger.i("shouldOverrideUrlLoading", str);
            try {
                if (u.this.i(str)) {
                    u.this.l();
                    return true;
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            return super.shouldOverrideUrlLoading(webView, str);
        }
    }

    class b implements Runnable {
        final /* synthetic */ StringBuilder a;
        final /* synthetic */ String b;

        b(StringBuilder sb, String str) {
            this.a = sb;
            this.b = str;
        }

        public void run() {
            try {
                if (u.this.B == null) {
                    u.this.d(this.a.toString());
                    Boolean unused = u.this.B = Boolean.TRUE;
                } else if (u.this.B.booleanValue()) {
                    u.this.d(this.a.toString());
                } else {
                    u.this.loadUrl(this.b);
                }
            } catch (Throwable th) {
                String z = u.this.b;
                Logger.e(z, "injectJavascript: " + th.toString());
            }
        }
    }

    class c implements Runnable {
        c() {
        }

        public void run() {
            u.this.a(1);
        }
    }

    class d implements Runnable {
        d() {
        }

        public void run() {
            u.this.a(1);
        }
    }

    class e implements Runnable {
        final /* synthetic */ f6 a;

        e(f6 f6Var) {
            this.a = f6Var;
        }

        public void run() {
            c b2 = u.this.Q;
            b2.b("controller html - failed to download - " + this.a.b());
        }
    }

    class f implements Runnable {
        final /* synthetic */ String a;
        final /* synthetic */ String b;

        f(String str, String str2) {
            this.a = str;
            this.b = str2;
        }

        public void run() {
            if (u.this.getDebugMode() == e6.d.MODE_3.a()) {
                Context currentActivityContext = u.this.getCurrentActivityContext();
                Toast.makeText(currentActivityContext, this.a + " : " + this.b, 1).show();
            }
        }
    }

    class g implements Runnable {
        final /* synthetic */ Context a;

        g(Context context) {
            this.a = context;
        }

        public void run() {
            u.this.f(this.a);
        }
    }

    class h implements Runnable {
        final /* synthetic */ Context a;

        h(Context context) {
            this.a = context;
        }

        public void run() {
            u.this.g(this.a);
        }
    }

    class i implements Runnable {
        final /* synthetic */ e6.e a;
        final /* synthetic */ String b;

        i(e6.e eVar, String str) {
            this.a = eVar;
            this.b = str;
        }

        public void run() {
            e6.e eVar = this.a;
            if (eVar == e6.e.RewardedVideo || eVar == e6.e.Interstitial) {
                u2 a2 = u.this.a(eVar);
                if (a2 != null) {
                    a2.a(this.a, this.b);
                }
            } else if (eVar == e6.e.OfferWall) {
                u.this.z.onOWAdClosed();
            }
        }
    }

    class j extends i2 {
        j(JSONObject jSONObject, Context context) {
            super(jSONObject, context);
        }

        public void a() {
            if (u.this.i) {
                u.this.m("none");
            }
        }

        public void a(String str, JSONObject jSONObject) {
            if (u.this.i) {
                u.this.m(str);
            }
        }

        public void b(String str, JSONObject jSONObject) {
            if (jSONObject != null && u.this.i) {
                try {
                    jSONObject.put("connectionType", str);
                    u.this.e(jSONObject);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    class k implements gd {
        k() {
        }

        public void a(String str, JSONObject jSONObject) {
            u.this.j(u.this.c(str, jSONObject.toString()));
        }
    }

    class l implements Runnable {
        final /* synthetic */ JSONObject a;
        final /* synthetic */ String b;

        l(JSONObject jSONObject, String str) {
            this.a = jSONObject;
            this.b = str;
        }

        public void run() {
            u.this.setWebDebuggingEnabled(this.a);
            u.this.l("about:blank");
            u.this.l(this.b);
        }
    }

    class m extends CountDownTimer {
        final /* synthetic */ int a;

        class a implements Runnable {
            a() {
            }

            public void run() {
                u.this.Q.b(m2.c.j);
            }
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        m(long j, long j2, int i) {
            super(j, j2);
            this.a = i;
        }

        public void onFinish() {
            Logger.i(u.this.b, "Loading Controller Timer Finish");
            int i = this.a;
            if (i == 3) {
                u.this.b((Runnable) new a());
            } else {
                u.this.a(i + 1);
            }
        }

        public void onTick(long j) {
            String z = u.this.b;
            Logger.i(z, "Loading Controller Timer Tick " + j);
        }
    }

    class n implements w {
        n() {
        }

        public void a(String str, e6.e eVar, h3 h3Var) {
            u.this.a(str, eVar, h3Var);
        }
    }

    class o implements w {
        o() {
        }

        public void a(String str, e6.e eVar, h3 h3Var) {
            u.this.a(str, eVar, h3Var);
        }
    }

    class p implements w {
        p() {
        }

        public void a(String str, e6.e eVar, h3 h3Var) {
            u.this.a(str, eVar, h3Var);
        }
    }

    class q implements w {
        q() {
        }

        public void a(String str, e6.e eVar, h3 h3Var) {
            u.this.a(str, eVar, h3Var);
        }
    }

    class r implements w {
        r() {
        }

        public void a(String str, e6.e eVar, h3 h3Var) {
            u.this.a(str, eVar, h3Var);
        }
    }

    private class s extends WebChromeClient {
        private s() {
        }

        /* synthetic */ s(u uVar, j jVar) {
            this();
        }

        public View getVideoLoadingProgressView() {
            FrameLayout frameLayout = new FrameLayout(u.this.getContext());
            frameLayout.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
            return frameLayout;
        }

        public boolean onConsoleMessage(ConsoleMessage consoleMessage) {
            Logger.i("MyApplication", consoleMessage.message() + " -- From line " + consoleMessage.lineNumber() + " of " + consoleMessage.sourceId());
            return true;
        }

        public boolean onCreateWindow(WebView webView, boolean z, boolean z2, Message message) {
            WebView webView2 = new WebView(webView.getContext());
            webView2.setWebChromeClient(this);
            webView2.setWebViewClient(new C0024u(u.this, (j) null));
            ((WebView.WebViewTransport) message.obj).setWebView(webView2);
            message.sendToTarget();
            Logger.i("onCreateWindow", "onCreateWindow");
            return true;
        }

        public void onHideCustomView() {
            Logger.i("Test", "onHideCustomView");
            if (u.this.r != null) {
                u.this.r.setVisibility(8);
                u.this.s.removeView(u.this.r);
                View unused = u.this.r = null;
                u.this.s.setVisibility(8);
                u.this.t.onCustomViewHidden();
                u.this.setVisibility(0);
            }
        }

        public void onShowCustomView(View view, WebChromeClient.CustomViewCallback customViewCallback) {
            Logger.i("Test", "onShowCustomView");
            u.this.setVisibility(8);
            if (u.this.r != null) {
                Logger.i("Test", "mCustomView != null");
                customViewCallback.onCustomViewHidden();
                return;
            }
            Logger.i("Test", "mCustomView == null");
            u.this.s.addView(view);
            View unused = u.this.r = view;
            WebChromeClient.CustomViewCallback unused2 = u.this.t = customViewCallback;
            u.this.s.setVisibility(0);
        }
    }

    static class t {
        e6.e a;
        String b;

        public t(e6.e eVar, String str) {
            this.a = eVar;
            this.b = str;
        }

        /* access modifiers changed from: package-private */
        public String a() {
            return this.b;
        }

        /* access modifiers changed from: package-private */
        public e6.e b() {
            return this.a;
        }
    }

    /* renamed from: com.ironsource.sdk.controller.u$u  reason: collision with other inner class name */
    private class C0024u extends WebViewClient {
        private C0024u() {
        }

        /* synthetic */ C0024u(u uVar, j jVar) {
            this();
        }

        public boolean onRenderProcessGone(WebView webView, RenderProcessGoneDetail renderProcessGoneDetail) {
            String z = u.this.b;
            Logger.e(z, "Chromium process crashed - detail.didCrash(): " + g$$ExternalSyntheticApiModelOutline0.m(renderProcessGoneDetail));
            return true;
        }

        public boolean shouldOverrideUrlLoading(WebView webView, String str) {
            Context currentActivityContext = u.this.getCurrentActivityContext();
            Intent intent = new Intent(currentActivityContext, OpenUrlActivity.class);
            intent.putExtra(u.d0, str);
            intent.putExtra(u.e0, false);
            currentActivityContext.startActivity(intent);
            return true;
        }
    }

    public class v {

        class a implements Runnable {
            final /* synthetic */ String a;
            final /* synthetic */ String b;

            a(String str, String str2) {
                this.a = str;
                this.b = str2;
            }

            public void run() {
                String str = this.a;
                if (str == null) {
                    str = "We're sorry, some error occurred. we will investigate it";
                }
                String z = u.this.b;
                Log.d(z, "onRVInitFail(message:" + str + ")");
                u.this.x.a(e6.e.RewardedVideo, this.b, str);
            }
        }

        class a0 implements Runnable {
            final /* synthetic */ String a;

            a0(String str) {
                this.a = str;
            }

            public void run() {
                try {
                    u.this.O.a(new JSONObject(this.a), new e0());
                } catch (Exception e) {
                    e.printStackTrace();
                    String z = u.this.b;
                    Logger.i(z, "fileSystemAPI failed with exception " + e.getMessage());
                }
            }
        }

        class b implements Runnable {
            final /* synthetic */ String a;
            final /* synthetic */ String b;

            b(String str, String str2) {
                this.a = str;
                this.b = str2;
            }

            public void run() {
                String str = this.a;
                if (str == null) {
                    str = "We're sorry, some error occurred. we will investigate it";
                }
                String z = u.this.b;
                Log.d(z, "onRVShowFail(message:" + this.a + ")");
                u.this.x.d(this.b, str);
            }
        }

        class b0 implements Runnable {
            final /* synthetic */ String a;
            final /* synthetic */ String b;
            final /* synthetic */ int c;
            final /* synthetic */ boolean d;
            final /* synthetic */ int e;
            final /* synthetic */ boolean f;
            final /* synthetic */ String g;
            final /* synthetic */ String h;

            b0(String str, String str2, int i2, boolean z, int i3, boolean z2, String str3, String str4) {
                this.a = str;
                this.b = str2;
                this.c = i2;
                this.d = z;
                this.e = i3;
                this.f = z2;
                this.g = str3;
                this.h = str4;
            }

            public void run() {
                if (this.a.equalsIgnoreCase(e6.e.RewardedVideo.toString())) {
                    u.this.x.a(this.b, this.c);
                } else if (this.a.equalsIgnoreCase(e6.e.OfferWall.toString()) && this.d && u.this.z.onOWAdCredited(this.c, this.e, this.f) && !TextUtils.isEmpty(this.g)) {
                    if (d8.e().a(this.g, u.this.e, u.this.f)) {
                        u.this.a(this.h, true, (String) null, (String) null);
                    } else {
                        u.this.a(this.h, false, "Time Stamp could not be stored", (String) null);
                    }
                }
            }
        }

        class c implements Runnable {
            final /* synthetic */ String a;

            c(String str) {
                this.a = str;
            }

            public void run() {
                u.this.z.onOWShowSuccess(this.a);
            }
        }

        class c0 implements Runnable {
            final /* synthetic */ String a;
            final /* synthetic */ int b;

            c0(String str, int i) {
                this.a = str;
                this.b = i;
            }

            public void run() {
                u.this.y.onInterstitialAdRewarded(this.a, this.b);
            }
        }

        class d implements Runnable {
            final /* synthetic */ String a;

            d(String str) {
                this.a = str;
            }

            public void run() {
                String str = this.a;
                if (str == null) {
                    str = "We're sorry, some error occurred. we will investigate it";
                }
                u.this.z.onOWShowFail(str);
            }
        }

        class d0 implements Runnable {
            d0() {
            }

            public void run() {
                u uVar = u.this;
                uVar.setOnTouchListener(new z(uVar, (j) null));
            }
        }

        class e implements Runnable {
            final /* synthetic */ String a;

            e(String str) {
                this.a = str;
            }

            public void run() {
                Log.d(u.this.b, "onInterstitialInitSuccess()");
                u.this.y.a(e6.e.Interstitial, this.a, (com.ironsource.e0) null);
            }
        }

        public class e0 {
            public e0() {
            }

            /* access modifiers changed from: package-private */
            public void a(boolean z, String str, ab abVar) {
                abVar.b(z ? u.f0 : u.g0, str);
                u.this.a(abVar.toString(), z, (String) null, (String) null);
            }

            /* access modifiers changed from: package-private */
            public void a(boolean z, String str, String str2) {
                ab abVar = new ab();
                abVar.b(z ? u.f0 : u.g0, str);
                abVar.b("data", str2);
                u.this.a(abVar.toString(), z, (String) null, (String) null);
            }

            public void a(boolean z, String str, JSONObject jSONObject) {
                String str2;
                if (z) {
                    try {
                        str2 = u.f0;
                    } catch (JSONException e) {
                        e.printStackTrace();
                        e.getMessage();
                        return;
                    }
                } else {
                    str2 = u.g0;
                }
                jSONObject.put(str2, str);
                u.this.a(jSONObject.toString(), z, (String) null, (String) null);
            }
        }

        class f implements Runnable {
            final /* synthetic */ String a;
            final /* synthetic */ String b;

            f(String str, String str2) {
                this.a = str;
                this.b = str2;
            }

            public void run() {
                String str = this.a;
                if (str == null) {
                    str = "We're sorry, some error occurred. we will investigate it";
                }
                String z = u.this.b;
                Log.d(z, "onInterstitialInitFail(message:" + str + ")");
                u.this.y.a(e6.e.Interstitial, this.b, str);
            }
        }

        class g implements Runnable {
            final /* synthetic */ u2 a;
            final /* synthetic */ e6.e b;
            final /* synthetic */ String c;

            g(u2 u2Var, e6.e eVar, String str) {
                this.a = u2Var;
                this.b = eVar;
                this.c = str;
            }

            public void run() {
                this.a.c(this.b, this.c);
            }
        }

        class h implements Runnable {
            final /* synthetic */ String a;

            h(String str) {
                this.a = str;
            }

            public void run() {
                u.this.y.b(e6.e.Interstitial, this.a);
                u.this.y.c(this.a);
            }
        }

        class i implements Runnable {
            i() {
            }

            public void run() {
                Log.d(u.this.b, "onOfferWallInitSuccess()");
                u.this.z.onOfferwallInitSuccess();
            }
        }

        class j implements Runnable {
            final /* synthetic */ String a;

            j(String str) {
                this.a = str;
            }

            public void run() {
                String str = this.a;
                if (str == null) {
                    str = "We're sorry, some error occurred. we will investigate it";
                }
                String z = u.this.b;
                Log.d(z, "onOfferWallInitFail(message:" + str + ")");
                u.this.z.onOfferwallInitFail(str);
            }
        }

        class k implements Runnable {
            k() {
            }

            public void run() {
                u.this.q();
            }
        }

        class l implements Runnable {
            final /* synthetic */ String a;

            l(String str) {
                this.a = str;
            }

            public void run() {
                u.this.y.b(this.a);
            }
        }

        class m implements Runnable {
            final /* synthetic */ String a;
            final /* synthetic */ String b;

            m(String str, String str2) {
                this.a = str;
                this.b = str2;
            }

            public void run() {
                String str = this.a;
                if (str == null) {
                    str = "We're sorry, some error occurred. we will investigate it";
                }
                u.this.y.c(this.b, str);
            }
        }

        class n implements Runnable {
            final /* synthetic */ String a;
            final /* synthetic */ String b;

            n(String str, String str2) {
                this.a = str;
                this.b = str2;
            }

            public void run() {
                String str = this.a;
                if (str == null) {
                    str = "We're sorry, some error occurred. we will investigate it";
                }
                u.this.y.b(this.b, str);
            }
        }

        class o implements Runnable {
            final /* synthetic */ String a;

            o(String str) {
                this.a = str;
            }

            public void run() {
                Log.d(u.this.b, "onBannerInitSuccess()");
                u.this.A.a(e6.e.Banner, this.a, (com.ironsource.e0) null);
            }
        }

        class p implements Runnable {
            final /* synthetic */ String a;
            final /* synthetic */ String b;

            p(String str, String str2) {
                this.a = str;
                this.b = str2;
            }

            public void run() {
                String str = this.a;
                if (str == null) {
                    str = "We're sorry, some error occurred. we will investigate it";
                }
                String z = u.this.b;
                Log.d(z, "onBannerInitFail(message:" + str + ")");
                u.this.A.a(e6.e.Banner, this.b, str);
            }
        }

        class q implements Runnable {
            final /* synthetic */ String a;
            final /* synthetic */ x5 b;

            q(String str, x5 x5Var) {
                this.a = str;
                this.b = x5Var;
            }

            public void run() {
                Log.d(u.this.b, "onBannerLoadSuccess()");
                u.this.A.a(this.a, this.b);
            }
        }

        class r implements Runnable {
            final /* synthetic */ String a;
            final /* synthetic */ String b;

            r(String str, String str2) {
                this.a = str;
                this.b = str2;
            }

            public void run() {
                Log.d(u.this.b, "onLoadBannerFail()");
                String str = this.a;
                if (str == null) {
                    str = "We're sorry, some error occurred. we will investigate it";
                }
                u.this.A.a(this.b, str);
            }
        }

        class s implements Runnable {
            final /* synthetic */ String a;

            s(String str) {
                this.a = str;
            }

            public void run() {
                try {
                    if (new JSONObject(this.a).has(f.b.b)) {
                        u.this.T.a(f.a.a(this.a));
                        return;
                    }
                    u.this.U.a(x8.a(this.a));
                } catch (JSONException e) {
                    Logger.e(u.this.b, "failed to parse received message");
                    e.printStackTrace();
                }
            }
        }

        class t implements Runnable {
            final /* synthetic */ String a;

            t(String str) {
                this.a = str;
            }

            public void run() {
                String str = this.a;
                if (str == null) {
                    str = "We're sorry, some error occurred. we will investigate it";
                }
                u.this.z.onGetOWCreditsFailed(str);
            }
        }

        /* renamed from: com.ironsource.sdk.controller.u$v$u  reason: collision with other inner class name */
        class C0025u implements Runnable {
            final /* synthetic */ e6.e a;
            final /* synthetic */ String b;
            final /* synthetic */ String c;
            final /* synthetic */ JSONObject d;

            C0025u(e6.e eVar, String str, String str2, JSONObject jSONObject) {
                this.a = eVar;
                this.b = str;
                this.c = str2;
                this.d = jSONObject;
            }

            public void run() {
                e6.e eVar = this.a;
                if (eVar == e6.e.Interstitial || eVar == e6.e.RewardedVideo || eVar == e6.e.Banner) {
                    u2 a2 = u.this.a(eVar);
                    if (a2 != null) {
                        a2.a(this.a, this.b, this.c, this.d);
                    }
                } else if (eVar == e6.e.OfferWall) {
                    u.this.z.onOfferwallEventNotificationReceived(this.c, this.d);
                }
            }
        }

        /* renamed from: com.ironsource.sdk.controller.u$v$v  reason: collision with other inner class name */
        class C0026v implements Runnable {
            C0026v() {
            }

            public void run() {
                u.this.n();
            }
        }

        class w implements Runnable {
            final /* synthetic */ String a;

            w(String str) {
                this.a = str;
            }

            public void run() {
                try {
                    String z = u.this.b;
                    Logger.i(z, "omidAPI(" + this.a + ")");
                    u.this.J.a(new ab(this.a).toString(), new e0());
                } catch (Exception e) {
                    e.printStackTrace();
                    String z2 = u.this.b;
                    Logger.i(z2, "omidAPI failed with exception " + e.getMessage());
                }
            }
        }

        class x implements Runnable {
            x() {
            }

            public void run() {
                u.this.removeJavascriptInterface(m2.f);
            }
        }

        class y implements Runnable {
            y() {
            }

            public void run() {
                u.this.getSettings().setMixedContentMode(0);
            }
        }

        class z implements Runnable {
            final /* synthetic */ int a;
            final /* synthetic */ String b;
            final /* synthetic */ com.ironsource.e0 c;

            z(int i, String str, com.ironsource.e0 e0Var) {
                this.a = i;
                this.b = str;
                this.c = e0Var;
            }

            public void run() {
                if (this.a > 0) {
                    Log.d(u.this.b, "onRVInitSuccess()");
                    u.this.x.a(e6.e.RewardedVideo, this.b, this.c);
                    return;
                }
                u.this.x.d(this.b);
            }
        }

        public v() {
        }

        private void a(String str, int i2) {
            h3 a2;
            u uVar = u.this;
            e6.e eVar = e6.e.Interstitial;
            if (uVar.n(eVar.toString()) && (a2 = u.this.I.a(eVar, str)) != null && a2.k()) {
                u.this.b((Runnable) new c0(str, i2));
            }
        }

        private void a(String str, String str2) {
            if (!TextUtils.isEmpty(str)) {
                u.this.j(u.this.c(str, str2));
            }
        }

        private void a(String str, boolean z2) {
            h3 a2 = u.this.I.a(e6.e.Interstitial, str);
            if (a2 != null) {
                a2.a(z2);
            }
        }

        private void a(JSONObject jSONObject) {
            try {
                jSONObject.put("controllerSourceData", u.this.D.f());
            } catch (Exception unused) {
            }
        }

        private void a(JSONObject jSONObject, String str) {
            if (a(str)) {
                try {
                    JSONObject jSONObject2 = new JSONObject(str);
                    jSONObject.putOpt("testerABGroup", jSONObject2.get("testerABGroup"));
                    jSONObject.putOpt("testFriendlyName", jSONObject2.get("testFriendlyName"));
                } catch (JSONException unused) {
                    Logger.d(u.this.b, "getControllerConfig Error while parsing Tester AB Group parameters");
                }
            }
        }

        private void b(JSONObject jSONObject) {
            try {
                FeaturesManager instance = FeaturesManager.getInstance();
                if (!instance.a().isEmpty()) {
                    jSONObject.put(m2.a.g, new JSONArray(instance.a()));
                }
            } catch (Exception e2) {
                l6.a(za.p, (Map<String, Object>) new g6().a(z3.z, e2.getMessage()).a());
                Logger.d(u.this.b, "getControllerConfig Error while adding supported features data from FeaturesManager");
            }
        }

        private void c(JSONObject jSONObject) {
            b(jSONObject);
            a(jSONObject, SDKUtils.getTesterParameters());
            a(jSONObject);
        }

        /* access modifiers changed from: package-private */
        public boolean a(String str) {
            if (TextUtils.isEmpty(str) || str.contains("-1")) {
                return false;
            }
            try {
                JSONObject jSONObject = new JSONObject(str);
                return !jSONObject.getString("testerABGroup").isEmpty() && !jSONObject.getString("testFriendlyName").isEmpty();
            } catch (JSONException e2) {
                e2.printStackTrace();
                return false;
            }
        }

        @JavascriptInterface
        public void adClicked(String str) {
            String z2 = u.this.b;
            Logger.i(z2, "adClicked(" + str + ")");
            ab abVar = new ab(str);
            String d2 = abVar.d(m2.h.m);
            String fetchDemandSourceId = SDKUtils.fetchDemandSourceId(abVar);
            if (!TextUtils.isEmpty(fetchDemandSourceId)) {
                e6.e d3 = u.this.h(d2);
                u2 a2 = u.this.a(d3);
                if (d3 != null && a2 != null) {
                    u.this.b((Runnable) new g(a2, d3, fetchDemandSourceId));
                }
            }
        }

        @JavascriptInterface
        public void adCredited(String str) {
            String str2;
            boolean z2;
            boolean z3;
            Log.d(u.this.c, "adCredited(" + str + ")");
            ab abVar = new ab(str);
            String d2 = abVar.d(m2.h.k);
            boolean z4 = false;
            int parseInt = d2 != null ? Integer.parseInt(d2) : 0;
            String fetchDemandSourceId = SDKUtils.fetchDemandSourceId(abVar);
            String d3 = abVar.d(m2.h.m);
            if (TextUtils.isEmpty(d3)) {
                Log.d(u.this.c, "adCredited | product type is missing");
            }
            if (e6.e.Interstitial.toString().equalsIgnoreCase(d3)) {
                a(fetchDemandSourceId, parseInt);
                return;
            }
            String d4 = abVar.d(m2.h.l);
            int parseInt2 = d4 != null ? Integer.parseInt(d4) : 0;
            if (!e6.e.OfferWall.toString().equalsIgnoreCase(d3)) {
                str2 = null;
                z3 = false;
                z2 = false;
            } else if (abVar.e(InAppPurchaseMetaData.KEY_SIGNATURE) || abVar.e(y2.a.d) || abVar.e("totalCreditsFlag")) {
                u.this.a(str, false, "One of the keys are missing: signature/timestamp/totalCreditsFlag", (String) null);
                return;
            } else {
                if (abVar.d(InAppPurchaseMetaData.KEY_SIGNATURE).equalsIgnoreCase(SDKUtils.getMD5(d4 + u.this.e + u.this.f))) {
                    z4 = true;
                } else {
                    u.this.a(str, false, "Controller signature is not equal to SDK signature", (String) null);
                }
                boolean c2 = abVar.c("totalCreditsFlag");
                str2 = abVar.d(y2.a.d);
                z2 = c2;
                z3 = z4;
            }
            if (u.this.n(d3)) {
                u.this.b((Runnable) new b0(d3, fetchDemandSourceId, parseInt, z3, parseInt2, z2, str2, str));
            }
        }

        @JavascriptInterface
        public void adUnitsReady(String str) {
            String z2 = u.this.b;
            Logger.i(z2, "adUnitsReady(" + str + ")");
            String fetchDemandSourceId = SDKUtils.fetchDemandSourceId(new ab(str));
            com.ironsource.e0 e0Var = new com.ironsource.e0(str);
            if (!e0Var.g()) {
                u.this.a(str, false, m2.c.t, (String) null);
                return;
            }
            u.this.a(str, true, (String) null, (String) null);
            String d2 = e0Var.d();
            if (e6.e.RewardedVideo.toString().equalsIgnoreCase(d2) && u.this.n(d2)) {
                u.this.b((Runnable) new z(Integer.parseInt(e0Var.c()), fetchDemandSourceId, e0Var));
            }
        }

        @JavascriptInterface
        public void adViewAPI(String str) {
            try {
                String z2 = u.this.b;
                Logger.i(z2, "adViewAPI(" + str + ")");
                u.this.N.a(new ab(str).toString(), new e0());
            } catch (Exception e2) {
                e2.printStackTrace();
                String z3 = u.this.b;
                Logger.i(z3, "adViewAPI failed with exception " + e2.getMessage());
            }
        }

        /* access modifiers changed from: package-private */
        public void b(String str) {
            u.this.j(u.this.a(m2.g.d, str, (String) null, (String) null));
        }

        @JavascriptInterface
        public void bannerViewAPI(String str) {
            Logger.i(u.this.b, "bannerViewAPI is not supported in this native version, only adview API");
        }

        @JavascriptInterface
        public void cleanAdInstance(String str) {
            e6.e d2;
            try {
                String z2 = u.this.b;
                Logger.i(z2, "cleanAdInstance(" + str + ")");
                ab abVar = new ab(str);
                String d3 = abVar.d(m2.h.m);
                String fetchDemandSourceId = SDKUtils.fetchDemandSourceId(abVar);
                if (!TextUtils.isEmpty(fetchDemandSourceId) && (d2 = u.this.h(d3)) != null) {
                    u.this.I.b(d2, fetchDemandSourceId);
                }
            } catch (Exception e2) {
                u.this.a(str, false, e2.getMessage(), (String) null);
                e2.printStackTrace();
            }
        }

        @JavascriptInterface
        public void clearLastUpdateTimeData(String str) {
            try {
                ArrayList<String> a2 = d8.e().a();
                ab abVar = new ab(str);
                if (!a2.isEmpty()) {
                    abVar.b(m2.h.x0, a2.toString());
                }
                u.this.a(abVar.toString(), true, (String) null, (String) null);
            } catch (Exception e2) {
                u.this.a(str, false, e2.getMessage(), (String) null);
                e2.printStackTrace();
            }
        }

        @JavascriptInterface
        public void deleteFile(String str) {
            try {
                String z2 = u.this.b;
                Logger.i(z2, "deleteFile(" + str + ")");
                ab abVar = new ab(str);
                String d2 = abVar.d(m2.h.b);
                String d3 = abVar.d("path");
                if (d3 != null) {
                    if (!TextUtils.isEmpty(d2)) {
                        n6 n6Var = new n6(IronSourceStorageUtils.buildAbsolutePathToDirInCache(u.this.C, d3), d2);
                        IronSourceStorageUtils.ensurePathSafety(n6Var, u.this.C);
                        if (!n6Var.exists()) {
                            u.this.a(str, false, m2.c.f, "1");
                            return;
                        }
                        u.this.a(str, IronSourceStorageUtils.deleteFile(n6Var), (String) null, (String) null);
                        return;
                    }
                }
                u.this.a(str, false, m2.c.g, "1");
            } catch (Exception e2) {
                u.this.a(str, false, e2.getMessage(), (String) null);
                e2.printStackTrace();
            }
        }

        @JavascriptInterface
        public void deleteFolder(String str) {
            try {
                String z2 = u.this.b;
                Logger.i(z2, "deleteFolder(" + str + ")");
                String d2 = new ab(str).d("path");
                if (d2 == null) {
                    u.this.a(str, false, m2.c.g, "1");
                    return;
                }
                n6 n6Var = new n6(IronSourceStorageUtils.buildAbsolutePathToDirInCache(u.this.C, d2));
                IronSourceStorageUtils.ensurePathSafety(n6Var, u.this.C);
                if (!n6Var.exists()) {
                    u.this.a(str, false, m2.c.e, "1");
                    return;
                }
                u.this.a(str, IronSourceStorageUtils.deleteFolder(n6Var.getPath()), (String) null, (String) null);
            } catch (Exception e2) {
                u.this.a(str, false, e2.getMessage(), (String) null);
                e2.printStackTrace();
            }
        }

        @JavascriptInterface
        public void deviceDataAPI(String str) {
            try {
                String z2 = u.this.b;
                Logger.i(z2, "deviceDataAPI(" + str + ")");
                u.this.M.a(new ab(str).toString(), new e0());
            } catch (Exception e2) {
                e2.printStackTrace();
                String z3 = u.this.b;
                Logger.i(z3, "deviceDataAPI failed with exception " + e2.getMessage());
            }
        }

        @JavascriptInterface
        public void displayWebView(String str) {
            String z2 = u.this.b;
            Logger.i(z2, "displayWebView(" + str + ")");
            u.this.a(str, true, (String) null, (String) null);
            ab abVar = new ab(str);
            boolean booleanValue = ((Boolean) abVar.b(m2.h.d)).booleanValue();
            String d2 = abVar.d(m2.h.m);
            boolean c2 = abVar.c(m2.h.u);
            String d3 = abVar.d("adViewId");
            String fetchDemandSourceId = SDKUtils.fetchDemandSourceId(abVar);
            boolean c3 = abVar.c(m2.h.z0);
            if (booleanValue) {
                boolean unused = u.this.H = abVar.c(m2.h.v);
                boolean c4 = abVar.c(m2.h.y);
                y state = u.this.getState();
                y yVar = y.Display;
                if (state != yVar) {
                    u.this.setState(yVar);
                    String z3 = u.this.b;
                    Logger.i(z3, "State: " + u.this.v);
                    Context currentActivityContext = u.this.getCurrentActivityContext();
                    String orientationState = u.this.getOrientationState();
                    int g2 = m3.g(currentActivityContext);
                    if (c2) {
                        h hVar = new h(currentActivityContext);
                        hVar.addView(u.this.u);
                        hVar.a(u.this);
                        return;
                    }
                    Intent intent = c4 ? new Intent(currentActivityContext, InterstitialActivity.class) : new Intent(currentActivityContext, ControllerActivity.class);
                    e6.e eVar = e6.e.RewardedVideo;
                    if (eVar.toString().equalsIgnoreCase(d2)) {
                        if (m2.h.F.equals(orientationState)) {
                            orientationState = SDKUtils.translateRequestedOrientation(m3.b(currentActivityContext));
                        }
                        intent.putExtra(m2.h.m, eVar.toString());
                        u.this.F.a(eVar.ordinal());
                        u.this.F.f(fetchDemandSourceId);
                        if (u.this.n(eVar.toString())) {
                            u.this.x.b(eVar, fetchDemandSourceId);
                        }
                    } else {
                        e6.e eVar2 = e6.e.OfferWall;
                        if (eVar2.toString().equalsIgnoreCase(d2)) {
                            intent.putExtra(m2.h.m, eVar2.toString());
                            u.this.F.a(eVar2.ordinal());
                        } else {
                            e6.e eVar3 = e6.e.Interstitial;
                            if (eVar3.toString().equalsIgnoreCase(d2)) {
                                if (m2.h.F.equals(orientationState)) {
                                    orientationState = SDKUtils.translateRequestedOrientation(m3.b(currentActivityContext));
                                }
                                intent.putExtra(m2.h.m, eVar3.toString());
                            }
                        }
                    }
                    if (d3 != null) {
                        intent.putExtra("adViewId", d3);
                    }
                    intent.putExtra(m2.h.z0, c3);
                    intent.setFlags(DriveFile.MODE_WRITE_ONLY);
                    intent.putExtra(m2.h.v, u.this.H);
                    intent.putExtra(m2.h.A, orientationState);
                    intent.putExtra(m2.h.B, g2);
                    u uVar = u.this;
                    t unused2 = uVar.j = new t(uVar.h(d2), fetchDemandSourceId);
                    currentActivityContext.startActivity(intent);
                    return;
                }
                String z4 = u.this.b;
                Logger.i(z4, "State: " + u.this.v);
                return;
            }
            u.this.setState(y.Gone);
            u.this.g();
        }

        @JavascriptInterface
        public void fileSystemAPI(String str) {
            String z2 = u.this.b;
            Logger.i(z2, "fileSystemAPI(" + str + ")");
            u.this.a((Runnable) new a0(str));
        }

        /* JADX WARNING: Code restructure failed: missing block: B:6:0x0059, code lost:
            if (android.text.TextUtils.isEmpty(r0) == false) goto L_0x005d;
         */
        /* JADX WARNING: Removed duplicated region for block: B:10:0x0063  */
        /* JADX WARNING: Removed duplicated region for block: B:12:? A[RETURN, SYNTHETIC] */
        @android.webkit.JavascriptInterface
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void getApplicationInfo(java.lang.String r5) {
            /*
                r4 = this;
                com.ironsource.sdk.controller.u r0 = com.ironsource.sdk.controller.u.this
                java.lang.String r0 = r0.b
                java.lang.StringBuilder r1 = new java.lang.StringBuilder
                java.lang.String r2 = "getApplicationInfo("
                r1.<init>(r2)
                r1.append(r5)
                java.lang.String r2 = ")"
                r1.append(r2)
                java.lang.String r1 = r1.toString()
                com.ironsource.sdk.utils.Logger.i(r0, r1)
                com.ironsource.sdk.controller.u r0 = com.ironsource.sdk.controller.u.this
                java.lang.String r0 = r0.f((java.lang.String) r5)
                com.ironsource.sdk.controller.u r1 = com.ironsource.sdk.controller.u.this
                java.lang.String r1 = r1.e((java.lang.String) r5)
                com.ironsource.ab r2 = new com.ironsource.ab
                r2.<init>(r5)
                java.lang.String r5 = "productType"
                java.lang.String r5 = r2.d(r5)
                java.lang.String r2 = com.ironsource.sdk.utils.SDKUtils.fetchDemandSourceId((com.ironsource.ab) r2)
                com.ironsource.sdk.controller.u r3 = com.ironsource.sdk.controller.u.this
                java.lang.Object[] r5 = r3.d((java.lang.String) r5, (java.lang.String) r2)
                r2 = 0
                r2 = r5[r2]
                java.lang.String r2 = (java.lang.String) r2
                r3 = 1
                r5 = r5[r3]
                java.lang.Boolean r5 = (java.lang.Boolean) r5
                boolean r5 = r5.booleanValue()
                if (r5 == 0) goto L_0x0055
                boolean r5 = android.text.TextUtils.isEmpty(r1)
                if (r5 != 0) goto L_0x005c
                r0 = r1
                goto L_0x005d
            L_0x0055:
                boolean r5 = android.text.TextUtils.isEmpty(r0)
                if (r5 != 0) goto L_0x005c
                goto L_0x005d
            L_0x005c:
                r0 = 0
            L_0x005d:
                boolean r5 = android.text.TextUtils.isEmpty(r0)
                if (r5 != 0) goto L_0x0072
                com.ironsource.sdk.controller.u r5 = com.ironsource.sdk.controller.u.this
                java.lang.String r1 = "onGetApplicationInfoSuccess"
                java.lang.String r3 = "onGetApplicationInfoFail"
                java.lang.String r5 = r5.a((java.lang.String) r0, (java.lang.String) r2, (java.lang.String) r1, (java.lang.String) r3)
                com.ironsource.sdk.controller.u r0 = com.ironsource.sdk.controller.u.this
                r0.j((java.lang.String) r5)
            L_0x0072:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.ironsource.sdk.controller.u.v.getApplicationInfo(java.lang.String):void");
        }

        @JavascriptInterface
        public void getCachedFilesMap(String str) {
            u uVar;
            String str2;
            String z2 = u.this.b;
            Logger.i(z2, "getCachedFilesMap(" + str + ")");
            String a2 = u.this.f(str);
            if (!TextUtils.isEmpty(a2)) {
                ab abVar = new ab(str);
                if (!abVar.a("path")) {
                    uVar = u.this;
                    str2 = m2.c.u;
                } else {
                    String str3 = (String) abVar.b("path");
                    if (!IronSourceStorageUtils.isPathExist(u.this.C, str3)) {
                        uVar = u.this;
                        str2 = m2.c.v;
                    } else {
                        u.this.j(u.this.a(a2, IronSourceStorageUtils.getCachedFilesMap(u.this.C, str3), m2.g.r, m2.g.q));
                        return;
                    }
                }
                uVar.a(str, false, str2, (String) null);
            }
        }

        @JavascriptInterface
        public void getConnectivityInfo(String str) {
            String str2;
            String z2 = u.this.b;
            Logger.i(z2, "getConnectivityInfo(" + str + ")");
            ab abVar = new ab(str);
            String d2 = abVar.d(u.f0);
            String d3 = abVar.d(u.g0);
            JSONObject jSONObject = new JSONObject();
            if (u.this.R != null) {
                jSONObject = u.this.R.a(u.this.getContext());
            }
            if (jSONObject.length() > 0) {
                str2 = u.this.c(d2, jSONObject.toString());
            } else {
                str2 = u.this.c(d3, u.this.a("errMsg", m2.c.C, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, false));
            }
            u.this.j(str2);
        }

        @JavascriptInterface
        public void getControllerConfig(String str) {
            String z2 = u.this.b;
            Logger.i(z2, "getControllerConfig(" + str + ")");
            String d2 = new ab(str).d(u.f0);
            if (!TextUtils.isEmpty(d2)) {
                JSONObject controllerConfigAsJSONObject = SDKUtils.getControllerConfigAsJSONObject();
                c(controllerConfigAsJSONObject);
                u.this.j(u.this.c(d2, controllerConfigAsJSONObject.toString()));
            }
        }

        @JavascriptInterface
        public void getDemandSourceState(String str) {
            String str2;
            String z2 = u.this.b;
            Logger.i(z2, "getMediationState(" + str + ")");
            ab abVar = new ab(str);
            String d2 = abVar.d("demandSourceName");
            String fetchDemandSourceId = SDKUtils.fetchDemandSourceId(abVar);
            String d3 = abVar.d(m2.h.m);
            if (d3 != null && d2 != null) {
                try {
                    e6.e productType = SDKUtils.getProductType(d3);
                    if (productType != null) {
                        h3 a2 = u.this.I.a(productType, fetchDemandSourceId);
                        JSONObject jSONObject = new JSONObject();
                        jSONObject.put(m2.h.m, d3);
                        jSONObject.put("demandSourceName", d2);
                        jSONObject.put("demandSourceId", fetchDemandSourceId);
                        if (a2 == null || a2.a(-1)) {
                            str2 = u.this.e(str);
                        } else {
                            str2 = u.this.f(str);
                            jSONObject.put("state", a2.j());
                        }
                        a(str2, jSONObject.toString());
                    }
                } catch (Exception e2) {
                    u.this.a(str, false, e2.getMessage(), (String) null);
                    e2.printStackTrace();
                }
            }
        }

        /* JADX WARNING: Code restructure failed: missing block: B:6:0x004e, code lost:
            if (android.text.TextUtils.isEmpty(r0) == false) goto L_0x0052;
         */
        /* JADX WARNING: Removed duplicated region for block: B:10:0x0058  */
        /* JADX WARNING: Removed duplicated region for block: B:12:? A[RETURN, SYNTHETIC] */
        @android.webkit.JavascriptInterface
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void getDeviceStatus(java.lang.String r5) {
            /*
                r4 = this;
                com.ironsource.sdk.controller.u r0 = com.ironsource.sdk.controller.u.this
                java.lang.String r0 = r0.b
                java.lang.StringBuilder r1 = new java.lang.StringBuilder
                java.lang.String r2 = "getDeviceStatus("
                r1.<init>(r2)
                r1.append(r5)
                java.lang.String r2 = ")"
                r1.append(r2)
                java.lang.String r1 = r1.toString()
                com.ironsource.sdk.utils.Logger.i(r0, r1)
                com.ironsource.sdk.controller.u r0 = com.ironsource.sdk.controller.u.this
                java.lang.String r0 = r0.f((java.lang.String) r5)
                com.ironsource.sdk.controller.u r1 = com.ironsource.sdk.controller.u.this
                java.lang.String r5 = r1.e((java.lang.String) r5)
                com.ironsource.sdk.controller.u r1 = com.ironsource.sdk.controller.u.this
                android.content.Context r2 = r1.getContext()
                java.lang.Object[] r1 = r1.d((android.content.Context) r2)
                r2 = 0
                r2 = r1[r2]
                java.lang.String r2 = (java.lang.String) r2
                r3 = 1
                r1 = r1[r3]
                java.lang.Boolean r1 = (java.lang.Boolean) r1
                boolean r1 = r1.booleanValue()
                if (r1 == 0) goto L_0x004a
                boolean r0 = android.text.TextUtils.isEmpty(r5)
                if (r0 != 0) goto L_0x0051
                r0 = r5
                goto L_0x0052
            L_0x004a:
                boolean r5 = android.text.TextUtils.isEmpty(r0)
                if (r5 != 0) goto L_0x0051
                goto L_0x0052
            L_0x0051:
                r0 = 0
            L_0x0052:
                boolean r5 = android.text.TextUtils.isEmpty(r0)
                if (r5 != 0) goto L_0x0067
                com.ironsource.sdk.controller.u r5 = com.ironsource.sdk.controller.u.this
                java.lang.String r1 = "onGetDeviceStatusSuccess"
                java.lang.String r3 = "onGetDeviceStatusFail"
                java.lang.String r5 = r5.a((java.lang.String) r0, (java.lang.String) r2, (java.lang.String) r1, (java.lang.String) r3)
                com.ironsource.sdk.controller.u r0 = com.ironsource.sdk.controller.u.this
                r0.j((java.lang.String) r5)
            L_0x0067:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.ironsource.sdk.controller.u.v.getDeviceStatus(java.lang.String):void");
        }

        @JavascriptInterface
        public void getDeviceVolume(String str) {
            String z2 = u.this.b;
            Logger.i(z2, "getDeviceVolume(" + str + ")");
            try {
                Context context = u.this.getContext();
                float a2 = l3.b(context).a(context);
                ab abVar = new ab(str);
                abVar.b("deviceVolume", String.valueOf(a2));
                u.this.a(abVar.toString(), true, (String) null, (String) null);
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }

        @JavascriptInterface
        public void getInitSummery(String str) {
            String z2 = u.this.b;
            Logger.i(z2, "getInitSummery(" + str + ")");
            ab abVar = new ab(str);
            abVar.a(m2.i.q0, u.this.S);
            u.this.a(abVar.toString(), true, (String) null, (String) null);
        }

        @JavascriptInterface
        public void getOrientation(String str) {
            l6.a(za.z, (Map<String, Object>) new g6().a(z3.x, str).a());
            String a2 = u.this.f(str);
            String jSONObject = SDKUtils.getOrientation(u.this.getContext()).toString();
            if (!TextUtils.isEmpty(a2)) {
                u.this.j(u.this.a(a2, jSONObject, m2.g.c0, m2.g.d0));
            }
        }

        @JavascriptInterface
        public void getUserData(String str) {
            String z2 = u.this.b;
            Logger.i(z2, "getUserData(" + str + ")");
            ab abVar = new ab(str);
            if (!abVar.a(m2.h.W)) {
                u.this.a(str, false, m2.c.H, (String) null);
                return;
            }
            String a2 = u.this.f(str);
            String d2 = abVar.d(m2.h.W);
            u.this.j(u.this.c(a2, u.this.a(d2, d8.e().a(d2), (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, false)));
        }

        @JavascriptInterface
        public void iabTokenAPI(String str) {
            try {
                String z2 = u.this.b;
                Logger.i(z2, "iabTokenAPI(" + str + ")");
                u.this.L.a(new ab(str).toString(), new e0());
            } catch (Exception e2) {
                e2.printStackTrace();
                String z3 = u.this.b;
                Logger.i(z3, "iabTokenAPI failed with exception " + e2.getMessage());
            }
        }

        @JavascriptInterface
        public void initController(String str) {
            String z2 = u.this.b;
            Logger.i(z2, "initController(" + str + ")");
            ab abVar = new ab(str);
            CountDownTimer countDownTimer = u.this.m;
            if (countDownTimer != null) {
                countDownTimer.cancel();
                u.this.m = null;
            }
            if (abVar.a(m2.h.q)) {
                String d2 = abVar.d(m2.h.q);
                if (m2.h.s.equalsIgnoreCase(d2)) {
                    boolean unused = u.this.i = true;
                    u.this.Q.f();
                } else if (m2.h.r.equalsIgnoreCase(d2)) {
                    u.this.Q.a();
                } else if (m2.h.t.equalsIgnoreCase(d2)) {
                    String d3 = abVar.d("errMsg");
                    c b2 = u.this.Q;
                    b2.b("controller js failed to initialize : " + d3);
                } else {
                    Logger.i(u.this.b, "No STAGE mentioned! should not get here!");
                }
            }
        }

        @JavascriptInterface
        public void omidAPI(String str) {
            u.this.c((Runnable) new w(str));
        }

        @JavascriptInterface
        public void onAdWindowsClosed(String str) {
            String z2 = u.this.b;
            Logger.i(z2, "onAdWindowsClosed(" + str + ")");
            u.this.F.a();
            u.this.F.f((String) null);
            t unused = u.this.j = null;
            ab abVar = new ab(str);
            String d2 = abVar.d(m2.h.m);
            String fetchDemandSourceId = SDKUtils.fetchDemandSourceId(abVar);
            e6.e d3 = u.this.h(d2);
            String u = u.this.c;
            Log.d(u, "onAdClosed() with type " + d3);
            if (u.this.n(d2)) {
                u.this.a(d3, fetchDemandSourceId);
            }
        }

        @JavascriptInterface
        public void onCleanUpNonDisplayBannersSuccess(String str) {
            String z2 = u.this.b;
            Logger.i(z2, "onCleanUpNonDisplayBannersSuccess() value=" + str);
        }

        @JavascriptInterface
        public void onGetApplicationInfoFail(String str) {
            String z2 = u.this.b;
            Logger.i(z2, "onGetApplicationInfoFail(" + str + ")");
            u.this.a(str, true, (String) null, (String) null);
            u.this.f(m2.g.n, str);
        }

        @JavascriptInterface
        public void onGetApplicationInfoSuccess(String str) {
            String z2 = u.this.b;
            Logger.i(z2, "onGetApplicationInfoSuccess(" + str + ")");
            u.this.a(str, true, (String) null, (String) null);
            u.this.f(m2.g.m, str);
        }

        @JavascriptInterface
        public void onGetCachedFilesMapFail(String str) {
            String z2 = u.this.b;
            Logger.i(z2, "onGetCachedFilesMapFail(" + str + ")");
            u.this.a(str, true, (String) null, (String) null);
            u.this.f(m2.g.q, str);
        }

        @JavascriptInterface
        public void onGetCachedFilesMapSuccess(String str) {
            String z2 = u.this.b;
            Logger.i(z2, "onGetCachedFilesMapSuccess(" + str + ")");
            u.this.a(str, true, (String) null, (String) null);
            u.this.f(m2.g.r, str);
        }

        @JavascriptInterface
        public void onGetDeviceStatusFail(String str) {
            String z2 = u.this.b;
            Logger.i(z2, "onGetDeviceStatusFail(" + str + ")");
            u.this.a(str, true, (String) null, (String) null);
            u.this.f(m2.g.l, str);
        }

        @JavascriptInterface
        public void onGetDeviceStatusSuccess(String str) {
            String z2 = u.this.b;
            Logger.i(z2, "onGetDeviceStatusSuccess(" + str + ")");
            u.this.a(str, true, (String) null, (String) null);
            u.this.f(m2.g.k, str);
        }

        @JavascriptInterface
        public void onGetUserCreditsFail(String str) {
            String z2 = u.this.b;
            Logger.i(z2, "onGetUserCreditsFail(" + str + ")");
            String d2 = new ab(str).d("errMsg");
            if (u.this.n(e6.e.OfferWall.toString())) {
                u.this.b((Runnable) new t(d2));
            }
            u.this.a(str, true, (String) null, (String) null);
            u.this.f(m2.g.g0, str);
        }

        @JavascriptInterface
        public void onInitBannerFail(String str) {
            String z2 = u.this.b;
            Logger.i(z2, "onInitBannerFail(" + str + ")");
            ab abVar = new ab(str);
            String d2 = abVar.d("errMsg");
            String fetchDemandSourceId = SDKUtils.fetchDemandSourceId(abVar);
            if (TextUtils.isEmpty(fetchDemandSourceId)) {
                Logger.i(u.this.b, "onInitBannerFail failed with no demand source");
                return;
            }
            i3 t2 = u.this.I;
            e6.e eVar = e6.e.Banner;
            h3 a2 = t2.a(eVar, fetchDemandSourceId);
            if (a2 != null) {
                a2.b(3);
            }
            if (u.this.n(eVar.toString())) {
                u.this.b((Runnable) new p(d2, fetchDemandSourceId));
            }
            u.this.a(str, true, (String) null, (String) null);
            u.this.f(m2.g.S, str);
        }

        @JavascriptInterface
        public void onInitBannerSuccess(String str) {
            Logger.i(u.this.b, "onInitBannerSuccess()");
            u.this.f(m2.g.R, "true");
            String fetchDemandSourceId = SDKUtils.fetchDemandSourceId(new ab(str));
            if (TextUtils.isEmpty(fetchDemandSourceId)) {
                Logger.i(u.this.b, "onInitBannerSuccess failed with no demand source");
            } else if (u.this.n(e6.e.Banner.toString())) {
                u.this.b((Runnable) new o(fetchDemandSourceId));
            }
        }

        @JavascriptInterface
        public void onInitInterstitialFail(String str) {
            String z2 = u.this.b;
            Logger.i(z2, "onInitInterstitialFail(" + str + ")");
            ab abVar = new ab(str);
            String d2 = abVar.d("errMsg");
            String fetchDemandSourceId = SDKUtils.fetchDemandSourceId(abVar);
            if (TextUtils.isEmpty(fetchDemandSourceId)) {
                Logger.i(u.this.b, "onInitInterstitialSuccess failed with no demand source");
                return;
            }
            i3 t2 = u.this.I;
            e6.e eVar = e6.e.Interstitial;
            h3 a2 = t2.a(eVar, fetchDemandSourceId);
            if (a2 != null) {
                a2.b(3);
            }
            if (u.this.n(eVar.toString())) {
                u.this.b((Runnable) new f(d2, fetchDemandSourceId));
            }
            u.this.a(str, true, (String) null, (String) null);
            u.this.f(m2.g.J, str);
        }

        @JavascriptInterface
        public void onInitInterstitialSuccess(String str) {
            Logger.i(u.this.b, "onInitInterstitialSuccess()");
            u.this.f(m2.g.I, "true");
            String fetchDemandSourceId = SDKUtils.fetchDemandSourceId(new ab(str));
            if (TextUtils.isEmpty(fetchDemandSourceId)) {
                Logger.i(u.this.b, "onInitInterstitialSuccess failed with no demand source");
            } else if (u.this.n(e6.e.Interstitial.toString())) {
                u.this.b((Runnable) new e(fetchDemandSourceId));
            }
        }

        @JavascriptInterface
        public void onInitOfferWallFail(String str) {
            String z2 = u.this.b;
            Logger.i(z2, "onInitOfferWallFail(" + str + ")");
            u.this.F.a(false);
            String d2 = new ab(str).d("errMsg");
            if (u.this.F.l()) {
                u.this.F.b(false);
                if (u.this.n(e6.e.OfferWall.toString())) {
                    u.this.b((Runnable) new j(d2));
                }
            }
            u.this.a(str, true, (String) null, (String) null);
            u.this.f(m2.g.B, str);
        }

        @JavascriptInterface
        public void onInitOfferWallSuccess(String str) {
            u.this.f(m2.g.A, "true");
            u.this.F.a(true);
            if (u.this.F.l()) {
                u.this.F.b(false);
                if (u.this.n(e6.e.OfferWall.toString())) {
                    u.this.b((Runnable) new i());
                }
            }
        }

        @JavascriptInterface
        public void onInitRewardedVideoFail(String str) {
            String z2 = u.this.b;
            Logger.i(z2, "onInitRewardedVideoFail(" + str + ")");
            ab abVar = new ab(str);
            String d2 = abVar.d("errMsg");
            String fetchDemandSourceId = SDKUtils.fetchDemandSourceId(abVar);
            i3 t2 = u.this.I;
            e6.e eVar = e6.e.RewardedVideo;
            h3 a2 = t2.a(eVar, fetchDemandSourceId);
            if (a2 != null) {
                a2.b(3);
            }
            if (u.this.n(eVar.toString())) {
                u.this.b((Runnable) new a(d2, fetchDemandSourceId));
            }
            u.this.a(str, true, (String) null, (String) null);
            u.this.f(m2.g.g, str);
        }

        @JavascriptInterface
        public void onLoadBannerFail(String str) {
            Logger.i(u.this.b, "onLoadBannerFail()");
            ab abVar = new ab(str);
            String d2 = abVar.d("errMsg");
            String fetchDemandSourceId = SDKUtils.fetchDemandSourceId(abVar);
            u.this.a(str, true, (String) null, (String) null);
            if (!TextUtils.isEmpty(fetchDemandSourceId) && u.this.n(e6.e.Banner.toString())) {
                u.this.b((Runnable) new r(d2, fetchDemandSourceId));
            }
        }

        @JavascriptInterface
        public void onLoadBannerSuccess(String str) {
            Logger.i(u.this.b, "onLoadBannerSuccess()");
            ab abVar = new ab(str);
            String fetchDemandSourceId = SDKUtils.fetchDemandSourceId(abVar);
            String d2 = abVar.d("adViewId");
            u.this.a(str, true, (String) null, (String) null);
            v6 a2 = d6.a().a(d2);
            if (a2 == null) {
                v2 A = u.this.A;
                A.a(fetchDemandSourceId, "not found view for the current adViewId= " + d2);
            } else if (a2 instanceof x5) {
                x5 x5Var = (x5) a2;
                if (u.this.n(e6.e.Banner.toString())) {
                    u.this.b((Runnable) new q(fetchDemandSourceId, x5Var));
                }
            }
        }

        @JavascriptInterface
        public void onLoadInterstitialFail(String str) {
            String z2 = u.this.b;
            Logger.i(z2, "onLoadInterstitialFail(" + str + ")");
            ab abVar = new ab(str);
            String d2 = abVar.d("errMsg");
            String fetchDemandSourceId = SDKUtils.fetchDemandSourceId(abVar);
            u.this.a(str, true, (String) null, (String) null);
            if (!TextUtils.isEmpty(fetchDemandSourceId)) {
                a(fetchDemandSourceId, false);
                if (u.this.n(e6.e.Interstitial.toString())) {
                    u.this.b((Runnable) new m(d2, fetchDemandSourceId));
                }
                u.this.f(m2.g.M, "true");
            }
        }

        @JavascriptInterface
        public void onLoadInterstitialSuccess(String str) {
            String z2 = u.this.b;
            Logger.i(z2, "onLoadInterstitialSuccess(" + str + ")");
            String fetchDemandSourceId = SDKUtils.fetchDemandSourceId(new ab(str));
            a(fetchDemandSourceId, true);
            u.this.a(str, true, (String) null, (String) null);
            if (u.this.n(e6.e.Interstitial.toString())) {
                u.this.b((Runnable) new l(fetchDemandSourceId));
            }
            u.this.f(m2.g.L, "true");
        }

        @JavascriptInterface
        public void onOfferWallGeneric(String str) {
            String z2 = u.this.b;
            Logger.i(z2, "onOfferWallGeneric(" + str + ")");
        }

        @JavascriptInterface
        public void onReceivedMessage(String str) {
            String z2 = u.this.b;
            Logger.i(z2, "onReceivedMessage(" + str + ")");
            n5.a.a(new s(str));
        }

        @JavascriptInterface
        public void onShowInterstitialFail(String str) {
            String z2 = u.this.b;
            Logger.i(z2, "onShowInterstitialFail(" + str + ")");
            ab abVar = new ab(str);
            String d2 = abVar.d("errMsg");
            String fetchDemandSourceId = SDKUtils.fetchDemandSourceId(abVar);
            u.this.a(str, true, (String) null, (String) null);
            if (!TextUtils.isEmpty(fetchDemandSourceId)) {
                a(fetchDemandSourceId, false);
                if (u.this.n(e6.e.Interstitial.toString())) {
                    u.this.b((Runnable) new n(d2, fetchDemandSourceId));
                }
                u.this.f(m2.g.P, str);
            }
        }

        @JavascriptInterface
        public void onShowInterstitialSuccess(String str) {
            String z2 = u.this.b;
            Logger.i(z2, "onShowInterstitialSuccess(" + str + ")");
            u.this.a(str, true, (String) null, (String) null);
            String fetchDemandSourceId = SDKUtils.fetchDemandSourceId(new ab(str));
            if (TextUtils.isEmpty(fetchDemandSourceId)) {
                Logger.i(u.this.b, "onShowInterstitialSuccess called with no demand");
                return;
            }
            f0 q2 = u.this.F;
            e6.e eVar = e6.e.Interstitial;
            q2.a(eVar.ordinal());
            u.this.F.f(fetchDemandSourceId);
            if (u.this.n(eVar.toString())) {
                u.this.b((Runnable) new h(fetchDemandSourceId));
                u.this.f(m2.g.O, str);
            }
            a(fetchDemandSourceId, false);
        }

        @JavascriptInterface
        public void onShowOfferWallFail(String str) {
            String z2 = u.this.b;
            Logger.i(z2, "onShowOfferWallFail(" + str + ")");
            String d2 = new ab(str).d("errMsg");
            if (u.this.n(e6.e.OfferWall.toString())) {
                u.this.b((Runnable) new d(d2));
            }
            u.this.a(str, true, (String) null, (String) null);
            u.this.f(m2.g.F, str);
        }

        @JavascriptInterface
        public void onShowOfferWallSuccess(String str) {
            String z2 = u.this.b;
            Logger.i(z2, "onShowOfferWallSuccess(" + str + ")");
            f0 q2 = u.this.F;
            e6.e eVar = e6.e.OfferWall;
            q2.a(eVar.ordinal());
            String valueFromJsonObject = SDKUtils.getValueFromJsonObject(str, m2.i);
            if (u.this.n(eVar.toString())) {
                u.this.b((Runnable) new c(valueFromJsonObject));
            }
            u.this.a(str, true, (String) null, (String) null);
            u.this.f(m2.g.E, str);
        }

        @JavascriptInterface
        public void onShowRewardedVideoFail(String str) {
            String z2 = u.this.b;
            Logger.i(z2, "onShowRewardedVideoFail(" + str + ")");
            ab abVar = new ab(str);
            String d2 = abVar.d("errMsg");
            String fetchDemandSourceId = SDKUtils.fetchDemandSourceId(abVar);
            if (u.this.n(e6.e.RewardedVideo.toString())) {
                u.this.b((Runnable) new b(d2, fetchDemandSourceId));
            }
            u.this.a(str, true, (String) null, (String) null);
            u.this.f(m2.g.j, str);
        }

        @JavascriptInterface
        public void onShowRewardedVideoSuccess(String str) {
            String z2 = u.this.b;
            Logger.i(z2, "onShowRewardedVideoSuccess(" + str + ")");
            u.this.a(str, true, (String) null, (String) null);
            u.this.f(m2.g.i, str);
        }

        @JavascriptInterface
        public void onVideoStatusChanged(String str) {
            String z2 = u.this.b;
            Log.d(z2, "onVideoStatusChanged(" + str + ")");
            ab abVar = new ab(str);
            String d2 = abVar.d(m2.h.m);
            if (u.this.E != null && !TextUtils.isEmpty(d2)) {
                String d3 = abVar.d("status");
                if (m2.h.e0.equalsIgnoreCase(d3)) {
                    u.this.E.onVideoStarted();
                } else if (m2.h.f0.equalsIgnoreCase(d3)) {
                    u.this.E.onVideoPaused();
                } else if (m2.h.g0.equalsIgnoreCase(d3)) {
                    u.this.E.onVideoResumed();
                } else if (m2.h.h0.equalsIgnoreCase(d3)) {
                    u.this.E.onVideoEnded();
                } else if (m2.h.i0.equalsIgnoreCase(d3)) {
                    u.this.E.onVideoStopped();
                } else {
                    String z3 = u.this.b;
                    Logger.i(z3, "onVideoStatusChanged: unknown status: " + d3);
                }
            }
        }

        /* JADX WARNING: Removed duplicated region for block: B:20:0x0078 A[Catch:{ Exception -> 0x00d7 }] */
        /* JADX WARNING: Removed duplicated region for block: B:26:0x00cf A[Catch:{ Exception -> 0x00d7 }] */
        @android.webkit.JavascriptInterface
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void openUrl(java.lang.String r13) {
            /*
                r12 = this;
                java.lang.String r0 = "method "
                com.ironsource.sdk.controller.u r1 = com.ironsource.sdk.controller.u.this
                java.lang.String r1 = r1.b
                java.lang.StringBuilder r2 = new java.lang.StringBuilder
                java.lang.String r3 = "openUrl("
                r2.<init>(r3)
                r2.append(r13)
                java.lang.String r3 = ")"
                r2.append(r3)
                java.lang.String r2 = r2.toString()
                com.ironsource.sdk.utils.Logger.i(r1, r2)
                com.ironsource.ab r1 = new com.ironsource.ab
                r1.<init>(r13)
                java.lang.String r2 = "url"
                java.lang.String r2 = r1.d(r2)
                java.lang.String r3 = "method"
                java.lang.String r3 = r1.d(r3)
                java.lang.String r4 = "package_name"
                java.lang.String r1 = r1.d(r4)
                r4 = 0
                r5 = 0
                com.ironsource.sdk.controller.u r6 = com.ironsource.sdk.controller.u.this     // Catch:{ Exception -> 0x00d7 }
                android.content.Context r6 = r6.getCurrentActivityContext()     // Catch:{ Exception -> 0x00d7 }
                java.lang.String r7 = r3.toLowerCase()     // Catch:{ Exception -> 0x00d7 }
                int r8 = r7.hashCode()     // Catch:{ Exception -> 0x00d7 }
                r9 = -1455867212(0xffffffffa9393ab4, float:-4.112917E-14)
                r10 = 2
                r11 = 1
                if (r8 == r9) goto L_0x006b
                r9 = 109770977(0x68af8e1, float:5.2275525E-35)
                if (r8 == r9) goto L_0x0061
                r9 = 1224424441(0x48fb3bf9, float:514527.78)
                if (r8 == r9) goto L_0x0057
                goto L_0x0075
            L_0x0057:
                java.lang.String r8 = "webview"
                boolean r7 = r7.equals(r8)     // Catch:{ Exception -> 0x00d7 }
                if (r7 == 0) goto L_0x0075
                r7 = 1
                goto L_0x0076
            L_0x0061:
                java.lang.String r8 = "store"
                boolean r7 = r7.equals(r8)     // Catch:{ Exception -> 0x00d7 }
                if (r7 == 0) goto L_0x0075
                r7 = 2
                goto L_0x0076
            L_0x006b:
                java.lang.String r8 = "external_browser"
                boolean r7 = r7.equals(r8)     // Catch:{ Exception -> 0x00d7 }
                if (r7 == 0) goto L_0x0075
                r7 = 0
                goto L_0x0076
            L_0x0075:
                r7 = -1
            L_0x0076:
                if (r7 == 0) goto L_0x00cf
                if (r7 == r11) goto L_0x00af
                if (r7 == r10) goto L_0x0093
                java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x00d7 }
                r1.<init>(r0)     // Catch:{ Exception -> 0x00d7 }
                r1.append(r3)     // Catch:{ Exception -> 0x00d7 }
                java.lang.String r0 = " is unsupported"
                r1.append(r0)     // Catch:{ Exception -> 0x00d7 }
                java.lang.String r0 = r1.toString()     // Catch:{ Exception -> 0x00d7 }
                com.ironsource.sdk.controller.u r1 = com.ironsource.sdk.controller.u.this     // Catch:{ Exception -> 0x00d7 }
                r1.a((java.lang.String) r13, (boolean) r4, (java.lang.String) r0, (java.lang.String) r5)     // Catch:{ Exception -> 0x00d7 }
                goto L_0x00e4
            L_0x0093:
                android.content.Intent r0 = new android.content.Intent     // Catch:{ Exception -> 0x00d7 }
                java.lang.Class<com.ironsource.sdk.controller.OpenUrlActivity> r1 = com.ironsource.sdk.controller.OpenUrlActivity.class
                r0.<init>(r6, r1)     // Catch:{ Exception -> 0x00d7 }
                java.lang.String r1 = com.ironsource.sdk.controller.u.d0     // Catch:{ Exception -> 0x00d7 }
                r0.putExtra(r1, r2)     // Catch:{ Exception -> 0x00d7 }
                java.lang.String r1 = com.ironsource.sdk.controller.u.c0     // Catch:{ Exception -> 0x00d7 }
                r0.putExtra(r1, r11)     // Catch:{ Exception -> 0x00d7 }
                java.lang.String r1 = com.ironsource.sdk.controller.u.e0     // Catch:{ Exception -> 0x00d7 }
                r0.putExtra(r1, r11)     // Catch:{ Exception -> 0x00d7 }
                r6.startActivity(r0)     // Catch:{ Exception -> 0x00d7 }
            L_0x00ac:
                com.ironsource.sdk.controller.u r0 = com.ironsource.sdk.controller.u.this     // Catch:{ Exception -> 0x00d7 }
                goto L_0x00d3
            L_0x00af:
                android.content.Intent r0 = new android.content.Intent     // Catch:{ Exception -> 0x00d7 }
                java.lang.Class<com.ironsource.sdk.controller.OpenUrlActivity> r1 = com.ironsource.sdk.controller.OpenUrlActivity.class
                r0.<init>(r6, r1)     // Catch:{ Exception -> 0x00d7 }
                java.lang.String r1 = com.ironsource.sdk.controller.u.d0     // Catch:{ Exception -> 0x00d7 }
                r0.putExtra(r1, r2)     // Catch:{ Exception -> 0x00d7 }
                java.lang.String r1 = com.ironsource.sdk.controller.u.e0     // Catch:{ Exception -> 0x00d7 }
                r0.putExtra(r1, r11)     // Catch:{ Exception -> 0x00d7 }
                java.lang.String r1 = "immersive"
                com.ironsource.sdk.controller.u r2 = com.ironsource.sdk.controller.u.this     // Catch:{ Exception -> 0x00d7 }
                boolean r2 = r2.H     // Catch:{ Exception -> 0x00d7 }
                r0.putExtra(r1, r2)     // Catch:{ Exception -> 0x00d7 }
                r6.startActivity(r0)     // Catch:{ Exception -> 0x00d7 }
                goto L_0x00ac
            L_0x00cf:
                com.ironsource.pc.a(r6, r2, r1)     // Catch:{ Exception -> 0x00d7 }
                goto L_0x00ac
            L_0x00d3:
                r0.a((java.lang.String) r13, (boolean) r11, (java.lang.String) r5, (java.lang.String) r5)     // Catch:{ Exception -> 0x00d7 }
                goto L_0x00e4
            L_0x00d7:
                r0 = move-exception
                com.ironsource.sdk.controller.u r1 = com.ironsource.sdk.controller.u.this
                java.lang.String r2 = r0.getMessage()
                r1.a((java.lang.String) r13, (boolean) r4, (java.lang.String) r2, (java.lang.String) r5)
                r0.printStackTrace()
            L_0x00e4:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.ironsource.sdk.controller.u.v.openUrl(java.lang.String):void");
        }

        @JavascriptInterface
        public void pauseControllerWebview() {
            u.this.c((Runnable) new C0026v());
        }

        @JavascriptInterface
        public void permissionsAPI(String str) {
            try {
                String z2 = u.this.b;
                Logger.i(z2, "permissionsAPI(" + str + ")");
                u.this.K.a(new ab(str).toString(), new e0());
            } catch (Exception e2) {
                e2.printStackTrace();
                String z3 = u.this.b;
                Logger.i(z3, "permissionsAPI failed with exception " + e2.getMessage());
            }
        }

        @JavascriptInterface
        public void postAdEventNotification(String str) {
            String str2 = str;
            try {
                String z2 = u.this.b;
                Logger.i(z2, "postAdEventNotification(" + str2 + ")");
                ab abVar = new ab(str2);
                String d2 = abVar.d(m2.h.k0);
                if (TextUtils.isEmpty(d2)) {
                    u.this.a(str2, false, m2.c.y, (String) null);
                    return;
                }
                String d3 = abVar.d(m2.h.l0);
                String fetchDemandSourceId = SDKUtils.fetchDemandSourceId(abVar);
                String str3 = !TextUtils.isEmpty(fetchDemandSourceId) ? fetchDemandSourceId : d3;
                JSONObject jSONObject = (JSONObject) abVar.b(m2.h.m0);
                String d4 = abVar.d(m2.h.m);
                e6.e d5 = u.this.h(d4);
                if (u.this.n(d4)) {
                    String a2 = u.this.f(str2);
                    if (!TextUtils.isEmpty(a2)) {
                        u.this.j(u.this.a(a2, u.this.a(m2.h.m, d4, m2.h.k0, d2, "demandSourceName", d3, "demandSourceId", str3, (String) null, false), m2.g.h0, m2.g.i0));
                    }
                    u.this.b((Runnable) new C0025u(d5, str3, d2, jSONObject));
                    return;
                }
                u.this.a(str2, false, m2.c.x, (String) null);
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }

        @JavascriptInterface
        public void removeCloseEventHandler(String str) {
            String z2 = u.this.b;
            Logger.i(z2, "removeCloseEventHandler(" + str + ")");
            if (u.this.l != null) {
                u.this.l.cancel();
            }
            boolean unused = u.this.k = true;
        }

        @JavascriptInterface
        public void removeMessagingInterface(String str) {
            u.this.c((Runnable) new x());
        }

        @JavascriptInterface
        public void requestToDestroyBanner(String str) {
            String z2 = u.this.b;
            Logger.i(z2, "onCleanUpNonDisplayBannersFail() value=" + str);
        }

        @JavascriptInterface
        public void resumeControllerWebview() {
            u.this.c((Runnable) new k());
        }

        @JavascriptInterface
        public void saveFile(String str) {
            try {
                String z2 = u.this.b;
                Logger.i(z2, "saveFile(" + str + ")");
                ab abVar = new ab(str);
                String d2 = abVar.d("path");
                String d3 = abVar.d(m2.h.b);
                if (TextUtils.isEmpty(d3)) {
                    u.this.a(str, false, m2.c.g, "1");
                    return;
                }
                n6 n6Var = new n6(IronSourceStorageUtils.buildAbsolutePathToDirInCache(u.this.C, d2), SDKUtils.getFileName(d3));
                IronSourceStorageUtils.ensurePathSafety(n6Var, u.this.C);
                if (m3.d(u.this.C) <= 0) {
                    u.this.a(str, false, n2.A, (String) null);
                } else if (!SDKUtils.isExternalStorageAvailable()) {
                    u.this.a(str, false, n2.B, (String) null);
                } else if (n6Var.exists()) {
                    u.this.a(str, false, n2.z, (String) null);
                } else if (!k2.g(u.this.getContext())) {
                    u.this.a(str, false, n2.C, (String) null);
                } else {
                    u.this.a(str, true, (String) null, (String) null);
                    u.this.h.a(n6Var, d3, abVar.a("connectionTimeout", 0), abVar.a("readTimeout", 0));
                }
            } catch (Exception e2) {
                u.this.a(str, false, e2.getMessage(), (String) null);
                e2.printStackTrace();
            }
        }

        @JavascriptInterface
        public void setBackButtonState(String str) {
            String z2 = u.this.b;
            Logger.i(z2, "setBackButtonState(" + str + ")");
            d8.e().c(new ab(str).d("state"));
        }

        @JavascriptInterface
        public void setForceClose(String str) {
            String z2 = u.this.b;
            Logger.i(z2, "setForceClose(" + str + ")");
            ab abVar = new ab(str);
            String d2 = abVar.d("width");
            String d3 = abVar.d("height");
            int unused = u.this.n = Integer.parseInt(d2);
            int unused2 = u.this.o = Integer.parseInt(d3);
            String unused3 = u.this.p = abVar.d(m2.h.L);
        }

        @JavascriptInterface
        public void setMixedContentAlwaysAllow(String str) {
            String z2 = u.this.b;
            Logger.i(z2, "setMixedContentAlwaysAllow(" + str + ")");
            u.this.c((Runnable) new y());
        }

        @JavascriptInterface
        public void setOrientation(String str) {
            String z2 = u.this.b;
            Logger.i(z2, "setOrientation(" + str + ")");
            String d2 = new ab(str).d("orientation");
            u.this.setOrientationState(d2);
            if (u.this.W != null) {
                u.this.W.onOrientationChanged(d2, m3.g(u.this.getContext()));
            }
        }

        @JavascriptInterface
        public void setStoreSearchKeys(String str) {
            String z2 = u.this.b;
            Logger.i(z2, "setStoreSearchKeys(" + str + ")");
            d8.e().e(str);
        }

        @JavascriptInterface
        public void setTouchListener(String str) {
            String z2 = u.this.b;
            Logger.i(z2, "removeCloseEventHandler(" + str + ")");
            u.this.c((Runnable) new d0());
        }

        @JavascriptInterface
        public void setUserData(String str) {
            String str2 = str;
            String z2 = u.this.b;
            Logger.i(z2, "setUserData(" + str2 + ")");
            ab abVar = new ab(str2);
            if (!abVar.a(m2.h.W)) {
                u.this.a(str2, false, m2.c.H, (String) null);
            } else if (!abVar.a(m2.h.X)) {
                u.this.a(str2, false, m2.c.I, (String) null);
            } else {
                String d2 = abVar.d(m2.h.W);
                String d3 = abVar.d(m2.h.X);
                d8.e().a(d2, d3);
                u.this.j(u.this.c(u.this.f(str2), u.this.a(d2, d3, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, false)));
            }
        }

        @JavascriptInterface
        public void setWebviewBackgroundColor(String str) {
            String z2 = u.this.b;
            Logger.i(z2, "setWebviewBackgroundColor(" + str + ")");
            u.this.setWebviewBackground(str);
        }
    }

    private interface w {
        void a(String str, e6.e eVar, h3 h3Var);
    }

    static class x {
        String a;
        String b;

        x() {
        }
    }

    public enum y {
        Display,
        Gone
    }

    private class z implements View.OnTouchListener {

        class a extends CountDownTimer {
            a(long j, long j2) {
                super(j, j2);
            }

            public void onFinish() {
                Logger.i(u.this.b, "Close Event Timer Finish");
                if (u.this.k) {
                    boolean unused = u.this.k = false;
                } else {
                    u.this.c(m2.h.i);
                }
            }

            public void onTick(long j) {
                String z = u.this.b;
                Logger.i(z, "Close Event Timer Tick " + j);
            }
        }

        private z() {
        }

        /* synthetic */ z(u uVar, j jVar) {
            this();
        }

        public boolean onTouch(View view, MotionEvent motionEvent) {
            if (motionEvent.getAction() == 1) {
                float x = motionEvent.getX();
                float y = motionEvent.getY();
                String z = u.this.b;
                StringBuilder sb = new StringBuilder("X:");
                int i = (int) x;
                sb.append(i);
                sb.append(" Y:");
                int i2 = (int) y;
                sb.append(i2);
                Logger.i(z, sb.toString());
                int o = m3.o();
                int h = m3.h();
                String z2 = u.this.b;
                Logger.i(z2, "Width:" + o + " Height:" + h);
                int dpToPx = SDKUtils.dpToPx((long) u.this.n);
                int dpToPx2 = SDKUtils.dpToPx((long) u.this.o);
                if (m2.e.b.equalsIgnoreCase(u.this.p)) {
                    i = o - i;
                } else if (!m2.e.c.equalsIgnoreCase(u.this.p)) {
                    if (m2.e.d.equalsIgnoreCase(u.this.p)) {
                        i = o - i;
                    } else if (!m2.e.e.equalsIgnoreCase(u.this.p)) {
                        i = 0;
                        i2 = 0;
                    }
                    i2 = h - i2;
                }
                if (i <= dpToPx && i2 <= dpToPx2) {
                    boolean unused = u.this.k = false;
                    if (u.this.l != null) {
                        u.this.l.cancel();
                    }
                    CountDownTimer unused2 = u.this.l = new a(2000, 500).start();
                }
            }
            return false;
        }
    }

    public u(Context context, i3 i3Var, o2 o2Var, c cVar, n5 n5Var, int i2, q3 q3Var, String str, k.a aVar, k.b bVar, String str2, String str3) throws Throwable {
        super(context);
        Logger.i("u", "C'tor");
        this.V = o2Var;
        this.Q = cVar;
        this.a = n5Var;
        this.I = i3Var;
        e(context);
        this.C = str;
        this.F = new f0();
        this.S = new JSONObject();
        this.h = q3Var;
        q3Var.a(this);
        this.T = aVar;
        this.U = bVar;
        this.D = new d(SDKUtils.getNetworkConfiguration(), this.C, SDKUtils.getControllerUrl(), q3Var);
        s sVar = new s(this, (j) null);
        this.q = sVar;
        setWebViewClient(new a0(this, (j) null));
        setWebChromeClient(sVar);
        hd.a((WebView) this);
        h();
        setDownloadListener(this);
        this.R = c(context);
        b(context);
        setDebugMode(i2);
        this.e = str2;
        this.f = str3;
    }

    private x a(e6.e eVar, h3 h3Var) {
        x xVar = new x();
        if (eVar == e6.e.RewardedVideo || eVar == e6.e.Interstitial || eVar == e6.e.OfferWall || eVar == e6.e.Banner) {
            HashMap hashMap = new HashMap();
            hashMap.put("applicationKey", this.e);
            if (!TextUtils.isEmpty(this.f)) {
                hashMap.put("applicationUserId", this.f);
            }
            if (h3Var != null) {
                if (h3Var.g() != null) {
                    hashMap.putAll(h3Var.g());
                    hashMap.put(m2.h.y0, String.valueOf(com.ironsource.j.a.c(h3Var.h())));
                }
                hashMap.put("demandSourceName", h3Var.f());
                hashMap.put("demandSourceId", h3Var.h());
            }
            Map<String, String> b2 = b(eVar);
            if (b2 != null) {
                hashMap.putAll(b2);
            }
            String flatMapToJsonAsString = SDKUtils.flatMapToJsonAsString(hashMap);
            m2.g a2 = m2.g.a(eVar);
            String a3 = a(a2.a, flatMapToJsonAsString, a2.b, a2.c);
            xVar.a = a2.a;
            xVar.b = a3;
        } else if (eVar == e6.e.OfferWallCredits) {
            String a4 = a(m2.g.D, a(m2.h.m, m2.h.a0, "applicationKey", this.e, "applicationUserId", this.f, (String) null, (String) null, (String) null, false), "null", m2.g.g0);
            xVar.a = m2.g.D;
            xVar.b = a4;
        }
        return xVar;
    }

    /* access modifiers changed from: private */
    public u2 a(e6.e eVar) {
        if (eVar == e6.e.Interstitial) {
            return this.y;
        }
        if (eVar == e6.e.RewardedVideo) {
            return this.x;
        }
        if (eVar == e6.e.Banner) {
            return this.A;
        }
        return null;
    }

    private String a(e6.e eVar, JSONObject jSONObject) {
        HashMap hashMap = new HashMap();
        hashMap.put("sessionDepth", Integer.toString(jSONObject.optInt("sessionDepth")));
        String optString = jSONObject.optString("demandSourceName");
        String fetchDemandSourceId = SDKUtils.fetchDemandSourceId(jSONObject);
        h3 a2 = this.I.a(eVar, fetchDemandSourceId);
        if (a2 != null) {
            if (a2.g() != null) {
                hashMap.putAll(a2.g());
            }
            if (!TextUtils.isEmpty(optString)) {
                hashMap.put("demandSourceName", optString);
            }
            if (!TextUtils.isEmpty(fetchDemandSourceId)) {
                hashMap.put("demandSourceId", fetchDemandSourceId);
            }
        }
        Map<String, String> b2 = b(eVar);
        if (b2 != null) {
            hashMap.putAll(b2);
        }
        String flatMapToJsonAsString = SDKUtils.flatMapToJsonAsString(hashMap);
        m2.g b3 = m2.g.b(eVar);
        return a(b3.a, flatMapToJsonAsString, b3.b, b3.c);
    }

    /* access modifiers changed from: private */
    public String a(String str, String str2, String str3, String str4) {
        return new m.a(str, str2, str3, str4).a();
    }

    /* access modifiers changed from: private */
    public String a(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, boolean z2) {
        JSONObject jSONObject = new JSONObject();
        try {
            if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
                jSONObject.put(str, SDKUtils.encodeString(str2));
            }
            if (!TextUtils.isEmpty(str3) && !TextUtils.isEmpty(str4)) {
                jSONObject.put(str3, SDKUtils.encodeString(str4));
            }
            if (!TextUtils.isEmpty(str5) && !TextUtils.isEmpty(str6)) {
                jSONObject.put(str5, SDKUtils.encodeString(str6));
            }
            if (!TextUtils.isEmpty(str7) && !TextUtils.isEmpty(str8)) {
                jSONObject.put(str7, SDKUtils.encodeString(str8));
            }
            if (!TextUtils.isEmpty(str9)) {
                jSONObject.put(str9, z2);
            }
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        return jSONObject.toString();
    }

    private void a(h3 h3Var, Map<String, String> map) {
        Map<String, String> mergeHashMaps = SDKUtils.mergeHashMaps(new Map[]{map, h3Var.b()});
        this.F.d(h3Var.h(), true);
        j(a(m2.g.K, SDKUtils.flatMapToJsonAsString(mergeHashMaps), m2.g.L, m2.g.M));
    }

    /* access modifiers changed from: private */
    public void a(String str, e6.e eVar, h3 h3Var) {
        if (n(eVar.toString())) {
            b((Runnable) new a(eVar, h3Var, str));
        }
    }

    private void a(String str, e6.e eVar, h3 h3Var, w wVar) {
        if (TextUtils.isEmpty(str)) {
            wVar.a("Application key are missing", eVar, h3Var);
        } else {
            j(a(eVar, h3Var).b);
        }
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:3:0x0017, code lost:
        if (android.text.TextUtils.isEmpty(r1) == false) goto L_0x0023;
     */
    /* JADX WARNING: Removed duplicated region for block: B:10:0x0029  */
    /* JADX WARNING: Removed duplicated region for block: B:22:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void a(java.lang.String r4, boolean r5, java.lang.String r6, java.lang.String r7) {
        /*
            r3 = this;
            com.ironsource.ab r0 = new com.ironsource.ab
            r0.<init>(r4)
            java.lang.String r1 = f0
            java.lang.String r1 = r0.d(r1)
            java.lang.String r2 = g0
            java.lang.String r0 = r0.d(r2)
            if (r5 == 0) goto L_0x001a
            boolean r5 = android.text.TextUtils.isEmpty(r1)
            if (r5 != 0) goto L_0x0022
            goto L_0x0023
        L_0x001a:
            boolean r5 = android.text.TextUtils.isEmpty(r0)
            if (r5 != 0) goto L_0x0022
            r1 = r0
            goto L_0x0023
        L_0x0022:
            r1 = 0
        L_0x0023:
            boolean r5 = android.text.TextUtils.isEmpty(r1)
            if (r5 != 0) goto L_0x005c
            boolean r5 = android.text.TextUtils.isEmpty(r6)
            if (r5 != 0) goto L_0x0040
            org.json.JSONObject r5 = new org.json.JSONObject     // Catch:{ JSONException -> 0x003f }
            r5.<init>(r4)     // Catch:{ JSONException -> 0x003f }
            java.lang.String r0 = "errMsg"
            org.json.JSONObject r5 = r5.put(r0, r6)     // Catch:{ JSONException -> 0x003f }
            java.lang.String r4 = r5.toString()     // Catch:{ JSONException -> 0x003f }
            goto L_0x0040
        L_0x003f:
        L_0x0040:
            boolean r5 = android.text.TextUtils.isEmpty(r7)
            if (r5 != 0) goto L_0x0055
            org.json.JSONObject r5 = new org.json.JSONObject     // Catch:{ JSONException -> 0x0055 }
            r5.<init>(r4)     // Catch:{ JSONException -> 0x0055 }
            java.lang.String r6 = "errCode"
            org.json.JSONObject r5 = r5.put(r6, r7)     // Catch:{ JSONException -> 0x0055 }
            java.lang.String r4 = r5.toString()     // Catch:{ JSONException -> 0x0055 }
        L_0x0055:
            java.lang.String r4 = r3.c((java.lang.String) r1, (java.lang.String) r4)
            r3.j((java.lang.String) r4)
        L_0x005c:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ironsource.sdk.controller.u.a(java.lang.String, boolean, java.lang.String, java.lang.String):void");
    }

    private String b(String str) {
        String str2 = this.C + File.separator;
        return str.contains(str2) ? str.substring(str2.length()) : str;
    }

    private String b(String str, String str2, String str3) {
        return new m.a(str, (String) null, str2, str3).a();
    }

    private Map<String, String> b(e6.e eVar) {
        if (eVar == e6.e.OfferWall) {
            return this.g;
        }
        return null;
    }

    private i2 c(Context context) {
        return new j(SDKUtils.getControllerConfigAsJSONObject(), context);
    }

    /* access modifiers changed from: private */
    public String c(String str, String str2) {
        return new m.a(str, str2).a();
    }

    private void c(JSONObject jSONObject) throws JSONException {
        jSONObject.put(SDKUtils.encodeString("gpi"), ca.d(getContext()));
    }

    private String d(JSONObject jSONObject) {
        l3 b2 = l3.b(getContext());
        StringBuilder sb = new StringBuilder();
        String sDKVersion = SDKUtils.getSDKVersion();
        if (!TextUtils.isEmpty(sDKVersion)) {
            sb.append("SDKVersion=");
            sb.append(sDKVersion);
            sb.append(m2.i.c);
        }
        String e2 = b2.e();
        if (!TextUtils.isEmpty(e2)) {
            sb.append("deviceOs=");
            sb.append(e2);
        }
        Uri parse = Uri.parse(SDKUtils.getControllerUrl());
        if (parse != null) {
            String str = parse.getScheme() + ":";
            String host = parse.getHost();
            int port = parse.getPort();
            if (port != -1) {
                host = host + ":" + port;
            }
            sb.append("&protocol=");
            sb.append(str);
            sb.append("&domain=");
            sb.append(host);
            if (jSONObject.keys().hasNext()) {
                try {
                    String jSONObject2 = new JSONObject(jSONObject, new String[]{m2.i.Y, "applicationKey"}).toString();
                    if (!TextUtils.isEmpty(jSONObject2)) {
                        sb.append(m2.i.c);
                        sb.append(m2.i.M);
                        sb.append(m2.i.b);
                        sb.append(jSONObject2);
                    }
                } catch (JSONException e3) {
                    e3.printStackTrace();
                }
            }
            sb.append("&debug=");
            sb.append(getDebugMode());
        }
        return sb.toString();
    }

    /* access modifiers changed from: private */
    public void d(String str) {
        evaluateJavascript(str, (ValueCallback) null);
    }

    /* access modifiers changed from: private */
    public Object[] d(Context context) {
        boolean z2;
        l3 b2 = l3.b(context);
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("appOrientation", "none");
            jSONObject.put(m2.i.z, SDKUtils.translateDeviceOrientation(m3.m(context)));
            String d2 = b2.d();
            if (d2 != null) {
                jSONObject.put(SDKUtils.encodeString("deviceOEM"), SDKUtils.encodeString(d2));
            }
            String c2 = b2.c();
            if (c2 != null) {
                jSONObject.put(SDKUtils.encodeString("deviceModel"), SDKUtils.encodeString(c2));
                z2 = false;
            } else {
                z2 = true;
            }
            try {
                SDKUtils.loadGoogleAdvertiserInfo(context);
                String advertiserId = SDKUtils.getAdvertiserId();
                if (!TextUtils.isEmpty(advertiserId)) {
                    Logger.i(this.b, "add AID");
                    jSONObject.put(jc.n0, SDKUtils.encodeString(advertiserId));
                }
                String limitAdTracking = SDKUtils.getLimitAdTracking();
                if (!TextUtils.isEmpty(limitAdTracking)) {
                    Logger.i(this.b, "add LAT");
                    jSONObject.put("isLimitAdTrackingEnabled", Boolean.parseBoolean(limitAdTracking));
                }
                String e2 = b2.e();
                if (e2 != null) {
                    jSONObject.put(SDKUtils.encodeString("deviceOs"), SDKUtils.encodeString(e2));
                } else {
                    z2 = true;
                }
                String f2 = b2.f();
                if (f2 != null) {
                    jSONObject.put(SDKUtils.encodeString("deviceOSVersion"), f2.replaceAll("[^0-9/.]", ""));
                } else {
                    z2 = true;
                }
                String f3 = b2.f();
                if (f3 != null) {
                    jSONObject.put(SDKUtils.encodeString("deviceOSVersionFull"), SDKUtils.encodeString(f3));
                }
                String valueOf = String.valueOf(b2.a());
                if (valueOf != null) {
                    jSONObject.put(SDKUtils.encodeString("deviceApiLevel"), valueOf);
                } else {
                    z2 = true;
                }
                jSONObject.put(t4.V, String.valueOf(com.ironsource.o.a()));
                String sDKVersion = SDKUtils.getSDKVersion();
                if (sDKVersion != null) {
                    jSONObject.put(SDKUtils.encodeString("SDKVersion"), SDKUtils.encodeString(sDKVersion));
                }
                if (b2.b() != null && b2.b().length() > 0) {
                    jSONObject.put(SDKUtils.encodeString("mobileCarrier"), SDKUtils.encodeString(b2.b()));
                }
                String b3 = l2.b(context);
                if (!b3.equals("none")) {
                    jSONObject.put(SDKUtils.encodeString("connectionType"), SDKUtils.encodeString(b3));
                } else {
                    z2 = true;
                }
                if (Build.VERSION.SDK_INT >= 23) {
                    jSONObject.put(SDKUtils.encodeString("hasVPN"), l2.d(context));
                }
                jSONObject.put("uxt", IronSourceStorageUtils.isUxt());
                String language = context.getResources().getConfiguration().locale.getLanguage();
                if (!TextUtils.isEmpty(language)) {
                    jSONObject.put(SDKUtils.encodeString("deviceLanguage"), SDKUtils.encodeString(language.toUpperCase()));
                }
                if (SDKUtils.isExternalStorageAvailable()) {
                    jSONObject.put(SDKUtils.encodeString("diskFreeSize"), SDKUtils.encodeString(String.valueOf(m3.d(this.C))));
                } else {
                    z2 = true;
                }
                String valueOf2 = String.valueOf(m3.o());
                if (!TextUtils.isEmpty(valueOf2)) {
                    jSONObject.put(SDKUtils.encodeString(m2.i.F) + m2.i.d + SDKUtils.encodeString("width") + m2.i.e, SDKUtils.encodeString(valueOf2));
                } else {
                    z2 = true;
                }
                String valueOf3 = String.valueOf(m3.h());
                jSONObject.put(SDKUtils.encodeString(m2.i.F) + m2.i.d + SDKUtils.encodeString("height") + m2.i.e, SDKUtils.encodeString(valueOf3));
                String g2 = k0.g(getContext());
                if (!TextUtils.isEmpty(g2)) {
                    jSONObject.put(SDKUtils.encodeString("bundleId"), SDKUtils.encodeString(g2));
                }
                String valueOf4 = String.valueOf(m3.g());
                if (!TextUtils.isEmpty(valueOf4)) {
                    jSONObject.put(SDKUtils.encodeString("deviceScreenScale"), SDKUtils.encodeString(valueOf4));
                }
                String valueOf5 = String.valueOf(m3.s());
                if (!TextUtils.isEmpty(valueOf5)) {
                    jSONObject.put(SDKUtils.encodeString("unLocked"), SDKUtils.encodeString(valueOf5));
                }
                jSONObject.put(SDKUtils.encodeString("deviceVolume"), (double) l3.b(context).a(context));
                jSONObject.put(SDKUtils.encodeString("batteryLevel"), m3.h(context));
                jSONObject.put(SDKUtils.encodeString("mcc"), k2.b(context));
                jSONObject.put(SDKUtils.encodeString("mnc"), k2.c(context));
                jSONObject.put(SDKUtils.encodeString("phoneType"), k2.e(context));
                jSONObject.put(SDKUtils.encodeString("simOperator"), SDKUtils.encodeString(k2.f(context)));
                jSONObject.put(SDKUtils.encodeString("lastUpdateTime"), k0.f(context));
                jSONObject.put(SDKUtils.encodeString("firstInstallTime"), k0.d(context));
                jSONObject.put(SDKUtils.encodeString("appVersion"), SDKUtils.encodeString(k0.b(context)));
                String e3 = k0.e(context);
                if (!TextUtils.isEmpty(e3)) {
                    jSONObject.put(SDKUtils.encodeString("installerPackageName"), SDKUtils.encodeString(e3));
                }
                c(jSONObject);
                jSONObject.put(SDKUtils.encodeString(m2.i.o0), m3.A(context));
            } catch (JSONException e4) {
                e = e4;
                e.printStackTrace();
                return new Object[]{jSONObject.toString(), Boolean.valueOf(z2)};
            }
        } catch (JSONException e5) {
            e = e5;
            z2 = false;
            e.printStackTrace();
            return new Object[]{jSONObject.toString(), Boolean.valueOf(z2)};
        }
        return new Object[]{jSONObject.toString(), Boolean.valueOf(z2)};
    }

    /* access modifiers changed from: private */
    public Object[] d(String str, String str2) {
        boolean z2;
        JSONObject jSONObject = new JSONObject();
        Map<String, String> map = null;
        if (!TextUtils.isEmpty(str)) {
            e6.e h2 = h(str);
            if (h2 == e6.e.OfferWall) {
                map = this.g;
            } else {
                h3 a2 = this.I.a(h2, str2);
                if (a2 != null) {
                    map = a2.g();
                    map.put("demandSourceName", a2.f());
                    map.put("demandSourceId", a2.h());
                }
            }
            try {
                jSONObject.put(m2.h.m, str);
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
            try {
                Map<String, String> initSDKParams = SDKUtils.getInitSDKParams();
                if (initSDKParams != null) {
                    jSONObject = SDKUtils.mergeJSONObjects(jSONObject, new JSONObject(initSDKParams));
                }
            } catch (Exception e3) {
                e3.printStackTrace();
            }
            z2 = false;
        } else {
            z2 = true;
        }
        if (!TextUtils.isEmpty(this.f)) {
            try {
                jSONObject.put(SDKUtils.encodeString("applicationUserId"), SDKUtils.encodeString(this.f));
            } catch (JSONException e4) {
                e4.printStackTrace();
            }
        }
        if (!TextUtils.isEmpty(this.e)) {
            try {
                jSONObject.put(SDKUtils.encodeString("applicationKey"), SDKUtils.encodeString(this.e));
            } catch (JSONException e5) {
                e5.printStackTrace();
            }
        } else {
            z2 = true;
        }
        if (map != null && !map.isEmpty()) {
            for (Map.Entry next : map.entrySet()) {
                if (((String) next.getKey()).equalsIgnoreCase("sdkWebViewCache")) {
                    setWebviewCache((String) next.getValue());
                }
                try {
                    jSONObject.put(SDKUtils.encodeString((String) next.getKey()), SDKUtils.encodeString((String) next.getValue()));
                } catch (JSONException e6) {
                    e6.printStackTrace();
                }
            }
        }
        return new Object[]{jSONObject.toString(), Boolean.valueOf(z2)};
    }

    /* access modifiers changed from: private */
    public String e(String str) {
        return new ab(str).d(g0);
    }

    private void e(Context context) {
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        this.u = new FrameLayout(context);
        this.s = new FrameLayout(context);
        this.s.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        this.s.setVisibility(8);
        FrameLayout frameLayout = new FrameLayout(context);
        frameLayout.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        frameLayout.addView(this);
        this.u.addView(this.s, layoutParams);
        this.u.addView(frameLayout);
    }

    /* access modifiers changed from: private */
    public String f(String str) {
        return new ab(str).d(f0);
    }

    /* access modifiers changed from: private */
    public void f(Context context) {
        try {
            i2 i2Var = this.R;
            if (i2Var != null) {
                i2Var.b(context);
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    /* access modifiers changed from: private */
    public void f(String str, String str2) {
        String d2 = new ab(str2).d("errMsg");
        if (!TextUtils.isEmpty(d2)) {
            c((Runnable) new f(str, d2));
        }
    }

    private String g(String str) {
        return new m.a(str).a();
    }

    /* access modifiers changed from: private */
    public void g() {
        aa aaVar = this.W;
        if (aaVar != null) {
            aaVar.onCloseRequested();
        }
    }

    /* access modifiers changed from: private */
    public void g(Context context) {
        try {
            i2 i2Var = this.R;
            if (i2Var != null) {
                i2Var.c(context);
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    private WebView getWebview() {
        return this;
    }

    /* access modifiers changed from: private */
    public e6.e h(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        e6.e eVar = e6.e.Interstitial;
        if (str.equalsIgnoreCase(eVar.toString())) {
            return eVar;
        }
        e6.e eVar2 = e6.e.RewardedVideo;
        if (str.equalsIgnoreCase(eVar2.toString())) {
            return eVar2;
        }
        e6.e eVar3 = e6.e.OfferWall;
        if (str.equalsIgnoreCase(eVar3.toString())) {
            return eVar3;
        }
        e6.e eVar4 = e6.e.Banner;
        if (str.equalsIgnoreCase(eVar4.toString())) {
            return eVar4;
        }
        return null;
    }

    private void h() {
        r rVar = new r(r.a());
        addJavascriptInterface(a(rVar), m2.e);
        addJavascriptInterface(b(rVar), m2.f);
    }

    /* access modifiers changed from: private */
    public void j(String str) {
        if (!TextUtils.isEmpty(str)) {
            String str2 = (getDebugMode() != e6.d.MODE_0.a() && (getDebugMode() < e6.d.MODE_1.a() || getDebugMode() > e6.d.MODE_3.a())) ? "empty" : "console.log(\"JS exeption: \" + JSON.stringify(e));";
            StringBuilder sb = new StringBuilder();
            sb.append("try{");
            sb.append(str);
            sb.append("}catch(e){");
            sb.append(str2);
            sb.append("}");
            String str3 = "javascript:" + sb.toString();
            Logger.i(this.b, str3);
            c((Runnable) new b(sb, str3));
        }
    }

    /* access modifiers changed from: private */
    public void l(String str) {
        try {
            String str2 = this.b;
            Logger.i(str2, "load(): " + str);
            loadUrl(str);
        } catch (Throwable th) {
            String str3 = this.b;
            Logger.e(str3, "WebViewController::load: " + th);
        }
    }

    /* access modifiers changed from: private */
    public boolean n(String str) {
        boolean z2 = false;
        if (TextUtils.isEmpty(str)) {
            Logger.d(this.b, "Trying to trigger a listener - no product was found");
            return false;
        }
        if (!str.equalsIgnoreCase(e6.e.Interstitial.toString()) ? !str.equalsIgnoreCase(e6.e.RewardedVideo.toString()) ? !str.equalsIgnoreCase(e6.e.Banner.toString()) ? (str.equalsIgnoreCase(e6.e.OfferWall.toString()) || str.equalsIgnoreCase(e6.e.OfferWallCredits.toString())) && this.z != null : this.A != null : this.x != null : this.y != null) {
            z2 = true;
        }
        if (!z2) {
            String str2 = this.b;
            Logger.d(str2, "Trying to trigger a listener - no listener was found for product " + str);
        }
        return z2;
    }

    private void r() {
        WebView.setWebContentsDebuggingEnabled(true);
    }

    private void setMediaPlaybackJellyBean(WebSettings webSettings) {
        webSettings.setMediaPlaybackRequiresUserGesture(false);
    }

    /* access modifiers changed from: private */
    public void setWebDebuggingEnabled(JSONObject jSONObject) {
        if (jSONObject.optBoolean("inspectWebview")) {
            r();
        }
    }

    /* access modifiers changed from: private */
    public void setWebviewBackground(String str) {
        WebView webView;
        ab abVar = new ab(str);
        String d2 = abVar.d(m2.h.S);
        String d3 = abVar.d("adViewId");
        int parseColor = !m2.h.T.equalsIgnoreCase(d2) ? Color.parseColor(d2) : 0;
        if (d3 != null) {
            webView = d6.a().a(d3).getPresentingView();
            if (webView == null) {
                return;
            }
        } else {
            webView = this;
        }
        webView.setBackgroundColor(parseColor);
    }

    private void setWebviewCache(String str) {
        WebSettings webSettings;
        int i2;
        if (str.equalsIgnoreCase("0")) {
            webSettings = getSettings();
            i2 = 2;
        } else {
            webSettings = getSettings();
            i2 = -1;
        }
        webSettings.setCacheMode(i2);
    }

    /* access modifiers changed from: package-private */
    public g a(r rVar) {
        return new g(new b(new v()), rVar);
    }

    public void a(int i2) {
        b(i2);
    }

    public void a(Activity activity) {
        this.V.a(activity);
    }

    public void a(Context context) {
        a((Runnable) new h(context));
    }

    /* access modifiers changed from: package-private */
    public void a(e6.e eVar, String str) {
        b((Runnable) new i(eVar, str));
    }

    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0069, code lost:
        if (android.text.TextUtils.isEmpty(r0) == false) goto L_0x006b;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void a(com.ironsource.f0 r11) {
        /*
            r10 = this;
            java.lang.String r0 = "restoreState(state:"
            java.lang.Object r1 = r10.G
            monitor-enter(r1)
            boolean r2 = r11.m()     // Catch:{ all -> 0x015f }
            if (r2 == 0) goto L_0x015b
            boolean r2 = r10.i     // Catch:{ all -> 0x015f }
            if (r2 == 0) goto L_0x015b
            java.lang.String r2 = r10.b     // Catch:{ all -> 0x015f }
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x015f }
            r3.<init>(r0)     // Catch:{ all -> 0x015f }
            r3.append(r11)     // Catch:{ all -> 0x015f }
            java.lang.String r0 = ")"
            r3.append(r0)     // Catch:{ all -> 0x015f }
            java.lang.String r0 = r3.toString()     // Catch:{ all -> 0x015f }
            android.util.Log.d(r2, r0)     // Catch:{ all -> 0x015f }
            int r0 = r11.c()     // Catch:{ all -> 0x015f }
            r2 = -1
            if (r0 == r2) goto L_0x008d
            com.ironsource.e6$e r3 = com.ironsource.e6.e.RewardedVideo     // Catch:{ all -> 0x015f }
            int r4 = r3.ordinal()     // Catch:{ all -> 0x015f }
            if (r0 != r4) goto L_0x004c
            java.lang.String r0 = r10.b     // Catch:{ all -> 0x015f }
            java.lang.String r4 = "onRVAdClosed()"
            android.util.Log.d(r0, r4)     // Catch:{ all -> 0x015f }
            java.lang.String r0 = r11.b()     // Catch:{ all -> 0x015f }
            com.ironsource.u2 r4 = r10.a((com.ironsource.e6.e) r3)     // Catch:{ all -> 0x015f }
            if (r4 == 0) goto L_0x0085
            boolean r5 = android.text.TextUtils.isEmpty(r0)     // Catch:{ all -> 0x015f }
            if (r5 != 0) goto L_0x0085
            goto L_0x006b
        L_0x004c:
            com.ironsource.e6$e r3 = com.ironsource.e6.e.Interstitial     // Catch:{ all -> 0x015f }
            int r4 = r3.ordinal()     // Catch:{ all -> 0x015f }
            if (r0 != r4) goto L_0x006f
            java.lang.String r0 = r10.b     // Catch:{ all -> 0x015f }
            java.lang.String r4 = "onInterstitialAdClosed()"
            android.util.Log.d(r0, r4)     // Catch:{ all -> 0x015f }
            java.lang.String r0 = r11.b()     // Catch:{ all -> 0x015f }
            com.ironsource.u2 r4 = r10.a((com.ironsource.e6.e) r3)     // Catch:{ all -> 0x015f }
            if (r4 == 0) goto L_0x0085
            boolean r5 = android.text.TextUtils.isEmpty(r0)     // Catch:{ all -> 0x015f }
            if (r5 != 0) goto L_0x0085
        L_0x006b:
            r4.a(r3, r0)     // Catch:{ all -> 0x015f }
            goto L_0x0085
        L_0x006f:
            com.ironsource.e6$e r3 = com.ironsource.e6.e.OfferWall     // Catch:{ all -> 0x015f }
            int r3 = r3.ordinal()     // Catch:{ all -> 0x015f }
            if (r0 != r3) goto L_0x0085
            java.lang.String r0 = r10.b     // Catch:{ all -> 0x015f }
            java.lang.String r3 = "onOWAdClosed()"
            android.util.Log.d(r0, r3)     // Catch:{ all -> 0x015f }
            com.ironsource.w9 r0 = r10.z     // Catch:{ all -> 0x015f }
            if (r0 == 0) goto L_0x0085
            r0.onOWAdClosed()     // Catch:{ all -> 0x015f }
        L_0x0085:
            r11.a((int) r2)     // Catch:{ all -> 0x015f }
            r0 = 0
            r11.f(r0)     // Catch:{ all -> 0x015f }
            goto L_0x0094
        L_0x008d:
            java.lang.String r0 = r10.b     // Catch:{ all -> 0x015f }
            java.lang.String r2 = "No ad was opened"
            android.util.Log.d(r0, r2)     // Catch:{ all -> 0x015f }
        L_0x0094:
            java.lang.String r0 = r11.d()     // Catch:{ all -> 0x015f }
            java.lang.String r2 = r11.f()     // Catch:{ all -> 0x015f }
            com.ironsource.i3 r3 = r10.I     // Catch:{ all -> 0x015f }
            com.ironsource.e6$e r4 = com.ironsource.e6.e.Interstitial     // Catch:{ all -> 0x015f }
            java.util.Collection r3 = r3.a(r4)     // Catch:{ all -> 0x015f }
            java.util.Iterator r3 = r3.iterator()     // Catch:{ all -> 0x015f }
        L_0x00a8:
            boolean r4 = r3.hasNext()     // Catch:{ all -> 0x015f }
            r5 = 2
            if (r4 == 0) goto L_0x00f0
            java.lang.Object r4 = r3.next()     // Catch:{ all -> 0x015f }
            com.ironsource.h3 r4 = (com.ironsource.h3) r4     // Catch:{ all -> 0x015f }
            int r6 = r4.e()     // Catch:{ all -> 0x015f }
            if (r6 != r5) goto L_0x00a8
            java.lang.String r5 = r10.b     // Catch:{ all -> 0x015f }
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch:{ all -> 0x015f }
            r6.<init>()     // Catch:{ all -> 0x015f }
            java.lang.String r7 = "initInterstitial(appKey:"
            r6.append(r7)     // Catch:{ all -> 0x015f }
            r6.append(r0)     // Catch:{ all -> 0x015f }
            java.lang.String r7 = ", userId:"
            r6.append(r7)     // Catch:{ all -> 0x015f }
            r6.append(r2)     // Catch:{ all -> 0x015f }
            java.lang.String r7 = ", demandSource:"
            r6.append(r7)     // Catch:{ all -> 0x015f }
            java.lang.String r7 = r4.f()     // Catch:{ all -> 0x015f }
            r6.append(r7)     // Catch:{ all -> 0x015f }
            java.lang.String r7 = ")"
            r6.append(r7)     // Catch:{ all -> 0x015f }
            java.lang.String r6 = r6.toString()     // Catch:{ all -> 0x015f }
            android.util.Log.d(r5, r6)     // Catch:{ all -> 0x015f }
            com.ironsource.w2 r5 = r10.y     // Catch:{ all -> 0x015f }
            r10.a((java.lang.String) r0, (java.lang.String) r2, (com.ironsource.h3) r4, (com.ironsource.w2) r5)     // Catch:{ all -> 0x015f }
            goto L_0x00a8
        L_0x00f0:
            java.lang.String r0 = r11.i()     // Catch:{ all -> 0x015f }
            java.lang.String r2 = r11.j()     // Catch:{ all -> 0x015f }
            com.ironsource.i3 r3 = r10.I     // Catch:{ all -> 0x015f }
            com.ironsource.e6$e r4 = com.ironsource.e6.e.RewardedVideo     // Catch:{ all -> 0x015f }
            java.util.Collection r3 = r3.a(r4)     // Catch:{ all -> 0x015f }
            java.util.Iterator r3 = r3.iterator()     // Catch:{ all -> 0x015f }
        L_0x0104:
            boolean r4 = r3.hasNext()     // Catch:{ all -> 0x015f }
            if (r4 == 0) goto L_0x0157
            java.lang.Object r4 = r3.next()     // Catch:{ all -> 0x015f }
            com.ironsource.h3 r4 = (com.ironsource.h3) r4     // Catch:{ all -> 0x015f }
            int r6 = r4.e()     // Catch:{ all -> 0x015f }
            if (r6 != r5) goto L_0x0104
            java.lang.String r6 = r4.f()     // Catch:{ all -> 0x015f }
            java.lang.String r7 = r10.b     // Catch:{ all -> 0x015f }
            java.lang.String r8 = "onRVNoMoreOffers()"
            android.util.Log.d(r7, r8)     // Catch:{ all -> 0x015f }
            com.ironsource.x2 r7 = r10.x     // Catch:{ all -> 0x015f }
            r7.d(r6)     // Catch:{ all -> 0x015f }
            java.lang.String r7 = r10.b     // Catch:{ all -> 0x015f }
            java.lang.StringBuilder r8 = new java.lang.StringBuilder     // Catch:{ all -> 0x015f }
            r8.<init>()     // Catch:{ all -> 0x015f }
            java.lang.String r9 = "initRewardedVideo(appKey:"
            r8.append(r9)     // Catch:{ all -> 0x015f }
            r8.append(r0)     // Catch:{ all -> 0x015f }
            java.lang.String r9 = ", userId:"
            r8.append(r9)     // Catch:{ all -> 0x015f }
            r8.append(r2)     // Catch:{ all -> 0x015f }
            java.lang.String r9 = ", demandSource:"
            r8.append(r9)     // Catch:{ all -> 0x015f }
            r8.append(r6)     // Catch:{ all -> 0x015f }
            java.lang.String r6 = ")"
            r8.append(r6)     // Catch:{ all -> 0x015f }
            java.lang.String r6 = r8.toString()     // Catch:{ all -> 0x015f }
            android.util.Log.d(r7, r6)     // Catch:{ all -> 0x015f }
            com.ironsource.x2 r6 = r10.x     // Catch:{ all -> 0x015f }
            r10.a((java.lang.String) r0, (java.lang.String) r2, (com.ironsource.h3) r4, (com.ironsource.x2) r6)     // Catch:{ all -> 0x015f }
            goto L_0x0104
        L_0x0157:
            r0 = 0
            r11.c((boolean) r0)     // Catch:{ all -> 0x015f }
        L_0x015b:
            r10.F = r11     // Catch:{ all -> 0x015f }
            monitor-exit(r1)     // Catch:{ all -> 0x015f }
            return
        L_0x015f:
            r11 = move-exception
            monitor-exit(r1)     // Catch:{ all -> 0x015f }
            throw r11
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ironsource.sdk.controller.u.a(com.ironsource.f0):void");
    }

    public void a(h3 h3Var) {
        Map<String, String> b2 = h3Var.b();
        if (b2 != null) {
            j(a(m2.g.Y, SDKUtils.flatMapToJsonAsString(b2), m2.g.V, m2.g.W));
        }
    }

    public void a(h3 h3Var, Map<String, String> map, v2 v2Var) {
        Map<String, String> mergeHashMaps = SDKUtils.mergeHashMaps(new Map[]{map, h3Var.b()});
        if (map != null) {
            j(a(m2.g.T, SDKUtils.flatMapToJsonAsString(mergeHashMaps), m2.g.U, m2.g.X));
        }
    }

    public void a(h3 h3Var, Map<String, String> map, w2 w2Var) {
        j(a(e6.e.Interstitial, new JSONObject(SDKUtils.mergeHashMaps(new Map[]{map, h3Var.b()}))));
    }

    public void a(n6 n6Var) {
        if (n6Var.getName().contains(m2.g)) {
            this.D.a((Runnable) new c());
        } else {
            a(n6Var.getName(), n6Var.getParent());
        }
    }

    public void a(n6 n6Var, f6 f6Var) {
        if (n6Var.getName().contains(m2.g)) {
            this.D.a(new d(), new e(f6Var));
        } else {
            a(n6Var.getName(), n6Var.getParent(), f6Var.b());
        }
    }

    public void a(a aVar) {
        this.N = aVar;
        aVar.a(getControllerDelegate());
    }

    public void a(f.c cVar, k.a aVar) {
        j(a(cVar.e(), cVar.h(), m2.g.Z, m2.g.Z));
    }

    public void a(i iVar) {
        this.M = iVar;
    }

    public void a(j jVar) {
        this.O = jVar;
    }

    public void a(o oVar) {
        this.J = oVar;
    }

    public void a(p pVar) {
        this.K = pVar;
    }

    public void a(t tVar) {
        this.L = tVar;
    }

    /* access modifiers changed from: package-private */
    public void a(Runnable runnable) {
        n5 n5Var = this.a;
        if (n5Var != null) {
            n5Var.a(runnable);
        }
    }

    public void a(String str, w2 w2Var) {
        HashMap hashMap = new HashMap();
        hashMap.put("demandSourceName", str);
        String flatMapToJsonAsString = SDKUtils.flatMapToJsonAsString(hashMap);
        this.F.d(str, true);
        j(a(m2.g.K, flatMapToJsonAsString, m2.g.L, m2.g.M));
    }

    public void a(String str, String str2) {
        try {
            j(c(m2.g.o, a(m2.h.b, str, "path", b(str2), (String) null, (String) null, (String) null, (String) null, (String) null, false)));
        } catch (Exception e2) {
            a(str, str2, e2.getMessage());
        }
    }

    public void a(String str, String str2, h3 h3Var, v2 v2Var) {
        this.e = str;
        this.f = str2;
        this.A = v2Var;
        a(str, e6.e.Banner, h3Var, (w) new r());
    }

    public void a(String str, String str2, h3 h3Var, w2 w2Var) {
        this.e = str;
        this.f = str2;
        this.y = w2Var;
        this.F.g(str);
        this.F.h(this.f);
        a(this.e, e6.e.Interstitial, h3Var, (w) new o());
    }

    public void a(String str, String str2, h3 h3Var, x2 x2Var) {
        this.e = str;
        this.f = str2;
        this.x = x2Var;
        this.F.i(str);
        this.F.j(str2);
        a(str, e6.e.RewardedVideo, h3Var, (w) new n());
    }

    public void a(String str, String str2, w9 w9Var) {
        this.e = str;
        this.f = str2;
        this.z = w9Var;
        if (TextUtils.isEmpty(str2)) {
            a("UserId missing", e6.e.OfferWallCredits, (h3) null);
        } else {
            a(this.e, e6.e.OfferWallCredits, (h3) null, (w) new q());
        }
    }

    public void a(String str, String str2, String str3) {
        try {
            j(c(m2.g.p, a(m2.h.b, str, "path", b(str2), "errMsg", str3, (String) null, (String) null, (String) null, false)));
        } catch (Exception unused) {
        }
    }

    public void a(String str, String str2, Map<String, String> map, w9 w9Var) {
        this.e = str;
        this.f = str2;
        this.g = map;
        this.z = w9Var;
        this.F.b(map);
        this.F.b(true);
        if (TextUtils.isEmpty(str2)) {
            a("UserId missing", e6.e.OfferWall, (h3) null);
        } else {
            a(this.e, e6.e.OfferWall, (h3) null, (w) new p());
        }
    }

    public void a(Map<String, String> map, w9 w9Var) {
        this.g = map;
        j(b(m2.g.C, m2.g.E, m2.g.F));
    }

    public void a(JSONObject jSONObject) {
        j(c(m2.g.j0, jSONObject != null ? jSONObject.toString() : null));
    }

    public void a(JSONObject jSONObject, v2 v2Var) {
        j(a(m2.g.T, jSONObject.toString(), m2.g.U, m2.g.X));
    }

    public void a(JSONObject jSONObject, w2 w2Var) {
        j(a(e6.e.Interstitial, jSONObject));
    }

    public void a(JSONObject jSONObject, x2 x2Var) {
        j(a(e6.e.RewardedVideo, jSONObject));
    }

    public void a(boolean z2, String str) {
        j(c(m2.g.a0, a(m2.h.K, str, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, m2.h.o, z2)));
    }

    public boolean a(String str) {
        h3 a2 = this.I.a(e6.e.Interstitial, str);
        return a2 != null && a2.d();
    }

    /* access modifiers changed from: package-private */
    public q b(r rVar) {
        return new q(rVar);
    }

    public void b() {
        j(g(m2.g.s));
    }

    public void b(int i2) {
        if (this.D.m()) {
            JSONObject controllerConfigAsJSONObject = SDKUtils.getControllerConfigAsJSONObject();
            String d2 = d(controllerConfigAsJSONObject);
            Map<String, String> initSDKParams = SDKUtils.getInitSDKParams();
            if (initSDKParams != null && initSDKParams.containsKey(z3.g)) {
                d2 = String.format("%s&sessionid=%s", new Object[]{d2, initSDKParams.get(z3.g)});
            }
            String uri = this.D.g().toURI().toString();
            this.a.c(new l(controllerConfigAsJSONObject, uri + "?" + d2));
            this.m = new m(50000, 1000, i2).start();
            return;
        }
        Logger.i(this.b, "load(): Mobile Controller HTML Does not exist");
    }

    public void b(Context context) {
        a((Runnable) new g(context));
    }

    public void b(h3 h3Var, Map<String, String> map, w2 w2Var) {
        a(h3Var, map);
    }

    /* access modifiers changed from: package-private */
    public void b(Runnable runnable) {
        n5 n5Var = this.a;
        if (n5Var != null) {
            n5Var.b(runnable);
        }
    }

    public void b(String str, String str2) {
        if (TextUtils.isEmpty(str2)) {
            str2 = m2.c.B;
        }
        String str3 = str2;
        if (TextUtils.isEmpty(str)) {
            str = m2.c.A;
        }
        j(c(m2.g.f0, a("errMsg", str, "url", str3, (String) null, (String) null, (String) null, (String) null, (String) null, false)));
    }

    public void b(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.S = jSONObject;
        }
    }

    public void c() {
        a(this.F);
    }

    /* access modifiers changed from: package-private */
    public void c(Runnable runnable) {
        n5 n5Var = this.a;
        if (n5Var != null) {
            n5Var.c(runnable);
        }
    }

    public void c(String str) {
        if (str.equals(m2.h.i)) {
            g();
        }
        j(c(m2.g.y, a(m2.h.h, str, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, false)));
    }

    public void d() {
        j(g(m2.g.t));
    }

    public void destroy() {
        super.destroy();
        q3 q3Var = this.h;
        if (q3Var != null) {
            q3Var.d();
        }
        i2 i2Var = this.R;
        if (i2Var != null) {
            i2Var.b();
        }
        CountDownTimer countDownTimer = this.m;
        if (countDownTimer != null) {
            countDownTimer.cancel();
        }
    }

    public void e() {
        this.D.a(new g6());
        if (this.D.k()) {
            a(1);
        }
    }

    public void e(String str, String str2) {
        j(c(m2.g.b0, a(m2.h.p, str2, m2.h.m, str, (String) null, (String) null, (String) null, (String) null, (String) null, false)));
    }

    public void e(JSONObject jSONObject) {
        String str = this.b;
        Logger.i(str, "device connection info changed: " + jSONObject.toString());
        j(c(m2.g.x, a(m2.i.g0, jSONObject.toString(), (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, false)));
    }

    public gd getControllerDelegate() {
        if (this.P == null) {
            this.P = new k();
        }
        return this.P;
    }

    public Context getCurrentActivityContext() {
        return this.V.a();
    }

    public int getDebugMode() {
        return b0;
    }

    public FrameLayout getLayout() {
        return this.u;
    }

    public String getOrientationState() {
        return this.w;
    }

    public f0 getSavedState() {
        return this.F;
    }

    public y getState() {
        return this.v;
    }

    public e6.c getType() {
        return e6.c.Web;
    }

    public void i() {
        if (this.j != null) {
            g();
            e6.e b2 = this.j.b();
            String a2 = this.j.a();
            if (n(b2.toString())) {
                a(b2, a2);
            }
        }
    }

    public boolean i(String str) {
        List<String> d2 = d8.e().d();
        if (d2 == null) {
            return false;
        }
        try {
            if (d2.isEmpty()) {
                return false;
            }
            for (String contains : d2) {
                if (str.contains(contains)) {
                    pc.a(getCurrentActivityContext(), str);
                    return true;
                }
            }
            return false;
        } catch (Exception e2) {
            e2.printStackTrace();
            return false;
        }
    }

    public void j() {
        this.q.onHideCustomView();
    }

    public void k(String str) {
        j(c(m2.g.v, a(m2.h.h, str, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, false)));
    }

    public boolean k() {
        return this.r != null;
    }

    public void l() {
        j(g(m2.g.e0));
    }

    public void m() {
        j(g(m2.g.G));
    }

    public void m(String str) {
        String str2 = this.b;
        Logger.i(str2, "device status changed, connection type " + str);
        j6.a(str);
        j(c(m2.g.w, a("connectionType", str, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, false)));
    }

    public void n() {
        try {
            onPause();
        } catch (Throwable th) {
            String str = this.b;
            Logger.i(str, "WebViewController: onPause() - " + th);
        }
    }

    public void o() {
        this.E = null;
    }

    public void onDownloadStart(String str, String str2, String str3, String str4, long j2) {
        String str5 = this.b;
        Logger.i(str5, str + " " + str4);
    }

    public boolean onKeyDown(int i2, KeyEvent keyEvent) {
        aa aaVar;
        if (i2 != 4 || (aaVar = this.W) == null || !aaVar.onBackButtonPressed()) {
            return super.onKeyDown(i2, keyEvent);
        }
        return true;
    }

    public void p() {
        this.W = null;
    }

    public void q() {
        try {
            onResume();
        } catch (Throwable th) {
            String str = this.b;
            Logger.i(str, "WebViewController: onResume() - " + th);
        }
    }

    public WebBackForwardList saveState(Bundle bundle) {
        return super.saveState(bundle);
    }

    public void setDebugMode(int i2) {
        b0 = i2;
    }

    public void setOnWebViewControllerChangeListener(aa aaVar) {
        this.W = aaVar;
    }

    public void setOrientationState(String str) {
        this.w = str;
    }

    public void setState(y yVar) {
        this.v = yVar;
    }

    public void setVideoEventsListener(uc ucVar) {
        this.E = ucVar;
    }
}
