package com.applovin.exoplayer2.e.f;

import com.applovin.exoplayer2.b.r;
import com.applovin.exoplayer2.e.v;
import com.applovin.exoplayer2.e.w;
import com.applovin.exoplayer2.l.a;
import com.applovin.exoplayer2.l.ai;
import com.applovin.exoplayer2.l.q;
import com.applovin.exoplayer2.l.y;

final class g implements e {
    private final long fH;
    private final long tX;
    private final long yO;
    private final long zi;
    private final int zj;
    private final long[] zk;

    public long dd() {
        return this.fH;
    }

    public boolean hU() {
        return this.zk != null;
    }

    public long iF() {
        return this.yO;
    }

    public static g b(long j, long j2, r.a aVar, y yVar) {
        int pD;
        long j3 = j;
        r.a aVar2 = aVar;
        int i = aVar2.mJ;
        int i2 = aVar2.dM;
        int px = yVar.px();
        if ((px & 1) != 1 || (pD = yVar.pD()) == 0) {
            return null;
        }
        long e = ai.e((long) pD, ((long) i) * 1000000, (long) i2);
        if ((px & 6) != 6) {
            return new g(j2, aVar2.jz, e);
        }
        long pv = yVar.pv();
        long[] jArr = new long[100];
        for (int i3 = 0; i3 < 100; i3++) {
            jArr[i3] = (long) yVar.po();
        }
        if (j3 != -1) {
            long j4 = j2 + pv;
            if (j3 != j4) {
                q.h("XingSeeker", "XING data size mismatch: " + j3 + ", " + j4);
            }
        }
        return new g(j2, aVar2.jz, e, pv, jArr);
    }

    private g(long j, int i, long j2) {
        this(j, i, j2, -1, (long[]) null);
    }

    private g(long j, int i, long j2, long j3, long[] jArr) {
        this.zi = j;
        this.zj = i;
        this.fH = j2;
        this.zk = jArr;
        this.tX = j3;
        this.yO = j3 != -1 ? j + j3 : -1;
    }

    public v.a ai(long j) {
        double d;
        if (!hU()) {
            return new v.a(new w(0, this.zi + ((long) this.zj)));
        }
        long b = ai.b(j, 0, this.fH);
        double d2 = (((double) b) * 100.0d) / ((double) this.fH);
        double d3 = 0.0d;
        if (d2 > 0.0d) {
            if (d2 >= 100.0d) {
                d3 = 256.0d;
            } else {
                int i = (int) d2;
                long[] jArr = (long[]) a.N(this.zk);
                double d4 = (double) jArr[i];
                if (i == 99) {
                    d = 256.0d;
                } else {
                    d = (double) jArr[i + 1];
                }
                d3 = d4 + ((d2 - ((double) i)) * (d - d4));
            }
        }
        return new v.a(new w(b, this.zi + ai.b(Math.round((d3 / 256.0d) * ((double) this.tX)), (long) this.zj, this.tX - 1)));
    }

    public long aq(long j) {
        long j2;
        long j3 = j - this.zi;
        if (!hU() || j3 <= ((long) this.zj)) {
            return 0;
        }
        long[] jArr = (long[]) a.N(this.zk);
        double d = (((double) j3) * 256.0d) / ((double) this.tX);
        int a = ai.a(jArr, (long) d, true, true);
        long ce = ce(a);
        long j4 = jArr[a];
        int i = a + 1;
        long ce2 = ce(i);
        if (a == 99) {
            j2 = 256;
        } else {
            j2 = jArr[i];
        }
        return ce + Math.round((j4 == j2 ? 0.0d : (d - ((double) j4)) / ((double) (j2 - j4))) * ((double) (ce2 - ce)));
    }

    private long ce(int i) {
        return (this.fH * ((long) i)) / 100;
    }
}
