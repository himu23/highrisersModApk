package com.applovin.exoplayer2.h;

import com.applovin.exoplayer2.ab;
import com.applovin.exoplayer2.ba;
import com.applovin.exoplayer2.h.p;
import com.applovin.exoplayer2.k.aa;
import com.applovin.exoplayer2.l.ai;

public final class l extends e<Void> {
    private boolean LA;
    private boolean LB;
    private a Ly;
    private k Lz;
    private final ba.c U;
    private final ba.a bI;
    private final boolean bK;
    private boolean gb;
    private final p gf;

    public ba bf() {
        return this.Ly;
    }

    public void kS() {
    }

    public l(p pVar, boolean z) {
        this.gf = pVar;
        this.bK = z && pVar.lc();
        this.U = new ba.c();
        this.bI = new ba.a();
        ba lb = pVar.lb();
        if (lb != null) {
            this.Ly = a.a(lb, (Object) null, (Object) null);
            this.LB = true;
            return;
        }
        this.Ly = a.b(pVar.kZ());
    }

    public void b(aa aaVar) {
        super.b(aaVar);
        if (!this.bK) {
            this.LA = true;
            a(null, this.gf);
        }
    }

    public ab kZ() {
        return this.gf.kZ();
    }

    /* renamed from: b */
    public k a(p.a aVar, com.applovin.exoplayer2.k.b bVar, long j) {
        k kVar = new k(aVar, bVar, j);
        kVar.a(this.gf);
        if (this.gb) {
            kVar.g(aVar.G(E(aVar.gM)));
        } else {
            this.Lz = kVar;
            if (!this.LA) {
                this.LA = true;
                a(null, this.gf);
            }
        }
        return kVar;
    }

    public void f(n nVar) {
        ((k) nVar).kY();
        if (nVar == this.Lz) {
            this.Lz = null;
        }
    }

