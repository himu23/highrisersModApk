package com.ironsource;

import android.text.TextUtils;
import com.ironsource.a0;
import com.ironsource.environment.ContextProvider;
import com.ironsource.kb;
import com.ironsource.mediationsdk.IronSource;
import com.ironsource.mediationsdk.adunit.adapter.internal.AdapterAdFullScreenInterface;
import com.ironsource.mediationsdk.adunit.adapter.internal.AdapterBaseInterface;
import com.ironsource.mediationsdk.adunit.adapter.internal.BaseAdAdapter;
import com.ironsource.mediationsdk.adunit.adapter.internal.listener.AdapterAdListener;
import com.ironsource.mediationsdk.adunit.adapter.listener.NetworkInitializationListener;
import com.ironsource.mediationsdk.adunit.adapter.utility.AdData;
import com.ironsource.mediationsdk.adunit.adapter.utility.AdInfo;
import com.ironsource.mediationsdk.adunit.adapter.utility.AdapterErrorType;
import com.ironsource.mediationsdk.logger.IronLog;
import com.ironsource.mediationsdk.logger.IronSourceError;
import com.ironsource.mediationsdk.model.NetworkSettings;
import com.ironsource.mediationsdk.model.Placement;
import com.ironsource.mediationsdk.utils.IronSourceConstants;
import com.ironsource.nb;
import com.ironsource.v;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;

public abstract class t1<Listener extends a0> implements NetworkInitializationListener, nb.a, u, AdapterAdListener, kb.a {
    protected p a;
    protected Listener b;
    protected BaseAdAdapter<?, AdapterAdListener> c;
    protected v d;
    protected h e;
    private AtomicBoolean f = new AtomicBoolean(false);
    protected Placement g;
    protected h0 h;
    protected JSONObject i;
    protected String j;
    protected AdData k;
    protected Long l;
    protected r3 m;
    private nb n;
    private final d1 o;
    private final ia p;
    protected final Object q;

    class a extends cb {
        a() {
        }

        public void a() {
            t1.this.K();
        }
    }

    class b extends cb {
        b() {
        }

        public void a() {
            t1.this.J();
        }
    }

    class c extends cb {
        final /* synthetic */ int a;
        final /* synthetic */ String b;

        c(int i, String str) {
            this.a = i;
            this.b = str;
        }

        public void a() {
            t1.this.a(this.a, this.b);
        }
    }

    class d extends cb {
        d() {
        }

        public void a() {
            t1.this.H();
        }
    }

    class e extends cb {
        final /* synthetic */ AdapterErrorType a;
        final /* synthetic */ int b;
        final /* synthetic */ String c;

        e(AdapterErrorType adapterErrorType, int i, String str) {
            this.a = adapterErrorType;
            this.b = i;
            this.c = str;
        }

        public void a() {
            t1.this.a(this.a, this.b, this.c);
        }
    }

    class f extends cb {
        f() {
        }

        public void a() {
            t1.this.I();
        }
    }

    class g extends cb {
        g() {
        }

        public void a() {
            t1.this.G();
        }
    }

    protected enum h {
        NONE,
        INIT_IN_PROGRESS,
        READY_TO_LOAD,
        LOADING,
        LOADED,
        SHOWING,
        FAILED
    }

    public t1(ia iaVar, p pVar, BaseAdAdapter<?, ?> baseAdAdapter, h0 h0Var, d1 d1Var, Listener listener) {
        this.a = pVar;
        this.b = listener;
        this.d = new v(pVar.a(), v.b.PROVIDER, this);
        this.h = h0Var;
        this.i = h0Var.c();
        this.c = baseAdAdapter;
        this.o = d1Var;
        this.p = iaVar;
        this.n = new nb(TimeUnit.SECONDS.toMillis((long) s()));
        this.q = new Object();
        a(h.NONE);
    }

    private boolean C() {
        return this.e == h.INIT_IN_PROGRESS;
    }

