package com.fyber.inneractive.sdk.player.exoplayer2.source.chunk;

import com.fyber.inneractive.sdk.player.exoplayer2.i;
import com.fyber.inneractive.sdk.player.exoplayer2.upstream.g;
import com.fyber.inneractive.sdk.player.exoplayer2.upstream.j;
import com.fyber.inneractive.sdk.player.exoplayer2.util.a;

public abstract class d extends a {
    public final int i;

    public d(g gVar, j jVar, i iVar, int i2, Object obj, long j, long j2, int i3) {
        super(gVar, jVar, 1, iVar, i2, obj, j, j2);
        a.a(iVar);
        this.i = i3;
    }
}
