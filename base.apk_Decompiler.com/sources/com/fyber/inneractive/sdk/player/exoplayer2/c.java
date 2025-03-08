package com.fyber.inneractive.sdk.player.exoplayer2;

import com.fyber.inneractive.sdk.player.exoplayer2.upstream.b;
import com.fyber.inneractive.sdk.player.exoplayer2.upstream.k;
import com.fyber.inneractive.sdk.player.exoplayer2.util.n;

public final class c {
    public final k a;
    public final long b;
    public final long c;
    public final long d;
    public final long e;
    public int f;
    public boolean g;

    public c(k kVar, int i, int i2, long j, long j2) {
        this(kVar, i, i2, j, j2, (n) null);
    }

    public b a() {
        return this.a;
    }

    public c(k kVar, int i, int i2, long j, long j2, n nVar) {
        this.a = kVar;
        this.b = ((long) i) * 1000;
        this.c = ((long) i2) * 1000;
        this.d = j * 1000;
        this.e = j2 * 1000;
    }

    public boolean a(long j) {
        int i;
        boolean z = false;
        char c2 = j > this.c ? 0 : j < this.b ? (char) 2 : 1;
        k kVar = this.a;
        synchronized (kVar) {
            i = kVar.f * kVar.b;
        }
        boolean z2 = i >= this.f;
        boolean z3 = this.g;
        if (c2 == 2 || (c2 == 1 && z3 && !z2)) {
            z = true;
        }
        this.g = z;
        return z;
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
        	at jadx.core.dex.visitors.regions.RegionMaker.processIf(RegionMaker.java:693)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:123)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
        	at jadx.core.dex.visitors.regions.RegionMaker.processMonitorEnter(RegionMaker.java:598)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:133)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
        	at jadx.core.dex.visitors.regions.RegionMaker.processIf(RegionMaker.java:693)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:123)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
        	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:49)
        */
    public final void a(boolean r3) {
        /*
            r2 = this;
            r0 = 0
            r2.f = r0
            r2.g = r0
            if (r3 == 0) goto L_0x0027
            com.fyber.inneractive.sdk.player.exoplayer2.upstream.k r3 = r2.a
            monitor-enter(r3)
            boolean r1 = r3.a     // Catch:{ all -> 0x0024 }
            if (r1 == 0) goto L_0x0022
            monitor-enter(r3)     // Catch:{ all -> 0x0024 }
            int r1 = r3.e     // Catch:{ all -> 0x001f }
            if (r1 <= 0) goto L_0x0015
            r1 = 1
            goto L_0x0016
        L_0x0015:
            r1 = 0
        L_0x0016:
            r3.e = r0     // Catch:{ all -> 0x001f }
            if (r1 == 0) goto L_0x001d
            r3.b()     // Catch:{ all -> 0x001f }
        L_0x001d:
            monitor-exit(r3)     // Catch:{ all -> 0x0024 }
            goto L_0x0022
        L_0x001f:
            r0 = move-exception
            monitor-exit(r3)     // Catch:{ all -> 0x0024 }
            throw r0     // Catch:{ all -> 0x0024 }
        L_0x0022:
            monitor-exit(r3)
            goto L_0x0027
        L_0x0024:
            r0 = move-exception
            monitor-exit(r3)
            throw r0
        L_0x0027:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fyber.inneractive.sdk.player.exoplayer2.c.a(boolean):void");
    }
}
