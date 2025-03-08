package com.fyber.inneractive.sdk.network;

import android.net.Uri;
import android.os.Build;
import android.text.TextUtils;
import com.fyber.inneractive.sdk.config.IAConfigManager;
import com.fyber.inneractive.sdk.config.a0;
import com.fyber.inneractive.sdk.config.d;
import com.fyber.inneractive.sdk.config.enums.UnitDisplayType;
import com.fyber.inneractive.sdk.config.f;
import com.fyber.inneractive.sdk.config.global.s;
import com.fyber.inneractive.sdk.config.l;
import com.fyber.inneractive.sdk.dv.g;
import com.fyber.inneractive.sdk.external.InneractiveAdManager;
import com.fyber.inneractive.sdk.external.InneractiveAdRequest;
import com.fyber.inneractive.sdk.external.InneractiveMediationDefs;
import com.fyber.inneractive.sdk.external.InneractiveUserConfig;
import com.fyber.inneractive.sdk.network.timeouts.request.a;
import com.fyber.inneractive.sdk.response.e;
import com.fyber.inneractive.sdk.serverapi.b;
import com.fyber.inneractive.sdk.serverapi.c;
import com.fyber.inneractive.sdk.util.IAlog;
import com.fyber.inneractive.sdk.util.k0;
import com.fyber.inneractive.sdk.util.n;
import com.fyber.inneractive.sdk.util.p;
import com.fyber.inneractive.sdk.util.t;
import com.fyber.inneractive.sdk.util.x0;
import com.ironsource.m2;
import com.ironsource.t4;
import java.nio.charset.StandardCharsets;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

public class d0 extends f0<e> implements n {
    public final InneractiveAdRequest r;
    public Map<String, String> s;
    public StringBuffer t;
    public final c u;
    public g v;
    public boolean w;
    public a x;

    public d0(w<e> wVar, InneractiveAdRequest inneractiveAdRequest, s sVar) {
        this(wVar, inneractiveAdRequest, new b(sVar), x.a().b(), sVar);
    }

