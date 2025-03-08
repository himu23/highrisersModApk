package com.applovin.impl.mediation.d;

import android.app.Activity;
import android.content.Context;
import android.os.SystemClock;
import com.applovin.impl.mediation.MaxAdWaterfallInfoImpl;
import com.applovin.impl.mediation.MaxErrorImpl;
import com.applovin.impl.mediation.MaxMediatedNetworkInfoImpl;
import com.applovin.impl.mediation.MaxNetworkResponseInfoImpl;
import com.applovin.impl.mediation.ads.a;
import com.applovin.impl.mediation.e.c;
import com.applovin.impl.sdk.e.d;
import com.applovin.impl.sdk.n;
import com.applovin.impl.sdk.utils.JsonUtils;
import com.applovin.impl.sdk.utils.m;
import com.applovin.impl.sdk.utils.u;
import com.applovin.impl.sdk.x;
import com.applovin.mediation.MaxAd;
import com.applovin.mediation.MaxAdFormat;
import com.applovin.mediation.MaxAdListener;
import com.applovin.mediation.MaxError;
import com.applovin.mediation.MaxNetworkResponseInfo;
import com.applovin.sdk.AppLovinSdkUtils;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONArray;
import org.json.JSONObject;

public class f extends d {
    private static final AtomicBoolean awA = new AtomicBoolean();
    /* access modifiers changed from: private */
    public final List<MaxNetworkResponseInfo> akY;
    /* access modifiers changed from: private */
    public final String awV;
    /* access modifiers changed from: private */
    public final MaxAdFormat awW;
    private final JSONObject awX;
    private final List<com.applovin.impl.mediation.b.a> awY;
    /* access modifiers changed from: private */
    public final a.C0067a awZ;
    /* access modifiers changed from: private */
    public final WeakReference<Context> axa;
    private long startTimeMillis;

    f(String str, MaxAdFormat maxAdFormat, Map<String, Object> map, JSONObject jSONObject, Context context, n nVar, a.C0067a aVar) {
        super("TaskProcessMediationWaterfall", nVar, str);
        this.awV = str;
        this.awW = maxAdFormat;
        this.awX = jSONObject;
        this.awZ = aVar;
        this.axa = new WeakReference<>(context);
        JSONArray jSONArray = JsonUtils.getJSONArray(jSONObject, "ads", new JSONArray());
        this.awY = new ArrayList(jSONArray.length());
        for (int i = 0; i < jSONArray.length(); i++) {
            this.awY.add(com.applovin.impl.mediation.b.a.a(i, map, JsonUtils.getJSONObject(jSONArray, i, (JSONObject) null), jSONObject, nVar));
        }
        this.akY = new ArrayList(this.awY.size());
    }

