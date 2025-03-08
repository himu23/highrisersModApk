package com.ironsource.mediationsdk;

import android.graphics.Rect;
import android.os.AsyncTask;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.FrameLayout;
import com.ironsource.a2;
import com.ironsource.b2;
import com.ironsource.d1;
import com.ironsource.environment.ContextProvider;
import com.ironsource.environment.thread.IronSourceThreadManager;
import com.ironsource.f1;
import com.ironsource.h5;
import com.ironsource.hc;
import com.ironsource.i5;
import com.ironsource.ka;
import com.ironsource.m1;
import com.ironsource.mediationsdk.IronSource;
import com.ironsource.mediationsdk.adunit.adapter.utility.AdData;
import com.ironsource.mediationsdk.h;
import com.ironsource.mediationsdk.impressionData.ImpressionDataListener;
import com.ironsource.mediationsdk.l;
import com.ironsource.mediationsdk.logger.IronLog;
import com.ironsource.mediationsdk.logger.IronSourceError;
import com.ironsource.mediationsdk.model.NetworkSettings;
import com.ironsource.mediationsdk.utils.IronSourceConstants;
import com.ironsource.mediationsdk.utils.IronSourceUtils;
import com.ironsource.n7;
import com.ironsource.o8;
import com.ironsource.r3;
import com.ironsource.t0;
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
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.TimeUnit;
import org.json.JSONObject;

public class w extends m implements ka, t0 {
    private final Object A;
    private r3 B;
    private boolean C;
    /* access modifiers changed from: private */
    public final boolean D;
    private final long E;
    private final Runnable F;
    private final w6 e;
    private final w6.a f;
    /* access modifiers changed from: private */
    public k g;
    private h h;
    /* access modifiers changed from: private */
    public o8 i;
    /* access modifiers changed from: private */
    public IronSourceBannerLayout j;
    /* access modifiers changed from: private */
    public m1 k;
    private int l;
    /* access modifiers changed from: private */
    public x m;
    /* access modifiers changed from: private */
    public int n;
    /* access modifiers changed from: private */
    public final ConcurrentHashMap<String, x> o;
    private CopyOnWriteArrayList<x> p;
    private String q;
    private JSONObject r;
    private String s;
    private int t;
    private e u;
    private d1 v;
    private h w;
    private ConcurrentHashMap<String, d1> x;
    private ConcurrentHashMap<String, h.a> y;
    private long z;

    class a implements l.c {
        final /* synthetic */ m1 a;
        final /* synthetic */ IronSourceBannerLayout b;

        a(m1 m1Var, IronSourceBannerLayout ironSourceBannerLayout) {
            this.a = m1Var;
            this.b = ironSourceBannerLayout;
        }

        public void a() {
            IronLog ironLog = IronLog.INTERNAL;
            ironLog.verbose("placement = " + this.a.getPlacementName());
            IronSourceBannerLayout unused = w.this.j = this.b;
            m1 unused2 = w.this.k = this.a;
            if (com.ironsource.mediationsdk.utils.b.d(ContextProvider.getInstance().getApplicationContext(), this.a.getPlacementName())) {
                ironLog.verbose("placement is capped");
                n a2 = n.a();
                IronSource.AD_UNIT ad_unit = IronSource.AD_UNIT.BANNER;
                a2.a(ad_unit, new IronSourceError(IronSourceError.ERROR_BN_LOAD_PLACEMENT_CAPPED, "placement " + this.a.getPlacementName() + " is capped"));
                w.this.a((int) IronSourceConstants.BN_CALLBACK_LOAD_ERROR, new Object[][]{new Object[]{"errorCode", Integer.valueOf(IronSourceError.ERROR_BN_LOAD_PLACEMENT_CAPPED)}});
                w.this.a(h.READY_TO_LOAD);
                return;
            }
            w.this.b(false);
        }

        public void a(String str) {
            IronLog ironLog = IronLog.API;
            ironLog.error("can't load banner - errorMessage = " + str);
        }
    }

    class b implements l.c {
        final /* synthetic */ IronSourceBannerLayout a;

        b(IronSourceBannerLayout ironSourceBannerLayout) {
            this.a = ironSourceBannerLayout;
        }

        public void a() {
            IronLog.INTERNAL.verbose("destroying banner");
            w.this.i.b();
            w.this.a((int) IronSourceConstants.BN_DESTROY, (Object[][]) null, w.this.m != null ? w.this.m.n() : w.this.n);
            w.this.h();
            this.a.a();
            IronSourceBannerLayout unused = w.this.j = null;
            m1 unused2 = w.this.k = null;
            w.this.a(h.READY_TO_LOAD);
        }

        public void a(String str) {
            IronLog ironLog = IronLog.API;
            ironLog.error("destroy banner failed - errorMessage = " + str);
        }
    }

    class c implements Runnable {
        c() {
        }

        public void run() {
            try {
                if (w.this.j == null) {
                    IronLog.INTERNAL.verbose("mIronSourceBanner is null");
                    w.this.a((int) IronSourceConstants.BN_SKIP_RELOAD, new Object[][]{new Object[]{"errorCode", Integer.valueOf(IronSourceError.ERROR_BN_RELOAD_SKIP_BANNER_LAYOUT_IS_NULL)}});
                } else if (w.this.o()) {
                    w.this.v();
                } else {
                    IronLog.INTERNAL.verbose("banner is not visible, reload skipped");
                    w.this.a((int) IronSourceConstants.BN_SKIP_RELOAD, new Object[][]{new Object[]{"errorCode", Integer.valueOf(IronSourceError.ERROR_BN_RELOAD_SKIP_INVISIBLE)}});
                    w.this.i.a(TimeUnit.SECONDS.toMillis((long) w.this.g.f()));
                }
            } catch (Throwable th) {
                w.this.a((int) IronSourceConstants.TROUBLESHOOTING_BN_RELOAD_EXCEPTION, new Object[][]{new Object[]{"reason", th.getMessage()}});
            }
        }
    }

