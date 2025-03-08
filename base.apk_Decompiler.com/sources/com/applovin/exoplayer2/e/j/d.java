package com.applovin.exoplayer2.e.j;

import com.applovin.exoplayer2.e.v;
import com.applovin.exoplayer2.e.w;
import com.applovin.exoplayer2.l.ai;

final class d implements v {
    private final int Gd;
    private final b Gt;
    private final long Gu;
    private final long Gv;
    private final long fH;

    public long dd() {
        return this.fH;
    }

    public boolean hU() {
        return true;
    }

    public d(b bVar, int i, long j, long j2) {
        this.Gt = bVar;
        this.Gd = i;
        this.Gu = j;
        long j3 = (j2 - j) / ((long) bVar.Gq);
        this.Gv = j3;
        this.fH = aJ(j3);
    }

    public v.a ai(long j) {
        long b = ai.b((((long) this.Gt.Go) * j) / (((long) this.Gd) * 1000000), 0, this.Gv - 1);
        long j2 = this.Gu + (((long) this.Gt.Gq) * b);
        long aJ = aJ(b);
        w wVar = new w(aJ, j2);
        if (aJ >= j || b == this.Gv - 1) {
            return new v.a(wVar);
        }
        long j3 = b + 1;
        return new v.a(wVar, new w(aJ(j3), this.Gu + (((long) this.Gt.Gq) * j3)));
    }

    private long aJ(long j) {
        return ai.e(j * ((long) this.Gd), 1000000, (long) this.Gt.Go);
    }
}
