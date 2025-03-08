package com.applovin.exoplayer2;

import android.os.Bundle;
import com.applovin.exoplayer2.common.base.Objects;
import com.applovin.exoplayer2.g;
import com.applovin.exoplayer2.l.a;

public final class az extends aq {
    public static final g.a<az> br = new az$$ExternalSyntheticLambda0();
    private final boolean dV;
    private final boolean iv;

    public az() {
        this.dV = false;
        this.iv = false;
    }

    public az(boolean z) {
        this.dV = true;
        this.iv = z;
    }

    public int hashCode() {
        return Objects.hashCode(Boolean.valueOf(this.dV), Boolean.valueOf(this.iv));
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof az)) {
            return false;
        }
        az azVar = (az) obj;
        if (this.iv == azVar.iv && this.dV == azVar.dV) {
            return true;
        }
        return false;
    }

    /* access modifiers changed from: private */
    public static az p(Bundle bundle) {
        a.checkArgument(bundle.getInt(t(0), -1) == 3);
        if (bundle.getBoolean(t(1), false)) {
            return new az(bundle.getBoolean(t(2), false));
        }
        return new az();
    }

    private static String t(int i) {
        return Integer.toString(i, 36);
    }
}
