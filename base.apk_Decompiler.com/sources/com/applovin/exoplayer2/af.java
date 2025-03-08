package com.applovin.exoplayer2;

import android.os.Handler;
import android.util.Pair;
import com.applovin.exoplayer2.a.a;
import com.applovin.exoplayer2.ba;
import com.applovin.exoplayer2.common.a.s;
import com.applovin.exoplayer2.h.n;
import com.applovin.exoplayer2.h.p;
import com.applovin.exoplayer2.j.j;
import com.applovin.exoplayer2.j.k;
import com.applovin.exoplayer2.k.b;
import java.util.List;

final class af {
    private final ba.c U = new ba.c();
    private final ba.a bI = new ba.a();
    private final a bM;
    private int bS;
    private boolean bT;
    private final Handler fM;
    private long fN;
    private ad fO;
    private ad fP;
    private ad fQ;
    private int fR;
    private Object fS;
    private long fT;

    private boolean f(long j, long j2) {
        return j == -9223372036854775807L || j == j2;
    }

    public ad cq() {
        return this.fQ;
    }

    public ad cr() {
        return this.fO;
    }

    public ad cs() {
        return this.fP;
    }

    public af(a aVar, Handler handler) {
        this.bM = aVar;
        this.fM = handler;
    }

    public boolean a(ba baVar, int i) {
        this.bS = i;
        return b(baVar);
    }

    public boolean b(ba baVar, boolean z) {
        this.bT = z;
        return b(baVar);
    }

    public boolean e(n nVar) {
        ad adVar = this.fQ;
        return adVar != null && adVar.ft == nVar;
    }

    public void t(long j) {
        ad adVar = this.fQ;
        if (adVar != null) {
            adVar.t(j);
        }
    }

    public boolean cp() {
        ad adVar = this.fQ;
        return adVar == null || (!adVar.fx.fL && this.fQ.cf() && this.fQ.fx.fH != -9223372036854775807L && this.fR < 100);
    }

    public ae a(long j, al alVar) {
        if (this.fQ == null) {
            return e(alVar);
        }
        return a(alVar.ci, this.fQ, j);
    }

    public ad a(as[] asVarArr, j jVar, b bVar, ah ahVar, ae aeVar, k kVar) {
        long j;
        ae aeVar2 = aeVar;
        ad adVar = this.fQ;
        if (adVar == null) {
            j = (!aeVar2.fE.la() || aeVar2.de == -9223372036854775807L) ? 0 : aeVar2.de;
        } else {
            j = (adVar.cd() + this.fQ.fx.fH) - aeVar2.fF;
        }
        ad adVar2 = new ad(asVarArr, j, jVar, bVar, ahVar, aeVar, kVar);
        ad adVar3 = this.fQ;
        if (adVar3 != null) {
            adVar3.a(adVar2);
        } else {
            this.fO = adVar2;
            this.fP = adVar2;
        }
        this.fS = null;
        this.fQ = adVar2;
        this.fR++;
        cv();
        return adVar2;
    }

    public ad ct() {
        ad adVar = this.fP;
        com.applovin.exoplayer2.l.a.checkState((adVar == null || adVar.ci() == null) ? false : true);
        this.fP = this.fP.ci();
        cv();
        return this.fP;
    }

    public ad cu() {
        ad adVar = this.fO;
        if (adVar == null) {
            return null;
        }
        if (adVar == this.fP) {
            this.fP = adVar.ci();
        }
        this.fO.release();
        int i = this.fR - 1;
        this.fR = i;
        if (i == 0) {
            this.fQ = null;
            this.fS = this.fO.ch;
            this.fT = this.fO.fx.fE.LL;
        }
        this.fO = this.fO.ci();
        cv();
        return this.fO;
    }

    public boolean b(ad adVar) {
        boolean z = false;
        com.applovin.exoplayer2.l.a.checkState(adVar != null);
        if (adVar.equals(this.fQ)) {
            return false;
        }
        this.fQ = adVar;
        while (adVar.ci() != null) {
            adVar = adVar.ci();
            if (adVar == this.fP) {
                this.fP = this.fO;
                z = true;
            }
            adVar.release();
            this.fR--;
        }
        this.fQ.a((ad) null);
        cv();
        return z;
    }

    public void clear() {
        if (this.fR != 0) {
            ad adVar = (ad) com.applovin.exoplayer2.l.a.N(this.fO);
            this.fS = adVar.ch;
            this.fT = adVar.fx.fE.LL;
            while (adVar != null) {
                adVar.release();
                adVar = adVar.ci();
            }
            this.fO = null;
            this.fQ = null;
            this.fP = null;
            this.fR = 0;
            cv();
        }
    }

