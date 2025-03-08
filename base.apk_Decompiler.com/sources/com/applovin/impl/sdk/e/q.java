package com.applovin.impl.sdk.e;

import com.applovin.impl.sdk.n;
import com.applovin.impl.sdk.utils.f;
import com.applovin.impl.sdk.utils.u;
import com.applovin.impl.sdk.x;
import java.lang.Thread;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class q {
    private static final ExecutorService aTt = Executors.newFixedThreadPool(4);
    private final ScheduledThreadPoolExecutor aUl;
    private final ScheduledThreadPoolExecutor aUm;
    private final List<d> aUn = new ArrayList(5);
    private final Object aUo = new Object();
    private boolean aUp;
    /* access modifiers changed from: private */
    public final x logger;
    /* access modifiers changed from: private */
    public final n sdk;

    public enum b {
        MAIN,
        TIMEOUT,
        BACKGROUND,
        ADVERTISING_INFO_COLLECTION,
        POSTBACKS,
        CACHING_INTERSTITIAL,
        CACHING_INCENTIVIZED,
        CACHING_NATIVE,
        CACHING_OTHER,
        REWARD,
        MEDIATION_MAIN,
        MEDIATION_TIMEOUT,
        MEDIATION_BACKGROUND,
        MEDIATION_POSTBACKS,
        MEDIATION_BANNER,
        MEDIATION_INTERSTITIAL,
        MEDIATION_APP_OPEN,
        MEDIATION_INCENTIVIZED,
        MEDIATION_REWARDED_INTERSTITIAL,
        MEDIATION_REWARD
    }

    public Executor KI() {
        return this.aUm;
    }

    public ExecutorService KJ() {
        return aTt;
    }

    public ExecutorService KK() {
        return this.aUl;
    }

    public boolean isInitialized() {
        return this.aUp;
    }

    public q(n nVar) {
        this.sdk = nVar;
        this.logger = nVar.BN();
        this.aUl = g("auxiliary_operations", ((Integer) nVar.a(com.applovin.impl.sdk.c.b.aMN)).intValue());
        this.aUm = g("shared_thread_pool", ((Integer) nVar.a(com.applovin.impl.sdk.c.b.aKz)).intValue());
    }

    public void a(d dVar, b bVar) {
        a(dVar, bVar, 0);
    }

    public void a(d dVar, b bVar, long j) {
        a(dVar, bVar, j, false);
    }

    public void a(d dVar, b bVar, long j, boolean z) {
        if (dVar == null) {
            throw new IllegalArgumentException("No task specified");
        } else if (j >= 0) {
            d dVar2 = new d(this.sdk, dVar, bVar);
            if (!a(dVar2)) {
                a((Runnable) dVar2, j, z);
            } else if (x.Fn()) {
                this.logger.g(dVar.Kg(), "Task execution delayed until after init");
            }
        } else {
            throw new IllegalArgumentException("Invalid delay (millis) specified: " + j);
        }
    }

    public void h(Runnable runnable) {
        this.aUl.submit(runnable);
    }

    public void b(d dVar) {
        if (dVar != null) {
            try {
                if (u.Lx()) {
                    this.aUm.submit(new d(this.sdk, dVar, b.MAIN));
                } else {
                    dVar.run();
                }
            } catch (Throwable th) {
                if (x.Fn()) {
                    this.logger.c(dVar.Kg(), "Task failed execution", th);
                }
                dVar.q(th);
            }
        } else {
            throw new IllegalArgumentException("No task specified");
        }
    }

    private void a(Runnable runnable, long j, boolean z) {
        if (j <= 0) {
            this.aUm.submit(runnable);
        } else if (z) {
            f.a(j, this.sdk, new q$$ExternalSyntheticLambda0(this, runnable));
        } else {
            this.aUm.schedule(runnable, j, TimeUnit.MILLISECONDS);
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void i(Runnable runnable) {
        this.aUm.execute(runnable);
    }

    public ExecutorService f(String str, int i) {
        return Executors.newFixedThreadPool(i, new a(str));
    }

    public List<Future<Boolean>> a(List<a> list, ExecutorService executorService) {
        try {
            if (x.Fn()) {
                x xVar = this.logger;
                xVar.f("TaskManager", "Awaiting " + list.size() + " tasks...");
            }
            return executorService.invokeAll(list);
        } catch (Throwable th) {
            if (!x.Fn()) {
                return null;
            }
            this.logger.c("TaskManager", "Awaiting tasks were interrupted", th);
            return null;
        }
    }

    public void KL() {
        synchronized (this.aUo) {
            this.aUp = false;
        }
    }

    public void KM() {
        synchronized (this.aUo) {
            this.aUp = true;
            for (d next : this.aUn) {
                a(next.aUP, next.aUQ);
            }
            this.aUn.clear();
        }
    }

    private boolean a(d dVar) {
        if (dVar.aUP.Kh()) {
            return false;
        }
        synchronized (this.aUo) {
            if (this.aUp) {
                return false;
            }
            this.aUn.add(dVar);
            return true;
        }
    }

    private ScheduledThreadPoolExecutor g(String str, int i) {
        return new ScheduledThreadPoolExecutor(i, new c(str));
    }

    private static class d implements Runnable {
        /* access modifiers changed from: private */
        public final d aUP;
        /* access modifiers changed from: private */
        public final b aUQ;
        private final x logger;
        private final n sdk;
        private final String tag;

        public d(n nVar, d dVar, b bVar) {
            this.sdk = nVar;
            this.logger = nVar.BN();
            this.tag = dVar.Kg();
            this.aUP = dVar;
            this.aUQ = bVar;
        }

        /* JADX WARNING: Removed duplicated region for block: B:14:0x0040  */
        /* JADX WARNING: Removed duplicated region for block: B:31:? A[RETURN, SYNTHETIC] */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void run() {
            /*
                r6 = this;
                java.lang.String r0 = " queue finished task "
                com.applovin.impl.sdk.utils.h.KU()     // Catch:{ all -> 0x004a }
                com.applovin.impl.sdk.n r1 = r6.sdk     // Catch:{ all -> 0x004a }
                boolean r1 = r1.Bp()     // Catch:{ all -> 0x004a }
                if (r1 == 0) goto L_0x0035
                com.applovin.impl.sdk.e.d r1 = r6.aUP     // Catch:{ all -> 0x004a }
                boolean r1 = r1.Kh()     // Catch:{ all -> 0x004a }
                if (r1 == 0) goto L_0x0016
                goto L_0x0035
            L_0x0016:
                boolean r1 = com.applovin.impl.sdk.x.Fn()     // Catch:{ all -> 0x004a }
                if (r1 == 0) goto L_0x0025
                com.applovin.impl.sdk.x r1 = r6.logger     // Catch:{ all -> 0x004a }
                java.lang.String r2 = r6.tag     // Catch:{ all -> 0x004a }
                java.lang.String r3 = "Task re-scheduled..."
                r1.g(r2, r3)     // Catch:{ all -> 0x004a }
            L_0x0025:
                com.applovin.impl.sdk.n r1 = r6.sdk     // Catch:{ all -> 0x004a }
                com.applovin.impl.sdk.e.q r1 = r1.BO()     // Catch:{ all -> 0x004a }
                com.applovin.impl.sdk.e.d r2 = r6.aUP     // Catch:{ all -> 0x004a }
                com.applovin.impl.sdk.e.q$b r3 = r6.aUQ     // Catch:{ all -> 0x004a }
                r4 = 2000(0x7d0, double:9.88E-321)
                r1.a((com.applovin.impl.sdk.e.d) r2, (com.applovin.impl.sdk.e.q.b) r3, (long) r4)     // Catch:{ all -> 0x004a }
                goto L_0x003a
            L_0x0035:
                com.applovin.impl.sdk.e.d r1 = r6.aUP     // Catch:{ all -> 0x004a }
                r1.run()     // Catch:{ all -> 0x004a }
            L_0x003a:
                boolean r1 = com.applovin.impl.sdk.x.Fn()
                if (r1 == 0) goto L_0x0086
                com.applovin.impl.sdk.x r1 = r6.logger
                java.lang.String r2 = r6.tag
                java.lang.StringBuilder r3 = new java.lang.StringBuilder
                r3.<init>()
                goto L_0x006e
            L_0x004a:
                r1 = move-exception
                boolean r2 = com.applovin.impl.sdk.x.Fn()     // Catch:{ all -> 0x0087 }
                if (r2 == 0) goto L_0x005a
                com.applovin.impl.sdk.x r2 = r6.logger     // Catch:{ all -> 0x0087 }
                java.lang.String r3 = r6.tag     // Catch:{ all -> 0x0087 }
                java.lang.String r4 = "Task failed execution"
                r2.c(r3, r4, r1)     // Catch:{ all -> 0x0087 }
            L_0x005a:
                com.applovin.impl.sdk.e.d r2 = r6.aUP     // Catch:{ all -> 0x0087 }
                r2.q(r1)     // Catch:{ all -> 0x0087 }
                boolean r1 = com.applovin.impl.sdk.x.Fn()
                if (r1 == 0) goto L_0x0086
                com.applovin.impl.sdk.x r1 = r6.logger
                java.lang.String r2 = r6.tag
                java.lang.StringBuilder r3 = new java.lang.StringBuilder
                r3.<init>()
            L_0x006e:
                com.applovin.impl.sdk.e.q$b r4 = r6.aUQ
                r3.append(r4)
                r3.append(r0)
                com.applovin.impl.sdk.e.d r0 = r6.aUP
                java.lang.String r0 = r0.Kg()
                r3.append(r0)
                java.lang.String r0 = r3.toString()
                r1.g(r2, r0)
            L_0x0086:
                return
            L_0x0087:
                r1 = move-exception
                boolean r2 = com.applovin.impl.sdk.x.Fn()
                if (r2 == 0) goto L_0x00af
                com.applovin.impl.sdk.x r2 = r6.logger
                java.lang.String r3 = r6.tag
                java.lang.StringBuilder r4 = new java.lang.StringBuilder
                r4.<init>()
                com.applovin.impl.sdk.e.q$b r5 = r6.aUQ
                r4.append(r5)
                r4.append(r0)
                com.applovin.impl.sdk.e.d r0 = r6.aUP
                java.lang.String r0 = r0.Kg()
                r4.append(r0)
                java.lang.String r0 = r4.toString()
                r2.g(r3, r0)
            L_0x00af:
                throw r1
            */
            throw new UnsupportedOperationException("Method not decompiled: com.applovin.impl.sdk.e.q.d.run():void");
        }
    }

    private class c implements ThreadFactory {
        private final String name;

        c(String str) {
            this.name = str;
        }

        public Thread newThread(Runnable runnable) {
            Thread thread = new Thread(runnable, "AppLovinSdk:" + this.name);
            thread.setDaemon(true);
            thread.setPriority(((Integer) q.this.sdk.a(com.applovin.impl.sdk.c.b.aQJ)).intValue());
            thread.setUncaughtExceptionHandler(new Thread.UncaughtExceptionHandler() {
                public void uncaughtException(Thread thread, Throwable th) {
                    x unused = q.this.logger;
                    if (x.Fn()) {
                        q.this.logger.c("TaskManager", "Caught unhandled exception", th);
                    }
                }
            });
            return thread;
        }
    }

    private class a implements ThreadFactory {
        private final AtomicInteger aUq = new AtomicInteger(1);
        private final String name;

        a(String str) {
            this.name = str;
        }

        public Thread newThread(Runnable runnable) {
            Thread thread = new Thread(runnable, "AppLovinSdk:" + this.name + "-" + this.aUq.getAndIncrement());
            thread.setDaemon(true);
            thread.setPriority(((Integer) q.this.sdk.a(com.applovin.impl.sdk.c.b.aQJ)).intValue());
            thread.setUncaughtExceptionHandler(new Thread.UncaughtExceptionHandler() {
                public void uncaughtException(Thread thread, Throwable th) {
                    q.this.sdk.BN();
                    if (x.Fn()) {
                        q.this.sdk.BN().c("TaskManager", "Caught unhandled exception", th);
                    }
                }
            });
            return thread;
        }
    }
}
