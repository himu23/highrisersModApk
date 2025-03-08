package com.applovin.exoplayer2.e.d;

import com.applovin.exoplayer2.e.i;
import com.applovin.exoplayer2.e.q;
import com.applovin.exoplayer2.l.a;

final class c extends q {
    private final long wE;

    public c(i iVar, long j) {
        super(iVar);
        a.checkArgument(iVar.ie() >= j);
        this.wE = j;
    }

    public long ie() {
        return super.ie() - this.wE;
    }

    public long id() {
        return super.id() - this.wE;
    }

    /* renamed from: if  reason: not valid java name */
    public long m1766if() {
        return super.m1772if() - this.wE;
    }
}
