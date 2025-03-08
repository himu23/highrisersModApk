package com.applovin.impl.adview;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.net.Uri;
import android.os.Bundle;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.RelativeLayout;
import com.applovin.adview.AppLovinAdView;
import com.applovin.adview.AppLovinAdViewDisplayErrorCode;
import com.applovin.adview.AppLovinAdViewEventListener;
import com.applovin.adview.AppLovinFullscreenActivity;
import com.applovin.communicator.AppLovinCommunicator;
import com.applovin.communicator.AppLovinCommunicatorMessage;
import com.applovin.communicator.AppLovinCommunicatorSubscriber;
import com.applovin.impl.adview.v;
import com.applovin.impl.sdk.AppLovinAdServiceImpl;
import com.applovin.impl.sdk.ad.e;
import com.applovin.impl.sdk.ad.h;
import com.applovin.impl.sdk.d.d;
import com.applovin.impl.sdk.d.f;
import com.applovin.impl.sdk.e.ab;
import com.applovin.impl.sdk.e.q;
import com.applovin.impl.sdk.n;
import com.applovin.impl.sdk.utils.m;
import com.applovin.impl.sdk.utils.u;
import com.applovin.impl.sdk.utils.v;
import com.applovin.impl.sdk.x;
import com.applovin.sdk.AppLovinAd;
import com.applovin.sdk.AppLovinAdClickListener;
import com.applovin.sdk.AppLovinAdDisplayListener;
import com.applovin.sdk.AppLovinAdLoadListener;
import com.applovin.sdk.AppLovinAdSize;
import com.applovin.sdk.AppLovinSdk;
import com.applovin.sdk.AppLovinSdkUtils;
import com.iab.omid.library.applovin.adsession.FriendlyObstructionPurpose;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

public class b implements AppLovinCommunicatorSubscriber {
    private volatile AppLovinAdDisplayListener agA;
    /* access modifiers changed from: private */
    public volatile AppLovinAdViewEventListener agB;
    private volatile AppLovinAdClickListener agC;
    private volatile g agD = null;
    /* access modifiers changed from: private */
    public Context agc;
    private ViewGroup agd;
    private AppLovinAdServiceImpl age;
    private AppLovinCommunicator agf;
    /* access modifiers changed from: private */
    public final Map<String, Object> agg = Collections.synchronizedMap(new HashMap());
    private AppLovinAdSize agh;
    private String agi;
    /* access modifiers changed from: private */
    public d agj;
    private e agk;
    private c agl;
    /* access modifiers changed from: private */
    public d agm;
    /* access modifiers changed from: private */
    public v agn;
    private Runnable ago;
    private Runnable agp;
    /* access modifiers changed from: private */
    public volatile e agq = null;
    private volatile AppLovinAd agr = null;
    private m ags = null;
    private m agt = null;
    private final AtomicReference<AppLovinAd> agu = new AtomicReference<>();
    private final AtomicBoolean agv = new AtomicBoolean();
    private volatile boolean agw = false;
    /* access modifiers changed from: private */
    public volatile boolean agx = false;
    private volatile boolean agy = false;
    private volatile AppLovinAdLoadListener agz;
    /* access modifiers changed from: private */
    public x logger;
    /* access modifiers changed from: private */
    public n sdk;

    public void a(g gVar) {
        this.agD = gVar;
    }

    public String getCommunicatorId() {
        return "b";
    }

    public e getCurrentAd() {
        return this.agq;
    }

    public n getSdk() {
        return this.sdk;
    }

    public AppLovinAdSize getSize() {
        return this.agh;
    }

    public String getZoneId() {
        return this.agi;
    }

    public void pause() {
        if (this.agw && !this.agx) {
            this.agx = true;
        }
    }

    public AppLovinAdViewEventListener qQ() {
        return this.agB;
    }

    public g qR() {
        return this.agD;
    }

    public void qV() {
        this.agy = true;
    }

    public void qW() {
        this.agy = false;
    }

    public d qZ() {
        return this.agm;
    }

    public void setAdClickListener(AppLovinAdClickListener appLovinAdClickListener) {
        this.agC = appLovinAdClickListener;
    }

    public void setAdDisplayListener(AppLovinAdDisplayListener appLovinAdDisplayListener) {
        this.agA = appLovinAdDisplayListener;
    }

