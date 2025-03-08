package com.applovin.impl.sdk.utils;

import android.text.TextUtils;
import com.applovin.impl.sdk.c.b;
import com.applovin.impl.sdk.c.d;
import com.applovin.impl.sdk.c.e;
import com.applovin.impl.sdk.n;
import com.applovin.impl.sdk.x;

public final class t {
    private final String aWl = a(d.aRn, (String) e.b(d.aRm, null, n.getApplicationContext()));
    private final String aWm;
    private String awc;
    private final n sdk;

    public String BA() {
        return this.aWl;
    }

    public String Bz() {
        return this.awc;
    }

    public String Lv() {
        return this.aWm;
    }

    public t(n nVar) {
        this.sdk = nVar;
        this.aWm = a(d.aRo, (String) nVar.a(b.aKl));
        cA(Lu());
    }

    private String Lu() {
        if (!((Boolean) this.sdk.a(b.aOC)).booleanValue()) {
            this.sdk.b(d.aRl);
        }
        String str = (String) this.sdk.a(d.aRl);
        if (!StringUtils.isValidString(str)) {
            return null;
        }
        this.sdk.BN();
        if (x.Fn()) {
            x BN = this.sdk.BN();
            BN.f("AppLovinSdk", "Using identifier (" + str + ") from previous session");
        }
        return str;
    }

    /* JADX WARNING: type inference failed for: r3v0, types: [com.applovin.impl.sdk.c.d, com.applovin.impl.sdk.c.d<java.lang.String>] */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private java.lang.String a(com.applovin.impl.sdk.c.d<java.lang.String> r3, java.lang.String r4) {
        /*
            r2 = this;
            r0 = 0
            android.content.Context r1 = com.applovin.impl.sdk.n.getApplicationContext()
            java.lang.Object r0 = com.applovin.impl.sdk.c.e.b(r3, r0, (android.content.Context) r1)
            java.lang.String r0 = (java.lang.String) r0
            boolean r1 = com.applovin.impl.sdk.utils.StringUtils.isValidString(r0)
            if (r1 == 0) goto L_0x0012
            return r0
        L_0x0012:
            boolean r0 = com.applovin.impl.sdk.utils.StringUtils.isValidString(r4)
            if (r0 == 0) goto L_0x0019
            goto L_0x0027
        L_0x0019:
            java.util.UUID r4 = java.util.UUID.randomUUID()
            java.lang.String r4 = r4.toString()
            java.util.Locale r0 = java.util.Locale.US
            java.lang.String r4 = r4.toLowerCase(r0)
        L_0x0027:
            android.content.Context r0 = com.applovin.impl.sdk.n.getApplicationContext()
            com.applovin.impl.sdk.c.e.a(r3, r4, (android.content.Context) r0)
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.applovin.impl.sdk.utils.t.a(com.applovin.impl.sdk.c.d, java.lang.String):java.lang.String");
    }

    public void cA(String str) {
        if (((Boolean) this.sdk.a(b.aOC)).booleanValue()) {
            this.sdk.a(d.aRl, str);
        }
        this.awc = str;
        this.sdk.Ch().z(str, Lv());
    }

    public static String M(n nVar) {
        String str = (String) nVar.a(d.aRp);
        if (!TextUtils.isEmpty(str)) {
            return str;
        }
        String valueOf = String.valueOf(((int) (Math.random() * 100.0d)) + 1);
        nVar.a(d.aRp, valueOf);
        return valueOf;
    }
}
