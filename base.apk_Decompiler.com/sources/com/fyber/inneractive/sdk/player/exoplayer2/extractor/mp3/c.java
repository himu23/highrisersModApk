package com.fyber.inneractive.sdk.player.exoplayer2.extractor.mp3;

import com.fyber.inneractive.sdk.player.exoplayer2.extractor.mp3.b;
import com.fyber.inneractive.sdk.player.exoplayer2.util.u;

public final class c implements b.a {
    public final long[] a;
    public final long[] b;
    public final long c;

    public c(long[] jArr, long[] jArr2, long j) {
        this.a = jArr;
        this.b = jArr2;
        this.c = j;
    }

    public long a(long j) {
        return this.b[u.b(this.a, j, true, true)];
    }

    public boolean a() {
        return true;
    }

    public long b(long j) {
        return this.a[u.b(this.b, j, true, true)];
    }

    public long c() {
        return this.c;
    }
}
