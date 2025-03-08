package com.applovin.exoplayer2.e.i;

import com.applovin.exoplayer2.b.r;
import com.applovin.exoplayer2.e.i.ad;
import com.applovin.exoplayer2.e.j;
import com.applovin.exoplayer2.e.x;
import com.applovin.exoplayer2.l.a;
import com.applovin.exoplayer2.l.y;
import com.applovin.exoplayer2.v;
import kotlin.UByte;

public final class q implements j {
    private String Ct;
    private long Dj;
    private final y ED;
    private final r.a EE;
    private int EF;
    private boolean EG;
    private int Z;
    private final String dq;
    private int jz;
    private long rJ;
    private boolean vJ;
    private x wl;

    public void e(long j, int i) {
        if (j != -9223372036854775807L) {
            this.rJ = j;
        }
    }

    public void jb() {
        this.Z = 0;
        this.EF = 0;
        this.EG = false;
        this.rJ = -9223372036854775807L;
    }

    public void jc() {
    }

    public q() {
        this((String) null);
    }

    public q(String str) {
        this.Z = 0;
        y yVar = new y(4);
        this.ED = yVar;
        yVar.hO()[0] = -1;
        this.EE = new r.a();
        this.rJ = -9223372036854775807L;
        this.dq = str;
    }

    public void a(j jVar, ad.d dVar) {
        dVar.jy();
        this.Ct = dVar.jA();
        this.wl = jVar.y(dVar.jz(), 1);
    }

    public void K(y yVar) {
        a.N(this.wl);
        while (yVar.pj() > 0) {
            int i = this.Z;
            if (i == 0) {
                P(yVar);
            } else if (i == 1) {
                Q(yVar);
            } else if (i == 2) {
                R(yVar);
            } else {
                throw new IllegalStateException();
            }
        }
    }

    private void P(y yVar) {
        byte[] hO = yVar.hO();
        int pk = yVar.pk();
        for (int il = yVar.il(); il < pk; il++) {
            byte b = hO[il];
            boolean z = (b & UByte.MAX_VALUE) == 255;
            boolean z2 = this.EG && (b & 224) == 224;
            this.EG = z;
            if (z2) {
                yVar.fx(il + 1);
                this.EG = false;
                this.ED.hO()[1] = hO[il];
                this.EF = 2;
                this.Z = 1;
                return;
            }
        }
        yVar.fx(pk);
    }

    private void Q(y yVar) {
        int min = Math.min(yVar.pj(), 4 - this.EF);
        yVar.r(this.ED.hO(), this.EF, min);
        int i = this.EF + min;
        this.EF = i;
        if (i >= 4) {
            this.ED.fx(0);
            if (!this.EE.aK(this.ED.px())) {
                this.EF = 0;
                this.Z = 1;
                return;
            }
            this.jz = this.EE.jz;
            if (!this.vJ) {
                this.Dj = (((long) this.EE.mJ) * 1000000) / ((long) this.EE.dM);
                this.wl.j(new v.a().g(this.Ct).m(this.EE.eg).I(4096).N(this.EE.mI).O(this.EE.dM).j(this.dq).bT());
                this.vJ = true;
            }
            this.ED.fx(0);
            this.wl.c(this.ED, 4);
            this.Z = 2;
        }
    }

    private void R(y yVar) {
        int min = Math.min(yVar.pj(), this.jz - this.EF);
        this.wl.c(yVar, min);
        int i = this.EF + min;
        this.EF = i;
        int i2 = this.jz;
        if (i >= i2) {
            long j = this.rJ;
            if (j != -9223372036854775807L) {
                this.wl.a(j, 1, i2, 0, (x.a) null);
                this.rJ += this.Dj;
            }
            this.EF = 0;
            this.Z = 0;
        }
    }
}
