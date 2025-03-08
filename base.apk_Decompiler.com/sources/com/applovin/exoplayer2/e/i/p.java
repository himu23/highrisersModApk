package com.applovin.exoplayer2.e.i;

import com.applovin.exoplayer2.ai;
import com.applovin.exoplayer2.b.a;
import com.applovin.exoplayer2.e.i.ad;
import com.applovin.exoplayer2.e.j;
import com.applovin.exoplayer2.e.x;
import com.applovin.exoplayer2.l.a;
import com.applovin.exoplayer2.l.x;
import com.applovin.exoplayer2.l.y;
import com.applovin.exoplayer2.v;
import java.util.Collections;
import java.util.List;

public final class p implements j {
    private int Ai;
    private String Ct;
    private int Cu;
    private long Cw;
    private int EA;
    private boolean EB;
    private long EC;
    private final y Eu;
    private final x Ev;
    private int Ew;
    private boolean Ex;
    private int Ey;
    private int Ez;
    private int Z;
    private int dL;
    private v dU;
    private final String dq;
    private String dw;
    private int js;
    private long rJ = -9223372036854775807L;
    private com.applovin.exoplayer2.e.x wl;

    public void e(long j, int i) {
        if (j != -9223372036854775807L) {
            this.rJ = j;
        }
    }

    public void jb() {
        this.Z = 0;
        this.rJ = -9223372036854775807L;
        this.Ex = false;
    }

    public void jc() {
    }

    public p(String str) {
        this.dq = str;
        y yVar = new y(1024);
        this.Eu = yVar;
        this.Ev = new x(yVar.hO());
    }

    public void a(j jVar, ad.d dVar) {
        dVar.jy();
        this.wl = jVar.y(dVar.jz(), 1);
        this.Ct = dVar.jA();
    }

    public void K(y yVar) throws ai {
        a.N(this.wl);
        while (yVar.pj() > 0) {
            int i = this.Z;
            if (i != 0) {
                if (i == 1) {
                    int po = yVar.po();
                    if ((po & 224) == 224) {
                        this.Ew = po;
                        this.Z = 2;
                    } else if (po != 86) {
                        this.Z = 0;
                    }
                } else if (i == 2) {
                    int po2 = ((this.Ew & -225) << 8) | yVar.po();
                    this.Ai = po2;
                    if (po2 > this.Eu.hO().length) {
                        cA(this.Ai);
                    }
                    this.Cu = 0;
                    this.Z = 3;
                } else if (i == 3) {
                    int min = Math.min(yVar.pj(), this.Ai - this.Cu);
                    yVar.r(this.Ev.tf, this.Cu, min);
                    int i2 = this.Cu + min;
                    this.Cu = i2;
                    if (i2 == this.Ai) {
                        this.Ev.fx(0);
                        e(this.Ev);
                        this.Z = 0;
                    }
                } else {
                    throw new IllegalStateException();
                }
            } else if (yVar.po() == 86) {
                this.Z = 1;
            }
        }
    }

    private void e(x xVar) throws ai {
        if (!xVar.ik()) {
            this.Ex = true;
            f(xVar);
        } else if (!this.Ex) {
            return;
        }
        if (this.Ey != 0) {
            throw ai.c((String) null, (Throwable) null);
        } else if (this.Ez == 0) {
            b(xVar, i(xVar));
            if (this.EB) {
                xVar.bR((int) this.EC);
            }
        } else {
            throw ai.c((String) null, (Throwable) null);
        }
    }

    private void f(x xVar) throws ai {
        boolean ik;
        int bQ = xVar.bQ(1);
        int bQ2 = bQ == 1 ? xVar.bQ(1) : 0;
        this.Ey = bQ2;
        if (bQ2 == 0) {
            if (bQ == 1) {
                j(xVar);
            }
            if (xVar.ik()) {
                this.Ez = xVar.bQ(6);
                int bQ3 = xVar.bQ(4);
                int bQ4 = xVar.bQ(3);
                if (bQ3 == 0 && bQ4 == 0) {
                    if (bQ == 0) {
                        int il = xVar.il();
                        int h = h(xVar);
                        xVar.fx(il);
                        byte[] bArr = new byte[((h + 7) / 8)];
                        xVar.q(bArr, 0, h);
                        v bT = new v.a().g(this.Ct).m("audio/mp4a-latm").k(this.dw).N(this.dL).O(this.js).c((List<byte[]>) Collections.singletonList(bArr)).j(this.dq).bT();
                        if (!bT.equals(this.dU)) {
                            this.dU = bT;
                            this.Cw = 1024000000 / ((long) bT.dM);
                            this.wl.j(bT);
                        }
                    } else {
                        xVar.bR(((int) j(xVar)) - h(xVar));
                    }
                    g(xVar);
                    boolean ik2 = xVar.ik();
                    this.EB = ik2;
                    this.EC = 0;
                    if (ik2) {
                        if (bQ == 1) {
                            this.EC = j(xVar);
                        } else {
                            do {
                                ik = xVar.ik();
                                this.EC = (this.EC << 8) + ((long) xVar.bQ(8));
                            } while (ik);
                        }
                    }
                    if (xVar.ik()) {
                        xVar.bR(8);
                        return;
                    }
                    return;
                }
                throw ai.c((String) null, (Throwable) null);
            }
            throw ai.c((String) null, (Throwable) null);
        }
        throw ai.c((String) null, (Throwable) null);
    }

    private void g(x xVar) {
        int bQ = xVar.bQ(3);
        this.EA = bQ;
        if (bQ == 0) {
            xVar.bR(8);
        } else if (bQ == 1) {
            xVar.bR(9);
        } else if (bQ == 3 || bQ == 4 || bQ == 5) {
            xVar.bR(6);
        } else if (bQ == 6 || bQ == 7) {
            xVar.bR(1);
        } else {
            throw new IllegalStateException();
        }
    }

    private int h(x xVar) throws ai {
        int pf = xVar.pf();
        a.C0031a a = com.applovin.exoplayer2.b.a.a(xVar, true);
        this.dw = a.dw;
        this.js = a.js;
        this.dL = a.dL;
        return pf - xVar.pf();
    }

    private int i(x xVar) throws ai {
        int bQ;
        if (this.EA == 0) {
            int i = 0;
            do {
                bQ = xVar.bQ(8);
                i += bQ;
            } while (bQ == 255);
            return i;
        }
        throw ai.c((String) null, (Throwable) null);
    }

    private void b(x xVar, int i) {
        int il = xVar.il();
        if ((il & 7) == 0) {
            this.Eu.fx(il >> 3);
        } else {
            xVar.q(this.Eu.hO(), 0, i * 8);
            this.Eu.fx(0);
        }
        this.wl.c(this.Eu, i);
        long j = this.rJ;
        if (j != -9223372036854775807L) {
            this.wl.a(j, 1, i, 0, (x.a) null);
            this.rJ += this.Cw;
        }
    }

    private void cA(int i) {
        this.Eu.U(i);
        this.Ev.I(this.Eu.hO());
    }

    private static long j(com.applovin.exoplayer2.l.x xVar) {
        return (long) xVar.bQ((xVar.bQ(2) + 1) * 8);
    }
}
