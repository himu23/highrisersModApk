package com.ironsource.mediationsdk;

import android.app.Activity;
import android.content.Context;
import android.os.AsyncTask;
import android.text.TextUtils;
import android.util.Log;
import com.ironsource.a2;
import com.ironsource.b2;
import com.ironsource.d1;
import com.ironsource.environment.ContextProvider;
import com.ironsource.environment.thread.IronSourceThreadManager;
import com.ironsource.h5;
import com.ironsource.i5;
import com.ironsource.j5;
import com.ironsource.kb;
import com.ironsource.la;
import com.ironsource.m7;
import com.ironsource.mediationsdk.IronSource;
import com.ironsource.mediationsdk.adunit.adapter.utility.AdData;
import com.ironsource.mediationsdk.h;
import com.ironsource.mediationsdk.impressionData.ImpressionDataListener;
import com.ironsource.mediationsdk.logger.IronLog;
import com.ironsource.mediationsdk.logger.IronSourceError;
import com.ironsource.mediationsdk.logger.IronSourceLogger;
import com.ironsource.mediationsdk.logger.IronSourceLoggerManager;
import com.ironsource.mediationsdk.model.NetworkSettings;
import com.ironsource.mediationsdk.utils.ErrorBuilder;
import com.ironsource.mediationsdk.utils.IronSourceConstants;
import com.ironsource.mediationsdk.utils.IronSourceUtils;
import com.ironsource.n7;
import com.ironsource.t0;
import com.ironsource.u5;
import com.ironsource.w6;
import com.ironsource.w8;
import com.ironsource.x1;
import com.ironsource.y1;
import com.ironsource.y3;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.TimeUnit;
import org.json.JSONObject;

class y extends m implements la, t0, j5 {
    boolean A;
    private final w6 B;
    private final w6.a C;
    private kb e;
    private e f;
    /* access modifiers changed from: private */
    public final ConcurrentHashMap<String, z> g;
    private CopyOnWriteArrayList<z> h;
    private ConcurrentHashMap<String, d1> i;
    private ConcurrentHashMap<String, h.a> j;
    private d1 k;
    private String l;
    /* access modifiers changed from: private */
    public String m;
    /* access modifiers changed from: private */
    public JSONObject n;
    private int o;
    private boolean p;
    /* access modifiers changed from: private */
    public final boolean q;
    private final long r;
    private boolean s;
    private e t;
    private h u;
    private long v;
    private long w;
    private long x;
    private int y;
    private String z;

    class a implements Runnable {
        final /* synthetic */ NetworkSettings a;
        final /* synthetic */ m7 b;
        final /* synthetic */ String c;
        final /* synthetic */ String d;

        a(NetworkSettings networkSettings, m7 m7Var, String str, String str2) {
            this.a = networkSettings;
            this.b = m7Var;
            this.c = str;
            this.d = str2;
        }

        public void run() {
            y.this.a(this.a, this.b, this.c, this.d);
        }
    }

    class b implements Runnable {
        b() {
        }

        public void run() {
            String unused = y.this.m = "";
            JSONObject unused2 = y.this.n = null;
            if (!y.this.m()) {
                y.this.a(2000, (Object[][]) null);
                HashMap hashMap = new HashMap();
                ArrayList arrayList = new ArrayList();
                StringBuilder sb = new StringBuilder();
                ArrayList arrayList2 = new ArrayList();
                y.this.b(hashMap, arrayList, sb, arrayList2);
                if (y.this.q) {
                    y.this.a((Map<String, Object>) hashMap, (List<String>) arrayList, sb, (List<x1>) arrayList2);
                } else {
                    y.this.a((Map<String, Object>) hashMap, (List<String>) arrayList, sb.toString());
                }
            }
        }
    }

    class c implements a2.b {
        final /* synthetic */ Map a;
        final /* synthetic */ StringBuilder b;
        final /* synthetic */ List c;

        c(Map map, StringBuilder sb, List list) {
            this.a = map;
            this.b = sb;
            this.c = list;
        }

        public void a(List<b2> list, long j, List<String> list2) {
            y.this.a((int) IronSourceConstants.IS_COLLECT_TOKENS_COMPLETED, new Object[][]{new Object[]{IronSourceConstants.EVENTS_DURATION, Long.valueOf(j)}});
            for (b2 next : list) {
                if (next.a() != null) {
                    this.a.put(next.c(), next.a());
                    StringBuilder sb = this.b;
                    sb.append(next.d());
                    sb.append(next.c());
                    sb.append(",");
                    y yVar = y.this;
                    yVar.a((int) IronSourceConstants.IS_INSTANCE_COLLECT_TOKEN_SUCCESS, (z) yVar.g.get(next.c()), new Object[][]{new Object[]{IronSourceConstants.EVENTS_DURATION, Long.valueOf(next.e())}});
                } else {
                    y yVar2 = y.this;
                    yVar2.a((int) IronSourceConstants.IS_INSTANCE_COLLECT_TOKEN_FAILED, (z) yVar2.g.get(next.c()), new Object[][]{new Object[]{IronSourceConstants.EVENTS_DURATION, Long.valueOf(next.e())}, new Object[]{"reason", next.b()}});
                }
            }
            for (String str : list2) {
                y yVar3 = y.this;
                ConcurrentHashMap d2 = yVar3.g;
                yVar3.a((int) IronSourceConstants.IS_INSTANCE_COLLECT_TOKEN_TIMED_OUT, (z) d2.get(str), new Object[][]{new Object[]{IronSourceConstants.EVENTS_DURATION, Long.valueOf(j)}});
            }
            y.this.a((Map<String, Object>) this.a, (List<String>) this.c, this.b.toString());
        }

        public void onFailure(String str) {
            y.this.a((int) IronSourceConstants.IS_COLLECT_TOKENS_FAILED, new Object[][]{new Object[]{"reason", str}});
            y.this.a((Map<String, Object>) this.a, (List<String>) this.c, this.b.toString());
        }
    }

    class d implements Runnable {
        d() {
        }

        public void run() {
            y.this.k();
        }
    }

    enum e {
        STATE_NOT_INITIALIZED,
        STATE_READY_TO_LOAD,
        STATE_AUCTION,
        STATE_LOADING_SMASHES,
        STATE_READY_TO_SHOW,
        STATE_SHOWING
    }

