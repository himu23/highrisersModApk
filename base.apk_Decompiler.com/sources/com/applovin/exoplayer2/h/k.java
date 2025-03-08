package com.applovin.exoplayer2.h;

import com.applovin.exoplayer2.av;
import com.applovin.exoplayer2.h.n;
import com.applovin.exoplayer2.h.p;
import com.applovin.exoplayer2.j.d;
import com.applovin.exoplayer2.k.b;
import com.applovin.exoplayer2.l.ai;
import java.io.IOException;

public final class k implements n, n.a {
    private n.a KS;
    private final long Lt;
    private final b Lu;
    private a Lv;
    private boolean Lw;
    private long Lx = -9223372036854775807L;
    public final p.a fE;
    private n ft;
    private p gf;

    public interface a {
        void a(p.a aVar, IOException iOException);

        void h(p.a aVar);
    }

    private long aU(long j) {
        long j2 = this.Lx;
        return j2 != -9223372036854775807L ? j2 : j;
    }

    public void aT(long j) {
        this.Lx = j;
    }

    public long kW() {
        return this.Lt;
    }

    public long kX() {
        return this.Lx;
    }

    public k(p.a aVar, b bVar, long j) {
        this.fE = aVar;
        this.Lu = bVar;
        this.Lt = j;
    }

    public void a(p pVar) {
        com.applovin.exoplayer2.l.a.checkState(this.gf == null);
        this.gf = pVar;
    }

    public void g(p.a aVar) {
        long aU = aU(this.Lt);
        n a2 = ((p) com.applovin.exoplayer2.l.a.checkNotNull(this.gf)).a(aVar, this.Lu, aU);
        this.ft = a2;
        if (this.KS != null) {
            a2.a((n.a) this, aU);
        }
    }

    public void kY() {
        if (this.ft != null) {
            ((p) com.applovin.exoplayer2.l.a.checkNotNull(this.gf)).f(this.ft);
        }
    }

    public void a(n.a aVar, long j) {
        this.KS = aVar;
        n nVar = this.ft;
        if (nVar != null) {
            nVar.a((n.a) this, aU(this.Lt));
        }
    }

    public void kM() throws IOException {
        try {
            n nVar = this.ft;
            if (nVar != null) {
                nVar.kM();
                return;
            }
            p pVar = this.gf;
            if (pVar != null) {
                pVar.kS();
            }
        } catch (IOException e) {
            a aVar = this.Lv;
            if (aVar == null) {
                throw e;
            } else if (!this.Lw) {
                this.Lw = true;
                aVar.a(this.fE, e);
            }
        }
    }

    public ad cj() {
        return ((n) ai.R(this.ft)).cj();
    }

    public long a(d[] dVarArr, boolean[] zArr, x[] xVarArr, boolean[] zArr2, long j) {
        long j2;
        long j3 = this.Lx;
        if (j3 == -9223372036854775807L || j != this.Lt) {
            j2 = j;
        } else {
            this.Lx = -9223372036854775807L;
            j2 = j3;
        }
        return ((n) ai.R(this.ft)).a(dVarArr, zArr, xVarArr, zArr2, j2);
    }

    public void d(long j, boolean z) {
        ((n) ai.R(this.ft)).d(j, z);
    }

    public long kN() {
        return ((n) ai.R(this.ft)).kN();
    }

    public long cg() {
        return ((n) ai.R(this.ft)).cg();
    }

    public long aQ(long j) {
        return ((n) ai.R(this.ft)).aQ(j);
    }

    public long a(long j, av avVar) {
        return ((n) ai.R(this.ft)).a(j, avVar);
    }

    public long ch() {
        return ((n) ai.R(this.ft)).ch();
    }

    public void t(long j) {
        ((n) ai.R(this.ft)).t(j);
    }

    public boolean aR(long j) {
        n nVar = this.ft;
        return nVar != null && nVar.aR(j);
    }

    public boolean kO() {
        n nVar = this.ft;
        return nVar != null && nVar.kO();
    }

    /* renamed from: b */
    public void a(n nVar) {
        ((n.a) ai.R(this.KS)).a(this);
    }

    public void a(n nVar) {
        ((n.a) ai.R(this.KS)).a(this);
        a aVar = this.Lv;
        if (aVar != null) {
            aVar.h(this.fE);
        }
    }
}
