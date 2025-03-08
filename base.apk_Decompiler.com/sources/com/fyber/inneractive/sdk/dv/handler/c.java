package com.fyber.inneractive.sdk.dv.handler;

import com.fyber.inneractive.sdk.config.enums.UnitDisplayType;
import com.fyber.inneractive.sdk.dv.g;
import com.fyber.inneractive.sdk.external.InneractiveAdRequest;
import com.fyber.inneractive.sdk.network.s;
import com.fyber.inneractive.sdk.response.e;
import com.fyber.inneractive.sdk.util.IAlog;
import com.fyber.inneractive.sdk.util.q;
import com.google.android.gms.ads.AdFormat;
import com.google.android.gms.ads.query.QueryInfo;
import com.unity3d.ads.metadata.MediationMetaData;
import java.util.HashMap;
import org.json.JSONArray;
import org.json.JSONObject;

public class c extends a<QueryInfo> {
    public final HashMap<AdFormat, QueryInfo> a = new HashMap<>();
    public boolean b = false;
    public final Object c = new Object();
    public int d = 0;

    public static /* synthetic */ class a {
        public static final /* synthetic */ int[] a;

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|(3:5|6|8)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        static {
            /*
                com.fyber.inneractive.sdk.config.enums.UnitDisplayType[] r0 = com.fyber.inneractive.sdk.config.enums.UnitDisplayType.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                a = r0
                com.fyber.inneractive.sdk.config.enums.UnitDisplayType r1 = com.fyber.inneractive.sdk.config.enums.UnitDisplayType.BANNER     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = a     // Catch:{ NoSuchFieldError -> 0x001d }
                com.fyber.inneractive.sdk.config.enums.UnitDisplayType r1 = com.fyber.inneractive.sdk.config.enums.UnitDisplayType.MRECT     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = a     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.fyber.inneractive.sdk.config.enums.UnitDisplayType r1 = com.fyber.inneractive.sdk.config.enums.UnitDisplayType.REWARDED     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.fyber.inneractive.sdk.dv.handler.c.a.<clinit>():void");
        }
    }

    public void a() {
        for (AdFormat adFormat : AdFormat.values()) {
            if (adFormat != AdFormat.NATIVE) {
                q.a(new b(this, adFormat));
            }
        }
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(3:8|9|13) */
    /* JADX WARNING: Code restructure failed: missing block: B:13:?, code lost:
        return com.google.android.gms.ads.MobileAds.getVersionString();
     */
    /* JADX WARNING: Missing exception handler attribute for start block: B:8:0x001d */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String b() {
        /*
            java.lang.String r0 = "com.google.android.gms.ads.MobileAds"
            java.lang.Class r0 = java.lang.Class.forName(r0)     // Catch:{ all -> 0x0022 }
            java.lang.String r1 = "getVersion"
            r2 = 0
            java.lang.Class[] r3 = new java.lang.Class[r2]     // Catch:{ NoSuchMethodException -> 0x001d }
            java.lang.reflect.Method r0 = r0.getMethod(r1, r3)     // Catch:{ NoSuchMethodException -> 0x001d }
            java.lang.Object[] r1 = new java.lang.Object[r2]     // Catch:{ NoSuchMethodException -> 0x001d }
            r2 = 0
            java.lang.Object r0 = r0.invoke(r2, r1)     // Catch:{ NoSuchMethodException -> 0x001d }
            if (r0 == 0) goto L_0x0022
            java.lang.String r0 = r0.toString()     // Catch:{ NoSuchMethodException -> 0x001d }
            goto L_0x0024
        L_0x001d:
            java.lang.String r0 = com.google.android.gms.ads.MobileAds.getVersionString()     // Catch:{ all -> 0x0022 }
            goto L_0x0024
        L_0x0022:
            java.lang.String r0 = "na"
        L_0x0024:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fyber.inneractive.sdk.dv.handler.c.b():java.lang.String");
    }

    public g a(UnitDisplayType unitDisplayType) {
        AdFormat adFormat;
        g gVar;
        int i = a.a[unitDisplayType.ordinal()];
        if (i == 1 || i == 2) {
            adFormat = AdFormat.BANNER;
        } else if (i != 3) {
            adFormat = AdFormat.INTERSTITIAL;
        } else {
            adFormat = AdFormat.REWARDED;
        }
        QueryInfo queryInfo = this.a.get(adFormat);
        if (queryInfo != null) {
            synchronized (this.c) {
                this.a.remove(adFormat);
            }
            gVar = new g(queryInfo);
        } else {
            gVar = null;
        }
        IAlog.a("DVHanlder - get query: %s", gVar);
        q.a(new b(this, adFormat));
        return gVar;
    }

    public static void a(String str, com.fyber.inneractive.sdk.dv.enums.a aVar, InneractiveAdRequest inneractiveAdRequest, e eVar, String str2) {
        IAlog.a(String.format("Firing Event 1001 -Phase - %s  Fetch error DV - msg  %s", new Object[]{aVar.name(), str2}), new Object[0]);
        s.a aVar2 = new s.a(com.fyber.inneractive.sdk.network.q.DV_ERROR_PHASE, inneractiveAdRequest, eVar, (JSONArray) null);
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("spot_id", str);
        } catch (Exception unused) {
            IAlog.e("Got exception adding param to json object: %s, %s", "spot_id", str);
        }
        String lowerCase = aVar.name().toLowerCase();
        try {
            jSONObject.put("phase", lowerCase);
        } catch (Exception unused2) {
            IAlog.e("Got exception adding param to json object: %s, %s", "phase", lowerCase);
        }
        String b2 = b();
        try {
            jSONObject.put(MediationMetaData.KEY_VERSION, b2);
        } catch (Exception unused3) {
            IAlog.e("Got exception adding param to json object: %s, %s", MediationMetaData.KEY_VERSION, b2);
        }
        try {
            jSONObject.put("message", str2);
        } catch (Exception unused4) {
            IAlog.e("Got exception adding param to json object: %s, %s", "message", str2);
        }
        aVar2.f.put(jSONObject);
        aVar2.a((String) null);
    }
}