    class d implements Runnable {
        d() {
        }

        public void run() {
            w.this.w();
            if (!w.this.y()) {
                w.this.a((int) IronSourceConstants.BN_AUCTION_REQUEST);
                HashMap hashMap = new HashMap();
                ArrayList arrayList = new ArrayList();
                StringBuilder sb = new StringBuilder();
                ArrayList arrayList2 = new ArrayList();
                w.this.b(hashMap, arrayList, sb, arrayList2);
                if (w.this.D) {
                    w.this.a((Map<String, Object>) hashMap, (List<String>) arrayList, sb, (List<x1>) arrayList2);
                } else {
                    w.this.a((Map<String, Object>) hashMap, (List<String>) arrayList, sb);
                }
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
            w.this.a((int) IronSourceConstants.BN_COLLECT_TOKENS_COMPLETED, new Object[][]{new Object[]{IronSourceConstants.EVENTS_DURATION, Long.valueOf(j)}});
            for (b2 next : list) {
                if (next.a() != null) {
                    this.a.put(next.c(), next.a());
                    StringBuilder sb = this.b;
                    sb.append(next.d());
                    sb.append(next.c());
                    sb.append(",");
                    ((x) w.this.o.get(next.c())).a((int) IronSourceConstants.BN_INSTANCE_COLLECT_TOKEN_SUCCESS, new Object[][]{new Object[]{IronSourceConstants.EVENTS_DURATION, Long.valueOf(next.e())}});
                } else {
                    ((x) w.this.o.get(next.c())).a((int) IronSourceConstants.BN_INSTANCE_COLLECT_TOKEN_FAILED, new Object[][]{new Object[]{IronSourceConstants.EVENTS_DURATION, Long.valueOf(next.e())}, new Object[]{"reason", next.b()}});
                }
            }
            for (String str : list2) {
                ConcurrentHashMap g = w.this.o;
                ((x) g.get(str)).a((int) IronSourceConstants.BN_INSTANCE_COLLECT_TOKEN_TIMED_OUT, new Object[][]{new Object[]{IronSourceConstants.EVENTS_DURATION, Long.valueOf(j)}});
            }
            w.this.a((Map<String, Object>) this.a, (List<String>) this.c, this.b);
        }

        public void onFailure(String str) {
            w.this.a((int) IronSourceConstants.BN_COLLECT_TOKENS_FAILED, new Object[][]{new Object[]{IronSourceConstants.EVENTS_DURATION, str}});
            w.this.a((Map<String, Object>) this.a, (List<String>) this.c, this.b);
        }
    }

    class f implements Runnable {
        final /* synthetic */ NetworkSettings a;

        f(NetworkSettings networkSettings) {
            this.a = networkSettings;
        }

        public void run() {
            w.this.a(this.a);
        }
    }

    class g extends TimerTask {
        g() {
        }

        public void run() {
            w.this.u();
        }
    }

    enum h {
        NONE,
        READY_TO_LOAD,
        STARTED_LOADING,
        FIRST_AUCTION,
        AUCTION,
        LOADING,
        RELOADING,
        LOADED
    }

    w(i5 i5Var, h5 h5Var, List<NetworkSettings> list, k kVar, HashSet<ImpressionDataListener> hashSet, IronSourceSegment ironSourceSegment) {
        super(hashSet, ironSourceSegment);
        this.h = h.NONE;
        this.s = "";
        this.A = new Object();
        this.C = false;
        c cVar = new c();
        this.F = cVar;
        w6 b2 = i5Var.b();
        this.e = b2;
        this.f = h5Var.a();
        long time = new Date().getTime();
        a((int) IronSourceConstants.BN_MANAGER_INIT_STARTED, new Object[][]{new Object[]{IronSourceConstants.EVENTS_EXT1, IronSourceConstants.PROG_BN_MANAGER_NAME}});
        IronLog ironLog = IronLog.INTERNAL;
        ironLog.verbose("isAuctionEnabled = " + kVar.k());
        this.g = kVar;
        this.o = new ConcurrentHashMap<>();
        this.p = new CopyOnWriteArrayList<>();
        this.x = new ConcurrentHashMap<>();
        this.y = new ConcurrentHashMap<>();
        IronSource.AD_UNIT ad_unit = IronSource.AD_UNIT.BANNER;
        this.n = b2.a(ad_unit);
        n.a().a(ad_unit, this.g.d());
        if (this.g.k()) {
            this.u = new e(ad_unit, this.g.b(), this);
        }
        this.w = new h(list, this.g.b().c());
        a(list, kVar);
        this.z = new Date().getTime();
        a(h.READY_TO_LOAD);
        this.D = kVar.g();
        this.E = kVar.h();
        this.i = new o8(cVar, com.ironsource.lifecycle.b.d(), new hc());
        a((int) IronSourceConstants.BN_MANAGER_INIT_ENDED, new Object[][]{new Object[]{IronSourceConstants.EVENTS_DURATION, Long.valueOf(new Date().getTime() - time)}});
    }

    public w(List<NetworkSettings> list, k kVar, HashSet<ImpressionDataListener> hashSet, IronSourceSegment ironSourceSegment) {
        this(w8.e(), w8.d(), list, kVar, hashSet, ironSourceSegment);
    }

