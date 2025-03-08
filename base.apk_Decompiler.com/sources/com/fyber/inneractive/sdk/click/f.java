package com.fyber.inneractive.sdk.click;

import com.fyber.inneractive.sdk.util.i;
import com.fyber.inneractive.sdk.util.p0;
import com.fyber.inneractive.sdk.web.r;

public class f implements a {
    public r a;
    public boolean b;
    public final a c;
    public final p0 d;
    public final i e;

    public interface a {
        void a(b bVar, p0 p0Var, i iVar);
    }

    public f(a aVar, p0 p0Var, i iVar) {
        this.c = aVar;
        this.d = p0Var;
        this.e = iVar;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:4:0x0018, code lost:
        r3 = r2.a;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean a(android.net.Uri r3, com.fyber.inneractive.sdk.click.l r4) {
        /*
            r2 = this;
            com.fyber.inneractive.sdk.ignite.k r3 = com.fyber.inneractive.sdk.ignite.k.NONE
            com.fyber.inneractive.sdk.ignite.k r0 = r4.k
            boolean r1 = r4.j
            r2.b = r1
            com.fyber.inneractive.sdk.web.r r4 = r4.i
            r2.a = r4
            if (r0 == r3) goto L_0x0022
            com.fyber.inneractive.sdk.config.IAConfigManager r3 = com.fyber.inneractive.sdk.config.IAConfigManager.M
            com.fyber.inneractive.sdk.ignite.c r3 = r3.E
            boolean r3 = r3.d()
            if (r3 == 0) goto L_0x0022
            com.fyber.inneractive.sdk.web.r r3 = r2.a
            if (r3 == 0) goto L_0x0022
            boolean r3 = r3.l
            if (r3 == 0) goto L_0x0022
            r3 = 1
            goto L_0x0023
        L_0x0022:
            r3 = 0
        L_0x0023:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fyber.inneractive.sdk.click.f.a(android.net.Uri, com.fyber.inneractive.sdk.click.l):boolean");
    }

    /* JADX WARNING: Removed duplicated region for block: B:31:0x0074  */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x0078  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.fyber.inneractive.sdk.click.b a(android.content.Context r12, android.net.Uri r13, java.util.List<com.fyber.inneractive.sdk.click.i> r14) {
        /*
            r11 = this;
            com.fyber.inneractive.sdk.web.r r0 = r11.a
            java.lang.String r1 = "IgniteGooglePlay"
            if (r0 == 0) goto L_0x00fa
            boolean r2 = r11.b
            boolean r3 = r0.C
            r4 = 0
            if (r3 == 0) goto L_0x0025
            com.fyber.inneractive.sdk.util.b0$a r0 = new com.fyber.inneractive.sdk.util.b0$a
            com.fyber.inneractive.sdk.util.b0$d r2 = com.fyber.inneractive.sdk.util.b0.d.FAILED
            java.lang.IllegalStateException r3 = new java.lang.IllegalStateException
            java.lang.String r5 = "Store controller is already open"
            r3.<init>(r5)
            java.lang.Class r12 = r12.getClass()
            java.lang.String r12 = r12.getName()
            r0.<init>(r2, r3, r12)
            goto L_0x00aa
        L_0x0025:
            r3 = 1
            r0.C = r3
            java.lang.Class r5 = r12.getClass()     // Catch:{ all -> 0x0031 }
            java.lang.String r5 = r5.getName()     // Catch:{ all -> 0x0031 }
            goto L_0x0033
        L_0x0031:
            java.lang.String r5 = "failed"
        L_0x0033:
            r0.D = r3
            java.lang.String r3 = r0.j
            java.lang.String r6 = "invalid_task_id"
            boolean r3 = r3.equals(r6)
            if (r3 == 0) goto L_0x004c
            boolean r3 = r0.z
            if (r3 != 0) goto L_0x004c
            if (r2 == 0) goto L_0x0048
            com.fyber.inneractive.sdk.ignite.k r3 = com.fyber.inneractive.sdk.ignite.k.TRUE_SINGLE_TAP
            goto L_0x004a
        L_0x0048:
            com.fyber.inneractive.sdk.ignite.k r3 = com.fyber.inneractive.sdk.ignite.k.SINGLE_TAP
        L_0x004a:
            r0.d = r3
        L_0x004c:
            r0.B = r2
            boolean r3 = r0.A
            r6 = 0
            java.lang.String r7 = "onInstallationSuccess();"
            if (r3 == 0) goto L_0x0059
            r0.f(r7)
            goto L_0x0095
        L_0x0059:
            boolean r3 = r0.z
            if (r3 != 0) goto L_0x0095
            java.lang.String r3 = r0.c
            boolean r8 = android.text.TextUtils.isEmpty(r3)     // Catch:{ Exception -> 0x0070 }
            if (r8 != 0) goto L_0x0071
            android.app.Application r8 = com.fyber.inneractive.sdk.util.p.a     // Catch:{ Exception -> 0x0070 }
            android.content.pm.PackageManager r8 = r8.getPackageManager()     // Catch:{ Exception -> 0x0070 }
            android.content.pm.PackageInfo r3 = r8.getPackageInfo(r3, r4)     // Catch:{ Exception -> 0x0070 }
            goto L_0x0072
        L_0x0070:
        L_0x0071:
            r3 = r6
        L_0x0072:
            if (r3 == 0) goto L_0x0078
            r0.f(r7)
            goto L_0x0095
        L_0x0078:
            if (r2 == 0) goto L_0x0095
            com.fyber.inneractive.sdk.ignite.c r2 = r0.b
            java.lang.String r3 = r0.c
            com.fyber.inneractive.sdk.ignite.c$d r7 = new com.fyber.inneractive.sdk.ignite.c$d
            java.lang.String r8 = r0.f
            com.fyber.inneractive.sdk.ignite.k r9 = r0.d
            com.fyber.inneractive.sdk.ignite.j r10 = r0.h
            com.fyber.inneractive.sdk.flow.p$a r10 = (com.fyber.inneractive.sdk.flow.p.a) r10
            com.fyber.inneractive.sdk.flow.p r10 = com.fyber.inneractive.sdk.flow.p.this
            r7.<init>(r8, r9, r10)
            r2.a((java.lang.String) r3, (com.fyber.inneractive.sdk.ignite.c.d) r7)
            java.lang.String r2 = "onShowInstallStarted();"
            r0.f(r2)
        L_0x0095:
            java.lang.String r0 = r0.e     // Catch:{ ActivityNotFoundException -> 0x00a2 }
            com.fyber.inneractive.sdk.activities.InternalStoreWebpageActivity.startActivity(r12, r0)     // Catch:{ ActivityNotFoundException -> 0x00a2 }
            com.fyber.inneractive.sdk.util.b0$a r0 = new com.fyber.inneractive.sdk.util.b0$a     // Catch:{ ActivityNotFoundException -> 0x00a2 }
            com.fyber.inneractive.sdk.util.b0$d r12 = com.fyber.inneractive.sdk.util.b0.d.OPENED_INTERNAL_STORE     // Catch:{ ActivityNotFoundException -> 0x00a2 }
            r0.<init>(r12, r6, r5)     // Catch:{ ActivityNotFoundException -> 0x00a2 }
            goto L_0x00aa
        L_0x00a2:
            r12 = move-exception
            com.fyber.inneractive.sdk.util.b0$a r0 = new com.fyber.inneractive.sdk.util.b0$a
            com.fyber.inneractive.sdk.util.b0$d r2 = com.fyber.inneractive.sdk.util.b0.d.FAILED
            r0.<init>(r2, r12, r5)
        L_0x00aa:
            java.lang.Throwable r12 = r0.b
            if (r12 != 0) goto L_0x00db
            com.fyber.inneractive.sdk.network.q0 r12 = new com.fyber.inneractive.sdk.network.q0
            com.fyber.inneractive.sdk.click.e r0 = new com.fyber.inneractive.sdk.click.e
            r0.<init>(r11, r14, r13)
            java.lang.String r14 = r13.toString()
            com.fyber.inneractive.sdk.network.x r2 = com.fyber.inneractive.sdk.network.x.c
            com.fyber.inneractive.sdk.network.g r2 = r2.b()
            r12.<init>(r0, r14, r2)
            com.fyber.inneractive.sdk.config.IAConfigManager r14 = com.fyber.inneractive.sdk.config.IAConfigManager.M
            com.fyber.inneractive.sdk.network.y r14 = r14.s
            java.util.concurrent.BlockingQueue<com.fyber.inneractive.sdk.network.c0<?>> r14 = r14.a
            r14.offer(r12)
            com.fyber.inneractive.sdk.network.r0 r14 = com.fyber.inneractive.sdk.network.r0.QUEUED
            r12.a((com.fyber.inneractive.sdk.network.r0) r14)
            com.fyber.inneractive.sdk.click.l$d r12 = com.fyber.inneractive.sdk.click.l.d.OPEN_INTERNAL_STORE
            java.lang.String r13 = r13.toString()
            com.fyber.inneractive.sdk.click.b r12 = com.fyber.inneractive.sdk.click.l.a((java.lang.String) r13, (com.fyber.inneractive.sdk.click.l.d) r12, (java.lang.String) r1)
            return r12
        L_0x00db:
            if (r14 == 0) goto L_0x00ef
            com.fyber.inneractive.sdk.click.i r0 = new com.fyber.inneractive.sdk.click.i
            com.fyber.inneractive.sdk.web.r r2 = r11.a
            java.lang.String r2 = r2.k
            com.fyber.inneractive.sdk.click.l$d r3 = com.fyber.inneractive.sdk.click.l.d.OPEN_INTERNAL_STORE
            java.lang.String r12 = r12.toString()
            r0.<init>(r2, r4, r3, r12)
            r14.add(r0)
        L_0x00ef:
            java.lang.String r12 = r13.toString()
            java.lang.String r13 = "mInternalStoreWebpageController.show has failed"
            com.fyber.inneractive.sdk.click.b r12 = com.fyber.inneractive.sdk.click.l.a((java.lang.String) r12, (java.lang.String) r1, (java.lang.String) r13)
            return r12
        L_0x00fa:
            java.lang.String r12 = r13.toString()
            java.lang.String r13 = "mInternalStoreWebpageController is null"
            com.fyber.inneractive.sdk.click.b r12 = com.fyber.inneractive.sdk.click.l.a((java.lang.String) r12, (java.lang.String) r1, (java.lang.String) r13)
            return r12
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fyber.inneractive.sdk.click.f.a(android.content.Context, android.net.Uri, java.util.List):com.fyber.inneractive.sdk.click.b");
    }
}
