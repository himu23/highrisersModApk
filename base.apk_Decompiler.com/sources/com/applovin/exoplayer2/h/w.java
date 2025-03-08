package com.applovin.exoplayer2.h;

import android.os.Looper;
import com.applovin.exoplayer2.d.e;
import com.applovin.exoplayer2.d.f;
import com.applovin.exoplayer2.d.g;
import com.applovin.exoplayer2.d.h;
import com.applovin.exoplayer2.e.x;
import com.applovin.exoplayer2.l.ai;
import com.applovin.exoplayer2.l.u;
import com.applovin.exoplayer2.l.y;
import com.applovin.exoplayer2.v;
import java.io.IOException;

public class w implements x {
    private long Gi = Long.MIN_VALUE;
    private final h LS;
    private final v MS;
    private final a MT = new a();
    private final ab<b> MU = new ab<>(new w$$ExternalSyntheticLambda0());
    private c MV;
    private v MW;
    private f MX;
    private int MY = 1000;
    private int[] MZ = new int[1000];
    private x.a[] Na = new x.a[1000];
    private int Nb;
    private int Nc;
    private int Nd;
    private long Ne = Long.MIN_VALUE;
    private long Nf = Long.MIN_VALUE;
    private boolean Ng;
    private boolean Nh = true;
    private boolean Ni = true;
    private boolean Nj;
    private v Nk;
    private v Nl;
    private int Nm;
    private boolean Nn;
    private boolean No;
    private long Np;
    private boolean Nq;
    private final Looper co;
    private int fR;
    private final g.a fY;
    private int[] tR = new int[1000];
    private long[] tS = new long[1000];
    private long[] tU = new long[1000];
    private int[] zJ = new int[1000];

    public interface c {
        void t(v vVar);
    }

    private int dU(int i) {
        int i2 = this.Nc + i;
        int i3 = this.MY;
        return i2 < i3 ? i2 : i2 - i3;
    }

    private boolean lF() {
        return this.Nd != this.fR;
    }

    public /* synthetic */ int a(com.applovin.exoplayer2.k.g gVar, int i, boolean z) {
        return x.CC.$default$a(this, gVar, i, z);
    }

    public final void a(c cVar) {
        this.MV = cVar;
    }

    public final void ba(long j) {
        this.Gi = j;
    }

    public /* synthetic */ void c(y yVar, int i) {
        x.CC.$default$c(this, yVar, i);
    }

    public final int lw() {
        return this.Nb + this.fR;
    }

    public final int ly() {
        return this.Nb + this.Nd;
    }

    public static w a(com.applovin.exoplayer2.k.b bVar, Looper looper, h hVar, g.a aVar) {
        return new w(bVar, (Looper) com.applovin.exoplayer2.l.a.checkNotNull(looper), (h) com.applovin.exoplayer2.l.a.checkNotNull(hVar), (g.a) com.applovin.exoplayer2.l.a.checkNotNull(aVar));
    }

    protected w(com.applovin.exoplayer2.k.b bVar, Looper looper, h hVar, g.a aVar) {
        this.co = looper;
        this.LS = hVar;
        this.fY = aVar;
        this.MS = new v(bVar);
    }

    public void release() {
        e(true);
        lE();
    }

    public final void Y() {
        e(false);
    }

    public void e(boolean z) {
        this.MS.Y();
        this.fR = 0;
        this.Nb = 0;
        this.Nc = 0;
        this.Nd = 0;
        this.Nh = true;
        this.Gi = Long.MIN_VALUE;
        this.Ne = Long.MIN_VALUE;
        this.Nf = Long.MIN_VALUE;
        this.Ng = false;
        this.MU.clear();
        if (z) {
            this.Nk = null;
            this.Nl = null;
            this.Ni = true;
        }
    }

    public void lx() {
        lC();
        lE();
    }

    public void kR() throws IOException {
        f fVar = this.MX;
        if (fVar != null && fVar.P() == 1) {
            throw ((f.a) com.applovin.exoplayer2.l.a.checkNotNull(this.MX.ht()));
        }
    }

