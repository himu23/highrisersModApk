package com.ironsource;

import android.app.Activity;
import com.ironsource.mediationsdk.adunit.adapter.internal.AdapterAdFullScreenInterface;
import com.ironsource.mediationsdk.adunit.adapter.internal.BaseAdAdapter;
import com.ironsource.mediationsdk.adunit.adapter.internal.listener.AdapterAdInteractionListener;
import com.ironsource.mediationsdk.adunit.adapter.internal.listener.AdapterAdListener;
import com.ironsource.mediationsdk.logger.IronLog;
import com.ironsource.mediationsdk.logger.IronSourceError;
import com.ironsource.mediationsdk.model.Placement;
import com.ironsource.t1;
import com.ironsource.w;
import java.util.Locale;

public abstract class p1<Listener extends w> extends t1<Listener> implements AdapterAdInteractionListener {

    class a extends cb {
        a() {
        }

        public void a() {
            p1.this.O();
        }
    }

    class b extends cb {
        b() {
        }

        public void a() {
            p1.this.R();
        }
    }

    class c extends cb {
        c() {
        }

        public void a() {
            p1.this.P();
        }
    }

    class d extends cb {
        d() {
        }

        public void a() {
            p1.this.S();
        }
    }

    class e extends cb {
        e() {
        }

        public void a() {
            p1.this.Q();
        }
    }

    class f extends cb {
        final /* synthetic */ int a;
        final /* synthetic */ String b;

        f(int i, String str) {
            this.a = i;
            this.b = str;
        }

        public void a() {
            p1.this.b(this.a, this.b);
        }
    }

