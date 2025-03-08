package com.ironsource;

import com.ironsource.mediationsdk.d;
import com.ironsource.mediationsdk.impressionData.ImpressionData;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

public class d1 {
    public static final String n = "adMarkup";
    public static final String o = "instance";
    public static final String p = "adData";
    public static final String q = "price";
    public static final String r = "serverData";
    public static final String s = "loadTimeout";
    public static final String t = "order";
    public static final String u = "show";
    public static final String v = "price";
    public static final String w = "notifications";
    public static final String x = "burl";
    public static final String y = "lurl";
    public static final String z = "nurl";
    private String a;
    private String b;
    private JSONObject c;
    private String d;
    private Integer e;
    private int f;
    private int g;
    private int h;
    private final List<String> i;
    private final List<String> j;
    private final List<String> k;
    private ImpressionData l;
    private boolean m;

    public d1(String str) {
        this.a = null;
        this.b = "";
        this.c = null;
        this.d = "";
        this.e = null;
        this.f = -1;
        this.g = -1;
        this.h = -1;
        this.i = new ArrayList();
        this.j = new ArrayList();
        this.k = new ArrayList();
        this.l = null;
        this.m = true;
        this.a = str;
    }

    public d1(JSONObject jSONObject) {
        this(jSONObject, -1, (JSONObject) null);
    }

