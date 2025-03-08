package com.applovin.impl.mediation;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Log;
import android.view.ViewGroup;
import androidx.lifecycle.Lifecycle;
import com.applovin.impl.mediation.ads.a;
import com.applovin.impl.mediation.b.c;
import com.applovin.impl.mediation.b.e;
import com.applovin.impl.mediation.b.f;
import com.applovin.impl.mediation.b.g;
import com.applovin.impl.mediation.d;
import com.applovin.impl.mediation.d.h;
import com.applovin.impl.sdk.AppLovinBroadcastManager;
import com.applovin.impl.sdk.c.b;
import com.applovin.impl.sdk.e.q;
import com.applovin.impl.sdk.n;
import com.applovin.impl.sdk.u;
import com.applovin.impl.sdk.utils.CollectionUtils;
import com.applovin.impl.sdk.utils.StringUtils;
import com.applovin.impl.sdk.utils.m;
import com.applovin.impl.sdk.x;
import com.applovin.mediation.MaxAd;
import com.applovin.mediation.MaxAdFormat;
import com.applovin.mediation.MaxAdListener;
import com.applovin.mediation.MaxAdRequestListener;
import com.applovin.mediation.MaxAdRevenueListener;
import com.applovin.mediation.MaxAdViewAdListener;
import com.applovin.mediation.MaxError;
import com.applovin.mediation.MaxReward;
import com.applovin.mediation.MaxRewardedAdListener;
import com.applovin.mediation.adapter.MaxAdapter;
import com.applovin.mediation.adapter.MaxAdapterError;
import com.applovin.mediation.adapter.listeners.MaxSignalCollectionListener;
import com.applovin.mediation.adapter.parameters.MaxAdapterResponseParameters;
import com.applovin.mediation.adapter.parameters.MaxAdapterSignalCollectionParameters;
import com.applovin.sdk.AppLovinSdkUtils;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicReference;
import org.json.JSONObject;

public class MediationServiceImpl implements AppLovinBroadcastManager.Receiver {
    private final AtomicReference<JSONObject> amE = new AtomicReference<>();
    /* access modifiers changed from: private */
    public final x logger;
    /* access modifiers changed from: private */
    public final n sdk;

    public MediationServiceImpl(n nVar) {
        this.sdk = nVar;
        this.logger = nVar.BN();
        AppLovinBroadcastManager.registerReceiver(this, new IntentFilter("com.applovin.render_process_gone"));
    }

