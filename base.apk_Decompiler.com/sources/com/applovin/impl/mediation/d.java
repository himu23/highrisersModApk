package com.applovin.impl.mediation;

import android.content.Context;
import android.os.SystemClock;
import com.applovin.impl.mediation.ads.a;
import com.applovin.impl.mediation.d.b;
import com.applovin.impl.mediation.d.c;
import com.applovin.impl.sdk.n;
import com.applovin.impl.sdk.utils.AppLovinSdkExtraParameterKey;
import com.applovin.impl.sdk.utils.CollectionUtils;
import com.applovin.impl.sdk.utils.StringUtils;
import com.applovin.impl.sdk.utils.m;
import com.applovin.impl.sdk.utils.u;
import com.applovin.impl.sdk.x;
import com.applovin.mediation.MaxAd;
import com.applovin.mediation.MaxAdFormat;
import com.applovin.mediation.MaxAdListener;
import com.applovin.mediation.MaxError;
import com.applovin.sdk.AppLovinSdkUtils;
import java.lang.ref.WeakReference;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONArray;

public class d {
    private final Map<String, c> als = new HashMap(4);
    private final Object alt = new Object();
    private final Map<String, com.applovin.impl.mediation.b.a> alu = new HashMap(4);
    private final Object alv = new Object();
    private final Map<String, Integer> alw = new HashMap();
    private final Object alx = new Object();
    /* access modifiers changed from: private */
    public final n sdk;

    private static class c {
        /* access modifiers changed from: private */
        public final AtomicBoolean alT;
        /* access modifiers changed from: private */
        public int alU;
        /* access modifiers changed from: private */
        public volatile a.C0067a alV;
        /* access modifiers changed from: private */
        public final String loadTag;

        static /* synthetic */ int e(c cVar) {
            int i = cVar.alU;
            cVar.alU = i + 1;
            return i;
        }

        private c(String str) {
            this.alT = new AtomicBoolean();
            this.loadTag = str;
        }
    }

    public enum a {
        PUBLISHER_INITIATED("publisher_initiated"),
        SEQUENTIAL_OR_PRECACHE("sequential_or_precache"),
        REFRESH("refresh"),
        EXPONENTIAL_RETRY("exponential_retry"),
        EXPIRED("expired"),
        NATIVE_AD_PLACER("native_ad_placer");
        
        private final String Jn;

        public String tU() {
            return this.Jn;
        }

        private a(String str) {
            this.Jn = str;
        }
    }

    public d(n nVar) {
        this.sdk = nVar;
    }

    public boolean bw(String str) {
        boolean z;
        synchronized (this.alv) {
            z = this.alu.get(str) != null;
        }
        return z;
    }

    public void o(String str, String str2) {
        synchronized (this.alt) {
            this.als.remove(q(str, str2));
        }
    }

    public void a(String str, String str2, MaxAdFormat maxAdFormat, a aVar, Map<String, Object> map, Map<String, Object> map2, Context context, a.C0067a aVar2) {
        String str3 = str2;
        a.C0067a aVar3 = aVar2;
        com.applovin.impl.mediation.b.a bx = (this.sdk.CE().xj() || u.ak(n.getApplicationContext())) ? null : bx(str);
        if (bx != null) {
            bx.setLoadTag(str3);
            bx.xC().uf().a(aVar3);
            aVar3.onAdLoaded(bx);
            if (bx.xz().endsWith("load")) {
                aVar3.onAdRevenuePaid(bx);
            }
        }
        c p = p(str, str2);
        if (p.alT.compareAndSet(false, true)) {
            if (bx == null) {
                a.C0067a unused = p.alV = aVar3;
            }
            Map synchronizedMap = Collections.synchronizedMap(new HashMap());
            synchronizedMap.put("art", aVar.tU());
            if (StringUtils.isValidString(str2)) {
                synchronizedMap.put("alt", str3);
            }
            a(str, maxAdFormat, map, map2, synchronizedMap, context, new b(map, map2, synchronizedMap, p, maxAdFormat, SystemClock.elapsedRealtime(), this, this.sdk, context));
            return;
        }
        if (!(p.alV == null || p.alV == aVar3)) {
            x.F("MediationAdLoadManager", "Attempting to load ad for same ad unit id (" + str + ") while another ad load is already in progress!");
        }
        a.C0067a unused2 = p.alV = aVar3;
    }

