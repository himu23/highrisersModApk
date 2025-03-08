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
import com.applovin.impl.sdk.e.q;
import com.applovin.impl.sdk.n;
import com.applovin.impl.sdk.utils.JsonUtils;
import com.applovin.impl.sdk.utils.f;
import com.applovin.impl.sdk.utils.m;
import com.applovin.impl.sdk.utils.r;
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
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONArray;
import org.json.JSONObject;

public class e extends d {
    private static final AtomicBoolean awA = new AtomicBoolean();
    /* access modifiers changed from: private */
    public final String adUnitId;
    private final List<MaxNetworkResponseInfo> akY;
    /* access modifiers changed from: private */
    public final WeakReference<Context> alO;
    private final JSONObject awB;
    /* access modifiers changed from: private */
    public final a.C0067a awC;
    private final Queue<com.applovin.impl.mediation.b.a> awD = new LinkedList();
    private final Object awE = new Object();
    private final Queue<com.applovin.impl.mediation.b.a> awF = new LinkedList();
    private final Object awG = new Object();
    /* access modifiers changed from: private */
    public final int awH;
    /* access modifiers changed from: private */
    public final AtomicBoolean awI = new AtomicBoolean();
    /* access modifiers changed from: private */
    public final AtomicBoolean awJ = new AtomicBoolean();
    /* access modifiers changed from: private */
    public final AtomicBoolean awK = new AtomicBoolean();
    /* access modifiers changed from: private */
    public com.applovin.impl.mediation.b.a awL;
    /* access modifiers changed from: private */
    public r awM;
    /* access modifiers changed from: private */
    public final MaxAdFormat format;
    private long startTimeMillis;

    private enum b {
        BIDDING,
        TAG
    }

    public e(String str, MaxAdFormat maxAdFormat, Map<String, Object> map, JSONObject jSONObject, Context context, n nVar, a.C0067a aVar) {
        super("TaskProcessMediationWaterfallV2", nVar, str);
        this.adUnitId = str;
        this.format = maxAdFormat;
        this.awB = jSONObject;
        this.awC = aVar;
        this.alO = new WeakReference<>(context);
        JSONArray jSONArray = JsonUtils.getJSONArray(jSONObject, "ads", new JSONArray());
        for (int i = 0; i < jSONArray.length(); i++) {
            com.applovin.impl.mediation.b.a a2 = com.applovin.impl.mediation.b.a.a(i, map, JsonUtils.getJSONObject(jSONArray, i, (JSONObject) null), jSONObject, nVar);
            if (a2.isBidding()) {
                this.awF.add(a2);
            } else {
                this.awD.add(a2);
            }
        }
        int size = this.awD.size() + this.awF.size();
        this.awH = size;
        this.akY = new ArrayList(size);
    }

