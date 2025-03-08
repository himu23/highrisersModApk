package com.applovin.impl.sdk;

import android.os.Build;
import android.webkit.WebSettings;
import android.webkit.WebView;
import com.applovin.impl.sdk.c.d;
import com.applovin.impl.sdk.c.e;
import com.applovin.impl.sdk.utils.h;
import com.applovin.sdk.AppLovinSdkUtils;
import java.util.concurrent.atomic.AtomicBoolean;

public class af {
    private static WebView aFY;
    private static final Object aFZ = new Object();
    private static final AtomicBoolean aGa = new AtomicBoolean();
    private static String ta;

    public static void z(n nVar) {
    }

    static {
        if (Fz()) {
            ta = (String) e.b(d.aRP, "", n.getApplicationContext());
            return;
        }
        ta = "";
        e.a(d.aRP, null, n.getApplicationContext());
        e.a(d.aRQ, null, n.getApplicationContext());
    }

    public static void A(n nVar) {
        if (!Fz() && !aGa.getAndSet(true)) {
            if (h.KV()) {
                AppLovinSdkUtils.runOnUiThread(new af$$ExternalSyntheticLambda0(nVar));
            } else {
                AppLovinSdkUtils.runOnUiThread(new af$$ExternalSyntheticLambda1(nVar));
            }
        }
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ void C(n nVar) {
        try {
            synchronized (aFZ) {
                ta = WebSettings.getDefaultUserAgent(n.getApplicationContext());
                e.a(d.aRP, ta, n.getApplicationContext());
                e.a(d.aRQ, Build.VERSION.RELEASE, n.getApplicationContext());
            }
        } catch (Throwable th) {
            nVar.BN();
            if (x.Fn()) {
                nVar.BN().c("WebViewDataCollector", "Failed to collect user agent", th);
            }
            nVar.Cs().d("WebViewDataCollector", "collectUserAgent", th);
        }
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ void B(n nVar) {
        try {
            z(nVar);
            synchronized (aFZ) {
                ta = aFY.getSettings().getUserAgentString();
                e.a(d.aRP, ta, n.getApplicationContext());
                e.a(d.aRQ, Build.VERSION.RELEASE, n.getApplicationContext());
            }
        } catch (Throwable th) {
            nVar.BN();
            if (x.Fn()) {
                nVar.BN().c("WebViewDataCollector", "Failed to collect user agent", th);
            }
            nVar.Cs().d("WebViewDataCollector", "collectUserAgent", th);
        }
    }

    public static String Fy() {
        String str;
        synchronized (aFZ) {
            str = ta;
        }
        return str;
    }

    public static boolean Fz() {
        boolean equals;
        synchronized (aFZ) {
            equals = Build.VERSION.RELEASE.equals((String) e.b(d.aRQ, "", n.getApplicationContext()));
        }
        return equals;
    }
}
