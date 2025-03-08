package com.applovin.impl.sdk.e;

import com.applovin.impl.sdk.e.q;
import com.applovin.impl.sdk.n;
import com.applovin.impl.sdk.network.c;
import com.applovin.impl.sdk.utils.AppLovinSdkExtraParameterKey;
import com.applovin.impl.sdk.utils.h;
import com.applovin.impl.sdk.utils.i;
import com.applovin.impl.sdk.utils.p;
import com.applovin.impl.sdk.x;
import com.applovin.sdk.AppLovinWebViewActivity;
import com.google.android.gms.security.ProviderInstaller;
import com.ironsource.i9;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;

public class l extends d {
    private static final AtomicBoolean aUf = new AtomicBoolean();
    private final int aCS;
    private final Object aUg = new Object();
    /* access modifiers changed from: private */
    public a aUh;

    public interface a {
        void G(JSONObject jSONObject);
    }

    public l(int i, n nVar, a aVar) {
        super("TaskFetchBasicSettings", nVar, true);
        this.aCS = i;
        this.aUh = aVar;
    }

    public void run() {
        if (!h.Lc() && aUf.compareAndSet(false, true)) {
            try {
                ProviderInstaller.installIfNeeded(n.getApplicationContext());
            } catch (Throwable th) {
                x xVar = this.logger;
                if (x.Fn()) {
                    this.logger.c(this.tag, "Cannot update security provider", th);
                }
            }
        }
        Map<String, String> EU = EU();
        final c<T> Ig = c.D(this.sdk).cW(KD()).cY(KE()).k(EU).K(vS()).aU(((Boolean) this.sdk.a(com.applovin.impl.sdk.c.b.aQk)).booleanValue()).cX(i9.b).ad(new JSONObject()).gE(((Integer) this.sdk.a(com.applovin.impl.sdk.c.b.aNV)).intValue()).gG(((Integer) this.sdk.a(com.applovin.impl.sdk.c.b.aNY)).intValue()).gF(((Integer) this.sdk.a(com.applovin.impl.sdk.c.b.aNU)).intValue()).aR(((Boolean) this.sdk.a(com.applovin.impl.sdk.c.b.aOh)).booleanValue()).a(p.a.gW(((Integer) this.sdk.a(com.applovin.impl.sdk.c.b.aPQ)).intValue())).aT(true).Ig();
        this.sdk.BO().a((d) new b(this.sdk), q.b.TIMEOUT, ((long) ((Integer) this.sdk.a(com.applovin.impl.sdk.c.b.aNU)).intValue()) + 250);
        AnonymousClass1 r1 = new w<JSONObject>(Ig, this.sdk, Kh()) {
            /* renamed from: a */
            public void d(JSONObject jSONObject, int i) {
                l.this.Q(jSONObject);
                this.sdk.Cs().b(Ig.zL(), "fetchBasicSettings", i);
            }

            public void a(int i, String str, JSONObject jSONObject) {
                x xVar = this.logger;
                if (x.Fn()) {
                    x xVar2 = this.logger;
                    String str2 = this.tag;
                    xVar2.i(str2, "Unable to fetch basic SDK settings: server returned " + i);
                }
                if (jSONObject == null) {
                    jSONObject = new JSONObject();
                }
                l.this.Q(jSONObject);
                this.sdk.Cs().b(Ig.zL(), "fetchBasicSettings", i);
            }
        };
        r1.e(com.applovin.impl.sdk.c.b.aLs);
        r1.f(com.applovin.impl.sdk.c.b.aLt);
        this.sdk.BO().b((d) r1);
    }

