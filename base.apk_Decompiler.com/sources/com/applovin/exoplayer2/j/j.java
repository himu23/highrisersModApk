package com.applovin.exoplayer2.j;

import com.applovin.exoplayer2.as;
import com.applovin.exoplayer2.ba;
import com.applovin.exoplayer2.h.ad;
import com.applovin.exoplayer2.h.p;
import com.applovin.exoplayer2.k.d;

public abstract class j {
    private a VC;
    private d bO;

    public interface a {
    }

    public abstract void J(Object obj);

    public abstract k a(as[] asVarArr, ad adVar, p.a aVar, ba baVar) throws com.applovin.exoplayer2.p;

    public final void a(a aVar, d dVar) {
        this.VC = aVar;
        this.bO = dVar;
    }

    public boolean nh() {
        return false;
    }

    /* access modifiers changed from: protected */
    public final d nq() {
        return (d) com.applovin.exoplayer2.l.a.checkNotNull(this.bO);
    }
}
