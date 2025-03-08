package com.fyber.inneractive.sdk.response;

import com.fyber.inneractive.sdk.config.global.s;
import com.fyber.inneractive.sdk.external.InneractiveAdRequest;
import com.fyber.inneractive.sdk.external.InneractiveErrorCode;
import com.fyber.inneractive.sdk.measurement.f;
import com.fyber.inneractive.sdk.model.vast.b;
import com.fyber.inneractive.sdk.model.vast.o;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class g extends e {
    public long J;
    public b K;
    public Map<o, com.fyber.inneractive.sdk.flow.vast.g> L = new LinkedHashMap();
    public List<com.fyber.inneractive.sdk.model.vast.g> M = new ArrayList();
    public final List<f> N = new ArrayList();
    public LinkedHashMap<String, String> O = new LinkedHashMap<>();

    public InneractiveErrorCode a(InneractiveAdRequest inneractiveAdRequest) {
        return a((InneractiveAdRequest) null, (s) null);
    }

    public List<f> d() {
        return this.N;
    }

    public b e() {
        return this.K;
    }

    /* JADX WARNING: Removed duplicated region for block: B:100:0x0215  */
    /* JADX WARNING: Removed duplicated region for block: B:103:0x021c  */
    /* JADX WARNING: Removed duplicated region for block: B:104:0x021e  */
    /* JADX WARNING: Removed duplicated region for block: B:112:0x024d  */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x0115  */
    /* JADX WARNING: Removed duplicated region for block: B:60:0x0148  */
    /* JADX WARNING: Removed duplicated region for block: B:61:0x014a  */
    /* JADX WARNING: Removed duplicated region for block: B:65:0x0165  */
    /* JADX WARNING: Removed duplicated region for block: B:95:0x0204  */
    /* JADX WARNING: Removed duplicated region for block: B:96:0x020b  */
    /* JADX WARNING: Removed duplicated region for block: B:99:0x0210  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.fyber.inneractive.sdk.external.InneractiveErrorCode a(com.fyber.inneractive.sdk.external.InneractiveAdRequest r18, com.fyber.inneractive.sdk.config.global.s r19) {
        /*
            r17 = this;
            r1 = r17
            r2 = r18
            com.fyber.inneractive.sdk.flow.vast.k r3 = new com.fyber.inneractive.sdk.flow.vast.k
            r3.<init>()
            java.lang.String r0 = r1.i
            java.lang.String r4 = "VastErrorInvalidFile"
            boolean r4 = r4.equals(r0)
            java.lang.String r5 = "reason"
            r6 = 0
            if (r4 == 0) goto L_0x0034
            com.fyber.inneractive.sdk.external.InneractiveErrorCode r0 = com.fyber.inneractive.sdk.external.InneractiveErrorCode.SERVER_INVALID_RESPONSE
            com.fyber.inneractive.sdk.network.q r4 = com.fyber.inneractive.sdk.network.q.VAST_ERROR_INVALID_RESPONSE
            java.lang.String r8 = r1.j
            if (r8 == 0) goto L_0x002c
            com.fyber.inneractive.sdk.network.s$b r8 = new com.fyber.inneractive.sdk.network.s$b
            r8.<init>()
            java.lang.String r9 = r1.j
            java.lang.String r10 = "exception"
            com.fyber.inneractive.sdk.network.s$b r8 = r8.a(r10, r9)
            goto L_0x002d
        L_0x002c:
            r8 = 0
        L_0x002d:
            r16 = r4
            r4 = r0
            r0 = r16
            goto L_0x0113
        L_0x0034:
            java.lang.String r4 = "ErrorNoCompatibleMediaFile"
            boolean r4 = r4.equals(r0)
            if (r4 == 0) goto L_0x00c3
            com.fyber.inneractive.sdk.external.InneractiveErrorCode r0 = com.fyber.inneractive.sdk.external.InneractiveErrorCode.SERVER_INVALID_RESPONSE
            com.fyber.inneractive.sdk.network.q r4 = com.fyber.inneractive.sdk.network.q.VAST_ERROR_NO_COMPATIBLE_MEDIA_FILE
            java.util.Map<com.fyber.inneractive.sdk.model.vast.o, com.fyber.inneractive.sdk.flow.vast.g> r8 = r1.L
            if (r8 == 0) goto L_0x002c
            java.util.Set r9 = r8.keySet()
            if (r9 == 0) goto L_0x002c
            int r10 = r9.size()
            if (r10 <= 0) goto L_0x002c
            com.fyber.inneractive.sdk.network.s$b r10 = new com.fyber.inneractive.sdk.network.s$b
            r10.<init>()
            org.json.JSONArray r11 = new org.json.JSONArray
            r11.<init>()
            java.util.Iterator r9 = r9.iterator()
        L_0x005e:
            boolean r12 = r9.hasNext()
            if (r12 == 0) goto L_0x00bb
            java.lang.Object r12 = r9.next()
            com.fyber.inneractive.sdk.model.vast.o r12 = (com.fyber.inneractive.sdk.model.vast.o) r12
            java.lang.Object r13 = r8.get(r12)     // Catch:{ JSONException -> 0x00b2 }
            com.fyber.inneractive.sdk.flow.vast.g r13 = (com.fyber.inneractive.sdk.flow.vast.g) r13     // Catch:{ JSONException -> 0x00b2 }
            org.json.JSONObject r14 = new org.json.JSONObject     // Catch:{ JSONException -> 0x00b2 }
            r14.<init>()     // Catch:{ JSONException -> 0x00b2 }
            java.lang.String r15 = "url"
            java.lang.String r7 = r12.g     // Catch:{ JSONException -> 0x00b2 }
            r14.put(r15, r7)     // Catch:{ JSONException -> 0x00b2 }
            java.lang.String r7 = "bitrate"
            java.lang.Integer r15 = r12.e     // Catch:{ JSONException -> 0x00b2 }
            r14.put(r7, r15)     // Catch:{ JSONException -> 0x00b2 }
            java.lang.String r7 = "mime"
            java.lang.String r15 = r12.d     // Catch:{ JSONException -> 0x00b2 }
            boolean r15 = android.text.TextUtils.isEmpty(r15)     // Catch:{ JSONException -> 0x00b2 }
            if (r15 == 0) goto L_0x0090
            java.lang.String r15 = "na"
            goto L_0x0092
        L_0x0090:
            java.lang.String r15 = r12.d     // Catch:{ JSONException -> 0x00b2 }
        L_0x0092:
            r14.put(r7, r15)     // Catch:{ JSONException -> 0x00b2 }
            java.lang.String r7 = "delivery"
            java.lang.String r12 = r12.a     // Catch:{ JSONException -> 0x00b2 }
            r14.put(r7, r12)     // Catch:{ JSONException -> 0x00b2 }
            com.fyber.inneractive.sdk.flow.vast.g$a r7 = r13.a     // Catch:{ JSONException -> 0x00b2 }
            if (r7 == 0) goto L_0x00a3
            int r7 = r7.value     // Catch:{ JSONException -> 0x00b2 }
            goto L_0x00a4
        L_0x00a3:
            r7 = 0
        L_0x00a4:
            r14.put(r5, r7)     // Catch:{ JSONException -> 0x00b2 }
            java.lang.String r7 = "required_value"
            java.lang.Object r12 = r13.b     // Catch:{ JSONException -> 0x00b2 }
            r14.put(r7, r12)     // Catch:{ JSONException -> 0x00b2 }
            r11.put(r14)     // Catch:{ JSONException -> 0x00b2 }
            goto L_0x005e
        L_0x00b2:
            java.lang.Object[] r7 = new java.lang.Object[r6]
            java.lang.String r8 = "VastResponseValidator: Failed converting media file data to Extra data json!"
            com.fyber.inneractive.sdk.util.IAlog.a(r8, r7)
            goto L_0x002c
        L_0x00bb:
            java.lang.String r7 = "media_files"
            r10.a(r7, r11)
            r8 = r10
            goto L_0x002d
        L_0x00c3:
            java.lang.String r4 = "VastErrorTooManyWrappers"
            boolean r4 = r4.equals(r0)
            if (r4 == 0) goto L_0x00e6
            com.fyber.inneractive.sdk.external.InneractiveErrorCode r0 = com.fyber.inneractive.sdk.external.InneractiveErrorCode.SERVER_INVALID_RESPONSE
            com.fyber.inneractive.sdk.network.q r4 = com.fyber.inneractive.sdk.network.q.VAST_ERROR_TOO_MANY_WRAPPERS
            com.fyber.inneractive.sdk.network.s$b r7 = new com.fyber.inneractive.sdk.network.s$b
            r7.<init>()
            com.fyber.inneractive.sdk.config.IAConfigManager r8 = com.fyber.inneractive.sdk.config.IAConfigManager.M
            com.fyber.inneractive.sdk.config.s r8 = r8.i
            int r8 = r8.b
            java.lang.Integer r8 = java.lang.Integer.valueOf(r8)
            java.lang.String r9 = "max"
            com.fyber.inneractive.sdk.network.s$b r8 = r7.a(r9, r8)
            goto L_0x002d
        L_0x00e6:
            java.lang.String r4 = "ErrorNoMediaFiles"
            boolean r4 = r4.equals(r0)
            if (r4 == 0) goto L_0x00f4
            com.fyber.inneractive.sdk.external.InneractiveErrorCode r0 = com.fyber.inneractive.sdk.external.InneractiveErrorCode.SERVER_INVALID_RESPONSE
            com.fyber.inneractive.sdk.network.q r4 = com.fyber.inneractive.sdk.network.q.VAST_ERROR_NO_MEDIA_FILES
            goto L_0x002c
        L_0x00f4:
            java.lang.String r4 = "ErrorConfigurationMismatch"
            boolean r4 = r4.equals(r0)
            if (r4 == 0) goto L_0x0102
            com.fyber.inneractive.sdk.external.InneractiveErrorCode r0 = com.fyber.inneractive.sdk.external.InneractiveErrorCode.ERROR_CONFIGURATION_MISMATCH
            com.fyber.inneractive.sdk.network.q r4 = com.fyber.inneractive.sdk.network.q.INTERNAL_CONFIG_MISMATCH
            goto L_0x002c
        L_0x0102:
            java.lang.String r4 = "VastErrorUnsecure"
            boolean r0 = r4.equals(r0)
            if (r0 == 0) goto L_0x0110
            com.fyber.inneractive.sdk.external.InneractiveErrorCode r0 = com.fyber.inneractive.sdk.external.InneractiveErrorCode.SERVER_INVALID_RESPONSE
            com.fyber.inneractive.sdk.network.q r4 = com.fyber.inneractive.sdk.network.q.VAST_ERROR_UNSECURE_URL
            goto L_0x002c
        L_0x0110:
            r0 = 0
            r4 = 0
            r8 = 0
        L_0x0113:
            if (r0 == 0) goto L_0x0135
            com.fyber.inneractive.sdk.network.s$a r7 = new com.fyber.inneractive.sdk.network.s$a
            if (r19 != 0) goto L_0x011b
            r9 = 0
            goto L_0x011f
        L_0x011b:
            org.json.JSONArray r9 = r19.c()
        L_0x011f:
            r7.<init>((com.fyber.inneractive.sdk.response.e) r1)
            r7.b = r0
            r7.a = r2
            r7.d = r9
            if (r8 == 0) goto L_0x0131
            org.json.JSONArray r0 = r7.f
            org.json.JSONObject r8 = r8.a
            r0.put(r8)
        L_0x0131:
            r8 = 0
            r7.a((java.lang.String) r8)
        L_0x0135:
            java.util.List<com.fyber.inneractive.sdk.model.vast.g> r0 = r1.M
            java.lang.String r7 = "Got exception adding param to json object: %s, %s"
            r9 = 1
            if (r0 == 0) goto L_0x0200
            int r10 = r0.size()
            if (r10 <= 0) goto L_0x0200
            com.fyber.inneractive.sdk.network.s$a r10 = new com.fyber.inneractive.sdk.network.s$a
            com.fyber.inneractive.sdk.network.r r11 = com.fyber.inneractive.sdk.network.r.VAST_EVENT_COMPANION_FILTERED
            if (r19 != 0) goto L_0x014a
            r12 = 0
            goto L_0x014e
        L_0x014a:
            org.json.JSONArray r12 = r19.c()
        L_0x014e:
            r10.<init>((com.fyber.inneractive.sdk.network.r) r11, (com.fyber.inneractive.sdk.external.InneractiveAdRequest) r2, (com.fyber.inneractive.sdk.response.e) r1, (org.json.JSONArray) r12)
            org.json.JSONObject r11 = new org.json.JSONObject
            r11.<init>()
            org.json.JSONArray r12 = new org.json.JSONArray
            r12.<init>()
            java.util.Iterator r13 = r0.iterator()
        L_0x015f:
            boolean r0 = r13.hasNext()
            if (r0 == 0) goto L_0x01e6
            java.lang.Object r0 = r13.next()
            com.fyber.inneractive.sdk.model.vast.g r0 = (com.fyber.inneractive.sdk.model.vast.g) r0
            r0.getClass()
            org.json.JSONObject r14 = new org.json.JSONObject
            r14.<init>()
            java.lang.String r15 = "w"
            java.lang.Integer r8 = r0.a     // Catch:{ JSONException -> 0x01d0 }
            r14.put(r15, r8)     // Catch:{ JSONException -> 0x01d0 }
            java.lang.String r8 = "h"
            java.lang.Integer r15 = r0.b     // Catch:{ JSONException -> 0x01d0 }
            r14.put(r8, r15)     // Catch:{ JSONException -> 0x01d0 }
            java.lang.String r8 = "ctr"
            java.lang.String r15 = r0.g     // Catch:{ JSONException -> 0x01d0 }
            r14.put(r8, r15)     // Catch:{ JSONException -> 0x01d0 }
            java.lang.String r8 = "clt"
            java.util.List<java.lang.String> r15 = r0.h     // Catch:{ JSONException -> 0x01d0 }
            r14.put(r8, r15)     // Catch:{ JSONException -> 0x01d0 }
            java.lang.String r8 = r0.f     // Catch:{ JSONException -> 0x01d0 }
            java.lang.String r15 = "content"
            if (r8 == 0) goto L_0x019b
            r14.put(r15, r8)     // Catch:{ JSONException -> 0x01d0 }
            java.lang.String r8 = "HTMLResource"
            goto L_0x019c
        L_0x019b:
            r8 = 0
        L_0x019c:
            com.fyber.inneractive.sdk.model.vast.j r6 = r0.d     // Catch:{ JSONException -> 0x01d0 }
            if (r6 == 0) goto L_0x01b0
            java.lang.String r6 = r6.b     // Catch:{ JSONException -> 0x01d0 }
            r14.put(r15, r6)     // Catch:{ JSONException -> 0x01d0 }
            java.lang.String r6 = "creativeType"
            com.fyber.inneractive.sdk.model.vast.j r8 = r0.d     // Catch:{ JSONException -> 0x01d0 }
            java.lang.String r8 = r8.a     // Catch:{ JSONException -> 0x01d0 }
            r14.put(r6, r8)     // Catch:{ JSONException -> 0x01d0 }
            java.lang.String r8 = "StaticResource"
        L_0x01b0:
            java.lang.String r6 = r0.e     // Catch:{ JSONException -> 0x01d0 }
            boolean r6 = android.text.TextUtils.isEmpty(r6)     // Catch:{ JSONException -> 0x01d0 }
            if (r6 != 0) goto L_0x01bf
            java.lang.String r6 = r0.e     // Catch:{ JSONException -> 0x01d0 }
            r14.put(r15, r6)     // Catch:{ JSONException -> 0x01d0 }
            java.lang.String r8 = "iFrameResource"
        L_0x01bf:
            if (r8 == 0) goto L_0x01c6
            java.lang.String r6 = "type"
            r14.put(r6, r8)     // Catch:{ JSONException -> 0x01d0 }
        L_0x01c6:
            com.fyber.inneractive.sdk.flow.vast.d$a r0 = r0.i     // Catch:{ JSONException -> 0x01d0 }
            if (r0 == 0) goto L_0x01e0
            int r0 = r0.a     // Catch:{ JSONException -> 0x01d0 }
            r14.put(r5, r0)     // Catch:{ JSONException -> 0x01d0 }
            goto L_0x01e0
        L_0x01d0:
            r0 = move-exception
            java.lang.Object[] r6 = new java.lang.Object[r9]
            java.lang.String r0 = r0.getMessage()
            r8 = 0
            r6[r8] = r0
            java.lang.String r0 = "Failed creating Companion json object: %s"
            com.fyber.inneractive.sdk.util.IAlog.a(r0, r6)
            r14 = 0
        L_0x01e0:
            r12.put(r14)
            r6 = 0
            goto L_0x015f
        L_0x01e6:
            java.lang.String r0 = "companion_data"
            r11.put(r0, r12)     // Catch:{ Exception -> 0x01ec }
            goto L_0x01f7
        L_0x01ec:
            r5 = 2
            java.lang.Object[] r6 = new java.lang.Object[r5]
            r5 = 0
            r6[r5] = r0
            r6[r9] = r12
            com.fyber.inneractive.sdk.util.IAlog.e(r7, r6)
        L_0x01f7:
            org.json.JSONArray r0 = r10.f
            r0.put(r11)
            r5 = 0
            r10.a((java.lang.String) r5)
        L_0x0200:
            com.fyber.inneractive.sdk.model.vast.b r0 = r1.K
            if (r0 == 0) goto L_0x020b
            java.util.PriorityQueue<com.fyber.inneractive.sdk.model.vast.c> r0 = r0.g
            int r0 = r0.size()
            goto L_0x020c
        L_0x020b:
            r0 = 0
        L_0x020c:
            java.util.List<com.fyber.inneractive.sdk.model.vast.g> r5 = r1.M
            if (r5 == 0) goto L_0x0215
            int r5 = r5.size()
            goto L_0x0216
        L_0x0215:
            r5 = 0
        L_0x0216:
            com.fyber.inneractive.sdk.network.s$a r6 = new com.fyber.inneractive.sdk.network.s$a
            com.fyber.inneractive.sdk.network.r r8 = com.fyber.inneractive.sdk.network.r.NUMBER_OF_COMPANIONS
            if (r19 != 0) goto L_0x021e
            r10 = 0
            goto L_0x0222
        L_0x021e:
            org.json.JSONArray r10 = r19.c()
        L_0x0222:
            r6.<init>((com.fyber.inneractive.sdk.network.r) r8, (com.fyber.inneractive.sdk.external.InneractiveAdRequest) r2, (com.fyber.inneractive.sdk.response.e) r1, (org.json.JSONArray) r10)
            org.json.JSONObject r8 = new org.json.JSONObject
            r8.<init>()
            java.lang.String r10 = "number_of_endcards"
            int r0 = r0 + r5
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)
            r8.put(r10, r0)     // Catch:{ Exception -> 0x0235 }
            goto L_0x0240
        L_0x0235:
            r5 = 2
            java.lang.Object[] r11 = new java.lang.Object[r5]
            r5 = 0
            r11[r5] = r10
            r11[r9] = r0
            com.fyber.inneractive.sdk.util.IAlog.e(r7, r11)
        L_0x0240:
            org.json.JSONArray r0 = r6.f
            r0.put(r8)
            r5 = 0
            r6.a((java.lang.String) r5)
            com.fyber.inneractive.sdk.model.vast.b r0 = r1.K
            if (r0 == 0) goto L_0x02c8
            com.fyber.inneractive.sdk.flow.vast.j r0 = new com.fyber.inneractive.sdk.flow.vast.j
            r0.<init>(r3, r1)
            int r3 = r0.size()
            if (r3 <= 0) goto L_0x02c8
            org.json.JSONObject r3 = new org.json.JSONObject
            r3.<init>()
            org.json.JSONArray r5 = new org.json.JSONArray
            r5.<init>()
            com.fyber.inneractive.sdk.network.s$a r6 = new com.fyber.inneractive.sdk.network.s$a
            com.fyber.inneractive.sdk.network.r r8 = com.fyber.inneractive.sdk.network.r.OMID_VAST_DETECTION
            if (r19 != 0) goto L_0x026a
            r10 = 0
            goto L_0x026e
        L_0x026a:
            org.json.JSONArray r10 = r19.c()
        L_0x026e:
            r6.<init>((com.fyber.inneractive.sdk.network.r) r8, (com.fyber.inneractive.sdk.external.InneractiveAdRequest) r2, (com.fyber.inneractive.sdk.response.e) r1, (org.json.JSONArray) r10)
            java.util.Iterator r0 = r0.iterator()
        L_0x0275:
            boolean r2 = r0.hasNext()
            if (r2 == 0) goto L_0x02ae
            java.lang.Object r2 = r0.next()
            com.fyber.inneractive.sdk.measurement.f r2 = (com.fyber.inneractive.sdk.measurement.f) r2
            r2.getClass()
            org.json.JSONObject r8 = new org.json.JSONObject
            r8.<init>()
            java.lang.String r10 = "success"
            boolean r11 = r2.b()     // Catch:{ JSONException -> 0x02a6 }
            java.lang.String r11 = java.lang.String.valueOf(r11)     // Catch:{ JSONException -> 0x02a6 }
            r8.put(r10, r11)     // Catch:{ JSONException -> 0x02a6 }
            boolean r10 = r2.b()     // Catch:{ JSONException -> 0x02a6 }
            if (r10 != 0) goto L_0x02a8
            java.lang.String r10 = "error_reason"
            java.lang.String r2 = r2.a()     // Catch:{ JSONException -> 0x02a6 }
            r8.put(r10, r2)     // Catch:{ JSONException -> 0x02a6 }
            goto L_0x02a8
        L_0x02a6:
            r8 = 0
        L_0x02a8:
            if (r8 == 0) goto L_0x0275
            r5.put(r8)
            goto L_0x0275
        L_0x02ae:
            java.lang.String r0 = "verifications"
            r3.put(r0, r5)     // Catch:{ Exception -> 0x02b4 }
            goto L_0x02bf
        L_0x02b4:
            r2 = 2
            java.lang.Object[] r2 = new java.lang.Object[r2]
            r8 = 0
            r2[r8] = r0
            r2[r9] = r5
            com.fyber.inneractive.sdk.util.IAlog.e(r7, r2)
        L_0x02bf:
            org.json.JSONArray r0 = r6.f
            r0.put(r3)
            r2 = 0
            r6.a((java.lang.String) r2)
        L_0x02c8:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fyber.inneractive.sdk.response.g.a(com.fyber.inneractive.sdk.external.InneractiveAdRequest, com.fyber.inneractive.sdk.config.global.s):com.fyber.inneractive.sdk.external.InneractiveErrorCode");
    }
}
