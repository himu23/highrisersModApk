package com.applovin.impl.sdk.utils;

import com.applovin.impl.sdk.n;
import com.applovin.impl.sdk.x;
import java.util.Timer;
import java.util.TimerTask;

public class r {
    /* access modifiers changed from: private */
    public Timer aWf;
    private long aWg;
    private long aWh;
    /* access modifiers changed from: private */
    public final Object amY = new Object();
    /* access modifiers changed from: private */
    public final n sdk;
    private long startTimeMillis;
    /* access modifiers changed from: private */
    public final Runnable v;

    public static r b(long j, n nVar, Runnable runnable) {
        if (j < 0) {
            throw new IllegalArgumentException("Cannot create a scheduled timer. Invalid fire time passed in: " + j + ".");
        } else if (runnable != null) {
            r rVar = new r(nVar, runnable);
            rVar.startTimeMillis = System.currentTimeMillis();
            rVar.aWg = j;
            try {
                Timer timer = new Timer();
                rVar.aWf = timer;
                timer.schedule(rVar.Lt(), j);
            } catch (OutOfMemoryError e) {
                nVar.BN();
                if (x.Fn()) {
                    nVar.BN().c("Timer", "Failed to create timer due to OOM error", e);
                }
            }
            return rVar;
        } else {
            throw new IllegalArgumentException("Cannot create a scheduled timer. Runnable is null.");
        }
    }

    private r(n nVar, Runnable runnable) {
        this.sdk = nVar;
        this.v = runnable;
    }

    public long AH() {
        if (this.aWf == null) {
            return this.aWg - this.aWh;
        }
        return this.aWg - (System.currentTimeMillis() - this.startTimeMillis);
    }

    public void pause() {
        synchronized (this.amY) {
            Timer timer = this.aWf;
            if (timer != null) {
                try {
                    timer.cancel();
                    this.aWh = Math.max(1, System.currentTimeMillis() - this.startTimeMillis);
                } catch (Throwable th) {
                    this.aWf = null;
                    throw th;
                }
                this.aWf = null;
            }
        }
    }

    public void resume() {
        synchronized (this.amY) {
            long j = this.aWh;
            if (j > 0) {
                try {
                    long j2 = this.aWg - j;
                    this.aWg = j2;
                    if (j2 < 0) {
                        this.aWg = 0;
                    }
                    Timer timer = new Timer();
                    this.aWf = timer;
                    timer.schedule(Lt(), this.aWg);
                    this.startTimeMillis = System.currentTimeMillis();
                } catch (Throwable th) {
                    this.aWh = 0;
                    throw th;
                }
                this.aWh = 0;
            }
        }
    }

    public void tT() {
        synchronized (this.amY) {
            Timer timer = this.aWf;
            if (timer != null) {
                try {
                    timer.cancel();
                    this.aWf = null;
                } catch (Throwable th) {
                    this.aWf = null;
                    this.aWh = 0;
                    throw th;
                }
                this.aWh = 0;
            }
        }
    }