    public String a() {
        String str;
        String str2;
        String str3;
        Boolean bool;
        String str4;
        int i = f.a;
        String property = System.getProperty("ia.testEnvironmentConfiguration.name");
        if (TextUtils.isEmpty(property)) {
            str = "https://" + IAConfigManager.M.i.e;
        } else {
            str = com.fyber.inneractive.sdk.config.a.a(property, "clientRequestEnhancedXmlAd");
        }
        InneractiveAdRequest inneractiveAdRequest = this.r;
        c cVar = this.u;
        e0 e0Var = new e0(inneractiveAdRequest, cVar);
        e0Var.c = new HashMap();
        e0Var.a("fromSDK", Boolean.toString(true));
        e0Var.a("po", System.getProperty("ia.testEnvironmentConfiguration.number"));
        String str5 = "0";
        e0Var.a("secure", (t.a() ^ true) || IAConfigManager.M.r ? "1" : str5);
        e0Var.a("spotid", inneractiveAdRequest.getSpotId());
        String property2 = System.getProperty("ia.testEnvironmentConfiguration.chosenUnitId");
        if (property2 == null) {
            if (inneractiveAdRequest.getSelectedUnitConfig() == null) {
                property2 = null;
            } else {
                property2 = ((a0) inneractiveAdRequest.getSelectedUnitConfig()).a;
            }
        }
        e0Var.a("uid", property2);
        IAConfigManager iAConfigManager = IAConfigManager.M;
        if (!TextUtils.isEmpty(iAConfigManager.o)) {
            e0Var.a("med", String.format("%s_%s", new Object[]{iAConfigManager.m, iAConfigManager.o}));
        } else {
            e0Var.a("med", iAConfigManager.m);
        }
        cVar.getClass();
        e0Var.a(InneractiveMediationDefs.GENDER_FEMALE, Integer.toString(372));
        b bVar = (b) cVar;
        List<Integer> list = b.d;
        if (!list.isEmpty()) {
            e0Var.a("protocols", p.a(",", (Collection<Integer>) list));
        }
        List<String> list2 = b.e;
        if (!list2.isEmpty()) {
            e0Var.a("mimes", p.b(",", list2));
        }
        List<Integer> list3 = b.c;
        if (!list3.isEmpty()) {
            e0Var.a("api", p.a(",", (Collection<Integer>) list3));
        }
        if (!InneractiveAdManager.isCurrentUserAChild()) {
            e0Var.a("zip", iAConfigManager.j.getZipCode());
        }
        e0Var.a("a", Integer.toString(iAConfigManager.j.getAge()));
        InneractiveUserConfig.Gender gender = iAConfigManager.j.getGender();
        if (InneractiveUserConfig.Gender.MALE.equals(gender)) {
            e0Var.a("g", InneractiveMediationDefs.GENDER_MALE);
        } else if (InneractiveUserConfig.Gender.FEMALE.equals(gender)) {
            e0Var.a("g", InneractiveMediationDefs.GENDER_FEMALE);
        }
        e0Var.a("k", iAConfigManager.k);
        e0Var.a("t", Long.toString(System.currentTimeMillis()));
        e0Var.a("v", bVar.a("2.2.0"));
        Boolean a = iAConfigManager.D.a();
        if (a != null) {
            if (a.booleanValue()) {
                str4 = "1";
            } else {
                str4 = str5;
            }
            e0Var.a("gdpr_privacy_consent", str4);
        }
        d dVar = iAConfigManager.D;
        if (dVar != null) {
            if (p.a == null) {
                bool = null;
            } else {
                bool = dVar.f;
            }
            if (bool != null) {
                if (bool.booleanValue()) {
                    str5 = "1";
                }
                e0Var.a("lgpd_consent", str5);
            }
            Boolean bool2 = iAConfigManager.D.g;
            if (bool2 != null && bool2.booleanValue()) {
                e0Var.a("coppaApplies", "1");
            }
        }
        if (!InneractiveAdManager.isCurrentUserAChild()) {
            String property3 = System.getProperty("ia.testEnvironmentConfiguration.device");
            String str6 = l.b() ? "amazonId" : "aaid";
            if (TextUtils.isEmpty(property3)) {
                property3 = l.a();
            }
            e0Var.a(str6, property3);
        }
        if (!InneractiveAdManager.isCurrentUserAChild()) {
            e0Var.a("dnt", Boolean.toString(l.c()));
        }
        e0Var.a("dml", bVar.b());
        int b = p.b(p.f());
        int b2 = p.b(p.e());
        if (b > 0 && b2 > 0) {
            e0Var.a("w", Integer.toString(b));
            e0Var.a("h", Integer.toString(b2));
        }
        int d = p.d();
        e0Var.a("o", d == 1 ? "p" : d == 2 ? "l" : "u");
        if (!InneractiveAdManager.isCurrentUserAChild()) {
            e0Var.a("ciso", n.h());
            e0Var.a("mcc", bVar.c());
            e0Var.a("mnc", bVar.d());
            e0Var.a("nt", k0.e().key);
            e0Var.a("crn", bVar.a());
        }
        e0Var.a(t4.x, m2.e);
        e0Var.a("lng", iAConfigManager.p);
        List<String> list4 = iAConfigManager.q;
        if (list4 != null && !list4.isEmpty()) {
            e0Var.a("in_lng", p.b(",", list4));
        }
        e0Var.a(t4.f, p.a.getPackageName());
        e0Var.a("appv", bVar.f());
        d dVar2 = iAConfigManager.D;
        dVar2.getClass();
        if (p.a == null) {
            str2 = null;
        } else {
            str2 = dVar2.b;
        }
        e0Var.a("gdpr_consent_data", str2);
        d dVar3 = iAConfigManager.D;
        dVar3.getClass();
        if (p.a == null) {
            str3 = null;
        } else {
            str3 = dVar3.e;
        }
        e0Var.a("us_privacy", str3);
        e0Var.a("mute_video", Boolean.toString(iAConfigManager.l));
        e0Var.a(t4.y, Build.VERSION.RELEASE);
        e0Var.a("ignitep", iAConfigManager.E.c);
        e0Var.a("ignitev", iAConfigManager.E.d);
        HashMap hashMap = new HashMap();
        bVar.a(hashMap, inneractiveAdRequest.getSpotId());
        for (Map.Entry entry : hashMap.entrySet()) {
            e0Var.a((String) entry.getKey(), (String) entry.getValue());
        }
        if (InneractiveAdManager.isCurrentUserAChild()) {
            e0Var.a("childMode", "1");
        }
        Map<String, String> map = e0Var.c;
        StringBuilder sb = new StringBuilder(str);
        boolean z = true;
        for (Map.Entry next : map.entrySet()) {
            sb.append(z ? "?" : m2.i.c);
            sb.append((String) next.getKey());
            sb.append(m2.i.b);
            sb.append(Uri.encode((String) next.getValue()));
            z = false;
        }
        String sb2 = sb.toString();
        if (!this.w) {
            int i2 = IAlog.a;
            IAlog.a(1, (Exception) null, "%s %s", "AD_REQUEST", sb2);
            this.w = true;
        }
        return sb2;
    }

    public void b(long j) {
        super.b(j);
        IAlog.a("%s : NetworkRequestAd : set start connection timestamp", IAlog.a((Object) this));
    }