    public void setAdLoadListener(AppLovinAdLoadListener appLovinAdLoadListener) {
        this.agz = appLovinAdLoadListener;
    }

    public void setAdViewEventListener(AppLovinAdViewEventListener appLovinAdViewEventListener) {
        this.agB = appLovinAdViewEventListener;
    }

    private void a(AppLovinAdView appLovinAdView, n nVar, AppLovinAdSize appLovinAdSize, String str, Context context) {
        if (appLovinAdView == null) {
            throw new IllegalArgumentException("No parent view specified");
        } else if (nVar == null) {
            throw new IllegalArgumentException("No sdk specified");
        } else if (appLovinAdSize != null) {
            this.sdk = nVar;
            this.age = nVar.BD();
            this.logger = nVar.BN();
            this.agf = AppLovinCommunicator.getInstance(context);
            this.agh = appLovinAdSize;
            this.agi = str;
            if (!(context instanceof AppLovinFullscreenActivity)) {
                context = context.getApplicationContext();
            }
            this.agc = context;
            this.agd = appLovinAdView;
            this.agk = new e(this, nVar);
            this.agp = new a();
            this.ago = new C0063b();
            this.agl = new c(this, nVar);
            a(appLovinAdSize);
        } else {
            throw new IllegalArgumentException("No ad size specified");
        }
    }