    y(i5 i5Var, h5 h5Var, List<NetworkSettings> list, m7 m7Var, String str, String str2, int i2, HashSet<ImpressionDataListener> hashSet, IronSourceSegment ironSourceSegment) {
        super(hashSet, ironSourceSegment);
        this.z = "";
        this.A = false;
        this.B = i5Var.b();
        this.C = h5Var.a();
        long time = new Date().getTime();
        a((int) IronSourceConstants.IS_MANAGER_INIT_STARTED, new Object[][]{new Object[]{IronSourceConstants.EVENTS_EXT1, IronSourceConstants.PROG_IS_MANAGER_NAME}});
        a(e.STATE_NOT_INITIALIZED);
        ConcurrentHashMap<String, z> concurrentHashMap = new ConcurrentHashMap<>();
        this.g = concurrentHashMap;
        this.h = new CopyOnWriteArrayList<>();
        this.i = new ConcurrentHashMap<>();
        this.j = new ConcurrentHashMap<>();
        this.l = "";
        this.m = "";
        this.n = null;
        this.o = m7Var.c();
        this.p = m7Var.f();
        this.q = m7Var.h();
        this.r = m7Var.i();
        n a2 = n.a();
        IronSource.AD_UNIT ad_unit = IronSource.AD_UNIT.INTERSTITIAL;
        a2.a(ad_unit, i2);
        com.ironsource.mediationsdk.utils.a g2 = m7Var.g();
        this.w = g2.k();
        boolean z2 = g2.g() > 0;
        this.s = z2;
        if (z2) {
            this.t = new e(ad_unit, g2, this);
        }
        a(list, m7Var, str, str2);
        this.u = new h(list, g2.c());
        this.e = new kb(new ArrayList(concurrentHashMap.values()));
        for (z next : concurrentHashMap.values()) {
            if (next.r()) {
                next.t();
            }
        }
        this.v = new Date().getTime();
        a(e.STATE_READY_TO_LOAD);
        a((int) IronSourceConstants.IS_MANAGER_INIT_ENDED, new Object[][]{new Object[]{IronSourceConstants.EVENTS_DURATION, Long.valueOf(new Date().getTime() - time)}});
    }

    public y(List<NetworkSettings> list, m7 m7Var, String str, String str2, int i2, HashSet<ImpressionDataListener> hashSet, IronSourceSegment ironSourceSegment) {
        this(w8.e(), w8.d(), list, m7Var, str, str2, i2, hashSet, ironSourceSegment);
    }

    private String a(d1 d1Var) {
        z zVar = this.g.get(d1Var.c());
        String num = zVar != null ? Integer.toString(zVar.g()) : TextUtils.isEmpty(d1Var.j()) ? "1" : "2";
        return num + d1Var.c();
    }

    private void a(int i2) {
        a(i2, (Object[][]) null, false);
    }

    private void a(int i2, z zVar) {
        a(i2, zVar, (Object[][]) null, false);
    }

    /* access modifiers changed from: private */
    public void a(int i2, z zVar, Object[][] objArr) {
        a(i2, zVar, objArr, false);
    }

    private void a(int i2, z zVar, Object[][] objArr, boolean z2) {
        Map<String, Object> m2 = zVar.m();
        if (!TextUtils.isEmpty(this.m)) {
            m2.put("auctionId", this.m);
        }
        JSONObject jSONObject = this.n;
        if (jSONObject != null && jSONObject.length() > 0) {
            m2.put("genericParams", this.n);
        }
        if (z2 && !TextUtils.isEmpty(this.l)) {
            m2.put("placement", this.l);
        }
        if (c(i2)) {
            n7.i().a(m2, this.y, this.z);
        }
        if (objArr != null) {
            try {
                for (Object[] objArr2 : objArr) {
                    m2.put(objArr2[0].toString(), objArr2[1]);
                }
            } catch (Exception e2) {
                IronSourceLoggerManager.getLogger().log(IronSourceLogger.IronSourceTag.INTERNAL, "IS sendProviderEvent " + Log.getStackTraceString(e2), 3);
            }
        }
        n7.i().a(new y3(i2, new JSONObject(m2)));
    }

    /* access modifiers changed from: private */
    public void a(int i2, Object[][] objArr) {
        a(i2, objArr, false);
    }

    private void a(int i2, Object[][] objArr, boolean z2) {
        HashMap hashMap = new HashMap();
        hashMap.put(IronSourceConstants.EVENTS_PROVIDER, "Mediation");
        hashMap.put(IronSourceConstants.EVENTS_PROGRAMMATIC, 1);
        if (!TextUtils.isEmpty(this.m)) {
            hashMap.put("auctionId", this.m);
        }
        JSONObject jSONObject = this.n;
        if (jSONObject != null && jSONObject.length() > 0) {
            hashMap.put("genericParams", this.n);
        }
        if (z2 && !TextUtils.isEmpty(this.l)) {
            hashMap.put("placement", this.l);
        }
        if (c(i2)) {
            n7.i().a((Map<String, Object>) hashMap, this.y, this.z);
        }
        if (objArr != null) {
            try {
                for (Object[] objArr2 : objArr) {
                    hashMap.put(objArr2[0].toString(), objArr2[1]);
                }
            } catch (Exception e2) {
                b("sendMediationEvent " + e2.getMessage());
            }
        }
        n7.i().a(new y3(i2, new JSONObject(hashMap)));
    }

    /* access modifiers changed from: private */
    public void a(NetworkSettings networkSettings, m7 m7Var, String str, String str2) {
        IronLog ironLog = IronLog.INTERNAL;
        ironLog.verbose(String.format("Start initializing provider %s on thread %s", new Object[]{networkSettings.getProviderInstanceName(), Thread.currentThread().getName()}));
        NetworkSettings networkSettings2 = networkSettings;
        AbstractAdapter a2 = c.b().a(networkSettings, networkSettings.getInterstitialSettings(), false);
        if (a2 != null) {
            z zVar = new z(str, str2, networkSettings, this, m7Var.d(), a2);
            this.g.put(zVar.c(), zVar);
        }
        ironLog.verbose(String.format("Done initializing provider %s on thread %s", new Object[]{networkSettings.getProviderInstanceName(), Thread.currentThread().getName()}));
    }

    private void a(e eVar) {
        this.f = eVar;
        b("state=" + eVar);
    }

    private void a(z zVar, String str) {
        IronSourceLoggerManager.getLogger().log(IronSourceLogger.IronSourceTag.INTERNAL, "ProgIsManager " + zVar.c() + " : " + str, 0);
    }

    private void a(String str) {
        IronSourceLoggerManager.getLogger().log(IronSourceLogger.IronSourceTag.API, str, 3);
    }

    private void a(List<d1> list) {
        this.h.clear();
        this.i.clear();
        this.j.clear();
        StringBuilder sb = new StringBuilder();
        for (d1 next : list) {
            sb.append(a(next) + ",");
            z zVar = this.g.get(next.c());
            if (zVar != null) {
                zVar.a(true);
                this.h.add(zVar);
                this.i.put(zVar.c(), next);
                this.j.put(next.c(), h.a.ISAuctionPerformanceDidntAttemptToLoad);
            } else {
                b("updateWaterfall() - could not find matching smash for auction response item " + next.c());
            }
        }
        b("updateWaterfall() - next waterfall is " + sb.toString());
        if (sb.length() == 0) {
            b("Updated waterfall is empty");
        }
        a((int) IronSourceConstants.IS_RESULT_WATERFALL, new Object[][]{new Object[]{IronSourceConstants.EVENTS_EXT1, sb.toString()}});
    }

