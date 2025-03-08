package com.applovin.exoplayer2;

import com.applovin.exoplayer2.h.g;
import com.applovin.exoplayer2.h.n;
import com.applovin.exoplayer2.h.p;
import com.applovin.exoplayer2.h.x;
import com.applovin.exoplayer2.j.d;
import com.applovin.exoplayer2.j.j;
import com.applovin.exoplayer2.j.k;
import com.applovin.exoplayer2.k.b;
import com.applovin.exoplayer2.l.a;
import com.applovin.exoplayer2.l.q;

final class ad {
    private final j bC;
    public final Object ch;
    private final as[] ck;
    private final ah cs;
    private ad fA;
    private com.applovin.exoplayer2.h.ad fB = com.applovin.exoplayer2.h.ad.NG;
    private k fC;
    private long fD;
    public final n ft;
    public final x[] fu;
    public boolean fv;
    public boolean fw;
    public ae fx;
    public boolean fy;
    private final boolean[] fz;

    private boolean co() {
        return this.fA == null;
    }

    public long cd() {
        return this.fD;
    }

    public ad ci() {
        return this.fA;
    }

    public com.applovin.exoplayer2.h.ad cj() {
        return this.fB;
    }

    public k ck() {
        return this.fC;
    }

    public void s(long j) {
        this.fD = j;
    }

    public ad(as[] asVarArr, long j, j jVar, b bVar, ah ahVar, ae aeVar, k kVar) {
        this.ck = asVarArr;
        this.fD = j;
        this.bC = jVar;
        this.cs = ahVar;
        this.ch = aeVar.fE.gM;
        this.fx = aeVar;
        this.fC = kVar;
        this.fu = new x[asVarArr.length];
        this.fz = new boolean[asVarArr.length];
        this.ft = a(aeVar.fE, ahVar, bVar, aeVar.fF, aeVar.fG);
    }

    public long q(long j) {
        return j + cd();
    }

    public long r(long j) {
        return j - cd();
    }

    public long ce() {
        return this.fx.fF + this.fD;
    }

    public boolean cf() {
        return this.fv && (!this.fw || this.ft.cg() == Long.MIN_VALUE);
    }

    public long cg() {
        if (!this.fv) {
            return this.fx.fF;
        }
        long cg = this.fw ? this.ft.cg() : Long.MIN_VALUE;
        return cg == Long.MIN_VALUE ? this.fx.fH : cg;
    }

    public long ch() {
        if (!this.fv) {
            return 0;
        }
        return this.ft.ch();
    }

    public void a(float f, ba baVar) throws p {
        this.fv = true;
        this.fB = this.ft.cj();
        k b = b(f, baVar);
        long j = this.fx.fF;
        if (this.fx.fH != -9223372036854775807L && j >= this.fx.fH) {
            j = Math.max(0, this.fx.fH - 1);
        }
        long a = a(b, j, false);
        this.fD += this.fx.fF - a;
        this.fx = this.fx.v(a);
    }

    public void t(long j) {
        a.checkState(co());
        if (this.fv) {
            this.ft.t(r(j));
        }
    }

    public void u(long j) {
        a.checkState(co());
        this.ft.aR(r(j));
    }

    public k b(float f, ba baVar) throws p {
        k a = this.bC.a(this.ck, cj(), this.fx.fE, baVar);
        for (d dVar : a.VE) {
            if (dVar != null) {
                dVar.v(f);
            }
        }
        return a;
    }

    public long a(k kVar, long j, boolean z) {
        return a(kVar, j, z, new boolean[this.ck.length]);
    }

    public long a(k kVar, long j, boolean z, boolean[] zArr) {
        k kVar2 = kVar;
        int i = 0;
        while (true) {
            boolean z2 = true;
            if (i >= kVar2.fR) {
                break;
            }
            boolean[] zArr2 = this.fz;
            if (z || !kVar.a(this.fC, i)) {
                z2 = false;
            }
            zArr2[i] = z2;
            i++;
        }
        a(this.fu);
        cn();
        this.fC = kVar2;
        cm();
        long a = this.ft.a(kVar2.VE, this.fz, this.fu, zArr, j);
        b(this.fu);
        this.fw = false;
        int i2 = 0;
        while (true) {
            x[] xVarArr = this.fu;
            if (i2 >= xVarArr.length) {
                return a;
            }
            if (xVarArr[i2] != null) {
                a.checkState(kVar.eW(i2));
                if (this.ck[i2].M() != -2) {
                    this.fw = true;
                }
            } else {
                a.checkState(kVar2.VE[i2] == null);
            }
            i2++;
        }
    }

    public void release() {
        cn();
        a(this.cs, this.ft);
    }

    public void a(ad adVar) {
        if (adVar != this.fA) {
            cn();
            this.fA = adVar;
            cm();
        }
    }

    public void cl() {
        if (this.ft instanceof com.applovin.exoplayer2.h.d) {
            ((com.applovin.exoplayer2.h.d) this.ft).v(0, this.fx.fG == -9223372036854775807L ? Long.MIN_VALUE : this.fx.fG);
        }
    }

    private void cm() {
        if (co()) {
            for (int i = 0; i < this.fC.fR; i++) {
                boolean eW = this.fC.eW(i);
                d dVar = this.fC.VE[i];
                if (eW && dVar != null) {
                    dVar.enable();
                }
            }
        }
    }

    private void cn() {
        if (co()) {
            for (int i = 0; i < this.fC.fR; i++) {
                boolean eW = this.fC.eW(i);
                d dVar = this.fC.VE[i];
                if (eW && dVar != null) {
                    dVar.X();
                }
            }
        }
    }

    private void a(x[] xVarArr) {
        int i = 0;
        while (true) {
            as[] asVarArr = this.ck;
            if (i < asVarArr.length) {
                if (asVarArr[i].M() == -2) {
                    xVarArr[i] = null;
                }
                i++;
            } else {
                return;
            }
        }
    }

    private void b(x[] xVarArr) {
        int i = 0;
        while (true) {
            as[] asVarArr = this.ck;
            if (i < asVarArr.length) {
                if (asVarArr[i].M() == -2 && this.fC.eW(i)) {
                    xVarArr[i] = new g();
                }
                i++;
            } else {
                return;
            }
        }
    }

    private static n a(p.a aVar, ah ahVar, b bVar, long j, long j2) {
        n a = ahVar.a(aVar, bVar, j);
        return j2 != -9223372036854775807L ? new com.applovin.exoplayer2.h.d(a, true, 0, j2) : a;
    }

    private static void a(ah ahVar, n nVar) {
        try {
            if (nVar instanceof com.applovin.exoplayer2.h.d) {
                ahVar.f(((com.applovin.exoplayer2.h.d) nVar).ft);
            } else {
                ahVar.f(nVar);
            }
        } catch (RuntimeException e) {
            q.c("MediaPeriodHolder", "Period release failed.", e);
        }
    }
}