    /* access modifiers changed from: protected */
    public Map<String, String> EU() {
        HashMap hashMap = new HashMap();
        if (!((Boolean) this.sdk.a(com.applovin.impl.sdk.c.b.aPZ)).booleanValue() && !((Boolean) this.sdk.a(com.applovin.impl.sdk.c.b.aPY)).booleanValue()) {
            hashMap.put("rid", UUID.randomUUID().toString());
        }
        if (!((Boolean) this.sdk.a(com.applovin.impl.sdk.c.b.aPL)).booleanValue()) {
            hashMap.put(AppLovinWebViewActivity.INTENT_EXTRA_KEY_SDK_KEY, this.sdk.getSdkKey());
        }
        Boolean B = com.applovin.impl.privacy.a.zP().B(rQ());
        if (B != null) {
            hashMap.put(AppLovinSdkExtraParameterKey.HAS_USER_CONSENT, B.toString());
        }
        Boolean B2 = com.applovin.impl.privacy.a.zO().B(rQ());
        if (B2 != null) {
            hashMap.put(AppLovinSdkExtraParameterKey.AGE_RESTRICTED_USER, B2.toString());
        }
        Boolean B3 = com.applovin.impl.privacy.a.zQ().B(rQ());
        if (B3 != null) {
            hashMap.put(AppLovinSdkExtraParameterKey.DO_NOT_SELL, B3.toString());
        }
        return hashMap;
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Can't wrap try/catch for region: R(40:0|1|2|(1:6)|7|(1:9)|10|(1:12)|13|(1:15)(1:16)|17|(1:21)|22|(1:24)|25|(1:27)(1:28)|29|(1:31)|32|33|(1:35)|36|37|(1:39)|40|41|(5:43|44|(1:50)|51|(1:56))(4:57|(1:63)|64|(1:69))|70|(1:72)|73|(1:75)|76|(1:78)|79|(1:81)|82|(1:86)|87|(3:89|(1:91)|92)|98) */
    /* JADX WARNING: Missing exception handler attribute for start block: B:36:0x0240 */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x0250 A[Catch:{ JSONException -> 0x0442 }] */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x0264 A[SYNTHETIC, Splitter:B:43:0x0264] */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x02f1 A[Catch:{ JSONException -> 0x0442 }] */
    /* JADX WARNING: Removed duplicated region for block: B:72:0x0388 A[Catch:{ JSONException -> 0x0442 }] */
    /* JADX WARNING: Removed duplicated region for block: B:75:0x03a1 A[Catch:{ JSONException -> 0x0442 }] */
    /* JADX WARNING: Removed duplicated region for block: B:78:0x03bc A[Catch:{ JSONException -> 0x0442 }] */
    /* JADX WARNING: Removed duplicated region for block: B:81:0x03d3 A[Catch:{ JSONException -> 0x0442 }] */
    /* JADX WARNING: Removed duplicated region for block: B:89:0x0409 A[Catch:{ JSONException -> 0x0442 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public org.json.JSONObject vS() {
        /*
            r25 = this;
            r1 = r25
            java.lang.String r0 = "supported_abis"
            java.lang.String r2 = "screen_size_in"
            java.lang.String r3 = "is_tablet"
            java.lang.String r4 = "revision"
            java.lang.String r5 = "model"
            java.lang.String r6 = "hardware"
            java.lang.String r7 = "brand_name"
            java.lang.String r8 = "brand"
            java.lang.String r9 = "locale"
            java.lang.String r10 = "os"
            java.lang.String r11 = "platform"
            java.lang.String r12 = "IABTCF_AddtlConsent"
            java.lang.String r13 = "IABTCF_gdprApplies"
            java.lang.String r14 = "IABTCF_TCString"
            java.lang.String r15 = "target_sdk"
            r16 = r0
            java.lang.String r0 = "tg"
            r17 = r2
            java.lang.String r2 = "debug"
            r18 = r3
            java.lang.String r3 = "test_ads"
            r19 = r4
            java.lang.String r4 = "app_version"
            r20 = r5
            java.lang.String r5 = "package_name"
            r21 = r6
            org.json.JSONObject r6 = new org.json.JSONObject
            r6.<init>()
            r22 = r7
            com.applovin.impl.sdk.n r7 = r1.sdk     // Catch:{ JSONException -> 0x0442 }
            r23 = r8
            com.applovin.impl.sdk.c.b<java.lang.Boolean> r8 = com.applovin.impl.sdk.c.b.aPY     // Catch:{ JSONException -> 0x0442 }
            java.lang.Object r7 = r7.a(r8)     // Catch:{ JSONException -> 0x0442 }
            java.lang.Boolean r7 = (java.lang.Boolean) r7     // Catch:{ JSONException -> 0x0442 }
            boolean r7 = r7.booleanValue()     // Catch:{ JSONException -> 0x0442 }
            if (r7 != 0) goto L_0x005f
            com.applovin.impl.sdk.n r7 = r1.sdk     // Catch:{ JSONException -> 0x0442 }
            com.applovin.impl.sdk.c.b<java.lang.Boolean> r8 = com.applovin.impl.sdk.c.b.aPY     // Catch:{ JSONException -> 0x0442 }
            java.lang.Object r7 = r7.a(r8)     // Catch:{ JSONException -> 0x0442 }
            java.lang.Boolean r7 = (java.lang.Boolean) r7     // Catch:{ JSONException -> 0x0442 }
            boolean r7 = r7.booleanValue()     // Catch:{ JSONException -> 0x0442 }
            if (r7 == 0) goto L_0x006c
        L_0x005f:
            java.lang.String r7 = "rid"
            java.util.UUID r8 = java.util.UUID.randomUUID()     // Catch:{ JSONException -> 0x0442 }
            java.lang.String r8 = r8.toString()     // Catch:{ JSONException -> 0x0442 }
            r6.put(r7, r8)     // Catch:{ JSONException -> 0x0442 }
        L_0x006c:
            java.lang.String r7 = "sdk_version"
            java.lang.String r8 = com.applovin.sdk.AppLovinSdk.VERSION     // Catch:{ JSONException -> 0x0442 }
            r6.put(r7, r8)     // Catch:{ JSONException -> 0x0442 }
            java.lang.String r7 = "is_cross_promo"
            com.applovin.impl.sdk.n r8 = r1.sdk     // Catch:{ JSONException -> 0x0442 }
            boolean r8 = r8.Bq()     // Catch:{ JSONException -> 0x0442 }
            r6.put(r7, r8)     // Catch:{ JSONException -> 0x0442 }
            java.lang.String r7 = "init_count"
            int r8 = r1.aCS     // Catch:{ JSONException -> 0x0442 }
            r6.put(r7, r8)     // Catch:{ JSONException -> 0x0442 }
            java.lang.String r7 = "server_installed_at"
            com.applovin.impl.sdk.n r8 = r1.sdk     // Catch:{ JSONException -> 0x0442 }
            r24 = r9
            com.applovin.impl.sdk.c.b<java.lang.String> r9 = com.applovin.impl.sdk.c.b.aKu     // Catch:{ JSONException -> 0x0442 }
            java.lang.Object r8 = r8.a(r9)     // Catch:{ JSONException -> 0x0442 }
            r6.put(r7, r8)     // Catch:{ JSONException -> 0x0442 }
            com.applovin.impl.sdk.n r7 = r1.sdk     // Catch:{ JSONException -> 0x0442 }
            boolean r7 = r7.CK()     // Catch:{ JSONException -> 0x0442 }
            r8 = 1
            if (r7 == 0) goto L_0x00a2
            java.lang.String r7 = "first_install"
            r6.put(r7, r8)     // Catch:{ JSONException -> 0x0442 }
        L_0x00a2:
            com.applovin.impl.sdk.n r7 = r1.sdk     // Catch:{ JSONException -> 0x0442 }
            boolean r7 = r7.BL()     // Catch:{ JSONException -> 0x0442 }
            if (r7 != 0) goto L_0x00af
            java.lang.String r7 = "first_install_v2"
            r6.put(r7, r8)     // Catch:{ JSONException -> 0x0442 }
        L_0x00af:
            java.lang.String r7 = "plugin_version"
            com.applovin.impl.sdk.n r9 = r1.sdk     // Catch:{ JSONException -> 0x0442 }
            com.applovin.impl.sdk.c.b<java.lang.String> r8 = com.applovin.impl.sdk.c.b.aOD     // Catch:{ JSONException -> 0x0442 }
            java.lang.Object r8 = r9.a(r8)     // Catch:{ JSONException -> 0x0442 }
            java.lang.String r8 = (java.lang.String) r8     // Catch:{ JSONException -> 0x0442 }
            com.applovin.impl.sdk.utils.JsonUtils.putStringIfValid(r6, r7, r8)     // Catch:{ JSONException -> 0x0442 }
            java.lang.String r7 = "mediation_provider"
            com.applovin.impl.sdk.n r8 = r1.sdk     // Catch:{ JSONException -> 0x0442 }
            java.lang.String r8 = r8.getMediationProvider()     // Catch:{ JSONException -> 0x0442 }
            com.applovin.impl.sdk.utils.JsonUtils.putStringIfValid(r6, r7, r8)     // Catch:{ JSONException -> 0x0442 }
            java.lang.String r7 = "mediation_provider_v2"
            com.applovin.impl.sdk.n r8 = r1.sdk     // Catch:{ JSONException -> 0x0442 }
            java.lang.String r8 = r8.CL()     // Catch:{ JSONException -> 0x0442 }
            com.applovin.impl.sdk.utils.JsonUtils.putStringIfValid(r6, r7, r8)     // Catch:{ JSONException -> 0x0442 }
            java.lang.String r7 = "installed_mediation_adapters"
            com.applovin.impl.sdk.n r8 = r1.sdk     // Catch:{ JSONException -> 0x0442 }
            org.json.JSONArray r8 = com.applovin.impl.mediation.e.c.f((com.applovin.impl.sdk.n) r8)     // Catch:{ JSONException -> 0x0442 }
            r6.put(r7, r8)     // Catch:{ JSONException -> 0x0442 }
            com.applovin.impl.sdk.n r7 = r1.sdk     // Catch:{ JSONException -> 0x0442 }
            com.applovin.impl.sdk.p r7 = r7.BV()     // Catch:{ JSONException -> 0x0442 }
            if (r7 == 0) goto L_0x00f2
            com.applovin.impl.sdk.n r7 = r1.sdk     // Catch:{ JSONException -> 0x0442 }
            com.applovin.impl.sdk.p r7 = r7.BV()     // Catch:{ JSONException -> 0x0442 }
            java.util.Map r7 = r7.DI()     // Catch:{ JSONException -> 0x0442 }
            goto L_0x00fc
        L_0x00f2:
            com.applovin.impl.sdk.n r7 = r1.sdk     // Catch:{ JSONException -> 0x0442 }
            com.applovin.impl.sdk.o r7 = r7.BS()     // Catch:{ JSONException -> 0x0442 }
            java.util.Map r7 = r7.Db()     // Catch:{ JSONException -> 0x0442 }
        L_0x00fc:
            java.lang.Object r8 = r7.get(r5)     // Catch:{ JSONException -> 0x0442 }
            r6.put(r5, r8)     // Catch:{ JSONException -> 0x0442 }
            java.lang.Object r5 = r7.get(r4)     // Catch:{ JSONException -> 0x0442 }
            r6.put(r4, r5)     // Catch:{ JSONException -> 0x0442 }
            java.lang.Object r4 = r7.get(r3)     // Catch:{ JSONException -> 0x0442 }
            r6.put(r3, r4)     // Catch:{ JSONException -> 0x0442 }
            java.lang.Object r3 = r7.get(r2)     // Catch:{ JSONException -> 0x0442 }
            r6.put(r2, r3)     // Catch:{ JSONException -> 0x0442 }
            java.lang.Object r2 = r7.get(r0)     // Catch:{ JSONException -> 0x0442 }
            r6.put(r0, r2)     // Catch:{ JSONException -> 0x0442 }
            java.lang.Object r0 = r7.get(r15)     // Catch:{ JSONException -> 0x0442 }
            r6.put(r15, r0)     // Catch:{ JSONException -> 0x0442 }
            com.applovin.impl.sdk.n r0 = r1.sdk     // Catch:{ JSONException -> 0x0442 }
            com.applovin.sdk.AppLovinSdkSettings r0 = r0.getSettings()     // Catch:{ JSONException -> 0x0442 }
            java.util.List r0 = r0.getInitializationAdUnitIds()     // Catch:{ JSONException -> 0x0442 }
            if (r0 == 0) goto L_0x0149
            int r2 = r0.size()     // Catch:{ JSONException -> 0x0442 }
            if (r2 <= 0) goto L_0x0149
            java.util.List r0 = com.applovin.impl.sdk.utils.CollectionUtils.removeTrimmedEmptyStrings(r0)     // Catch:{ JSONException -> 0x0442 }
            java.lang.String r2 = "ad_unit_ids"
            int r3 = r0.size()     // Catch:{ JSONException -> 0x0442 }
            java.lang.String r0 = com.applovin.impl.sdk.utils.CollectionUtils.implode(r0, r3)     // Catch:{ JSONException -> 0x0442 }
            r6.put(r2, r0)     // Catch:{ JSONException -> 0x0442 }
        L_0x0149:
            java.lang.Object r0 = r7.get(r14)     // Catch:{ JSONException -> 0x0442 }
            r6.put(r14, r0)     // Catch:{ JSONException -> 0x0442 }
            java.lang.Object r0 = r7.get(r13)     // Catch:{ JSONException -> 0x0442 }
            r6.put(r13, r0)     // Catch:{ JSONException -> 0x0442 }
            java.lang.Object r0 = r7.get(r12)     // Catch:{ JSONException -> 0x0442 }
            boolean r2 = r0 instanceof java.lang.String     // Catch:{ JSONException -> 0x0442 }
            if (r2 == 0) goto L_0x0164
            java.lang.String r0 = (java.lang.String) r0     // Catch:{ JSONException -> 0x0442 }
            com.applovin.impl.sdk.utils.JsonUtils.putStringIfValid(r6, r12, r0)     // Catch:{ JSONException -> 0x0442 }
        L_0x0164:
            java.lang.String r0 = "consent_flow_info"
            com.applovin.impl.sdk.n r2 = r1.sdk     // Catch:{ JSONException -> 0x0442 }
            com.applovin.impl.privacy.a.c r2 = r2.Cl()     // Catch:{ JSONException -> 0x0442 }
            org.json.JSONObject r2 = r2.Ab()     // Catch:{ JSONException -> 0x0442 }
            r6.put(r0, r2)     // Catch:{ JSONException -> 0x0442 }
            com.applovin.impl.sdk.n r0 = r1.sdk     // Catch:{ JSONException -> 0x0442 }
            com.applovin.impl.sdk.p r0 = r0.BV()     // Catch:{ JSONException -> 0x0442 }
            if (r0 == 0) goto L_0x0186
            com.applovin.impl.sdk.n r0 = r1.sdk     // Catch:{ JSONException -> 0x0442 }
            com.applovin.impl.sdk.p r0 = r0.BV()     // Catch:{ JSONException -> 0x0442 }
            java.util.Map r0 = r0.CT()     // Catch:{ JSONException -> 0x0442 }
            goto L_0x0190
        L_0x0186:
            com.applovin.impl.sdk.n r0 = r1.sdk     // Catch:{ JSONException -> 0x0442 }
            com.applovin.impl.sdk.o r0 = r0.BS()     // Catch:{ JSONException -> 0x0442 }
            java.util.Map r0 = r0.CT()     // Catch:{ JSONException -> 0x0442 }
        L_0x0190:
            java.lang.Object r2 = r0.get(r11)     // Catch:{ JSONException -> 0x0442 }
            r6.put(r11, r2)     // Catch:{ JSONException -> 0x0442 }
            java.lang.Object r2 = r0.get(r10)     // Catch:{ JSONException -> 0x0442 }
            r6.put(r10, r2)     // Catch:{ JSONException -> 0x0442 }
            r2 = r24
            java.lang.Object r3 = r0.get(r2)     // Catch:{ JSONException -> 0x0442 }
            r6.put(r2, r3)     // Catch:{ JSONException -> 0x0442 }
            r2 = r23
            java.lang.Object r3 = r0.get(r2)     // Catch:{ JSONException -> 0x0442 }
            r6.put(r2, r3)     // Catch:{ JSONException -> 0x0442 }
            r2 = r22
            java.lang.Object r3 = r0.get(r2)     // Catch:{ JSONException -> 0x0442 }
            r6.put(r2, r3)     // Catch:{ JSONException -> 0x0442 }
            r2 = r21
            java.lang.Object r3 = r0.get(r2)     // Catch:{ JSONException -> 0x0442 }
            r6.put(r2, r3)     // Catch:{ JSONException -> 0x0442 }
            r2 = r20
            java.lang.Object r3 = r0.get(r2)     // Catch:{ JSONException -> 0x0442 }
            r6.put(r2, r3)     // Catch:{ JSONException -> 0x0442 }
            r2 = r19
            java.lang.Object r3 = r0.get(r2)     // Catch:{ JSONException -> 0x0442 }
            r6.put(r2, r3)     // Catch:{ JSONException -> 0x0442 }
            r2 = r18
            java.lang.Object r3 = r0.get(r2)     // Catch:{ JSONException -> 0x0442 }
            r6.put(r2, r3)     // Catch:{ JSONException -> 0x0442 }
            r2 = r17
            java.lang.Object r3 = r0.get(r2)     // Catch:{ JSONException -> 0x0442 }
            r6.put(r2, r3)     // Catch:{ JSONException -> 0x0442 }
            r2 = r16
            java.lang.Object r0 = r0.get(r2)     // Catch:{ JSONException -> 0x0442 }
            r6.put(r2, r0)     // Catch:{ JSONException -> 0x0442 }
            com.applovin.impl.sdk.n r0 = r1.sdk     // Catch:{ JSONException -> 0x0442 }
            com.applovin.impl.sdk.c.b<java.lang.Boolean> r2 = com.applovin.impl.sdk.c.b.aOM     // Catch:{ JSONException -> 0x0442 }
            java.lang.Object r0 = r0.a(r2)     // Catch:{ JSONException -> 0x0442 }
            java.lang.Boolean r0 = (java.lang.Boolean) r0     // Catch:{ JSONException -> 0x0442 }
            boolean r0 = r0.booleanValue()     // Catch:{ JSONException -> 0x0442 }
            if (r0 == 0) goto L_0x020e
            java.lang.String r0 = "mtl"
            com.applovin.impl.sdk.n r2 = r1.sdk     // Catch:{ JSONException -> 0x0442 }
            com.applovin.impl.sdk.SessionTracker r2 = r2.Ce()     // Catch:{ JSONException -> 0x0442 }
            int r2 = r2.getLastTrimMemoryLevel()     // Catch:{ JSONException -> 0x0442 }
            r6.put(r0, r2)     // Catch:{ JSONException -> 0x0442 }
        L_0x020e:
            android.content.Context r0 = com.applovin.impl.sdk.n.getApplicationContext()     // Catch:{ all -> 0x0240 }
            java.lang.String r2 = "activity"
            java.lang.Object r0 = r0.getSystemService(r2)     // Catch:{ all -> 0x0240 }
            android.app.ActivityManager r0 = (android.app.ActivityManager) r0     // Catch:{ all -> 0x0240 }
            android.app.ActivityManager$MemoryInfo r2 = new android.app.ActivityManager$MemoryInfo     // Catch:{ all -> 0x0240 }
            r2.<init>()     // Catch:{ all -> 0x0240 }
            if (r0 == 0) goto L_0x0240
            r0.getMemoryInfo(r2)     // Catch:{ all -> 0x0240 }
            java.lang.String r0 = "fm"
            long r3 = r2.availMem     // Catch:{ all -> 0x0240 }
            r6.put(r0, r3)     // Catch:{ all -> 0x0240 }
            java.lang.String r0 = "tm"
            long r3 = r2.totalMem     // Catch:{ all -> 0x0240 }
            r6.put(r0, r3)     // Catch:{ all -> 0x0240 }
            java.lang.String r0 = "lmt"
            long r3 = r2.threshold     // Catch:{ all -> 0x0240 }
            r6.put(r0, r3)     // Catch:{ all -> 0x0240 }
            java.lang.String r0 = "lm"
            boolean r2 = r2.lowMemory     // Catch:{ all -> 0x0240 }
            r6.put(r0, r2)     // Catch:{ all -> 0x0240 }
        L_0x0240:
            com.applovin.impl.sdk.n r0 = r1.sdk     // Catch:{ JSONException -> 0x0442 }
            com.applovin.impl.sdk.AppLovinTargetingDataImpl r0 = r0.BC()     // Catch:{ JSONException -> 0x0442 }
            java.util.Map r0 = r0.getAllData()     // Catch:{ JSONException -> 0x0442 }
            boolean r2 = r0.isEmpty()     // Catch:{ JSONException -> 0x0442 }
            if (r2 != 0) goto L_0x025a
            java.lang.String r2 = "targeting_data"
            org.json.JSONObject r3 = new org.json.JSONObject     // Catch:{ JSONException -> 0x0442 }
            r3.<init>(r0)     // Catch:{ JSONException -> 0x0442 }
            r6.put(r2, r3)     // Catch:{ JSONException -> 0x0442 }
        L_0x025a:
            com.applovin.impl.sdk.n r0 = r1.sdk     // Catch:{ JSONException -> 0x0442 }
            com.applovin.impl.sdk.p r0 = r0.BV()     // Catch:{ JSONException -> 0x0442 }
            java.lang.String r2 = "dnt"
            if (r0 == 0) goto L_0x02f1
            com.applovin.impl.sdk.n r0 = r1.sdk     // Catch:{ JSONException -> 0x0442 }
            com.applovin.impl.sdk.q r0 = r0.BU()     // Catch:{ JSONException -> 0x0442 }
            com.applovin.impl.sdk.utils.d$a r0 = r0.DM()     // Catch:{ JSONException -> 0x0442 }
            boolean r3 = r0.KQ()     // Catch:{ JSONException -> 0x0442 }
            r6.put(r2, r3)     // Catch:{ JSONException -> 0x0442 }
            java.lang.String r2 = "dnt_code"
            com.applovin.impl.sdk.utils.d$a$a r3 = r0.KS()     // Catch:{ JSONException -> 0x0442 }
            java.lang.String r3 = r3.KT()     // Catch:{ JSONException -> 0x0442 }
            r6.put(r2, r3)     // Catch:{ JSONException -> 0x0442 }
            com.applovin.impl.privacy.a$a r2 = com.applovin.impl.privacy.a.zO()     // Catch:{ JSONException -> 0x0442 }
            android.content.Context r3 = r25.rQ()     // Catch:{ JSONException -> 0x0442 }
            java.lang.Boolean r2 = r2.B(r3)     // Catch:{ JSONException -> 0x0442 }
            com.applovin.impl.sdk.n r3 = r1.sdk     // Catch:{ JSONException -> 0x0442 }
            com.applovin.impl.sdk.c.b<java.lang.Boolean> r4 = com.applovin.impl.sdk.c.b.aOz     // Catch:{ JSONException -> 0x0442 }
            java.lang.Object r3 = r3.a(r4)     // Catch:{ JSONException -> 0x0442 }
            java.lang.Boolean r3 = (java.lang.Boolean) r3     // Catch:{ JSONException -> 0x0442 }
            boolean r3 = r3.booleanValue()     // Catch:{ JSONException -> 0x0442 }
            if (r3 == 0) goto L_0x02b9
            java.lang.String r3 = r0.KR()     // Catch:{ JSONException -> 0x0442 }
            boolean r3 = com.applovin.impl.sdk.utils.StringUtils.isValidString(r3)     // Catch:{ JSONException -> 0x0442 }
            if (r3 == 0) goto L_0x02b9
            java.lang.Boolean r3 = java.lang.Boolean.TRUE     // Catch:{ JSONException -> 0x0442 }
            boolean r3 = r3.equals(r2)     // Catch:{ JSONException -> 0x0442 }
            if (r3 != 0) goto L_0x02b9
            java.lang.String r3 = "idfa"
            java.lang.String r0 = r0.KR()     // Catch:{ JSONException -> 0x0442 }
            r6.put(r3, r0)     // Catch:{ JSONException -> 0x0442 }
        L_0x02b9:
            com.applovin.impl.sdk.n r0 = r1.sdk     // Catch:{ JSONException -> 0x0442 }
            com.applovin.impl.sdk.q r0 = r0.BU()     // Catch:{ JSONException -> 0x0442 }
            com.applovin.impl.sdk.q$b r0 = r0.DJ()     // Catch:{ JSONException -> 0x0442 }
            com.applovin.impl.sdk.n r3 = r1.sdk     // Catch:{ JSONException -> 0x0442 }
            com.applovin.impl.sdk.c.b<java.lang.Boolean> r4 = com.applovin.impl.sdk.c.b.aOs     // Catch:{ JSONException -> 0x0442 }
            java.lang.Object r3 = r3.a(r4)     // Catch:{ JSONException -> 0x0442 }
            java.lang.Boolean r3 = (java.lang.Boolean) r3     // Catch:{ JSONException -> 0x0442 }
            boolean r3 = r3.booleanValue()     // Catch:{ JSONException -> 0x0442 }
            if (r3 == 0) goto L_0x0378
            if (r0 == 0) goto L_0x0378
            java.lang.Boolean r3 = java.lang.Boolean.TRUE     // Catch:{ JSONException -> 0x0442 }
            boolean r2 = r3.equals(r2)     // Catch:{ JSONException -> 0x0442 }
            if (r2 != 0) goto L_0x0378
            java.lang.String r2 = "idfv"
            java.lang.String r3 = r0.mQ()     // Catch:{ JSONException -> 0x0442 }
            r6.put(r2, r3)     // Catch:{ JSONException -> 0x0442 }
            java.lang.String r2 = "idfv_scope"
            int r0 = r0.Et()     // Catch:{ JSONException -> 0x0442 }
            r6.put(r2, r0)     // Catch:{ JSONException -> 0x0442 }
            goto L_0x0378
        L_0x02f1:
            com.applovin.impl.sdk.n r0 = r1.sdk     // Catch:{ JSONException -> 0x0442 }
            com.applovin.impl.sdk.o r0 = r0.BS()     // Catch:{ JSONException -> 0x0442 }
            com.applovin.impl.sdk.utils.d$a r0 = r0.Di()     // Catch:{ JSONException -> 0x0442 }
            boolean r3 = r0.KQ()     // Catch:{ JSONException -> 0x0442 }
            r6.put(r2, r3)     // Catch:{ JSONException -> 0x0442 }
            java.lang.String r2 = "dnt_code"
            com.applovin.impl.sdk.utils.d$a$a r3 = r0.KS()     // Catch:{ JSONException -> 0x0442 }
            java.lang.String r3 = r3.KT()     // Catch:{ JSONException -> 0x0442 }
            r6.put(r2, r3)     // Catch:{ JSONException -> 0x0442 }
            com.applovin.impl.privacy.a$a r2 = com.applovin.impl.privacy.a.zO()     // Catch:{ JSONException -> 0x0442 }
            android.content.Context r3 = r25.rQ()     // Catch:{ JSONException -> 0x0442 }
            java.lang.Boolean r2 = r2.B(r3)     // Catch:{ JSONException -> 0x0442 }
            com.applovin.impl.sdk.n r3 = r1.sdk     // Catch:{ JSONException -> 0x0442 }
            com.applovin.impl.sdk.c.b<java.lang.Boolean> r4 = com.applovin.impl.sdk.c.b.aOz     // Catch:{ JSONException -> 0x0442 }
            java.lang.Object r3 = r3.a(r4)     // Catch:{ JSONException -> 0x0442 }
            java.lang.Boolean r3 = (java.lang.Boolean) r3     // Catch:{ JSONException -> 0x0442 }
            boolean r3 = r3.booleanValue()     // Catch:{ JSONException -> 0x0442 }
            if (r3 == 0) goto L_0x0346
            java.lang.String r3 = r0.KR()     // Catch:{ JSONException -> 0x0442 }
            boolean r3 = com.applovin.impl.sdk.utils.StringUtils.isValidString(r3)     // Catch:{ JSONException -> 0x0442 }
            if (r3 == 0) goto L_0x0346
            java.lang.Boolean r3 = java.lang.Boolean.TRUE     // Catch:{ JSONException -> 0x0442 }
            boolean r3 = r3.equals(r2)     // Catch:{ JSONException -> 0x0442 }
            if (r3 != 0) goto L_0x0346
            java.lang.String r3 = "idfa"
            java.lang.String r0 = r0.KR()     // Catch:{ JSONException -> 0x0442 }
            r6.put(r3, r0)     // Catch:{ JSONException -> 0x0442 }
        L_0x0346:
            com.applovin.impl.sdk.n r0 = r1.sdk     // Catch:{ JSONException -> 0x0442 }
            com.applovin.impl.sdk.o r0 = r0.BS()     // Catch:{ JSONException -> 0x0442 }
            com.applovin.impl.sdk.o$a r0 = r0.Dj()     // Catch:{ JSONException -> 0x0442 }
            com.applovin.impl.sdk.n r3 = r1.sdk     // Catch:{ JSONException -> 0x0442 }
            com.applovin.impl.sdk.c.b<java.lang.Boolean> r4 = com.applovin.impl.sdk.c.b.aOs     // Catch:{ JSONException -> 0x0442 }
            java.lang.Object r3 = r3.a(r4)     // Catch:{ JSONException -> 0x0442 }
            java.lang.Boolean r3 = (java.lang.Boolean) r3     // Catch:{ JSONException -> 0x0442 }
            boolean r3 = r3.booleanValue()     // Catch:{ JSONException -> 0x0442 }
            if (r3 == 0) goto L_0x0378
            if (r0 == 0) goto L_0x0378
            java.lang.Boolean r3 = java.lang.Boolean.TRUE     // Catch:{ JSONException -> 0x0442 }
            boolean r2 = r3.equals(r2)     // Catch:{ JSONException -> 0x0442 }
            if (r2 != 0) goto L_0x0378
            java.lang.String r2 = "idfv"
            java.lang.String r3 = r0.f15do     // Catch:{ JSONException -> 0x0442 }
            r6.put(r2, r3)     // Catch:{ JSONException -> 0x0442 }
            java.lang.String r2 = "idfv_scope"
            int r0 = r0.aDh     // Catch:{ JSONException -> 0x0442 }
            r6.put(r2, r0)     // Catch:{ JSONException -> 0x0442 }
        L_0x0378:
            com.applovin.impl.sdk.n r0 = r1.sdk     // Catch:{ JSONException -> 0x0442 }
            com.applovin.sdk.AppLovinUserSegment r0 = r0.getUserSegment()     // Catch:{ JSONException -> 0x0442 }
            java.lang.String r0 = r0.getName()     // Catch:{ JSONException -> 0x0442 }
            boolean r2 = com.applovin.impl.sdk.utils.StringUtils.isValidString(r0)     // Catch:{ JSONException -> 0x0442 }
            if (r2 == 0) goto L_0x0391
            java.lang.String r2 = "user_segment_name"
            java.lang.String r0 = com.applovin.impl.sdk.utils.StringUtils.encodeUriString(r0)     // Catch:{ JSONException -> 0x0442 }
            r6.put(r2, r0)     // Catch:{ JSONException -> 0x0442 }
        L_0x0391:
            com.applovin.impl.sdk.n r0 = r1.sdk     // Catch:{ JSONException -> 0x0442 }
            com.applovin.impl.sdk.c.b<java.lang.Boolean> r2 = com.applovin.impl.sdk.c.b.aOv     // Catch:{ JSONException -> 0x0442 }
            java.lang.Object r0 = r0.a(r2)     // Catch:{ JSONException -> 0x0442 }
            java.lang.Boolean r0 = (java.lang.Boolean) r0     // Catch:{ JSONException -> 0x0442 }
            boolean r0 = r0.booleanValue()     // Catch:{ JSONException -> 0x0442 }
            if (r0 == 0) goto L_0x03ac
            java.lang.String r0 = "compass_random_token"
            com.applovin.impl.sdk.n r2 = r1.sdk     // Catch:{ JSONException -> 0x0442 }
            java.lang.String r2 = r2.BA()     // Catch:{ JSONException -> 0x0442 }
            r6.put(r0, r2)     // Catch:{ JSONException -> 0x0442 }
        L_0x03ac:
            com.applovin.impl.sdk.n r0 = r1.sdk     // Catch:{ JSONException -> 0x0442 }
            com.applovin.impl.sdk.c.b<java.lang.Boolean> r2 = com.applovin.impl.sdk.c.b.aOx     // Catch:{ JSONException -> 0x0442 }
            java.lang.Object r0 = r0.a(r2)     // Catch:{ JSONException -> 0x0442 }
            java.lang.Boolean r0 = (java.lang.Boolean) r0     // Catch:{ JSONException -> 0x0442 }
            boolean r0 = r0.booleanValue()     // Catch:{ JSONException -> 0x0442 }
            if (r0 == 0) goto L_0x03c7
            java.lang.String r0 = "applovin_random_token"
            com.applovin.impl.sdk.n r2 = r1.sdk     // Catch:{ JSONException -> 0x0442 }
            java.lang.String r2 = r2.BB()     // Catch:{ JSONException -> 0x0442 }
            r6.put(r0, r2)     // Catch:{ JSONException -> 0x0442 }
        L_0x03c7:
            com.applovin.impl.sdk.n r0 = r1.sdk     // Catch:{ JSONException -> 0x0442 }
            com.applovin.impl.mediation.debugger.ui.testmode.c r0 = r0.CE()     // Catch:{ JSONException -> 0x0442 }
            boolean r0 = r0.isEnabled()     // Catch:{ JSONException -> 0x0442 }
            if (r0 == 0) goto L_0x03d9
            java.lang.String r0 = "test_mode"
            r2 = 1
            r6.put(r0, r2)     // Catch:{ JSONException -> 0x0442 }
        L_0x03d9:
            com.applovin.impl.sdk.n r0 = r1.sdk     // Catch:{ JSONException -> 0x0442 }
            com.applovin.impl.mediation.debugger.ui.testmode.c r0 = r0.CE()     // Catch:{ JSONException -> 0x0442 }
            java.util.List r0 = r0.xk()     // Catch:{ JSONException -> 0x0442 }
            if (r0 == 0) goto L_0x03f0
            boolean r2 = r0.isEmpty()     // Catch:{ JSONException -> 0x0442 }
            if (r2 != 0) goto L_0x03f0
            java.lang.String r2 = "test_mode_networks"
            r6.put(r2, r0)     // Catch:{ JSONException -> 0x0442 }
        L_0x03f0:
            org.json.JSONObject r0 = new org.json.JSONObject     // Catch:{ JSONException -> 0x0442 }
            com.applovin.impl.sdk.n r2 = r1.sdk     // Catch:{ JSONException -> 0x0442 }
            com.applovin.sdk.AppLovinSdkSettings r2 = r2.getSettings()     // Catch:{ JSONException -> 0x0442 }
            java.util.Map r2 = r2.getExtraParameters()     // Catch:{ JSONException -> 0x0442 }
            r0.<init>(r2)     // Catch:{ JSONException -> 0x0442 }
            java.lang.String r2 = "sdk_extra_parameters"
            r6.put(r2, r0)     // Catch:{ JSONException -> 0x0442 }
            int r0 = r1.aCS     // Catch:{ JSONException -> 0x0442 }
            r2 = 1
            if (r0 <= r2) goto L_0x0461
            com.applovin.impl.sdk.n r0 = r1.sdk     // Catch:{ JSONException -> 0x0442 }
            com.applovin.impl.sdk.array.ArrayService r0 = r0.Cr()     // Catch:{ JSONException -> 0x0442 }
            java.lang.Boolean r2 = r0.getIsDirectDownloadEnabled()     // Catch:{ JSONException -> 0x0442 }
            if (r2 == 0) goto L_0x041e
            java.lang.String r2 = "ah_dd_enabled"
            java.lang.Boolean r3 = r0.getIsDirectDownloadEnabled()     // Catch:{ JSONException -> 0x0442 }
            r6.put(r2, r3)     // Catch:{ JSONException -> 0x0442 }
        L_0x041e:
            java.lang.String r2 = "ah_sdk_version_code"
            long r3 = r0.getAppHubVersionCode()     // Catch:{ JSONException -> 0x0442 }
            r6.put(r2, r3)     // Catch:{ JSONException -> 0x0442 }
            java.lang.String r2 = "ah_random_user_token"
            java.lang.String r3 = r0.getRandomUserToken()     // Catch:{ JSONException -> 0x0442 }
            java.lang.String r3 = com.applovin.impl.sdk.utils.StringUtils.emptyIfNull(r3)     // Catch:{ JSONException -> 0x0442 }
            r6.put(r2, r3)     // Catch:{ JSONException -> 0x0442 }
            java.lang.String r2 = "ah_sdk_package_name"
            java.lang.String r0 = r0.getAppHubPackageName()     // Catch:{ JSONException -> 0x0442 }
            java.lang.String r0 = com.applovin.impl.sdk.utils.StringUtils.emptyIfNull(r0)     // Catch:{ JSONException -> 0x0442 }
            r6.put(r2, r0)     // Catch:{ JSONException -> 0x0442 }
            goto L_0x0461
        L_0x0442:
            r0 = move-exception
            com.applovin.impl.sdk.x r2 = r1.logger
            boolean r2 = com.applovin.impl.sdk.x.Fn()
            if (r2 == 0) goto L_0x0454
            com.applovin.impl.sdk.x r2 = r1.logger
            java.lang.String r3 = r1.tag
            java.lang.String r4 = "Failed to create JSON body"
            r2.c(r3, r4, r0)
        L_0x0454:
            com.applovin.impl.sdk.n r2 = r1.sdk
            com.applovin.impl.sdk.r r2 = r2.Cs()
            java.lang.String r3 = r1.tag
            java.lang.String r4 = "createJSONBody"
            r2.d(r3, r4, r0)
        L_0x0461:
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.applovin.impl.sdk.e.l.vS():org.json.JSONObject");
    }

    private String KD() {
        return i.a((String) this.sdk.a(com.applovin.impl.sdk.c.b.aLs), "5.0/i", getSdk());
    }

    private String KE() {
        return i.a((String) this.sdk.a(com.applovin.impl.sdk.c.b.aLt), "5.0/i", getSdk());
    }

    /* access modifiers changed from: private */
    public void Q(JSONObject jSONObject) {
        a aVar;
        synchronized (this.aUg) {
            aVar = this.aUh;
            this.aUh = null;
        }
        if (aVar != null) {
            aVar.G(jSONObject);
        }
    }

    private class b extends d {
        public b(n nVar) {
            super("TaskTimeoutFetchBasicSettings", nVar, true);
        }

        public void run() {
            if (l.this.aUh != null) {
                x xVar = this.logger;
                if (x.Fn()) {
                    this.logger.i(this.tag, "Timing out fetch basic settings...");
                }
                l.this.Q(new JSONObject());
            }
        }
    }
}
