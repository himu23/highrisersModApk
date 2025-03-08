package com.ironsource.sdk.controller;

import com.ironsource.f6;
import com.ironsource.l4;
import com.ironsource.l8;
import com.ironsource.n4;
import com.ironsource.n6;
import com.ironsource.sdk.utils.IronSourceStorageUtils;
import com.ironsource.y9;
import org.json.JSONObject;

class j {
    private final String a;
    private final n4 b;

    class a implements y9 {
        final /* synthetic */ l a;
        final /* synthetic */ l8 b;

        a(l lVar, l8 l8Var) {
            this.a = lVar;
            this.b = l8Var;
        }

        public void a(n6 n6Var) {
            try {
                l lVar = this.a;
                l8 l8Var = this.b;
                lVar.b(l8Var, j.this.a(l8Var, n6Var.a()));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        public void a(n6 n6Var, f6 f6Var) {
            try {
                l lVar = this.a;
                l8 l8Var = this.b;
                lVar.a(l8Var, j.this.a(l8Var, f6Var.b()));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    j(String str, n4 n4Var) {
        this.a = str;
        this.b = n4Var;
    }

    private n6 a(JSONObject jSONObject, String str) throws Exception {
        if (jSONObject.has(l4.c.d)) {
            return new n6(IronSourceStorageUtils.buildAbsolutePathToDirInCache(str, jSONObject.getString(l4.c.d)));
        }
        throw new Exception(l4.a.b);
    }

    private y9 a(l8 l8Var, l lVar) {
        return new a(lVar, l8Var);
    }

    private JSONObject a(l8 l8Var, long j) {
        try {
            return l8Var.e().put("result", j);
        } catch (Exception e) {
            e.printStackTrace();
            return new JSONObject();
        }
    }

    /* access modifiers changed from: private */
    public JSONObject a(l8 l8Var, String str) {
        try {
            return l8Var.e().put("errMsg", str);
        } catch (Exception e) {
            e.printStackTrace();
            return new JSONObject();
        }
    }

    /* access modifiers changed from: private */
    public JSONObject a(l8 l8Var, JSONObject jSONObject) {
        try {
            return l8Var.e().put("result", jSONObject);
        } catch (Exception e) {
            e.printStackTrace();
            return new JSONObject();
        }
    }

    private n6 b(JSONObject jSONObject, String str) throws Exception {
        if (!jSONObject.has(l4.c.c) || !jSONObject.has(l4.c.b)) {
            throw new Exception(l4.a.a);
        }
        String string = jSONObject.getString(l4.c.c);
        return new n6(IronSourceStorageUtils.buildAbsolutePathToDirInCache(str, string), jSONObject.getString(l4.c.b));
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void a(org.json.JSONObject r10, com.ironsource.sdk.controller.u.v.e0 r11) {
        /*
            r9 = this;
            com.ironsource.l8 r0 = new com.ironsource.l8
            r0.<init>(r10)
            com.ironsource.sdk.controller.l r10 = new com.ironsource.sdk.controller.l
            r10.<init>(r11)
            java.lang.String r11 = r0.b()     // Catch:{ Exception -> 0x00ce }
            org.json.JSONObject r1 = r0.c()     // Catch:{ Exception -> 0x00ce }
            java.lang.String r2 = r9.a     // Catch:{ Exception -> 0x00ce }
            com.ironsource.n6 r4 = r9.b(r1, r2)     // Catch:{ Exception -> 0x00ce }
            java.lang.String r2 = r9.a     // Catch:{ Exception -> 0x00ce }
            com.ironsource.sdk.utils.IronSourceStorageUtils.ensurePathSafety(r4, r2)     // Catch:{ Exception -> 0x00ce }
            int r2 = r11.hashCode()     // Catch:{ Exception -> 0x00ce }
            r3 = 5
            r5 = 4
            r6 = 3
            r7 = 2
            r8 = 1
            switch(r2) {
                case -2073025383: goto L_0x005c;
                case -1137024519: goto L_0x0052;
                case -318115535: goto L_0x0048;
                case 537556755: goto L_0x003e;
                case 1764172231: goto L_0x0034;
                case 1953259713: goto L_0x002a;
                default: goto L_0x0029;
            }     // Catch:{ Exception -> 0x00ce }
        L_0x0029:
            goto L_0x0066
        L_0x002a:
            java.lang.String r2 = "getFiles"
            boolean r11 = r11.equals(r2)     // Catch:{ Exception -> 0x00ce }
            if (r11 == 0) goto L_0x0066
            r11 = 3
            goto L_0x0067
        L_0x0034:
            java.lang.String r2 = "deleteFile"
            boolean r11 = r11.equals(r2)     // Catch:{ Exception -> 0x00ce }
            if (r11 == 0) goto L_0x0066
            r11 = 1
            goto L_0x0067
        L_0x003e:
            java.lang.String r2 = "updateAttributesOfFile"
            boolean r11 = r11.equals(r2)     // Catch:{ Exception -> 0x00ce }
            if (r11 == 0) goto L_0x0066
            r11 = 5
            goto L_0x0067
        L_0x0048:
            java.lang.String r2 = "getTotalSizeOfFiles"
            boolean r11 = r11.equals(r2)     // Catch:{ Exception -> 0x00ce }
            if (r11 == 0) goto L_0x0066
            r11 = 4
            goto L_0x0067
        L_0x0052:
            java.lang.String r2 = "deleteFolder"
            boolean r11 = r11.equals(r2)     // Catch:{ Exception -> 0x00ce }
            if (r11 == 0) goto L_0x0066
            r11 = 2
            goto L_0x0067
        L_0x005c:
            java.lang.String r2 = "saveFile"
            boolean r11 = r11.equals(r2)     // Catch:{ Exception -> 0x00ce }
            if (r11 == 0) goto L_0x0066
            r11 = 0
            goto L_0x0067
        L_0x0066:
            r11 = -1
        L_0x0067:
            if (r11 == 0) goto L_0x00b2
            if (r11 == r8) goto L_0x00a4
            if (r11 == r7) goto L_0x009a
            if (r11 == r6) goto L_0x0093
            if (r11 == r5) goto L_0x0088
            if (r11 == r3) goto L_0x0074
            goto L_0x00da
        L_0x0074:
            java.lang.String r11 = "attributesToUpdate"
            org.json.JSONObject r11 = r1.optJSONObject(r11)     // Catch:{ Exception -> 0x00ce }
            com.ironsource.n4 r1 = r9.b     // Catch:{ Exception -> 0x00ce }
            r1.a(r4, r11)     // Catch:{ Exception -> 0x00ce }
            org.json.JSONObject r11 = r4.a()     // Catch:{ Exception -> 0x00ce }
        L_0x0083:
            org.json.JSONObject r11 = r9.a((com.ironsource.l8) r0, (org.json.JSONObject) r11)     // Catch:{ Exception -> 0x00ce }
            goto L_0x00ae
        L_0x0088:
            com.ironsource.n4 r11 = r9.b     // Catch:{ Exception -> 0x00ce }
            long r1 = r11.d(r4)     // Catch:{ Exception -> 0x00ce }
            org.json.JSONObject r11 = r9.a((com.ironsource.l8) r0, (long) r1)     // Catch:{ Exception -> 0x00ce }
            goto L_0x00ae
        L_0x0093:
            com.ironsource.n4 r11 = r9.b     // Catch:{ Exception -> 0x00ce }
            org.json.JSONObject r11 = r11.c(r4)     // Catch:{ Exception -> 0x00ce }
            goto L_0x0083
        L_0x009a:
            com.ironsource.n4 r11 = r9.b     // Catch:{ Exception -> 0x00ce }
            r11.b(r4)     // Catch:{ Exception -> 0x00ce }
            org.json.JSONObject r11 = r4.a()     // Catch:{ Exception -> 0x00ce }
            goto L_0x0083
        L_0x00a4:
            com.ironsource.n4 r11 = r9.b     // Catch:{ Exception -> 0x00ce }
            r11.a((com.ironsource.n6) r4)     // Catch:{ Exception -> 0x00ce }
            org.json.JSONObject r11 = r4.a()     // Catch:{ Exception -> 0x00ce }
            goto L_0x0083
        L_0x00ae:
            r10.b(r0, r11)     // Catch:{ Exception -> 0x00ce }
            goto L_0x00da
        L_0x00b2:
            java.lang.String r11 = "fileUrl"
            java.lang.String r5 = r1.optString(r11)     // Catch:{ Exception -> 0x00ce }
            java.lang.String r11 = "connectionTimeout"
            int r6 = r1.optInt(r11)     // Catch:{ Exception -> 0x00ce }
            java.lang.String r11 = "readTimeout"
            int r7 = r1.optInt(r11)     // Catch:{ Exception -> 0x00ce }
            com.ironsource.y9 r8 = r9.a((com.ironsource.l8) r0, (com.ironsource.sdk.controller.l) r10)     // Catch:{ Exception -> 0x00ce }
            com.ironsource.n4 r3 = r9.b     // Catch:{ Exception -> 0x00ce }
            r3.a(r4, r5, r6, r7, r8)     // Catch:{ Exception -> 0x00ce }
            goto L_0x00da
        L_0x00ce:
            r11 = move-exception
            java.lang.String r11 = r11.getMessage()
            org.json.JSONObject r11 = r9.a((com.ironsource.l8) r0, (java.lang.String) r11)
            r10.a(r0, r11)
        L_0x00da:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ironsource.sdk.controller.j.a(org.json.JSONObject, com.ironsource.sdk.controller.u$v$e0):void");
    }
}
