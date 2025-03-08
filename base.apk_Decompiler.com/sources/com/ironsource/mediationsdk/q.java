package com.ironsource.mediationsdk;

import android.app.Activity;
import android.content.Context;
import android.content.IntentFilter;
import android.os.AsyncTask;
import android.text.TextUtils;
import android.util.Log;
import com.ironsource.a2;
import com.ironsource.b2;
import com.ironsource.d1;
import com.ironsource.environment.ContextProvider;
import com.ironsource.environment.NetworkStateReceiver;
import com.ironsource.environment.thread.IronSourceThreadManager;
import com.ironsource.i;
import com.ironsource.i4;
import com.ironsource.j8;
import com.ironsource.k5;
import com.ironsource.kb;
import com.ironsource.l9;
import com.ironsource.m8;
import com.ironsource.mediationsdk.IronSource;
import com.ironsource.mediationsdk.adunit.adapter.utility.AdData;
import com.ironsource.mediationsdk.h;
import com.ironsource.mediationsdk.impressionData.ImpressionDataListener;
import com.ironsource.mediationsdk.logger.IronLog;
import com.ironsource.mediationsdk.logger.IronSourceError;
import com.ironsource.mediationsdk.logger.IronSourceLogger;
import com.ironsource.mediationsdk.logger.IronSourceLoggerManager;
import com.ironsource.mediationsdk.model.NetworkSettings;
import com.ironsource.mediationsdk.model.Placement;
import com.ironsource.mediationsdk.utils.ErrorBuilder;
import com.ironsource.mediationsdk.utils.IronSourceConstants;
import com.ironsource.mediationsdk.utils.IronSourceUtils;
import com.ironsource.n8;
import com.ironsource.oa;
import com.ironsource.t0;
import com.ironsource.ua;
import com.ironsource.va;
import com.ironsource.x1;
import com.ironsource.xa;
import com.ironsource.y1;
import com.ironsource.y3;
import com.ironsource.ya;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.TimeUnit;
import org.json.JSONObject;

class q extends m implements m8, ya, t0, k5, l9, i {
    private long A;
    private Boolean B;
    private final Object C = new Object();
    private i4 D;
    /* access modifiers changed from: private */
    public final boolean E;
    private final long F;
    private n8 e;
    private ConcurrentHashMap<String, d1> f;
    private ConcurrentHashMap<String, h.a> g;
    private d1 h;
    private h i;
    private e j;
    private JSONObject k;
    private xa l;
    private boolean m;
    /* access modifiers changed from: private */
    public long n;
    private String o = "";
    private int p;
    private NetworkStateReceiver q;
    private boolean r = false;
    /* access modifiers changed from: private */
    public final ConcurrentHashMap<String, r> s;
    private kb t;
    private int u = 1;
    private String v;
    private int w;
    private boolean x;
    private boolean y;
    private e z;

    class a implements Runnable {
        final /* synthetic */ NetworkSettings a;
        final /* synthetic */ ua b;
        final /* synthetic */ String c;
        final /* synthetic */ String d;

        a(NetworkSettings networkSettings, ua uaVar, String str, String str2) {
            this.a = networkSettings;
            this.b = uaVar;
            this.c = str;
            this.d = str2;
        }

        public void run() {
            q.this.a(this.a, this.b, this.c, this.d);
        }
    }

    class b extends TimerTask {
        b() {
        }

        public void run() {
            q.this.j();
        }
    }

    class c implements Runnable {
        c() {
        }

        public void run() {
            q.this.d("makeAuction()");
            long unused = q.this.n = new Date().getTime();
            HashMap hashMap = new HashMap();
            ArrayList arrayList = new ArrayList();
            StringBuilder sb = new StringBuilder();
            ArrayList arrayList2 = new ArrayList();
            q.this.b(hashMap, arrayList, sb, arrayList2);
            if (q.this.E) {
                q.this.a((Map<String, Object>) hashMap, (List<String>) arrayList, sb, (List<x1>) arrayList2);
            } else {
                q.this.a((Map<String, Object>) hashMap, (List<String>) arrayList, sb.toString());
            }
        }
    }

    class d implements a2.b {
        final /* synthetic */ Map a;
        final /* synthetic */ StringBuilder b;
        final /* synthetic */ List c;

        d(Map map, StringBuilder sb, List list) {
            this.a = map;
            this.b = sb;
            this.c = list;
        }

        public void a(List<b2> list, long j, List<String> list2) {
            q.this.c((int) IronSourceConstants.RV_COLLECT_TOKENS_COMPLETED, j8.a(new Object[][]{new Object[]{IronSourceConstants.EVENTS_DURATION, Long.valueOf(j)}}));
            for (b2 next : list) {
                r rVar = (r) q.this.s.get(next.c());
                if (next.a() != null) {
                    this.a.put(next.c(), next.a());
                    StringBuilder sb = this.b;
                    sb.append(next.d());
                    sb.append(next.c());
                    sb.append(",");
                    if (rVar != null) {
                        rVar.a(1021, new Object[][]{new Object[]{IronSourceConstants.EVENTS_DURATION, Long.valueOf(next.e())}});
                    }
                } else if (rVar != null) {
                    rVar.a(1022, new Object[][]{new Object[]{IronSourceConstants.EVENTS_DURATION, Long.valueOf(next.e())}, new Object[]{"reason", next.b()}});
                }
            }
            for (String str : list2) {
                r rVar2 = (r) q.this.s.get(str);
                if (rVar2 != null) {
                    rVar2.a(1023, new Object[][]{new Object[]{IronSourceConstants.EVENTS_DURATION, Long.valueOf(j)}});
                }
            }
            q.this.a((Map<String, Object>) this.a, (List<String>) this.c, this.b.toString());
        }

        public void onFailure(String str) {
            q.this.c((int) IronSourceConstants.RV_COLLECT_TOKENS_FAILED, j8.a(new Object[][]{new Object[]{"reason", str}}));
            q.this.a((Map<String, Object>) this.a, (List<String>) this.c, this.b.toString());
        }
    }

    private enum e {
        RV_STATE_INITIATING,
        RV_STATE_AUCTION_IN_PROGRESS,
        RV_STATE_NOT_LOADED,
        RV_STATE_LOADING_SMASHES,
        RV_STATE_READY_TO_SHOW
    }

    public q(List<NetworkSettings> list, ua uaVar, String str, String str2, HashSet<ImpressionDataListener> hashSet, IronSourceSegment ironSourceSegment) {
        super(hashSet, ironSourceSegment);
        long time = new Date().getTime();
        c((int) IronSourceConstants.RV_MANAGER_INIT_STARTED, j8.a(new Object[][]{new Object[]{IronSourceConstants.EVENTS_EXT1, IronSourceConstants.LWS_RV_MANAGER_NAME}}));
        a(e.RV_STATE_INITIATING);
        this.B = null;
        this.w = uaVar.g();
        this.x = uaVar.j();
        this.v = "";
        this.k = null;
        com.ironsource.mediationsdk.utils.a k2 = uaVar.k();
        this.y = false;
        this.e = new n8(uaVar.k().f(), uaVar.k().i());
        this.f = new ConcurrentHashMap<>();
        this.g = new ConcurrentHashMap<>();
        this.A = new Date().getTime();
        boolean z2 = k2.g() > 0;
        this.m = z2;
        if (z2) {
            this.j = new e(IronSource.AD_UNIT.REWARDED_VIDEO, k2, this);
        }
        this.l = new xa(k2, this);
        ConcurrentHashMap<String, r> concurrentHashMap = new ConcurrentHashMap<>();
        this.s = concurrentHashMap;
        a(list, uaVar, str, str2);
        this.i = new h(list, k2.c());
        this.t = new kb(new ArrayList(concurrentHashMap.values()));
        this.D = new i4(uaVar.c(), this);
        this.E = uaVar.l();
        this.F = uaVar.m();
        c((int) IronSourceConstants.RV_MANAGER_INIT_ENDED, j8.a(new Object[][]{new Object[]{IronSourceConstants.EVENTS_DURATION, Long.valueOf(new Date().getTime() - time)}}));
        a(k2.k());
    }

