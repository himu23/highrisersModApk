package com.applovin.impl.sdk;

import android.content.Intent;
import com.applovin.impl.sdk.AppLovinBroadcastManager;
import com.applovin.impl.sdk.ad.g;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public class b implements AppLovinBroadcastManager.Receiver {
    private static final long ayP = TimeUnit.SECONDS.toMillis(2);
    private final HashSet<c> ayQ = new HashSet<>();
    private final Object ayR = new Object();
    private final x logger;
    private final n sdk;

    public interface a {
        void onAdExpired(g gVar);
    }

    public b(n nVar) {
        this.sdk = nVar;
        this.logger = nVar.BN();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:9:0x002a, code lost:
        return true;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean a(com.applovin.impl.sdk.ad.g r11, com.applovin.impl.sdk.b.a r12) {
        /*
            r10 = this;
            java.lang.String r0 = "Ad has already expired: "
            java.lang.String r1 = "Scheduling ad expiration "
            java.lang.String r2 = "Ad expiration already scheduled for ad: "
            java.lang.Object r3 = r10.ayR
            monitor-enter(r3)
            com.applovin.impl.sdk.c r4 = r10.b(r11)     // Catch:{ all -> 0x00ad }
            r5 = 1
            if (r4 == 0) goto L_0x002b
            boolean r12 = com.applovin.impl.sdk.x.Fn()     // Catch:{ all -> 0x00ad }
            if (r12 == 0) goto L_0x0029
            com.applovin.impl.sdk.x r12 = r10.logger     // Catch:{ all -> 0x00ad }
            java.lang.String r0 = "AdExpirationManager"
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ all -> 0x00ad }
            r1.<init>(r2)     // Catch:{ all -> 0x00ad }
            r1.append(r11)     // Catch:{ all -> 0x00ad }
            java.lang.String r11 = r1.toString()     // Catch:{ all -> 0x00ad }
            r12.f(r0, r11)     // Catch:{ all -> 0x00ad }
        L_0x0029:
            monitor-exit(r3)     // Catch:{ all -> 0x00ad }
            return r5
        L_0x002b:
            long r6 = r11.getTimeToLiveMillis()     // Catch:{ all -> 0x00ad }
            long r8 = ayP     // Catch:{ all -> 0x00ad }
            int r2 = (r6 > r8 ? 1 : (r6 == r8 ? 0 : -1))
            if (r2 > 0) goto L_0x0054
            boolean r12 = com.applovin.impl.sdk.x.Fn()     // Catch:{ all -> 0x00ad }
            if (r12 == 0) goto L_0x004e
            com.applovin.impl.sdk.x r12 = r10.logger     // Catch:{ all -> 0x00ad }
            java.lang.String r1 = "AdExpirationManager"
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x00ad }
            r2.<init>(r0)     // Catch:{ all -> 0x00ad }
            r2.append(r11)     // Catch:{ all -> 0x00ad }
            java.lang.String r0 = r2.toString()     // Catch:{ all -> 0x00ad }
            r12.f(r1, r0)     // Catch:{ all -> 0x00ad }
        L_0x004e:
            r11.setExpired()     // Catch:{ all -> 0x00ad }
            monitor-exit(r3)     // Catch:{ all -> 0x00ad }
            r11 = 0
            return r11
        L_0x0054:
            boolean r0 = com.applovin.impl.sdk.x.Fn()     // Catch:{ all -> 0x00ad }
            if (r0 == 0) goto L_0x0084
            com.applovin.impl.sdk.x r0 = r10.logger     // Catch:{ all -> 0x00ad }
            java.lang.String r2 = "AdExpirationManager"
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ all -> 0x00ad }
            r4.<init>(r1)     // Catch:{ all -> 0x00ad }
            java.util.concurrent.TimeUnit r1 = java.util.concurrent.TimeUnit.MILLISECONDS     // Catch:{ all -> 0x00ad }
            long r6 = r11.getTimeToLiveMillis()     // Catch:{ all -> 0x00ad }
            long r6 = r1.toSeconds(r6)     // Catch:{ all -> 0x00ad }
            r4.append(r6)     // Catch:{ all -> 0x00ad }
            java.lang.String r1 = " seconds from now for "
            r4.append(r1)     // Catch:{ all -> 0x00ad }
            r4.append(r11)     // Catch:{ all -> 0x00ad }
            java.lang.String r1 = "..."
            r4.append(r1)     // Catch:{ all -> 0x00ad }
            java.lang.String r1 = r4.toString()     // Catch:{ all -> 0x00ad }
            r0.f(r2, r1)     // Catch:{ all -> 0x00ad }
        L_0x0084:
            java.util.HashSet<com.applovin.impl.sdk.c> r0 = r10.ayQ     // Catch:{ all -> 0x00ad }
            boolean r0 = r0.isEmpty()     // Catch:{ all -> 0x00ad }
            if (r0 == 0) goto L_0x00a0
            android.content.IntentFilter r0 = new android.content.IntentFilter     // Catch:{ all -> 0x00ad }
            java.lang.String r1 = "com.applovin.application_paused"
            r0.<init>(r1)     // Catch:{ all -> 0x00ad }
            com.applovin.impl.sdk.AppLovinBroadcastManager.registerReceiver(r10, r0)     // Catch:{ all -> 0x00ad }
            android.content.IntentFilter r0 = new android.content.IntentFilter     // Catch:{ all -> 0x00ad }
            java.lang.String r1 = "com.applovin.application_resumed"
            r0.<init>(r1)     // Catch:{ all -> 0x00ad }
            com.applovin.impl.sdk.AppLovinBroadcastManager.registerReceiver(r10, r0)     // Catch:{ all -> 0x00ad }
        L_0x00a0:
            com.applovin.impl.sdk.n r0 = r10.sdk     // Catch:{ all -> 0x00ad }
            com.applovin.impl.sdk.c r11 = com.applovin.impl.sdk.c.a(r11, r12, r0)     // Catch:{ all -> 0x00ad }
            java.util.HashSet<com.applovin.impl.sdk.c> r12 = r10.ayQ     // Catch:{ all -> 0x00ad }
            r12.add(r11)     // Catch:{ all -> 0x00ad }
            monitor-exit(r3)     // Catch:{ all -> 0x00ad }
            return r5
        L_0x00ad:
            r11 = move-exception
            monitor-exit(r3)     // Catch:{ all -> 0x00ad }
            throw r11
        */
        throw new UnsupportedOperationException("Method not decompiled: com.applovin.impl.sdk.b.a(com.applovin.impl.sdk.ad.g, com.applovin.impl.sdk.b$a):boolean");
    }

    public void a(g gVar) {
        synchronized (this.ayR) {
            c b = b(gVar);
            if (b != null) {
                if (x.Fn()) {
                    x xVar = this.logger;
                    xVar.f("AdExpirationManager", "Cancelling expiration timer for ad: " + gVar);
                }
                b.tT();
                a(b);
            }
        }
    }

    public void a(c cVar) {
        synchronized (this.ayR) {
            this.ayQ.remove(cVar);
            if (this.ayQ.isEmpty()) {
                AppLovinBroadcastManager.unregisterReceiver(this);
            }
        }
    }

    private c b(g gVar) {
        synchronized (this.ayR) {
            if (gVar == null) {
                return null;
            }
            Iterator<c> it = this.ayQ.iterator();
            while (it.hasNext()) {
                c next = it.next();
                if (gVar == next.AD()) {
                    return next;
                }
            }
            return null;
        }
    }

    public void onReceive(Intent intent, Map<String, Object> map) {
        String action = intent.getAction();
        if (SessionTracker.ACTION_APPLICATION_PAUSED.equals(action)) {
            AB();
        } else if (SessionTracker.ACTION_APPLICATION_RESUMED.equals(action)) {
            AC();
        }
    }

    private void AB() {
        synchronized (this.ayR) {
            Iterator<c> it = this.ayQ.iterator();
            while (it.hasNext()) {
                it.next().tT();
            }
        }
    }

    private void AC() {
        HashSet hashSet = new HashSet();
        synchronized (this.ayR) {
            Iterator<c> it = this.ayQ.iterator();
            while (it.hasNext()) {
                c next = it.next();
                g AD = next.AD();
                if (AD == null) {
                    hashSet.add(next);
                } else {
                    long timeToLiveMillis = AD.getTimeToLiveMillis();
                    if (timeToLiveMillis <= 0) {
                        if (x.Fn()) {
                            x xVar = this.logger;
                            xVar.f("AdExpirationManager", "Ad expired while app was paused. Preparing to notify listener for ad: " + AD);
                        }
                        hashSet.add(next);
                    } else {
                        if (x.Fn()) {
                            x xVar2 = this.logger;
                            xVar2.f("AdExpirationManager", "Rescheduling expiration with remaining " + TimeUnit.MILLISECONDS.toSeconds(timeToLiveMillis) + " seconds for ad: " + AD);
                        }
                        next.bJ(timeToLiveMillis);
                    }
                }
            }
        }
        Iterator it2 = hashSet.iterator();
        while (it2.hasNext()) {
            c cVar = (c) it2.next();
            a(cVar);
            cVar.AE();
        }
    }
}