    /* access modifiers changed from: protected */
    public void a(AppLovinAdSize appLovinAdSize) {
        try {
            d dVar = new d(this.agk, this.sdk, this.agc);
            this.agm = dVar;
            dVar.setBackgroundColor(0);
            this.agm.setWillNotCacheDrawing(false);
            this.agd.setBackgroundColor(0);
            this.agd.addView(this.agm);
            a((View) this.agm, appLovinAdSize);
            if (!this.agw) {
                runOnUiThread(this.agp);
            }
            runOnUiThread(new b$$ExternalSyntheticLambda4(this));
            this.agw = true;
        } catch (Throwable th) {
            x.e("AppLovinAdView", "Failed to initialize AdWebView", th);
            this.sdk.Cs().d("AppLovinAdView", "initAdWebView", th);
            this.agv.set(true);
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void ri() {
        this.agm.loadDataWithBaseURL("/", "<html></html>", "text/html", (String) null, "");
    }

    /* access modifiers changed from: private */
    public static void a(View view, AppLovinAdSize appLovinAdSize) {
        int i;
        if (view != null) {
            DisplayMetrics displayMetrics = view.getResources().getDisplayMetrics();
            int i2 = -1;
            if (appLovinAdSize.getLabel().equals(AppLovinAdSize.INTERSTITIAL.getLabel())) {
                i = -1;
            } else if (appLovinAdSize.getWidth() == -1) {
                i = displayMetrics.widthPixels;
            } else {
                i = (int) TypedValue.applyDimension(1, (float) appLovinAdSize.getWidth(), displayMetrics);
            }
            if (!appLovinAdSize.getLabel().equals(AppLovinAdSize.INTERSTITIAL.getLabel())) {
                if (appLovinAdSize.getHeight() == -1) {
                    i2 = displayMetrics.heightPixels;
                } else {
                    i2 = (int) TypedValue.applyDimension(1, (float) appLovinAdSize.getHeight(), displayMetrics);
                }
            }
            ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
            if (layoutParams == null) {
                layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            }
            layoutParams.width = i;
            layoutParams.height = i2;
            if (layoutParams instanceof RelativeLayout.LayoutParams) {
                ((RelativeLayout.LayoutParams) layoutParams).addRule(13);
            }
            view.setLayoutParams(layoutParams);
        }
    }

    public void a(AppLovinAdView appLovinAdView, Context context, AppLovinAdSize appLovinAdSize, String str, AppLovinSdk appLovinSdk, AttributeSet attributeSet) {
        if (appLovinAdView == null) {
            throw new IllegalArgumentException("No parent view specified");
        } else if (context == null) {
            x.H("AppLovinAdView", "Unable to build AppLovinAdView: no context provided. Please use a different constructor for this view.");
        } else {
            if (appLovinAdSize == null && (appLovinAdSize = com.applovin.impl.sdk.utils.c.a(attributeSet)) == null) {
                appLovinAdSize = AppLovinAdSize.BANNER;
            }
            AppLovinAdSize appLovinAdSize2 = appLovinAdSize;
            if (appLovinSdk == null) {
                appLovinSdk = AppLovinSdk.getInstance(context);
            }
            if (appLovinSdk != null) {
                a(appLovinAdView, appLovinSdk.a(), appLovinAdSize2, str, context);
                if (com.applovin.impl.sdk.utils.c.b(attributeSet)) {
                    loadNextAd();
                }
            }
        }
    }

    public void loadNextAd() {
        if (this.sdk == null || this.agl == null || this.agc == null || !this.agw) {
            x.E("AppLovinAdView", "Unable to load next ad: AppLovinAdView is not initialized.");
        } else {
            this.age.loadNextAd(this.agi, this.agh, this.agl);
        }
    }

    public void resume() {
        if (this.agw) {
            AppLovinAd andSet = this.agu.getAndSet((Object) null);
            if (andSet != null) {
                renderAd(andSet);
            }
            this.agx = false;
        }
    }

    public void destroy() {
        runOnUiThread(new b$$ExternalSyntheticLambda3(this));
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void rh() {
        if (!(this.agm == null || this.ags == null)) {
            qT();
        }
        qP();
    }

    private void qP() {
        if (this.logger != null && x.Fn() && x.Fn()) {
            this.logger.f("AppLovinAdView", "Destroying...");
        }
        com.applovin.impl.sdk.utils.x.k(this.agm);
        this.agm = null;
        this.agz = null;
        this.agA = null;
        this.agC = null;
        this.agB = null;
        this.agx = true;
    }

    public void setExtraInfo(String str, Object obj) {
        this.agg.put(str, obj);
    }

    private void qS() {
        runOnUiThread(new b$$ExternalSyntheticLambda0(this));
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void rg() {
        if (this.ags != null) {
            if (x.Fn()) {
                x xVar = this.logger;
                xVar.f("AppLovinAdView", "Detaching expanded ad: " + this.ags.rI());
            }
            this.agt = this.ags;
            this.ags = null;
            a(this.agh);
        }
    }

    public void onAttachedToWindow() {
        if (com.applovin.impl.sdk.utils.c.z(this.agm)) {
            this.sdk.BR().a(f.aTg);
        }
    }

    public void onDetachedFromWindow() {
        if (this.agw) {
            m.b(this.agA, (AppLovinAd) this.agq);
            if (this.agq != null && this.agq.isOpenMeasurementEnabled() && u.c(this.agq.getSize())) {
                this.agq.getAdEventTracker().IM();
            }
            if (this.agm != null && this.ags != null) {
                if (x.Fn()) {
                    this.logger.f("AppLovinAdView", "onDetachedFromWindowCalled with expanded ad present");
                }
                qS();
            } else if (x.Fn()) {
                this.logger.f("AppLovinAdView", "onDetachedFromWindowCalled without an expanded ad present");
            }
        }
    }

    public void renderAd(AppLovinAd appLovinAd) {
        a(appLovinAd, (String) null);
    }

    public void a(AppLovinAd appLovinAd, String str) {
        if (appLovinAd != null) {
            u.b(appLovinAd, this.sdk);
            if (this.agw) {
                e eVar = (e) u.a(appLovinAd, this.sdk);
                if (eVar == null) {
                    x.H("AppLovinAdView", "Unable to retrieve the loaded ad: " + appLovinAd);
                    m.a(this.agA, "Unable to retrieve the loaded ad");
                } else if (eVar == this.agq) {
                    x.H("AppLovinAdView", "Attempting to show ad again: " + eVar);
                    if (!((Boolean) this.sdk.a(com.applovin.impl.sdk.c.b.aMJ)).booleanValue()) {
                        return;
                    }
                    if (this.agA instanceof h) {
                        m.a(this.agA, "Attempting to show ad again");
                        return;
                    }
                    throw new IllegalStateException("Attempting to show ad again");
                } else {
                    if (x.Fn()) {
                        x xVar = this.logger;
                        xVar.f("AppLovinAdView", "Rendering ad #" + eVar.getAdIdNumber() + " (" + eVar.getSize() + ")");
                    }
                    m.b(this.agA, (AppLovinAd) this.agq);
                    if (eVar.getSize() != AppLovinAdSize.INTERSTITIAL) {
                        rb();
                    }
                    if (this.agq != null && this.agq.isOpenMeasurementEnabled()) {
                        this.agq.getAdEventTracker().IM();
                    }
                    this.agu.set((Object) null);
                    this.agr = null;
                    this.agq = eVar;
                    if (!this.agx && u.c(this.agh)) {
                        this.sdk.BD().trackImpression(eVar);
                    }
                    if (this.ags != null) {
                        qS();
                    }
                    runOnUiThread(this.ago);
                }
            } else {
                x.E("AppLovinAdView", "Unable to render ad: AppLovinAdView is not initialized.");
            }
        } else {
            throw new IllegalArgumentException("No ad specified");
        }
    }

    public void b(WebView webView) {
        d(webView, (String) null);
    }

    public void d(WebView webView, String str) {
        if (this.agq != null) {
            runOnUiThread(new b$$ExternalSyntheticLambda7(webView));
            if (!((Boolean) this.sdk.a(com.applovin.impl.sdk.c.b.aQS)).booleanValue() || (str != null && str.startsWith(this.agq.Hn()))) {
                try {
                    if (this.agq != this.agr) {
                        this.agr = this.agq;
                        this.agm.setAdHtmlLoaded(true);
                        if (this.agA != null) {
                            this.sdk.Co().V(this.agq);
                            m.a(this.agA, (AppLovinAd) this.agq);
                            this.agm.bq("javascript:al_onAdViewRendered();");
                        }
                        if (u.c(this.agh) && this.agq.isOpenMeasurementEnabled()) {
                            this.sdk.BO().a((com.applovin.impl.sdk.e.d) new ab(this.sdk, "StartOMSDK", new b$$ExternalSyntheticLambda8(this, webView)), q.b.MAIN, 500);
                        }
                    }
                } catch (Throwable th) {
                    x.e("AppLovinAdView", "Exception while notifying ad display listener", th);
                    n nVar = this.sdk;
                    if (nVar != null) {
                        nVar.Cs().d("AppLovinAdView", "onAdHtmlLoaded", th);
                    }
                }
            }
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void c(WebView webView) {
        this.agq.getAdEventTracker().i(webView);
        v vVar = this.agn;
        if (vVar == null || !vVar.sh()) {
            this.agq.getAdEventTracker().x(webView);
        } else {
            this.agq.getAdEventTracker().a(webView, Collections.singletonList(new com.applovin.impl.sdk.a.d(this.agn, FriendlyObstructionPurpose.NOT_VISIBLE, this.agn.getIdentifier())));
        }
        this.agq.getAdEventTracker().IK();
        this.agq.getAdEventTracker().IL();
    }

    public void b(MotionEvent motionEvent) {
        runOnUiThread(new b$$ExternalSyntheticLambda1(this, motionEvent));
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void c(MotionEvent motionEvent) {
        if (this.ags == null && (this.agq instanceof com.applovin.impl.sdk.ad.a) && this.agm != null) {
            com.applovin.impl.sdk.ad.a aVar = (com.applovin.impl.sdk.ad.a) this.agq;
            Context context = this.agc;
            Activity a2 = context instanceof Activity ? (Activity) context : u.a((View) this.agm, this.sdk);
            if (a2 == null || a2.isFinishing()) {
                x.H("AppLovinAdView", "Unable to expand ad. No Activity found.");
                Uri FK = aVar.FK();
                if (FK != null) {
                    this.age.trackAndLaunchClick(aVar, qY(), this, FK, motionEvent, this.agy, (Bundle) null);
                    d dVar = this.agj;
                    if (dVar != null) {
                        dVar.JN();
                    }
                }
                this.agm.bq("javascript:al_onFailedExpand();");
                return;
            }
            ViewGroup viewGroup = this.agd;
            if (viewGroup != null) {
                viewGroup.removeView(this.agm);
            }
            m mVar = new m(aVar, this.agm, a2, this.sdk);
            this.ags = mVar;
            mVar.setOnDismissListener(new b$$ExternalSyntheticLambda9(this));
            this.ags.show();
            m.a(this.agB, (AppLovinAd) this.agq, (AppLovinAdView) this.agd);
            d dVar2 = this.agj;
            if (dVar2 != null) {
                dVar2.JO();
            }
            if (this.agq.isOpenMeasurementEnabled()) {
                this.agq.getAdEventTracker().x(this.ags.rJ());
            }
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void a(DialogInterface dialogInterface) {
        qT();
    }

    public void qT() {
        runOnUiThread(new b$$ExternalSyntheticLambda6(this));
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void rf() {
        d dVar;
        ra();
        if (this.agd != null && (dVar = this.agm) != null && dVar.getParent() == null) {
            this.agd.addView(this.agm);
            a((View) this.agm, this.agq.getSize());
            if (this.agq.isOpenMeasurementEnabled()) {
                this.agq.getAdEventTracker().x(this.agm);
            }
        }
    }

    public void qU() {
        if (this.ags == null && this.agt == null) {
            if (x.Fn()) {
                x xVar = this.logger;
                xVar.f("AppLovinAdView", "Ad: " + this.agq + " closed.");
            }
            runOnUiThread(this.agp);
            m.b(this.agA, (AppLovinAd) this.agq);
            this.agq = null;
            return;
        }
        qT();
    }

    /* access modifiers changed from: package-private */
    public void a(e eVar, AppLovinAdView appLovinAdView, Uri uri, MotionEvent motionEvent, Bundle bundle) {
        if (appLovinAdView != null) {
            this.age.trackAndLaunchClick(eVar, appLovinAdView, this, uri, motionEvent, this.agy, bundle);
        } else if (x.Fn()) {
            this.logger.i("AppLovinAdView", "Unable to process ad click - AppLovinAdView destroyed prematurely");
        }
        m.a(this.agC, (AppLovinAd) eVar);
    }

    /* access modifiers changed from: package-private */
    public void a(AppLovinAd appLovinAd) {
        if (appLovinAd != null) {
            if (!this.agx) {
                renderAd(appLovinAd);
            } else {
                this.agu.set(appLovinAd);
                if (x.Fn()) {
                    this.logger.f("AppLovinAdView", "Ad view has paused when an ad was received, ad saved for later");
                }
            }
            runOnUiThread(new b$$ExternalSyntheticLambda5(this, appLovinAd));
            return;
        }
        if (x.Fn()) {
            this.logger.i("AppLovinAdView", "No provided when to the view controller");
        }
        fW(-1);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void b(AppLovinAd appLovinAd) {
        if (this.agv.compareAndSet(true, false)) {
            a(this.agh);
        }
        try {
            if (this.agz != null) {
                this.agz.adReceived(appLovinAd);
            }
        } catch (Throwable th) {
            x.H("AppLovinAdView", "Exception while running ad load callback: " + th.getMessage());
            n nVar = this.sdk;
            if (nVar != null) {
                nVar.Cs().d("AppLovinAdView", "notifyAdLoaded", th);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void fW(int i) {
        if (!this.agx) {
            runOnUiThread(this.agp);
        }
        runOnUiThread(new b$$ExternalSyntheticLambda2(this, i));
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void fX(int i) {
        try {
            if (this.agz != null) {
                this.agz.failedToReceiveAd(i);
            }
        } catch (Throwable th) {
            x.e("AppLovinAdView", "Exception while running app load callback", th);
            n nVar = this.sdk;
            if (nVar != null) {
                nVar.Cs().d("AppLovinAdView", "notifyAdLoadFailed", th);
            }
        }
    }

    private void runOnUiThread(Runnable runnable) {
        AppLovinSdkUtils.runOnUiThread(runnable);
    }

    public void qX() {
        if ((this.agc instanceof l) && this.agq != null && this.agq.Gv() == e.a.DISMISS) {
            ((l) this.agc).dismiss();
        }
    }

    public AppLovinAdView qY() {
        return (AppLovinAdView) this.agd;
    }

    public void setStatsManagerHelper(d dVar) {
        d dVar2 = this.agm;
        if (dVar2 != null) {
            dVar2.setStatsManagerHelper(dVar);
        }
    }

    private void ra() {
        runOnUiThread(new b$$ExternalSyntheticLambda10(this));
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void re() {
        com.applovin.impl.sdk.ad.a aVar;
        m mVar = this.agt;
        if (mVar != null || this.ags != null) {
            if (mVar != null) {
                aVar = mVar.rI();
                this.agt.dismiss();
                this.agt = null;
            } else {
                aVar = this.ags.rI();
                this.ags.dismiss();
                this.ags = null;
            }
            m.b(this.agB, (AppLovinAd) aVar, (AppLovinAdView) this.agd);
        }
    }

    private void rb() {
        d dVar = this.agj;
        if (dVar != null) {
            dVar.rb();
            this.agj = null;
        }
    }

    /* access modifiers changed from: private */
    public void rc() {
        e eVar = this.agq;
        com.applovin.impl.sdk.utils.n nVar = new com.applovin.impl.sdk.utils.n();
        nVar.Lo().g(eVar).a(qY());
        if (!u.c(eVar.getSize())) {
            nVar.Lo().dz("Fullscreen Ad Properties").h(eVar);
        }
        nVar.L(this.sdk);
        nVar.Lo();
        if (x.Fn()) {
            this.logger.f("AppLovinAdView", nVar.toString());
        }
    }

    public void onMessageReceived(AppLovinCommunicatorMessage appLovinCommunicatorMessage) {
        if ("crash_applovin_ad_webview".equals(appLovinCommunicatorMessage.getTopic())) {
            runOnUiThread(new b$$ExternalSyntheticLambda11(this));
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void rd() {
        qZ().loadUrl("chrome://crash");
    }

    static class c implements AppLovinAdLoadListener {
        private final b agG;

        private b rk() {
            return this.agG;
        }

        c(b bVar, n nVar) {
            if (bVar == null) {
                throw new IllegalArgumentException("No view specified");
            } else if (nVar != null) {
                this.agG = bVar;
            } else {
                throw new IllegalArgumentException("No sdk specified");
            }
        }

        public void adReceived(AppLovinAd appLovinAd) {
            b rk = rk();
            if (rk != null) {
                rk.a(appLovinAd);
            } else {
                x.H("AppLovinAdView", "Ad view has been garbage collected by the time an ad was received");
            }
        }

        public void failedToReceiveAd(int i) {
            b rk = rk();
            if (rk != null) {
                rk.fW(i);
            }
        }
    }

    /* renamed from: com.applovin.impl.adview.b$b  reason: collision with other inner class name */
    private class C0063b implements Runnable {
        private C0063b() {
        }

        public void run() {
            if (b.this.agq == null) {
                return;
            }
            if (b.this.agm != null) {
                b.this.rc();
                x unused = b.this.logger;
                if (x.Fn()) {
                    x d = b.this.logger;
                    d.f("AppLovinAdView", "Rendering advertisement ad for #" + b.this.agq.getAdIdNumber() + "...");
                }
                b.a((View) b.this.agm, b.this.agq.getSize());
                if (b.this.agn != null) {
                    v.B(b.this.agn);
                    v unused2 = b.this.agn = null;
                }
                p pVar = new p(b.this.agg, b.this.sdk);
                if (pVar.rN()) {
                    v unused3 = b.this.agn = new v(pVar, b.this.agc);
                    b.this.agn.a(new v.a() {
                        public void rj() {
                            b.this.agm.addView(b.this.agn, new ViewGroup.LayoutParams(-1, -1));
                        }

                        public void onFailure() {
                            x unused = b.this.logger;
                            if (x.Fn()) {
                                b.this.logger.i("AppLovinAdView", "Watermark failed to render.");
                            }
                        }
                    });
                }
                b.this.agm.setAdHtmlLoaded(false);
                b.this.agm.a(b.this.agq);
                if (b.this.agq.getSize() != AppLovinAdSize.INTERSTITIAL && !b.this.agx) {
                    b bVar = b.this;
                    d unused4 = bVar.agj = new d(bVar.agq, b.this.sdk);
                    b.this.agj.JM();
                    b.this.agm.setStatsManagerHelper(b.this.agj);
                    b.this.agq.setHasShown(true);
                }
                if (b.this.agm.getStatsManagerHelper() != null) {
                    b.this.agm.getStatsManagerHelper().bS(b.this.agq.Gm() ? 0 : 1);
                    return;
                }
                return;
            }
            x.H("AppLovinAdView", "Unable to render advertisement for ad #" + b.this.agq.getAdIdNumber() + ". Please make sure you are not calling AppLovinAdView.destroy() prematurely.");
            m.a(b.this.agB, (AppLovinAd) b.this.agq, (AppLovinAdView) null, AppLovinAdViewDisplayErrorCode.WEBVIEW_NOT_FOUND);
        }
    }

    private class a implements Runnable {
        private a() {
        }

        public void run() {
            if (b.this.agm != null) {
                b.this.agm.setVisibility(8);
            }
        }
    }
}
