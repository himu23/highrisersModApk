package com.applovin.exoplayer2.e.i;

import com.applovin.exoplayer2.e.i.ad;
import com.applovin.exoplayer2.e.j;
import com.applovin.exoplayer2.e.x;
import com.applovin.exoplayer2.l.y;
import com.applovin.exoplayer2.v;
import java.util.Collections;
import java.util.List;

public final class i implements j {
    private final List<ad.a> CW;
    private final x[] CX;
    private boolean CY;
    private int CZ;
    private long Da = -9223372036854775807L;
    private int xJ;

    public void e(long j, int i) {
        if ((i & 4) != 0) {
            this.CY = true;
            if (j != -9223372036854775807L) {
                this.Da = j;
            }
            this.xJ = 0;
            this.CZ = 2;
        }
    }

    public void jb() {
        this.CY = false;
        this.Da = -9223372036854775807L;
    }

    public i(List<ad.a> list) {
        this.CW = list;
        this.CX = new x[list.size()];
    }

    public void a(j jVar, ad.d dVar) {
        for (int i = 0; i < this.CX.length; i++) {
            ad.a aVar = this.CW.get(i);
            dVar.jy();
            x y = jVar.y(dVar.jz(), 3);
            y.j(new v.a().g(dVar.jA()).m("application/dvbsubs").c((List<byte[]>) Collections.singletonList(aVar.FQ)).j(aVar.dq).bT());
            this.CX[i] = y;
        }
    }

    public void jc() {
        if (this.CY) {
            if (this.Da != -9223372036854775807L) {
                for (x a : this.CX) {
                    a.a(this.Da, 1, this.xJ, 0, (x.a) null);
                }
            }
            this.CY = false;
        }
    }

    public void K(y yVar) {
        if (!this.CY) {
            return;
        }
        if (this.CZ != 2 || o(yVar, 32)) {
            if (this.CZ != 1 || o(yVar, 0)) {
                int il = yVar.il();
                int pj = yVar.pj();
                for (x c : this.CX) {
                    yVar.fx(il);
                    c.c(yVar, pj);
                }
                this.xJ += pj;
            }
        }
    }

    private boolean o(y yVar, int i) {
        if (yVar.pj() == 0) {
            return false;
        }
        if (yVar.po() != i) {
            this.CY = false;
        }
        this.CZ--;
        return this.CY;
    }
}
