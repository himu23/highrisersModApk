package com.applovin.impl.mediation;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.view.View;
import android.view.ViewGroup;
import androidx.lifecycle.Lifecycle;
import com.applovin.impl.mediation.MediationServiceImpl;
import com.applovin.impl.mediation.b.f;
import com.applovin.impl.mediation.b.h;
import com.applovin.impl.sdk.e.q;
import com.applovin.impl.sdk.n;
import com.applovin.impl.sdk.r;
import com.applovin.impl.sdk.x;
import com.applovin.mediation.MaxAd;
import com.applovin.mediation.MaxAdFormat;
import com.applovin.mediation.MaxAdListener;
import com.applovin.mediation.MaxError;
import com.applovin.mediation.MaxReward;
import com.applovin.mediation.adapter.MaxAdViewAdapter;
import com.applovin.mediation.adapter.MaxAdapter;
import com.applovin.mediation.adapter.MaxAdapterError;
import com.applovin.mediation.adapter.MaxAppOpenAdapter;
import com.applovin.mediation.adapter.MaxInterstitialAdViewAdapter;
import com.applovin.mediation.adapter.MaxInterstitialAdapter;
import com.applovin.mediation.adapter.MaxRewardedAdViewAdapter;
import com.applovin.mediation.adapter.MaxRewardedAdapter;
import com.applovin.mediation.adapter.MaxRewardedInterstitialAdapter;
import com.applovin.mediation.adapter.MaxSignalProvider;
import com.applovin.mediation.adapter.listeners.MaxAdViewAdapterListener;
import com.applovin.mediation.adapter.listeners.MaxAppOpenAdapterListener;
import com.applovin.mediation.adapter.listeners.MaxInterstitialAdapterListener;
import com.applovin.mediation.adapter.listeners.MaxNativeAdAdapterListener;
import com.applovin.mediation.adapter.listeners.MaxRewardedAdapterListener;
import com.applovin.mediation.adapter.listeners.MaxRewardedInterstitialAdapterListener;
import com.applovin.mediation.adapter.listeners.MaxSignalCollectionListener;
import com.applovin.mediation.adapter.parameters.MaxAdapterInitializationParameters;
import com.applovin.mediation.adapter.parameters.MaxAdapterResponseParameters;
import com.applovin.mediation.adapter.parameters.MaxAdapterSignalCollectionParameters;
import com.applovin.mediation.adapters.MediationAdapterBase;
import com.applovin.mediation.nativeAds.MaxNativeAd;
import com.applovin.mediation.nativeAds.MaxNativeAdView;
import com.applovin.sdk.AppLovinSdkUtils;
import com.unity3d.services.ads.gmascar.bridges.mobileads.MobileAdsBridgeBase;
import java.util.concurrent.atomic.AtomicBoolean;

public class g {
    /* access modifiers changed from: private */
    public final Handler acG = new Handler(Looper.getMainLooper());
    /* access modifiers changed from: private */
    public String adUnitId;
    /* access modifiers changed from: private */
    public final f ami;
    /* access modifiers changed from: private */
    public final String amj;
    private MaxAdapter amk;
    /* access modifiers changed from: private */
    public com.applovin.impl.mediation.b.a aml;
    /* access modifiers changed from: private */
    public View amm;
    /* access modifiers changed from: private */
    public MaxNativeAd amn;
    private MaxNativeAdView amo;
    private ViewGroup amp;
    /* access modifiers changed from: private */
    public final a amq = new a();
    private MaxAdapterResponseParameters amr;
    private final AtomicBoolean ams = new AtomicBoolean(true);
    /* access modifiers changed from: private */
    public final AtomicBoolean amt = new AtomicBoolean(false);
    /* access modifiers changed from: private */
    public final AtomicBoolean amu = new AtomicBoolean(false);
    private final boolean amv;
    /* access modifiers changed from: private */
    public final x logger;
    private final String name;
    /* access modifiers changed from: private */
    public final n sdk;

    public void a(MaxNativeAdView maxNativeAdView) {
        this.amo = maxNativeAdView;
    }

    /* access modifiers changed from: package-private */
    public void a(String str, com.applovin.impl.mediation.b.a aVar) {
        this.adUnitId = str;
        this.aml = aVar;
    }

    public void b(ViewGroup viewGroup) {
        this.amp = viewGroup;
    }

    public String getName() {
        return this.name;
    }

    public View ub() {
        return this.amm;
    }

    public MaxNativeAd uc() {
        return this.amn;
    }

    public MaxNativeAdView ud() {
        return this.amo;
    }

    public ViewGroup ue() {
        return this.amp;
    }

    g(f fVar, MaxAdapter maxAdapter, boolean z, n nVar) {
        if (fVar == null) {
            throw new IllegalArgumentException("No adapter name specified");
        } else if (maxAdapter == null) {
            throw new IllegalArgumentException("No adapter specified");
        } else if (nVar != null) {
            this.name = fVar.yA();
            this.amk = maxAdapter;
            this.sdk = nVar;
            this.logger = nVar.BN();
            this.ami = fVar;
            this.amj = maxAdapter.getClass().getSimpleName();
            this.amv = z;
        } else {
            throw new IllegalArgumentException("No sdk specified");
        }
    }

