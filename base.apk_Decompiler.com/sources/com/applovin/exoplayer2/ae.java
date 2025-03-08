package com.applovin.exoplayer2;

import com.applovin.exoplayer2.h.p;
import com.applovin.exoplayer2.l.a;
import com.applovin.exoplayer2.l.ai;
import com.ironsource.mediationsdk.logger.IronSourceError;

final class ae {
    public final long de;
    public final p.a fE;
    public final long fF;
    public final long fG;
    public final long fH;
    public final boolean fI;
    public final boolean fJ;
    public final boolean fK;
    public final boolean fL;

    ae(p.a aVar, long j, long j2, long j3, long j4, boolean z, boolean z2, boolean z3, boolean z4) {
        boolean z5 = z;
        boolean z6 = z2;
        boolean z7 = z3;
        boolean z8 = z4;
        boolean z9 = false;
        a.checkArgument(!z8 || z6);
        a.checkArgument(!z7 || z6);
        if (!z5 || (!z6 && !z7 && !z8)) {
            z9 = true;
        }
        a.checkArgument(z9);
        this.fE = aVar;
        this.fF = j;
        this.de = j2;
        this.fG = j3;
        this.fH = j4;
        this.fI = z5;
        this.fJ = z6;
        this.fK = z7;
        this.fL = z8;
    }

    public ae v(long j) {
        if (j == this.fF) {
            return this;
        }
        return new ae(this.fE, j, this.de, this.fG, this.fH, this.fI, this.fJ, this.fK, this.fL);
    }

    public ae w(long j) {
        if (j == this.de) {
            return this;
        }
        return new ae(this.fE, this.fF, j, this.fG, this.fH, this.fI, this.fJ, this.fK, this.fL);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        ae aeVar = (ae) obj;
        if (this.fF == aeVar.fF && this.de == aeVar.de && this.fG == aeVar.fG && this.fH == aeVar.fH && this.fI == aeVar.fI && this.fJ == aeVar.fJ && this.fK == aeVar.fK && this.fL == aeVar.fL && ai.r(this.fE, aeVar.fE)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return ((((((((((((((((IronSourceError.ERROR_NON_EXISTENT_INSTANCE + this.fE.hashCode()) * 31) + ((int) this.fF)) * 31) + ((int) this.de)) * 31) + ((int) this.fG)) * 31) + ((int) this.fH)) * 31) + (this.fI ? 1 : 0)) * 31) + (this.fJ ? 1 : 0)) * 31) + (this.fK ? 1 : 0)) * 31) + (this.fL ? 1 : 0);
    }
}
