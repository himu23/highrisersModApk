package com.applovin.exoplayer2.j;

import com.ironsource.mediationsdk.logger.IronSourceError;
import java.util.Arrays;

public final class h {
    private final g[] Vc;
    private int dS;
    public final int fR;

    public h(g... gVarArr) {
        this.Vc = gVarArr;
        this.fR = gVarArr.length;
    }

    public g eU(int i) {
        return this.Vc[i];
    }

    public int hashCode() {
        if (this.dS == 0) {
            this.dS = IronSourceError.ERROR_NON_EXISTENT_INSTANCE + Arrays.hashCode(this.Vc);
        }
        return this.dS;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        return Arrays.equals(this.Vc, ((h) obj).Vc);
    }
}
