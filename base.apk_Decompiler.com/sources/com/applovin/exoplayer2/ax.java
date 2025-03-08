package com.applovin.exoplayer2;

import android.os.Bundle;
import com.applovin.exoplayer2.common.base.Objects;
import com.applovin.exoplayer2.g;
import com.applovin.exoplayer2.l.a;

public final class ax extends aq {
    public static final g.a<ax> br = new ax$$ExternalSyntheticLambda0();
    private final int in;
    private final float io;

    public ax(int i) {
        a.checkArgument(i > 0, "maxStars must be a positive integer");
        this.in = i;
        this.io = -1.0f;
    }

    public ax(int i, float f) {
        boolean z = true;
        a.checkArgument(i > 0, "maxStars must be a positive integer");
        a.checkArgument((f < 0.0f || f > ((float) i)) ? false : z, "starRating is out of range [0, maxStars]");
        this.in = i;
        this.io = f;
    }

    public int hashCode() {
        return Objects.hashCode(Integer.valueOf(this.in), Float.valueOf(this.io));
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof ax)) {
            return false;
        }
        ax axVar = (ax) obj;
        if (this.in == axVar.in && this.io == axVar.io) {
            return true;
        }
        return false;
    }

    /* access modifiers changed from: private */
    public static ax o(Bundle bundle) {
        boolean z = false;
        if (bundle.getInt(t(0), -1) == 2) {
            z = true;
        }
        a.checkArgument(z);
        int i = bundle.getInt(t(1), 5);
        float f = bundle.getFloat(t(2), -1.0f);
        if (f == -1.0f) {
            return new ax(i);
        }
        return new ax(i, f);
    }

    private static String t(int i) {
        return Integer.toString(i, 36);
    }
}
