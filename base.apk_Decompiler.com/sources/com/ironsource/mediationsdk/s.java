package com.ironsource.mediationsdk;

import android.content.Context;
import android.content.IntentFilter;
import android.os.CountDownTimer;
import android.os.Handler;
import android.text.TextUtils;
import com.ironsource.environment.ContextProvider;
import com.ironsource.environment.NetworkStateReceiver;
import com.ironsource.environment.thread.IronSourceThreadManager;
import com.ironsource.gb;
import com.ironsource.ib;
import com.ironsource.j0;
import com.ironsource.j3;
import com.ironsource.l0;
import com.ironsource.l9;
import com.ironsource.mediationsdk.IronSource;
import com.ironsource.mediationsdk.integration.IntegrationHelper;
import com.ironsource.mediationsdk.logger.IronLog;
import com.ironsource.mediationsdk.logger.IronSourceLogger;
import com.ironsource.mediationsdk.logger.IronSourceLoggerManager;
import com.ironsource.mediationsdk.p;
import com.ironsource.mediationsdk.sdk.SegmentListener;
import com.ironsource.mediationsdk.utils.IronSourceConstants;
import com.ironsource.mediationsdk.utils.IronSourceUtils;
import com.ironsource.mediationsdk.utils.c;
import com.ironsource.o0;
import com.ironsource.q4;
import com.ironsource.s2;
import com.ironsource.u9;
import com.ironsource.w7;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;

class s implements l9 {
    private static s A;
    /* access modifiers changed from: private */
    public ib a;
    private int b = e.e;
    private final String c = "appKey";
    private final String d = getClass().getSimpleName();
    /* access modifiers changed from: private */
    public int e = 1;
    /* access modifiers changed from: private */
    public int f = 0;
    /* access modifiers changed from: private */
    public int g = 62;
    /* access modifiers changed from: private */
    public int h = 12;
    /* access modifiers changed from: private */
    public int i = 5;
    /* access modifiers changed from: private */
    public boolean j = false;
    /* access modifiers changed from: private */
    public boolean k = false;
    /* access modifiers changed from: private */
    public Handler l = IronSourceThreadManager.INSTANCE.getInitHandler();
    private boolean m = false;
    private AtomicBoolean n = new AtomicBoolean(true);
    private NetworkStateReceiver o;
    /* access modifiers changed from: private */
    public CountDownTimer p;
    /* access modifiers changed from: private */
    public List<u9> q = new ArrayList();
    /* access modifiers changed from: private */
    public String r = "";
    /* access modifiers changed from: private */
    public String s;
    /* access modifiers changed from: private */
    public com.ironsource.mediationsdk.utils.c t;
    private d u = d.NOT_INIT;
    /* access modifiers changed from: private */
    public SegmentListener v;
    /* access modifiers changed from: private */
    public boolean w = false;
    /* access modifiers changed from: private */
    public long x;
    /* access modifiers changed from: private */
    public w7 y = new w7();
    private f z = new a();

    class a extends f {
        a() {
            super();
        }

