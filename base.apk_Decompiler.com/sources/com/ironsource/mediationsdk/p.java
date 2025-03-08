package com.ironsource.mediationsdk;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.ironsource.a8;
import com.ironsource.a9;
import com.ironsource.c3;
import com.ironsource.d3;
import com.ironsource.da;
import com.ironsource.e9;
import com.ironsource.environment.ContextProvider;
import com.ironsource.f2;
import com.ironsource.f7;
import com.ironsource.g2;
import com.ironsource.g9;
import com.ironsource.h1;
import com.ironsource.j3;
import com.ironsource.j4;
import com.ironsource.j7;
import com.ironsource.k1;
import com.ironsource.k5;
import com.ironsource.k8;
import com.ironsource.l5;
import com.ironsource.m0;
import com.ironsource.m1;
import com.ironsource.m3;
import com.ironsource.m7;
import com.ironsource.mc;
import com.ironsource.mediationsdk.IronSource;
import com.ironsource.mediationsdk.adquality.AdQualityBridge;
import com.ironsource.mediationsdk.adunit.adapter.utility.AdInfo;
import com.ironsource.mediationsdk.config.ConfigFile;
import com.ironsource.mediationsdk.demandOnly.ISDemandOnlyBannerLayout;
import com.ironsource.mediationsdk.demandOnly.ISDemandOnlyInterstitialListener;
import com.ironsource.mediationsdk.demandOnly.ISDemandOnlyRewardedVideoListener;
import com.ironsource.mediationsdk.demandOnly.f;
import com.ironsource.mediationsdk.demandOnly.h;
import com.ironsource.mediationsdk.demandOnly.k;
import com.ironsource.mediationsdk.events.ISErrorListener;
import com.ironsource.mediationsdk.impressionData.ImpressionDataListener;
import com.ironsource.mediationsdk.logger.IronLog;
import com.ironsource.mediationsdk.logger.IronSourceError;
import com.ironsource.mediationsdk.logger.IronSourceLogger;
import com.ironsource.mediationsdk.logger.IronSourceLoggerManager;
import com.ironsource.mediationsdk.logger.LogListener;
import com.ironsource.mediationsdk.metadata.MetaData;
import com.ironsource.mediationsdk.metadata.MetaDataUtils;
import com.ironsource.mediationsdk.model.InterstitialPlacement;
import com.ironsource.mediationsdk.model.NetworkSettings;
import com.ironsource.mediationsdk.model.Placement;
import com.ironsource.mediationsdk.s;
import com.ironsource.mediationsdk.sdk.InitializationListener;
import com.ironsource.mediationsdk.sdk.InterstitialListener;
import com.ironsource.mediationsdk.sdk.LevelPlayInterstitialListener;
import com.ironsource.mediationsdk.sdk.LevelPlayRewardedVideoBaseListener;
import com.ironsource.mediationsdk.sdk.LevelPlayRewardedVideoListener;
import com.ironsource.mediationsdk.sdk.LevelPlayRewardedVideoManualListener;
import com.ironsource.mediationsdk.sdk.OfferwallListener;
import com.ironsource.mediationsdk.sdk.RewardedVideoListener;
import com.ironsource.mediationsdk.sdk.RewardedVideoManualListener;
import com.ironsource.mediationsdk.sdk.SegmentListener;
import com.ironsource.mediationsdk.server.HttpFunctions;
import com.ironsource.mediationsdk.server.ServerURL;
import com.ironsource.mediationsdk.utils.ErrorBuilder;
import com.ironsource.mediationsdk.utils.IronSourceAES;
import com.ironsource.mediationsdk.utils.IronSourceConstants;
import com.ironsource.mediationsdk.utils.IronSourceUtils;
import com.ironsource.mediationsdk.utils.b;
import com.ironsource.mediationsdk.utils.c;
import com.ironsource.n;
import com.ironsource.n7;
import com.ironsource.o;
import com.ironsource.o0;
import com.ironsource.oa;
import com.ironsource.pb;
import com.ironsource.q8;
import com.ironsource.q9;
import com.ironsource.r4;
import com.ironsource.r5;
import com.ironsource.rb;
import com.ironsource.sa;
import com.ironsource.sb;
import com.ironsource.t3;
import com.ironsource.u3;
import com.ironsource.u5;
import com.ironsource.u9;
import com.ironsource.ua;
import com.ironsource.v7;
import com.ironsource.va;
import com.ironsource.w7;
import com.ironsource.wb;
import com.ironsource.y3;
import com.ironsource.y8;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONException;
import org.json.JSONObject;

public class p implements v7, u9, c3, c3.b, c3.c, c3.a {
    private static boolean q0;
    private final String A;
    private int B;
    private boolean C;
    private boolean D;
    private boolean E;
    private boolean F;
    private boolean G;
    private boolean H;
    private boolean I;
    private Boolean J;
    private IronSourceBannerLayout K;
    private String L;
    private Boolean M;
    private k5 N;
    private y O;
    private w P;
    private j7 Q;
    private sa R;
    private h1 S;
    private InitializationListener T;
    private AtomicBoolean U;
    private boolean V;
    private boolean W;
    private boolean X;
    private boolean Y;
    private boolean Z;
    private final String a;
    private boolean a0;
    private final String b;
    private int b0;
    private AbstractAdapter c;
    private final ConcurrentHashMap<String, h.d> c0;
    private v d;
    private final ConcurrentHashMap<String, h.b> d0;
    private IronSourceLoggerManager e;
    private final ConcurrentHashMap<String, h.d> e0;
    private q8 f;
    private f f0;
    private com.ironsource.mediationsdk.logger.b g;
    private k g0;
    private AtomicBoolean h;
    private com.ironsource.mediationsdk.demandOnly.c h0;
    private final Object i;
    private j4 i0;
    private com.ironsource.mediationsdk.utils.c j;
    private w7 j0;
    private String k;
    private mc k0;
    private String l;
    private boolean l0;
    private String m;
    private AdQualityBridge m0;
    private String n;
    ISErrorListener n0;
    private Map<String, String> o;
    r5<ISDemandOnlyInterstitialListener> o0;
    private String p;
    r5<ISDemandOnlyRewardedVideoListener> p0;
    private AtomicBoolean q;
    private boolean r;
    private List<IronSource.AD_UNIT> s;
    private String t;
    private Context u;
    private Boolean v;
    private Set<IronSource.AD_UNIT> w;
    private Set<IronSource.AD_UNIT> x;
    private boolean y;
    private IronSourceSegment z;

    class a implements ISErrorListener {
        a() {
        }

        public void onError(Throwable th) {
            IronLog.INTERNAL.error(th.getMessage());
        }
    }