    public void loadAd(String str, String str2, MaxAdFormat maxAdFormat, d.a aVar, Map<String, Object> map, Map<String, Object> map2, Context context, a.C0067a aVar2) {
        String str3 = str;
        a.C0067a aVar3 = aVar2;
        if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException("No Ad Unit ID specified");
        } else if (context == null) {
            throw new IllegalArgumentException("No context specified");
        } else if (aVar3 != null) {
            if (TextUtils.isEmpty(this.sdk.getMediationProvider())) {
                x.H("AppLovinSdk", "Mediation provider is null. Please set AppLovin SDK mediation provider via AppLovinSdk.getInstance(context).setMediationProvider()");
            }
            if (!this.sdk.isEnabled()) {
                x.F("AppLovinSdk", "Attempted to load ad before SDK initialization. Please wait until after the SDK has initialized, e.g. AppLovinSdk.initializeSdk(Context, SdkInitializationListener).");
            }
            this.sdk.Bl();
            if (str.length() != 16 && !str.startsWith("test_mode") && !this.sdk.getSdkKey().startsWith("05TMD")) {
                x.H("MediationService", "Please double-check the ad unit " + str + " for " + maxAdFormat.getLabel() + " : " + Log.getStackTraceString(new Throwable("")));
            }
            MaxAdFormat maxAdFormat2 = maxAdFormat;
            if (this.sdk.g(maxAdFormat)) {
                x.H("MediationService", "Ad load failed due to disabled ad format " + maxAdFormat.getLabel());
                m.a((MaxAdListener) aVar3, str, (MaxError) new MaxErrorImpl(-1, "Disabled ad format " + maxAdFormat.getLabel()));
                return;
            }
            this.sdk.BH();
            m.a((MaxAdRequestListener) aVar3, str, true, true);
            this.sdk.CD().a(str, str2, maxAdFormat, aVar, map, map2, context, aVar2);
        } else {
            throw new IllegalArgumentException("No listener specified");
        }
    }

    public void showFullscreenAd(c cVar, Activity activity, a.C0067a aVar) {
        if (cVar == null) {
            throw new IllegalArgumentException("No ad specified");
        } else if (activity != null || MaxAdFormat.APP_OPEN == cVar.getFormat()) {
            this.sdk.Cf().aM(true);
            g g = g(cVar);
            long yb = cVar.yb();
            if (x.Fn()) {
                x xVar = this.logger;
                xVar.g("MediationService", "Showing ad " + cVar.getAdUnitId() + " with delay of " + yb + "ms...");
            }
            AppLovinSdkUtils.runOnUiThreadDelayed(new MediationServiceImpl$$ExternalSyntheticLambda0(this, cVar, g, activity, aVar), yb);
        } else {
            throw new IllegalArgumentException("No activity specified");
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void a(c cVar, g gVar, Activity activity, a.C0067a aVar) {
        cVar.aH(true);
        h(cVar);
        gVar.a((com.applovin.impl.mediation.b.a) cVar, activity);
        a(cVar, aVar);
    }

    public void showFullscreenAd(c cVar, ViewGroup viewGroup, Lifecycle lifecycle, Activity activity, a.C0067a aVar) {
        if (cVar == null) {
            throw new IllegalArgumentException("No ad specified");
        } else if (activity != null) {
            this.sdk.Cf().aM(true);
            g g = g(cVar);
            long yb = cVar.yb();
            if (x.Fn()) {
                x xVar = this.logger;
                xVar.g("MediationService", "Showing ad " + cVar.getAdUnitId() + " with delay of " + yb + "ms...");
            }
            AppLovinSdkUtils.runOnUiThreadDelayed(new MediationServiceImpl$$ExternalSyntheticLambda1(this, cVar, g, viewGroup, lifecycle, activity, aVar), yb);
        } else {
            throw new IllegalArgumentException("No activity specified");
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void a(c cVar, g gVar, ViewGroup viewGroup, Lifecycle lifecycle, Activity activity, a.C0067a aVar) {
        cVar.aH(true);
        h(cVar);
        gVar.a((com.applovin.impl.mediation.b.a) cVar, viewGroup, lifecycle, activity);
        a(cVar, aVar);
    }

    private g g(c cVar) {
        g xC = cVar.xC();
        if (xC != null) {
            return xC;
        }
        this.sdk.Cf().aM(false);
        if (x.Fn()) {
            x xVar = this.logger;
            xVar.h("MediationService", "Failed to show " + cVar + ": adapter not found");
        }
        x.H("MediationService", "There may be an integration problem with the adapter for Ad Unit ID '" + cVar.getAdUnitId() + "'. Please check if you have a supported version of that SDK integrated into your project.");
        throw new IllegalStateException("Could not find adapter for provided ad");
    }

    private void h(c cVar) {
        if (cVar.getFormat() == MaxAdFormat.REWARDED || cVar.getFormat() == MaxAdFormat.REWARDED_INTERSTITIAL) {
            this.sdk.BO().a((com.applovin.impl.sdk.e.d) new h(cVar, this.sdk), q.b.MEDIATION_REWARD);
        }
    }

    private void a(c cVar, a.C0067a aVar) {
        this.sdk.Cf().aM(false);
        a(cVar, (MaxAdListener) aVar);
        if (x.Fn()) {
            this.logger.f("MediationService", "Scheduling impression for ad manually...");
        }
        processRawAdImpressionPostback(cVar, aVar);
    }

    public void destroyAd(MaxAd maxAd) {
        if (maxAd instanceof com.applovin.impl.mediation.b.a) {
            if (x.Fn()) {
                x xVar = this.logger;
                xVar.g("MediationService", "Destroying " + maxAd);
            }
            com.applovin.impl.mediation.b.a aVar = (com.applovin.impl.mediation.b.a) maxAd;
            g xC = aVar.xC();
            if (xC != null) {
                xC.destroy();
                aVar.xQ();
            }
            this.sdk.Cv().cv(aVar.xA());
        }
    }

    public void loadThirdPartyMediatedAd(String str, com.applovin.impl.mediation.b.a aVar, Activity activity, a.C0067a aVar2) {
        if (aVar != null) {
            if (x.Fn()) {
                this.logger.f("MediationService", "Loading " + aVar + "...");
            }
            this.sdk.Ch().a(aVar, "WILL_LOAD");
            g c = this.sdk.Cw().c(aVar);
            if (c != null) {
                MaxAdapterParametersImpl a2 = MaxAdapterParametersImpl.a(aVar);
                this.sdk.Cx().a((f) aVar, activity);
                com.applovin.impl.mediation.b.a k = aVar.k(c);
                c.a(str, k);
                k.xL();
                c.a(str, (MaxAdapterResponseParameters) a2, k, activity, new a(k, aVar2));
                return;
            }
            String str2 = "Failed to load " + aVar + ": adapter not loaded";
            x.H("MediationService", str2);
            a(aVar, (MaxError) new MaxErrorImpl(-5001, str2), (MaxAdListener) aVar2);
            return;
        }
        throw new IllegalArgumentException("No mediated ad specified");
    }

    public void collectSignal(String str, MaxAdFormat maxAdFormat, com.applovin.impl.mediation.b.h hVar, Context context, g.a aVar) {
        if (hVar == null) {
            throw new IllegalArgumentException("No spec specified");
        } else if (context == null) {
            throw new IllegalArgumentException("No context specified");
        } else if (aVar != null) {
            g a2 = this.sdk.Cw().a(hVar, hVar.yL());
            if (a2 != null) {
                Activity CF = context instanceof Activity ? (Activity) context : this.sdk.CF();
                MaxAdapterParametersImpl a3 = MaxAdapterParametersImpl.a(hVar, str, maxAdFormat);
                this.sdk.Cx().a((f) hVar, CF);
                final long elapsedRealtime = SystemClock.elapsedRealtime();
                final g gVar = a2;
                final String str2 = str;
                final g.a aVar2 = aVar;
                final com.applovin.impl.mediation.b.h hVar2 = hVar;
                AnonymousClass1 r2 = new MaxSignalCollectionListener() {
                    public void onSignalCollected(String str) {
                        x unused = MediationServiceImpl.this.logger;
                        if (x.Fn()) {
                            x a = MediationServiceImpl.this.logger;
                            a.f("MediationService", "Signal collection successful from: " + gVar.getName() + " for Ad Unit ID: " + str2 + " with signal: \"" + str + "\"");
                        }
                        aVar2.a(g.a(hVar2, gVar, str, SystemClock.elapsedRealtime() - elapsedRealtime));
                        gVar.destroy();
                    }

                    public void onSignalCollectionFailed(String str) {
                        x unused = MediationServiceImpl.this.logger;
                        if (x.Fn()) {
                            x a = MediationServiceImpl.this.logger;
                            a.i("MediationService", "Signal collection failed from: " + gVar.getName() + " for Ad Unit ID: " + str2 + " with error message: \"" + str + "\"");
                        }
                        MediationServiceImpl.this.a(str, hVar2, gVar);
                        aVar2.a(g.b(hVar2, gVar, str, SystemClock.elapsedRealtime() - elapsedRealtime));
                        gVar.destroy();
                    }
                };
                if (!hVar.yK()) {
                    if (x.Fn()) {
                        x xVar = this.logger;
                        xVar.f("MediationService", "Collecting signal for adapter: " + a2.getName());
                    }
                    a2.a((MaxAdapterSignalCollectionParameters) a3, hVar, CF, (MaxSignalCollectionListener) r2);
                } else if (this.sdk.Cx().b((f) hVar)) {
                    if (x.Fn()) {
                        x xVar2 = this.logger;
                        xVar2.f("MediationService", "Collecting signal for now-initialized adapter: " + a2.getName());
                    }
                    a2.a((MaxAdapterSignalCollectionParameters) a3, hVar, CF, (MaxSignalCollectionListener) r2);
                } else {
                    if (x.Fn()) {
                        x xVar3 = this.logger;
                        xVar3.i("MediationService", "Skip collecting signal for not-initialized adapter: " + a2.getName());
                    }
                    aVar.a(g.a(hVar, "Adapter not initialized yet"));
                }
            } else {
                aVar.a(g.a(hVar, "Could not load adapter"));
            }
        } else {
            throw new IllegalArgumentException("No callback specified");
        }
    }

    private void a(c cVar, MaxAdListener maxAdListener) {
        Long l = (Long) this.sdk.a(com.applovin.impl.sdk.c.a.aJL);
        if (l.longValue() > 0) {
            AppLovinSdkUtils.runOnUiThreadDelayed(new MediationServiceImpl$$ExternalSyntheticLambda2(this, cVar, l, maxAdListener), l.longValue());
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void a(c cVar, Long l, MaxAdListener maxAdListener) {
        if (!cVar.xO().get()) {
            String str = "Ad (" + cVar.yB() + ") has not been displayed after " + l + "ms. Failing ad display...";
            x.H("MediationService", str);
            b(cVar, new MaxErrorImpl(-1, str), maxAdListener);
            this.sdk.Cf().ac(cVar);
        }
    }

    public void setCustomPostBodyData(JSONObject jSONObject) {
        this.amE.set(jSONObject);
    }

    public JSONObject getAndResetCustomPostBodyData() {
        return this.amE.getAndSet((Object) null);
    }

    /* access modifiers changed from: private */
    public void a(com.applovin.impl.mediation.b.a aVar, MaxError maxError, MaxAdListener maxAdListener) {
        a(maxError, aVar);
        destroyAd(aVar);
        m.a(maxAdListener, aVar.getAdUnitId(), maxError);
    }

    /* access modifiers changed from: private */
    public void b(com.applovin.impl.mediation.b.a aVar, MaxError maxError, MaxAdListener maxAdListener) {
        this.sdk.Ch().a(aVar, "DID_FAIL_DISPLAY");
        a(maxError, aVar, true);
        if (aVar.xO().compareAndSet(false, true)) {
            m.a(maxAdListener, (MaxAd) aVar, maxError);
        }
    }

    public void processAdLossPostback(com.applovin.impl.mediation.b.a aVar, Float f) {
        String f2 = f != null ? f.toString() : "";
        HashMap hashMap = new HashMap(1);
        hashMap.put("{MBR}", f2);
        a("mloss", (Map<String, String>) hashMap, (f) aVar);
    }

    /* access modifiers changed from: private */
    public void d(com.applovin.impl.mediation.b.a aVar) {
        this.sdk.Ch().a(aVar, "DID_LOAD");
        if (aVar.xz().endsWith("load")) {
            this.sdk.Ch().j(aVar);
        }
        HashMap hashMap = new HashMap(3);
        hashMap.put("{LOAD_TIME_MS}", String.valueOf(aVar.xJ()));
        if (aVar.getFormat().isFullscreenAd()) {
            u.a cH = this.sdk.Cf().cH(aVar.getAdUnitId());
            hashMap.put("{SHOW_ATTEMPT_COUNT}", String.valueOf(cH.Ff()));
            hashMap.put("{SHOW_ATTEMPT_TIMESTAMP_MS}", String.valueOf(cH.Fe()));
        }
        a("load", (Map<String, String>) hashMap, (f) aVar);
    }

    private void a(MaxError maxError, com.applovin.impl.mediation.b.a aVar) {
        HashMap hashMap = new HashMap(3);
        hashMap.put("{LOAD_TIME_MS}", String.valueOf(aVar.xJ()));
        if (aVar.getFormat().isFullscreenAd()) {
            u.a cH = this.sdk.Cf().cH(aVar.getAdUnitId());
            hashMap.put("{SHOW_ATTEMPT_COUNT}", String.valueOf(cH.Ff()));
            hashMap.put("{SHOW_ATTEMPT_TIMESTAMP_MS}", String.valueOf(cH.Fe()));
        }
        a("mlerr", (Map<String, String>) hashMap, maxError, (f) aVar);
    }

    public void processAdapterInitializationPostback(f fVar, long j, MaxAdapter.InitializationStatus initializationStatus, String str) {
        HashMap hashMap = new HashMap(2);
        hashMap.put("{INIT_STATUS}", String.valueOf(initializationStatus.getCode()));
        hashMap.put("{INIT_TIME_MS}", String.valueOf(j));
        a("minit", (Map<String, String>) hashMap, (MaxError) new MaxErrorImpl(str), fVar);
    }

    public void processRawAdImpressionPostback(com.applovin.impl.mediation.b.a aVar, a.C0067a aVar2) {
        this.sdk.Ch().a(aVar, "WILL_DISPLAY");
        if (aVar.xz().endsWith("mimp")) {
            this.sdk.Ch().j(aVar);
            m.a((MaxAdRevenueListener) aVar2, (MaxAd) aVar);
        }
        HashMap hashMap = new HashMap(2);
        if (aVar instanceof c) {
            hashMap.put("{TIME_TO_SHOW_MS}", String.valueOf(((c) aVar).ya()));
        }
        String emptyIfNull = StringUtils.emptyIfNull(this.sdk.Bz());
        if (!((Boolean) this.sdk.a(b.aOA)).booleanValue()) {
            emptyIfNull = "";
        }
        hashMap.put("{CUID}", emptyIfNull);
        a("mimp", (Map<String, String>) hashMap, (f) aVar);
    }

    public void processViewabilityAdImpressionPostback(e eVar, long j, a.C0067a aVar) {
        if (eVar.xz().endsWith("vimp")) {
            this.sdk.Ch().j(eVar);
            m.a((MaxAdRevenueListener) aVar, (MaxAd) eVar);
        }
        HashMap hashMap = new HashMap(3);
        hashMap.put("{VIEWABILITY_FLAGS}", String.valueOf(j));
        hashMap.put("{USED_VIEWABILITY_TIMER}", String.valueOf(eVar.yw()));
        String emptyIfNull = StringUtils.emptyIfNull(this.sdk.Bz());
        if (!((Boolean) this.sdk.a(b.aOA)).booleanValue()) {
            emptyIfNull = "";
        }
        hashMap.put("{CUID}", emptyIfNull);
        a("mvimp", (Map<String, String>) hashMap, (f) eVar);
    }

    public void processCallbackAdImpressionPostback(com.applovin.impl.mediation.b.a aVar, a.C0067a aVar2) {
        if (aVar.xz().endsWith("cimp")) {
            this.sdk.Ch().j(aVar);
            m.a((MaxAdRevenueListener) aVar2, (MaxAd) aVar);
        }
        HashMap hashMap = new HashMap(1);
        String emptyIfNull = StringUtils.emptyIfNull(this.sdk.Bz());
        if (!((Boolean) this.sdk.a(b.aOA)).booleanValue()) {
            emptyIfNull = "";
        }
        hashMap.put("{CUID}", emptyIfNull);
        a("mcimp", (Map<String, String>) hashMap, (f) aVar);
    }

    /* access modifiers changed from: private */
    public void a(com.applovin.impl.mediation.b.a aVar, a.C0067a aVar2) {
        this.sdk.Ch().a(aVar, "DID_CLICKED");
        this.sdk.Ch().a(aVar, "DID_CLICK");
        if (aVar.xz().endsWith("click")) {
            this.sdk.Ch().j(aVar);
            m.a((MaxAdRevenueListener) aVar2, (MaxAd) aVar);
        }
        HashMap hashMap = new HashMap(1);
        String emptyIfNull = StringUtils.emptyIfNull(this.sdk.Bz());
        if (!((Boolean) this.sdk.a(b.aOA)).booleanValue()) {
            emptyIfNull = "";
        }
        hashMap.put("{CUID}", emptyIfNull);
        a("mclick", (Map<String, String>) hashMap, (f) aVar);
    }

    public void processAdDisplayErrorPostbackForUserError(MaxError maxError, com.applovin.impl.mediation.b.a aVar) {
        a(maxError, aVar, false);
    }

    private void a(MaxError maxError, com.applovin.impl.mediation.b.a aVar, boolean z) {
        a("mierr", Collections.EMPTY_MAP, maxError, aVar, z);
    }

    /* access modifiers changed from: private */
    public void a(String str, com.applovin.impl.mediation.b.h hVar, g gVar) {
        HashMap hashMap = new HashMap(2);
        CollectionUtils.putStringIfValid("{ADAPTER_VERSION}", gVar.getAdapterVersion(), hashMap);
        CollectionUtils.putStringIfValid("{SDK_VERSION}", gVar.getSdkVersion(), hashMap);
        a("serr", (Map<String, String>) hashMap, (MaxError) new MaxErrorImpl(str), (f) hVar);
    }

    private void a(String str, Map<String, String> map, f fVar) {
        a(str, map, (MaxError) null, fVar);
    }

    private void a(String str, Map<String, String> map, MaxError maxError, f fVar) {
        a(str, map, maxError, fVar, true);
    }

    private void a(String str, Map<String, String> map, MaxError maxError, f fVar, boolean z) {
        Map<String, String> map2 = CollectionUtils.map(map);
        String str2 = "";
        map2.put("{PLACEMENT}", z ? StringUtils.emptyIfNull(fVar.getPlacement()) : str2);
        map2.put("{CUSTOM_DATA}", z ? StringUtils.emptyIfNull(fVar.yG()) : str2);
        if (fVar instanceof com.applovin.impl.mediation.b.a) {
            com.applovin.impl.mediation.b.a aVar = (com.applovin.impl.mediation.b.a) fVar;
            if (z) {
                str2 = StringUtils.emptyIfNull(aVar.getCreativeId());
            }
            map2.put("{CREATIVE_ID}", str2);
        }
        this.sdk.BO().a((com.applovin.impl.sdk.e.d) new com.applovin.impl.mediation.d.d(str, map2, maxError, fVar, this.sdk, z), q.b.MEDIATION_POSTBACKS);
    }

    public void onReceive(Intent intent, Map<String, Object> map) {
        if ("com.applovin.render_process_gone".equals(intent.getAction())) {
            Object Fd = this.sdk.Cf().Fd();
            if (Fd instanceof com.applovin.impl.mediation.b.a) {
                a((MaxError) MaxAdapterError.WEBVIEW_ERROR, (com.applovin.impl.mediation.b.a) Fd, true);
            }
        }
    }

    public class a implements a.C0067a, MaxAdListener, MaxAdRevenueListener, MaxAdViewAdListener, MaxRewardedAdListener {
        private final com.applovin.impl.mediation.b.a amK;
        private a.C0067a amL;

        public void a(a.C0067a aVar) {
            this.amL = aVar;
        }

        public void onAdRequestStarted(String str) {
        }

        public void onAdRevenuePaid(MaxAd maxAd) {
        }

        public a(com.applovin.impl.mediation.b.a aVar, a.C0067a aVar2) {
            this.amK = aVar;
            this.amL = aVar2;
        }

        public void onAdLoaded(MaxAd maxAd) {
            a(maxAd, (Bundle) null);
        }

        public void a(MaxAd maxAd, Bundle bundle) {
            this.amK.S(bundle);
            this.amK.xN();
            MediationServiceImpl.this.d(this.amK);
            m.a((MaxAdListener) this.amL, maxAd);
        }

        public void onAdLoadFailed(String str, MaxError maxError) {
            this.amK.xN();
            MediationServiceImpl.this.a(this.amK, maxError, (MaxAdListener) this.amL);
        }

        public void onAdDisplayed(MaxAd maxAd) {
            b(maxAd, (Bundle) null);
        }

        public void b(MaxAd maxAd, Bundle bundle) {
            this.amK.S(bundle);
            x unused = MediationServiceImpl.this.logger;
            if (x.Fn()) {
                MediationServiceImpl.this.logger.f("MediationService", "Scheduling impression for ad via callback...");
            }
            MediationServiceImpl.this.processCallbackAdImpressionPostback(this.amK, this.amL);
            MediationServiceImpl.this.sdk.BR().a(com.applovin.impl.sdk.d.f.aSU);
            MediationServiceImpl.this.sdk.BR().a(com.applovin.impl.sdk.d.f.aSX);
            if (maxAd.getFormat().isFullscreenAd()) {
                c cVar = (c) maxAd;
                if (cVar.yk()) {
                    MediationServiceImpl.this.sdk.Ch().a(this.amK, "DID_DISPLAY");
                    MediationServiceImpl.this.sdk.Cf().ab(this.amK);
                    m.b((MaxAdListener) this.amL, maxAd);
                    return;
                }
                x unused2 = MediationServiceImpl.this.logger;
                if (x.Fn()) {
                    MediationServiceImpl.this.logger.h("MediationService", "Received ad display callback before attempting show".concat(cVar.xF() ? " for hybrid ad" : ""));
                    return;
                }
                return;
            }
            MediationServiceImpl.this.sdk.Ch().a(this.amK, "DID_DISPLAY");
            m.b((MaxAdListener) this.amL, maxAd);
        }

        public void onAdHidden(MaxAd maxAd) {
            c(maxAd, (Bundle) null);
        }

        public void c(MaxAd maxAd, Bundle bundle) {
            this.amK.S(bundle);
            MediationServiceImpl.this.sdk.Ch().a((com.applovin.impl.mediation.b.a) maxAd, "DID_HIDE");
            AppLovinSdkUtils.runOnUiThreadDelayed(new MediationServiceImpl$a$$ExternalSyntheticLambda0(this, maxAd), maxAd instanceof c ? ((c) maxAd).yc() : 0);
        }

        /* access modifiers changed from: private */
        public /* synthetic */ void a(MaxAd maxAd) {
            if (maxAd.getFormat().isFullscreenAd()) {
                MediationServiceImpl.this.sdk.Cf().ac(maxAd);
            }
            m.c((MaxAdListener) this.amL, maxAd);
        }

        public void onAdClicked(MaxAd maxAd) {
            d(maxAd, (Bundle) null);
        }

        public void d(MaxAd maxAd, Bundle bundle) {
            this.amK.S(bundle);
            MediationServiceImpl.this.a(this.amK, this.amL);
            m.d((MaxAdListener) this.amL, maxAd);
        }

        public void onAdDisplayFailed(MaxAd maxAd, MaxError maxError) {
            a(maxAd, maxError, (Bundle) null);
        }

        public void a(MaxAd maxAd, MaxError maxError, Bundle bundle) {
            this.amK.S(bundle);
            MediationServiceImpl.this.b(this.amK, maxError, this.amL);
            if ((maxAd.getFormat() == MaxAdFormat.REWARDED || maxAd.getFormat() == MaxAdFormat.REWARDED_INTERSTITIAL) && (maxAd instanceof c)) {
                ((c) maxAd).yg();
            }
        }

        public void onRewardedVideoStarted(MaxAd maxAd) {
            m.e(this.amL, maxAd);
        }

        public void onRewardedVideoCompleted(MaxAd maxAd) {
            m.f(this.amL, maxAd);
        }

        public void onUserRewarded(MaxAd maxAd, MaxReward maxReward) {
            a(maxAd, maxReward, (Bundle) null);
        }

        public void a(MaxAd maxAd, MaxReward maxReward, Bundle bundle) {
            this.amK.S(bundle);
            m.a((MaxAdListener) this.amL, maxAd, maxReward);
            MediationServiceImpl.this.sdk.BO().a((com.applovin.impl.sdk.e.d) new com.applovin.impl.mediation.d.g((c) maxAd, MediationServiceImpl.this.sdk), q.b.MEDIATION_REWARD);
        }

        public void onAdExpanded(MaxAd maxAd) {
            e(maxAd, (Bundle) null);
        }

        public void e(MaxAd maxAd, Bundle bundle) {
            this.amK.S(bundle);
            m.g((MaxAdListener) this.amL, maxAd);
        }

        public void onAdCollapsed(MaxAd maxAd) {
            f(maxAd, (Bundle) null);
        }

        public void f(MaxAd maxAd, Bundle bundle) {
            this.amK.S(bundle);
            m.h((MaxAdListener) this.amL, maxAd);
        }
    }
}
