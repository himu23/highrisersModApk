package com.ironsource.sdk.controller;

import android.content.Context;
import android.text.TextUtils;
import com.ironsource.d6;
import com.ironsource.gd;
import com.ironsource.y5;
import com.ironsource.yc;
import org.json.JSONException;
import org.json.JSONObject;

public class a implements y5 {
    private static final String d = "loadWithUrl";
    private static final String e = "sendMessage";
    public static final String f = "removeAdView";
    public static final String g = "webviewAction";
    public static final String h = "handleGetViewVisibility";
    private static final String i = "functionName";
    private static final String j = "functionParams";
    private static final String k = "success";
    private static final String l = "fail";
    public static final String m = "errMsg";
    private static final String n = "%s | unsupported AdViews API";
    private gd a;
    private d6 b = d6.a();
    private Context c;

    private static class b {
        String a;
        JSONObject b;
        String c;
        String d;

        private b() {
        }
    }

    public a(Context context) {
        this.c = context;
    }

    private b a(String str) throws JSONException {
        JSONObject jSONObject = new JSONObject(str);
        b bVar = new b();
        bVar.a = jSONObject.optString("functionName");
        bVar.b = jSONObject.optJSONObject("functionParams");
        bVar.c = jSONObject.optString("success");
        bVar.d = jSONObject.optString("fail");
        return bVar;
    }