    public void c(long j) {
        super.c(j);
        IAlog.a("%s : NetworkRequestAd : set end read timestamp, total execution time: %d", IAlog.a((Object) this), Integer.valueOf(y()));
    }

    public void d() {
        super.d();
        IAlog.a("%s : NetworkRequestAd cancel by timeout - resolve request with no fill", IAlog.a((Object) this));
        this.a = true;
        a(null, (Exception) new t0(204, "no fill"), false);
    }

    public StringBuffer e() {
        return this.t;
    }

    public p0 i() {
        return p0.HIGH;
    }

    public u0 n() {
        a aVar = this.x;
        return new u0(aVar.i, aVar.h);
    }

    public boolean o() {
        return false;
    }

    public z r() {
        return z.POST;
    }

    public Map<String, String> t() {
        return this.s;
    }

    public int v() {
        return 0;
    }

    public Map<String, String> w() {
        int i = f.a;
        String property = System.getProperty("ia.testEnvironmentConfiguration.response");
        if (TextUtils.isEmpty(property)) {
            return null;
        }
        HashMap hashMap = new HashMap();
        hashMap.put("mockadnetworkresponseid", property);
        IAlog.a("NetworkRequestAd: Adding mock response header - %s", property);
        return hashMap;
    }

    public int x() {
        return y();
    }

    public d0(w<e> wVar, InneractiveAdRequest inneractiveAdRequest, c cVar, g gVar, s sVar) {
        super(wVar, gVar, sVar);
        this.v = null;
        this.w = false;
        this.q = true;
        this.r = inneractiveAdRequest;
        this.u = cVar;
        if (inneractiveAdRequest != null) {
            this.x = new com.fyber.inneractive.sdk.network.timeouts.request.c().a(x0.a(inneractiveAdRequest.getSpotId()), inneractiveAdRequest.getMediationName(), sVar, false);
        }
    }

    public int h() {
        return this.x.f;
    }

