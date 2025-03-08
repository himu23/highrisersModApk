package com.applovin.impl.sdk.e;

import android.app.Activity;
import com.applovin.impl.privacy.a;
import com.applovin.impl.privacy.a.c;
import com.applovin.impl.privacy.a.d;
import com.applovin.impl.sdk.af;
import com.applovin.impl.sdk.c.b;
import com.applovin.impl.sdk.e.q;
import com.applovin.impl.sdk.f;
import com.applovin.impl.sdk.n;
import com.applovin.impl.sdk.utils.t;
import com.applovin.impl.sdk.utils.u;
import com.applovin.impl.sdk.x;
import com.applovin.sdk.AppLovinSdk;
import com.ironsource.m2;
import com.ironsource.mediationsdk.utils.IronSourceConstants;
import com.ironsource.t4;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public class p extends d {
    private final n sdk;

    public p(n nVar) {
        super("TaskInitializeSdk", nVar, true);
        this.sdk = nVar;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:34:0x01a3, code lost:
        if (r13.sdk.isEnabled() != false) goto L_0x0237;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:50:0x0233, code lost:
        if (r13.sdk.isEnabled() != false) goto L_0x0237;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:51:0x0236, code lost:
        r2 = com.ironsource.m2.h.t;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:52:0x0237, code lost:
        r10.append(r2);
        r10.append(" in ");
        r10.append(java.lang.System.currentTimeMillis() - r6);
        r10.append("ms");
        r8.f(r9, r10.toString());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:67:?, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void run() {
        /*
            r13 = this;
            java.lang.String r0 = "ms"
            java.lang.String r1 = " in "
            java.lang.String r2 = "succeeded"
            java.lang.String r3 = "failed"
            java.lang.String r4 = " initialization "
            java.lang.String r5 = "AppLovin SDK "
            long r6 = java.lang.System.currentTimeMillis()
            com.applovin.impl.sdk.x r8 = r13.logger
            boolean r8 = com.applovin.impl.sdk.x.Fn()
            if (r8 == 0) goto L_0x0034
            com.applovin.impl.sdk.x r8 = r13.logger
            java.lang.String r9 = r13.tag
            java.lang.StringBuilder r10 = new java.lang.StringBuilder
            java.lang.String r11 = "Initializing AppLovin SDK v"
            r10.<init>(r11)
            java.lang.String r11 = com.applovin.sdk.AppLovinSdk.VERSION
            r10.append(r11)
            java.lang.String r11 = "..."
            r10.append(r11)
            java.lang.String r10 = r10.toString()
            r8.f(r9, r10)
        L_0x0034:
            com.applovin.impl.sdk.n r8 = r13.sdk     // Catch:{ all -> 0x01a7 }
            com.applovin.impl.sdk.d.g r8 = r8.BR()     // Catch:{ all -> 0x01a7 }
            r8.JZ()     // Catch:{ all -> 0x01a7 }
            com.applovin.impl.sdk.n r8 = r13.sdk     // Catch:{ all -> 0x01a7 }
            com.applovin.impl.sdk.d.g r8 = r8.BR()     // Catch:{ all -> 0x01a7 }
            com.applovin.impl.sdk.d.f r9 = com.applovin.impl.sdk.d.f.aSW     // Catch:{ all -> 0x01a7 }
            r8.c(r9)     // Catch:{ all -> 0x01a7 }
            com.applovin.impl.sdk.n r8 = r13.sdk     // Catch:{ all -> 0x01a7 }
            com.applovin.impl.sdk.d.g r8 = r8.BR()     // Catch:{ all -> 0x01a7 }
            com.applovin.impl.sdk.d.f r9 = com.applovin.impl.sdk.d.f.aSX     // Catch:{ all -> 0x01a7 }
            r8.c(r9)     // Catch:{ all -> 0x01a7 }
            com.applovin.impl.sdk.n r8 = r13.sdk     // Catch:{ all -> 0x01a7 }
            com.applovin.impl.sdk.t r8 = r8.Cc()     // Catch:{ all -> 0x01a7 }
            android.content.Context r9 = r13.rQ()     // Catch:{ all -> 0x01a7 }
            r8.H(r9)     // Catch:{ all -> 0x01a7 }
            com.applovin.impl.sdk.n r8 = r13.sdk     // Catch:{ all -> 0x01a7 }
            com.applovin.impl.sdk.t r8 = r8.Cc()     // Catch:{ all -> 0x01a7 }
            android.content.Context r9 = r13.rQ()     // Catch:{ all -> 0x01a7 }
            r8.L(r9)     // Catch:{ all -> 0x01a7 }
            com.applovin.impl.sdk.n r8 = r13.sdk     // Catch:{ all -> 0x01a7 }
            com.applovin.impl.sdk.e.q r8 = r8.BO()     // Catch:{ all -> 0x01a7 }
            com.applovin.impl.sdk.e.e r9 = new com.applovin.impl.sdk.e.e     // Catch:{ all -> 0x01a7 }
            com.applovin.impl.sdk.n r10 = r13.sdk     // Catch:{ all -> 0x01a7 }
            r9.<init>(r10)     // Catch:{ all -> 0x01a7 }
            com.applovin.impl.sdk.e.q$b r10 = com.applovin.impl.sdk.e.q.b.MAIN     // Catch:{ all -> 0x01a7 }
            r8.a((com.applovin.impl.sdk.e.d) r9, (com.applovin.impl.sdk.e.q.b) r10)     // Catch:{ all -> 0x01a7 }
            com.applovin.impl.sdk.n r8 = r13.sdk     // Catch:{ all -> 0x01a7 }
            com.applovin.impl.sdk.p r8 = r8.BV()     // Catch:{ all -> 0x01a7 }
            if (r8 == 0) goto L_0x0091
            com.applovin.impl.sdk.n r8 = r13.sdk     // Catch:{ all -> 0x01a7 }
            com.applovin.impl.sdk.p r8 = r8.BV()     // Catch:{ all -> 0x01a7 }
            r8.DG()     // Catch:{ all -> 0x01a7 }
            goto L_0x009a
        L_0x0091:
            com.applovin.impl.sdk.n r8 = r13.sdk     // Catch:{ all -> 0x01a7 }
            com.applovin.impl.sdk.o r8 = r8.BS()     // Catch:{ all -> 0x01a7 }
            r8.CW()     // Catch:{ all -> 0x01a7 }
        L_0x009a:
            com.applovin.impl.sdk.n r8 = r13.sdk     // Catch:{ all -> 0x01a7 }
            com.applovin.impl.sdk.utils.q r8 = r8.Ci()     // Catch:{ all -> 0x01a7 }
            r8.Lq()     // Catch:{ all -> 0x01a7 }
            com.applovin.impl.sdk.n r8 = r13.sdk     // Catch:{ all -> 0x01a7 }
            com.applovin.impl.a.a.a r8 = r8.Co()     // Catch:{ all -> 0x01a7 }
            r8.tv()     // Catch:{ all -> 0x01a7 }
            android.content.Context r8 = r13.rQ()     // Catch:{ all -> 0x01a7 }
            com.applovin.impl.sdk.n r9 = r13.sdk     // Catch:{ all -> 0x01a7 }
            boolean r8 = com.applovin.impl.sdk.utils.u.b((android.content.Context) r8, (com.applovin.impl.sdk.n) r9)     // Catch:{ all -> 0x01a7 }
            if (r8 == 0) goto L_0x00bd
            com.applovin.impl.sdk.n r8 = r13.sdk     // Catch:{ all -> 0x01a7 }
            r8.Bt()     // Catch:{ all -> 0x01a7 }
        L_0x00bd:
            com.applovin.impl.sdk.n r8 = r13.sdk     // Catch:{ all -> 0x01a7 }
            com.applovin.impl.sdk.array.ArrayService r8 = r8.Cr()     // Catch:{ all -> 0x01a7 }
            r8.collectAppHubData()     // Catch:{ all -> 0x01a7 }
            r13.KG()     // Catch:{ all -> 0x01a7 }
            com.applovin.impl.sdk.n r8 = r13.sdk     // Catch:{ all -> 0x01a7 }
            com.applovin.impl.sdk.c.b<java.lang.Boolean> r9 = com.applovin.impl.sdk.c.b.aOY     // Catch:{ all -> 0x01a7 }
            java.lang.Object r8 = r8.a(r9)     // Catch:{ all -> 0x01a7 }
            java.lang.Boolean r8 = (java.lang.Boolean) r8     // Catch:{ all -> 0x01a7 }
            boolean r8 = r8.booleanValue()     // Catch:{ all -> 0x01a7 }
            if (r8 == 0) goto L_0x00e1
            com.applovin.impl.sdk.e.p$$ExternalSyntheticLambda0 r8 = new com.applovin.impl.sdk.e.p$$ExternalSyntheticLambda0     // Catch:{ all -> 0x01a7 }
            r8.<init>(r13)     // Catch:{ all -> 0x01a7 }
            com.applovin.sdk.AppLovinSdkUtils.runOnUiThread(r8)     // Catch:{ all -> 0x01a7 }
        L_0x00e1:
            r13.KF()     // Catch:{ all -> 0x01a7 }
            com.applovin.impl.sdk.n r8 = r13.sdk     // Catch:{ all -> 0x01a7 }
            r9 = 1
            r8.aK(r9)     // Catch:{ all -> 0x01a7 }
            com.applovin.impl.sdk.n r8 = r13.sdk     // Catch:{ all -> 0x01a7 }
            com.applovin.impl.sdk.network.f r8 = r8.Cu()     // Catch:{ all -> 0x01a7 }
            r8.Iq()     // Catch:{ all -> 0x01a7 }
            com.applovin.impl.sdk.n r8 = r13.sdk     // Catch:{ all -> 0x01a7 }
            com.applovin.impl.sdk.EventServiceImpl r8 = r8.BF()     // Catch:{ all -> 0x01a7 }
            r8.maybeTrackAppOpenEvent()     // Catch:{ all -> 0x01a7 }
            com.applovin.impl.sdk.n r8 = r13.sdk     // Catch:{ all -> 0x01a7 }
            com.applovin.impl.mediation.debugger.b r8 = r8.CB()     // Catch:{ all -> 0x01a7 }
            boolean r8 = r8.uC()     // Catch:{ all -> 0x01a7 }
            if (r8 == 0) goto L_0x0110
            com.applovin.impl.sdk.n r8 = r13.sdk     // Catch:{ all -> 0x01a7 }
            boolean r8 = r8.Bq()     // Catch:{ all -> 0x01a7 }
            if (r8 == 0) goto L_0x0134
        L_0x0110:
            com.applovin.impl.sdk.n r8 = r13.sdk     // Catch:{ all -> 0x01a7 }
            com.applovin.impl.sdk.c.b<java.lang.Boolean> r9 = com.applovin.impl.sdk.c.a.aJl     // Catch:{ all -> 0x01a7 }
            java.lang.Object r8 = r8.a(r9)     // Catch:{ all -> 0x01a7 }
            java.lang.Boolean r8 = (java.lang.Boolean) r8     // Catch:{ all -> 0x01a7 }
            boolean r8 = r8.booleanValue()     // Catch:{ all -> 0x01a7 }
            if (r8 == 0) goto L_0x013d
            android.content.Context r8 = com.applovin.impl.sdk.n.getApplicationContext()     // Catch:{ all -> 0x01a7 }
            com.applovin.impl.sdk.n r9 = r13.sdk     // Catch:{ all -> 0x01a7 }
            boolean r8 = com.applovin.impl.sdk.utils.u.b((android.content.Context) r8, (com.applovin.impl.sdk.n) r9)     // Catch:{ all -> 0x01a7 }
            if (r8 == 0) goto L_0x013d
            com.applovin.impl.sdk.n r8 = r13.sdk     // Catch:{ all -> 0x01a7 }
            boolean r8 = r8.Br()     // Catch:{ all -> 0x01a7 }
            if (r8 == 0) goto L_0x013d
        L_0x0134:
            com.applovin.impl.sdk.n r8 = r13.sdk     // Catch:{ all -> 0x01a7 }
            com.applovin.impl.mediation.debugger.b r8 = r8.CB()     // Catch:{ all -> 0x01a7 }
            r8.uB()     // Catch:{ all -> 0x01a7 }
        L_0x013d:
            com.applovin.impl.sdk.n r8 = r13.sdk
            com.applovin.impl.sdk.aa r8 = r8.BW()
            if (r8 == 0) goto L_0x0158
            com.applovin.impl.sdk.n r8 = r13.sdk
            com.applovin.impl.sdk.c.b<java.lang.String> r9 = com.applovin.impl.sdk.c.b.aKM
            java.lang.Object r8 = r8.a(r9)
            java.lang.String r8 = (java.lang.String) r8
            com.applovin.impl.sdk.n r9 = r13.sdk
            com.applovin.impl.sdk.aa r9 = r9.BW()
            r9.cL(r8)
        L_0x0158:
            com.applovin.impl.sdk.n r8 = r13.sdk
            com.applovin.impl.sdk.a.f r8 = r8.Cp()
            r8.uB()
            com.applovin.impl.sdk.n r8 = r13.sdk
            com.applovin.impl.sdk.c.b<java.lang.Boolean> r9 = com.applovin.impl.sdk.c.b.aKZ
            java.lang.Object r8 = r8.a(r9)
            java.lang.Boolean r8 = (java.lang.Boolean) r8
            boolean r8 = r8.booleanValue()
            if (r8 == 0) goto L_0x0184
            com.applovin.impl.sdk.n r8 = r13.sdk
            com.applovin.impl.sdk.c.b<java.lang.Long> r9 = com.applovin.impl.sdk.c.b.aLa
            java.lang.Object r8 = r8.a(r9)
            java.lang.Long r8 = (java.lang.Long) r8
            com.applovin.impl.sdk.n r9 = r13.sdk
            long r10 = r8.longValue()
            r9.bN(r10)
        L_0x0184:
            com.applovin.impl.sdk.x r8 = r13.logger
            boolean r8 = com.applovin.impl.sdk.x.Fn()
            if (r8 == 0) goto L_0x024f
            com.applovin.impl.sdk.x r8 = r13.logger
            java.lang.String r9 = r13.tag
            java.lang.StringBuilder r10 = new java.lang.StringBuilder
            r10.<init>(r5)
            java.lang.String r5 = com.applovin.sdk.AppLovinSdk.VERSION
            r10.append(r5)
            r10.append(r4)
            com.applovin.impl.sdk.n r4 = r13.sdk
            boolean r4 = r4.isEnabled()
            if (r4 == 0) goto L_0x0236
            goto L_0x0237
        L_0x01a7:
            r8 = move-exception
            java.lang.String r9 = "AppLovinSdk"
            java.lang.String r10 = "Failed to initialize SDK!"
            com.applovin.impl.sdk.x.e(r9, r10, r8)     // Catch:{ all -> 0x0250 }
            com.applovin.impl.sdk.n r9 = r13.sdk     // Catch:{ all -> 0x0250 }
            r10 = 0
            r9.aK(r10)     // Catch:{ all -> 0x0250 }
            r13.q(r8)     // Catch:{ all -> 0x0250 }
            com.applovin.impl.sdk.n r8 = r13.sdk     // Catch:{ all -> 0x0250 }
            com.applovin.impl.sdk.c.b<java.lang.Boolean> r9 = com.applovin.impl.sdk.c.b.aKn     // Catch:{ all -> 0x0250 }
            java.lang.Object r8 = r8.a(r9)     // Catch:{ all -> 0x0250 }
            java.lang.Boolean r8 = (java.lang.Boolean) r8     // Catch:{ all -> 0x0250 }
            boolean r8 = r8.booleanValue()     // Catch:{ all -> 0x0250 }
            if (r8 == 0) goto L_0x01cd
            com.applovin.impl.sdk.n r8 = r13.sdk     // Catch:{ all -> 0x0250 }
            r8.Bx()     // Catch:{ all -> 0x0250 }
        L_0x01cd:
            com.applovin.impl.sdk.n r8 = r13.sdk
            com.applovin.impl.sdk.aa r8 = r8.BW()
            if (r8 == 0) goto L_0x01e8
            com.applovin.impl.sdk.n r8 = r13.sdk
            com.applovin.impl.sdk.c.b<java.lang.String> r9 = com.applovin.impl.sdk.c.b.aKM
            java.lang.Object r8 = r8.a(r9)
            java.lang.String r8 = (java.lang.String) r8
            com.applovin.impl.sdk.n r9 = r13.sdk
            com.applovin.impl.sdk.aa r9 = r9.BW()
            r9.cL(r8)
        L_0x01e8:
            com.applovin.impl.sdk.n r8 = r13.sdk
            com.applovin.impl.sdk.a.f r8 = r8.Cp()
            r8.uB()
            com.applovin.impl.sdk.n r8 = r13.sdk
            com.applovin.impl.sdk.c.b<java.lang.Boolean> r9 = com.applovin.impl.sdk.c.b.aKZ
            java.lang.Object r8 = r8.a(r9)
            java.lang.Boolean r8 = (java.lang.Boolean) r8
            boolean r8 = r8.booleanValue()
            if (r8 == 0) goto L_0x0214
            com.applovin.impl.sdk.n r8 = r13.sdk
            com.applovin.impl.sdk.c.b<java.lang.Long> r9 = com.applovin.impl.sdk.c.b.aLa
            java.lang.Object r8 = r8.a(r9)
            java.lang.Long r8 = (java.lang.Long) r8
            com.applovin.impl.sdk.n r9 = r13.sdk
            long r10 = r8.longValue()
            r9.bN(r10)
        L_0x0214:
            com.applovin.impl.sdk.x r8 = r13.logger
            boolean r8 = com.applovin.impl.sdk.x.Fn()
            if (r8 == 0) goto L_0x024f
            com.applovin.impl.sdk.x r8 = r13.logger
            java.lang.String r9 = r13.tag
            java.lang.StringBuilder r10 = new java.lang.StringBuilder
            r10.<init>(r5)
            java.lang.String r5 = com.applovin.sdk.AppLovinSdk.VERSION
            r10.append(r5)
            r10.append(r4)
            com.applovin.impl.sdk.n r4 = r13.sdk
            boolean r4 = r4.isEnabled()
            if (r4 == 0) goto L_0x0236
            goto L_0x0237
        L_0x0236:
            r2 = r3
        L_0x0237:
            r10.append(r2)
            r10.append(r1)
            long r1 = java.lang.System.currentTimeMillis()
            long r1 = r1 - r6
            r10.append(r1)
            r10.append(r0)
            java.lang.String r0 = r10.toString()
            r8.f(r9, r0)
        L_0x024f:
            return
        L_0x0250:
            r8 = move-exception
            com.applovin.impl.sdk.n r9 = r13.sdk
            com.applovin.impl.sdk.aa r9 = r9.BW()
            if (r9 == 0) goto L_0x026c
            com.applovin.impl.sdk.n r9 = r13.sdk
            com.applovin.impl.sdk.c.b<java.lang.String> r10 = com.applovin.impl.sdk.c.b.aKM
            java.lang.Object r9 = r9.a(r10)
            java.lang.String r9 = (java.lang.String) r9
            com.applovin.impl.sdk.n r10 = r13.sdk
            com.applovin.impl.sdk.aa r10 = r10.BW()
            r10.cL(r9)
        L_0x026c:
            com.applovin.impl.sdk.n r9 = r13.sdk
            com.applovin.impl.sdk.a.f r9 = r9.Cp()
            r9.uB()
            com.applovin.impl.sdk.n r9 = r13.sdk
            com.applovin.impl.sdk.c.b<java.lang.Boolean> r10 = com.applovin.impl.sdk.c.b.aKZ
            java.lang.Object r9 = r9.a(r10)
            java.lang.Boolean r9 = (java.lang.Boolean) r9
            boolean r9 = r9.booleanValue()
            if (r9 == 0) goto L_0x0298
            com.applovin.impl.sdk.n r9 = r13.sdk
            com.applovin.impl.sdk.c.b<java.lang.Long> r10 = com.applovin.impl.sdk.c.b.aLa
            java.lang.Object r9 = r9.a(r10)
            java.lang.Long r9 = (java.lang.Long) r9
            com.applovin.impl.sdk.n r10 = r13.sdk
            long r11 = r9.longValue()
            r10.bN(r11)
        L_0x0298:
            com.applovin.impl.sdk.x r9 = r13.logger
            boolean r9 = com.applovin.impl.sdk.x.Fn()
            if (r9 == 0) goto L_0x02d3
            com.applovin.impl.sdk.x r9 = r13.logger
            java.lang.String r10 = r13.tag
            java.lang.StringBuilder r11 = new java.lang.StringBuilder
            r11.<init>(r5)
            java.lang.String r5 = com.applovin.sdk.AppLovinSdk.VERSION
            r11.append(r5)
            r11.append(r4)
            com.applovin.impl.sdk.n r4 = r13.sdk
            boolean r4 = r4.isEnabled()
            if (r4 == 0) goto L_0x02ba
            goto L_0x02bb
        L_0x02ba:
            r2 = r3
        L_0x02bb:
            r11.append(r2)
            r11.append(r1)
            long r1 = java.lang.System.currentTimeMillis()
            long r1 = r1 - r6
            r11.append(r1)
            r11.append(r0)
            java.lang.String r0 = r11.toString()
            r9.f(r10, r0)
        L_0x02d3:
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.applovin.impl.sdk.e.p.run():void");
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void zJ() {
        af.z(this.sdk);
    }

    private void KF() {
        if (!this.sdk.Cx().isInitialized()) {
            Activity CF = this.sdk.CF();
            if (CF != null) {
                this.sdk.Cx().b(CF);
            } else {
                this.sdk.BO().a((d) new ab(this.sdk, true, "initializeAdapters", new p$$ExternalSyntheticLambda1(this)), q.b.MAIN, TimeUnit.SECONDS.toMillis(1));
            }
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void KH() {
        this.sdk.Cx().b(this.sdk.BM().Az());
    }

    private void KG() {
        Map<String, Object> map;
        Map<String, Object> map2;
        if (!this.sdk.Bq()) {
            boolean isVerboseLoggingEnabled = this.sdk.BP().isVerboseLoggingEnabled();
            String str = "<Enable verbose logging to see the GAID to use for test devices - https://monetization-support.applovin.com/hc/en-us/articles/236114328-How-can-I-expose-verbose-logging-for-the-SDK>";
            if (this.sdk.BV() != null) {
                if (isVerboseLoggingEnabled) {
                    str = this.sdk.BU().DM().KR() + " (use this for test devices)";
                }
                map2 = this.sdk.BV().CV();
                map = this.sdk.BV().CU();
            } else {
                if (isVerboseLoggingEnabled) {
                    str = this.sdk.BS().Di().KR() + " (use this for test devices)";
                }
                map2 = this.sdk.BS().CV();
                map = this.sdk.BS().CU();
            }
            com.applovin.impl.sdk.utils.n nVar = new com.applovin.impl.sdk.utils.n();
            nVar.Lo().dz("=====AppLovin SDK=====");
            nVar.dz("===SDK Versions===").e("Version", AppLovinSdk.VERSION).e("Plugin Version", this.sdk.a(b.aOD)).e("Ad Review Version", f.getVersion()).e("OM SDK Version", this.sdk.Cp().getSdkVersion());
            nVar.dz("===Device Info===").e("OS", u.LB()).e(IronSourceConstants.TYPE_GAID, str).e("Model", map2.get(t4.u)).e("Locale", map2.get("locale")).e("Emulator", map2.get("sim")).e("Tablet", map2.get("is_tablet"));
            nVar.dz("===App Info===").e("Application ID", map.get(m2.h.V)).e("Target SDK", map.get("target_sdk")).e("ExoPlayer Version", Integer.valueOf(u.LC()));
            nVar.dz("===SDK Settings===").e("SDK Key", this.sdk.getSdkKey()).e("Mediation Provider", this.sdk.getMediationProvider()).e("TG", t.M(this.sdk)).e("AEI", this.sdk.a(b.aKC)).e("MEI", this.sdk.a(b.aKD)).e("Test Mode On", Boolean.valueOf(this.sdk.CE().isEnabled())).e("Verbose Logging On", Boolean.valueOf(isVerboseLoggingEnabled));
            nVar.dz("===Privacy States===\nPlease review AppLovin MAX documentation to be compliant with regional privacy policies.").dz(a.A(rQ()));
            c Cl = this.sdk.Cl();
            nVar.dz("===MAX Terms Flow===").e("Enabled", Boolean.valueOf(Cl.isEnabled()));
            if (Cl.isEnabled()) {
                nVar.e("Flow Type", Cl.zX() == d.a.TERMS ? "MAX Terms Flow" : "MAX Terms and Privacy Policy Flow");
            }
            nVar.e("Privacy Policy URI", Cl.getPrivacyPolicyUri()).e("Terms of Service URI", Cl.getTermsOfServiceUri());
            this.sdk.Cm();
            nVar.dz("===CMP (CONSENT MANAGEMENT PLATFORM)===").dz(this.sdk.Cm().uI());
            nVar.Lo();
            x.D("AppLovinSdk", nVar.toString());
        }
    }
}