    private String a(List<d1> list) {
        IronLog ironLog = IronLog.INTERNAL;
        ironLog.verbose("waterfall.size() = " + list.size());
        this.p.clear();
        this.x.clear();
        this.y.clear();
        StringBuilder sb = new StringBuilder();
        for (int i2 = 0; i2 < list.size(); i2++) {
            d1 d1Var = list.get(i2);
            a(d1Var);
            sb.append(b(d1Var));
            if (i2 != list.size() - 1) {
                sb.append(",");
            }
        }
        IronLog.INTERNAL.verbose("updateWaterfall() - next waterfall is " + sb.toString());
        return sb.toString();
    }

    /* access modifiers changed from: private */
    public void a(int i2) {
        a(i2, (Object[][]) null);
    }

    /* access modifiers changed from: private */
    public void a(int i2, Object[][] objArr) {
        a(i2, objArr, this.n);
    }

    /* access modifiers changed from: private */
    public void a(int i2, Object[][] objArr, int i3) {
        JSONObject mediationAdditionalData = IronSourceUtils.getMediationAdditionalData(false, true, 1);
        try {
            ISBannerSize k2 = k();
            if (k2 != null) {
                a(mediationAdditionalData, k2);
            }
            if (this.k != null) {
                mediationAdditionalData.put("placement", l());
            }
            mediationAdditionalData.put("sessionDepth", i3);
            if (!TextUtils.isEmpty(this.q)) {
                mediationAdditionalData.put("auctionId", this.q);
            }
            JSONObject jSONObject = this.r;
            if (jSONObject != null && jSONObject.length() > 0) {
                mediationAdditionalData.put("genericParams", this.r);
            }
            if (b(i2)) {
                mediationAdditionalData.put(IronSourceConstants.AUCTION_TRIALS, this.t);
                if (!TextUtils.isEmpty(this.s)) {
                    mediationAdditionalData.put(IronSourceConstants.AUCTION_FALLBACK, this.s);
                }
            }
            if (objArr != null) {
                for (Object[] objArr2 : objArr) {
                    mediationAdditionalData.put(objArr2[0].toString(), objArr2[1]);
                }
            }
        } catch (Exception e2) {
            IronLog.INTERNAL.error(Log.getStackTraceString(e2));
        }
        n7.i().a(new y3(i2, mediationAdditionalData));
    }

    private void a(View view, FrameLayout.LayoutParams layoutParams) {
        IronSourceBannerLayout ironSourceBannerLayout = this.j;
        if (ironSourceBannerLayout != null) {
            l.a(ironSourceBannerLayout, view, layoutParams);
        }
    }

    private void a(d1 d1Var) {
        x xVar = this.o.get(d1Var.c());
        if (xVar != null) {
            AbstractAdapter a2 = c.b().a(xVar.b.h());
            if (a2 != null) {
                x xVar2 = new x(this.g, this, xVar.b.h(), a2, this.n, this.q, this.r, this.t, this.s, p());
                xVar2.a(true);
                this.p.add(xVar2);
                this.x.put(xVar2.c(), d1Var);
                this.y.put(d1Var.c(), h.a.ISAuctionPerformanceDidntAttemptToLoad);
                return;
            }
            return;
        }
        IronLog ironLog = IronLog.INTERNAL;
        ironLog.error("could not find matching smash for auction response item - item = " + d1Var.c());
    }

    /* access modifiers changed from: private */
    public void a(NetworkSettings networkSettings) {
        IronLog ironLog = IronLog.INTERNAL;
        ironLog.verbose(String.format("Start initializing provider %s on thread %s", new Object[]{networkSettings.getProviderInstanceName(), Thread.currentThread().getName()}));
        AbstractAdapter a2 = c.b().a(networkSettings, networkSettings.getBannerSettings(), false);
        if (a2 != null) {
            x xVar = new x(this.g, this, networkSettings, a2, this.n, p());
            this.o.put(xVar.c(), xVar);
        } else {
            ironLog.verbose(networkSettings.getProviderInstanceName() + " can't load adapter");
        }
        ironLog.verbose(String.format("Done initializing provider %s on thread %s", new Object[]{networkSettings.getProviderInstanceName(), Thread.currentThread().getName()}));
    }

    /* access modifiers changed from: private */
    public void a(h hVar) {
        IronLog ironLog = IronLog.INTERNAL;
        ironLog.verbose("from '" + this.h + "' to '" + hVar + "'");
        synchronized (this.A) {
            this.h = hVar;
        }
    }

    private void a(x xVar, d1 d1Var) {
        this.u.a(d1Var, xVar.g(), this.v, l());
        a(this.x.get(xVar.c()), l());
    }

    private void a(List<NetworkSettings> list, k kVar) {
        ArrayList arrayList = new ArrayList();
        for (NetworkSettings fVar : list) {
            arrayList.add(new f(fVar));
        }
        IronSourceThreadManager.INSTANCE.executeTasks(kVar.c().l(), kVar.c().o(), arrayList);
    }

    /* access modifiers changed from: private */
    public void a(Map<String, Object> map, List<String> list, StringBuilder sb) {
        IronLog ironLog = IronLog.INTERNAL;
        ironLog.verbose("auction waterfallString = " + sb);
        if (map.size() == 0 && list.size() == 0) {
            a((int) IronSourceConstants.BN_AUCTION_FAILED, new Object[][]{new Object[]{"errorCode", 1005}, new Object[]{IronSourceConstants.EVENTS_DURATION, 0}});
            if (a(h.AUCTION, h.LOADED)) {
                this.i.a(TimeUnit.SECONDS.toMillis((long) this.g.f()));
                return;
            }
            n.a().a(IronSource.AD_UNIT.BANNER, new IronSourceError(1005, "No candidates available for auctioning"));
            a((int) IronSourceConstants.BN_CALLBACK_LOAD_ERROR, new Object[][]{new Object[]{"errorCode", 1005}});
            a(h.READY_TO_LOAD);
            return;
        }
        a((int) IronSourceConstants.BN_AUCTION_REQUEST_WATERFALL, new Object[][]{new Object[]{IronSourceConstants.EVENTS_EXT1, sb.toString()}});
        e eVar = this.u;
        if (eVar != null) {
            eVar.a(ContextProvider.getInstance().getApplicationContext(), map, list, this.w, this.n, this.c, j());
            return;
        }
        ironLog.error("mAuctionHandler is null");
    }

