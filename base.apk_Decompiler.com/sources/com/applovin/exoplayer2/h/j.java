package com.applovin.exoplayer2.h;

import android.net.Uri;
import com.applovin.exoplayer2.k.l;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

public final class j {
    private static final AtomicLong Lp = new AtomicLong();
    public final long Lq;
    public final long Lr;
    public final long Ls;
    public final Uri ef;
    public final l tw;
    public final Map<String, List<String>> ty;
    public final long tz;

    public static long kV() {
        return Lp.getAndIncrement();
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public j(long r13, com.applovin.exoplayer2.k.l r15, long r16) {
        /*
            r12 = this;
            r3 = r15
            android.net.Uri r4 = r3.ef
            java.util.Map r5 = java.util.Collections.emptyMap()
            r8 = 0
            r10 = 0
            r0 = r12
            r1 = r13
            r6 = r16
            r0.<init>(r1, r3, r4, r5, r6, r8, r10)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.applovin.exoplayer2.h.j.<init>(long, com.applovin.exoplayer2.k.l, long):void");
    }

    public j(long j, l lVar, Uri uri, Map<String, List<String>> map, long j2, long j3, long j4) {
        this.Lq = j;
        this.tw = lVar;
        this.ef = uri;
        this.ty = map;
        this.Lr = j2;
        this.Ls = j3;
        this.tz = j4;
    }
}
