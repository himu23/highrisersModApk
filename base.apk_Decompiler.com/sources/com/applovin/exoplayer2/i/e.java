package com.applovin.exoplayer2.i;

import com.applovin.exoplayer2.c.i;

final class e extends k {
    private final i.a<k> Os;

    public e(i.a<k> aVar) {
        this.Os = aVar;
    }

    public final void release() {
        this.Os.releaseOutputBuffer(this);
    }
}
