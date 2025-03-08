package com.fyber.inneractive.sdk.config;

import android.content.Context;
import android.webkit.WebView;
import com.fyber.inneractive.sdk.util.q;
import com.ironsource.z3;
import java.util.concurrent.TimeUnit;

public class r implements Runnable {
    public final /* synthetic */ String a;
    public final /* synthetic */ String b;

    public r(String str, String str2) {
        this.a = str;
        this.b = str2;
    }

    public void run() {
        Context context;
        IAConfigManager iAConfigManager = IAConfigManager.M;
        if (iAConfigManager.K == null && (context = iAConfigManager.f) != null) {
            iAConfigManager.K = iAConfigManager.a(context);
        }
        WebView webView = iAConfigManager.K;
        String str = this.a;
        String str2 = this.b;
        if (webView != null) {
            if (str2 == null) {
                str2 = "";
            }
            webView.loadDataWithBaseURL(str, str2, "text/html", z3.L, (String) null);
        }
        q.b.postDelayed(IAConfigManager.O, TimeUnit.SECONDS.toMillis(10));
    }
}
