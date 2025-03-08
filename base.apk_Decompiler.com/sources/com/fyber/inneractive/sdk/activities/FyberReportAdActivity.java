package com.fyber.inneractive.sdk.activities;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.FrameLayout;
import com.fyber.inneractive.sdk.R;
import com.fyber.inneractive.sdk.flow.f;
import com.fyber.inneractive.sdk.util.IAlog;
import com.fyber.inneractive.sdk.util.u;
import com.google.android.gms.drive.DriveFile;

public class FyberReportAdActivity extends Activity {
    public static f b;
    public WebView a;

    public static void disableWebviewZoomControls(WebView webView) {
        webView.getSettings().setSupportZoom(true);
        webView.getSettings().setBuiltInZoomControls(true);
        webView.getSettings().setDisplayZoomControls(false);
    }

    public static f getAdReporter() {
        return b;
    }

    public final ViewGroup a() {
        WebView webView;
        FrameLayout frameLayout = new FrameLayout(this);
        try {
            webView = new WebView(this);
            webView.setWebViewClient(new a(this));
            webView.setId(R.id.inneractive_webview_report_ad);
            WebSettings settings = webView.getSettings();
            settings.setJavaScriptEnabled(true);
            settings.setSupportZoom(true);
            settings.setBuiltInZoomControls(true);
            settings.setUseWideViewPort(true);
            settings.setLoadWithOverviewMode(true);
            disableWebviewZoomControls(webView);
            webView.loadUrl("https://cdn2.inner-active.mobi/client/fyber-i-icon/index.html");
        } catch (Exception unused) {
            IAlog.b("failed creating webivew for report ad", new Object[0]);
            finish();
            webView = null;
        }
        this.a = webView;
        frameLayout.addView(webView, -1, -1);
        return frameLayout;
    }

    public void onCreate(Bundle bundle) {
        getWindow().requestFeature(2);
        getWindow().setFeatureInt(2, -1);
        super.onCreate(bundle);
        try {
            setContentView(a());
        } catch (Exception e) {
            IAlog.a("failed creating fyber report ad activity", e, new Object[0]);
            finish();
        }
    }

    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        setVisible(false);
    }

    public void onDestroy() {
        WebView webView = this.a;
        if (webView != null) {
            u.a((View) webView);
            this.a.destroy();
            this.a = null;
        }
        b = null;
        super.onDestroy();
    }

    public static void start(Context context, f fVar) {
        b = fVar;
        try {
            Intent intent = new Intent(context, FyberReportAdActivity.class);
            if (!(context instanceof Activity)) {
                intent.addFlags(DriveFile.MODE_READ_ONLY);
            }
            context.startActivity(intent);
        } catch (Exception e) {
            IAlog.a("failed starting fyber report ad activity", e, new Object[0]);
        }
    }
}
