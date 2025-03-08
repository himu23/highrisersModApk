package com.fyber.inneractive.sdk.util;

import android.view.View;
import android.webkit.WebView;

public class f0 {
    public static void a(WebView webView) {
        if (webView != null) {
            u.a((View) webView);
            webView.destroy();
        }
    }
}
