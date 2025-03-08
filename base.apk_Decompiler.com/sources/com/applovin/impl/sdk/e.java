package com.applovin.impl.sdk;

import android.content.Intent;
import android.content.IntentFilter;
import com.applovin.impl.sdk.AppLovinBroadcastManager;
import com.applovin.impl.sdk.utils.r;
import java.lang.ref.WeakReference;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;

public class e implements AppLovinBroadcastManager.Receiver {
    private r ayU;
    private final Object ayX = new Object();
    private final AtomicBoolean ayY = new AtomicBoolean();
    private boolean ayZ;
    private final WeakReference<a> aza;
    private long azb;
    private final n sdk;

    public interface a {
        void onAdRefresh();
    }

    public boolean AL() {
        return this.ayZ;
    }

    public e(n nVar, a aVar) {
        this.aza = new WeakReference<>(aVar);
        this.sdk = nVar;
    }

    public boolean AG() {
        boolean z;
        synchronized (this.ayX) {
            z = this.ayU != null;
        }
        return z;
    }

    public long AH() {
        long AH;
        synchronized (this.ayX) {
            r rVar = this.ayU;
            AH = rVar != null ? rVar.AH() : -1;
        }
        return AH;
    }

    public void bK(long j) {
        synchronized (this.ayX) {
            AI();
            this.azb = j;
            this.ayU = r.b(j, this.sdk, new e$$ExternalSyntheticLambda0(this));
            if (!((Boolean) this.sdk.a(com.applovin.impl.sdk.c.a.aJv)).booleanValue()) {
                AppLovinBroadcastManager.registerReceiver(this, new IntentFilter(SessionTracker.ACTION_APPLICATION_PAUSED));
                AppLovinBroadcastManager.registerReceiver(this, new IntentFilter(SessionTracker.ACTION_APPLICATION_RESUMED));
                AppLovinBroadcastManager.registerReceiver(this, new IntentFilter("com.applovin.fullscreen_ad_displayed"));
                AppLovinBroadcastManager.registerReceiver(this, new IntentFilter("com.applovin.fullscreen_ad_hidden"));
            }
            if (((Boolean) this.sdk.a(com.applovin.impl.sdk.c.a.aJu)).booleanValue() && (this.sdk.Cf().Fc() || this.sdk.Ce().isApplicationPaused())) {
                this.ayU.pause();
            }
            if (this.ayY.compareAndSet(true, false) && ((Boolean) this.sdk.a(com.applovin.impl.sdk.c.a.aJw)).booleanValue()) {
                this.sdk.BN();
                if (x.Fn()) {
                    this.sdk.BN().f("AdRefreshManager", "Pausing refresh for a previous request.");
                }
                this.ayU.pause();
            }
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void AQ() {
        Y();
        a aVar = (a) this.aza.get();
        if (aVar != null) {
            aVar.onAdRefresh();
        }
    }

    public void AI() {
        synchronized (this.ayX) {
            r rVar = this.ayU;
            if (rVar != null) {
                rVar.tT();
                Y();
            }
        }
    }

    public void AJ() {
        synchronized (this.ayX) {
            AM();
            this.ayZ = true;
        }
    }

    public void AK() {
        synchronized (this.ayX) {
            AN();
            this.ayZ = false;
        }
    }

    private void AM() {
        synchronized (this.ayX) {
            r rVar = this.ayU;
            if (rVar != null) {
                rVar.pause();
            } else {
                this.sdk.BN();
                if (x.Fn()) {
                    this.sdk.BN().f("AdRefreshManager", "An ad load is in progress. Will pause refresh once the ad finishes loading.");
                }
                this.ayY.set(true);
            }
        }
    }

    private void AN() {
        synchronized (this.ayX) {
            r rVar = this.ayU;
            if (rVar != null) {
                rVar.resume();
            } else {
                this.ayY.set(false);
            }
        }
    }

    private void Y() {
        synchronized (this.ayX) {
            this.ayU = null;
            if (!((Boolean) this.sdk.a(com.applovin.impl.sdk.c.a.aJv)).booleanValue()) {
                AppLovinBroadcastManager.unregisterReceiver(this);
            }
        }
    }

    public void onReceive(Intent intent, Map<String, Object> map) {
        String action = intent.getAction();
        if (SessionTracker.ACTION_APPLICATION_PAUSED.equals(action)) {
            AB();
        } else if (SessionTracker.ACTION_APPLICATION_RESUMED.equals(action)) {
            AC();
        } else if ("com.applovin.fullscreen_ad_displayed".equals(action)) {
            AO();
        } else if ("com.applovin.fullscreen_ad_hidden".equals(action)) {
            AP();
        }
    }

    public void AB() {
        if (((Boolean) this.sdk.a(com.applovin.impl.sdk.c.a.aJt)).booleanValue()) {
            AM();
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0030, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0056, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x0087, code lost:
        if (r2 == false) goto L_?;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x0089, code lost:
        r0 = (com.applovin.impl.sdk.e.a) r9.aza.get();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x0091, code lost:
        if (r0 == null) goto L_?;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:0x0093, code lost:
        r0.onAdRefresh();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:40:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:41:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:42:?, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void AC() {
        /*
            r9 = this;
            com.applovin.impl.sdk.n r0 = r9.sdk
            com.applovin.impl.sdk.c.b<java.lang.Boolean> r1 = com.applovin.impl.sdk.c.a.aJt
            java.lang.Object r0 = r0.a(r1)
            java.lang.Boolean r0 = (java.lang.Boolean) r0
            boolean r0 = r0.booleanValue()
            if (r0 == 0) goto L_0x009a
            java.lang.Object r0 = r9.ayX
            monitor-enter(r0)
            boolean r1 = r9.ayZ     // Catch:{ all -> 0x0097 }
            if (r1 == 0) goto L_0x0031
            com.applovin.impl.sdk.n r1 = r9.sdk     // Catch:{ all -> 0x0097 }
            r1.BN()     // Catch:{ all -> 0x0097 }
            boolean r1 = com.applovin.impl.sdk.x.Fn()     // Catch:{ all -> 0x0097 }
            if (r1 == 0) goto L_0x002f
            com.applovin.impl.sdk.n r1 = r9.sdk     // Catch:{ all -> 0x0097 }
            com.applovin.impl.sdk.x r1 = r1.BN()     // Catch:{ all -> 0x0097 }
            java.lang.String r2 = "AdRefreshManager"
            java.lang.String r3 = "Application resumed but banner ad refresh paused by publisher. Waiting for publisher to resume banner ad refresh."
            r1.f(r2, r3)     // Catch:{ all -> 0x0097 }
        L_0x002f:
            monitor-exit(r0)     // Catch:{ all -> 0x0097 }
            return
        L_0x0031:
            com.applovin.impl.sdk.n r1 = r9.sdk     // Catch:{ all -> 0x0097 }
            com.applovin.impl.sdk.u r1 = r1.Cf()     // Catch:{ all -> 0x0097 }
            boolean r1 = r1.Fc()     // Catch:{ all -> 0x0097 }
            if (r1 == 0) goto L_0x0057
            com.applovin.impl.sdk.n r1 = r9.sdk     // Catch:{ all -> 0x0097 }
            r1.BN()     // Catch:{ all -> 0x0097 }
            boolean r1 = com.applovin.impl.sdk.x.Fn()     // Catch:{ all -> 0x0097 }
            if (r1 == 0) goto L_0x0055
            com.applovin.impl.sdk.n r1 = r9.sdk     // Catch:{ all -> 0x0097 }
            com.applovin.impl.sdk.x r1 = r1.BN()     // Catch:{ all -> 0x0097 }
            java.lang.String r2 = "AdRefreshManager"
            java.lang.String r3 = "Waiting for the full screen ad to be dismissed to resume the timer."
            r1.f(r2, r3)     // Catch:{ all -> 0x0097 }
        L_0x0055:
            monitor-exit(r0)     // Catch:{ all -> 0x0097 }
            return
        L_0x0057:
            com.applovin.impl.sdk.utils.r r1 = r9.ayU     // Catch:{ all -> 0x0097 }
            r2 = 0
            if (r1 == 0) goto L_0x0086
            long r3 = r9.azb     // Catch:{ all -> 0x0097 }
            long r5 = r9.AH()     // Catch:{ all -> 0x0097 }
            long r3 = r3 - r5
            com.applovin.impl.sdk.n r1 = r9.sdk     // Catch:{ all -> 0x0097 }
            com.applovin.impl.sdk.c.b<java.lang.Long> r5 = com.applovin.impl.sdk.c.a.aJs     // Catch:{ all -> 0x0097 }
            java.lang.Object r1 = r1.a(r5)     // Catch:{ all -> 0x0097 }
            java.lang.Long r1 = (java.lang.Long) r1     // Catch:{ all -> 0x0097 }
            long r5 = r1.longValue()     // Catch:{ all -> 0x0097 }
            r7 = 0
            int r1 = (r5 > r7 ? 1 : (r5 == r7 ? 0 : -1))
            if (r1 < 0) goto L_0x0081
            int r1 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r1 <= 0) goto L_0x0081
            r9.AI()     // Catch:{ all -> 0x0097 }
            r1 = 1
            r2 = 1
            goto L_0x0086
        L_0x0081:
            com.applovin.impl.sdk.utils.r r1 = r9.ayU     // Catch:{ all -> 0x0097 }
            r1.resume()     // Catch:{ all -> 0x0097 }
        L_0x0086:
            monitor-exit(r0)     // Catch:{ all -> 0x0097 }
            if (r2 == 0) goto L_0x009a
            java.lang.ref.WeakReference<com.applovin.impl.sdk.e$a> r0 = r9.aza
            java.lang.Object r0 = r0.get()
            com.applovin.impl.sdk.e$a r0 = (com.applovin.impl.sdk.e.a) r0
            if (r0 == 0) goto L_0x009a
            r0.onAdRefresh()
            goto L_0x009a
        L_0x0097:
            r1 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x0097 }
            throw r1
        L_0x009a:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.applovin.impl.sdk.e.AC():void");
    }

    private void AO() {
        if (((Boolean) this.sdk.a(com.applovin.impl.sdk.c.a.aJu)).booleanValue()) {
            AM();
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0030, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0056, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:?, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void AP() {
        /*
            r4 = this;
            com.applovin.impl.sdk.n r0 = r4.sdk
            com.applovin.impl.sdk.c.b<java.lang.Boolean> r1 = com.applovin.impl.sdk.c.a.aJu
            java.lang.Object r0 = r0.a(r1)
            java.lang.Boolean r0 = (java.lang.Boolean) r0
            boolean r0 = r0.booleanValue()
            if (r0 == 0) goto L_0x0063
            java.lang.Object r0 = r4.ayX
            monitor-enter(r0)
            boolean r1 = r4.ayZ     // Catch:{ all -> 0x0060 }
            if (r1 == 0) goto L_0x0031
            com.applovin.impl.sdk.n r1 = r4.sdk     // Catch:{ all -> 0x0060 }
            r1.BN()     // Catch:{ all -> 0x0060 }
            boolean r1 = com.applovin.impl.sdk.x.Fn()     // Catch:{ all -> 0x0060 }
            if (r1 == 0) goto L_0x002f
            com.applovin.impl.sdk.n r1 = r4.sdk     // Catch:{ all -> 0x0060 }
            com.applovin.impl.sdk.x r1 = r1.BN()     // Catch:{ all -> 0x0060 }
            java.lang.String r2 = "AdRefreshManager"
            java.lang.String r3 = "Fullscreen ad dismissed but banner ad refresh paused by publisher. Waiting for publisher to resume banner ad refresh."
            r1.f(r2, r3)     // Catch:{ all -> 0x0060 }
        L_0x002f:
            monitor-exit(r0)     // Catch:{ all -> 0x0060 }
            return
        L_0x0031:
            com.applovin.impl.sdk.n r1 = r4.sdk     // Catch:{ all -> 0x0060 }
            com.applovin.impl.sdk.SessionTracker r1 = r1.Ce()     // Catch:{ all -> 0x0060 }
            boolean r1 = r1.isApplicationPaused()     // Catch:{ all -> 0x0060 }
            if (r1 == 0) goto L_0x0057
            com.applovin.impl.sdk.n r1 = r4.sdk     // Catch:{ all -> 0x0060 }
            r1.BN()     // Catch:{ all -> 0x0060 }
            boolean r1 = com.applovin.impl.sdk.x.Fn()     // Catch:{ all -> 0x0060 }
            if (r1 == 0) goto L_0x0055
            com.applovin.impl.sdk.n r1 = r4.sdk     // Catch:{ all -> 0x0060 }
            com.applovin.impl.sdk.x r1 = r1.BN()     // Catch:{ all -> 0x0060 }
            java.lang.String r2 = "AdRefreshManager"
            java.lang.String r3 = "Waiting for the application to enter foreground to resume the timer."
            r1.f(r2, r3)     // Catch:{ all -> 0x0060 }
        L_0x0055:
            monitor-exit(r0)     // Catch:{ all -> 0x0060 }
            return
        L_0x0057:
            com.applovin.impl.sdk.utils.r r1 = r4.ayU     // Catch:{ all -> 0x0060 }
            if (r1 == 0) goto L_0x005e
            r1.resume()     // Catch:{ all -> 0x0060 }
        L_0x005e:
            monitor-exit(r0)     // Catch:{ all -> 0x0060 }
            goto L_0x0063
        L_0x0060:
            r1 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x0060 }
            throw r1
        L_0x0063:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.applovin.impl.sdk.e.AP():void");
    }
}
