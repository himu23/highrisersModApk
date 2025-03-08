package com.applovin.exoplayer2;

import android.os.Bundle;
import com.applovin.exoplayer2.common.base.Objects;
import com.applovin.exoplayer2.g;
import com.applovin.exoplayer2.l.a;

public final class x extends aq {
    public static final g.a<x> br = new x$$ExternalSyntheticLambda0();
    private final boolean dV;
    private final boolean dW;

    public x() {
        this.dV = false;
        this.dW = false;
    }

    public x(boolean z) {
        this.dV = true;
        this.dW = z;
    }

    public int hashCode() {
        return Objects.hashCode(Boolean.valueOf(this.dV), Boolean.valueOf(this.dW));
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof x)) {
            return false;
        }
        x xVar = (x) obj;
        if (this.dW == xVar.dW && this.dV == xVar.dV) {
            return true;
        }
        return false;
    }

    /* access modifiers changed from: private */
    public static x c(Bundle bundle) {
        a.checkArgument(bundle.getInt(t(0), -1) == 0);
        if (bundle.getBoolean(t(1), false)) {
            return new x(bundle.getBoolean(t(2), false));
        }
        return new x();
    }

    private static String t(int i) {
        return Integer.toString(i, 36);
    }
}