    static /* synthetic */ class b {
        static final /* synthetic */ int[] a;
        static final /* synthetic */ int[] b;
        static final /* synthetic */ int[] c;

        /* JADX WARNING: Can't wrap try/catch for region: R(23:0|(2:1|2)|3|(2:5|6)|7|(2:9|10)|11|(2:13|14)|15|17|18|19|20|21|23|24|25|26|27|28|29|30|(3:31|32|34)) */
        /* JADX WARNING: Can't wrap try/catch for region: R(28:0|1|2|3|(2:5|6)|7|9|10|11|13|14|15|17|18|19|20|21|23|24|25|26|27|28|29|30|31|32|34) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:19:0x0044 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:25:0x005f */
        /* JADX WARNING: Missing exception handler attribute for start block: B:27:0x0069 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:29:0x0073 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:31:0x007d */
        static {
            /*
                com.ironsource.mediationsdk.utils.b$b[] r0 = com.ironsource.mediationsdk.utils.b.C0017b.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                c = r0
                r1 = 1
                com.ironsource.mediationsdk.utils.b$b r2 = com.ironsource.mediationsdk.utils.b.C0017b.CAPPED_PER_DELIVERY     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r2 = r2.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r0[r2] = r1     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                r0 = 2
                int[] r2 = c     // Catch:{ NoSuchFieldError -> 0x001d }
                com.ironsource.mediationsdk.utils.b$b r3 = com.ironsource.mediationsdk.utils.b.C0017b.CAPPED_PER_COUNT     // Catch:{ NoSuchFieldError -> 0x001d }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2[r3] = r0     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                r2 = 3
                int[] r3 = c     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.ironsource.mediationsdk.utils.b$b r4 = com.ironsource.mediationsdk.utils.b.C0017b.CAPPED_PER_PACE     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r4 = r4.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r3[r4] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                r3 = 4
                int[] r4 = c     // Catch:{ NoSuchFieldError -> 0x0033 }
                com.ironsource.mediationsdk.utils.b$b r5 = com.ironsource.mediationsdk.utils.b.C0017b.NOT_CAPPED     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r5 = r5.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r4[r5] = r3     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                com.ironsource.mediationsdk.s$d[] r4 = com.ironsource.mediationsdk.s.d.values()
                int r4 = r4.length
                int[] r4 = new int[r4]
                b = r4
                com.ironsource.mediationsdk.s$d r5 = com.ironsource.mediationsdk.s.d.INIT_FAILED     // Catch:{ NoSuchFieldError -> 0x0044 }
                int r5 = r5.ordinal()     // Catch:{ NoSuchFieldError -> 0x0044 }
                r4[r5] = r1     // Catch:{ NoSuchFieldError -> 0x0044 }
            L_0x0044:
                int[] r4 = b     // Catch:{ NoSuchFieldError -> 0x004e }
                com.ironsource.mediationsdk.s$d r5 = com.ironsource.mediationsdk.s.d.INIT_IN_PROGRESS     // Catch:{ NoSuchFieldError -> 0x004e }
                int r5 = r5.ordinal()     // Catch:{ NoSuchFieldError -> 0x004e }
                r4[r5] = r0     // Catch:{ NoSuchFieldError -> 0x004e }
            L_0x004e:
                com.ironsource.mediationsdk.IronSource$AD_UNIT[] r4 = com.ironsource.mediationsdk.IronSource.AD_UNIT.values()
                int r4 = r4.length
                int[] r4 = new int[r4]
                a = r4
                com.ironsource.mediationsdk.IronSource$AD_UNIT r5 = com.ironsource.mediationsdk.IronSource.AD_UNIT.REWARDED_VIDEO     // Catch:{ NoSuchFieldError -> 0x005f }
                int r5 = r5.ordinal()     // Catch:{ NoSuchFieldError -> 0x005f }
                r4[r5] = r1     // Catch:{ NoSuchFieldError -> 0x005f }
            L_0x005f:
                int[] r1 = a     // Catch:{ NoSuchFieldError -> 0x0069 }
                com.ironsource.mediationsdk.IronSource$AD_UNIT r4 = com.ironsource.mediationsdk.IronSource.AD_UNIT.INTERSTITIAL     // Catch:{ NoSuchFieldError -> 0x0069 }
                int r4 = r4.ordinal()     // Catch:{ NoSuchFieldError -> 0x0069 }
                r1[r4] = r0     // Catch:{ NoSuchFieldError -> 0x0069 }
            L_0x0069:
                int[] r0 = a     // Catch:{ NoSuchFieldError -> 0x0073 }
                com.ironsource.mediationsdk.IronSource$AD_UNIT r1 = com.ironsource.mediationsdk.IronSource.AD_UNIT.OFFERWALL     // Catch:{ NoSuchFieldError -> 0x0073 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0073 }
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0073 }
            L_0x0073:
                int[] r0 = a     // Catch:{ NoSuchFieldError -> 0x007d }
                com.ironsource.mediationsdk.IronSource$AD_UNIT r1 = com.ironsource.mediationsdk.IronSource.AD_UNIT.BANNER     // Catch:{ NoSuchFieldError -> 0x007d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x007d }
                r0[r1] = r3     // Catch:{ NoSuchFieldError -> 0x007d }
            L_0x007d:
                int[] r0 = a     // Catch:{ NoSuchFieldError -> 0x0088 }
                com.ironsource.mediationsdk.IronSource$AD_UNIT r1 = com.ironsource.mediationsdk.IronSource.AD_UNIT.NATIVE_AD     // Catch:{ NoSuchFieldError -> 0x0088 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0088 }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0088 }
            L_0x0088:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.ironsource.mediationsdk.p.b.<clinit>():void");
        }
    }

    public interface c {
        void a(String str);
    }

    private static class d {
        static volatile p a = new p((a) null);

        private d() {
        }
    }

    private p() {
        this.a = getClass().getName();
        this.b = "!SDK-VERSION-STRING!:com.ironsource:mediationsdk:​7.6.1";
        this.i = new Object();
        this.j = null;
        this.k = null;
        this.l = "";
        this.m = null;
        this.n = null;
        this.o = null;
        this.p = null;
        this.r = false;
        this.v = null;
        this.y = true;
        this.A = "sessionDepth";
        this.M = null;
        this.l0 = false;
        v();
        this.h = new AtomicBoolean();
        this.w = new HashSet();
        this.x = new HashSet();
        this.D = false;
        this.C = false;
        this.E = false;
        this.q = new AtomicBoolean(true);
        this.U = new AtomicBoolean(false);
        this.B = 0;
        this.F = false;
        this.G = false;
        this.H = false;
        this.I = false;
        this.t = IronSourceUtils.getSessionId();
        this.J = Boolean.FALSE;
        this.Z = false;
        this.L = null;
        this.N = null;
        this.O = null;
        this.T = null;
        this.P = null;
        this.V = false;
        this.c0 = new ConcurrentHashMap<>();
        this.e0 = new ConcurrentHashMap<>();
        this.d0 = new ConcurrentHashMap<>();
        this.f0 = null;
        this.g0 = null;
        this.h0 = null;
        this.b0 = 1;
        this.i0 = new j4();
        this.j0 = new w7();
        this.k0 = new mc();
        this.n0 = new a();
        this.m0 = null;
        this.o0 = new r5.a();
        this.p0 = new r5.b();
    }

    /* synthetic */ p(a aVar) {
        this();
    }

    private boolean B() {
        com.ironsource.mediationsdk.utils.c cVar = this.j;
        return (cVar == null || cVar.b() == null || this.j.b().d() == null) ? false : true;
    }

    private boolean C() {
        return B() && E();
    }

    private boolean E() {
        com.ironsource.mediationsdk.utils.c cVar = this.j;
        return (cVar == null || cVar.h() == null || this.j.h().b() == null || this.j.h().b().size() <= 0) ? false : true;
    }

    private boolean F() {
        com.ironsource.mediationsdk.utils.c cVar = this.j;
        return (cVar == null || cVar.b() == null || this.j.b().e() == null) ? false : true;
    }

    private boolean G() {
        return F() && H();
    }

    private boolean H() {
        com.ironsource.mediationsdk.utils.c cVar = this.j;
        return (cVar == null || cVar.h() == null || this.j.h().c() == null || this.j.h().c().isEmpty()) ? false : true;
    }

    private boolean I() {
        com.ironsource.mediationsdk.utils.c cVar = this.j;
        return (cVar == null || cVar.b() == null || this.j.b().f() == null) ? false : true;
    }

    private boolean K() {
        com.ironsource.mediationsdk.utils.c cVar = this.j;
        return (cVar == null || cVar.b() == null || this.j.b().g() == null) ? false : true;
    }

    private boolean L() {
        return K() && M();
    }

    private boolean M() {
        com.ironsource.mediationsdk.utils.c cVar = this.j;
        return (cVar == null || cVar.h() == null || this.j.h().d() == null || this.j.h().d().size() <= 0) ? false : true;
    }

    private void R() {
        if (this.T != null && this.U.compareAndSet(false, true)) {
            IronLog.CALLBACK.verbose("onInitializationCompleted()");
            va.i().a(new y3(IronSourceConstants.TROUBLESHOOTING_INIT_COMPLETED, IronSourceUtils.getMediationAdditionalData(false)));
            this.T.onInitializationComplete();
        }
    }

    private void S() {
        if (!q0) {
            q0 = true;
            JSONObject mediationAdditionalData = IronSourceUtils.getMediationAdditionalData(false);
            try {
                mediationAdditionalData.put("status", "false");
                mediationAdditionalData.put("errorCode", 1);
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
            va.i().a(new y3(114, mediationAdditionalData));
        }
    }

    private void T() {
        ConcurrentHashMap<String, List<String>> c2 = k8.b().c();
        if (c2.containsKey(y8.c)) {
            String str = (String) c2.get(y8.c).get(0);
            if (!TextUtils.isEmpty(str)) {
                j3.a.b(!MetaDataUtils.getMetaDataBooleanValue(str));
            }
        }
    }

    private boolean U() {
        return this.m0 == null && this.j.b().a().a() && AdQualityBridge.adQualityAvailable();
    }

    private void V() {
        if (this.E) {
            X();
            return;
        }
        boolean h2 = this.j.b().c().d().h();
        this.a0 = h2;
        if (h2) {
            W();
        } else {
            d0();
        }
    }

    private void W() {
        IronLog.INTERNAL.verbose();
        List<NetworkSettings> a2 = a(this.j.h().a());
        if (a2.size() > 0) {
            this.S = new h1(a2, this.j.b().c(), IronSourceUtils.getUserIdForNetworks(), k8.b(), this.z, this.j.k());
            u();
            return;
        }
        JSONObject mediationAdditionalData = IronSourceUtils.getMediationAdditionalData(false, true, 1);
        a(mediationAdditionalData, new Object[][]{new Object[]{"errorCode", 1010}});
        a((int) IronSourceConstants.TROUBLESHOOTING_BN_INIT_FAILED, mediationAdditionalData);
        a(IronSource.AD_UNIT.BANNER, false);
    }

    private void X() {
        this.e.log(IronSourceLogger.IronSourceTag.INTERNAL, "Banner started in demand only mode", 0);
        ArrayList arrayList = new ArrayList();
        for (int i2 = 0; i2 < this.j.h().a().size(); i2++) {
            String str = this.j.h().a().get(i2);
            if (!TextUtils.isEmpty(str)) {
                arrayList.add(this.j.i().b(str));
            }
        }
        if (!arrayList.isEmpty()) {
            synchronized (this.d0) {
                k1 c2 = this.j.b().c();
                d3.a aVar = new d3.a("Mediation");
                if (c2.k()) {
                    aVar.a("isOneFlow", 1);
                }
                this.h0 = new com.ironsource.mediationsdk.demandOnly.c(arrayList, c2, p(), q(), new d3.b(n7.i(), aVar));
            }
            for (h.b next : this.d0.values()) {
                this.h0.a(next.g(), next.b());
            }
            this.d0.clear();
            return;
        }
        JSONObject mediationAdditionalData = IronSourceUtils.getMediationAdditionalData(false, false, 1);
        a(mediationAdditionalData, new Object[][]{new Object[]{"errorCode", 1010}});
        a((int) IronSourceConstants.TROUBLESHOOTING_BN_INIT_FAILED, mediationAdditionalData);
        a(IronSource.AD_UNIT.BANNER, false);
    }

    private void Y() {
        this.e.log(IronSourceLogger.IronSourceTag.INTERNAL, "Interstitial started in demand only mode", 0);
        ArrayList arrayList = new ArrayList();
        for (int i2 = 0; i2 < this.j.h().b().size(); i2++) {
            String str = this.j.h().b().get(i2);
            if (!TextUtils.isEmpty(str)) {
                arrayList.add(this.j.i().b(str));
            }
        }
        if (!arrayList.isEmpty()) {
            synchronized (this.c0) {
                this.f0 = a((List<NetworkSettings>) arrayList);
            }
            for (h.d a2 : this.c0.values()) {
                this.f0.a(a2);
            }
            this.c0.clear();
            return;
        }
        JSONObject mediationAdditionalData = IronSourceUtils.getMediationAdditionalData(false, false, 1);
        a(mediationAdditionalData, new Object[][]{new Object[]{"errorCode", 1010}});
        a((int) IronSourceConstants.TROUBLESHOOTING_IS_INIT_FAILED, mediationAdditionalData);
        a(IronSource.AD_UNIT.INTERSTITIAL, false);
    }

    private void Z() {
        this.e.log(IronSourceLogger.IronSourceTag.INTERNAL, "Rewarded Video started in demand only mode", 0);
        ArrayList arrayList = new ArrayList();
        for (int i2 = 0; i2 < this.j.h().d().size(); i2++) {
            String str = this.j.h().d().get(i2);
            if (!TextUtils.isEmpty(str)) {
                arrayList.add(this.j.i().b(str));
            }
        }
        if (!arrayList.isEmpty()) {
            synchronized (this.e0) {
                this.g0 = b((List<NetworkSettings>) arrayList);
            }
            if (ContextProvider.getInstance().getCurrentActiveActivity() == null) {
                a(IronSource.AD_UNIT.REWARDED_VIDEO, false);
                return;
            }
            for (h.d a2 : this.e0.values()) {
                this.g0.a(a2);
            }
            this.e0.clear();
            return;
        }
        a(IronSource.AD_UNIT.REWARDED_VIDEO, false);
    }

    private int a(ua uaVar) {
        return (this.X || this.V || !uaVar.k().e()) ? 1 : 2;
    }

    private f a(List<NetworkSettings> list) {
        m7 d2 = this.j.b().d();
        d3.a aVar = new d3.a("Mediation");
        if (d2.k()) {
            aVar.a("isOneFlow", 1);
        }
        return new f(list, d2, c.b(), this.o0, p(), q(), new d3.b(n7.i(), aVar));
    }

    private IronSourceError a(s.d dVar) {
        if (!this.H) {
            return new IronSourceError(510, "ironSource SDK was not initialized");
        }
        if (!this.E) {
            return new IronSourceError(510, "ironSource SDK was not initialized using Demand Only mode");
        }
        if (dVar == s.d.INIT_FAILED) {
            return new IronSourceError(510, "ironSource initialization failed");
        }
        if (dVar != s.d.INIT_IN_PROGRESS || !s.c().d()) {
            return null;
        }
        return new IronSourceError(510, "ironSource initialization in progress");
    }

    private com.ironsource.mediationsdk.utils.c a(Context context, String str) {
        if (IronSourceUtils.isInitResponseCached(context)) {
            String cachedValueByKeyOfCachedInitResponse = IronSourceUtils.getCachedValueByKeyOfCachedInitResponse(context, "appKey");
            String cachedValueByKeyOfCachedInitResponse2 = IronSourceUtils.getCachedValueByKeyOfCachedInitResponse(context, "userId");
            String cachedValueByKeyOfCachedInitResponse3 = IronSourceUtils.getCachedValueByKeyOfCachedInitResponse(context, com.ironsource.mediationsdk.utils.c.Y1);
            if (cachedValueByKeyOfCachedInitResponse.equals(str)) {
                com.ironsource.mediationsdk.utils.c cVar = new com.ironsource.mediationsdk.utils.c(context, cachedValueByKeyOfCachedInitResponse, cachedValueByKeyOfCachedInitResponse2, cachedValueByKeyOfCachedInitResponse3);
                cVar.a(c.a.CACHE);
                return cVar;
            }
        }
        return null;
    }

    private com.ironsource.mediationsdk.utils.c a(Context context, String str, c cVar) {
        com.ironsource.mediationsdk.utils.c cVar2 = null;
        if (!IronSourceUtils.isNetworkConnected(context)) {
            return null;
        }
        try {
            String b2 = b(context);
            if (TextUtils.isEmpty(b2)) {
                b2 = m3.z(context);
                IronSourceLoggerManager.getLogger().log(IronSourceLogger.IronSourceTag.INTERNAL, "using custom identifier", 1);
            }
            String str2 = b2;
            IronSourceSegment ironSourceSegment = this.z;
            String stringFromURL = HttpFunctions.getStringFromURL(ServerURL.getCPVProvidersURL(context, p(), str, str2, r(), this.V, ironSourceSegment != null ? ironSourceSegment.getSegmentData() : null, A()), cVar);
            if (stringFromURL == null) {
                IronLog.INTERNAL.warning("serverResponseString is null");
                return null;
            }
            if (IronSourceUtils.isEncryptedResponse()) {
                IronLog ironLog = IronLog.INTERNAL;
                ironLog.verbose("encrypt");
                String optString = new JSONObject(stringFromURL).optString(com.ironsource.mediationsdk.utils.c.Y1, (String) null);
                if (TextUtils.isEmpty(optString)) {
                    ironLog.warning("encryptedResponse is empty - return null");
                    return null;
                }
                stringFromURL = IronSourceAES.decode(u3.b().c(), optString);
                if (TextUtils.isEmpty(stringFromURL)) {
                    ironLog.warning("encoded response invalid - return null");
                    S();
                    return null;
                }
            }
            com.ironsource.mediationsdk.utils.c cVar3 = new com.ironsource.mediationsdk.utils.c(context, p(), str, stringFromURL);
            try {
                cVar3.a(c.a.SERVER);
                if (cVar3.m()) {
                    return cVar3;
                }
                IronLog.INTERNAL.warning("response invalid - return null");
                return null;
            } catch (Exception e2) {
                e = e2;
                cVar2 = cVar3;
                IronLog ironLog2 = IronLog.INTERNAL;
                ironLog2.warning("exception = " + e);
                e.printStackTrace();
                return cVar2;
            }
        } catch (Exception e3) {
            e = e3;
            IronLog ironLog22 = IronLog.INTERNAL;
            ironLog22.warning("exception = " + e);
            e.printStackTrace();
            return cVar2;
        }
    }

    private List<NetworkSettings> a(ArrayList<String> arrayList) {
        ArrayList arrayList2 = new ArrayList();
        for (int i2 = 0; i2 < arrayList.size(); i2++) {
            String str = arrayList.get(i2);
            if (!TextUtils.isEmpty(str)) {
                arrayList2.add(this.j.i().b(str));
            }
        }
        return arrayList2;
    }

    private void a(int i2, JSONObject jSONObject) {
        n7.i().a(new y3(i2, jSONObject));
    }

    private void a(m0 m0Var, Context context, com.ironsource.mediationsdk.utils.c cVar) {
        n7.i().a(m0Var.c(), context);
        n7.i().b(m0Var.d(), context);
        n7.i().b(m0Var.f());
        n7.i().a(m0Var.e());
        n7.i().c(m0Var.a());
        n7.i().c(m0Var.i(), context);
        n7.i().a(m0Var.h(), context);
        n7.i().b(m0Var.j(), context);
        n7.i().d(m0Var.g(), context);
        n7.i().a(cVar.b().b().i());
        n7.i().a(m0Var.k());
        n7.i().d(m0Var.b());
    }

    private void a(IronSource.AD_UNIT ad_unit) {
        String str = ad_unit + " ad unit has already been initialized";
        this.e.log(IronSourceLogger.IronSourceTag.API, str, 3);
        IronSourceUtils.sendAutomationLog(str);
    }

    private void a(IronSource.AD_UNIT ad_unit, boolean z2) {
        ConcurrentHashMap concurrentHashMap;
        int i2 = b.a[ad_unit.ordinal()];
        if (i2 != 1) {
            if (i2 != 2) {
                if (i2 != 3) {
                    if (i2 == 4) {
                        if (this.E) {
                            for (h.b next : this.d0.values()) {
                                ISDemandOnlyBannerLayout g2 = next.g();
                                if (g2 != null) {
                                    g2.getListener().a(next.b(), ErrorBuilder.buildInitFailedError("initISDemandOnly() had failed", "Banner"));
                                }
                            }
                            concurrentHashMap = this.d0;
                        } else if (this.J.booleanValue()) {
                            this.J = Boolean.FALSE;
                            n.a().a(IronSource.AD_UNIT.BANNER, new IronSourceError(IronSourceError.ERROR_BN_INIT_FAILED_AFTER_LOAD, "init() had failed"));
                            this.K = null;
                            this.L = null;
                            return;
                        } else {
                            return;
                        }
                    } else {
                        return;
                    }
                } else if (z2 || I() || this.x.contains(ad_unit)) {
                    this.f.onOfferwallAvailable(false);
                    return;
                } else {
                    return;
                }
            } else if (this.D) {
                for (h.d b2 : this.c0.values()) {
                    String b3 = b2.b();
                    this.o0.a(b3).onInterstitialAdLoadFailed(b3, ErrorBuilder.buildInitFailedError("initISDemandOnly() had failed", "Interstitial"));
                }
                concurrentHashMap = this.c0;
            } else if (this.Z) {
                this.Z = false;
                n.a().a(IronSource.AD_UNIT.INTERSTITIAL, ErrorBuilder.buildInitFailedError("init() had failed", "Interstitial"));
                return;
            } else {
                return;
            }
        } else if (this.C) {
            for (h.d b4 : this.e0.values()) {
                String b5 = b4.b();
                this.p0.a(b5).onRewardedVideoAdLoadFailed(b5, ErrorBuilder.buildInitFailedError("initISDemandOnly() had failed", IronSourceConstants.REWARDED_VIDEO_AD_UNIT));
            }
            concurrentHashMap = this.e0;
        } else if (this.V) {
            if (this.W) {
                this.W = false;
                n.a().a(IronSource.AD_UNIT.REWARDED_VIDEO, ErrorBuilder.buildInitFailedError("init() had failed", IronSourceConstants.REWARDED_VIDEO_AD_UNIT));
                return;
            }
            return;
        } else if (z2 || K() || this.x.contains(ad_unit)) {
            oa.a().a(false, (AdInfo) null);
            return;
        } else {
            return;
        }
        concurrentHashMap.clear();
    }

    /*  JADX ERROR: IndexOutOfBoundsException in pass: RegionMakerVisitor
        java.lang.IndexOutOfBoundsException: Index: 0, Size: 0
        	at java.util.ArrayList.rangeCheck(ArrayList.java:659)
        	at java.util.ArrayList.get(ArrayList.java:435)
        	at jadx.core.dex.nodes.InsnNode.getArg(InsnNode.java:101)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:611)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.processMonitorEnter(RegionMaker.java:561)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:133)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
        	at jadx.core.dex.visitors.regions.RegionMaker.processIf(RegionMaker.java:698)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:123)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
        	at jadx.core.dex.visitors.regions.RegionMaker.processIf(RegionMaker.java:693)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:123)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
        	at jadx.core.dex.visitors.regions.RegionMaker.processIf(RegionMaker.java:698)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:123)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
        	at jadx.core.dex.visitors.regions.RegionMaker.processIf(RegionMaker.java:698)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:123)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
        	at jadx.core.dex.visitors.regions.RegionMaker.processIf(RegionMaker.java:698)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:123)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
        	at jadx.core.dex.visitors.regions.RegionMaker.processIf(RegionMaker.java:698)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:123)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
        	at jadx.core.dex.visitors.regions.RegionMaker.processMonitorEnter(RegionMaker.java:598)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:133)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
        	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:49)
        */
    private synchronized void a(com.ironsource.mediationsdk.demandOnly.h.d r8, com.ironsource.mediationsdk.demandOnly.ISDemandOnlyInterstitialListener r9) {
        /*
            r7 = this;
            java.lang.String r0 = "instanceId="
            monitor-enter(r7)
            java.lang.String r1 = r8.b()     // Catch:{ all -> 0x0146 }
            com.ironsource.mediationsdk.logger.IronLog r2 = com.ironsource.mediationsdk.logger.IronLog.API     // Catch:{ all -> 0x0146 }
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x0146 }
            r3.<init>(r0)     // Catch:{ all -> 0x0146 }
            r3.append(r1)     // Catch:{ all -> 0x0146 }
            java.lang.String r0 = r3.toString()     // Catch:{ all -> 0x0146 }
            r2.info(r0)     // Catch:{ all -> 0x0146 }
            r0 = 510(0x1fe, float:7.15E-43)
            boolean r3 = r7.G     // Catch:{ all -> 0x012e }
            if (r3 != 0) goto L_0x002d
            java.lang.String r8 = "initISDemandOnly() must be called before loadISDemandOnlyInterstitial()"
            r2.error(r8)     // Catch:{ all -> 0x012e }
            com.ironsource.mediationsdk.logger.IronSourceError r2 = new com.ironsource.mediationsdk.logger.IronSourceError     // Catch:{ all -> 0x012e }
            r2.<init>(r0, r8)     // Catch:{ all -> 0x012e }
            r9.onInterstitialAdLoadFailed(r1, r2)     // Catch:{ all -> 0x012e }
            monitor-exit(r7)
            return
        L_0x002d:
            boolean r3 = r7.D     // Catch:{ all -> 0x012e }
            if (r3 != 0) goto L_0x0040
            java.lang.String r8 = "Interstitial was initialized in mediation mode. Use loadInterstitial instead"
            r2.error(r8)     // Catch:{ all -> 0x012e }
            com.ironsource.mediationsdk.logger.IronSourceError r2 = new com.ironsource.mediationsdk.logger.IronSourceError     // Catch:{ all -> 0x012e }
            r2.<init>(r0, r8)     // Catch:{ all -> 0x012e }
            r9.onInterstitialAdLoadFailed(r1, r2)     // Catch:{ all -> 0x012e }
            monitor-exit(r7)
            return
        L_0x0040:
            com.ironsource.mediationsdk.s r3 = com.ironsource.mediationsdk.s.c()     // Catch:{ all -> 0x012e }
            com.ironsource.mediationsdk.s$d r3 = r3.a()     // Catch:{ all -> 0x012e }
            com.ironsource.mediationsdk.s$d r4 = com.ironsource.mediationsdk.s.d.INIT_FAILED     // Catch:{ all -> 0x012e }
            if (r3 != r4) goto L_0x005e
            java.lang.String r8 = "init() had failed"
            r2.error(r8)     // Catch:{ all -> 0x012e }
            java.lang.String r8 = "init() had failed"
            java.lang.String r2 = "Interstitial"
            com.ironsource.mediationsdk.logger.IronSourceError r8 = com.ironsource.mediationsdk.utils.ErrorBuilder.buildInitFailedError(r8, r2)     // Catch:{ all -> 0x012e }
            r9.onInterstitialAdLoadFailed(r1, r8)     // Catch:{ all -> 0x012e }
            monitor-exit(r7)
            return
        L_0x005e:
            com.ironsource.mediationsdk.logger.IronSourceError r4 = r8.c()     // Catch:{ all -> 0x012e }
            r5 = 1
            if (r4 == 0) goto L_0x008c
            int r3 = r4.getErrorCode()     // Catch:{ all -> 0x012e }
            r6 = 1060(0x424, float:1.485E-42)
            if (r3 != r6) goto L_0x0080
            java.lang.String r8 = r8.a()     // Catch:{ all -> 0x012e }
            boolean r8 = android.text.TextUtils.isEmpty(r8)     // Catch:{ all -> 0x012e }
            r8 = r8 ^ r5
            org.json.JSONObject r8 = com.ironsource.mediationsdk.utils.IronSourceUtils.getMediationAdditionalData(r5, r8, r5)     // Catch:{ all -> 0x012e }
            r3 = 82321(0x14191, float:1.15356E-40)
            r7.b((int) r3, (org.json.JSONObject) r8)     // Catch:{ all -> 0x012e }
        L_0x0080:
            java.lang.String r8 = r4.toString()     // Catch:{ all -> 0x012e }
            r2.error(r8)     // Catch:{ all -> 0x012e }
            r9.onInterstitialAdLoadFailed(r1, r4)     // Catch:{ all -> 0x012e }
            monitor-exit(r7)
            return
        L_0x008c:
            android.app.Activity r4 = r8.e()     // Catch:{ all -> 0x012e }
            r7.e((android.app.Activity) r4)     // Catch:{ all -> 0x012e }
            com.ironsource.mediationsdk.s$d r4 = com.ironsource.mediationsdk.s.d.INIT_IN_PROGRESS     // Catch:{ all -> 0x012e }
            r6 = 83003(0x1443b, float:1.16312E-40)
            if (r3 != r4) goto L_0x00e1
            com.ironsource.mediationsdk.s r3 = com.ironsource.mediationsdk.s.c()     // Catch:{ all -> 0x012e }
            boolean r3 = r3.d()     // Catch:{ all -> 0x012e }
            if (r3 == 0) goto L_0x00b5
            java.lang.String r8 = "init() had failed"
            r2.error(r8)     // Catch:{ all -> 0x012e }
            java.lang.String r8 = "init() had failed"
            java.lang.String r2 = "Interstitial"
            com.ironsource.mediationsdk.logger.IronSourceError r8 = com.ironsource.mediationsdk.utils.ErrorBuilder.buildInitFailedError(r8, r2)     // Catch:{ all -> 0x012e }
            r9.onInterstitialAdLoadFailed(r1, r8)     // Catch:{ all -> 0x012e }
            goto L_0x00dc
        L_0x00b5:
            java.util.concurrent.ConcurrentHashMap<java.lang.String, com.ironsource.mediationsdk.demandOnly.h$d> r2 = r7.c0     // Catch:{ all -> 0x012e }
            monitor-enter(r2)     // Catch:{ all -> 0x012e }
            java.util.concurrent.ConcurrentHashMap<java.lang.String, com.ironsource.mediationsdk.demandOnly.h$d> r3 = r7.c0     // Catch:{ all -> 0x00de }
            java.lang.String r4 = r8.b()     // Catch:{ all -> 0x00de }
            r3.put(r4, r8)     // Catch:{ all -> 0x00de }
            monitor-exit(r2)     // Catch:{ all -> 0x00de }
            java.lang.String r2 = r8.b()     // Catch:{ all -> 0x012e }
            boolean r2 = android.text.TextUtils.isEmpty(r2)     // Catch:{ all -> 0x012e }
            if (r2 != 0) goto L_0x00dc
            java.lang.String r8 = r8.a()     // Catch:{ all -> 0x012e }
            boolean r8 = android.text.TextUtils.isEmpty(r8)     // Catch:{ all -> 0x012e }
            r8 = r8 ^ r5
            org.json.JSONObject r8 = com.ironsource.mediationsdk.utils.IronSourceUtils.getMediationAdditionalData(r5, r8, r5)     // Catch:{ all -> 0x012e }
            r7.a((int) r6, (org.json.JSONObject) r8)     // Catch:{ all -> 0x012e }
        L_0x00dc:
            monitor-exit(r7)
            return
        L_0x00de:
            r8 = move-exception
            monitor-exit(r2)     // Catch:{ all -> 0x00de }
            throw r8     // Catch:{ all -> 0x012e }
        L_0x00e1:
            boolean r3 = r7.C()     // Catch:{ all -> 0x012e }
            if (r3 != 0) goto L_0x00f9
            java.lang.String r8 = "No interstitial configurations found"
            r2.error(r8)     // Catch:{ all -> 0x012e }
            java.lang.String r8 = "the server response does not contain interstitial data"
            java.lang.String r2 = "Interstitial"
            com.ironsource.mediationsdk.logger.IronSourceError r8 = com.ironsource.mediationsdk.utils.ErrorBuilder.buildInitFailedError(r8, r2)     // Catch:{ all -> 0x012e }
            r9.onInterstitialAdLoadFailed(r1, r8)     // Catch:{ all -> 0x012e }
            monitor-exit(r7)
            return
        L_0x00f9:
            java.util.concurrent.ConcurrentHashMap<java.lang.String, com.ironsource.mediationsdk.demandOnly.h$d> r2 = r7.c0     // Catch:{ all -> 0x012e }
            monitor-enter(r2)     // Catch:{ all -> 0x012e }
            com.ironsource.mediationsdk.demandOnly.f r3 = r7.f0     // Catch:{ all -> 0x012b }
            if (r3 != 0) goto L_0x0126
            java.util.concurrent.ConcurrentHashMap<java.lang.String, com.ironsource.mediationsdk.demandOnly.h$d> r3 = r7.c0     // Catch:{ all -> 0x012b }
            java.lang.String r4 = r8.b()     // Catch:{ all -> 0x012b }
            r3.put(r4, r8)     // Catch:{ all -> 0x012b }
            java.lang.String r3 = r8.a()     // Catch:{ all -> 0x012b }
            boolean r3 = android.text.TextUtils.isEmpty(r3)     // Catch:{ all -> 0x012b }
            if (r3 != 0) goto L_0x0123
            java.lang.String r8 = r8.a()     // Catch:{ all -> 0x012b }
            boolean r8 = android.text.TextUtils.isEmpty(r8)     // Catch:{ all -> 0x012b }
            r8 = r8 ^ r5
            org.json.JSONObject r8 = com.ironsource.mediationsdk.utils.IronSourceUtils.getMediationAdditionalData(r5, r8, r5)     // Catch:{ all -> 0x012b }
            r7.a((int) r6, (org.json.JSONObject) r8)     // Catch:{ all -> 0x012b }
        L_0x0123:
            monitor-exit(r2)     // Catch:{ all -> 0x012b }
            monitor-exit(r7)
            return
        L_0x0126:
            monitor-exit(r2)     // Catch:{ all -> 0x012b }
            r3.a((com.ironsource.mediationsdk.demandOnly.h.d) r8)     // Catch:{ all -> 0x012e }
            goto L_0x0144
        L_0x012b:
            r8 = move-exception
            monitor-exit(r2)     // Catch:{ all -> 0x012b }
            throw r8     // Catch:{ all -> 0x012e }
        L_0x012e:
            r8 = move-exception
            com.ironsource.mediationsdk.logger.IronLog r2 = com.ironsource.mediationsdk.logger.IronLog.API     // Catch:{ all -> 0x0146 }
            java.lang.String r3 = r8.getMessage()     // Catch:{ all -> 0x0146 }
            r2.error(r3)     // Catch:{ all -> 0x0146 }
            com.ironsource.mediationsdk.logger.IronSourceError r2 = new com.ironsource.mediationsdk.logger.IronSourceError     // Catch:{ all -> 0x0146 }
            java.lang.String r8 = r8.getMessage()     // Catch:{ all -> 0x0146 }
            r2.<init>(r0, r8)     // Catch:{ all -> 0x0146 }
            r9.onInterstitialAdLoadFailed(r1, r2)     // Catch:{ all -> 0x0146 }
        L_0x0144:
            monitor-exit(r7)
            return
        L_0x0146:
            r8 = move-exception
            monitor-exit(r7)
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ironsource.mediationsdk.p.a(com.ironsource.mediationsdk.demandOnly.h$d, com.ironsource.mediationsdk.demandOnly.ISDemandOnlyInterstitialListener):void");
    }

    private void a(com.ironsource.mediationsdk.utils.c cVar) {
        this.g.setDebugLevel(cVar.b().b().g().b());
        this.e.setLoggerDebugLevel(com.ironsource.mediationsdk.logger.a.c, cVar.b().b().g().a());
    }

    /* JADX WARNING: Removed duplicated region for block: B:28:0x00b3  */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x00c3  */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x00ef  */
    /* JADX WARNING: Removed duplicated region for block: B:39:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void a(com.ironsource.mediationsdk.utils.c r9, android.content.Context r10) {
        /*
            r8 = this;
            boolean r0 = r8.K()
            r1 = 0
            if (r0 == 0) goto L_0x0018
            com.ironsource.g2 r0 = r9.b()
            com.ironsource.ua r0 = r0.g()
            com.ironsource.m0 r0 = r0.n()
            boolean r0 = r0.l()
            goto L_0x0019
        L_0x0018:
            r0 = 0
        L_0x0019:
            boolean r2 = r8.B()
            if (r2 == 0) goto L_0x0030
            com.ironsource.g2 r2 = r9.b()
            com.ironsource.m7 r2 = r2.d()
            com.ironsource.m0 r2 = r2.j()
            boolean r2 = r2.l()
            goto L_0x0031
        L_0x0030:
            r2 = 0
        L_0x0031:
            boolean r3 = r8.x()
            if (r3 == 0) goto L_0x0048
            com.ironsource.g2 r3 = r9.b()
            com.ironsource.k1 r3 = r3.c()
            com.ironsource.m0 r3 = r3.h()
            boolean r3 = r3.l()
            goto L_0x0049
        L_0x0048:
            r3 = 0
        L_0x0049:
            boolean r4 = r8.F()
            if (r4 == 0) goto L_0x0060
            com.ironsource.g2 r4 = r9.b()
            com.ironsource.a9 r4 = r4.e()
            com.ironsource.m0 r4 = r4.g()
            boolean r4 = r4.l()
            goto L_0x0061
        L_0x0060:
            r4 = 0
        L_0x0061:
            boolean r5 = r8.I()
            if (r5 == 0) goto L_0x0078
            com.ironsource.g2 r5 = r9.b()
            com.ironsource.p9 r5 = r5.f()
            com.ironsource.m0 r5 = r5.c()
            boolean r5 = r5.l()
            goto L_0x0079
        L_0x0078:
            r5 = 0
        L_0x0079:
            com.ironsource.g2 r6 = r9.b()
            com.ironsource.j0 r6 = r6.b()
            com.ironsource.ea r6 = r6.h()
            boolean r7 = r6.i()
            if (r0 == 0) goto L_0x009b
            com.ironsource.g2 r0 = r9.b()
            com.ironsource.ua r0 = r0.g()
            com.ironsource.m0 r0 = r0.n()
        L_0x0097:
            r8.b((com.ironsource.m0) r0, (android.content.Context) r10, (com.ironsource.mediationsdk.utils.c) r9)
            goto L_0x00b1
        L_0x009b:
            if (r5 == 0) goto L_0x00aa
            com.ironsource.g2 r0 = r9.b()
            com.ironsource.p9 r0 = r0.f()
            com.ironsource.m0 r0 = r0.c()
            goto L_0x0097
        L_0x00aa:
            com.ironsource.va r0 = com.ironsource.va.i()
            r0.b((boolean) r1)
        L_0x00b1:
            if (r2 == 0) goto L_0x00c3
            com.ironsource.g2 r0 = r9.b()
            com.ironsource.m7 r0 = r0.d()
            com.ironsource.m0 r0 = r0.j()
        L_0x00bf:
            r8.a((com.ironsource.m0) r0, (android.content.Context) r10, (com.ironsource.mediationsdk.utils.c) r9)
            goto L_0x00e8
        L_0x00c3:
            if (r3 == 0) goto L_0x00d2
            com.ironsource.g2 r0 = r9.b()
            com.ironsource.k1 r0 = r0.c()
            com.ironsource.m0 r0 = r0.h()
            goto L_0x00bf
        L_0x00d2:
            if (r4 == 0) goto L_0x00e1
            com.ironsource.g2 r0 = r9.b()
            com.ironsource.a9 r0 = r0.e()
            com.ironsource.m0 r0 = r0.g()
            goto L_0x00bf
        L_0x00e1:
            com.ironsource.n7 r9 = com.ironsource.n7.i()
            r9.b((boolean) r1)
        L_0x00e8:
            com.ironsource.da r9 = com.ironsource.da.P
            r9.b((boolean) r7)
            if (r7 == 0) goto L_0x0112
            java.lang.String r0 = r6.j()
            r9.b((java.lang.String) r0, (android.content.Context) r10)
            int[] r0 = r6.l()
            r9.c((int[]) r0, (android.content.Context) r10)
            int[] r0 = r6.k()
            r9.a((int[]) r0, (android.content.Context) r10)
            boolean r10 = r6.g()
            r9.a((boolean) r10)
            int r10 = r6.h()
            r9.d((int) r10)
        L_0x0112:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ironsource.mediationsdk.p.a(com.ironsource.mediationsdk.utils.c, android.content.Context):void");
    }

    private void a(o0 o0Var) {
        j3 j3Var = j3.a;
        j3Var.c(o0Var.e());
        j3Var.a(o0Var.d());
        j3Var.a(o0Var.g());
    }

    private void a(String str, f2 f2Var) {
        if (!a(str, 1, 128)) {
            f2Var.a(ErrorBuilder.buildInvalidKeyValueError(IronSourceConstants.EVENTS_DYNAMIC_USER_ID, IronSourceConstants.SUPERSONIC_CONFIG_NAME, "dynamicUserId is invalid, should be between 1-128 chars in length."));
        }
    }

    private void a(JSONObject jSONObject, Object[][] objArr) {
        if (objArr != null) {
            try {
                for (Object[] objArr2 : objArr) {
                    jSONObject.put(objArr2[0].toString(), objArr2[1]);
                }
            } catch (Exception e2) {
                IronSourceLoggerManager.getLogger().log(IronSourceLogger.IronSourceTag.INTERNAL, "IronSourceObject addToDictionary: " + Log.getStackTraceString(e2), 3);
            }
        }
    }

    private void a(boolean z2, String str) {
        if (z2) {
            JSONObject mediationAdditionalData = IronSourceUtils.getMediationAdditionalData(this.C, true, this.b0);
            if (str != null) {
                a(mediationAdditionalData, new Object[][]{new Object[]{"placement", str}});
            }
            b((int) IronSourceConstants.RV_API_IS_CAPPED_TRUE, mediationAdditionalData);
        }
    }

    private void a(boolean z2, boolean z3, int i2, JSONObject jSONObject) {
        String str;
        try {
            StringBuilder sb = new StringBuilder();
            if (z3) {
                Object[] objArr = new Object[1];
                objArr[0] = Boolean.valueOf(ContextProvider.getInstance().getCurrentActiveActivity() != null);
                str = String.format(",Activity=%s", objArr);
            } else {
                if (!z2) {
                    sb.append(",");
                    str = IronSourceConstants.EVENTS_INIT_CONTEXT_FLOW;
                }
                sb.append(String.format(",cachedUserAgent=%s", new Object[]{Boolean.valueOf(m3.x)}));
                jSONObject.put(IronSourceConstants.EVENTS_EXT1, sb.toString());
                jSONObject.put("sessionDepth", i2);
                va.i().a(new y3(14, jSONObject));
            }
            sb.append(str);
            sb.append(String.format(",cachedUserAgent=%s", new Object[]{Boolean.valueOf(m3.x)}));
            jSONObject.put(IronSourceConstants.EVENTS_EXT1, sb.toString());
            jSONObject.put("sessionDepth", i2);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        va.i().a(new y3(14, jSONObject));
    }

    /* JADX WARNING: Code restructure failed: missing block: B:73:0x00fc, code lost:
        if (r5 != false) goto L_0x00fe;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private synchronized void a(boolean r10, boolean r11, com.ironsource.mediationsdk.IronSource.AD_UNIT... r12) {
        /*
            r9 = this;
            monitor-enter(r9)
            int r0 = r12.length     // Catch:{ all -> 0x0108 }
            r1 = 0
            r2 = 0
        L_0x0004:
            r3 = 1
            if (r2 >= r0) goto L_0x0037
            r4 = r12[r2]     // Catch:{ all -> 0x0108 }
            com.ironsource.mediationsdk.IronSource$AD_UNIT r5 = com.ironsource.mediationsdk.IronSource.AD_UNIT.INTERSTITIAL     // Catch:{ all -> 0x0108 }
            boolean r5 = r4.equals(r5)     // Catch:{ all -> 0x0108 }
            if (r5 == 0) goto L_0x0014
            r9.G = r3     // Catch:{ all -> 0x0108 }
            goto L_0x0034
        L_0x0014:
            com.ironsource.mediationsdk.IronSource$AD_UNIT r5 = com.ironsource.mediationsdk.IronSource.AD_UNIT.BANNER     // Catch:{ all -> 0x0108 }
            boolean r5 = r4.equals(r5)     // Catch:{ all -> 0x0108 }
            if (r5 == 0) goto L_0x001f
            r9.H = r3     // Catch:{ all -> 0x0108 }
            goto L_0x0034
        L_0x001f:
            com.ironsource.mediationsdk.IronSource$AD_UNIT r5 = com.ironsource.mediationsdk.IronSource.AD_UNIT.REWARDED_VIDEO     // Catch:{ all -> 0x0108 }
            boolean r5 = r4.equals(r5)     // Catch:{ all -> 0x0108 }
            if (r5 == 0) goto L_0x002a
            r9.F = r3     // Catch:{ all -> 0x0108 }
            goto L_0x0034
        L_0x002a:
            com.ironsource.mediationsdk.IronSource$AD_UNIT r5 = com.ironsource.mediationsdk.IronSource.AD_UNIT.NATIVE_AD     // Catch:{ all -> 0x0108 }
            boolean r4 = r4.equals(r5)     // Catch:{ all -> 0x0108 }
            if (r4 == 0) goto L_0x0034
            r9.I = r3     // Catch:{ all -> 0x0108 }
        L_0x0034:
            int r2 = r2 + 1
            goto L_0x0004
        L_0x0037:
            com.ironsource.mediationsdk.s r0 = com.ironsource.mediationsdk.s.c()     // Catch:{ all -> 0x0108 }
            com.ironsource.mediationsdk.s$d r0 = r0.a()     // Catch:{ all -> 0x0108 }
            com.ironsource.mediationsdk.s$d r2 = com.ironsource.mediationsdk.s.d.INIT_FAILED     // Catch:{ all -> 0x0108 }
            if (r0 != r2) goto L_0x0060
            com.ironsource.q8 r10 = r9.f     // Catch:{ Exception -> 0x005a }
            if (r10 == 0) goto L_0x0106
            int r10 = r12.length     // Catch:{ Exception -> 0x005a }
        L_0x0048:
            if (r1 >= r10) goto L_0x0106
            r11 = r12[r1]     // Catch:{ Exception -> 0x005a }
            java.util.Set<com.ironsource.mediationsdk.IronSource$AD_UNIT> r0 = r9.w     // Catch:{ Exception -> 0x005a }
            boolean r0 = r0.contains(r11)     // Catch:{ Exception -> 0x005a }
            if (r0 != 0) goto L_0x0057
            r9.a((com.ironsource.mediationsdk.IronSource.AD_UNIT) r11, (boolean) r3)     // Catch:{ Exception -> 0x005a }
        L_0x0057:
            int r1 = r1 + 1
            goto L_0x0048
        L_0x005a:
            r10 = move-exception
            r10.printStackTrace()     // Catch:{ all -> 0x0108 }
            goto L_0x0106
        L_0x0060:
            boolean r0 = r9.r     // Catch:{ all -> 0x0108 }
            if (r0 != 0) goto L_0x00ad
            org.json.JSONObject r0 = com.ironsource.mediationsdk.utils.IronSourceUtils.getMediationAdditionalData(r11)     // Catch:{ all -> 0x0108 }
            int r2 = r12.length     // Catch:{ all -> 0x0108 }
            r4 = 0
        L_0x006a:
            if (r1 >= r2) goto L_0x00aa
            r5 = r12[r1]     // Catch:{ all -> 0x0108 }
            java.util.Set<com.ironsource.mediationsdk.IronSource$AD_UNIT> r6 = r9.w     // Catch:{ all -> 0x0108 }
            boolean r6 = r6.contains(r5)     // Catch:{ all -> 0x0108 }
            if (r6 != 0) goto L_0x008e
            java.util.Set<com.ironsource.mediationsdk.IronSource$AD_UNIT> r4 = r9.w     // Catch:{ all -> 0x0108 }
            r4.add(r5)     // Catch:{ all -> 0x0108 }
            java.util.Set<com.ironsource.mediationsdk.IronSource$AD_UNIT> r4 = r9.x     // Catch:{ all -> 0x0108 }
            r4.add(r5)     // Catch:{ all -> 0x0108 }
            java.lang.String r4 = r5.toString()     // Catch:{ Exception -> 0x0088 }
            r0.put(r4, r3)     // Catch:{ Exception -> 0x0088 }
            goto L_0x008c
        L_0x0088:
            r4 = move-exception
            r4.printStackTrace()     // Catch:{ all -> 0x0108 }
        L_0x008c:
            r4 = 1
            goto L_0x00a7
        L_0x008e:
            com.ironsource.mediationsdk.logger.IronSourceLoggerManager r6 = r9.e     // Catch:{ all -> 0x0108 }
            com.ironsource.mediationsdk.logger.IronSourceLogger$IronSourceTag r7 = com.ironsource.mediationsdk.logger.IronSourceLogger.IronSourceTag.API     // Catch:{ all -> 0x0108 }
            java.lang.StringBuilder r8 = new java.lang.StringBuilder     // Catch:{ all -> 0x0108 }
            r8.<init>()     // Catch:{ all -> 0x0108 }
            r8.append(r5)     // Catch:{ all -> 0x0108 }
            java.lang.String r5 = " ad unit has started initializing."
            r8.append(r5)     // Catch:{ all -> 0x0108 }
            java.lang.String r5 = r8.toString()     // Catch:{ all -> 0x0108 }
            r8 = 3
            r6.log(r7, r5, r8)     // Catch:{ all -> 0x0108 }
        L_0x00a7:
            int r1 = r1 + 1
            goto L_0x006a
        L_0x00aa:
            if (r4 == 0) goto L_0x0106
            goto L_0x00fe
        L_0x00ad:
            com.ironsource.mediationsdk.s r0 = com.ironsource.mediationsdk.s.c()     // Catch:{ all -> 0x0108 }
            r0.b((boolean) r11)     // Catch:{ all -> 0x0108 }
            java.util.List<com.ironsource.mediationsdk.IronSource$AD_UNIT> r0 = r9.s     // Catch:{ all -> 0x0108 }
            if (r0 != 0) goto L_0x00ba
            monitor-exit(r9)
            return
        L_0x00ba:
            org.json.JSONObject r0 = com.ironsource.mediationsdk.utils.IronSourceUtils.getMediationAdditionalData(r11)     // Catch:{ all -> 0x0108 }
            int r2 = r12.length     // Catch:{ all -> 0x0108 }
            r4 = 0
            r5 = 0
        L_0x00c1:
            if (r4 >= r2) goto L_0x00fc
            r6 = r12[r4]     // Catch:{ all -> 0x0108 }
            java.util.Set<com.ironsource.mediationsdk.IronSource$AD_UNIT> r7 = r9.w     // Catch:{ all -> 0x0108 }
            boolean r7 = r7.contains(r6)     // Catch:{ all -> 0x0108 }
            if (r7 != 0) goto L_0x00f6
            java.util.Set<com.ironsource.mediationsdk.IronSource$AD_UNIT> r5 = r9.w     // Catch:{ all -> 0x0108 }
            r5.add(r6)     // Catch:{ all -> 0x0108 }
            java.util.Set<com.ironsource.mediationsdk.IronSource$AD_UNIT> r5 = r9.x     // Catch:{ all -> 0x0108 }
            r5.add(r6)     // Catch:{ all -> 0x0108 }
            java.lang.String r5 = r6.toString()     // Catch:{ Exception -> 0x00df }
            r0.put(r5, r3)     // Catch:{ Exception -> 0x00df }
            goto L_0x00e3
        L_0x00df:
            r5 = move-exception
            r5.printStackTrace()     // Catch:{ all -> 0x0108 }
        L_0x00e3:
            java.util.List<com.ironsource.mediationsdk.IronSource$AD_UNIT> r5 = r9.s     // Catch:{ all -> 0x0108 }
            if (r5 == 0) goto L_0x00f1
            boolean r5 = r5.contains(r6)     // Catch:{ all -> 0x0108 }
            if (r5 == 0) goto L_0x00f1
            r9.b((com.ironsource.mediationsdk.IronSource.AD_UNIT) r6)     // Catch:{ all -> 0x0108 }
            goto L_0x00f4
        L_0x00f1:
            r9.a((com.ironsource.mediationsdk.IronSource.AD_UNIT) r6, (boolean) r1)     // Catch:{ all -> 0x0108 }
        L_0x00f4:
            r5 = 1
            goto L_0x00f9
        L_0x00f6:
            r9.a((com.ironsource.mediationsdk.IronSource.AD_UNIT) r6)     // Catch:{ all -> 0x0108 }
        L_0x00f9:
            int r4 = r4 + 1
            goto L_0x00c1
        L_0x00fc:
            if (r5 == 0) goto L_0x0106
        L_0x00fe:
            int r12 = r9.B     // Catch:{ all -> 0x0108 }
            int r12 = r12 + r3
            r9.B = r12     // Catch:{ all -> 0x0108 }
            r9.a((boolean) r10, (boolean) r11, (int) r12, (org.json.JSONObject) r0)     // Catch:{ all -> 0x0108 }
        L_0x0106:
            monitor-exit(r9)
            return
        L_0x0108:
            r10 = move-exception
            monitor-exit(r9)
            throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ironsource.mediationsdk.p.a(boolean, boolean, com.ironsource.mediationsdk.IronSource$AD_UNIT[]):void");
    }

    private boolean a(h.b bVar) {
        if (s.c().a() != s.d.INIT_IN_PROGRESS) {
            return false;
        }
        synchronized (this.d0) {
            this.d0.put(bVar.b(), bVar);
        }
        return true;
    }

    private boolean a(String str, int i2, int i3) {
        return str != null && str.length() >= i2 && str.length() <= i3;
    }

    private void a0() {
        if (this.D) {
            Y();
            return;
        }
        boolean h2 = this.j.b().d().g().h();
        this.Y = h2;
        if (h2) {
            b0();
        } else {
            e0();
        }
    }

    private k b(List<NetworkSettings> list) {
        ua g2 = this.j.b().g();
        d3.a aVar = new d3.a("Mediation");
        if (g2.d()) {
            aVar.a("isOneFlow", 1);
        }
        return new k(list, g2, c.b(), this.p0, p(), q(), new d3.b(va.i(), aVar));
    }

    private void b(int i2, JSONObject jSONObject) {
        va.i().a(new y3(i2, jSONObject));
    }

    private void b(m0 m0Var, Context context, com.ironsource.mediationsdk.utils.c cVar) {
        va.i().a(m0Var.c(), context);
        va.i().b(m0Var.d(), context);
        va.i().b(m0Var.f());
        va.i().a(m0Var.e());
        va.i().c(m0Var.a());
        va.i().c(m0Var.i(), context);
        va.i().a(m0Var.h(), context);
        va.i().b(m0Var.j(), context);
        va.i().d(m0Var.g(), context);
        va.i().a(cVar.b().b().i());
        va.i().a(m0Var.k());
        va.i().d(m0Var.b());
    }

    private void b(IronSource.AD_UNIT ad_unit) {
        int i2 = b.a[ad_unit.ordinal()];
        if (i2 == 1) {
            f0();
        } else if (i2 == 2) {
            a0();
        } else if (i2 == 3) {
            this.d.a(p(), q());
        } else if (i2 == 4) {
            V();
        }
    }

    private void b(com.ironsource.mediationsdk.utils.c cVar, Context context) {
        a(cVar);
        a(cVar, context);
    }

    private void b(String str, f2 f2Var) {
        if (str != null) {
            try {
                if (str.length() > 64) {
                    f2Var.a(ErrorBuilder.buildInvalidKeyValueError("segment", IronSourceConstants.SUPERSONIC_CONFIG_NAME, "segment value should not exceed 64 characters."));
                }
            } catch (Exception unused) {
                f2Var.a(ErrorBuilder.buildInvalidKeyValueError("segment", IronSourceConstants.SUPERSONIC_CONFIG_NAME, "segment value should not exceed 64 characters."));
            }
        }
    }

    private boolean b(h.b bVar) {
        synchronized (this.d0) {
            if (this.h0 != null) {
                return false;
            }
            this.d0.put(bVar.b(), bVar);
            return true;
        }
    }

    private boolean b(com.ironsource.mediationsdk.utils.c cVar) {
        return cVar != null && cVar.l();
    }

    private void b0() {
        IronLog.INTERNAL.verbose();
        List<NetworkSettings> a2 = a(this.j.h().b());
        if (a2.size() > 0) {
            j7 j7Var = new j7(a2, this.j.b().d(), IronSourceUtils.getUserIdForNetworks(), k8.b(), this.z, this.j.k());
            this.Q = j7Var;
            Boolean bool = this.v;
            if (bool != null) {
                j7Var.a(this.u, bool.booleanValue());
            }
            if (this.Z) {
                this.Z = false;
                this.Q.w();
                return;
            }
            return;
        }
        JSONObject mediationAdditionalData = IronSourceUtils.getMediationAdditionalData(false, true, 1);
        a(mediationAdditionalData, new Object[][]{new Object[]{"errorCode", 1010}});
        a((int) IronSourceConstants.TROUBLESHOOTING_IS_INIT_FAILED, mediationAdditionalData);
        a(IronSource.AD_UNIT.INTERSTITIAL, false);
    }

    private com.ironsource.mediationsdk.utils.c c(Context context) {
        com.ironsource.mediationsdk.utils.c cVar = this.j;
        return cVar != null ? cVar : f7.b(context);
    }

    private void c0() {
        this.e.log(IronSourceLogger.IronSourceTag.INTERNAL, "Rewarded Video started in programmatic mode", 0);
        List<NetworkSettings> a2 = a(this.j.h().d());
        if (a2.size() > 0) {
            q qVar = new q(a2, this.j.b().g(), p(), IronSourceUtils.getUserIdForNetworks(), k8.b().a(), this.z);
            this.N = qVar;
            Boolean bool = this.v;
            if (bool != null) {
                qVar.a(this.u, bool.booleanValue());
                return;
            }
            return;
        }
        JSONObject mediationAdditionalData = IronSourceUtils.getMediationAdditionalData(false, true, this.b0);
        a(mediationAdditionalData, new Object[][]{new Object[]{"errorCode", 1010}});
        b((int) IronSourceConstants.TROUBLESHOOTING_RV_INIT_FAILED, mediationAdditionalData);
        a(IronSource.AD_UNIT.REWARDED_VIDEO, false);
    }

    private void d(Activity activity, String str) {
        try {
            InterstitialPlacement n2 = n(str);
            if (n2 == null) {
                n2 = l();
            }
            if (n2 == null) {
                this.e.log(IronSourceLogger.IronSourceTag.INTERNAL, "showProgrammaticInterstitial error: empty default placement in response", 3);
                u5.a().a(new IronSourceError(1020, "showProgrammaticInterstitial error: empty default placement in response"), (AdInfo) null);
                return;
            }
            if (activity != null) {
                e(activity);
            } else if (ContextProvider.getInstance().getCurrentActiveActivity() == null) {
                this.e.log(IronSourceLogger.IronSourceTag.API, "Activity must be provided in showInterstitial when initializing SDK with context", 3);
                u5.a().a(new IronSourceError(510, "Activity must be provided in showInterstitial when initializing SDK with context"), (AdInfo) null);
                return;
            }
            if (this.Y) {
                this.Q.a(activity, new Placement(n2));
            } else {
                this.O.a(activity, n2.getPlacementName());
            }
        } catch (Exception e2) {
            this.e.logException(IronSourceLogger.IronSourceTag.API, "showProgrammaticInterstitial()", e2);
        }
    }

    private void d0() {
        IronLog.INTERNAL.verbose();
        List<NetworkSettings> a2 = a(this.j.h().a());
        if (a2.size() > 0) {
            this.e.log(IronSourceLogger.IronSourceTag.INTERNAL, "Banner started in programmatic mode", 0);
            this.P = new w(a2, new k(p(), IronSourceUtils.getUserIdForNetworks(), this.j.b().c()), k8.b().a(), this.z);
            u();
            return;
        }
        JSONObject mediationAdditionalData = IronSourceUtils.getMediationAdditionalData(false, true, 1);
        a(mediationAdditionalData, new Object[][]{new Object[]{"errorCode", 1010}});
        a((int) IronSourceConstants.TROUBLESHOOTING_BN_INIT_FAILED, mediationAdditionalData);
        a(IronSource.AD_UNIT.BANNER, false);
    }

    private void e(Activity activity) {
        ContextProvider.getInstance().updateActivity(activity);
        IronLog ironLog = IronLog.INTERNAL;
        ironLog.verbose("activity is updated to: " + activity.hashCode());
    }

    /* JADX WARNING: Removed duplicated region for block: B:15:0x0036  */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x003a  */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x0067  */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x006b  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void e(android.app.Activity r7, java.lang.String r8) {
        /*
            r6 = this;
            r0 = 3
            r1 = 0
            com.ironsource.mediationsdk.model.Placement r8 = r6.r(r8)     // Catch:{ Exception -> 0x0029 }
            if (r8 != 0) goto L_0x000f
            com.ironsource.mediationsdk.model.Placement r8 = r6.m()     // Catch:{ Exception -> 0x000d }
            goto L_0x000f
        L_0x000d:
            r2 = move-exception
            goto L_0x002b
        L_0x000f:
            if (r8 != 0) goto L_0x0034
            java.lang.String r2 = "showProgrammaticRewardedVideo error: empty default placement in response"
            com.ironsource.mediationsdk.logger.IronSourceLoggerManager r3 = r6.e     // Catch:{ Exception -> 0x000d }
            com.ironsource.mediationsdk.logger.IronSourceLogger$IronSourceTag r4 = com.ironsource.mediationsdk.logger.IronSourceLogger.IronSourceTag.INTERNAL     // Catch:{ Exception -> 0x000d }
            r3.log(r4, r2, r0)     // Catch:{ Exception -> 0x000d }
            com.ironsource.mediationsdk.logger.IronSourceError r3 = new com.ironsource.mediationsdk.logger.IronSourceError     // Catch:{ Exception -> 0x000d }
            r4 = 1021(0x3fd, float:1.431E-42)
            r3.<init>(r4, r2)     // Catch:{ Exception -> 0x000d }
            com.ironsource.oa r2 = com.ironsource.oa.a()     // Catch:{ Exception -> 0x000d }
            r2.a((com.ironsource.mediationsdk.logger.IronSourceError) r3, (com.ironsource.mediationsdk.adunit.adapter.utility.AdInfo) r1)     // Catch:{ Exception -> 0x000d }
            return
        L_0x0029:
            r2 = move-exception
            r8 = r1
        L_0x002b:
            com.ironsource.mediationsdk.logger.IronSourceLoggerManager r3 = r6.e
            com.ironsource.mediationsdk.logger.IronSourceLogger$IronSourceTag r4 = com.ironsource.mediationsdk.logger.IronSourceLogger.IronSourceTag.API
            java.lang.String r5 = "showProgrammaticRewardedVideo()"
            r3.logException(r4, r5, r2)
        L_0x0034:
            if (r7 == 0) goto L_0x003a
            r6.e((android.app.Activity) r7)
            goto L_0x005b
        L_0x003a:
            com.ironsource.environment.ContextProvider r2 = com.ironsource.environment.ContextProvider.getInstance()
            android.app.Activity r2 = r2.getCurrentActiveActivity()
            if (r2 != 0) goto L_0x005b
            com.ironsource.mediationsdk.logger.IronSourceLoggerManager r7 = r6.e
            com.ironsource.mediationsdk.logger.IronSourceLogger$IronSourceTag r8 = com.ironsource.mediationsdk.logger.IronSourceLogger.IronSourceTag.API
            java.lang.String r2 = "Activity must be provided in showRewardedVideo when initializing SDK with context"
            r7.log(r8, r2, r0)
            com.ironsource.oa r7 = com.ironsource.oa.a()
            java.lang.String r8 = "Rewarded Video"
            com.ironsource.mediationsdk.logger.IronSourceError r8 = com.ironsource.mediationsdk.utils.ErrorBuilder.buildInitFailedError(r2, r8)
            r7.a((com.ironsource.mediationsdk.logger.IronSourceError) r8, (com.ironsource.mediationsdk.adunit.adapter.utility.AdInfo) r1)
            return
        L_0x005b:
            com.ironsource.sa r2 = r6.R
            if (r2 == 0) goto L_0x006b
            boolean r3 = r6.V
            if (r3 != 0) goto L_0x0067
            boolean r3 = r6.X
            if (r3 == 0) goto L_0x006b
        L_0x0067:
            r2.a((android.app.Activity) r7, (com.ironsource.mediationsdk.model.Placement) r8)
            goto L_0x008a
        L_0x006b:
            com.ironsource.k5 r2 = r6.N
            if (r2 == 0) goto L_0x0073
            r2.a((android.app.Activity) r7, (com.ironsource.mediationsdk.model.Placement) r8)
            goto L_0x008a
        L_0x0073:
            com.ironsource.mediationsdk.logger.IronSourceLoggerManager r7 = r6.e
            com.ironsource.mediationsdk.logger.IronSourceLogger$IronSourceTag r8 = com.ironsource.mediationsdk.logger.IronSourceLogger.IronSourceTag.API
            java.lang.String r2 = "showProgrammaticRewardedVideo - show called before init completed, managers not initiated yet"
            r7.log(r8, r2, r0)
            com.ironsource.mediationsdk.logger.IronSourceError r7 = new com.ironsource.mediationsdk.logger.IronSourceError
            r8 = 1023(0x3ff, float:1.434E-42)
            r7.<init>(r8, r2)
            com.ironsource.oa r8 = com.ironsource.oa.a()
            r8.a((com.ironsource.mediationsdk.logger.IronSourceError) r7, (com.ironsource.mediationsdk.adunit.adapter.utility.AdInfo) r1)
        L_0x008a:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ironsource.mediationsdk.p.e(android.app.Activity, java.lang.String):void");
    }

    private void e(Context context) {
        AtomicBoolean atomicBoolean = this.h;
        if (atomicBoolean != null && atomicBoolean.compareAndSet(false, true)) {
            pb.a().a(new r4(context));
            n7.i().a(context, this.z);
            va.i().a(context, this.z);
            da.P.a(context, this.z);
        }
    }

    private void e0() {
        this.e.log(IronSourceLogger.IronSourceTag.INTERNAL, "Adunit: Interstitial is now initiated - programmatic mode", 0);
        List<NetworkSettings> a2 = a(this.j.h().b());
        if (a2.size() > 0) {
            y yVar = new y(a2, this.j.b().d(), p(), IronSourceUtils.getUserIdForNetworks(), this.j.b().d().b(), k8.b().a(), this.z);
            this.O = yVar;
            Boolean bool = this.v;
            if (bool != null) {
                yVar.a(this.u, bool.booleanValue());
            }
            if (this.Z) {
                this.Z = false;
                this.O.i();
                return;
            }
            return;
        }
        JSONObject mediationAdditionalData = IronSourceUtils.getMediationAdditionalData(false, true, 1);
        a(mediationAdditionalData, new Object[][]{new Object[]{"errorCode", 1010}});
        a((int) IronSourceConstants.TROUBLESHOOTING_IS_INIT_FAILED, mediationAdditionalData);
        a(IronSource.AD_UNIT.INTERSTITIAL, false);
    }

    private void f(Context context) {
        this.j0.a(context);
        this.j0.e(IronSourceUtils.getSDKVersion());
        this.j0.g(this.t);
        this.j0.f(ConfigFile.getConfigFile().getPluginType());
        this.j0.a(l5.a());
        this.j0.b(IronSourceUtils.isGooglePlayInstalled(context));
        this.j0.a(o.a());
    }

    private void f0() {
        if (this.C) {
            Z();
            return;
        }
        ua g2 = this.j.b().g();
        this.X = g2.k().h();
        this.b0 = a(g2);
        if (this.V || this.X) {
            g0();
        } else {
            c0();
        }
    }

    private void g() {
        Context applicationContext = ContextProvider.getInstance().getApplicationContext();
        boolean isInitResponseCached = IronSourceUtils.isInitResponseCached(applicationContext);
        long firstSessionTimestamp = IronSourceUtils.getFirstSessionTimestamp(applicationContext);
        if (!isInitResponseCached && firstSessionTimestamp == -1) {
            long currentTimeMillis = System.currentTimeMillis();
            IronLog ironLog = IronLog.INTERNAL;
            ironLog.verbose("get first session timestamp = " + currentTimeMillis);
            IronSourceUtils.saveFirstSessionTimestamp(applicationContext, currentTimeMillis);
        }
    }

    private void g0() {
        IronLog.INTERNAL.verbose();
        List<NetworkSettings> a2 = a(this.j.h().d());
        if (a2.size() > 0) {
            sa saVar = new sa(a2, this.j.b().g(), IronSourceUtils.getUserIdForNetworks(), this.V, k8.b(), this.z, this.j.k());
            this.R = saVar;
            Boolean bool = this.v;
            if (bool != null) {
                saVar.a(this.u, bool.booleanValue());
            }
            if (this.W && this.V) {
                this.W = false;
                this.R.w();
                return;
            }
            return;
        }
        JSONObject mediationAdditionalData = IronSourceUtils.getMediationAdditionalData(false, true, this.b0);
        a(mediationAdditionalData, new Object[][]{new Object[]{"errorCode", 1010}});
        b((int) IronSourceConstants.TROUBLESHOOTING_RV_INIT_FAILED, mediationAdditionalData);
        a(IronSource.AD_UNIT.REWARDED_VIDEO, false);
    }

    private m1 l(String str) {
        k1 c2 = this.j.b().c();
        if (c2 == null) {
            return new t3();
        }
        if (TextUtils.isEmpty(str)) {
            return c2.j();
        }
        m1 a2 = c2.a(str);
        return a2 != null ? a2 : c2.j();
    }

    private InterstitialPlacement l() {
        m7 d2 = this.j.b().d();
        if (d2 != null) {
            return d2.a();
        }
        return null;
    }

    private Placement m() {
        ua g2 = this.j.b().g();
        if (g2 != null) {
            return g2.a();
        }
        return null;
    }

    /* JADX WARNING: Removed duplicated region for block: B:18:0x0037  */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x003a  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private com.ironsource.mediationsdk.utils.b.C0017b m(java.lang.String r5) {
        /*
            r4 = this;
            com.ironsource.mediationsdk.utils.c r0 = r4.j
            if (r0 == 0) goto L_0x0047
            com.ironsource.g2 r0 = r0.b()
            if (r0 == 0) goto L_0x0047
            com.ironsource.mediationsdk.utils.c r0 = r4.j
            com.ironsource.g2 r0 = r0.b()
            com.ironsource.m7 r0 = r0.d()
            if (r0 != 0) goto L_0x0017
            goto L_0x0047
        L_0x0017:
            com.ironsource.mediationsdk.model.InterstitialPlacement r5 = r4.n(r5)     // Catch:{ Exception -> 0x0030 }
            if (r5 != 0) goto L_0x0035
            com.ironsource.mediationsdk.model.InterstitialPlacement r5 = r4.l()     // Catch:{ Exception -> 0x002e }
            if (r5 != 0) goto L_0x0035
            java.lang.String r0 = "Default placement was not found"
            com.ironsource.mediationsdk.logger.IronSourceLoggerManager r1 = r4.e     // Catch:{ Exception -> 0x002e }
            com.ironsource.mediationsdk.logger.IronSourceLogger$IronSourceTag r2 = com.ironsource.mediationsdk.logger.IronSourceLogger.IronSourceTag.API     // Catch:{ Exception -> 0x002e }
            r3 = 3
            r1.log(r2, r0, r3)     // Catch:{ Exception -> 0x002e }
            goto L_0x0035
        L_0x002e:
            r0 = move-exception
            goto L_0x0032
        L_0x0030:
            r0 = move-exception
            r5 = 0
        L_0x0032:
            r0.printStackTrace()
        L_0x0035:
            if (r5 != 0) goto L_0x003a
            com.ironsource.mediationsdk.utils.b$b r5 = com.ironsource.mediationsdk.utils.b.C0017b.NOT_CAPPED
            return r5
        L_0x003a:
            com.ironsource.environment.ContextProvider r0 = com.ironsource.environment.ContextProvider.getInstance()
            android.content.Context r0 = r0.getApplicationContext()
            com.ironsource.mediationsdk.utils.b$b r5 = com.ironsource.mediationsdk.utils.b.c((android.content.Context) r0, (com.ironsource.mediationsdk.model.InterstitialPlacement) r5)
            return r5
        L_0x0047:
            com.ironsource.mediationsdk.utils.b$b r5 = com.ironsource.mediationsdk.utils.b.C0017b.NOT_CAPPED
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ironsource.mediationsdk.p.m(java.lang.String):com.ironsource.mediationsdk.utils.b$b");
    }

    private InterstitialPlacement n(String str) {
        m7 d2 = this.j.b().d();
        if (d2 != null) {
            return d2.a(str);
        }
        return null;
    }

    public static p o() {
        return d.a;
    }

    /* JADX WARNING: Removed duplicated region for block: B:18:0x0037  */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x003a  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private com.ironsource.mediationsdk.utils.b.C0017b q(java.lang.String r5) {
        /*
            r4 = this;
            com.ironsource.mediationsdk.utils.c r0 = r4.j
            if (r0 == 0) goto L_0x0047
            com.ironsource.g2 r0 = r0.b()
            if (r0 == 0) goto L_0x0047
            com.ironsource.mediationsdk.utils.c r0 = r4.j
            com.ironsource.g2 r0 = r0.b()
            com.ironsource.ua r0 = r0.g()
            if (r0 != 0) goto L_0x0017
            goto L_0x0047
        L_0x0017:
            com.ironsource.mediationsdk.model.Placement r5 = r4.r(r5)     // Catch:{ Exception -> 0x0030 }
            if (r5 != 0) goto L_0x0035
            com.ironsource.mediationsdk.model.Placement r5 = r4.m()     // Catch:{ Exception -> 0x002e }
            if (r5 != 0) goto L_0x0035
            java.lang.String r0 = "Default placement was not found"
            com.ironsource.mediationsdk.logger.IronSourceLoggerManager r1 = r4.e     // Catch:{ Exception -> 0x002e }
            com.ironsource.mediationsdk.logger.IronSourceLogger$IronSourceTag r2 = com.ironsource.mediationsdk.logger.IronSourceLogger.IronSourceTag.API     // Catch:{ Exception -> 0x002e }
            r3 = 3
            r1.log(r2, r0, r3)     // Catch:{ Exception -> 0x002e }
            goto L_0x0035
        L_0x002e:
            r0 = move-exception
            goto L_0x0032
        L_0x0030:
            r0 = move-exception
            r5 = 0
        L_0x0032:
            r0.printStackTrace()
        L_0x0035:
            if (r5 != 0) goto L_0x003a
            com.ironsource.mediationsdk.utils.b$b r5 = com.ironsource.mediationsdk.utils.b.C0017b.NOT_CAPPED
            return r5
        L_0x003a:
            com.ironsource.environment.ContextProvider r0 = com.ironsource.environment.ContextProvider.getInstance()
            android.content.Context r0 = r0.getApplicationContext()
            com.ironsource.mediationsdk.utils.b$b r5 = com.ironsource.mediationsdk.utils.b.c((android.content.Context) r0, (com.ironsource.mediationsdk.model.Placement) r5)
            return r5
        L_0x0047:
            com.ironsource.mediationsdk.utils.b$b r5 = com.ironsource.mediationsdk.utils.b.C0017b.NOT_CAPPED
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ironsource.mediationsdk.p.q(java.lang.String):com.ironsource.mediationsdk.utils.b$b");
    }

    private Placement r(String str) {
        ua g2 = this.j.b().g();
        if (g2 != null) {
            return g2.a(str);
        }
        return null;
    }

    private void u() {
        if (this.J.booleanValue()) {
            IronLog.INTERNAL.verbose("load banner after init");
            this.J = Boolean.FALSE;
            a(this.K, this.L);
            this.K = null;
            this.L = null;
        }
    }

    private void v() {
        this.e = IronSourceLoggerManager.getLogger(0);
        com.ironsource.mediationsdk.logger.b bVar = new com.ironsource.mediationsdk.logger.b((LogListener) null, 1);
        this.g = bVar;
        this.e.addLogger(bVar);
        this.f = new q8();
        v vVar = new v();
        this.d = vVar;
        vVar.setInternalOfferwallListener(this.f);
    }

    private boolean w() {
        try {
            Class<?> cls = Class.forName("com.ironsource.adqualitysdk.sdk.IronSourceAdQuality");
            IronLog ironLog = IronLog.INTERNAL;
            ironLog.verbose("AdQuality SDK exist: " + cls.getName());
            return true;
        } catch (Throwable unused) {
            IronLog.INTERNAL.verbose("No AdQuality SDK found");
            return false;
        }
    }

    private boolean w(String str) {
        if (str == null) {
            return false;
        }
        return str.matches("^[a-zA-Z0-9]*$");
    }

    private f2 x(String str) {
        IronSourceError ironSourceError;
        String str2;
        f2 f2Var = new f2();
        if (str != null) {
            if (a(str, 5, 10)) {
                if (!w(str)) {
                    str2 = "should contain only english characters and numbers";
                }
                return f2Var;
            }
            str2 = "length should be between 5-10 characters";
            ironSourceError = ErrorBuilder.buildInvalidCredentialsError("appKey", str, str2);
        } else {
            ironSourceError = new IronSourceError(IronSourceError.ERROR_CODE_INVALID_KEY_VALUE, "Init Fail - appKey is missing");
        }
        f2Var.a(ironSourceError);
        return f2Var;
    }

    private boolean x() {
        com.ironsource.mediationsdk.utils.c cVar = this.j;
        return (cVar == null || cVar.b() == null || this.j.b().c() == null) ? false : true;
    }

    private boolean y() {
        return x() && z();
    }

    private boolean z() {
        com.ironsource.mediationsdk.utils.c cVar = this.j;
        return (cVar == null || cVar.h() == null || this.j.h().a() == null || this.j.h().a().size() <= 0) ? false : true;
    }

    /* access modifiers changed from: package-private */
    public boolean A() {
        return this.C || this.D || this.E;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:16:0x002a, code lost:
        if (r3.h() != false) goto L_0x002c;
     */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x0037 A[Catch:{ all -> 0x005b }] */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x003a A[Catch:{ all -> 0x005b }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean D() {
        /*
            r9 = this;
            java.lang.String r0 = "isInterstitialReady():"
            r1 = 1
            r2 = 0
            boolean r3 = r9.D     // Catch:{ all -> 0x0060 }
            if (r3 == 0) goto L_0x0013
            com.ironsource.mediationsdk.logger.IronSourceLoggerManager r3 = r9.e     // Catch:{ all -> 0x0060 }
            com.ironsource.mediationsdk.logger.IronSourceLogger$IronSourceTag r4 = com.ironsource.mediationsdk.logger.IronSourceLogger.IronSourceTag.API     // Catch:{ all -> 0x0060 }
            java.lang.String r5 = "Interstitial was initialized in demand only mode. Use isISDemandOnlyInterstitialReady instead"
            r6 = 3
            r3.log(r4, r5, r6)     // Catch:{ all -> 0x0060 }
            return r2
        L_0x0013:
            boolean r3 = r9.Y     // Catch:{ all -> 0x0060 }
            if (r3 == 0) goto L_0x0022
            com.ironsource.j7 r3 = r9.Q     // Catch:{ all -> 0x0060 }
            if (r3 == 0) goto L_0x002e
            boolean r3 = r3.q()     // Catch:{ all -> 0x0060 }
            if (r3 == 0) goto L_0x002e
            goto L_0x002c
        L_0x0022:
            com.ironsource.mediationsdk.y r3 = r9.O     // Catch:{ all -> 0x0060 }
            if (r3 == 0) goto L_0x002e
            boolean r3 = r3.h()     // Catch:{ all -> 0x0060 }
            if (r3 == 0) goto L_0x002e
        L_0x002c:
            r3 = 1
            goto L_0x002f
        L_0x002e:
            r3 = 0
        L_0x002f:
            org.json.JSONObject r4 = com.ironsource.mediationsdk.utils.IronSourceUtils.getMediationAdditionalData(r2, r1, r1)     // Catch:{ all -> 0x005b }
            com.ironsource.y3 r5 = new com.ironsource.y3     // Catch:{ all -> 0x005b }
            if (r3 == 0) goto L_0x003a
            r6 = 2101(0x835, float:2.944E-42)
            goto L_0x003c
        L_0x003a:
            r6 = 2102(0x836, float:2.946E-42)
        L_0x003c:
            r5.<init>(r6, r4)     // Catch:{ all -> 0x005b }
            com.ironsource.n7 r4 = com.ironsource.n7.i()     // Catch:{ all -> 0x005b }
            r4.a((com.ironsource.y3) r5)     // Catch:{ all -> 0x005b }
            com.ironsource.mediationsdk.logger.IronSourceLoggerManager r4 = r9.e     // Catch:{ all -> 0x005b }
            com.ironsource.mediationsdk.logger.IronSourceLogger$IronSourceTag r5 = com.ironsource.mediationsdk.logger.IronSourceLogger.IronSourceTag.API     // Catch:{ all -> 0x005b }
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch:{ all -> 0x005b }
            r6.<init>(r0)     // Catch:{ all -> 0x005b }
            r6.append(r3)     // Catch:{ all -> 0x005b }
            java.lang.String r6 = r6.toString()     // Catch:{ all -> 0x005b }
            r4.log(r5, r6, r1)     // Catch:{ all -> 0x005b }
            r2 = r3
            goto L_0x007c
        L_0x005b:
            r4 = move-exception
            r8 = r4
            r4 = r3
            r3 = r8
            goto L_0x0062
        L_0x0060:
            r3 = move-exception
            r4 = 0
        L_0x0062:
            com.ironsource.mediationsdk.logger.IronSourceLoggerManager r5 = r9.e
            com.ironsource.mediationsdk.logger.IronSourceLogger$IronSourceTag r6 = com.ironsource.mediationsdk.logger.IronSourceLogger.IronSourceTag.API
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            r7.<init>(r0)
            r7.append(r4)
            java.lang.String r0 = r7.toString()
            r5.log(r6, r0, r1)
            com.ironsource.mediationsdk.logger.IronSourceLoggerManager r0 = r9.e
            java.lang.String r1 = "isInterstitialReady()"
            r0.logException(r6, r1, r3)
        L_0x007c:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ironsource.mediationsdk.p.D():boolean");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:19:0x002f, code lost:
        if (r3.q() != false) goto L_0x0031;
     */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x0052 A[Catch:{ all -> 0x0076 }] */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x0055 A[Catch:{ all -> 0x0076 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean J() {
        /*
            r9 = this;
            java.lang.String r0 = "isRewardedVideoAvailable():"
            r1 = 1
            r2 = 0
            boolean r3 = r9.C     // Catch:{ all -> 0x007b }
            if (r3 == 0) goto L_0x0013
            com.ironsource.mediationsdk.logger.IronSourceLoggerManager r3 = r9.e     // Catch:{ all -> 0x007b }
            com.ironsource.mediationsdk.logger.IronSourceLogger$IronSourceTag r4 = com.ironsource.mediationsdk.logger.IronSourceLogger.IronSourceTag.API     // Catch:{ all -> 0x007b }
            java.lang.String r5 = "Rewarded Video was initialized in demand only mode. Use isISDemandOnlyRewardedVideoAvailable instead"
            r6 = 3
            r3.log(r4, r5, r6)     // Catch:{ all -> 0x007b }
            return r2
        L_0x0013:
            boolean r3 = r9.V     // Catch:{ all -> 0x007b }
            if (r3 != 0) goto L_0x0027
            boolean r3 = r9.X     // Catch:{ all -> 0x007b }
            if (r3 == 0) goto L_0x001c
            goto L_0x0027
        L_0x001c:
            com.ironsource.k5 r3 = r9.N     // Catch:{ all -> 0x007b }
            if (r3 == 0) goto L_0x0033
            boolean r3 = r3.d()     // Catch:{ all -> 0x007b }
            if (r3 == 0) goto L_0x0033
            goto L_0x0031
        L_0x0027:
            com.ironsource.sa r3 = r9.R     // Catch:{ all -> 0x007b }
            if (r3 == 0) goto L_0x0033
            boolean r3 = r3.q()     // Catch:{ all -> 0x007b }
            if (r3 == 0) goto L_0x0033
        L_0x0031:
            r3 = 1
            goto L_0x0034
        L_0x0033:
            r3 = 0
        L_0x0034:
            org.json.JSONObject r4 = com.ironsource.mediationsdk.utils.IronSourceUtils.getMediationAdditionalData(r2)     // Catch:{ all -> 0x0076 }
            java.lang.Object[][] r5 = new java.lang.Object[r1][]     // Catch:{ all -> 0x0076 }
            r6 = 2
            java.lang.Object[] r6 = new java.lang.Object[r6]     // Catch:{ all -> 0x0076 }
            java.lang.String r7 = "programmatic"
            r6[r2] = r7     // Catch:{ all -> 0x0076 }
            int r7 = r9.b0     // Catch:{ all -> 0x0076 }
            java.lang.Integer r7 = java.lang.Integer.valueOf(r7)     // Catch:{ all -> 0x0076 }
            r6[r1] = r7     // Catch:{ all -> 0x0076 }
            r5[r2] = r6     // Catch:{ all -> 0x0076 }
            r9.a((org.json.JSONObject) r4, (java.lang.Object[][]) r5)     // Catch:{ all -> 0x0076 }
            com.ironsource.y3 r5 = new com.ironsource.y3     // Catch:{ all -> 0x0076 }
            if (r3 == 0) goto L_0x0055
            r6 = 1101(0x44d, float:1.543E-42)
            goto L_0x0057
        L_0x0055:
            r6 = 1102(0x44e, float:1.544E-42)
        L_0x0057:
            r5.<init>(r6, r4)     // Catch:{ all -> 0x0076 }
            com.ironsource.va r4 = com.ironsource.va.i()     // Catch:{ all -> 0x0076 }
            r4.a((com.ironsource.y3) r5)     // Catch:{ all -> 0x0076 }
            com.ironsource.mediationsdk.logger.IronSourceLoggerManager r4 = r9.e     // Catch:{ all -> 0x0076 }
            com.ironsource.mediationsdk.logger.IronSourceLogger$IronSourceTag r5 = com.ironsource.mediationsdk.logger.IronSourceLogger.IronSourceTag.API     // Catch:{ all -> 0x0076 }
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch:{ all -> 0x0076 }
            r6.<init>(r0)     // Catch:{ all -> 0x0076 }
            r6.append(r3)     // Catch:{ all -> 0x0076 }
            java.lang.String r6 = r6.toString()     // Catch:{ all -> 0x0076 }
            r4.log(r5, r6, r1)     // Catch:{ all -> 0x0076 }
            r2 = r3
            goto L_0x0097
        L_0x0076:
            r4 = move-exception
            r8 = r4
            r4 = r3
            r3 = r8
            goto L_0x007d
        L_0x007b:
            r3 = move-exception
            r4 = 0
        L_0x007d:
            com.ironsource.mediationsdk.logger.IronSourceLoggerManager r5 = r9.e
            com.ironsource.mediationsdk.logger.IronSourceLogger$IronSourceTag r6 = com.ironsource.mediationsdk.logger.IronSourceLogger.IronSourceTag.API
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            r7.<init>(r0)
            r7.append(r4)
            java.lang.String r0 = r7.toString()
            r5.log(r6, r0, r1)
            com.ironsource.mediationsdk.logger.IronSourceLoggerManager r0 = r9.e
            java.lang.String r1 = "isRewardedVideoAvailable()"
            r0.logException(r6, r1, r3)
        L_0x0097:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ironsource.mediationsdk.p.J():boolean");
    }

    public void N() {
        IronSourceLoggerManager ironSourceLoggerManager = this.e;
        IronSourceLogger.IronSourceTag ironSourceTag = IronSourceLogger.IronSourceTag.API;
        ironSourceLoggerManager.log(ironSourceTag, "loadInterstitial()", 1);
        try {
            if (this.D) {
                this.e.log(ironSourceTag, "Interstitial was initialized in demand only mode. Use loadISDemandOnlyInterstitial instead", 3);
                n.a().a(IronSource.AD_UNIT.INTERSTITIAL, ErrorBuilder.buildInitFailedError("Interstitial was initialized in demand only mode. Use loadISDemandOnlyInterstitial instead", "Interstitial"));
            } else if (!this.G) {
                this.e.log(ironSourceTag, "init() must be called before loadInterstitial()", 3);
                n.a().a(IronSource.AD_UNIT.INTERSTITIAL, ErrorBuilder.buildInitFailedError("init() must be called before loadInterstitial()", "Interstitial"));
            } else {
                s.d a2 = s.c().a();
                if (a2 == s.d.INIT_FAILED) {
                    this.e.log(ironSourceTag, "init() had failed", 3);
                    n.a().a(IronSource.AD_UNIT.INTERSTITIAL, ErrorBuilder.buildInitFailedError("init() had failed", "Interstitial"));
                } else if (a2 == s.d.INIT_IN_PROGRESS) {
                    if (s.c().d()) {
                        this.e.log(ironSourceTag, "init() had failed", 3);
                        n.a().a(IronSource.AD_UNIT.INTERSTITIAL, ErrorBuilder.buildInitFailedError("init() had failed", "Interstitial"));
                        return;
                    }
                    this.Z = true;
                } else if (!C()) {
                    this.e.log(ironSourceTag, "No interstitial configurations found", 3);
                    n.a().a(IronSource.AD_UNIT.INTERSTITIAL, ErrorBuilder.buildInitFailedError("the server response does not contain interstitial data", "Interstitial"));
                } else {
                    if (this.Y) {
                        j7 j7Var = this.Q;
                        if (j7Var != null) {
                            j7Var.w();
                            return;
                        }
                    } else {
                        y yVar = this.O;
                        if (yVar != null) {
                            yVar.i();
                            return;
                        }
                    }
                    this.Z = true;
                }
            }
        } catch (Throwable th) {
            this.e.logException(IronSourceLogger.IronSourceTag.API, "loadInterstitial()", th);
            n.a().a(IronSource.AD_UNIT.INTERSTITIAL, new IronSourceError(510, th.getMessage()));
        }
    }

    public void O() {
        IronSourceLoggerManager ironSourceLoggerManager = this.e;
        IronSourceLogger.IronSourceTag ironSourceTag = IronSourceLogger.IronSourceTag.API;
        ironSourceLoggerManager.log(ironSourceTag, "loadRewardedVideo()", 1);
        try {
            if (this.C) {
                this.e.log(ironSourceTag, "Rewarded Video was initialized in demand only mode. Use loadISDemandOnlyRewardedVideo instead", 3);
                n.a().a(IronSource.AD_UNIT.REWARDED_VIDEO, ErrorBuilder.buildInitFailedError("Rewarded Video was initialized in demand only mode. Use loadISDemandOnlyRewardedVideo instead", IronSourceConstants.REWARDED_VIDEO_AD_UNIT));
            } else if (!this.V && !this.l0) {
                this.e.log(ironSourceTag, "Rewarded Video is not initiated with manual load", 3);
            } else if (!this.F) {
                this.e.log(ironSourceTag, "init() must be called before loadRewardedVideo()", 3);
                n.a().a(IronSource.AD_UNIT.REWARDED_VIDEO, ErrorBuilder.buildInitFailedError("init() must be called before loadRewardedVideo()", IronSourceConstants.REWARDED_VIDEO_AD_UNIT));
            } else {
                s.d a2 = s.c().a();
                if (a2 == s.d.INIT_FAILED) {
                    this.e.log(ironSourceTag, "init() had failed", 3);
                    n.a().a(IronSource.AD_UNIT.REWARDED_VIDEO, ErrorBuilder.buildInitFailedError("init() had failed", IronSourceConstants.REWARDED_VIDEO_AD_UNIT));
                } else if (a2 == s.d.INIT_IN_PROGRESS) {
                    if (s.c().d()) {
                        this.e.log(ironSourceTag, "init() had failed", 3);
                        n.a().a(IronSource.AD_UNIT.REWARDED_VIDEO, ErrorBuilder.buildInitFailedError("init() had failed", IronSourceConstants.REWARDED_VIDEO_AD_UNIT));
                        return;
                    }
                    this.W = true;
                } else if (!L()) {
                    this.e.log(ironSourceTag, "No rewarded video configurations found", 3);
                    n.a().a(IronSource.AD_UNIT.REWARDED_VIDEO, ErrorBuilder.buildInitFailedError("the server response does not contain rewarded video data", IronSourceConstants.REWARDED_VIDEO_AD_UNIT));
                } else {
                    sa saVar = this.R;
                    if (saVar == null) {
                        this.W = true;
                    } else {
                        saVar.w();
                    }
                }
            }
        } catch (Throwable th) {
            this.e.logException(IronSourceLogger.IronSourceTag.API, "loadRewardedVideo()", th);
            n.a().a(IronSource.AD_UNIT.REWARDED_VIDEO, new IronSourceError(510, th.getMessage()));
        }
    }

    public void P() {
        j7 j7Var = this.Q;
        if (j7Var != null) {
            j7Var.a((wb) null);
        }
        sa saVar = this.R;
        if (saVar != null) {
            saVar.a((wb) null);
        }
        h1 h1Var = this.S;
        if (h1Var != null) {
            h1Var.a((wb) null);
        }
        this.l0 = false;
    }

    public void Q() {
        IronLog.API.info("removing all impression data listeners");
        k8.b().d();
        k5 k5Var = this.N;
        if (k5Var != null) {
            k5Var.c();
        }
        y yVar = this.O;
        if (yVar != null) {
            yVar.c();
        }
        w wVar = this.P;
        if (wVar != null) {
            wVar.c();
        }
    }

    public ISDemandOnlyBannerLayout a(Activity activity, ISBannerSize iSBannerSize) {
        IronSourceLoggerManager ironSourceLoggerManager = this.e;
        IronSourceLogger.IronSourceTag ironSourceTag = IronSourceLogger.IronSourceTag.API;
        ironSourceLoggerManager.log(ironSourceTag, "createBannerForDemandOnly()", 1);
        if (activity == null) {
            this.e.log(ironSourceTag, "createBannerForDemandOnly() : Activity cannot be null", 3);
            return null;
        }
        ContextProvider.getInstance().updateActivity(activity);
        return new ISDemandOnlyBannerLayout(activity, iSBannerSize);
    }

    public String a(Context context) {
        String str;
        b((int) IronSourceConstants.TROUBLESHOOTING_DO_GET_BIDDING_DATA_CALLED, (JSONObject) null);
        if (context == null) {
            IronLog.API.error("bidding data cannot be retrieved, context required");
            return null;
        }
        s.d a2 = s.c().a();
        s.d dVar = s.d.NOT_INIT;
        if (a2 == dVar) {
            IronLog.API.error("bidding data cannot be retrieved, SDK not initialized");
            b((int) IronSourceConstants.TROUBLESHOOTING_DO_GET_BIDDING_DATA_RETURNED_NULL, (JSONObject) null);
            return null;
        } else if (a2 == s.d.INIT_FAILED) {
            IronLog.API.error("bidding data cannot be retrieved, SDK failed to initialize");
            b((int) IronSourceConstants.TROUBLESHOOTING_DO_GET_BIDDING_DATA_RETURNED_NULL, (JSONObject) null);
            return null;
        } else {
            try {
                com.ironsource.mediationsdk.utils.c c2 = c(context);
                if (a2 == dVar) {
                    f(context);
                }
                if (a2 != s.d.INITIATED) {
                    s.c().a(c2);
                    if (c2 != null) {
                        s.c().a(context, c2);
                    }
                }
                com.ironsource.mediationsdk.utils.d b2 = com.ironsource.mediationsdk.utils.c.b(c2);
                JSONObject a3 = this.k0.a(context, b2);
                d.c().a(a3, true);
                str = b2.e() ? IronSourceAES.compressAndEncrypt(a3.toString()) : IronSourceAES.encrypt(a3.toString());
            } catch (Throwable th) {
                b((int) IronSourceConstants.TROUBLESHOOTING_DO_GET_BIDDING_DATA_ENRICH_TOKEN_ERROR, (JSONObject) null);
                IronLog ironLog = IronLog.API;
                ironLog.error("got error during token creation: " + th.getMessage());
                str = null;
            }
            if (str == null) {
                b((int) IronSourceConstants.TROUBLESHOOTING_DO_GET_BIDDING_DATA_RETURNED_NULL, (JSONObject) null);
            }
            return str;
        }
    }

    /* access modifiers changed from: package-private */
    public String a(String str, b.C0017b bVar) {
        if (bVar == null) {
            return null;
        }
        int i2 = b.c[bVar.ordinal()];
        if (i2 != 1 && i2 != 2 && i2 != 3) {
            return null;
        }
        return "placement " + str + " is capped";
    }

    public void a() {
        if (this.J.booleanValue()) {
            this.J = Boolean.FALSE;
            n.a().a(IronSource.AD_UNIT.BANNER, new IronSourceError(IronSourceError.ERROR_BN_LOAD_WHILE_LONG_INITIATION, "init() had failed"));
            this.K = null;
            this.L = null;
        }
        if (this.Z) {
            this.Z = false;
            n.a().a(IronSource.AD_UNIT.INTERSTITIAL, ErrorBuilder.buildInitFailedError("init() had failed", "Interstitial"));
        }
        if (this.W) {
            this.W = false;
            n.a().a(IronSource.AD_UNIT.REWARDED_VIDEO, ErrorBuilder.buildInitFailedError("init() had failed", IronSourceConstants.REWARDED_VIDEO_AD_UNIT));
        }
        synchronized (this.c0) {
            for (h.d b2 : this.c0.values()) {
                String b3 = b2.b();
                this.o0.a(b3).onInterstitialAdLoadFailed(b3, ErrorBuilder.buildInitFailedError("init() had failed", "Interstitial"));
            }
            this.c0.clear();
        }
        synchronized (this.e0) {
            for (h.d b4 : this.e0.values()) {
                String b5 = b4.b();
                this.p0.a(b5).onRewardedVideoAdLoadFailed(b5, ErrorBuilder.buildInitFailedError("init() had failed", IronSourceConstants.REWARDED_VIDEO_AD_UNIT));
            }
            this.e0.clear();
        }
        synchronized (this.d0) {
            for (h.b next : this.d0.values()) {
                ISDemandOnlyBannerLayout g2 = next.g();
                if (g2 != null) {
                    g2.getListener().a(next.b(), ErrorBuilder.buildInitFailedError("init() had failed", "Banner"));
                }
            }
            this.d0.clear();
        }
    }

    public void a(long j2) {
        JSONObject mediationAdditionalData = IronSourceUtils.getMediationAdditionalData(A());
        try {
            mediationAdditionalData.put(IronSourceConstants.EVENTS_DURATION, j2);
            mediationAdditionalData.put("sessionDepth", this.B);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        va.i().a(new y3(IronSourceConstants.INIT_COMPLETE, mediationAdditionalData));
    }

    public void a(Activity activity) {
        try {
            this.e.log(IronSourceLogger.IronSourceTag.API, "onPause()", 1);
            ContextProvider.getInstance().onPause(activity);
        } catch (Throwable th) {
            this.e.logException(IronSourceLogger.IronSourceTag.API, "onPause()", th);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:8:0x0038, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized void a(android.app.Activity r5, com.ironsource.mediationsdk.demandOnly.ISDemandOnlyBannerLayout r6, java.lang.String r7) {
        /*
            r4 = this;
            monitor-enter(r4)
            com.ironsource.mediationsdk.demandOnly.h$c r0 = new com.ironsource.mediationsdk.demandOnly.h$c     // Catch:{ all -> 0x0099 }
            r0.<init>()     // Catch:{ all -> 0x0099 }
            com.ironsource.mediationsdk.demandOnly.h$c r0 = r0.b(r7)     // Catch:{ all -> 0x0099 }
            com.ironsource.mediationsdk.demandOnly.h$c r0 = r0.a((android.app.Activity) r5)     // Catch:{ all -> 0x0099 }
            com.ironsource.mediationsdk.demandOnly.h$c r0 = r0.a((com.ironsource.mediationsdk.demandOnly.ISDemandOnlyBannerLayout) r6)     // Catch:{ all -> 0x0099 }
            com.ironsource.mediationsdk.IronSource$AD_UNIT r1 = com.ironsource.mediationsdk.IronSource.AD_UNIT.BANNER     // Catch:{ all -> 0x0099 }
            com.ironsource.mediationsdk.demandOnly.h$c r0 = r0.a((com.ironsource.mediationsdk.IronSource.AD_UNIT) r1)     // Catch:{ all -> 0x0099 }
            com.ironsource.mediationsdk.demandOnly.h$b r0 = r0.a()     // Catch:{ all -> 0x0099 }
            com.ironsource.mediationsdk.logger.IronSourceError r1 = r0.c()     // Catch:{ all -> 0x0099 }
            r2 = 3
            if (r1 == 0) goto L_0x0039
            com.ironsource.mediationsdk.logger.IronSourceLoggerManager r5 = r4.e     // Catch:{ all -> 0x0099 }
            com.ironsource.mediationsdk.logger.IronSourceLogger$IronSourceTag r0 = com.ironsource.mediationsdk.logger.IronSourceLogger.IronSourceTag.API     // Catch:{ all -> 0x0099 }
            java.lang.String r3 = r1.getErrorMessage()     // Catch:{ all -> 0x0099 }
            r5.log(r0, r3, r2)     // Catch:{ all -> 0x0099 }
            if (r6 == 0) goto L_0x0037
            com.ironsource.e1 r5 = r6.getListener()     // Catch:{ all -> 0x0099 }
            r5.a(r7, r1)     // Catch:{ all -> 0x0099 }
        L_0x0037:
            monitor-exit(r4)
            return
        L_0x0039:
            com.ironsource.mediationsdk.s r1 = com.ironsource.mediationsdk.s.c()     // Catch:{ all -> 0x0099 }
            com.ironsource.mediationsdk.s$d r1 = r1.a()     // Catch:{ all -> 0x0099 }
            com.ironsource.mediationsdk.logger.IronSourceError r1 = r4.a((com.ironsource.mediationsdk.s.d) r1)     // Catch:{ all -> 0x0099 }
            if (r1 == 0) goto L_0x005b
            com.ironsource.mediationsdk.logger.IronSourceLoggerManager r5 = r4.e     // Catch:{ all -> 0x0099 }
            com.ironsource.mediationsdk.logger.IronSourceLogger$IronSourceTag r0 = com.ironsource.mediationsdk.logger.IronSourceLogger.IronSourceTag.API     // Catch:{ all -> 0x0099 }
            java.lang.String r3 = r1.getErrorMessage()     // Catch:{ all -> 0x0099 }
            r5.log(r0, r3, r2)     // Catch:{ all -> 0x0099 }
            com.ironsource.e1 r5 = r6.getListener()     // Catch:{ all -> 0x0099 }
            r5.a(r7, r1)     // Catch:{ all -> 0x0099 }
            monitor-exit(r4)
            return
        L_0x005b:
            com.ironsource.environment.ContextProvider r1 = com.ironsource.environment.ContextProvider.getInstance()     // Catch:{ all -> 0x0099 }
            r1.updateActivity(r5)     // Catch:{ all -> 0x0099 }
            boolean r5 = r4.a((com.ironsource.mediationsdk.demandOnly.h.b) r0)     // Catch:{ all -> 0x0099 }
            if (r5 == 0) goto L_0x006a
            monitor-exit(r4)
            return
        L_0x006a:
            boolean r5 = r4.y()     // Catch:{ all -> 0x0099 }
            if (r5 != 0) goto L_0x008a
            com.ironsource.mediationsdk.logger.IronSourceLoggerManager r5 = r4.e     // Catch:{ all -> 0x0099 }
            com.ironsource.mediationsdk.logger.IronSourceLogger$IronSourceTag r0 = com.ironsource.mediationsdk.logger.IronSourceLogger.IronSourceTag.API     // Catch:{ all -> 0x0099 }
            java.lang.String r1 = "No banner configurations found"
            r5.log(r0, r1, r2)     // Catch:{ all -> 0x0099 }
            com.ironsource.e1 r5 = r6.getListener()     // Catch:{ all -> 0x0099 }
            java.lang.String r6 = "the server response does not contain banner data"
            java.lang.String r0 = "Banner"
            com.ironsource.mediationsdk.logger.IronSourceError r6 = com.ironsource.mediationsdk.utils.ErrorBuilder.buildInitFailedError(r6, r0)     // Catch:{ all -> 0x0099 }
            r5.a(r7, r6)     // Catch:{ all -> 0x0099 }
            monitor-exit(r4)
            return
        L_0x008a:
            boolean r5 = r4.b((com.ironsource.mediationsdk.demandOnly.h.b) r0)     // Catch:{ all -> 0x0099 }
            if (r5 == 0) goto L_0x0092
            monitor-exit(r4)
            return
        L_0x0092:
            com.ironsource.mediationsdk.demandOnly.c r5 = r4.h0     // Catch:{ all -> 0x0099 }
            r5.a(r6, r7)     // Catch:{ all -> 0x0099 }
            monitor-exit(r4)
            return
        L_0x0099:
            r5 = move-exception
            monitor-exit(r4)
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ironsource.mediationsdk.p.a(android.app.Activity, com.ironsource.mediationsdk.demandOnly.ISDemandOnlyBannerLayout, java.lang.String):void");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:8:0x0041, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized void a(android.app.Activity r4, com.ironsource.mediationsdk.demandOnly.ISDemandOnlyBannerLayout r5, java.lang.String r6, java.lang.String r7) {
        /*
            r3 = this;
            monitor-enter(r3)
            com.ironsource.mediationsdk.demandOnly.h$c r0 = new com.ironsource.mediationsdk.demandOnly.h$c     // Catch:{ all -> 0x00a2 }
            r0.<init>()     // Catch:{ all -> 0x00a2 }
            com.ironsource.mediationsdk.demandOnly.h$c r0 = r0.b(r6)     // Catch:{ all -> 0x00a2 }
            com.ironsource.mediationsdk.demandOnly.h$c r0 = r0.a((android.app.Activity) r4)     // Catch:{ all -> 0x00a2 }
            r1 = 1
            com.ironsource.mediationsdk.demandOnly.h$c r0 = r0.a((boolean) r1)     // Catch:{ all -> 0x00a2 }
            com.ironsource.mediationsdk.demandOnly.h$c r0 = r0.a((java.lang.String) r7)     // Catch:{ all -> 0x00a2 }
            com.ironsource.mediationsdk.demandOnly.h$c r0 = r0.a((com.ironsource.mediationsdk.demandOnly.ISDemandOnlyBannerLayout) r5)     // Catch:{ all -> 0x00a2 }
            com.ironsource.mediationsdk.IronSource$AD_UNIT r1 = com.ironsource.mediationsdk.IronSource.AD_UNIT.BANNER     // Catch:{ all -> 0x00a2 }
            com.ironsource.mediationsdk.demandOnly.h$c r0 = r0.a((com.ironsource.mediationsdk.IronSource.AD_UNIT) r1)     // Catch:{ all -> 0x00a2 }
            com.ironsource.mediationsdk.demandOnly.h$b r0 = r0.a()     // Catch:{ all -> 0x00a2 }
            com.ironsource.mediationsdk.logger.IronSourceError r1 = r0.c()     // Catch:{ all -> 0x00a2 }
            r2 = 3
            if (r1 == 0) goto L_0x0042
            com.ironsource.mediationsdk.logger.IronSourceLoggerManager r4 = r3.e     // Catch:{ all -> 0x00a2 }
            com.ironsource.mediationsdk.logger.IronSourceLogger$IronSourceTag r7 = com.ironsource.mediationsdk.logger.IronSourceLogger.IronSourceTag.API     // Catch:{ all -> 0x00a2 }
            java.lang.String r0 = r1.getErrorMessage()     // Catch:{ all -> 0x00a2 }
            r4.log(r7, r0, r2)     // Catch:{ all -> 0x00a2 }
            if (r5 == 0) goto L_0x0040
            com.ironsource.e1 r4 = r5.getListener()     // Catch:{ all -> 0x00a2 }
            r4.a(r6, r1)     // Catch:{ all -> 0x00a2 }
        L_0x0040:
            monitor-exit(r3)
            return
        L_0x0042:
            com.ironsource.mediationsdk.s r1 = com.ironsource.mediationsdk.s.c()     // Catch:{ all -> 0x00a2 }
            com.ironsource.mediationsdk.s$d r1 = r1.a()     // Catch:{ all -> 0x00a2 }
            com.ironsource.mediationsdk.logger.IronSourceError r1 = r3.a((com.ironsource.mediationsdk.s.d) r1)     // Catch:{ all -> 0x00a2 }
            if (r1 == 0) goto L_0x0064
            com.ironsource.mediationsdk.logger.IronSourceLoggerManager r4 = r3.e     // Catch:{ all -> 0x00a2 }
            com.ironsource.mediationsdk.logger.IronSourceLogger$IronSourceTag r7 = com.ironsource.mediationsdk.logger.IronSourceLogger.IronSourceTag.API     // Catch:{ all -> 0x00a2 }
            java.lang.String r0 = r1.getErrorMessage()     // Catch:{ all -> 0x00a2 }
            r4.log(r7, r0, r2)     // Catch:{ all -> 0x00a2 }
            com.ironsource.e1 r4 = r5.getListener()     // Catch:{ all -> 0x00a2 }
            r4.a(r6, r1)     // Catch:{ all -> 0x00a2 }
            monitor-exit(r3)
            return
        L_0x0064:
            com.ironsource.environment.ContextProvider r1 = com.ironsource.environment.ContextProvider.getInstance()     // Catch:{ all -> 0x00a2 }
            r1.updateActivity(r4)     // Catch:{ all -> 0x00a2 }
            boolean r4 = r3.a((com.ironsource.mediationsdk.demandOnly.h.b) r0)     // Catch:{ all -> 0x00a2 }
            if (r4 == 0) goto L_0x0073
            monitor-exit(r3)
            return
        L_0x0073:
            boolean r4 = r3.y()     // Catch:{ all -> 0x00a2 }
            if (r4 != 0) goto L_0x0093
            com.ironsource.mediationsdk.logger.IronSourceLoggerManager r4 = r3.e     // Catch:{ all -> 0x00a2 }
            com.ironsource.mediationsdk.logger.IronSourceLogger$IronSourceTag r7 = com.ironsource.mediationsdk.logger.IronSourceLogger.IronSourceTag.API     // Catch:{ all -> 0x00a2 }
            java.lang.String r0 = "No banner configurations found"
            r4.log(r7, r0, r2)     // Catch:{ all -> 0x00a2 }
            com.ironsource.e1 r4 = r5.getListener()     // Catch:{ all -> 0x00a2 }
            java.lang.String r5 = "the server response does not contain banner data"
            java.lang.String r7 = "Banner"
            com.ironsource.mediationsdk.logger.IronSourceError r5 = com.ironsource.mediationsdk.utils.ErrorBuilder.buildInitFailedError(r5, r7)     // Catch:{ all -> 0x00a2 }
            r4.a(r6, r5)     // Catch:{ all -> 0x00a2 }
            monitor-exit(r3)
            return
        L_0x0093:
            boolean r4 = r3.b((com.ironsource.mediationsdk.demandOnly.h.b) r0)     // Catch:{ all -> 0x00a2 }
            if (r4 == 0) goto L_0x009b
            monitor-exit(r3)
            return
        L_0x009b:
            com.ironsource.mediationsdk.demandOnly.c r4 = r3.h0     // Catch:{ all -> 0x00a2 }
            r4.a(r5, r6, r7)     // Catch:{ all -> 0x00a2 }
            monitor-exit(r3)
            return
        L_0x00a2:
            r4 = move-exception
            monitor-exit(r3)
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ironsource.mediationsdk.p.a(android.app.Activity, com.ironsource.mediationsdk.demandOnly.ISDemandOnlyBannerLayout, java.lang.String, java.lang.String):void");
    }

    public synchronized void a(Activity activity, String str) {
        a(new h.c().b(str).a(activity, ContextProvider.getInstance().getCurrentActiveActivity()).a(IronSource.AD_UNIT.INTERSTITIAL).b(), this.o0.a(str));
    }

    public synchronized void a(Activity activity, String str, String str2) {
        a(new h.c().b(str).a(str2).a(activity, ContextProvider.getInstance().getCurrentActiveActivity()).a(true).a(IronSource.AD_UNIT.REWARDED_VIDEO).b(), this.p0.a(str));
    }

    /* JADX WARNING: Code restructure failed: missing block: B:79:0x01d7, code lost:
        return;
     */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x00af  */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x00b9  */
    /* JADX WARNING: Removed duplicated region for block: B:48:0x0118  */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x0157 A[SYNTHETIC, Splitter:B:57:0x0157] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized void a(android.content.Context r8, java.lang.String r9, boolean r10, com.ironsource.mediationsdk.sdk.InitializationListener r11, com.ironsource.mediationsdk.IronSource.AD_UNIT... r12) {
        /*
            r7 = this;
            monitor-enter(r7)
            com.ironsource.mediationsdk.logger.IronLog r0 = com.ironsource.mediationsdk.logger.IronLog.INTERNAL     // Catch:{ all -> 0x01d8 }
            r0.verbose()     // Catch:{ all -> 0x01d8 }
            java.lang.String r0 = "Init Failed - provided context is null"
            boolean r0 = com.ironsource.a8.a((java.lang.Object) r8, (java.lang.String) r0)     // Catch:{ all -> 0x01d8 }
            if (r0 != 0) goto L_0x0015
            java.lang.String r8 = "Provided context is null"
            r7.d((java.lang.String) r8)     // Catch:{ all -> 0x01d8 }
            monitor-exit(r7)
            return
        L_0x0015:
            boolean r0 = r8 instanceof android.app.Activity     // Catch:{ all -> 0x01d8 }
            if (r0 == 0) goto L_0x001f
            r1 = r8
            android.app.Activity r1 = (android.app.Activity) r1     // Catch:{ all -> 0x01d8 }
            r7.e((android.app.Activity) r1)     // Catch:{ all -> 0x01d8 }
        L_0x001f:
            if (r11 == 0) goto L_0x0023
            r7.T = r11     // Catch:{ all -> 0x01d8 }
        L_0x0023:
            java.util.concurrent.atomic.AtomicBoolean r11 = r7.q     // Catch:{ all -> 0x01d8 }
            if (r11 == 0) goto L_0x01b5
            r1 = 0
            r2 = 1
            boolean r11 = r11.compareAndSet(r2, r1)     // Catch:{ all -> 0x01d8 }
            if (r11 == 0) goto L_0x01b5
            if (r12 == 0) goto L_0x0070
            int r11 = r12.length     // Catch:{ all -> 0x01d8 }
            if (r11 != 0) goto L_0x0035
            goto L_0x0070
        L_0x0035:
            int r11 = r12.length     // Catch:{ all -> 0x01d8 }
            r3 = 0
        L_0x0037:
            if (r3 >= r11) goto L_0x008a
            r4 = r12[r3]     // Catch:{ all -> 0x01d8 }
            java.util.Set<com.ironsource.mediationsdk.IronSource$AD_UNIT> r5 = r7.w     // Catch:{ all -> 0x01d8 }
            r5.add(r4)     // Catch:{ all -> 0x01d8 }
            java.util.Set<com.ironsource.mediationsdk.IronSource$AD_UNIT> r5 = r7.x     // Catch:{ all -> 0x01d8 }
            r5.add(r4)     // Catch:{ all -> 0x01d8 }
            com.ironsource.mediationsdk.IronSource$AD_UNIT r5 = com.ironsource.mediationsdk.IronSource.AD_UNIT.INTERSTITIAL     // Catch:{ all -> 0x01d8 }
            boolean r5 = r4.equals(r5)     // Catch:{ all -> 0x01d8 }
            if (r5 == 0) goto L_0x004f
            r7.G = r2     // Catch:{ all -> 0x01d8 }
        L_0x004f:
            com.ironsource.mediationsdk.IronSource$AD_UNIT r5 = com.ironsource.mediationsdk.IronSource.AD_UNIT.BANNER     // Catch:{ all -> 0x01d8 }
            boolean r5 = r4.equals(r5)     // Catch:{ all -> 0x01d8 }
            if (r5 == 0) goto L_0x0059
            r7.H = r2     // Catch:{ all -> 0x01d8 }
        L_0x0059:
            com.ironsource.mediationsdk.IronSource$AD_UNIT r5 = com.ironsource.mediationsdk.IronSource.AD_UNIT.NATIVE_AD     // Catch:{ all -> 0x01d8 }
            boolean r5 = r4.equals(r5)     // Catch:{ all -> 0x01d8 }
            if (r5 == 0) goto L_0x0063
            r7.I = r2     // Catch:{ all -> 0x01d8 }
        L_0x0063:
            com.ironsource.mediationsdk.IronSource$AD_UNIT r5 = com.ironsource.mediationsdk.IronSource.AD_UNIT.REWARDED_VIDEO     // Catch:{ all -> 0x01d8 }
            boolean r4 = r4.equals(r5)     // Catch:{ all -> 0x01d8 }
            if (r4 == 0) goto L_0x006d
            r7.F = r2     // Catch:{ all -> 0x01d8 }
        L_0x006d:
            int r3 = r3 + 1
            goto L_0x0037
        L_0x0070:
            com.ironsource.mediationsdk.IronSource$AD_UNIT[] r11 = com.ironsource.mediationsdk.IronSource.AD_UNIT.values()     // Catch:{ all -> 0x01d8 }
            int r3 = r11.length     // Catch:{ all -> 0x01d8 }
            r4 = 0
        L_0x0076:
            if (r4 >= r3) goto L_0x0082
            r5 = r11[r4]     // Catch:{ all -> 0x01d8 }
            java.util.Set<com.ironsource.mediationsdk.IronSource$AD_UNIT> r6 = r7.w     // Catch:{ all -> 0x01d8 }
            r6.add(r5)     // Catch:{ all -> 0x01d8 }
            int r4 = r4 + 1
            goto L_0x0076
        L_0x0082:
            r7.F = r2     // Catch:{ all -> 0x01d8 }
            r7.G = r2     // Catch:{ all -> 0x01d8 }
            r7.H = r2     // Catch:{ all -> 0x01d8 }
            r7.I = r2     // Catch:{ all -> 0x01d8 }
        L_0x008a:
            com.ironsource.mediationsdk.logger.IronLog r11 = com.ironsource.mediationsdk.logger.IronLog.API     // Catch:{ all -> 0x01d8 }
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x01d8 }
            r3.<init>()     // Catch:{ all -> 0x01d8 }
            java.lang.String r4 = "init(appKey:"
            r3.append(r4)     // Catch:{ all -> 0x01d8 }
            r3.append(r9)     // Catch:{ all -> 0x01d8 }
            java.lang.String r4 = ")"
            r3.append(r4)     // Catch:{ all -> 0x01d8 }
            java.lang.String r3 = r3.toString()     // Catch:{ all -> 0x01d8 }
            r11.info(r3)     // Catch:{ all -> 0x01d8 }
            com.ironsource.f2 r11 = r7.x(r9)     // Catch:{ all -> 0x01d8 }
            boolean r3 = r11.b()     // Catch:{ all -> 0x01d8 }
            if (r3 == 0) goto L_0x00b1
            r7.k = r9     // Catch:{ all -> 0x01d8 }
        L_0x00b1:
            java.lang.String r3 = r7.k     // Catch:{ all -> 0x01d8 }
            com.ironsource.mediationsdk.utils.c r3 = r7.a((android.content.Context) r8, (java.lang.String) r3)     // Catch:{ all -> 0x01d8 }
            if (r3 == 0) goto L_0x00c8
            com.ironsource.g2 r3 = r3.b()     // Catch:{ all -> 0x01d8 }
            com.ironsource.j0 r3 = r3.b()     // Catch:{ all -> 0x01d8 }
            com.ironsource.o0 r3 = r3.e()     // Catch:{ all -> 0x01d8 }
            r7.a((com.ironsource.o0) r3)     // Catch:{ all -> 0x01d8 }
        L_0x00c8:
            com.ironsource.environment.ContextProvider r3 = com.ironsource.environment.ContextProvider.getInstance()     // Catch:{ all -> 0x01d8 }
            android.content.Context r4 = r8.getApplicationContext()     // Catch:{ all -> 0x01d8 }
            r3.updateAppContext(r4)     // Catch:{ all -> 0x01d8 }
            android.content.Context r3 = r8.getApplicationContext()     // Catch:{ all -> 0x01d8 }
            java.util.concurrent.TimeUnit r4 = java.util.concurrent.TimeUnit.HOURS     // Catch:{ all -> 0x01d8 }
            com.ironsource.j3 r5 = com.ironsource.j3.a     // Catch:{ all -> 0x01d8 }
            int r5 = r5.d()     // Catch:{ all -> 0x01d8 }
            long r5 = (long) r5     // Catch:{ all -> 0x01d8 }
            long r4 = r4.toMillis(r5)     // Catch:{ all -> 0x01d8 }
            com.ironsource.m3.b(r3, r4)     // Catch:{ all -> 0x01d8 }
            com.ironsource.w7 r3 = r7.j0     // Catch:{ all -> 0x01d8 }
            java.lang.String r4 = com.ironsource.mediationsdk.utils.IronSourceUtils.getSDKVersion()     // Catch:{ all -> 0x01d8 }
            r3.e(r4)     // Catch:{ all -> 0x01d8 }
            com.ironsource.w7 r3 = r7.j0     // Catch:{ all -> 0x01d8 }
            com.ironsource.m5 r4 = com.ironsource.l5.a()     // Catch:{ all -> 0x01d8 }
            r3.a((com.ironsource.m5) r4)     // Catch:{ all -> 0x01d8 }
            com.ironsource.w7 r3 = r7.j0     // Catch:{ all -> 0x01d8 }
            boolean r4 = com.ironsource.mediationsdk.utils.IronSourceUtils.isGooglePlayInstalled(r8)     // Catch:{ all -> 0x01d8 }
            r3.b((boolean) r4)     // Catch:{ all -> 0x01d8 }
            com.ironsource.w7 r3 = r7.j0     // Catch:{ all -> 0x01d8 }
            int r4 = com.ironsource.o.a()     // Catch:{ all -> 0x01d8 }
            r3.a((int) r4)     // Catch:{ all -> 0x01d8 }
            r7.g()     // Catch:{ all -> 0x01d8 }
            r7.T()     // Catch:{ all -> 0x01d8 }
            r7.e((android.content.Context) r8)     // Catch:{ all -> 0x01d8 }
            java.lang.String r3 = r7.k     // Catch:{ all -> 0x01d8 }
            if (r3 != 0) goto L_0x0157
            com.ironsource.mediationsdk.s r8 = com.ironsource.mediationsdk.s.c()     // Catch:{ all -> 0x01d8 }
            r8.e()     // Catch:{ all -> 0x01d8 }
            java.util.Set<com.ironsource.mediationsdk.IronSource$AD_UNIT> r8 = r7.w     // Catch:{ all -> 0x01d8 }
            com.ironsource.mediationsdk.IronSource$AD_UNIT r9 = com.ironsource.mediationsdk.IronSource.AD_UNIT.REWARDED_VIDEO     // Catch:{ all -> 0x01d8 }
            boolean r8 = r8.contains(r9)     // Catch:{ all -> 0x01d8 }
            if (r8 == 0) goto L_0x0131
            com.ironsource.oa r8 = com.ironsource.oa.a()     // Catch:{ all -> 0x01d8 }
            r9 = 0
            r8.a((boolean) r1, (com.ironsource.mediationsdk.adunit.adapter.utility.AdInfo) r9)     // Catch:{ all -> 0x01d8 }
        L_0x0131:
            java.util.Set<com.ironsource.mediationsdk.IronSource$AD_UNIT> r8 = r7.w     // Catch:{ all -> 0x01d8 }
            com.ironsource.mediationsdk.IronSource$AD_UNIT r9 = com.ironsource.mediationsdk.IronSource.AD_UNIT.OFFERWALL     // Catch:{ all -> 0x01d8 }
            boolean r8 = r8.contains(r9)     // Catch:{ all -> 0x01d8 }
            if (r8 == 0) goto L_0x0144
            com.ironsource.q8 r8 = r7.f     // Catch:{ all -> 0x01d8 }
            com.ironsource.mediationsdk.logger.IronSourceError r9 = r11.a()     // Catch:{ all -> 0x01d8 }
            r8.a((boolean) r1, (com.ironsource.mediationsdk.logger.IronSourceError) r9)     // Catch:{ all -> 0x01d8 }
        L_0x0144:
            com.ironsource.mediationsdk.logger.IronSourceLoggerManager r8 = com.ironsource.mediationsdk.logger.IronSourceLoggerManager.getLogger()     // Catch:{ all -> 0x01d8 }
            com.ironsource.mediationsdk.logger.IronSourceLogger$IronSourceTag r9 = com.ironsource.mediationsdk.logger.IronSourceLogger.IronSourceTag.API     // Catch:{ all -> 0x01d8 }
            com.ironsource.mediationsdk.logger.IronSourceError r10 = r11.a()     // Catch:{ all -> 0x01d8 }
            java.lang.String r10 = r10.toString()     // Catch:{ all -> 0x01d8 }
            r8.log(r9, r10, r2)     // Catch:{ all -> 0x01d8 }
            monitor-exit(r7)
            return
        L_0x0157:
            com.ironsource.w7 r11 = r7.j0     // Catch:{ all -> 0x01d8 }
            r11.a((android.content.Context) r8)     // Catch:{ all -> 0x01d8 }
            com.ironsource.w7 r11 = r7.j0     // Catch:{ all -> 0x01d8 }
            java.lang.String r3 = r7.k     // Catch:{ all -> 0x01d8 }
            r11.b((java.lang.String) r3)     // Catch:{ all -> 0x01d8 }
            com.ironsource.w7 r11 = r7.j0     // Catch:{ all -> 0x01d8 }
            java.lang.String r3 = r7.t     // Catch:{ all -> 0x01d8 }
            r11.g(r3)     // Catch:{ all -> 0x01d8 }
            com.ironsource.w7 r11 = r7.j0     // Catch:{ all -> 0x01d8 }
            com.ironsource.mediationsdk.config.ConfigFile r3 = com.ironsource.mediationsdk.config.ConfigFile.getConfigFile()     // Catch:{ all -> 0x01d8 }
            java.lang.String r3 = r3.getPluginType()     // Catch:{ all -> 0x01d8 }
            r11.f(r3)     // Catch:{ all -> 0x01d8 }
            boolean r11 = r7.y     // Catch:{ all -> 0x01d8 }
            if (r11 == 0) goto L_0x019b
            org.json.JSONObject r11 = com.ironsource.mediationsdk.utils.IronSourceUtils.getMediationAdditionalData(r10)     // Catch:{ all -> 0x01d8 }
            if (r12 == 0) goto L_0x0191
            int r3 = r12.length     // Catch:{ all -> 0x01d8 }
            r4 = 0
        L_0x0183:
            if (r4 >= r3) goto L_0x0191
            r5 = r12[r4]     // Catch:{ all -> 0x01d8 }
            java.lang.String r5 = r5.toString()     // Catch:{ Exception -> 0x018e }
            r11.put(r5, r2)     // Catch:{ Exception -> 0x018e }
        L_0x018e:
            int r4 = r4 + 1
            goto L_0x0183
        L_0x0191:
            int r3 = r7.B     // Catch:{ all -> 0x01d8 }
            int r3 = r3 + r2
            r7.B = r3     // Catch:{ all -> 0x01d8 }
            r7.a((boolean) r0, (boolean) r10, (int) r3, (org.json.JSONObject) r11)     // Catch:{ all -> 0x01d8 }
            r7.y = r1     // Catch:{ all -> 0x01d8 }
        L_0x019b:
            com.ironsource.mediationsdk.s r10 = com.ironsource.mediationsdk.s.c()     // Catch:{ all -> 0x01d8 }
            r10.a((com.ironsource.u9) r7)     // Catch:{ all -> 0x01d8 }
            com.ironsource.mediationsdk.s r10 = com.ironsource.mediationsdk.s.c()     // Catch:{ all -> 0x01d8 }
            com.ironsource.j4 r11 = r7.i0     // Catch:{ all -> 0x01d8 }
            r10.a((com.ironsource.u9) r11)     // Catch:{ all -> 0x01d8 }
            com.ironsource.mediationsdk.s r10 = com.ironsource.mediationsdk.s.c()     // Catch:{ all -> 0x01d8 }
            java.lang.String r11 = r7.l     // Catch:{ all -> 0x01d8 }
            r10.a(r8, r9, r11, r12)     // Catch:{ all -> 0x01d8 }
            goto L_0x01d6
        L_0x01b5:
            if (r12 == 0) goto L_0x01cc
            r7.a((boolean) r0, (boolean) r10, (com.ironsource.mediationsdk.IronSource.AD_UNIT[]) r12)     // Catch:{ all -> 0x01d8 }
            com.ironsource.mediationsdk.s r8 = com.ironsource.mediationsdk.s.c()     // Catch:{ all -> 0x01d8 }
            com.ironsource.mediationsdk.s$d r8 = r8.a()     // Catch:{ all -> 0x01d8 }
            com.ironsource.mediationsdk.s$d r9 = com.ironsource.mediationsdk.s.d.INITIATED     // Catch:{ all -> 0x01d8 }
            if (r8 != r9) goto L_0x01d6
            if (r10 != 0) goto L_0x01d6
            r7.R()     // Catch:{ all -> 0x01d8 }
            goto L_0x01d6
        L_0x01cc:
            com.ironsource.mediationsdk.logger.IronSourceLoggerManager r8 = r7.e     // Catch:{ all -> 0x01d8 }
            com.ironsource.mediationsdk.logger.IronSourceLogger$IronSourceTag r9 = com.ironsource.mediationsdk.logger.IronSourceLogger.IronSourceTag.API     // Catch:{ all -> 0x01d8 }
            java.lang.String r10 = "Multiple calls to init without ad units are not allowed"
            r11 = 3
            r8.log(r9, r10, r11)     // Catch:{ all -> 0x01d8 }
        L_0x01d6:
            monitor-exit(r7)
            return
        L_0x01d8:
            r8 = move-exception
            monitor-exit(r7)
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ironsource.mediationsdk.p.a(android.content.Context, java.lang.String, boolean, com.ironsource.mediationsdk.sdk.InitializationListener, com.ironsource.mediationsdk.IronSource$AD_UNIT[]):void");
    }

    /* JADX WARNING: Removed duplicated region for block: B:50:0x00bf  */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x00da  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized void a(android.content.Context r9, java.lang.String r10, com.ironsource.mediationsdk.IronSource.AD_UNIT... r11) {
        /*
            r8 = this;
            monitor-enter(r8)
            java.util.ArrayList r0 = new java.util.ArrayList     // Catch:{ all -> 0x00f1 }
            r0.<init>()     // Catch:{ all -> 0x00f1 }
            r1 = 1
            if (r11 == 0) goto L_0x008a
            int r2 = r11.length     // Catch:{ all -> 0x00f1 }
            if (r2 != 0) goto L_0x000e
            goto L_0x008a
        L_0x000e:
            int r2 = r11.length     // Catch:{ all -> 0x00f1 }
            r3 = 0
        L_0x0010:
            if (r3 >= r2) goto L_0x00bd
            r4 = r11[r3]     // Catch:{ all -> 0x00f1 }
            com.ironsource.mediationsdk.IronSource$AD_UNIT r5 = com.ironsource.mediationsdk.IronSource.AD_UNIT.OFFERWALL     // Catch:{ all -> 0x00f1 }
            boolean r5 = r4.equals(r5)     // Catch:{ all -> 0x00f1 }
            if (r5 == 0) goto L_0x0036
            com.ironsource.mediationsdk.logger.IronSourceLoggerManager r5 = r8.e     // Catch:{ all -> 0x00f1 }
            com.ironsource.mediationsdk.logger.IronSourceLogger$IronSourceTag r6 = com.ironsource.mediationsdk.logger.IronSourceLogger.IronSourceTag.API     // Catch:{ all -> 0x00f1 }
            java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch:{ all -> 0x00f1 }
            r7.<init>()     // Catch:{ all -> 0x00f1 }
            r7.append(r4)     // Catch:{ all -> 0x00f1 }
            java.lang.String r4 = " ad unit cannot be initialized in demand only mode"
            r7.append(r4)     // Catch:{ all -> 0x00f1 }
            java.lang.String r4 = r7.toString()     // Catch:{ all -> 0x00f1 }
            r7 = 3
            r5.log(r6, r4, r7)     // Catch:{ all -> 0x00f1 }
            goto L_0x0087
        L_0x0036:
            com.ironsource.mediationsdk.IronSource$AD_UNIT r5 = com.ironsource.mediationsdk.IronSource.AD_UNIT.INTERSTITIAL     // Catch:{ all -> 0x00f1 }
            boolean r5 = r4.equals(r5)     // Catch:{ all -> 0x00f1 }
            if (r5 == 0) goto L_0x0051
            boolean r5 = r8.G     // Catch:{ all -> 0x00f1 }
            if (r5 == 0) goto L_0x0046
            r8.a((com.ironsource.mediationsdk.IronSource.AD_UNIT) r4)     // Catch:{ all -> 0x00f1 }
            goto L_0x0051
        L_0x0046:
            r8.D = r1     // Catch:{ all -> 0x00f1 }
            boolean r5 = r0.contains(r4)     // Catch:{ all -> 0x00f1 }
            if (r5 != 0) goto L_0x0051
            r0.add(r4)     // Catch:{ all -> 0x00f1 }
        L_0x0051:
            com.ironsource.mediationsdk.IronSource$AD_UNIT r5 = com.ironsource.mediationsdk.IronSource.AD_UNIT.REWARDED_VIDEO     // Catch:{ all -> 0x00f1 }
            boolean r5 = r4.equals(r5)     // Catch:{ all -> 0x00f1 }
            if (r5 == 0) goto L_0x006c
            boolean r5 = r8.F     // Catch:{ all -> 0x00f1 }
            if (r5 == 0) goto L_0x0061
            r8.a((com.ironsource.mediationsdk.IronSource.AD_UNIT) r4)     // Catch:{ all -> 0x00f1 }
            goto L_0x006c
        L_0x0061:
            r8.C = r1     // Catch:{ all -> 0x00f1 }
            boolean r5 = r0.contains(r4)     // Catch:{ all -> 0x00f1 }
            if (r5 != 0) goto L_0x006c
            r0.add(r4)     // Catch:{ all -> 0x00f1 }
        L_0x006c:
            com.ironsource.mediationsdk.IronSource$AD_UNIT r5 = com.ironsource.mediationsdk.IronSource.AD_UNIT.BANNER     // Catch:{ all -> 0x00f1 }
            boolean r5 = r4.equals(r5)     // Catch:{ all -> 0x00f1 }
            if (r5 == 0) goto L_0x0087
            boolean r5 = r8.H     // Catch:{ all -> 0x00f1 }
            if (r5 == 0) goto L_0x007c
            r8.a((com.ironsource.mediationsdk.IronSource.AD_UNIT) r4)     // Catch:{ all -> 0x00f1 }
            goto L_0x0087
        L_0x007c:
            r8.E = r1     // Catch:{ all -> 0x00f1 }
            boolean r5 = r0.contains(r4)     // Catch:{ all -> 0x00f1 }
            if (r5 != 0) goto L_0x0087
            r0.add(r4)     // Catch:{ all -> 0x00f1 }
        L_0x0087:
            int r3 = r3 + 1
            goto L_0x0010
        L_0x008a:
            boolean r11 = r8.F     // Catch:{ all -> 0x00f1 }
            if (r11 == 0) goto L_0x0094
            com.ironsource.mediationsdk.IronSource$AD_UNIT r11 = com.ironsource.mediationsdk.IronSource.AD_UNIT.REWARDED_VIDEO     // Catch:{ all -> 0x00f1 }
            r8.a((com.ironsource.mediationsdk.IronSource.AD_UNIT) r11)     // Catch:{ all -> 0x00f1 }
            goto L_0x009b
        L_0x0094:
            r8.C = r1     // Catch:{ all -> 0x00f1 }
            com.ironsource.mediationsdk.IronSource$AD_UNIT r11 = com.ironsource.mediationsdk.IronSource.AD_UNIT.REWARDED_VIDEO     // Catch:{ all -> 0x00f1 }
            r0.add(r11)     // Catch:{ all -> 0x00f1 }
        L_0x009b:
            boolean r11 = r8.G     // Catch:{ all -> 0x00f1 }
            if (r11 == 0) goto L_0x00a5
            com.ironsource.mediationsdk.IronSource$AD_UNIT r11 = com.ironsource.mediationsdk.IronSource.AD_UNIT.INTERSTITIAL     // Catch:{ all -> 0x00f1 }
            r8.a((com.ironsource.mediationsdk.IronSource.AD_UNIT) r11)     // Catch:{ all -> 0x00f1 }
            goto L_0x00ac
        L_0x00a5:
            r8.D = r1     // Catch:{ all -> 0x00f1 }
            com.ironsource.mediationsdk.IronSource$AD_UNIT r11 = com.ironsource.mediationsdk.IronSource.AD_UNIT.INTERSTITIAL     // Catch:{ all -> 0x00f1 }
            r0.add(r11)     // Catch:{ all -> 0x00f1 }
        L_0x00ac:
            boolean r11 = r8.H     // Catch:{ all -> 0x00f1 }
            if (r11 == 0) goto L_0x00b6
            com.ironsource.mediationsdk.IronSource$AD_UNIT r11 = com.ironsource.mediationsdk.IronSource.AD_UNIT.BANNER     // Catch:{ all -> 0x00f1 }
            r8.a((com.ironsource.mediationsdk.IronSource.AD_UNIT) r11)     // Catch:{ all -> 0x00f1 }
            goto L_0x00bd
        L_0x00b6:
            r8.E = r1     // Catch:{ all -> 0x00f1 }
            com.ironsource.mediationsdk.IronSource$AD_UNIT r11 = com.ironsource.mediationsdk.IronSource.AD_UNIT.BANNER     // Catch:{ all -> 0x00f1 }
            r0.add(r11)     // Catch:{ all -> 0x00f1 }
        L_0x00bd:
            if (r9 == 0) goto L_0x00d4
            boolean r11 = r9 instanceof android.app.Activity     // Catch:{ all -> 0x00f1 }
            if (r11 == 0) goto L_0x00c9
            r11 = r9
            android.app.Activity r11 = (android.app.Activity) r11     // Catch:{ all -> 0x00f1 }
            r8.e((android.app.Activity) r11)     // Catch:{ all -> 0x00f1 }
        L_0x00c9:
            com.ironsource.environment.ContextProvider r11 = com.ironsource.environment.ContextProvider.getInstance()     // Catch:{ all -> 0x00f1 }
            android.content.Context r1 = r9.getApplicationContext()     // Catch:{ all -> 0x00f1 }
            r11.updateAppContext(r1)     // Catch:{ all -> 0x00f1 }
        L_0x00d4:
            boolean r11 = r0.isEmpty()     // Catch:{ all -> 0x00f1 }
            if (r11 != 0) goto L_0x00ef
            int r11 = r0.size()     // Catch:{ all -> 0x00f1 }
            com.ironsource.mediationsdk.IronSource$AD_UNIT[] r11 = new com.ironsource.mediationsdk.IronSource.AD_UNIT[r11]     // Catch:{ all -> 0x00f1 }
            java.lang.Object[] r11 = r0.toArray(r11)     // Catch:{ all -> 0x00f1 }
            r5 = r11
            com.ironsource.mediationsdk.IronSource$AD_UNIT[] r5 = (com.ironsource.mediationsdk.IronSource.AD_UNIT[]) r5     // Catch:{ all -> 0x00f1 }
            r3 = 1
            r4 = 0
            r0 = r8
            r1 = r9
            r2 = r10
            r0.a(r1, r2, r3, r4, r5)     // Catch:{ all -> 0x00f1 }
        L_0x00ef:
            monitor-exit(r8)
            return
        L_0x00f1:
            r9 = move-exception
            monitor-exit(r8)
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ironsource.mediationsdk.p.a(android.content.Context, java.lang.String, com.ironsource.mediationsdk.IronSource$AD_UNIT[]):void");
    }

    public void a(Context context, boolean z2) {
        this.u = context;
        this.v = Boolean.valueOf(z2);
        if (this.Y) {
            j7 j7Var = this.Q;
            if (j7Var != null) {
                j7Var.a(context, z2);
            }
        } else {
            y yVar = this.O;
            if (yVar != null) {
                yVar.a(context, z2);
            }
        }
        if (this.X) {
            sa saVar = this.R;
            if (saVar != null) {
                saVar.a(context, z2);
                return;
            }
            return;
        }
        k5 k5Var = this.N;
        if (k5Var != null) {
            k5Var.a(context, z2);
        }
    }

    /* access modifiers changed from: package-private */
    public synchronized void a(AbstractAdapter abstractAdapter) {
        this.c = abstractAdapter;
    }

    public void a(IronSource.AD_UNIT ad_unit, WaterfallConfiguration waterfallConfiguration) {
        if (ad_unit == null) {
            IronLog.API.error("AdUnit should not be null.");
            return;
        }
        IronLog ironLog = IronLog.API;
        Object[] objArr = new Object[2];
        objArr[0] = ad_unit.name();
        objArr[1] = waterfallConfiguration == null ? "NULL" : waterfallConfiguration.toString();
        ironLog.info(String.format("(%s, %s)", objArr));
        y3 y3Var = new y3(53, IronSourceUtils.getMediationAdditionalData(false));
        y3Var.a(IronSourceConstants.EVENTS_EXT1, waterfallConfiguration == null ? "" : waterfallConfiguration.toJsonString());
        va.i().a(y3Var, ad_unit);
        this.j0.a(ad_unit, waterfallConfiguration);
    }

    public void a(IronSource.AD_UNIT ad_unit, wb wbVar) {
        h1 h1Var;
        sa saVar;
        j7 j7Var;
        if (this.l0) {
            if (ad_unit == IronSource.AD_UNIT.INTERSTITIAL && (j7Var = this.Q) != null) {
                j7Var.a(wbVar);
            }
            if (ad_unit == IronSource.AD_UNIT.REWARDED_VIDEO && (saVar = this.R) != null) {
                saVar.a(wbVar);
            }
            if (ad_unit == IronSource.AD_UNIT.BANNER && (h1Var = this.S) != null) {
                h1Var.a(wbVar);
            }
        }
    }

    public void a(IronSourceBannerLayout ironSourceBannerLayout) {
        h1 h1Var;
        this.e.log(IronSourceLogger.IronSourceTag.API, "destroyBanner()", 1);
        try {
            if (!this.a0 || (h1Var = this.S) == null) {
                w wVar = this.P;
                if (wVar != null) {
                    wVar.a(ironSourceBannerLayout);
                    return;
                }
                return;
            }
            h1Var.a(ironSourceBannerLayout);
        } catch (Throwable th) {
            this.e.logException(IronSourceLogger.IronSourceTag.API, "destroyBanner()", th);
        }
    }

    public void a(IronSourceBannerLayout ironSourceBannerLayout, String str) {
        IronLog ironLog = IronLog.INTERNAL;
        ironLog.verbose("placementName = " + str);
        if (this.E) {
            this.e.log(IronSourceLogger.IronSourceTag.API, "Banner was initialized in demand only mode. Use loadISDemandOnlyBanner instead", 3);
            n.a().a(IronSource.AD_UNIT.BANNER, ErrorBuilder.buildInitFailedError("Banner was initialized in demand only mode. Use loadISDemandOnlyBanner instead", "Banner"));
        } else if (ironSourceBannerLayout == null || ironSourceBannerLayout.isDestroyed()) {
            String concat = "loadBanner can't be called - ".concat(ironSourceBannerLayout == null ? "banner layout is null " : "banner layout is destroyed");
            this.e.log(IronSourceLogger.IronSourceTag.API, concat, 3);
            n.a().a(IronSource.AD_UNIT.BANNER, ErrorBuilder.buildLoadFailedError(concat));
        } else if (!this.H) {
            this.e.log(IronSourceLogger.IronSourceTag.API, "init() must be called before loadBanner()", 3);
            n.a().a(IronSource.AD_UNIT.BANNER, ErrorBuilder.buildLoadFailedError("init() must be called before loadBanner()"));
        } else if (!ironSourceBannerLayout.getSize().getDescription().equals(l.f) || (ironSourceBannerLayout.getSize().getWidth() > 0 && ironSourceBannerLayout.getSize().getHeight() > 0)) {
            s.d a2 = s.c().a();
            if (a2 == s.d.INIT_FAILED) {
                this.e.log(IronSourceLogger.IronSourceTag.API, "init() had failed", 3);
                n.a().a(IronSource.AD_UNIT.BANNER, new IronSourceError(600, "Init() had failed"));
            } else if (a2 == s.d.INIT_IN_PROGRESS) {
                if (s.c().d()) {
                    this.e.log(IronSourceLogger.IronSourceTag.API, "init() had failed", 3);
                    n.a().a(IronSource.AD_UNIT.BANNER, new IronSourceError(IronSourceError.ERROR_BN_LOAD_AFTER_LONG_INITIATION, "Init() had failed"));
                    return;
                }
                this.K = ironSourceBannerLayout;
                this.J = Boolean.TRUE;
                this.L = str;
            } else if (!y()) {
                this.e.log(IronSourceLogger.IronSourceTag.API, "No banner configurations found", 3);
                n.a().a(IronSource.AD_UNIT.BANNER, new IronSourceError(IronSourceError.ERROR_BN_LOAD_NO_CONFIG, "the server response does not contain banner data"));
            } else {
                w wVar = this.P;
                if (wVar == null && this.S == null) {
                    this.K = ironSourceBannerLayout;
                    this.J = Boolean.TRUE;
                    this.L = str;
                } else if (this.a0) {
                    this.S.a(ironSourceBannerLayout, new Placement(l(str)));
                } else {
                    wVar.a(ironSourceBannerLayout, l(str));
                }
            }
        } else {
            this.e.log(IronSourceLogger.IronSourceTag.API, "loadBanner: Unsupported banner size. Height and width must be bigger than 0", 3);
            n.a().a(IronSource.AD_UNIT.BANNER, ErrorBuilder.unsupportedBannerSize(""));
        }
    }

    public void a(IronSourceSegment ironSourceSegment) {
        this.z = ironSourceSegment;
        sa saVar = this.R;
        if (saVar != null) {
            saVar.a(ironSourceSegment);
        }
        k5 k5Var = this.N;
        if (k5Var != null) {
            k5Var.a(ironSourceSegment);
        }
        j7 j7Var = this.Q;
        if (j7Var != null) {
            j7Var.a(ironSourceSegment);
        }
        y yVar = this.O;
        if (yVar != null) {
            yVar.a(ironSourceSegment);
        }
        w wVar = this.P;
        if (wVar != null) {
            wVar.a(ironSourceSegment);
        }
        h1 h1Var = this.S;
        if (h1Var != null) {
            h1Var.a(ironSourceSegment);
        }
        AdQualityBridge adQualityBridge = this.m0;
        if (adQualityBridge != null) {
            adQualityBridge.setSegment(ironSourceSegment);
        }
        n7.i().a(this.z);
        va.i().a(this.z);
        da.P.a(this.z);
    }

    public void a(ISDemandOnlyInterstitialListener iSDemandOnlyInterstitialListener) {
        this.o0.a(iSDemandOnlyInterstitialListener);
    }

    public void a(ISDemandOnlyRewardedVideoListener iSDemandOnlyRewardedVideoListener) {
        this.p0.a(iSDemandOnlyRewardedVideoListener);
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Code restructure failed: missing block: B:53:0x0115, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void a(com.ironsource.mediationsdk.demandOnly.h.d r8, com.ironsource.mediationsdk.demandOnly.ISDemandOnlyRewardedVideoListener r9) {
        /*
            r7 = this;
            java.lang.String r0 = r8.b()
            com.ironsource.mediationsdk.logger.IronLog r1 = com.ironsource.mediationsdk.logger.IronLog.API
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            java.lang.String r3 = "instanceId="
            r2.<init>(r3)
            r2.append(r0)
            java.lang.String r2 = r2.toString()
            r1.info(r2)
            r2 = 510(0x1fe, float:7.15E-43)
            boolean r3 = r7.F     // Catch:{ all -> 0x011e }
            if (r3 != 0) goto L_0x002b
            java.lang.String r8 = "initISDemandOnly() must be called before loadDemandOnlyRewardedVideo()"
            r1.error(r8)     // Catch:{ all -> 0x011e }
            com.ironsource.mediationsdk.logger.IronSourceError r1 = new com.ironsource.mediationsdk.logger.IronSourceError     // Catch:{ all -> 0x011e }
            r1.<init>(r2, r8)     // Catch:{ all -> 0x011e }
            r9.onRewardedVideoAdLoadFailed(r0, r1)     // Catch:{ all -> 0x011e }
            return
        L_0x002b:
            boolean r3 = r7.C     // Catch:{ all -> 0x011e }
            if (r3 != 0) goto L_0x003d
            java.lang.String r8 = "Rewarded video was initialized in mediation mode"
            r1.error(r8)     // Catch:{ all -> 0x011e }
            com.ironsource.mediationsdk.logger.IronSourceError r1 = new com.ironsource.mediationsdk.logger.IronSourceError     // Catch:{ all -> 0x011e }
            r1.<init>(r2, r8)     // Catch:{ all -> 0x011e }
            r9.onRewardedVideoAdLoadFailed(r0, r1)     // Catch:{ all -> 0x011e }
            return
        L_0x003d:
            com.ironsource.mediationsdk.s r3 = com.ironsource.mediationsdk.s.c()     // Catch:{ all -> 0x011e }
            com.ironsource.mediationsdk.s$d r3 = r3.a()     // Catch:{ all -> 0x011e }
            com.ironsource.mediationsdk.s$d r4 = com.ironsource.mediationsdk.s.d.INIT_FAILED     // Catch:{ all -> 0x011e }
            if (r3 != r4) goto L_0x005a
            java.lang.String r8 = "init() had failed"
            r1.error(r8)     // Catch:{ all -> 0x011e }
            java.lang.String r8 = "init() had failed"
            java.lang.String r1 = "Rewarded Video"
            com.ironsource.mediationsdk.logger.IronSourceError r8 = com.ironsource.mediationsdk.utils.ErrorBuilder.buildInitFailedError(r8, r1)     // Catch:{ all -> 0x011e }
            r9.onRewardedVideoAdLoadFailed(r0, r8)     // Catch:{ all -> 0x011e }
            return
        L_0x005a:
            com.ironsource.mediationsdk.logger.IronSourceError r4 = r8.c()     // Catch:{ all -> 0x011e }
            r5 = 1
            if (r4 == 0) goto L_0x0087
            int r3 = r4.getErrorCode()     // Catch:{ all -> 0x011e }
            r6 = 1060(0x424, float:1.485E-42)
            if (r3 != r6) goto L_0x007c
            java.lang.String r8 = r8.a()     // Catch:{ all -> 0x011e }
            boolean r8 = android.text.TextUtils.isEmpty(r8)     // Catch:{ all -> 0x011e }
            r8 = r8 ^ r5
            org.json.JSONObject r8 = com.ironsource.mediationsdk.utils.IronSourceUtils.getMediationAdditionalData(r5, r8, r5)     // Catch:{ all -> 0x011e }
            r3 = 81321(0x13da9, float:1.13955E-40)
            r7.b((int) r3, (org.json.JSONObject) r8)     // Catch:{ all -> 0x011e }
        L_0x007c:
            java.lang.String r8 = r4.toString()     // Catch:{ all -> 0x011e }
            r1.error(r8)     // Catch:{ all -> 0x011e }
            r9.onRewardedVideoAdLoadFailed(r0, r4)     // Catch:{ all -> 0x011e }
            return
        L_0x0087:
            android.app.Activity r4 = r8.e()     // Catch:{ all -> 0x011e }
            r7.e((android.app.Activity) r4)     // Catch:{ all -> 0x011e }
            com.ironsource.mediationsdk.s$d r4 = com.ironsource.mediationsdk.s.d.INIT_IN_PROGRESS     // Catch:{ all -> 0x011e }
            r6 = 83002(0x1443a, float:1.1631E-40)
            if (r3 != r4) goto L_0x00d7
            com.ironsource.mediationsdk.s r3 = com.ironsource.mediationsdk.s.c()     // Catch:{ all -> 0x011e }
            boolean r3 = r3.d()     // Catch:{ all -> 0x011e }
            if (r3 == 0) goto L_0x00b0
            java.lang.String r8 = "init() had failed"
            r1.error(r8)     // Catch:{ all -> 0x011e }
            java.lang.String r8 = "init() had failed"
            java.lang.String r1 = "Rewarded Video"
            com.ironsource.mediationsdk.logger.IronSourceError r8 = com.ironsource.mediationsdk.utils.ErrorBuilder.buildInitFailedError(r8, r1)     // Catch:{ all -> 0x011e }
            r9.onRewardedVideoAdLoadFailed(r0, r8)     // Catch:{ all -> 0x011e }
            goto L_0x00d3
        L_0x00b0:
            java.util.concurrent.ConcurrentHashMap<java.lang.String, com.ironsource.mediationsdk.demandOnly.h$d> r1 = r7.e0     // Catch:{ all -> 0x011e }
            monitor-enter(r1)     // Catch:{ all -> 0x011e }
            java.util.concurrent.ConcurrentHashMap<java.lang.String, com.ironsource.mediationsdk.demandOnly.h$d> r3 = r7.e0     // Catch:{ all -> 0x00d4 }
            r3.put(r0, r8)     // Catch:{ all -> 0x00d4 }
            monitor-exit(r1)     // Catch:{ all -> 0x00d4 }
            java.lang.String r1 = r8.a()     // Catch:{ all -> 0x011e }
            boolean r1 = android.text.TextUtils.isEmpty(r1)     // Catch:{ all -> 0x011e }
            if (r1 != 0) goto L_0x00d3
            java.lang.String r8 = r8.a()     // Catch:{ all -> 0x011e }
            boolean r8 = android.text.TextUtils.isEmpty(r8)     // Catch:{ all -> 0x011e }
            r8 = r8 ^ r5
            org.json.JSONObject r8 = com.ironsource.mediationsdk.utils.IronSourceUtils.getMediationAdditionalData(r5, r8, r5)     // Catch:{ all -> 0x011e }
            r7.b((int) r6, (org.json.JSONObject) r8)     // Catch:{ all -> 0x011e }
        L_0x00d3:
            return
        L_0x00d4:
            r8 = move-exception
            monitor-exit(r1)     // Catch:{ all -> 0x00d4 }
            throw r8     // Catch:{ all -> 0x011e }
        L_0x00d7:
            boolean r3 = r7.L()     // Catch:{ all -> 0x011e }
            if (r3 != 0) goto L_0x00ee
            java.lang.String r8 = "No rewarded video configurations found"
            r1.error(r8)     // Catch:{ all -> 0x011e }
            java.lang.String r8 = "the server response does not contain rewarded video data"
            java.lang.String r1 = "Rewarded Video"
            com.ironsource.mediationsdk.logger.IronSourceError r8 = com.ironsource.mediationsdk.utils.ErrorBuilder.buildInitFailedError(r8, r1)     // Catch:{ all -> 0x011e }
            r9.onRewardedVideoAdLoadFailed(r0, r8)     // Catch:{ all -> 0x011e }
            return
        L_0x00ee:
            java.util.concurrent.ConcurrentHashMap<java.lang.String, com.ironsource.mediationsdk.demandOnly.h$d> r1 = r7.e0     // Catch:{ all -> 0x011e }
            monitor-enter(r1)     // Catch:{ all -> 0x011e }
            com.ironsource.mediationsdk.demandOnly.k r3 = r7.g0     // Catch:{ all -> 0x011b }
            if (r3 != 0) goto L_0x0116
            java.util.concurrent.ConcurrentHashMap<java.lang.String, com.ironsource.mediationsdk.demandOnly.h$d> r3 = r7.e0     // Catch:{ all -> 0x011b }
            r3.put(r0, r8)     // Catch:{ all -> 0x011b }
            java.lang.String r3 = r8.a()     // Catch:{ all -> 0x011b }
            boolean r3 = android.text.TextUtils.isEmpty(r3)     // Catch:{ all -> 0x011b }
            if (r3 != 0) goto L_0x0114
            java.lang.String r8 = r8.a()     // Catch:{ all -> 0x011b }
            boolean r8 = android.text.TextUtils.isEmpty(r8)     // Catch:{ all -> 0x011b }
            r8 = r8 ^ r5
            org.json.JSONObject r8 = com.ironsource.mediationsdk.utils.IronSourceUtils.getMediationAdditionalData(r5, r8, r5)     // Catch:{ all -> 0x011b }
            r7.b((int) r6, (org.json.JSONObject) r8)     // Catch:{ all -> 0x011b }
        L_0x0114:
            monitor-exit(r1)     // Catch:{ all -> 0x011b }
            return
        L_0x0116:
            monitor-exit(r1)     // Catch:{ all -> 0x011b }
            r3.a((com.ironsource.mediationsdk.demandOnly.h.d) r8)     // Catch:{ all -> 0x011e }
            goto L_0x0134
        L_0x011b:
            r8 = move-exception
            monitor-exit(r1)     // Catch:{ all -> 0x011b }
            throw r8     // Catch:{ all -> 0x011e }
        L_0x011e:
            r8 = move-exception
            com.ironsource.mediationsdk.logger.IronLog r1 = com.ironsource.mediationsdk.logger.IronLog.API
            java.lang.String r3 = r8.getMessage()
            r1.error(r3)
            com.ironsource.mediationsdk.logger.IronSourceError r1 = new com.ironsource.mediationsdk.logger.IronSourceError
            java.lang.String r8 = r8.getMessage()
            r1.<init>(r2, r8)
            r9.onRewardedVideoAdLoadFailed(r0, r1)
        L_0x0134:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ironsource.mediationsdk.p.a(com.ironsource.mediationsdk.demandOnly.h$d, com.ironsource.mediationsdk.demandOnly.ISDemandOnlyRewardedVideoListener):void");
    }

    public void a(ImpressionDataListener impressionDataListener) {
        if (a8.a((Object) impressionDataListener, "removeImpressionDataListener - listener is null")) {
            k8.b().b(impressionDataListener);
            k5 k5Var = this.N;
            if (k5Var != null) {
                k5Var.a(impressionDataListener);
            }
            y yVar = this.O;
            if (yVar != null) {
                yVar.a(impressionDataListener);
            }
            w wVar = this.P;
            if (wVar != null) {
                wVar.a(impressionDataListener);
            }
            IronLog ironLog = IronLog.API;
            ironLog.info("remove impression data listener from " + impressionDataListener.getClass().getSimpleName());
        }
    }

    public void a(LogListener logListener) {
        if (logListener == null) {
            this.e.log(IronSourceLogger.IronSourceTag.API, "setLogListener(LogListener:null)", 1);
            return;
        }
        this.g.a(logListener);
        IronSourceLoggerManager ironSourceLoggerManager = this.e;
        IronSourceLogger.IronSourceTag ironSourceTag = IronSourceLogger.IronSourceTag.API;
        ironSourceLoggerManager.log(ironSourceTag, "setLogListener(LogListener:" + logListener.getClass().getSimpleName() + ")", 1);
    }

    public void a(InterstitialListener interstitialListener) {
        this.e.log(IronSourceLogger.IronSourceTag.API, interstitialListener == null ? "setInterstitialListener(ISListener:null)" : "setInterstitialListener(ISListener)", 1);
        this.f.a(interstitialListener);
        u5.a().a(interstitialListener);
    }

    public void a(LevelPlayInterstitialListener levelPlayInterstitialListener) {
        IronLog ironLog = IronLog.API;
        if (levelPlayInterstitialListener == null) {
            ironLog.info("ISListener is null");
        } else {
            ironLog.info();
        }
        u5.a().a(levelPlayInterstitialListener);
    }

    public void a(LevelPlayRewardedVideoListener levelPlayRewardedVideoListener) {
        IronLog ironLog = IronLog.API;
        if (levelPlayRewardedVideoListener == null) {
            ironLog.info("RVListener is null");
        } else {
            ironLog.info();
        }
        oa.a().a((LevelPlayRewardedVideoBaseListener) levelPlayRewardedVideoListener);
    }

    public synchronized void a(LevelPlayRewardedVideoManualListener levelPlayRewardedVideoManualListener) {
        IronLog ironLog;
        String str;
        if (levelPlayRewardedVideoManualListener == null) {
            IronLog.API.info("RVListener is null");
        } else {
            IronLog.API.info();
        }
        if (!this.F) {
            if (levelPlayRewardedVideoManualListener == null) {
                this.V = false;
                ironLog = IronLog.API;
                str = "Disabling rewarded video manual mode";
            } else {
                this.V = true;
                ironLog = IronLog.API;
                str = "Enabling rewarded video manual mode";
            }
            ironLog.info(str);
        }
        oa.a().a((LevelPlayRewardedVideoBaseListener) levelPlayRewardedVideoManualListener);
    }

    public void a(OfferwallListener offerwallListener) {
        this.e.log(IronSourceLogger.IronSourceTag.API, offerwallListener == null ? "setOfferwallListener(OWListener:null)" : "setOfferwallListener(OWListener)", 1);
        this.f.a(offerwallListener);
    }

    public void a(RewardedVideoListener rewardedVideoListener) {
        this.e.log(IronSourceLogger.IronSourceTag.API, rewardedVideoListener == null ? "setRewardedVideoListener(RVListener:null)" : "setRewardedVideoListener(RVListener)", 1);
        this.f.a(rewardedVideoListener);
        oa.a().a(rewardedVideoListener);
    }

    public synchronized void a(RewardedVideoManualListener rewardedVideoManualListener) {
        IronLog ironLog;
        String str;
        if (rewardedVideoManualListener == null) {
            IronLog.API.info("RVListener is null");
        } else {
            IronLog.API.info();
        }
        if (!this.F) {
            if (rewardedVideoManualListener == null) {
                this.V = false;
                ironLog = IronLog.API;
                str = "Disabling rewarded video manual mode";
            } else {
                this.V = true;
                ironLog = IronLog.API;
                str = "Enabling rewarded video manual mode";
            }
            ironLog.info(str);
        }
        this.f.a((RewardedVideoListener) rewardedVideoManualListener);
        oa.a().a((RewardedVideoListener) rewardedVideoManualListener);
    }

    /* access modifiers changed from: package-private */
    public void a(SegmentListener segmentListener) {
        q8 q8Var = this.f;
        if (q8Var != null) {
            q8Var.a(segmentListener);
            s.c().a((SegmentListener) this.f);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:24:0x0063, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized void a(java.lang.String r5) {
        /*
            r4 = this;
            java.lang.String r0 = "instanceId="
            monitor-enter(r4)
            com.ironsource.mediationsdk.logger.IronLog r1 = com.ironsource.mediationsdk.logger.IronLog.API     // Catch:{ all -> 0x0064 }
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x0064 }
            r2.<init>(r0)     // Catch:{ all -> 0x0064 }
            r2.append(r5)     // Catch:{ all -> 0x0064 }
            java.lang.String r0 = r2.toString()     // Catch:{ all -> 0x0064 }
            r1.info(r0)     // Catch:{ all -> 0x0064 }
            com.ironsource.r5<com.ironsource.mediationsdk.demandOnly.ISDemandOnlyRewardedVideoListener> r0 = r4.p0     // Catch:{ all -> 0x0064 }
            java.lang.Object r0 = r0.a((java.lang.String) r5)     // Catch:{ all -> 0x0064 }
            com.ironsource.mediationsdk.demandOnly.ISDemandOnlyRewardedVideoListener r0 = (com.ironsource.mediationsdk.demandOnly.ISDemandOnlyRewardedVideoListener) r0     // Catch:{ all -> 0x0064 }
            boolean r2 = r4.C     // Catch:{ Exception -> 0x0048 }
            r3 = 508(0x1fc, float:7.12E-43)
            if (r2 != 0) goto L_0x0031
            java.lang.String r2 = "Rewarded video was initialized in mediation mode. Use showRewardedVideo instead"
            r1.error(r2)     // Catch:{ Exception -> 0x0048 }
            com.ironsource.mediationsdk.logger.IronSourceError r1 = new com.ironsource.mediationsdk.logger.IronSourceError     // Catch:{ Exception -> 0x0048 }
            r1.<init>(r3, r2)     // Catch:{ Exception -> 0x0048 }
            r0.onRewardedVideoAdShowFailed(r5, r1)     // Catch:{ Exception -> 0x0048 }
            monitor-exit(r4)
            return
        L_0x0031:
            com.ironsource.mediationsdk.demandOnly.k r2 = r4.g0     // Catch:{ Exception -> 0x0048 }
            if (r2 != 0) goto L_0x0044
            java.lang.String r2 = "Rewarded video was not initiated"
            r1.error(r2)     // Catch:{ Exception -> 0x0048 }
            com.ironsource.mediationsdk.logger.IronSourceError r1 = new com.ironsource.mediationsdk.logger.IronSourceError     // Catch:{ Exception -> 0x0048 }
            r1.<init>(r3, r2)     // Catch:{ Exception -> 0x0048 }
            r0.onRewardedVideoAdShowFailed(r5, r1)     // Catch:{ Exception -> 0x0048 }
            monitor-exit(r4)
            return
        L_0x0044:
            r2.b(r5)     // Catch:{ Exception -> 0x0048 }
            goto L_0x0062
        L_0x0048:
            r1 = move-exception
            com.ironsource.mediationsdk.logger.IronLog r2 = com.ironsource.mediationsdk.logger.IronLog.API     // Catch:{ all -> 0x0064 }
            java.lang.String r3 = r1.getMessage()     // Catch:{ all -> 0x0064 }
            r2.error(r3)     // Catch:{ all -> 0x0064 }
            if (r0 == 0) goto L_0x0062
            com.ironsource.mediationsdk.logger.IronSourceError r2 = new com.ironsource.mediationsdk.logger.IronSourceError     // Catch:{ all -> 0x0064 }
            java.lang.String r1 = r1.getMessage()     // Catch:{ all -> 0x0064 }
            r3 = 510(0x1fe, float:7.15E-43)
            r2.<init>(r3, r1)     // Catch:{ all -> 0x0064 }
            r0.onRewardedVideoAdShowFailed(r5, r2)     // Catch:{ all -> 0x0064 }
        L_0x0062:
            monitor-exit(r4)
            return
        L_0x0064:
            r5 = move-exception
            monitor-exit(r4)
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ironsource.mediationsdk.p.a(java.lang.String):void");
    }

    public void a(String str, String str2) {
    }

    public void a(String str, List<String> list) {
        IronLog ironLog = IronLog.API;
        ironLog.verbose("key = " + str + ", values = " + list.toString());
        String checkMetaDataKeyValidity = MetaDataUtils.checkMetaDataKeyValidity(str);
        String checkMetaDataValueValidity = MetaDataUtils.checkMetaDataValueValidity(list);
        if (checkMetaDataKeyValidity.length() > 0) {
            ironLog.verbose(checkMetaDataKeyValidity);
        } else if (checkMetaDataValueValidity.length() > 0) {
            ironLog.verbose(checkMetaDataValueValidity);
        } else {
            MetaData formatMetaData = MetaDataUtils.formatMetaData(str, list);
            String metaDataKey = formatMetaData.getMetaDataKey();
            List<String> metaDataValue = formatMetaData.getMetaDataValue();
            if (!MetaDataUtils.isMediationOnlyKey(metaDataKey)) {
                c.b().a(metaDataKey, metaDataValue);
            } else if (s.c().a() != s.d.INITIATED || !MetaDataUtils.isMediationKeysBeforeInit(metaDataKey)) {
                k8.b().a(metaDataKey, metaDataValue);
            } else {
                ironLog.error("setMetaData with key = " + metaDataKey + " must to be called before init");
            }
            try {
                ConcurrentHashMap<String, List<String>> c2 = c.b().c();
                c2.putAll(k8.b().c());
                JSONObject jSONObject = new JSONObject();
                for (Map.Entry next : c2.entrySet()) {
                    jSONObject.put((String) next.getKey(), next.getValue());
                }
                this.j0.a(jSONObject);
            } catch (JSONException e2) {
                IronLog ironLog2 = IronLog.INTERNAL;
                ironLog2.error("got the following error " + e2.getMessage());
                e2.printStackTrace();
            }
            va.i().a(new y3(s.c().a() == s.d.INITIATED ? 51 : 50, IronSourceUtils.getJsonForMetaData(str, list, metaDataValue)));
        }
    }

    public void a(String str, JSONObject jSONObject) {
        if (a8.a((Object) jSONObject, "setAdRevenueData - impressionData is null") && a8.a((Object) str, "setAdRevenueData - dataSource is null")) {
            this.i0.a(str, jSONObject);
        }
    }

    public void a(List<IronSource.AD_UNIT> list, boolean z2, g2 g2Var) {
        IronLog.INTERNAL.verbose();
        try {
            this.g.a(g2Var.b().g().d());
            this.s = list;
            this.r = true;
            this.e.log(IronSourceLogger.IronSourceTag.API, "onInitSuccess()", 1);
            IronSourceUtils.sendAutomationLog("init success");
            if (z2) {
                JSONObject mediationAdditionalData = IronSourceUtils.getMediationAdditionalData(false);
                try {
                    mediationAdditionalData.put("revived", true);
                } catch (JSONException e2) {
                    e2.printStackTrace();
                }
                va.i().a(new y3(114, mediationAdditionalData));
            }
            n7.i().h();
            va.i().h();
            c.b().b(p(), q());
            for (IronSource.AD_UNIT ad_unit : IronSource.AD_UNIT.values()) {
                if (this.w.contains(ad_unit)) {
                    if (list.contains(ad_unit)) {
                        b(ad_unit);
                    } else {
                        a(ad_unit, false);
                    }
                }
            }
            if (w() && U()) {
                AdQualityBridge adQualityBridge = new AdQualityBridge(ContextProvider.getInstance().getApplicationContext(), p(), q(), new n(), this.j.b().b().g().a());
                this.m0 = adQualityBridge;
                IronSourceSegment ironSourceSegment = this.z;
                if (ironSourceSegment != null) {
                    adQualityBridge.setSegment(ironSourceSegment);
                }
            }
            R();
        } catch (Exception e3) {
            e3.printStackTrace();
        }
    }

    public void a(Map<String, String> map) {
        if (map != null) {
            try {
                if (map.size() != 0) {
                    this.e.log(IronSourceLogger.IronSourceTag.API, this.a + ":setRewardedVideoServerParameters(params:" + map.toString() + ")", 1);
                    this.o = new HashMap(map);
                }
            } catch (Exception e2) {
                IronSourceLoggerManager ironSourceLoggerManager = this.e;
                IronSourceLogger.IronSourceTag ironSourceTag = IronSourceLogger.IronSourceTag.API;
                ironSourceLoggerManager.logException(ironSourceTag, this.a + ":setRewardedVideoServerParameters(params:" + map.toString() + ")", e2);
            }
        }
    }

    public void a(boolean z2) {
        IronSourceLoggerManager logger = IronSourceLoggerManager.getLogger();
        IronSourceLogger.IronSourceTag ironSourceTag = IronSourceLogger.IronSourceTag.API;
        logger.log(ironSourceTag, "setAdaptersDebug : " + z2, 1);
        c.b().a(z2);
    }

    public IronSourceBannerLayout b(Activity activity, ISBannerSize iSBannerSize) {
        IronSourceLoggerManager ironSourceLoggerManager = this.e;
        IronSourceLogger.IronSourceTag ironSourceTag = IronSourceLogger.IronSourceTag.API;
        ironSourceLoggerManager.log(ironSourceTag, "createBanner()", 1);
        if (activity == null) {
            this.e.log(ironSourceTag, "createBanner() : Activity cannot be null", 3);
            return null;
        }
        ContextProvider.getInstance().updateActivity(activity);
        return new IronSourceBannerLayout(activity, iSBannerSize);
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0090, code lost:
        return r9;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.ironsource.mediationsdk.utils.c b(android.content.Context r7, java.lang.String r8, com.ironsource.mediationsdk.p.c r9) {
        /*
            r6 = this;
            java.lang.Object r0 = r6.i
            monitor-enter(r0)
            com.ironsource.mediationsdk.utils.c r1 = r6.j     // Catch:{ all -> 0x0091 }
            if (r1 == 0) goto L_0x000e
            com.ironsource.mediationsdk.utils.c r7 = new com.ironsource.mediationsdk.utils.c     // Catch:{ all -> 0x0091 }
            r7.<init>(r1)     // Catch:{ all -> 0x0091 }
            monitor-exit(r0)     // Catch:{ all -> 0x0091 }
            return r7
        L_0x000e:
            com.ironsource.mediationsdk.utils.c r9 = r6.a((android.content.Context) r7, (java.lang.String) r8, (com.ironsource.mediationsdk.p.c) r9)     // Catch:{ all -> 0x0091 }
            r1 = 1
            if (r9 == 0) goto L_0x001b
            boolean r2 = r9.m()     // Catch:{ all -> 0x0091 }
            if (r2 != 0) goto L_0x006c
        L_0x001b:
            com.ironsource.mediationsdk.logger.IronSourceLoggerManager r9 = com.ironsource.mediationsdk.logger.IronSourceLoggerManager.getLogger()     // Catch:{ all -> 0x0091 }
            com.ironsource.mediationsdk.logger.IronSourceLogger$IronSourceTag r2 = com.ironsource.mediationsdk.logger.IronSourceLogger.IronSourceTag.INTERNAL     // Catch:{ all -> 0x0091 }
            java.lang.String r3 = "Null or invalid response. Trying to get cached response"
            r4 = 0
            r9.log(r2, r3, r4)     // Catch:{ all -> 0x0091 }
            java.lang.String r9 = r6.p()     // Catch:{ all -> 0x0091 }
            com.ironsource.mediationsdk.utils.c r9 = r6.a((android.content.Context) r7, (java.lang.String) r9)     // Catch:{ all -> 0x0091 }
            if (r9 == 0) goto L_0x006c
            java.lang.String r3 = r6.p()     // Catch:{ all -> 0x0091 }
            com.ironsource.mediationsdk.logger.IronSourceError r8 = com.ironsource.mediationsdk.utils.ErrorBuilder.buildUsingCachedConfigurationError(r3, r8)     // Catch:{ all -> 0x0091 }
            com.ironsource.mediationsdk.logger.IronSourceLoggerManager r3 = r6.e     // Catch:{ all -> 0x0091 }
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ all -> 0x0091 }
            r5.<init>()     // Catch:{ all -> 0x0091 }
            java.lang.String r8 = r8.toString()     // Catch:{ all -> 0x0091 }
            r5.append(r8)     // Catch:{ all -> 0x0091 }
            java.lang.String r8 = ": "
            r5.append(r8)     // Catch:{ all -> 0x0091 }
            java.lang.String r8 = r9.toString()     // Catch:{ all -> 0x0091 }
            r5.append(r8)     // Catch:{ all -> 0x0091 }
            java.lang.String r8 = r5.toString()     // Catch:{ all -> 0x0091 }
            r3.log(r2, r8, r1)     // Catch:{ all -> 0x0091 }
            org.json.JSONObject r8 = com.ironsource.mediationsdk.utils.IronSourceUtils.getMediationAdditionalData(r4)     // Catch:{ all -> 0x0091 }
            com.ironsource.y3 r2 = new com.ironsource.y3     // Catch:{ all -> 0x0091 }
            r3 = 140(0x8c, float:1.96E-43)
            r2.<init>(r3, r8)     // Catch:{ all -> 0x0091 }
            com.ironsource.va r8 = com.ironsource.va.i()     // Catch:{ all -> 0x0091 }
            r8.a((com.ironsource.y3) r2)     // Catch:{ all -> 0x0091 }
        L_0x006c:
            if (r9 == 0) goto L_0x008f
            r6.j = r9     // Catch:{ all -> 0x0091 }
            java.lang.String r8 = r9.toString()     // Catch:{ all -> 0x0091 }
            com.ironsource.mediationsdk.utils.IronSourceUtils.saveLastResponse(r7, r8)     // Catch:{ all -> 0x0091 }
            com.ironsource.mediationsdk.utils.c r8 = r6.j     // Catch:{ all -> 0x0091 }
            r6.b((com.ironsource.mediationsdk.utils.c) r8, (android.content.Context) r7)     // Catch:{ all -> 0x0091 }
            com.ironsource.n7 r7 = com.ironsource.n7.i()     // Catch:{ all -> 0x0091 }
            r7.c((boolean) r1)     // Catch:{ all -> 0x0091 }
            com.ironsource.va r7 = com.ironsource.va.i()     // Catch:{ all -> 0x0091 }
            r7.c((boolean) r1)     // Catch:{ all -> 0x0091 }
            com.ironsource.da r7 = com.ironsource.da.P     // Catch:{ all -> 0x0091 }
            r7.c((boolean) r1)     // Catch:{ all -> 0x0091 }
        L_0x008f:
            monitor-exit(r0)     // Catch:{ all -> 0x0091 }
            return r9
        L_0x0091:
            r7 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x0091 }
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ironsource.mediationsdk.p.b(android.content.Context, java.lang.String, com.ironsource.mediationsdk.p$c):com.ironsource.mediationsdk.utils.c");
    }

    public String b(Context context) {
        String N2 = m3.N(context);
        return !TextUtils.isEmpty(N2) ? N2 : "";
    }

    /* access modifiers changed from: package-private */
    public HashSet<String> b(String str, String str2) {
        com.ironsource.mediationsdk.utils.c cVar = this.j;
        return cVar == null ? new HashSet<>() : cVar.i().a(str, str2);
    }

    public void b() {
        this.o = null;
    }

    public void b(Activity activity) {
        try {
            this.e.log(IronSourceLogger.IronSourceTag.API, "onResume()", 1);
            ContextProvider.getInstance().onResume(activity);
        } catch (Throwable th) {
            this.e.logException(IronSourceLogger.IronSourceTag.API, "onResume()", th);
        }
    }

    public synchronized void b(Activity activity, String str) {
        a(new h.c().b(str).a(activity, ContextProvider.getInstance().getCurrentActiveActivity()).a(IronSource.AD_UNIT.REWARDED_VIDEO).b(), this.p0.a(str));
    }

    public synchronized void b(Activity activity, String str, String str2) {
        a(new h.c().b(str).a(activity, ContextProvider.getInstance().getCurrentActiveActivity()).a(IronSource.AD_UNIT.INTERSTITIAL).a(true).a(str2).b(), this.o0.a(str));
    }

    public void b(IronSourceBannerLayout ironSourceBannerLayout) {
        a(ironSourceBannerLayout, "");
    }

    public void b(ImpressionDataListener impressionDataListener) {
        if (a8.a((Object) impressionDataListener, "addImpressionDataListener - listener is null")) {
            k8.b().a(impressionDataListener);
            k5 k5Var = this.N;
            if (k5Var != null) {
                k5Var.b(impressionDataListener);
            }
            y yVar = this.O;
            if (yVar != null) {
                yVar.b(impressionDataListener);
            }
            w wVar = this.P;
            if (wVar != null) {
                wVar.b(impressionDataListener);
            }
            IronLog ironLog = IronLog.API;
            ironLog.info("add impression data listener to " + impressionDataListener.getClass().getSimpleName());
        }
    }

    public void b(String str) {
        IronSourceLoggerManager ironSourceLoggerManager = this.e;
        IronSourceLogger.IronSourceTag ironSourceTag = IronSourceLogger.IronSourceTag.API;
        ironSourceLoggerManager.log(ironSourceTag, "showDemandOnlyInterstitial() instanceId=" + str, 1);
        ISDemandOnlyInterstitialListener a2 = this.o0.a(str);
        try {
            if (!this.D) {
                IronLog.API.error("Interstitial was initialized in mediation mode. Use showInterstitial instead");
                a2.onInterstitialAdShowFailed(str, new IronSourceError(IronSourceError.ERROR_CODE_INIT_FAILED, "Interstitial was initialized in mediation mode. Use showInterstitial instead"));
                return;
            }
            f fVar = this.f0;
            if (fVar == null) {
                IronLog.API.error("Interstitial was not initiated");
                a2.onInterstitialAdShowFailed(str, new IronSourceError(IronSourceError.ERROR_CODE_INIT_FAILED, "Interstitial was not initiated"));
                return;
            }
            fVar.a(str);
        } catch (Exception e2) {
            IronLog.API.error(e2.getMessage());
            if (a2 != null) {
                a2.onInterstitialAdShowFailed(str, ErrorBuilder.buildInitFailedError("showISDemandOnlyInterstitial can't be called before the Interstitial ad unit initialization completed successfully", "Interstitial"));
            }
        }
    }

    public void b(String str, JSONObject jSONObject) {
        String str2 = "networkKey = " + str;
        if (jSONObject != null) {
            str2 = str2 + " networkData = " + jSONObject;
        }
        IronLog.API.verbose(str2);
        c.b().a(str, jSONObject);
    }

    public void b(boolean z2) {
        this.M = Boolean.valueOf(z2);
        IronSourceLoggerManager logger = IronSourceLoggerManager.getLogger();
        IronSourceLogger.IronSourceTag ironSourceTag = IronSourceLogger.IronSourceTag.API;
        logger.log(ironSourceTag, "setConsent : " + z2, 1);
        c.b().b(z2);
        if (this.c != null) {
            IronSourceLoggerManager ironSourceLoggerManager = this.e;
            IronSourceLogger.IronSourceTag ironSourceTag2 = IronSourceLogger.IronSourceTag.ADAPTER_API;
            ironSourceLoggerManager.log(ironSourceTag2, "Offerwall | setConsent(consent:" + z2 + ")", 1);
            this.c.setConsent(z2);
        }
        int i2 = !z2 ? 41 : 40;
        this.j0.a(z2);
        va.i().a(new y3(i2, IronSourceUtils.getMediationAdditionalData(false)));
    }

    public void c() {
        try {
            this.e.log(IronSourceLogger.IronSourceTag.API, "showOfferwall()", 1);
            if (!I()) {
                this.f.onOfferwallShowFailed(ErrorBuilder.buildInitFailedError("showOfferwall can't be called before the Offerwall ad unit initialization completed successfully", IronSourceConstants.OFFERWALL_AD_UNIT));
                return;
            }
            q9 a2 = this.j.b().f().a();
            if (a2 != null) {
                j(a2.getPlacementName());
            }
        } catch (Exception e2) {
            this.e.logException(IronSourceLogger.IronSourceTag.API, "showOfferwall()", e2);
            this.f.onOfferwallShowFailed(ErrorBuilder.buildInitFailedError("showOfferwall can't be called before the Offerwall ad unit initialization completed successfully", IronSourceConstants.OFFERWALL_AD_UNIT));
        }
    }

    public void c(Activity activity) {
        IronSourceLoggerManager ironSourceLoggerManager = this.e;
        IronSourceLogger.IronSourceTag ironSourceTag = IronSourceLogger.IronSourceTag.API;
        ironSourceLoggerManager.log(ironSourceTag, "showInterstitial()", 1);
        try {
            if (this.D) {
                this.e.log(ironSourceTag, "Interstitial was initialized in demand only mode. Use showISDemandOnlyInterstitial instead", 3);
                u5.a().a(new IronSourceError(510, "Interstitial was initialized in demand only mode. Use showISDemandOnlyInterstitial instead"), (AdInfo) null);
            } else if (!B()) {
                u5.a().a(ErrorBuilder.buildInitFailedError("showInterstitial can't be called before the Interstitial ad unit initialization completed successfully", "Interstitial"), (AdInfo) null);
            } else {
                InterstitialPlacement l2 = l();
                if (l2 != null) {
                    c(activity, l2.getPlacementName());
                } else {
                    u5.a().a(new IronSourceError(1020, "showInterstitial error: empty default placement in response"), (AdInfo) null);
                }
            }
        } catch (Exception e2) {
            this.e.logException(IronSourceLogger.IronSourceTag.API, "showInterstitial()", e2);
            u5.a().a(new IronSourceError(510, e2.getMessage()), (AdInfo) null);
        }
    }

    public void c(Activity activity, String str) {
        String str2 = "showInterstitial(" + str + ")";
        IronSourceLoggerManager ironSourceLoggerManager = this.e;
        IronSourceLogger.IronSourceTag ironSourceTag = IronSourceLogger.IronSourceTag.API;
        ironSourceLoggerManager.log(ironSourceTag, str2, 1);
        try {
            if (this.D) {
                this.e.log(ironSourceTag, "Interstitial was initialized in demand only mode. Use showISDemandOnlyInterstitial instead", 3);
                u5.a().a(new IronSourceError(510, "Interstitial was initialized in demand only mode. Use showISDemandOnlyInterstitial instead"), (AdInfo) null);
            } else if (!B()) {
                u5.a().a(ErrorBuilder.buildInitFailedError("showInterstitial can't be called before the Interstitial ad unit initialization completed successfully", "Interstitial"), (AdInfo) null);
            } else {
                d(activity, str);
            }
        } catch (Exception e2) {
            this.e.logException(IronSourceLogger.IronSourceTag.API, str2, e2);
            u5.a().a(new IronSourceError(510, e2.getMessage()), (AdInfo) null);
        }
    }

    public void c(String str) {
        this.e.log(IronSourceLogger.IronSourceTag.API, "destroyBanner()", 1);
        try {
            com.ironsource.mediationsdk.demandOnly.c cVar = this.h0;
            if (cVar != null) {
                cVar.a(str);
            }
        } catch (Throwable th) {
            this.e.logException(IronSourceLogger.IronSourceTag.API, "destroyISDemandOnlyBanner()", th);
        }
    }

    public void d() {
        this.e.log(IronSourceLogger.IronSourceTag.API, "removeRewardedVideoListener()", 1);
        this.f.a((RewardedVideoListener) null);
        oa.a().a((RewardedVideoListener) null);
        oa.a().a((LevelPlayRewardedVideoBaseListener) null);
    }

    public void d(Activity activity) {
        if (!K()) {
            oa.a().a(ErrorBuilder.buildInitFailedError("showRewardedVideo can't be called before the Rewarded Video ad unit initialization completed successfully", IronSourceConstants.REWARDED_VIDEO_AD_UNIT), (AdInfo) null);
            this.e.log(IronSourceLogger.IronSourceTag.INTERNAL, "showRewardedVideo can't be called before the Rewarded Video ad unit initialization completed successfully", 3);
            return;
        }
        Placement m2 = m();
        if (m2 == null) {
            this.e.log(IronSourceLogger.IronSourceTag.INTERNAL, "showRewardedVideo error: empty default placement in response", 3);
            oa.a().a(new IronSourceError(1021, "showRewardedVideo error: empty default placement in response"), (AdInfo) null);
            return;
        }
        f(activity, m2.getPlacementName());
    }

    public void d(Context context) {
        rb rbVar = rb.a;
        rbVar.b();
        if (!this.r) {
            rbVar.a((int) IronSourceConstants.errorCode_TEST_SUITE_SDK_NOT_INITIALIZED);
            IronLog.API.error("TestSuite cannot be launched, SDK not initialized");
        } else if (!b(this.j)) {
            rbVar.a((int) IronSourceConstants.errorCode_TEST_SUITE_DISABLED);
            IronLog.API.error("TestSuite cannot be launched, Please contact your account manager to enable it");
        } else if (!IronSourceUtils.isNetworkConnected(context)) {
            rbVar.a((int) IronSourceConstants.errorCode_TEST_SUITE_NO_NETWORK_CONNECTIVITY);
            IronLog.API.error("TestSuite cannot be launched, No network connectivity");
        } else {
            j7 j7Var = this.Q;
            if (j7Var != null) {
                j7Var.F();
            }
            sa saVar = this.R;
            if (saVar != null) {
                saVar.F();
            }
            h1 h1Var = this.S;
            if (h1Var != null) {
                h1Var.F();
                this.S.K();
            }
            new sb().a(context, p(), this.j.g(), IronSourceUtils.getSDKVersion(), this.j.b().h().b(), j(), this.V);
            this.l0 = true;
            rbVar.c();
        }
    }

    public void d(String str) {
        try {
            IronSourceLoggerManager ironSourceLoggerManager = this.e;
            IronSourceLogger.IronSourceTag ironSourceTag = IronSourceLogger.IronSourceTag.API;
            ironSourceLoggerManager.log(ironSourceTag, "onInitFailed(reason:" + str + ")", 1);
            IronSourceUtils.sendAutomationLog("Mediation init failed");
            if (this.f != null) {
                for (IronSource.AD_UNIT a2 : this.w) {
                    a(a2, true);
                }
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public void e() {
        this.e.log(IronSourceLogger.IronSourceTag.API, "removeOfferwallListener()", 1);
        this.f.a((OfferwallListener) null);
    }

    public boolean e(String str) {
        try {
            IronSourceLoggerManager ironSourceLoggerManager = this.e;
            IronSourceLogger.IronSourceTag ironSourceTag = IronSourceLogger.IronSourceTag.API;
            ironSourceLoggerManager.log(ironSourceTag, this.a + ":setDynamicUserId(dynamicUserId:" + str + ")", 1);
            f2 f2Var = new f2();
            a(str, f2Var);
            if (f2Var.b()) {
                this.n = str;
                va.i().a(new y3(52, IronSourceUtils.getJsonForUserId(true)));
                return true;
            }
            IronSourceLoggerManager.getLogger().log(ironSourceTag, f2Var.a().toString(), 2);
            return false;
        } catch (Exception e2) {
            this.e.logException(IronSourceLogger.IronSourceTag.API, this.a + ":setDynamicUserId(dynamicUserId:" + str + ")", e2);
            return false;
        }
    }

    public void f() {
        this.e.log(IronSourceLogger.IronSourceTag.API, "removeInterstitialListener()", 1);
        this.f.a((InterstitialListener) null);
        u5.a().a((InterstitialListener) null);
        u5.a().a((LevelPlayInterstitialListener) null);
    }

    public void f(Activity activity, String str) {
        String str2 = "showRewardedVideo(" + str + ")";
        IronSourceLoggerManager ironSourceLoggerManager = this.e;
        IronSourceLogger.IronSourceTag ironSourceTag = IronSourceLogger.IronSourceTag.API;
        ironSourceLoggerManager.log(ironSourceTag, str2, 1);
        try {
            if (this.C) {
                this.e.log(ironSourceTag, "Rewarded Video was initialized in demand only mode. Use showISDemandOnlyRewardedVideo instead", 3);
                oa.a().a(ErrorBuilder.buildInitFailedError("Rewarded Video was initialized in demand only mode. Use showISDemandOnlyRewardedVideo instead", IronSourceConstants.REWARDED_VIDEO_AD_UNIT), (AdInfo) null);
            } else if (!K()) {
                oa.a().a(ErrorBuilder.buildInitFailedError("showRewardedVideo can't be called before the Rewarded Video ad unit initialization completed successfully", IronSourceConstants.REWARDED_VIDEO_AD_UNIT), (AdInfo) null);
            } else {
                e(activity, str);
            }
        } catch (Exception e2) {
            this.e.logException(IronSourceLogger.IronSourceTag.API, str2, e2);
            oa.a().a(new IronSourceError(510, e2.getMessage()), (AdInfo) null);
        }
    }

    public synchronized boolean f(String str) {
        f fVar;
        fVar = this.f0;
        return fVar != null && fVar.b(str);
    }

    public InterstitialPlacement g(String str) {
        try {
            InterstitialPlacement n2 = n(str);
            if (n2 == null) {
                try {
                    this.e.log(IronSourceLogger.IronSourceTag.API, "Placement is not valid, please make sure you are using the right placements, using the default placement.", 2);
                    n2 = l();
                } catch (Exception unused) {
                    return n2;
                }
            }
            IronSourceLoggerManager ironSourceLoggerManager = this.e;
            IronSourceLogger.IronSourceTag ironSourceTag = IronSourceLogger.IronSourceTag.API;
            ironSourceLoggerManager.log(ironSourceTag, "getPlacementInfo(placement: " + str + "):" + n2, 1);
            return n2;
        } catch (Exception unused2) {
            return null;
        }
    }

    public void getOfferwallCredits() {
        this.e.log(IronSourceLogger.IronSourceTag.API, "getOfferwallCredits()", 1);
        try {
            this.d.getOfferwallCredits();
        } catch (Throwable th) {
            this.e.logException(IronSourceLogger.IronSourceTag.API, "getOfferwallCredits()", th);
        }
    }

    public String h() {
        String str;
        if (!this.I) {
            str = "init() must be called first";
        } else {
            s c2 = s.c();
            int i2 = b.b[c2.a().ordinal()];
            if (i2 != 1) {
                if (i2 != 2) {
                    str = "";
                } else if (!c2.d()) {
                    str = "init() not finished yet";
                }
            }
            str = "init() had failed";
        }
        return (G() || !str.isEmpty()) ? str : "No Native Ad configurations found";
    }

    public void h(String str) {
        try {
            IronSourceLoggerManager ironSourceLoggerManager = this.e;
            IronSourceLogger.IronSourceTag ironSourceTag = IronSourceLogger.IronSourceTag.INTERNAL;
            ironSourceLoggerManager.log(ironSourceTag, this.a + ":setMediationType(mediationType:" + str + ")", 1);
            if (!a(str, 1, 64) || !w(str)) {
                this.e.log(ironSourceTag, " mediationType value is invalid - should be alphanumeric and 1-64 chars in length", 1);
                return;
            }
            this.p = str;
            this.j0.d(str);
        } catch (Exception e2) {
            this.e.logException(IronSourceLogger.IronSourceTag.API, this.a + ":setMediationType(mediationType:" + str + ")", e2);
        }
    }

    public e9 i() {
        IronLog.INTERNAL.verbose();
        List<NetworkSettings> a2 = a(this.j.h().c());
        if (a2.size() > 0) {
            return new e9(a2, this.j.b().e(), IronSourceUtils.getUserIdForNetworks(), k8.b(), this.z, this.j.k());
        }
        JSONObject mediationAdditionalData = IronSourceUtils.getMediationAdditionalData(false, true, 1);
        a(mediationAdditionalData, new Object[][]{new Object[]{"errorCode", 1010}});
        a((int) IronSourceConstants.TROUBLESHOOTING_NT_INIT_FAILED, mediationAdditionalData);
        return null;
    }

    public Placement i(String str) {
        try {
            Placement r2 = r(str);
            if (r2 == null) {
                try {
                    this.e.log(IronSourceLogger.IronSourceTag.API, "Placement is not valid, please make sure you are using the right placements, using the default placement.", 2);
                    r2 = m();
                } catch (Exception unused) {
                    return r2;
                }
            }
            IronSourceLoggerManager ironSourceLoggerManager = this.e;
            IronSourceLogger.IronSourceTag ironSourceTag = IronSourceLogger.IronSourceTag.API;
            ironSourceLoggerManager.log(ironSourceTag, "getPlacementInfo(placement: " + str + "):" + r2, 1);
            return r2;
        } catch (Exception unused2) {
            return null;
        }
    }

    public boolean isOfferwallAvailable() {
        try {
            v vVar = this.d;
            if (vVar != null) {
                return vVar.isOfferwallAvailable();
            }
            return false;
        } catch (Exception unused) {
            return false;
        }
    }

    /* access modifiers changed from: package-private */
    public Boolean j() {
        return this.M;
    }

    public void j(String str) {
        String str2 = "showOfferwall(" + str + ")";
        IronSourceLoggerManager ironSourceLoggerManager = this.e;
        IronSourceLogger.IronSourceTag ironSourceTag = IronSourceLogger.IronSourceTag.API;
        ironSourceLoggerManager.log(ironSourceTag, str2, 1);
        try {
            if (!I()) {
                this.f.onOfferwallShowFailed(ErrorBuilder.buildInitFailedError("showOfferwall can't be called before the Offerwall ad unit initialization completed successfully", IronSourceConstants.OFFERWALL_AD_UNIT));
                return;
            }
            q9 a2 = this.j.b().f().a(str);
            if (a2 == null) {
                this.e.log(ironSourceTag, "Placement is not valid, please make sure you are using the right placements, using the default placement.", 3);
                a2 = this.j.b().f().a();
                if (a2 == null) {
                    this.e.log(ironSourceTag, "Default placement was not found, please make sure you are using the right placements.", 3);
                    return;
                }
            }
            this.d.j(a2.getPlacementName());
        } catch (Exception e2) {
            this.e.logException(IronSourceLogger.IronSourceTag.API, str2, e2);
            this.f.onOfferwallShowFailed(ErrorBuilder.buildInitFailedError("showOfferwall can't be called before the Offerwall ad unit initialization completed successfully", IronSourceConstants.OFFERWALL_AD_UNIT));
        }
    }

    public com.ironsource.mediationsdk.utils.c k() {
        return this.j;
    }

    public synchronized boolean k(String str) {
        k kVar;
        kVar = this.g0;
        return kVar != null && kVar.a(str);
    }

    public String n() {
        return this.n;
    }

    public g9 o(String str) {
        a9 e2 = this.j.b().e();
        if (e2 == null) {
            return null;
        }
        if (TextUtils.isEmpty(str)) {
            return e2.e();
        }
        g9 a2 = e2.a(str);
        return a2 != null ? a2 : e2.e();
    }

    /* access modifiers changed from: package-private */
    public synchronized AbstractAdapter p(String str) {
        try {
            AbstractAdapter abstractAdapter = this.c;
            if (abstractAdapter != null && abstractAdapter.getProviderName().equals(str)) {
                return this.c;
            }
        } catch (Exception e2) {
            IronSourceLoggerManager ironSourceLoggerManager = this.e;
            IronSourceLogger.IronSourceTag ironSourceTag = IronSourceLogger.IronSourceTag.INTERNAL;
            ironSourceLoggerManager.log(ironSourceTag, "getOfferwallAdapter exception: " + e2, 1);
        }
        return null;
    }

    public String p() {
        return this.k;
    }

    public String q() {
        return this.l;
    }

    public String r() {
        return this.p;
    }

    public Map<String, String> s() {
        return this.o;
    }

    /* access modifiers changed from: package-private */
    public boolean s(String str) {
        if (!x()) {
            return false;
        }
        m1 m1Var = null;
        try {
            m1Var = this.j.b().c().a(str);
            if (m1Var == null && (m1Var = this.j.b().c().j()) == null) {
                this.e.log(IronSourceLogger.IronSourceTag.API, "Banner default placement was not found", 3);
                return false;
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        if (m1Var == null) {
            return false;
        }
        return com.ironsource.mediationsdk.utils.b.d(ContextProvider.getInstance().getApplicationContext(), m1Var.getPlacementName());
    }

    public String t() {
        return this.t;
    }

    /* access modifiers changed from: package-private */
    public boolean t(String str) {
        boolean z2 = false;
        if (this.D) {
            return false;
        }
        if (m(str) != b.C0017b.NOT_CAPPED) {
            z2 = true;
        }
        if (z2) {
            JSONObject mediationAdditionalData = IronSourceUtils.getMediationAdditionalData(this.D, true, 1);
            try {
                mediationAdditionalData.put("placement", str);
                mediationAdditionalData.put(IronSourceConstants.EVENTS_PROGRAMMATIC, 1);
            } catch (Exception unused) {
            }
            n7.i().a(new y3(IronSourceConstants.IS_CHECK_CAPPED_TRUE, mediationAdditionalData));
        }
        return z2;
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Code restructure failed: missing block: B:7:0x0015, code lost:
        if (r0 != 3) goto L_0x0017;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean u(java.lang.String r4) {
        /*
            r3 = this;
            com.ironsource.mediationsdk.utils.b$b r0 = r3.q(r4)
            if (r0 == 0) goto L_0x0017
            int[] r1 = com.ironsource.mediationsdk.p.b.c
            int r0 = r0.ordinal()
            r0 = r1[r0]
            r1 = 1
            if (r0 == r1) goto L_0x0018
            r2 = 2
            if (r0 == r2) goto L_0x0018
            r2 = 3
            if (r0 == r2) goto L_0x0018
        L_0x0017:
            r1 = 0
        L_0x0018:
            r3.a((boolean) r1, (java.lang.String) r4)
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ironsource.mediationsdk.p.u(java.lang.String):boolean");
    }

    /* access modifiers changed from: package-private */
    public void v(String str) {
        IronLog ironLog = IronLog.API;
        ironLog.verbose("userId = " + str);
        this.l = str;
        va.i().a(new y3(52, IronSourceUtils.getJsonForUserId(false)));
        AdQualityBridge adQualityBridge = this.m0;
        if (adQualityBridge != null) {
            adQualityBridge.changeUserId(str);
        }
    }
}
