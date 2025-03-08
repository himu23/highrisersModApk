package com.applovin.exoplayer2.e.i;

import com.applovin.exoplayer2.e.i.ad;
import com.applovin.exoplayer2.e.j;
import com.applovin.exoplayer2.e.x;
import com.applovin.exoplayer2.l.a;
import com.applovin.exoplayer2.l.ag;
import com.applovin.exoplayer2.l.ai;
import com.applovin.exoplayer2.l.y;
import com.applovin.exoplayer2.v;

public final class s implements x {
    private v dU;
    private x wl;
    private ag zS;

    public s(String str) {
        this.dU = new v.a().m(str).bT();
    }

    public void a(ag agVar, j jVar, ad.d dVar) {
        this.zS = agVar;
        dVar.jy();
        x y = jVar.y(dVar.jz(), 5);
        this.wl = y;
        y.j(this.dU);
    }

    public void K(y yVar) {
        io();
        long pT = this.zS.pT();
        long pU = this.zS.pU();
        if (pT != -9223372036854775807L && pU != -9223372036854775807L) {
            if (pU != this.dU.dD) {
                v bT = this.dU.bR().p(pU).bT();
                this.dU = bT;
                this.wl.j(bT);
            }
            int pj = yVar.pj();
            this.wl.c(yVar, pj);
            this.wl.a(pT, 1, pj, 0, (x.a) null);
        }
    }

    private void io() {
        a.N(this.zS);
        ai.R(this.wl);
    }
}
