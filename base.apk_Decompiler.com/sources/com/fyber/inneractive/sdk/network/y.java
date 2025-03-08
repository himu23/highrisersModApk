package com.fyber.inneractive.sdk.network;

import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Handler;
import android.os.Looper;
import com.fyber.inneractive.sdk.config.IAConfigManager;
import com.fyber.inneractive.sdk.config.global.features.k;
import com.fyber.inneractive.sdk.util.IAlog;
import com.fyber.inneractive.sdk.util.p;
import com.fyber.inneractive.sdk.util.q;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;
import java.util.Comparator;
import java.util.Locale;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class y {
    public static final ThreadFactory g = new a();
    public BlockingQueue<c0<?>> a = new PriorityBlockingQueue(100, new d((a) null));
    public volatile boolean b = false;
    public final Handler c = new Handler(Looper.getMainLooper());
    public final ThreadPoolExecutor d = new ThreadPoolExecutor(6, 6, 1000, TimeUnit.SECONDS, new LinkedBlockingQueue(100), g);
    public final Runnable e = new b();
    public s0 f = new s0();

    public class a implements ThreadFactory {
        public final AtomicInteger a = new AtomicInteger(100);

        public Thread newThread(Runnable runnable) {
            return new Thread(runnable, String.format(Locale.ENGLISH, "FyberMarketplace-Network-%02d", new Object[]{Integer.valueOf(this.a.getAndIncrement())}));
        }
    }

    public class b implements Runnable {
        public b() {
        }

        /* JADX WARNING: Removed duplicated region for block: B:49:0x00d7 A[Catch:{ all -> 0x00db }] */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void run() {
            /*
                r10 = this;
                com.fyber.inneractive.sdk.network.y r0 = com.fyber.inneractive.sdk.network.y.this
                r0.getClass()
                r1 = 10
                android.os.Process.setThreadPriority(r1)
            L_0x000a:
                boolean r1 = r0.b
                if (r1 == 0) goto L_0x00f2
                r1 = 0
                java.util.concurrent.BlockingQueue<com.fyber.inneractive.sdk.network.c0<?>> r2 = r0.a     // Catch:{ InterruptedException -> 0x0018 }
                java.lang.Object r2 = r2.take()     // Catch:{ InterruptedException -> 0x0018 }
                com.fyber.inneractive.sdk.network.c0 r2 = (com.fyber.inneractive.sdk.network.c0) r2     // Catch:{ InterruptedException -> 0x0018 }
                goto L_0x0025
            L_0x0018:
                boolean r2 = r0.b
                if (r2 != 0) goto L_0x0024
                java.lang.Thread r2 = java.lang.Thread.currentThread()
                r2.interrupt()
            L_0x0024:
                r2 = r1
            L_0x0025:
                if (r2 == 0) goto L_0x000a
                boolean r3 = r2.g()
                if (r3 != 0) goto L_0x000a
                com.fyber.inneractive.sdk.network.r0 r3 = com.fyber.inneractive.sdk.network.r0.RUNNING
                r2.a((com.fyber.inneractive.sdk.network.r0) r3)
                boolean r3 = r0.e(r2)
                r4 = 1
                r5 = 0
                if (r3 == 0) goto L_0x007d
                com.fyber.inneractive.sdk.network.s0 r3 = r0.f
                java.lang.Thread r6 = java.lang.Thread.currentThread()
                r3.getClass()
                r7 = 2
                java.lang.Object[] r7 = new java.lang.Object[r7]
                java.lang.String r8 = com.fyber.inneractive.sdk.util.IAlog.a((java.lang.Object) r3)
                r7[r5] = r8
                java.lang.String r8 = r2.f()
                r7[r4] = r8
                java.lang.String r8 = "%s : NetworkRequestWatchdog : register request: %s"
                com.fyber.inneractive.sdk.util.IAlog.a(r8, r7)
                int r7 = r2.h()
                com.fyber.inneractive.sdk.network.u0 r8 = r2.n()
                int r9 = r8.a
                int r8 = r8.b
                int r9 = r9 + r8
                int r9 = r9 + r7
                com.fyber.inneractive.sdk.network.v0 r7 = new com.fyber.inneractive.sdk.network.v0
                r7.<init>(r2, r6, r9)
                java.util.concurrent.ConcurrentHashMap<java.lang.String, com.fyber.inneractive.sdk.network.v0> r3 = r3.a
                java.lang.String r6 = r2.f()
                r3.putIfAbsent(r6, r7)
                java.lang.Runnable r3 = r7.d
                int r6 = r7.c
                long r6 = (long) r6
                android.os.Handler r8 = com.fyber.inneractive.sdk.util.q.b
                r8.postDelayed(r3, r6)
            L_0x007d:
                boolean r3 = r2.g()     // Catch:{ Exception -> 0x008e }
                if (r3 != 0) goto L_0x009f
                java.lang.String r3 = r2.c()     // Catch:{ Exception -> 0x008e }
                if (r3 == 0) goto L_0x009f
                com.fyber.inneractive.sdk.network.a r3 = r2.k()     // Catch:{ Exception -> 0x008e }
                goto L_0x00a0
            L_0x008e:
                r3 = move-exception
                java.lang.Object[] r6 = new java.lang.Object[r5]
                java.lang.String r7 = "failed fetching cache data"
                com.fyber.inneractive.sdk.util.IAlog.a(r7, r3, r6)
                boolean r6 = r2.g()
                if (r6 != 0) goto L_0x009f
                r2.a(r1, (java.lang.Exception) r3, (boolean) r4)
            L_0x009f:
                r3 = r1
            L_0x00a0:
                if (r3 == 0) goto L_0x00b1
                T r6 = r3.b
                if (r6 == 0) goto L_0x00b1
                boolean r6 = r2.g()
                if (r6 != 0) goto L_0x00b1
                T r6 = r3.b
                r2.a(r6, (java.lang.Exception) r1, (boolean) r4)
            L_0x00b1:
                com.fyber.inneractive.sdk.network.j r3 = r0.a((com.fyber.inneractive.sdk.network.c0<?>) r2, (com.fyber.inneractive.sdk.network.a<?>) r3)     // Catch:{ a1 -> 0x00e6, Exception -> 0x00cf, all -> 0x00cb }
                com.fyber.inneractive.sdk.network.b0 r4 = r0.a(r2, (com.fyber.inneractive.sdk.network.j) r3)     // Catch:{ a1 -> 0x00e6, Exception -> 0x00cf, all -> 0x00cb }
                r0.a(r2, r3, r4)     // Catch:{ a1 -> 0x00c9, Exception -> 0x00c7 }
                r0.a(r2, (com.fyber.inneractive.sdk.network.b0) r4)
                r0.a(r2)
                r0.c(r2)
                goto L_0x000a
            L_0x00c7:
                r3 = move-exception
                goto L_0x00d1
            L_0x00c9:
                r1 = r4
                goto L_0x00e6
            L_0x00cb:
                r3 = move-exception
                r4 = r1
                r1 = r3
                goto L_0x00dc
            L_0x00cf:
                r3 = move-exception
                r4 = r1
            L_0x00d1:
                boolean r6 = r2.g()     // Catch:{ all -> 0x00db }
                if (r6 != 0) goto L_0x00e7
                r2.a(r1, (java.lang.Exception) r3, (boolean) r5)     // Catch:{ all -> 0x00db }
                goto L_0x00e7
            L_0x00db:
                r1 = move-exception
            L_0x00dc:
                r0.a(r2, (com.fyber.inneractive.sdk.network.b0) r4)
                r0.a(r2)
                r0.c(r2)
                throw r1
            L_0x00e6:
                r4 = r1
            L_0x00e7:
                r0.a(r2, (com.fyber.inneractive.sdk.network.b0) r4)
                r0.a(r2)
                r0.c(r2)
                goto L_0x000a
            L_0x00f2:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.fyber.inneractive.sdk.network.y.b.run():void");
        }
    }

    public class c implements Runnable {
        public final /* synthetic */ c0 a;

        public c(c0 c0Var) {
            this.a = c0Var;
        }

        public void run() {
            IAlog.d("retryNetworkRequest pre-execute - %s", this.a.getClass().getName());
            y.this.b(this.a);
        }
    }

    public static class d implements Comparator<c0> {
        public d() {
        }

        public int compare(Object obj, Object obj2) {
            return ((c0) obj).i().ordinal() - ((c0) obj2).i().ordinal();
        }

        public /* synthetic */ d(a aVar) {
            this();
        }
    }

    public final void a(c0<?> c0Var) {
        try {
            c0Var.b();
        } catch (Exception unused) {
        }
        c0Var.a(r0.DONE);
    }

    public void b(c0<?> c0Var) {
        this.a.offer(c0Var);
        c0Var.a(r0.QUEUED);
    }

    public final <T> void c(c0<T> c0Var) {
        s0 s0Var = this.f;
        s0Var.getClass();
        String f2 = c0Var.f();
        IAlog.a("%s : NetworkRequestWatchdog : finalize request: %s", IAlog.a((Object) s0Var), f2);
        v0 v0Var = s0Var.a.get(f2);
        if (v0Var != null) {
            q.b.removeCallbacks(v0Var.d);
        }
        s0Var.a.remove(f2);
    }

    public boolean d(c0<?> c0Var) {
        if (!c0Var.o()) {
            return false;
        }
        c0Var.a(r0.QUEUED_FOR_RETRY);
        long v = (long) c0Var.v();
        IAlog.d("retryNetworkRequest queue up in main thread - %s with delay of %d", c0Var.getClass().getName(), Long.valueOf(v));
        this.c.postDelayed(new c(c0Var), v);
        return true;
    }

    public final <T> boolean e(c0<T> c0Var) {
        boolean z = c0Var.s() || c0Var.j();
        IAlog.a("%s : NetworkExecutorImpl : should enabled watchdog : %s", IAlog.a((Object) this), Boolean.valueOf(z));
        return z;
    }

    public final <T> void a(c0<T> c0Var, b0 b0Var) {
        try {
            if (!c0Var.g() && b0Var != null) {
                c0Var.a(b0Var.a, (Exception) null, false);
            }
        } catch (Exception e2) {
            IAlog.a("failed notifying the listener request complete", e2, new Object[0]);
            if (!c0Var.g()) {
                c0Var.a(null, e2, false);
            }
        }
    }

    public final <T> void a(c0<T> c0Var, j jVar, b0 b0Var) {
        try {
            if (!c0Var.g() && c0Var.c() != null && b0Var != null && jVar != null && jVar.a == 200) {
                c0Var.a(b0Var, c0Var.c(), jVar.e);
            }
        } catch (Exception e2) {
            IAlog.a("Failed cache network response data", e2, new Object[0]);
        }
    }

    public final <T> b0 a(c0<T> c0Var, j jVar) throws Exception {
        if (jVar == null) {
            return null;
        }
        try {
            if (c0Var.g()) {
                return null;
            }
            int i = jVar.a;
            if (i != 200) {
                if (i < 300 || i >= 304) {
                    if (i == 304) {
                        c0Var.a(null, (Exception) new f(), false);
                        return null;
                    }
                    c0Var.a(null, (Exception) new t0(jVar.a, jVar.b), false);
                    return null;
                }
            }
            return c0Var.a(jVar, jVar.d, i);
        } catch (a1 e2) {
            IAlog.a("failed parsing network request but will retry", e2, new Object[0]);
            if (d(c0Var)) {
                throw e2;
            }
            throw new z0(e2);
        } catch (Exception e3) {
            IAlog.a("failed parsing network request", e3, new Object[0]);
            throw e3;
        }
    }

    public final j a(c0<?> c0Var, a<?> aVar) throws Exception {
        try {
            if (c0Var.g()) {
                return null;
            }
            String str = aVar != null ? aVar.a : "";
            a();
            return c0Var.a(str);
        } catch (a1 e2) {
            IAlog.a("failed sending network request but will retry", e2, new Object[0]);
            if (d(c0Var)) {
                throw e2;
            }
            throw new z0(e2);
        } catch (b | SocketTimeoutException | UnknownHostException e3) {
            IAlog.a("failed sending network request", e3, new Object[0]);
            if (d(c0Var)) {
                throw new a1(e3);
            }
            throw new z0(e3);
        } catch (Exception e4) {
            IAlog.a("failed sending network request", e4, new Object[0]);
            throw e4;
        }
    }

    public final void a() throws b {
        if (((k) IAConfigManager.M.L.a(k.class)).a("should_use_is_network_connected", false)) {
            try {
                ConnectivityManager connectivityManager = (ConnectivityManager) p.a.getSystemService("connectivity");
                NetworkInfo activeNetworkInfo = connectivityManager != null ? connectivityManager.getActiveNetworkInfo() : null;
                if (!p.b("android.permission.ACCESS_NETWORK_STATE") || activeNetworkInfo == null || !activeNetworkInfo.isConnectedOrConnecting()) {
                    throw new b("No network connection");
                }
            } catch (Throwable unused) {
                IAlog.b("Error retrieved when trying to get the network state - Perhaps you forgot to declare android.permission.ACCESS_NETWORK_STATE in your Android manifest file.", new Object[0]);
            }
        }
    }
}