    public void kJ() {
        this.gb = false;
        this.LA = false;
        super.kJ();
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x008d  */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x0094  */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x009e  */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x00bd  */
    /* JADX WARNING: Removed duplicated region for block: B:30:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void a(java.lang.Void r13, com.applovin.exoplayer2.h.p r14, com.applovin.exoplayer2.ba r15) {
        /*
            r12 = this;
            boolean r13 = r12.gb
            if (r13 == 0) goto L_0x0019
            com.applovin.exoplayer2.h.l$a r13 = r12.Ly
            com.applovin.exoplayer2.h.l$a r13 = r13.f(r15)
            r12.Ly = r13
            com.applovin.exoplayer2.h.k r13 = r12.Lz
            if (r13 == 0) goto L_0x00b0
            long r13 = r13.kX()
            r12.aV(r13)
            goto L_0x00b0
        L_0x0019:
            boolean r13 = r15.isEmpty()
            if (r13 == 0) goto L_0x0036
            boolean r13 = r12.LB
            if (r13 == 0) goto L_0x002a
            com.applovin.exoplayer2.h.l$a r13 = r12.Ly
            com.applovin.exoplayer2.h.l$a r13 = r13.f(r15)
            goto L_0x0032
        L_0x002a:
            java.lang.Object r13 = com.applovin.exoplayer2.ba.c.iF
            java.lang.Object r14 = com.applovin.exoplayer2.h.l.a.LC
            com.applovin.exoplayer2.h.l$a r13 = com.applovin.exoplayer2.h.l.a.a((com.applovin.exoplayer2.ba) r15, (java.lang.Object) r13, (java.lang.Object) r14)
        L_0x0032:
            r12.Ly = r13
            goto L_0x00b0
        L_0x0036:
            com.applovin.exoplayer2.ba$c r13 = r12.U
            r14 = 0
            r15.a((int) r14, (com.applovin.exoplayer2.ba.c) r13)
            com.applovin.exoplayer2.ba$c r13 = r12.U
            long r0 = r13.dk()
            com.applovin.exoplayer2.ba$c r13 = r12.U
            java.lang.Object r13 = r13.ch
            com.applovin.exoplayer2.h.k r2 = r12.Lz
            if (r2 == 0) goto L_0x0074
            long r2 = r2.kW()
            com.applovin.exoplayer2.h.l$a r4 = r12.Ly
            com.applovin.exoplayer2.h.k r5 = r12.Lz
            com.applovin.exoplayer2.h.p$a r5 = r5.fE
            java.lang.Object r5 = r5.gM
            com.applovin.exoplayer2.ba$a r6 = r12.bI
            r4.a((java.lang.Object) r5, (com.applovin.exoplayer2.ba.a) r6)
            com.applovin.exoplayer2.ba$a r4 = r12.bI
            long r4 = r4.df()
            long r4 = r4 + r2
            com.applovin.exoplayer2.h.l$a r2 = r12.Ly
            com.applovin.exoplayer2.ba$c r3 = r12.U
            com.applovin.exoplayer2.ba$c r14 = r2.a((int) r14, (com.applovin.exoplayer2.ba.c) r3)
            long r2 = r14.dk()
            int r14 = (r4 > r2 ? 1 : (r4 == r2 ? 0 : -1))
            if (r14 == 0) goto L_0x0074
            r10 = r4
            goto L_0x0075
        L_0x0074:
            r10 = r0
        L_0x0075:
            com.applovin.exoplayer2.ba$c r7 = r12.U
            com.applovin.exoplayer2.ba$a r8 = r12.bI
            r9 = 0
            r6 = r15
            android.util.Pair r14 = r6.a(r7, r8, r9, r10)
            java.lang.Object r0 = r14.first
            java.lang.Object r14 = r14.second
            java.lang.Long r14 = (java.lang.Long) r14
            long r1 = r14.longValue()
            boolean r14 = r12.LB
            if (r14 == 0) goto L_0x0094
            com.applovin.exoplayer2.h.l$a r13 = r12.Ly
            com.applovin.exoplayer2.h.l$a r13 = r13.f(r15)
            goto L_0x0098
        L_0x0094:
            com.applovin.exoplayer2.h.l$a r13 = com.applovin.exoplayer2.h.l.a.a((com.applovin.exoplayer2.ba) r15, (java.lang.Object) r13, (java.lang.Object) r0)
        L_0x0098:
            r12.Ly = r13
            com.applovin.exoplayer2.h.k r13 = r12.Lz
            if (r13 == 0) goto L_0x00b0
            r12.aV(r1)
            com.applovin.exoplayer2.h.p$a r14 = r13.fE
            com.applovin.exoplayer2.h.p$a r13 = r13.fE
            java.lang.Object r13 = r13.gM
            java.lang.Object r13 = r12.E(r13)
            com.applovin.exoplayer2.h.p$a r13 = r14.G(r13)
            goto L_0x00b1
        L_0x00b0:
            r13 = 0
        L_0x00b1:
            r14 = 1
            r12.LB = r14
            r12.gb = r14
            com.applovin.exoplayer2.h.l$a r14 = r12.Ly
            r12.e((com.applovin.exoplayer2.ba) r14)
            if (r13 == 0) goto L_0x00c8
            com.applovin.exoplayer2.h.k r14 = r12.Lz
            java.lang.Object r14 = com.applovin.exoplayer2.l.a.checkNotNull(r14)
            com.applovin.exoplayer2.h.k r14 = (com.applovin.exoplayer2.h.k) r14
            r14.g(r13)
        L_0x00c8:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.applovin.exoplayer2.h.l.a(java.lang.Void, com.applovin.exoplayer2.h.p, com.applovin.exoplayer2.ba):void");
    }

    /* access modifiers changed from: protected */
    public p.a a(Void voidR, p.a aVar) {
        return aVar.G(F(aVar.gM));
    }

    private Object E(Object obj) {
        return (this.Ly.LE == null || !obj.equals(a.LC)) ? obj : this.Ly.LE;
    }

    private Object F(Object obj) {
        return (this.Ly.LE == null || !this.Ly.LE.equals(obj)) ? obj : a.LC;
    }

    private void aV(long j) {
        k kVar = this.Lz;
        int c = this.Ly.c(kVar.fE.gM);
        if (c != -1) {
            long j2 = this.Ly.a(c, this.bI).fH;
            if (j2 != -9223372036854775807L && j >= j2) {
                j = Math.max(0, j2 - 1);
            }
            kVar.aT(j);
        }
    }

    private static final class a extends h {
        public static final Object LC = new Object();
        private final Object LD;
        /* access modifiers changed from: private */
        public final Object LE;

        public static a b(ab abVar) {
            return new a(new b(abVar), ba.c.iF, LC);
        }

        public static a a(ba baVar, Object obj, Object obj2) {
            return new a(baVar, obj, obj2);
        }

        private a(ba baVar, Object obj, Object obj2) {
            super(baVar);
            this.LD = obj;
            this.LE = obj2;
        }

        public a f(ba baVar) {
            return new a(baVar, this.LD, this.LE);
        }

        public ba.c a(int i, ba.c cVar, long j) {
            this.ci.a(i, cVar, j);
            if (ai.r(cVar.ch, this.LD)) {
                cVar.ch = ba.c.iF;
            }
            return cVar;
        }

        public ba.a a(int i, ba.a aVar, boolean z) {
            this.ci.a(i, aVar, z);
            if (ai.r(aVar.ch, this.LE) && z) {
                aVar.ch = LC;
            }
            return aVar;
        }

        public int c(Object obj) {
            Object obj2;
            ba baVar = this.ci;
            if (LC.equals(obj) && (obj2 = this.LE) != null) {
                obj = obj2;
            }
            return baVar.c(obj);
        }

        public Object b(int i) {
            Object b = this.ci.b(i);
            return ai.r(b, this.LE) ? LC : b;
        }
    }

    public static final class b extends ba {
        private final ab gL;

        public int cP() {
            return 1;
        }

        public int cQ() {
            return 1;
        }

        public b(ab abVar) {
            this.gL = abVar;
        }

        public ba.c a(int i, ba.c cVar, long j) {
            ba.c cVar2 = cVar;
            cVar.a(ba.c.iF, this.gL, (Object) null, -9223372036854775807L, -9223372036854775807L, -9223372036854775807L, false, true, (ab.e) null, 0, -9223372036854775807L, 0, 0, 0);
            ba.c cVar3 = cVar;
            cVar3.iz = true;
            return cVar3;
        }

        public ba.a a(int i, ba.a aVar, boolean z) {
            Object obj = null;
            Integer num = z ? 0 : null;
            if (z) {
                obj = a.LC;
            }
            aVar.a(num, obj, 0, -9223372036854775807L, 0, com.applovin.exoplayer2.h.a.a.NI, true);
            return aVar;
        }

        public int c(Object obj) {
            return obj == a.LC ? 0 : -1;
        }

        public Object b(int i) {
            return a.LC;
        }
    }
}
