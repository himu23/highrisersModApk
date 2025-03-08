package com.fyber.inneractive.sdk.network;

import com.fyber.inneractive.sdk.config.global.s;

public class m0 extends f0<String> {
    public final String r;

    public m0(w<String> wVar, String str, s sVar) {
        super(wVar, x.a().b(), (s) null);
        this.r = str;
    }

    public String a() {
        return this.r;
    }

    public p0 i() {
        return p0.LOW;
    }

    public boolean o() {
        return false;
    }

    public z r() {
        return z.GET;
    }

    public int v() {
        return 0;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v5, resolved type: java.lang.String} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.fyber.inneractive.sdk.network.b0 a(com.fyber.inneractive.sdk.network.j r4, java.util.Map<java.lang.String, java.util.List<java.lang.String>> r5, int r6) throws java.lang.Exception {
        /*
            r3 = this;
            com.fyber.inneractive.sdk.network.b0 r6 = new com.fyber.inneractive.sdk.network.b0
            r6.<init>()
            r0 = 0
            java.io.InputStream r4 = r4.c     // Catch:{ Exception -> 0x003c }
            r1 = 0
            if (r5 == 0) goto L_0x0014
            java.lang.String r2 = "Content-Type"
            java.lang.Object r5 = r5.get(r2)     // Catch:{ Exception -> 0x003c }
            java.util.List r5 = (java.util.List) r5     // Catch:{ Exception -> 0x003c }
            goto L_0x0015
        L_0x0014:
            r5 = r1
        L_0x0015:
            if (r5 == 0) goto L_0x001e
            java.lang.Object r5 = r5.get(r0)     // Catch:{ Exception -> 0x003c }
            r1 = r5
            java.lang.String r1 = (java.lang.String) r1     // Catch:{ Exception -> 0x003c }
        L_0x001e:
            byte[] r4 = com.fyber.inneractive.sdk.util.u.a((java.io.InputStream) r4)     // Catch:{ Exception -> 0x003c }
            java.lang.String r4 = android.util.Base64.encodeToString(r4, r0)     // Catch:{ Exception -> 0x003c }
            java.lang.String r5 = "data:%s;base64, %s"
            r2 = 2
            java.lang.Object[] r2 = new java.lang.Object[r2]     // Catch:{ Exception -> 0x003c }
            if (r1 == 0) goto L_0x002e
            goto L_0x0030
        L_0x002e:
            java.lang.String r1 = "image/png"
        L_0x0030:
            r2[r0] = r1     // Catch:{ Exception -> 0x003c }
            r1 = 1
            r2[r1] = r4     // Catch:{ Exception -> 0x003c }
            java.lang.String r4 = java.lang.String.format(r5, r2)     // Catch:{ Exception -> 0x003c }
            r6.a = r4     // Catch:{ Exception -> 0x003c }
            goto L_0x0043
        L_0x003c:
            java.lang.Object[] r4 = new java.lang.Object[r0]
            java.lang.String r5 = "failed to fetch and encode the image."
            com.fyber.inneractive.sdk.util.IAlog.a(r5, r4)
        L_0x0043:
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fyber.inneractive.sdk.network.m0.a(com.fyber.inneractive.sdk.network.j, java.util.Map, int):com.fyber.inneractive.sdk.network.b0");
    }
}