    private void E() {
        IronLog.INTERNAL.verbose(d());
        a(h.LOADING);
        a(false);
        try {
            this.n.a(this);
            F();
        } catch (Throwable th) {
            String str = "unexpected error while calling adapter.loadAd() - " + th.getMessage() + " - state = " + this.e;
            IronLog.INTERNAL.error(a(str));
            v vVar = this.d;
            if (vVar != null) {
                vVar.k.c(str);
            }
            onAdLoadFailed(AdapterErrorType.ADAPTER_ERROR_TYPE_INTERNAL, 510, str);
        }
    }

    /* access modifiers changed from: private */
    public void G() {
        IronLog.INTERNAL.verbose(d());
        v vVar = this.d;
        if (vVar != null) {
            vVar.j.a(j());
        }
        this.b.f(this);
    }

    /* access modifiers changed from: private */
    public void H() {
        boolean z;
        IronLog ironLog = IronLog.INTERNAL;
        ironLog.verbose(d());
        nb nbVar = this.n;
        if (nbVar != null) {
            nbVar.e();
        }
        synchronized (this.q) {
            h hVar = this.e;
            z = false;
            if (hVar == h.LOADING) {
                long a2 = r3.a(this.m);
                ironLog.verbose(a("Load duration = " + a2));
                if (this.d != null) {
                    if (u()) {
                        this.d.g.a(a2);
                    } else {
                        this.d.g.a(a2, false);
                    }
                }
                a(h.LOADED);
                z = N();
            } else if (hVar != h.FAILED) {
                ironLog.error(a(String.format("unexpected load success for %s, state - %s", new Object[]{k(), this.e})));
                String format = String.format("unexpected load success, state - %s", new Object[]{this.e});
                if (this.d != null) {
                    if (u()) {
                        this.d.k.n(format);
                    } else {
                        this.d.k.k(format);
                    }
                }
            }
        }
        if (z) {
            this.b.e(this);
        }
    }

    /* access modifiers changed from: private */
    public void I() {
        IronLog.INTERNAL.verbose(d());
        a(h.SHOWING);
        v vVar = this.d;
        if (vVar != null) {
            vVar.j.e(j());
        }
        this.b.b(this);
    }

