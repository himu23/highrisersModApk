package com.ironsource.sdk.controller;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.view.ContextThemeWrapper;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.RenderProcessGoneDetail;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import androidx.core.view.InputDeviceCompat;
import com.ironsource.d8;
import com.ironsource.g$$ExternalSyntheticApiModelOutline0;
import com.ironsource.m2;
import com.ironsource.r7;
import com.ironsource.sdk.utils.Logger;
import com.ironsource.sdk.utils.SDKUtils;
import java.util.List;

public class OpenUrlActivity extends Activity {
    private static final String j = "OpenUrlActivity";
    private static final int k = SDKUtils.generateViewId();
    private static final int l = SDKUtils.generateViewId();
    private WebView a = null;
    /* access modifiers changed from: private */
    public u b;
    /* access modifiers changed from: private */
    public ProgressBar c;
    boolean d;
    private RelativeLayout e;
    private String f;
    /* access modifiers changed from: private */
    public Handler g = new Handler();
    /* access modifiers changed from: private */
    public boolean h = false;
    /* access modifiers changed from: private */
    public final Runnable i = new b();

    class a implements View.OnSystemUiVisibilityChangeListener {
        a() {
        }

        public void onSystemUiVisibilityChange(int i) {
            if ((i & InputDeviceCompat.SOURCE_TOUCHSCREEN) == 0) {
                OpenUrlActivity.this.g.removeCallbacks(OpenUrlActivity.this.i);
                OpenUrlActivity.this.g.postDelayed(OpenUrlActivity.this.i, 500);
            }
        }
    }

    class b implements Runnable {
        b() {
        }

        public void run() {
            OpenUrlActivity.this.getWindow().getDecorView().setSystemUiVisibility(SDKUtils.getActivityUIFlags(OpenUrlActivity.this.h));
        }
    }

    private class c extends WebViewClient {
        private c() {
        }

        /* synthetic */ c(OpenUrlActivity openUrlActivity, a aVar) {
            this();
        }

        public void onPageFinished(WebView webView, String str) {
            super.onPageFinished(webView, str);
            OpenUrlActivity.this.c.setVisibility(4);
        }

        public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
            super.onPageStarted(webView, str, bitmap);
            OpenUrlActivity.this.c.setVisibility(0);
        }

        public void onReceivedError(WebView webView, int i, String str, String str2) {
            super.onReceivedError(webView, i, str, str2);
        }

        public boolean onRenderProcessGone(WebView webView, RenderProcessGoneDetail renderProcessGoneDetail) {
            Logger.e(OpenUrlActivity.j, "Chromium process crashed - detail.didCrash():" + g$$ExternalSyntheticApiModelOutline0.m(renderProcessGoneDetail));
            OpenUrlActivity.this.finish();
            return true;
        }

        public boolean shouldOverrideUrlLoading(WebView webView, String str) {
            List<String> d = d8.e().d();
            if (d != null && !d.isEmpty()) {
                for (String contains : d) {
                    if (str.contains(contains)) {
                        try {
                            OpenUrlActivity.this.startActivity(new Intent("android.intent.action.VIEW", Uri.parse(str)));
                            OpenUrlActivity.this.b.l();
                        } catch (Exception e) {
                            StringBuilder sb = new StringBuilder();
                            sb.append(e instanceof ActivityNotFoundException ? m2.c.z : m2.c.A);
                            if (OpenUrlActivity.this.b != null) {
                                OpenUrlActivity.this.b.b(sb.toString(), str);
                            }
                        }
                        OpenUrlActivity.this.finish();
                        return true;
                    }
                }
            }
            return super.shouldOverrideUrlLoading(webView, str);
        }
    }

    private void a() {
        if (this.c == null) {
            ProgressBar progressBar = new ProgressBar(new ContextThemeWrapper(this, 16973939));
            this.c = progressBar;
            progressBar.setId(l);
        }
        if (findViewById(l) == null) {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams.addRule(13);
            this.c.setLayoutParams(layoutParams);
            this.c.setVisibility(4);
            this.e.addView(this.c);
        }
    }

    private void b() {
        if (this.a == null) {
            WebView webView = new WebView(getApplicationContext());
            this.a = webView;
            webView.setId(k);
            this.a.getSettings().setJavaScriptEnabled(true);
            this.a.setWebViewClient(new c(this, (a) null));
            loadUrl(this.f);
        }
        if (findViewById(k) == null) {
            this.e.addView(this.a, new RelativeLayout.LayoutParams(-1, -1));
        }
        a();
        u uVar = this.b;
        if (uVar != null) {
            uVar.a(true, m2.h.Y);
        }
    }

    private void c() {
        WebView webView = this.a;
        if (webView != null) {
            webView.destroy();
        }
    }

    private void d() {
        getWindow().addFlags(16);
    }

    private void e() {
        requestWindowFeature(1);
    }

    private void f() {
        getWindow().setFlags(1024, 1024);
    }

    private void g() {
        ViewGroup viewGroup;
        u uVar = this.b;
        if (uVar != null) {
            uVar.a(false, m2.h.Y);
            if (this.e != null && (viewGroup = (ViewGroup) this.a.getParent()) != null) {
                if (viewGroup.findViewById(k) != null) {
                    viewGroup.removeView(this.a);
                }
                if (viewGroup.findViewById(l) != null) {
                    viewGroup.removeView(this.c);
                }
            }
        }
    }

    public void finish() {
        u uVar;
        if (this.d && (uVar = this.b) != null) {
            uVar.c(m2.h.j);
        }
        super.finish();
    }

    public void loadUrl(String str) {
        this.a.stopLoading();
        this.a.clearHistory();
        try {
            this.a.loadUrl(str);
        } catch (Throwable th) {
            Logger.e(j, "OpenUrlActivity:: loadUrl: " + th.toString());
        }
    }

    public void onBackPressed() {
        if (this.a.canGoBack()) {
            this.a.goBack();
        } else {
            super.onBackPressed();
        }
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Logger.i(j, "onCreate()");
        try {
            this.b = (u) r7.b((Context) this).a().i();
            e();
            f();
            Bundle extras = getIntent().getExtras();
            this.f = extras.getString(u.d0);
            this.d = extras.getBoolean(u.e0);
            boolean booleanExtra = getIntent().getBooleanExtra(m2.h.v, false);
            this.h = booleanExtra;
            if (booleanExtra) {
                getWindow().getDecorView().setOnSystemUiVisibilityChangeListener(new a());
                runOnUiThread(this.i);
            }
            RelativeLayout relativeLayout = new RelativeLayout(this);
            this.e = relativeLayout;
            setContentView(relativeLayout, new ViewGroup.LayoutParams(-1, -1));
        } catch (Exception e2) {
            e2.printStackTrace();
            finish();
        }
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        super.onDestroy();
        c();
    }

    public boolean onKeyDown(int i2, KeyEvent keyEvent) {
        if (this.h && (i2 == 25 || i2 == 24)) {
            this.g.postDelayed(this.i, 500);
        }
        return super.onKeyDown(i2, keyEvent);
    }

    /* access modifiers changed from: protected */
    public void onPause() {
        super.onPause();
        g();
    }

    /* access modifiers changed from: protected */
    public void onResume() {
        super.onResume();
        b();
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        if (this.h && z) {
            runOnUiThread(this.i);
        }
    }
}