    public void run() {
        this.startTimeMillis = SystemClock.elapsedRealtime();
        if (this.awB.optBoolean("is_testing", false) && !this.sdk.CE().isEnabled() && awA.compareAndSet(false, true)) {
            AppLovinSdkUtils.runOnUiThread(new e$$ExternalSyntheticLambda0(this));
        }
        if (this.awH == 0) {
            x xVar = this.logger;
            if (x.Fn()) {
                x xVar2 = this.logger;
                String str = this.tag;
                xVar2.h(str, "No ads were returned from the server for " + this.format.getLabel() + " ad unit " + this.adUnitId);
            }
            u.a(this.adUnitId, this.format, this.awB, this.sdk);
            JSONObject jSONObject = JsonUtils.getJSONObject(this.awB, com.ironsource.mediationsdk.d.f, new JSONObject());
            long j = JsonUtils.getLong(jSONObject, "alfdcs", 0);
            MaxErrorImpl maxErrorImpl = new MaxErrorImpl(204, "MAX returned no eligible ads from any mediated networks for this app/device.");
            if (j > 0) {
                long millis = TimeUnit.SECONDS.toMillis(j);
                e$$ExternalSyntheticLambda1 e__externalsyntheticlambda1 = new e$$ExternalSyntheticLambda1(this, maxErrorImpl);
                if (JsonUtils.getBoolean(jSONObject, "alfdcs_iba", false).booleanValue()) {
                    f.a(millis, this.sdk, e__externalsyntheticlambda1);
                } else {
                    AppLovinSdkUtils.runOnUiThreadDelayed(e__externalsyntheticlambda1, millis);
                }
            } else {
                a((MaxError) maxErrorImpl);
            }
        } else {
            x xVar3 = this.logger;
            if (x.Fn()) {
                x xVar4 = this.logger;
                String str2 = this.tag;
                xVar4.f(str2, "Starting waterfall for " + this.format.getLabel() + " ad unit " + this.adUnitId + " with " + this.awH + " ad(s)...");
            }
            a(b.TAG);
            a(b.BIDDING);
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void zJ() {
        u.a("MAX SDK Not Initialized In Test Mode", "Test ads may not load. Please force close and restart the app if you experience issues.", (Context) this.sdk.CF());
    }

    /* access modifiers changed from: private */
    public boolean a(b bVar) {
        com.applovin.impl.mediation.b.a c = c(bVar);
        if (c == null) {
            d(bVar);
            return false;
        }
        this.sdk.BO().a((d) new a(c, bVar), q.b.MEDIATION_MAIN);
        return true;
    }

    /* access modifiers changed from: private */
    public com.applovin.impl.mediation.b.a b(b bVar) {
        return a(bVar, true);
    }

    private com.applovin.impl.mediation.b.a c(b bVar) {
        return a(bVar, false);
    }

    private com.applovin.impl.mediation.b.a a(b bVar, boolean z) {
        com.applovin.impl.mediation.b.a aVar;
        com.applovin.impl.mediation.b.a aVar2;
        if (bVar == b.BIDDING) {
            synchronized (this.awG) {
                aVar2 = (com.applovin.impl.mediation.b.a) (z ? this.awF.peek() : this.awF.poll());
            }
            return aVar2;
        }
        synchronized (this.awE) {
            aVar = (com.applovin.impl.mediation.b.a) (z ? this.awD.peek() : this.awD.poll());
        }
        return aVar;
    }

    /* access modifiers changed from: private */
    public void d(b bVar) {
        if (b.BIDDING == bVar) {
            this.awI.compareAndSet(false, true);
        } else if (b.TAG == bVar) {
            this.awJ.compareAndSet(false, true);
        }
    }

    /* access modifiers changed from: private */
    public void h(com.applovin.impl.mediation.b.a aVar) {
        a(aVar, (com.applovin.impl.mediation.b.a) null);
    }

    /* access modifiers changed from: private */
    public void a(com.applovin.impl.mediation.b.a aVar, com.applovin.impl.mediation.b.a aVar2) {
        if (this.awK.compareAndSet(false, true)) {
            zI();
            zH();
            this.sdk.CC().b(aVar, aVar2);
            long elapsedRealtime = SystemClock.elapsedRealtime() - this.startTimeMillis;
            x xVar = this.logger;
            if (x.Fn()) {
                x xVar2 = this.logger;
                String str = this.tag;
                xVar2.g(str, "Waterfall loaded in " + elapsedRealtime + "ms from " + aVar.yA() + " for " + this.format + " ad unit " + this.adUnitId);
            }
            aVar.setWaterfall(new MaxAdWaterfallInfoImpl(aVar, elapsedRealtime, this.akY));
            m.a((MaxAdListener) this.awC, (MaxAd) aVar);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: c */
    public void a(MaxError maxError) {
        int i = 0;
        if (this.awK.compareAndSet(false, true)) {
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
                xVar2.g(str, "Waterfall failed in " + elapsedRealtime + "ms for " + this.format + " ad unit " + this.adUnitId + " with error: " + maxError);
            }
            ((MaxErrorImpl) maxError).setWaterfall(new MaxAdWaterfallInfoImpl((com.applovin.impl.mediation.b.a) null, JsonUtils.getString(this.awB, "waterfall_name", ""), JsonUtils.getString(this.awB, "waterfall_test_name", ""), elapsedRealtime, this.akY));
            m.a((MaxAdListener) this.awC, this.adUnitId, maxError);
        }
    }

    private void zH() {
        a(this.awD);
        a(this.awF);
    }

    private void a(Queue<com.applovin.impl.mediation.b.a> queue) {
        for (com.applovin.impl.mediation.b.a a2 : queue) {
            a(a2, MaxNetworkResponseInfo.AdLoadState.AD_LOAD_NOT_ATTEMPTED, -1, (MaxError) null);
        }
    }

    private void zI() {
        r rVar = this.awM;
        if (rVar != null) {
            rVar.tT();
            this.awM = null;
        }
    }

    /* access modifiers changed from: private */
    public void a(com.applovin.impl.mediation.b.a aVar, MaxNetworkResponseInfo.AdLoadState adLoadState, long j, MaxError maxError) {
        MaxNetworkResponseInfo.AdLoadState adLoadState2 = adLoadState;
        this.akY.add(new MaxNetworkResponseInfoImpl(adLoadState2, new MaxMediatedNetworkInfoImpl(c.a(aVar.vt(), this.sdk)), aVar.getCredentials(), aVar.isBidding(), j, maxError));
    }

    private class a extends d {
        /* access modifiers changed from: private */
        public final com.applovin.impl.mediation.b.a aml;
        /* access modifiers changed from: private */
        public final String awN;
        /* access modifiers changed from: private */
        public final b awO;
        /* access modifiers changed from: private */
        public final int awP;
        /* access modifiers changed from: private */
        public final long startTimeMillis;

        /* access modifiers changed from: private */
        public void ch(String str) {
        }

        private a(com.applovin.impl.mediation.b.a aVar, b bVar) {
            super(e.this.tag, e.this.sdk, e.this.adUnitId);
            this.awN = this.tag + ":" + bVar;
            this.startTimeMillis = SystemClock.elapsedRealtime();
            this.aml = aVar;
            this.awO = bVar;
            this.awP = aVar.ah() + 1;
        }

        public void run() {
            x xVar = this.logger;
            if (x.Fn()) {
                x xVar2 = this.logger;
                String str = this.awN;
                xVar2.f(str, "Loading ad " + this.awP + " of " + e.this.awH + " from " + this.aml.yA() + " for " + e.this.format + " ad unit " + e.this.adUnitId);
            }
            ch("started to load ad");
            Context context = (Context) e.this.alO.get();
            this.sdk.Cy().loadThirdPartyMediatedAd(e.this.adUnitId, this.aml, context instanceof Activity ? (Activity) context : this.sdk.CF(), new com.applovin.impl.mediation.e.a(e.this.awC) {
                public void onAdLoaded(MaxAd maxAd) {
                    long j;
                    boolean z;
                    com.applovin.impl.mediation.b.a aVar;
                    int i;
                    a.this.ch("loaded ad");
                    com.applovin.impl.mediation.b.a aVar2 = (com.applovin.impl.mediation.b.a) maxAd;
                    long elapsedRealtime = SystemClock.elapsedRealtime() - a.this.startTimeMillis;
                    x unused = a.this.logger;
                    if (x.Fn()) {
                        x e = a.this.logger;
                        String c = a.this.awN;
                        e.f(c, "Ad (" + a.this.awP + ") loaded in " + elapsedRealtime + "ms for " + e.this.format + " ad unit " + e.this.adUnitId);
                    }
                    e.this.a(aVar2, MaxNetworkResponseInfo.AdLoadState.AD_LOADED, elapsedRealtime, (MaxError) null);
                    e.this.d(a.this.awO);
                    if (b.BIDDING == a.this.awO) {
                        z = e.this.awJ.get();
                        j = aVar2.xu();
                    } else {
                        z = e.this.awI.get();
                        j = aVar2.xt();
                    }
                    if (z || j == 0) {
                        if (a.this.i(aVar2)) {
                            aVar = aVar2;
                            aVar2 = e.this.awL;
                        } else {
                            aVar = e.this.awL;
                        }
                        e.this.a(aVar2, aVar);
                        return;
                    }
                    com.applovin.impl.mediation.b.a unused2 = e.this.awL = aVar2;
                    if (i >= 0) {
                        r unused3 = e.this.awM = r.b(j, a.this.sdk, new e$a$1$$ExternalSyntheticLambda0(this));
                    }
                }

                /* access modifiers changed from: private */
                public /* synthetic */ void zK() {
                    e.this.h(e.this.awL);
                }

                public void onAdLoadFailed(String str, MaxError maxError) {
                    long elapsedRealtime = SystemClock.elapsedRealtime() - a.this.startTimeMillis;
                    x unused = a.this.logger;
                    if (x.Fn()) {
                        x i = a.this.logger;
                        String c = a.this.awN;
                        i.f(c, "Ad (" + a.this.awP + ") failed to load in " + elapsedRealtime + "ms for " + e.this.format + " ad unit " + str + " with error: " + maxError);
                    }
                    a aVar = a.this;
                    aVar.ch("failed to load ad: " + maxError.getCode());
                    e.this.a(a.this.aml, MaxNetworkResponseInfo.AdLoadState.FAILED_TO_LOAD, elapsedRealtime, maxError);
                    if (!e.this.awK.get()) {
                        if (e.this.awL != null) {
                            if (a.this.i(e.this.b(a.this.awO))) {
                                e.this.h(e.this.awL);
                                return;
                            }
                        }
                        if ((!e.this.a(a.this.awO)) && e.this.awJ.get() && e.this.awI.get()) {
                            e.this.a((MaxError) new MaxErrorImpl(-5001, "MAX returned eligible ads from mediated networks, but all ads failed to load. Inspect getWaterfall() for more info."));
                        }
                    }
                }
            });
        }

        /* access modifiers changed from: private */
        public boolean i(com.applovin.impl.mediation.b.a aVar) {
            if (e.this.awL == null) {
                return false;
            }
            if (aVar == null) {
                return true;
            }
            double xv = e.this.awL.xv();
            double xv2 = aVar.xv();
            if (xv < 0.0d || xv2 < 0.0d) {
                if (e.this.awL.ah() < aVar.ah()) {
                    return true;
                }
                return false;
            } else if (xv > xv2) {
                return true;
            } else {
                return false;
            }
        }
    }
}
