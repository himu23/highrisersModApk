package com.applovin.impl.sdk.e;

import com.applovin.impl.sdk.ad.d;
import com.applovin.impl.sdk.c.b;
import com.applovin.impl.sdk.d.f;
import com.applovin.impl.sdk.d.g;
import com.applovin.impl.sdk.n;
import com.applovin.impl.sdk.network.c;
import com.applovin.impl.sdk.utils.JsonUtils;
import com.applovin.impl.sdk.utils.StringUtils;
import com.applovin.impl.sdk.utils.i;
import com.applovin.impl.sdk.utils.p;
import com.applovin.impl.sdk.utils.u;
import com.applovin.impl.sdk.x;
import com.applovin.mediation.adapter.MaxAdapterError;
import com.applovin.sdk.AppLovinWebViewActivity;
import com.ironsource.i9;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.TimeUnit;
import org.json.JSONObject;

public abstract class k extends d {
    private final String aUd;
    protected final d azA;

    /* access modifiers changed from: protected */
    public abstract d I(JSONObject jSONObject);

    /* access modifiers changed from: protected */
    public abstract String zC();

    /* access modifiers changed from: protected */
    public abstract String zD();

    public k(d dVar, String str, n nVar) {
        super(str, nVar);
        this.azA = dVar;
        this.aUd = nVar.BI();
    }

    public void run() {
        Map<String, String> map;
        p.a aVar;
        Map<String, Object> map2;
        Map<String, Object> map3;
        x xVar = this.logger;
        if (x.Fn()) {
            x xVar2 = this.logger;
            String str = this.tag;
            xVar2.f(str, "Fetching next ad of zone: " + this.azA);
        }
        if (((Boolean) this.sdk.a(b.aOJ)).booleanValue() && u.Lz()) {
            x xVar3 = this.logger;
            if (x.Fn()) {
                this.logger.f(this.tag, "User is connected to a VPN");
            }
        }
        g BR = this.sdk.BR();
        BR.a(f.aSS);
        if (BR.b(f.aSV) == 0) {
            BR.b(f.aSV, System.currentTimeMillis());
        }
        try {
            JSONObject andResetCustomPostBody = this.sdk.BD().getAndResetCustomPostBody();
            boolean booleanValue = ((Boolean) this.sdk.a(b.aOa)).booleanValue();
            String str2 = i9.b;
            if (booleanValue) {
                aVar = p.a.gW(((Integer) this.sdk.a(b.aPT)).intValue());
                if (this.sdk.BV() != null) {
                    map3 = this.sdk.BV().a(HI(), false, true);
                } else {
                    map3 = this.sdk.BS().a(HI(), false, true);
                }
                JSONObject jSONObject = new JSONObject(map3);
                map = new HashMap<>();
                if (!((Boolean) this.sdk.a(b.aQc)).booleanValue() && !((Boolean) this.sdk.a(b.aPY)).booleanValue()) {
                    map.put("rid", UUID.randomUUID().toString());
                }
                if (!((Boolean) this.sdk.a(b.aPL)).booleanValue()) {
                    map.put(AppLovinWebViewActivity.INTENT_EXTRA_KEY_SDK_KEY, this.sdk.getSdkKey());
                }
                JsonUtils.putAll(jSONObject, andResetCustomPostBody);
                andResetCustomPostBody = jSONObject;
            } else {
                p.a gW = p.a.gW(((Integer) this.sdk.a(b.aPU)).intValue());
                if (this.sdk.BV() != null) {
                    map2 = this.sdk.BV().a(HI(), false, false);
                } else {
                    map2 = this.sdk.BS().a(HI(), false, false);
                }
                Map<String, String> s = u.s(map2);
                if (andResetCustomPostBody == null) {
                    andResetCustomPostBody = null;
                    str2 = i9.a;
                }
                aVar = gW;
                map = s;
            }
            if (u.ak(rQ())) {
                map.putAll(this.sdk.BD().getAndResetCustomQueryParams());
            }
            if (StringUtils.isValidString(this.aUd)) {
                map.put("sts", this.aUd);
            }
            a(BR);
            c.a<T> aT = c.D(this.sdk).cW(zC()).cY(zD()).k(map).cX(str2).l(zE()).ad(new JSONObject()).gE(((Integer) this.sdk.a(b.aNP)).intValue()).aP(((Boolean) this.sdk.a(b.aNQ)).booleanValue()).aQ(((Boolean) this.sdk.a(b.aNR)).booleanValue()).gF(((Integer) this.sdk.a(b.aNO)).intValue()).a(aVar).aT(true);
            if (andResetCustomPostBody != null) {
                aT.K(andResetCustomPostBody);
                aT.aU(((Boolean) this.sdk.a(b.aQm)).booleanValue());
            }
            final c<T> Ig = aT.Ig();
            AnonymousClass1 r2 = new w<JSONObject>(this.sdk, Ig) {
                /* renamed from: a */
                public void d(JSONObject jSONObject, int i) {
                    if (i == 200) {
                        JsonUtils.putLong(jSONObject, "ad_fetch_latency_millis", this.aHv.getLatencyMillis());
                        JsonUtils.putLong(jSONObject, "ad_fetch_response_size", this.aHv.HL());
                        k.this.q(jSONObject);
                        return;
                    }
                    k.this.e(i, MaxAdapterError.NO_FILL.getErrorMessage());
                    this.sdk.Cs().b(Ig.zL(), "fetchAd", i);
                }

                public void a(int i, String str, JSONObject jSONObject) {
                    k.this.e(i, str);
                    this.sdk.Cs().b(Ig.zL(), "fetchAd", i);
                }
            };
            r2.e(b.aLu);
            r2.f(b.aLv);
            this.sdk.BO().b((d) r2);
        } catch (Throwable th) {
            x xVar4 = this.logger;
            if (x.Fn()) {
                x xVar5 = this.logger;
                String str3 = this.tag;
                xVar5.c(str3, "Unable to fetch ad " + this.azA, th);
            }
            e(0, th.getMessage());
        }
    }

