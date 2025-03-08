package com.ironsource;

import android.content.Context;
import android.content.IntentFilter;
import android.os.AsyncTask;
import android.text.TextUtils;
import com.ironsource.a2;
import com.ironsource.environment.ContextProvider;
import com.ironsource.environment.NetworkStateReceiver;
import com.ironsource.environment.thread.IronSourceThreadManager;
import com.ironsource.mediationsdk.IronSource;
import com.ironsource.mediationsdk.IronSourceSegment;
import com.ironsource.mediationsdk.adunit.adapter.internal.AdapterBaseInterface;
import com.ironsource.mediationsdk.adunit.adapter.internal.AdapterSettingsInterface;
import com.ironsource.mediationsdk.adunit.adapter.internal.BaseAdAdapter;
import com.ironsource.mediationsdk.adunit.adapter.internal.listener.AdapterAdListener;
import com.ironsource.mediationsdk.adunit.adapter.listener.NetworkInitializationListener;
import com.ironsource.mediationsdk.adunit.adapter.utility.AdData;
import com.ironsource.mediationsdk.adunit.adapter.utility.AdInfo;
import com.ironsource.mediationsdk.h;
import com.ironsource.mediationsdk.i;
import com.ironsource.mediationsdk.impressionData.ImpressionData;
import com.ironsource.mediationsdk.impressionData.ImpressionDataListener;
import com.ironsource.mediationsdk.logger.IronLog;
import com.ironsource.mediationsdk.logger.IronSourceError;
import com.ironsource.mediationsdk.logger.IronSourceLogger;
import com.ironsource.mediationsdk.logger.IronSourceLoggerManager;
import com.ironsource.mediationsdk.model.NetworkSettings;
import com.ironsource.mediationsdk.model.Placement;
import com.ironsource.mediationsdk.n;
import com.ironsource.mediationsdk.utils.IronSourceConstants;
import com.ironsource.mediationsdk.utils.IronSourceUtils;
import com.ironsource.t1;
import com.ironsource.v;
import com.ironsource.w6;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.TimerTask;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONException;
import org.json.JSONObject;

public abstract class q1<Smash extends t1<?>, Listener extends AdapterAdListener> implements a0, t0, u, s8, l9, i, ad, y1, ia {
    private AdInfo A;
    private k8 B;
    final w6 C = w8.e().b();
    final w6.a D = w8.d().a();
    private boolean E;
    private wb F;
    private AtomicBoolean G = new AtomicBoolean(false);
    private u7 H;
    protected zc<Smash> a;
    protected ConcurrentHashMap<String, h.a> b;
    protected com.ironsource.mediationsdk.e c;
    protected h d;
    protected int e;
    protected String f = "";
    protected JSONObject g;
    protected d1 h;
    protected Placement i;
    protected boolean j = false;
    private NetworkStateReceiver k;
    protected kb l;
    protected r3 m;
    protected r3 n;
    protected l o;
    protected f p;
    protected z q;
    protected i4 r;
    protected v s;
    protected x t;
    protected r u;
    protected IronSourceSegment v;
    protected UUID w = UUID.randomUUID();
    protected final Object x = new Object();
    private long y = 0;
    private Boolean z;

    class a extends cb {
        a() {
        }

        public void a() {
            q1.this.x();
        }
    }

    class b implements Runnable {
        final /* synthetic */ NetworkSettings a;

        b(NetworkSettings networkSettings) {
            this.a = networkSettings;
        }

        public void run() {
            q1.this.c(this.a);
        }
    }

    class c extends TimerTask {
        c() {
        }

        public void run() {
            q1.this.z();
        }
    }

    class d implements Runnable {
        d() {
        }

        public void run() {
            q1.this.g = new JSONObject();
            q1.this.s.i.a();
            HashMap hashMap = new HashMap();
            ArrayList arrayList = new ArrayList();
            StringBuilder sb = new StringBuilder();
            ArrayList arrayList2 = new ArrayList();
            q1.this.b(hashMap, arrayList, sb, arrayList2);
            if (q1.this.o.e()) {
                q1.this.a((Map<String, Object>) hashMap, (List<String>) arrayList, sb, (List<x1>) arrayList2);
            } else {
                q1.this.a((Map<String, Object>) hashMap, (List<String>) arrayList, sb.toString());
            }
        }
    }

    class e implements a2.b {
        final /* synthetic */ Map a;
        final /* synthetic */ StringBuilder b;
        final /* synthetic */ List c;

        e(Map map, StringBuilder sb, List list) {
            this.a = map;
            this.b = sb;
            this.c = list;
        }

        public void a(List<b2> list, long j, List<String> list2) {
            q1.this.s.h.a(j);
            for (b2 next : list) {
                NetworkSettings a2 = q1.this.o.a(next.c());
                Map a3 = q1.this.a(a2, com.ironsource.mediationsdk.c.b().b(a2, q1.this.o.b(), q1.this.h()));
                if (next.a() != null) {
                    this.a.put(next.c(), next.a());
                    StringBuilder sb = this.b;
                    sb.append(next.d());
                    sb.append(next.c());
                    sb.append(",");
                    q1.this.s.h.a(a3, next.e());
                } else {
                    q1.this.s.h.a(a3, next.e(), next.b());
                }
            }
            for (String a4 : list2) {
                NetworkSettings a5 = q1.this.o.a(a4);
                q1.this.s.h.b(q1.this.a(a5, com.ironsource.mediationsdk.c.b().b(a5, q1.this.o.b(), q1.this.h())), j);
            }
            q1.this.a((Map<String, Object>) this.a, (List<String>) this.c, this.b.toString());
        }

        public void onFailure(String str) {
            q1.this.s.h.a(str);
            q1.this.a((Map<String, Object>) this.a, (List<String>) this.c, this.b.toString());
        }
    }

    protected enum f {
        NONE,
        READY_TO_LOAD,
        AUCTION,
        LOADING,
        READY_TO_SHOW,
        SHOWING
    }

    public q1(l lVar, k8 k8Var, IronSourceSegment ironSourceSegment, boolean z2) {
        IronLog ironLog = IronLog.INTERNAL;
        ironLog.verbose("adUnit = " + lVar.b() + ", loading mode = " + lVar.h().a());
        StringBuilder sb = new StringBuilder();
        sb.append(lVar.b());
        sb.append(" initiated object per waterfall mode");
        IronSourceUtils.sendAutomationLog(sb.toString());
        r3 r3Var = new r3();
        this.H = a(lVar);
        this.v = ironSourceSegment;
        this.o = lVar;
        this.s = new v(lVar.b(), v.b.MEDIATION, this);
        this.t = e();
        this.q = new z(this.o.h(), this);
        a(f.NONE);
        this.B = k8Var;
        this.a = new zc<>(this.o.d().f(), this.o.d().i(), this);
        this.s.f.a(l(), this.o.h().a().toString());
        this.b = new ConcurrentHashMap<>();
        this.i = null;
        C();
        this.g = new JSONObject();
        if (this.o.r()) {
            this.c = new com.ironsource.mediationsdk.e(new com.ironsource.mediationsdk.f(this.o.d(), z2, IronSourceUtils.getSessionId()));
        }
        this.d = new h(this.o.j(), this.o.d().c());
        p();
        o();
        this.m = new r3();
        a(f.READY_TO_LOAD);
        this.r = new i4(lVar.a(), this);
        this.u = new r();
        this.s.f.a(r3.a(r3Var));
        if (this.o.h().e()) {
            ironLog.verbose("first automatic load");
            w();
        }
    }