    private String a(d1 d1Var) {
        r rVar = this.s.get(d1Var.c());
        String num = rVar != null ? Integer.toString(rVar.g()) : TextUtils.isEmpty(d1Var.j()) ? "1" : "2";
        return num + d1Var.c();
    }

    private void a(int i2) {
        a(i2, (Map<String, Object>) null, true, true);
    }

    private void a(int i2, Map<String, Object> map) {
        a(i2, map, false, true);
    }

    private void a(int i2, Map<String, Object> map, boolean z2, boolean z3) {
        HashMap hashMap = new HashMap();
        hashMap.put(IronSourceConstants.EVENTS_PROVIDER, "Mediation");
        hashMap.put(IronSourceConstants.EVENTS_PROGRAMMATIC, 2);
        if (z3 && !TextUtils.isEmpty(this.e.d())) {
            hashMap.put("auctionId", this.e.d());
        }
        JSONObject jSONObject = this.k;
        if (jSONObject != null && jSONObject.length() > 0) {
            hashMap.put("genericParams", this.k);
        }
        if (z2 && !TextUtils.isEmpty(this.v)) {
            hashMap.put("placement", this.v);
        }
        if (c(i2)) {
            va.i().a((Map<String, Object>) hashMap, this.p, this.o);
        }
        hashMap.put("sessionDepth", Integer.valueOf(this.u));
        if (map != null) {
            try {
                if (!map.isEmpty()) {
                    hashMap.putAll(map);
                }
            } catch (Exception e2) {
                IronSourceLoggerManager logger = IronSourceLoggerManager.getLogger();
                IronSourceLogger.IronSourceTag ironSourceTag = IronSourceLogger.IronSourceTag.INTERNAL;
                logger.log(ironSourceTag, "LWSProgRvManager: RV sendMediationEvent " + Log.getStackTraceString(e2), 3);
            }
        }
        va.i().a(new y3(i2, new JSONObject(hashMap)));
    }

    private void a(long j2) {
        Map<String, Object> a2;
        if (this.t.a()) {
            d("all smashes are capped");
            a2 = j8.a(new Object[][]{new Object[]{"errorCode", Integer.valueOf(IronSourceConstants.TROUBLESHOOTING_MEDIATION_TCS_CALCULATED)}, new Object[]{"reason", "all smashes are capped"}});
        } else {
            a(IronSource.AD_UNIT.REWARDED_VIDEO);
            if (this.m) {
                if (!this.g.isEmpty()) {
                    this.i.a(this.g);
                    this.g.clear();
                }
                new Timer().schedule(new b(), j2);
                return;
            }
            d("auction fallback flow starting");
            k();
            if (this.e.c().isEmpty()) {
                d("loadSmashes -  waterfall is empty");
                a2 = j8.a(new Object[][]{new Object[]{"errorCode", 80004}, new Object[]{"reason", "waterfall is empty"}});
            } else {
                b(1000);
                i();
                return;
            }
        }
        a((int) IronSourceConstants.TROUBLESHOOTING_RV_LOAD_FAILED, a2);
        h();
    }

    /* access modifiers changed from: private */
    public void a(NetworkSettings networkSettings, ua uaVar, String str, String str2) {
        IronLog ironLog = IronLog.INTERNAL;
        ironLog.verbose(String.format("Start initializing provider %s on thread %s", new Object[]{networkSettings.getProviderInstanceName(), Thread.currentThread().getName()}));
        AbstractAdapter a2 = c.b().a(networkSettings, networkSettings.getRewardedVideoSettings(), false);
        if (a2 != null) {
            r rVar = new r(str, str2, networkSettings, this, uaVar.h(), a2, this.u);
            this.s.put(rVar.c(), rVar);
        }
        ironLog.verbose(String.format("Done initializing provider %s on thread %s", new Object[]{networkSettings.getProviderInstanceName(), Thread.currentThread().getName()}));
    }

    private void a(e eVar) {
        d("current state=" + this.z + ", new state=" + eVar);
        this.z = eVar;
    }

    private void a(r rVar, String str) {
        String str2 = rVar.c() + " : " + str;
        IronSourceLoggerManager.getLogger().log(IronSourceLogger.IronSourceTag.ADAPTER_CALLBACK, "LWSProgRvManager: " + str2, 0);
    }

    private void a(String str) {
        IronSourceLoggerManager.getLogger().log(IronSourceLogger.IronSourceTag.API, str, 3);
    }

    private void a(List<NetworkSettings> list, ua uaVar, String str, String str2) {
        ArrayList arrayList = new ArrayList();
        for (NetworkSettings aVar : list) {
            arrayList.add(new a(aVar, uaVar, str, str2));
        }
        IronSourceThreadManager.INSTANCE.executeTasks(uaVar.f(), uaVar.q(), arrayList);
    }

    private void a(List<d1> list, String str, JSONObject jSONObject) {
        this.f.clear();
        this.g.clear();
        CopyOnWriteArrayList copyOnWriteArrayList = new CopyOnWriteArrayList();
        StringBuilder sb = new StringBuilder();
        for (d1 next : list) {
            sb.append(a(next) + ",");
            r rVar = this.s.get(next.c());
            if (rVar != null) {
                AbstractAdapter a2 = c.b().a(rVar.b.h());
                if (a2 != null) {
                    r rVar2 = new r(rVar, this, a2, this.u, str, jSONObject, this.p, this.o);
                    rVar2.a(true);
                    copyOnWriteArrayList.add(rVar2);
                    this.f.put(rVar2.c(), next);
                    this.g.put(next.c(), h.a.ISAuctionPerformanceDidntAttemptToLoad);
                }
            } else {
                d("updateWaterfall() - could not find matching smash for auction response item " + next.c());
            }
        }
        this.e.a((CopyOnWriteArrayList<r>) copyOnWriteArrayList, str);
        if (this.e.a()) {
            a((int) IronSourceConstants.TROUBLESHOOTING_RV_WATERFALL_OVERHEAD, j8.a(new Object[][]{new Object[]{"reason", "waterfalls hold too many with size=" + this.e.e()}}));
        }
        d("updateWaterfall() - next waterfall is " + sb.toString());
        if (sb.length() == 0) {
            d("Updated waterfall is empty");
        }
        a((int) IronSourceConstants.RV_AUCTION_RESPONSE_WATERFALL, j8.a(new Object[][]{new Object[]{IronSourceConstants.EVENTS_EXT1, sb.toString()}}));
    }

    /* access modifiers changed from: private */
    public void a(Map<String, Object> map, List<String> list, String str) {
        if (map.keySet().size() == 0 && list.size() == 0) {
            c((int) IronSourceConstants.RV_AUCTION_FAILED, j8.a(new Object[][]{new Object[]{"errorCode", 1005}, new Object[]{IronSourceConstants.EVENTS_DURATION, 0}}));
            d("makeAuction() failed - No candidates available for auctioning");
            h();
            return;
        }
        d("makeAuction() - request waterfall is: " + str);
        b(1000);
        b((int) IronSourceConstants.RV_AUCTION_REQUEST);
        c((int) IronSourceConstants.RV_AUCTION_REQUEST_WATERFALL, j8.a(new Object[][]{new Object[]{IronSourceConstants.EVENTS_EXT1, str.toString()}}));
        this.j.a(ContextProvider.getInstance().getApplicationContext(), map, list, this.i, this.u, this.c);
    }

    /* access modifiers changed from: private */
    public void a(Map<String, Object> map, List<String> list, StringBuilder sb, List<x1> list2) {
        if (list2.isEmpty()) {
            a(map, list, sb.toString());
            return;
        }
        a2 a2Var = new a2();
        d dVar = new d(map, sb, list);
        b((int) IronSourceConstants.RV_COLLECT_TOKENS);
        a2Var.a(list2, (a2.b) dVar, this.F, TimeUnit.MILLISECONDS);
    }

