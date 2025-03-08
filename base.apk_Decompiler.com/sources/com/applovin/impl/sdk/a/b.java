package com.applovin.impl.sdk.a;

import android.view.View;
import android.webkit.WebView;
import com.applovin.impl.sdk.AppLovinAdBase;
import com.applovin.impl.sdk.n;
import com.applovin.impl.sdk.utils.StringUtils;
import com.applovin.impl.sdk.x;
import com.applovin.sdk.AppLovinSdkUtils;
import com.iab.omid.library.applovin.adsession.AdEvents;
import com.iab.omid.library.applovin.adsession.AdSession;
import com.iab.omid.library.applovin.adsession.AdSessionConfiguration;
import com.iab.omid.library.applovin.adsession.AdSessionContext;
import com.iab.omid.library.applovin.adsession.ErrorType;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public abstract class b {
    protected AdSession aIA;
    protected AdEvents aIB;
    protected final AppLovinAdBase aIy;
    protected boolean aIz;
    protected final x logger;
    protected final n sdk;
    protected final String tag;

    /* access modifiers changed from: protected */
    public abstract AdSessionConfiguration II();

    /* access modifiers changed from: protected */
    public void a(AdSession adSession) {
    }

    /* access modifiers changed from: protected */
    public abstract AdSessionContext h(WebView webView);

    public b(AppLovinAdBase appLovinAdBase) {
        this.aIy = appLovinAdBase;
        this.sdk = appLovinAdBase.getSdk();
        this.logger = appLovinAdBase.getSdk().BN();
        String str = "AdEventTracker:" + appLovinAdBase.getAdIdNumber();
        if (StringUtils.isValidString(appLovinAdBase.getDspName())) {
            str = str + ":" + appLovinAdBase.getDspName();
        }
        this.tag = str;
    }

    public void IJ() {
        i((WebView) null);
    }

    public void i(WebView webView) {
        AppLovinSdkUtils.runOnUiThread(new b$$ExternalSyntheticLambda0(this, webView));
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void j(WebView webView) {
        AdSessionContext h;
        if (!this.aIy.isOpenMeasurementEnabled()) {
            if (x.Fn()) {
                this.logger.g(this.tag, "Skip starting session - Open Measurement disabled");
            }
        } else if (this.aIA == null) {
            if (x.Fn()) {
                this.logger.f(this.tag, "Starting session");
            }
            AdSessionConfiguration II = II();
            if (II != null && (h = h(webView)) != null) {
                try {
                    AdSession createAdSession = AdSession.createAdSession(II, h);
                    this.aIA = createAdSession;
                    try {
                        this.aIB = AdEvents.createAdEvents(createAdSession);
                        a(this.aIA);
                        this.aIA.start();
                        this.aIz = true;
                        if (x.Fn()) {
                            this.logger.f(this.tag, "Session started");
                        }
                    } catch (Throwable th) {
                        if (x.Fn()) {
                            this.logger.c(this.tag, "Failed to create ad events", th);
                        }
                    }
                } catch (Throwable th2) {
                    if (x.Fn()) {
                        this.logger.c(this.tag, "Failed to create session", th2);
                    }
                }
            }
        } else if (x.Fn()) {
            x xVar = this.logger;
            String str = this.tag;
            xVar.h(str, "Attempting to start session again for ad: " + this.aIy);
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void IP() {
        this.aIB.loaded();
    }

    public void IK() {
        b("track loaded", (Runnable) new b$$ExternalSyntheticLambda4(this));
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void IO() {
        this.aIB.impressionOccurred();
    }

    public void IL() {
        b("track impression event", (Runnable) new b$$ExternalSyntheticLambda1(this));
    }

    public void x(View view) {
        a(view, Collections.emptyList());
    }

    public void a(View view, List<d> list) {
        b("update main view: " + view, (Runnable) new b$$ExternalSyntheticLambda2(this, view, list));
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void b(View view, List list) {
        this.aIA.registerAdView(view);
        this.aIA.removeAllFriendlyObstructions();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            d dVar = (d) it.next();
            if (dVar.IQ() != null) {
                try {
                    this.aIA.addFriendlyObstruction(dVar.IQ(), dVar.IR(), dVar.IS());
                } catch (Throwable th) {
                    if (x.Fn()) {
                        x xVar = this.logger;
                        String str = this.tag;
                        xVar.c(str, "Failed to add friendly obstruction (" + dVar + ")", th);
                    }
                }
            }
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void dk(String str) {
        this.aIA.error(ErrorType.VIDEO, str);
    }

    public void dj(String str) {
        b("track error", (Runnable) new b$$ExternalSyntheticLambda3(this, str));
    }

    public void IM() {
        b("stop session", (Runnable) new b$$ExternalSyntheticLambda6(this));
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void IN() {
        this.aIz = false;
        this.aIA.finish();
        this.aIA = null;
        this.aIB = null;
    }

    /* access modifiers changed from: protected */
    public void b(String str, Runnable runnable) {
        AppLovinSdkUtils.runOnUiThread(new b$$ExternalSyntheticLambda5(this, str, runnable));
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void d(String str, Runnable runnable) {
        try {
            if (this.aIz) {
                if (x.Fn()) {
                    x xVar = this.logger;
                    String str2 = this.tag;
                    xVar.f(str2, "Running operation: " + str);
                }
                runnable.run();
            }
        } catch (Throwable th) {
            if (x.Fn()) {
                x xVar2 = this.logger;
                String str3 = this.tag;
                xVar2.c(str3, "Failed to run operation: " + str, th);
            }
        }
    }
}