    public boolean a(ba baVar, long j, long j2) {
        ae aeVar;
        long j3;
        ad adVar = this.fO;
        ad adVar2 = null;
        while (adVar != null) {
            ae aeVar2 = adVar.fx;
            if (adVar2 == null) {
                aeVar = a(baVar, aeVar2);
            } else {
                ae a = a(baVar, adVar2, j);
                if (a == null) {
                    return !b(adVar2);
                }
                if (!a(aeVar2, a)) {
                    return !b(adVar2);
                }
                aeVar = a;
            }
            adVar.fx = aeVar.w(aeVar2.de);
            if (!f(aeVar2.fH, aeVar.fH)) {
                adVar.cl();
                if (aeVar.fH == -9223372036854775807L) {
                    j3 = Long.MAX_VALUE;
                } else {
                    j3 = adVar.q(aeVar.fH);
                }
                boolean z = adVar == this.fP && !adVar.fx.fI && (j2 == Long.MIN_VALUE || j2 >= j3);
                if (b(adVar) || z) {
                    return false;
                }
                return true;
            }
            adVar2 = adVar;
            adVar = adVar.ci();
        }
        return true;
    }

    /* JADX WARNING: Removed duplicated region for block: B:18:0x0064  */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x006e  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.applovin.exoplayer2.ae a(com.applovin.exoplayer2.ba r19, com.applovin.exoplayer2.ae r20) {
        /*
            r18 = this;
            r0 = r18
            r1 = r19
            r2 = r20
            com.applovin.exoplayer2.h.p$a r3 = r2.fE
            boolean r12 = r0.a(r3)
            boolean r13 = r0.b((com.applovin.exoplayer2.ba) r1, (com.applovin.exoplayer2.h.p.a) r3)
            boolean r14 = r0.a((com.applovin.exoplayer2.ba) r1, (com.applovin.exoplayer2.h.p.a) r3, (boolean) r12)
            com.applovin.exoplayer2.h.p$a r4 = r2.fE
            java.lang.Object r4 = r4.gM
            com.applovin.exoplayer2.ba$a r5 = r0.bI
            r1.a((java.lang.Object) r4, (com.applovin.exoplayer2.ba.a) r5)
            boolean r1 = r3.la()
            r4 = -1
            r5 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            if (r1 != 0) goto L_0x0037
            int r1 = r3.LM
            if (r1 != r4) goto L_0x002e
            goto L_0x0037
        L_0x002e:
            com.applovin.exoplayer2.ba$a r1 = r0.bI
            int r7 = r3.LM
            long r7 = r1.al(r7)
            goto L_0x0038
        L_0x0037:
            r7 = r5
        L_0x0038:
            boolean r1 = r3.la()
            if (r1 == 0) goto L_0x004a
            com.applovin.exoplayer2.ba$a r1 = r0.bI
            int r5 = r3.gP
            int r6 = r3.gQ
            long r5 = r1.i(r5, r6)
        L_0x0048:
            r9 = r5
            goto L_0x005e
        L_0x004a:
            int r1 = (r7 > r5 ? 1 : (r7 == r5 ? 0 : -1))
            if (r1 == 0) goto L_0x0057
            r5 = -9223372036854775808
            int r1 = (r7 > r5 ? 1 : (r7 == r5 ? 0 : -1))
            if (r1 != 0) goto L_0x0055
            goto L_0x0057
        L_0x0055:
            r9 = r7
            goto L_0x005e
        L_0x0057:
            com.applovin.exoplayer2.ba$a r1 = r0.bI
            long r5 = r1.dd()
            goto L_0x0048
        L_0x005e:
            boolean r1 = r3.la()
            if (r1 == 0) goto L_0x006e
            com.applovin.exoplayer2.ba$a r1 = r0.bI
            int r4 = r3.gP
            boolean r1 = r1.ap(r4)
            r11 = r1
            goto L_0x0081
        L_0x006e:
            int r1 = r3.LM
            if (r1 == r4) goto L_0x007f
            com.applovin.exoplayer2.ba$a r1 = r0.bI
            int r4 = r3.LM
            boolean r1 = r1.ap(r4)
            if (r1 == 0) goto L_0x007f
            r1 = 1
            r11 = 1
            goto L_0x0081
        L_0x007f:
            r1 = 0
            r11 = 0
        L_0x0081:
            com.applovin.exoplayer2.ae r15 = new com.applovin.exoplayer2.ae
            long r4 = r2.fF
            long r1 = r2.de
            r16 = r1
            r1 = r15
            r2 = r3
            r3 = r4
            r5 = r16
            r1.<init>(r2, r3, r5, r7, r9, r11, r12, r13, r14)
            return r15
        */
        throw new UnsupportedOperationException("Method not decompiled: com.applovin.exoplayer2.af.a(com.applovin.exoplayer2.ba, com.applovin.exoplayer2.ae):com.applovin.exoplayer2.ae");
    }

