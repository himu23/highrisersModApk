package com.fyber.inneractive.sdk.measurement;

import android.text.TextUtils;
import android.webkit.RenderProcessGoneDetail;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.fyber.inneractive.sdk.external.InneractiveAdRequest;
import com.fyber.inneractive.sdk.flow.f0;
import com.fyber.inneractive.sdk.network.t;
import com.fyber.inneractive.sdk.response.g;
import com.fyber.inneractive.sdk.util.IAlog;
import com.iab.omid.library.fyber.adsession.AdEvents;
import com.iab.omid.library.fyber.adsession.AdSession;
import com.iab.omid.library.fyber.adsession.VerificationScriptResource;
import com.iab.omid.library.fyber.adsession.media.MediaEvents;
import java.util.ArrayList;
import java.util.List;

public class d {
    public AdSession a;
    public AdEvents b;
    public MediaEvents c;
    public boolean d = false;
    public boolean e = false;
    public f0 f;
    public WebViewClient g = new a();

    public class a extends WebViewClient {
        public a() {
        }

        public void onLoadResource(WebView webView, String str) {
            super.onLoadResource(webView, str);
            IAlog.d("%s Resources to load: %s", "OMVideo", str);
            int i = IAlog.a;
            IAlog.a(1, (Exception) null, "%s %s", "RESOURCES", str);
        }

        public boolean onRenderProcessGone(WebView webView, RenderProcessGoneDetail renderProcessGoneDetail) {
            d.this.a();
            com.fyber.inneractive.sdk.util.f0.a(webView);
            return true;
        }
    }

    public final void a(Throwable th) {
        String simpleName = th.getClass().getSimpleName();
        String format = String.format("%s - %s", new Object[]{"OpenMeasurementNativeVideoTracker", th.getMessage()});
        f0 f0Var = this.f;
        g gVar = null;
        InneractiveAdRequest inneractiveAdRequest = f0Var != null ? f0Var.a : null;
        if (f0Var != null) {
            gVar = (g) f0Var.b;
        }
        t.a(simpleName, format, inneractiveAdRequest, gVar);
    }

    public List<VerificationScriptResource> a(List<f> list) {
        VerificationScriptResource verificationScriptResource;
        ArrayList arrayList = new ArrayList();
        for (f next : list) {
            VerificationScriptResource verificationScriptResource2 = null;
            try {
                if (next.a != null) {
                    if (TextUtils.isEmpty(next.e) || TextUtils.isEmpty(next.d)) {
                        verificationScriptResource = VerificationScriptResource.createVerificationScriptResourceWithoutParameters(next.a);
                    } else {
                        verificationScriptResource = VerificationScriptResource.createVerificationScriptResourceWithParameters(next.e, next.a, next.d);
                    }
                    verificationScriptResource2 = verificationScriptResource;
                }
            } catch (Throwable th) {
                a(th);
            }
            if (verificationScriptResource2 != null) {
                arrayList.add(verificationScriptResource2);
            }
        }
        return arrayList;
    }

    public void a() {
        if (this.a != null) {
            IAlog.a("%s destroy", "OMVideo");
            try {
                this.a.finish();
            } catch (Throwable th) {
                a(th);
            }
        }
        this.b = null;
        this.a = null;
        this.c = null;
    }
}
