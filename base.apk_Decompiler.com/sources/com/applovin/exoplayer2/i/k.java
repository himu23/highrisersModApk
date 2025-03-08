package com.applovin.exoplayer2.i;

import com.applovin.exoplayer2.c.i;
import com.applovin.exoplayer2.l.a;
import java.util.List;

public abstract class k extends i implements f {
    private f Ou;
    private long dD;

    public void a(long j, f fVar, long j2) {
        this.rJ = j;
        this.Ou = fVar;
        if (j2 == Long.MAX_VALUE) {
            j2 = this.rJ;
        }
        this.dD = j2;
    }

    public int lX() {
        return ((f) a.checkNotNull(this.Ou)).lX();
    }

    public long ej(int i) {
        return ((f) a.checkNotNull(this.Ou)).ej(i) + this.dD;
    }

    public int be(long j) {
        return ((f) a.checkNotNull(this.Ou)).be(j - this.dD);
    }

    public List<a> bf(long j) {
        return ((f) a.checkNotNull(this.Ou)).bf(j - this.dD);
    }

    public void clear() {
        super.clear();
        this.Ou = null;
    }
}