    private dd<Smash> A() {
        IronLog.INTERNAL.verbose();
        return new cd(this.o).d(this.a.b());
    }

    private void B() {
        this.u.a(this.o.b(), false);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0033, code lost:
        if (r2 <= 0) goto L_0x0043;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0035, code lost:
        new java.util.Timer().schedule(new com.ironsource.q1.c(r5), r2);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0043, code lost:
        z();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0018, code lost:
        r5.G.set(false);
        r2 = r5.o.d().k() - com.ironsource.r3.a(r5.m);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void G() {
        /*
            r5 = this;
            com.ironsource.mediationsdk.logger.IronLog r0 = com.ironsource.mediationsdk.logger.IronLog.INTERNAL
            java.lang.String r1 = r5.f()
            r0.verbose(r1)
            java.lang.Object r0 = r5.x
            monitor-enter(r0)
            com.ironsource.q1$f r1 = r5.p     // Catch:{ all -> 0x0047 }
            com.ironsource.q1$f r2 = com.ironsource.q1.f.AUCTION     // Catch:{ all -> 0x0047 }
            if (r1 != r2) goto L_0x0014
            monitor-exit(r0)     // Catch:{ all -> 0x0047 }
            return
        L_0x0014:
            r5.a((com.ironsource.q1.f) r2)     // Catch:{ all -> 0x0047 }
            monitor-exit(r0)     // Catch:{ all -> 0x0047 }
            java.util.concurrent.atomic.AtomicBoolean r0 = r5.G
            r1 = 0
            r0.set(r1)
            com.ironsource.r3 r0 = r5.m
            long r0 = com.ironsource.r3.a(r0)
            com.ironsource.l r2 = r5.o
            com.ironsource.mediationsdk.utils.a r2 = r2.d()
            long r2 = r2.k()
            long r2 = r2 - r0
            r0 = 0
            int r4 = (r2 > r0 ? 1 : (r2 == r0 ? 0 : -1))
            if (r4 <= 0) goto L_0x0043
            java.util.Timer r0 = new java.util.Timer
            r0.<init>()
            com.ironsource.q1$c r1 = new com.ironsource.q1$c
            r1.<init>()
            r0.schedule(r1, r2)
            goto L_0x0046
        L_0x0043:
            r5.z()
        L_0x0046:
            return
        L_0x0047:
            r1 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x0047 }
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ironsource.q1.G():void");
    }

    private void H() {
        IronLog.INTERNAL.verbose(f());
        a(g(), j());
    }

    private Smash a(d1 d1Var, String str) {
        NetworkSettings a2 = this.o.a(d1Var.c());
        if (a2 != null) {
            com.ironsource.mediationsdk.c.b().b(a2, this.o.b(), h());
            BaseAdAdapter a3 = a(a2, this.o.b());
            if (a3 != null) {
                Smash a4 = a(a2, a3, this.C.a(this.o.b()), str, d1Var);
                this.b.put(d1Var.c(), h.a.ISAuctionPerformanceDidntAttemptToLoad);
                return a4;
            }
            IronLog.INTERNAL.error(b("addSmashToWaterfall - could not load ad adapter for " + a2.getProviderInstanceName()));
        } else {
            String str2 = "could not find matching provider settings for auction response item - item = " + d1Var.c() + " state = " + this.p;
            IronLog.INTERNAL.error(b(str2));
            this.s.k.d(str2);
        }
        return null;
    }

    private u7 a(l lVar) {
        if (lVar.o()) {
            return IronSourceThreadManager.INSTANCE.createAndStartThread(String.format("%s_%s", new Object[]{lVar.b().name(), Integer.valueOf(hashCode())}));
        } else if (lVar.l()) {
            return IronSourceThreadManager.INSTANCE.getSharedManagersThread();
        } else {
            return null;
        }
    }

    private String a(List<d1> list, String str) {
        IronLog ironLog = IronLog.INTERNAL;
        ironLog.verbose(b("waterfall.size() = " + list.size()));
        this.b.clear();
        StringBuilder sb = new StringBuilder();
        CopyOnWriteArrayList copyOnWriteArrayList = new CopyOnWriteArrayList();
        for (int i2 = 0; i2 < list.size(); i2++) {
            d1 d1Var = list.get(i2);
            t1 a2 = a(d1Var, str);
            if (a2 != null) {
                copyOnWriteArrayList.add(a2);
                sb.append(a(d1Var, a2.l()));
            }
            if (i2 != list.size() - 1) {
                sb.append(",");
            }
        }
        this.a.a(this.o.h().a(), copyOnWriteArrayList, str);
        IronLog.INTERNAL.verbose(b("updateWaterfall() - next waterfall is " + sb));
        return sb.toString();
    }

    /* access modifiers changed from: private */
    public Map<String, Object> a(NetworkSettings networkSettings, AdapterBaseInterface adapterBaseInterface) {
        HashMap hashMap = new HashMap();
        try {
            hashMap.put(IronSourceConstants.EVENTS_PROVIDER, networkSettings.getProviderDefaultInstance());
            hashMap.put(IronSourceConstants.EVENTS_PROVIDER_ADAPTER_VERSION, adapterBaseInterface.getAdapterVersion());
            hashMap.put(IronSourceConstants.EVENTS_PROVIDER_SDK_VERSION, adapterBaseInterface.getNetworkSDKVersion());
            hashMap.put(IronSourceConstants.EVENTS_SUB_PROVIDER_ID, networkSettings.getSubProviderId());
            hashMap.put("instanceType", Integer.valueOf(networkSettings.getInstanceType(this.o.b())));
            hashMap.put(IronSourceConstants.EVENTS_PROGRAMMATIC, Integer.valueOf(m()));
        } catch (Exception e2) {
            IronSourceLoggerManager logger = IronSourceLoggerManager.getLogger();
            IronSourceLogger.IronSourceTag ironSourceTag = IronSourceLogger.IronSourceTag.INTERNAL;
            logger.logException(ironSourceTag, "getProviderEventData " + networkSettings.getProviderDefaultInstance(), e2);
        }
        return hashMap;
    }

    /* access modifiers changed from: private */
    public void a(Map<String, Object> map, List<String> list, String str) {
        IronLog ironLog = IronLog.INTERNAL;
        ironLog.verbose(b("auction waterfallString = " + str));
        boolean z2 = false;
        if (map.size() == 0 && list.size() == 0) {
            ironLog.verbose(b("auction failed - no candidates"));
            this.s.i.a(1005, "No candidates available for auctioning");
            a(s.e(this.o.b()), "no available ad to load", false);
            return;
        }
        this.s.i.b(str);
        if (this.c != null) {
            int a2 = this.C.a(this.o.b());
            i iVar = new i(this.o.b());
            iVar.b(IronSourceUtils.isEncryptedResponse());
            iVar.a(map);
            iVar.a(list);
            iVar.a(this.d);
            iVar.a(a2);
            iVar.a(this.v);
            iVar.d(this.E);
            wb wbVar = this.F;
            if (wbVar != null && wbVar.a()) {
                z2 = true;
            }
            iVar.e(z2);
            a(ContextProvider.getInstance().getApplicationContext(), iVar, (t0) this);
            return;
        }
        ironLog.error(b("mAuctionHandler is null"));
    }

    /* access modifiers changed from: private */
    public void a(Map<String, Object> map, List<String> list, StringBuilder sb, List<x1> list2) {
        if (list2.isEmpty()) {
            a(map, list, sb.toString());
            return;
        }
        a2 a2Var = new a2();
        e eVar = new e(map, sb, list);
        this.s.h.a();
        a2Var.a(list2, (a2.b) eVar, this.o.f(), TimeUnit.MILLISECONDS);
    }

    private void a(JSONObject jSONObject) {
        boolean z2 = false;
        if (jSONObject != null) {
            z2 = jSONObject.optBoolean(com.ironsource.mediationsdk.d.e, false);
        }
        this.u.a(this.o.b(), z2);
        b(jSONObject);
    }

    /* access modifiers changed from: private */
    public void b(Map<String, Object> map, List<String> list, StringBuilder sb, List<x1> list2) {
        String str;
        String str2;
        StringBuilder sb2;
        StringBuilder sb3;
        for (NetworkSettings next : this.o.j()) {
            wb wbVar = this.F;
            if (wbVar == null || wbVar.a(next, this.o.b())) {
                if (!this.l.b(new jb(next.getProviderInstanceName(), next.getMaxAdsPerSession(this.o.b()))) && d(next)) {
                    AdData a2 = a(next, (String) null);
                    if (next.isBidder(this.o.b())) {
                        AdapterBaseInterface b2 = com.ironsource.mediationsdk.c.b().b(next, this.o.b(), h());
                        if (!(b2 instanceof z1)) {
                            if (b2 == null) {
                                sb2 = new StringBuilder("prepareAuctionCandidates - could not load network adapter ");
                                str2 = next.getProviderName();
                            } else {
                                sb2 = new StringBuilder("network adapter ");
                                sb2.append(next.getProviderName());
                                str2 = " does not implementing BiddingDataInterface";
                            }
                            sb2.append(str2);
                            str = sb2.toString();
                            this.s.k.c(str);
                        } else if (this.o.e()) {
                            list2.add(new x1(next.getInstanceType(this.o.b()), next.getProviderInstanceName(), a2, (z1) b2, this, next));
                        } else {
                            try {
                                Map<String, Object> a3 = ((z1) b2).a(a2);
                                if (a3 != null) {
                                    map.put(next.getProviderInstanceName(), a3);
                                    sb.append(next.getInstanceType(this.o.b()));
                                    sb.append(next.getProviderInstanceName());
                                    sb.append(",");
                                } else {
                                    this.s.k.a(a(next, b2), "Missing bidding data");
                                }
                            } catch (Exception e2) {
                                e = e2;
                                sb3 = new StringBuilder("prepareAuctionCandidates - exception while calling networkAdapter.getBiddingData - ");
                                sb3.append(e.getMessage());
                                str = sb3.toString();
                                IronLog.INTERNAL.error(str);
                                this.s.k.c(str);
                            } catch (NoClassDefFoundError e3) {
                                e = e3;
                                sb3 = new StringBuilder("prepareAuctionCandidates - error while calling networkAdapter.getBiddingData - ");
                                sb3.append(e.getMessage());
                                str = sb3.toString();
                                IronLog.INTERNAL.error(str);
                                this.s.k.c(str);
                            }
                        }
                    } else {
                        list.add(next.getProviderInstanceName());
                        sb.append(next.getInstanceType(this.o.b()));
                        sb.append(next.getProviderInstanceName());
                        sb.append(",");
                    }
                }
            }
        }
    }

    private void b(JSONObject jSONObject) {
        int i2;
        if (jSONObject == null) {
            this.o.b(false);
            IronLog ironLog = IronLog.INTERNAL;
            ironLog.verbose(b("loading configuration from auction response is null, using the following: " + this.o.s()));
            return;
        }
        try {
            if (jSONObject.has(com.ironsource.mediationsdk.d.n0) && (i2 = jSONObject.getInt(com.ironsource.mediationsdk.d.n0)) > 0) {
                this.o.a(i2);
            }
            if (jSONObject.has(com.ironsource.mediationsdk.d.o0)) {
                this.o.a(jSONObject.getBoolean(com.ironsource.mediationsdk.d.o0));
            }
            this.o.b(jSONObject.optBoolean(com.ironsource.mediationsdk.d.p0, false));
            IronLog.INTERNAL.verbose(b(this.o.s()));
        } catch (JSONException e2) {
            IronLog ironLog2 = IronLog.INTERNAL;
            ironLog2.error("failed to update loading configuration for" + this.o.b() + " Error: " + e2.getMessage());
            ironLog2.verbose(b(this.o.s()));
        } catch (Throwable th) {
            IronLog.INTERNAL.verbose(b(this.o.s()));
            throw th;
        }
    }

    private boolean b(NetworkSettings networkSettings, AdapterBaseInterface adapterBaseInterface) {
        if (this.a.a(adapterBaseInterface, this.o.b(), networkSettings.getProviderInstanceName())) {
            return false;
        }
        return networkSettings.shouldEarlyInit() || networkSettings.isIronSource() || networkSettings.isBidder(this.o.b());
    }

    private boolean b(t tVar) {
        return (tVar == t.INIT_STARTED || tVar == t.LOAD_AD || tVar == t.AUCTION_REQUEST || tVar == t.AUCTION_REQUEST_WATERFALL || tVar == t.AUCTION_FAILED_NO_CANDIDATES || tVar == t.COLLECT_TOKEN || tVar == t.COLLECT_TOKENS_COMPLETED || tVar == t.COLLECT_TOKENS_FAILED || tVar == t.INSTANCE_COLLECT_TOKEN || tVar == t.INSTANCE_COLLECT_TOKEN_SUCCESS || tVar == t.INSTANCE_COLLECT_TOKEN_FAILED || tVar == t.INSTANCE_COLLECT_TOKEN_TIMED_OUT) ? false : true;
    }

    /* access modifiers changed from: private */
    public void c(NetworkSettings networkSettings) {
        IronLog.INTERNAL.verbose(b(String.format("Start initializing provider %s on thread %s", new Object[]{networkSettings.getProviderInstanceName(), Thread.currentThread().getName()})));
        AdData a2 = a(networkSettings, this.o.p());
        AdapterBaseInterface b2 = com.ironsource.mediationsdk.c.b().b(networkSettings, this.o.b(), h());
        if (b2 != null) {
            try {
                b2.init(a2, ContextProvider.getInstance().getApplicationContext(), (NetworkInitializationListener) null);
            } catch (Exception e2) {
                oc ocVar = this.s.k;
                ocVar.c("initProvider - exception while calling networkAdapter.init with " + networkSettings.getProviderName() + " - " + e2);
            }
        }
        IronLog.INTERNAL.verbose(b(String.format("Done initializing provider %s on thread %s", new Object[]{networkSettings.getProviderInstanceName(), Thread.currentThread().getName()})));
    }

    private boolean c(t tVar) {
        return tVar == t.LOAD_AD_SUCCESS || tVar == t.LOAD_AD_FAILED || tVar == t.LOAD_AD_FAILED_WITH_REASON || tVar == t.AUCTION_SUCCESS || tVar == t.AUCTION_FAILED || tVar == t.AD_UNIT_CAPPED;
    }

    private boolean c(boolean z2) {
        Boolean bool = this.z;
        if (bool == null) {
            return false;
        }
        return (z2 && !bool.booleanValue() && q()) || (!z2 && this.z.booleanValue());
    }

    private boolean d(NetworkSettings networkSettings) {
        AdapterBaseInterface b2 = com.ironsource.mediationsdk.c.b().b(networkSettings, this.o.b(), h());
        if (b2 instanceof AdapterSettingsInterface) {
            return this.a.a(this.o.h().a(), networkSettings.getProviderInstanceName(), networkSettings.getProviderTypeForReflection(), ((AdapterSettingsInterface) b2).getLoadWhileShowSupportedState(networkSettings), b2, this.o.b());
        }
        return false;
    }

    private List<d1> g() {
        CopyOnWriteArrayList copyOnWriteArrayList = new CopyOnWriteArrayList();
        for (NetworkSettings next : this.o.j()) {
            if (!next.isBidder(this.o.b()) && d(next)) {
                jb jbVar = new jb(next.getProviderInstanceName(), next.getMaxAdsPerSession(this.o.b()));
                if (!this.l.b(jbVar)) {
                    copyOnWriteArrayList.add(new d1(jbVar.c()));
                }
            }
        }
        return copyOnWriteArrayList;
    }

    private int m() {
        return 1;
    }

    private void o() {
        IronLog.INTERNAL.verbose(f());
        ArrayList arrayList = new ArrayList();
        for (NetworkSettings next : this.o.j()) {
            if (b(next, com.ironsource.mediationsdk.c.b().b(next, this.o.b(), h()))) {
                arrayList.add(new b(next));
            }
        }
        IronSourceThreadManager.INSTANCE.executeTasks(this.o.k(), this.o.q(), arrayList);
    }

    private void p() {
        ArrayList arrayList = new ArrayList();
        for (NetworkSettings next : this.o.j()) {
            arrayList.add(new jb(next.getProviderInstanceName(), next.getMaxAdsPerSession(this.o.b())));
        }
        this.l = new kb(arrayList);
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0082, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:44:0x010c, code lost:
        if (r6.o.r() != false) goto L_?;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:45:0x010e, code lost:
        r0.verbose(b("auction disabled"));
        H();
        y();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:53:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:54:?, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void x() {
        /*
            r6 = this;
            com.ironsource.mediationsdk.logger.IronLog r0 = com.ironsource.mediationsdk.logger.IronLog.INTERNAL
            java.lang.String r1 = r6.f()
            r0.verbose(r1)
            java.lang.Object r1 = r6.x
            monitor-enter(r1)
            com.ironsource.l r2 = r6.o     // Catch:{ all -> 0x011e }
            com.ironsource.y r2 = r2.h()     // Catch:{ all -> 0x011e }
            boolean r2 = r2.e()     // Catch:{ all -> 0x011e }
            r3 = 0
            if (r2 == 0) goto L_0x0039
            com.ironsource.kb r2 = r6.l     // Catch:{ all -> 0x011e }
            boolean r2 = r2.a()     // Catch:{ all -> 0x011e }
            if (r2 == 0) goto L_0x0039
            java.lang.String r2 = "all smashes are capped"
            java.lang.String r4 = r6.b((java.lang.String) r2)     // Catch:{ all -> 0x011e }
            r0.verbose(r4)     // Catch:{ all -> 0x011e }
            com.ironsource.l r0 = r6.o     // Catch:{ all -> 0x011e }
            com.ironsource.mediationsdk.IronSource$AD_UNIT r0 = r0.b()     // Catch:{ all -> 0x011e }
            int r0 = com.ironsource.s.a(r0)     // Catch:{ all -> 0x011e }
            r6.a((int) r0, (java.lang.String) r2, (boolean) r3)     // Catch:{ all -> 0x011e }
            monitor-exit(r1)     // Catch:{ all -> 0x011e }
            return
        L_0x0039:
            com.ironsource.l r2 = r6.o     // Catch:{ all -> 0x011e }
            com.ironsource.y r2 = r2.h()     // Catch:{ all -> 0x011e }
            com.ironsource.y$a r2 = r2.a()     // Catch:{ all -> 0x011e }
            com.ironsource.y$a r4 = com.ironsource.y.a.AUTOMATIC_LOAD_WHILE_SHOW     // Catch:{ all -> 0x011e }
            if (r2 == r4) goto L_0x0083
            com.ironsource.q1$f r2 = r6.p     // Catch:{ all -> 0x011e }
            com.ironsource.q1$f r5 = com.ironsource.q1.f.SHOWING     // Catch:{ all -> 0x011e }
            if (r2 != r5) goto L_0x0083
            java.lang.String r0 = "load cannot be invoked while showing an ad"
            com.ironsource.mediationsdk.logger.IronLog r2 = com.ironsource.mediationsdk.logger.IronLog.API     // Catch:{ all -> 0x011e }
            java.lang.String r4 = r6.b((java.lang.String) r0)     // Catch:{ all -> 0x011e }
            r2.error(r4)     // Catch:{ all -> 0x011e }
            com.ironsource.mediationsdk.logger.IronSourceError r2 = new com.ironsource.mediationsdk.logger.IronSourceError     // Catch:{ all -> 0x011e }
            com.ironsource.l r4 = r6.o     // Catch:{ all -> 0x011e }
            com.ironsource.mediationsdk.IronSource$AD_UNIT r4 = r4.b()     // Catch:{ all -> 0x011e }
            int r4 = com.ironsource.s.d(r4)     // Catch:{ all -> 0x011e }
            r2.<init>(r4, r0)     // Catch:{ all -> 0x011e }
            com.ironsource.l r0 = r6.o     // Catch:{ all -> 0x011e }
            com.ironsource.y r0 = r0.h()     // Catch:{ all -> 0x011e }
            boolean r0 = r0.f()     // Catch:{ all -> 0x011e }
            if (r0 == 0) goto L_0x007b
            boolean r0 = r6.r()     // Catch:{ all -> 0x011e }
            r6.a((com.ironsource.mediationsdk.logger.IronSourceError) r2, (boolean) r0)     // Catch:{ all -> 0x011e }
            goto L_0x0081
        L_0x007b:
            com.ironsource.x r0 = r6.t     // Catch:{ all -> 0x011e }
            r2 = 0
            r0.a((boolean) r3, (com.ironsource.mediationsdk.adunit.adapter.utility.AdInfo) r2)     // Catch:{ all -> 0x011e }
        L_0x0081:
            monitor-exit(r1)     // Catch:{ all -> 0x011e }
            return
        L_0x0083:
            com.ironsource.l r2 = r6.o     // Catch:{ all -> 0x011e }
            com.ironsource.y r2 = r2.h()     // Catch:{ all -> 0x011e }
            com.ironsource.y$a r2 = r2.a()     // Catch:{ all -> 0x011e }
            if (r2 == r4) goto L_0x00b6
            com.ironsource.q1$f r2 = r6.p     // Catch:{ all -> 0x011e }
            com.ironsource.q1$f r3 = com.ironsource.q1.f.READY_TO_LOAD     // Catch:{ all -> 0x011e }
            if (r2 == r3) goto L_0x0099
            com.ironsource.q1$f r3 = com.ironsource.q1.f.READY_TO_SHOW     // Catch:{ all -> 0x011e }
            if (r2 != r3) goto L_0x00a9
        L_0x0099:
            com.ironsource.mediationsdk.n r2 = com.ironsource.mediationsdk.n.a()     // Catch:{ all -> 0x011e }
            com.ironsource.l r3 = r6.o     // Catch:{ all -> 0x011e }
            com.ironsource.mediationsdk.IronSource$AD_UNIT r3 = r3.b()     // Catch:{ all -> 0x011e }
            boolean r2 = r2.b(r3)     // Catch:{ all -> 0x011e }
            if (r2 == 0) goto L_0x00b6
        L_0x00a9:
            com.ironsource.mediationsdk.logger.IronLog r0 = com.ironsource.mediationsdk.logger.IronLog.API     // Catch:{ all -> 0x011e }
            java.lang.String r2 = "load is already in progress"
            java.lang.String r2 = r6.b((java.lang.String) r2)     // Catch:{ all -> 0x011e }
            r0.error(r2)     // Catch:{ all -> 0x011e }
            monitor-exit(r1)     // Catch:{ all -> 0x011e }
            return
        L_0x00b6:
            org.json.JSONObject r2 = new org.json.JSONObject     // Catch:{ all -> 0x011e }
            r2.<init>()     // Catch:{ all -> 0x011e }
            r6.g = r2     // Catch:{ all -> 0x011e }
            r6.B()     // Catch:{ all -> 0x011e }
            boolean r2 = r6.r()     // Catch:{ all -> 0x011e }
            if (r2 == 0) goto L_0x00ce
            com.ironsource.v r2 = r6.s     // Catch:{ all -> 0x011e }
            com.ironsource.r8 r2 = r2.g     // Catch:{ all -> 0x011e }
            r2.a()     // Catch:{ all -> 0x011e }
            goto L_0x00d9
        L_0x00ce:
            com.ironsource.v r2 = r6.s     // Catch:{ all -> 0x011e }
            com.ironsource.r8 r2 = r2.g     // Catch:{ all -> 0x011e }
            boolean r3 = r6.n()     // Catch:{ all -> 0x011e }
            r2.a((boolean) r3)     // Catch:{ all -> 0x011e }
        L_0x00d9:
            com.ironsource.r3 r2 = new com.ironsource.r3     // Catch:{ all -> 0x011e }
            r2.<init>()     // Catch:{ all -> 0x011e }
            r6.n = r2     // Catch:{ all -> 0x011e }
            com.ironsource.l r2 = r6.o     // Catch:{ all -> 0x011e }
            boolean r2 = r2.r()     // Catch:{ all -> 0x011e }
            if (r2 == 0) goto L_0x0100
            java.util.concurrent.ConcurrentHashMap<java.lang.String, com.ironsource.mediationsdk.h$a> r2 = r6.b     // Catch:{ all -> 0x011e }
            boolean r2 = r2.isEmpty()     // Catch:{ all -> 0x011e }
            if (r2 != 0) goto L_0x00fc
            com.ironsource.mediationsdk.h r2 = r6.d     // Catch:{ all -> 0x011e }
            java.util.concurrent.ConcurrentHashMap<java.lang.String, com.ironsource.mediationsdk.h$a> r3 = r6.b     // Catch:{ all -> 0x011e }
            r2.a((java.util.concurrent.ConcurrentHashMap<java.lang.String, com.ironsource.mediationsdk.h.a>) r3)     // Catch:{ all -> 0x011e }
            java.util.concurrent.ConcurrentHashMap<java.lang.String, com.ironsource.mediationsdk.h$a> r2 = r6.b     // Catch:{ all -> 0x011e }
            r2.clear()     // Catch:{ all -> 0x011e }
        L_0x00fc:
            r6.G()     // Catch:{ all -> 0x011e }
            goto L_0x0105
        L_0x0100:
            com.ironsource.q1$f r2 = com.ironsource.q1.f.LOADING     // Catch:{ all -> 0x011e }
            r6.a((com.ironsource.q1.f) r2)     // Catch:{ all -> 0x011e }
        L_0x0105:
            monitor-exit(r1)     // Catch:{ all -> 0x011e }
            com.ironsource.l r1 = r6.o
            boolean r1 = r1.r()
            if (r1 != 0) goto L_0x011d
            java.lang.String r1 = "auction disabled"
            java.lang.String r1 = r6.b((java.lang.String) r1)
            r0.verbose(r1)
            r6.H()
            r6.y()
        L_0x011d:
            return
        L_0x011e:
            r0 = move-exception
            monitor-exit(r1)     // Catch:{ all -> 0x011e }
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ironsource.q1.x():void");
    }

    private void y() {
        dd A2 = A();
        if (A2.c()) {
            a((int) IronSourceError.ERROR_CODE_NO_ADS_TO_SHOW, "Mediation No fill", false);
        }
        for (t1 D2 : A2.a()) {
            D2.D();
        }
    }

    /* access modifiers changed from: private */
    public void z() {
        IronLog.INTERNAL.verbose(f());
        AsyncTask.execute(new d());
    }

    /* access modifiers changed from: protected */
    public void C() {
        n.a().a(this.o.b(), this.o.g());
    }

    /* access modifiers changed from: protected */
    public boolean D() {
        return true;
    }

    /* access modifiers changed from: protected */
    public boolean E() {
        return true;
    }

    public void F() {
        for (NetworkSettings b2 : this.o.j()) {
            com.ironsource.mediationsdk.c.b().b(b2, this.o.b(), h());
        }
    }

    /* access modifiers changed from: protected */
    public BaseAdAdapter<?, Listener> a(NetworkSettings networkSettings, IronSource.AD_UNIT ad_unit) {
        BaseAdAdapter<?, ?> a2 = com.ironsource.mediationsdk.c.b().a(networkSettings, ad_unit, h());
        if (a2 != null) {
            return a2;
        }
        return null;
    }

    /* access modifiers changed from: protected */
    public AdData a(NetworkSettings networkSettings, String str) {
        return AdData.createAdDataForNetworkAdapter(b(networkSettings), this.o.b(), str);
    }

    /* access modifiers changed from: protected */
    public abstract Smash a(NetworkSettings networkSettings, BaseAdAdapter<?, Listener> baseAdAdapter, int i2, String str, d1 d1Var);

    /* access modifiers changed from: protected */
    public String a(d1 d1Var, int i2) {
        return String.format("%s%s", new Object[]{Integer.valueOf(i2), d1Var.c()});
    }

    public Map<String, Object> a(t tVar) {
        HashMap hashMap = new HashMap();
        hashMap.put(IronSourceConstants.EVENTS_PROVIDER, "Mediation");
        hashMap.put(IronSourceConstants.EVENTS_PROGRAMMATIC, 1);
        JSONObject jSONObject = this.g;
        if (jSONObject != null && jSONObject.length() > 0) {
            hashMap.put("genericParams", this.g);
        }
        hashMap.put("sessionDepth", Integer.valueOf(this.C.a(this.o.b())));
        if (c(tVar)) {
            hashMap.put(IronSourceConstants.AUCTION_TRIALS, Integer.valueOf(this.e));
            if (!TextUtils.isEmpty(this.f)) {
                hashMap.put(IronSourceConstants.AUCTION_FALLBACK, this.f);
            }
        }
        if (b(tVar) && !TextUtils.isEmpty(this.a.c())) {
            hashMap.put("auctionId", this.a.c());
        }
        return hashMap;
    }

    public void a() {
        IronLog.INTERNAL.verbose(f());
        w();
    }

    public void a(int i2) {
        oc ocVar = this.s.k;
        ocVar.q("waterfalls hold too many with size = " + i2);
    }

    public void a(int i2, String str, int i3, String str2, long j2) {
        IronLog ironLog = IronLog.INTERNAL;
        ironLog.verbose(f());
        if (u()) {
            String str3 = "Auction failed | moving to fallback waterfall (error " + i2 + " - " + str + ")";
            ironLog.verbose(b(str3));
            IronSourceUtils.sendAutomationLog(i() + ": " + str3);
            this.e = i3;
            this.f = str2;
            this.g = new JSONObject();
            H();
            this.s.i.a(j2, i2, str);
            a(f.LOADING);
            y();
            return;
        }
        String str4 = "unexpected auction fail - error = " + i2 + ", " + str + " state = " + this.p;
        ironLog.error(b(str4));
        this.s.k.e(str4);
    }

    /* access modifiers changed from: protected */
    public void a(int i2, String str, boolean z2) {
        a(f.READY_TO_LOAD);
        IronLog ironLog = IronLog.INTERNAL;
        ironLog.verbose(b("errorCode = " + i2 + ", errorReason = " + str));
        if (this.o.h().f()) {
            if (!z2) {
                this.s.g.a(r3.a(this.n), i2, str);
            }
            a(new IronSourceError(i2, str), false);
        } else {
            if (!z2) {
                this.s.k.b(i2, str);
            }
            b(false);
        }
        this.q.c();
    }

    /* access modifiers changed from: protected */
    public void a(Context context, i iVar, t0 t0Var) {
        com.ironsource.mediationsdk.e eVar = this.c;
        if (eVar != null) {
            eVar.a(context, iVar, t0Var);
        } else {
            IronLog.INTERNAL.error(b("mAuctionHandler is null"));
        }
    }

    public void a(Context context, boolean z2) {
        IronLog ironLog = IronLog.INTERNAL;
        ironLog.verbose(b("track = " + z2));
        try {
            this.j = z2;
            if (z2) {
                if (this.k == null) {
                    this.k = new NetworkStateReceiver(context, this);
                }
                context.getApplicationContext().registerReceiver(this.k, new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
            } else if (this.k != null) {
                context.getApplicationContext().unregisterReceiver(this.k);
            }
        } catch (Exception e2) {
            IronLog ironLog2 = IronLog.INTERNAL;
            ironLog2.error("Got an error from receiver with message: " + e2.getMessage());
        }
    }

    public void a(IronSourceSegment ironSourceSegment) {
        this.v = ironSourceSegment;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:20:0x006f, code lost:
        if (r7 != null) goto L_0x0072;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0071, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x0078, code lost:
        if (r6.o.m() == false) goto L_0x00a4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x007a, code lost:
        r8 = r6.x;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x007c, code lost:
        monitor-enter(r8);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x0081, code lost:
        if (r7.b() == false) goto L_0x009f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x0087, code lost:
        if (s() == false) goto L_0x009f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:0x0089, code lost:
        r0 = new com.ironsource.cd(r6.o).c(r6.a.b());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:32:0x009a, code lost:
        if (r0 == null) goto L_0x009f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:33:0x009c, code lost:
        i(r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:34:0x009f, code lost:
        monitor-exit(r8);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:39:0x00a4, code lost:
        r7 = r7.a().iterator();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:41:0x00b0, code lost:
        if (r7.hasNext() == false) goto L_0x00bc;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:42:0x00b2, code lost:
        ((com.ironsource.t1) r7.next()).D();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:43:0x00bc, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void a(com.ironsource.mediationsdk.logger.IronSourceError r7, com.ironsource.t1<?> r8) {
        /*
            r6 = this;
            java.lang.String r0 = "onAdLoadFailed was invoked with state ="
            java.lang.String r1 = "onAdLoadFailed was invoked from "
            java.lang.Object r2 = r6.x
            monitor-enter(r2)
            com.ironsource.mediationsdk.logger.IronLog r3 = com.ironsource.mediationsdk.logger.IronLog.INTERNAL     // Catch:{ all -> 0x010f }
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ all -> 0x010f }
            r4.<init>()     // Catch:{ all -> 0x010f }
            java.lang.String r5 = r8.k()     // Catch:{ all -> 0x010f }
            r4.append(r5)     // Catch:{ all -> 0x010f }
            java.lang.String r5 = " - error = "
            r4.append(r5)     // Catch:{ all -> 0x010f }
            r4.append(r7)     // Catch:{ all -> 0x010f }
            java.lang.String r7 = r4.toString()     // Catch:{ all -> 0x010f }
            java.lang.String r7 = r6.b((java.lang.String) r7)     // Catch:{ all -> 0x010f }
            r3.verbose(r7)     // Catch:{ all -> 0x010f }
            java.lang.String r7 = r8.h()     // Catch:{ all -> 0x010f }
            com.ironsource.zc<Smash> r4 = r6.a     // Catch:{ all -> 0x010f }
            java.lang.String r4 = r4.c()     // Catch:{ all -> 0x010f }
            boolean r7 = r7.equals(r4)     // Catch:{ all -> 0x010f }
            if (r7 == 0) goto L_0x00bd
            com.ironsource.q1$f r7 = r6.p     // Catch:{ all -> 0x010f }
            com.ironsource.q1$f r4 = com.ironsource.q1.f.AUCTION     // Catch:{ all -> 0x010f }
            if (r7 != r4) goto L_0x0040
            goto L_0x00bd
        L_0x0040:
            java.util.concurrent.ConcurrentHashMap<java.lang.String, com.ironsource.mediationsdk.h$a> r7 = r6.b     // Catch:{ all -> 0x010f }
            java.lang.String r8 = r8.c()     // Catch:{ all -> 0x010f }
            com.ironsource.mediationsdk.h$a r0 = com.ironsource.mediationsdk.h.a.ISAuctionPerformanceFailedToLoad     // Catch:{ all -> 0x010f }
            r7.put(r8, r0)     // Catch:{ all -> 0x010f }
            boolean r7 = r6.v()     // Catch:{ all -> 0x010f }
            if (r7 != 0) goto L_0x005a
            boolean r7 = r6.t()     // Catch:{ all -> 0x010f }
            if (r7 == 0) goto L_0x0058
            goto L_0x005a
        L_0x0058:
            r7 = 0
            goto L_0x006e
        L_0x005a:
            com.ironsource.dd r7 = r6.A()     // Catch:{ all -> 0x010f }
            boolean r8 = r7.c()     // Catch:{ all -> 0x010f }
            if (r8 == 0) goto L_0x006e
            java.lang.String r7 = "Mediation No fill"
            r8 = 0
            r0 = 509(0x1fd, float:7.13E-43)
            r6.a((int) r0, (java.lang.String) r7, (boolean) r8)     // Catch:{ all -> 0x010f }
            monitor-exit(r2)     // Catch:{ all -> 0x010f }
            return
        L_0x006e:
            monitor-exit(r2)     // Catch:{ all -> 0x010f }
            if (r7 != 0) goto L_0x0072
            return
        L_0x0072:
            com.ironsource.l r8 = r6.o
            boolean r8 = r8.m()
            if (r8 == 0) goto L_0x00a4
            java.lang.Object r8 = r6.x
            monitor-enter(r8)
            boolean r0 = r7.b()     // Catch:{ all -> 0x00a1 }
            if (r0 == 0) goto L_0x009f
            boolean r0 = r6.s()     // Catch:{ all -> 0x00a1 }
            if (r0 == 0) goto L_0x009f
            com.ironsource.cd r0 = new com.ironsource.cd     // Catch:{ all -> 0x00a1 }
            com.ironsource.l r1 = r6.o     // Catch:{ all -> 0x00a1 }
            r0.<init>(r1)     // Catch:{ all -> 0x00a1 }
            com.ironsource.zc<Smash> r1 = r6.a     // Catch:{ all -> 0x00a1 }
            java.util.List r1 = r1.b()     // Catch:{ all -> 0x00a1 }
            com.ironsource.t1 r0 = r0.c(r1)     // Catch:{ all -> 0x00a1 }
            if (r0 == 0) goto L_0x009f
            r6.i(r0)     // Catch:{ all -> 0x00a1 }
        L_0x009f:
            monitor-exit(r8)     // Catch:{ all -> 0x00a1 }
            goto L_0x00a4
        L_0x00a1:
            r7 = move-exception
            monitor-exit(r8)     // Catch:{ all -> 0x00a1 }
            throw r7
        L_0x00a4:
            java.util.List r7 = r7.a()
            java.util.Iterator r7 = r7.iterator()
        L_0x00ac:
            boolean r8 = r7.hasNext()
            if (r8 == 0) goto L_0x00bc
            java.lang.Object r8 = r7.next()
            com.ironsource.t1 r8 = (com.ironsource.t1) r8
            r8.D()
            goto L_0x00ac
        L_0x00bc:
            return
        L_0x00bd:
            java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch:{ all -> 0x010f }
            r7.<init>(r1)     // Catch:{ all -> 0x010f }
            java.lang.String r1 = r8.c()     // Catch:{ all -> 0x010f }
            r7.append(r1)     // Catch:{ all -> 0x010f }
            java.lang.String r1 = " with state ="
            r7.append(r1)     // Catch:{ all -> 0x010f }
            com.ironsource.q1$f r1 = r6.p     // Catch:{ all -> 0x010f }
            r7.append(r1)     // Catch:{ all -> 0x010f }
            java.lang.String r1 = " auctionId: "
            r7.append(r1)     // Catch:{ all -> 0x010f }
            java.lang.String r8 = r8.h()     // Catch:{ all -> 0x010f }
            r7.append(r8)     // Catch:{ all -> 0x010f }
            java.lang.String r8 = " and the current id is "
            r7.append(r8)     // Catch:{ all -> 0x010f }
            com.ironsource.zc<Smash> r8 = r6.a     // Catch:{ all -> 0x010f }
            java.lang.String r8 = r8.c()     // Catch:{ all -> 0x010f }
            r7.append(r8)     // Catch:{ all -> 0x010f }
            java.lang.String r7 = r7.toString()     // Catch:{ all -> 0x010f }
            java.lang.String r7 = r6.b((java.lang.String) r7)     // Catch:{ all -> 0x010f }
            r3.error(r7)     // Catch:{ all -> 0x010f }
            com.ironsource.v r7 = r6.s     // Catch:{ all -> 0x010f }
            com.ironsource.oc r7 = r7.k     // Catch:{ all -> 0x010f }
            java.lang.StringBuilder r8 = new java.lang.StringBuilder     // Catch:{ all -> 0x010f }
            r8.<init>(r0)     // Catch:{ all -> 0x010f }
            com.ironsource.q1$f r0 = r6.p     // Catch:{ all -> 0x010f }
            r8.append(r0)     // Catch:{ all -> 0x010f }
            java.lang.String r8 = r8.toString()     // Catch:{ all -> 0x010f }
            r7.j(r8)     // Catch:{ all -> 0x010f }
            monitor-exit(r2)     // Catch:{ all -> 0x010f }
            return
        L_0x010f:
            r7 = move-exception
            monitor-exit(r2)     // Catch:{ all -> 0x010f }
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ironsource.q1.a(com.ironsource.mediationsdk.logger.IronSourceError, com.ironsource.t1):void");
    }

    /* access modifiers changed from: protected */
    public void a(IronSourceError ironSourceError, boolean z2) {
        n.a().b(this.o.b(), ironSourceError, z2);
    }

    public void a(NetworkSettings networkSettings) {
        AdapterBaseInterface b2 = com.ironsource.mediationsdk.c.b().b(networkSettings, this.o.b(), h());
        if (b2 != null) {
            this.s.h.a(a(networkSettings, b2));
        }
    }

    /* access modifiers changed from: protected */
    public void a(f fVar) {
        synchronized (this.x) {
            this.p = fVar;
        }
    }

    /* access modifiers changed from: protected */
    public void a(t1<?> t1Var, AdInfo adInfo) {
        this.t.c(adInfo);
    }

    public void a(wb wbVar) {
        this.F = wbVar;
        this.E = wbVar != null;
        this.z = null;
    }

    /* access modifiers changed from: protected */
    public void a(x xVar) {
        this.t = xVar;
    }

    public void a(Runnable runnable) {
        u7 u7Var = this.H;
        if (u7Var != null) {
            u7Var.a(runnable);
        }
    }

    public void a(String str) {
        this.s.k.c(str);
    }

    public void a(List<d1> list, String str, d1 d1Var, JSONObject jSONObject, JSONObject jSONObject2, int i2, long j2, int i3, String str2) {
        IronLog ironLog = IronLog.INTERNAL;
        ironLog.verbose(f());
        if (u()) {
            this.f = "";
            this.e = i2;
            this.h = d1Var;
            this.g = jSONObject;
            if (!TextUtils.isEmpty(str2)) {
                this.s.k.a(i3, str2);
            }
            a(jSONObject2);
            if (this.u.a(this.o.b())) {
                this.s.i.a(str);
                a((int) IronSourceError.ERROR_AD_UNIT_CAPPED, "Ad unit is capped", true);
                return;
            }
            String a2 = a(list, str);
            this.s.i.a(j2, this.o.s());
            this.s.i.c(a2);
            a(f.LOADING);
            y();
            return;
        }
        ironLog.error(b("unexpected auction success for auctionId - " + str + " state = " + this.p));
        oc ocVar = this.s.k;
        StringBuilder sb = new StringBuilder("unexpected auction success, state = ");
        sb.append(this.p);
        ocVar.f(sb.toString());
    }

    public void a(boolean z2) {
        if (this.j && !this.o.h().f()) {
            IronLog ironLog = IronLog.INTERNAL;
            ironLog.verbose("network availability changed to - " + z2);
            if (c(z2)) {
                a(z2, false, (t1<?>) null);
            }
        }
    }

    /* access modifiers changed from: protected */
    public void a(boolean z2, boolean z3, t1<?> t1Var) {
        synchronized (this.x) {
            Boolean bool = this.z;
            if (bool == null || bool.booleanValue() != z2) {
                this.z = Boolean.valueOf(z2);
                long j2 = 0;
                if (this.y != 0) {
                    j2 = new Date().getTime() - this.y;
                }
                this.y = new Date().getTime();
                this.s.g.a(z2, j2, z3);
                AdInfo f2 = t1Var != null ? t1Var.f() : this.A;
                this.A = f2;
                x xVar = this.t;
                if (!z2) {
                    f2 = null;
                }
                xVar.a(z2, f2);
            }
        }
    }

    /* access modifiers changed from: protected */
    public boolean a(f fVar, f fVar2) {
        boolean z2;
        synchronized (this.x) {
            if (this.p == fVar) {
                this.p = fVar2;
                z2 = true;
            } else {
                z2 = false;
            }
        }
        return z2;
    }

    /* access modifiers changed from: protected */
    public String b(String str) {
        String name = this.o.b().name();
        if (TextUtils.isEmpty(str)) {
            return name;
        }
        return name + " - " + str;
    }

    /* access modifiers changed from: protected */
    public abstract JSONObject b(NetworkSettings networkSettings);

    public void b() {
        if (this.o.h().e()) {
            a(f.READY_TO_LOAD);
            b(true);
            w();
        }
    }

    /* access modifiers changed from: protected */
    public void b(d1 d1Var, String str) {
        if (d1Var != null) {
            ImpressionData a2 = d1Var.a(str);
            if (a2 != null) {
                for (ImpressionDataListener impressionDataListener : new HashSet(this.B.a())) {
                    IronLog ironLog = IronLog.CALLBACK;
                    ironLog.info(b("onImpressionSuccess " + impressionDataListener.getClass().getSimpleName() + ": " + a2));
                    impressionDataListener.onImpressionSuccess(a2);
                }
                return;
            }
            return;
        }
        IronLog.INTERNAL.error(b("reportImpressionDataToPublisher - no auctionResponseItem or listener"));
        v vVar = this.s;
        if (vVar != null) {
            vVar.k.c("reportImpressionDataToPublisher - no auctionResponseItem or listener");
        }
    }

    public void b(t1<?> t1Var) {
        IronLog ironLog = IronLog.INTERNAL;
        ironLog.verbose(b(t1Var.k()));
        this.s.j.e(k());
        this.a.a(t1Var);
        this.l.a(t1Var);
        if (this.l.b(t1Var)) {
            ironLog.verbose(b(t1Var.c() + " was session capped"));
            t1Var.M();
            IronSourceUtils.sendAutomationLog(t1Var.c() + " was session capped");
        }
        com.ironsource.mediationsdk.utils.b.a(ContextProvider.getInstance().getApplicationContext(), k(), this.o.b());
        if (com.ironsource.mediationsdk.utils.b.b(ContextProvider.getInstance().getApplicationContext(), k(), this.o.b())) {
            ironLog.verbose(b("placement " + k() + " is capped"));
            this.s.j.i(k());
        }
        this.D.b(this.o.b());
        if (this.o.r()) {
            d1 i2 = t1Var.i();
            this.c.a(i2, t1Var.l(), this.h, k());
            this.b.put(t1Var.c(), h.a.ISAuctionPerformanceShowedSuccessfully);
            if (D()) {
                b(i2, k());
            }
        }
        g(t1Var);
        if (this.o.h().e()) {
            b(false);
        }
        this.q.f();
    }

    /* access modifiers changed from: protected */
    public void b(boolean z2) {
        a(false, z2, (t1<?>) null);
    }

    public boolean c() {
        return this.o.o() || this.o.l();
    }

    /* access modifiers changed from: protected */
    public abstract x e();

    public void e(t1<?> t1Var) {
        IronLog ironLog = IronLog.INTERNAL;
        ironLog.verbose(b(t1Var.k()));
        if (!t1Var.h().equals(this.a.c())) {
            ironLog.error(b("invoked from " + t1Var.c() + " with state = " + this.p + " auctionId: " + t1Var.h() + " and the current id is " + this.a.c()));
            oc ocVar = this.s.k;
            StringBuilder sb = new StringBuilder("onAdLoadSuccess invoked with state = ");
            sb.append(this.p);
            ocVar.k(sb.toString());
            return;
        }
        if (this.o.m()) {
            List<Smash> b2 = this.a.b();
            cd cdVar = new cd(this.o);
            boolean a2 = cdVar.a(t1Var, b2);
            synchronized (this.x) {
                if (a2) {
                    if (s()) {
                        i(t1Var);
                    }
                }
                if (cdVar.a(b2)) {
                    i(cdVar.c(b2));
                }
            }
        }
        this.b.put(t1Var.c(), h.a.ISAuctionPerformanceLoadedSuccessfully);
        if (a(f.LOADING, f.READY_TO_SHOW)) {
            long a3 = r3.a(this.n);
            if (r()) {
                this.s.g.a(a3);
            } else {
                this.s.g.a(a3, n());
            }
            if (this.o.h().e()) {
                this.r.a(0);
            }
            if (!this.o.m()) {
                i(t1Var);
            }
            h(t1Var);
        }
    }

    /* access modifiers changed from: protected */
    public String f() {
        return b((String) null);
    }

    public void f(t1<?> t1Var) {
        IronLog.INTERNAL.verbose(b(t1Var.k()));
        this.s.j.a(k());
        this.t.a(this.i, t1Var.f());
    }

    /* access modifiers changed from: protected */
    public void g(t1<?> t1Var) {
        this.t.d(t1Var.f());
    }

    public UUID h() {
        return this.w;
    }

    /* access modifiers changed from: protected */
    public void h(t1<?> t1Var) {
        if (this.o.h().f()) {
            a(t1Var, t1Var.f());
        } else {
            a(true, false, t1Var);
        }
    }

    /* access modifiers changed from: protected */
    public abstract String i();

    /* access modifiers changed from: protected */
    public void i(t1<?> t1Var) {
        if (this.o.r() && this.G.compareAndSet(false, true)) {
            d1 i2 = t1Var.i();
            this.c.a(i2, t1Var.l(), this.h);
            ArrayList arrayList = new ArrayList();
            ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap();
            for (Smash smash : this.a.b()) {
                arrayList.add(smash.c());
                concurrentHashMap.put(smash.c(), smash.i());
            }
            this.c.a((ArrayList<String>) arrayList, (ConcurrentHashMap<String, d1>) concurrentHashMap, t1Var.l(), this.h, i2);
        }
    }

    /* access modifiers changed from: protected */
    public String j() {
        return "fallback_" + System.currentTimeMillis();
    }

    /* access modifiers changed from: protected */
    public String k() {
        Placement placement = this.i;
        return placement == null ? "" : placement.getPlacementName();
    }

    /* access modifiers changed from: package-private */
    public abstract String l();

    /* access modifiers changed from: protected */
    public boolean n() {
        return false;
    }

    /* access modifiers changed from: protected */
    public boolean q() {
        return false;
    }

    /* access modifiers changed from: protected */
    public abstract boolean r();

    /* access modifiers changed from: protected */
    public boolean s() {
        boolean z2;
        synchronized (this.x) {
            f fVar = this.p;
            if (fVar != f.LOADING) {
                if (fVar != f.READY_TO_SHOW) {
                    z2 = false;
                }
            }
            z2 = true;
        }
        return z2;
    }

    /* access modifiers changed from: protected */
    public boolean t() {
        boolean z2;
        synchronized (this.x) {
            z2 = this.p == f.READY_TO_SHOW;
        }
        return z2;
    }

    /* access modifiers changed from: protected */
    public boolean u() {
        boolean z2;
        synchronized (this.x) {
            z2 = this.p == f.AUCTION;
        }
        return z2;
    }

    /* access modifiers changed from: protected */
    public boolean v() {
        boolean z2;
        synchronized (this.x) {
            z2 = this.p == f.LOADING;
        }
        return z2;
    }

    public void w() {
        if (!c()) {
            x();
        } else {
            a((Runnable) new a());
        }
    }
}