    /* access modifiers changed from: package-private */
    public void a(MaxAdapterInitializationParameters maxAdapterInitializationParameters, Activity activity, Runnable runnable) {
        b(MobileAdsBridgeBase.initializeMethodName, (Runnable) new g$$ExternalSyntheticLambda18(this, runnable, maxAdapterInitializationParameters, activity));
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void a(Runnable runnable, MaxAdapterInitializationParameters maxAdapterInitializationParameters, Activity activity) {
        long elapsedRealtime = SystemClock.elapsedRealtime();
        if (x.Fn()) {
            x xVar = this.logger;
            xVar.f("MediationAdapterWrapper", "Initializing " + this.amj + " on thread: " + Thread.currentThread() + " with 'run_on_ui_thread' value: " + this.ami.yC());
        }
        this.amk.initialize(maxAdapterInitializationParameters, activity, new b(this.sdk, this.ami, elapsedRealtime, runnable));
    }

    public MediationServiceImpl.a uf() {
        return this.amq.amy;
    }

    public void a(String str, MaxAdapterResponseParameters maxAdapterResponseParameters, com.applovin.impl.mediation.b.a aVar, Activity activity, MediationServiceImpl.a aVar2) {
        Runnable runnable;
        if (aVar == null) {
            throw new IllegalArgumentException("No mediated ad specified");
        } else if (!this.ams.get()) {
            String str2 = "Mediation adapter '" + this.amj + "' was disabled due to earlier failures. Loading ads with this adapter is disabled.";
            x.H("MediationAdapterWrapper", str2);
            aVar2.onAdLoadFailed(str, new MaxErrorImpl(-1, str2));
        } else {
            this.amr = maxAdapterResponseParameters;
            this.amq.a(aVar2);
            MaxAdFormat xE = aVar.xF() ? aVar.xE() : aVar.getFormat();
            if (xE == MaxAdFormat.INTERSTITIAL) {
                runnable = new g$$ExternalSyntheticLambda3(this, maxAdapterResponseParameters, activity);
            } else if (xE == MaxAdFormat.APP_OPEN) {
                runnable = new g$$ExternalSyntheticLambda4(this, maxAdapterResponseParameters, activity);
            } else if (xE == MaxAdFormat.REWARDED) {
                runnable = new g$$ExternalSyntheticLambda5(this, maxAdapterResponseParameters, activity);
            } else if (xE == MaxAdFormat.REWARDED_INTERSTITIAL) {
                runnable = new g$$ExternalSyntheticLambda6(this, maxAdapterResponseParameters, activity);
            } else if (xE == MaxAdFormat.NATIVE) {
                runnable = new g$$ExternalSyntheticLambda7(this, maxAdapterResponseParameters, activity);
            } else if (xE.isAdViewAd()) {
                runnable = new g$$ExternalSyntheticLambda8(this, maxAdapterResponseParameters, xE, activity);
            } else {
                throw new IllegalStateException("Failed to load " + aVar + ": " + aVar.getFormat() + " (" + aVar.xE() + ") is not a supported ad format");
            }
            a("load_ad", xE, (Runnable) new g$$ExternalSyntheticLambda9(this, runnable, aVar));
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void e(MaxAdapterResponseParameters maxAdapterResponseParameters, Activity activity) {
        ((MaxInterstitialAdapter) this.amk).loadInterstitialAd(maxAdapterResponseParameters, activity, this.amq);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void d(MaxAdapterResponseParameters maxAdapterResponseParameters, Activity activity) {
        ((MaxAppOpenAdapter) this.amk).loadAppOpenAd(maxAdapterResponseParameters, activity, this.amq);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void c(MaxAdapterResponseParameters maxAdapterResponseParameters, Activity activity) {
        ((MaxRewardedAdapter) this.amk).loadRewardedAd(maxAdapterResponseParameters, activity, this.amq);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void b(MaxAdapterResponseParameters maxAdapterResponseParameters, Activity activity) {
        ((MaxRewardedInterstitialAdapter) this.amk).loadRewardedInterstitialAd(maxAdapterResponseParameters, activity, this.amq);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void a(MaxAdapterResponseParameters maxAdapterResponseParameters, Activity activity) {
        ((MediationAdapterBase) this.amk).loadNativeAd(maxAdapterResponseParameters, activity, this.amq);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void a(MaxAdapterResponseParameters maxAdapterResponseParameters, MaxAdFormat maxAdFormat, Activity activity) {
        ((MaxAdViewAdapter) this.amk).loadAdViewAd(maxAdapterResponseParameters, maxAdFormat, activity, this.amq);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void b(Runnable runnable, com.applovin.impl.mediation.b.a aVar) {
        try {
            runnable.run();
        } catch (Throwable th) {
            String str = "Failed to start loading ad for " + this.name + " due to: " + th;
            x.H("MediationAdapterWrapper", str);
            this.amq.a("load_ad", (MaxError) new MaxErrorImpl(-1, str));
            this.sdk.Cs().d("MediationAdapterWrapper", "load_ad:" + this.ami.vt(), th);
            bC("load_ad");
            this.sdk.Cw().a(this.ami.vt(), "load_ad", this.aml);
        }
        if (!this.amt.get()) {
            long yE = this.ami.yE();
            if (yE > 0) {
                if (x.Fn()) {
                    this.logger.f("MediationAdapterWrapper", "Setting timeout " + yE + "ms. for " + aVar);
                }
                this.sdk.BO().a((com.applovin.impl.sdk.e.d) new d(), q.b.MEDIATION_TIMEOUT, yE);
            } else if (x.Fn()) {
                this.logger.f("MediationAdapterWrapper", "Negative timeout set for " + aVar + ", not scheduling a timeout");
            }
        }
    }

    public void a(com.applovin.impl.mediation.b.a aVar, Activity activity) {
        Runnable runnable;
        if (b(aVar, activity)) {
            if (aVar.xF()) {
                runnable = new g$$ExternalSyntheticLambda11(this, aVar, activity);
            } else if (aVar.getFormat() == MaxAdFormat.INTERSTITIAL) {
                runnable = new g$$ExternalSyntheticLambda12(this, activity);
            } else if (aVar.getFormat() == MaxAdFormat.APP_OPEN) {
                runnable = new g$$ExternalSyntheticLambda13(this, activity);
            } else if (aVar.getFormat() == MaxAdFormat.REWARDED) {
                runnable = new g$$ExternalSyntheticLambda14(this, activity);
            } else if (aVar.getFormat() == MaxAdFormat.REWARDED_INTERSTITIAL) {
                runnable = new g$$ExternalSyntheticLambda15(this, activity);
            } else {
                throw new IllegalStateException("Failed to show " + aVar + ": " + aVar.getFormat() + " is not a supported ad format");
            }
            a(runnable, aVar);
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void c(com.applovin.impl.mediation.b.a aVar, Activity activity) {
        this.sdk.Cz().a((com.applovin.impl.mediation.b.c) aVar, activity, this.amq);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void f(Activity activity) {
        ((MaxInterstitialAdapter) this.amk).showInterstitialAd(this.amr, activity, this.amq);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void e(Activity activity) {
        ((MaxAppOpenAdapter) this.amk).showAppOpenAd(this.amr, activity, this.amq);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void d(Activity activity) {
        ((MaxRewardedAdapter) this.amk).showRewardedAd(this.amr, activity, this.amq);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void c(Activity activity) {
        ((MaxRewardedInterstitialAdapter) this.amk).showRewardedInterstitialAd(this.amr, activity, this.amq);
    }

    public void a(com.applovin.impl.mediation.b.a aVar, ViewGroup viewGroup, Lifecycle lifecycle, Activity activity) {
        Runnable runnable;
        if (b(aVar, activity)) {
            if (aVar.getFormat() == MaxAdFormat.INTERSTITIAL) {
                runnable = new g$$ExternalSyntheticLambda16(this, viewGroup, lifecycle, activity);
            } else if (aVar.getFormat() == MaxAdFormat.REWARDED) {
                runnable = new g$$ExternalSyntheticLambda17(this, viewGroup, lifecycle, activity);
            } else {
                throw new IllegalStateException("Failed to show " + aVar + ": " + aVar.getFormat() + " is not a supported ad format");
            }
            a(runnable, aVar);
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void b(ViewGroup viewGroup, Lifecycle lifecycle, Activity activity) {
        ((MaxInterstitialAdViewAdapter) this.amk).showInterstitialAd(this.amr, viewGroup, lifecycle, activity, this.amq);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void a(ViewGroup viewGroup, Lifecycle lifecycle, Activity activity) {
        ((MaxRewardedAdViewAdapter) this.amk).showRewardedAd(this.amr, viewGroup, lifecycle, activity, this.amq);
    }

    private boolean b(com.applovin.impl.mediation.b.a aVar, Activity activity) {
        if (aVar == null) {
            throw new IllegalArgumentException("No mediated ad specified");
        } else if (aVar.xC() == null) {
            x.H("MediationAdapterWrapper", "Adapter has been garbage collected");
            this.amq.a("ad_show", (MaxError) new MaxErrorImpl(-1, "Adapter has been garbage collected"), (Bundle) null);
            return false;
        } else if (aVar.xC() != this) {
            throw new IllegalArgumentException("Mediated ad belongs to a different adapter");
        } else if (activity == null && MaxAdFormat.APP_OPEN != aVar.getFormat()) {
            throw new IllegalArgumentException("No activity specified");
        } else if (!this.ams.get()) {
            String str = "Mediation adapter '" + this.amj + "' is disabled. Showing ads with this adapter is disabled.";
            x.H("MediationAdapterWrapper", str);
            this.amq.a("ad_show", (MaxError) new MaxErrorImpl(-1, str), (Bundle) null);
            return false;
        } else if (ug()) {
            return true;
        } else {
            throw new IllegalStateException("Mediation adapter '" + this.amj + "' does not have an ad loaded. Please load an ad first");
        }
    }

    private void a(Runnable runnable, com.applovin.impl.mediation.b.a aVar) {
        a("show_ad", aVar.getFormat(), (Runnable) new g$$ExternalSyntheticLambda1(this, runnable));
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void g(Runnable runnable) {
        try {
            runnable.run();
        } catch (Throwable th) {
            String str = "Failed to start displaying ad for " + this.name + " due to: " + th;
            x.H("MediationAdapterWrapper", str);
            this.amq.a("show_ad", (MaxError) new MaxErrorImpl(-1, str), (Bundle) null);
            this.sdk.Cs().d("MediationAdapterWrapper", "show_ad:" + this.ami.vt(), th);
            bC("show_ad");
            this.sdk.Cw().a(this.ami.vt(), "show_ad", this.aml);
        }
    }

    public boolean isEnabled() {
        return this.ams.get();
    }

    public boolean ug() {
        return this.amt.get() && this.amu.get();
    }

    public String getSdkVersion() {
        MaxAdapter maxAdapter = this.amk;
        if (maxAdapter == null) {
            return null;
        }
        try {
            return maxAdapter.getSdkVersion();
        } catch (Throwable th) {
            x.e("MediationAdapterWrapper", "Failed to get adapter's SDK version for " + this.name, th);
            r Cs = this.sdk.Cs();
            Cs.d("MediationAdapterWrapper", "sdk_version:" + this.ami.vt(), th);
            bC("sdk_version");
            this.sdk.Cw().a(this.ami.vt(), "sdk_version", this.aml);
            return null;
        }
    }

    public String getAdapterVersion() {
        MaxAdapter maxAdapter = this.amk;
        if (maxAdapter == null) {
            return null;
        }
        try {
            return maxAdapter.getAdapterVersion();
        } catch (Throwable th) {
            x.e("MediationAdapterWrapper", "Failed to get adapter version for " + this.name, th);
            r Cs = this.sdk.Cs();
            Cs.d("MediationAdapterWrapper", "adapter_version:" + this.ami.vt(), th);
            bC("adapter_version");
            this.sdk.Cw().a(this.ami.vt(), "adapter_version", this.aml);
            return null;
        }
    }

    /* access modifiers changed from: package-private */
    public void a(MaxAdapterSignalCollectionParameters maxAdapterSignalCollectionParameters, h hVar, Activity activity, MaxSignalCollectionListener maxSignalCollectionListener) {
        if (maxSignalCollectionListener == null) {
            throw new IllegalArgumentException("No callback specified");
        } else if (!this.ams.get()) {
            x.H("MediationAdapterWrapper", "Mediation adapter '" + this.amj + "' is disabled. Signal collection ads with this adapter is disabled.");
            maxSignalCollectionListener.onSignalCollectionFailed("The adapter (" + this.amj + ") is disabled");
        } else {
            c cVar = new c(hVar, maxSignalCollectionListener);
            MaxAdapter maxAdapter = this.amk;
            if (maxAdapter instanceof MaxSignalProvider) {
                b("collect_signal", (Runnable) new g$$ExternalSyntheticLambda2(this, (MaxSignalProvider) maxAdapter, maxAdapterSignalCollectionParameters, activity, cVar, hVar));
                return;
            }
            b("The adapter (" + this.amj + ") does not support signal collection", cVar);
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void a(MaxSignalProvider maxSignalProvider, MaxAdapterSignalCollectionParameters maxAdapterSignalCollectionParameters, Activity activity, final c cVar, h hVar) {
        try {
            maxSignalProvider.collectSignal(maxAdapterSignalCollectionParameters, activity, new MaxSignalCollectionListener() {
                public void onSignalCollected(String str) {
                    g.this.a(str, cVar);
                }

                public void onSignalCollectionFailed(String str) {
                    g.this.b(str, cVar);
                }
            });
        } catch (Throwable th) {
            String str = "Failed signal collection for " + this.name + " due to: " + th;
            x.H("MediationAdapterWrapper", str);
            b(str, cVar);
            this.sdk.Cs().d("MediationAdapterWrapper", "collect_signal:" + this.ami.vt(), th);
            bC("collect_signal");
            this.sdk.Cw().a(this.ami.vt(), "collect_signal", this.aml);
        }
        if (cVar.amC.get()) {
            return;
        }
        if (hVar.yE() == 0) {
            if (x.Fn()) {
                this.logger.f("MediationAdapterWrapper", "Failing signal collection " + hVar + " since it has 0 timeout");
            }
            b("The adapter (" + this.amj + ") has 0 timeout", cVar);
        } else if (hVar.yE() > 0) {
            if (x.Fn()) {
                this.logger.f("MediationAdapterWrapper", "Setting timeout " + hVar.yE() + "ms. for " + hVar);
            }
            this.sdk.BO().a((com.applovin.impl.sdk.e.d) new e(cVar), q.b.MEDIATION_TIMEOUT, hVar.yE());
        } else if (x.Fn()) {
            this.logger.f("MediationAdapterWrapper", "Negative timeout set for " + hVar + ", not scheduling a timeout");
        }
    }

    /* access modifiers changed from: package-private */
    public void destroy() {
        if (!this.amv) {
            b("destroy", (Runnable) new g$$ExternalSyntheticLambda10(this));
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void uh() {
        bC("destroy");
        this.amk.onDestroy();
        this.amk = null;
        this.amm = null;
        this.amn = null;
        this.amo = null;
        this.amp = null;
    }

    /* access modifiers changed from: private */
    public void a(String str, c cVar) {
        if (cVar.amC.compareAndSet(false, true) && cVar.amB != null) {
            cVar.amB.onSignalCollected(str);
        }
    }

    /* access modifiers changed from: private */
    public void b(String str, c cVar) {
        if (cVar.amC.compareAndSet(false, true) && cVar.amB != null) {
            cVar.amB.onSignalCollectionFailed(str);
        }
    }

    private void bC(String str) {
        if (x.Fn()) {
            x xVar = this.logger;
            xVar.g("MediationAdapterWrapper", "Marking " + this.amj + " as disabled due to: " + str);
        }
        this.ams.set(false);
    }

    private void b(String str, Runnable runnable) {
        a(str, (MaxAdFormat) null, runnable);
    }

    private void a(String str, MaxAdFormat maxAdFormat, Runnable runnable) {
        g$$ExternalSyntheticLambda0 g__externalsyntheticlambda0 = new g$$ExternalSyntheticLambda0(this, str, runnable);
        if (a(str, maxAdFormat)) {
            this.acG.post(g__externalsyntheticlambda0);
        } else {
            g__externalsyntheticlambda0.run();
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void c(String str, Runnable runnable) {
        try {
            if (x.Fn()) {
                x xVar = this.logger;
                xVar.f("MediationAdapterWrapper", this.amj + ": running " + str + "...");
            }
            runnable.run();
            if (x.Fn()) {
                x xVar2 = this.logger;
                xVar2.f("MediationAdapterWrapper", this.amj + ": finished " + str + "");
            }
        } catch (Throwable th) {
            x.e("MediationAdapterWrapper", "Failed operation " + str + " for " + this.name, th);
            StringBuilder sb = new StringBuilder("fail_");
            sb.append(str);
            bC(sb.toString());
            if (!str.equals("destroy")) {
                this.sdk.Cw().a(this.ami.vt(), str, this.aml);
                this.sdk.Cs().d("MediationAdapterWrapper", "outer:" + str + ":" + this.ami.vt(), th);
            }
        }
    }

    private boolean a(String str, MaxAdFormat maxAdFormat) {
        Boolean shouldShowAdsOnUiThread;
        MaxAdapter maxAdapter = this.amk;
        if (maxAdapter == null) {
            return this.ami.yC();
        }
        if (MobileAdsBridgeBase.initializeMethodName.equals(str)) {
            Boolean shouldInitializeOnUiThread = maxAdapter.shouldInitializeOnUiThread();
            if (shouldInitializeOnUiThread != null) {
                return shouldInitializeOnUiThread.booleanValue();
            }
        } else if ("collect_signal".equals(str)) {
            Boolean shouldCollectSignalsOnUiThread = maxAdapter.shouldCollectSignalsOnUiThread();
            if (shouldCollectSignalsOnUiThread != null) {
                return shouldCollectSignalsOnUiThread.booleanValue();
            }
        } else if ("load_ad".equals(str) && maxAdFormat != null) {
            Boolean shouldLoadAdsOnUiThread = maxAdapter.shouldLoadAdsOnUiThread(maxAdFormat);
            if (shouldLoadAdsOnUiThread != null) {
                return shouldLoadAdsOnUiThread.booleanValue();
            }
        } else if (!(!"show_ad".equals(str) || maxAdFormat == null || (shouldShowAdsOnUiThread = maxAdapter.shouldShowAdsOnUiThread(maxAdFormat)) == null)) {
            return shouldShowAdsOnUiThread.booleanValue();
        }
        return this.ami.yC();
    }

    public String toString() {
        return "MediationAdapterWrapper{adapterTag='" + this.amj + "'}";
    }

    private class d extends com.applovin.impl.sdk.e.d {
        private d() {
            super("TaskTimeoutMediatedAd", g.this.sdk);
        }

        public void run() {
            if (g.this.amt.get()) {
                return;
            }
            if (g.this.aml.xD()) {
                x xVar = this.logger;
                if (x.Fn()) {
                    x xVar2 = this.logger;
                    String str = this.tag;
                    xVar2.f(str, g.this.amj + " is timing out, considering JS Tag ad loaded: " + g.this.aml);
                }
                c(g.this.aml);
                return;
            }
            x xVar3 = this.logger;
            if (x.Fn()) {
                x xVar4 = this.logger;
                String str2 = this.tag;
                xVar4.i(str2, g.this.amj + " is timing out " + g.this.aml + "...");
            }
            c(g.this.aml);
            g.this.amq.a(this.tag, (MaxError) new MaxErrorImpl(-5101, "Adapter timed out"));
        }

        private void c(com.applovin.impl.mediation.b.a aVar) {
            if (aVar != null) {
                this.sdk.CA().e(aVar);
            }
        }
    }

    private class e extends com.applovin.impl.sdk.e.d {
        private final c amD;

        private e(c cVar) {
            super("TaskTimeoutSignalCollection", g.this.sdk);
            this.amD = cVar;
        }

        public void run() {
            if (!this.amD.amC.get()) {
                x xVar = this.logger;
                if (x.Fn()) {
                    x xVar2 = this.logger;
                    String str = this.tag;
                    xVar2.i(str, g.this.amj + " is timing out " + this.amD.amA + "...");
                }
                g gVar = g.this;
                gVar.b("The adapter (" + g.this.amj + ") timed out", this.amD);
            }
        }
    }

    private class a implements MaxAdViewAdapterListener, MaxAppOpenAdapterListener, MaxInterstitialAdapterListener, MaxNativeAdAdapterListener, MaxRewardedAdapterListener, MaxRewardedInterstitialAdapterListener {
        /* access modifiers changed from: private */
        public MediationServiceImpl.a amy;

        private a() {
        }

        /* access modifiers changed from: private */
        public void a(MediationServiceImpl.a aVar) {
            if (aVar != null) {
                this.amy = aVar;
                return;
            }
            throw new IllegalArgumentException("No listener specified");
        }

        private void a(String str, Bundle bundle) {
            if (g.this.aml.xP().get()) {
                x unused = g.this.logger;
                if (x.Fn()) {
                    x f = g.this.logger;
                    f.i("MediationAdapterWrapper", g.this.amj + ": blocking ad loaded callback for " + g.this.aml + " since onAdHidden() has been called");
                }
                g.this.sdk.Ch().b(g.this.aml, str);
                return;
            }
            g.this.amu.set(true);
            a(str, (MaxAdListener) this.amy, (Runnable) new g$a$$ExternalSyntheticLambda8(this, bundle));
        }

        /* access modifiers changed from: private */
        public /* synthetic */ void R(Bundle bundle) {
            if (g.this.amt.compareAndSet(false, true)) {
                this.amy.a(g.this.aml, bundle);
            }
        }

        /* access modifiers changed from: private */
        public void a(String str, MaxError maxError) {
            if (g.this.aml.xP().get()) {
                x unused = g.this.logger;
                if (x.Fn()) {
                    x f = g.this.logger;
                    f.i("MediationAdapterWrapper", g.this.amj + ": blocking ad load failed callback for " + g.this.aml + " since onAdHidden() has been called");
                }
                g.this.sdk.Ch().b(g.this.aml, str);
                return;
            }
            a(str, (MaxAdListener) this.amy, (Runnable) new g$a$$ExternalSyntheticLambda17(this, maxError));
        }

        /* access modifiers changed from: private */
        public /* synthetic */ void a(MaxError maxError) {
            if (g.this.amt.compareAndSet(false, true)) {
                this.amy.onAdLoadFailed(g.this.adUnitId, maxError);
            }
        }

        private void b(String str, Bundle bundle) {
            if (g.this.aml.xP().get()) {
                x unused = g.this.logger;
                if (x.Fn()) {
                    x f = g.this.logger;
                    f.i("MediationAdapterWrapper", g.this.amj + ": blocking ad displayed callback for " + g.this.aml + " since onAdHidden() has been called");
                }
                g.this.sdk.Ch().b(g.this.aml, str);
            } else if (g.this.aml.xO().compareAndSet(false, true)) {
                a(str, (MaxAdListener) this.amy, (Runnable) new g$a$$ExternalSyntheticLambda2(this, bundle));
            }
        }

        /* access modifiers changed from: private */
        public /* synthetic */ void Q(Bundle bundle) {
            this.amy.b(g.this.aml, bundle);
        }

        /* access modifiers changed from: private */
        public void a(String str, MaxError maxError, Bundle bundle) {
            if (g.this.aml.xP().get()) {
                x unused = g.this.logger;
                if (x.Fn()) {
                    x f = g.this.logger;
                    f.i("MediationAdapterWrapper", g.this.amj + ": blocking ad display failed callback for " + g.this.aml + " since onAdHidden() has been called");
                }
                g.this.sdk.Ch().b(g.this.aml, str);
                return;
            }
            a(str, (MaxAdListener) this.amy, (Runnable) new g$a$$ExternalSyntheticLambda9(this, maxError, bundle));
        }

        /* access modifiers changed from: private */
        public /* synthetic */ void a(MaxError maxError, Bundle bundle) {
            this.amy.a((MaxAd) g.this.aml, maxError, bundle);
        }

        private void c(String str, Bundle bundle) {
            if (g.this.aml.xP().compareAndSet(false, true)) {
                a(str, (MaxAdListener) this.amy, (Runnable) new g$a$$ExternalSyntheticLambda18(this, bundle));
            }
        }

        /* access modifiers changed from: private */
        public /* synthetic */ void P(Bundle bundle) {
            this.amy.c(g.this.aml, bundle);
        }

        public void onInterstitialAdLoaded() {
            onInterstitialAdLoaded((Bundle) null);
        }

        public void onInterstitialAdLoaded(Bundle bundle) {
            x unused = g.this.logger;
            if (x.Fn()) {
                x f = g.this.logger;
                f.g("MediationAdapterWrapper", g.this.amj + ": interstitial ad loaded with extra info: " + bundle);
            }
            a("onInterstitialAdLoaded", bundle);
        }

        public void onInterstitialAdLoadFailed(MaxAdapterError maxAdapterError) {
            x unused = g.this.logger;
            if (x.Fn()) {
                x f = g.this.logger;
                f.h("MediationAdapterWrapper", g.this.amj + ": interstitial ad failed to load with error " + maxAdapterError);
            }
            a("onInterstitialAdLoadFailed", (MaxError) maxAdapterError);
        }

        public void onInterstitialAdDisplayed() {
            onInterstitialAdDisplayed((Bundle) null);
        }

        public void onInterstitialAdDisplayed(Bundle bundle) {
            x unused = g.this.logger;
            if (x.Fn()) {
                x f = g.this.logger;
                f.g("MediationAdapterWrapper", g.this.amj + ": interstitial ad displayed with extra info: " + bundle);
            }
            b("onInterstitialAdDisplayed", bundle);
        }

        public void onInterstitialAdClicked() {
            onInterstitialAdClicked((Bundle) null);
        }

        public void onInterstitialAdClicked(Bundle bundle) {
            x unused = g.this.logger;
            if (x.Fn()) {
                x f = g.this.logger;
                f.g("MediationAdapterWrapper", g.this.amj + ": interstitial ad clicked with extra info: " + bundle);
            }
            a("onInterstitialAdClicked", (MaxAdListener) this.amy, (Runnable) new g$a$$ExternalSyntheticLambda5(this, bundle));
        }

        /* access modifiers changed from: private */
        public /* synthetic */ void O(Bundle bundle) {
            this.amy.d(g.this.aml, bundle);
        }

        public void onInterstitialAdHidden() {
            onInterstitialAdHidden((Bundle) null);
        }

        public void onInterstitialAdHidden(Bundle bundle) {
            x unused = g.this.logger;
            if (x.Fn()) {
                x f = g.this.logger;
                f.g("MediationAdapterWrapper", g.this.amj + ": interstitial ad hidden with extra info " + bundle);
            }
            c("onInterstitialAdHidden", bundle);
        }

        public void onInterstitialAdDisplayFailed(MaxAdapterError maxAdapterError) {
            onInterstitialAdDisplayFailed(maxAdapterError, (Bundle) null);
        }

        public void onInterstitialAdDisplayFailed(MaxAdapterError maxAdapterError, Bundle bundle) {
            x unused = g.this.logger;
            if (x.Fn()) {
                x f = g.this.logger;
                f.h("MediationAdapterWrapper", g.this.amj + ": interstitial ad failed to display with error " + maxAdapterError);
            }
            a("onInterstitialAdDisplayFailed", (MaxError) maxAdapterError, bundle);
        }

        public void onRewardedAdLoaded() {
            onRewardedAdLoaded((Bundle) null);
        }

        public void onRewardedAdLoaded(Bundle bundle) {
            x unused = g.this.logger;
            if (x.Fn()) {
                x f = g.this.logger;
                f.g("MediationAdapterWrapper", g.this.amj + ": rewarded ad loaded with extra info: " + bundle);
            }
            a("onRewardedAdLoaded", bundle);
        }

        public void onRewardedAdLoadFailed(MaxAdapterError maxAdapterError) {
            x unused = g.this.logger;
            if (x.Fn()) {
                x f = g.this.logger;
                f.h("MediationAdapterWrapper", g.this.amj + ": rewarded ad failed to load with error: " + maxAdapterError);
            }
            a("onRewardedAdLoadFailed", (MaxError) maxAdapterError);
        }

        public void onRewardedAdDisplayed() {
            onRewardedAdDisplayed((Bundle) null);
        }

        public void onRewardedAdDisplayed(Bundle bundle) {
            x unused = g.this.logger;
            if (x.Fn()) {
                x f = g.this.logger;
                f.g("MediationAdapterWrapper", g.this.amj + ": rewarded ad displayed with extra info: " + bundle);
            }
            b("onRewardedAdDisplayed", bundle);
        }

        public void onRewardedAdClicked() {
            onRewardedAdClicked((Bundle) null);
        }

        public void onRewardedAdClicked(Bundle bundle) {
            x unused = g.this.logger;
            if (x.Fn()) {
                x f = g.this.logger;
                f.g("MediationAdapterWrapper", g.this.amj + ": rewarded ad clicked with extra info: " + bundle);
            }
            a("onRewardedAdClicked", (MaxAdListener) this.amy, (Runnable) new g$a$$ExternalSyntheticLambda12(this, bundle));
        }

        /* access modifiers changed from: private */
        public /* synthetic */ void N(Bundle bundle) {
            this.amy.d(g.this.aml, bundle);
        }

        public void onRewardedAdHidden() {
            onRewardedAdHidden((Bundle) null);
        }

        public void onRewardedAdHidden(Bundle bundle) {
            x unused = g.this.logger;
            if (x.Fn()) {
                x f = g.this.logger;
                f.g("MediationAdapterWrapper", g.this.amj + ": rewarded ad hidden with extra info: " + bundle);
            }
            c("onRewardedAdHidden", bundle);
        }

        public void onUserRewarded(MaxReward maxReward) {
            onUserRewarded(maxReward, (Bundle) null);
        }

        public void onUserRewarded(MaxReward maxReward, Bundle bundle) {
            if (g.this.aml instanceof com.applovin.impl.mediation.b.c) {
                com.applovin.impl.mediation.b.c cVar = (com.applovin.impl.mediation.b.c) g.this.aml;
                if (cVar.yi().compareAndSet(false, true)) {
                    x unused = g.this.logger;
                    if (x.Fn()) {
                        x f = g.this.logger;
                        f.g("MediationAdapterWrapper", g.this.amj + ": user was rewarded: " + maxReward);
                    }
                    a("onUserRewarded", (MaxAdListener) this.amy, (Runnable) new g$a$$ExternalSyntheticLambda14(this, cVar, maxReward, bundle));
                }
            }
        }

        /* access modifiers changed from: private */
        public /* synthetic */ void a(com.applovin.impl.mediation.b.c cVar, MaxReward maxReward, Bundle bundle) {
            this.amy.a((MaxAd) cVar, maxReward, bundle);
        }

        public void onRewardedAdVideoStarted() {
            x unused = g.this.logger;
            if (x.Fn()) {
                x f = g.this.logger;
                f.g("MediationAdapterWrapper", g.this.amj + ": rewarded video started");
            }
            a("onRewardedAdVideoStarted", (MaxAdListener) this.amy, (Runnable) new g$a$$ExternalSyntheticLambda4(this));
        }

        /* access modifiers changed from: private */
        public /* synthetic */ void um() {
            this.amy.onRewardedVideoStarted(g.this.aml);
        }

        public void onRewardedAdVideoCompleted() {
            x unused = g.this.logger;
            if (x.Fn()) {
                x f = g.this.logger;
                f.g("MediationAdapterWrapper", g.this.amj + ": rewarded video completed");
            }
            a("onRewardedAdVideoCompleted", (MaxAdListener) this.amy, (Runnable) new g$a$$ExternalSyntheticLambda15(this));
        }

        /* access modifiers changed from: private */
        public /* synthetic */ void ul() {
            this.amy.onRewardedVideoCompleted(g.this.aml);
        }

        public void onRewardedAdDisplayFailed(MaxAdapterError maxAdapterError) {
            onRewardedAdDisplayFailed(maxAdapterError, (Bundle) null);
        }

        public void onRewardedAdDisplayFailed(MaxAdapterError maxAdapterError, Bundle bundle) {
            x unused = g.this.logger;
            if (x.Fn()) {
                x f = g.this.logger;
                f.h("MediationAdapterWrapper", g.this.amj + ": rewarded ad display failed with error: " + maxAdapterError);
            }
            a("onRewardedAdDisplayFailed", (MaxError) maxAdapterError, bundle);
        }

        public void onRewardedInterstitialAdLoaded() {
            onRewardedInterstitialAdLoaded((Bundle) null);
        }

        public void onRewardedInterstitialAdLoaded(Bundle bundle) {
            x unused = g.this.logger;
            if (x.Fn()) {
                x f = g.this.logger;
                f.g("MediationAdapterWrapper", g.this.amj + ": rewarded interstitial ad loaded with extra info: " + bundle);
            }
            a("onRewardedInterstitialAdLoaded", bundle);
        }

        public void onRewardedInterstitialAdLoadFailed(MaxAdapterError maxAdapterError) {
            x unused = g.this.logger;
            if (x.Fn()) {
                x f = g.this.logger;
                f.h("MediationAdapterWrapper", g.this.amj + ": rewarded ad failed to load with error: " + maxAdapterError);
            }
            a("onRewardedInterstitialAdLoadFailed", (MaxError) maxAdapterError);
        }

        public void onRewardedInterstitialAdDisplayed() {
            onRewardedInterstitialAdDisplayed((Bundle) null);
        }

        public void onRewardedInterstitialAdDisplayed(Bundle bundle) {
            x unused = g.this.logger;
            if (x.Fn()) {
                x f = g.this.logger;
                f.g("MediationAdapterWrapper", g.this.amj + ": rewarded interstitial ad displayed with extra info: " + bundle);
            }
            b("onRewardedInterstitialAdDisplayed", bundle);
        }

        public void onRewardedInterstitialAdDisplayFailed(MaxAdapterError maxAdapterError) {
            onRewardedInterstitialAdDisplayFailed(maxAdapterError, (Bundle) null);
        }

        public void onRewardedInterstitialAdDisplayFailed(MaxAdapterError maxAdapterError, Bundle bundle) {
            x unused = g.this.logger;
            if (x.Fn()) {
                x f = g.this.logger;
                f.h("MediationAdapterWrapper", g.this.amj + ": rewarded interstitial ad display failed with error: " + maxAdapterError);
            }
            a("onRewardedInterstitialAdDisplayFailed", (MaxError) maxAdapterError, bundle);
        }

        public void onRewardedInterstitialAdClicked() {
            onRewardedInterstitialAdClicked((Bundle) null);
        }

        public void onRewardedInterstitialAdClicked(Bundle bundle) {
            x unused = g.this.logger;
            if (x.Fn()) {
                x f = g.this.logger;
                f.g("MediationAdapterWrapper", g.this.amj + ": rewarded interstitial ad clicked with extra info: " + bundle);
            }
            a("onRewardedInterstitialAdClicked", (MaxAdListener) this.amy, (Runnable) new g$a$$ExternalSyntheticLambda13(this, bundle));
        }

        /* access modifiers changed from: private */
        public /* synthetic */ void M(Bundle bundle) {
            this.amy.d(g.this.aml, bundle);
        }

        public void onRewardedInterstitialAdHidden() {
            onRewardedInterstitialAdHidden((Bundle) null);
        }

        public void onRewardedInterstitialAdHidden(Bundle bundle) {
            x unused = g.this.logger;
            if (x.Fn()) {
                x f = g.this.logger;
                f.g("MediationAdapterWrapper", g.this.amj + ": rewarded interstitial ad hidden with extra info: " + bundle);
            }
            c("onRewardedInterstitialAdHidden", bundle);
        }

        public void onRewardedInterstitialAdVideoStarted() {
            x unused = g.this.logger;
            if (x.Fn()) {
                x f = g.this.logger;
                f.g("MediationAdapterWrapper", g.this.amj + ": rewarded interstitial started");
            }
            a("onRewardedInterstitialAdVideoStarted", (MaxAdListener) this.amy, (Runnable) new g$a$$ExternalSyntheticLambda7(this));
        }

        /* access modifiers changed from: private */
        public /* synthetic */ void uk() {
            this.amy.onRewardedVideoStarted(g.this.aml);
        }

        public void onRewardedInterstitialAdVideoCompleted() {
            x unused = g.this.logger;
            if (x.Fn()) {
                x f = g.this.logger;
                f.g("MediationAdapterWrapper", g.this.amj + ": rewarded interstitial completed");
            }
            a("onRewardedInterstitialAdVideoCompleted", (MaxAdListener) this.amy, (Runnable) new g$a$$ExternalSyntheticLambda6(this));
        }

        /* access modifiers changed from: private */
        public /* synthetic */ void uj() {
            this.amy.onRewardedVideoCompleted(g.this.aml);
        }

        public void onAppOpenAdLoaded() {
            onAppOpenAdLoaded((Bundle) null);
        }

        public void onAppOpenAdLoaded(Bundle bundle) {
            x unused = g.this.logger;
            if (x.Fn()) {
                x f = g.this.logger;
                f.g("MediationAdapterWrapper", g.this.amj + ": app open ad loaded with extra info: " + bundle);
            }
            a("onAppOpenAdLoaded", bundle);
        }

        public void onAppOpenAdLoadFailed(MaxAdapterError maxAdapterError) {
            x unused = g.this.logger;
            if (x.Fn()) {
                x f = g.this.logger;
                f.h("MediationAdapterWrapper", g.this.amj + ": app open ad failed to load with error: " + maxAdapterError);
            }
            a("onAppOpenAdLoadFailed", (MaxError) maxAdapterError);
        }

        public void onAppOpenAdDisplayed() {
            onAppOpenAdDisplayed((Bundle) null);
        }

        public void onAppOpenAdDisplayed(Bundle bundle) {
            x unused = g.this.logger;
            if (x.Fn()) {
                x f = g.this.logger;
                f.g("MediationAdapterWrapper", g.this.amj + ": app open ad displayed with extra info: " + bundle);
            }
            b("onAppOpenAdDisplayed", bundle);
        }

        public void onAppOpenAdDisplayFailed(MaxAdapterError maxAdapterError) {
            onAppOpenAdDisplayFailed(maxAdapterError, (Bundle) null);
        }

        public void onAppOpenAdDisplayFailed(MaxAdapterError maxAdapterError, Bundle bundle) {
            x unused = g.this.logger;
            if (x.Fn()) {
                x f = g.this.logger;
                f.h("MediationAdapterWrapper", g.this.amj + ": app open ad display failed with error: " + maxAdapterError);
            }
            a("onAppOpenAdDisplayFailed", (MaxError) maxAdapterError, bundle);
        }

        public void onAppOpenAdClicked() {
            onAppOpenAdClicked((Bundle) null);
        }

        public void onAppOpenAdClicked(Bundle bundle) {
            x unused = g.this.logger;
            if (x.Fn()) {
                x f = g.this.logger;
                f.g("MediationAdapterWrapper", g.this.amj + ": app open ad clicked with extra info: " + bundle);
            }
            a("onAppOpenAdClicked", (MaxAdListener) this.amy, (Runnable) new g$a$$ExternalSyntheticLambda11(this, bundle));
        }

        /* access modifiers changed from: private */
        public /* synthetic */ void L(Bundle bundle) {
            this.amy.d(g.this.aml, bundle);
        }

        public void onAppOpenAdHidden() {
            onAppOpenAdHidden((Bundle) null);
        }

        public void onAppOpenAdHidden(Bundle bundle) {
            x unused = g.this.logger;
            if (x.Fn()) {
                x f = g.this.logger;
                f.g("MediationAdapterWrapper", g.this.amj + ": app open ad hidden with extra info: " + bundle);
            }
            c("onAppOpenAdHidden", bundle);
        }

        public void onAdViewAdLoaded(View view) {
            onAdViewAdLoaded(view, (Bundle) null);
        }

        public void onAdViewAdLoaded(View view, Bundle bundle) {
            x unused = g.this.logger;
            if (x.Fn()) {
                x f = g.this.logger;
                f.g("MediationAdapterWrapper", g.this.amj + ": adview ad loaded with extra info: " + bundle);
            }
            View unused2 = g.this.amm = view;
            a("onAdViewAdLoaded", bundle);
        }

        public void onAdViewAdLoadFailed(MaxAdapterError maxAdapterError) {
            x unused = g.this.logger;
            if (x.Fn()) {
                x f = g.this.logger;
                f.h("MediationAdapterWrapper", g.this.amj + ": adview ad ad failed to load with error: " + maxAdapterError);
            }
            a("onAdViewAdLoadFailed", (MaxError) maxAdapterError);
        }

        public void onAdViewAdDisplayed() {
            onAdViewAdDisplayed((Bundle) null);
        }

        public void onAdViewAdDisplayed(Bundle bundle) {
            if (!g.this.aml.xF()) {
                x unused = g.this.logger;
                if (x.Fn()) {
                    x f = g.this.logger;
                    f.g("MediationAdapterWrapper", g.this.amj + ": adview ad displayed with extra info: " + bundle);
                }
                b("onAdViewAdDisplayed", bundle);
            }
        }

        public void onAdViewAdClicked() {
            onAdViewAdClicked((Bundle) null);
        }

        public void onAdViewAdClicked(Bundle bundle) {
            x unused = g.this.logger;
            if (x.Fn()) {
                x f = g.this.logger;
                f.g("MediationAdapterWrapper", g.this.amj + ": adview ad clicked with extra info: " + bundle);
            }
            a("onAdViewAdClicked", (MaxAdListener) this.amy, (Runnable) new g$a$$ExternalSyntheticLambda3(this, bundle));
        }

        /* access modifiers changed from: private */
        public /* synthetic */ void K(Bundle bundle) {
            this.amy.d(g.this.aml, bundle);
        }

        public void onAdViewAdHidden() {
            onAdViewAdHidden((Bundle) null);
        }

        public void onAdViewAdHidden(Bundle bundle) {
            x unused = g.this.logger;
            if (x.Fn()) {
                x f = g.this.logger;
                f.g("MediationAdapterWrapper", g.this.amj + ": adview ad hidden with extra info: " + bundle);
            }
            c("onAdViewAdHidden", bundle);
        }

        public void onAdViewAdExpanded() {
            onAdViewAdExpanded((Bundle) null);
        }

        public void onAdViewAdExpanded(Bundle bundle) {
            x unused = g.this.logger;
            if (x.Fn()) {
                x f = g.this.logger;
                f.g("MediationAdapterWrapper", g.this.amj + ": adview ad expanded");
            }
            a("onAdViewAdExpanded", (MaxAdListener) this.amy, (Runnable) new g$a$$ExternalSyntheticLambda16(this, bundle));
        }

        /* access modifiers changed from: private */
        public /* synthetic */ void J(Bundle bundle) {
            this.amy.e(g.this.aml, bundle);
        }

        public void onAdViewAdCollapsed() {
            onAdViewAdCollapsed((Bundle) null);
        }

        public void onAdViewAdCollapsed(Bundle bundle) {
            x unused = g.this.logger;
            if (x.Fn()) {
                x f = g.this.logger;
                f.g("MediationAdapterWrapper", g.this.amj + ": adview ad collapsed");
            }
            a("onAdViewAdCollapsed", (MaxAdListener) this.amy, (Runnable) new g$a$$ExternalSyntheticLambda10(this));
        }

        /* access modifiers changed from: private */
        public /* synthetic */ void ui() {
            this.amy.onAdCollapsed(g.this.aml);
        }

        public void onAdViewAdDisplayFailed(MaxAdapterError maxAdapterError) {
            onAdViewAdDisplayFailed(maxAdapterError, (Bundle) null);
        }

        public void onAdViewAdDisplayFailed(MaxAdapterError maxAdapterError, Bundle bundle) {
            x unused = g.this.logger;
            if (x.Fn()) {
                x f = g.this.logger;
                f.h("MediationAdapterWrapper", g.this.amj + ": adview ad failed to display with error: " + maxAdapterError);
            }
            a("onAdViewAdDisplayFailed", (MaxError) maxAdapterError, bundle);
        }

        public void onNativeAdLoaded(MaxNativeAd maxNativeAd, Bundle bundle) {
            x unused = g.this.logger;
            if (x.Fn()) {
                x f = g.this.logger;
                f.g("MediationAdapterWrapper", g.this.amj + ": native ad loaded with extra info: " + bundle);
            }
            MaxNativeAd unused2 = g.this.amn = maxNativeAd;
            a("onNativeAdLoaded", bundle);
        }

        public void onNativeAdLoadFailed(MaxAdapterError maxAdapterError) {
            x unused = g.this.logger;
            if (x.Fn()) {
                x f = g.this.logger;
                f.h("MediationAdapterWrapper", g.this.amj + ": native ad ad failed to load with error: " + maxAdapterError);
            }
            a("onNativeAdLoadFailed", (MaxError) maxAdapterError);
        }

        public void onNativeAdDisplayed(Bundle bundle) {
            if (!g.this.aml.xF()) {
                x unused = g.this.logger;
                if (x.Fn()) {
                    x f = g.this.logger;
                    f.g("MediationAdapterWrapper", g.this.amj + ": native ad displayed with extra info: " + bundle);
                }
                b("onNativeAdDisplayed", bundle);
            }
        }

        public void onNativeAdClicked() {
            onNativeAdClicked((Bundle) null);
        }

        public void onNativeAdClicked(Bundle bundle) {
            x unused = g.this.logger;
            if (x.Fn()) {
                x f = g.this.logger;
                f.g("MediationAdapterWrapper", g.this.amj + ": native ad clicked");
            }
            a("onNativeAdClicked", (MaxAdListener) this.amy, (Runnable) new g$a$$ExternalSyntheticLambda1(this, bundle));
        }

        /* access modifiers changed from: private */
        public /* synthetic */ void I(Bundle bundle) {
            this.amy.d(g.this.aml, bundle);
        }

        private void a(String str, MaxAdListener maxAdListener, Runnable runnable) {
            g.this.acG.post(new g$a$$ExternalSyntheticLambda0(this, runnable, maxAdListener, str));
        }

        /* access modifiers changed from: private */
        public /* synthetic */ void a(Runnable runnable, MaxAdListener maxAdListener, String str) {
            try {
                runnable.run();
            } catch (Throwable th) {
                String name = maxAdListener != null ? maxAdListener.getClass().getName() : null;
                x.e("MediationAdapterWrapper", "Failed to forward call (" + str + ") to " + name, th);
                g.this.sdk.Cs().d("MediationAdapterWrapper", str + ":" + g.this.ami.vt(), th);
            }
        }
    }

    private static class c {
        /* access modifiers changed from: private */
        public final h amA;
        /* access modifiers changed from: private */
        public final MaxSignalCollectionListener amB;
        /* access modifiers changed from: private */
        public final AtomicBoolean amC = new AtomicBoolean();

        c(h hVar, MaxSignalCollectionListener maxSignalCollectionListener) {
            this.amA = hVar;
            this.amB = maxSignalCollectionListener;
        }
    }

    private static class b implements MaxAdapter.OnCompletionListener {
        private final f ami;
        private final Runnable amz;
        private final n sdk;
        private final long startTimeMillis;

        public b(n nVar, f fVar, long j, Runnable runnable) {
            this.sdk = nVar;
            this.ami = fVar;
            this.startTimeMillis = j;
            this.amz = runnable;
        }

        public void onCompletion(MaxAdapter.InitializationStatus initializationStatus, String str) {
            AppLovinSdkUtils.runOnUiThreadDelayed(new g$b$$ExternalSyntheticLambda0(this, initializationStatus, str), this.ami.yF());
        }

        /* access modifiers changed from: private */
        public /* synthetic */ void a(MaxAdapter.InitializationStatus initializationStatus, String str) {
            this.sdk.Cx().a(this.ami, SystemClock.elapsedRealtime() - this.startTimeMillis, initializationStatus, str);
            Runnable runnable = this.amz;
            if (runnable != null) {
                runnable.run();
            }
        }
    }
}