    public void a(gd gdVar) {
        this.a = gdVar;
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void a(java.lang.String r10, com.ironsource.sdk.controller.u.v.e0 r11) throws java.lang.Exception {
        /*
            r9 = this;
            com.ironsource.sdk.controller.a$b r10 = r9.a((java.lang.String) r10)
            com.ironsource.ab r0 = new com.ironsource.ab
            r0.<init>()
            r1 = 0
            java.lang.String r2 = r10.a     // Catch:{ Exception -> 0x00a6 }
            int r3 = r2.hashCode()     // Catch:{ Exception -> 0x00a6 }
            r4 = 4
            r5 = 3
            r6 = 2
            r7 = 1
            switch(r3) {
                case -1384357108: goto L_0x0040;
                case 691453791: goto L_0x0036;
                case 842351363: goto L_0x002c;
                case 1182065477: goto L_0x0022;
                case 1491535759: goto L_0x0018;
                default: goto L_0x0017;
            }     // Catch:{ Exception -> 0x00a6 }
        L_0x0017:
            goto L_0x004a
        L_0x0018:
            java.lang.String r3 = "webviewAction"
            boolean r2 = r2.equals(r3)     // Catch:{ Exception -> 0x00a6 }
            if (r2 == 0) goto L_0x004a
            r2 = 4
            goto L_0x004b
        L_0x0022:
            java.lang.String r3 = "handleGetViewVisibility"
            boolean r2 = r2.equals(r3)     // Catch:{ Exception -> 0x00a6 }
            if (r2 == 0) goto L_0x004a
            r2 = 3
            goto L_0x004b
        L_0x002c:
            java.lang.String r3 = "loadWithUrl"
            boolean r2 = r2.equals(r3)     // Catch:{ Exception -> 0x00a6 }
            if (r2 == 0) goto L_0x004a
            r2 = 0
            goto L_0x004b
        L_0x0036:
            java.lang.String r3 = "sendMessage"
            boolean r2 = r2.equals(r3)     // Catch:{ Exception -> 0x00a6 }
            if (r2 == 0) goto L_0x004a
            r2 = 1
            goto L_0x004b
        L_0x0040:
            java.lang.String r3 = "removeAdView"
            boolean r2 = r2.equals(r3)     // Catch:{ Exception -> 0x00a6 }
            if (r2 == 0) goto L_0x004a
            r2 = 2
            goto L_0x004b
        L_0x004a:
            r2 = -1
        L_0x004b:
            if (r2 == 0) goto L_0x0097
            if (r2 == r7) goto L_0x008b
            if (r2 == r6) goto L_0x007f
            if (r2 == r5) goto L_0x0073
            if (r2 != r4) goto L_0x0061
            com.ironsource.d6 r2 = r9.b     // Catch:{ Exception -> 0x00a6 }
            org.json.JSONObject r3 = r10.b     // Catch:{ Exception -> 0x00a6 }
            java.lang.String r4 = r10.c     // Catch:{ Exception -> 0x00a6 }
            java.lang.String r5 = r10.d     // Catch:{ Exception -> 0x00a6 }
            r2.b(r3, r4, r5)     // Catch:{ Exception -> 0x00a6 }
            goto L_0x00c8
        L_0x0061:
            java.lang.IllegalArgumentException r2 = new java.lang.IllegalArgumentException     // Catch:{ Exception -> 0x00a6 }
            java.lang.String r3 = "%s | unsupported AdViews API"
            java.lang.Object[] r4 = new java.lang.Object[r7]     // Catch:{ Exception -> 0x00a6 }
            java.lang.String r5 = r10.a     // Catch:{ Exception -> 0x00a6 }
            r4[r1] = r5     // Catch:{ Exception -> 0x00a6 }
            java.lang.String r3 = java.lang.String.format(r3, r4)     // Catch:{ Exception -> 0x00a6 }
            r2.<init>(r3)     // Catch:{ Exception -> 0x00a6 }
            throw r2     // Catch:{ Exception -> 0x00a6 }
        L_0x0073:
            com.ironsource.d6 r2 = r9.b     // Catch:{ Exception -> 0x00a6 }
            org.json.JSONObject r3 = r10.b     // Catch:{ Exception -> 0x00a6 }
            java.lang.String r4 = r10.c     // Catch:{ Exception -> 0x00a6 }
            java.lang.String r5 = r10.d     // Catch:{ Exception -> 0x00a6 }
            r2.a(r3, r4, r5)     // Catch:{ Exception -> 0x00a6 }
            goto L_0x00c8
        L_0x007f:
            com.ironsource.d6 r2 = r9.b     // Catch:{ Exception -> 0x00a6 }
            org.json.JSONObject r3 = r10.b     // Catch:{ Exception -> 0x00a6 }
            java.lang.String r4 = r10.c     // Catch:{ Exception -> 0x00a6 }
            java.lang.String r5 = r10.d     // Catch:{ Exception -> 0x00a6 }
            r2.c(r3, r4, r5)     // Catch:{ Exception -> 0x00a6 }
            goto L_0x00c8
        L_0x008b:
            com.ironsource.d6 r2 = r9.b     // Catch:{ Exception -> 0x00a6 }
            org.json.JSONObject r3 = r10.b     // Catch:{ Exception -> 0x00a6 }
            java.lang.String r4 = r10.c     // Catch:{ Exception -> 0x00a6 }
            java.lang.String r5 = r10.d     // Catch:{ Exception -> 0x00a6 }
            r2.d(r3, r4, r5)     // Catch:{ Exception -> 0x00a6 }
            goto L_0x00c8
        L_0x0097:
            com.ironsource.d6 r3 = r9.b     // Catch:{ Exception -> 0x00a6 }
            org.json.JSONObject r5 = r10.b     // Catch:{ Exception -> 0x00a6 }
            android.content.Context r6 = r9.c     // Catch:{ Exception -> 0x00a6 }
            java.lang.String r7 = r10.c     // Catch:{ Exception -> 0x00a6 }
            java.lang.String r8 = r10.d     // Catch:{ Exception -> 0x00a6 }
            r4 = r9
            r3.a(r4, r5, r6, r7, r8)     // Catch:{ Exception -> 0x00a6 }
            goto L_0x00c8
        L_0x00a6:
            r2 = move-exception
            java.lang.String r2 = r2.getMessage()
            java.lang.String r3 = "errMsg"
            r0.b(r3, r2)
            com.ironsource.d6 r2 = r9.b
            org.json.JSONObject r3 = r10.b
            java.lang.String r2 = r2.c(r3)
            boolean r3 = android.text.TextUtils.isEmpty(r2)
            if (r3 != 0) goto L_0x00c3
            java.lang.String r3 = "adViewId"
            r0.b(r3, r2)
        L_0x00c3:
            java.lang.String r10 = r10.d
            r11.a((boolean) r1, (java.lang.String) r10, (com.ironsource.ab) r0)
        L_0x00c8:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ironsource.sdk.controller.a.a(java.lang.String, com.ironsource.sdk.controller.u$v$e0):void");
    }

    public void a(String str, String str2, String str3) {
        a(str, yc.a(str2, str3));
    }

    public void a(String str, JSONObject jSONObject) {
        if (this.a != null && !TextUtils.isEmpty(str)) {
            this.a.a(str, jSONObject);
        }
    }
}
