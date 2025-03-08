package com.applovin.exoplayer2.g.g;

import com.applovin.exoplayer2.g.a;
import com.applovin.exoplayer2.g.d;
import com.applovin.exoplayer2.g.g;
import com.applovin.exoplayer2.l.ag;
import com.applovin.exoplayer2.l.x;
import com.applovin.exoplayer2.l.y;
import java.nio.ByteBuffer;

public final class c extends g {
    private final y Fk = new y();
    private final x Kr = new x();
    private ag zS;

    /* access modifiers changed from: protected */
    public a a(d dVar, ByteBuffer byteBuffer) {
        a.C0047a aVar;
        if (this.zS == null || dVar.dD != this.zS.pU()) {
            ag agVar = new ag(dVar.rJ);
            this.zS = agVar;
            agVar.bs(dVar.rJ - dVar.dD);
        }
        byte[] array = byteBuffer.array();
        int limit = byteBuffer.limit();
        this.Fk.l(array, limit);
        this.Kr.l(array, limit);
        this.Kr.bR(39);
        long bQ = (((long) this.Kr.bQ(1)) << 32) | ((long) this.Kr.bQ(32));
        this.Kr.bR(20);
        int bQ2 = this.Kr.bQ(12);
        int bQ3 = this.Kr.bQ(8);
        this.Fk.fz(14);
        if (bQ3 == 0) {
            aVar = new e();
        } else if (bQ3 == 255) {
            aVar = a.a(this.Fk, bQ2, bQ);
        } else if (bQ3 == 4) {
            aVar = f.Y(this.Fk);
        } else if (bQ3 != 5) {
            aVar = bQ3 != 6 ? null : g.b(this.Fk, bQ, this.zS);
        } else {
            aVar = d.a(this.Fk, bQ, this.zS);
        }
        if (aVar == null) {
            return new a(new a.C0047a[0]);
        }
        return new a(aVar);
    }
}
