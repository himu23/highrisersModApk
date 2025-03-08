package com.fyber.inneractive.sdk.activities;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.text.TextUtils;
import android.webkit.RenderProcessGoneDetail;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import androidx.webkit.ProxyConfig;
import com.fyber.inneractive.sdk.R;
import com.fyber.inneractive.sdk.click.a;
import com.fyber.inneractive.sdk.click.f;
import com.fyber.inneractive.sdk.click.g;
import com.fyber.inneractive.sdk.click.h;
import com.fyber.inneractive.sdk.click.j;
import com.fyber.inneractive.sdk.click.l;
import com.fyber.inneractive.sdk.external.InneractiveAdRequest;
import com.fyber.inneractive.sdk.ignite.k;
import com.fyber.inneractive.sdk.network.t;
import com.fyber.inneractive.sdk.response.e;
import com.fyber.inneractive.sdk.util.IAlog;
import com.fyber.inneractive.sdk.util.f0;
import com.fyber.inneractive.sdk.util.i;
import com.fyber.inneractive.sdk.util.p;
import com.fyber.inneractive.sdk.util.p0;
import com.fyber.inneractive.sdk.util.u0;
import com.fyber.inneractive.sdk.web.r;
import java.util.Arrays;

public class d extends WebViewClient {
    public final /* synthetic */ InneractiveInternalBrowserActivity a;

    public d(InneractiveInternalBrowserActivity inneractiveInternalBrowserActivity) {
        this.a = inneractiveInternalBrowserActivity;
    }

    public void onPageFinished(WebView webView, String str) {
        Drawable drawable;
        Drawable drawable2;
        super.onPageFinished(webView, str);
        if (webView.canGoBack()) {
            drawable = p.c(R.drawable.ia_ib_left_arrow);
        } else {
            drawable = p.c(R.drawable.ia_ib_unleft_arrow);
        }
        this.a.f.setImageDrawable(drawable);
        if (webView.canGoForward()) {
            drawable2 = p.c(R.drawable.ia_ib_right_arrow);
        } else {
            drawable2 = p.c(R.drawable.ia_ib_unright_arrow);
        }
        this.a.g.setImageDrawable(drawable2);
    }

    public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
        super.onPageStarted(webView, str, bitmap);
        this.a.g.setImageDrawable(p.c(R.drawable.ia_ib_unright_arrow));
    }

    public void onReceivedError(WebView webView, int i, String str, String str2) {
        IAlog.e("Received Error on WebViewClient: Code: %d, Description: %s, failingUrl: %s", Integer.valueOf(i), str, str2);
    }

    public boolean onRenderProcessGone(WebView webView, RenderProcessGoneDetail renderProcessGoneDetail) {
        t.a("WebViewRendererProcessGone", "Web view renderer process has gone. Web view destroyed", (InneractiveAdRequest) null, (e) null);
        InneractiveInternalBrowserActivity inneractiveInternalBrowserActivity = this.a;
        if (inneractiveInternalBrowserActivity.e == webView) {
            inneractiveInternalBrowserActivity.e = null;
        }
        f0.a(webView);
        this.a.finish();
        return true;
    }

    public boolean shouldOverrideUrlLoading(WebView webView, String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        if (u0.a(str)) {
            this.a.e.loadUrl("chrome://crash");
            return true;
        }
        InneractiveInternalBrowserActivity inneractiveInternalBrowserActivity = this.a;
        String str2 = InneractiveInternalBrowserActivity.URL_EXTRA;
        inneractiveInternalBrowserActivity.getClass();
        String str3 = null;
        f fVar = new f(new e(inneractiveInternalBrowserActivity), (p0) null, i.VIDEO_CTA);
        l lVar = new l(false);
        a[] aVarArr = new a[5];
        aVarArr[0] = fVar;
        aVarArr[1] = new com.fyber.inneractive.sdk.click.d();
        aVarArr[2] = new g();
        aVarArr[3] = new j();
        if (!TextUtils.isEmpty(str)) {
            str3 = Uri.parse(str).getScheme();
        }
        aVarArr[4] = new h(str3, false);
        lVar.h.addAll(Arrays.asList(aVarArr));
        lVar.a(inneractiveInternalBrowserActivity.getApplicationContext(), str, new f(inneractiveInternalBrowserActivity), (r) null, false, k.NONE, "");
        return !str.startsWith(ProxyConfig.MATCH_HTTP);
    }
}
