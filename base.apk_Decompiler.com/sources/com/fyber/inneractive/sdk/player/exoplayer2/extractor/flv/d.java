package com.fyber.inneractive.sdk.player.exoplayer2.extractor.flv;

import com.fyber.inneractive.sdk.player.exoplayer2.extractor.n;
import com.fyber.inneractive.sdk.player.exoplayer2.l;
import com.fyber.inneractive.sdk.player.exoplayer2.util.k;

public abstract class d {
    public final n a;

    public static final class a extends l {
        public a(String str) {
            super(str);
        }
    }

    public d(n nVar) {
        this.a = nVar;
    }

    public final void a(k kVar, long j) throws l {
        if (a(kVar)) {
            b(kVar, j);
        }
    }

    public abstract boolean a(k kVar) throws l;

    public abstract void b(k kVar, long j) throws l;
}
