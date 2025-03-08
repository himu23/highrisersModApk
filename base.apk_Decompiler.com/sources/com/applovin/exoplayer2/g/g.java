package com.applovin.exoplayer2.g;

import com.applovin.exoplayer2.l.a;
import java.nio.ByteBuffer;

public abstract class g implements b {
    /* access modifiers changed from: protected */
    public abstract a a(d dVar, ByteBuffer byteBuffer);

    public final a a(d dVar) {
        ByteBuffer byteBuffer = (ByteBuffer) a.checkNotNull(dVar.rH);
        a.checkArgument(byteBuffer.position() == 0 && byteBuffer.hasArray() && byteBuffer.arrayOffset() == 0);
        if (dVar.gX()) {
            return null;
        }
        return a(dVar, byteBuffer);
    }
}
