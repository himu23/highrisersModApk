package com.applovin.exoplayer2.m.a;

import android.media.MediaFormat;
import com.applovin.exoplayer2.l.af;
import com.applovin.exoplayer2.m.l;
import com.applovin.exoplayer2.v;
import java.util.Arrays;
import java.util.concurrent.atomic.AtomicBoolean;

final class h implements a, l {
    private final AtomicBoolean afL;
    private final c afM;
    private final af<Long> afN;
    private final af<e> afO;
    private volatile int afP;
    private int afQ;
    private byte[] afR;

    public void setDefaultStereoMode(int i) {
        this.afP = i;
    }

    public void a(long j, long j2, v vVar, MediaFormat mediaFormat) {
        this.afN.a(j2, Long.valueOf(j));
        a(vVar.dI, vVar.dJ, j2);
    }

    public void a(long j, float[] fArr) {
        this.afM.b(j, fArr);
    }

    public void cZ() {
        this.afN.clear();
        this.afM.Y();
        this.afL.set(true);
    }

    private void a(byte[] bArr, int i, long j) {
        byte[] bArr2 = this.afR;
        int i2 = this.afQ;
        this.afR = bArr;
        if (i == -1) {
            i = this.afP;
        }
        this.afQ = i;
        if (i2 != i || !Arrays.equals(bArr2, this.afR)) {
            byte[] bArr3 = this.afR;
            e m = bArr3 != null ? f.m(bArr3, this.afQ) : null;
            if (m == null || !g.a(m)) {
                m = e.fT(this.afQ);
            }
            this.afO.a(j, m);
        }
    }
}
