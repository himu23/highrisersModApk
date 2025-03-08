package com.applovin.exoplayer2.l;

public final class ag {
    private long CD;
    private long acS;
    private long acT;
    private final ThreadLocal<Long> acU = new ThreadLocal<>();

    public ag(long j) {
        aI(j);
    }

    public synchronized long pS() {
        long j;
        j = this.CD;
        if (j == Long.MAX_VALUE || j == 9223372036854775806L) {
            j = -9223372036854775807L;
        }
        return j;
    }

    public synchronized long pT() {
        long j;
        j = this.acT;
        return j != -9223372036854775807L ? j + this.acS : pS();
    }

    public synchronized long pU() {
        return this.acS;
    }

    public synchronized void aI(long j) {
        this.CD = j;
        this.acS = j == Long.MAX_VALUE ? 0 : -9223372036854775807L;
        this.acT = -9223372036854775807L;
    }

    public synchronized long br(long j) {
        if (j == -9223372036854775807L) {
            return -9223372036854775807L;
        }
        long j2 = this.acT;
        if (j2 != -9223372036854775807L) {
            long bu = bu(j2);
            long j3 = (4294967296L + bu) / 8589934592L;
            long j4 = ((j3 - 1) * 8589934592L) + j;
            j += j3 * 8589934592L;
            if (Math.abs(j4 - bu) < Math.abs(j - bu)) {
                j = j4;
            }
        }
        return bs(bt(j));
    }

    public synchronized long bs(long j) {
        if (j == -9223372036854775807L) {
            return -9223372036854775807L;
        }
        if (this.acS == -9223372036854775807L) {
            long j2 = this.CD;
            if (j2 == 9223372036854775806L) {
                j2 = ((Long) a.checkNotNull(this.acU.get())).longValue();
            }
            this.acS = j2 - j;
            notifyAll();
        }
        this.acT = j;
        return j + this.acS;
    }

    public static long bt(long j) {
        return (j * 1000000) / 90000;
    }

    public static long bu(long j) {
        return (j * 90000) / 1000000;
    }
}
