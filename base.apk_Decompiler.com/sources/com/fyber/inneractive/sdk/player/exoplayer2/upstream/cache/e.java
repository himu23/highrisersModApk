package com.fyber.inneractive.sdk.player.exoplayer2.upstream.cache;

import com.fyber.inneractive.sdk.player.exoplayer2.upstream.cache.d;
import com.fyber.inneractive.sdk.player.exoplayer2.upstream.f;
import com.fyber.inneractive.sdk.player.exoplayer2.upstream.g;

public final class e implements g.a {
    public final a a;
    public final g.a b;
    public final g.a c;
    public final f.a d;

    public e(a aVar, g.a aVar2, g.a aVar3, f.a aVar4, int i, d.a aVar5) {
        this.a = aVar;
        this.b = aVar2;
        this.c = aVar3;
        this.d = aVar4;
    }

    public g a() {
        b bVar;
        a aVar = this.a;
        g a2 = this.b.a();
        g a3 = this.c.a();
        f.a aVar2 = this.d;
        if (aVar2 != null) {
            c cVar = (c) aVar2;
            bVar = new b(cVar.a, cVar.b, 20480);
        } else {
            bVar = null;
        }
        return new d(aVar, a2, a3, bVar, 2, (d.a) null);
    }
}
