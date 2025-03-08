package com.ironsource;

import android.app.Activity;
import com.ironsource.environment.ContextProvider;
import com.ironsource.mediationsdk.IronSourceSegment;
import com.ironsource.mediationsdk.adunit.adapter.internal.listener.AdapterAdInteractionListener;
import com.ironsource.mediationsdk.h;
import com.ironsource.mediationsdk.logger.IronLog;
import com.ironsource.mediationsdk.logger.IronSourceError;
import com.ironsource.mediationsdk.model.Placement;
import com.ironsource.mediationsdk.utils.IronSourceUtils;
import com.ironsource.p1;
import com.ironsource.q1;
import java.util.List;

public abstract class o1<Smash extends p1<?>, Listener extends AdapterAdInteractionListener> extends q1<Smash, Listener> implements w {

    class a extends cb {
        final /* synthetic */ Activity a;
        final /* synthetic */ Placement b;

        a(Activity activity, Placement placement) {
            this.a = activity;
            this.b = placement;
        }

        public void a() {
            o1.this.b(this.a, this.b);
        }
    }

    protected o1(l lVar, k8 k8Var, IronSourceSegment ironSourceSegment, boolean z) {
        super(lVar, k8Var, ironSourceSegment, z);
    }

    private String a(List<Smash> list) {
        StringBuilder sb = new StringBuilder();
        for (Smash smash : list) {
            if (smash.e() != null) {
                sb.append(smash.c());
                sb.append(":");
                sb.append(smash.e());
                sb.append(",");
            }
        }
        return sb.toString();
    }

    private void a(Activity activity, p1<?> p1Var, Placement placement) {
        if (this.o.h().e()) {
            this.r.a();
        }
        p1Var.a(activity, placement);
    }

    private void a(IronSourceError ironSourceError, p1<?> p1Var, String str) {
        this.s.j.a(k(), ironSourceError.getErrorCode(), ironSourceError.getErrorMessage(), str);
        this.q.e();
        this.t.a(ironSourceError, p1Var != null ? p1Var.f() : null);
        if (this.o.h().e()) {
            b(false);
        }
    }

    private void a(IronSourceError ironSourceError, String str) {
        a(ironSourceError, (p1<?>) null, str);
    }

    private void a(Smash smash, List<Smash> list) {
        for (Smash smash2 : list) {
            if (smash == null || smash2 != smash) {
                smash2.b(false);
                IronLog ironLog = IronLog.INTERNAL;
                ironLog.verbose(b(smash2.k() + " - not ready to show"));
            } else {
                smash.b(true);
                return;
            }
        }
    }

