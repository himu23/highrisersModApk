package com.fyber.inneractive.sdk.player.cache;

public class g implements Runnable {
    public final /* synthetic */ h a;

    public g(h hVar) {
        this.a = hVar;
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
        	at jadx.core.dex.visitors.regions.RegionMaker.processMonitorEnter(RegionMaker.java:561)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:133)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
        	at jadx.core.dex.visitors.regions.RegionMaker.processExcHandler(RegionMaker.java:1043)
        	at jadx.core.dex.visitors.regions.RegionMaker.processTryCatchBlocks(RegionMaker.java:975)
        	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:52)
        */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x005e  */
    public void run() {
        /*
            r9 = this;
            r0 = 1
            r1 = 0
            com.fyber.inneractive.sdk.player.cache.h r2 = r9.a     // Catch:{ IOException -> 0x0040 }
            com.fyber.inneractive.sdk.player.cache.c$f r3 = r2.c     // Catch:{ IOException -> 0x0040 }
            if (r3 != 0) goto L_0x0016
            com.fyber.inneractive.sdk.player.cache.c r3 = r2.b     // Catch:{ IOException -> 0x0040 }
            java.lang.String r2 = r2.a()     // Catch:{ IOException -> 0x0040 }
            com.fyber.inneractive.sdk.player.cache.c$f r2 = r3.b(r2)     // Catch:{ IOException -> 0x0040 }
            com.fyber.inneractive.sdk.player.cache.h r3 = r9.a     // Catch:{ IOException -> 0x0040 }
            r3.c = r2     // Catch:{ IOException -> 0x0040 }
        L_0x0016:
            com.fyber.inneractive.sdk.player.cache.h r2 = r9.a     // Catch:{ IOException -> 0x0040 }
            com.fyber.inneractive.sdk.player.cache.c$f r3 = r2.c     // Catch:{ IOException -> 0x0040 }
            if (r3 != 0) goto L_0x0064
            com.fyber.inneractive.sdk.player.cache.c r3 = r2.b     // Catch:{ IOException -> 0x0040 }
            java.lang.String r2 = r2.a()     // Catch:{ IOException -> 0x0040 }
            com.fyber.inneractive.sdk.player.cache.c$c r2 = r3.a((java.lang.String) r2)     // Catch:{ IOException -> 0x0040 }
            if (r2 != 0) goto L_0x002a
            r3 = 1
            goto L_0x002b
        L_0x002a:
            r3 = 0
        L_0x002b:
            if (r2 == 0) goto L_0x005c
            r2.a()     // Catch:{ IOException -> 0x003e }
            com.fyber.inneractive.sdk.player.cache.h r2 = r9.a     // Catch:{ IOException -> 0x003e }
            com.fyber.inneractive.sdk.player.cache.c$f r4 = r2.c     // Catch:{ IOException -> 0x003e }
            if (r4 != 0) goto L_0x005c
            com.fyber.inneractive.sdk.player.cache.h$f r2 = r2.h     // Catch:{ IOException -> 0x003e }
            if (r2 == 0) goto L_0x005c
            r2.start()     // Catch:{ IOException -> 0x003e }
            return
        L_0x003e:
            r2 = move-exception
            goto L_0x0042
        L_0x0040:
            r2 = move-exception
            r3 = 0
        L_0x0042:
            r4 = 2
            java.lang.Object[] r4 = new java.lang.Object[r4]
            com.fyber.inneractive.sdk.player.cache.h r5 = r9.a
            java.lang.String r6 = r5.a
            r4[r1] = r6
            java.lang.String r5 = r5.a()
            r4[r0] = r5
            java.lang.String r5 = "%s | Exception raised waiting on availbility for %s"
            java.lang.String r4 = java.lang.String.format(r5, r4)
            java.lang.Object[] r5 = new java.lang.Object[r1]
            com.fyber.inneractive.sdk.util.IAlog.a(r4, r2, r5)
        L_0x005c:
            if (r3 == 0) goto L_0x0064
            com.fyber.inneractive.sdk.player.cache.h r0 = r9.a
            com.fyber.inneractive.sdk.player.cache.h.b(r0, r1)
            goto L_0x00cf
        L_0x0064:
            com.fyber.inneractive.sdk.player.cache.h r2 = r9.a
            boolean unused = r2.getClass()
            com.fyber.inneractive.sdk.player.cache.h r0 = r9.a
            boolean unused = r0.o = r1
            com.fyber.inneractive.sdk.player.cache.h r0 = r9.a
            java.lang.String r3 = r0.a()
            com.fyber.inneractive.sdk.player.cache.h r2 = r9.a
            java.lang.String r4 = r2.e
            com.fyber.inneractive.sdk.player.cache.c r5 = r2.b
            java.lang.String r2 = r2.a()
            java.io.File r5 = r5.a(r2, r1)
            com.fyber.inneractive.sdk.player.cache.h r2 = r9.a
            java.lang.String r7 = r2.l
            com.fyber.inneractive.sdk.player.cache.a r8 = new com.fyber.inneractive.sdk.player.cache.a
            r6 = 0
            r2 = r8
            r2.<init>(r3, r4, r5, r6, r7)
            r0.f = r8
            com.fyber.inneractive.sdk.player.cache.h r0 = r9.a
            com.fyber.inneractive.sdk.player.cache.a r0 = r0.f
            java.lang.Object r0 = r0.d
            monitor-enter(r0)
            com.fyber.inneractive.sdk.player.cache.h r2 = r9.a     // Catch:{ all -> 0x00d0 }
            com.fyber.inneractive.sdk.player.cache.a r2 = r2.f     // Catch:{ all -> 0x00d0 }
            java.io.File r2 = r2.a     // Catch:{ all -> 0x00d0 }
            if (r2 == 0) goto L_0x00c9
            boolean r2 = r2.exists()     // Catch:{ all -> 0x00d0 }
            if (r2 == 0) goto L_0x00c9
            com.fyber.inneractive.sdk.player.cache.h r1 = r9.a     // Catch:{ all -> 0x00d0 }
            com.fyber.inneractive.sdk.player.cache.b r2 = r1.d     // Catch:{ all -> 0x00d0 }
            com.fyber.inneractive.sdk.player.cache.a r3 = r1.f     // Catch:{ all -> 0x00d0 }
            java.lang.String r1 = r1.l     // Catch:{ all -> 0x00d0 }
            r2.a(r3, r1)     // Catch:{ all -> 0x00d0 }
            com.fyber.inneractive.sdk.player.cache.h r1 = r9.a     // Catch:{ all -> 0x00d0 }
            com.fyber.inneractive.sdk.player.cache.a r2 = r1.f     // Catch:{ all -> 0x00d0 }
            com.fyber.inneractive.sdk.player.cache.b r1 = r1.d     // Catch:{ all -> 0x00d0 }
            java.util.Map<java.lang.String, java.lang.String> r1 = r1.a     // Catch:{ all -> 0x00d0 }
            java.util.Map<java.lang.String, java.lang.String> r2 = r2.e     // Catch:{ all -> 0x00d0 }
            r2.putAll(r1)     // Catch:{ all -> 0x00d0 }
            com.fyber.inneractive.sdk.player.cache.h r1 = r9.a     // Catch:{ all -> 0x00d0 }
            com.fyber.inneractive.sdk.player.cache.a r2 = r1.f     // Catch:{ all -> 0x00d0 }
            r1.a((com.fyber.inneractive.sdk.player.cache.a) r2)     // Catch:{ all -> 0x00d0 }
            com.fyber.inneractive.sdk.player.cache.h r1 = r9.a     // Catch:{ all -> 0x00d0 }
            r1.b()     // Catch:{ all -> 0x00d0 }
            goto L_0x00ce
        L_0x00c9:
            com.fyber.inneractive.sdk.player.cache.h r2 = r9.a     // Catch:{ all -> 0x00d0 }
            com.fyber.inneractive.sdk.player.cache.h.b(r2, r1)     // Catch:{ all -> 0x00d0 }
        L_0x00ce:
            monitor-exit(r0)     // Catch:{ all -> 0x00d0 }
        L_0x00cf:
            return
        L_0x00d0:
            r1 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x00d0 }
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fyber.inneractive.sdk.player.cache.g.run():void");
    }
}
