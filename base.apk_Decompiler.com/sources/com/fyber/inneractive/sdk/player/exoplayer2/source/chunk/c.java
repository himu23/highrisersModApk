package com.fyber.inneractive.sdk.player.exoplayer2.source.chunk;

import com.fyber.inneractive.sdk.player.exoplayer2.extractor.hls.c;
import com.fyber.inneractive.sdk.player.exoplayer2.i;
import com.fyber.inneractive.sdk.player.exoplayer2.upstream.g;
import com.fyber.inneractive.sdk.player.exoplayer2.upstream.j;
import com.fyber.inneractive.sdk.player.exoplayer2.util.u;
import java.io.IOException;
import java.util.Arrays;

public abstract class c extends a {
    public byte[] i;
    public int j;
    public volatile boolean k;

    public c(g gVar, j jVar, int i2, i iVar, int i3, Object obj, byte[] bArr) {
        super(gVar, jVar, i2, iVar, i3, obj, -9223372036854775807L, -9223372036854775807L);
        this.i = bArr;
    }

    public final boolean a() {
        return this.k;
    }

    public final void b() {
        this.k = true;
    }

    public long c() {
        return (long) this.j;
    }

    public final void load() throws IOException, InterruptedException {
        try {
            this.h.a(this.a);
            this.j = 0;
            while (!this.k) {
                byte[] bArr = this.i;
                if (bArr == null) {
                    this.i = new byte[16384];
                } else if (bArr.length < this.j + 16384) {
                    this.i = Arrays.copyOf(bArr, bArr.length + 16384);
                }
                int a = this.h.a(this.i, this.j, 16384);
                if (a != -1) {
                    this.j += a;
                }
                if (a == -1) {
                    break;
                }
            }
            if (!this.k) {
                ((c.a) this).m = Arrays.copyOf(this.i, this.j);
            }
        } finally {
            u.a(this.h);
        }
    }
}