    /* JADX WARNING: Removed duplicated region for block: B:14:0x007b A[Catch:{ Exception -> 0x00c7 }] */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x00ac A[Catch:{ Exception -> 0x00c7 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public d1(org.json.JSONObject r13, int r14, org.json.JSONObject r15) {
        /*
            r12 = this;
            java.lang.String r0 = "loadTimeout"
            java.lang.String r1 = "notifications"
            java.lang.String r2 = "serverData"
            java.lang.String r3 = "adMarkup"
            java.lang.String r4 = "instance"
            r12.<init>()
            r5 = 0
            r12.a = r5
            java.lang.String r6 = ""
            r12.b = r6
            r12.c = r5
            r12.d = r6
            r12.e = r5
            r6 = -1
            r12.f = r6
            r12.g = r6
            r12.h = r6
            java.util.ArrayList r6 = new java.util.ArrayList
            r6.<init>()
            r12.i = r6
            java.util.ArrayList r7 = new java.util.ArrayList
            r7.<init>()
            r12.j = r7
            java.util.ArrayList r8 = new java.util.ArrayList
            r8.<init>()
            r12.k = r8
            r12.l = r5
            r9 = 1
            r12.m = r9
            r10 = 0
            boolean r11 = r13.has(r4)     // Catch:{ Exception -> 0x00c7 }
            if (r11 == 0) goto L_0x0048
            java.lang.String r4 = r13.getString(r4)     // Catch:{ Exception -> 0x00c7 }
            r12.a = r4     // Catch:{ Exception -> 0x00c7 }
        L_0x0048:
            boolean r4 = r13.has(r3)     // Catch:{ Exception -> 0x00c7 }
            if (r4 == 0) goto L_0x0053
            java.lang.String r2 = r13.getString(r3)     // Catch:{ Exception -> 0x00c7 }
            goto L_0x0061
        L_0x0053:
            boolean r3 = r13.has(r2)     // Catch:{ Exception -> 0x00c7 }
            if (r3 == 0) goto L_0x0063
            org.json.JSONObject r2 = r13.getJSONObject(r2)     // Catch:{ Exception -> 0x00c7 }
            java.lang.String r2 = r2.toString()     // Catch:{ Exception -> 0x00c7 }
        L_0x0061:
            r12.b = r2     // Catch:{ Exception -> 0x00c7 }
        L_0x0063:
            java.lang.String r2 = "adData"
            org.json.JSONObject r2 = r13.optJSONObject(r2)     // Catch:{ Exception -> 0x00c7 }
            r12.c = r2     // Catch:{ Exception -> 0x00c7 }
            java.lang.String r2 = "price"
            java.lang.String r3 = "0"
            java.lang.String r2 = r13.optString(r2, r3)     // Catch:{ Exception -> 0x00c7 }
            r12.d = r2     // Catch:{ Exception -> 0x00c7 }
            boolean r2 = r13.has(r1)     // Catch:{ Exception -> 0x00c7 }
            if (r2 == 0) goto L_0x008e
            org.json.JSONObject r1 = r13.getJSONObject(r1)     // Catch:{ Exception -> 0x00c7 }
            java.lang.String r2 = "burl"
            r12.a(r1, r2, r6)     // Catch:{ Exception -> 0x00c7 }
            java.lang.String r2 = "lurl"
            r12.a(r1, r2, r7)     // Catch:{ Exception -> 0x00c7 }
            java.lang.String r2 = "nurl"
            r12.a(r1, r2, r8)     // Catch:{ Exception -> 0x00c7 }
        L_0x008e:
            java.lang.String r1 = "armData"
            org.json.JSONObject r1 = r13.optJSONObject(r1)     // Catch:{ Exception -> 0x00c7 }
            com.ironsource.mediationsdk.impressionData.ImpressionData r2 = new com.ironsource.mediationsdk.impressionData.ImpressionData     // Catch:{ Exception -> 0x00c7 }
            r3 = 2
            org.json.JSONObject[] r3 = new org.json.JSONObject[r3]     // Catch:{ Exception -> 0x00c7 }
            r3[r10] = r15     // Catch:{ Exception -> 0x00c7 }
            r3[r9] = r1     // Catch:{ Exception -> 0x00c7 }
            org.json.JSONObject r15 = com.ironsource.g8.a((org.json.JSONObject[]) r3)     // Catch:{ Exception -> 0x00c7 }
            r2.<init>((org.json.JSONObject) r15)     // Catch:{ Exception -> 0x00c7 }
            r12.l = r2     // Catch:{ Exception -> 0x00c7 }
            boolean r15 = r13.has(r0)     // Catch:{ Exception -> 0x00c7 }
            if (r15 == 0) goto L_0x00bb
            java.util.concurrent.TimeUnit r15 = java.util.concurrent.TimeUnit.MILLISECONDS     // Catch:{ Exception -> 0x00c7 }
            long r0 = r13.getLong(r0)     // Catch:{ Exception -> 0x00c7 }
            long r0 = r15.toSeconds(r0)     // Catch:{ Exception -> 0x00c7 }
            int r15 = (int) r0     // Catch:{ Exception -> 0x00c7 }
            java.lang.Integer r5 = java.lang.Integer.valueOf(r15)     // Catch:{ Exception -> 0x00c7 }
        L_0x00bb:
            r12.e = r5     // Catch:{ Exception -> 0x00c7 }
            java.lang.String r15 = "order"
            org.json.JSONObject r13 = r13.optJSONObject(r15)     // Catch:{ Exception -> 0x00c7 }
            r12.a(r13, r14)     // Catch:{ Exception -> 0x00c7 }
            goto L_0x00e1
        L_0x00c7:
            r13 = move-exception
            r12.m = r10
            com.ironsource.mediationsdk.logger.IronLog r14 = com.ironsource.mediationsdk.logger.IronLog.INTERNAL
            java.lang.StringBuilder r15 = new java.lang.StringBuilder
            java.lang.String r0 = "exception "
            r15.<init>(r0)
            java.lang.String r13 = r13.getMessage()
            r15.append(r13)
            java.lang.String r13 = r15.toString()
            r14.error(r13)
        L_0x00e1:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ironsource.d1.<init>(org.json.JSONObject, int, org.json.JSONObject):void");
    }

    private void a(JSONObject jSONObject, int i2) {
        this.f = i2;
        this.g = i2;
        this.h = i2;
        if (jSONObject != null) {
            int optInt = jSONObject.optInt(u, i2);
            this.g = optInt;
            this.h = jSONObject.optInt("price", optInt);
        }
    }

    private void a(JSONObject jSONObject, String str, List<String> list) throws JSONException {
        if (jSONObject.has(str)) {
            list.addAll(g8.b(jSONObject.getJSONArray(str)));
        }
    }

    public ImpressionData a(String str) {
        ImpressionData impressionData = this.l;
        if (impressionData == null) {
            return null;
        }
        ImpressionData impressionData2 = new ImpressionData(impressionData);
        impressionData2.replaceMacroForPlacementWithValue(d.q, str);
        return impressionData2;
    }

    public JSONObject a() {
        return this.c;
    }

    public List<String> b() {
        return this.i;
    }

    public String c() {
        return this.a;
    }

    public int d() {
        return this.f;
    }

    public Integer e() {
        return this.e;
    }

    public List<String> f() {
        return this.j;
    }

    public List<String> g() {
        return this.k;
    }

    public String h() {
        return this.d;
    }

    public int i() {
        return this.h;
    }

    public String j() {
        return this.b;
    }

    public int k() {
        return this.g;
    }

    public boolean l() {
        return this.m;
    }
}
