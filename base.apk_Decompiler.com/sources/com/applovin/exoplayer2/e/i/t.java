package com.applovin.exoplayer2.e.i;

import com.applovin.exoplayer2.ai;
import com.applovin.exoplayer2.e.i.ad;
import com.applovin.exoplayer2.e.j;
import com.applovin.exoplayer2.l.a;
import com.applovin.exoplayer2.l.ag;
import com.applovin.exoplayer2.l.q;
import com.applovin.exoplayer2.l.x;
import com.applovin.exoplayer2.l.y;

public final class t implements ad {
    private int Cu;
    private final j EL;
    private final x EN = new x(new byte[10]);
    private boolean EO;
    private boolean EP;
    private boolean EQ;
    private int ER;
    private int ES;
    private boolean ET;
    private int Z = 0;
    private long rJ;
    private ag zS;

    private void v(int i) {
        this.Z = i;
        this.Cu = 0;
    }

    public t(j jVar) {
        this.EL = jVar;
    }

    public void a(ag agVar, j jVar, ad.d dVar) {
        this.zS = agVar;
        this.EL.a(jVar, dVar);
    }

    public final void jb() {
        this.Z = 0;
        this.Cu = 0;
        this.EQ = false;
        this.EL.jb();
    }

    public final void p(y yVar, int i) throws ai {
        a.N(this.zS);
        if ((i & 1) != 0) {
            int i2 = this.Z;
            if (!(i2 == 0 || i2 == 1)) {
                if (i2 == 2) {
                    q.h("PesReader", "Unexpected start indicator reading extended header");
                } else if (i2 == 3) {
                    if (this.ES != -1) {
                        q.h("PesReader", "Unexpected start indicator: expected " + this.ES + " more bytes");
                    }
                    this.EL.jc();
                } else {
                    throw new IllegalStateException();
                }
            }
            v(1);
        }
        while (yVar.pj() > 0) {
            int i3 = this.Z;
            if (i3 != 0) {
                int i4 = 0;
                if (i3 != 1) {
                    if (i3 == 2) {
                        if (a(yVar, this.EN.tf, Math.min(10, this.ER)) && a(yVar, (byte[]) null, this.ER)) {
                            js();
                            if (this.ET) {
                                i4 = 4;
                            }
                            i |= i4;
                            this.EL.e(this.rJ, i);
                            v(3);
                        }
                    } else if (i3 == 3) {
                        int pj = yVar.pj();
                        int i5 = this.ES;
                        if (i5 != -1) {
                            i4 = pj - i5;
                        }
                        if (i4 > 0) {
                            pj -= i4;
                            yVar.fA(yVar.il() + pj);
                        }
                        this.EL.K(yVar);
                        int i6 = this.ES;
                        if (i6 != -1) {
                            int i7 = i6 - pj;
                            this.ES = i7;
                            if (i7 == 0) {
                                this.EL.jc();
                                v(1);
                            }
                        }
                    } else {
                        throw new IllegalStateException();
                    }
                } else if (a(yVar, this.EN.tf, 9)) {
                    if (jr()) {
                        i4 = 2;
                    }
                    v(i4);
                }
            } else {
                yVar.fz(yVar.pj());
            }
        }
    }

    private boolean a(y yVar, byte[] bArr, int i) {
        int min = Math.min(yVar.pj(), i - this.Cu);
        if (min <= 0) {
            return true;
        }
        if (bArr == null) {
            yVar.fz(min);
        } else {
            yVar.r(bArr, this.Cu, min);
        }
        int i2 = this.Cu + min;
        this.Cu = i2;
        if (i2 == i) {
            return true;
        }
        return false;
    }

    private boolean jr() {
        this.EN.fx(0);
        int bQ = this.EN.bQ(24);
        if (bQ != 1) {
            q.h("PesReader", "Unexpected start code prefix: " + bQ);
            this.ES = -1;
            return false;
        }
        this.EN.bR(8);
        int bQ2 = this.EN.bQ(16);
        this.EN.bR(5);
        this.ET = this.EN.ik();
        this.EN.bR(2);
        this.EO = this.EN.ik();
        this.EP = this.EN.ik();
        this.EN.bR(6);
        int bQ3 = this.EN.bQ(8);
        this.ER = bQ3;
        if (bQ2 == 0) {
            this.ES = -1;
        } else {
            int i = (bQ2 - 3) - bQ3;
            this.ES = i;
            if (i < 0) {
                q.h("PesReader", "Found negative packet payload size: " + this.ES);
                this.ES = -1;
            }
        }
        return true;
    }

    private void js() {
        this.EN.fx(0);
        this.rJ = -9223372036854775807L;
        if (this.EO) {
            this.EN.bR(4);
            this.EN.bR(1);
            this.EN.bR(1);
            long bQ = (((long) this.EN.bQ(3)) << 30) | ((long) (this.EN.bQ(15) << 15)) | ((long) this.EN.bQ(15));
            this.EN.bR(1);
            if (!this.EQ && this.EP) {
                this.EN.bR(4);
                this.EN.bR(1);
                this.EN.bR(1);
                this.EN.bR(1);
                this.zS.br((((long) this.EN.bQ(3)) << 30) | ((long) (this.EN.bQ(15) << 15)) | ((long) this.EN.bQ(15)));
                this.EQ = true;
            }
            this.rJ = this.zS.br(bQ);
        }
    }
}
