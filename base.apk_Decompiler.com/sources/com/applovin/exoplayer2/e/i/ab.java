package com.applovin.exoplayer2.e.i;

import com.applovin.exoplayer2.e.i;
import com.applovin.exoplayer2.e.u;
import com.applovin.exoplayer2.l.ag;
import com.applovin.exoplayer2.l.ai;
import com.applovin.exoplayer2.l.q;
import com.applovin.exoplayer2.l.y;
import java.io.IOException;

final class ab {
    private final y CB = new y();
    private boolean EV;
    private final ag Fo = new ag(0);
    private final int Fq;
    private boolean Fr;
    private boolean Fs;
    private long Ft = -9223372036854775807L;
    private long Fu = -9223372036854775807L;
    private long fH = -9223372036854775807L;

    public long dd() {
        return this.fH;
    }

    public boolean jt() {
        return this.EV;
    }

    public ag jv() {
        return this.Fo;
    }

    ab(int i) {
        this.Fq = i;
    }

    public int a(i iVar, u uVar, int i) throws IOException {
        if (i <= 0) {
            return Y(iVar);
        }
        if (!this.Fs) {
            return c(iVar, uVar, i);
        }
        if (this.Fu == -9223372036854775807L) {
            return Y(iVar);
        }
        if (!this.Fr) {
            return b(iVar, uVar, i);
        }
        long j = this.Ft;
        if (j == -9223372036854775807L) {
            return Y(iVar);
        }
        long br = this.Fo.br(this.Fu) - this.Fo.br(j);
        this.fH = br;
        if (br < 0) {
            q.h("TsDurationReader", "Invalid duration: " + this.fH + ". Using TIME_UNSET instead.");
            this.fH = -9223372036854775807L;
        }
        return Y(iVar);
    }

    private int Y(i iVar) {
        this.CB.I(ai.ada);
        this.EV = true;
        iVar.ic();
        return 0;
    }

    private int b(i iVar, u uVar, int i) throws IOException {
        int min = (int) Math.min((long) this.Fq, iVar.m1771if());
        long j = (long) 0;
        if (iVar.ie() != j) {
            uVar.uc = j;
            return 1;
        }
        this.CB.U(min);
        iVar.ic();
        iVar.c(this.CB.hO(), 0, min);
        this.Ft = q(this.CB, i);
        this.Fr = true;
        return 0;
    }

    private long q(y yVar, int i) {
        int pk = yVar.pk();
        for (int il = yVar.il(); il < pk; il++) {
            if (yVar.hO()[il] == 71) {
                long f = ae.f(yVar, il, i);
                if (f != -9223372036854775807L) {
                    return f;
                }
            }
        }
        return -9223372036854775807L;
    }

    private int c(i iVar, u uVar, int i) throws IOException {
        long j = iVar.m1771if();
        int min = (int) Math.min((long) this.Fq, j);
        long j2 = j - ((long) min);
        if (iVar.ie() != j2) {
            uVar.uc = j2;
            return 1;
        }
        this.CB.U(min);
        iVar.ic();
        iVar.c(this.CB.hO(), 0, min);
        this.Fu = r(this.CB, i);
        this.Fs = true;
        return 0;
    }

    private long r(y yVar, int i) {
        int il = yVar.il();
        int pk = yVar.pk();
        for (int i2 = pk - 188; i2 >= il; i2--) {
            if (ae.a(yVar.hO(), il, pk, i2)) {
                long f = ae.f(yVar, i2, i);
                if (f != -9223372036854775807L) {
                    return f;
                }
            }
        }
        return -9223372036854775807L;
    }
}
