package com.fyber.inneractive.sdk.config.remote;

import java.util.List;

public class e {
    public a a;
    public List<h> b = null;
    public String c;
    public String d;

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r15v0, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r15v3, resolved type: com.fyber.inneractive.sdk.config.remote.h} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r15v4, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r15v5, resolved type: java.lang.String} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x0182  */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x0185 A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.fyber.inneractive.sdk.config.remote.e a(org.json.JSONObject r19) throws com.fyber.inneractive.sdk.external.InvalidAppIdException {
        /*
            r0 = r19
            java.lang.String r1 = "updateHash"
            r2 = 0
            java.lang.String r1 = r0.optString(r1, r2)
            boolean r3 = android.text.TextUtils.isEmpty(r1)
            if (r3 == 0) goto L_0x0010
            return r2
        L_0x0010:
            com.fyber.inneractive.sdk.config.remote.e r3 = new com.fyber.inneractive.sdk.config.remote.e
            r3.<init>()
            r3.c = r1
            java.lang.String r1 = "app"
            org.json.JSONObject r1 = r0.optJSONObject(r1)
            r4 = -1
            java.lang.String r5 = "id"
            if (r1 != 0) goto L_0x0024
            r6 = -1
            goto L_0x0028
        L_0x0024:
            int r6 = r1.optInt(r5, r4)
        L_0x0028:
            java.lang.String r7 = "isActive"
            java.lang.String r8 = "native"
            java.lang.String r9 = "viewability"
            java.lang.String r10 = "display"
            java.lang.String r11 = "video"
            java.lang.String r12 = "monitor"
            if (r6 != r4) goto L_0x0038
            r4 = r2
            goto L_0x0080
        L_0x0038:
            com.fyber.inneractive.sdk.config.remote.a r4 = new com.fyber.inneractive.sdk.config.remote.a
            r4.<init>()
            java.lang.String r6 = java.lang.String.valueOf(r6)
            r4.a = r6
            java.lang.String r6 = "publisherId"
            java.lang.String r6 = r1.optString(r6, r2)
            r4.b = r6
            org.json.JSONObject r6 = r1.optJSONObject(r12)
            com.fyber.inneractive.sdk.config.remote.f r6 = com.fyber.inneractive.sdk.config.remote.f.a(r6)
            r4.c = r6
            org.json.JSONObject r6 = r1.optJSONObject(r11)
            com.fyber.inneractive.sdk.config.remote.j r6 = com.fyber.inneractive.sdk.config.remote.j.a(r6)
            r4.d = r6
            org.json.JSONObject r6 = r1.optJSONObject(r10)
            com.fyber.inneractive.sdk.config.remote.b r6 = com.fyber.inneractive.sdk.config.remote.b.a(r6)
            r4.e = r6
            org.json.JSONObject r6 = r1.optJSONObject(r9)
            com.fyber.inneractive.sdk.config.remote.k r6 = com.fyber.inneractive.sdk.config.remote.k.a(r6)
            r4.f = r6
            java.lang.String r6 = r1.optString(r7, r2)
            r4.g = r6
            org.json.JSONObject r1 = r1.optJSONObject(r8)
            com.fyber.inneractive.sdk.config.remote.g.a(r1)
        L_0x0080:
            if (r4 != 0) goto L_0x0083
            return r2
        L_0x0083:
            r3.a = r4
            java.util.ArrayList r1 = new java.util.ArrayList
            r1.<init>()
            java.lang.String r4 = "spots"
            org.json.JSONArray r0 = r0.optJSONArray(r4)
            if (r0 == 0) goto L_0x018e
            r6 = 0
        L_0x0093:
            int r13 = r0.length()
            if (r6 >= r13) goto L_0x018e
            org.json.JSONObject r13 = r0.optJSONObject(r6)
            if (r13 != 0) goto L_0x00a0
            goto L_0x00aa
        L_0x00a0:
            java.lang.String r14 = r13.optString(r5, r2)
            boolean r15 = android.text.TextUtils.isEmpty(r14)
            if (r15 == 0) goto L_0x00b2
        L_0x00aa:
            r17 = r0
            r15 = r2
            r18 = r7
            r7 = r15
            goto L_0x0180
        L_0x00b2:
            com.fyber.inneractive.sdk.config.remote.h r15 = new com.fyber.inneractive.sdk.config.remote.h
            r15.<init>()
            r15.a = r14
            java.lang.String r14 = r13.optString(r7, r2)
            r15.b = r14
            org.json.JSONObject r14 = r13.optJSONObject(r10)
            com.fyber.inneractive.sdk.config.remote.b r14 = com.fyber.inneractive.sdk.config.remote.b.a(r14)
            r15.c = r14
            org.json.JSONObject r14 = r13.optJSONObject(r12)
            com.fyber.inneractive.sdk.config.remote.f r14 = com.fyber.inneractive.sdk.config.remote.f.a(r14)
            r15.d = r14
            org.json.JSONObject r14 = r13.optJSONObject(r8)
            com.fyber.inneractive.sdk.config.remote.g.a(r14)
            org.json.JSONObject r14 = r13.optJSONObject(r11)
            com.fyber.inneractive.sdk.config.remote.j r14 = com.fyber.inneractive.sdk.config.remote.j.a(r14)
            r15.e = r14
            org.json.JSONObject r14 = r13.optJSONObject(r9)
            com.fyber.inneractive.sdk.config.remote.k r14 = com.fyber.inneractive.sdk.config.remote.k.a(r14)
            r15.f = r14
            java.lang.String r14 = "units"
            org.json.JSONArray r13 = r13.optJSONArray(r14)
            if (r13 == 0) goto L_0x0174
            int r14 = r13.length()
            if (r14 != 0) goto L_0x00fe
            goto L_0x0174
        L_0x00fe:
            java.util.ArrayList r14 = new java.util.ArrayList
            r14.<init>()
            r4 = 0
        L_0x0104:
            int r2 = r13.length()
            if (r4 >= r2) goto L_0x016e
            org.json.JSONObject r2 = r13.optJSONObject(r4)
            r17 = r0
            if (r2 == 0) goto L_0x0160
            com.fyber.inneractive.sdk.config.remote.i r0 = new com.fyber.inneractive.sdk.config.remote.i
            r0.<init>()
            r18 = r7
            r16 = r13
            r7 = 0
            java.lang.String r13 = r2.optString(r5, r7)
            r0.a = r13
            java.lang.String r13 = "spotId"
            java.lang.String r13 = r2.optString(r13, r7)
            r0.b = r13
            org.json.JSONObject r13 = r2.optJSONObject(r10)
            com.fyber.inneractive.sdk.config.remote.b r13 = com.fyber.inneractive.sdk.config.remote.b.a(r13)
            r0.c = r13
            org.json.JSONObject r13 = r2.optJSONObject(r12)
            com.fyber.inneractive.sdk.config.remote.f r13 = com.fyber.inneractive.sdk.config.remote.f.a(r13)
            r0.d = r13
            org.json.JSONObject r13 = r2.optJSONObject(r8)
            com.fyber.inneractive.sdk.config.remote.g r13 = com.fyber.inneractive.sdk.config.remote.g.a(r13)
            r0.e = r13
            org.json.JSONObject r13 = r2.optJSONObject(r11)
            com.fyber.inneractive.sdk.config.remote.j r13 = com.fyber.inneractive.sdk.config.remote.j.a(r13)
            r0.f = r13
            org.json.JSONObject r2 = r2.optJSONObject(r9)
            com.fyber.inneractive.sdk.config.remote.k r2 = com.fyber.inneractive.sdk.config.remote.k.a(r2)
            r0.g = r2
            r14.add(r0)
            goto L_0x0165
        L_0x0160:
            r18 = r7
            r16 = r13
            r7 = 0
        L_0x0165:
            int r4 = r4 + 1
            r13 = r16
            r0 = r17
            r7 = r18
            goto L_0x0104
        L_0x016e:
            r17 = r0
            r18 = r7
            r7 = 0
            goto L_0x017e
        L_0x0174:
            r17 = r0
            r18 = r7
            r7 = r2
            java.util.ArrayList r14 = new java.util.ArrayList
            r14.<init>()
        L_0x017e:
            r15.g = r14
        L_0x0180:
            if (r15 == 0) goto L_0x0185
            r1.add(r15)
        L_0x0185:
            int r6 = r6 + 1
            r2 = r7
            r0 = r17
            r7 = r18
            goto L_0x0093
        L_0x018e:
            r3.b = r1
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fyber.inneractive.sdk.config.remote.e.a(org.json.JSONObject):com.fyber.inneractive.sdk.config.remote.e");
    }
}