    /* JADX WARNING: type inference failed for: r2v7, types: [com.ironsource.t1] */
    /* access modifiers changed from: private */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void b(android.app.Activity r8, com.ironsource.mediationsdk.model.Placement r9) {
        /*
            r7 = this;
            java.lang.String r0 = "placement "
            com.ironsource.mediationsdk.logger.IronLog r1 = com.ironsource.mediationsdk.logger.IronLog.INTERNAL
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            java.lang.String r3 = "state = "
            r2.<init>(r3)
            com.ironsource.q1$f r3 = r7.p
            r2.append(r3)
            java.lang.String r2 = r2.toString()
            java.lang.String r2 = r7.b((java.lang.String) r2)
            r1.verbose(r2)
            java.lang.Object r1 = r7.x
            monitor-enter(r1)
            r7.i = r9     // Catch:{ all -> 0x00f9 }
            com.ironsource.v r2 = r7.s     // Catch:{ all -> 0x00f9 }
            com.ironsource.k r2 = r2.j     // Catch:{ all -> 0x00f9 }
            java.lang.String r3 = r7.k()     // Catch:{ all -> 0x00f9 }
            r2.a((android.app.Activity) r8, (java.lang.String) r3)     // Catch:{ all -> 0x00f9 }
            com.ironsource.q1$f r2 = r7.p     // Catch:{ all -> 0x00f9 }
            com.ironsource.q1$f r3 = com.ironsource.q1.f.SHOWING     // Catch:{ all -> 0x00f9 }
            r4 = 0
            if (r2 != r3) goto L_0x0044
            java.lang.String r9 = "can't show ad while an ad is already showing"
            com.ironsource.mediationsdk.logger.IronSourceError r0 = new com.ironsource.mediationsdk.logger.IronSourceError     // Catch:{ all -> 0x00f9 }
            com.ironsource.l r2 = r7.o     // Catch:{ all -> 0x00f9 }
            com.ironsource.mediationsdk.IronSource$AD_UNIT r2 = r2.b()     // Catch:{ all -> 0x00f9 }
            int r2 = com.ironsource.s.g(r2)     // Catch:{ all -> 0x00f9 }
            r0.<init>(r2, r9)     // Catch:{ all -> 0x00f9 }
            goto L_0x00a4
        L_0x0044:
            com.ironsource.q1$f r5 = com.ironsource.q1.f.READY_TO_SHOW     // Catch:{ all -> 0x00f9 }
            if (r2 == r5) goto L_0x0052
            java.lang.String r9 = "show called while no ads are available"
            com.ironsource.mediationsdk.logger.IronSourceError r0 = new com.ironsource.mediationsdk.logger.IronSourceError     // Catch:{ all -> 0x00f9 }
            r2 = 509(0x1fd, float:7.13E-43)
            r0.<init>(r2, r9)     // Catch:{ all -> 0x00f9 }
            goto L_0x00a4
        L_0x0052:
            if (r9 != 0) goto L_0x0066
            java.lang.String r9 = "empty default placement"
            com.ironsource.mediationsdk.logger.IronSourceError r0 = new com.ironsource.mediationsdk.logger.IronSourceError     // Catch:{ all -> 0x00f9 }
            com.ironsource.l r2 = r7.o     // Catch:{ all -> 0x00f9 }
            com.ironsource.mediationsdk.IronSource$AD_UNIT r2 = r2.b()     // Catch:{ all -> 0x00f9 }
            int r2 = com.ironsource.s.b(r2)     // Catch:{ all -> 0x00f9 }
            r0.<init>(r2, r9)     // Catch:{ all -> 0x00f9 }
            goto L_0x00a4
        L_0x0066:
            com.ironsource.environment.ContextProvider r2 = com.ironsource.environment.ContextProvider.getInstance()     // Catch:{ all -> 0x00f9 }
            android.content.Context r2 = r2.getApplicationContext()     // Catch:{ all -> 0x00f9 }
            java.lang.String r5 = r9.getPlacementName()     // Catch:{ all -> 0x00f9 }
            com.ironsource.l r6 = r7.o     // Catch:{ all -> 0x00f9 }
            com.ironsource.mediationsdk.IronSource$AD_UNIT r6 = r6.b()     // Catch:{ all -> 0x00f9 }
            boolean r2 = com.ironsource.mediationsdk.utils.b.b((android.content.Context) r2, (java.lang.String) r5, (com.ironsource.mediationsdk.IronSource.AD_UNIT) r6)     // Catch:{ all -> 0x00f9 }
            if (r2 == 0) goto L_0x00a3
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x00f9 }
            r2.<init>(r0)     // Catch:{ all -> 0x00f9 }
            java.lang.String r9 = r9.getPlacementName()     // Catch:{ all -> 0x00f9 }
            r2.append(r9)     // Catch:{ all -> 0x00f9 }
            java.lang.String r9 = " is capped"
            r2.append(r9)     // Catch:{ all -> 0x00f9 }
            java.lang.String r9 = r2.toString()     // Catch:{ all -> 0x00f9 }
            com.ironsource.mediationsdk.logger.IronSourceError r0 = new com.ironsource.mediationsdk.logger.IronSourceError     // Catch:{ all -> 0x00f9 }
            com.ironsource.l r2 = r7.o     // Catch:{ all -> 0x00f9 }
            com.ironsource.mediationsdk.IronSource$AD_UNIT r2 = r2.b()     // Catch:{ all -> 0x00f9 }
            int r2 = com.ironsource.s.f(r2)     // Catch:{ all -> 0x00f9 }
            r0.<init>(r2, r9)     // Catch:{ all -> 0x00f9 }
            goto L_0x00a4
        L_0x00a3:
            r0 = r4
        L_0x00a4:
            if (r0 == 0) goto L_0x00b9
            com.ironsource.mediationsdk.logger.IronLog r9 = com.ironsource.mediationsdk.logger.IronLog.API     // Catch:{ all -> 0x00f9 }
            java.lang.String r2 = r0.getErrorMessage()     // Catch:{ all -> 0x00f9 }
            java.lang.String r2 = r7.b((java.lang.String) r2)     // Catch:{ all -> 0x00f9 }
            r9.error(r2)     // Catch:{ all -> 0x00f9 }
            java.lang.String r9 = ""
        L_0x00b5:
            r7.a((com.ironsource.mediationsdk.logger.IronSourceError) r0, (java.lang.String) r9)     // Catch:{ all -> 0x00f9 }
            goto L_0x00f0
        L_0x00b9:
            com.ironsource.zc<Smash> r9 = r7.a     // Catch:{ all -> 0x00f9 }
            java.util.List r9 = r9.b()     // Catch:{ all -> 0x00f9 }
            com.ironsource.cd r0 = new com.ironsource.cd     // Catch:{ all -> 0x00f9 }
            com.ironsource.l r2 = r7.o     // Catch:{ all -> 0x00f9 }
            r0.<init>(r2)     // Catch:{ all -> 0x00f9 }
            com.ironsource.t1 r2 = r0.c(r9)     // Catch:{ all -> 0x00f9 }
            r4 = r2
            com.ironsource.p1 r4 = (com.ironsource.p1) r4     // Catch:{ all -> 0x00f9 }
            java.util.List r0 = r0.b(r9)     // Catch:{ all -> 0x00f9 }
            r7.a(r4, r0)     // Catch:{ all -> 0x00f9 }
            if (r4 == 0) goto L_0x00dd
            r7.a((com.ironsource.q1.f) r3)     // Catch:{ all -> 0x00f9 }
            r7.i(r4)     // Catch:{ all -> 0x00f9 }
            goto L_0x00f0
        L_0x00dd:
            com.ironsource.l r0 = r7.o     // Catch:{ all -> 0x00f9 }
            com.ironsource.mediationsdk.IronSource$AD_UNIT r0 = r0.b()     // Catch:{ all -> 0x00f9 }
            java.lang.String r0 = r0.toString()     // Catch:{ all -> 0x00f9 }
            com.ironsource.mediationsdk.logger.IronSourceError r0 = com.ironsource.mediationsdk.utils.ErrorBuilder.buildNoAdsToShowError(r0)     // Catch:{ all -> 0x00f9 }
            java.lang.String r9 = r7.a(r9)     // Catch:{ all -> 0x00f9 }
            goto L_0x00b5
        L_0x00f0:
            monitor-exit(r1)     // Catch:{ all -> 0x00f9 }
            if (r4 == 0) goto L_0x00f8
            com.ironsource.mediationsdk.model.Placement r9 = r7.i
            r7.a((android.app.Activity) r8, (com.ironsource.p1<?>) r4, (com.ironsource.mediationsdk.model.Placement) r9)
        L_0x00f8:
            return
        L_0x00f9:
            r8 = move-exception
            monitor-exit(r1)     // Catch:{ all -> 0x00f9 }
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ironsource.o1.b(android.app.Activity, com.ironsource.mediationsdk.model.Placement):void");
    }

    public void a(Activity activity, Placement placement) {
        if (!c()) {
            b(activity, placement);
        } else {
            a((Runnable) new a(activity, placement));
        }
    }

    public void a(IronSourceError ironSourceError, p1<?> p1Var) {
        IronLog ironLog = IronLog.INTERNAL;
        ironLog.verbose(b(p1Var.k() + " - error = " + ironSourceError));
        this.b.put(p1Var.c(), h.a.ISAuctionPerformanceFailedToShow);
        a(q1.f.READY_TO_LOAD);
        a(ironSourceError, p1Var, "");
    }

    public void a(p1<?> p1Var) {
        IronLog.INTERNAL.verbose(b(p1Var.k()));
        if (this.p == q1.f.SHOWING) {
            a(q1.f.READY_TO_LOAD);
        }
        this.q.d();
        this.t.a(p1Var.f());
    }

    public void b(p1<?> p1Var) {
        IronLog.INTERNAL.verbose(b(p1Var.k()));
        this.t.g(p1Var.f());
    }

    public void c(p1<?> p1Var) {
        IronLog.INTERNAL.verbose(b(p1Var.k()));
        this.t.a();
    }

    public String d() {
        StringBuilder sb = new StringBuilder();
        if (this.p == q1.f.READY_TO_SHOW) {
            for (Smash smash : this.a.b()) {
                if (smash.x()) {
                    sb.append(smash.c());
                    sb.append(";");
                }
            }
        }
        return sb.toString();
    }

    public void d(p1<?> p1Var) {
        IronLog.INTERNAL.verbose(b(p1Var.k()));
        this.t.b();
    }

    public boolean q() {
        if (!t()) {
            return false;
        }
        if (this.j && !IronSourceUtils.isNetworkConnected(ContextProvider.getInstance().getApplicationContext())) {
            return false;
        }
        for (Smash A : this.a.b()) {
            if (A.A()) {
                return true;
            }
        }
        return false;
    }

    /* access modifiers changed from: protected */
    public boolean r() {
        return false;
    }
}
