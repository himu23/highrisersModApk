package com.ironsource.sdk.controller;

import android.content.Context;
import com.ironsource.m9;
import org.json.JSONException;
import org.json.JSONObject;

public class o {
    private static final String c = "o";
    private static final String d = "activate";
    private static final String e = "startSession";
    private static final String f = "finishSession";
    private static final String g = "impressionOccurred";
    private static final String h = "getOmidData";
    private static final String i = "omidFunction";
    private static final String j = "omidParams";
    private static final String k = "success";
    private static final String l = "fail";
    private static final String m = "%s | unsupported OMID API";
    private final Context a;
    private final m9 b = new m9();

    private static class b {
        String a;
        JSONObject b;
        String c;
        String d;

        private b() {
        }
    }

    public o(Context context) {
        this.a = context;
    }

    private b a(String str) throws JSONException {
        JSONObject jSONObject = new JSONObject(str);
        b bVar = new b();
        bVar.a = jSONObject.optString(i);
        bVar.b = jSONObject.optJSONObject(j);
        bVar.c = jSONObject.optString("success");
        bVar.d = jSONObject.optString("fail");
        return bVar;
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void a(java.lang.String r9, com.ironsource.sdk.controller.u.v.e0 r10) throws java.lang.Exception {
        /*
            r8 = this;
            com.ironsource.sdk.controller.o$b r9 = r8.a(r9)
            com.ironsource.ab r0 = new com.ironsource.ab
            r0.<init>()
            org.json.JSONObject r1 = r9.b
            if (r1 == 0) goto L_0x001e
            java.lang.String r2 = ""
            java.lang.String r3 = "adViewId"
            java.lang.String r1 = r1.optString(r3, r2)
            boolean r2 = android.text.TextUtils.isEmpty(r1)
            if (r2 != 0) goto L_0x001e
            r0.b(r3, r1)
        L_0x001e:
            r1 = 0
            java.lang.String r2 = r9.a     // Catch:{ Exception -> 0x00a9 }
            int r3 = r2.hashCode()     // Catch:{ Exception -> 0x00a9 }
            r4 = 4
            r5 = 3
            r6 = 2
            r7 = 1
            switch(r3) {
                case -1655974669: goto L_0x0055;
                case -984459207: goto L_0x004b;
                case 70701699: goto L_0x0041;
                case 1208109646: goto L_0x0037;
                case 1850541012: goto L_0x002d;
                default: goto L_0x002c;
            }     // Catch:{ Exception -> 0x00a9 }
        L_0x002c:
            goto L_0x005f
        L_0x002d:
            java.lang.String r3 = "startSession"
            boolean r2 = r2.equals(r3)     // Catch:{ Exception -> 0x00a9 }
            if (r2 == 0) goto L_0x005f
            r2 = 1
            goto L_0x0060
        L_0x0037:
            java.lang.String r3 = "impressionOccurred"
            boolean r2 = r2.equals(r3)     // Catch:{ Exception -> 0x00a9 }
            if (r2 == 0) goto L_0x005f
            r2 = 3
            goto L_0x0060
        L_0x0041:
            java.lang.String r3 = "finishSession"
            boolean r2 = r2.equals(r3)     // Catch:{ Exception -> 0x00a9 }
            if (r2 == 0) goto L_0x005f
            r2 = 2
            goto L_0x0060
        L_0x004b:
            java.lang.String r3 = "getOmidData"
            boolean r2 = r2.equals(r3)     // Catch:{ Exception -> 0x00a9 }
            if (r2 == 0) goto L_0x005f
            r2 = 4
            goto L_0x0060
        L_0x0055:
            java.lang.String r3 = "activate"
            boolean r2 = r2.equals(r3)     // Catch:{ Exception -> 0x00a9 }
            if (r2 == 0) goto L_0x005f
            r2 = 0
            goto L_0x0060
        L_0x005f:
            r2 = -1
        L_0x0060:
            if (r2 == 0) goto L_0x0097
            if (r2 == r7) goto L_0x008f
            if (r2 == r6) goto L_0x0087
            if (r2 == r5) goto L_0x007f
            if (r2 != r4) goto L_0x006d
        L_0x006a:
            com.ironsource.m9 r2 = r8.b     // Catch:{ Exception -> 0x00a9 }
            goto L_0x009f
        L_0x006d:
            java.lang.IllegalArgumentException r2 = new java.lang.IllegalArgumentException     // Catch:{ Exception -> 0x00a9 }
            java.lang.String r3 = "%s | unsupported OMID API"
            java.lang.Object[] r4 = new java.lang.Object[r7]     // Catch:{ Exception -> 0x00a9 }
            java.lang.String r5 = r9.a     // Catch:{ Exception -> 0x00a9 }
            r4[r1] = r5     // Catch:{ Exception -> 0x00a9 }
            java.lang.String r3 = java.lang.String.format(r3, r4)     // Catch:{ Exception -> 0x00a9 }
            r2.<init>(r3)     // Catch:{ Exception -> 0x00a9 }
            throw r2     // Catch:{ Exception -> 0x00a9 }
        L_0x007f:
            com.ironsource.m9 r2 = r8.b     // Catch:{ Exception -> 0x00a9 }
            org.json.JSONObject r3 = r9.b     // Catch:{ Exception -> 0x00a9 }
            r2.c(r3)     // Catch:{ Exception -> 0x00a9 }
            goto L_0x00a3
        L_0x0087:
            com.ironsource.m9 r2 = r8.b     // Catch:{ Exception -> 0x00a9 }
            org.json.JSONObject r3 = r9.b     // Catch:{ Exception -> 0x00a9 }
            r2.b(r3)     // Catch:{ Exception -> 0x00a9 }
            goto L_0x00a3
        L_0x008f:
            com.ironsource.m9 r2 = r8.b     // Catch:{ Exception -> 0x00a9 }
            org.json.JSONObject r3 = r9.b     // Catch:{ Exception -> 0x00a9 }
            r2.d(r3)     // Catch:{ Exception -> 0x00a9 }
            goto L_0x00a3
        L_0x0097:
            com.ironsource.m9 r2 = r8.b     // Catch:{ Exception -> 0x00a9 }
            android.content.Context r3 = r8.a     // Catch:{ Exception -> 0x00a9 }
            r2.a((android.content.Context) r3)     // Catch:{ Exception -> 0x00a9 }
            goto L_0x006a
        L_0x009f:
            com.ironsource.ab r0 = r2.a()     // Catch:{ Exception -> 0x00a9 }
        L_0x00a3:
            java.lang.String r2 = r9.c     // Catch:{ Exception -> 0x00a9 }
            r10.a((boolean) r7, (java.lang.String) r2, (com.ironsource.ab) r0)     // Catch:{ Exception -> 0x00a9 }
            goto L_0x00d9
        L_0x00a9:
            r2 = move-exception
            java.lang.String r3 = r2.getMessage()
            java.lang.String r4 = "errMsg"
            r0.b(r4, r3)
            java.lang.String r3 = c
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            java.lang.String r5 = "OMIDJSAdapter "
            r4.<init>(r5)
            java.lang.String r5 = r9.a
            r4.append(r5)
            java.lang.String r5 = " Exception: "
            r4.append(r5)
            java.lang.String r2 = r2.getMessage()
            r4.append(r2)
            java.lang.String r2 = r4.toString()
            com.ironsource.sdk.utils.Logger.i(r3, r2)
            java.lang.String r9 = r9.d
            r10.a((boolean) r1, (java.lang.String) r9, (com.ironsource.ab) r0)
        L_0x00d9:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ironsource.sdk.controller.o.a(java.lang.String, com.ironsource.sdk.controller.u$v$e0):void");
    }
}
