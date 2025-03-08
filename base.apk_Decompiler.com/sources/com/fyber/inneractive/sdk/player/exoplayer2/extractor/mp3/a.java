package com.fyber.inneractive.sdk.player.exoplayer2.extractor.mp3;

import com.fyber.inneractive.sdk.player.exoplayer2.extractor.mp3.b;
import com.fyber.inneractive.sdk.player.exoplayer2.util.u;

public final class a implements b.a {
    public final long a;
    public final int b;
    public final long c;

    public a(long j, int i, long j2) {
        long j3;
        this.a = j;
        this.b = i;
        if (j2 == -1) {
            j3 = -9223372036854775807L;
        } else {
            j3 = b(j2);
        }
        this.c = j3;
    }

    public boolean a() {
        return this.c != -9223372036854775807L;
    }

    public long b(long j) {
        return (Math.max(0, j - this.a) * 8000000) / ((long) this.b);
    }

    public long c() {
        return this.c;
    }

    public long a(long j) {
        long j2 = this.c;
        if (j2 == -9223372036854775807L) {
            return 0;
        }
        int i = u.a;
        return this.a + ((Math.max(0, Math.min(j, j2)) * ((long) this.b)) / 8000000);
    }
}
