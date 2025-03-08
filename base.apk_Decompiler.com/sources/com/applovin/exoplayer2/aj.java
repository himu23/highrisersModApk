package com.applovin.exoplayer2;

import android.os.Bundle;
import com.applovin.exoplayer2.common.base.Objects;
import com.applovin.exoplayer2.g;
import com.applovin.exoplayer2.l.a;

public final class aj extends aq {
    public static final g.a<aj> br = new aj$$ExternalSyntheticLambda0();
    private final float go;

    public aj() {
        this.go = -1.0f;
    }

    public aj(float f) {
        a.checkArgument(f >= 0.0f && f <= 100.0f, "percent must be in the range of [0, 100]");
        this.go = f;
    }

    public int hashCode() {
        return Objects.hashCode(Float.valueOf(this.go));
    }

    public boolean equals(Object obj) {
        if ((obj instanceof aj) && this.go == ((aj) obj).go) {
            return true;
        }
        return false;
    }

    /* access modifiers changed from: private */
    public static aj i(Bundle bundle) {
        boolean z = false;
        if (bundle.getInt(t(0), -1) == 1) {
            z = true;
        }
        a.checkArgument(z);
        float f = bundle.getFloat(t(1), -1.0f);
        return f == -1.0f ? new aj() : new aj(f);
    }

    private static String t(int i) {
        return Integer.toString(i, 36);
    }
}