    public p1(ia iaVar, p pVar, BaseAdAdapter<?, ?> baseAdAdapter, h0 h0Var, d1 d1Var, Listener listener) {
        super(iaVar, pVar, baseAdAdapter, h0Var, d1Var, listener);
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0064, code lost:
        ((com.ironsource.w) r8.b).a(r8);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x006b, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x00a1, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void O() {
        /*
            r8 = this;
            java.lang.String r0 = "true|"
            java.lang.String r1 = "unexpected ad closed - state = "
            java.lang.String r2 = "otherInstanceAvailable = "
            java.lang.String r3 = "unexpected ad closed for "
            com.ironsource.mediationsdk.logger.IronLog r4 = com.ironsource.mediationsdk.logger.IronLog.INTERNAL
            java.lang.String r5 = r8.d()
            r4.verbose(r5)
            java.lang.Object r5 = r8.q
            monitor-enter(r5)
            com.ironsource.t1$h r6 = r8.e     // Catch:{ all -> 0x00a2 }
            com.ironsource.t1$h r7 = com.ironsource.t1.h.SHOWING     // Catch:{ all -> 0x00a2 }
            if (r6 != r7) goto L_0x006c
            com.ironsource.t1$h r1 = com.ironsource.t1.h.NONE     // Catch:{ all -> 0x00a2 }
            r8.a((com.ironsource.t1.h) r1)     // Catch:{ all -> 0x00a2 }
            com.ironsource.v r1 = r8.d     // Catch:{ all -> 0x00a2 }
            if (r1 == 0) goto L_0x0063
            java.lang.String r1 = ""
            com.ironsource.p r3 = r8.a     // Catch:{ all -> 0x00a2 }
            com.ironsource.mediationsdk.IronSource$AD_UNIT r3 = r3.a()     // Catch:{ all -> 0x00a2 }
            com.ironsource.mediationsdk.IronSource$AD_UNIT r4 = com.ironsource.mediationsdk.IronSource.AD_UNIT.REWARDED_VIDEO     // Catch:{ all -> 0x00a2 }
            if (r3 != r4) goto L_0x0058
            Listener r1 = r8.b     // Catch:{ all -> 0x00a2 }
            com.ironsource.w r1 = (com.ironsource.w) r1     // Catch:{ all -> 0x00a2 }
            java.lang.String r1 = r1.d()     // Catch:{ all -> 0x00a2 }
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x00a2 }
            r3.<init>(r2)     // Catch:{ all -> 0x00a2 }
            int r2 = r1.length()     // Catch:{ all -> 0x00a2 }
            if (r2 <= 0) goto L_0x004f
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x00a2 }
            r2.<init>(r0)     // Catch:{ all -> 0x00a2 }
            r2.append(r1)     // Catch:{ all -> 0x00a2 }
            java.lang.String r0 = r2.toString()     // Catch:{ all -> 0x00a2 }
            goto L_0x0051
        L_0x004f:
            java.lang.String r0 = "false"
        L_0x0051:
            r3.append(r0)     // Catch:{ all -> 0x00a2 }
            java.lang.String r1 = r3.toString()     // Catch:{ all -> 0x00a2 }
        L_0x0058:
            com.ironsource.v r0 = r8.d     // Catch:{ all -> 0x00a2 }
            com.ironsource.k r0 = r0.j     // Catch:{ all -> 0x00a2 }
            java.lang.String r2 = r8.j()     // Catch:{ all -> 0x00a2 }
            r0.a((java.lang.String) r2, (java.lang.String) r1)     // Catch:{ all -> 0x00a2 }
        L_0x0063:
            monitor-exit(r5)     // Catch:{ all -> 0x00a2 }
            Listener r0 = r8.b
            com.ironsource.w r0 = (com.ironsource.w) r0
            r0.a(r8)
            return
        L_0x006c:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ all -> 0x00a2 }
            r0.<init>(r3)     // Catch:{ all -> 0x00a2 }
            java.lang.String r2 = r8.k()     // Catch:{ all -> 0x00a2 }
            r0.append(r2)     // Catch:{ all -> 0x00a2 }
            java.lang.String r2 = " - state = "
            r0.append(r2)     // Catch:{ all -> 0x00a2 }
            com.ironsource.t1$h r2 = r8.e     // Catch:{ all -> 0x00a2 }
            r0.append(r2)     // Catch:{ all -> 0x00a2 }
            java.lang.String r0 = r0.toString()     // Catch:{ all -> 0x00a2 }
            r4.error(r0)     // Catch:{ all -> 0x00a2 }
            com.ironsource.v r0 = r8.d     // Catch:{ all -> 0x00a2 }
            if (r0 == 0) goto L_0x00a0
            com.ironsource.oc r0 = r0.k     // Catch:{ all -> 0x00a2 }
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x00a2 }
            r2.<init>(r1)     // Catch:{ all -> 0x00a2 }
            com.ironsource.t1$h r1 = r8.e     // Catch:{ all -> 0x00a2 }
            r2.append(r1)     // Catch:{ all -> 0x00a2 }
            java.lang.String r1 = r2.toString()     // Catch:{ all -> 0x00a2 }
            r0.g(r1)     // Catch:{ all -> 0x00a2 }
        L_0x00a0:
            monitor-exit(r5)     // Catch:{ all -> 0x00a2 }
            return
        L_0x00a2:
            r0 = move-exception
            monitor-exit(r5)     // Catch:{ all -> 0x00a2 }
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ironsource.p1.O():void");
    }

    /* access modifiers changed from: private */
    public void P() {
        IronLog.INTERNAL.verbose(d());
        v vVar = this.d;
        if (vVar != null) {
            vVar.j.c(j());
        }
        ((w) this.b).c(this);
    }

    /* access modifiers changed from: private */
    public void Q() {
        IronLog.INTERNAL.verbose(d());
        v vVar = this.d;
        if (vVar != null) {
            vVar.j.j(j());
        }
        ((w) this.b).b(this);
    }

    /* access modifiers changed from: private */
    public void R() {
        IronLog.INTERNAL.verbose(d());
        v vVar = this.d;
        if (vVar != null) {
            vVar.j.g(j());
        }
        ((w) this.b).d(this);
    }

    /* access modifiers changed from: private */
    public void S() {
        IronLog.INTERNAL.verbose(d());
        v vVar = this.d;
        if (vVar != null) {
            vVar.j.h(j());
        }
    }

    static String a(t1.h hVar, int i, String str) {
        return String.format(Locale.ENGLISH, "unexpected show failed, state - %s, error - %d %s", new Object[]{hVar, Integer.valueOf(i), str});
    }

    /* access modifiers changed from: private */
    public void b(int i, String str) {
        IronLog ironLog = IronLog.INTERNAL;
        ironLog.verbose(a("error = " + i + ", " + str));
        t1.h hVar = this.e;
        if (hVar == t1.h.SHOWING) {
            a(t1.h.FAILED);
            v vVar = this.d;
            if (vVar != null) {
                vVar.j.a(j(), i, str, "");
            }
            ((w) this.b).a(new IronSourceError(i, str), this);
            return;
        }
        String a2 = a(hVar, i, str);
        ironLog.error(a(a2));
        v vVar2 = this.d;
        if (vVar2 != null) {
            vVar2.k.o(a2);
        }
    }

    public boolean A() {
        if (this.k == null || !x()) {
            return false;
        }
        try {
            BaseAdAdapter<?, AdapterAdListener> baseAdAdapter = this.c;
            if (baseAdAdapter instanceof AdapterAdFullScreenInterface) {
                return ((AdapterAdFullScreenInterface) baseAdAdapter).isAdAvailable(this.k);
            }
            IronLog.INTERNAL.error(a("isReadyToShow - adapter not instance of AdapterAdFullScreenInterface"));
            v vVar = this.d;
            if (vVar != null) {
                vVar.k.c("isReadyToShow - adapter not instance of AdapterAdFullScreenInterface");
            }
            return false;
        } catch (Throwable th) {
            String str = "isReadyToShow - exception = " + th.getMessage() + " - state = " + this.e;
            IronLog.INTERNAL.error(a(str));
            v vVar2 = this.d;
            if (vVar2 != null) {
                vVar2.k.c(str);
            }
        }
    }

    public void a(Activity activity, Placement placement) {
        IronLog ironLog = IronLog.INTERNAL;
        ironLog.verbose(a("placementName = " + placement.getPlacementName()));
        try {
            this.g = placement;
            a(t1.h.SHOWING);
            this.d.j.a(activity, j());
            BaseAdAdapter<?, AdapterAdListener> baseAdAdapter = this.c;
            if (baseAdAdapter instanceof AdapterAdFullScreenInterface) {
                ((AdapterAdFullScreenInterface) baseAdAdapter).showAd(this.k, this);
                return;
            }
            ironLog.error(a("showAd - adapter not instance of AdapterAdFullScreenInterface"));
            v vVar = this.d;
            if (vVar != null) {
                vVar.k.c("showAd - adapter not instance of AdapterAdFullScreenInterface");
            }
        } catch (Throwable th) {
            a(t1.h.FAILED);
            String str = "showAd - exception = " + th.getMessage() + " - state = " + this.e;
            IronLog.INTERNAL.error(a(str));
            v vVar2 = this.d;
            if (vVar2 != null) {
                vVar2.k.c(str);
            }
            onAdShowFailed(s.h(this.a.a()), str);
        }
    }

    public void b(boolean z) {
        v vVar = this.d;
        if (vVar != null) {
            vVar.j.a(z);
        }
    }

    public void onAdClosed() {
        if (!t().c()) {
            O();
        } else {
            t().a(new a());
        }
    }

    public void onAdEnded() {
        if (!t().c()) {
            P();
        } else {
            t().a(new c());
        }
    }

    public void onAdShowFailed(int i, String str) {
        if (!t().c()) {
            b(i, str);
        } else {
            t().a(new f(i, str));
        }
    }

    public void onAdShowSuccess() {
        if (!t().c()) {
            Q();
        } else {
            t().a(new e());
        }
    }

    public void onAdStarted() {
        if (!t().c()) {
            R();
        } else {
            t().a(new b());
        }
    }

    public void onAdVisible() {
        if (!t().c()) {
            S();
        } else {
            t().a(new d());
        }
    }
}
