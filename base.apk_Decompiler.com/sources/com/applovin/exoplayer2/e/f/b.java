package com.applovin.exoplayer2.e.f;

import com.applovin.exoplayer2.e.v;
import com.applovin.exoplayer2.e.w;
import com.applovin.exoplayer2.l.ai;
import com.applovin.exoplayer2.l.r;

final class b implements e {
    private long fH;
    private final long yO;
    private final r yP;
    private final r yQ;

    /* access modifiers changed from: package-private */
    public void as(long j) {
        this.fH = j;
    }

    public long dd() {
        return this.fH;
    }

    public boolean hU() {
        return true;
    }

    public long iF() {
        return this.yO;
    }

    public b(long j, long j2, long j3) {
        this.fH = j;
        this.yO = j3;
        r rVar = new r();
        this.yP = rVar;
        r rVar2 = new r();
        this.yQ = rVar2;
        rVar.bo(0);
        rVar2.bo(j2);
    }

    public long aq(long j) {
        return this.yP.fu(ai.a(this.yQ, j, true, true));
    }

    public v.a ai(long j) {
        int a = ai.a(this.yP, j, true, true);
        w wVar = new w(this.yP.fu(a), this.yQ.fu(a));
        if (wVar.rJ == j || a == this.yP.size() - 1) {
            return new v.a(wVar);
        }
        int i = a + 1;
        return new v.a(wVar, new w(this.yP.fu(i), this.yQ.fu(i)));
    }

    public void s(long j, long j2) {
        if (!ar(j)) {
            this.yP.bo(j);
            this.yQ.bo(j2);
        }
    }

    public boolean ar(long j) {
        r rVar = this.yP;
        return j - rVar.fu(rVar.size() - 1) < 100000;
    }
}