    /* access modifiers changed from: private */
    public void a(String str, MaxAdFormat maxAdFormat, Map<String, Object> map, Map<String, Object> map2, Map<String, Object> map3, Context context, a.C0067a aVar) {
        final long elapsedRealtime = SystemClock.elapsedRealtime();
        final Map<String, Object> map4 = map3;
        final String str2 = str;
        final MaxAdFormat maxAdFormat2 = maxAdFormat;
        final Map<String, Object> map5 = map;
        final Map<String, Object> map6 = map2;
        final Context context2 = context;
        final a.C0067a aVar2 = aVar;
        this.sdk.BO().a((com.applovin.impl.sdk.e.d) new b(str2, maxAdFormat2, map5, context, this.sdk, new b.a() {
            public void a(JSONArray jSONArray) {
                map4.put("sct_ms", Long.valueOf(SystemClock.elapsedRealtime() - elapsedRealtime));
                map4.put("calfc", Integer.valueOf(d.this.bA(str2)));
                d.this.sdk.BO().b((com.applovin.impl.sdk.e.d) new c(str2, maxAdFormat2, map5, map6, map4, jSONArray, context2, d.this.sdk, aVar2));
            }
        }), com.applovin.impl.mediation.e.c.f(maxAdFormat));
    }

    /* access modifiers changed from: private */
    public void b(com.applovin.impl.mediation.b.a aVar) {
        synchronized (this.alv) {
            if (this.alu.containsKey(aVar.getAdUnitId())) {
                x.H("AppLovinSdk", "Ad in cache already: " + aVar.getAdUnitId());
            }
            this.alu.put(aVar.getAdUnitId(), aVar);
        }
    }

    private com.applovin.impl.mediation.b.a bx(String str) {
        com.applovin.impl.mediation.b.a aVar;
        synchronized (this.alv) {
            aVar = this.alu.get(str);
            this.alu.remove(str);
        }
        return aVar;
    }

    private c p(String str, String str2) {
        c cVar;
        synchronized (this.alt) {
            String q = q(str, str2);
            cVar = this.als.get(q);
            if (cVar == null) {
                cVar = new c(str2);
                this.als.put(q, cVar);
            }
        }
        return cVar;
    }

    private String q(String str, String str2) {
        String str3;
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        if (str2 != null) {
            str3 = "-" + str2;
        } else {
            str3 = "";
        }
        sb.append(str3);
        return sb.toString();
    }

    public void by(String str) {
        synchronized (this.alx) {
            this.sdk.BN();
            if (x.Fn()) {
                x BN = this.sdk.BN();
                BN.f("MediationAdLoadManager", "Incrementing ad load failures count for ad unit ID: " + str);
            }
            Integer num = this.alw.get(str);
            if (num == null) {
                num = 0;
            }
            this.alw.put(str, Integer.valueOf(num.intValue() + 1));
        }
    }

    /* access modifiers changed from: private */
    public void bz(String str) {
        synchronized (this.alx) {
            this.sdk.BN();
            if (x.Fn()) {
                x BN = this.sdk.BN();
                BN.f("MediationAdLoadManager", "Clearing ad load failures count for ad unit ID: " + str);
            }
            this.alw.remove(str);
        }
    }

    public int bA(String str) {
        int intValue;
        synchronized (this.alx) {
            Integer num = this.alw.get(str);
            intValue = num != null ? num.intValue() : 0;
        }
        return intValue;
    }

    private static class b implements a.C0067a {
        private final WeakReference<Context> alO;
        private final d alP;
        private final c alQ;
        private final Map<String, Object> alR;
        private final int alS;
        private final Map<String, Object> extraParameters;
        private final MaxAdFormat format;
        private final Map<String, Object> localExtraParameters;
        private final n sdk;
        private long startTimeMillis;

        public void onAdClicked(MaxAd maxAd) {
        }

        public void onAdDisplayFailed(MaxAd maxAd, MaxError maxError) {
        }

        public void onAdDisplayed(MaxAd maxAd) {
        }

        public void onAdRequestStarted(String str) {
        }

        public void onAdRevenuePaid(MaxAd maxAd) {
        }

