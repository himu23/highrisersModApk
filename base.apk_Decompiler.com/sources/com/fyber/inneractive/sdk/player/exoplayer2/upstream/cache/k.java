package com.fyber.inneractive.sdk.player.exoplayer2.upstream.cache;

import android.os.ConditionVariable;
import com.fyber.inneractive.sdk.player.exoplayer2.upstream.cache.a;
import com.fyber.inneractive.sdk.player.exoplayer2.util.b;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;

public final class k implements a {
    public final File a;
    public final f b;
    public final HashMap<String, g> c;
    public final i d;
    public final HashMap<String, ArrayList<a.b>> e;
    public long f = 0;
    public a.C0128a g;

    public class a extends Thread {
        public final /* synthetic */ ConditionVariable a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(String str, ConditionVariable conditionVariable) {
            super(str);
            this.a = conditionVariable;
        }

        public void run() {
            synchronized (k.this) {
                this.a.open();
                try {
                    k.a(k.this);
                } catch (a.C0128a e) {
                    k.this.g = e;
                }
                k.this.b.getClass();
            }
        }
    }

    public k(File file, f fVar, byte[] bArr) {
        this.a = file;
        this.b = fVar;
        this.c = new HashMap<>();
        this.d = new i(file, (byte[]) null);
        this.e = new HashMap<>();
        ConditionVariable conditionVariable = new ConditionVariable();
        new a("SimpleCache.initialize()", conditionVariable).start();
        conditionVariable.block();
    }

    public synchronized long a() {
        return this.f;
    }

    public g b(String str, long j) throws InterruptedException, a.C0128a {
        l d2;
        synchronized (this) {
            while (true) {
                d2 = c(str, j);
                if (d2 == null) {
                    wait();
                }
            }
        }
        return d2;
    }

    public synchronized File a(String str, long j, long j2) throws a.C0128a {
        File file;
        h hVar;
        com.fyber.inneractive.sdk.player.exoplayer2.util.a.b(this.c.containsKey(str));
        if (!this.a.exists()) {
            b();
            this.a.mkdirs();
        }
        ((j) this.b).a((a) this, j2);
        file = this.a;
        i iVar = this.d;
        hVar = iVar.a.get(str);
        if (hVar == null) {
            hVar = iVar.a(str, -1);
        }
        return l.a(file, hVar.a, j, System.currentTimeMillis());
    }

    /* renamed from: d */
    public synchronized l c(String str, long j) throws a.C0128a {
        l lVar;
        l floor;
        a.C0128a aVar = this.g;
        if (aVar == null) {
            h hVar = this.d.a.get(str);
            if (hVar == null) {
                lVar = new l(str, j, -1, -9223372036854775807L, (File) null);
            } else {
                while (true) {
                    l lVar2 = new l(hVar.b, j, -1, -9223372036854775807L, (File) null);
                    floor = hVar.c.floor(lVar2);
                    if (floor == null || floor.b + floor.c <= j) {
                        l ceiling = hVar.c.ceiling(lVar2);
                        if (ceiling == null) {
                            floor = new l(hVar.b, j, -1, -9223372036854775807L, (File) null);
                        } else {
                            floor = new l(hVar.b, j, ceiling.b - j, -9223372036854775807L, (File) null);
                        }
                    }
                    if (!floor.d || floor.e.length() == floor.c) {
                        lVar = floor;
                    } else {
                        b();
                    }
                }
                lVar = floor;
            }
            if (lVar.d) {
                h hVar2 = this.d.a.get(str);
                com.fyber.inneractive.sdk.player.exoplayer2.util.a.b(hVar2.c.remove(lVar));
                int i = hVar2.a;
                com.fyber.inneractive.sdk.player.exoplayer2.util.a.b(lVar.d);
                long currentTimeMillis = System.currentTimeMillis();
                File a2 = l.a(lVar.e.getParentFile(), i, lVar.b, currentTimeMillis);
                l lVar3 = new l(lVar.a, lVar.b, lVar.c, currentTimeMillis, a2);
                if (lVar.e.renameTo(a2)) {
                    hVar2.c.add(lVar3);
                    ArrayList arrayList = this.e.get(lVar.a);
                    if (arrayList != null) {
                        for (int size = arrayList.size() - 1; size >= 0; size--) {
                            ((a.b) arrayList.get(size)).a(this, lVar, lVar3);
                        }
                    }
                    j jVar = (j) this.b;
                    jVar.a.remove(lVar);
                    jVar.b -= lVar.c;
                    jVar.b(this, lVar3);
                    return lVar3;
                }
                throw new a.C0128a("Renaming of " + lVar.e + " to " + a2 + " failed.");
            } else if (this.c.containsKey(str)) {
                return null;
            } else {
                this.c.put(str, lVar);
                return lVar;
            }
        } else {
            throw aVar;
        }
    }

