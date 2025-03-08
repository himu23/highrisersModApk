package com.fyber.inneractive.sdk.player.exoplayer2.trackselection;

import com.fyber.inneractive.sdk.player.exoplayer2.o;
import com.fyber.inneractive.sdk.player.exoplayer2.source.s;
import com.fyber.inneractive.sdk.player.exoplayer2.util.u;

public final class h {
    public final s a;
    public final f b;
    public final Object c;
    public final o[] d;

    public h(s sVar, f fVar, Object obj, o[] oVarArr) {
        this.a = sVar;
        this.b = fVar;
        this.c = obj;
        this.d = oVarArr;
    }

    public boolean a(h hVar, int i) {
        if (hVar != null && u.a((Object) this.b.b[i], (Object) hVar.b.b[i]) && u.a((Object) this.d[i], (Object) hVar.d[i])) {
            return true;
        }
        return false;
    }
}
