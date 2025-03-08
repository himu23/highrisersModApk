package com.fyber.inneractive.sdk.player.exoplayer2.extractor.ogg;

import com.fyber.inneractive.sdk.player.exoplayer2.extractor.g;
import com.fyber.inneractive.sdk.player.exoplayer2.extractor.m;
import com.fyber.inneractive.sdk.player.exoplayer2.extractor.n;
import com.fyber.inneractive.sdk.player.exoplayer2.i;
import com.fyber.inneractive.sdk.player.exoplayer2.util.k;
import java.io.IOException;

public abstract class h {
    public d a;
    public n b;
    public com.fyber.inneractive.sdk.player.exoplayer2.extractor.h c;
    public f d;
    public long e;
    public long f;
    public long g;
    public int h;
    public int i;
    public a j;
    public long k;
    public boolean l;
    public boolean m;

    public static class a {
        public i a;
        public f b;
    }

    public static final class b implements f {
        public long a(g gVar) throws IOException, InterruptedException {
            return -1;
        }

        public m b() {
            return new m.a(-9223372036854775807L);
        }

        public long c(long j) {
            return 0;
        }
    }

    public abstract long a(k kVar);

    public void a(boolean z) {
        if (z) {
            this.j = new a();
            this.f = 0;
            this.h = 0;
        } else {
            this.h = 1;
        }
        this.e = -1;
        this.g = 0;
    }

    public abstract boolean a(k kVar, long j2, a aVar) throws IOException, InterruptedException;

    public void b(long j2) {
        this.g = j2;
    }

    public long a(long j2) {
        return (((long) this.i) * j2) / 1000000;
    }
}