    public final synchronized v lz() {
        return this.Ni ? null : this.Nl;
    }

    public final synchronized long lj() {
        return this.Nf;
    }

    public final synchronized long lA() {
        return Math.max(this.Ne, dT(this.Nd));
    }

    public final synchronized boolean lB() {
        return this.Ng;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0019, code lost:
        return r1;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized boolean Q(boolean r3) {
        /*
            r2 = this;
            monitor-enter(r2)
            boolean r0 = r2.lF()     // Catch:{ all -> 0x003a }
            r1 = 1
            if (r0 != 0) goto L_0x001a
            if (r3 != 0) goto L_0x0018
            boolean r3 = r2.Ng     // Catch:{ all -> 0x003a }
            if (r3 != 0) goto L_0x0018
            com.applovin.exoplayer2.v r3 = r2.Nl     // Catch:{ all -> 0x003a }
            if (r3 == 0) goto L_0x0017
            com.applovin.exoplayer2.v r0 = r2.MW     // Catch:{ all -> 0x003a }
            if (r3 == r0) goto L_0x0017
            goto L_0x0018
        L_0x0017:
            r1 = 0
        L_0x0018:
            monitor-exit(r2)
            return r1
        L_0x001a:
            com.applovin.exoplayer2.h.ab<com.applovin.exoplayer2.h.w$b> r3 = r2.MU     // Catch:{ all -> 0x003a }
            int r0 = r2.ly()     // Catch:{ all -> 0x003a }
            java.lang.Object r3 = r3.get(r0)     // Catch:{ all -> 0x003a }
            com.applovin.exoplayer2.h.w$b r3 = (com.applovin.exoplayer2.h.w.b) r3     // Catch:{ all -> 0x003a }
            com.applovin.exoplayer2.v r3 = r3.dU     // Catch:{ all -> 0x003a }
            com.applovin.exoplayer2.v r0 = r2.MW     // Catch:{ all -> 0x003a }
            if (r3 == r0) goto L_0x002e
            monitor-exit(r2)
            return r1
        L_0x002e:
            int r3 = r2.Nd     // Catch:{ all -> 0x003a }
            int r3 = r2.dU(r3)     // Catch:{ all -> 0x003a }
            boolean r3 = r2.dR(r3)     // Catch:{ all -> 0x003a }
            monitor-exit(r2)
            return r3
        L_0x003a:
            r3 = move-exception
            monitor-exit(r2)
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.applovin.exoplayer2.h.w.Q(boolean):boolean");
    }

    public int a(com.applovin.exoplayer2.w wVar, com.applovin.exoplayer2.c.g gVar, int i, boolean z) {
        boolean z2 = false;
        int a2 = a(wVar, gVar, (i & 2) != 0, z, this.MT);
        if (a2 == -4 && !gVar.gY()) {
            if ((i & 1) != 0) {
                z2 = true;
            }
            if ((i & 4) == 0) {
                if (z2) {
                    this.MS.b(gVar, this.MT);
                } else {
                    this.MS.a(gVar, this.MT);
                }
            }
            if (!z2) {
                this.Nd++;
            }
        }
        return a2;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:20:0x003f, code lost:
        return false;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized boolean e(long r9, boolean r11) {
        /*
            r8 = this;
            monitor-enter(r8)
            r8.lt()     // Catch:{ all -> 0x0040 }
            int r0 = r8.Nd     // Catch:{ all -> 0x0040 }
            int r2 = r8.dU(r0)     // Catch:{ all -> 0x0040 }
            boolean r0 = r8.lF()     // Catch:{ all -> 0x0040 }
            r7 = 0
            if (r0 == 0) goto L_0x003e
            long[] r0 = r8.tU     // Catch:{ all -> 0x0040 }
            r3 = r0[r2]     // Catch:{ all -> 0x0040 }
            int r0 = (r9 > r3 ? 1 : (r9 == r3 ? 0 : -1))
            if (r0 < 0) goto L_0x003e
            long r0 = r8.Nf     // Catch:{ all -> 0x0040 }
            int r3 = (r9 > r0 ? 1 : (r9 == r0 ? 0 : -1))
            if (r3 <= 0) goto L_0x0022
            if (r11 != 0) goto L_0x0022
            goto L_0x003e
        L_0x0022:
            int r11 = r8.fR     // Catch:{ all -> 0x0040 }
            int r0 = r8.Nd     // Catch:{ all -> 0x0040 }
            int r3 = r11 - r0
            r6 = 1
            r1 = r8
            r4 = r9
            int r11 = r1.a((int) r2, (int) r3, (long) r4, (boolean) r6)     // Catch:{ all -> 0x0040 }
            r0 = -1
            if (r11 != r0) goto L_0x0034
            monitor-exit(r8)
            return r7
        L_0x0034:
            r8.Gi = r9     // Catch:{ all -> 0x0040 }
            int r9 = r8.Nd     // Catch:{ all -> 0x0040 }
            int r9 = r9 + r11
            r8.Nd = r9     // Catch:{ all -> 0x0040 }
            monitor-exit(r8)
            r9 = 1
            return r9
        L_0x003e:
            monitor-exit(r8)
            return r7
        L_0x0040:
            r9 = move-exception
            monitor-exit(r8)
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.applovin.exoplayer2.h.w.e(long, boolean):boolean");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:23:0x003b, code lost:
        return 0;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized int f(long r9, boolean r11) {
        /*
            r8 = this;
            monitor-enter(r8)
            int r0 = r8.Nd     // Catch:{ all -> 0x003c }
            int r2 = r8.dU(r0)     // Catch:{ all -> 0x003c }
            boolean r0 = r8.lF()     // Catch:{ all -> 0x003c }
            r7 = 0
            if (r0 == 0) goto L_0x003a
            long[] r0 = r8.tU     // Catch:{ all -> 0x003c }
            r3 = r0[r2]     // Catch:{ all -> 0x003c }
            int r0 = (r9 > r3 ? 1 : (r9 == r3 ? 0 : -1))
            if (r0 >= 0) goto L_0x0017
            goto L_0x003a
        L_0x0017:
            long r0 = r8.Nf     // Catch:{ all -> 0x003c }
            int r3 = (r9 > r0 ? 1 : (r9 == r0 ? 0 : -1))
            if (r3 <= 0) goto L_0x0026
            if (r11 == 0) goto L_0x0026
            int r9 = r8.fR     // Catch:{ all -> 0x003c }
            int r10 = r8.Nd     // Catch:{ all -> 0x003c }
            int r9 = r9 - r10
            monitor-exit(r8)
            return r9
        L_0x0026:
            int r11 = r8.fR     // Catch:{ all -> 0x003c }
            int r0 = r8.Nd     // Catch:{ all -> 0x003c }
            int r3 = r11 - r0
            r6 = 1
            r1 = r8
            r4 = r9
            int r9 = r1.a((int) r2, (int) r3, (long) r4, (boolean) r6)     // Catch:{ all -> 0x003c }
            r10 = -1
            if (r9 != r10) goto L_0x0038
            monitor-exit(r8)
            return r7
        L_0x0038:
            monitor-exit(r8)
            return r9
        L_0x003a:
            monitor-exit(r8)
            return r7
        L_0x003c:
            r9 = move-exception
            monitor-exit(r8)
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.applovin.exoplayer2.h.w.f(long, boolean):int");
    }

    public final synchronized void dP(int i) {
        boolean z;
        if (i >= 0) {
            try {
                if (this.Nd + i <= this.fR) {
                    z = true;
                    com.applovin.exoplayer2.l.a.checkArgument(z);
                    this.Nd += i;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        z = false;
        com.applovin.exoplayer2.l.a.checkArgument(z);
        this.Nd += i;
    }

    public final void b(long j, boolean z, boolean z2) {
        this.MS.aY(c(j, z, z2));
    }

    public final void lC() {
        this.MS.aY(lD());
    }

    public final void j(v vVar) {
        v u = u(vVar);
        this.Nj = false;
        this.Nk = vVar;
        boolean v = v(u);
        c cVar = this.MV;
        if (cVar != null && v) {
            cVar.t(u);
        }
    }

    public final int a(com.applovin.exoplayer2.k.g gVar, int i, boolean z, int i2) throws IOException {
        return this.MS.a(gVar, i, z);
    }

    public final void a(y yVar, int i, int i2) {
        this.MS.c(yVar, i);
    }

    /* JADX WARNING: Removed duplicated region for block: B:25:0x0056  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void a(long r12, int r14, int r15, int r16, com.applovin.exoplayer2.e.x.a r17) {
        /*
            r11 = this;
            r8 = r11
            boolean r0 = r8.Nj
            if (r0 == 0) goto L_0x0010
            com.applovin.exoplayer2.v r0 = r8.Nk
            java.lang.Object r0 = com.applovin.exoplayer2.l.a.N(r0)
            com.applovin.exoplayer2.v r0 = (com.applovin.exoplayer2.v) r0
            r11.j(r0)
        L_0x0010:
            r0 = r14 & 1
            r1 = 0
            r2 = 1
            if (r0 == 0) goto L_0x0018
            r3 = 1
            goto L_0x0019
        L_0x0018:
            r3 = 0
        L_0x0019:
            boolean r4 = r8.Nh
            if (r4 == 0) goto L_0x0022
            if (r3 != 0) goto L_0x0020
            return
        L_0x0020:
            r8.Nh = r1
        L_0x0022:
            long r4 = r8.Np
            long r4 = r4 + r12
            boolean r6 = r8.Nn
            if (r6 == 0) goto L_0x0051
            long r6 = r8.Gi
            int r9 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r9 >= 0) goto L_0x0030
            return
        L_0x0030:
            if (r0 != 0) goto L_0x0051
            boolean r0 = r8.No
            if (r0 != 0) goto L_0x004d
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            java.lang.String r6 = "Overriding unexpected non-sync sample for format: "
            r0.<init>(r6)
            com.applovin.exoplayer2.v r6 = r8.Nl
            r0.append(r6)
            java.lang.String r0 = r0.toString()
            java.lang.String r6 = "SampleQueue"
            com.applovin.exoplayer2.l.q.h(r6, r0)
            r8.No = r2
        L_0x004d:
            r0 = r14 | 1
            r6 = r0
            goto L_0x0052
        L_0x0051:
            r6 = r14
        L_0x0052:
            boolean r0 = r8.Nq
            if (r0 == 0) goto L_0x0063
            if (r3 == 0) goto L_0x0062
            boolean r0 = r11.bb(r4)
            if (r0 != 0) goto L_0x005f
            goto L_0x0062
        L_0x005f:
            r8.Nq = r1
            goto L_0x0063
        L_0x0062:
            return
        L_0x0063:
            com.applovin.exoplayer2.h.v r0 = r8.MS
            long r0 = r0.lu()
            r7 = r15
            long r2 = (long) r7
            long r0 = r0 - r2
            r2 = r16
            long r2 = (long) r2
            long r9 = r0 - r2
            r0 = r11
            r1 = r4
            r3 = r6
            r4 = r9
            r6 = r15
            r7 = r17
            r0.a((long) r1, (int) r3, (long) r4, (int) r6, (com.applovin.exoplayer2.e.x.a) r7)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.applovin.exoplayer2.h.w.a(long, int, int, int, com.applovin.exoplayer2.e.x$a):void");
    }

    /* access modifiers changed from: protected */
    public v u(v vVar) {
        return (this.Np == 0 || vVar.dD == Long.MAX_VALUE) ? vVar : vVar.bR().p(vVar.dD + this.Np).bT();
    }

    private synchronized void lt() {
        this.Nd = 0;
        this.MS.lt();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:18:0x002a, code lost:
        return -3;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private synchronized int a(com.applovin.exoplayer2.w r5, com.applovin.exoplayer2.c.g r6, boolean r7, boolean r8, com.applovin.exoplayer2.h.w.a r9) {
        /*
            r4 = this;
            monitor-enter(r4)
            r0 = 0
            r6.rI = r0     // Catch:{ all -> 0x008a }
            boolean r0 = r4.lF()     // Catch:{ all -> 0x008a }
            r1 = -5
            r2 = -3
            r3 = -4
            if (r0 != 0) goto L_0x0031
            if (r8 != 0) goto L_0x002b
            boolean r8 = r4.Ng     // Catch:{ all -> 0x008a }
            if (r8 == 0) goto L_0x0014
            goto L_0x002b
        L_0x0014:
            com.applovin.exoplayer2.v r6 = r4.Nl     // Catch:{ all -> 0x008a }
            if (r6 == 0) goto L_0x0029
            if (r7 != 0) goto L_0x001e
            com.applovin.exoplayer2.v r7 = r4.MW     // Catch:{ all -> 0x008a }
            if (r6 == r7) goto L_0x0029
        L_0x001e:
            java.lang.Object r6 = com.applovin.exoplayer2.l.a.checkNotNull(r6)     // Catch:{ all -> 0x008a }
            com.applovin.exoplayer2.v r6 = (com.applovin.exoplayer2.v) r6     // Catch:{ all -> 0x008a }
            r4.a(r6, r5)     // Catch:{ all -> 0x008a }
            monitor-exit(r4)
            return r1
        L_0x0029:
            monitor-exit(r4)
            return r2
        L_0x002b:
            r5 = 4
            r6.bs(r5)     // Catch:{ all -> 0x008a }
            monitor-exit(r4)
            return r3
        L_0x0031:
            com.applovin.exoplayer2.h.ab<com.applovin.exoplayer2.h.w$b> r8 = r4.MU     // Catch:{ all -> 0x008a }
            int r0 = r4.ly()     // Catch:{ all -> 0x008a }
            java.lang.Object r8 = r8.get(r0)     // Catch:{ all -> 0x008a }
            com.applovin.exoplayer2.h.w$b r8 = (com.applovin.exoplayer2.h.w.b) r8     // Catch:{ all -> 0x008a }
            com.applovin.exoplayer2.v r8 = r8.dU     // Catch:{ all -> 0x008a }
            if (r7 != 0) goto L_0x0085
            com.applovin.exoplayer2.v r7 = r4.MW     // Catch:{ all -> 0x008a }
            if (r8 == r7) goto L_0x0046
            goto L_0x0085
        L_0x0046:
            int r5 = r4.Nd     // Catch:{ all -> 0x008a }
            int r5 = r4.dU(r5)     // Catch:{ all -> 0x008a }
            boolean r7 = r4.dR(r5)     // Catch:{ all -> 0x008a }
            if (r7 != 0) goto L_0x0057
            r5 = 1
            r6.rI = r5     // Catch:{ all -> 0x008a }
            monitor-exit(r4)
            return r2
        L_0x0057:
            int[] r7 = r4.zJ     // Catch:{ all -> 0x008a }
            r7 = r7[r5]     // Catch:{ all -> 0x008a }
            r6.bs(r7)     // Catch:{ all -> 0x008a }
            long[] r7 = r4.tU     // Catch:{ all -> 0x008a }
            r0 = r7[r5]     // Catch:{ all -> 0x008a }
            r6.rJ = r0     // Catch:{ all -> 0x008a }
            long r7 = r6.rJ     // Catch:{ all -> 0x008a }
            long r0 = r4.Gi     // Catch:{ all -> 0x008a }
            int r2 = (r7 > r0 ? 1 : (r7 == r0 ? 0 : -1))
            if (r2 >= 0) goto L_0x0071
            r7 = -2147483648(0xffffffff80000000, float:-0.0)
            r6.bt(r7)     // Catch:{ all -> 0x008a }
        L_0x0071:
            int[] r6 = r4.tR     // Catch:{ all -> 0x008a }
            r6 = r6[r5]     // Catch:{ all -> 0x008a }
            r9.oW = r6     // Catch:{ all -> 0x008a }
            long[] r6 = r4.tS     // Catch:{ all -> 0x008a }
            r7 = r6[r5]     // Catch:{ all -> 0x008a }
            r9.zr = r7     // Catch:{ all -> 0x008a }
            com.applovin.exoplayer2.e.x$a[] r6 = r4.Na     // Catch:{ all -> 0x008a }
            r5 = r6[r5]     // Catch:{ all -> 0x008a }
            r9.xZ = r5     // Catch:{ all -> 0x008a }
            monitor-exit(r4)
            return r3
        L_0x0085:
            r4.a(r8, r5)     // Catch:{ all -> 0x008a }
            monitor-exit(r4)
            return r1
        L_0x008a:
            r5 = move-exception
            monitor-exit(r4)
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.applovin.exoplayer2.h.w.a(com.applovin.exoplayer2.w, com.applovin.exoplayer2.c.g, boolean, boolean, com.applovin.exoplayer2.h.w$a):int");
    }

    private synchronized boolean v(v vVar) {
        this.Ni = false;
        if (ai.r(vVar, this.Nl)) {
            return false;
        }
        if (this.MU.isEmpty() || !this.MU.lK().dU.equals(vVar)) {
            this.Nl = vVar;
        } else {
            this.Nl = this.MU.lK().dU;
        }
        this.Nn = u.j(this.Nl.dz, this.Nl.dw);
        this.No = false;
        return true;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:21:0x002e, code lost:
        return -1;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private synchronized long c(long r11, boolean r13, boolean r14) {
        /*
            r10 = this;
            monitor-enter(r10)
            int r0 = r10.fR     // Catch:{ all -> 0x002f }
            r1 = -1
            if (r0 == 0) goto L_0x002d
            long[] r3 = r10.tU     // Catch:{ all -> 0x002f }
            int r5 = r10.Nc     // Catch:{ all -> 0x002f }
            r6 = r3[r5]     // Catch:{ all -> 0x002f }
            int r3 = (r11 > r6 ? 1 : (r11 == r6 ? 0 : -1))
            if (r3 >= 0) goto L_0x0012
            goto L_0x002d
        L_0x0012:
            if (r14 == 0) goto L_0x001a
            int r14 = r10.Nd     // Catch:{ all -> 0x002f }
            if (r14 == r0) goto L_0x001a
            int r0 = r14 + 1
        L_0x001a:
            r6 = r0
            r4 = r10
            r7 = r11
            r9 = r13
            int r11 = r4.a((int) r5, (int) r6, (long) r7, (boolean) r9)     // Catch:{ all -> 0x002f }
            r12 = -1
            if (r11 != r12) goto L_0x0027
            monitor-exit(r10)
            return r1
        L_0x0027:
            long r11 = r10.dS(r11)     // Catch:{ all -> 0x002f }
            monitor-exit(r10)
            return r11
        L_0x002d:
            monitor-exit(r10)
            return r1
        L_0x002f:
            r11 = move-exception
            monitor-exit(r10)
            throw r11
        */
        throw new UnsupportedOperationException("Method not decompiled: com.applovin.exoplayer2.h.w.c(long, boolean, boolean):long");
    }

    private synchronized long lD() {
        int i = this.fR;
        if (i == 0) {
            return -1;
        }
        return dS(i);
    }

    private void lE() {
        f fVar = this.MX;
        if (fVar != null) {
            fVar.b(this.fY);
            this.MX = null;
            this.MW = null;
        }
    }

    private synchronized void a(long j, int i, long j2, int i2, x.a aVar) {
        h.a aVar2;
        int i3 = this.fR;
        if (i3 > 0) {
            int dU = dU(i3 - 1);
            com.applovin.exoplayer2.l.a.checkArgument(this.tS[dU] + ((long) this.tR[dU]) <= j2);
        }
        this.Ng = (536870912 & i) != 0;
        this.Nf = Math.max(this.Nf, j);
        int dU2 = dU(this.fR);
        this.tU[dU2] = j;
        this.tS[dU2] = j2;
        this.tR[dU2] = i2;
        this.zJ[dU2] = i;
        this.Na[dU2] = aVar;
        this.MZ[dU2] = this.Nm;
        if (this.MU.isEmpty() || !this.MU.lK().dU.equals(this.Nl)) {
            h hVar = this.LS;
            if (hVar != null) {
                aVar2 = hVar.a((Looper) com.applovin.exoplayer2.l.a.checkNotNull(this.co), this.fY, this.Nl);
            } else {
                aVar2 = h.a.tk;
            }
            this.MU.b(lw(), new b((v) com.applovin.exoplayer2.l.a.checkNotNull(this.Nl), aVar2));
        }
        int i4 = this.fR + 1;
        this.fR = i4;
        int i5 = this.MY;
        if (i4 == i5) {
            int i6 = i5 + 1000;
            int[] iArr = new int[i6];
            long[] jArr = new long[i6];
            long[] jArr2 = new long[i6];
            int[] iArr2 = new int[i6];
            int[] iArr3 = new int[i6];
            x.a[] aVarArr = new x.a[i6];
            int i7 = this.Nc;
            int i8 = i5 - i7;
            System.arraycopy(this.tS, i7, jArr, 0, i8);
            System.arraycopy(this.tU, this.Nc, jArr2, 0, i8);
            System.arraycopy(this.zJ, this.Nc, iArr2, 0, i8);
            System.arraycopy(this.tR, this.Nc, iArr3, 0, i8);
            System.arraycopy(this.Na, this.Nc, aVarArr, 0, i8);
            System.arraycopy(this.MZ, this.Nc, iArr, 0, i8);
            int i9 = this.Nc;
            System.arraycopy(this.tS, 0, jArr, i8, i9);
            System.arraycopy(this.tU, 0, jArr2, i8, i9);
            System.arraycopy(this.zJ, 0, iArr2, i8, i9);
            System.arraycopy(this.tR, 0, iArr3, i8, i9);
            System.arraycopy(this.Na, 0, aVarArr, i8, i9);
            System.arraycopy(this.MZ, 0, iArr, i8, i9);
            this.tS = jArr;
            this.tU = jArr2;
            this.zJ = iArr2;
            this.tR = iArr3;
            this.Na = aVarArr;
            this.MZ = iArr;
            this.Nc = 0;
            this.MY = i6;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0010, code lost:
        return r1;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private synchronized boolean bb(long r6) {
        /*
            r5 = this;
            monitor-enter(r5)
            int r0 = r5.fR     // Catch:{ all -> 0x0027 }
            r1 = 1
            r2 = 0
            if (r0 != 0) goto L_0x0011
            long r3 = r5.Ne     // Catch:{ all -> 0x0027 }
            int r0 = (r6 > r3 ? 1 : (r6 == r3 ? 0 : -1))
            if (r0 <= 0) goto L_0x000e
            goto L_0x000f
        L_0x000e:
            r1 = 0
        L_0x000f:
            monitor-exit(r5)
            return r1
        L_0x0011:
            long r3 = r5.lA()     // Catch:{ all -> 0x0027 }
            int r0 = (r3 > r6 ? 1 : (r3 == r6 ? 0 : -1))
            if (r0 < 0) goto L_0x001b
            monitor-exit(r5)
            return r2
        L_0x001b:
            int r6 = r5.bc(r6)     // Catch:{ all -> 0x0027 }
            int r7 = r5.Nb     // Catch:{ all -> 0x0027 }
            int r7 = r7 + r6
            r5.dQ(r7)     // Catch:{ all -> 0x0027 }
            monitor-exit(r5)
            return r1
        L_0x0027:
            r6 = move-exception
            monitor-exit(r5)
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.applovin.exoplayer2.h.w.bb(long):boolean");
    }

    private long dQ(int i) {
        int lw = lw() - i;
        boolean z = false;
        com.applovin.exoplayer2.l.a.checkArgument(lw >= 0 && lw <= this.fR - this.Nd);
        int i2 = this.fR - lw;
        this.fR = i2;
        this.Nf = Math.max(this.Ne, dT(i2));
        if (lw == 0 && this.Ng) {
            z = true;
        }
        this.Ng = z;
        this.MU.dY(i);
        int i3 = this.fR;
        if (i3 == 0) {
            return 0;
        }
        int dU = dU(i3 - 1);
        return this.tS[dU] + ((long) this.tR[dU]);
    }

    private void a(v vVar, com.applovin.exoplayer2.w wVar) {
        v vVar2 = this.MW;
        boolean z = vVar2 == null;
        e eVar = z ? null : vVar2.dC;
        this.MW = vVar;
        e eVar2 = vVar.dC;
        h hVar = this.LS;
        wVar.dU = hVar != null ? vVar.B(hVar.g(vVar)) : vVar;
        wVar.dT = this.MX;
        if (this.LS != null) {
            if (z || !ai.r(eVar, eVar2)) {
                f fVar = this.MX;
                f b2 = this.LS.b((Looper) com.applovin.exoplayer2.l.a.checkNotNull(this.co), this.fY, vVar);
                this.MX = b2;
                wVar.dT = b2;
                if (fVar != null) {
                    fVar.b(this.fY);
                }
            }
        }
    }

    private boolean dR(int i) {
        f fVar = this.MX;
        return fVar == null || fVar.P() == 4 || ((this.zJ[i] & 1073741824) == 0 && this.MX.hs());
    }

    private int a(int i, int i2, long j, boolean z) {
        int i3 = -1;
        for (int i4 = 0; i4 < i2; i4++) {
            long j2 = this.tU[i];
            if (j2 > j) {
                return i3;
            }
            if (!z || (this.zJ[i] & 1) != 0) {
                if (j2 == j) {
                    return i4;
                }
                i3 = i4;
            }
            i++;
            if (i == this.MY) {
                i = 0;
            }
        }
        return i3;
    }

    private int bc(long j) {
        int i = this.fR;
        int dU = dU(i - 1);
        while (i > this.Nd && this.tU[dU] >= j) {
            i--;
            dU--;
            if (dU == -1) {
                dU = this.MY - 1;
            }
        }
        return i;
    }

    private long dS(int i) {
        this.Ne = Math.max(this.Ne, dT(i));
        this.fR -= i;
        int i2 = this.Nb + i;
        this.Nb = i2;
        int i3 = this.Nc + i;
        this.Nc = i3;
        int i4 = this.MY;
        if (i3 >= i4) {
            this.Nc = i3 - i4;
        }
        int i5 = this.Nd - i;
        this.Nd = i5;
        if (i5 < 0) {
            this.Nd = 0;
        }
        this.MU.dX(i2);
        if (this.fR != 0) {
            return this.tS[this.Nc];
        }
        int i6 = this.Nc;
        if (i6 == 0) {
            i6 = this.MY;
        }
        int i7 = i6 - 1;
        return this.tS[i7] + ((long) this.tR[i7]);
    }

    private long dT(int i) {
        long j = Long.MIN_VALUE;
        if (i == 0) {
            return Long.MIN_VALUE;
        }
        int dU = dU(i - 1);
        for (int i2 = 0; i2 < i; i2++) {
            j = Math.max(j, this.tU[dU]);
            if ((this.zJ[dU] & 1) != 0) {
                break;
            }
            dU--;
            if (dU == -1) {
                dU = this.MY - 1;
            }
        }
        return j;
    }

    static final class a {
        public int oW;
        public x.a xZ;
        public long zr;

        a() {
        }
    }

    private static final class b {
        public final h.a Nr;
        public final v dU;

        private b(v vVar, h.a aVar) {
            this.dU = vVar;
            this.Nr = aVar;
        }
    }
}
