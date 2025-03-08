package com.fyber.inneractive.sdk.player.cache;

import com.fyber.inneractive.sdk.config.global.s;
import com.fyber.inneractive.sdk.player.cache.d;
import com.fyber.inneractive.sdk.player.exoplayer2.upstream.g;

public class e implements g.a {
    public final d.c a;
    public d.b b;
    public final int c;
    public final s d;

    public e(d.b bVar, d.c cVar, int i, s sVar) {
        this.b = bVar;
        this.c = i;
        this.a = cVar;
        this.d = sVar;
    }

    public g a() {
        d dVar = new d();
        dVar.h = this.b;
        dVar.j = this.c;
        dVar.k = this.d;
        dVar.i = this.a;
        return dVar;
    }
}
