package com.fyber.inneractive.sdk.player.exoplayer2.source;

public final class h implements p {
    public final p[] a;

    public h(p[] pVarArr) {
        this.a = pVarArr;
    }

    public long a() {
        long j = Long.MAX_VALUE;
        for (p a2 : this.a) {
            long a3 = a2.a();
            if (a3 != Long.MIN_VALUE) {
                j = Math.min(j, a3);
            }
        }
        if (j == Long.MAX_VALUE) {
            return Long.MIN_VALUE;
        }
        return j;
    }

    public boolean a(long j) {
        boolean z;
        boolean z2 = false;
        do {
            long a2 = a();
            if (a2 == Long.MIN_VALUE) {
                break;
            }
            z = false;
            for (p pVar : this.a) {
                if (pVar.a() == a2) {
                    z |= pVar.a(j);
                }
            }
            z2 |= z;
        } while (z);
        return z2;
    }
}