    private TimerTask Lt() {
        return new TimerTask() {
            /* JADX WARNING: No exception handlers in catch block: Catch:{  } */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public void run() {
                /*
                    r5 = this;
                    r0 = 0
                    com.applovin.impl.sdk.utils.r r1 = com.applovin.impl.sdk.utils.r.this     // Catch:{ all -> 0x001b }
                    java.lang.Runnable r1 = r1.v     // Catch:{ all -> 0x001b }
                    r1.run()     // Catch:{ all -> 0x001b }
                    com.applovin.impl.sdk.utils.r r1 = com.applovin.impl.sdk.utils.r.this
                    java.lang.Object r1 = r1.amY
                    monitor-enter(r1)
                    com.applovin.impl.sdk.utils.r r2 = com.applovin.impl.sdk.utils.r.this     // Catch:{ all -> 0x0018 }
                    java.util.Timer unused = r2.aWf = r0     // Catch:{ all -> 0x0018 }
                    monitor-exit(r1)     // Catch:{ all -> 0x0018 }
                    goto L_0x0062
                L_0x0018:
                    r0 = move-exception
                    monitor-exit(r1)     // Catch:{ all -> 0x0018 }
                    throw r0
                L_0x001b:
                    r1 = move-exception
                    com.applovin.impl.sdk.utils.r r2 = com.applovin.impl.sdk.utils.r.this     // Catch:{ all -> 0x0066 }
                    com.applovin.impl.sdk.n r2 = r2.sdk     // Catch:{ all -> 0x0066 }
                    if (r2 == 0) goto L_0x0055
                    com.applovin.impl.sdk.utils.r r2 = com.applovin.impl.sdk.utils.r.this     // Catch:{ all -> 0x0066 }
                    com.applovin.impl.sdk.n r2 = r2.sdk     // Catch:{ all -> 0x0066 }
                    r2.BN()     // Catch:{ all -> 0x0066 }
                    boolean r2 = com.applovin.impl.sdk.x.Fn()     // Catch:{ all -> 0x0066 }
                    if (r2 == 0) goto L_0x0044
                    com.applovin.impl.sdk.utils.r r2 = com.applovin.impl.sdk.utils.r.this     // Catch:{ all -> 0x0066 }
                    com.applovin.impl.sdk.n r2 = r2.sdk     // Catch:{ all -> 0x0066 }
                    com.applovin.impl.sdk.x r2 = r2.BN()     // Catch:{ all -> 0x0066 }
                    java.lang.String r3 = "Timer"
                    java.lang.String r4 = "Encountered error while executing timed task"
                    r2.c(r3, r4, r1)     // Catch:{ all -> 0x0066 }
                L_0x0044:
                    com.applovin.impl.sdk.utils.r r2 = com.applovin.impl.sdk.utils.r.this     // Catch:{ all -> 0x0066 }
                    com.applovin.impl.sdk.n r2 = r2.sdk     // Catch:{ all -> 0x0066 }
                    com.applovin.impl.sdk.r r2 = r2.Cs()     // Catch:{ all -> 0x0066 }
                    java.lang.String r3 = "Timer"
                    java.lang.String r4 = "executingTimedTask"
                    r2.d(r3, r4, r1)     // Catch:{ all -> 0x0066 }
                L_0x0055:
                    com.applovin.impl.sdk.utils.r r1 = com.applovin.impl.sdk.utils.r.this
                    java.lang.Object r1 = r1.amY
                    monitor-enter(r1)
                    com.applovin.impl.sdk.utils.r r2 = com.applovin.impl.sdk.utils.r.this     // Catch:{ all -> 0x0063 }
                    java.util.Timer unused = r2.aWf = r0     // Catch:{ all -> 0x0063 }
                    monitor-exit(r1)     // Catch:{ all -> 0x0063 }
                L_0x0062:
                    return
                L_0x0063:
                    r0 = move-exception
                    monitor-exit(r1)     // Catch:{ all -> 0x0063 }
                    throw r0
                L_0x0066:
                    r1 = move-exception
                    com.applovin.impl.sdk.utils.r r2 = com.applovin.impl.sdk.utils.r.this
                    java.lang.Object r2 = r2.amY
                    monitor-enter(r2)
                    com.applovin.impl.sdk.utils.r r3 = com.applovin.impl.sdk.utils.r.this     // Catch:{ all -> 0x0075 }
                    java.util.Timer unused = r3.aWf = r0     // Catch:{ all -> 0x0075 }
                    monitor-exit(r2)     // Catch:{ all -> 0x0075 }
                    throw r1
                L_0x0075:
                    r0 = move-exception
                    monitor-exit(r2)     // Catch:{ all -> 0x0075 }
                    throw r0
                */
                throw new UnsupportedOperationException("Method not decompiled: com.applovin.impl.sdk.utils.r.AnonymousClass1.run():void");
            }
        };
    }
}
