package com.ironsource;

import android.os.Handler;
import android.os.HandlerThread;
import com.ironsource.mediationsdk.logger.d;

public class pb extends Thread {
    private static pb b;
    private a a;

    private class a extends HandlerThread {
        private Handler a;

        a(String str) {
            super(str);
            setUncaughtExceptionHandler(new d());
        }

        /* access modifiers changed from: package-private */
        public Handler a() {
            return this.a;
        }

        /* access modifiers changed from: package-private */
        public void b() {
            this.a = new Handler(getLooper());
        }
    }

    private pb() {
        a aVar = new a(getClass().getSimpleName());
        this.a = aVar;
        aVar.start();
        this.a.b();
    }

    public static synchronized pb a() {
        pb pbVar;
        synchronized (pb.class) {
            if (b == null) {
                b = new pb();
            }
            pbVar = b;
        }
        return pbVar;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0011, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized void a(java.lang.Runnable r2) {
        /*
            r1 = this;
            monitor-enter(r1)
            com.ironsource.pb$a r0 = r1.a     // Catch:{ all -> 0x0012 }
            if (r0 != 0) goto L_0x0007
            monitor-exit(r1)
            return
        L_0x0007:
            android.os.Handler r0 = r0.a()     // Catch:{ all -> 0x0012 }
            if (r0 == 0) goto L_0x0010
            r0.post(r2)     // Catch:{ all -> 0x0012 }
        L_0x0010:
            monitor-exit(r1)
            return
        L_0x0012:
            r2 = move-exception
            monitor-exit(r1)
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ironsource.pb.a(java.lang.Runnable):void");
    }
}
