package com.applovin.exoplayer2.h;

import com.applovin.exoplayer2.av;
import com.applovin.exoplayer2.c.g;
import com.applovin.exoplayer2.h.n;
import com.applovin.exoplayer2.l.ai;
import com.applovin.exoplayer2.l.u;
import com.applovin.exoplayer2.v;
import com.applovin.exoplayer2.w;
import java.io.IOException;

public final class d implements n, n.a {
    private n.a KS;
    private a[] KT = new a[0];
    private long KU;
    long KV;
    long KW;
    public final n ft;

    /* access modifiers changed from: package-private */
    public boolean kP() {
        return this.KU != -9223372036854775807L;
    }

    public void v(long j, long j2) {
        this.KV = j;
        this.KW = j2;
    }

    public d(n nVar, boolean z, long j, long j2) {
        this.ft = nVar;
        this.KU = z ? j : -9223372036854775807L;
        this.KV = j;
        this.KW = j2;
    }

    public void a(n.a aVar, long j) {
        this.KS = aVar;
        this.ft.a((n.a) this, j);
    }

    public void kM() throws IOException {
        this.ft.kM();
    }

    public ad cj() {
        return this.ft.cj();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:22:0x005e, code lost:
        if (r2 > r4) goto L_0x0061;
     */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x004e  */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x006a  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public long a(com.applovin.exoplayer2.j.d[] r13, boolean[] r14, com.applovin.exoplayer2.h.x[] r15, boolean[] r16, long r17) {
        /*
            r12 = this;
            r0 = r12
            r1 = r15
            int r2 = r1.length
            com.applovin.exoplayer2.h.d$a[] r2 = new com.applovin.exoplayer2.h.d.a[r2]
            r0.KT = r2
            int r2 = r1.length
            com.applovin.exoplayer2.h.x[] r9 = new com.applovin.exoplayer2.h.x[r2]
            r10 = 0
            r2 = 0
        L_0x000c:
            int r3 = r1.length
            r11 = 0
            if (r2 >= r3) goto L_0x0021
            com.applovin.exoplayer2.h.d$a[] r3 = r0.KT
            r4 = r1[r2]
            com.applovin.exoplayer2.h.d$a r4 = (com.applovin.exoplayer2.h.d.a) r4
            r3[r2] = r4
            if (r4 == 0) goto L_0x001c
            com.applovin.exoplayer2.h.x r11 = r4.KX
        L_0x001c:
            r9[r2] = r11
            int r2 = r2 + 1
            goto L_0x000c
        L_0x0021:
            com.applovin.exoplayer2.h.n r2 = r0.ft
            r3 = r13
            r4 = r14
            r5 = r9
            r6 = r16
            r7 = r17
            long r2 = r2.a(r3, r4, r5, r6, r7)
            boolean r4 = r12.kP()
            if (r4 == 0) goto L_0x0043
            long r4 = r0.KV
            int r6 = (r17 > r4 ? 1 : (r17 == r4 ? 0 : -1))
            if (r6 != 0) goto L_0x0043
            r6 = r13
            boolean r4 = a((long) r4, (com.applovin.exoplayer2.j.d[]) r13)
            if (r4 == 0) goto L_0x0043
            r4 = r2
            goto L_0x0048
        L_0x0043:
            r4 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
        L_0x0048:
            r0.KU = r4
            int r4 = (r2 > r17 ? 1 : (r2 == r17 ? 0 : -1))
            if (r4 == 0) goto L_0x0063
            long r4 = r0.KV
            int r6 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r6 < 0) goto L_0x0061
            long r4 = r0.KW
            r6 = -9223372036854775808
            int r8 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r8 == 0) goto L_0x0063
            int r6 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r6 > 0) goto L_0x0061
            goto L_0x0063
        L_0x0061:
            r4 = 0
            goto L_0x0064
        L_0x0063:
            r4 = 1
        L_0x0064:
            com.applovin.exoplayer2.l.a.checkState(r4)
        L_0x0067:
            int r4 = r1.length
            if (r10 >= r4) goto L_0x0093
            r4 = r9[r10]
            if (r4 != 0) goto L_0x0073
            com.applovin.exoplayer2.h.d$a[] r4 = r0.KT
            r4[r10] = r11
            goto L_0x008a
        L_0x0073:
            com.applovin.exoplayer2.h.d$a[] r4 = r0.KT
            r4 = r4[r10]
            if (r4 == 0) goto L_0x007f
            com.applovin.exoplayer2.h.x r4 = r4.KX
            r5 = r9[r10]
            if (r4 == r5) goto L_0x008a
        L_0x007f:
            com.applovin.exoplayer2.h.d$a[] r4 = r0.KT
            com.applovin.exoplayer2.h.d$a r5 = new com.applovin.exoplayer2.h.d$a
            r6 = r9[r10]
            r5.<init>(r6)
            r4[r10] = r5
        L_0x008a:
            com.applovin.exoplayer2.h.d$a[] r4 = r0.KT
            r4 = r4[r10]
            r1[r10] = r4
            int r10 = r10 + 1
            goto L_0x0067
        L_0x0093:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.applovin.exoplayer2.h.d.a(com.applovin.exoplayer2.j.d[], boolean[], com.applovin.exoplayer2.h.x[], boolean[], long):long");
    }

    public void d(long j, boolean z) {
        this.ft.d(j, z);
    }

    public void t(long j) {
        this.ft.t(j);
    }

    public long kN() {
        if (kP()) {
            long j = this.KU;
            this.KU = -9223372036854775807L;
            long kN = kN();
            return kN != -9223372036854775807L ? kN : j;
        }
        long kN2 = this.ft.kN();
        if (kN2 == -9223372036854775807L) {
            return -9223372036854775807L;
        }
        boolean z = true;
        com.applovin.exoplayer2.l.a.checkState(kN2 >= this.KV);
        long j2 = this.KW;
        if (j2 != Long.MIN_VALUE && kN2 > j2) {
            z = false;
        }
        com.applovin.exoplayer2.l.a.checkState(z);
        return kN2;
    }

    public long cg() {
        long cg = this.ft.cg();
        if (cg != Long.MIN_VALUE) {
            long j = this.KW;
            if (j == Long.MIN_VALUE || cg < j) {
                return cg;
            }
        }
        return Long.MIN_VALUE;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0032, code lost:
        if (r0 > r7) goto L_0x0035;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public long aQ(long r7) {
        /*
            r6 = this;
            r0 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            r6.KU = r0
            com.applovin.exoplayer2.h.d$a[] r0 = r6.KT
            int r1 = r0.length
            r2 = 0
            r3 = 0
        L_0x000c:
            if (r3 >= r1) goto L_0x0018
            r4 = r0[r3]
            if (r4 == 0) goto L_0x0015
            r4.kQ()
        L_0x0015:
            int r3 = r3 + 1
            goto L_0x000c
        L_0x0018:
            com.applovin.exoplayer2.h.n r0 = r6.ft
            long r0 = r0.aQ(r7)
            int r3 = (r0 > r7 ? 1 : (r0 == r7 ? 0 : -1))
            if (r3 == 0) goto L_0x0034
            long r7 = r6.KV
            int r3 = (r0 > r7 ? 1 : (r0 == r7 ? 0 : -1))
            if (r3 < 0) goto L_0x0035
            long r7 = r6.KW
            r3 = -9223372036854775808
            int r5 = (r7 > r3 ? 1 : (r7 == r3 ? 0 : -1))
            if (r5 == 0) goto L_0x0034
            int r3 = (r0 > r7 ? 1 : (r0 == r7 ? 0 : -1))
            if (r3 > 0) goto L_0x0035
        L_0x0034:
            r2 = 1
        L_0x0035:
            com.applovin.exoplayer2.l.a.checkState(r2)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.applovin.exoplayer2.h.d.aQ(long):long");
    }

    public long a(long j, av avVar) {
        long j2 = this.KV;
        if (j == j2) {
            return j2;
        }
        return this.ft.a(j, b(j, avVar));
    }

    public long ch() {
        long ch = this.ft.ch();
        if (ch != Long.MIN_VALUE) {
            long j = this.KW;
            if (j == Long.MIN_VALUE || ch < j) {
                return ch;
            }
        }
        return Long.MIN_VALUE;
    }

    public boolean aR(long j) {
        return this.ft.aR(j);
    }

    public boolean kO() {
        return this.ft.kO();
    }

    public void a(n nVar) {
        ((n.a) com.applovin.exoplayer2.l.a.checkNotNull(this.KS)).a(this);
    }

    /* renamed from: b */
    public void a(n nVar) {
        ((n.a) com.applovin.exoplayer2.l.a.checkNotNull(this.KS)).a(this);
    }

    private av b(long j, av avVar) {
        long b = ai.b(avVar.ho, 0, j - this.KV);
        long j2 = avVar.hp;
        long j3 = this.KW;
        long b2 = ai.b(j2, 0, j3 == Long.MIN_VALUE ? Long.MAX_VALUE : j3 - j);
        if (b == avVar.ho && b2 == avVar.hp) {
            return avVar;
        }
        return new av(b, b2);
    }

    private static boolean a(long j, com.applovin.exoplayer2.j.d[] dVarArr) {
        if (j != 0) {
            for (com.applovin.exoplayer2.j.d dVar : dVarArr) {
                if (dVar != null) {
                    v ng = dVar.ng();
                    if (!u.j(ng.dz, ng.dw)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    private final class a implements x {
        public final x KX;
        private boolean KY;

        public void kQ() {
            this.KY = false;
        }

        public a(x xVar) {
            this.KX = xVar;
        }

        public boolean isReady() {
            return !d.this.kP() && this.KX.isReady();
        }

        public void kR() throws IOException {
            this.KX.kR();
        }

        public int b(w wVar, g gVar, int i) {
            if (d.this.kP()) {
                return -3;
            }
            if (this.KY) {
                gVar.bs(4);
                return -4;
            }
            int b = this.KX.b(wVar, gVar, i);
            if (b == -5) {
                v vVar = (v) com.applovin.exoplayer2.l.a.checkNotNull(wVar.dU);
                if (!(vVar.dO == 0 && vVar.dP == 0)) {
                    int i2 = 0;
                    int i3 = d.this.KV != 0 ? 0 : vVar.dO;
                    if (d.this.KW == Long.MIN_VALUE) {
                        i2 = vVar.dP;
                    }
                    wVar.dU = vVar.bR().Q(i3).R(i2).bT();
                }
                return -5;
            } else if (d.this.KW == Long.MIN_VALUE || ((b != -4 || gVar.rJ < d.this.KW) && (b != -3 || d.this.cg() != Long.MIN_VALUE || gVar.rI))) {
                return b;
            } else {
                gVar.clear();
                gVar.bs(4);
                this.KY = true;
                return -4;
            }
        }

        public int aS(long j) {
            if (d.this.kP()) {
                return -3;
            }
            return this.KX.aS(j);
        }
    }
}