    public void run() {
        this.startTimeMillis = SystemClock.elapsedRealtime();
        if (this.awX.optBoolean("is_testing", false) && !this.sdk.CE().isEnabled() && awA.compareAndSet(false, true)) {
            AppLovinSdkUtils.runOnUiThread(new f$$ExternalSyntheticLambda0(this));
        }
        if (this.awY.size() > 0) {
            x xVar = this.logger;
            if (x.Fn()) {
                x xVar2 = this.logger;
                String str = this.tag;
                xVar2.f(str, "Starting waterfall for " + this.awW.getLabel() + " ad unit " + this.awV + " with " + this.awY.size() + " ad(s)...");
            }
            this.sdk.BO().b((d) new a(0, this.awY));
            return;
        }
        x xVar3 = this.logger;
        if (x.Fn()) {
            x xVar4 = this.logger;
            String str2 = this.tag;
            xVar4.h(str2, "No ads were returned from the server for " + this.awW.getLabel() + " ad unit " + this.awV);
        }
        u.a(this.awV, this.awW, this.awX, this.sdk);
        JSONObject jSONObject = JsonUtils.getJSONObject(this.awX, com.ironsource.mediationsdk.d.f, new JSONObject());
        long j = JsonUtils.getLong(jSONObject, "alfdcs", 0);
        MaxErrorImpl maxErrorImpl = new MaxErrorImpl(204, "MAX returned no eligible ads from any mediated networks for this app/device.");
        if (j > 0) {
            long millis = TimeUnit.SECONDS.toMillis(j);
            f$$ExternalSyntheticLambda1 f__externalsyntheticlambda1 = new f$$ExternalSyntheticLambda1(this, maxErrorImpl);
            if (JsonUtils.getBoolean(jSONObject, "alfdcs_iba", false).booleanValue()) {
                com.applovin.impl.sdk.utils.f.a(millis, this.sdk, f__externalsyntheticlambda1);
            } else {
                AppLovinSdkUtils.runOnUiThreadDelayed(f__externalsyntheticlambda1, millis);
            }
        } else {
            a((MaxError) maxErrorImpl);
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void zJ() {
        u.a("MAX SDK Not Initialized In Test Mode", "Test ads may not load. Please force close and restart the app if you experience issues.", (Context) this.sdk.CF());
    }

    /* access modifiers changed from: private */
    public void h(com.applovin.impl.mediation.b.a aVar) {
        this.sdk.CC().l(aVar);
        long elapsedRealtime = SystemClock.elapsedRealtime() - this.startTimeMillis;
        x xVar = this.logger;
        if (x.Fn()) {
            x xVar2 = this.logger;
            String str = this.tag;
            xVar2.g(str, "Waterfall loaded in " + elapsedRealtime + "ms from " + aVar.yA() + " for " + this.awW.getLabel() + " ad unit " + this.awV);
        }
        aVar.setWaterfall(new MaxAdWaterfallInfoImpl(aVar, elapsedRealtime, this.akY));
        m.a((MaxAdListener) this.awZ, (MaxAd) aVar);
    }

    /* access modifiers changed from: private */
    /* renamed from: c */
    public void a(MaxError maxError) {
        if (maxError.getCode() == 204) {
            this.sdk.BR().a(com.applovin.impl.sdk.d.f.aTj);
        } else if (maxError.getCode() == -5001) {
            this.sdk.BR().a(com.applovin.impl.sdk.d.f.aTk);
        } else {
            this.sdk.BR().a(com.applovin.impl.sdk.d.f.aTl);
        }
        ArrayList arrayList = new ArrayList(this.akY.size());
        for (MaxNetworkResponseInfo next : this.akY) {
            if (next.getAdLoadState() == MaxNetworkResponseInfo.AdLoadState.FAILED_TO_LOAD) {
                arrayList.add(next);
            }
        }
        if (arrayList.size() > 0) {
            StringBuilder sb = new StringBuilder("======FAILED AD LOADS======\n");
            int i = 0;
            while (i < arrayList.size()) {
                MaxNetworkResponseInfo maxNetworkResponseInfo = (MaxNetworkResponseInfo) arrayList.get(i);
                i++;
                sb.append(i);
                sb.append(") ");
                sb.append(maxNetworkResponseInfo.getMediatedNetwork().getName());
                sb.append("\n..code: ");
                sb.append(maxNetworkResponseInfo.getError().getCode());
                sb.append("\n..message: ");
                sb.append(maxNetworkResponseInfo.getError().getMessage());
                sb.append("\n");
            }
            ((MaxErrorImpl) maxError).setAdLoadFailureInfo(sb.toString());
        }
        long elapsedRealtime = SystemClock.elapsedRealtime() - this.startTimeMillis;
        x xVar = this.logger;
        if (x.Fn()) {
            x xVar2 = this.logger;
            String str = this.tag;
            xVar2.g(str, "Waterfall failed in " + elapsedRealtime + "ms for " + this.awW.getLabel() + " ad unit " + this.awV + " with error: " + maxError);
        }
        ((MaxErrorImpl) maxError).setWaterfall(new MaxAdWaterfallInfoImpl((com.applovin.impl.mediation.b.a) null, JsonUtils.getString(this.awX, "waterfall_name", ""), JsonUtils.getString(this.awX, "waterfall_test_name", ""), elapsedRealtime, this.akY));
        m.a((MaxAdListener) this.awZ, this.awV, maxError);
    }

    private class a extends d {
        /* access modifiers changed from: private */
        public final com.applovin.impl.mediation.b.a aml;
        /* access modifiers changed from: private */
        public final int axb;
        /* access modifiers changed from: private */
        public final List<com.applovin.impl.mediation.b.a> axc;
        /* access modifiers changed from: private */
        public final long startTimeMillis = SystemClock.elapsedRealtime();

        /* access modifiers changed from: private */
        public void ch(String str) {
        }

        a(int i, List<com.applovin.impl.mediation.b.a> list) {
            super(f.this.tag, f.this.sdk, f.this.awV);
            this.axb = i;
            this.aml = list.get(i);
            this.axc = list;
        }

        public void run() {
            x xVar = this.logger;
            if (x.Fn()) {
                x xVar2 = this.logger;
                String str = this.tag;
                xVar2.f(str, "Loading ad " + (this.axb + 1) + " of " + this.axc.size() + " from " + this.aml.yA() + " for " + f.this.awW.getLabel() + " ad unit " + f.this.awV);
            }
            ch("started to load ad");
            Context context = (Context) f.this.axa.get();
            this.sdk.Cy().loadThirdPartyMediatedAd(f.this.awV, this.aml, context instanceof Activity ? (Activity) context : this.sdk.CF(), new com.applovin.impl.mediation.e.a(f.this.awZ) {
                public void onAdLoaded(MaxAd maxAd) {
                    a.this.ch("loaded ad");
                    long elapsedRealtime = SystemClock.elapsedRealtime() - a.this.startTimeMillis;
                    x unused = a.this.logger;
                    if (x.Fn()) {
                        x d = a.this.logger;
                        String c = a.this.tag;
                        d.f(c, "Ad loaded in " + elapsedRealtime + "ms for " + f.this.awW.getLabel() + " ad unit " + f.this.awV);
                    }
                    com.applovin.impl.mediation.b.a aVar = (com.applovin.impl.mediation.b.a) maxAd;
                    a.this.a(aVar, MaxNetworkResponseInfo.AdLoadState.AD_LOADED, elapsedRealtime, (MaxError) null);
                    int e = a.this.axb;
                    while (true) {
                        e++;
                        if (e < a.this.axc.size()) {
                            a aVar2 = a.this;
                            aVar2.a((com.applovin.impl.mediation.b.a) aVar2.axc.get(e), MaxNetworkResponseInfo.AdLoadState.AD_LOAD_NOT_ATTEMPTED, -1, (MaxError) null);
                        } else {
                            f.this.h(aVar);
                            return;
                        }
                    }
                }

                public void onAdLoadFailed(String str, MaxError maxError) {
                    long elapsedRealtime = SystemClock.elapsedRealtime() - a.this.startTimeMillis;
                    x unused = a.this.logger;
                    if (x.Fn()) {
                        x i = a.this.logger;
                        String h = a.this.tag;
                        i.f(h, "Ad failed to load in " + elapsedRealtime + " ms for " + f.this.awW.getLabel() + " ad unit " + f.this.awV + " with error: " + maxError);
                    }
                    a aVar = a.this;
                    aVar.ch("failed to load ad: " + maxError.getCode());
                    a aVar2 = a.this;
                    aVar2.a(aVar2.aml, MaxNetworkResponseInfo.AdLoadState.FAILED_TO_LOAD, elapsedRealtime, maxError);
                    if (a.this.axb < a.this.axc.size() - 1) {
                        a.this.sdk.BO().a((d) new a(a.this.axb + 1, a.this.axc), c.f(f.this.awW));
                        return;
                    }
                    f.this.a((MaxError) new MaxErrorImpl(-5001, "MAX returned eligible ads from mediated networks, but all ads failed to load. Inspect getWaterfall() for more info."));
                }
            });
        }

        /* access modifiers changed from: private */
        public void a(com.applovin.impl.mediation.b.a aVar, MaxNetworkResponseInfo.AdLoadState adLoadState, long j, MaxError maxError) {
            MaxNetworkResponseInfo.AdLoadState adLoadState2 = adLoadState;
            f.this.akY.add(new MaxNetworkResponseInfoImpl(adLoadState2, new MaxMediatedNetworkInfoImpl(c.a(aVar.vt(), this.sdk)), aVar.getCredentials(), aVar.isBidding(), j, maxError));
        }
    }
}