    /* access modifiers changed from: private */
    public void J() {
        IronLog ironLog = IronLog.INTERNAL;
        ironLog.verbose(d());
        if (C()) {
            nb nbVar = this.n;
            if (nbVar != null) {
                nbVar.e();
            }
            a(h.READY_TO_LOAD);
            E();
        } else if (this.e != h.FAILED) {
            ironLog.error(a(String.format("unexpected init success for %s, state - %s", new Object[]{k(), this.e})));
            if (this.d != null) {
                this.d.k.i(String.format("unexpected init success, state - %s", new Object[]{this.e}));
            }
        }
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:10:0x005f, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x00a1, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0056, code lost:
        r9.b.a(com.ironsource.mediationsdk.utils.ErrorBuilder.buildLoadFailedError("time out"), r9);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void K() {
        /*
            r9 = this;
            com.ironsource.r3 r0 = r9.m
            long r0 = com.ironsource.r3.a(r0)
            com.ironsource.mediationsdk.logger.IronLog r2 = com.ironsource.mediationsdk.logger.IronLog.INTERNAL
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            java.lang.String r4 = "Load duration = "
            r3.<init>(r4)
            r3.append(r0)
            java.lang.String r4 = ", state = "
            r3.append(r4)
            com.ironsource.t1$h r4 = r9.e
            r3.append(r4)
            java.lang.String r4 = ", isBidder = "
            r3.append(r4)
            boolean r4 = r9.v()
            r3.append(r4)
            java.lang.String r3 = r3.toString()
            java.lang.String r3 = r9.a((java.lang.String) r3)
            r2.verbose(r3)
            java.lang.String r3 = "time out"
            java.lang.Object r4 = r9.q
            monitor-enter(r4)
            boolean r5 = r9.y()     // Catch:{ all -> 0x00a2 }
            r6 = 1025(0x401, float:1.436E-42)
            if (r5 == 0) goto L_0x0060
            com.ironsource.t1$h r2 = com.ironsource.t1.h.FAILED     // Catch:{ all -> 0x00a2 }
            r9.a((com.ironsource.t1.h) r2)     // Catch:{ all -> 0x00a2 }
            com.ironsource.v r2 = r9.d     // Catch:{ all -> 0x00a2 }
            if (r2 == 0) goto L_0x0055
            com.ironsource.r8 r2 = r2.g     // Catch:{ all -> 0x00a2 }
            r2.a((long) r0, (int) r6)     // Catch:{ all -> 0x00a2 }
            com.ironsource.v r2 = r9.d     // Catch:{ all -> 0x00a2 }
            com.ironsource.r8 r2 = r2.g     // Catch:{ all -> 0x00a2 }
            r2.a((long) r0, (int) r6, (java.lang.String) r3)     // Catch:{ all -> 0x00a2 }
        L_0x0055:
            monitor-exit(r4)     // Catch:{ all -> 0x00a2 }
            Listener r0 = r9.b
            com.ironsource.mediationsdk.logger.IronSourceError r1 = com.ironsource.mediationsdk.utils.ErrorBuilder.buildLoadFailedError(r3)
            r0.a(r1, r9)
            return
        L_0x0060:
            java.lang.String r0 = "unexpected timeout for %s, state - %s, error - %s"
            r1 = 3
            java.lang.Object[] r1 = new java.lang.Object[r1]     // Catch:{ all -> 0x00a2 }
            java.lang.String r3 = r9.k()     // Catch:{ all -> 0x00a2 }
            r5 = 0
            r1[r5] = r3     // Catch:{ all -> 0x00a2 }
            com.ironsource.t1$h r3 = r9.e     // Catch:{ all -> 0x00a2 }
            r7 = 1
            r1[r7] = r3     // Catch:{ all -> 0x00a2 }
            java.lang.Integer r3 = java.lang.Integer.valueOf(r6)     // Catch:{ all -> 0x00a2 }
            r8 = 2
            r1[r8] = r3     // Catch:{ all -> 0x00a2 }
            java.lang.String r0 = java.lang.String.format(r0, r1)     // Catch:{ all -> 0x00a2 }
            java.lang.String r0 = r9.a((java.lang.String) r0)     // Catch:{ all -> 0x00a2 }
            r2.error(r0)     // Catch:{ all -> 0x00a2 }
            com.ironsource.v r0 = r9.d     // Catch:{ all -> 0x00a2 }
            if (r0 == 0) goto L_0x00a0
            java.lang.String r0 = "unexpected timeout, state - %s, error - %s"
            java.lang.Object[] r1 = new java.lang.Object[r8]     // Catch:{ all -> 0x00a2 }
            com.ironsource.t1$h r2 = r9.e     // Catch:{ all -> 0x00a2 }
            r1[r5] = r2     // Catch:{ all -> 0x00a2 }
            java.lang.Integer r2 = java.lang.Integer.valueOf(r6)     // Catch:{ all -> 0x00a2 }
            r1[r7] = r2     // Catch:{ all -> 0x00a2 }
            java.lang.String r0 = java.lang.String.format(r0, r1)     // Catch:{ all -> 0x00a2 }
            com.ironsource.v r1 = r9.d     // Catch:{ all -> 0x00a2 }
            com.ironsource.oc r1 = r1.k     // Catch:{ all -> 0x00a2 }
            r1.p(r0)     // Catch:{ all -> 0x00a2 }
        L_0x00a0:
            monitor-exit(r4)     // Catch:{ all -> 0x00a2 }
            return
        L_0x00a2:
            r0 = move-exception
            monitor-exit(r4)     // Catch:{ all -> 0x00a2 }
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ironsource.t1.K():void");
    }

    /* access modifiers changed from: private */
    public void a(int i2, String str) {
        IronLog ironLog = IronLog.INTERNAL;
        ironLog.verbose(a("error = " + i2 + ", " + str));
        if (C()) {
            nb nbVar = this.n;
            if (nbVar != null) {
                nbVar.e();
            }
            a(h.FAILED);
            a(AdapterErrorType.ADAPTER_ERROR_TYPE_INTERNAL, i2, str, r3.a(this.m));
            this.b.a(new IronSourceError(i2, str), this);
        } else if (this.e != h.FAILED) {
            ironLog.error(a(String.format("unexpected init failed for %s, state - %s, error - %s, %s", new Object[]{k(), this.e, Integer.valueOf(i2), str})));
            if (this.d != null) {
                this.d.k.h(String.format("unexpected init failed, state - %s, error - %s, %s", new Object[]{this.e, Integer.valueOf(i2), str}));
            }
        }
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x00a8, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:38:0x010a, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void a(com.ironsource.mediationsdk.adunit.adapter.utility.AdapterErrorType r9, int r10, java.lang.String r11) {
        /*
            r8 = this;
            com.ironsource.r3 r0 = r8.m
            long r5 = com.ironsource.r3.a(r0)
            com.ironsource.mediationsdk.logger.IronLog r0 = com.ironsource.mediationsdk.logger.IronLog.INTERNAL
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            java.lang.String r2 = "Load duration = "
            r1.<init>(r2)
            r1.append(r5)
            java.lang.String r2 = ", error = "
            r1.append(r2)
            r1.append(r10)
            java.lang.String r2 = ", "
            r1.append(r2)
            r1.append(r11)
            java.lang.String r1 = r1.toString()
            java.lang.String r1 = r8.a((java.lang.String) r1)
            r0.verbose(r1)
            com.ironsource.nb r1 = r8.n
            if (r1 == 0) goto L_0x0034
            r1.e()
        L_0x0034:
            java.lang.Object r7 = r8.q
            monitor-enter(r7)
            com.ironsource.t1$h r1 = r8.e     // Catch:{ all -> 0x010b }
            com.ironsource.t1$h r2 = com.ironsource.t1.h.LOADING     // Catch:{ all -> 0x010b }
            if (r1 != r2) goto L_0x0055
            r1 = r8
            r2 = r9
            r3 = r10
            r4 = r11
            r1.a((com.ironsource.mediationsdk.adunit.adapter.utility.AdapterErrorType) r2, (int) r3, (java.lang.String) r4, (long) r5)     // Catch:{ all -> 0x010b }
            com.ironsource.t1$h r9 = com.ironsource.t1.h.FAILED     // Catch:{ all -> 0x010b }
            r8.a((com.ironsource.t1.h) r9)     // Catch:{ all -> 0x010b }
            monitor-exit(r7)     // Catch:{ all -> 0x010b }
            Listener r9 = r8.b
            com.ironsource.mediationsdk.logger.IronSourceError r0 = new com.ironsource.mediationsdk.logger.IronSourceError
            r0.<init>(r10, r11)
            r9.a(r0, r8)
            return
        L_0x0055:
            com.ironsource.t1$h r2 = com.ironsource.t1.h.FAILED     // Catch:{ all -> 0x010b }
            if (r1 != r2) goto L_0x0062
            r1 = r8
            r2 = r9
            r3 = r10
            r4 = r11
            r1.a((com.ironsource.mediationsdk.adunit.adapter.utility.AdapterErrorType) r2, (int) r3, (java.lang.String) r4, (long) r5)     // Catch:{ all -> 0x010b }
            monitor-exit(r7)     // Catch:{ all -> 0x010b }
            return
        L_0x0062:
            com.ironsource.t1$h r2 = com.ironsource.t1.h.LOADED     // Catch:{ all -> 0x010b }
            r3 = 2
            r4 = 1
            r5 = 0
            if (r1 != r2) goto L_0x00a9
            com.ironsource.mediationsdk.adunit.adapter.utility.AdapterErrorType r1 = com.ironsource.mediationsdk.adunit.adapter.utility.AdapterErrorType.ADAPTER_ERROR_TYPE_AD_EXPIRED     // Catch:{ all -> 0x010b }
            if (r9 != r1) goto L_0x00a9
            long r9 = java.lang.System.currentTimeMillis()     // Catch:{ all -> 0x010b }
            java.lang.Long r9 = java.lang.Long.valueOf(r9)     // Catch:{ all -> 0x010b }
            r8.l = r9     // Catch:{ all -> 0x010b }
            java.lang.String r9 = "ad expired for %s, state = %s"
            java.lang.Object[] r10 = new java.lang.Object[r3]     // Catch:{ all -> 0x010b }
            com.ironsource.h0 r11 = r8.h     // Catch:{ all -> 0x010b }
            java.lang.String r11 = r11.f()     // Catch:{ all -> 0x010b }
            r10[r5] = r11     // Catch:{ all -> 0x010b }
            com.ironsource.t1$h r11 = r8.e     // Catch:{ all -> 0x010b }
            r10[r4] = r11     // Catch:{ all -> 0x010b }
            java.lang.String r9 = java.lang.String.format(r9, r10)     // Catch:{ all -> 0x010b }
            java.lang.String r9 = r8.a((java.lang.String) r9)     // Catch:{ all -> 0x010b }
            r0.error(r9)     // Catch:{ all -> 0x010b }
            com.ironsource.v r9 = r8.d     // Catch:{ all -> 0x010b }
            if (r9 == 0) goto L_0x00a7
            com.ironsource.oc r9 = r9.k     // Catch:{ all -> 0x010b }
            java.lang.String r10 = "ad expired, state = %s"
            java.lang.Object[] r11 = new java.lang.Object[r4]     // Catch:{ all -> 0x010b }
            com.ironsource.t1$h r0 = r8.e     // Catch:{ all -> 0x010b }
            r11[r5] = r0     // Catch:{ all -> 0x010b }
            java.lang.String r10 = java.lang.String.format(r10, r11)     // Catch:{ all -> 0x010b }
            r9.a(r10)     // Catch:{ all -> 0x010b }
        L_0x00a7:
            monitor-exit(r7)     // Catch:{ all -> 0x010b }
            return
        L_0x00a9:
            java.lang.String r9 = "unexpected load failed for %s, state - %s, error - %s, %s"
            r1 = 4
            java.lang.Object[] r1 = new java.lang.Object[r1]     // Catch:{ all -> 0x010b }
            java.lang.String r2 = r8.k()     // Catch:{ all -> 0x010b }
            r1[r5] = r2     // Catch:{ all -> 0x010b }
            com.ironsource.t1$h r2 = r8.e     // Catch:{ all -> 0x010b }
            r1[r4] = r2     // Catch:{ all -> 0x010b }
            java.lang.Integer r2 = java.lang.Integer.valueOf(r10)     // Catch:{ all -> 0x010b }
            r1[r3] = r2     // Catch:{ all -> 0x010b }
            r2 = 3
            r1[r2] = r11     // Catch:{ all -> 0x010b }
            java.lang.String r9 = java.lang.String.format(r9, r1)     // Catch:{ all -> 0x010b }
            java.lang.String r9 = r8.a((java.lang.String) r9)     // Catch:{ all -> 0x010b }
            r0.error(r9)     // Catch:{ all -> 0x010b }
            java.lang.String r9 = "unexpected load failed, state - %s, error - %s, %s"
            java.lang.Object[] r0 = new java.lang.Object[r2]     // Catch:{ all -> 0x010b }
            com.ironsource.t1$h r1 = r8.e     // Catch:{ all -> 0x010b }
            r0[r5] = r1     // Catch:{ all -> 0x010b }
            java.lang.Integer r10 = java.lang.Integer.valueOf(r10)     // Catch:{ all -> 0x010b }
            r0[r4] = r10     // Catch:{ all -> 0x010b }
            r0[r3] = r11     // Catch:{ all -> 0x010b }
            java.lang.String r9 = java.lang.String.format(r9, r0)     // Catch:{ all -> 0x010b }
            com.ironsource.v r10 = r8.d     // Catch:{ all -> 0x010b }
            if (r10 == 0) goto L_0x0109
            boolean r10 = r8.u()     // Catch:{ all -> 0x010b }
            if (r10 == 0) goto L_0x00f2
            com.ironsource.v r10 = r8.d     // Catch:{ all -> 0x010b }
            com.ironsource.oc r10 = r10.k     // Catch:{ all -> 0x010b }
            r10.m(r9)     // Catch:{ all -> 0x010b }
            goto L_0x0109
        L_0x00f2:
            com.ironsource.p r10 = r8.a     // Catch:{ all -> 0x010b }
            com.ironsource.mediationsdk.IronSource$AD_UNIT r10 = r10.a()     // Catch:{ all -> 0x010b }
            com.ironsource.mediationsdk.IronSource$AD_UNIT r11 = com.ironsource.mediationsdk.IronSource.AD_UNIT.REWARDED_VIDEO     // Catch:{ all -> 0x010b }
            if (r10 != r11) goto L_0x0102
            com.ironsource.t1$h r10 = r8.e     // Catch:{ all -> 0x010b }
            com.ironsource.t1$h r11 = com.ironsource.t1.h.SHOWING     // Catch:{ all -> 0x010b }
            if (r10 == r11) goto L_0x0109
        L_0x0102:
            com.ironsource.v r10 = r8.d     // Catch:{ all -> 0x010b }
            com.ironsource.oc r10 = r10.k     // Catch:{ all -> 0x010b }
            r10.j(r9)     // Catch:{ all -> 0x010b }
        L_0x0109:
            monitor-exit(r7)     // Catch:{ all -> 0x010b }
            return
        L_0x010b:
            r9 = move-exception
            monitor-exit(r7)     // Catch:{ all -> 0x010b }
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ironsource.t1.a(com.ironsource.mediationsdk.adunit.adapter.utility.AdapterErrorType, int, java.lang.String):void");
    }

    private void a(AdapterErrorType adapterErrorType, int i2, String str, long j2) {
        if (this.d == null) {
            return;
        }
        if (adapterErrorType == AdapterErrorType.ADAPTER_ERROR_TYPE_NO_FILL) {
            if (u()) {
                this.d.g.c(j2, i2);
            } else {
                this.d.g.b(j2, i2);
            }
        } else if (TextUtils.isEmpty(str)) {
            this.d.g.a(j2, i2);
        } else if (u()) {
            this.d.g.b(j2, i2, str);
        } else {
            this.d.g.a(j2, i2, str);
        }
    }

    private boolean b(t tVar) {
        return tVar == t.LOAD_AD || tVar == t.LOAD_AD_SUCCESS || tVar == t.LOAD_AD_FAILED || tVar == t.LOAD_AD_FAILED_WITH_REASON || tVar == t.LOAD_AD_NO_FILL || tVar == t.AD_OPENED || tVar == t.AD_CLOSED || tVar == t.SHOW_AD || tVar == t.SHOW_AD_FAILED || tVar == t.AD_CLICKED || tVar == t.AD_REWARDED;
    }

    private int o() {
        return 1;
    }

    private int s() {
        d1 d1Var = this.o;
        if (d1Var == null) {
            return this.a.f();
        }
        Integer e2 = d1Var.e();
        int f2 = (e2 == null || e2.intValue() <= 0) ? this.a.f() : e2.intValue();
        IronLog ironLog = IronLog.INTERNAL;
        ironLog.verbose(a("Load timeout for " + this.o.c() + " - " + f2 + " seconds"));
        return f2;
    }

    public boolean A() {
        return x();
    }

    public boolean B() {
        return this.e == h.SHOWING;
    }

    public void D() {
        IronLog ironLog = IronLog.INTERNAL;
        ironLog.verbose(d());
        d1 i2 = i();
        String j2 = i2.j();
        Map<String, Object> a2 = g8.a(i2.a());
        a2.put("adUnit", this.a.a());
        b(j2);
        try {
            boolean z = false;
            if (u()) {
                this.d.g.a();
            } else {
                this.d.g.a(false);
            }
            this.l = null;
            this.m = new r3();
            this.k = a(j2, a2);
            synchronized (this.q) {
                if (this.e != h.NONE) {
                    z = true;
                } else {
                    a(h.INIT_IN_PROGRESS);
                }
            }
            if (z) {
                String str = "loadAd - incorrect state while loading, state = " + this.e;
                ironLog.error(a(str));
                this.d.k.c(str);
                onInitFailed(s.c(this.a.a()), str);
                return;
            }
            this.n.a(this);
            AdapterBaseInterface networkAdapter = this.c.getNetworkAdapter();
            if (networkAdapter != null) {
                networkAdapter.init(this.k, ContextProvider.getInstance().getApplicationContext(), this);
                return;
            }
            String str2 = "loadAd - network adapter not available " + k();
            ironLog.error(a(str2));
            onInitFailed(s.c(this.a.a()), str2);
        } catch (Throwable th) {
            String str3 = "loadAd - exception = " + th.getLocalizedMessage();
            IronLog.INTERNAL.error(a(str3));
            v vVar = this.d;
            if (vVar != null) {
                vVar.k.c(str3);
            }
            onInitFailed(s.c(this.a.a()), str3);
        }
    }

    /* access modifiers changed from: protected */
    public void F() {
        BaseAdAdapter<?, AdapterAdListener> baseAdAdapter = this.c;
        if (baseAdAdapter instanceof AdapterAdFullScreenInterface) {
            ((AdapterAdFullScreenInterface) baseAdAdapter).loadAd(this.k, ContextProvider.getInstance().getCurrentActiveActivity(), this);
        } else {
            IronLog.INTERNAL.error(a("adapter not instance of AdapterAdFullScreenInterface"));
        }
    }

    public void L() {
        BaseAdAdapter<?, AdapterAdListener> baseAdAdapter = this.c;
        if (baseAdAdapter != null) {
            try {
                baseAdAdapter.releaseMemory();
                this.c = null;
            } catch (Exception e2) {
                String str = "Exception while calling adapter.releaseMemory() from " + this.h.f() + " - " + e2.getMessage() + " - state = " + this.e;
                IronLog.INTERNAL.error(a(str));
                this.d.k.c(str);
            }
        }
        v vVar = this.d;
        if (vVar != null) {
            vVar.f();
            this.d = null;
        }
        nb nbVar = this.n;
        if (nbVar != null) {
            nbVar.d();
            this.n = null;
        }
    }

    public void M() {
        IronLog.INTERNAL.verbose(d());
        v vVar = this.d;
        if (vVar != null) {
            vVar.j.a();
        }
    }

    /* access modifiers changed from: protected */
    public boolean N() {
        return true;
    }

    /* access modifiers changed from: protected */
    public AdData a(String str, Map<String, Object> map) {
        return new AdData(str, q(), a(map));
    }

    /* access modifiers changed from: protected */
    public String a(String str) {
        String str2 = this.a.a().name() + " - " + k() + " - state = " + this.e;
        if (TextUtils.isEmpty(str)) {
            return str2;
        }
        return str2 + " - " + str;
    }

    public Map<String, Object> a(t tVar) {
        HashMap hashMap = new HashMap();
        try {
            BaseAdAdapter baseAdAdapter = this.c;
            String str = "";
            hashMap.put(IronSourceConstants.EVENTS_PROVIDER_ADAPTER_VERSION, baseAdAdapter != null ? baseAdAdapter.getNetworkAdapter().getAdapterVersion() : str);
            BaseAdAdapter baseAdAdapter2 = this.c;
            if (baseAdAdapter2 != null) {
                str = baseAdAdapter2.getNetworkAdapter().getNetworkSDKVersion();
            }
            hashMap.put(IronSourceConstants.EVENTS_PROVIDER_SDK_VERSION, str);
        } catch (Exception unused) {
            IronLog.INTERNAL.error(a("could not get adapter version for event data" + k()));
        }
        hashMap.put(IronSourceConstants.EVENTS_SUB_PROVIDER_ID, this.h.i());
        hashMap.put(IronSourceConstants.EVENTS_PROVIDER, this.h.a());
        hashMap.put("instanceType", Integer.valueOf(l()));
        hashMap.put(IronSourceConstants.EVENTS_PROGRAMMATIC, Integer.valueOf(o()));
        if (!TextUtils.isEmpty(this.j)) {
            hashMap.put(IronSourceConstants.EVENTS_DYNAMIC_DEMAND_SOURCE_ID, this.j);
        }
        hashMap.put("sessionDepth", r());
        if (this.a.e() != null && this.a.e().length() > 0) {
            hashMap.put("genericParams", this.a.e());
        }
        if (!TextUtils.isEmpty(this.a.c())) {
            hashMap.put("auctionId", this.a.c());
        }
        if (b(tVar)) {
            hashMap.put(IronSourceConstants.AUCTION_TRIALS, Integer.valueOf(this.a.d()));
            if (!TextUtils.isEmpty(this.a.b())) {
                hashMap.put(IronSourceConstants.AUCTION_FALLBACK, this.a.b());
            }
        }
        if (!TextUtils.isEmpty(this.a.g().getCustomNetwork())) {
            hashMap.put(IronSourceConstants.EVENTS_CUSTOM_NETWORK_FIELD, this.a.g().getCustomNetwork());
        }
        return hashMap;
    }

    /* access modifiers changed from: protected */
    public Map<String, Object> a(Map<String, Object> map) {
        if (map == null) {
            map = new HashMap<>();
        }
        map.put("userId", this.a.i());
        return map;
    }

    public void a() {
        if (!this.p.c()) {
            K();
        } else {
            this.p.a(new a());
        }
    }

    /* access modifiers changed from: protected */
    public void a(h hVar) {
        this.e = hVar;
    }

    public void a(boolean z) {
        this.f.set(z);
    }

    public int b() {
        return this.h.e();
    }

    public void b(String str) {
        this.j = com.ironsource.mediationsdk.d.c().d(str);
    }

    public String c() {
        return this.h.f();
    }

    /* access modifiers changed from: protected */
    public String d() {
        return a((String) null);
    }

    public Long e() {
        return this.l;
    }

    public AdInfo f() {
        return new AdInfo(this.o.a(j()));
    }

    public IronSource.AD_UNIT g() {
        return this.a.a();
    }

    public String h() {
        return this.a.c();
    }

    public d1 i() {
        return this.o;
    }

    /* access modifiers changed from: protected */
    public String j() {
        Placement placement = this.g;
        return placement == null ? "" : placement.getPlacementName();
    }

    public String k() {
        return String.format("%s %s", new Object[]{c(), Integer.valueOf(hashCode())});
    }

    public int l() {
        return this.h.d();
    }

    public String m() {
        return this.h.h().isMultipleInstances() ? this.h.h().getProviderTypeForReflection() : this.h.f();
    }

    public String n() {
        return this.h.g();
    }

    public void onAdClicked() {
        if (!this.p.c()) {
            G();
        } else {
            this.p.a(new g());
        }
    }

    public void onAdLoadFailed(AdapterErrorType adapterErrorType, int i2, String str) {
        if (!this.p.c()) {
            a(adapterErrorType, i2, str);
        } else {
            this.p.a(new e(adapterErrorType, i2, str));
        }
    }

    public void onAdLoadSuccess() {
        if (!this.p.c()) {
            H();
        } else {
            this.p.a(new d());
        }
    }

    public void onAdOpened() {
        if (!this.p.c()) {
            I();
        } else {
            this.p.a(new f());
        }
    }

    public void onInitFailed(int i2, String str) {
        if (!this.p.c()) {
            a(i2, str);
        } else {
            this.p.a(new c(i2, str));
        }
    }

    public void onInitSuccess() {
        if (!this.p.c()) {
            J();
        } else {
            this.p.a(new b());
        }
    }

    public NetworkSettings p() {
        return this.a.g();
    }

    /* access modifiers changed from: protected */
    public Map<String, Object> q() {
        HashMap hashMap = new HashMap();
        hashMap.putAll(g8.a(this.i));
        return hashMap;
    }

    public Integer r() {
        p pVar = this.a;
        if (pVar != null) {
            return Integer.valueOf(pVar.h());
        }
        return null;
    }

    /* access modifiers changed from: protected */
    public ia t() {
        return this.p;
    }

    /* access modifiers changed from: protected */
    public boolean u() {
        return false;
    }

    public boolean v() {
        return this.h.j();
    }

    public boolean w() {
        return this.e == h.FAILED;
    }

    public boolean x() {
        return this.e == h.LOADED;
    }

    public boolean y() {
        h hVar = this.e;
        return hVar == h.INIT_IN_PROGRESS || hVar == h.LOADING;
    }

    public AtomicBoolean z() {
        return this.f;
    }
}
