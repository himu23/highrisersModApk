package com.fyber.inneractive.sdk.player.exoplayer2.source.chunk;

import com.fyber.inneractive.sdk.player.exoplayer2.i;
import com.fyber.inneractive.sdk.player.exoplayer2.upstream.g;
import com.fyber.inneractive.sdk.player.exoplayer2.upstream.j;
import com.fyber.inneractive.sdk.player.exoplayer2.upstream.x;

public abstract class a implements x.c {
    public final j a;
    public final int b;
    public final i c;
    public final int d;
    public final Object e;
    public final long f;
    public final long g;
    public final g h;

    public a(g gVar, j jVar, int i, i iVar, int i2, Object obj, long j, long j2) {
        this.h = (g) com.fyber.inneractive.sdk.player.exoplayer2.util.a.a(gVar);
        this.a = (j) com.fyber.inneractive.sdk.player.exoplayer2.util.a.a(jVar);
        this.b = i;
        this.c = iVar;
        this.d = i2;
        this.e = obj;
        this.f = j;
        this.g = j2;
    }

    public abstract long c();
}
