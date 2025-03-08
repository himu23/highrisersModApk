package com.fyber.inneractive.sdk.activities;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import com.fyber.inneractive.sdk.R;
import com.fyber.inneractive.sdk.click.b;
import com.fyber.inneractive.sdk.click.i;
import com.fyber.inneractive.sdk.config.global.s;
import com.fyber.inneractive.sdk.external.InneractiveAdRequest;
import com.fyber.inneractive.sdk.external.InneractiveAdSpot;
import com.fyber.inneractive.sdk.external.InneractiveAdSpotManager;
import com.fyber.inneractive.sdk.flow.q;
import com.fyber.inneractive.sdk.network.r;
import com.fyber.inneractive.sdk.network.s;
import com.fyber.inneractive.sdk.response.e;
import com.fyber.inneractive.sdk.util.IAlog;
import com.fyber.inneractive.sdk.util.b0;
import com.fyber.inneractive.sdk.util.p;
import com.fyber.inneractive.sdk.util.u;
import com.google.android.gms.drive.DriveFile;
import com.ironsource.z3;
import java.net.URLDecoder;
import org.json.JSONArray;
import org.json.JSONObject;

public class InneractiveInternalBrowserActivity extends InneractiveBaseActivity {
    public static final String EXTRA_KEY_SPOT_ID = "spotId";
    public static final String URL_EXTRA = "extra_url";
    public static String j;
    public static InternalBrowserListener k;
    public q b;
    public String c;
    public LinearLayout d;
    public WebView e;
    public ImageButton f;
    public ImageButton g;
    public ImageButton h;
    public ImageButton i;

    public interface InternalBrowserListener {
        void onApplicationInBackground();

        void onInternalBrowserDismissed();
    }

    public static void a(InneractiveInternalBrowserActivity inneractiveInternalBrowserActivity, b bVar) {
        s sVar;
        q qVar = inneractiveInternalBrowserActivity.b;
        InneractiveAdRequest inneractiveAdRequest = qVar != null ? qVar.a : null;
        e d2 = qVar != null ? qVar.d() : null;
        q qVar2 = inneractiveInternalBrowserActivity.b;
        s.a aVar = new s.a(r.FYBER_SUCCESS_CLICK, inneractiveAdRequest, d2, (qVar2 == null || (sVar = qVar2.c) == null) ? null : sVar.c());
        JSONObject jSONObject = new JSONObject();
        long j2 = bVar.e;
        if (j2 != 0) {
            Long valueOf = Long.valueOf(j2);
            try {
                jSONObject.put("time_passed", valueOf);
            } catch (Exception unused) {
                IAlog.e("Got exception adding param to json object: %s, %s", "time_passed", valueOf);
            }
        }
        JSONArray jSONArray = new JSONArray();
        for (i next : bVar.f) {
            JSONObject jSONObject2 = new JSONObject();
            try {
                jSONObject2.put("url", next.a);
                jSONObject2.put("success", next.b);
                jSONObject2.put("opened_by", next.c);
                jSONObject2.put("reason", next.d);
            } catch (Exception unused2) {
            }
            jSONArray.put(jSONObject2);
        }
        try {
            jSONObject.put("urls", jSONArray);
        } catch (Exception unused3) {
            IAlog.e("Got exception adding param to json object: %s, %s", "urls", jSONArray);
        }
        com.fyber.inneractive.sdk.util.i iVar = com.fyber.inneractive.sdk.util.i.VIDEO_CTA;
        try {
            jSONObject.put("origin", iVar);
        } catch (Exception unused4) {
            IAlog.e("Got exception adding param to json object: %s, %s", "origin", iVar);
        }
        aVar.f.put(jSONObject);
        aVar.a((String) null);
    }

    public static void disableWebviewZoomControls(WebView webView) {
        webView.getSettings().setSupportZoom(true);
        webView.getSettings().setBuiltInZoomControls(true);
        webView.getSettings().setDisplayZoomControls(false);
    }

    public static void setHtmlExtra(String str) {
        j = str;
    }

    public static void setInternalBrowserListener(InternalBrowserListener internalBrowserListener) {
        k = internalBrowserListener;
    }

    public void onBackPressed() {
        finish();
    }

