package com.fyber.inneractive.sdk.player.exoplayer2.source;

import com.fyber.inneractive.sdk.player.exoplayer2.i;
import com.fyber.inneractive.sdk.player.exoplayer2.util.a;
import com.ironsource.mediationsdk.logger.IronSourceError;
import java.util.Arrays;

public final class r {
    public final int a;
    public final i[] b;
    public int c;

    public r(i... iVarArr) {
        a.b(iVarArr.length > 0);
        this.b = iVarArr;
        this.a = iVarArr.length;
    }

    public i a(int i) {
        return this.b[i];
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || r.class != obj.getClass()) {
            return false;
        }
        r rVar = (r) obj;
        if (this.a != rVar.a || !Arrays.equals(this.b, rVar.b)) {
            return false;
        }
        return true;
    }

    public int a(i iVar) {
        int i = 0;
        while (true) {
            i[] iVarArr = this.b;
            if (i >= iVarArr.length) {
                return -1;
            }
            if (iVar == iVarArr[i]) {
                return i;
            }
            i++;
        }
    }

    public int hashCode() {
        if (this.c == 0) {
            this.c = Arrays.hashCode(this.b) + IronSourceError.ERROR_NON_EXISTENT_INSTANCE;
        }
        return this.c;
    }
}
