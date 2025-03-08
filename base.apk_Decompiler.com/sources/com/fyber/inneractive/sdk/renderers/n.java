package com.fyber.inneractive.sdk.renderers;

import com.fyber.inneractive.sdk.external.InneractiveAdSpot;
import com.fyber.inneractive.sdk.flow.f0;
import com.fyber.inneractive.sdk.player.c;
import com.fyber.inneractive.sdk.player.controller.b;
import com.fyber.inneractive.sdk.player.e;
import com.fyber.inneractive.sdk.player.ui.h;

public abstract class n {
    public b a;
    public h b;
    public e c;

    public n(com.fyber.inneractive.sdk.player.h hVar) {
        this.c = (e) hVar.c();
    }

    public abstract b a(InneractiveAdSpot inneractiveAdSpot, f0 f0Var);

    public abstract void a(c.C0106c cVar);

    public abstract boolean c();

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0004, code lost:
        r0 = r0.e;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean a() {
        /*
            r3 = this;
            com.fyber.inneractive.sdk.player.e r0 = r3.c
            if (r0 == 0) goto L_0x000d
            com.fyber.inneractive.sdk.flow.f0 r0 = r0.e
            if (r0 == 0) goto L_0x000d
            T r0 = r0.b
            com.fyber.inneractive.sdk.response.g r0 = (com.fyber.inneractive.sdk.response.g) r0
            goto L_0x000e
        L_0x000d:
            r0 = 0
        L_0x000e:
            r1 = 1
            if (r0 == 0) goto L_0x001f
            java.lang.String r0 = r0.C
            if (r0 == 0) goto L_0x001f
            java.lang.String r2 = "1"
            boolean r0 = android.text.TextUtils.equals(r0, r2)
            if (r0 == 0) goto L_0x001f
            r0 = 1
            goto L_0x0020
        L_0x001f:
            r0 = 0
        L_0x0020:
            r0 = r0 ^ r1
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fyber.inneractive.sdk.renderers.n.a():boolean");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0005, code lost:
        r0 = r0.e;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.String b() {
        /*
            r2 = this;
            com.fyber.inneractive.sdk.player.e r0 = r2.c
            r1 = 0
            if (r0 == 0) goto L_0x000e
            com.fyber.inneractive.sdk.flow.f0 r0 = r0.e
            if (r0 == 0) goto L_0x000e
            T r0 = r0.b
            com.fyber.inneractive.sdk.response.g r0 = (com.fyber.inneractive.sdk.response.g) r0
            goto L_0x000f
        L_0x000e:
            r0 = r1
        L_0x000f:
            if (r0 == 0) goto L_0x0013
            java.lang.String r1 = r0.D
        L_0x0013:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fyber.inneractive.sdk.renderers.n.b():java.lang.String");
    }
}
