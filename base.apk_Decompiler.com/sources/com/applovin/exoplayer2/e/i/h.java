package com.applovin.exoplayer2.e.i;

import com.applovin.exoplayer2.b.o;
import com.applovin.exoplayer2.d.e;
import com.applovin.exoplayer2.e.i.ad;
import com.applovin.exoplayer2.e.j;
import com.applovin.exoplayer2.e.x;
import com.applovin.exoplayer2.l.a;
import com.applovin.exoplayer2.l.y;
import com.applovin.exoplayer2.v;

public final class h implements j {
    private int Ai;
    private int CV;
    private final y Cs = new y(new byte[18]);
    private String Ct;
    private int Cu;
    private long Cw;
    private int Z = 0;
    private v dU;
    private final String dq;
    private long rJ = -9223372036854775807L;
    private x wl;

    public void e(long j, int i) {
        if (j != -9223372036854775807L) {
            this.rJ = j;
        }
    }

    public void jb() {
        this.Z = 0;
        this.Cu = 0;
        this.CV = 0;
        this.rJ = -9223372036854775807L;
    }

    public void jc() {
    }

    public h(String str) {
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
            if (i != 0) {
                if (i != 1) {
                    if (i == 2) {
                        int min = Math.min(yVar.pj(), this.Ai - this.Cu);
                        this.wl.c(yVar, min);
                        int i2 = this.Cu + min;
                        this.Cu = i2;
                        int i3 = this.Ai;
                        if (i2 == i3) {
                            long j = this.rJ;
                            if (j != -9223372036854775807L) {
                                this.wl.a(j, 1, i3, 0, (x.a) null);
                                this.rJ += this.Cw;
                            }
                            this.Z = 0;
                        }
                    } else {
                        throw new IllegalStateException();
                    }
                } else if (a(yVar, this.Cs.hO(), 18)) {
                    jd();
                    this.Cs.fx(0);
                    this.wl.c(this.Cs, 18);
                    this.Z = 2;
                }
            } else if (L(yVar)) {
                this.Z = 1;
            }
        }
    }

    private boolean a(y yVar, byte[] bArr, int i) {
        int min = Math.min(yVar.pj(), i - this.Cu);
        yVar.r(bArr, this.Cu, min);
        int i2 = this.Cu + min;
        this.Cu = i2;
        return i2 == i;
    }

    private boolean L(y yVar) {
        while (yVar.pj() > 0) {
            int i = this.CV << 8;
            this.CV = i;
            int po = i | yVar.po();
            this.CV = po;
            if (o.aF(po)) {
                byte[] hO = this.Cs.hO();
                int i2 = this.CV;
                hO[0] = (byte) ((i2 >> 24) & 255);
                hO[1] = (byte) ((i2 >> 16) & 255);
                hO[2] = (byte) ((i2 >> 8) & 255);
                hO[3] = (byte) (i2 & 255);
                this.Cu = 4;
                this.CV = 0;
                return true;
            }
        }
        return false;
    }

    private void jd() {
        byte[] hO = this.Cs.hO();
        if (this.dU == null) {
            v a = o.a(hO, this.Ct, this.dq, (e) null);
            this.dU = a;
            this.wl.j(a);
        }
        this.Ai = o.f(hO);
        this.Cw = (long) ((int) ((((long) o.e(hO)) * 1000000) / ((long) this.dU.dM)));
    }
}