        private b(Map<String, Object> map, Map<String, Object> map2, Map<String, Object> map3, c cVar, MaxAdFormat maxAdFormat, long j, d dVar, n nVar, Context context) {
            this.sdk = nVar;
            this.alO = new WeakReference<>(context);
            this.alP = dVar;
            this.alQ = cVar;
            this.format = maxAdFormat;
            this.extraParameters = map2;
            this.localExtraParameters = map;
            this.alR = map3;
            this.startTimeMillis = j;
            if (CollectionUtils.getBoolean(map2, AppLovinSdkExtraParameterKey.DISABLE_AUTO_RETRIES)) {
                this.alS = -1;
            } else if (!maxAdFormat.isAdViewAd() || !CollectionUtils.getBoolean(map2, "auto_refresh_stopped")) {
                this.alS = ((Integer) nVar.a(com.applovin.impl.sdk.c.a.aJV)).intValue();
            } else {
                this.alS = Math.min(2, ((Integer) nVar.a(com.applovin.impl.sdk.c.a.aJV)).intValue());
            }
        }

        public void onAdLoaded(MaxAd maxAd) {
            com.applovin.impl.mediation.b.a aVar = (com.applovin.impl.mediation.b.a) maxAd;
            aVar.setLoadTag(this.alQ.loadTag);
            aVar.setRequestLatencyMillis(SystemClock.elapsedRealtime() - this.startTimeMillis);
            this.alP.bz(maxAd.getAdUnitId());
            int unused = this.alQ.alU = 0;
            if (this.alQ.alV != null) {
                aVar.xC().uf().a(this.alQ.alV);
                this.alQ.alV.onAdLoaded(aVar);
                if (aVar.xz().endsWith("load")) {
                    this.alQ.alV.onAdRevenuePaid(aVar);
                }
                a.C0067a unused2 = this.alQ.alV;
                a.C0067a unused3 = this.alQ.alV = null;
                if ((this.sdk.b(com.applovin.impl.sdk.c.a.aJU).contains(maxAd.getAdUnitId()) || this.sdk.a(com.applovin.impl.sdk.c.a.aJT, maxAd.getFormat())) && !this.sdk.CE().isEnabled() && !this.sdk.CE().xj()) {
                    Context context = (Context) this.alO.get();
                    if (context == null) {
                        context = n.getApplicationContext();
                    }
                    this.startTimeMillis = SystemClock.elapsedRealtime();
                    this.alR.put("art", a.SEQUENTIAL_OR_PRECACHE.tU());
                    this.alP.a(maxAd.getAdUnitId(), maxAd.getFormat(), this.localExtraParameters, this.extraParameters, this.alR, context, this);
                    return;
                }
                this.alQ.alT.set(false);
                return;
            }
            this.alP.b(aVar);
            this.alQ.alT.set(false);
        }

        public void onAdLoadFailed(String str, MaxError maxError) {
            this.alP.by(str);
            if (!this.sdk.a(com.applovin.impl.sdk.c.a.aJW, this.format) || this.alQ.alU >= this.alS) {
                int unused = this.alQ.alU = 0;
                this.alQ.alT.set(false);
                if (this.alQ.alV != null) {
                    MaxErrorImpl maxErrorImpl = (MaxErrorImpl) maxError;
                    maxErrorImpl.setLoadTag(this.alQ.loadTag);
                    maxErrorImpl.setRequestLatencyMillis(SystemClock.elapsedRealtime() - this.startTimeMillis);
                    m.a((MaxAdListener) this.alQ.alV, str, maxError);
                    a.C0067a unused2 = this.alQ.alV = null;
                    return;
                }
                return;
            }
            c.e(this.alQ);
            int pow = (int) Math.pow(2.0d, (double) this.alQ.alU);
            AppLovinSdkUtils.runOnUiThreadDelayed(new d$b$$ExternalSyntheticLambda0(this, pow, str), TimeUnit.SECONDS.toMillis((long) pow));
        }

        /* access modifiers changed from: private */
        public /* synthetic */ void d(int i, String str) {
            this.extraParameters.put("retry_delay_sec", Integer.valueOf(i));
            this.extraParameters.put("retry_attempt", Integer.valueOf(this.alQ.alU));
            Context context = (Context) this.alO.get();
            if (context == null) {
                context = n.getApplicationContext();
            }
            this.alR.put("art", a.EXPONENTIAL_RETRY.tU());
            this.alR.put("era", Integer.valueOf(this.alQ.alU));
            String str2 = str;
            this.alP.a(str2, this.format, this.localExtraParameters, this.extraParameters, this.alR, context, this);
        }

        public void onAdHidden(MaxAd maxAd) {
            throw new IllegalStateException("Wrong callback invoked for ad: " + maxAd);
        }
    }
}