    private void a(List<NetworkSettings> list, m7 m7Var, String str, String str2) {
        ArrayList arrayList = new ArrayList();
        for (NetworkSettings aVar : list) {
            arrayList.add(new a(aVar, m7Var, str, str2));
        }
        IronSourceThreadManager.INSTANCE.executeTasks(m7Var.l(), m7Var.o(), arrayList);
    }

    /* access modifiers changed from: private */
    public void a(Map<String, Object> map, List<String> list, String str) {
        if (map.size() == 0 && list.size() == 0) {
            a((int) IronSourceConstants.IS_AUCTION_FAILED, new Object[][]{new Object[]{"errorCode", 1005}, new Object[]{IronSourceConstants.EVENTS_DURATION, 0}});
            b("makeAuction() failed - No candidates available for auctioning");
            n.a().a(IronSource.AD_UNIT.INTERSTITIAL, new IronSourceError(1005, "No candidates available for auctioning"));
            a((int) IronSourceConstants.IS_CALLBACK_LOAD_ERROR, new Object[][]{new Object[]{"errorCode", 1005}});
            a(e.STATE_READY_TO_LOAD);
            return;
        }
        a((int) IronSourceConstants.IS_AUCTION_REQUEST_WATERFALL, new Object[][]{new Object[]{IronSourceConstants.EVENTS_EXT1, str}});
        int a2 = this.B.a(IronSource.AD_UNIT.INTERSTITIAL);
        e eVar = this.t;
        if (eVar != null) {
            eVar.a(ContextProvider.getInstance().getApplicationContext(), map, list, this.u, a2, this.c);
        }
    }

    /* access modifiers changed from: private */
    public void a(Map<String, Object> map, List<String> list, StringBuilder sb, List<x1> list2) {
        if (list2.isEmpty()) {
            a(map, list, sb.toString());
            return;
        }
        a2 a2Var = new a2();
        c cVar = new c(map, sb, list);
        a((int) IronSourceConstants.IS_COLLECT_TOKENS);
        a2Var.a(list2, (a2.b) cVar, this.r, TimeUnit.MILLISECONDS);
    }

    private void b(int i2) {
        a(i2, (Object[][]) null, true);
    }

    private void b(int i2, z zVar) {
        a(i2, zVar, (Object[][]) null, true);
    }

    private void b(int i2, z zVar, Object[][] objArr) {
        a(i2, zVar, objArr, true);
    }

    private void b(int i2, Object[][] objArr) {
        a(i2, objArr, true);
    }

    private void b(z zVar, String str) {
        a(e.STATE_SHOWING);
        zVar.x();
        b(2201, zVar);
        this.e.a(zVar);
        if (this.e.b(zVar)) {
            a((int) IronSourceConstants.IS_CAP_SESSION, zVar);
            IronSourceUtils.sendAutomationLog(zVar.c() + " was session capped");
        }
        com.ironsource.mediationsdk.utils.b.b(ContextProvider.getInstance().getApplicationContext(), str);
        if (com.ironsource.mediationsdk.utils.b.e(ContextProvider.getInstance().getApplicationContext(), str)) {
            b((int) IronSourceConstants.IS_CAP_PLACEMENT);
        }
    }

    private void b(String str) {
        IronSourceLoggerManager logger = IronSourceLoggerManager.getLogger();
        IronSourceLogger.IronSourceTag ironSourceTag = IronSourceLogger.IronSourceTag.INTERNAL;
        logger.log(ironSourceTag, "ProgIsManager " + str, 0);
    }

    /* access modifiers changed from: private */
    public void b(Map<String, Object> map, List<String> list, StringBuilder sb, List<x1> list2) {
        for (z next : this.g.values()) {
            if (h(next)) {
                if (!next.p()) {
                    list.add(next.c());
                    sb.append(next.g() + next.c() + ",");
                } else if (this.q) {
                    list2.add(new x1(next.g(), next.c(), (AdData) null, next, (y1) null, (NetworkSettings) null));
                } else {
                    try {
                        Map<String, Object> a2 = next.a((AdData) null);
                        if (a2 != null) {
                            map.put(next.c(), a2);
                            sb.append(next.g() + next.c() + ",");
                        } else {
                            a((int) IronSourceConstants.TROUBLESHOOTING_IS_BIDDING_DATA_MISSING, next, new Object[][]{new Object[]{"reason", "Missing bidding data"}});
                        }
                    } catch (Exception e2) {
                        String str = "prepareAuctionCandidates - exception while calling smash.getBiddingData - " + e2.getMessage();
                        IronLog.INTERNAL.error(str);
                        next.a((int) IronSourceConstants.TROUBLESHOOTING_IS_INTERNAL_ERROR, new Object[][]{new Object[]{"reason", str}});
                    } catch (NoClassDefFoundError e3) {
                        String str2 = "prepareAuctionCandidates - error while calling smash.getBiddingData - " + e3.getMessage();
                        IronLog.INTERNAL.error(str2);
                        next.a((int) IronSourceConstants.TROUBLESHOOTING_IS_INTERNAL_ERROR, new Object[][]{new Object[]{"reason", str2}});
                    }
                }
            }
        }
    }

    private boolean c(int i2) {
        return i2 == 2002 || i2 == 2003 || i2 == 2200 || i2 == 2213 || i2 == 2005 || i2 == 2204 || i2 == 2201 || i2 == 2203 || i2 == 2006 || i2 == 2004 || i2 == 2110 || i2 == 2301 || i2 == 2300 || i2 == 2303;
    }

    private List<d1> g() {
        CopyOnWriteArrayList copyOnWriteArrayList = new CopyOnWriteArrayList();
        for (z next : this.g.values()) {
            if (!next.p() && h(next)) {
                copyOnWriteArrayList.add(new d1(next.c()));
            }
        }
        return copyOnWriteArrayList;
    }

    private void g(z zVar) {
        String j2 = this.i.get(zVar.c()).j();
        JSONObject a2 = this.i.get(zVar.c()).a();
        zVar.c(j2);
        a(2002, zVar);
        zVar.a(j2, a2);
    }

    private boolean h(z zVar) {
        IronLog.INTERNAL.verbose();
        return zVar != null && !zVar.o() && !this.e.b(zVar);
    }

    private void j() {
        if (this.h.isEmpty()) {
            a(e.STATE_READY_TO_LOAD);
            a((int) IronSourceConstants.IS_CALLBACK_LOAD_ERROR, new Object[][]{new Object[]{"errorCode", Integer.valueOf(IronSourceError.ERROR_IS_LOAD_FAILED_NO_CANDIDATES)}, new Object[]{"reason", "Empty waterfall"}});
            n.a().a(IronSource.AD_UNIT.INTERSTITIAL, new IronSourceError(IronSourceError.ERROR_IS_LOAD_FAILED_NO_CANDIDATES, "Empty waterfall"));
            return;
        }
        a(e.STATE_LOADING_SMASHES);
        int i2 = 0;
        for (int i3 = 0; i3 < this.h.size() && i2 < this.o; i3++) {
            z zVar = this.h.get(i3);
            if (zVar.h()) {
                if (!this.p || !zVar.p()) {
                    g(zVar);
                    i2++;
                } else if (i2 == 0) {
                    String str = "Advanced Loading: Starting to load bidder " + zVar.c() + ". No other instances will be loaded at the same time.";
                    b(str);
                    IronSourceUtils.sendAutomationLog(str);
                    g(zVar);
                    return;
                } else {
                    String str2 = "Advanced Loading: Won't start loading bidder " + zVar.c() + " as a non bidder is being loaded";
                    b(str2);
                    IronSourceUtils.sendAutomationLog(str2);
                    return;
                }
            }
        }
    }

