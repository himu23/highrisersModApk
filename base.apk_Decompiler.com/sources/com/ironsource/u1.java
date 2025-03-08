package com.ironsource;

import android.content.Context;
import android.os.Handler;
import android.os.HandlerThread;
import android.text.TextUtils;
import com.ironsource.mediationsdk.IronSource;
import com.ironsource.mediationsdk.IronSourceSegment;
import com.ironsource.mediationsdk.events.ISErrorListener;
import com.ironsource.mediationsdk.logger.IronLog;
import com.ironsource.mediationsdk.utils.IronSourceConstants;
import com.ironsource.mediationsdk.utils.IronSourceUtils;
import com.ironsource.y2;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;

public abstract class u1 implements d5 {
    private int[] A;
    /* access modifiers changed from: private */
    public int[] B;
    private int[] C;
    private Map<String, String> D = new HashMap();
    /* access modifiers changed from: private */
    public Map<String, String> E = new HashMap();
    private String F = "";
    int G;
    String H;
    String I;
    Set<Integer> J;
    /* access modifiers changed from: private */
    public f K;
    private IronSourceSegment L;
    private gb M;
    /* access modifiers changed from: private */
    public ISErrorListener N;
    private final Object O = new Object();
    final int a = 1;
    final int b = 100;
    final int c = 5000;
    final int d = 90000;
    final int e = 1024;
    final int f = 5;
    final String g = "supersonic_sdk.db";
    final String h = IronSourceConstants.EVENTS_PROVIDER;
    final String i = "placement";
    private final String j = t4.r0;
    private final String k = "mt";
    private boolean l;
    /* access modifiers changed from: private */
    public boolean m = false;
    private boolean n = false;
    private int o = -1;
    /* access modifiers changed from: private */
    public y2 p;
    private c q;
    /* access modifiers changed from: private */
    public ArrayList<y3> r;
    private boolean s = true;
    /* access modifiers changed from: private */
    public int t;
    /* access modifiers changed from: private */
    public String u;
    /* access modifiers changed from: private */
    public Context v;
    private int w = 100;
    private int x = 5000;
    private int y = 1;
    private int[] z;

    class a implements Runnable {
        a() {
        }

        public void run() {
            u1.this.a();
        }
    }

    class b implements Runnable {
        final /* synthetic */ y3 a;
        final /* synthetic */ IronSource.AD_UNIT b;

        b(y3 y3Var, IronSource.AD_UNIT ad_unit) {
            this.a = y3Var;
            this.b = ad_unit;
        }

        public void run() {
            this.a.a("eventSessionId", u1.this.u);
            String connectionType = IronSourceUtils.getConnectionType(u1.this.v);
            if (u1.this.g(this.a)) {
                this.a.a("connectionType", connectionType);
            }
            if (u1.this.a(connectionType, this.a)) {
                y3 y3Var = this.a;
                y3Var.a(u1.this.b(y3Var));
            }
            int a2 = u1.this.a(this.a.c(), this.b);
            if (a2 != e.NOT_SUPPORTED.a()) {
                this.a.a("adUnit", Integer.valueOf(a2));
            }
            u1.this.a(this.a, "reason");
            u1.this.a(this.a, IronSourceConstants.EVENTS_EXT1);
            if (!u1.this.E.isEmpty()) {
                for (Map.Entry entry : u1.this.E.entrySet()) {
                    if (!(this.a.b().has((String) entry.getKey()) || entry.getKey() == "eventId" || entry.getKey() == y2.a.d)) {
                        this.a.a((String) entry.getKey(), entry.getValue());
                    }
                }
            }
            if (u1.this.i(this.a)) {
                if (u1.this.h(this.a) && !u1.this.e(this.a)) {
                    this.a.a("sessionDepth", Integer.valueOf(u1.this.c(this.a)));
                }
                if (u1.this.j(this.a)) {
                    u1.this.f(this.a);
                } else if (!TextUtils.isEmpty(u1.this.e(this.a.c())) && u1.this.k(this.a)) {
                    y3 y3Var2 = this.a;
                    y3Var2.a("placement", u1.this.e(y3Var2.c()));
                }
                long firstSessionTimestamp = IronSourceUtils.getFirstSessionTimestamp(u1.this.v);
                if (firstSessionTimestamp != -1) {
                    this.a.a(IronSourceConstants.FIRST_SESSION_TIMESTAMP, Long.valueOf(firstSessionTimestamp));
                }
                IronLog.EVENT.verbose(this.a.toString());
                u1.this.r.add(this.a);
                u1.d(u1.this);
            }
            u1 u1Var = u1.this;
            boolean a3 = u1Var.a(u1Var.B) ? u1.this.a(this.a.c(), u1.this.B) : u1.this.d(this.a);
            if (!u1.this.m && a3) {
                boolean unused = u1.this.m = true;
            }
            if (u1.this.p == null) {
                return;
            }
            if (u1.this.g()) {
                u1.this.f();
                return;
            }
            u1 u1Var2 = u1.this;
            if (u1Var2.b((ArrayList<y3>) u1Var2.r) || a3) {
                u1.this.a();
            }
        }
    }

