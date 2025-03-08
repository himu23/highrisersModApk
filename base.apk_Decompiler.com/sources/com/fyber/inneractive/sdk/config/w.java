package com.fyber.inneractive.sdk.config;

public class w {
    /*  JADX ERROR: IndexOutOfBoundsException in pass: RegionMakerVisitor
        java.lang.IndexOutOfBoundsException: Index: 0, Size: 0
        	at java.util.ArrayList.rangeCheck(ArrayList.java:659)
        	at java.util.ArrayList.get(ArrayList.java:435)
        	at jadx.core.dex.nodes.InsnNode.getArg(InsnNode.java:101)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:611)
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
    public static void a(android.content.Context r5, com.fyber.inneractive.sdk.config.v r6) {
        /*
            r0 = 0
            r1 = 0
            com.google.android.gms.ads.identifier.AdvertisingIdClient$Info r5 = com.google.android.gms.ads.identifier.AdvertisingIdClient.getAdvertisingIdInfo(r5)     // Catch:{ Exception -> 0x0028 }
            java.lang.String r0 = r5.getId()     // Catch:{ Exception -> 0x0028 }
            java.lang.String r2 = "advertising id: %s"
            r3 = 1
            java.lang.Object[] r4 = new java.lang.Object[r3]     // Catch:{ Exception -> 0x0028 }
            r4[r1] = r0     // Catch:{ Exception -> 0x0028 }
            com.fyber.inneractive.sdk.util.IAlog.d(r2, r4)     // Catch:{ Exception -> 0x0028 }
            boolean r5 = r5.isLimitAdTrackingEnabled()     // Catch:{ Exception -> 0x0028 }
            java.lang.String r2 = "limit ad tracking: %s"
            java.lang.Object[] r3 = new java.lang.Object[r3]     // Catch:{ Exception -> 0x0026 }
            java.lang.Boolean r4 = java.lang.Boolean.valueOf(r5)     // Catch:{ Exception -> 0x0026 }
            r3[r1] = r4     // Catch:{ Exception -> 0x0026 }
            com.fyber.inneractive.sdk.util.IAlog.d(r2, r3)     // Catch:{ Exception -> 0x0026 }
            goto L_0x0041
        L_0x0026:
            r2 = move-exception
            goto L_0x002a
        L_0x0028:
            r2 = move-exception
            r5 = 0
        L_0x002a:
            java.lang.Object[] r3 = new java.lang.Object[r1]
            java.lang.String r4 = "Handled Exception:"
            com.fyber.inneractive.sdk.util.IAlog.d(r4, r3)
            java.lang.String r2 = com.fyber.inneractive.sdk.util.u.b((java.lang.Throwable) r2)
            java.lang.Object[] r3 = new java.lang.Object[r1]
            com.fyber.inneractive.sdk.util.IAlog.d(r2, r3)
            java.lang.Object[] r2 = new java.lang.Object[r1]
            java.lang.String r3 = "Advertising ID is not available. Please add Google Play Services library (v 4.0+) to improve your ad targeting. (relevant for devices running Android API 2.3 and above)"
            com.fyber.inneractive.sdk.util.IAlog.c(r3, r2)
        L_0x0041:
            com.fyber.inneractive.sdk.config.l r6 = (com.fyber.inneractive.sdk.config.l) r6
            monitor-enter(r6)
            com.fyber.inneractive.sdk.config.l$c r2 = r6.b     // Catch:{ all -> 0x004e }
            r2.a = r0     // Catch:{ all -> 0x004e }
            r2.b = r5     // Catch:{ all -> 0x004e }
            r2.c = r1     // Catch:{ all -> 0x004e }
            monitor-exit(r6)
            return
        L_0x004e:
            r5 = move-exception
            monitor-exit(r6)
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fyber.inneractive.sdk.config.w.a(android.content.Context, com.fyber.inneractive.sdk.config.v):void");
    }
}
