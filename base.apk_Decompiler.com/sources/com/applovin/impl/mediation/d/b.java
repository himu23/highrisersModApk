package com.applovin.impl.mediation.d;

import android.content.Context;
import com.applovin.impl.mediation.b.g;
import com.applovin.impl.mediation.b.h;
import com.applovin.impl.sdk.e.ab;
import com.applovin.impl.sdk.e.d;
import com.applovin.impl.sdk.e.q;
import com.applovin.impl.sdk.n;
import com.applovin.impl.sdk.utils.JsonUtils;
import com.applovin.impl.sdk.utils.StringUtils;
import com.applovin.impl.sdk.utils.u;
import com.applovin.impl.sdk.x;
import com.applovin.mediation.MaxAdFormat;
import com.applovin.sdk.AppLovinSdkUtils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class b extends d {
    private static JSONObject awl;
    private static final Object awm = new Object();
    private static final Map<String, Set<String>> awn = Collections.synchronizedMap(new HashMap());
    private final Context E;
    private final MaxAdFormat adFormat;
    private final String adUnitId;
    private final a awo;
    private final Map<String, Object> localExtraParameters;

    public interface a {
        void a(JSONArray jSONArray);
    }

    public b(String str, MaxAdFormat maxAdFormat, Map<String, Object> map, Context context, n nVar, a aVar) {
        super("TaskCollectSignals", nVar);
        this.adUnitId = str;
        this.adFormat = maxAdFormat;
        this.localExtraParameters = map;
        this.E = context;
        this.awo = aVar;
    }

    /* JADX WARNING: No exception handlers in catch block: Catch:{  } */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void run() {
        /*
            r4 = this;
            java.lang.Object r0 = awm     // Catch:{ JSONException -> 0x009b, InterruptedException -> 0x0087, all -> 0x0073 }
            monitor-enter(r0)     // Catch:{ JSONException -> 0x009b, InterruptedException -> 0x0087, all -> 0x0073 }
            org.json.JSONObject r1 = awl     // Catch:{ all -> 0x0070 }
            java.lang.String r2 = "signal_providers"
            r3 = 0
            org.json.JSONArray r1 = com.applovin.impl.sdk.utils.JsonUtils.getJSONArray(r1, r2, r3)     // Catch:{ all -> 0x0070 }
            monitor-exit(r0)     // Catch:{ all -> 0x0070 }
            if (r1 == 0) goto L_0x0029
            int r0 = r1.length()     // Catch:{ JSONException -> 0x009b, InterruptedException -> 0x0087, all -> 0x0073 }
            if (r0 <= 0) goto L_0x0029
            java.util.Map<java.lang.String, java.util.Set<java.lang.String>> r0 = awn     // Catch:{ JSONException -> 0x009b, InterruptedException -> 0x0087, all -> 0x0073 }
            int r0 = r0.size()     // Catch:{ JSONException -> 0x009b, InterruptedException -> 0x0087, all -> 0x0073 }
            if (r0 <= 0) goto L_0x0023
            org.json.JSONObject r0 = awl     // Catch:{ JSONException -> 0x009b, InterruptedException -> 0x0087, all -> 0x0073 }
            r4.c((org.json.JSONArray) r1, (org.json.JSONObject) r0)     // Catch:{ JSONException -> 0x009b, InterruptedException -> 0x0087, all -> 0x0073 }
            goto L_0x0028
        L_0x0023:
            org.json.JSONObject r0 = awl     // Catch:{ JSONException -> 0x009b, InterruptedException -> 0x0087, all -> 0x0073 }
            r4.b((org.json.JSONArray) r1, (org.json.JSONObject) r0)     // Catch:{ JSONException -> 0x009b, InterruptedException -> 0x0087, all -> 0x0073 }
        L_0x0028:
            return
        L_0x0029:
            com.applovin.impl.sdk.x r0 = r4.logger     // Catch:{ JSONException -> 0x009b, InterruptedException -> 0x0087, all -> 0x0073 }
            boolean r0 = com.applovin.impl.sdk.x.Fn()     // Catch:{ JSONException -> 0x009b, InterruptedException -> 0x0087, all -> 0x0073 }
            if (r0 == 0) goto L_0x003a
            com.applovin.impl.sdk.x r0 = r4.logger     // Catch:{ JSONException -> 0x009b, InterruptedException -> 0x0087, all -> 0x0073 }
            java.lang.String r1 = r4.tag     // Catch:{ JSONException -> 0x009b, InterruptedException -> 0x0087, all -> 0x0073 }
            java.lang.String r2 = "Unable to find cached signal providers, fetching signal providers from SharedPreferences."
            r0.h(r1, r2)     // Catch:{ JSONException -> 0x009b, InterruptedException -> 0x0087, all -> 0x0073 }
        L_0x003a:
            com.applovin.impl.sdk.n r0 = r4.sdk     // Catch:{ JSONException -> 0x009b, InterruptedException -> 0x0087, all -> 0x0073 }
            com.applovin.impl.sdk.c.d<java.lang.String> r1 = com.applovin.impl.sdk.c.d.aRK     // Catch:{ JSONException -> 0x009b, InterruptedException -> 0x0087, all -> 0x0073 }
            java.lang.String r2 = "{}"
            java.lang.Object r0 = r0.b(r1, r2)     // Catch:{ JSONException -> 0x009b, InterruptedException -> 0x0087, all -> 0x0073 }
            java.lang.String r0 = (java.lang.String) r0     // Catch:{ JSONException -> 0x009b, InterruptedException -> 0x0087, all -> 0x0073 }
            org.json.JSONObject r1 = new org.json.JSONObject     // Catch:{ JSONException -> 0x009b, InterruptedException -> 0x0087, all -> 0x0073 }
            r1.<init>(r0)     // Catch:{ JSONException -> 0x009b, InterruptedException -> 0x0087, all -> 0x0073 }
            java.lang.String r0 = "signal_providers"
            org.json.JSONArray r0 = com.applovin.impl.sdk.utils.JsonUtils.getJSONArray(r1, r0, r3)     // Catch:{ JSONException -> 0x009b, InterruptedException -> 0x0087, all -> 0x0073 }
            if (r0 == 0) goto L_0x006a
            int r2 = r0.length()     // Catch:{ JSONException -> 0x009b, InterruptedException -> 0x0087, all -> 0x0073 }
            if (r2 != 0) goto L_0x005a
            goto L_0x006a
        L_0x005a:
            java.util.Map<java.lang.String, java.util.Set<java.lang.String>> r2 = awn     // Catch:{ JSONException -> 0x009b, InterruptedException -> 0x0087, all -> 0x0073 }
            int r2 = r2.size()     // Catch:{ JSONException -> 0x009b, InterruptedException -> 0x0087, all -> 0x0073 }
            if (r2 <= 0) goto L_0x0066
            r4.c((org.json.JSONArray) r0, (org.json.JSONObject) r1)     // Catch:{ JSONException -> 0x009b, InterruptedException -> 0x0087, all -> 0x0073 }
            goto L_0x00ae
        L_0x0066:
            r4.b((org.json.JSONArray) r0, (org.json.JSONObject) r1)     // Catch:{ JSONException -> 0x009b, InterruptedException -> 0x0087, all -> 0x0073 }
            goto L_0x00ae
        L_0x006a:
            java.lang.String r0 = "No signal providers found"
            r4.f(r0, r3)     // Catch:{ JSONException -> 0x009b, InterruptedException -> 0x0087, all -> 0x0073 }
            return
        L_0x0070:
            r1 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x0070 }
            throw r1     // Catch:{ JSONException -> 0x009b, InterruptedException -> 0x0087, all -> 0x0073 }
        L_0x0073:
            r0 = move-exception
            java.lang.String r1 = "Failed to collect signals"
            r4.f(r1, r0)
            com.applovin.impl.sdk.n r1 = r4.sdk
            com.applovin.impl.sdk.r r1 = r1.Cs()
            java.lang.String r2 = "TaskCollectSignals"
            java.lang.String r3 = "collectSignals"
            r1.d(r2, r3, r0)
            goto L_0x00ae
        L_0x0087:
            r0 = move-exception
            java.lang.String r1 = "Failed to wait for signals"
            r4.f(r1, r0)
            com.applovin.impl.sdk.n r1 = r4.sdk
            com.applovin.impl.sdk.r r1 = r1.Cs()
            java.lang.String r2 = "TaskCollectSignals"
            java.lang.String r3 = "waitForSignals"
            r1.d(r2, r3, r0)
            goto L_0x00ae
        L_0x009b:
            r0 = move-exception
            java.lang.String r1 = "Failed to parse signals JSON"
            r4.f(r1, r0)
            com.applovin.impl.sdk.n r1 = r4.sdk
            com.applovin.impl.sdk.r r1 = r1.Cs()
            java.lang.String r2 = "TaskCollectSignals"
            java.lang.String r3 = "parseSignalsJSON"
            r1.d(r2, r3, r0)
        L_0x00ae:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.applovin.impl.mediation.d.b.run():void");
    }

    private void b(JSONArray jSONArray, JSONObject jSONObject) throws JSONException, InterruptedException {
        C0070b bVar = new C0070b(jSONArray.length(), this.awo, this.sdk);
        for (int i = 0; i < jSONArray.length(); i++) {
            a(new h(this.localExtraParameters, jSONArray.getJSONObject(i), jSONObject, this.sdk), bVar);
        }
        this.sdk.BO().a((d) new ab(this.sdk, "timeoutCollectSignal", bVar), q.b.MAIN, ((Long) this.sdk.a(com.applovin.impl.sdk.c.a.aJn)).longValue());
    }

    private void c(JSONArray jSONArray, JSONObject jSONObject) throws JSONException, InterruptedException {
        Set set = awn.get(this.adUnitId);
        if (set == null || set.isEmpty()) {
            f("No signal providers found for ad unit: " + this.adUnitId, (Throwable) null);
            return;
        }
        C0070b bVar = new C0070b(set.size(), this.awo, this.sdk);
        for (int i = 0; i < jSONArray.length(); i++) {
            JSONObject jSONObject2 = jSONArray.getJSONObject(i);
            if (set.contains(JsonUtils.getString(jSONObject2, "name", (String) null))) {
                a(new h(this.localExtraParameters, jSONObject2, jSONObject, this.sdk), bVar);
            }
        }
        this.sdk.BO().a((d) new ab(this.sdk, "timeoutCollectSignal", bVar), q.b.MAIN, ((Long) this.sdk.a(com.applovin.impl.sdk.c.a.aJn)).longValue());
    }

    private void a(h hVar, g.a aVar) {
        if (hVar.yC()) {
            AppLovinSdkUtils.runOnUiThread(new b$$ExternalSyntheticLambda0(this, hVar, aVar));
            return;
        }
        this.sdk.Cy().collectSignal(this.adUnitId, this.adFormat, hVar, this.E, aVar);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void b(h hVar, g.a aVar) {
        this.sdk.Cy().collectSignal(this.adUnitId, this.adFormat, hVar, this.E, aVar);
    }

    private void f(String str, Throwable th) {
        x xVar = this.logger;
        if (x.Fn()) {
            x xVar2 = this.logger;
            String str2 = this.tag;
            xVar2.c(str2, "No signals collected: " + str, th);
        }
        a aVar = this.awo;
        if (aVar != null) {
            aVar.a(new JSONArray());
        }
    }

    /* renamed from: com.applovin.impl.mediation.d.b$b  reason: collision with other inner class name */
    private static class C0070b implements g.a, Runnable {
        private final AtomicBoolean amC;
        private final a awo;
        private final Object awp;
        private int awq;
        private final Collection<g> awr;
        private final x logger;
        private final n sdk;

        private C0070b(int i, a aVar, n nVar) {
            this.awq = i;
            this.awo = aVar;
            this.sdk = nVar;
            this.logger = nVar.BN();
            this.awp = new Object();
            this.awr = new ArrayList(i);
            this.amC = new AtomicBoolean();
        }

        public void a(g gVar) {
            boolean z;
            synchronized (this.awp) {
                this.awr.add(gVar);
                int i = this.awq - 1;
                this.awq = i;
                z = i < 1;
            }
            if (z && this.amC.compareAndSet(false, true)) {
                if (!u.Lx() || !((Boolean) this.sdk.a(com.applovin.impl.sdk.c.b.aQI)).booleanValue()) {
                    zB();
                } else {
                    this.sdk.BO().a((d) new ab(this.sdk, "handleSignalCollectionCompleted", new b$b$$ExternalSyntheticLambda0(this)), q.b.MEDIATION_MAIN);
                }
            }
        }

        public void run() {
            if (this.amC.compareAndSet(false, true)) {
                zB();
            }
        }

        /* access modifiers changed from: private */
        public void zB() {
            ArrayList<g> arrayList;
            synchronized (this.awp) {
                arrayList = new ArrayList<>(this.awr);
            }
            JSONArray jSONArray = new JSONArray();
            for (g gVar : arrayList) {
                try {
                    JSONObject jSONObject = new JSONObject();
                    h yH = gVar.yH();
                    jSONObject.put("name", yH.yA());
                    jSONObject.put("class", yH.vt());
                    jSONObject.put("adapter_version", gVar.getAdapterVersion());
                    jSONObject.put("sdk_version", gVar.getSdkVersion());
                    JSONObject jSONObject2 = new JSONObject();
                    if (StringUtils.isValidString(gVar.getErrorMessage())) {
                        jSONObject2.put("error_message", gVar.getErrorMessage());
                    } else {
                        jSONObject2.put("signal", gVar.yI());
                    }
                    jSONObject2.put("signal_collection_time_ms", gVar.yJ());
                    jSONObject.put("data", jSONObject2);
                    jSONArray.put(jSONObject);
                    if (x.Fn()) {
                        x xVar = this.logger;
                        xVar.f("TaskCollectSignals", "Collected signal from " + yH);
                    }
                } catch (JSONException e) {
                    if (x.Fn()) {
                        this.logger.c("TaskCollectSignals", "Failed to create signal data", e);
                    }
                    this.sdk.Cs().d("TaskCollectSignals", "createSignalsData", e);
                }
            }
            d(jSONArray);
        }

        private void d(JSONArray jSONArray) {
            a aVar = this.awo;
            if (aVar != null) {
                aVar.a(jSONArray);
            }
        }
    }

    public static void p(JSONObject jSONObject) {
        synchronized (awm) {
            awl = jSONObject;
        }
    }

    public static void c(JSONObject jSONObject, n nVar) {
        try {
            JSONObject jSONObject2 = JsonUtils.getJSONObject(jSONObject, "ad_unit_signal_providers", (JSONObject) null);
            if (jSONObject2 != null) {
                for (String str : JsonUtils.toList(jSONObject2.names())) {
                    awn.put(str, new HashSet(JsonUtils.getList(jSONObject2, str, (List) null)));
                }
            }
        } catch (JSONException e) {
            x.e("TaskCollectSignals", "Failed to parse ad unit signal providers for JSON object: " + jSONObject, e);
            nVar.Cs().d("TaskCollectSignals", "parseAdUnitSignalProvidersJSON", e);
        }
    }
}
