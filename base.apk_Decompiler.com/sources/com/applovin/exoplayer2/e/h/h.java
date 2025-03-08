package com.applovin.exoplayer2.e.h;

import com.applovin.exoplayer2.e.i;
import com.applovin.exoplayer2.e.j;
import com.applovin.exoplayer2.e.u;
import com.applovin.exoplayer2.e.v;
import com.applovin.exoplayer2.e.x;
import com.applovin.exoplayer2.l.ai;
import com.applovin.exoplayer2.l.y;
import com.applovin.exoplayer2.v;
import java.io.IOException;

abstract class h {
    private final d BY = new d();
    private f BZ;
    private long Bs;
    private long Bx;
    private long Ca;
    private a Cb = new a();
    private long Cc;
    private boolean Cd;
    private boolean Ce;
    private int Z;
    private int dM;
    private j vG;
    private x vH;

    /* access modifiers changed from: protected */
    public abstract long G(y yVar);

    /* access modifiers changed from: protected */
    public abstract boolean a(y yVar, long j, a aVar) throws IOException;

    /* access modifiers changed from: protected */
    public void aG(long j) {
        this.Ca = j;
    }

    static class a {
        f BZ;
        v dU;

        a() {
        }
    }

    /* access modifiers changed from: package-private */
    public void a(j jVar, x xVar) {
        this.vG = jVar;
        this.vH = xVar;
        e(true);
    }

    /* access modifiers changed from: protected */
    public void e(boolean z) {
        if (z) {
            this.Cb = new a();
            this.Bs = 0;
            this.Z = 0;
        } else {
            this.Z = 1;
        }
        this.Bx = -1;
        this.Ca = 0;
    }

    /* access modifiers changed from: package-private */
    public final void o(long j, long j2) {
        this.BY.Y();
        if (j == 0) {
            e(!this.Cd);
        } else if (this.Z != 0) {
            this.Bx = aF(j2);
            ((f) ai.R(this.BZ)).aC(this.Bx);
            this.Z = 2;
        }
    }

    /* access modifiers changed from: package-private */
    public final int b(i iVar, u uVar) throws IOException {
        io();
        int i = this.Z;
        if (i == 0) {
            return V(iVar);
        }
        if (i == 1) {
            iVar.bH((int) this.Bs);
            this.Z = 2;
            return 0;
        } else if (i == 2) {
            ai.R(this.BZ);
            return i(iVar, uVar);
        } else if (i == 3) {
            return -1;
        } else {
            throw new IllegalStateException();
        }
    }

    private void io() {
        com.applovin.exoplayer2.l.a.N(this.vH);
        ai.R(this.vG);
    }

    private boolean U(i iVar) throws IOException {
        while (this.BY.S(iVar)) {
            this.Cc = iVar.ie() - this.Bs;
            if (!a(this.BY.iZ(), this.Bs, this.Cb)) {
                return true;
            }
            this.Bs = iVar.ie();
        }
        this.Z = 3;
        return false;
    }

    private int V(i iVar) throws IOException {
        if (!U(iVar)) {
            return -1;
        }
        this.dM = this.Cb.dU.dM;
        if (!this.Ce) {
            this.vH.j(this.Cb.dU);
            this.Ce = true;
        }
        if (this.Cb.BZ != null) {
            this.BZ = this.Cb.BZ;
        } else if (iVar.m1771if() == -1) {
            this.BZ = new b();
        } else {
            e iY = this.BY.iY();
            this.BZ = new a(this, this.Bs, iVar.m1771if(), (long) (iY.BT + iY.BU), iY.BN, (iY.bs & 4) != 0);
        }
        this.Z = 2;
        this.BY.ja();
        return 0;
    }

    private int i(i iVar, u uVar) throws IOException {
        i iVar2 = iVar;
        long N = this.BZ.N(iVar2);
        if (N >= 0) {
            uVar.uc = N;
            return 1;
        }
        if (N < -1) {
            aG(-(N + 2));
        }
        if (!this.Cd) {
            this.vG.a((com.applovin.exoplayer2.e.v) com.applovin.exoplayer2.l.a.N(this.BZ.iX()));
            this.Cd = true;
        }
        if (this.Cc > 0 || this.BY.S(iVar2)) {
            this.Cc = 0;
            y iZ = this.BY.iZ();
            long G = G(iZ);
            if (G >= 0) {
                long j = this.Ca;
                if (j + G >= this.Bx) {
                    long aE = aE(j);
                    this.vH.c(iZ, iZ.pk());
                    this.vH.a(aE, 1, iZ.pk(), 0, (x.a) null);
                    this.Bx = -1;
                }
            }
            this.Ca += G;
            return 0;
        }
        this.Z = 3;
        return -1;
    }

    /* access modifiers changed from: protected */
    public long aE(long j) {
        return (j * 1000000) / ((long) this.dM);
    }

    /* access modifiers changed from: protected */
    public long aF(long j) {
        return (((long) this.dM) * j) / 1000000;
    }

    private static final class b implements f {
        public long N(i iVar) {
            return -1;
        }

        public void aC(long j) {
        }

        private b() {
        }

        public com.applovin.exoplayer2.e.v iX() {
            return new v.b(-9223372036854775807L);
        }
    }
}