    /* access modifiers changed from: private */
    public void k() {
        a(e.STATE_AUCTION);
        AsyncTask.execute(new b());
    }

    private void l() {
        List<d1> g2 = g();
        this.m = e();
        a(g2);
    }

    /* access modifiers changed from: private */
    public boolean m() {
        long time = this.w - (new Date().getTime() - this.v);
        if (time <= 0) {
            return false;
        }
        IronLog ironLog = IronLog.INTERNAL;
        ironLog.verbose("delaying auction by " + time);
        IronSourceThreadManager.INSTANCE.postMediationBackgroundTask(new d(), time);
        return true;
    }

    public void a(int i2, String str, int i3, String str2, long j2) {
        String str3 = "Auction failed | moving to fallback waterfall (error " + i2 + " - " + str + ")";
        b(str3);
        IronSourceUtils.sendAutomationLog("IS: " + str3);
        this.y = i3;
        this.z = str2;
        this.n = null;
        l();
        if (TextUtils.isEmpty(str)) {
            a((int) IronSourceConstants.IS_AUCTION_FAILED, new Object[][]{new Object[]{"errorCode", Integer.valueOf(i2)}, new Object[]{IronSourceConstants.EVENTS_DURATION, Long.valueOf(j2)}});
        } else {
            a((int) IronSourceConstants.IS_AUCTION_FAILED, new Object[][]{new Object[]{"errorCode", Integer.valueOf(i2)}, new Object[]{"reason", str}, new Object[]{IronSourceConstants.EVENTS_DURATION, Long.valueOf(j2)}});
        }
        j();
    }

    public synchronized void a(Activity activity, String str) {
        Object[][] objArr;
        e eVar = this.f;
        if (eVar == e.STATE_SHOWING) {
            a("showInterstitial error: can't show ad while an ad is already showing");
            u5.a().a(new IronSourceError(IronSourceError.ERROR_IS_SHOW_CALLED_DURING_SHOW, "showInterstitial error: can't show ad while an ad is already showing"), this.d);
            a((int) IronSourceConstants.IS_CALLBACK_AD_SHOW_ERROR, new Object[][]{new Object[]{"errorCode", Integer.valueOf(IronSourceError.ERROR_IS_SHOW_CALLED_DURING_SHOW)}, new Object[]{"reason", "showInterstitial error: can't show ad while an ad is already showing"}});
        } else if (eVar != e.STATE_READY_TO_SHOW) {
            b("showInterstitial() error state=" + this.f.toString());
            a("showInterstitial error: show called while no ads are available");
            u5.a().a(new IronSourceError(IronSourceError.ERROR_CODE_NO_ADS_TO_SHOW, "showInterstitial error: show called while no ads are available"), this.d);
            a((int) IronSourceConstants.IS_CALLBACK_AD_SHOW_ERROR, new Object[][]{new Object[]{"errorCode", Integer.valueOf(IronSourceError.ERROR_CODE_NO_ADS_TO_SHOW)}, new Object[]{"reason", "showInterstitial error: show called while no ads are available"}});
        } else if (str == null) {
            a("showInterstitial error: empty default placement");
            u5.a().a(new IronSourceError(1020, "showInterstitial error: empty default placement"), this.d);
            a((int) IronSourceConstants.IS_CALLBACK_AD_SHOW_ERROR, new Object[][]{new Object[]{"errorCode", 1020}, new Object[]{"reason", "showInterstitial error: empty default placement"}});
        } else {
            this.l = str;
            if (activity != null) {
                objArr = new Object[][]{new Object[]{IronSourceConstants.EVENTS_EXT1, IronSourceConstants.EVENTS_INIT_CONTEXT_FLOW}};
            } else {
                objArr = null;
            }
            b((int) IronSourceConstants.IS_SHOW_CALLED, objArr);
            if (com.ironsource.mediationsdk.utils.b.e(ContextProvider.getInstance().getApplicationContext(), str)) {
                String str2 = "placement " + this.l + " is capped";
                a(str2);
                u5.a().a(new IronSourceError(IronSourceError.ERROR_REACHED_CAP_LIMIT_PER_PLACEMENT, str2), this.d);
                b((int) IronSourceConstants.IS_CALLBACK_AD_SHOW_ERROR, new Object[][]{new Object[]{"errorCode", Integer.valueOf(IronSourceError.ERROR_REACHED_CAP_LIMIT_PER_PLACEMENT)}, new Object[]{"reason", str2}});
                return;
            }
            Iterator<z> it = this.h.iterator();
            while (it.hasNext()) {
                z next = it.next();
                if (next.v()) {
                    b(next, str);
                    return;
                }
                b("showInterstitial " + next.c() + " isReadyToShow() == false");
            }
            u5.a().a(ErrorBuilder.buildNoAdsToShowError("Interstitial"), this.d);
            b((int) IronSourceConstants.IS_CALLBACK_AD_SHOW_ERROR, new Object[][]{new Object[]{"errorCode", Integer.valueOf(IronSourceError.ERROR_CODE_NO_ADS_TO_SHOW)}, new Object[]{"reason", "Show Fail - No ads to show"}});
        }
    }

    /* access modifiers changed from: package-private */
    public void a(Context context, boolean z2) {
        IronSourceLoggerManager logger = IronSourceLoggerManager.getLogger();
        IronSourceLogger.IronSourceTag ironSourceTag = IronSourceLogger.IronSourceTag.INTERNAL;
        logger.log(ironSourceTag, "Should Track Network State: " + z2, 0);
        this.A = z2;
    }

    public void a(IronSourceError ironSourceError, z zVar) {
        a((int) IronSourceConstants.IS_INSTANCE_INIT_FAILED, zVar, new Object[][]{new Object[]{"reason", ironSourceError.getErrorMessage()}});
    }

