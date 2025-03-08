package com.ironsource.mediationsdk;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import com.ironsource.b1;
import com.ironsource.d0;
import com.ironsource.d1;
import com.ironsource.environment.ContextProvider;
import com.ironsource.environment.thread.IronSourceThreadManager;
import com.ironsource.g$$ExternalSyntheticApiModelOutline0;
import com.ironsource.g8;
import com.ironsource.i9;
import com.ironsource.jc;
import com.ironsource.k0;
import com.ironsource.k8;
import com.ironsource.m3;
import com.ironsource.mediationsdk.IronSource;
import com.ironsource.mediationsdk.demandOnly.p;
import com.ironsource.mediationsdk.logger.IronLog;
import com.ironsource.mediationsdk.utils.IronSourceAES;
import com.ironsource.mediationsdk.utils.IronSourceConstants;
import com.ironsource.mediationsdk.utils.IronSourceUtils;
import com.ironsource.t4;
import com.ironsource.u3;
import com.ironsource.v0;
import com.ironsource.va;
import com.ironsource.y3;
import com.ironsource.z0;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class d {
    private static final String A = "bannerHeight";
    private static final String B = "bannerSize";
    private static final String C = "bannerWidth";
    private static final String D = "biddingAdditionalData";
    private static final String E = "browserUserAgent";
    private static final String F = "bundleId";
    private static final String G = "clientParams";
    private static final String H = "clientTimestamp";
    private static final String I = "consent";
    private static final String J = "connectionType";
    private static final String K = "deviceHeight";
    private static final String L = "deviceLang";
    private static final String M = "deviceMake";
    private static final String N = "deviceModel";
    private static final String O = "deviceOS";
    private static final String P = "deviceOSVersion";
    private static final String Q = "deviceType";
    private static final String R = "deviceWidth";
    private static final String S = "fs";
    private static final String T = "instances";
    private static final String U = "instanceType";
    private static final String V = "isLimitAdTrackingEnabled";
    private static final String W = "metaData";
    private static final String X = "mobileCarrier";
    private static final String Y = "performance";
    private static final String Z = "SDKVersion";
    private static final String a0 = "secure";
    private static final String b = "AuctionDataUtils";
    private static final String b0 = "sessionDepth";
    public static final String c = "auctionId";
    private static final String c0 = "sessionId";
    public static final String d = "armData";
    private static final String d0 = "auid";
    public static final String e = "isAdUnitCapped";
    private static final String e0 = "";
    public static final String f = "settings";
    public static final String f0 = "isOneFlow";
    public static final String g = "waterfall";
    public static final String g0 = "dlpl";
    public static final String h = "genericParams";
    public static final String h0 = "mt";
    public static final String i = "configurations";
    public static final String i0 = "adUnit";
    public static final String j = "instances";
    public static final String j0 = "isDemandOnly";
    public static final String k = "${AUCTION_LOSS}";
    public static final String k0 = "doNotEncryptResponse";
    public static final String l = "${AUCTION_MBR}";
    private static final String l0 = "testSuite";
    public static final String m = "${AUCTION_PRICE}";
    private static final String m0 = "test";
    public static final String n = "${DYNAMIC_DEMAND_SOURCE}";
    public static final String n0 = "parallelLoad";
    public static final String o = "${INSTANCE}";
    public static final String o0 = "bidderExclusive";
    public static final String p = "${INSTANCE_TYPE}";
    public static final String p0 = "showPriorityEnabled";
    public static final String q = "${PLACEMENT_NAME}";
    public static final boolean q0 = false;
    private static final String r = "adMarkup";
    private static d r0 = new d();
    private static final String s = "dynamicDemandSource";
    private static final String t = "params";
    private static final String u = "advId";
    private static final String v = "advIdType";
    private static final String w = "applicationKey";
    private static final String x = "applicationUserId";
    private static final String y = "appVersion";
    private static final String z = "auctionData";
    private final AtomicBoolean a = new AtomicBoolean(false);

    public static class a {
        private String a;
        /* access modifiers changed from: private */
        public List<d1> b;
        /* access modifiers changed from: private */
        public d1 c;
        /* access modifiers changed from: private */
        public JSONObject d;
        /* access modifiers changed from: private */
        public JSONObject e;
        /* access modifiers changed from: private */
        public int f;
        /* access modifiers changed from: private */
        public String g;
        /* access modifiers changed from: private */
        public v0 h;

        public a(String str) {
            this.a = str;
        }

        public p a(String str) {
            v0 v0Var = this.h;
            return v0Var != null ? v0Var.a(str) : new p.b();
        }

        public String a() {
            return this.a;
        }

        public JSONObject b() {
            return this.e;
        }

        public int c() {
            return this.f;
        }

        public String d() {
            return this.g;
        }

        public d1 e() {
            return this.c;
        }

        public JSONObject f() {
            return this.d;
        }

        public v0 g() {
            return this.h;
        }

        public List<d1> h() {
            return this.b;
        }
    }

    static class b implements Runnable {
        private static final int d = 15000;
        private String a;
        private String b;
        private String c;

        public b(String str, String str2, String str3) {
            this.a = str;
            this.b = str2;
            this.c = str3;
        }

        public void run() {
            String str = this.a + ";" + this.b + ";" + this.c;
            try {
                HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(this.c).openConnection();
                httpURLConnection.setRequestMethod(i9.a);
                httpURLConnection.setReadTimeout(d);
                httpURLConnection.setConnectTimeout(d);
                httpURLConnection.connect();
                int responseCode = httpURLConnection.getResponseCode();
                String responseMessage = httpURLConnection.getResponseMessage();
                httpURLConnection.disconnect();
                if (responseCode == 200) {
                    return;
                }
                if (responseCode != 204) {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put(IronSourceConstants.EVENTS_PROVIDER, "Mediation");
                    jSONObject.put(IronSourceConstants.EVENTS_PROGRAMMATIC, 1);
                    jSONObject.put(IronSourceConstants.EVENTS_EXT1, str);
                    jSONObject.put("errorCode", responseCode);
                    jSONObject.put("reason", responseMessage);
                    va.i().a(new y3(IronSourceConstants.TROUBLESHOOTING_FAILED_TO_SEND_AUCTION_URL, jSONObject));
                }
            } catch (Exception e) {
                e.printStackTrace();
                IronLog.INTERNAL.error("Send auction url failed with params - " + str + ";" + e.getMessage());
            }
        }
    }

    private enum c {
        NOT_SECURE,
        SECURE
    }

    private c a() {
        c cVar = c.SECURE;
        int i2 = Build.VERSION.SDK_INT;
        if (i2 >= 28) {
            if (!g$$ExternalSyntheticApiModelOutline0.m().isCleartextTrafficPermitted()) {
                return cVar;
            }
        } else if (i2 >= 23 && (ContextProvider.getInstance().getApplicationContext().getApplicationInfo().flags & 134217728) == 0) {
            return cVar;
        }
        return c.NOT_SECURE;
    }

    private String a(String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return "";
        }
        double parseDouble = Double.parseDouble(str);
        double parseDouble2 = Double.parseDouble(str2);
        return parseDouble2 == 0.0d ? "" : String.valueOf(((double) Math.round((parseDouble / parseDouble2) * 1000.0d)) / 1000.0d);
    }

    private JSONObject a(JSONObject jSONObject, List<String> list) {
        if (list.isEmpty()) {
            list = jc.y1;
        }
        return d(jSONObject, list);
    }

    private String b() {
        return Locale.getDefault().getLanguage();
    }

    private JSONObject b(JSONObject jSONObject, List<String> list) {
        return list.isEmpty() ? jSONObject : d(jSONObject, list);
    }

    public static d c() {
        return r0;
    }

    private JSONObject c(JSONObject jSONObject, List<String> list) {
        JSONObject jSONObject2 = new JSONObject();
        if (jSONObject != null) {
            Iterator<String> keys = jSONObject.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                try {
                    String a2 = a(jc.z1, next);
                    if ((list.isEmpty() && !jc.y1.contains(a2) && !a2.startsWith(jc.r1)) || list.contains(a2)) {
                        jSONObject2.put(a2, jSONObject.opt(next));
                    }
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            }
        }
        return jSONObject2;
    }

    private JSONObject d(JSONObject jSONObject, List<String> list) {
        JSONObject jSONObject2 = new JSONObject();
        if (jSONObject != null) {
            Iterator<String> keys = jSONObject.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                try {
                    if (list.contains(next)) {
                        jSONObject2.put(next, jSONObject.opt(next));
                    }
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            }
        }
        return jSONObject2;
    }

    public d1 a(String str, List<d1> list) {
        for (int i2 = 0; i2 < list.size(); i2++) {
            if (list.get(i2).c().equals(str)) {
                return list.get(i2);
            }
        }
        return null;
    }

    public String a(String str, int i2, d1 d1Var, String str2, String str3, String str4) {
        String h2 = d1Var.h();
        return a(str, d1Var.c(), i2, c().d(d1Var.j()), h2, c().a(h2, str2), str3, str4);
    }

    public String a(String str, String str2, int i2, String str3, String str4, String str5, String str6, String str7) {
        return str.replace(m, str4).replace(k, str6).replace(l, str5).replace(o, str2).replace(p, Integer.toString(i2)).replace(n, str3).replace(q, str7);
    }

    /* access modifiers changed from: package-private */
    public String a(HashMap<String, String> hashMap, String str) {
        return hashMap.containsKey(str) ? hashMap.get(str) : str;
    }

    /* access modifiers changed from: package-private */
    public String a(JSONObject jSONObject) {
        return IronSourceAES.encode(u3.b().c(), jSONObject.toString());
    }

    /* access modifiers changed from: package-private */
    public String a(JSONObject jSONObject, String str) {
        if (!jSONObject.has(str)) {
            return str;
        }
        int i2 = 0;
        String str2 = str;
        while (jSONObject.has(str2)) {
            i2++;
            str2 = str + "_" + i2;
        }
        return str2;
    }

    /* access modifiers changed from: package-private */
    public JSONObject a(Context context, Map<String, Object> map, List<String> list, h hVar, int i2, String str, com.ironsource.mediationsdk.utils.a aVar, ISBannerSize iSBannerSize, JSONObject jSONObject, boolean z2, boolean z3) throws JSONException {
        String str2;
        h hVar2 = hVar;
        JSONObject jSONObject2 = jSONObject;
        JSONObject jSONObject3 = new JSONObject();
        Iterator<String> it = map.keySet().iterator();
        while (true) {
            str2 = "";
            if (!it.hasNext()) {
                break;
            }
            String next = it.next();
            JSONObject jSONObject4 = new JSONObject();
            jSONObject4.put("instanceType", 2);
            Map<String, Object> map2 = map;
            jSONObject4.put(D, new JSONObject((Map) map.get(next)));
            if (hVar2 != null) {
                str2 = hVar2.a(next);
            }
            jSONObject4.put(Y, str2);
            if (z3) {
                jSONObject4.put(m0, 1);
            }
            jSONObject3.put(next, jSONObject4);
        }
        if (list != null) {
            for (String next2 : list) {
                JSONObject jSONObject5 = new JSONObject();
                jSONObject5.put("instanceType", 1);
                jSONObject5.put(Y, hVar2 != null ? hVar2.a(next2) : str2);
                jSONObject3.put(next2, jSONObject5);
            }
        }
        ConcurrentHashMap<String, List<String>> c2 = c.b().c();
        c2.putAll(k8.b().c());
        JSONObject jSONObject6 = new JSONObject();
        for (Map.Entry next3 : c2.entrySet()) {
            jSONObject6.put((String) next3.getKey(), TextUtils.join(",", (Iterable) next3.getValue()));
        }
        a(new z0((t4.a) null).a(), false);
        JSONObject jSONObject7 = new JSONObject();
        String q2 = p.o().q();
        if (!TextUtils.isEmpty(q2)) {
            jSONObject7.put("applicationUserId", q2);
        }
        Boolean j2 = p.o().j();
        if (j2 != null) {
            jSONObject7.put("consent", j2.booleanValue() ? 1 : 0);
        }
        jSONObject7.put("mobileCarrier", m3.x(context));
        jSONObject7.put("connectionType", IronSourceUtils.getConnectionType(context));
        jSONObject7.put("deviceOS", "android");
        jSONObject7.put("deviceWidth", context.getResources().getConfiguration().screenWidthDp);
        jSONObject7.put("deviceHeight", context.getResources().getConfiguration().screenHeightDp);
        jSONObject7.put("deviceOSVersion", Build.VERSION.SDK_INT + "(" + Build.VERSION.RELEASE + ")");
        jSONObject7.put("deviceModel", Build.MODEL);
        jSONObject7.put("deviceMake", Build.MANUFACTURER);
        jSONObject7.put("bundleId", context.getPackageName());
        Context context2 = context;
        jSONObject7.put("appVersion", k0.b(context, context.getPackageName()));
        jSONObject7.put("clientTimestamp", new Date().getTime());
        jSONObject7.put("fs", IronSourceUtils.getFirstSession(context) ? 1 : 0);
        jSONObject7.put(E, m3.f());
        jSONObject7.put(Q, IronSourceUtils.getDeviceType(context));
        jSONObject7.put(L, b());
        jSONObject7.put(a0, a().ordinal());
        if (iSBannerSize != null) {
            jSONObject7.put("bannerSize", iSBannerSize.getDescription());
            jSONObject7.put(C, iSBannerSize.getWidth());
            jSONObject7.put(A, iSBannerSize.getHeight());
        }
        String N2 = m3.N(context);
        if (!TextUtils.isEmpty(N2)) {
            str2 = IronSourceConstants.TYPE_GAID;
        } else {
            N2 = m3.z(context);
            if (!TextUtils.isEmpty(N2)) {
                str2 = IronSourceConstants.TYPE_UUID;
            }
        }
        if (!TextUtils.isEmpty(N2)) {
            jSONObject7.put("advId", N2);
            jSONObject7.put("advIdType", str2);
        }
        String O2 = m3.O(context);
        if (!TextUtils.isEmpty(O2)) {
            jSONObject7.put("isLimitAdTrackingEnabled", O2);
        }
        String P2 = m3.P(context);
        if (!TextUtils.isEmpty(P2)) {
            jSONObject7.put("asid", P2);
        }
        String f2 = m3.f(context);
        if (!TextUtils.isEmpty(f2)) {
            jSONObject7.put("auid", f2);
        }
        JSONObject jSONObject8 = new JSONObject();
        jSONObject8.put("applicationKey", p.o().p());
        jSONObject8.put("SDKVersion", IronSourceUtils.getSDKVersion());
        jSONObject8.put(G, jSONObject7);
        jSONObject8.put("sessionDepth", i2);
        jSONObject8.put("sessionId", str);
        jSONObject8.put("instances", jSONObject3);
        jSONObject8.put(z, aVar.a());
        jSONObject8.put(W, jSONObject6);
        if (jSONObject2 != null) {
            jSONObject8.put(t4.J0, jSONObject2);
        }
        if (z2) {
            jSONObject8.put(l0, 1);
        }
        return jSONObject8;
    }

    /* access modifiers changed from: package-private */
    public JSONObject a(i iVar) throws JSONException {
        boolean z2;
        boolean z3;
        String str;
        ISBannerSize iSBannerSize;
        IronSource.AD_UNIT b2 = iVar.b();
        boolean q2 = iVar.q();
        Map<String, Object> e2 = iVar.e();
        List<String> i2 = iVar.i();
        h c2 = iVar.c();
        int l2 = iVar.l();
        ISBannerSize d2 = iVar.d();
        IronSourceSegment k2 = iVar.k();
        boolean m2 = iVar.m();
        boolean n2 = iVar.n();
        ArrayList<b1> h2 = iVar.h();
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = new JSONObject();
        Iterator<String> it = e2.keySet().iterator();
        while (true) {
            z2 = m2;
            z3 = q2;
            str = "";
            iSBannerSize = d2;
            if (!it.hasNext()) {
                break;
            }
            String next = it.next();
            Iterator<String> it2 = it;
            JSONObject jSONObject3 = new JSONObject();
            IronSourceSegment ironSourceSegment = k2;
            jSONObject3.put(t4.h0, 2);
            jSONObject3.put(t4.Y, new JSONObject((Map) e2.get(next)));
            if (c2 != null) {
                str = c2.a(next);
            }
            jSONObject3.put(t4.k0, str);
            jSONObject3.put(t4.R0, n2);
            jSONObject2.put(next, jSONObject3);
            m2 = z2;
            q2 = z3;
            d2 = iSBannerSize;
            it = it2;
            k2 = ironSourceSegment;
        }
        IronSourceSegment ironSourceSegment2 = k2;
        for (String next2 : i2) {
            JSONObject jSONObject4 = new JSONObject();
            jSONObject4.put(t4.h0, 1);
            jSONObject4.put(t4.k0, c2 != null ? c2.a(next2) : str);
            jSONObject2.put(next2, jSONObject4);
        }
        Iterator<b1> it3 = h2.iterator();
        while (it3.hasNext()) {
            b1 next3 = it3.next();
            JSONObject jSONObject5 = new JSONObject();
            jSONObject5.put(t4.h0, next3.e() ? 2 : 1);
            Map<String, Object> f2 = next3.f();
            if (!f2.isEmpty()) {
                jSONObject5.put(t4.Y, new JSONObject(f2));
            }
            jSONObject5.put(t4.k0, c2 != null ? c2.a(next3.g()) : str);
            jSONObject5.put(t4.R0, n2 ? 1 : 0);
            if (!next3.h().isEmpty()) {
                jSONObject5.put(g0, next3.h());
            }
            jSONObject2.put(next3.g(), jSONObject5);
        }
        jSONObject.put(t4.g0, jSONObject2);
        if (iVar.r()) {
            jSONObject.put(t4.W0, 1);
        }
        if (iVar.p()) {
            jSONObject.put(t4.V0, 1);
        }
        JSONObject a2 = new z0(d0.a(b2)).a();
        a(a2, false);
        a2.put(t4.i0, l2);
        a2.put(t4.j0, a().ordinal());
        if (ironSourceSegment2 != null) {
            a2.put(t4.J0, ironSourceSegment2.toJson());
        }
        jSONObject.put(t4.d0, a2);
        if (iSBannerSize != null) {
            JSONObject jSONObject6 = new JSONObject();
            jSONObject6.put(t4.a0, iSBannerSize.getDescription());
            jSONObject6.put(t4.c0, iSBannerSize.getWidth());
            jSONObject6.put(t4.b0, iSBannerSize.getHeight());
            jSONObject.put(t4.Z, jSONObject6);
        }
        jSONObject.put(t4.X, b2.toString());
        jSONObject.put(t4.e0, z3 ^ true ? 1 : 0);
        Object remove = a2.remove(t4.S0);
        if (remove != null) {
            jSONObject.put(t4.S0, remove);
        }
        if (z2) {
            jSONObject.put(t4.Q0, 1);
        }
        return jSONObject;
    }

    public JSONObject a(String str) {
        try {
            return new JSONObject(IronSourceAES.decode(u3.b().c(), str));
        } catch (Exception unused) {
            return null;
        }
    }

    /* access modifiers changed from: package-private */
    public JSONObject a(JSONObject jSONObject, JSONObject jSONObject2, List<String> list) {
        JSONObject a2 = a(c0.f().g(), list);
        a(a2, c(jSONObject, list));
        a(a2, b(jSONObject2, list));
        return a2;
    }

    public void a(String str, String str2, String str3) {
        IronSourceThreadManager.INSTANCE.postMediationBackgroundTask(new b(str, str2, str3));
    }

    /* access modifiers changed from: package-private */
    public void a(JSONObject jSONObject, JSONObject jSONObject2) {
        if (jSONObject2 != null) {
            Iterator<String> keys = jSONObject2.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                try {
                    jSONObject.put(a(jSONObject, next), jSONObject2.opt(next));
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            }
        }
    }

    public void a(JSONObject jSONObject, boolean z2) {
        if (jSONObject != null && jSONObject.length() > 0 && !TextUtils.isEmpty(jSONObject.optString(t4.L0)) && this.a.compareAndSet(false, true)) {
            va.i().a(new y3(IronSourceConstants.TROUBLESHOOTING_MEDIATION_TCS_CALCULATED, IronSourceUtils.getMediationAdditionalData(z2, true, -1)));
        }
    }

    public a b(JSONObject jSONObject) throws JSONException {
        String optString = jSONObject.optString("auctionId");
        if (!TextUtils.isEmpty(optString)) {
            a aVar = new a(optString);
            JSONObject jSONObject2 = null;
            if (jSONObject.has(f)) {
                JSONObject jSONObject3 = jSONObject.getJSONObject(f);
                d1 unused = aVar.c = new d1(jSONObject3);
                if (jSONObject3.has(d)) {
                    jSONObject2 = jSONObject3.optJSONObject(d);
                }
                if (jSONObject3.has("genericParams")) {
                    JSONObject unused2 = aVar.d = jSONObject3.optJSONObject("genericParams");
                }
                if (jSONObject3.has(i)) {
                    JSONObject unused3 = aVar.e = jSONObject3.optJSONObject(i);
                }
                if (jSONObject3.has("instances")) {
                    v0 unused4 = aVar.h = new v0.a(jSONObject3.optJSONObject("instances"));
                }
            }
            List unused5 = aVar.b = new ArrayList();
            if (jSONObject.has(g)) {
                JSONArray jSONArray = jSONObject.getJSONArray(g);
                int i2 = 0;
                while (i2 < jSONArray.length()) {
                    d1 d1Var = new d1(jSONArray.getJSONObject(i2), i2, jSONObject2);
                    if (d1Var.l()) {
                        aVar.b.add(d1Var);
                        i2++;
                    } else {
                        int unused6 = aVar.f = 1002;
                        String unused7 = aVar.g = "waterfall " + i2;
                        IronLog ironLog = IronLog.INTERNAL;
                        ironLog.verbose("AuctionResponseItem " + i2 + " not valid - parsing error");
                        throw new JSONException("invalid response");
                    }
                }
            }
            return aVar;
        }
        throw new JSONException("Invalid auction response - auction id is missing");
    }

    public String b(String str) {
        try {
            if (TextUtils.isEmpty(str)) {
                return str;
            }
            JSONObject jSONObject = new JSONObject(str);
            return jSONObject.has("adMarkup") ? jSONObject.getString("adMarkup") : str;
        } catch (JSONException e2) {
            e2.printStackTrace();
            IronLog ironLog = IronLog.INTERNAL;
            ironLog.error("exception " + e2.getMessage());
            return str;
        }
    }

    public Map<String, String> c(String str) {
        HashMap hashMap = new HashMap();
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (jSONObject.has("params")) {
                JSONObject jSONObject2 = jSONObject.getJSONObject("params");
                Iterator<String> keys = jSONObject2.keys();
                while (keys.hasNext()) {
                    String next = keys.next();
                    Object obj = jSONObject2.get(next);
                    if (obj instanceof String) {
                        hashMap.put(next, (String) obj);
                    }
                }
            }
        } catch (JSONException e2) {
            e2.printStackTrace();
            IronLog ironLog = IronLog.INTERNAL;
            ironLog.error("exception " + e2.getMessage());
        }
        return hashMap;
    }

    public String d(String str) {
        try {
            if (TextUtils.isEmpty(str) || !g8.a(str)) {
                return "";
            }
            JSONObject jSONObject = new JSONObject(str);
            if (!jSONObject.has("params")) {
                return "";
            }
            JSONObject jSONObject2 = jSONObject.getJSONObject("params");
            IronLog ironLog = IronLog.INTERNAL;
            ironLog.verbose("parameters = " + jSONObject2);
            if (!jSONObject2.has("dynamicDemandSource")) {
                return "";
            }
            String string = jSONObject2.getString("dynamicDemandSource");
            ironLog.verbose("demand source = " + string);
            return string;
        } catch (JSONException e2) {
            e2.printStackTrace();
            IronLog ironLog2 = IronLog.INTERNAL;
            ironLog2.error("exception " + e2.getMessage());
            return "";
        }
    }
}
