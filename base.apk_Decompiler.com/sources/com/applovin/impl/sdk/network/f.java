package com.applovin.impl.sdk.network;

import android.content.Intent;
import android.content.IntentFilter;
import android.text.TextUtils;
import com.applovin.impl.sdk.AppLovinBroadcastManager;
import com.applovin.impl.sdk.SessionTracker;
import com.applovin.impl.sdk.c.b;
import com.applovin.impl.sdk.e.ab;
import com.applovin.impl.sdk.e.d;
import com.applovin.impl.sdk.e.q;
import com.applovin.impl.sdk.n;
import com.applovin.impl.sdk.utils.u;
import com.applovin.impl.sdk.x;
import com.applovin.sdk.AppLovinPostbackListener;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class f implements AppLovinBroadcastManager.Receiver {
    private final Object aFv = new Object();
    private final int aId;
    private final g aIe;
    private final List<h> aIf;
    private final Set<h> aIg;
    private final List<h> aIh;
    /* access modifiers changed from: private */
    public final x logger;
    /* access modifiers changed from: private */
    public final n sdk;

    public f(n nVar) {
        ArrayList arrayList = new ArrayList();
        this.aIf = arrayList;
        this.aIg = new HashSet();
        this.aIh = new ArrayList();
        if (nVar != null) {
            this.sdk = nVar;
            this.logger = nVar.BN();
            int intValue = ((Integer) nVar.a(b.aNF)).intValue();
            this.aId = intValue;
            if (((Boolean) nVar.a(b.aNI)).booleanValue()) {
                g gVar = new g(this, nVar);
                this.aIe = gVar;
                if (!u.a(b.aMb, nVar) || !u.Lx()) {
                    arrayList.addAll(gVar.gJ(intValue));
                } else {
                    a((Runnable) new f$$ExternalSyntheticLambda1(this), true, true);
                }
                AppLovinBroadcastManager.registerReceiver(this, new IntentFilter(SessionTracker.ACTION_APPLICATION_PAUSED));
                return;
            }
            this.aIe = null;
            return;
        }
        throw new IllegalArgumentException("No sdk specified");
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void ln() {
        synchronized (this.aFv) {
            this.aIf.addAll(0, this.aIe.gJ(this.aId));
        }
    }

    public void a(h hVar) {
        a(hVar, true);
    }

    public void a(h hVar, boolean z) {
        a(hVar, z, (AppLovinPostbackListener) null);
    }

    public void a(h hVar, boolean z, AppLovinPostbackListener appLovinPostbackListener) {
        if (!TextUtils.isEmpty(hVar.Iu())) {
            if (z) {
                hVar.IB();
            }
            a((Runnable) new f$$ExternalSyntheticLambda0(this, hVar, appLovinPostbackListener), u.Lx(), hVar.IE());
        } else if (x.Fn()) {
            this.logger.i("PersistentPostbackManager", "Requested a postback dispatch for empty URL; nothing to do...");
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void b(h hVar, AppLovinPostbackListener appLovinPostbackListener) {
        synchronized (this.aFv) {
            c(hVar);
            a(hVar, appLovinPostbackListener);
        }
    }

    public void Iq() {
        a((Runnable) new f$$ExternalSyntheticLambda2(this), true, false);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void It() {
        synchronized (this.aFv) {
            Iterator it = new ArrayList(this.aIf).iterator();
            while (it.hasNext()) {
                b((h) it.next());
            }
        }
    }

    /* access modifiers changed from: protected */
    public List<h> Ir() {
        ArrayList arrayList = new ArrayList();
        synchronized (this.aFv) {
            if (((Boolean) this.sdk.a(b.aNH)).booleanValue()) {
                arrayList.ensureCapacity(this.aIh.size());
                arrayList.addAll(this.aIh);
            } else {
                arrayList.ensureCapacity(this.aIf.size());
                arrayList.addAll(this.aIf);
            }
        }
        return arrayList;
    }

    private void b(h hVar) {
        a(hVar, (AppLovinPostbackListener) null);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:24:0x007e, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x0083, code lost:
        r0 = (java.lang.Integer) r5.sdk.a(com.applovin.impl.sdk.c.b.aNE);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x0095, code lost:
        if (r6.Iz() <= r0.intValue()) goto L_0x00be;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x009b, code lost:
        if (com.applovin.impl.sdk.x.Fn() == false) goto L_0x00ba;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:0x009d, code lost:
        r7 = r5.logger;
        r7.h("PersistentPostbackManager", "Exceeded maximum persisted attempt count of " + r0 + ". Dequeuing postback: " + r6);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:32:0x00ba, code lost:
        d(r6);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:33:0x00bd, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:34:0x00be, code lost:
        r0 = r5.aFv;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:35:0x00c0, code lost:
        monitor-enter(r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:37:?, code lost:
        r5.aIg.add(r6);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:38:0x00c6, code lost:
        monitor-exit(r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:40:0x00cb, code lost:
        if (r6.Iw() == null) goto L_0x00d7;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:41:0x00cd, code lost:
        r0 = new org.json.JSONObject(r6.Iw());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:42:0x00d7, code lost:
        r0 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:43:0x00d8, code lost:
        r0 = com.applovin.impl.sdk.network.i.E(r5.sdk).cW(r6.Iu()).cY(r6.Iv()).k(r6.HR()).cX(r6.HQ()).l(r6.HS()).K(r0).aU(r6.If()).aS(r6.Ic()).a(r6.Id()).bb(r6.Ix()).di(r6.Iy()).Ig();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:44:0x013a, code lost:
        if (com.applovin.impl.sdk.x.Fn() == false) goto L_0x0151;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:45:0x013c, code lost:
        r1 = r5.logger;
        r1.f("PersistentPostbackManager", "Submitting postback: " + r6);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:46:0x0151, code lost:
        r5.sdk.Ct().dispatchPostbackRequest(r0, new com.applovin.impl.sdk.network.f.AnonymousClass1(r5));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:47:0x015f, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void a(final com.applovin.impl.sdk.network.h r6, final com.applovin.sdk.AppLovinPostbackListener r7) {
        /*
            r5 = this;
            java.lang.String r0 = "Skipping in progress postback: "
            boolean r1 = com.applovin.impl.sdk.x.Fn()
            if (r1 == 0) goto L_0x001d
            com.applovin.impl.sdk.x r1 = r5.logger
            java.lang.String r2 = "PersistentPostbackManager"
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            java.lang.String r4 = "Preparing to submit postback: "
            r3.<init>(r4)
            r3.append(r6)
            java.lang.String r3 = r3.toString()
            r1.f(r2, r3)
        L_0x001d:
            com.applovin.impl.sdk.n r1 = r5.sdk
            boolean r1 = r1.Bp()
            if (r1 == 0) goto L_0x003b
            boolean r1 = r6.IE()
            if (r1 != 0) goto L_0x003b
            boolean r6 = com.applovin.impl.sdk.x.Fn()
            if (r6 == 0) goto L_0x003a
            com.applovin.impl.sdk.x r6 = r5.logger
            java.lang.String r7 = "PersistentPostbackManager"
            java.lang.String r0 = "Skipping postback dispatch because SDK is still initializing - postback will be dispatched afterwards"
            r6.f(r7, r0)
        L_0x003a:
            return
        L_0x003b:
            java.lang.String r1 = r6.Iu()
            boolean r1 = android.text.TextUtils.isEmpty(r1)
            if (r1 == 0) goto L_0x0055
            boolean r6 = com.applovin.impl.sdk.x.Fn()
            if (r6 == 0) goto L_0x0054
            com.applovin.impl.sdk.x r6 = r5.logger
            java.lang.String r7 = "PersistentPostbackManager"
            java.lang.String r0 = "Skipping empty postback dispatch..."
            r6.i(r7, r0)
        L_0x0054:
            return
        L_0x0055:
            java.lang.Object r1 = r5.aFv
            monitor-enter(r1)
            java.util.Set<com.applovin.impl.sdk.network.h> r2 = r5.aIg     // Catch:{ all -> 0x0163 }
            boolean r2 = r2.contains(r6)     // Catch:{ all -> 0x0163 }
            if (r2 == 0) goto L_0x007f
            boolean r7 = com.applovin.impl.sdk.x.Fn()     // Catch:{ all -> 0x0163 }
            if (r7 == 0) goto L_0x007d
            com.applovin.impl.sdk.x r7 = r5.logger     // Catch:{ all -> 0x0163 }
            java.lang.String r2 = "PersistentPostbackManager"
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x0163 }
            r3.<init>(r0)     // Catch:{ all -> 0x0163 }
            java.lang.String r6 = r6.Iu()     // Catch:{ all -> 0x0163 }
            r3.append(r6)     // Catch:{ all -> 0x0163 }
            java.lang.String r6 = r3.toString()     // Catch:{ all -> 0x0163 }
            r7.f(r2, r6)     // Catch:{ all -> 0x0163 }
        L_0x007d:
            monitor-exit(r1)     // Catch:{ all -> 0x0163 }
            return
        L_0x007f:
            r6.IA()     // Catch:{ all -> 0x0163 }
            monitor-exit(r1)     // Catch:{ all -> 0x0163 }
            com.applovin.impl.sdk.n r0 = r5.sdk
            com.applovin.impl.sdk.c.b<java.lang.Integer> r1 = com.applovin.impl.sdk.c.b.aNE
            java.lang.Object r0 = r0.a(r1)
            java.lang.Integer r0 = (java.lang.Integer) r0
            int r1 = r6.Iz()
            int r2 = r0.intValue()
            if (r1 <= r2) goto L_0x00be
            boolean r7 = com.applovin.impl.sdk.x.Fn()
            if (r7 == 0) goto L_0x00ba
            com.applovin.impl.sdk.x r7 = r5.logger
            java.lang.String r1 = "PersistentPostbackManager"
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            java.lang.String r3 = "Exceeded maximum persisted attempt count of "
            r2.<init>(r3)
            r2.append(r0)
            java.lang.String r0 = ". Dequeuing postback: "
            r2.append(r0)
            r2.append(r6)
            java.lang.String r0 = r2.toString()
            r7.h(r1, r0)
        L_0x00ba:
            r5.d(r6)
            return
        L_0x00be:
            java.lang.Object r0 = r5.aFv
            monitor-enter(r0)
            java.util.Set<com.applovin.impl.sdk.network.h> r1 = r5.aIg     // Catch:{ all -> 0x0160 }
            r1.add(r6)     // Catch:{ all -> 0x0160 }
            monitor-exit(r0)     // Catch:{ all -> 0x0160 }
            java.util.Map r0 = r6.Iw()
            if (r0 == 0) goto L_0x00d7
            org.json.JSONObject r0 = new org.json.JSONObject
            java.util.Map r1 = r6.Iw()
            r0.<init>(r1)
            goto L_0x00d8
        L_0x00d7:
            r0 = 0
        L_0x00d8:
            com.applovin.impl.sdk.n r1 = r5.sdk
            com.applovin.impl.sdk.network.i$a r1 = com.applovin.impl.sdk.network.i.E(r1)
            java.lang.String r2 = r6.Iu()
            com.applovin.impl.sdk.network.i$a r1 = r1.cW(r2)
            java.lang.String r2 = r6.Iv()
            com.applovin.impl.sdk.network.i$a r1 = r1.cY(r2)
            java.util.Map r2 = r6.HR()
            com.applovin.impl.sdk.network.i$a r1 = r1.k(r2)
            java.lang.String r2 = r6.HQ()
            com.applovin.impl.sdk.network.i$a r1 = r1.cX(r2)
            java.util.Map r2 = r6.HS()
            com.applovin.impl.sdk.network.i$a r1 = r1.l(r2)
            com.applovin.impl.sdk.network.i$a r0 = r1.K(r0)
            boolean r1 = r6.If()
            com.applovin.impl.sdk.network.i$a r0 = r0.aU(r1)
            boolean r1 = r6.Ic()
            com.applovin.impl.sdk.network.i$a r0 = r0.aS(r1)
            com.applovin.impl.sdk.utils.p$a r1 = r6.Id()
            com.applovin.impl.sdk.network.i$a r0 = r0.a(r1)
            boolean r1 = r6.Ix()
            com.applovin.impl.sdk.network.i$a r0 = r0.bb(r1)
            java.lang.String r1 = r6.Iy()
            com.applovin.impl.sdk.network.i$a r0 = r0.di(r1)
            com.applovin.impl.sdk.network.i r0 = r0.Ig()
            boolean r1 = com.applovin.impl.sdk.x.Fn()
            if (r1 == 0) goto L_0x0151
            com.applovin.impl.sdk.x r1 = r5.logger
            java.lang.String r2 = "PersistentPostbackManager"
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            java.lang.String r4 = "Submitting postback: "
            r3.<init>(r4)
            r3.append(r6)
            java.lang.String r3 = r3.toString()
            r1.f(r2, r3)
        L_0x0151:
            com.applovin.impl.sdk.n r1 = r5.sdk
            com.applovin.impl.sdk.network.PostbackServiceImpl r1 = r1.Ct()
            com.applovin.impl.sdk.network.f$1 r2 = new com.applovin.impl.sdk.network.f$1
            r2.<init>(r6, r7)
            r1.dispatchPostbackRequest(r0, r2)
            return
        L_0x0160:
            r6 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x0160 }
            throw r6
        L_0x0163:
            r6 = move-exception
            monitor-exit(r1)     // Catch:{ all -> 0x0163 }
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.applovin.impl.sdk.network.f.a(com.applovin.impl.sdk.network.h, com.applovin.sdk.AppLovinPostbackListener):void");
    }

    private void c(h hVar) {
        synchronized (this.aFv) {
            while (this.aIf.size() > this.aId) {
                this.aIf.remove(0);
            }
            this.aIf.add(hVar);
        }
        if (x.Fn()) {
            x xVar = this.logger;
            xVar.f("PersistentPostbackManager", "Enqueued postback: " + hVar);
        }
    }

    /* access modifiers changed from: private */
    public void d(h hVar) {
        synchronized (this.aFv) {
            this.aIg.remove(hVar);
            this.aIf.remove(hVar);
        }
        if (x.Fn()) {
            x xVar = this.logger;
            xVar.f("PersistentPostbackManager", "Dequeued postback: " + hVar);
        }
    }

    /* access modifiers changed from: private */
    public void e(h hVar) {
        synchronized (this.aFv) {
            this.aIg.remove(hVar);
            this.aIh.add(hVar);
        }
    }

    /* access modifiers changed from: private */
    public void Is() {
        synchronized (this.aFv) {
            for (h b : this.aIh) {
                b(b);
            }
            this.aIh.clear();
        }
    }

    public void onReceive(Intent intent, Map<String, Object> map) {
        this.sdk.BO().a((d) this.aIe, q.b.POSTBACKS);
    }

    private void a(Runnable runnable, boolean z, boolean z2) {
        if (z) {
            this.sdk.BO().a((d) new ab(this.sdk, z2, "runPostbackTask", runnable), q.b.POSTBACKS);
            return;
        }
        runnable.run();
    }
}
