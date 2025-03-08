package com.applovin.exoplayer2.e.f;

import com.applovin.exoplayer2.b.r;
import com.applovin.exoplayer2.e.v;
import com.applovin.exoplayer2.e.w;
import com.applovin.exoplayer2.l.ai;
import com.applovin.exoplayer2.l.q;
import com.applovin.exoplayer2.l.y;

final class f implements e {
    private final long fH;
    private final long[] tU;
    private final long[] uP;
    private final long yO;

    public long dd() {
        return this.fH;
    }

    public boolean hU() {
        return true;
    }

    public long iF() {
        return this.yO;
    }

    public static f a(long j, long j2, r.a aVar, y yVar) {
        int i;
        long j3 = j;
        r.a aVar2 = aVar;
        y yVar2 = yVar;
        yVar2.fz(10);
        int px = yVar.px();
        if (px <= 0) {
            return null;
        }
        int i2 = aVar2.dM;
        long e = ai.e((long) px, ((long) (i2 >= 32000 ? 1152 : 576)) * 1000000, (long) i2);
        int pp = yVar.pp();
        int pp2 = yVar.pp();
        int pp3 = yVar.pp();
        yVar2.fz(2);
        long j4 = j2 + ((long) aVar2.jz);
        long[] jArr = new long[pp];
        long[] jArr2 = new long[pp];
        int i3 = 0;
        long j5 = j2;
        while (i3 < pp) {
            int i4 = pp2;
            jArr[i3] = (((long) i3) * e) / ((long) pp);
            long j6 = j4;
            jArr2[i3] = Math.max(j5, j6);
            if (pp3 == 1) {
                i = yVar.po();
            } else if (pp3 == 2) {
                i = yVar.pp();
            } else if (pp3 == 3) {
                i = yVar.pt();
            } else if (pp3 != 4) {
                return null;
            } else {
                i = yVar.pD();
            }
            j5 += (long) (i * i4);
            i3++;
            j4 = j6;
            pp2 = i4;
        }
        if (!(j3 == -1 || j3 == j5)) {
            q.h("VbriSeeker", "VBRI data size mismatch: " + j3 + ", " + j5);
        }
        return new f(jArr, jArr2, e, j5);
    }

    private f(long[] jArr, long[] jArr2, long j, long j2) {
        this.tU = jArr;
        this.uP = jArr2;
        this.fH = j;
        this.yO = j2;
    }

    public v.a ai(long j) {
        int a = ai.a(this.tU, j, true, true);
        w wVar = new w(this.tU[a], this.uP[a]);
        if (wVar.rJ >= j || a == this.tU.length - 1) {
            return new v.a(wVar);
        }
        int i = a + 1;
        return new v.a(wVar, new w(this.tU[i], this.uP[i]));
    }

    public long aq(long j) {
        return this.tU[ai.a(this.uP, j, true, true)];
    }
}
