package com.fyber.inneractive.sdk.player.cache;

import android.content.Context;
import android.text.TextUtils;
import com.fyber.inneractive.sdk.player.cache.c;
import com.fyber.inneractive.sdk.util.p;
import com.fyber.inneractive.sdk.util.t;
import java.io.File;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class n implements c.e {
    public static final n f = new n();
    public Context a;
    public c b;
    public boolean c = false;
    public final List<String> d = new CopyOnWriteArrayList();
    public final Runnable e = new a();

    public class a implements Runnable {
        public a() {
        }

        /* JADX WARNING: Code restructure failed: missing block: B:14:0x006a, code lost:
            r0 = move-exception;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:15:0x006b, code lost:
            com.fyber.inneractive.sdk.network.t.a("Failed to open cache directory", r0.getMessage(), (com.fyber.inneractive.sdk.external.InneractiveAdRequest) null, (com.fyber.inneractive.sdk.response.e) null);
            com.fyber.inneractive.sdk.util.IAlog.a("Failed to open cache directory", r0, new java.lang.Object[0]);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:16:?, code lost:
            return;
         */
        /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void run() {
            /*
                r8 = this;
                com.fyber.inneractive.sdk.player.cache.n r0 = com.fyber.inneractive.sdk.player.cache.n.this
                android.content.Context r0 = r0.a
                java.lang.String r1 = "fyb.vamp.vid.cache"
                java.io.File r0 = com.fyber.inneractive.sdk.player.cache.n.a((android.content.Context) r0, (java.lang.String) r1)
                if (r0 == 0) goto L_0x007c
                r1 = 0
                java.lang.String r2 = "VideoCache opening the cache in directory - %s"
                r3 = 1
                java.lang.Object[] r4 = new java.lang.Object[r3]     // Catch:{ all -> 0x006a }
                r4[r1] = r0     // Catch:{ all -> 0x006a }
                com.fyber.inneractive.sdk.util.IAlog.a(r2, r4)     // Catch:{ all -> 0x006a }
                com.fyber.inneractive.sdk.player.cache.n r2 = com.fyber.inneractive.sdk.player.cache.n.this     // Catch:{ all -> 0x006a }
                r4 = 52428800(0x3200000, double:2.5903269E-316)
                com.fyber.inneractive.sdk.player.cache.c r6 = com.fyber.inneractive.sdk.player.cache.c.a(r0, r1, r3, r4)     // Catch:{ all -> 0x006a }
                r2.b = r6     // Catch:{ all -> 0x006a }
                com.fyber.inneractive.sdk.player.cache.n r2 = com.fyber.inneractive.sdk.player.cache.n.this     // Catch:{ all -> 0x006a }
                com.fyber.inneractive.sdk.player.cache.c r2 = r2.b     // Catch:{ all -> 0x006a }
                r2.getClass()     // Catch:{ all -> 0x006a }
                java.lang.Object[] r6 = new java.lang.Object[r1]     // Catch:{ all -> 0x006a }
                java.lang.String r7 = "DiskLruCache delete cache"
                com.fyber.inneractive.sdk.util.IAlog.d(r7, r6)     // Catch:{ all -> 0x006a }
                r2.close()     // Catch:{ all -> 0x006a }
                java.io.File r2 = r2.a     // Catch:{ all -> 0x006a }
                com.fyber.inneractive.sdk.player.cache.m.a((java.io.File) r2)     // Catch:{ all -> 0x006a }
                com.fyber.inneractive.sdk.player.cache.n r2 = com.fyber.inneractive.sdk.player.cache.n.this     // Catch:{ all -> 0x006a }
                com.fyber.inneractive.sdk.player.cache.c r4 = com.fyber.inneractive.sdk.player.cache.c.a(r0, r1, r3, r4)     // Catch:{ all -> 0x006a }
                r2.b = r4     // Catch:{ all -> 0x006a }
                java.lang.String r2 = "VideoCache opened the cache in directory - %s current size is %d"
                r4 = 2
                java.lang.Object[] r4 = new java.lang.Object[r4]     // Catch:{ all -> 0x006a }
                r4[r1] = r0     // Catch:{ all -> 0x006a }
                com.fyber.inneractive.sdk.player.cache.n r0 = com.fyber.inneractive.sdk.player.cache.n.this     // Catch:{ all -> 0x006a }
                com.fyber.inneractive.sdk.player.cache.c r0 = r0.b     // Catch:{ all -> 0x006a }
                monitor-enter(r0)     // Catch:{ all -> 0x006a }
                long r5 = r0.h     // Catch:{ all -> 0x0067 }
                monitor-exit(r0)     // Catch:{ all -> 0x006a }
                java.lang.Long r0 = java.lang.Long.valueOf(r5)     // Catch:{ all -> 0x006a }
                r4[r3] = r0     // Catch:{ all -> 0x006a }
                com.fyber.inneractive.sdk.util.IAlog.a(r2, r4)     // Catch:{ all -> 0x006a }
                com.fyber.inneractive.sdk.player.cache.n r0 = com.fyber.inneractive.sdk.player.cache.n.this     // Catch:{ all -> 0x006a }
                com.fyber.inneractive.sdk.player.cache.c r2 = r0.b     // Catch:{ all -> 0x006a }
                r2.l = r0     // Catch:{ all -> 0x006a }
                boolean unused = r0.c = r3     // Catch:{ all -> 0x006a }
                com.fyber.inneractive.sdk.player.cache.n r0 = com.fyber.inneractive.sdk.player.cache.n.this     // Catch:{ all -> 0x006a }
                r0.getClass()     // Catch:{ all -> 0x006a }
                goto L_0x007c
            L_0x0067:
                r2 = move-exception
                monitor-exit(r0)     // Catch:{ all -> 0x006a }
                throw r2     // Catch:{ all -> 0x006a }
            L_0x006a:
                r0 = move-exception
                java.lang.String r2 = r0.getMessage()
                java.lang.String r3 = "Failed to open cache directory"
                r4 = 0
                com.fyber.inneractive.sdk.network.t.a(r3, r2, r4, r4)
                java.lang.Object[] r1 = new java.lang.Object[r1]
                java.lang.String r2 = "Failed to open cache directory"
                com.fyber.inneractive.sdk.util.IAlog.a(r2, r0, r1)
            L_0x007c:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.fyber.inneractive.sdk.player.cache.n.a.run():void");
        }
    }

    public static File a(Context context, String str) {
        File externalCacheDir;
        if (context == null || TextUtils.isEmpty(str)) {
            return null;
        }
        if (p.a != null && p.b("android.permission.WRITE_EXTERNAL_STORAGE") && "mounted".equals(p.c())) {
            String c2 = p.c();
            if (("mounted".equals(c2) || "mounted_ro".equals(c2)) && (externalCacheDir = context.getExternalCacheDir()) != null && externalCacheDir.getFreeSpace() > 52428800) {
                return new File(context.getExternalCacheDir(), str);
            }
        }
        File cacheDir = context.getCacheDir();
        if (cacheDir == null || cacheDir.getFreeSpace() <= 52428800) {
            return null;
        }
        return new File(context.getCacheDir(), str);
    }

    public boolean a() {
        return this.c && t.a();
    }

    public boolean a(c cVar, String str) {
        for (String equalsIgnoreCase : this.d) {
            if (equalsIgnoreCase.equalsIgnoreCase(str)) {
                return false;
            }
        }
        return true;
    }
}
