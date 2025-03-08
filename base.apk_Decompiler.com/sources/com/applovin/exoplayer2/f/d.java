package com.applovin.exoplayer2.f;

import com.applovin.exoplayer2.c.g;
import com.applovin.exoplayer2.l.a;
import java.nio.ByteBuffer;

final class d extends g {
    private long Hb;
    private int Hc = 32;
    private int jA;

    public int iI() {
        return this.jA;
    }

    public long jR() {
        return this.Hb;
    }

    public boolean jS() {
        return this.jA > 0;
    }

    public d() {
        super(2);
    }

    public void clear() {
        super.clear();
        this.jA = 0;
    }

    public void cQ(int i) {
        a.checkArgument(i > 0);
        this.Hc = i;
    }

    public long jQ() {
        return this.rJ;
    }

    public boolean d(g gVar) {
        a.checkArgument(!gVar.hg());
        a.checkArgument(!gVar.ha());
        a.checkArgument(!gVar.gY());
        if (!e(gVar)) {
            return false;
        }
        int i = this.jA;
        this.jA = i + 1;
        if (i == 0) {
            this.rJ = gVar.rJ;
            if (gVar.gZ()) {
                bs(1);
            }
        }
        if (gVar.gX()) {
            bs(Integer.MIN_VALUE);
        }
        ByteBuffer byteBuffer = gVar.rH;
        if (byteBuffer != null) {
            by(byteBuffer.remaining());
            this.rH.put(byteBuffer);
        }
        this.Hb = gVar.rJ;
        return true;
    }

    private boolean e(g gVar) {
        if (!jS()) {
            return true;
        }
        if (this.jA >= this.Hc || gVar.gX() != gX()) {
            return false;
        }
        ByteBuffer byteBuffer = gVar.rH;
        return byteBuffer == null || this.rH == null || this.rH.position() + byteBuffer.remaining() <= 3072000;
    }
}
