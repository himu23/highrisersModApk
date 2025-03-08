package com.applovin.exoplayer2;

import android.os.Looper;
import com.applovin.exoplayer2.l.d;

public final class ao {
    private final d bR;
    private int bs;
    private int cN;
    private final ba ci;
    private long dX = -9223372036854775807L;
    private final b gR;
    private final a gS;
    private Object gT;
    private Looper gU;
    private boolean gV = true;
    private boolean gW;
    private boolean gX;
    private boolean gY;
    private boolean gZ;

    public interface a {
        void a(ao aoVar);
    }

    public interface b {
        void a(int i, Object obj) throws p;
    }

    public ba bf() {
        return this.ci;
    }

    public b cF() {
        return this.gR;
    }

    public int cG() {
        return this.bs;
    }

    public Object cH() {
        return this.gT;
    }

    public Looper cI() {
        return this.gU;
    }

    public long cJ() {
        return this.dX;
    }

    public int cK() {
        return this.cN;
    }

    public boolean cL() {
        return this.gV;
    }

    public ao(a aVar, b bVar, ba baVar, int i, d dVar, Looper looper) {
        this.gS = aVar;
        this.gR = bVar;
        this.ci = baVar;
        this.gU = looper;
        this.bR = dVar;
        this.cN = i;
    }

    public ao ad(int i) {
        com.applovin.exoplayer2.l.a.checkState(!this.gW);
        this.bs = i;
        return this;
    }

    public ao h(Object obj) {
        com.applovin.exoplayer2.l.a.checkState(!this.gW);
        this.gT = obj;
        return this;
    }

    public ao cM() {
        com.applovin.exoplayer2.l.a.checkState(!this.gW);
        if (this.dX == -9223372036854775807L) {
            com.applovin.exoplayer2.l.a.checkArgument(this.gV);
        }
        this.gW = true;
        this.gS.a(this);
        return this;
    }

    public synchronized boolean cN() {
        return this.gZ;
    }

    public synchronized void B(boolean z) {
        this.gX = z | this.gX;
        this.gY = true;
        notifyAll();
    }

    /* JADX WARNING: Removed duplicated region for block: B:13:0x003c  */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x0040 A[SYNTHETIC, Splitter:B:16:0x0040] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized boolean y(long r7) throws java.lang.InterruptedException, java.util.concurrent.TimeoutException {
        /*
            r6 = this;
            monitor-enter(r6)
            boolean r0 = r6.gW     // Catch:{ all -> 0x0048 }
            com.applovin.exoplayer2.l.a.checkState(r0)     // Catch:{ all -> 0x0048 }
            android.os.Looper r0 = r6.gU     // Catch:{ all -> 0x0048 }
            java.lang.Thread r0 = r0.getThread()     // Catch:{ all -> 0x0048 }
            java.lang.Thread r1 = java.lang.Thread.currentThread()     // Catch:{ all -> 0x0048 }
            if (r0 == r1) goto L_0x0014
            r0 = 1
            goto L_0x0015
        L_0x0014:
            r0 = 0
        L_0x0015:
            com.applovin.exoplayer2.l.a.checkState(r0)     // Catch:{ all -> 0x0048 }
            com.applovin.exoplayer2.l.d r0 = r6.bR     // Catch:{ all -> 0x0048 }
            long r0 = r0.oK()     // Catch:{ all -> 0x0048 }
            long r0 = r0 + r7
        L_0x001f:
            boolean r2 = r6.gY     // Catch:{ all -> 0x0048 }
            if (r2 != 0) goto L_0x003a
            r3 = 0
            int r5 = (r7 > r3 ? 1 : (r7 == r3 ? 0 : -1))
            if (r5 <= 0) goto L_0x003a
            com.applovin.exoplayer2.l.d r2 = r6.bR     // Catch:{ all -> 0x0048 }
            r2.oM()     // Catch:{ all -> 0x0048 }
            r6.wait(r7)     // Catch:{ all -> 0x0048 }
            com.applovin.exoplayer2.l.d r7 = r6.bR     // Catch:{ all -> 0x0048 }
            long r7 = r7.oK()     // Catch:{ all -> 0x0048 }
            long r7 = r0 - r7
            goto L_0x001f
        L_0x003a:
            if (r2 == 0) goto L_0x0040
            boolean r7 = r6.gX     // Catch:{ all -> 0x0048 }
            monitor-exit(r6)
            return r7
        L_0x0040:
            java.util.concurrent.TimeoutException r7 = new java.util.concurrent.TimeoutException     // Catch:{ all -> 0x0048 }
            java.lang.String r8 = "Message delivery timed out."
            r7.<init>(r8)     // Catch:{ all -> 0x0048 }
            throw r7     // Catch:{ all -> 0x0048 }
        L_0x0048:
            r7 = move-exception
            monitor-exit(r6)
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.applovin.exoplayer2.ao.y(long):boolean");
    }
}
