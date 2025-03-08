package com.applovin.exoplayer2.j;

import com.applovin.exoplayer2.h.ac;
import com.applovin.exoplayer2.j.d;
import com.applovin.exoplayer2.l.a;
import com.applovin.exoplayer2.v;
import java.util.Arrays;

public abstract class b implements d {
    private final v[] NF;
    protected final ac Ud;
    protected final int[] Ue;
    private final long[] Uf;
    private final int bs;
    private int dS;
    protected final int fR;

    public void X() {
    }

    public /* synthetic */ void am(boolean z) {
        d.CC.$default$am(this, z);
    }

    public void enable() {
    }

    public final ac nf() {
        return this.Ud;
    }

    public /* synthetic */ void nn() {
        d.CC.$default$nn(this);
    }

    public /* synthetic */ void no() {
        d.CC.$default$no(this);
    }

    public void v(float f) {
    }

    public b(ac acVar, int[] iArr, int i) {
        int i2 = 0;
        a.checkState(iArr.length > 0);
        this.bs = i;
        this.Ud = (ac) a.checkNotNull(acVar);
        int length = iArr.length;
        this.fR = length;
        this.NF = new v[length];
        for (int i3 = 0; i3 < iArr.length; i3++) {
            this.NF[i3] = acVar.dZ(iArr[i3]);
        }
        Arrays.sort(this.NF, new b$$ExternalSyntheticLambda0());
        this.Ue = new int[this.fR];
        while (true) {
            int i4 = this.fR;
            if (i2 < i4) {
                this.Ue[i2] = acVar.w(this.NF[i2]);
                i2++;
            } else {
                this.Uf = new long[i4];
                return;
            }
        }
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ int b(v vVar, v vVar2) {
        return vVar2.dv - vVar.dv;
    }

    public final int kD() {
        return this.Ue.length;
    }

    public final v dZ(int i) {
        return this.NF[i];
    }

    public final int eP(int i) {
        return this.Ue[i];
    }

    public final v ng() {
        return this.NF[ne()];
    }

    public int hashCode() {
        if (this.dS == 0) {
            this.dS = (System.identityHashCode(this.Ud) * 31) + Arrays.hashCode(this.Ue);
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
        b bVar = (b) obj;
        if (this.Ud != bVar.Ud || !Arrays.equals(this.Ue, bVar.Ue)) {
            return false;
        }
        return true;
    }
}
