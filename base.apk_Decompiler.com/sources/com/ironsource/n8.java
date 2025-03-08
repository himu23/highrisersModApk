package com.ironsource;

import android.text.TextUtils;
import com.ironsource.mediationsdk.a0;
import com.ironsource.mediationsdk.adunit.adapter.utility.AdInfo;
import com.ironsource.mediationsdk.impressionData.ImpressionData;
import com.ironsource.mediationsdk.logger.IronLog;
import com.ironsource.mediationsdk.r;
import java.util.Iterator;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

public class n8 {
    private static final String i = "WaterfallLifeCycleHolder";
    ConcurrentHashMap<String, CopyOnWriteArrayList<r>> a = new ConcurrentHashMap<>();
    private String b = "";
    private String c = "";
    private r d;
    private final List<String> e;
    private final int f;
    private final Timer g = new Timer();
    ConcurrentHashMap<String, AdInfo> h = new ConcurrentHashMap<>();

    class a extends TimerTask {
        final /* synthetic */ String a;

        a(String str) {
            this.a = str;
        }

        public void run() {
            try {
                IronLog ironLog = IronLog.INTERNAL;
                ironLog.verbose("removing waterfall with id " + this.a + " from memory");
                n8.this.a.remove(this.a);
                ironLog.verbose("waterfall size is currently " + n8.this.a.size());
                ironLog.verbose("removing adInfo with id " + this.a + " from memory");
                n8.this.h.remove(this.a);
                ironLog.verbose("adInfo size is currently " + n8.this.h.size());
            } finally {
                cancel();
            }
        }
    }

    public n8(List<String> list, int i2) {
        this.e = list;
        this.f = i2;
    }

    private void b() {
        Iterator<r> it = c().iterator();
        while (it.hasNext()) {
            a0 next = it.next();
            if (!next.equals(this.d)) {
                next.q();
            }
        }
    }

    public AdInfo a(String str) {
        if (this.h.containsKey(str)) {
            return this.h.get(str);
        }
        return null;
    }

    public synchronized void a(r rVar) {
        IronLog.INTERNAL.verbose();
        r rVar2 = this.d;
        if (rVar2 != null && !rVar2.equals(rVar)) {
            this.d.q();
        }
        this.d = rVar;
    }

    public void a(String str, ImpressionData impressionData) {
        if (!TextUtils.isEmpty(str) && impressionData != null) {
            this.h.put(str, new AdInfo(impressionData));
        }
    }

    public void a(CopyOnWriteArrayList<r> copyOnWriteArrayList, String str) {
        IronLog ironLog = IronLog.INTERNAL;
        ironLog.verbose("updating new waterfall with id " + str);
        b();
        this.a.put(str, copyOnWriteArrayList);
        if (!TextUtils.isEmpty(this.c)) {
            if (g()) {
                ironLog.verbose("ad from previous waterfall " + this.c + " is still showing - the current waterfall " + this.b + " will be deleted instead");
                String str2 = this.b;
                this.b = this.c;
                this.c = str2;
            }
            this.g.schedule(new a(this.c), (long) this.f);
        }
        this.c = this.b;
        this.b = str;
    }

