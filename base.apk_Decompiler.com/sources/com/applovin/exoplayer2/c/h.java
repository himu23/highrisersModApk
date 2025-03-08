package com.applovin.exoplayer2.c;

import com.applovin.exoplayer2.l.a;
import com.applovin.exoplayer2.v;
import com.ironsource.mediationsdk.logger.IronSourceError;

public final class h {
    public final int pZ;
    public final String rO;
    public final v rP;
    public final v rQ;
    public final int rR;

    public h(String str, v vVar, v vVar2, int i, int i2) {
        a.checkArgument(i == 0 || i2 == 0);
        this.rO = a.aR(str);
        this.rP = (v) a.checkNotNull(vVar);
        this.rQ = (v) a.checkNotNull(vVar2);
        this.pZ = i;
        this.rR = i2;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        h hVar = (h) obj;
        if (this.pZ != hVar.pZ || this.rR != hVar.rR || !this.rO.equals(hVar.rO) || !this.rP.equals(hVar.rP) || !this.rQ.equals(hVar.rQ)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        return ((((((((IronSourceError.ERROR_NON_EXISTENT_INSTANCE + this.pZ) * 31) + this.rR) * 31) + this.rO.hashCode()) * 31) + this.rP.hashCode()) * 31) + this.rQ.hashCode();
    }
}
