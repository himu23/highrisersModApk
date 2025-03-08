package com.applovin.exoplayer2.b;

import android.media.AudioAttributes;
import android.os.Bundle;
import com.applovin.exoplayer2.g;
import com.applovin.exoplayer2.l.ai;
import com.ironsource.mediationsdk.logger.IronSourceError;

public final class d implements g {
    public static final g.a<d> br = new d$$ExternalSyntheticLambda1();
    public static final d jD = new a().dB();
    public final int jE;
    public final int jF;
    public final int jG;
    public final int jH;
    private AudioAttributes jI;

    public int hashCode() {
        return ((((((IronSourceError.ERROR_NON_EXISTENT_INSTANCE + this.jE) * 31) + this.jF) * 31) + this.jG) * 31) + this.jH;
    }

    public static final class a {
        private int jE = 0;
        private int jF = 0;
        private int jG = 1;
        private int jH = 1;

        public a ar(int i) {
            this.jE = i;
            return this;
        }

        public a as(int i) {
            this.jF = i;
            return this;
        }

        public a at(int i) {
            this.jG = i;
            return this;
        }

        public a au(int i) {
            this.jH = i;
            return this;
        }

        public d dB() {
            return new d(this.jE, this.jF, this.jG, this.jH);
        }
    }

    private d(int i, int i2, int i3, int i4) {
        this.jE = i;
        this.jF = i2;
        this.jG = i3;
        this.jH = i4;
    }

    public AudioAttributes dA() {
        if (this.jI == null) {
            AudioAttributes.Builder usage = new AudioAttributes.Builder().setContentType(this.jE).setFlags(this.jF).setUsage(this.jG);
            if (ai.acV >= 29) {
                AudioAttributes.Builder unused = usage.setAllowedCapturePolicy(this.jH);
            }
            this.jI = usage.build();
        }
        return this.jI;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        d dVar = (d) obj;
        if (this.jE == dVar.jE && this.jF == dVar.jF && this.jG == dVar.jG && this.jH == dVar.jH) {
            return true;
        }
        return false;
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ d t(Bundle bundle) {
        a aVar = new a();
        if (bundle.containsKey(t(0))) {
            aVar.ar(bundle.getInt(t(0)));
        }
        if (bundle.containsKey(t(1))) {
            aVar.as(bundle.getInt(t(1)));
        }
        if (bundle.containsKey(t(2))) {
            aVar.at(bundle.getInt(t(2)));
        }
        if (bundle.containsKey(t(3))) {
            aVar.au(bundle.getInt(t(3)));
        }
        return aVar.dB();
    }

    private static String t(int i) {
        return Integer.toString(i, 36);
    }
}
