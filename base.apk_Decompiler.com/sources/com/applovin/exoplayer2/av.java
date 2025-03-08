package com.applovin.exoplayer2;

import com.applovin.exoplayer2.l.a;
import com.applovin.exoplayer2.l.ai;

public final class av {
    public static final av hj;
    public static final av hk = new av(Long.MAX_VALUE, Long.MAX_VALUE);
    public static final av hl = new av(Long.MAX_VALUE, 0);

    /* renamed from: hm  reason: collision with root package name */
    public static final av f19hm = new av(0, Long.MAX_VALUE);
    public static final av hn;
    public final long ho;
    public final long hp;

    public int hashCode() {
        return (((int) this.ho) * 31) + ((int) this.hp);
    }

    static {
        av avVar = new av(0, 0);
        hj = avVar;
        hn = avVar;
    }

    public av(long j, long j2) {
        boolean z = true;
        a.checkArgument(j >= 0);
        a.checkArgument(j2 < 0 ? false : z);
        this.ho = j;
        this.hp = j2;
    }

    public long a(long j, long j2, long j3) {
        long j4 = this.ho;
        if (j4 == 0 && this.hp == 0) {
            return j;
        }
        long d = ai.d(j, j4, Long.MIN_VALUE);
        long c = ai.c(j, this.hp, Long.MAX_VALUE);
        boolean z = true;
        boolean z2 = d <= j2 && j2 <= c;
        if (d > j3 || j3 > c) {
            z = false;
        }
        if (z2 && z) {
            return Math.abs(j2 - j) <= Math.abs(j3 - j) ? j2 : j3;
        }
        if (z2) {
            return j2;
        }
        return z ? j3 : d;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        av avVar = (av) obj;
        if (this.ho == avVar.ho && this.hp == avVar.hp) {
            return true;
        }
        return false;
    }
}