    public void onCreate(Bundle bundle) {
        InneractiveAdSpot spot;
        getWindow().requestFeature(2);
        getWindow().setFeatureInt(2, -1);
        super.onCreate(bundle);
        if (getActionBar() != null) {
            getActionBar().hide();
        }
        try {
            setContentView(a());
            String stringExtra = getIntent().getStringExtra("spotId");
            this.c = stringExtra;
            if (!TextUtils.isEmpty(stringExtra) && (spot = InneractiveAdSpotManager.get().getSpot(this.c)) != null) {
                this.b = spot.getAdContent();
            }
            Intent intent = getIntent();
            WebSettings settings = this.e.getSettings();
            settings.setJavaScriptEnabled(true);
            settings.setSupportZoom(true);
            settings.setBuiltInZoomControls(true);
            settings.setUseWideViewPort(true);
            settings.setLoadWithOverviewMode(true);
            disableWebviewZoomControls(this.e);
            this.e.setWebChromeClient(new c(this));
            String stringExtra2 = intent.getStringExtra(URL_EXTRA);
            if (!TextUtils.isEmpty(j)) {
                String str = j + "<title>DigitalTurbine Internal Browser</title>";
                j = str;
                this.e.loadDataWithBaseURL(stringExtra2, str, "text/html", "UTF-8", (String) null);
            } else if (TextUtils.isEmpty(stringExtra2)) {
                IAlog.e("Empty url", new Object[0]);
                finish();
            } else if (!b0.e(stringExtra2)) {
                this.e.loadUrl(stringExtra2);
            } else if (b0.d(stringExtra2)) {
                try {
                    stringExtra2 = URLDecoder.decode(stringExtra2, z3.L);
                    this.e.loadUrl(stringExtra2);
                } catch (Exception unused) {
                    IAlog.e("Failed to open Url: %s", stringExtra2);
                    finish();
                }
            } else {
                Intent intent2 = new Intent("android.intent.action.VIEW", Uri.parse(stringExtra2));
                intent2.addFlags(DriveFile.MODE_READ_ONLY);
                try {
                    startActivity(intent2);
                    InternalBrowserListener internalBrowserListener = k;
                    if (internalBrowserListener != null) {
                        internalBrowserListener.onApplicationInBackground();
                    }
                } catch (ActivityNotFoundException unused2) {
                    IAlog.e("Failed to start activity for %s. Please ensure that your phone can handle this intent.", stringExtra2);
                }
                finish();
            }
            this.f.setBackgroundColor(0);
            this.f.setOnClickListener(new g(this));
            this.f.setContentDescription("IABackButton");
            this.g.setBackgroundColor(0);
            this.g.setOnClickListener(new h(this));
            this.g.setContentDescription("IAForwardButton");
            this.h.setBackgroundColor(0);
            this.h.setOnClickListener(new i(this));
            this.h.setContentDescription("IARefreshButton");
            this.i.setBackgroundColor(0);
            this.i.setOnClickListener(new j(this));
            this.i.setContentDescription("IACloseButton");
        } catch (Exception unused3) {
            finish();
        }
    }

    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        setVisible(false);
    }

    public void onPause() {
        super.onPause();
    }

    public void onResume() {
        super.onResume();
    }

    public void finish() {
        InternalBrowserListener internalBrowserListener = k;
        super.finish();
        if (internalBrowserListener != null) {
            internalBrowserListener.onInternalBrowserDismissed();
        }
    }

    public void onDestroy() {
        LinearLayout linearLayout = this.d;
        if (linearLayout != null) {
            linearLayout.removeAllViews();
        }
        WebView webView = this.e;
        if (webView != null) {
            u.a((View) webView);
            this.e.destroy();
            this.e = null;
        }
        super.onDestroy();
        setHtmlExtra((String) null);
    }

    public final View a() {
        this.d = new LinearLayout(this);
        this.d.setLayoutParams(new LinearLayout.LayoutParams(-1, -1));
        this.d.setOrientation(1);
        this.d.setContentDescription("IAInternalBrowserView");
        RelativeLayout relativeLayout = new RelativeLayout(this);
        relativeLayout.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        this.d.addView(relativeLayout);
        LinearLayout linearLayout = new LinearLayout(this);
        linearLayout.setId(1);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, p.a(getResources().getInteger(R.integer.ia_ib_toolbar_height_dp)));
        layoutParams.addRule(12);
        linearLayout.setLayoutParams(layoutParams);
        linearLayout.setBackground(p.c(R.drawable.ia_ib_background));
        relativeLayout.addView(linearLayout);
        this.f = a(p.c(R.drawable.ia_ib_left_arrow));
        this.g = a(p.c(R.drawable.ia_ib_right_arrow));
        this.h = a(p.c(R.drawable.ia_ib_refresh));
        this.i = a(p.c(R.drawable.ia_ib_close));
        linearLayout.addView(this.f);
        linearLayout.addView(this.g);
        linearLayout.addView(this.h);
        linearLayout.addView(this.i);
        WebView webView = new WebView(this);
        this.e = webView;
        webView.setWebViewClient(new d(this));
        this.e.setId(R.id.inneractive_webview_internal_browser);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-1, -1);
        layoutParams2.addRule(2, 1);
        this.e.setLayoutParams(layoutParams2);
        relativeLayout.addView(this.e);
        return this.d;
    }

    public final ImageButton a(Drawable drawable) {
        ImageButton imageButton = new ImageButton(this);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(p.a(getResources().getInteger(R.integer.ia_ib_button_size_dp)), p.a(getResources().getInteger(R.integer.ia_ib_button_size_dp)), 1.0f);
        layoutParams.gravity = 16;
        imageButton.setLayoutParams(layoutParams);
        imageButton.setScaleType(ImageView.ScaleType.FIT_CENTER);
        imageButton.setImageDrawable(drawable);
        return imageButton;
    }
}
