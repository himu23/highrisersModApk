package com.applovin.exoplayer2;

import android.os.Bundle;
import com.applovin.exoplayer2.g;
import com.applovin.exoplayer2.l.a;
import com.applovin.exoplayer2.l.ai;
import com.ironsource.mediationsdk.logger.IronSourceError;

public final class am implements g {
    public static final g.a<am> br = new am$$ExternalSyntheticLambda0();
    public static final am gC = new am(1.0f);
    public final float gD;
    public final float gE;
    private final int gF;

    public long x(long j) {
        return j * ((long) this.gF);
    }

    public am(float f) {
        this(f, 1.0f);
    }

    public am(float f, float f2) {
        boolean z = true;
        a.checkArgument(f > 0.0f);
        a.checkArgument(f2 <= 0.0f ? false : z);
        this.gD = f;
        this.gE = f2;
        this.gF = Math.round(f * 1000.0f);
    }

    public am f(float f) {
        return new am(f, this.gE);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        am amVar = (am) obj;
        if (this.gD == amVar.gD && this.gE == amVar.gE) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return ((IronSourceError.ERROR_NON_EXISTENT_INSTANCE + Float.floatToRawIntBits(this.gD)) * 31) + Float.floatToRawIntBits(this.gE);
    }

    public String toString() {
        return ai.a("PlaybackParameters(speed=%.2f, pitch=%.2f)", Float.valueOf(this.gD), Float.valueOf(this.gE));
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ am k(Bundle bundle) {
        return new am(bundle.getFloat(t(0), 1.0f), bundle.getFloat(t(1), 1.0f));
    }

    private static String t(int i) {
        return Integer.toString(i, 36);
    }
}
