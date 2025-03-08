package com.fyber.inneractive.sdk.player.cache;

public final class j extends b {
    public final boolean b;

    public j(boolean z) {
        this.b = z;
    }

    /* JADX WARNING: Removed duplicated region for block: B:22:0x007b A[Catch:{ all -> 0x0081 }] */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x00a9 A[Catch:{ all -> 0x00c1 }] */
    /* JADX WARNING: Removed duplicated region for block: B:52:0x00cc A[ADDED_TO_REGION] */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x00c1 A[EDGE_INSN: B:57:0x00c1->B:44:0x00c1 ?: BREAK  , SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:61:? A[ADDED_TO_REGION, RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.fyber.inneractive.sdk.player.cache.b.a a(com.fyber.inneractive.sdk.player.cache.a r7, java.lang.String r8) {
        /*
            r6 = this;
            com.fyber.inneractive.sdk.player.cache.b$a r8 = com.fyber.inneractive.sdk.player.cache.b.a.INVALID
            android.media.MediaPlayer r0 = new android.media.MediaPlayer
            r0.<init>()
            java.io.File r1 = r7.a
            r2 = 0
            if (r1 == 0) goto L_0x0086
            boolean r1 = r1.exists()
            if (r1 == 0) goto L_0x0086
            java.io.FileInputStream r1 = new java.io.FileInputStream     // Catch:{ all -> 0x006d }
            java.io.File r3 = r7.a()     // Catch:{ all -> 0x006d }
            r1.<init>(r3)     // Catch:{ all -> 0x006d }
            java.io.File r3 = r7.a()     // Catch:{ all -> 0x006b }
            java.lang.String r3 = r3.getAbsolutePath()     // Catch:{ all -> 0x006b }
            r0.setDataSource(r3)     // Catch:{ all -> 0x006b }
            r0.prepare()     // Catch:{ all -> 0x006b }
            int r3 = r0.getDuration()     // Catch:{ all -> 0x006b }
            if (r3 <= 0) goto L_0x007d
            com.fyber.inneractive.sdk.player.cache.b$a r8 = com.fyber.inneractive.sdk.player.cache.b.a.OK     // Catch:{ all -> 0x006b }
            int r3 = r0.getVideoWidth()     // Catch:{ all -> 0x006b }
            if (r3 <= 0) goto L_0x005b
            int r3 = r0.getVideoHeight()     // Catch:{ all -> 0x006b }
            if (r3 <= 0) goto L_0x005b
            java.lang.String r3 = "video.width"
            int r4 = r0.getVideoWidth()     // Catch:{ all -> 0x006b }
            java.lang.String r4 = java.lang.String.valueOf(r4)     // Catch:{ all -> 0x006b }
            java.util.Map<java.lang.String, java.lang.String> r5 = r6.a     // Catch:{ all -> 0x006b }
            r5.put(r3, r4)     // Catch:{ all -> 0x006b }
            java.lang.String r3 = "video.height"
            int r4 = r0.getVideoHeight()     // Catch:{ all -> 0x006b }
            java.lang.String r4 = java.lang.String.valueOf(r4)     // Catch:{ all -> 0x006b }
            java.util.Map<java.lang.String, java.lang.String> r5 = r6.a     // Catch:{ all -> 0x006b }
            r5.put(r3, r4)     // Catch:{ all -> 0x006b }
        L_0x005b:
            java.lang.String r3 = "video.duration"
            int r4 = r0.getDuration()     // Catch:{ all -> 0x006b }
            java.lang.String r4 = java.lang.String.valueOf(r4)     // Catch:{ all -> 0x006b }
            java.util.Map<java.lang.String, java.lang.String> r5 = r6.a     // Catch:{ all -> 0x006b }
            r5.put(r3, r4)     // Catch:{ all -> 0x006b }
            goto L_0x007d
        L_0x006b:
            r3 = move-exception
            goto L_0x0070
        L_0x006d:
            r1 = move-exception
            r3 = r1
            r1 = 0
        L_0x0070:
            java.lang.String r4 = "Exception raised while trying to open a cache candidate"
            java.lang.Object[] r5 = new java.lang.Object[r2]     // Catch:{ all -> 0x0081 }
            com.fyber.inneractive.sdk.util.IAlog.a(r4, r3, r5)     // Catch:{ all -> 0x0081 }
            boolean r3 = r7.c     // Catch:{ all -> 0x0081 }
            if (r3 == 0) goto L_0x007d
            com.fyber.inneractive.sdk.player.cache.b$a r8 = com.fyber.inneractive.sdk.player.cache.b.a.PARTIAL_CANNOT_VALIDATE     // Catch:{ all -> 0x0081 }
        L_0x007d:
            com.fyber.inneractive.sdk.player.cache.m.a((java.io.Closeable) r1)
            goto L_0x0086
        L_0x0081:
            r7 = move-exception
            com.fyber.inneractive.sdk.player.cache.m.a((java.io.Closeable) r1)
            throw r7
        L_0x0086:
            r0.release()     // Catch:{ all -> 0x0089 }
        L_0x0089:
            boolean r0 = r6.b
            r1 = 1
            r0 = r0 ^ r1
            if (r0 != 0) goto L_0x00c8
            com.fyber.inneractive.sdk.player.cache.b$a r3 = com.fyber.inneractive.sdk.player.cache.b.a.OK
            if (r8 != r3) goto L_0x00c8
            android.media.MediaExtractor r3 = new android.media.MediaExtractor
            r3.<init>()
            java.io.File r4 = r7.a()     // Catch:{ all -> 0x00c1 }
            java.lang.String r4 = r4.getAbsolutePath()     // Catch:{ all -> 0x00c1 }
            r3.setDataSource(r4)     // Catch:{ all -> 0x00c1 }
        L_0x00a3:
            int r4 = r3.getTrackCount()     // Catch:{ all -> 0x00c1 }
            if (r2 >= r4) goto L_0x00c1
            android.media.MediaFormat r4 = r3.getTrackFormat(r2)     // Catch:{ all -> 0x00c1 }
            java.lang.String r5 = "mime"
            java.lang.String r4 = r4.getString(r5)     // Catch:{ all -> 0x00c1 }
            if (r4 == 0) goto L_0x00be
            java.lang.String r5 = "video/"
            boolean r4 = r4.startsWith(r5)     // Catch:{ all -> 0x00c1 }
            if (r4 == 0) goto L_0x00be
            goto L_0x00c2
        L_0x00be:
            int r2 = r2 + 1
            goto L_0x00a3
        L_0x00c1:
            r1 = r0
        L_0x00c2:
            r3.release()     // Catch:{ all -> 0x00c6 }
            goto L_0x00c7
        L_0x00c6:
        L_0x00c7:
            r0 = r1
        L_0x00c8:
            com.fyber.inneractive.sdk.player.cache.b$a r1 = com.fyber.inneractive.sdk.player.cache.b.a.OK
            if (r8 != r1) goto L_0x00d7
            if (r0 != 0) goto L_0x00d7
            boolean r7 = r7.c
            if (r7 == 0) goto L_0x00d5
            com.fyber.inneractive.sdk.player.cache.b$a r8 = com.fyber.inneractive.sdk.player.cache.b.a.PARTIAL_CANNOT_VALIDATE
            goto L_0x00d7
        L_0x00d5:
            com.fyber.inneractive.sdk.player.cache.b$a r8 = com.fyber.inneractive.sdk.player.cache.b.a.INVALID
        L_0x00d7:
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fyber.inneractive.sdk.player.cache.j.a(com.fyber.inneractive.sdk.player.cache.a, java.lang.String):com.fyber.inneractive.sdk.player.cache.b$a");
    }
}