    public boolean a() {
        return this.a.size() > 5;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0041, code lost:
        if (r5.e.contains(r6.j()) == false) goto L_0x0054;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0051, code lost:
        if (r5.d.j().equals(r6.j()) == false) goto L_0x0054;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized boolean b(com.ironsource.mediationsdk.r r6) {
        /*
            r5 = this;
            monitor-enter(r5)
            com.ironsource.mediationsdk.logger.IronLog r0 = com.ironsource.mediationsdk.logger.IronLog.INTERNAL     // Catch:{ all -> 0x0074 }
            r0.verbose()     // Catch:{ all -> 0x0074 }
            r1 = 1
            if (r6 == 0) goto L_0x0053
            boolean r2 = r6.o()     // Catch:{ all -> 0x0074 }
            if (r2 == 0) goto L_0x0010
            goto L_0x0053
        L_0x0010:
            com.ironsource.mediationsdk.r r2 = r5.d     // Catch:{ all -> 0x0074 }
            r3 = 0
            if (r2 != 0) goto L_0x0016
            goto L_0x0054
        L_0x0016:
            com.ironsource.mediationsdk.LoadWhileShowSupportState r2 = r6.w()     // Catch:{ all -> 0x0074 }
            com.ironsource.mediationsdk.LoadWhileShowSupportState r4 = com.ironsource.mediationsdk.LoadWhileShowSupportState.LOAD_WHILE_SHOW_BY_NETWORK     // Catch:{ all -> 0x0074 }
            if (r2 != r4) goto L_0x002f
            com.ironsource.mediationsdk.r r2 = r5.d     // Catch:{ all -> 0x0074 }
            java.lang.String r2 = r2.c()     // Catch:{ all -> 0x0074 }
            java.lang.String r4 = r6.c()     // Catch:{ all -> 0x0074 }
            boolean r2 = r2.equals(r4)     // Catch:{ all -> 0x0074 }
            if (r2 == 0) goto L_0x002f
            goto L_0x0053
        L_0x002f:
            com.ironsource.mediationsdk.LoadWhileShowSupportState r2 = r6.w()     // Catch:{ all -> 0x0074 }
            com.ironsource.mediationsdk.LoadWhileShowSupportState r4 = com.ironsource.mediationsdk.LoadWhileShowSupportState.NONE     // Catch:{ all -> 0x0074 }
            if (r2 == r4) goto L_0x0043
            java.util.List<java.lang.String> r2 = r5.e     // Catch:{ all -> 0x0074 }
            java.lang.String r4 = r6.j()     // Catch:{ all -> 0x0074 }
            boolean r2 = r2.contains(r4)     // Catch:{ all -> 0x0074 }
            if (r2 == 0) goto L_0x0054
        L_0x0043:
            com.ironsource.mediationsdk.r r2 = r5.d     // Catch:{ all -> 0x0074 }
            java.lang.String r2 = r2.j()     // Catch:{ all -> 0x0074 }
            java.lang.String r4 = r6.j()     // Catch:{ all -> 0x0074 }
            boolean r2 = r2.equals(r4)     // Catch:{ all -> 0x0074 }
            if (r2 == 0) goto L_0x0054
        L_0x0053:
            r3 = 1
        L_0x0054:
            if (r3 == 0) goto L_0x0070
            if (r6 == 0) goto L_0x0070
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x0074 }
            r2.<init>()     // Catch:{ all -> 0x0074 }
            java.lang.String r6 = r6.c()     // Catch:{ all -> 0x0074 }
            r2.append(r6)     // Catch:{ all -> 0x0074 }
            java.lang.String r6 = " will not be added to the auction request"
            r2.append(r6)     // Catch:{ all -> 0x0074 }
            java.lang.String r6 = r2.toString()     // Catch:{ all -> 0x0074 }
            r0.verbose(r6)     // Catch:{ all -> 0x0074 }
        L_0x0070:
            r6 = r3 ^ 1
            monitor-exit(r5)
            return r6
        L_0x0074:
            r6 = move-exception
            monitor-exit(r5)
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ironsource.n8.b(com.ironsource.mediationsdk.r):boolean");
    }

    public CopyOnWriteArrayList<r> c() {
        CopyOnWriteArrayList<r> copyOnWriteArrayList = this.a.get(this.b);
        return copyOnWriteArrayList == null ? new CopyOnWriteArrayList<>() : copyOnWriteArrayList;
    }

    public String d() {
        return this.b;
    }

    public int e() {
        return this.a.size();
    }

    public r f() {
        return this.d;
    }

    public synchronized boolean g() {
        r rVar;
        rVar = this.d;
        return rVar != null && rVar.u().equals(this.c);
    }
}
