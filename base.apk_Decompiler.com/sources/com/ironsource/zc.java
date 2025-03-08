package com.ironsource;

import android.text.TextUtils;
import com.ironsource.environment.ContextProvider;
import com.ironsource.mediationsdk.IronSource;
import com.ironsource.mediationsdk.adunit.adapter.internal.AdapterBaseInterface;
import com.ironsource.mediationsdk.adunit.adapter.internal.AdapterSettingsInterface;
import com.ironsource.mediationsdk.logger.IronLog;
import com.ironsource.t1;
import com.ironsource.y;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

public class zc<Smash extends t1<?>> {
    ConcurrentHashMap<String, CopyOnWriteArrayList<Smash>> a = new ConcurrentHashMap<>();
    private String b = "";
    private String c = "";
    private t1<?> d;
    private final List<String> e;
    private final int f;
    private final Timer g = new Timer();
    ad h;
    private final int i = 5;

    class a extends TimerTask {
        final /* synthetic */ String a;

        a(String str) {
            this.a = str;
        }

        public void run() {
            try {
                IronLog ironLog = IronLog.INTERNAL;
                ironLog.verbose("removing waterfall with id " + this.a + " from memory");
                zc.this.a.remove(this.a);
                ironLog.verbose("waterfall size is currently " + zc.this.a.size());
                ironLog.verbose("removing adInfo with id " + this.a + " from memory");
            } finally {
                cancel();
            }
        }
    }

    public zc(List<String> list, int i2, ad adVar) {
        this.e = list;
        this.f = i2;
        this.h = adVar;
    }

    private void a() {
        for (t1 t1Var : b()) {
            if (!t1Var.equals(this.d)) {
                t1Var.L();
            }
        }
    }

    private synchronized boolean e() {
        t1<?> t1Var;
        t1Var = this.d;
        return t1Var != null && t1Var.B() && this.d.h().equals(this.c);
    }

    private synchronized void f() {
        t1<?> t1Var = this.d;
        if (t1Var != null) {
            t1Var.L();
        }
    }

    public synchronized void a(t1<?> t1Var) {
        IronLog.INTERNAL.verbose();
        t1<?> t1Var2 = this.d;
        if (t1Var2 != null && !t1Var2.equals(t1Var)) {
            f();
        }
        this.d = t1Var;
    }

    public void a(y.a aVar, CopyOnWriteArrayList<Smash> copyOnWriteArrayList, String str) {
        IronLog ironLog = IronLog.INTERNAL;
        ironLog.verbose("updating new waterfall with id " + str);
        a();
        if (aVar == y.a.AUTOMATIC_LOAD_WHILE_SHOW) {
            this.a.put(str, copyOnWriteArrayList);
            if (!TextUtils.isEmpty(this.c)) {
                if (e()) {
                    ironLog.verbose("ad from previous waterfall " + this.c + " is still showing - the current waterfall " + this.b + " will be deleted instead");
                    String str2 = this.b;
                    this.b = this.c;
                    this.c = str2;
                }
                this.g.schedule(new a(this.c), (long) this.f);
            }
        } else {
            this.a.clear();
            this.a.put(str, copyOnWriteArrayList);
        }
        this.c = this.b;
        this.b = str;
        if (this.a.size() > 5) {
            this.h.a(this.a.size());
        }
    }