    /* access modifiers changed from: private */
    public void a(Map<String, Object> map, List<String> list, StringBuilder sb, List<x1> list2) {
        if (list2.isEmpty()) {
            a(map, list, sb);
            return;
        }
        a2 a2Var = new a2();
        e eVar = new e(map, sb, list);
        a((int) IronSourceConstants.BN_COLLECT_TOKENS);
        a2Var.a(list2, (a2.b) eVar, this.E, TimeUnit.MILLISECONDS);
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static void a(org.json.JSONObject r7, com.ironsource.mediationsdk.ISBannerSize r8) {
        /*
            java.lang.String r0 = "ext1"
            java.lang.String r1 = r8.getDescription()     // Catch:{ Exception -> 0x00af }
            int r2 = r1.hashCode()     // Catch:{ Exception -> 0x00af }
            r3 = 4
            r4 = 3
            r5 = 2
            r6 = 1
            switch(r2) {
                case -387072689: goto L_0x003a;
                case 72205083: goto L_0x0030;
                case 79011241: goto L_0x0026;
                case 1951953708: goto L_0x001c;
                case 1999208305: goto L_0x0012;
                default: goto L_0x0011;
            }     // Catch:{ Exception -> 0x00af }
        L_0x0011:
            goto L_0x0044
        L_0x0012:
            java.lang.String r2 = "CUSTOM"
            boolean r1 = r1.equals(r2)     // Catch:{ Exception -> 0x00af }
            if (r1 == 0) goto L_0x0044
            r1 = 4
            goto L_0x0045
        L_0x001c:
            java.lang.String r2 = "BANNER"
            boolean r1 = r1.equals(r2)     // Catch:{ Exception -> 0x00af }
            if (r1 == 0) goto L_0x0044
            r1 = 0
            goto L_0x0045
        L_0x0026:
            java.lang.String r2 = "SMART"
            boolean r1 = r1.equals(r2)     // Catch:{ Exception -> 0x00af }
            if (r1 == 0) goto L_0x0044
            r1 = 3
            goto L_0x0045
        L_0x0030:
            java.lang.String r2 = "LARGE"
            boolean r1 = r1.equals(r2)     // Catch:{ Exception -> 0x00af }
            if (r1 == 0) goto L_0x0044
            r1 = 1
            goto L_0x0045
        L_0x003a:
            java.lang.String r2 = "RECTANGLE"
            boolean r1 = r1.equals(r2)     // Catch:{ Exception -> 0x00af }
            if (r1 == 0) goto L_0x0044
            r1 = 2
            goto L_0x0045
        L_0x0044:
            r1 = -1
        L_0x0045:
            java.lang.String r2 = "bannerAdSize"
            if (r1 == 0) goto L_0x0085
            if (r1 == r6) goto L_0x0081
            if (r1 == r5) goto L_0x007d
            if (r1 == r4) goto L_0x0078
            if (r1 == r3) goto L_0x0052
            goto L_0x0088
        L_0x0052:
            r1 = 6
            r7.put(r2, r1)     // Catch:{ Exception -> 0x00af }
            java.lang.String r1 = "custom_banner_size"
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x00af }
            r2.<init>()     // Catch:{ Exception -> 0x00af }
            int r3 = r8.getWidth()     // Catch:{ Exception -> 0x00af }
            r2.append(r3)     // Catch:{ Exception -> 0x00af }
            java.lang.String r3 = "x"
            r2.append(r3)     // Catch:{ Exception -> 0x00af }
            int r3 = r8.getHeight()     // Catch:{ Exception -> 0x00af }
            r2.append(r3)     // Catch:{ Exception -> 0x00af }
            java.lang.String r2 = r2.toString()     // Catch:{ Exception -> 0x00af }
            r7.put(r1, r2)     // Catch:{ Exception -> 0x00af }
            goto L_0x0088
        L_0x0078:
            r1 = 5
            r7.put(r2, r1)     // Catch:{ Exception -> 0x00af }
            goto L_0x0088
        L_0x007d:
            r7.put(r2, r4)     // Catch:{ Exception -> 0x00af }
            goto L_0x0088
        L_0x0081:
            r7.put(r2, r5)     // Catch:{ Exception -> 0x00af }
            goto L_0x0088
        L_0x0085:
            r7.put(r2, r6)     // Catch:{ Exception -> 0x00af }
        L_0x0088:
            boolean r8 = r8.isAdaptive()     // Catch:{ Exception -> 0x00af }
            if (r8 == 0) goto L_0x00b9
            java.lang.String r8 = "Adaptive=true"
            boolean r1 = r7.has(r0)     // Catch:{ Exception -> 0x00af }
            if (r1 == 0) goto L_0x00ab
            java.lang.StringBuilder r8 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x00af }
            r8.<init>()     // Catch:{ Exception -> 0x00af }
            java.lang.String r1 = r7.optString(r0)     // Catch:{ Exception -> 0x00af }
            r8.append(r1)     // Catch:{ Exception -> 0x00af }
            java.lang.String r1 = " , Adaptive=true"
            r8.append(r1)     // Catch:{ Exception -> 0x00af }
            java.lang.String r8 = r8.toString()     // Catch:{ Exception -> 0x00af }
        L_0x00ab:
            r7.put(r0, r8)     // Catch:{ Exception -> 0x00af }
            goto L_0x00b9
        L_0x00af:
            r7 = move-exception
            com.ironsource.mediationsdk.logger.IronLog r8 = com.ironsource.mediationsdk.logger.IronLog.INTERNAL
            java.lang.String r7 = android.util.Log.getStackTraceString(r7)
            r8.error(r7)
        L_0x00b9:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ironsource.mediationsdk.w.a(org.json.JSONObject, com.ironsource.mediationsdk.ISBannerSize):void");
    }

    private boolean a(h hVar, h hVar2) {
        boolean z2;
        synchronized (this.A) {
            if (this.h == hVar) {
                IronLog ironLog = IronLog.INTERNAL;
                ironLog.verbose("set state from '" + this.h + "' to '" + hVar2 + "'");
                this.h = hVar2;
                z2 = true;
            } else {
                z2 = false;
            }
        }
        return z2;
    }

    private String b(d1 d1Var) {
        x xVar = this.o.get(d1Var.c());
        String str = (xVar == null ? !TextUtils.isEmpty(d1Var.j()) : xVar.p()) ? "2" : "1";
        return str + d1Var.c();
    }

    /* access modifiers changed from: private */
    public void b(Map<String, Object> map, List<String> list, StringBuilder sb, List<x1> list2) {
        if (!com.ironsource.mediationsdk.utils.b.d(ContextProvider.getInstance().getApplicationContext(), l())) {
            for (x next : this.o.values()) {
                AdData createAdDataForNetworkAdapter = AdData.createAdDataForNetworkAdapter(next.d, IronSource.AD_UNIT.BANNER, (String) null, this.j);
                if (next.p()) {
                    if (this.D) {
                        list2.add(new x1(next.g(), next.c(), createAdDataForNetworkAdapter, next, (y1) null, (NetworkSettings) null));
                    } else {
                        try {
                            Map<String, Object> a2 = next.a(createAdDataForNetworkAdapter);
                            if (a2 != null) {
                                map.put(next.c(), a2);
                                sb.append(next.g() + next.c() + ",");
                            } else {
                                next.a((int) IronSourceConstants.TROUBLESHOOTING_BN_BIDDING_DATA_MISSING, new Object[][]{new Object[]{"reason", "Missing bidding data"}});
                            }
                        } catch (Exception e2) {
                            String str = "prepareAuctionCandidates - exception while calling smash.getBiddingData - " + e2.getMessage();
                            IronLog.INTERNAL.error(str);
                            next.a((int) IronSourceConstants.TROUBLESHOOTING_BN_INTERNAL_ERROR, new Object[][]{new Object[]{"reason", str}});
                        } catch (NoClassDefFoundError e3) {
                            String str2 = "prepareAuctionCandidates - error while calling smash.getBiddingData - " + e3.getMessage();
                            IronLog.INTERNAL.error(str2);
                            next.a((int) IronSourceConstants.TROUBLESHOOTING_BN_INTERNAL_ERROR, new Object[][]{new Object[]{"reason", str2}});
                        }
                    }
                } else if (!next.p()) {
                    list.add(next.c());
                    sb.append(next.g() + next.c() + ",");
                }
            }
        }
    }

    /* access modifiers changed from: private */
    public void b(boolean z2) {
        IronLog ironLog = IronLog.INTERNAL;
        ironLog.verbose("current state = " + this.h);
        if (a(h.STARTED_LOADING, this.g.k() ? z2 ? h.AUCTION : h.FIRST_AUCTION : z2 ? h.RELOADING : h.LOADING)) {
            this.B = new r3();
            this.q = "";
            this.r = null;
            this.l = 0;
            this.n = this.e.a(IronSource.AD_UNIT.BANNER);
            a(z2 ? IronSourceConstants.BN_RELOAD : 3001);
            if (this.g.k()) {
                u();
                return;
            }
            x();
            t();
            return;
        }
        ironLog.error("wrong state - " + this.h);
    }

    private boolean b(int i2) {
        return i2 == 3201 || i2 == 3110 || i2 == 3111 || i2 == 3116 || i2 == 3119 || i2 == 3112 || i2 == 3115 || i2 == 3501 || i2 == 3502 || i2 == 3506;
    }

    private void f(x xVar) {
        String str;
        IronSourceBannerLayout ironSourceBannerLayout = this.j;
        if (ironSourceBannerLayout != null && !ironSourceBannerLayout.isDestroyed()) {
            IronSourceBannerLayout ironSourceBannerLayout2 = null;
            if (xVar.p()) {
                str = this.x.get(xVar.c()).j();
                xVar.c(str);
            } else {
                str = null;
            }
            JSONObject a2 = this.x.get(xVar.c()).a();
            try {
                ironSourceBannerLayout2 = this.j.b();
            } catch (Exception e2) {
                IronLog.INTERNAL.verbose("Failed to make copy of banner layout: " + e2.getMessage());
            }
            xVar.a(ironSourceBannerLayout2, this.k, str, a2);
        }
    }

    private boolean g() {
        IronSourceBannerLayout ironSourceBannerLayout = this.j;
        return ironSourceBannerLayout != null && !ironSourceBannerLayout.isDestroyed();
    }

    /* access modifiers changed from: private */
    public void h() {
        if (this.m != null) {
            IronLog ironLog = IronLog.INTERNAL;
            ironLog.verbose("mActiveSmash = " + this.m.f());
            this.m.t();
            this.m = null;
        }
    }

    private List<d1> i() {
        CopyOnWriteArrayList copyOnWriteArrayList = new CopyOnWriteArrayList();
        for (x next : this.o.values()) {
            if (!next.p() && !com.ironsource.mediationsdk.utils.b.d(ContextProvider.getInstance().getApplicationContext(), l())) {
                copyOnWriteArrayList.add(new d1(next.c()));
            }
        }
        return copyOnWriteArrayList;
    }

    private ISBannerSize j() {
        IronSourceBannerLayout ironSourceBannerLayout = this.j;
        if (ironSourceBannerLayout == null || ironSourceBannerLayout.getSize() == null) {
            return null;
        }
        return this.j.getSize().isSmart() ? AdapterUtils.isLargeScreen(ContextProvider.getInstance().getApplicationContext()) ? ISBannerSize.e : ISBannerSize.BANNER : this.j.getSize();
    }

    private ISBannerSize k() {
        IronSourceBannerLayout ironSourceBannerLayout = this.j;
        if (ironSourceBannerLayout != null) {
            return ironSourceBannerLayout.getSize();
        }
        return null;
    }

    private String l() {
        m1 m1Var = this.k;
        return m1Var != null ? m1Var.getPlacementName() : "";
    }

    private void m() {
        String str = this.p.isEmpty() ? "Empty waterfall" : "Mediation No fill";
        IronLog ironLog = IronLog.INTERNAL;
        ironLog.verbose("errorReason = ".concat(str));
        g((x) null);
        h hVar = h.LOADING;
        h hVar2 = h.READY_TO_LOAD;
        if (a(hVar, hVar2)) {
            a((int) IronSourceConstants.BN_CALLBACK_LOAD_ERROR, new Object[][]{new Object[]{"errorCode", 606}, new Object[]{"reason", str}, new Object[]{IronSourceConstants.EVENTS_DURATION, Long.valueOf(r3.a(this.B))}});
            n.a().a(IronSource.AD_UNIT.BANNER, new IronSourceError(606, str));
        } else if (a(h.RELOADING, h.LOADED)) {
            a((int) IronSourceConstants.BN_CALLBACK_RELOAD_ERROR, new Object[][]{new Object[]{IronSourceConstants.EVENTS_DURATION, Long.valueOf(r3.a(this.B))}});
            n.a().b(IronSource.AD_UNIT.BANNER, new IronSourceError(606, str), true);
            this.i.a(TimeUnit.SECONDS.toMillis((long) this.g.f()));
        } else {
            a(hVar2);
            ironLog.error("wrong state = " + this.h);
        }
    }

    private void n() {
        String l2 = l();
        com.ironsource.mediationsdk.utils.b.a(ContextProvider.getInstance().getApplicationContext(), l2);
        if (com.ironsource.mediationsdk.utils.b.d(ContextProvider.getInstance().getApplicationContext(), l2)) {
            a((int) IronSourceConstants.BN_PLACEMENT_CAPPED);
        }
    }

    private boolean p() {
        h hVar = this.h;
        return hVar == h.RELOADING || hVar == h.AUCTION;
    }

    private boolean q() {
        boolean z2;
        synchronized (this.A) {
            z2 = this.h == h.LOADED;
        }
        return z2;
    }

    private boolean r() {
        boolean z2;
        synchronized (this.A) {
            h hVar = this.h;
            if (hVar != h.FIRST_AUCTION) {
                if (hVar != h.AUCTION) {
                    z2 = false;
                }
            }
            z2 = true;
        }
        return z2;
    }

    private boolean s() {
        boolean z2;
        synchronized (this.A) {
            h hVar = this.h;
            if (hVar != h.LOADING) {
                if (hVar != h.RELOADING) {
                    z2 = false;
                }
            }
            z2 = true;
        }
        return z2;
    }

    private void t() {
        try {
            for (int i2 = this.l; i2 < this.p.size(); i2++) {
                x xVar = this.p.get(i2);
                if (xVar.h()) {
                    IronLog ironLog = IronLog.INTERNAL;
                    ironLog.verbose("loading smash - " + xVar.f());
                    this.l = i2 + 1;
                    f(xVar);
                    return;
                }
            }
            m();
        } catch (Exception e2) {
            a((int) IronSourceConstants.TROUBLESHOOTING_BN_INTERNAL_ERROR, new Object[][]{new Object[]{IronSourceConstants.EVENTS_EXT1, "loadNextSmash"}, new Object[]{"reason", Log.getStackTraceString(e2)}});
        }
    }

    /* access modifiers changed from: private */
    public void u() {
        IronLog.INTERNAL.verbose();
        AsyncTask.execute(new d());
    }

    /* access modifiers changed from: private */
    public void v() {
        IronLog ironLog = IronLog.INTERNAL;
        ironLog.verbose("");
        if (a(h.LOADED, h.STARTED_LOADING)) {
            b(true);
            return;
        }
        ironLog.error("wrong state = " + this.h);
    }

    /* access modifiers changed from: private */
    public void w() {
        if (!this.y.isEmpty()) {
            this.w.a(this.y);
            this.y.clear();
        }
    }

    private void x() {
        List<d1> i2 = i();
        this.q = e();
        a(i2);
    }

    /* access modifiers changed from: private */
    public boolean y() {
        long a2 = l.a(this.z, this.g.i());
        if (a2 <= 0) {
            return false;
        }
        IronLog ironLog = IronLog.INTERNAL;
        ironLog.verbose("waiting before auction - timeToWaitBeforeAuction = " + a2);
        new Timer().schedule(new g(), a2);
        return true;
    }

    public void a(int i2, String str, int i3, String str2, long j2) {
        String str3 = "Auction failed | moving to fallback waterfall (error " + i2 + " - " + str + ")";
        IronLog ironLog = IronLog.INTERNAL;
        ironLog.verbose(str3);
        IronSourceUtils.sendAutomationLog("BN: " + str3);
        if (r()) {
            this.s = str2;
            this.t = i3;
            this.r = null;
            x();
            a((int) IronSourceConstants.BN_AUCTION_FAILED, new Object[][]{new Object[]{IronSourceConstants.EVENTS_DURATION, Long.valueOf(j2)}, new Object[]{"errorCode", Integer.valueOf(i2)}, new Object[]{"reason", str}});
            a(this.h == h.FIRST_AUCTION ? h.LOADING : h.RELOADING);
            t();
            return;
        }
        ironLog.warning("wrong state - mCurrentState = " + this.h);
    }

    public void a(IronSourceBannerLayout ironSourceBannerLayout) {
        IronLog.INTERNAL.verbose();
        l.a(ironSourceBannerLayout, (l.c) new b(ironSourceBannerLayout));
    }

    public void a(IronSourceBannerLayout ironSourceBannerLayout, m1 m1Var) {
        IronLog ironLog = IronLog.INTERNAL;
        ironLog.verbose();
        IronSource.AD_UNIT ad_unit = IronSource.AD_UNIT.BANNER;
        a(ad_unit);
        f();
        if (!a(h.READY_TO_LOAD, h.STARTED_LOADING)) {
            IronLog.API.error("can't load banner - loadBanner already called and still in progress");
        } else if (!n.a().b(ad_unit)) {
            l.a(ironSourceBannerLayout, m1Var, (l.c) new a(m1Var, ironSourceBannerLayout));
        } else {
            ironLog.verbose("can't load banner - already has pending invocation");
        }
    }

    public void a(IronSourceError ironSourceError, x xVar, boolean z2) {
        IronLog ironLog = IronLog.INTERNAL;
        ironLog.verbose("error = " + ironSourceError);
        if (xVar.x() != this.q) {
            ironLog.error("invoked with auctionId: " + xVar.x() + " and the current id is " + this.q);
            xVar.a((int) IronSourceConstants.TROUBLESHOOTING_BN_MANAGER_UNEXPECTED_STATE, new Object[][]{new Object[]{"errorCode", 3}, new Object[]{"reason", "Wrong auction " + xVar.x() + " State - " + this.h}, new Object[]{IronSourceConstants.EVENTS_EXT1, xVar.c()}});
        } else if (s()) {
            this.y.put(xVar.c(), h.a.ISAuctionPerformanceFailedToLoad);
            t();
        } else {
            ironLog.warning("wrong state - mCurrentState = " + this.h);
        }
    }

    public void a(x xVar) {
        d1 d1Var;
        IronLog ironLog = IronLog.INTERNAL;
        ironLog.verbose(xVar.f());
        if (q()) {
            if (this.g.k() && this.g.b().p() && (d1Var = this.x.get(xVar.c())) != null) {
                a(xVar, d1Var);
            }
            a((int) IronSourceConstants.BN_CALLBACK_SHOW);
            return;
        }
        ironLog.warning("wrong state - mCurrentState = " + this.h);
        String c2 = xVar.c();
        a((int) IronSourceConstants.TROUBLESHOOTING_BN_MANAGER_UNEXPECTED_STATE, new Object[][]{new Object[]{"errorCode", 1}, new Object[]{"reason", "Wrong State - " + this.h}, new Object[]{IronSourceConstants.EVENTS_EXT1, c2}});
    }

    public void a(x xVar, View view, FrameLayout.LayoutParams layoutParams) {
        Object[][] objArr;
        x xVar2 = xVar;
        IronLog ironLog = IronLog.INTERNAL;
        ironLog.verbose("smash = " + xVar.f());
        if (xVar.x() != this.q) {
            ironLog.error("invoked with auctionId: " + xVar.x() + " and the current id is " + this.q);
            xVar2.a((int) IronSourceConstants.TROUBLESHOOTING_BN_MANAGER_UNEXPECTED_STATE, new Object[][]{new Object[]{"errorCode", 2}, new Object[]{"reason", "Wrong auction id " + xVar.x() + " State - " + this.h}, new Object[]{IronSourceConstants.EVENTS_EXT1, xVar.c()}});
        } else if (s()) {
            x xVar3 = this.m;
            if (xVar3 != null) {
                xVar3.q();
            }
            g(xVar);
            this.m = xVar2;
            a(view, layoutParams);
            this.y.put(xVar.c(), h.a.ISAuctionPerformanceShowedSuccessfully);
            if (this.g.k()) {
                d1 d1Var = this.x.get(xVar.c());
                if (d1Var != null) {
                    a(d1Var.a(l()));
                    this.u.a(d1Var, xVar.g(), this.v);
                    this.u.a((CopyOnWriteArrayList<a0>) this.p, this.x, xVar.g(), this.v, d1Var);
                    if (!this.g.b().p()) {
                        a(xVar2, d1Var);
                    }
                } else {
                    String c2 = xVar.c();
                    ironLog.error("onLoadSuccess winner instance " + c2 + " missing from waterfall. auctionId = " + this.q);
                    a((int) IronSourceConstants.TROUBLESHOOTING_BN_NOTIFICATIONS_ERROR, new Object[][]{new Object[]{"errorCode", 1010}, new Object[]{"reason", "Loaded missing"}, new Object[]{IronSourceConstants.EVENTS_EXT1, c2}});
                }
            }
            if (this.h == h.LOADING) {
                if (g()) {
                    f1.a().a(this.d, false);
                    objArr = new Object[][]{new Object[]{IronSourceConstants.EVENTS_DURATION, Long.valueOf(r3.a(this.B))}};
                } else {
                    objArr = new Object[][]{new Object[]{"reason", "banner is destroyed"}, new Object[]{IronSourceConstants.EVENTS_DURATION, Long.valueOf(r3.a(this.B))}};
                }
                a((int) IronSourceConstants.BN_CALLBACK_LOAD_SUCCESS, objArr);
            } else {
                if (g()) {
                    f1.a().a(this.d, true);
                }
                IronSourceUtils.sendAutomationLog("bannerReloadSucceeded");
                a((int) IronSourceConstants.BN_CALLBACK_RELOAD_SUCCESS, new Object[][]{new Object[]{IronSourceConstants.EVENTS_DURATION, Long.valueOf(r3.a(this.B))}});
            }
            n();
            this.f.b(IronSource.AD_UNIT.BANNER);
            a(h.LOADED);
            this.i.a(TimeUnit.SECONDS.toMillis((long) this.g.f()));
        } else {
            ironLog.warning("wrong state - mCurrentState = " + this.h);
        }
    }

    public void a(List<d1> list, String str, d1 d1Var, JSONObject jSONObject, JSONObject jSONObject2, int i2, long j2, int i3, String str2) {
        IronLog ironLog = IronLog.INTERNAL;
        ironLog.verbose("auctionId = " + str);
        if (r()) {
            this.s = "";
            this.q = str;
            this.t = i2;
            this.v = d1Var;
            this.r = jSONObject;
            if (!TextUtils.isEmpty(str2)) {
                a(88002, new Object[][]{new Object[]{"errorCode", Integer.valueOf(i3)}, new Object[]{"reason", str2}});
            }
            IronSource.AD_UNIT ad_unit = IronSource.AD_UNIT.BANNER;
            a(jSONObject2, ad_unit);
            if (this.b.a(ad_unit)) {
                a((int) IronSourceConstants.BN_AD_UNIT_CAPPED, new Object[][]{new Object[]{"auctionId", str}});
                h hVar = this.h;
                a(h.READY_TO_LOAD);
                if (hVar == h.FIRST_AUCTION) {
                    n.a().a(ad_unit, new IronSourceError(IronSourceError.ERROR_AD_UNIT_CAPPED, "Ad unit is capped"));
                    return;
                }
                return;
            }
            a((int) IronSourceConstants.BN_AUCTION_SUCCESS, new Object[][]{new Object[]{IronSourceConstants.EVENTS_DURATION, Long.valueOf(j2)}});
            a(this.h == h.FIRST_AUCTION ? h.LOADING : h.RELOADING);
            a((int) IronSourceConstants.BN_AUCTION_RESPONSE_WATERFALL, new Object[][]{new Object[]{IronSourceConstants.EVENTS_EXT1, a(list)}});
            t();
            return;
        }
        ironLog.warning("wrong state - mCurrentState = " + this.h);
    }

    public void b(x xVar) {
        Object[][] objArr;
        IronLog.INTERNAL.verbose(xVar.f());
        if (g()) {
            f1.a().b(this.d);
            objArr = null;
        } else {
            objArr = new Object[][]{new Object[]{"reason", "banner is destroyed"}};
        }
        a((int) IronSourceConstants.BN_CALLBACK_CLICK, objArr, xVar.n());
    }

    public void c(x xVar) {
        Object[][] objArr;
        IronLog.INTERNAL.verbose(xVar.f());
        if (g()) {
            f1.a().c(this.d);
            objArr = null;
        } else {
            objArr = new Object[][]{new Object[]{"reason", "banner is destroyed"}};
        }
        a((int) IronSourceConstants.BN_CALLBACK_LEAVE_APP, objArr, xVar.n());
    }

    public void d(x xVar) {
        Object[][] objArr;
        IronLog.INTERNAL.verbose(xVar.f());
        if (g()) {
            f1.a().e(this.d);
            objArr = null;
        } else {
            objArr = new Object[][]{new Object[]{"reason", "banner is destroyed"}};
        }
        a((int) IronSourceConstants.BN_CALLBACK_PRESENT_SCREEN, objArr, xVar.n());
    }

    public void e(x xVar) {
        Object[][] objArr;
        IronLog.INTERNAL.verbose(xVar.f());
        if (g()) {
            f1.a().d(this.d);
            objArr = null;
        } else {
            objArr = new Object[][]{new Object[]{"reason", "banner is destroyed"}};
        }
        a((int) IronSourceConstants.BN_CALLBACK_DISMISS_SCREEN, objArr, xVar.n());
    }

    public void g(x xVar) {
        Iterator<x> it = this.p.iterator();
        while (it.hasNext()) {
            x next = it.next();
            if (!next.equals(xVar)) {
                next.q();
            }
        }
    }

    public boolean o() {
        IronLog ironLog;
        String str;
        if (!this.j.isShown()) {
            ironLog = IronLog.INTERNAL;
            str = "banner or one of its parents are INVISIBLE or GONE";
        } else if (!this.j.hasWindowFocus()) {
            ironLog = IronLog.INTERNAL;
            str = "banner has no window focus";
        } else {
            boolean globalVisibleRect = this.j.getGlobalVisibleRect(new Rect());
            IronLog ironLog2 = IronLog.INTERNAL;
            ironLog2.verbose("visible = " + globalVisibleRect);
            return globalVisibleRect;
        }
        ironLog.verbose(str);
        return false;
    }
}
