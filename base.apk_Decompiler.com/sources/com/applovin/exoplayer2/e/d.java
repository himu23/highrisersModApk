package com.applovin.exoplayer2.e;

import com.applovin.exoplayer2.e.v;

public class d implements v {
    private final int dv;
    private final long fH;
    private final int jz;
    private final long tV;
    private final long tW;
    private final long tX;
    private final boolean tY;

    public long dd() {
        return this.fH;
    }

    public boolean hU() {
        return this.tX != -1 || this.tY;
    }

    public d(long j, long j2, int i, int i2, boolean z) {
        this.tV = j;
        this.tW = j2;
        this.jz = i2 == -1 ? 1 : i2;
        this.dv = i;
        this.tY = z;
        if (j == -1) {
            this.tX = -1;
            this.fH = -9223372036854775807L;
            return;
        }
        this.tX = j - j2;
        this.fH = a(j, j2, i);
    }

    public v.a ai(long j) {
        if (this.tX == -1 && !this.tY) {
            return new v.a(new w(0, this.tW));
        }
        long am = am(j);
        long al = al(am);
        w wVar = new w(al, am);
        if (this.tX != -1 && al < j) {
            int i = this.jz;
            if (((long) i) + am < this.tV) {
                long j2 = am + ((long) i);
                return new v.a(wVar, new w(al(j2), j2));
            }
        }
        return new v.a(wVar);
    }

    public long al(long j) {
        return a(j, this.tW, this.dv);
    }

    private static long a(long j, long j2, int i) {
        return (Math.max(0, j - j2) * 8000000) / ((long) i);
    }

    private long am(long j) {
        int i = this.jz;
        long j2 = (((j * ((long) this.dv)) / 8000000) / ((long) i)) * ((long) i);
        long j3 = this.tX;
        if (j3 != -1) {
            j2 = Math.min(j2, j3 - ((long) i));
        }
        return this.tW + Math.max(j2, 0);
    }
}
