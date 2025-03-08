package com.applovin.exoplayer2.e.i;

import com.applovin.exoplayer2.e.a;
import com.applovin.exoplayer2.e.i;
import com.applovin.exoplayer2.l.ag;
import com.applovin.exoplayer2.l.ai;
import com.applovin.exoplayer2.l.y;
import java.io.IOException;

final class aa extends com.applovin.exoplayer2.e.a {
    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public aa(com.applovin.exoplayer2.l.ag r17, long r18, long r20, int r22, int r23) {
        /*
            r16 = this;
            com.applovin.exoplayer2.e.a$b r1 = new com.applovin.exoplayer2.e.a$b
            r1.<init>()
            com.applovin.exoplayer2.e.i.aa$a r2 = new com.applovin.exoplayer2.e.i.aa$a
            r0 = r17
            r3 = r22
            r4 = r23
            r2.<init>(r3, r0, r4)
            r5 = 0
            r3 = 1
            long r7 = r18 + r3
            r9 = 0
            r13 = 188(0xbc, double:9.3E-322)
            r15 = 940(0x3ac, float:1.317E-42)
            r0 = r16
            r3 = r18
            r11 = r20
            r0.<init>(r1, r2, r3, r5, r7, r9, r11, r13, r15)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.applovin.exoplayer2.e.i.aa.<init>(com.applovin.exoplayer2.l.ag, long, long, int, int):void");
    }

    private static final class a implements a.f {
        private final y CB = new y();
        private final ag Fo;
        private final int Fp;
        private final int Fq;

        public a(int i, ag agVar, int i2) {
            this.Fp = i;
            this.Fo = agVar;
            this.Fq = i2;
        }

        public a.e b(i iVar, long j) throws IOException {
            long ie = iVar.ie();
            int min = (int) Math.min((long) this.Fq, iVar.m1771if() - ie);
            this.CB.U(min);
            iVar.c(this.CB.hO(), 0, min);
            return b(this.CB, j, ie);
        }

        private a.e b(y yVar, long j, long j2) {
            int i;
            int i2;
            y yVar2 = yVar;
            long j3 = j2;
            int pk = yVar.pk();
            long j4 = -1;
            long j5 = -1;
            long j6 = -9223372036854775807L;
            while (yVar.pj() >= 188 && (i2 = i + 188) <= pk) {
                long f = ae.f(yVar2, (i = ae.i(yVar.hO(), yVar.il(), pk)), this.Fp);
                if (f != -9223372036854775807L) {
                    long br = this.Fo.br(f);
                    if (br > j) {
                        if (j6 == -9223372036854775807L) {
                            return a.e.m(br, j3);
                        }
                        return a.e.aj(j3 + j5);
                    } else if (100000 + br > j) {
                        return a.e.aj(j3 + ((long) i));
                    } else {
                        j5 = (long) i;
                        j6 = br;
                    }
                }
                yVar2.fx(i2);
                j4 = (long) i2;
            }
            if (j6 != -9223372036854775807L) {
                return a.e.n(j6, j3 + j4);
            }
            return a.e.tO;
        }

        public void ib() {
            this.CB.I(ai.ada);
        }
    }
}