    private void a(boolean z2, Map<String, Object> map) {
        synchronized (this.C) {
            Boolean bool = this.B;
            if (bool == null || bool.booleanValue() != z2) {
                this.B = Boolean.valueOf(z2);
                long time = new Date().getTime() - this.A;
                this.A = new Date().getTime();
                if (map == null) {
                    map = new HashMap<>();
                }
                map.put(IronSourceConstants.EVENTS_DURATION, Long.valueOf(time));
                a(z2 ? IronSourceConstants.RV_CALLBACK_AVAILABILITY_TRUE : IronSourceConstants.RV_CALLBACK_AVAILABILITY_FALSE, map);
                oa a2 = oa.a();
                n8 n8Var = this.e;
                a2.a(z2, n8Var.a(n8Var.d()));
            }
        }
    }

    private void b(int i2) {
        a(i2, (Map<String, Object>) null, false, false);
    }

    private void b(int i2, Map<String, Object> map) {
        a(i2, map, true, true);
    }

    private void b(String str) {
        IronSourceLoggerManager.getLogger().log(IronSourceLogger.IronSourceTag.API, str, 0);
    }

    /* access modifiers changed from: private */
    public void b(Map<String, Object> map, List<String> list, StringBuilder sb, List<x1> list2) {
        for (r next : this.s.values()) {
            if (!this.t.b(next) && this.e.b(next)) {
                if (!next.p()) {
                    list.add(next.c());
                    sb.append(next.g() + next.c() + ",");
                } else if (this.E) {
                    list2.add(new x1(next.g(), next.c(), (AdData) null, next, (y1) null, (NetworkSettings) null));
                } else {
                    try {
                        Map<String, Object> a2 = next.a((AdData) null);
                        if (a2 != null) {
                            map.put(next.c(), a2);
                            sb.append(next.g() + next.c() + ",");
                        } else {
                            next.a((int) IronSourceConstants.TROUBLESHOOTING_RV_BIDDING_DATA_MISSING, new Object[][]{new Object[]{"reason", "Missing bidding data"}});
                        }
                    } catch (Exception e2) {
                        String str = "prepareAuctionCandidates - exception while calling smash.getBiddingData - " + e2.getMessage();
                        IronLog.INTERNAL.error(str);
                        next.a((int) IronSourceConstants.TROUBLESHOOTING_RV_INTERNAL_ERROR, new Object[][]{new Object[]{"reason", str}});
                    } catch (NoClassDefFoundError e3) {
                        String str2 = "prepareAuctionCandidates - error while calling smash.getBiddingData - " + e3.getMessage();
                        IronLog.INTERNAL.error(str2);
                        next.a((int) IronSourceConstants.TROUBLESHOOTING_RV_INTERNAL_ERROR, new Object[][]{new Object[]{"reason", str2}});
                    }
                }
            }
        }
    }

    private void b(boolean z2) {
        a(z2, (Map<String, Object>) null);
    }

    /* access modifiers changed from: private */
    public void c(int i2, Map<String, Object> map) {
        a(i2, map, false, false);
    }

    private void c(r rVar, Placement placement) {
        d("showVideo()");
        this.t.a(rVar);
        if (this.t.b(rVar)) {
            rVar.B();
            IronSourceUtils.sendAutomationLog(rVar.c() + " rewarded video is now session capped");
        }
        com.ironsource.mediationsdk.utils.b.c(ContextProvider.getInstance().getApplicationContext(), placement.getPlacementName());
        if (com.ironsource.mediationsdk.utils.b.f(ContextProvider.getInstance().getApplicationContext(), placement.getPlacementName())) {
            a((int) IronSourceConstants.RV_CAP_PLACEMENT);
        }
        this.D.a();
        rVar.a(placement);
    }

    private void c(String str) {
        IronSourceLoggerManager logger = IronSourceLoggerManager.getLogger();
        IronSourceLogger.IronSourceTag ironSourceTag = IronSourceLogger.IronSourceTag.INTERNAL;
        logger.log(ironSourceTag, "LWSProgRvManager: " + str, 3);
    }

    private boolean c(int i2) {
        return i2 == 1003 || i2 == 1302 || i2 == 1301 || i2 == 1303;
    }

    private boolean c(boolean z2) {
        Boolean bool = this.B;
        if (bool == null) {
            return false;
        }
        return (z2 && !bool.booleanValue() && d()) || (!z2 && this.B.booleanValue());
    }

    /* access modifiers changed from: private */
    public void d(String str) {
        IronSourceLoggerManager logger = IronSourceLoggerManager.getLogger();
        IronSourceLogger.IronSourceTag ironSourceTag = IronSourceLogger.IronSourceTag.INTERNAL;
        logger.log(ironSourceTag, "LWSProgRvManager: " + str, 0);
    }

    private List<d1> g() {
        CopyOnWriteArrayList copyOnWriteArrayList = new CopyOnWriteArrayList();
        for (r next : this.s.values()) {
            if (!next.p() && !this.t.b(next) && this.e.b(next)) {
                copyOnWriteArrayList.add(new d1(next.c()));
            }
        }
        return copyOnWriteArrayList;
    }

    private void g(r rVar) {
        String j2 = this.f.get(rVar.c()).j();
        JSONObject a2 = this.f.get(rVar.c()).a();
        rVar.c(j2);
        rVar.a(j2, a2);
    }

    private void h() {
        a(e.RV_STATE_NOT_LOADED);
        if (!this.y) {
            b(false);
        }
        this.l.a();
    }

    private void i() {
        if (this.e.c().isEmpty()) {
            d("loadSmashes -  waterfall is empty");
            a((int) IronSourceConstants.TROUBLESHOOTING_RV_LOAD_FAILED, j8.a(new Object[][]{new Object[]{"errorCode", 80004}, new Object[]{"reason", "waterfall is empty"}}));
            h();
            return;
        }
        a(e.RV_STATE_LOADING_SMASHES);
        int i2 = 0;
        for (int i3 = 0; i3 < this.e.c().size() && i2 < this.w; i3++) {
            r rVar = this.e.c().get(i3);
            if (rVar.h()) {
                if (!this.x || !rVar.p()) {
                    g(rVar);
                    i2++;
                } else if (i2 == 0) {
                    String str = "Advanced Loading: Starting to load bidder " + rVar.c() + ". No other instances will be loaded at the same time.";
                    d(str);
                    IronSourceUtils.sendAutomationLog(str);
                    g(rVar);
                    return;
                } else {
                    String str2 = "Advanced Loading: Won't start loading bidder " + rVar.c() + " as a non bidder is being loaded";
                    d(str2);
                    IronSourceUtils.sendAutomationLog(str2);
                    return;
                }
            }
        }
    }

    /* access modifiers changed from: private */
    public void j() {
        synchronized (this.C) {
            e eVar = this.z;
            e eVar2 = e.RV_STATE_AUCTION_IN_PROGRESS;
            if (eVar != eVar2) {
                a(eVar2);
                AsyncTask.execute(new c());
            }
        }
    }

    private void k() {
        List<d1> g2 = g();
        a(g2, "fallback_" + System.currentTimeMillis(), this.k);
    }

    public void a() {
        d("onLoadTriggered: RV load was triggered in " + this.z + " state");
        a(0);
    }

