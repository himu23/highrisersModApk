package com.applovin.exoplayer2;

import com.applovin.exoplayer2.h.ad;
import com.applovin.exoplayer2.j.d;
import com.applovin.exoplayer2.k.b;
import com.applovin.exoplayer2.k.m;
import com.applovin.exoplayer2.l.a;
import com.applovin.exoplayer2.l.ai;
import com.applovin.exoplayer2.l.q;
import com.ironsource.m2;
import com.ironsource.mediationsdk.demandOnly.e;

public class l implements aa {
    private final m aM;
    private final long aN;
    private final long aO;
    private final long aP;
    private final long aQ;
    private final int aR;
    private final boolean aS;
    private final long aT;
    private final boolean aU;
    private int aV;
    private boolean aW;

    public b ar() {
        return this.aM;
    }

    public long as() {
        return this.aT;
    }

    public boolean at() {
        return this.aU;
    }

    public l() {
        this(new m(true, 65536), m2.b.d, m2.b.d, e.b.p, 5000, -1, false, 0, false);
    }

    protected l(m mVar, int i, int i2, int i3, int i4, int i5, boolean z, int i6, boolean z2) {
        a(i3, 0, "bufferForPlaybackMs", "0");
        a(i4, 0, "bufferForPlaybackAfterRebufferMs", "0");
        a(i, i3, "minBufferMs", "bufferForPlaybackMs");
        a(i, i4, "minBufferMs", "bufferForPlaybackAfterRebufferMs");
        a(i2, i, "maxBufferMs", "minBufferMs");
        a(i6, 0, "backBufferDurationMs", "0");
        this.aM = mVar;
        this.aN = h.g((long) i);
        this.aO = h.g((long) i2);
        this.aP = h.g((long) i3);
        this.aQ = h.g((long) i4);
        this.aR = i5;
        this.aV = i5 == -1 ? 13107200 : i5;
        this.aS = z;
        this.aT = h.g((long) i6);
        this.aU = z2;
    }

    public void ap() {
        e(false);
    }

    public void a(ar[] arVarArr, ad adVar, d[] dVarArr) {
        int i = this.aR;
        if (i == -1) {
            i = a(arVarArr, dVarArr);
        }
        this.aV = i;
        this.aM.fj(i);
    }

    public void ab() {
        e(true);
    }

    public void aq() {
        e(true);
    }

    public boolean b(long j, long j2, float f) {
        boolean z = true;
        boolean z2 = this.aM.ok() >= this.aV;
        long j3 = this.aN;
        if (f > 1.0f) {
            j3 = Math.min(ai.a(j3, f), this.aO);
        }
        if (j2 < Math.max(j3, 500000)) {
            if (!this.aS && z2) {
                z = false;
            }
            this.aW = z;
            if (!z && j2 < 500000) {
                q.h("DefaultLoadControl", "Target buffer size reached with less than 500ms of buffered media data.");
            }
        } else if (j2 >= this.aO || z2) {
            this.aW = false;
        }
        return this.aW;
    }

    public boolean a(long j, float f, boolean z, long j2) {
        long b = ai.b(j, f);
        long j3 = z ? this.aQ : this.aP;
        if (j2 != -9223372036854775807L) {
            j3 = Math.min(j2 / 2, j3);
        }
        return j3 <= 0 || b >= j3 || (!this.aS && this.aM.ok() >= this.aV);
    }

    /* access modifiers changed from: protected */
    public int a(ar[] arVarArr, d[] dVarArr) {
        int i = 0;
        for (int i2 = 0; i2 < arVarArr.length; i2++) {
            if (dVarArr[i2] != null) {
                i += s(arVarArr[i2].M());
            }
        }
        return Math.max(13107200, i);
    }

    private void e(boolean z) {
        int i = this.aR;
        if (i == -1) {
            i = 13107200;
        }
        this.aV = i;
        this.aW = false;
        if (z) {
            this.aM.Y();
        }
    }

    private static int s(int i) {
        switch (i) {
            case -2:
                return 0;
            case 0:
                return 144310272;
            case 1:
                return 13107200;
            case 2:
                return 131072000;
            case 3:
            case 4:
            case 5:
            case 6:
                return 131072;
            default:
                throw new IllegalArgumentException();
        }
    }

    private static void a(int i, int i2, String str, String str2) {
        boolean z = i >= i2;
        a.checkArgument(z, str + " cannot be less than " + str2);
    }
}
