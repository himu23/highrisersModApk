package com.applovin.exoplayer2.c;

import com.applovin.exoplayer2.c.f;
import com.applovin.exoplayer2.c.g;
import com.applovin.exoplayer2.c.i;
import com.applovin.exoplayer2.l.a;
import java.util.ArrayDeque;

public abstract class j<I extends g, O extends i, E extends f> implements d<I, O, E> {
    private boolean cw;
    private int rA;
    private final Thread rS;
    private final Object rT = new Object();
    private final ArrayDeque<I> rU = new ArrayDeque<>();
    private final ArrayDeque<O> rV = new ArrayDeque<>();
    private final I[] rW;
    private final O[] rX;
    private int rY;
    private int rZ;
    private I sa;
    private E sb;
    private boolean sc;

    /* access modifiers changed from: protected */
    public abstract E a(I i, O o, boolean z);

    /* access modifiers changed from: protected */
    public abstract E a(Throwable th);

    /* access modifiers changed from: protected */
    public abstract I ho();

    /* access modifiers changed from: protected */
    public abstract O hp();

    protected j(I[] iArr, O[] oArr) {
        this.rW = iArr;
        this.rY = iArr.length;
        for (int i = 0; i < this.rY; i++) {
            this.rW[i] = ho();
        }
        this.rX = oArr;
        this.rZ = oArr.length;
        for (int i2 = 0; i2 < this.rZ; i2++) {
            this.rX[i2] = hp();
        }
        AnonymousClass1 r4 = new Thread("ExoPlayer:SimpleDecoder") {
            public void run() {
                j.this.run();
            }
        };
        this.rS = r4;
        r4.start();
    }

    /* access modifiers changed from: protected */
    public final void bA(int i) {
        a.checkState(this.rY == this.rW.length);
        for (I by : this.rW) {
            by.by(i);
        }
    }

    /* renamed from: hi */
    public final I hc() throws f {
        I i;
        synchronized (this.rT) {
            hk();
            a.checkState(this.sa == null);
            int i2 = this.rY;
            if (i2 == 0) {
                i = null;
            } else {
                I[] iArr = this.rW;
                int i3 = i2 - 1;
                this.rY = i3;
                i = iArr[i3];
            }
            this.sa = i;
        }
        return i;
    }

    /* renamed from: b */
    public final void D(I i) throws f {
        synchronized (this.rT) {
            hk();
            a.checkArgument(i == this.sa);
            this.rU.addLast(i);
            hl();
            this.sa = null;
        }
    }

    /* renamed from: hj */
    public final O hd() throws f {
        synchronized (this.rT) {
            hk();
            if (this.rV.isEmpty()) {
                return null;
            }
            O o = (i) this.rV.removeFirst();
            return o;
        }
    }

    /* access modifiers changed from: protected */
    public void releaseOutputBuffer(O o) {
        synchronized (this.rT) {
            a(o);
            hl();
        }
    }

    public final void dI() {
        synchronized (this.rT) {
            this.sc = true;
            this.rA = 0;
            I i = this.sa;
            if (i != null) {
                c(i);
                this.sa = null;
            }
            while (!this.rU.isEmpty()) {
                c((g) this.rU.removeFirst());
            }
            while (!this.rV.isEmpty()) {
                ((i) this.rV.removeFirst()).release();
            }
        }
    }

    public void release() {
        synchronized (this.rT) {
            this.cw = true;
            this.rT.notify();
        }
        try {
            this.rS.join();
        } catch (InterruptedException unused) {
            Thread.currentThread().interrupt();
        }
    }

    private void hk() throws f {
        E e = this.sb;
        if (e != null) {
            throw e;
        }
    }

    private void hl() {
        if (hn()) {
            this.rT.notify();
        }
    }