    public synchronized void b(g gVar) {
        com.fyber.inneractive.sdk.player.exoplayer2.util.a.b(gVar == this.c.remove(gVar.a));
        notifyAll();
    }

    public final void b() throws a.C0128a {
        LinkedList linkedList = new LinkedList();
        for (h hVar : this.d.a.values()) {
            Iterator<l> it = hVar.c.iterator();
            while (it.hasNext()) {
                g next = it.next();
                if (next.e.length() != next.c) {
                    linkedList.add(next);
                }
            }
        }
        Iterator it2 = linkedList.iterator();
        while (it2.hasNext()) {
            a((g) it2.next(), false);
        }
        this.d.b();
        this.d.c();
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
        	at jadx.core.dex.visitors.regions.RegionMaker.processMonitorEnter(RegionMaker.java:561)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:133)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
        	at jadx.core.dex.visitors.regions.RegionMaker.processIf(RegionMaker.java:698)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:123)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
        	at jadx.core.dex.visitors.regions.RegionMaker.processIf(RegionMaker.java:698)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:123)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
        	at jadx.core.dex.visitors.regions.RegionMaker.processMonitorEnter(RegionMaker.java:598)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:133)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
        	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:49)
        */
    public synchronized void a(java.io.File r9) throws com.fyber.inneractive.sdk.player.exoplayer2.upstream.cache.a.C0128a {
        /*
            r8 = this;
            monitor-enter(r8)
            com.fyber.inneractive.sdk.player.exoplayer2.upstream.cache.i r0 = r8.d     // Catch:{ all -> 0x0077 }
            com.fyber.inneractive.sdk.player.exoplayer2.upstream.cache.l r0 = com.fyber.inneractive.sdk.player.exoplayer2.upstream.cache.l.a(r9, r0)     // Catch:{ all -> 0x0077 }
            r1 = 1
            r2 = 0
            if (r0 == 0) goto L_0x000d
            r3 = 1
            goto L_0x000e
        L_0x000d:
            r3 = 0
        L_0x000e:
            com.fyber.inneractive.sdk.player.exoplayer2.util.a.b(r3)     // Catch:{ all -> 0x0077 }
            java.util.HashMap<java.lang.String, com.fyber.inneractive.sdk.player.exoplayer2.upstream.cache.g> r3 = r8.c     // Catch:{ all -> 0x0077 }
            java.lang.String r4 = r0.a     // Catch:{ all -> 0x0077 }
            boolean r3 = r3.containsKey(r4)     // Catch:{ all -> 0x0077 }
            com.fyber.inneractive.sdk.player.exoplayer2.util.a.b(r3)     // Catch:{ all -> 0x0077 }
            boolean r3 = r9.exists()     // Catch:{ all -> 0x0077 }
            if (r3 != 0) goto L_0x0024
            monitor-exit(r8)
            return
        L_0x0024:
            long r3 = r9.length()     // Catch:{ all -> 0x0077 }
            r5 = 0
            int r7 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r7 != 0) goto L_0x0033
            r9.delete()     // Catch:{ all -> 0x0077 }
            monitor-exit(r8)
            return
        L_0x0033:
            java.lang.String r9 = r0.a     // Catch:{ all -> 0x0077 }
            monitor-enter(r8)     // Catch:{ all -> 0x0077 }
            com.fyber.inneractive.sdk.player.exoplayer2.upstream.cache.i r3 = r8.d     // Catch:{ all -> 0x0074 }
            java.util.HashMap<java.lang.String, com.fyber.inneractive.sdk.player.exoplayer2.upstream.cache.h> r3 = r3.a     // Catch:{ all -> 0x0074 }
            java.lang.Object r9 = r3.get(r9)     // Catch:{ all -> 0x0074 }
            com.fyber.inneractive.sdk.player.exoplayer2.upstream.cache.h r9 = (com.fyber.inneractive.sdk.player.exoplayer2.upstream.cache.h) r9     // Catch:{ all -> 0x0074 }
            r3 = -1
            if (r9 != 0) goto L_0x0046
            r5 = r3
            goto L_0x0048
        L_0x0046:
            long r5 = r9.d     // Catch:{ all -> 0x0074 }
        L_0x0048:
            monitor-exit(r8)     // Catch:{ all -> 0x0077 }
            java.lang.Long r9 = java.lang.Long.valueOf(r5)     // Catch:{ all -> 0x0077 }
            long r5 = r9.longValue()     // Catch:{ all -> 0x0077 }
            int r7 = (r5 > r3 ? 1 : (r5 == r3 ? 0 : -1))
            if (r7 == 0) goto L_0x0067
            long r3 = r0.b     // Catch:{ all -> 0x0077 }
            long r5 = r0.c     // Catch:{ all -> 0x0077 }
            long r3 = r3 + r5
            long r5 = r9.longValue()     // Catch:{ all -> 0x0077 }
            int r9 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r9 > 0) goto L_0x0063
            goto L_0x0064
        L_0x0063:
            r1 = 0
        L_0x0064:
            com.fyber.inneractive.sdk.player.exoplayer2.util.a.b(r1)     // Catch:{ all -> 0x0077 }
        L_0x0067:
            r8.a((com.fyber.inneractive.sdk.player.exoplayer2.upstream.cache.l) r0)     // Catch:{ all -> 0x0077 }
            com.fyber.inneractive.sdk.player.exoplayer2.upstream.cache.i r9 = r8.d     // Catch:{ all -> 0x0077 }
            r9.c()     // Catch:{ all -> 0x0077 }
            r8.notifyAll()     // Catch:{ all -> 0x0077 }
            monitor-exit(r8)
            return
        L_0x0074:
            r9 = move-exception
            monitor-exit(r8)     // Catch:{ all -> 0x0077 }
            throw r9     // Catch:{ all -> 0x0077 }
        L_0x0077:
            r9 = move-exception
            monitor-exit(r8)
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fyber.inneractive.sdk.player.exoplayer2.upstream.cache.k.a(java.io.File):void");
    }

    public static void a(k kVar) throws a.C0128a {
        if (!kVar.a.exists()) {
            kVar.a.mkdirs();
            return;
        }
        i iVar = kVar.d;
        com.fyber.inneractive.sdk.player.exoplayer2.util.a.b(!iVar.f);
        if (!iVar.a()) {
            b bVar = iVar.c;
            bVar.a.delete();
            bVar.b.delete();
            iVar.a.clear();
            iVar.b.clear();
        }
        File[] listFiles = kVar.a.listFiles();
        if (listFiles != null) {
            for (File file : listFiles) {
                if (!file.getName().equals("cached_content_index.exi")) {
                    l a2 = file.length() > 0 ? l.a(file, kVar.d) : null;
                    if (a2 != null) {
                        kVar.a(a2);
                    } else {
                        file.delete();
                    }
                }
            }
            kVar.d.b();
            kVar.d.c();
        }
    }

    public final void a(l lVar) {
        i iVar = this.d;
        String str = lVar.a;
        h hVar = iVar.a.get(str);
        if (hVar == null) {
            hVar = iVar.a(str, -1);
        }
        hVar.c.add(lVar);
        this.f += lVar.c;
        ArrayList arrayList = this.e.get(lVar.a);
        if (arrayList != null) {
            for (int size = arrayList.size() - 1; size >= 0; size--) {
                ((a.b) arrayList.get(size)).b(this, lVar);
            }
        }
        ((j) this.b).b(this, lVar);
    }

    public final void a(g gVar, boolean z) throws a.C0128a {
        h a2 = this.d.a(gVar.a);
        if (a2 != null && a2.c.remove(gVar)) {
            gVar.e.delete();
            this.f -= gVar.c;
            if (z && a2.c.isEmpty()) {
                this.d.b(a2.b);
                this.d.c();
            }
            ArrayList arrayList = this.e.get(gVar.a);
            if (arrayList != null) {
                for (int size = arrayList.size() - 1; size >= 0; size--) {
                    ((a.b) arrayList.get(size)).a(this, gVar);
                }
            }
            j jVar = (j) this.b;
            jVar.a.remove(gVar);
            jVar.b -= gVar.c;
        }
    }

    public synchronized void a(g gVar) throws a.C0128a {
        a(gVar, true);
    }

    public synchronized void a(String str, long j) throws a.C0128a {
        i iVar = this.d;
        h hVar = iVar.a.get(str);
        if (hVar == null) {
            iVar.a(str, j);
        } else if (hVar.d != j) {
            hVar.d = j;
            iVar.f = true;
        }
        this.d.c();
    }

    public synchronized long a(String str) {
        long j;
        h hVar = this.d.a.get(str);
        if (hVar == null) {
            j = -1;
        } else {
            j = hVar.d;
        }
        return j;
    }
}
