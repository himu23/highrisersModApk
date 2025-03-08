package com.applovin.exoplayer2.e.i;

import com.applovin.exoplayer2.e.i.ad;
import com.applovin.exoplayer2.e.j;
import com.applovin.exoplayer2.e.x;
import com.applovin.exoplayer2.l.a;
import com.applovin.exoplayer2.l.q;
import com.applovin.exoplayer2.l.y;
import com.applovin.exoplayer2.v;

public final class o implements j {
    private int Ai;
    private boolean CY;
    private long Da = -9223372036854775807L;
    private final y Et = new y(10);
    private x wl;
    private int xI;

    public void e(long j, int i) {
        if ((i & 4) != 0) {
            this.CY = true;
            if (j != -9223372036854775807L) {
                this.Da = j;
            }
            this.Ai = 0;
            this.xI = 0;
        }
    }

    public void jb() {
        this.CY = false;
        this.Da = -9223372036854775807L;
    }

    public void a(j jVar, ad.d dVar) {
        dVar.jy();
        x y = jVar.y(dVar.jz(), 5);
        this.wl = y;
        y.j(new v.a().g(dVar.jA()).m("application/id3").bT());
    }

    public void K(y yVar) {
        a.N(this.wl);
        if (this.CY) {
            int pj = yVar.pj();
            int i = this.xI;
            if (i < 10) {
                int min = Math.min(pj, 10 - i);
                System.arraycopy(yVar.hO(), yVar.il(), this.Et.hO(), this.xI, min);
                if (this.xI + min == 10) {
                    this.Et.fx(0);
                    if (73 == this.Et.po() && 68 == this.Et.po() && 51 == this.Et.po()) {
                        this.Et.fz(3);
                        this.Ai = this.Et.pC() + 10;
                    } else {
                        q.h("Id3Reader", "Discarding invalid ID3 tag");
                        this.CY = false;
                        return;
                    }
                }
            }
            int min2 = Math.min(pj, this.Ai - this.xI);
            this.wl.c(yVar, min2);
            this.xI += min2;
        }
    }

    public void jc() {
        int i;
        a.N(this.wl);
        if (this.CY && (i = this.Ai) != 0 && this.xI == i) {
            long j = this.Da;
            if (j != -9223372036854775807L) {
                this.wl.a(j, 1, i, 0, (x.a) null);
            }
            this.CY = false;
        }
    }
}
