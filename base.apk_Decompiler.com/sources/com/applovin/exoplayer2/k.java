package com.applovin.exoplayer2;

import android.os.SystemClock;
import com.applovin.exoplayer2.ab;
import com.applovin.exoplayer2.common.b.d;
import com.applovin.exoplayer2.l.ai;

public final class k implements z {
    private long aA;
    private long aB;
    private long aC;
    private long aD;
    private float aE;
    private float aF;
    private float aG;
    private long aH;
    private long aI;
    private long aJ;
    private final float ar;
    private final float as;
    private final long at;
    private final float au;
    private final long av;
    private final long aw;
    private final float ax;
    private long ay;
    private long az;

    private static long a(long j, long j2, float f) {
        return (long) ((((float) j) * f) + ((1.0f - f) * ((float) j2)));
    }

    private void an() {
        long j = this.ay;
        if (j != -9223372036854775807L) {
            long j2 = this.az;
            if (j2 != -9223372036854775807L) {
                j = j2;
            }
            long j3 = this.aB;
            if (j3 != -9223372036854775807L && j < j3) {
                j = j3;
            }
            long j4 = this.aC;
            if (j4 != -9223372036854775807L && j > j4) {
                j = j4;
            }
        } else {
            j = -9223372036854775807L;
        }
        if (this.aA != j) {
            this.aA = j;
            this.aD = j;
            this.aI = -9223372036854775807L;
            this.aJ = -9223372036854775807L;
            this.aH = -9223372036854775807L;
        }
    }

    public void al() {
        long j = this.aD;
        if (j != -9223372036854775807L) {
            long j2 = j + this.aw;
            this.aD = j2;
            long j3 = this.aC;
            if (j3 != -9223372036854775807L && j2 > j3) {
                this.aD = j3;
            }
            this.aH = -9223372036854775807L;
        }
    }

    public long am() {
        return this.aD;
    }

    public static final class a {
        private float aK = 1.0E-7f;
        private long aL = h.g(500);
        private float ar = 0.97f;
        private float as = 1.03f;
        private long at = 1000;
        private long av = h.g(20);
        private float ax = 0.999f;

        public k ao() {
            return new k(this.ar, this.as, this.at, this.aK, this.av, this.aL, this.ax);
        }
    }

    private k(float f, float f2, long j, float f3, long j2, long j3, float f4) {
        this.ar = f;
        this.as = f2;
        this.at = j;
        this.au = f3;
        this.av = j2;
        this.aw = j3;
        this.ax = f4;
        this.ay = -9223372036854775807L;
        this.az = -9223372036854775807L;
        this.aB = -9223372036854775807L;
        this.aC = -9223372036854775807L;
        this.aF = f;
        this.aE = f2;
        this.aG = 1.0f;
        this.aH = -9223372036854775807L;
        this.aA = -9223372036854775807L;
        this.aD = -9223372036854775807L;
        this.aI = -9223372036854775807L;
        this.aJ = -9223372036854775807L;
    }

    public void a(ab.e eVar) {
        this.ay = h.g(eVar.eI);
        this.aB = h.g(eVar.eJ);
        this.aC = h.g(eVar.eK);
        this.aF = eVar.aF != -3.4028235E38f ? eVar.aF : this.ar;
        this.aE = eVar.aE != -3.4028235E38f ? eVar.aE : this.as;
        an();
    }

    public void h(long j) {
        this.az = j;
        an();
    }

    public float a(long j, long j2) {
        if (this.ay == -9223372036854775807L) {
            return 1.0f;
        }
        b(j, j2);
        if (this.aH != -9223372036854775807L && SystemClock.elapsedRealtime() - this.aH < this.at) {
            return this.aG;
        }
        this.aH = SystemClock.elapsedRealtime();
        i(j);
        long j3 = j - this.aD;
        if (Math.abs(j3) < this.av) {
            this.aG = 1.0f;
        } else {
            this.aG = ai.a((this.au * ((float) j3)) + 1.0f, this.aF, this.aE);
        }
        return this.aG;
    }

    private void b(long j, long j2) {
        long j3 = j - j2;
        long j4 = this.aI;
        if (j4 == -9223372036854775807L) {
            this.aI = j3;
            this.aJ = 0;
            return;
        }
        long max = Math.max(j3, a(j4, j3, this.ax));
        this.aI = max;
        this.aJ = a(this.aJ, Math.abs(j3 - max), this.ax);
    }

    private void i(long j) {
        long j2 = this.aI + (this.aJ * 3);
        if (this.aD > j2) {
            float g = (float) h.g(this.at);
            this.aD = d.a(j2, this.aA, this.aD - (((long) ((this.aG - 1.0f) * g)) + ((long) ((this.aE - 1.0f) * g))));
            return;
        }
        long b = ai.b(j - ((long) (Math.max(0.0f, this.aG - 1.0f) / this.au)), this.aD, j2);
        this.aD = b;
        long j3 = this.aC;
        if (j3 != -9223372036854775807L && b > j3) {
            this.aD = j3;
        }
    }
}