    class c implements e5 {

        class a implements Runnable {
            final /* synthetic */ boolean a;
            final /* synthetic */ ArrayList b;

            a(boolean z, ArrayList arrayList) {
                this.a = z;
                this.b = arrayList;
            }

            public void run() {
                try {
                    if (this.a) {
                        int unused = u1.this.t = u1.this.p.a(u1.this.I).size() + u1.this.r.size();
                    } else {
                        IronLog.INTERNAL.error("Failed to send events. Saving them back to storage.");
                        u1.this.a((ArrayList<y3>) this.b);
                    }
                } catch (Exception e) {
                    if (u1.this.N != null) {
                        u1.this.N.onError(new IllegalStateException("Error on sending data ", e));
                    }
                }
                c.this.a(this.b);
            }
        }

        c() {
        }

        public void a(ArrayList<y3> arrayList) {
            if (arrayList != null) {
                try {
                    arrayList.clear();
                } catch (Exception e) {
                    IronLog ironLog = IronLog.INTERNAL;
                    ironLog.error("clearData exception: " + e.getMessage());
                }
            }
        }

        public synchronized void a(ArrayList<y3> arrayList, boolean z) {
            u1.this.K.a(new a(z, arrayList));
        }
    }

    class d implements Runnable {
        d() {
        }

        public void run() {
            u1.this.f();
        }
    }

    public enum e {
        NOT_SUPPORTED(-1),
        OFFERWALL(1),
        INTERSTITIAL(2),
        REWARDED_VIDEO(3),
        NATIVE_AD(4),
        BANNER(8);
        
        private int a;

        private e(int i) {
            this.a = i;
        }

        public int a() {
            return this.a;
        }
    }

    private class f extends HandlerThread {
        private Handler a;

        f(String str) {
            super(str);
        }

        /* access modifiers changed from: package-private */
        public void a() {
            this.a = new Handler(getLooper());
        }

        /* access modifiers changed from: package-private */
        public void a(Runnable runnable) {
            this.a.post(runnable);
        }
    }

    /* access modifiers changed from: private */
    public int a(int i2, IronSource.AD_UNIT ad_unit) {
        e eVar;
        int a2 = e.NOT_SUPPORTED.a();
        if (ad_unit == IronSource.AD_UNIT.OFFERWALL || i2 == 15 || (i2 >= 300 && i2 < 400)) {
            eVar = e.OFFERWALL;
        } else if (ad_unit == IronSource.AD_UNIT.REWARDED_VIDEO || ((i2 >= 1000 && i2 < 2000) || (i2 >= 91000 && i2 < 92000))) {
            eVar = e.REWARDED_VIDEO;
        } else if (ad_unit == IronSource.AD_UNIT.INTERSTITIAL || ((i2 >= 2000 && i2 < 3000) || (i2 >= 92000 && i2 < 93000))) {
            eVar = e.INTERSTITIAL;
        } else if (ad_unit == IronSource.AD_UNIT.BANNER || ((i2 >= 3000 && i2 < 4000) || (i2 >= 93000 && i2 < 94000))) {
            eVar = e.BANNER;
        } else if (ad_unit != IronSource.AD_UNIT.NATIVE_AD && ((i2 < 4000 || i2 >= 5000) && (i2 < 94000 || i2 >= 95000))) {
            return a2;
        } else {
            eVar = e.NATIVE_AD;
        }
        return eVar.a();
    }