    public void a(int i2, String str, int i3, String str2, long j2) {
        Map<String, Object> map;
        String str3 = "Auction failed | moving to fallback waterfall (error " + i2 + " - " + str + ")";
        d(str3);
        IronSourceUtils.sendAutomationLog("RV: " + str3);
        this.p = i3;
        this.o = str2;
        this.k = null;
        k();
        if (TextUtils.isEmpty(str)) {
            map = j8.a(new Object[][]{new Object[]{"errorCode", Integer.valueOf(i2)}, new Object[]{IronSourceConstants.EVENTS_DURATION, Long.valueOf(j2)}});
        } else {
            map = j8.a(new Object[][]{new Object[]{"errorCode", Integer.valueOf(i2)}, new Object[]{"reason", str}, new Object[]{IronSourceConstants.EVENTS_DURATION, Long.valueOf(j2)}});
        }
        a((int) IronSourceConstants.RV_AUCTION_FAILED, map);
        i();
    }

    public void a(Activity activity, Placement placement) {
        Map<String, Object> map;
        synchronized (this.C) {
            if (placement == null) {
                a("showRewardedVideo error: empty default placement");
                IronSourceError ironSourceError = new IronSourceError(1021, "showRewardedVideo error: empty default placement");
                oa a2 = oa.a();
                n8 n8Var = this.e;
                a2.a(ironSourceError, n8Var.a(n8Var.d()));
                a((int) IronSourceConstants.RV_CALLBACK_SHOW_FAILED, j8.a(new Object[][]{new Object[]{"errorCode", 1021}, new Object[]{"reason", "showRewardedVideo error: empty default placement"}}), false, true);
                return;
            }
            this.v = placement.getPlacementName();
            b("showRewardedVideo(" + placement + ")");
            r rVar = null;
            if (activity != null) {
                map = j8.a(new Object[][]{new Object[]{IronSourceConstants.EVENTS_EXT1, IronSourceConstants.EVENTS_INIT_CONTEXT_FLOW}});
            } else {
                map = null;
            }
            b((int) IronSourceConstants.RV_API_SHOW_CALLED, map);
            if (this.y) {
                a("showRewardedVideo error: can't show ad while an ad is already showing");
                IronSourceError ironSourceError2 = new IronSourceError(1022, "showRewardedVideo error: can't show ad while an ad is already showing");
                oa a3 = oa.a();
                n8 n8Var2 = this.e;
                a3.a(ironSourceError2, n8Var2.a(n8Var2.d()));
                b((int) IronSourceConstants.RV_CALLBACK_SHOW_FAILED, j8.a(new Object[][]{new Object[]{"errorCode", 1022}, new Object[]{"reason", "showRewardedVideo error: can't show ad while an ad is already showing"}}));
            } else if (this.z != e.RV_STATE_READY_TO_SHOW) {
                a("showRewardedVideo error: show called while no ads are available");
                IronSourceError ironSourceError3 = new IronSourceError(1023, "showRewardedVideo error: show called while no ads are available");
                oa a4 = oa.a();
                n8 n8Var3 = this.e;
                a4.a(ironSourceError3, n8Var3.a(n8Var3.d()));
                b((int) IronSourceConstants.RV_CALLBACK_SHOW_FAILED, j8.a(new Object[][]{new Object[]{"errorCode", 1023}, new Object[]{"reason", "showRewardedVideo error: show called while no ads are available"}}));
            } else if (com.ironsource.mediationsdk.utils.b.f(ContextProvider.getInstance().getApplicationContext(), this.v)) {
                String str = "showRewardedVideo error: placement " + this.v + " is capped";
                a(str);
                IronSourceError ironSourceError4 = new IronSourceError(IronSourceError.ERROR_REACHED_CAP_LIMIT_PER_PLACEMENT, str);
                oa a5 = oa.a();
                n8 n8Var4 = this.e;
                a5.a(ironSourceError4, n8Var4.a(n8Var4.d()));
                b((int) IronSourceConstants.RV_CALLBACK_SHOW_FAILED, j8.a(new Object[][]{new Object[]{"errorCode", Integer.valueOf(IronSourceError.ERROR_REACHED_CAP_LIMIT_PER_PLACEMENT)}, new Object[]{"reason", str}}));
            } else {
                StringBuffer stringBuffer = new StringBuffer();
                Iterator<r> it = this.e.c().iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    r next = it.next();
                    if (next.A()) {
                        this.y = true;
                        next.b(true);
                        a(e.RV_STATE_NOT_LOADED);
                        rVar = next;
                        break;
                    }
                    if (next.e() != null) {
                        stringBuffer.append(next.c() + ":" + next.e() + ",");
                    }
                    next.b(false);
                }
                if (rVar == null) {
                    d("showRewardedVideo(): No ads to show");
                    oa a6 = oa.a();
                    IronSourceError buildNoAdsToShowError = ErrorBuilder.buildNoAdsToShowError(IronSourceConstants.REWARDED_VIDEO_AD_UNIT);
                    n8 n8Var5 = this.e;
                    a6.a(buildNoAdsToShowError, n8Var5.a(n8Var5.d()));
                    HashMap hashMap = new HashMap();
                    hashMap.put("errorCode", Integer.valueOf(IronSourceError.ERROR_CODE_NO_ADS_TO_SHOW));
                    hashMap.put("reason", "showRewardedVideo(): No ads to show");
                    if (stringBuffer.length() != 0) {
                        hashMap.put(IronSourceConstants.EVENTS_EXT1, stringBuffer.toString());
                    }
                    b((int) IronSourceConstants.RV_CALLBACK_SHOW_FAILED, (Map<String, Object>) hashMap);
                    this.l.b();
                    return;
                }
                c(rVar, placement);
            }
        }
    }

    public void a(Context context, boolean z2) {
        IronSourceLoggerManager logger = IronSourceLoggerManager.getLogger();
        IronSourceLogger.IronSourceTag ironSourceTag = IronSourceLogger.IronSourceTag.INTERNAL;
        logger.log(ironSourceTag, "LWSProgRvManager Should Track Network State: " + z2, 0);
        try {
            this.r = z2;
            if (z2) {
                if (this.q == null) {
                    this.q = new NetworkStateReceiver(context, this);
                }
                context.getApplicationContext().registerReceiver(this.q, new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
            } else if (this.q != null) {
                context.getApplicationContext().unregisterReceiver(this.q);
            }
        } catch (Exception e2) {
            IronLog ironLog = IronLog.INTERNAL;
            ironLog.error("Got an error from receiver with message: " + e2.getMessage());
        }
    }

    public void a(IronSourceError ironSourceError, r rVar) {
        d1 d1Var;
        if (this.m && (d1Var = this.f.get(rVar.c())) != null) {
            n8 n8Var = this.e;
            n8Var.a(n8Var.d(), d1Var.a(this.v));
        }
        a(rVar, "onRewardedVideoAdShowFailed error=" + ironSourceError.getErrorMessage());
        this.y = false;
        b((int) IronSourceConstants.RV_CALLBACK_SHOW_FAILED, j8.a(new Object[][]{new Object[]{"errorCode", Integer.valueOf(ironSourceError.getErrorCode())}, new Object[]{"reason", ironSourceError.getErrorMessage()}}));
        oa.a().a(ironSourceError, this.e.a(rVar.u()));
        this.g.put(rVar.c(), h.a.ISAuctionPerformanceFailedToShow);
        if (this.z != e.RV_STATE_READY_TO_SHOW) {
            b(false);
        }
        this.l.b();
    }

    public void a(r rVar) {
        a(rVar, "onRewardedVideoAdStarted");
        oa.a().c();
    }

    public void a(r rVar, Placement placement) {
        a(rVar, "onRewardedVideoAdRewarded");
        oa.a().b(placement, this.e.a(rVar.u()));
    }

    public void a(List<d1> list, String str, d1 d1Var, JSONObject jSONObject, JSONObject jSONObject2, int i2, long j2, int i3, String str2) {
        d("makeAuction(): success");
        this.h = d1Var;
        this.p = i2;
        this.k = jSONObject;
        this.o = "";
        if (!TextUtils.isEmpty(str2)) {
            a(88002, j8.a(new Object[][]{new Object[]{"errorCode", Integer.valueOf(i3)}, new Object[]{"reason", str2}}));
        }
        IronSource.AD_UNIT ad_unit = IronSource.AD_UNIT.REWARDED_VIDEO;
        a(jSONObject2, ad_unit);
        if (this.b.a(ad_unit)) {
            a((int) IronSourceConstants.RV_AD_UNIT_CAPPED, j8.a(new Object[][]{new Object[]{"auctionId", str}}));
            h();
            return;
        }
        a(list, str, this.k);
        a((int) IronSourceConstants.RV_AUCTION_SUCCESS, j8.a(new Object[][]{new Object[]{IronSourceConstants.EVENTS_DURATION, Long.valueOf(j2)}}));
        i();
    }

    public void a(boolean z2) {
        if (this.r) {
            IronSourceLoggerManager logger = IronSourceLoggerManager.getLogger();
            IronSourceLogger.IronSourceTag ironSourceTag = IronSourceLogger.IronSourceTag.INTERNAL;
            logger.log(ironSourceTag, "Network Availability Changed To: " + z2, 0);
            if (c(z2)) {
                b(z2);
            }
        }
    }

    public void b() {
        a(e.RV_STATE_NOT_LOADED);
        a(false, j8.a(new Object[][]{new Object[]{"errorCode", Integer.valueOf(IronSourceError.ERROR_RV_EXPIRED_ADS)}, new Object[]{"reason", "loaded ads are expired"}}));
        a(0);
    }

    public void b(r rVar) {
        String str;
        a(rVar, "onRewardedVideoAdClosed, mediation state: " + this.z.name());
        oa.a().b(this.e.a(rVar.u()));
        this.y = false;
        boolean z2 = this.z == e.RV_STATE_READY_TO_SHOW;
        StringBuilder sb = new StringBuilder();
        if (z2) {
            Iterator<r> it = this.e.c().iterator();
            while (it.hasNext()) {
                r next = it.next();
                if (next.y()) {
                    sb.append(next.c() + ";");
                }
            }
        }
        Object[][] objArr = new Object[1][];
        Object[] objArr2 = new Object[2];
        objArr2[0] = IronSourceConstants.EVENTS_EXT1;
        StringBuilder sb2 = new StringBuilder("otherRVAvailable = ");
        if (sb.length() > 0) {
            str = "true|" + sb;
        } else {
            str = "false";
        }
        sb2.append(str);
        objArr2[1] = sb2.toString();
        objArr[0] = objArr2;
        rVar.b(1203, objArr);
        if (rVar.equals(this.e.f())) {
            this.e.a((r) null);
            if (this.z != e.RV_STATE_READY_TO_SHOW) {
                b(false);
            }
        }
    }

    public void b(r rVar, Placement placement) {
        a(rVar, "onRewardedVideoAdClicked");
        oa.a().a(placement, this.e.a(rVar.u()));
    }

    /* JADX WARNING: Code restructure failed: missing block: B:57:0x0149, code lost:
        r12 = r3.iterator();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:59:0x0151, code lost:
        if (r12.hasNext() == false) goto L_0x015d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:60:0x0153, code lost:
        g((com.ironsource.mediationsdk.r) r12.next());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:61:0x015d, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void c(com.ironsource.mediationsdk.r r12) {
        /*
            r11 = this;
            java.lang.String r0 = "loadError wrong auction ID "
            java.lang.String r1 = "onLoadError was invoked with auctionId:"
            java.lang.String r2 = "onLoadError mState="
            java.util.concurrent.CopyOnWriteArrayList r3 = new java.util.concurrent.CopyOnWriteArrayList
            r3.<init>()
            java.lang.Object r4 = r11.C
            monitor-enter(r4)
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ all -> 0x01b0 }
            r5.<init>(r2)     // Catch:{ all -> 0x01b0 }
            com.ironsource.mediationsdk.q$e r2 = r11.z     // Catch:{ all -> 0x01b0 }
            r5.append(r2)     // Catch:{ all -> 0x01b0 }
            java.lang.String r2 = r5.toString()     // Catch:{ all -> 0x01b0 }
            r11.a((com.ironsource.mediationsdk.r) r12, (java.lang.String) r2)     // Catch:{ all -> 0x01b0 }
            java.lang.String r2 = r12.u()     // Catch:{ all -> 0x01b0 }
            com.ironsource.n8 r5 = r11.e     // Catch:{ all -> 0x01b0 }
            java.lang.String r5 = r5.d()     // Catch:{ all -> 0x01b0 }
            r6 = 2
            r7 = 1
            r8 = 0
            if (r2 != r5) goto L_0x015e
            com.ironsource.mediationsdk.q$e r2 = r11.z     // Catch:{ all -> 0x01b0 }
            com.ironsource.mediationsdk.q$e r5 = com.ironsource.mediationsdk.q.e.RV_STATE_AUCTION_IN_PROGRESS     // Catch:{ all -> 0x01b0 }
            if (r2 != r5) goto L_0x0036
            goto L_0x015e
        L_0x0036:
            java.util.concurrent.ConcurrentHashMap<java.lang.String, com.ironsource.mediationsdk.h$a> r0 = r11.g     // Catch:{ all -> 0x01b0 }
            java.lang.String r1 = r12.c()     // Catch:{ all -> 0x01b0 }
            com.ironsource.mediationsdk.h$a r2 = com.ironsource.mediationsdk.h.a.ISAuctionPerformanceFailedToLoad     // Catch:{ all -> 0x01b0 }
            r0.put(r1, r2)     // Catch:{ all -> 0x01b0 }
            com.ironsource.mediationsdk.q$e r0 = r11.z     // Catch:{ all -> 0x01b0 }
            com.ironsource.mediationsdk.q$e r1 = com.ironsource.mediationsdk.q.e.RV_STATE_LOADING_SMASHES     // Catch:{ all -> 0x01b0 }
            if (r0 == r1) goto L_0x004d
            com.ironsource.mediationsdk.q$e r1 = com.ironsource.mediationsdk.q.e.RV_STATE_READY_TO_SHOW     // Catch:{ all -> 0x01b0 }
            if (r0 == r1) goto L_0x004d
            monitor-exit(r4)     // Catch:{ all -> 0x01b0 }
            return
        L_0x004d:
            com.ironsource.n8 r0 = r11.e     // Catch:{ all -> 0x01b0 }
            java.util.concurrent.CopyOnWriteArrayList r0 = r0.c()     // Catch:{ all -> 0x01b0 }
            java.util.Iterator r0 = r0.iterator()     // Catch:{ all -> 0x01b0 }
            r1 = 0
            r2 = 0
        L_0x0059:
            boolean r5 = r0.hasNext()     // Catch:{ all -> 0x01b0 }
            if (r5 == 0) goto L_0x0100
            java.lang.Object r5 = r0.next()     // Catch:{ all -> 0x01b0 }
            com.ironsource.mediationsdk.r r5 = (com.ironsource.mediationsdk.r) r5     // Catch:{ all -> 0x01b0 }
            boolean r9 = r5.h()     // Catch:{ all -> 0x01b0 }
            if (r9 == 0) goto L_0x00ee
            boolean r9 = r11.x     // Catch:{ all -> 0x01b0 }
            if (r9 == 0) goto L_0x00c6
            boolean r9 = r5.p()     // Catch:{ all -> 0x01b0 }
            if (r9 == 0) goto L_0x00c6
            if (r1 != 0) goto L_0x009b
            if (r2 == 0) goto L_0x007a
            goto L_0x009b
        L_0x007a:
            java.lang.StringBuilder r9 = new java.lang.StringBuilder     // Catch:{ all -> 0x01b0 }
            r9.<init>()     // Catch:{ all -> 0x01b0 }
            java.lang.String r10 = "Advanced Loading: Starting to load bidder "
            r9.append(r10)     // Catch:{ all -> 0x01b0 }
            java.lang.String r10 = r5.c()     // Catch:{ all -> 0x01b0 }
            r9.append(r10)     // Catch:{ all -> 0x01b0 }
            java.lang.String r10 = ". No other instances will be loaded at the same time."
            r9.append(r10)     // Catch:{ all -> 0x01b0 }
            java.lang.String r9 = r9.toString()     // Catch:{ all -> 0x01b0 }
            r11.d((java.lang.String) r9)     // Catch:{ all -> 0x01b0 }
            com.ironsource.mediationsdk.utils.IronSourceUtils.sendAutomationLog(r9)     // Catch:{ all -> 0x01b0 }
            goto L_0x00c6
        L_0x009b:
            if (r1 == 0) goto L_0x00a0
            java.lang.String r12 = "a non bidder is being loaded"
            goto L_0x00a2
        L_0x00a0:
            java.lang.String r12 = "a non bidder was already loaded successfully"
        L_0x00a2:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ all -> 0x01b0 }
            r0.<init>()     // Catch:{ all -> 0x01b0 }
            java.lang.String r9 = "Advanced Loading: Won't start loading bidder "
            r0.append(r9)     // Catch:{ all -> 0x01b0 }
            java.lang.String r5 = r5.c()     // Catch:{ all -> 0x01b0 }
            r0.append(r5)     // Catch:{ all -> 0x01b0 }
            java.lang.String r5 = " as "
            r0.append(r5)     // Catch:{ all -> 0x01b0 }
            r0.append(r12)     // Catch:{ all -> 0x01b0 }
            java.lang.String r12 = r0.toString()     // Catch:{ all -> 0x01b0 }
            r11.d((java.lang.String) r12)     // Catch:{ all -> 0x01b0 }
            com.ironsource.mediationsdk.utils.IronSourceUtils.sendAutomationLog(r12)     // Catch:{ all -> 0x01b0 }
            goto L_0x0100
        L_0x00c6:
            java.util.concurrent.ConcurrentHashMap<java.lang.String, com.ironsource.d1> r9 = r11.f     // Catch:{ all -> 0x01b0 }
            java.lang.String r10 = r5.c()     // Catch:{ all -> 0x01b0 }
            java.lang.Object r9 = r9.get(r10)     // Catch:{ all -> 0x01b0 }
            if (r9 == 0) goto L_0x0059
            r3.add(r5)     // Catch:{ all -> 0x01b0 }
            boolean r9 = r11.x     // Catch:{ all -> 0x01b0 }
            if (r9 == 0) goto L_0x0100
            boolean r9 = r12.p()     // Catch:{ all -> 0x01b0 }
            if (r9 == 0) goto L_0x0100
            boolean r5 = r5.p()     // Catch:{ all -> 0x01b0 }
            if (r5 != 0) goto L_0x0100
            int r5 = r3.size()     // Catch:{ all -> 0x01b0 }
            int r9 = r11.w     // Catch:{ all -> 0x01b0 }
            if (r5 >= r9) goto L_0x0100
            goto L_0x00f4
        L_0x00ee:
            boolean r9 = r5.z()     // Catch:{ all -> 0x01b0 }
            if (r9 == 0) goto L_0x00f7
        L_0x00f4:
            r1 = 1
            goto L_0x0059
        L_0x00f7:
            boolean r5 = r5.A()     // Catch:{ all -> 0x01b0 }
            if (r5 == 0) goto L_0x0059
            r2 = 1
            goto L_0x0059
        L_0x0100:
            int r12 = r3.size()     // Catch:{ all -> 0x01b0 }
            if (r12 != 0) goto L_0x0148
            if (r2 != 0) goto L_0x0148
            if (r1 != 0) goto L_0x0148
            java.lang.String r12 = "onLoadError(): No other available smashes"
            r11.d((java.lang.String) r12)     // Catch:{ all -> 0x01b0 }
            boolean r12 = r11.y     // Catch:{ all -> 0x01b0 }
            if (r12 != 0) goto L_0x0116
            r11.b((boolean) r8)     // Catch:{ all -> 0x01b0 }
        L_0x0116:
            java.lang.Object[][] r12 = new java.lang.Object[r6][]     // Catch:{ all -> 0x01b0 }
            java.lang.Object[] r0 = new java.lang.Object[r6]     // Catch:{ all -> 0x01b0 }
            java.lang.String r1 = "errorCode"
            r0[r8] = r1     // Catch:{ all -> 0x01b0 }
            r1 = 509(0x1fd, float:7.13E-43)
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)     // Catch:{ all -> 0x01b0 }
            r0[r7] = r1     // Catch:{ all -> 0x01b0 }
            r12[r8] = r0     // Catch:{ all -> 0x01b0 }
            java.lang.Object[] r0 = new java.lang.Object[r6]     // Catch:{ all -> 0x01b0 }
            java.lang.String r1 = "reason"
            r0[r8] = r1     // Catch:{ all -> 0x01b0 }
            java.lang.String r1 = "Mediation No fill"
            r0[r7] = r1     // Catch:{ all -> 0x01b0 }
            r12[r7] = r0     // Catch:{ all -> 0x01b0 }
            java.util.Map r12 = com.ironsource.j8.a(r12)     // Catch:{ all -> 0x01b0 }
            r0 = 81001(0x13c69, float:1.13507E-40)
            r11.a((int) r0, (java.util.Map<java.lang.String, java.lang.Object>) r12)     // Catch:{ all -> 0x01b0 }
            com.ironsource.mediationsdk.q$e r12 = com.ironsource.mediationsdk.q.e.RV_STATE_NOT_LOADED     // Catch:{ all -> 0x01b0 }
            r11.a((com.ironsource.mediationsdk.q.e) r12)     // Catch:{ all -> 0x01b0 }
            com.ironsource.xa r12 = r11.l     // Catch:{ all -> 0x01b0 }
            r12.a()     // Catch:{ all -> 0x01b0 }
        L_0x0148:
            monitor-exit(r4)     // Catch:{ all -> 0x01b0 }
            java.util.Iterator r12 = r3.iterator()
        L_0x014d:
            boolean r0 = r12.hasNext()
            if (r0 == 0) goto L_0x015d
            java.lang.Object r0 = r12.next()
            com.ironsource.mediationsdk.r r0 = (com.ironsource.mediationsdk.r) r0
            r11.g(r0)
            goto L_0x014d
        L_0x015d:
            return
        L_0x015e:
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x01b0 }
            r2.<init>(r1)     // Catch:{ all -> 0x01b0 }
            java.lang.String r1 = r12.u()     // Catch:{ all -> 0x01b0 }
            r2.append(r1)     // Catch:{ all -> 0x01b0 }
            java.lang.String r1 = " and the current id is "
            r2.append(r1)     // Catch:{ all -> 0x01b0 }
            com.ironsource.n8 r1 = r11.e     // Catch:{ all -> 0x01b0 }
            java.lang.String r1 = r1.d()     // Catch:{ all -> 0x01b0 }
            r2.append(r1)     // Catch:{ all -> 0x01b0 }
            java.lang.String r1 = r2.toString()     // Catch:{ all -> 0x01b0 }
            r11.d((java.lang.String) r1)     // Catch:{ all -> 0x01b0 }
            java.lang.Object[][] r1 = new java.lang.Object[r6][]     // Catch:{ all -> 0x01b0 }
            java.lang.Object[] r2 = new java.lang.Object[r6]     // Catch:{ all -> 0x01b0 }
            java.lang.String r3 = "errorCode"
            r2[r8] = r3     // Catch:{ all -> 0x01b0 }
            r3 = 4
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)     // Catch:{ all -> 0x01b0 }
            r2[r7] = r3     // Catch:{ all -> 0x01b0 }
            r1[r8] = r2     // Catch:{ all -> 0x01b0 }
            java.lang.Object[] r2 = new java.lang.Object[r6]     // Catch:{ all -> 0x01b0 }
            java.lang.String r3 = "reason"
            r2[r8] = r3     // Catch:{ all -> 0x01b0 }
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x01b0 }
            r3.<init>(r0)     // Catch:{ all -> 0x01b0 }
            com.ironsource.mediationsdk.q$e r0 = r11.z     // Catch:{ all -> 0x01b0 }
            r3.append(r0)     // Catch:{ all -> 0x01b0 }
            java.lang.String r0 = r3.toString()     // Catch:{ all -> 0x01b0 }
            r2[r7] = r0     // Catch:{ all -> 0x01b0 }
            r1[r7] = r2     // Catch:{ all -> 0x01b0 }
            r0 = 81315(0x13da3, float:1.13947E-40)
            r12.a((int) r0, (java.lang.Object[][]) r1)     // Catch:{ all -> 0x01b0 }
            monitor-exit(r4)     // Catch:{ all -> 0x01b0 }
            return
        L_0x01b0:
            r12 = move-exception
            monitor-exit(r4)     // Catch:{ all -> 0x01b0 }
            throw r12
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ironsource.mediationsdk.q.c(com.ironsource.mediationsdk.r):void");
    }

    public void d(r rVar) {
        this.e.a(rVar);
        this.u++;
        a(rVar, "onRewardedVideoAdOpened");
        if (this.m) {
            d1 d1Var = this.f.get(rVar.c());
            if (d1Var != null) {
                n8 n8Var = this.e;
                n8Var.a(n8Var.d(), d1Var.a(this.v));
                this.j.a(d1Var, rVar.g(), this.h, this.v);
                this.g.put(rVar.c(), h.a.ISAuctionPerformanceShowedSuccessfully);
                a(d1Var, this.v);
            } else {
                String c2 = rVar.c();
                c("onRewardedVideoAdOpened showing instance " + c2 + " missing from waterfall");
                StringBuilder sb = new StringBuilder("Showing missing ");
                sb.append(this.z);
                a((int) IronSourceConstants.TROUBLESHOOTING_RV_NOTIFICATIONS_ERROR, j8.a(new Object[][]{new Object[]{"errorCode", 1011}, new Object[]{"reason", sb.toString()}, new Object[]{IronSourceConstants.EVENTS_EXT1, c2}}));
            }
        }
        oa.a().c(this.e.a(rVar.u()));
        b(false);
        this.l.c();
    }

    public boolean d() {
        if ((!this.r || IronSourceUtils.isNetworkConnected(ContextProvider.getInstance().getApplicationContext())) && this.z == e.RV_STATE_READY_TO_SHOW && !this.y) {
            Iterator<r> it = this.e.c().iterator();
            while (it.hasNext()) {
                if (it.next().A()) {
                    return true;
                }
            }
        }
        return false;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:18:0x012d, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void e(com.ironsource.mediationsdk.r r19) {
        /*
            r18 = this;
            r1 = r18
            r0 = r19
            java.lang.String r2 = "Loaded missing "
            java.lang.String r3 = "onLoadSuccess winner instance "
            java.lang.String r4 = "onLoadSuccess wrong auction ID "
            java.lang.String r5 = "onLoadSuccess was invoked with auctionId: "
            java.lang.String r6 = "onLoadSuccess mState="
            java.lang.Object r7 = r1.C
            monitor-enter(r7)
            java.lang.StringBuilder r8 = new java.lang.StringBuilder     // Catch:{ all -> 0x017f }
            r8.<init>(r6)     // Catch:{ all -> 0x017f }
            com.ironsource.mediationsdk.q$e r6 = r1.z     // Catch:{ all -> 0x017f }
            r8.append(r6)     // Catch:{ all -> 0x017f }
            java.lang.String r6 = r8.toString()     // Catch:{ all -> 0x017f }
            r1.a((com.ironsource.mediationsdk.r) r0, (java.lang.String) r6)     // Catch:{ all -> 0x017f }
            java.lang.String r6 = r19.u()     // Catch:{ all -> 0x017f }
            com.ironsource.n8 r8 = r1.e     // Catch:{ all -> 0x017f }
            java.lang.String r8 = r8.d()     // Catch:{ all -> 0x017f }
            r9 = 0
            r10 = 2
            r11 = 1
            if (r6 != r8) goto L_0x012e
            com.ironsource.mediationsdk.q$e r6 = r1.z     // Catch:{ all -> 0x017f }
            com.ironsource.mediationsdk.q$e r8 = com.ironsource.mediationsdk.q.e.RV_STATE_AUCTION_IN_PROGRESS     // Catch:{ all -> 0x017f }
            if (r6 != r8) goto L_0x0039
            goto L_0x012e
        L_0x0039:
            java.util.concurrent.ConcurrentHashMap<java.lang.String, com.ironsource.mediationsdk.h$a> r4 = r1.g     // Catch:{ all -> 0x017f }
            java.lang.String r5 = r19.c()     // Catch:{ all -> 0x017f }
            com.ironsource.mediationsdk.h$a r6 = com.ironsource.mediationsdk.h.a.ISAuctionPerformanceLoadedSuccessfully     // Catch:{ all -> 0x017f }
            r4.put(r5, r6)     // Catch:{ all -> 0x017f }
            com.ironsource.mediationsdk.q$e r4 = r1.z     // Catch:{ all -> 0x017f }
            com.ironsource.mediationsdk.q$e r5 = com.ironsource.mediationsdk.q.e.RV_STATE_LOADING_SMASHES     // Catch:{ all -> 0x017f }
            if (r4 != r5) goto L_0x012c
            com.ironsource.mediationsdk.q$e r4 = com.ironsource.mediationsdk.q.e.RV_STATE_READY_TO_SHOW     // Catch:{ all -> 0x017f }
            r1.a((com.ironsource.mediationsdk.q.e) r4)     // Catch:{ all -> 0x017f }
            java.util.Date r4 = new java.util.Date     // Catch:{ all -> 0x017f }
            r4.<init>()     // Catch:{ all -> 0x017f }
            long r12 = r4.getTime()     // Catch:{ all -> 0x017f }
            long r14 = r1.n     // Catch:{ all -> 0x017f }
            long r12 = r12 - r14
            java.lang.Object[][] r4 = new java.lang.Object[r11][]     // Catch:{ all -> 0x017f }
            java.lang.Object[] r6 = new java.lang.Object[r10]     // Catch:{ all -> 0x017f }
            java.lang.String r8 = "duration"
            r6[r9] = r8     // Catch:{ all -> 0x017f }
            java.lang.Long r8 = java.lang.Long.valueOf(r12)     // Catch:{ all -> 0x017f }
            r6[r11] = r8     // Catch:{ all -> 0x017f }
            r4[r9] = r6     // Catch:{ all -> 0x017f }
            java.util.Map r4 = com.ironsource.j8.a(r4)     // Catch:{ all -> 0x017f }
            r6 = 1003(0x3eb, float:1.406E-42)
            r1.a((int) r6, (java.util.Map<java.lang.String, java.lang.Object>) r4)     // Catch:{ all -> 0x017f }
            com.ironsource.i4 r4 = r1.D     // Catch:{ all -> 0x017f }
            r12 = 0
            r4.a((long) r12)     // Catch:{ all -> 0x017f }
            boolean r4 = r1.m     // Catch:{ all -> 0x017f }
            if (r4 == 0) goto L_0x0129
            java.util.concurrent.ConcurrentHashMap<java.lang.String, com.ironsource.d1> r4 = r1.f     // Catch:{ all -> 0x017f }
            java.lang.String r6 = r19.c()     // Catch:{ all -> 0x017f }
            java.lang.Object r4 = r4.get(r6)     // Catch:{ all -> 0x017f }
            com.ironsource.d1 r4 = (com.ironsource.d1) r4     // Catch:{ all -> 0x017f }
            if (r4 == 0) goto L_0x00bf
            com.ironsource.n8 r2 = r1.e     // Catch:{ all -> 0x017f }
            java.lang.String r3 = r2.d()     // Catch:{ all -> 0x017f }
            java.lang.String r5 = ""
            com.ironsource.mediationsdk.impressionData.ImpressionData r5 = r4.a(r5)     // Catch:{ all -> 0x017f }
            r2.a((java.lang.String) r3, (com.ironsource.mediationsdk.impressionData.ImpressionData) r5)     // Catch:{ all -> 0x017f }
            com.ironsource.mediationsdk.e r2 = r1.j     // Catch:{ all -> 0x017f }
            int r3 = r19.g()     // Catch:{ all -> 0x017f }
            com.ironsource.d1 r5 = r1.h     // Catch:{ all -> 0x017f }
            r2.a((com.ironsource.d1) r4, (int) r3, (com.ironsource.d1) r5)     // Catch:{ all -> 0x017f }
            com.ironsource.mediationsdk.e r12 = r1.j     // Catch:{ all -> 0x017f }
            com.ironsource.n8 r2 = r1.e     // Catch:{ all -> 0x017f }
            java.util.concurrent.CopyOnWriteArrayList r13 = r2.c()     // Catch:{ all -> 0x017f }
            java.util.concurrent.ConcurrentHashMap<java.lang.String, com.ironsource.d1> r14 = r1.f     // Catch:{ all -> 0x017f }
            int r15 = r19.g()     // Catch:{ all -> 0x017f }
            com.ironsource.d1 r0 = r1.h     // Catch:{ all -> 0x017f }
            r16 = r0
            r17 = r4
            r12.a((java.util.concurrent.CopyOnWriteArrayList<com.ironsource.mediationsdk.a0>) r13, (java.util.concurrent.ConcurrentHashMap<java.lang.String, com.ironsource.d1>) r14, (int) r15, (com.ironsource.d1) r16, (com.ironsource.d1) r17)     // Catch:{ all -> 0x017f }
            goto L_0x0129
        L_0x00bf:
            java.lang.String r4 = r19.c()     // Catch:{ all -> 0x017f }
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch:{ all -> 0x017f }
            r6.<init>(r3)     // Catch:{ all -> 0x017f }
            r6.append(r4)     // Catch:{ all -> 0x017f }
            java.lang.String r3 = " missing from waterfall. auctionId: "
            r6.append(r3)     // Catch:{ all -> 0x017f }
            java.lang.String r0 = r19.u()     // Catch:{ all -> 0x017f }
            r6.append(r0)     // Catch:{ all -> 0x017f }
            java.lang.String r0 = " and the current id is "
            r6.append(r0)     // Catch:{ all -> 0x017f }
            com.ironsource.n8 r0 = r1.e     // Catch:{ all -> 0x017f }
            java.lang.String r0 = r0.d()     // Catch:{ all -> 0x017f }
            r6.append(r0)     // Catch:{ all -> 0x017f }
            java.lang.String r0 = r6.toString()     // Catch:{ all -> 0x017f }
            r1.c((java.lang.String) r0)     // Catch:{ all -> 0x017f }
            r0 = 3
            java.lang.Object[][] r0 = new java.lang.Object[r0][]     // Catch:{ all -> 0x017f }
            java.lang.Object[] r3 = new java.lang.Object[r10]     // Catch:{ all -> 0x017f }
            java.lang.String r6 = "errorCode"
            r3[r9] = r6     // Catch:{ all -> 0x017f }
            r6 = 1010(0x3f2, float:1.415E-42)
            java.lang.Integer r6 = java.lang.Integer.valueOf(r6)     // Catch:{ all -> 0x017f }
            r3[r11] = r6     // Catch:{ all -> 0x017f }
            r0[r9] = r3     // Catch:{ all -> 0x017f }
            java.lang.Object[] r3 = new java.lang.Object[r10]     // Catch:{ all -> 0x017f }
            java.lang.String r6 = "reason"
            r3[r9] = r6     // Catch:{ all -> 0x017f }
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch:{ all -> 0x017f }
            r6.<init>(r2)     // Catch:{ all -> 0x017f }
            r6.append(r5)     // Catch:{ all -> 0x017f }
            java.lang.String r2 = r6.toString()     // Catch:{ all -> 0x017f }
            r3[r11] = r2     // Catch:{ all -> 0x017f }
            r0[r11] = r3     // Catch:{ all -> 0x017f }
            java.lang.Object[] r2 = new java.lang.Object[r10]     // Catch:{ all -> 0x017f }
            java.lang.String r3 = "ext1"
            r2[r9] = r3     // Catch:{ all -> 0x017f }
            r2[r11] = r4     // Catch:{ all -> 0x017f }
            r0[r10] = r2     // Catch:{ all -> 0x017f }
            java.util.Map r0 = com.ironsource.j8.a(r0)     // Catch:{ all -> 0x017f }
            r2 = 81317(0x13da5, float:1.1395E-40)
            r1.a((int) r2, (java.util.Map<java.lang.String, java.lang.Object>) r0)     // Catch:{ all -> 0x017f }
        L_0x0129:
            r1.b((boolean) r11)     // Catch:{ all -> 0x017f }
        L_0x012c:
            monitor-exit(r7)     // Catch:{ all -> 0x017f }
            return
        L_0x012e:
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x017f }
            r2.<init>(r5)     // Catch:{ all -> 0x017f }
            java.lang.String r3 = r19.u()     // Catch:{ all -> 0x017f }
            r2.append(r3)     // Catch:{ all -> 0x017f }
            java.lang.String r3 = " and the current id is "
            r2.append(r3)     // Catch:{ all -> 0x017f }
            com.ironsource.n8 r3 = r1.e     // Catch:{ all -> 0x017f }
            java.lang.String r3 = r3.d()     // Catch:{ all -> 0x017f }
            r2.append(r3)     // Catch:{ all -> 0x017f }
            java.lang.String r2 = r2.toString()     // Catch:{ all -> 0x017f }
            r1.d((java.lang.String) r2)     // Catch:{ all -> 0x017f }
            java.lang.Object[][] r2 = new java.lang.Object[r10][]     // Catch:{ all -> 0x017f }
            java.lang.Object[] r3 = new java.lang.Object[r10]     // Catch:{ all -> 0x017f }
            java.lang.String r5 = "errorCode"
            r3[r9] = r5     // Catch:{ all -> 0x017f }
            java.lang.Integer r5 = java.lang.Integer.valueOf(r10)     // Catch:{ all -> 0x017f }
            r3[r11] = r5     // Catch:{ all -> 0x017f }
            r2[r9] = r3     // Catch:{ all -> 0x017f }
            java.lang.Object[] r3 = new java.lang.Object[r10]     // Catch:{ all -> 0x017f }
            java.lang.String r5 = "reason"
            r3[r9] = r5     // Catch:{ all -> 0x017f }
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ all -> 0x017f }
            r5.<init>(r4)     // Catch:{ all -> 0x017f }
            com.ironsource.mediationsdk.q$e r4 = r1.z     // Catch:{ all -> 0x017f }
            r5.append(r4)     // Catch:{ all -> 0x017f }
            java.lang.String r4 = r5.toString()     // Catch:{ all -> 0x017f }
            r3[r11] = r4     // Catch:{ all -> 0x017f }
            r2[r11] = r3     // Catch:{ all -> 0x017f }
            r3 = 81315(0x13da3, float:1.13947E-40)
            r0.a((int) r3, (java.lang.Object[][]) r2)     // Catch:{ all -> 0x017f }
            monitor-exit(r7)     // Catch:{ all -> 0x017f }
            return
        L_0x017f:
            r0 = move-exception
            monitor-exit(r7)     // Catch:{ all -> 0x017f }
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ironsource.mediationsdk.q.e(com.ironsource.mediationsdk.r):void");
    }

    public void f(r rVar) {
        a(rVar, "onRewardedVideoAdEnded");
        oa.a().b();
    }
}
