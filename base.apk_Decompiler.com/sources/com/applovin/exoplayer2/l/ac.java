package com.applovin.exoplayer2.l;

import com.applovin.exoplayer2.am;
import com.applovin.exoplayer2.h;

public final class ac implements s {
    private boolean GL;
    private long acM;
    private long acN;
    private final d bR;
    private am gy = am.gC;

    public am av() {
        return this.gy;
    }

    public ac(d dVar) {
        this.bR = dVar;
    }

    public void start() {
        if (!this.GL) {
            this.acN = this.bR.oK();
            this.GL = true;
        }
    }

    public void W() {
        if (this.GL) {
            d(au());
            this.GL = false;
        }
    }

    public void d(long j) {
        this.acM = j;
        if (this.GL) {
            this.acN = this.bR.oK();
        }
    }

    public long au() {
        long j;
        long j2 = this.acM;
        if (!this.GL) {
            return j2;
        }
        long oK = this.bR.oK() - this.acN;
        if (this.gy.gD == 1.0f) {
            j = h.g(oK);
        } else {
            j = this.gy.x(oK);
        }
        return j2 + j;
    }

    public void a(am amVar) {
        if (this.GL) {
            d(au());
        }
        this.gy = amVar;
    }
}