        public void run() {
            gb i;
            try {
                p o = p.o();
                c0.f().a();
                if (!TextUtils.isEmpty(s.this.r)) {
                    q4.a().a("userId", s.this.r);
                }
                if (!TextUtils.isEmpty(s.this.s)) {
                    q4.a().a("appKey", s.this.s);
                }
                s.this.y.h(s.this.r);
                long unused = s.this.x = new Date().getTime();
                com.ironsource.mediationsdk.utils.c unused2 = s.this.t = o.b(ContextProvider.getInstance().getApplicationContext(), s.this.r, this.c);
                if (s.this.t != null) {
                    s.this.l.removeCallbacks(this);
                    if (s.this.t.m()) {
                        s.this.a(d.INITIATED);
                        s sVar = s.this;
                        sVar.a(sVar.t);
                        s.this.b(o.A());
                        o0 e2 = s.this.t.b().b().e();
                        if (e2 != null) {
                            j3 j3Var = j3.a;
                            j3Var.c(e2.e());
                            j3Var.a(e2.d());
                            j3Var.a(e2.g());
                            IronSourceThreadManager.INSTANCE.setUseSharedExecutorService(e2.f());
                        }
                        s.this.a(ContextProvider.getInstance().getApplicationContext(), s.this.t);
                        o.a(new Date().getTime() - s.this.x);
                        ib unused3 = s.this.a = new ib();
                        s.this.a.a();
                        if (s.this.t.b().b().f() && ContextProvider.getInstance().getApplicationContext() != null) {
                            IntegrationHelper.validateIntegration(ContextProvider.getInstance().getApplicationContext());
                        }
                        List<IronSource.AD_UNIT> e3 = s.this.t.e();
                        for (u9 a : s.this.q) {
                            a.a(e3, s.this.f(), s.this.t.b());
                        }
                        if (!(s.this.v == null || (i = s.this.t.b().b().i()) == null || TextUtils.isEmpty(i.c()))) {
                            s.this.v.onSegmentReceived(i.c());
                        }
                        l0 c = s.this.t.b().b().c();
                        if (c.f()) {
                            s2.d().a(ContextProvider.getInstance().getApplicationContext(), c.b(), c.d(), c.c(), c.e(), IronSourceUtils.getSessionId(), c.a(), c.g());
                        }
                    } else if (!s.this.k) {
                        s.this.a(d.INIT_FAILED);
                        boolean unused4 = s.this.k = true;
                        for (u9 d : s.this.q) {
                            d.d(IronSourceConstants.FALSE_AVAILABILITY_REASON_SERVER_RESPONSE_IS_NOT_VALID);
                        }
                    }
                } else {
                    if (s.this.f == 3) {
                        boolean unused5 = s.this.w = true;
                        for (u9 a2 : s.this.q) {
                            a2.a();
                        }
                    }
                    if (this.a && s.this.f < s.this.g) {
                        boolean unused6 = s.this.j = true;
                        s.this.l.postDelayed(this, (long) (s.this.e * 1000));
                        if (s.this.f < s.this.h) {
                            s.a(s.this, 2);
                        }
                    }
                    if ((!this.a || s.this.f == s.this.i) && !s.this.k) {
                        boolean unused7 = s.this.k = true;
                        if (TextUtils.isEmpty(this.b)) {
                            this.b = IronSourceConstants.FALSE_AVAILABILITY_REASON_NO_SERVER_RESPONSE;
                        }
                        for (u9 d2 : s.this.q) {
                            d2.d(this.b);
                        }
                        s.this.a(d.INIT_FAILED);
                        IronSourceLoggerManager.getLogger().log(IronSourceLogger.IronSourceTag.API, "Mediation availability false reason: No server response", 1);
                    }
                    s.f(s.this);
                }
            } catch (Exception e4) {
                e4.printStackTrace();
            }
        }
    }

    class b implements Runnable {

        class a extends CountDownTimer {
            a(long j, long j2) {
                super(j, j2);
            }

            public void onFinish() {
                if (!s.this.k) {
                    boolean unused = s.this.k = true;
                    for (u9 d : s.this.q) {
                        d.d(IronSourceConstants.FALSE_AVAILABILITY_REASON_NO_INTERNET);
                    }
                    IronSourceLoggerManager.getLogger().log(IronSourceLogger.IronSourceTag.API, "Mediation availability false reason: No internet connection", 1);
                }
            }

            public void onTick(long j) {
                if (j <= 45000) {
                    boolean unused = s.this.w = true;
                    for (u9 a2 : s.this.q) {
                        a2.a();
                    }
                }
            }
        }

        b() {
        }

        public void run() {
            CountDownTimer unused = s.this.p = new a(60000, 15000).start();
        }
    }

