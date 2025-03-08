package com.applovin.exoplayer2.b;

import com.ironsource.mediationsdk.logger.IronSourceError;

public final class k {
    public final int kM;
    public final float kN;

    public k(int i, float f) {
        this.kM = i;
        this.kN = f;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        k kVar = (k) obj;
        if (this.kM == kVar.kM && Float.compare(kVar.kN, this.kN) == 0) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return ((IronSourceError.ERROR_NON_EXISTENT_INSTANCE + this.kM) * 31) + Float.floatToIntBits(this.kN);
    }
}
