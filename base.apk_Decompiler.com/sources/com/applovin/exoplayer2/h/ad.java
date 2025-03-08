package com.applovin.exoplayer2.h;

import android.os.Bundle;
import com.applovin.exoplayer2.common.a.s;
import com.applovin.exoplayer2.g;
import com.applovin.exoplayer2.l.c;
import java.util.Arrays;
import java.util.List;

public final class ad implements g {
    public static final ad NG = new ad(new ac[0]);
    public static final g.a<ad> br = new ad$$ExternalSyntheticLambda0();
    private final ac[] NH;
    private int dS;
    public final int fR;

    public boolean isEmpty() {
        return this.fR == 0;
    }

    public ad(ac... acVarArr) {
        this.NH = acVarArr;
        this.fR = acVarArr.length;
    }

    public ac eb(int i) {
        return this.NH[i];
    }

    public int a(ac acVar) {
        for (int i = 0; i < this.fR; i++) {
            if (this.NH[i] == acVar) {
                return i;
            }
        }
        return -1;
    }

    public int hashCode() {
        if (this.dS == 0) {
            this.dS = Arrays.hashCode(this.NH);
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
        ad adVar = (ad) obj;
        if (this.fR != adVar.fR || !Arrays.equals(this.NH, adVar.NH)) {
            return false;
        }
        return true;
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ ad w(Bundle bundle) {
        return new ad((ac[]) c.a(ac.br, (List<Bundle>) bundle.getParcelableArrayList(t(0)), s.ga()).toArray(new ac[0]));
    }

    private static String t(int i) {
        return Integer.toString(i, 36);
    }
}
