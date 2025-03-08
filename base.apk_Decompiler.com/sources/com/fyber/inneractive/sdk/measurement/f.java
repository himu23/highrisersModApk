package com.fyber.inneractive.sdk.measurement;

import android.text.TextUtils;
import com.fyber.inneractive.sdk.model.vast.t;
import com.fyber.inneractive.sdk.response.i;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class f implements i {
    public URL a;
    public String b;
    public Map<t, List<String>> c = new HashMap();
    public String d;
    public String e;
    public String f;
    public boolean g = false;

    public void a(t tVar, String str) {
        List list = this.c.get(tVar);
        if (list == null) {
            list = new ArrayList();
            this.c.put(tVar, list);
        }
        if (!TextUtils.isEmpty(str)) {
            list.add(str);
        }
    }

    public String toString() {
        return "Verification{mJavaScriptResource=" + this.a + ", mTrackingEvents=" + this.c + ", mVerificationParameters='" + this.d + "', mVendor='" + this.e + "'}";
    }

    /* JADX WARNING: Code restructure failed: missing block: B:4:0x0008, code lost:
        r0 = r2.b;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean b() {
        /*
            r2 = this;
            boolean r0 = r2.g
            if (r0 == 0) goto L_0x001e
            java.net.URL r0 = r2.a
            if (r0 == 0) goto L_0x001e
            java.lang.String r0 = r2.b
            if (r0 == 0) goto L_0x001c
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            if (r0 != 0) goto L_0x001e
            java.lang.String r0 = r2.b
            java.lang.String r1 = "omid"
            boolean r0 = r0.equalsIgnoreCase(r1)
            if (r0 == 0) goto L_0x001e
        L_0x001c:
            r0 = 1
            goto L_0x001f
        L_0x001e:
            r0 = 0
        L_0x001f:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fyber.inneractive.sdk.measurement.f.b():boolean");
    }

    public List<String> a(t tVar) {
        Map<t, List<String>> map;
        if (tVar == null || (map = this.c) == null) {
            return null;
        }
        return map.get(tVar);
    }

    public String a() {
        if (!this.g) {
            return "JavaScriptResource = ";
        }
        if (TextUtils.isEmpty(this.b)) {
            return "apiFramework = ";
        }
        if (!this.b.equalsIgnoreCase("omid")) {
            return String.format("apiFramework = %s", new Object[]{this.b});
        }
        Object[] objArr = new Object[1];
        objArr[0] = TextUtils.isEmpty(this.f) ? "" : this.f;
        return String.format("JavaScriptResource_url = %s", objArr);
    }
}