    /* access modifiers changed from: private */
    public void run() {
        do {
            try {
            } catch (InterruptedException e) {
                throw new IllegalStateException(e);
            }
        } while (hm());
    }

    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0035, code lost:
        if (r1.gY() == false) goto L_0x003c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0037, code lost:
        r3.bt(4);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0040, code lost:
        if (r1.gX() == false) goto L_0x0047;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0042, code lost:
        r3.bt(Integer.MIN_VALUE);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:?, code lost:
        r0 = a(r1, r3, r4);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x004c, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x004d, code lost:
        r0 = a((java.lang.Throwable) r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x0052, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x0053, code lost:
        r0 = a((java.lang.Throwable) r0);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private boolean hm() throws java.lang.InterruptedException {
        /*
            r6 = this;
            java.lang.Object r0 = r6.rT
            monitor-enter(r0)
        L_0x0003:
            boolean r1 = r6.cw     // Catch:{ all -> 0x0090 }
            if (r1 != 0) goto L_0x0013
            boolean r1 = r6.hn()     // Catch:{ all -> 0x0090 }
            if (r1 != 0) goto L_0x0013
            java.lang.Object r1 = r6.rT     // Catch:{ all -> 0x0090 }
            r1.wait()     // Catch:{ all -> 0x0090 }
            goto L_0x0003
        L_0x0013:
            boolean r1 = r6.cw     // Catch:{ all -> 0x0090 }
            r2 = 0
            if (r1 == 0) goto L_0x001a
            monitor-exit(r0)     // Catch:{ all -> 0x0090 }
            return r2
        L_0x001a:
            java.util.ArrayDeque<I> r1 = r6.rU     // Catch:{ all -> 0x0090 }
            java.lang.Object r1 = r1.removeFirst()     // Catch:{ all -> 0x0090 }
            com.applovin.exoplayer2.c.g r1 = (com.applovin.exoplayer2.c.g) r1     // Catch:{ all -> 0x0090 }
            O[] r3 = r6.rX     // Catch:{ all -> 0x0090 }
            int r4 = r6.rZ     // Catch:{ all -> 0x0090 }
            r5 = 1
            int r4 = r4 - r5
            r6.rZ = r4     // Catch:{ all -> 0x0090 }
            r3 = r3[r4]     // Catch:{ all -> 0x0090 }
            boolean r4 = r6.sc     // Catch:{ all -> 0x0090 }
            r6.sc = r2     // Catch:{ all -> 0x0090 }
            monitor-exit(r0)     // Catch:{ all -> 0x0090 }
            boolean r0 = r1.gY()
            if (r0 == 0) goto L_0x003c
            r0 = 4
            r3.bt(r0)
            goto L_0x0063
        L_0x003c:
            boolean r0 = r1.gX()
            if (r0 == 0) goto L_0x0047
            r0 = -2147483648(0xffffffff80000000, float:-0.0)
            r3.bt(r0)
        L_0x0047:
            com.applovin.exoplayer2.c.f r0 = r6.a(r1, r3, r4)     // Catch:{ RuntimeException -> 0x0052, OutOfMemoryError -> 0x004c }
            goto L_0x0057
        L_0x004c:
            r0 = move-exception
            com.applovin.exoplayer2.c.f r0 = r6.a((java.lang.Throwable) r0)
            goto L_0x0057
        L_0x0052:
            r0 = move-exception
            com.applovin.exoplayer2.c.f r0 = r6.a((java.lang.Throwable) r0)
        L_0x0057:
            if (r0 == 0) goto L_0x0063
            java.lang.Object r4 = r6.rT
            monitor-enter(r4)
            r6.sb = r0     // Catch:{ all -> 0x0060 }
            monitor-exit(r4)     // Catch:{ all -> 0x0060 }
            return r2
        L_0x0060:
            r0 = move-exception
            monitor-exit(r4)     // Catch:{ all -> 0x0060 }
            throw r0
        L_0x0063:
            java.lang.Object r4 = r6.rT
            monitor-enter(r4)
            boolean r0 = r6.sc     // Catch:{ all -> 0x008d }
            if (r0 == 0) goto L_0x006e
            r3.release()     // Catch:{ all -> 0x008d }
            goto L_0x0088
        L_0x006e:
            boolean r0 = r3.gX()     // Catch:{ all -> 0x008d }
            if (r0 == 0) goto L_0x007d
            int r0 = r6.rA     // Catch:{ all -> 0x008d }
            int r0 = r0 + r5
            r6.rA = r0     // Catch:{ all -> 0x008d }
            r3.release()     // Catch:{ all -> 0x008d }
            goto L_0x0088
        L_0x007d:
            int r0 = r6.rA     // Catch:{ all -> 0x008d }
            r3.rA = r0     // Catch:{ all -> 0x008d }
            r6.rA = r2     // Catch:{ all -> 0x008d }
            java.util.ArrayDeque<O> r0 = r6.rV     // Catch:{ all -> 0x008d }
            r0.addLast(r3)     // Catch:{ all -> 0x008d }
        L_0x0088:
            r6.c(r1)     // Catch:{ all -> 0x008d }
            monitor-exit(r4)     // Catch:{ all -> 0x008d }
            return r5
        L_0x008d:
            r0 = move-exception
            monitor-exit(r4)     // Catch:{ all -> 0x008d }
            throw r0
        L_0x0090:
            r1 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x0090 }
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.applovin.exoplayer2.c.j.hm():boolean");
    }

    private boolean hn() {
        return !this.rU.isEmpty() && this.rZ > 0;
    }

    private void c(I i) {
        i.clear();
        I[] iArr = this.rW;
        int i2 = this.rY;
        this.rY = i2 + 1;
        iArr[i2] = i;
    }

    private void a(O o) {
        o.clear();
        O[] oArr = this.rX;
        int i = this.rZ;
        this.rZ = i + 1;
        oArr[i] = o;
    }
}