    /* access modifiers changed from: protected */
    public com.applovin.impl.sdk.ad.b getSource() {
        return this.azA.FS() ? com.applovin.impl.sdk.ad.b.APPLOVIN_PRIMARY_ZONE : com.applovin.impl.sdk.ad.b.APPLOVIN_CUSTOM_ZONE;
    }

    private Map<String, String> zE() {
        HashMap hashMap = new HashMap(3);
        hashMap.put("AppLovin-Zone-Id", this.azA.mQ());
        if (this.azA.getSize() != null) {
            hashMap.put("AppLovin-Ad-Size", this.azA.getSize().getLabel());
        }
        if (this.azA.getType() != null) {
            hashMap.put("AppLovin-Ad-Type", this.azA.getType().getLabel());
        }
        return hashMap;
    }

    /* access modifiers changed from: protected */
    public Map<String, String> HI() {
        HashMap hashMap = new HashMap(4);
        hashMap.put("zone_id", this.azA.mQ());
        if (this.azA.getSize() != null) {
            hashMap.put("size", this.azA.getSize().getLabel());
        }
        if (this.azA.getType() != null) {
            hashMap.put("require", this.azA.getType().getLabel());
        }
        return hashMap;
    }

    /* access modifiers changed from: protected */
    public void q(JSONObject jSONObject) {
        i.j(jSONObject, this.sdk);
        i.i(jSONObject, this.sdk);
        i.k(jSONObject, this.sdk);
        d.H(jSONObject);
        this.sdk.BO().b(I(jSONObject));
    }

    /* access modifiers changed from: protected */
    public void e(int i, String str) {
        x xVar = this.logger;
        if (x.Fn()) {
            x xVar2 = this.logger;
            String str2 = this.tag;
            xVar2.i(str2, "Unable to fetch " + this.azA + " ad: server returned " + i);
        }
        if (i == -800) {
            this.sdk.BR().a(f.aTb);
        }
    }

    private void a(g gVar) {
        long b = gVar.b(f.aSV);
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - b > TimeUnit.MINUTES.toMillis((long) ((Integer) this.sdk.a(b.aOk)).intValue())) {
            gVar.b(f.aSV, currentTimeMillis);
            gVar.c(f.aSW);
            gVar.c(f.aSX);
        }
    }
}
