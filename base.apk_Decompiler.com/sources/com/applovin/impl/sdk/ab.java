package com.applovin.impl.sdk;

import android.webkit.RenderProcessGoneDetail;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.applovin.impl.sdk.c.b;
import com.applovin.impl.sdk.r;
import com.applovin.impl.sdk.utils.h;
import com.ironsource.g$$ExternalSyntheticApiModelOutline0;
import java.util.HashMap;
import java.util.Map;

public class ab extends WebViewClient {
    public boolean onRenderProcessGone(WebView webView, RenderProcessGoneDetail renderProcessGoneDetail) {
        HashMap hashMap = new HashMap();
        hashMap.put("top_main_method", "onRenderProcessGone");
        if (h.La()) {
            hashMap.put("source", g$$ExternalSyntheticApiModelOutline0.m(renderProcessGoneDetail) ? "crash" : "non_crash");
            hashMap.put("details", "renderer_priority_at_exit=" + g$$ExternalSyntheticApiModelOutline0.m(renderProcessGoneDetail));
        }
        n.aAC.Cs().a(r.a.WEB_VIEW_ERROR, (Map<String, String>) hashMap, ((Long) n.aAC.a(b.aOj)).longValue());
        x.D("RenderProcessGoneHandlingWebViewClient", "onRenderProcessGone() handled");
        return true;
    }
}
