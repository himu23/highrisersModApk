package com.applovin.exoplayer2.e;

import com.applovin.exoplayer2.e.v;
import com.applovin.exoplayer2.l.a;
import com.applovin.exoplayer2.l.ai;

public final class o implements v {
    private final long uA;
    private final p uz;

    public boolean hU() {
        return true;
    }

    public o(p pVar, long j) {
        this.uz = pVar;
        this.uA = j;
    }

    public long dd() {
        return this.uz.dd();
    }

    public v.a ai(long j) {
        long j2;
        a.N(this.uz.uJ);
        long[] jArr = this.uz.uJ.uK;
        long[] jArr2 = this.uz.uJ.uL;
        int a = ai.a(jArr, this.uz.an(j), true, false);
        long j3 = 0;
        if (a == -1) {
            j2 = 0;
        } else {
            j2 = jArr[a];
        }
        if (a != -1) {
            j3 = jArr2[a];
        }
        w p = p(j2, j3);
        if (p.rJ == j || a == jArr.length - 1) {
            return new v.a(p);
        }
        int i = a + 1;
        return new v.a(p, p(jArr[i], jArr2[i]));
    }

    private w p(long j, long j2) {
        return new w((j * 1000000) / ((long) this.uz.dM), this.uA + j2);
    }
}