    /* access modifiers changed from: private */
    public void a() {
        synchronized (this.O) {
            this.p.a((List<y3>) this.r, this.I);
            this.r.clear();
        }
    }

    /* access modifiers changed from: private */
    public void a(y3 y3Var, String str) {
        a(y3Var, str, 1024);
    }

    private void a(y3 y3Var, String str, int i2) {
        JSONObject b2 = y3Var.b();
        if (b2 != null && b2.has(str)) {
            try {
                String optString = b2.optString(str, (String) null);
                if (optString != null) {
                    y3Var.a(str, optString.substring(0, Math.min(optString.length(), i2)));
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    private void a(JSONObject jSONObject) {
        try {
            IronSourceSegment ironSourceSegment = this.L;
            if (ironSourceSegment != null) {
                if (ironSourceSegment.getAge() > 0) {
                    jSONObject.put("age", this.L.getAge());
                }
                if (!TextUtils.isEmpty(this.L.getGender())) {
                    jSONObject.put(IronSourceSegment.GENDER, this.L.getGender());
                }
                if (this.L.getLevel() > 0) {
                    jSONObject.put(IronSourceSegment.LEVEL, this.L.getLevel());
                }
                if (this.L.getIsPaying() != null) {
                    jSONObject.put(IronSourceSegment.PAYING, this.L.getIsPaying().get());
                }
                if (this.L.getIapt() > 0.0d) {
                    jSONObject.put(IronSourceSegment.IAPT, this.L.getIapt());
                }
                if (this.L.getUcd() > 0) {
                    jSONObject.put(IronSourceSegment.USER_CREATION_DATE, this.L.getUcd());
                }
            }
            gb gbVar = this.M;
            if (gbVar != null) {
                String b2 = gbVar.b();
                if (!TextUtils.isEmpty(b2)) {
                    jSONObject.put("segmentId", b2);
                }
                JSONObject a2 = this.M.a();
                Iterator<String> keys = a2.keys();
                while (keys.hasNext()) {
                    String next = keys.next();
                    jSONObject.put(next, a2.get(next));
                }
            }
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
    }

    /* access modifiers changed from: private */
    public boolean a(int i2, int[] iArr) {
        if (!a(iArr)) {
            return false;
        }
        for (int i3 : iArr) {
            if (i2 == i3) {
                return true;
            }
        }
        return false;
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x002e, code lost:
        return a(r1.C) ? a(r3.c(), r1.C) : r1.J.contains(java.lang.Integer.valueOf(r3.c()));
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized boolean a(java.lang.String r2, com.ironsource.y3 r3) {
        /*
            r1 = this;
            monitor-enter(r1)
            java.lang.String r0 = "none"
            boolean r2 = r2.equalsIgnoreCase(r0)     // Catch:{ all -> 0x002f }
            if (r2 != 0) goto L_0x000c
            monitor-exit(r1)
            r2 = 0
            return r2
        L_0x000c:
            int[] r2 = r1.C     // Catch:{ all -> 0x002f }
            boolean r2 = r1.a((int[]) r2)     // Catch:{ all -> 0x002f }
            if (r2 == 0) goto L_0x001f
            int r2 = r3.c()     // Catch:{ all -> 0x002f }
            int[] r3 = r1.C     // Catch:{ all -> 0x002f }
            boolean r2 = r1.a((int) r2, (int[]) r3)     // Catch:{ all -> 0x002f }
            goto L_0x002d
        L_0x001f:
            java.util.Set<java.lang.Integer> r2 = r1.J     // Catch:{ all -> 0x002f }
            int r3 = r3.c()     // Catch:{ all -> 0x002f }
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)     // Catch:{ all -> 0x002f }
            boolean r2 = r2.contains(r3)     // Catch:{ all -> 0x002f }
        L_0x002d:
            monitor-exit(r1)
            return r2
        L_0x002f:
            r2 = move-exception
            monitor-exit(r1)
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ironsource.u1.a(java.lang.String, com.ironsource.y3):boolean");
    }

    /* access modifiers changed from: private */
    public boolean a(int[] iArr) {
        return iArr != null && iArr.length > 0;
    }

    /* access modifiers changed from: private */
    public synchronized int b(y3 y3Var) {
        return y3Var.c() + 90000;
    }

    private void b(String str) {
        c cVar = this.q;
        if (cVar == null || !cVar.c().equals(str)) {
            this.q = c4.a(str, this.G);
        }
    }

    /* access modifiers changed from: private */
    public boolean b(ArrayList<y3> arrayList) {
        return arrayList != null && arrayList.size() >= this.y;
    }

    static /* synthetic */ int d(u1 u1Var) {
        int i2 = u1Var.t;
        u1Var.t = i2 + 1;
        return i2;
    }

    /* access modifiers changed from: private */
    public boolean e(y3 y3Var) {
        JSONObject b2 = y3Var.b();
        if (b2 == null) {
            return false;
        }
        return b2.has("sessionDepth");
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: No exception handlers in catch block: Catch:{  } */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void f() {
        /*
            r7 = this;
            r0 = 0
            r7.m = r0     // Catch:{ all -> 0x0174 }
            java.util.ArrayList r1 = new java.util.ArrayList     // Catch:{ all -> 0x0174 }
            r1.<init>()     // Catch:{ all -> 0x0174 }
            java.lang.Object r2 = r7.O     // Catch:{ all -> 0x003f }
            monitor-enter(r2)     // Catch:{ all -> 0x003f }
            com.ironsource.y2 r3 = r7.p     // Catch:{ all -> 0x003c }
            java.lang.String r4 = r7.I     // Catch:{ all -> 0x003c }
            java.util.ArrayList r3 = r3.a((java.lang.String) r4)     // Catch:{ all -> 0x003c }
            com.ironsource.y2 r4 = r7.p     // Catch:{ all -> 0x003c }
            java.lang.String r5 = r7.I     // Catch:{ all -> 0x003c }
            r4.b(r5)     // Catch:{ all -> 0x003c }
            monitor-exit(r2)     // Catch:{ all -> 0x003c }
            com.ironsource.a4$c r2 = new com.ironsource.a4$c     // Catch:{ all -> 0x003f }
            com.ironsource.a4$a r4 = new com.ironsource.a4$a     // Catch:{ all -> 0x003f }
            java.util.ArrayList<com.ironsource.y3> r5 = r7.r     // Catch:{ all -> 0x003f }
            r4.<init>(r3, r5)     // Catch:{ all -> 0x003f }
            int r3 = r7.x     // Catch:{ all -> 0x003f }
            r2.<init>(r4, r3)     // Catch:{ all -> 0x003f }
            com.ironsource.y2 r3 = r7.p     // Catch:{ all -> 0x003f }
            java.util.List r4 = r2.a()     // Catch:{ all -> 0x003f }
            java.lang.String r5 = r7.I     // Catch:{ all -> 0x003f }
            r3.a((java.util.List<com.ironsource.y3>) r4, (java.lang.String) r5)     // Catch:{ all -> 0x003f }
            java.util.List r2 = r2.b()     // Catch:{ all -> 0x003f }
            r1.addAll(r2)     // Catch:{ all -> 0x003f }
            goto L_0x0070
        L_0x003c:
            r3 = move-exception
            monitor-exit(r2)     // Catch:{ all -> 0x003c }
            throw r3     // Catch:{ all -> 0x003f }
        L_0x003f:
            r2 = move-exception
            com.ironsource.mediationsdk.logger.IronLog r3 = com.ironsource.mediationsdk.logger.IronLog.INTERNAL     // Catch:{ all -> 0x0174 }
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ all -> 0x0174 }
            r4.<init>()     // Catch:{ all -> 0x0174 }
            java.lang.String r5 = "CombinedEventList exception: "
            r4.append(r5)     // Catch:{ all -> 0x0174 }
            java.lang.String r5 = r2.getMessage()     // Catch:{ all -> 0x0174 }
            r4.append(r5)     // Catch:{ all -> 0x0174 }
            java.lang.String r4 = r4.toString()     // Catch:{ all -> 0x0174 }
            r3.error(r4)     // Catch:{ all -> 0x0174 }
            com.ironsource.mediationsdk.events.ISErrorListener r3 = r7.N     // Catch:{ all -> 0x0174 }
            if (r3 == 0) goto L_0x0068
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException     // Catch:{ all -> 0x0174 }
            java.lang.String r5 = "Combined event exception: "
            r4.<init>(r5, r2)     // Catch:{ all -> 0x0174 }
            r3.onError(r4)     // Catch:{ all -> 0x0174 }
        L_0x0068:
            r1.clear()     // Catch:{ all -> 0x0174 }
            java.util.ArrayList<com.ironsource.y3> r2 = r7.r     // Catch:{ all -> 0x0174 }
            r1.addAll(r2)     // Catch:{ all -> 0x0174 }
        L_0x0070:
            int r2 = r1.size()     // Catch:{ all -> 0x0174 }
            if (r2 <= 0) goto L_0x018c
            java.util.ArrayList<com.ironsource.y3> r2 = r7.r     // Catch:{ all -> 0x0174 }
            r2.clear()     // Catch:{ all -> 0x0174 }
            r7.t = r0     // Catch:{ all -> 0x0174 }
            com.ironsource.q4 r2 = com.ironsource.q4.a()     // Catch:{ all -> 0x0174 }
            org.json.JSONObject r2 = r2.b()     // Catch:{ all -> 0x0174 }
            r7.a((org.json.JSONObject) r2)     // Catch:{ all -> 0x0103 }
            java.lang.String r3 = r7.b()     // Catch:{ all -> 0x0103 }
            boolean r4 = android.text.TextUtils.isEmpty(r3)     // Catch:{ all -> 0x0103 }
            if (r4 != 0) goto L_0x0097
            java.lang.String r4 = "abt"
            r2.put(r4, r3)     // Catch:{ all -> 0x0103 }
        L_0x0097:
            com.ironsource.mediationsdk.p r3 = com.ironsource.mediationsdk.p.o()     // Catch:{ all -> 0x0103 }
            java.lang.String r3 = r3.r()     // Catch:{ all -> 0x0103 }
            boolean r4 = android.text.TextUtils.isEmpty(r3)     // Catch:{ all -> 0x0103 }
            if (r4 != 0) goto L_0x00aa
            java.lang.String r4 = "mt"
            r2.put(r4, r3)     // Catch:{ all -> 0x0103 }
        L_0x00aa:
            java.util.Map r3 = r7.c()     // Catch:{ all -> 0x0103 }
            boolean r4 = r3.isEmpty()     // Catch:{ all -> 0x0103 }
            if (r4 != 0) goto L_0x00e2
            java.util.Set r3 = r3.entrySet()     // Catch:{ all -> 0x0103 }
            java.util.Iterator r3 = r3.iterator()     // Catch:{ all -> 0x0103 }
        L_0x00bc:
            boolean r4 = r3.hasNext()     // Catch:{ all -> 0x0103 }
            if (r4 == 0) goto L_0x00e2
            java.lang.Object r4 = r3.next()     // Catch:{ all -> 0x0103 }
            java.util.Map$Entry r4 = (java.util.Map.Entry) r4     // Catch:{ all -> 0x0103 }
            java.lang.Object r5 = r4.getKey()     // Catch:{ all -> 0x0103 }
            java.lang.String r5 = (java.lang.String) r5     // Catch:{ all -> 0x0103 }
            boolean r5 = r2.has(r5)     // Catch:{ all -> 0x0103 }
            if (r5 != 0) goto L_0x00bc
            java.lang.Object r5 = r4.getKey()     // Catch:{ all -> 0x0103 }
            java.lang.String r5 = (java.lang.String) r5     // Catch:{ all -> 0x0103 }
            java.lang.Object r4 = r4.getValue()     // Catch:{ all -> 0x0103 }
            r2.put(r5, r4)     // Catch:{ all -> 0x0103 }
            goto L_0x00bc
        L_0x00e2:
            com.ironsource.e4 r3 = new com.ironsource.e4     // Catch:{ all -> 0x0103 }
            r3.<init>()     // Catch:{ all -> 0x0103 }
            org.json.JSONObject r3 = r3.a()     // Catch:{ all -> 0x0103 }
            java.util.Iterator r4 = r3.keys()     // Catch:{ all -> 0x0103 }
        L_0x00ef:
            boolean r5 = r4.hasNext()     // Catch:{ all -> 0x0103 }
            if (r5 == 0) goto L_0x011e
            java.lang.Object r5 = r4.next()     // Catch:{ all -> 0x0103 }
            java.lang.String r5 = (java.lang.String) r5     // Catch:{ all -> 0x0103 }
            java.lang.Object r6 = r3.get(r5)     // Catch:{ all -> 0x0103 }
            r2.put(r5, r6)     // Catch:{ all -> 0x0103 }
            goto L_0x00ef
        L_0x0103:
            r3 = move-exception
            com.ironsource.mediationsdk.logger.IronLog r4 = com.ironsource.mediationsdk.logger.IronLog.INTERNAL     // Catch:{ all -> 0x0174 }
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ all -> 0x0174 }
            r5.<init>()     // Catch:{ all -> 0x0174 }
            java.lang.String r6 = "Exception while building the event general properties: "
            r5.append(r6)     // Catch:{ all -> 0x0174 }
            java.lang.String r3 = r3.getMessage()     // Catch:{ all -> 0x0174 }
            r5.append(r3)     // Catch:{ all -> 0x0174 }
            java.lang.String r3 = r5.toString()     // Catch:{ all -> 0x0174 }
            r4.error(r3)     // Catch:{ all -> 0x0174 }
        L_0x011e:
            com.ironsource.c r3 = r7.q     // Catch:{ all -> 0x0174 }
            java.lang.String r2 = r3.a(r1, r2)     // Catch:{ all -> 0x0174 }
            boolean r3 = android.text.TextUtils.isEmpty(r2)     // Catch:{ all -> 0x0174 }
            if (r3 == 0) goto L_0x0140
            com.ironsource.mediationsdk.logger.IronLog r0 = com.ironsource.mediationsdk.logger.IronLog.INTERNAL     // Catch:{ all -> 0x0174 }
            java.lang.String r1 = "Failed to parse events."
            r0.error(r1)     // Catch:{ all -> 0x0174 }
            com.ironsource.mediationsdk.events.ISErrorListener r0 = r7.N     // Catch:{ all -> 0x0174 }
            if (r0 == 0) goto L_0x013f
            java.lang.IllegalStateException r1 = new java.lang.IllegalStateException     // Catch:{ all -> 0x0174 }
            java.lang.String r2 = "Event parse failed"
            r1.<init>(r2)     // Catch:{ all -> 0x0174 }
            r0.onError(r1)     // Catch:{ all -> 0x0174 }
        L_0x013f:
            return
        L_0x0140:
            boolean r3 = r7.n     // Catch:{ all -> 0x0174 }
            if (r3 == 0) goto L_0x015e
            int r3 = r7.o     // Catch:{ Exception -> 0x014f }
            byte[] r3 = com.ironsource.t7.a(r2, r3)     // Catch:{ Exception -> 0x014f }
            java.lang.String r2 = android.util.Base64.encodeToString(r3, r0)     // Catch:{ Exception -> 0x014f }
            goto L_0x015e
        L_0x014f:
            r0 = move-exception
            com.ironsource.mediationsdk.events.ISErrorListener r3 = r7.N     // Catch:{ all -> 0x0174 }
            if (r3 == 0) goto L_0x015e
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException     // Catch:{ all -> 0x0174 }
            java.lang.String r5 = "Error on compression: "
            r4.<init>(r5, r0)     // Catch:{ all -> 0x0174 }
            r3.onError(r4)     // Catch:{ all -> 0x0174 }
        L_0x015e:
            com.ironsource.f4 r0 = new com.ironsource.f4     // Catch:{ all -> 0x0174 }
            com.ironsource.u1$c r3 = new com.ironsource.u1$c     // Catch:{ all -> 0x0174 }
            r3.<init>()     // Catch:{ all -> 0x0174 }
            com.ironsource.c r4 = r7.q     // Catch:{ all -> 0x0174 }
            java.lang.String r4 = r4.b()     // Catch:{ all -> 0x0174 }
            r0.<init>(r3, r2, r4, r1)     // Catch:{ all -> 0x0174 }
            com.ironsource.environment.thread.IronSourceThreadManager r1 = com.ironsource.environment.thread.IronSourceThreadManager.INSTANCE     // Catch:{ all -> 0x0174 }
            r1.postMediationBackgroundTask(r0)     // Catch:{ all -> 0x0174 }
            goto L_0x018c
        L_0x0174:
            r0 = move-exception
            com.ironsource.mediationsdk.logger.IronLog r1 = com.ironsource.mediationsdk.logger.IronLog.INTERNAL
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            java.lang.String r3 = "Send event exception: "
            r2.<init>(r3)
            java.lang.String r0 = r0.getMessage()
            r2.append(r0)
            java.lang.String r0 = r2.toString()
            r1.error(r0)
        L_0x018c:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ironsource.u1.f():void");
    }

    /* access modifiers changed from: private */
    public boolean g() {
        return (this.t >= this.w || this.m) && this.l;
    }

    /* access modifiers changed from: private */
    public boolean i(y3 y3Var) {
        if (y3Var == null) {
            return false;
        }
        if (a(this.z)) {
            return true ^ a(y3Var.c(), this.z);
        }
        if (a(this.A)) {
            return a(y3Var.c(), this.A);
        }
        return true;
    }

    public void a(int i2) {
        if (i2 > 0) {
            this.x = i2;
        }
    }

    public synchronized void a(Context context, IronSourceSegment ironSourceSegment) {
        String defaultEventsFormatterType = IronSourceUtils.getDefaultEventsFormatterType(context, this.I, this.H);
        this.H = defaultEventsFormatterType;
        b(defaultEventsFormatterType);
        this.q.a(IronSourceUtils.getDefaultEventsURL(context, this.I, (String) null));
        this.p = y2.a(context, "supersonic_sdk.db", 5);
        this.K.a(new a());
        this.z = IronSourceUtils.getDefaultOptOutEvents(context, this.I);
        this.A = IronSourceUtils.getDefaultOptInEvents(context, this.I);
        this.B = IronSourceUtils.getDefaultTriggerEvents(context, this.I);
        this.C = IronSourceUtils.getDefaultNonConnectivityEvents(context, this.I);
        this.L = ironSourceSegment;
        this.v = context;
    }

    public synchronized void a(gb gbVar) {
        this.M = gbVar;
    }

    public void a(IronSourceSegment ironSourceSegment) {
        this.L = ironSourceSegment;
    }

    public void a(ISErrorListener iSErrorListener) {
        this.N = iSErrorListener;
    }

    public synchronized void a(y3 y3Var) {
        a(y3Var, (IronSource.AD_UNIT) null);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0018, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized void a(com.ironsource.y3 r3, com.ironsource.mediationsdk.IronSource.AD_UNIT r4) {
        /*
            r2 = this;
            monitor-enter(r2)
            if (r3 == 0) goto L_0x0017
            boolean r0 = r2.s     // Catch:{ all -> 0x0014 }
            if (r0 != 0) goto L_0x0008
            goto L_0x0017
        L_0x0008:
            com.ironsource.u1$f r0 = r2.K     // Catch:{ all -> 0x0014 }
            com.ironsource.u1$b r1 = new com.ironsource.u1$b     // Catch:{ all -> 0x0014 }
            r1.<init>(r3, r4)     // Catch:{ all -> 0x0014 }
            r0.a(r1)     // Catch:{ all -> 0x0014 }
            monitor-exit(r2)
            return
        L_0x0014:
            r3 = move-exception
            monitor-exit(r2)
            throw r3
        L_0x0017:
            monitor-exit(r2)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ironsource.u1.a(com.ironsource.y3, com.ironsource.mediationsdk.IronSource$AD_UNIT):void");
    }

    public void a(String str) {
        this.F = str;
    }

    public void a(String str, Context context) {
        if (!TextUtils.isEmpty(str)) {
            this.H = str;
            IronSourceUtils.saveDefaultEventsFormatterType(context, this.I, str);
            b(str);
        }
    }

    /* access modifiers changed from: protected */
    public void a(ArrayList<y3> arrayList) {
        if (arrayList != null) {
            synchronized (this.O) {
                this.p.a((List<y3>) arrayList, this.I);
                this.t = this.p.a(this.I).size() + this.r.size();
            }
        }
    }

    public void a(Map<String, String> map) {
        this.D.putAll(map);
    }

    public void a(Map<String, Object> map, int i2, String str) {
        map.put(IronSourceConstants.AUCTION_TRIALS, Integer.valueOf(i2));
        if (!TextUtils.isEmpty(str)) {
            map.put(IronSourceConstants.AUCTION_FALLBACK, str);
        }
    }

    public void a(boolean z2) {
        this.n = z2;
    }

    public void a(int[] iArr, Context context) {
        this.A = iArr;
        IronSourceUtils.saveDefaultOptInEvents(context, this.I, iArr);
    }

    public String b() {
        return this.F;
    }

    public void b(int i2) {
        if (i2 > 0) {
            this.w = i2;
        }
    }

    public void b(String str, Context context) {
        if (!TextUtils.isEmpty(str)) {
            c cVar = this.q;
            if (cVar != null) {
                cVar.a(str);
            }
            IronSourceUtils.saveDefaultEventsURL(context, this.I, str);
        }
    }

    public void b(Map<String, String> map) {
        this.E.putAll(map);
    }

    public void b(boolean z2) {
        this.s = z2;
    }

    public void b(int[] iArr, Context context) {
        this.B = iArr;
        IronSourceUtils.saveDefaultTriggerEvents(context, this.I, iArr);
    }

    /* access modifiers changed from: protected */
    public abstract int c(y3 y3Var);

    public Map<String, String> c() {
        return this.D;
    }

    public void c(int i2) {
        if (i2 > 0) {
            this.y = i2;
        }
    }

    public void c(boolean z2) {
        this.l = z2;
    }

    public void c(int[] iArr, Context context) {
        this.z = iArr;
        IronSourceUtils.saveDefaultOptOutEvents(context, this.I, iArr);
    }

    /* access modifiers changed from: package-private */
    public abstract void d();

    public void d(int i2) {
        this.o = i2;
    }

    public void d(int[] iArr, Context context) {
        this.C = iArr;
        IronSourceUtils.saveDefaultNonConnectivityEvents(context, this.I, iArr);
    }

    /* access modifiers changed from: protected */
    public abstract boolean d(y3 y3Var);

    /* access modifiers changed from: protected */
    public abstract String e(int i2);

    /* access modifiers changed from: package-private */
    public void e() {
        this.r = new ArrayList<>();
        this.t = 0;
        this.q = c4.a(this.H, this.G);
        f fVar = new f(this.I + "EventThread");
        this.K = fVar;
        fVar.start();
        this.K.a();
        this.u = IronSourceUtils.getSessionId();
        this.J = new HashSet();
        d();
    }

    /* access modifiers changed from: protected */
    public int f(int i2) {
        return a(i2, (IronSource.AD_UNIT) null);
    }

    /* access modifiers changed from: protected */
    public abstract void f(y3 y3Var);

    /* access modifiers changed from: protected */
    public boolean g(y3 y3Var) {
        return (y3Var.c() == 40 || y3Var.c() == 41 || y3Var.c() == 50 || y3Var.c() == 51 || y3Var.c() == 52) ? false : true;
    }

    public void h() {
        this.K.a(new d());
    }

    /* access modifiers changed from: protected */
    public boolean h(y3 y3Var) {
        return (y3Var.c() == 14 || y3Var.c() == 114 || y3Var.c() == 514 || y3Var.c() == 140 || y3Var.c() == 40 || y3Var.c() == 41 || y3Var.c() == 50 || y3Var.c() == 51 || y3Var.c() == 52) ? false : true;
    }

    /* access modifiers changed from: protected */
    public abstract boolean j(y3 y3Var);

    /* access modifiers changed from: protected */
    public abstract boolean k(y3 y3Var);
}
