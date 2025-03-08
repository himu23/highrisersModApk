package com.applovin.exoplayer2.e.i;

import com.applovin.exoplayer2.common.base.Ascii;
import com.applovin.exoplayer2.e.a;
import com.applovin.exoplayer2.e.i;
import com.applovin.exoplayer2.l.ag;
import com.applovin.exoplayer2.l.ai;
import com.applovin.exoplayer2.l.y;
import java.io.IOException;
import kotlin.UByte;

final class u extends com.applovin.exoplayer2.e.a {
    public u(ag agVar, long j, long j2) {
        super(new a.b(), new a(agVar), j, 0, j + 1, 0, j2, 188, 1000);
    }

    private static final class a implements a.f {
        private final y CB;
        private final ag EU;

        private a(ag agVar) {
            this.EU = agVar;
            this.CB = new y();
        }

        public a.e b(i iVar, long j) throws IOException {
            long ie = iVar.ie();
            int min = (int) Math.min(20000, iVar.m1771if() - ie);
            this.CB.U(min);
            iVar.c(this.CB.hO(), 0, min);
            return a(this.CB, j, ie);
        }

        public void ib() {
            this.CB.I(ai.ada);
        }

        private a.e a(y yVar, long j, long j2) {
            int i = -1;
            long j3 = -9223372036854775807L;
            int i2 = -1;
            while (yVar.pj() >= 4) {
                if (u.d(yVar.hO(), yVar.il()) != 442) {
                    yVar.fz(1);
                } else {
                    yVar.fz(4);
                    long T = v.T(yVar);
                    if (T != -9223372036854775807L) {
                        long br = this.EU.br(T);
                        if (br > j) {
                            if (j3 == -9223372036854775807L) {
                                return a.e.m(br, j2);
                            }
                            return a.e.aj(j2 + ((long) i2));
                        } else if (100000 + br > j) {
                            return a.e.aj(j2 + ((long) yVar.il()));
                        } else {
                            i2 = yVar.il();
                            j3 = br;
                        }
                    }
                    S(yVar);
                    i = yVar.il();
                }
            }
            if (j3 != -9223372036854775807L) {
                return a.e.n(j3, j2 + ((long) i));
            }
            return a.e.tO;
        }

        private static void S(y yVar) {
            int pk = yVar.pk();
            if (yVar.pj() < 10) {
                yVar.fx(pk);
                return;
            }
            yVar.fz(9);
            int po = yVar.po() & 7;
            if (yVar.pj() < po) {
                yVar.fx(pk);
                return;
            }
            yVar.fz(po);
            if (yVar.pj() < 4) {
                yVar.fx(pk);
                return;
            }
            if (u.d(yVar.hO(), yVar.il()) == 443) {
                yVar.fz(4);
                int pp = yVar.pp();
                if (yVar.pj() < pp) {
                    yVar.fx(pk);
                    return;
                }
                yVar.fz(pp);
            }
            while (yVar.pj() >= 4 && (r1 = u.d(yVar.hO(), yVar.il())) != 442 && r1 != 441 && (r1 >>> 8) == 1) {
                yVar.fz(4);
                if (yVar.pj() < 2) {
                    yVar.fx(pk);
                    return;
                } else {
                    yVar.fx(Math.min(yVar.pk(), yVar.il() + yVar.pp()));
                }
            }
        }
    }

    /* access modifiers changed from: private */
    public static int d(byte[] bArr, int i) {
        return (bArr[i + 3] & UByte.MAX_VALUE) | ((bArr[i] & UByte.MAX_VALUE) << Ascii.CAN) | ((bArr[i + 1] & UByte.MAX_VALUE) << Ascii.DLE) | ((bArr[i + 2] & UByte.MAX_VALUE) << 8);
    }
}