    static /* synthetic */ class c {
        static final /* synthetic */ int[] a;

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|(3:5|6|8)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        static {
            /*
                com.ironsource.mediationsdk.s$d[] r0 = com.ironsource.mediationsdk.s.d.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                a = r0
                com.ironsource.mediationsdk.s$d r1 = com.ironsource.mediationsdk.s.d.INIT_IN_PROGRESS     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = a     // Catch:{ NoSuchFieldError -> 0x001d }
                com.ironsource.mediationsdk.s$d r1 = com.ironsource.mediationsdk.s.d.NOT_INIT     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = a     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.ironsource.mediationsdk.s$d r1 = com.ironsource.mediationsdk.s.d.INITIATED     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.ironsource.mediationsdk.s.c.<clinit>():void");
        }
    }

    enum d {
        NOT_INIT,
        INIT_IN_PROGRESS,
        INIT_FAILED,
        INITIATED
    }

    public static class e {
        public static int a = 0;
        public static int b = 1;
        public static int c = 2;
        public static int d = 3;
        public static int e = 4;
    }

    abstract class f implements Runnable {
        boolean a = true;
        String b;
        protected p.c c = new a();

        class a implements p.c {
            a() {
            }

            public void a(String str) {
                f fVar = f.this;
                fVar.a = false;
                fVar.b = str;
            }
        }

        f() {
        }
    }

    private s() {
    }

    static /* synthetic */ int a(s sVar, int i2) {
        int i3 = sVar.e * i2;
        sVar.e = i3;
        return i3;
    }

    private static int a(c.a aVar, d dVar) {
        if (aVar == c.a.CACHE) {
            return e.c;
        }
        int i2 = c.a[dVar.ordinal()];
        return i2 != 1 ? i2 != 2 ? i2 != 3 ? e.a : e.b : e.e : e.d;
    }

    /* access modifiers changed from: private */
    public synchronized void a(d dVar) {
        IronLog ironLog = IronLog.INTERNAL;
        ironLog.verbose("old status: " + this.u + ", new status: " + dVar + ")");
        this.u = dVar;
    }

    public static synchronized s c() {
        s sVar;
        synchronized (s.class) {
            if (A == null) {
                A = new s();
            }
            sVar = A;
        }
        return sVar;
    }

    static /* synthetic */ int f(s sVar) {
        int i2 = sVar.f;
        sVar.f = i2 + 1;
        return i2;
    }

    /* access modifiers changed from: private */
    public boolean f() {
        return this.j;
    }

    public synchronized d a() {
        return this.u;
    }

    public void a(Context context, com.ironsource.mediationsdk.utils.c cVar) {
        this.y.h(cVar.d().d());
        this.y.b(cVar.d().c());
        j0 b2 = cVar.b().b();
        this.y.a(b2.a());
        this.y.c(b2.b().b());
        this.y.b(b2.j().b());
        this.y.a(Boolean.valueOf(IronSourceUtils.getFirstSession(context)));
    }

    public synchronized void a(Context context, String str, String str2, IronSource.AD_UNIT... ad_unitArr) {
        try {
            AtomicBoolean atomicBoolean = this.n;
            if (atomicBoolean == null || !atomicBoolean.compareAndSet(true, false)) {
                IronSourceLoggerManager logger = IronSourceLoggerManager.getLogger();
                IronSourceLogger.IronSourceTag ironSourceTag = IronSourceLogger.IronSourceTag.API;
                logger.log(ironSourceTag, this.d + ": Multiple calls to init are not allowed", 2);
            } else {
                a(d.INIT_IN_PROGRESS);
                this.r = str2;
                this.s = str;
                if (IronSourceUtils.isNetworkConnected(context)) {
                    this.l.post(this.z);
                } else {
                    this.m = true;
                    if (this.o == null) {
                        this.o = new NetworkStateReceiver(context, this);
                    }
                    context.registerReceiver(this.o, new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
                    IronSourceThreadManager.INSTANCE.postMediationBackgroundTask(new b());
                }
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        return;
    }

    public void a(SegmentListener segmentListener) {
        this.v = segmentListener;
    }

    public synchronized void a(com.ironsource.mediationsdk.utils.c cVar) {
        int a2 = a(com.ironsource.mediationsdk.utils.c.a(cVar), this.u);
        this.b = a2;
        this.y.b(a2);
    }

    public void a(u9 u9Var) {
        if (u9Var != null) {
            this.q.add(u9Var);
        }
    }

    public void a(boolean z2) {
        if (this.m && z2) {
            CountDownTimer countDownTimer = this.p;
            if (countDownTimer != null) {
                countDownTimer.cancel();
            }
            this.m = false;
            this.j = true;
            this.l.post(this.z);
        }
    }

    public int b() {
        return this.b;
    }

    public void b(u9 u9Var) {
        if (u9Var != null && this.q.size() != 0) {
            this.q.remove(u9Var);
        }
    }

    public void b(boolean z2) {
        Map<String, String> b2;
        if (z2 && TextUtils.isEmpty(p.o().r()) && (b2 = this.t.b().b().d().b()) != null && !b2.isEmpty()) {
            for (String next : b2.keySet()) {
                if (IronSourceUtils.doesClassExist(next)) {
                    String str = b2.get(next);
                    if (!TextUtils.isEmpty(str)) {
                        next = str;
                    }
                    p.o().h(next);
                    return;
                }
            }
        }
    }

    public synchronized boolean d() {
        return this.w;
    }

    /* access modifiers changed from: package-private */
    public void e() {
        a(d.INIT_FAILED);
    }
}