    public boolean a(AdapterBaseInterface adapterBaseInterface, IronSource.AD_UNIT ad_unit, String str) {
        IronLog ironLog = IronLog.INTERNAL;
        ironLog.verbose();
        if (ContextProvider.getInstance().getCurrentActiveActivity() != null || !(adapterBaseInterface instanceof AdapterSettingsInterface) || !((AdapterSettingsInterface) adapterBaseInterface).isUsingActivityBeforeImpression(ad_unit)) {
            return false;
        }
        ironLog.verbose(str + " - is using activity before impression and activity is null");
        return true;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0034, code lost:
        if (r0.e.contains(r3) == false) goto L_0x0043;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x0040, code lost:
        if (r0.d.n().equals(r3) == false) goto L_0x0043;
     */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x0045  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized boolean a(com.ironsource.y.a r1, java.lang.String r2, java.lang.String r3, com.ironsource.mediationsdk.LoadWhileShowSupportState r4, com.ironsource.mediationsdk.adunit.adapter.internal.AdapterBaseInterface r5, com.ironsource.mediationsdk.IronSource.AD_UNIT r6) {
        /*
            r0 = this;
            monitor-enter(r0)
            boolean r5 = r0.a((com.ironsource.mediationsdk.adunit.adapter.internal.AdapterBaseInterface) r5, (com.ironsource.mediationsdk.IronSource.AD_UNIT) r6, (java.lang.String) r2)     // Catch:{ all -> 0x005d }
            if (r5 == 0) goto L_0x0008
            goto L_0x0042
        L_0x0008:
            com.ironsource.y$a r5 = com.ironsource.y.a.AUTOMATIC_LOAD_WHILE_SHOW     // Catch:{ all -> 0x005d }
            r6 = 1
            if (r1 == r5) goto L_0x000e
            goto L_0x0043
        L_0x000e:
            com.ironsource.t1<?> r1 = r0.d     // Catch:{ all -> 0x005d }
            if (r1 == 0) goto L_0x0043
            boolean r1 = r1.B()     // Catch:{ all -> 0x005d }
            if (r1 != 0) goto L_0x0019
            goto L_0x0043
        L_0x0019:
            com.ironsource.mediationsdk.LoadWhileShowSupportState r1 = com.ironsource.mediationsdk.LoadWhileShowSupportState.LOAD_WHILE_SHOW_BY_NETWORK     // Catch:{ all -> 0x005d }
            if (r4 != r1) goto L_0x002a
            com.ironsource.t1<?> r1 = r0.d     // Catch:{ all -> 0x005d }
            java.lang.String r1 = r1.c()     // Catch:{ all -> 0x005d }
            boolean r1 = r1.equals(r2)     // Catch:{ all -> 0x005d }
            if (r1 == 0) goto L_0x002a
            goto L_0x0042
        L_0x002a:
            com.ironsource.mediationsdk.LoadWhileShowSupportState r1 = com.ironsource.mediationsdk.LoadWhileShowSupportState.NONE     // Catch:{ all -> 0x005d }
            if (r4 == r1) goto L_0x0036
            java.util.List<java.lang.String> r1 = r0.e     // Catch:{ all -> 0x005d }
            boolean r1 = r1.contains(r3)     // Catch:{ all -> 0x005d }
            if (r1 == 0) goto L_0x0043
        L_0x0036:
            com.ironsource.t1<?> r1 = r0.d     // Catch:{ all -> 0x005d }
            java.lang.String r1 = r1.n()     // Catch:{ all -> 0x005d }
            boolean r1 = r1.equals(r3)     // Catch:{ all -> 0x005d }
            if (r1 == 0) goto L_0x0043
        L_0x0042:
            r6 = 0
        L_0x0043:
            if (r6 != 0) goto L_0x005b
            com.ironsource.mediationsdk.logger.IronLog r1 = com.ironsource.mediationsdk.logger.IronLog.INTERNAL     // Catch:{ all -> 0x005d }
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x005d }
            r3.<init>()     // Catch:{ all -> 0x005d }
            r3.append(r2)     // Catch:{ all -> 0x005d }
            java.lang.String r2 = " will not be added to the auction request"
            r3.append(r2)     // Catch:{ all -> 0x005d }
            java.lang.String r2 = r3.toString()     // Catch:{ all -> 0x005d }
            r1.verbose(r2)     // Catch:{ all -> 0x005d }
        L_0x005b:
            monitor-exit(r0)
            return r6
        L_0x005d:
            r1 = move-exception
            monitor-exit(r0)
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ironsource.zc.a(com.ironsource.y$a, java.lang.String, java.lang.String, com.ironsource.mediationsdk.LoadWhileShowSupportState, com.ironsource.mediationsdk.adunit.adapter.internal.AdapterBaseInterface, com.ironsource.mediationsdk.IronSource$AD_UNIT):boolean");
    }

    public List<Smash> b() {
        CopyOnWriteArrayList copyOnWriteArrayList = this.a.get(this.b);
        return copyOnWriteArrayList == null ? new CopyOnWriteArrayList() : copyOnWriteArrayList;
    }

    public String c() {
        return this.b;
    }

    public t1<?> d() {
        return this.d;
    }
}