    public p.a b(ba baVar, Object obj, long j) {
        return a(baVar, obj, j, a(baVar, obj), this.bI);
    }

    private void cv() {
        p.a aVar;
        if (this.bM != null) {
            s.a gc = s.gc();
            for (ad adVar = this.fO; adVar != null; adVar = adVar.ci()) {
                gc.t(adVar.fx.fE);
            }
            ad adVar2 = this.fP;
            if (adVar2 == null) {
                aVar = null;
            } else {
                aVar = adVar2.fx.fE;
            }
            this.fM.post(new af$$ExternalSyntheticLambda0(this, gc, aVar));
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void a(s.a aVar, p.a aVar2) {
        this.bM.a((List<p.a>) aVar.gd(), aVar2);
    }

    private static p.a a(ba baVar, Object obj, long j, long j2, ba.a aVar) {
        baVar.a(obj, aVar);
        int A = aVar.A(j);
        if (A == -1) {
            return new p.a(obj, j2, aVar.B(j));
        }
        return new p.a(obj, A, aVar.am(A), j2);
    }

    private long a(ba baVar, Object obj) {
        int c;
        int i = baVar.a(obj, this.bI).cN;
        Object obj2 = this.fS;
        if (obj2 != null && (c = baVar.c(obj2)) != -1 && baVar.a(c, this.bI).cN == i) {
            return this.fT;
        }
        for (ad adVar = this.fO; adVar != null; adVar = adVar.ci()) {
            if (adVar.ch.equals(obj)) {
                return adVar.fx.fE.LL;
            }
        }
        for (ad adVar2 = this.fO; adVar2 != null; adVar2 = adVar2.ci()) {
            int c2 = baVar.c(adVar2.ch);
            if (c2 != -1 && baVar.a(c2, this.bI).cN == i) {
                return adVar2.fx.fE.LL;
            }
        }
        long j = this.fN;
        this.fN = 1 + j;
        if (this.fO == null) {
            this.fS = obj;
            this.fT = j;
        }
        return j;
    }

    private boolean a(ae aeVar, ae aeVar2) {
        return aeVar.fF == aeVar2.fF && aeVar.fE.equals(aeVar2.fE);
    }

    private boolean b(ba baVar) {
        ad adVar = this.fO;
        if (adVar == null) {
            return true;
        }
        int c = baVar.c(adVar.ch);
        while (true) {
            c = baVar.a(c, this.bI, this.U, this.bS, this.bT);
            while (adVar.ci() != null && !adVar.fx.fJ) {
                adVar = adVar.ci();
            }
            ad ci = adVar.ci();
            if (c == -1 || ci == null || baVar.c(ci.ch) != c) {
                boolean b = b(adVar);
                adVar.fx = a(baVar, adVar.fx);
            } else {
                adVar = ci;
            }
        }
        boolean b2 = b(adVar);
        adVar.fx = a(baVar, adVar.fx);
        return !b2;
    }

    private ae e(al alVar) {
        return a(alVar.ci, alVar.dc, alVar.de, alVar.cO);
    }

    private ae a(ba baVar, ad adVar, long j) {
        long j2;
        ba baVar2 = baVar;
        ae aeVar = adVar.fx;
        long cd = (adVar.cd() + aeVar.fH) - j;
        if (aeVar.fJ) {
            long j3 = 0;
            int a = baVar.a(baVar2.c(aeVar.fE.gM), this.bI, this.U, this.bS, this.bT);
            if (a == -1) {
                return null;
            }
            int i = baVar2.a(a, this.bI, true).cN;
            Object obj = this.bI.ch;
            long j4 = aeVar.fE.LL;
            if (baVar2.a(i, this.U).iQ == a) {
                Pair<Object, Long> a2 = baVar.a(this.U, this.bI, i, -9223372036854775807L, Math.max(0, cd));
                if (a2 == null) {
                    return null;
                }
                obj = a2.first;
                long longValue = ((Long) a2.second).longValue();
                ad ci = adVar.ci();
                if (ci == null || !ci.ch.equals(obj)) {
                    j4 = this.fN;
                    this.fN = 1 + j4;
                } else {
                    j4 = ci.fx.fE.LL;
                }
                j2 = longValue;
                j3 = -9223372036854775807L;
            } else {
                j2 = 0;
            }
            return a(baVar, a(baVar, obj, j2, j4, this.bI), j3, j2);
        }
        p.a aVar = aeVar.fE;
        baVar2.a(aVar.gM, this.bI);
        if (aVar.la()) {
            int i2 = aVar.gP;
            int ao = this.bI.ao(i2);
            if (ao == -1) {
                return null;
            }
            int h = this.bI.h(i2, aVar.gQ);
            if (h < ao) {
                return a(baVar, aVar.gM, i2, h, aeVar.de, aVar.LL);
            }
            long j5 = aeVar.de;
            if (j5 == -9223372036854775807L) {
                ba.c cVar = this.U;
                ba.a aVar2 = this.bI;
                Pair<Object, Long> a3 = baVar.a(cVar, aVar2, aVar2.cN, -9223372036854775807L, Math.max(0, cd));
                if (a3 == null) {
                    return null;
                }
                j5 = ((Long) a3.second).longValue();
            }
            return a(baVar, aVar.gM, Math.max(a(baVar2, aVar.gM, aVar.gP), j5), aeVar.de, aVar.LL);
        }
        int am = this.bI.am(aVar.LM);
        if (am == this.bI.ao(aVar.LM)) {
            return a(baVar, aVar.gM, a(baVar2, aVar.gM, aVar.LM), aeVar.fH, aVar.LL);
        }
        return a(baVar, aVar.gM, aVar.LM, am, aeVar.fH, aVar.LL);
    }

    private ae a(ba baVar, p.a aVar, long j, long j2) {
        p.a aVar2 = aVar;
        ba baVar2 = baVar;
        baVar.a(aVar2.gM, this.bI);
        if (aVar.la()) {
            return a(baVar, aVar2.gM, aVar2.gP, aVar2.gQ, j, aVar2.LL);
        }
        return a(baVar, aVar2.gM, j2, j, aVar2.LL);
    }

    private ae a(ba baVar, Object obj, int i, int i2, long j, long j2) {
        int i3 = i2;
        p.a aVar = new p.a(obj, i, i3, j2);
        long i4 = baVar.a(aVar.gM, this.bI).i(aVar.gP, aVar.gQ);
        long di = i3 == this.bI.am(i) ? this.bI.di() : 0;
        return new ae(aVar, (i4 == -9223372036854775807L || di < i4) ? di : Math.max(0, i4 - 1), j, -9223372036854775807L, i4, this.bI.ap(aVar.gP), false, false, false);
    }

    private ae a(ba baVar, Object obj, long j, long j2, long j3) {
        long j4;
        ba baVar2 = baVar;
        Object obj2 = obj;
        long j5 = j;
        baVar2.a(obj2, this.bI);
        int B = this.bI.B(j5);
        p.a aVar = new p.a(obj2, j3, B);
        boolean a = a(aVar);
        boolean b = b(baVar2, aVar);
        boolean a2 = a(baVar2, aVar, a);
        boolean z = B != -1 && this.bI.ap(B);
        long al = B != -1 ? this.bI.al(B) : -9223372036854775807L;
        if (al == -9223372036854775807L || al == Long.MIN_VALUE) {
            j4 = this.bI.fH;
        } else {
            j4 = al;
        }
        if (j4 != -9223372036854775807L && j5 >= j4) {
            j5 = Math.max(0, j4 - 1);
        }
        return new ae(aVar, j5, j2, al, j4, z, a, b, a2);
    }

    private boolean a(p.a aVar) {
        return !aVar.la() && aVar.LM == -1;
    }

    private boolean b(ba baVar, p.a aVar) {
        if (!a(aVar)) {
            return false;
        }
        int i = baVar.a(aVar.gM, this.bI).cN;
        if (baVar.a(i, this.U).iR == baVar.c(aVar.gM)) {
            return true;
        }
        return false;
    }

    private boolean a(ba baVar, p.a aVar, boolean z) {
        int c = baVar.c(aVar.gM);
        if (!baVar.a(baVar.a(c, this.bI).cN, this.U).iN) {
            return baVar.b(c, this.bI, this.U, this.bS, this.bT) && z;
        }
    }

    private long a(ba baVar, Object obj, int i) {
        baVar.a(obj, this.bI);
        long al = this.bI.al(i);
        if (al == Long.MIN_VALUE) {
            return this.bI.fH;
        }
        return al + this.bI.aq(i);
    }
}
