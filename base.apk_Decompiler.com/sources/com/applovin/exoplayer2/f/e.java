package com.applovin.exoplayer2.f;

import com.applovin.exoplayer2.b.r;
import com.applovin.exoplayer2.c.g;
import com.applovin.exoplayer2.l.a;
import com.applovin.exoplayer2.l.q;
import com.applovin.exoplayer2.v;
import java.nio.ByteBuffer;
import kotlin.UByte;

final class e {
    private long Hd;
    private long He;
    private boolean Hf;

    public void Y() {
        this.Hd = 0;
        this.He = 0;
        this.Hf = false;
    }

    e() {
    }

    public long a(v vVar, g gVar) {
        if (this.He == 0) {
            this.Hd = gVar.rJ;
        }
        if (this.Hf) {
            return gVar.rJ;
        }
        ByteBuffer byteBuffer = (ByteBuffer) a.checkNotNull(gVar.rH);
        byte b = 0;
        for (int i = 0; i < 4; i++) {
            b = (b << 8) | (byteBuffer.get(i) & UByte.MAX_VALUE);
        }
        int aH = r.aH(b);
        if (aH == -1) {
            this.Hf = true;
            this.He = 0;
            this.Hd = gVar.rJ;
            q.h("C2Mp3TimestampTracker", "MPEG audio header is invalid.");
            return gVar.rJ;
        }
        long aK = aK((long) vVar.dM);
        this.He += (long) aH;
        return aK;
    }

    public long k(v vVar) {
        return aK((long) vVar.dM);
    }

    private long aK(long j) {
        return this.Hd + Math.max(0, ((this.He - 529) * 1000000) / j);
    }
}
