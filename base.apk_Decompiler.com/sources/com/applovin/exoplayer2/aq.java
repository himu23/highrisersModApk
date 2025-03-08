package com.applovin.exoplayer2;

import android.os.Bundle;
import com.applovin.exoplayer2.g;

public abstract class aq implements g {
    public static final g.a<aq> br = new aq$$ExternalSyntheticLambda0();

    aq() {
    }

    /* access modifiers changed from: private */
    public static aq n(Bundle bundle) {
        int i = bundle.getInt(t(0), -1);
        if (i == 0) {
            return x.br.fromBundle(bundle);
        }
        if (i == 1) {
            return aj.br.fromBundle(bundle);
        }
        if (i == 2) {
            return ax.br.fromBundle(bundle);
        }
        if (i == 3) {
            return az.br.fromBundle(bundle);
        }
        throw new IllegalArgumentException("Encountered unknown rating type: " + i);
    }

    private static String t(int i) {
        return Integer.toString(i, 36);
    }
}
