package com.applovin.exoplayer2.e;

import com.applovin.exoplayer2.e.v;
import com.applovin.exoplayer2.l.a;
import com.applovin.exoplayer2.l.ai;

public final class t implements v {
    private final long fH;
    private final boolean iM;
    private final long[] tU;
    private final long[] uP;

    public long dd() {
        return this.fH;
    }

    public boolean hU() {
        return this.iM;
    }

    public t(long[] jArr, long[] jArr2, long j) {
        a.checkArgument(jArr.length == jArr2.length);
        int length = jArr2.length;
        boolean z = length > 0;
        this.iM = z;
        if (!z || jArr2[0] <= 0) {
            this.uP = jArr;
            this.tU = jArr2;
        } else {
            int i = length + 1;
            long[] jArr3 = new long[i];
            this.uP = jArr3;
            long[] jArr4 = new long[i];
            this.tU = jArr4;
            System.arraycopy(jArr, 0, jArr3, 1, length);
            System.arraycopy(jArr2, 0, jArr4, 1, length);
        }
        this.fH = j;
    }

    public v.a ai(long j) {
        if (!this.iM) {
            return new v.a(w.uT);
        }
        int a = ai.a(this.tU, j, true, true);
        w wVar = new w(this.tU[a], this.uP[a]);
        if (wVar.rJ == j || a == this.tU.length - 1) {
            return new v.a(wVar);
        }
        int i = a + 1;
        return new v.a(wVar, new w(this.tU[i], this.uP[i]));
    }
}
