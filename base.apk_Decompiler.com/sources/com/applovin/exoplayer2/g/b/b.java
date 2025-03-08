package com.applovin.exoplayer2.g.b;

import com.applovin.exoplayer2.g.a;
import com.applovin.exoplayer2.g.d;
import com.applovin.exoplayer2.g.g;
import com.applovin.exoplayer2.l.y;
import java.nio.ByteBuffer;
import java.util.Arrays;

public final class b extends g {
    /* access modifiers changed from: protected */
    public a a(d dVar, ByteBuffer byteBuffer) {
        return new a(W(new y(byteBuffer.array(), byteBuffer.limit())));
    }

    public a W(y yVar) {
        return new a((String) com.applovin.exoplayer2.l.a.checkNotNull(yVar.pI()), (String) com.applovin.exoplayer2.l.a.checkNotNull(yVar.pI()), yVar.pz(), yVar.pz(), Arrays.copyOfRange(yVar.hO(), yVar.il(), yVar.pk()));
    }
}