    /* JADX WARNING: Code restructure failed: missing block: B:24:0x00f5, code lost:
        if (r10 == false) goto L_0x00fa;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x00f7, code lost:
        r8 = "a non bidder is being loaded";
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x00fa, code lost:
        r8 = "a non bidder was already loaded successfully";
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x00fc, code lost:
        r8 = "Advanced Loading: Won't start loading bidder " + r0.c() + " as " + r8;
        b(r8);
        com.ironsource.mediationsdk.utils.IronSourceUtils.sendAutomationLog(r8);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void a(com.ironsource.mediationsdk.logger.IronSourceError r8, com.ironsource.mediationsdk.z r9, long r10) {
        /*
            r7 = this;
            java.lang.String r0 = "onInterstitialAdLoadFailed error="
            java.util.concurrent.CopyOnWriteArrayList r1 = new java.util.concurrent.CopyOnWriteArrayList
            r1.<init>()
            monitor-enter(r7)
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x01b5 }
            r2.<init>(r0)     // Catch:{ all -> 0x01b5 }
            java.lang.String r0 = r8.getErrorMessage()     // Catch:{ all -> 0x01b5 }
            r2.append(r0)     // Catch:{ all -> 0x01b5 }
            java.lang.String r0 = " state="
            r2.append(r0)     // Catch:{ all -> 0x01b5 }
            com.ironsource.mediationsdk.y$e r0 = r7.f     // Catch:{ all -> 0x01b5 }
            java.lang.String r0 = r0.name()     // Catch:{ all -> 0x01b5 }
            r2.append(r0)     // Catch:{ all -> 0x01b5 }
            java.lang.String r0 = r2.toString()     // Catch:{ all -> 0x01b5 }
            r7.a((com.ironsource.mediationsdk.z) r9, (java.lang.String) r0)     // Catch:{ all -> 0x01b5 }
            int r0 = r8.getErrorCode()     // Catch:{ all -> 0x01b5 }
            r2 = 1158(0x486, float:1.623E-42)
            r3 = 2
            r4 = 1
            r5 = 0
            if (r0 != r2) goto L_0x005c
            java.lang.Object[][] r0 = new java.lang.Object[r3][]     // Catch:{ all -> 0x01b5 }
            java.lang.Object[] r2 = new java.lang.Object[r3]     // Catch:{ all -> 0x01b5 }
            java.lang.String r6 = "errorCode"
            r2[r5] = r6     // Catch:{ all -> 0x01b5 }
            int r8 = r8.getErrorCode()     // Catch:{ all -> 0x01b5 }
            java.lang.Integer r8 = java.lang.Integer.valueOf(r8)     // Catch:{ all -> 0x01b5 }
            r2[r4] = r8     // Catch:{ all -> 0x01b5 }
            r0[r5] = r2     // Catch:{ all -> 0x01b5 }
            java.lang.Object[] r8 = new java.lang.Object[r3]     // Catch:{ all -> 0x01b5 }
            java.lang.String r2 = "duration"
            r8[r5] = r2     // Catch:{ all -> 0x01b5 }
            java.lang.Long r10 = java.lang.Long.valueOf(r10)     // Catch:{ all -> 0x01b5 }
            r8[r4] = r10     // Catch:{ all -> 0x01b5 }
            r0[r4] = r8     // Catch:{ all -> 0x01b5 }
            r8 = 2213(0x8a5, float:3.101E-42)
            r7.a((int) r8, (com.ironsource.mediationsdk.z) r9, (java.lang.Object[][]) r0)     // Catch:{ all -> 0x01b5 }
            goto L_0x0092
        L_0x005c:
            r0 = 3
            java.lang.Object[][] r0 = new java.lang.Object[r0][]     // Catch:{ all -> 0x01b5 }
            java.lang.Object[] r2 = new java.lang.Object[r3]     // Catch:{ all -> 0x01b5 }
            java.lang.String r6 = "errorCode"
            r2[r5] = r6     // Catch:{ all -> 0x01b5 }
            int r6 = r8.getErrorCode()     // Catch:{ all -> 0x01b5 }
            java.lang.Integer r6 = java.lang.Integer.valueOf(r6)     // Catch:{ all -> 0x01b5 }
            r2[r4] = r6     // Catch:{ all -> 0x01b5 }
            r0[r5] = r2     // Catch:{ all -> 0x01b5 }
            java.lang.Object[] r2 = new java.lang.Object[r3]     // Catch:{ all -> 0x01b5 }
            java.lang.String r6 = "reason"
            r2[r5] = r6     // Catch:{ all -> 0x01b5 }
            java.lang.String r8 = r8.getErrorMessage()     // Catch:{ all -> 0x01b5 }
            r2[r4] = r8     // Catch:{ all -> 0x01b5 }
            r0[r4] = r2     // Catch:{ all -> 0x01b5 }
            java.lang.Object[] r8 = new java.lang.Object[r3]     // Catch:{ all -> 0x01b5 }
            java.lang.String r2 = "duration"
            r8[r5] = r2     // Catch:{ all -> 0x01b5 }
            java.lang.Long r10 = java.lang.Long.valueOf(r10)     // Catch:{ all -> 0x01b5 }
            r8[r4] = r10     // Catch:{ all -> 0x01b5 }
            r0[r3] = r8     // Catch:{ all -> 0x01b5 }
            r8 = 2200(0x898, float:3.083E-42)
            r7.a((int) r8, (com.ironsource.mediationsdk.z) r9, (java.lang.Object[][]) r0)     // Catch:{ all -> 0x01b5 }
        L_0x0092:
            if (r9 == 0) goto L_0x00ab
            java.util.concurrent.ConcurrentHashMap<java.lang.String, com.ironsource.mediationsdk.h$a> r8 = r7.j     // Catch:{ all -> 0x01b5 }
            java.lang.String r10 = r9.c()     // Catch:{ all -> 0x01b5 }
            boolean r8 = r8.containsKey(r10)     // Catch:{ all -> 0x01b5 }
            if (r8 == 0) goto L_0x00ab
            java.util.concurrent.ConcurrentHashMap<java.lang.String, com.ironsource.mediationsdk.h$a> r8 = r7.j     // Catch:{ all -> 0x01b5 }
            java.lang.String r10 = r9.c()     // Catch:{ all -> 0x01b5 }
            com.ironsource.mediationsdk.h$a r11 = com.ironsource.mediationsdk.h.a.ISAuctionPerformanceFailedToLoad     // Catch:{ all -> 0x01b5 }
            r8.put(r10, r11)     // Catch:{ all -> 0x01b5 }
        L_0x00ab:
            java.util.concurrent.CopyOnWriteArrayList<com.ironsource.mediationsdk.z> r8 = r7.h     // Catch:{ all -> 0x01b5 }
            java.util.Iterator r8 = r8.iterator()     // Catch:{ all -> 0x01b5 }
            r10 = 0
            r11 = 0
        L_0x00b3:
            boolean r0 = r8.hasNext()     // Catch:{ all -> 0x01b5 }
            if (r0 == 0) goto L_0x014e
            java.lang.Object r0 = r8.next()     // Catch:{ all -> 0x01b5 }
            com.ironsource.mediationsdk.z r0 = (com.ironsource.mediationsdk.z) r0     // Catch:{ all -> 0x01b5 }
            boolean r2 = r0.h()     // Catch:{ all -> 0x01b5 }
            if (r2 == 0) goto L_0x013c
            boolean r2 = r7.p     // Catch:{ all -> 0x01b5 }
            if (r2 == 0) goto L_0x0120
            boolean r2 = r0.p()     // Catch:{ all -> 0x01b5 }
            if (r2 == 0) goto L_0x0120
            if (r10 != 0) goto L_0x00f5
            if (r11 == 0) goto L_0x00d4
            goto L_0x00f5
        L_0x00d4:
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x01b5 }
            r2.<init>()     // Catch:{ all -> 0x01b5 }
            java.lang.String r6 = "Advanced Loading: Starting to load bidder "
            r2.append(r6)     // Catch:{ all -> 0x01b5 }
            java.lang.String r6 = r0.c()     // Catch:{ all -> 0x01b5 }
            r2.append(r6)     // Catch:{ all -> 0x01b5 }
            java.lang.String r6 = ". No other instances will be loaded at the same time."
            r2.append(r6)     // Catch:{ all -> 0x01b5 }
            java.lang.String r2 = r2.toString()     // Catch:{ all -> 0x01b5 }
            r7.b((java.lang.String) r2)     // Catch:{ all -> 0x01b5 }
            com.ironsource.mediationsdk.utils.IronSourceUtils.sendAutomationLog(r2)     // Catch:{ all -> 0x01b5 }
            goto L_0x0120
        L_0x00f5:
            if (r10 == 0) goto L_0x00fa
            java.lang.String r8 = "a non bidder is being loaded"
            goto L_0x00fc
        L_0x00fa:
            java.lang.String r8 = "a non bidder was already loaded successfully"
        L_0x00fc:
            java.lang.StringBuilder r9 = new java.lang.StringBuilder     // Catch:{ all -> 0x01b5 }
            r9.<init>()     // Catch:{ all -> 0x01b5 }
            java.lang.String r11 = "Advanced Loading: Won't start loading bidder "
            r9.append(r11)     // Catch:{ all -> 0x01b5 }
            java.lang.String r11 = r0.c()     // Catch:{ all -> 0x01b5 }
            r9.append(r11)     // Catch:{ all -> 0x01b5 }
            java.lang.String r11 = " as "
            r9.append(r11)     // Catch:{ all -> 0x01b5 }
            r9.append(r8)     // Catch:{ all -> 0x01b5 }
            java.lang.String r8 = r9.toString()     // Catch:{ all -> 0x01b5 }
            r7.b((java.lang.String) r8)     // Catch:{ all -> 0x01b5 }
            com.ironsource.mediationsdk.utils.IronSourceUtils.sendAutomationLog(r8)     // Catch:{ all -> 0x01b5 }
            goto L_0x014e
        L_0x0120:
            r1.add(r0)     // Catch:{ all -> 0x01b5 }
            boolean r2 = r7.p     // Catch:{ all -> 0x01b5 }
            if (r2 == 0) goto L_0x014e
            boolean r2 = r9.p()     // Catch:{ all -> 0x01b5 }
            if (r2 == 0) goto L_0x014e
            boolean r0 = r0.p()     // Catch:{ all -> 0x01b5 }
            if (r0 != 0) goto L_0x014e
            int r0 = r1.size()     // Catch:{ all -> 0x01b5 }
            int r2 = r7.o     // Catch:{ all -> 0x01b5 }
            if (r0 >= r2) goto L_0x014e
            goto L_0x0142
        L_0x013c:
            boolean r2 = r0.u()     // Catch:{ all -> 0x01b5 }
            if (r2 == 0) goto L_0x0145
        L_0x0142:
            r10 = 1
            goto L_0x00b3
        L_0x0145:
            boolean r0 = r0.v()     // Catch:{ all -> 0x01b5 }
            if (r0 == 0) goto L_0x00b3
            r11 = 1
            goto L_0x00b3
        L_0x014e:
            int r8 = r1.size()     // Catch:{ all -> 0x01b5 }
            if (r8 != 0) goto L_0x0188
            com.ironsource.mediationsdk.y$e r8 = r7.f     // Catch:{ all -> 0x01b5 }
            com.ironsource.mediationsdk.y$e r9 = com.ironsource.mediationsdk.y.e.STATE_LOADING_SMASHES     // Catch:{ all -> 0x01b5 }
            if (r8 != r9) goto L_0x0188
            if (r10 != 0) goto L_0x0188
            com.ironsource.mediationsdk.n r8 = com.ironsource.mediationsdk.n.a()     // Catch:{ all -> 0x01b5 }
            com.ironsource.mediationsdk.IronSource$AD_UNIT r9 = com.ironsource.mediationsdk.IronSource.AD_UNIT.INTERSTITIAL     // Catch:{ all -> 0x01b5 }
            com.ironsource.mediationsdk.logger.IronSourceError r10 = new com.ironsource.mediationsdk.logger.IronSourceError     // Catch:{ all -> 0x01b5 }
            java.lang.String r11 = "No ads to show"
            r0 = 509(0x1fd, float:7.13E-43)
            r10.<init>(r0, r11)     // Catch:{ all -> 0x01b5 }
            r8.a((com.ironsource.mediationsdk.IronSource.AD_UNIT) r9, (com.ironsource.mediationsdk.logger.IronSourceError) r10)     // Catch:{ all -> 0x01b5 }
            java.lang.Object[][] r8 = new java.lang.Object[r4][]     // Catch:{ all -> 0x01b5 }
            java.lang.Object[] r9 = new java.lang.Object[r3]     // Catch:{ all -> 0x01b5 }
            java.lang.String r10 = "errorCode"
            r9[r5] = r10     // Catch:{ all -> 0x01b5 }
            java.lang.Integer r10 = java.lang.Integer.valueOf(r0)     // Catch:{ all -> 0x01b5 }
            r9[r4] = r10     // Catch:{ all -> 0x01b5 }
            r8[r5] = r9     // Catch:{ all -> 0x01b5 }
            r9 = 2110(0x83e, float:2.957E-42)
            r7.a((int) r9, (java.lang.Object[][]) r8)     // Catch:{ all -> 0x01b5 }
            com.ironsource.mediationsdk.y$e r8 = com.ironsource.mediationsdk.y.e.STATE_READY_TO_LOAD     // Catch:{ all -> 0x01b5 }
            r7.a((com.ironsource.mediationsdk.y.e) r8)     // Catch:{ all -> 0x01b5 }
        L_0x0188:
            monitor-exit(r7)     // Catch:{ all -> 0x01b5 }
            com.ironsource.mediationsdk.logger.IronLog r8 = com.ironsource.mediationsdk.logger.IronLog.INTERNAL
            java.lang.StringBuilder r9 = new java.lang.StringBuilder
            java.lang.String r10 = "smashesToLoad.size() = "
            r9.<init>(r10)
            int r10 = r1.size()
            r9.append(r10)
            java.lang.String r9 = r9.toString()
            r8.verbose(r9)
            java.util.Iterator r8 = r1.iterator()
        L_0x01a4:
            boolean r9 = r8.hasNext()
            if (r9 == 0) goto L_0x01b4
            java.lang.Object r9 = r8.next()
            com.ironsource.mediationsdk.z r9 = (com.ironsource.mediationsdk.z) r9
            r7.g(r9)
            goto L_0x01a4
        L_0x01b4:
            return
        L_0x01b5:
            r8 = move-exception
            monitor-exit(r7)     // Catch:{ all -> 0x01b5 }
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ironsource.mediationsdk.y.a(com.ironsource.mediationsdk.logger.IronSourceError, com.ironsource.mediationsdk.z, long):void");
    }

    public void a(z zVar) {
        synchronized (this) {
            a(zVar, "onInterstitialAdOpened");
            b(2005, zVar);
            if (this.s) {
                d1 d1Var = this.i.get(zVar.c());
                if (d1Var != null) {
                    a(d1Var.a(this.l));
                    this.t.a(d1Var, zVar.g(), this.k, this.l);
                    this.j.put(zVar.c(), h.a.ISAuctionPerformanceShowedSuccessfully);
                    a(d1Var, this.l);
                } else {
                    String c2 = zVar.c();
                    b("onInterstitialAdOpened showing instance " + c2 + " missing from waterfall");
                    StringBuilder sb = new StringBuilder("Showing missing ");
                    sb.append(this.f);
                    a((int) IronSourceConstants.TROUBLESHOOTING_IS_NOTIFICATIONS_ERROR, new Object[][]{new Object[]{"errorCode", 1011}, new Object[]{"reason", sb.toString()}, new Object[]{IronSourceConstants.EVENTS_EXT1, c2}});
                }
            }
            u5.a().d(this.d);
        }
    }

    public void a(z zVar, long j2) {
        z zVar2 = zVar;
        synchronized (this) {
            a(zVar2, "onInterstitialAdReady");
            a(2003, zVar2, new Object[][]{new Object[]{IronSourceConstants.EVENTS_DURATION, Long.valueOf(j2)}});
            if (zVar2 != null && this.j.containsKey(zVar.c())) {
                this.j.put(zVar.c(), h.a.ISAuctionPerformanceLoadedSuccessfully);
            }
            if (this.f == e.STATE_LOADING_SMASHES) {
                a(e.STATE_READY_TO_SHOW);
                a((int) IronSourceConstants.IS_CALLBACK_LOAD_SUCCESS, new Object[][]{new Object[]{IronSourceConstants.EVENTS_DURATION, Long.valueOf(new Date().getTime() - this.x)}});
                if (this.s) {
                    d1 d1Var = this.i.get(zVar.c());
                    if (d1Var != null) {
                        a(d1Var.a(""));
                        this.t.a(d1Var, zVar.g(), this.k);
                        this.t.a((CopyOnWriteArrayList<a0>) this.h, this.i, zVar.g(), this.k, d1Var);
                    } else {
                        String c2 = zVar.c();
                        b("onInterstitialAdReady winner instance " + c2 + " missing from waterfall");
                        a((int) IronSourceConstants.TROUBLESHOOTING_IS_NOTIFICATIONS_ERROR, new Object[][]{new Object[]{"errorCode", 1010}, new Object[]{"reason", "Loaded missing"}, new Object[]{IronSourceConstants.EVENTS_EXT1, c2}});
                    }
                }
                u5.a().e(this.d);
            }
        }
    }

    public void a(List<d1> list, String str, d1 d1Var, JSONObject jSONObject, JSONObject jSONObject2, int i2, long j2, int i3, String str2) {
        this.m = str;
        this.k = d1Var;
        this.n = jSONObject;
        this.y = i2;
        this.z = "";
        if (!TextUtils.isEmpty(str2)) {
            a(88002, new Object[][]{new Object[]{"errorCode", Integer.valueOf(i3)}, new Object[]{"reason", str2}});
        }
        IronSource.AD_UNIT ad_unit = IronSource.AD_UNIT.INTERSTITIAL;
        a(jSONObject2, ad_unit);
        if (this.b.a(ad_unit)) {
            a(2303, new Object[][]{new Object[]{"auctionId", str}});
            a(e.STATE_READY_TO_LOAD);
            n.a().a(ad_unit, new IronSourceError(IronSourceError.ERROR_AD_UNIT_CAPPED, "Ad unit is capped"));
            return;
        }
        a((int) IronSourceConstants.IS_AUCTION_SUCCESS, new Object[][]{new Object[]{IronSourceConstants.EVENTS_DURATION, Long.valueOf(j2)}});
        a(list);
        j();
    }

    public void b(IronSourceError ironSourceError, z zVar) {
        d1 d1Var;
        synchronized (this) {
            if (this.s && (d1Var = this.i.get(zVar.c())) != null) {
                a(d1Var.a(this.l));
            }
            a(zVar, "onInterstitialAdShowFailed error=" + ironSourceError.getErrorMessage());
            u5.a().a(ironSourceError, this.d);
            b(2203, zVar, new Object[][]{new Object[]{"errorCode", Integer.valueOf(ironSourceError.getErrorCode())}, new Object[]{"reason", ironSourceError.getErrorMessage()}});
            this.j.put(zVar.c(), h.a.ISAuctionPerformanceFailedToShow);
            a(e.STATE_READY_TO_LOAD);
        }
    }

    public void b(z zVar) {
        a((int) IronSourceConstants.IS_INSTANCE_INIT_SUCCESS, zVar);
    }

    public void c(z zVar) {
        synchronized (this) {
            a(zVar, "onInterstitialAdClosed");
            w6 w6Var = this.B;
            IronSource.AD_UNIT ad_unit = IronSource.AD_UNIT.INTERSTITIAL;
            b(2204, zVar, new Object[][]{new Object[]{"sessionDepth", Integer.valueOf(w6Var.a(ad_unit))}});
            this.C.b(ad_unit);
            u5.a().c(this.d);
            a(e.STATE_READY_TO_LOAD);
        }
    }

    public void d(z zVar) {
        a(zVar, "onInterstitialAdClicked");
        u5.a().b(this.d);
        b(2006, zVar);
    }

    public void e(z zVar) {
        a(zVar, "onInterstitialAdVisible");
    }

    public void f(z zVar) {
        a(zVar, "onInterstitialAdShowSucceeded");
        u5.a().f(this.d);
        b(2202, zVar);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:9:0x001b, code lost:
        return false;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized boolean h() {
        /*
            r3 = this;
            monitor-enter(r3)
            boolean r0 = r3.A     // Catch:{ all -> 0x0039 }
            r1 = 0
            if (r0 == 0) goto L_0x0014
            com.ironsource.environment.ContextProvider r0 = com.ironsource.environment.ContextProvider.getInstance()     // Catch:{ all -> 0x0039 }
            android.content.Context r0 = r0.getApplicationContext()     // Catch:{ all -> 0x0039 }
            boolean r0 = com.ironsource.mediationsdk.utils.IronSourceUtils.isNetworkConnected(r0)     // Catch:{ all -> 0x0039 }
            if (r0 == 0) goto L_0x001a
        L_0x0014:
            com.ironsource.mediationsdk.y$e r0 = r3.f     // Catch:{ all -> 0x0039 }
            com.ironsource.mediationsdk.y$e r2 = com.ironsource.mediationsdk.y.e.STATE_READY_TO_SHOW     // Catch:{ all -> 0x0039 }
            if (r0 == r2) goto L_0x001c
        L_0x001a:
            monitor-exit(r3)
            return r1
        L_0x001c:
            java.util.concurrent.CopyOnWriteArrayList<com.ironsource.mediationsdk.z> r0 = r3.h     // Catch:{ all -> 0x0039 }
            java.util.Iterator r0 = r0.iterator()     // Catch:{ all -> 0x0039 }
        L_0x0022:
            boolean r2 = r0.hasNext()     // Catch:{ all -> 0x0039 }
            if (r2 == 0) goto L_0x0037
            java.lang.Object r2 = r0.next()     // Catch:{ all -> 0x0039 }
            com.ironsource.mediationsdk.z r2 = (com.ironsource.mediationsdk.z) r2     // Catch:{ all -> 0x0039 }
            boolean r2 = r2.v()     // Catch:{ all -> 0x0039 }
            if (r2 == 0) goto L_0x0022
            monitor-exit(r3)
            r0 = 1
            return r0
        L_0x0037:
            monitor-exit(r3)
            return r1
        L_0x0039:
            r0 = move-exception
            monitor-exit(r3)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ironsource.mediationsdk.y.h():boolean");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:27:0x0084, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized void i() {
        /*
            r4 = this;
            monitor-enter(r4)
            com.ironsource.mediationsdk.y$e r0 = r4.f     // Catch:{ all -> 0x0085 }
            com.ironsource.mediationsdk.y$e r1 = com.ironsource.mediationsdk.y.e.STATE_SHOWING     // Catch:{ all -> 0x0085 }
            if (r0 != r1) goto L_0x0025
            com.ironsource.mediationsdk.logger.IronSourceLoggerManager r0 = com.ironsource.mediationsdk.logger.IronSourceLoggerManager.getLogger()     // Catch:{ all -> 0x0085 }
            com.ironsource.mediationsdk.logger.IronSourceLogger$IronSourceTag r1 = com.ironsource.mediationsdk.logger.IronSourceLogger.IronSourceTag.API     // Catch:{ all -> 0x0085 }
            java.lang.String r2 = "loadInterstitial: load cannot be invoked while showing an ad"
            r3 = 3
            r0.log(r1, r2, r3)     // Catch:{ all -> 0x0085 }
            com.ironsource.mediationsdk.logger.IronSourceError r0 = new com.ironsource.mediationsdk.logger.IronSourceError     // Catch:{ all -> 0x0085 }
            java.lang.String r1 = "loadInterstitial: load cannot be invoked while showing an ad"
            r2 = 1037(0x40d, float:1.453E-42)
            r0.<init>(r2, r1)     // Catch:{ all -> 0x0085 }
            com.ironsource.u5 r1 = com.ironsource.u5.a()     // Catch:{ all -> 0x0085 }
            r1.a((com.ironsource.mediationsdk.logger.IronSourceError) r0)     // Catch:{ all -> 0x0085 }
            monitor-exit(r4)
            return
        L_0x0025:
            com.ironsource.mediationsdk.y$e r1 = com.ironsource.mediationsdk.y.e.STATE_READY_TO_LOAD     // Catch:{ all -> 0x0085 }
            if (r0 == r1) goto L_0x002d
            com.ironsource.mediationsdk.y$e r1 = com.ironsource.mediationsdk.y.e.STATE_READY_TO_SHOW     // Catch:{ all -> 0x0085 }
            if (r0 != r1) goto L_0x0039
        L_0x002d:
            com.ironsource.mediationsdk.n r0 = com.ironsource.mediationsdk.n.a()     // Catch:{ all -> 0x0085 }
            com.ironsource.mediationsdk.IronSource$AD_UNIT r1 = com.ironsource.mediationsdk.IronSource.AD_UNIT.INTERSTITIAL     // Catch:{ all -> 0x0085 }
            boolean r0 = r0.b(r1)     // Catch:{ all -> 0x0085 }
            if (r0 == 0) goto L_0x0040
        L_0x0039:
            java.lang.String r0 = "loadInterstitial: load is already in progress"
            r4.b((java.lang.String) r0)     // Catch:{ all -> 0x0085 }
            monitor-exit(r4)
            return
        L_0x0040:
            java.lang.String r0 = ""
            r4.m = r0     // Catch:{ all -> 0x0085 }
            java.lang.String r0 = ""
            r4.l = r0     // Catch:{ all -> 0x0085 }
            r0 = 0
            r4.n = r0     // Catch:{ all -> 0x0085 }
            r4.a((com.ironsource.mediationsdk.IronSource.AD_UNIT) r1)     // Catch:{ all -> 0x0085 }
            r4.f()     // Catch:{ all -> 0x0085 }
            r0 = 2001(0x7d1, float:2.804E-42)
            r4.a((int) r0)     // Catch:{ all -> 0x0085 }
            java.util.Date r0 = new java.util.Date     // Catch:{ all -> 0x0085 }
            r0.<init>()     // Catch:{ all -> 0x0085 }
            long r0 = r0.getTime()     // Catch:{ all -> 0x0085 }
            r4.x = r0     // Catch:{ all -> 0x0085 }
            boolean r0 = r4.s     // Catch:{ all -> 0x0085 }
            if (r0 == 0) goto L_0x007d
            java.util.concurrent.ConcurrentHashMap<java.lang.String, com.ironsource.mediationsdk.h$a> r0 = r4.j     // Catch:{ all -> 0x0085 }
            boolean r0 = r0.isEmpty()     // Catch:{ all -> 0x0085 }
            if (r0 != 0) goto L_0x0079
            com.ironsource.mediationsdk.h r0 = r4.u     // Catch:{ all -> 0x0085 }
            java.util.concurrent.ConcurrentHashMap<java.lang.String, com.ironsource.mediationsdk.h$a> r1 = r4.j     // Catch:{ all -> 0x0085 }
            r0.a((java.util.concurrent.ConcurrentHashMap<java.lang.String, com.ironsource.mediationsdk.h.a>) r1)     // Catch:{ all -> 0x0085 }
            java.util.concurrent.ConcurrentHashMap<java.lang.String, com.ironsource.mediationsdk.h$a> r0 = r4.j     // Catch:{ all -> 0x0085 }
            r0.clear()     // Catch:{ all -> 0x0085 }
        L_0x0079:
            r4.k()     // Catch:{ all -> 0x0085 }
            goto L_0x0083
        L_0x007d:
            r4.l()     // Catch:{ all -> 0x0085 }
            r4.j()     // Catch:{ all -> 0x0085 }
        L_0x0083:
            monitor-exit(r4)
            return
        L_0x0085:
            r0 = move-exception
            monitor-exit(r4)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ironsource.mediationsdk.y.i():void");
    }
}
