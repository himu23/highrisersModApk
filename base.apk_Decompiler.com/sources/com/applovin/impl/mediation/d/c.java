package com.applovin.impl.mediation.d;

import android.content.Context;
import com.applovin.impl.mediation.MaxErrorImpl;
import com.applovin.impl.mediation.ads.a;
import com.applovin.impl.sdk.c.b;
import com.applovin.impl.sdk.d.f;
import com.applovin.impl.sdk.d.g;
import com.applovin.impl.sdk.e.d;
import com.applovin.impl.sdk.e.w;
import com.applovin.impl.sdk.n;
import com.applovin.impl.sdk.r;
import com.applovin.impl.sdk.utils.AppLovinSdkExtraParameterKey;
import com.applovin.impl.sdk.utils.CollectionUtils;
import com.applovin.impl.sdk.utils.JsonUtils;
import com.applovin.impl.sdk.utils.StringUtils;
import com.applovin.impl.sdk.utils.i;
import com.applovin.impl.sdk.utils.m;
import com.applovin.impl.sdk.utils.p;
import com.applovin.impl.sdk.utils.u;
import com.applovin.impl.sdk.v;
import com.applovin.impl.sdk.x;
import com.applovin.impl.sdk.y;
import com.applovin.mediation.MaxAdFormat;
import com.applovin.mediation.MaxAdListener;
import com.applovin.mediation.MaxError;
import com.applovin.mediation.adapter.MaxAdapterError;
import com.applovin.sdk.AppLovinWebViewActivity;
import com.ironsource.i9;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.TimeUnit;
import kotlin.UByte$$ExternalSyntheticBackport0;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class c extends d {
    private final Context E;
    private final String adUnitId;
    private final Map<String, Object> alR;
    private final a.C0067a amL;
    private final JSONArray aws;
    private final Map<String, Object> extraParameters;
    private final MaxAdFormat format;
    private final Map<String, Object> localExtraParameters;

    public c(String str, MaxAdFormat maxAdFormat, Map<String, Object> map, Map<String, Object> map2, Map<String, Object> map3, JSONArray jSONArray, Context context, n nVar, a.C0067a aVar) {
        super("TaskFetchMediatedAd", nVar, str);
        this.adUnitId = str;
        this.format = maxAdFormat;
        this.localExtraParameters = map;
        this.extraParameters = map2;
        this.alR = map3;
        this.aws = jSONArray;
        this.E = context;
        this.amL = aVar;
    }

    public void run() {
        x xVar = this.logger;
        if (x.Fn()) {
            x xVar2 = this.logger;
            String str = this.tag;
            xVar2.f(str, "Fetching next ad for " + this.format.getLabel() + " ad unit " + this.adUnitId);
        }
        v.Fg();
        if (((Boolean) this.sdk.a(b.aOJ)).booleanValue() && u.Lz()) {
            x xVar3 = this.logger;
            if (x.Fn()) {
                this.logger.f(this.tag, "User is connected to a VPN");
            }
        }
        g BR = this.sdk.BR();
        BR.a(f.aTh);
        if (BR.b(f.aSV) == 0) {
            BR.b(f.aSV, System.currentTimeMillis());
        }
        try {
            JSONObject zF = zF();
            HashMap hashMap = new HashMap();
            if (!((Boolean) this.sdk.a(b.aQa)).booleanValue() && !((Boolean) this.sdk.a(b.aPY)).booleanValue()) {
                hashMap.put("rid", UUID.randomUUID().toString());
            }
            if (!((Boolean) this.sdk.a(b.aPL)).booleanValue()) {
                hashMap.put(AppLovinWebViewActivity.INTENT_EXTRA_KEY_SDK_KEY, this.sdk.getSdkKey());
            }
            if (this.sdk.CE().isEnabled()) {
                hashMap.put("test_mode", "1");
            }
            List<String> xk = this.sdk.CE().xk();
            String str2 = this.sdk.getSettings().getExtraParameters().get(AppLovinSdkExtraParameterKey.FILTER_AD_NETWORK);
            if (xk != null) {
                if (!xk.isEmpty()) {
                    String m = UByte$$ExternalSyntheticBackport0.m((CharSequence) ",", (Iterable) xk);
                    hashMap.put("filter_ad_network", m);
                    if (!this.sdk.CE().isEnabled()) {
                        hashMap.put("fhkZsVqYC7", "1");
                    }
                    if (this.sdk.CE().xj()) {
                        hashMap.put("force_ad_network", m);
                    }
                    a(BR);
                    final com.applovin.impl.sdk.network.c<T> Ig = com.applovin.impl.sdk.network.c.D(this.sdk).cX(i9.b).l(zE()).cW(zC()).cY(zD()).k(hashMap).K(zF).aU(((Boolean) this.sdk.a(com.applovin.impl.sdk.c.a.aKf)).booleanValue()).ad(new JSONObject()).gF(((Long) this.sdk.a(com.applovin.impl.sdk.c.a.aJj)).intValue()).gE(((Integer) this.sdk.a(b.aNP)).intValue()).gG(((Long) this.sdk.a(com.applovin.impl.sdk.c.a.aJi)).intValue()).a(p.a.gW(((Integer) this.sdk.a(b.aPR)).intValue())).aT(true).Ig();
                    AnonymousClass1 r1 = new w<JSONObject>(this.sdk, Ig) {
                        /* renamed from: a */
                        public void d(JSONObject jSONObject, int i) {
                            if (i == 200) {
                                JsonUtils.putLong(jSONObject, "ad_fetch_latency_millis", this.aHv.getLatencyMillis());
                                JsonUtils.putLong(jSONObject, "ad_fetch_response_size", this.aHv.HL());
                                c.this.q(jSONObject);
                                return;
                            }
                            c.this.e(i, (String) null);
                            this.sdk.Cs().b(Ig.zL(), "fetchMediatedAd", i);
                        }

                        public void a(int i, String str, JSONObject jSONObject) {
                            c.this.e(i, str);
                            this.sdk.Cs().b(Ig.zL(), "fetchMediatedAd", i);
                        }
                    };
                    r1.e(com.applovin.impl.sdk.c.a.aJg);
                    r1.f(com.applovin.impl.sdk.c.a.aJh);
                    this.sdk.BO().b((d) r1);
                }
            }
            if (StringUtils.isValidString(str2)) {
                hashMap.put("filter_ad_network", str2);
            }
            a(BR);
            final com.applovin.impl.sdk.network.c<T> Ig2 = com.applovin.impl.sdk.network.c.D(this.sdk).cX(i9.b).l(zE()).cW(zC()).cY(zD()).k(hashMap).K(zF).aU(((Boolean) this.sdk.a(com.applovin.impl.sdk.c.a.aKf)).booleanValue()).ad(new JSONObject()).gF(((Long) this.sdk.a(com.applovin.impl.sdk.c.a.aJj)).intValue()).gE(((Integer) this.sdk.a(b.aNP)).intValue()).gG(((Long) this.sdk.a(com.applovin.impl.sdk.c.a.aJi)).intValue()).a(p.a.gW(((Integer) this.sdk.a(b.aPR)).intValue())).aT(true).Ig();
            AnonymousClass1 r12 = new w<JSONObject>(this.sdk, Ig2) {
                /* renamed from: a */
                public void d(JSONObject jSONObject, int i) {
                    if (i == 200) {
                        JsonUtils.putLong(jSONObject, "ad_fetch_latency_millis", this.aHv.getLatencyMillis());
                        JsonUtils.putLong(jSONObject, "ad_fetch_response_size", this.aHv.HL());
                        c.this.q(jSONObject);
                        return;
                    }
                    c.this.e(i, (String) null);
                    this.sdk.Cs().b(Ig2.zL(), "fetchMediatedAd", i);
                }

                public void a(int i, String str, JSONObject jSONObject) {
                    c.this.e(i, str);
                    this.sdk.Cs().b(Ig2.zL(), "fetchMediatedAd", i);
                }
            };
            r12.e(com.applovin.impl.sdk.c.a.aJg);
            r12.f(com.applovin.impl.sdk.c.a.aJh);
            this.sdk.BO().b((d) r12);
        } catch (Throwable th) {
            x xVar4 = this.logger;
            if (x.Fn()) {
                x xVar5 = this.logger;
                String str3 = this.tag;
                xVar5.c(str3, "Unable to fetch ad for ad unit " + this.adUnitId, th);
            }
            throw new RuntimeException("Unable to fetch ad: " + th);
        }
    }

    private String zC() {
        return com.applovin.impl.mediation.e.b.b(this.sdk);
    }

    private String zD() {
        return com.applovin.impl.mediation.e.b.c(this.sdk);
    }

    /* access modifiers changed from: private */
    public void q(JSONObject jSONObject) {
        try {
            i.j(jSONObject, this.sdk);
            i.i(jSONObject, this.sdk);
            i.k(jSONObject, this.sdk);
            com.applovin.impl.mediation.e.b.d(jSONObject, this.sdk);
            com.applovin.impl.mediation.e.b.e(jSONObject, this.sdk);
            com.applovin.impl.mediation.e.b.f(jSONObject, this.sdk);
            com.applovin.impl.mediation.e.b.z(jSONObject);
            com.applovin.impl.sdk.g.o(this.sdk);
            MaxAdFormat formatFromString = MaxAdFormat.formatFromString(JsonUtils.getString(jSONObject, "ad_format", (String) null));
            String str = "UNKNOWN";
            if (!((Boolean) this.sdk.a(b.aQR)).booleanValue()) {
                if (this.format != formatFromString) {
                    if (formatFromString != null) {
                        str = formatFromString.getLabel();
                    }
                    x.H(this.tag, "Ad format requested (" + this.format.getLabel() + ") does not match ad format for ad unit id " + this.adUnitId + " (" + str + ")");
                }
                r(jSONObject);
            } else if (u.a(this.format, formatFromString)) {
                r(jSONObject);
            } else {
                if (formatFromString != null) {
                    str = formatFromString.getLabel();
                }
                String str2 = "Requested ad format " + this.format.getLabel() + " is not compatible with received ad format " + str;
                x.H(this.tag, str2);
                this.amL.onAdLoadFailed(this.adUnitId, new MaxAdapterError(MaxAdapterError.INVALID_CONFIGURATION, 0, str2));
                this.sdk.Cs().a(r.a.INTEGRATION_ERROR, "incompatible_ad_format", "pubId=" + ((Long) this.sdk.a(b.aKp)) + ",adUnitId=" + this.adUnitId + ",adInstanceFormat=" + this.format.getLabel() + ",adResponseFormat=" + str);
            }
        } catch (Throwable th) {
            x xVar = this.logger;
            if (x.Fn()) {
                this.logger.c(this.tag, "Unable to process mediated ad response for ad unit " + this.adUnitId, th);
            }
            throw new RuntimeException("Unable to process ad: " + th);
        }
    }

    /* JADX WARNING: type inference failed for: r1v2, types: [com.applovin.impl.sdk.e.d] */
    /* JADX WARNING: type inference failed for: r10v1, types: [com.applovin.impl.mediation.d.f] */
    /* JADX WARNING: type inference failed for: r2v5, types: [com.applovin.impl.mediation.d.e] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void r(org.json.JSONObject r19) {
        /*
            r18 = this;
            r0 = r18
            com.applovin.impl.sdk.n r1 = r0.sdk
            com.applovin.impl.sdk.c.b<java.lang.String> r2 = com.applovin.impl.sdk.c.a.aKb
            com.applovin.mediation.MaxAdFormat r3 = r0.format
            boolean r1 = r1.a((com.applovin.impl.sdk.c.b<java.lang.String>) r2, (com.applovin.mediation.MaxAdFormat) r3)
            if (r1 == 0) goto L_0x0023
            com.applovin.impl.mediation.d.e r1 = new com.applovin.impl.mediation.d.e
            java.lang.String r3 = r0.adUnitId
            com.applovin.mediation.MaxAdFormat r4 = r0.format
            java.util.Map<java.lang.String, java.lang.Object> r5 = r0.localExtraParameters
            android.content.Context r7 = r0.E
            com.applovin.impl.sdk.n r8 = r0.sdk
            com.applovin.impl.mediation.ads.a$a r9 = r0.amL
            r2 = r1
            r6 = r19
            r2.<init>(r3, r4, r5, r6, r7, r8, r9)
            goto L_0x003b
        L_0x0023:
            com.applovin.impl.mediation.d.f r1 = new com.applovin.impl.mediation.d.f
            java.lang.String r11 = r0.adUnitId
            com.applovin.mediation.MaxAdFormat r12 = r0.format
            java.util.Map<java.lang.String, java.lang.Object> r13 = r0.localExtraParameters
            android.content.Context r15 = r0.E
            com.applovin.impl.sdk.n r2 = r0.sdk
            com.applovin.impl.mediation.ads.a$a r3 = r0.amL
            r10 = r1
            r14 = r19
            r16 = r2
            r17 = r3
            r10.<init>(r11, r12, r13, r14, r15, r16, r17)
        L_0x003b:
            com.applovin.impl.sdk.n r2 = r0.sdk
            com.applovin.impl.sdk.e.q r2 = r2.BO()
            r2.b((com.applovin.impl.sdk.e.d) r1)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.applovin.impl.mediation.d.c.r(org.json.JSONObject):void");
    }

    /* access modifiers changed from: private */
    public void e(int i, String str) {
        MaxErrorImpl maxErrorImpl;
        x xVar = this.logger;
        if (x.Fn()) {
            x xVar2 = this.logger;
            String str2 = this.tag;
            xVar2.i(str2, "Unable to fetch ad for ad unit " + this.adUnitId + ": server returned " + i);
        }
        if (i == -800) {
            this.sdk.BR().a(f.aTi);
        }
        if (i == -1009) {
            maxErrorImpl = new MaxErrorImpl(-1009, str);
        } else if (i == -1001) {
            maxErrorImpl = new MaxErrorImpl(-1001, str);
        } else if (StringUtils.isValidString(str)) {
            maxErrorImpl = new MaxErrorImpl(-1000, str);
        } else {
            maxErrorImpl = new MaxErrorImpl(-1);
        }
        m.a((MaxAdListener) this.amL, this.adUnitId, (MaxError) maxErrorImpl);
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

    private Map<String, String> zE() {
        HashMap hashMap = new HashMap(2);
        hashMap.put("AppLovin-Ad-Unit-Id", this.adUnitId);
        hashMap.put("AppLovin-Ad-Format", this.format.getLabel());
        CollectionUtils.putObjectToStringIfValid("AppLovin-Retry-Attempt", this.extraParameters.get("retry_attempt"), hashMap);
        CollectionUtils.putObjectToStringIfValid("AppLovin-Retry-Delay-Sec", this.extraParameters.get("retry_delay_sec"), hashMap);
        return hashMap;
    }

    private JSONObject zF() throws JSONException {
        Map<String, Object> map;
        if (this.sdk.BV() != null) {
            map = this.sdk.BV().a((Map<String, String>) null, false, true);
        } else {
            map = this.sdk.BS().a((Map<String, String>) null, false, true);
        }
        map.putAll(this.alR);
        JSONObject jSONObject = new JSONObject(map);
        u(jSONObject);
        t(jSONObject);
        s(jSONObject);
        v(jSONObject);
        w(jSONObject);
        return jSONObject;
    }

    private void s(JSONObject jSONObject) {
        try {
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("disabled", new JSONArray(this.sdk.Cw().tZ()));
            jSONObject2.put("installed", com.applovin.impl.mediation.e.c.f(this.sdk));
            jSONObject2.put("initialized", this.sdk.Cx().tW());
            jSONObject2.put("initialized_classnames", new JSONArray(this.sdk.Cx().tV().keySet()));
            jSONObject2.put("loaded_classnames", new JSONArray(this.sdk.Cw().tX()));
            jSONObject2.put("failed_classnames", new JSONArray(this.sdk.Cw().tY()));
            jSONObject.put("adapters_info", jSONObject2);
        } catch (Exception e) {
            x xVar = this.logger;
            if (x.Fn()) {
                this.logger.c(this.tag, "Failed to populate adapter classNames", e);
            }
            throw new RuntimeException("Failed to populate classNames: " + e);
        }
    }

    private void t(JSONObject jSONObject) throws JSONException {
        JSONArray jSONArray = this.aws;
        if (jSONArray != null) {
            jSONObject.put("signal_data", jSONArray);
        }
    }

    private void u(JSONObject jSONObject) throws JSONException {
        JSONObject jSONObject2 = new JSONObject();
        jSONObject2.put("ad_unit_id", this.adUnitId);
        jSONObject2.put("ad_format", this.format.getLabel());
        Map<String, Object> map = CollectionUtils.map(this.extraParameters);
        y.a cK = this.sdk.CC().cK(this.adUnitId);
        if (cK != null) {
            if (Boolean.parseBoolean(this.sdk.getSettings().getExtraParameters().get(AppLovinSdkExtraParameterKey.ENABLE_SEQUENTIAL_CACHING))) {
                map.put("previous_winning_network", "APPLOVIN_NETWORK");
                map.put("previous_winning_network_name", "AppLovin");
            } else {
                map.put("previous_winning_network", cK.yA());
                map.put("previous_winning_network_name", cK.getNetworkName());
                CollectionUtils.putStringIfValid("second_previous_winning_network", cK.Fo(), map);
                CollectionUtils.putStringIfValid("second_previous_winning_network_name", cK.Fp(), map);
            }
        }
        jSONObject2.put("extra_parameters", CollectionUtils.toJson(map));
        jSONObject.put("ad_info", jSONObject2);
    }

    private void v(JSONObject jSONObject) {
        JSONObject andResetCustomPostBodyData = this.sdk.Cy().getAndResetCustomPostBodyData();
        if (andResetCustomPostBodyData != null && u.ak(n.getApplicationContext())) {
            JsonUtils.putAll(jSONObject, andResetCustomPostBodyData);
        }
    }

    private void w(JSONObject jSONObject) {
        JsonUtils.putObject(jSONObject, "sdk_extra_parameters", new JSONObject(this.sdk.getSettings().getExtraParameters()));
    }
}
