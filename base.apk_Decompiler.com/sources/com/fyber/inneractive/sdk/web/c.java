package com.fyber.inneractive.sdk.web;

import android.text.TextUtils;
import android.webkit.WebView;
import com.fyber.inneractive.sdk.config.global.s;
import com.fyber.inneractive.sdk.external.InneractiveErrorCode;
import com.fyber.inneractive.sdk.external.InneractiveInfrastructureError;
import com.fyber.inneractive.sdk.flow.g;
import com.fyber.inneractive.sdk.measurement.a;
import com.fyber.inneractive.sdk.model.vast.l;
import com.fyber.inneractive.sdk.util.e0;
import com.fyber.inneractive.sdk.util.m0;
import com.fyber.inneractive.sdk.web.b0;
import com.fyber.inneractive.sdk.web.d;
import com.fyber.inneractive.sdk.web.i;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

public class c<T extends b0> extends a0<T> {
    public final b O;

    public c(b bVar, boolean z, boolean z2) {
        super(z, z2, i.C0139i.INTERSTITIAL, (s) null);
        this.O = bVar;
    }

    public void a() {
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x0065, code lost:
        if (r6.equals("success") == false) goto L_0x0047;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean a(java.lang.String r10, com.fyber.inneractive.sdk.util.p0 r11) {
        /*
            r9 = this;
            r0 = 0
            if (r10 == 0) goto L_0x00b4
            java.lang.String r1 = r10.toLowerCase()
            java.lang.String r2 = "fmpendcard://"
            java.lang.String r2 = r2.toLowerCase()
            boolean r1 = r1.startsWith(r2)
            if (r1 == 0) goto L_0x00b4
            com.fyber.inneractive.sdk.web.b r1 = r9.O
            r2 = 1
            if (r1 == 0) goto L_0x00b3
            com.fyber.inneractive.sdk.web.d$d r3 = r9.f
            L r4 = r9.g
            r1.getClass()
            android.net.Uri r10 = android.net.Uri.parse(r10)
            r5 = 0
            if (r10 == 0) goto L_0x002b
            java.lang.String r6 = r10.getAuthority()
            goto L_0x002c
        L_0x002b:
            r6 = r5
        L_0x002c:
            boolean r7 = android.text.TextUtils.isEmpty(r6)
            if (r7 == 0) goto L_0x0039
            java.lang.String r10 = "empty type"
            r1.a(r3, r9, r10)
            goto L_0x00b3
        L_0x0039:
            r6.getClass()
            r6.hashCode()
            int r7 = r6.hashCode()
            r8 = -1
            switch(r7) {
                case -1867169789: goto L_0x005f;
                case -1086574198: goto L_0x0054;
                case 94750088: goto L_0x0049;
                default: goto L_0x0047;
            }
        L_0x0047:
            r0 = -1
            goto L_0x0068
        L_0x0049:
            java.lang.String r0 = "click"
            boolean r0 = r6.equals(r0)
            if (r0 != 0) goto L_0x0052
            goto L_0x0047
        L_0x0052:
            r0 = 2
            goto L_0x0068
        L_0x0054:
            java.lang.String r0 = "failure"
            boolean r0 = r6.equals(r0)
            if (r0 != 0) goto L_0x005d
            goto L_0x0047
        L_0x005d:
            r0 = 1
            goto L_0x0068
        L_0x005f:
            java.lang.String r7 = "success"
            boolean r6 = r6.equals(r7)
            if (r6 != 0) goto L_0x0068
            goto L_0x0047
        L_0x0068:
            java.lang.String r6 = "version"
            switch(r0) {
                case 0: goto L_0x00a4;
                case 1: goto L_0x008e;
                case 2: goto L_0x006e;
                default: goto L_0x006d;
            }
        L_0x006d:
            goto L_0x00b3
        L_0x006e:
            if (r4 == 0) goto L_0x00b3
            com.fyber.inneractive.sdk.flow.vast.e r10 = r1.c
            if (r10 == 0) goto L_0x00b3
            com.fyber.inneractive.sdk.web.b$a r0 = new com.fyber.inneractive.sdk.web.b$a
            java.lang.String r3 = r1.b
            int r10 = r10.d
            r0.<init>(r3, r10)
            com.fyber.inneractive.sdk.model.vast.b r10 = r1.a
            com.fyber.inneractive.sdk.model.vast.c r1 = r10.h
            if (r1 == 0) goto L_0x0085
            java.lang.String r5 = r1.g
        L_0x0085:
            if (r5 == 0) goto L_0x0088
            goto L_0x008a
        L_0x0088:
            java.lang.String r5 = r10.b
        L_0x008a:
            r4.a(r5, r11, r0)
            goto L_0x00b3
        L_0x008e:
            java.lang.String r11 = r10.getQueryParameter(r6)
            boolean r0 = android.text.TextUtils.isEmpty(r11)
            if (r0 != 0) goto L_0x009a
            r1.b = r11
        L_0x009a:
            java.lang.String r11 = "error"
            java.lang.String r10 = r10.getQueryParameter(r11)
            r1.a(r3, r9, r10)
            goto L_0x00b3
        L_0x00a4:
            java.lang.String r10 = r10.getQueryParameter(r6)
            boolean r11 = android.text.TextUtils.isEmpty(r10)
            if (r11 != 0) goto L_0x00b0
            r1.b = r10
        L_0x00b0:
            r9.g()
        L_0x00b3:
            return r2
        L_0x00b4:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fyber.inneractive.sdk.web.c.a(java.lang.String, com.fyber.inneractive.sdk.util.p0):boolean");
    }

    public void b() {
    }

    public a.C0101a d() {
        return null;
    }

    public void a(WebView webView) {
        JSONObject jSONObject;
        if (webView != null && this.O != null) {
            webView.setLongClickable(false);
            webView.setOnLongClickListener(new e0());
            b bVar = this.O;
            l lVar = bVar.a.f;
            if (lVar != null) {
                try {
                    jSONObject = new JSONObject();
                    m0.a(jSONObject, "name", lVar.a);
                    m0.a(jSONObject, "description", lVar.b);
                    JSONArray jSONArray = new JSONArray();
                    String str = lVar.d;
                    if (!TextUtils.isEmpty(str)) {
                        jSONArray.put(str);
                    }
                    m0.a(jSONObject, "icons", jSONArray);
                    m0.a(jSONObject, "rating", Float.valueOf(lVar.e));
                    JSONArray jSONArray2 = new JSONArray();
                    List<String> list = lVar.f;
                    if (list != null) {
                        for (String put : list) {
                            jSONArray2.put(put);
                        }
                    }
                    m0.a(jSONObject, "screenshots", jSONArray2);
                } catch (Exception unused) {
                }
                webView.evaluateJavascript(String.format("loadAssets(%s);", new Object[]{jSONObject}), new a(bVar));
            }
            jSONObject = null;
            webView.evaluateJavascript(String.format("loadAssets(%s);", new Object[]{jSONObject}), new a(bVar));
        }
    }

    public void a(int i) {
        d.C0138d dVar;
        if (this.O != null && (dVar = this.f) != null) {
            dVar.a(this, new InneractiveInfrastructureError(InneractiveErrorCode.SDK_INTERNAL_ERROR, g.WEBVIEW_FMP_ENDCARD_ERROR));
        }
    }
}