    public byte[] u() {
        byte[] bArr = new byte[0];
        JSONObject jSONObject = new JSONObject();
        try {
            JSONObject jSONObject2 = new JSONObject();
            s sVar = ((b) this.u).a;
            JSONArray d = sVar != null ? sVar.d() : null;
            if (d != null && d.length() > 0) {
                jSONObject2.put("experiments", d);
                jSONObject.put("sdk_experiments", jSONObject2);
            }
            UnitDisplayType a = com.fyber.inneractive.sdk.serverapi.a.a(this.r.getSpotId());
            IAConfigManager iAConfigManager = IAConfigManager.M;
            JSONArray a2 = iAConfigManager.x.a(a);
            if (a2 != null && a2.length() > 0) {
                jSONObject.put("user_sessions", a2);
            }
            int a3 = iAConfigManager.u.b.a("dv_enabled_v2", 0, 0);
            if (a != null && a3 == 1) {
                g a4 = iAConfigManager.F.a(a);
                this.v = a4;
                if (a4 != null) {
                    jSONObject.put("gdem_signal", a4.a.getQuery());
                }
            }
            byte[] bytes = jSONObject.toString().getBytes(StandardCharsets.UTF_8);
            IAlog.a("request json body - %s", jSONObject.toString());
            return bytes;
        } catch (Exception unused) {
            IAlog.a("Failed building body for ad request!", new Object[0]);
            return bArr;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:35:0x0096 A[Catch:{ Exception -> 0x00a5 }] */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x009b A[Catch:{ Exception -> 0x00a5 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.fyber.inneractive.sdk.network.b0 a(com.fyber.inneractive.sdk.network.j r6, java.util.Map<java.lang.String, java.util.List<java.lang.String>> r7, int r8) throws java.lang.Exception {
        /*
            r5 = this;
            r8 = 0
            if (r7 == 0) goto L_0x003a
            java.util.HashMap r0 = new java.util.HashMap
            r0.<init>()
            java.util.Set r1 = r7.keySet()
            java.util.Iterator r1 = r1.iterator()
        L_0x0010:
            boolean r2 = r1.hasNext()
            if (r2 == 0) goto L_0x0038
            java.lang.Object r2 = r1.next()
            java.lang.String r2 = (java.lang.String) r2
            if (r2 == 0) goto L_0x0010
            java.lang.Object r3 = r7.get(r2)
            java.util.List r3 = (java.util.List) r3
            if (r3 == 0) goto L_0x0010
            int r4 = r3.size()
            if (r4 <= 0) goto L_0x0010
            java.lang.String r2 = r2.toLowerCase()
            java.lang.Object r3 = r3.get(r8)
            r0.put(r2, r3)
            goto L_0x0010
        L_0x0038:
            r5.s = r0
        L_0x003a:
            r7 = 0
            if (r6 != 0) goto L_0x003f
            r6 = r7
            goto L_0x0041
        L_0x003f:
            java.io.InputStream r6 = r6.c
        L_0x0041:
            long r0 = java.lang.System.currentTimeMillis()
            super.d(r0)
            r0 = 1
            java.lang.Object[] r0 = new java.lang.Object[r0]
            java.lang.String r1 = com.fyber.inneractive.sdk.util.IAlog.a((java.lang.Object) r5)
            r0[r8] = r1
            java.lang.String r1 = "%s : NetworkRequestAd : set start read timestamp"
            com.fyber.inneractive.sdk.util.IAlog.a(r1, r0)
            if (r6 == 0) goto L_0x0068
            java.lang.StringBuffer r6 = com.fyber.inneractive.sdk.util.u.a((java.io.InputStream) r6, (boolean) r8)     // Catch:{ Exception -> 0x005d }
            goto L_0x0066
        L_0x005d:
            r6 = move-exception
            java.lang.Object[] r0 = new java.lang.Object[r8]
            java.lang.String r1 = "failed create response builder in network request ad"
            com.fyber.inneractive.sdk.util.IAlog.a(r1, r6, r0)
            r6 = r7
        L_0x0066:
            r5.t = r6
        L_0x0068:
            long r0 = java.lang.System.currentTimeMillis()
            r5.c(r0)
            com.fyber.inneractive.sdk.network.b0 r6 = new com.fyber.inneractive.sdk.network.b0
            r6.<init>()
            java.util.Map<java.lang.String, java.lang.String> r0 = r5.s     // Catch:{ Exception -> 0x00a5 }
            if (r0 == 0) goto L_0x0093
            com.fyber.inneractive.sdk.network.m r1 = com.fyber.inneractive.sdk.network.m.RETURNED_AD_TYPE     // Catch:{ Exception -> 0x00a5 }
            java.lang.String r1 = r1.key     // Catch:{ Exception -> 0x00a5 }
            java.lang.String r1 = r1.toLowerCase()     // Catch:{ Exception -> 0x00a5 }
            java.lang.Object r0 = r0.get(r1)     // Catch:{ Exception -> 0x00a5 }
            java.lang.String r0 = (java.lang.String) r0     // Catch:{ Exception -> 0x00a5 }
            boolean r1 = android.text.TextUtils.isEmpty(r0)     // Catch:{ Exception -> 0x00a5 }
            if (r1 != 0) goto L_0x0093
            boolean r1 = android.text.TextUtils.isDigitsOnly(r0)     // Catch:{ Exception -> 0x00a5 }
            if (r1 == 0) goto L_0x0093
            goto L_0x0094
        L_0x0093:
            r0 = r7
        L_0x0094:
            if (r0 == 0) goto L_0x009b
            int r0 = java.lang.Integer.parseInt(r0)     // Catch:{ Exception -> 0x00a5 }
            goto L_0x009c
        L_0x009b:
            r0 = 6
        L_0x009c:
            com.fyber.inneractive.sdk.dv.g r1 = r5.v     // Catch:{ Exception -> 0x00a5 }
            com.fyber.inneractive.sdk.response.e r7 = r5.a(r0, r5, r7, r1)     // Catch:{ Exception -> 0x00a5 }
            r6.a = r7     // Catch:{ Exception -> 0x00a5 }
            return r6
        L_0x00a5:
            r6 = move-exception
            long r0 = java.lang.System.currentTimeMillis()
            r5.c(r0)
            java.lang.Object[] r7 = new java.lang.Object[r8]
            java.lang.String r8 = "failed parse ad network request"
            com.fyber.inneractive.sdk.util.IAlog.a(r8, r6, r7)
            com.fyber.inneractive.sdk.network.a0 r7 = new com.fyber.inneractive.sdk.network.a0
            r7.<init>((java.lang.Exception) r6)
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fyber.inneractive.sdk.network.d0.a(com.fyber.inneractive.sdk.network.j, java.util.Map, int):com.fyber.inneractive.sdk.network.b0");
    }

    public j a(String str) throws Exception {
        IAlog.a("%s: NetworkRequestAd Ad request execution started, timeouts(connection: %d read: %d)", IAlog.a((Object) this), Integer.valueOf(n().a), Integer.valueOf(n().b));
        return super.a(str);
    }

    public void a(long j) {
        super.a(j);
        IAlog.a("%s : NetworkRequestAd : set end connection timestamp, total execution time: %d", IAlog.a((Object) this), Integer.valueOf(y()));
    }
}
