package com.applovin.exoplayer2.e.d;

import com.applovin.exoplayer2.e.j;
import com.applovin.exoplayer2.e.v;
import com.applovin.exoplayer2.e.w;
import com.applovin.exoplayer2.e.x;

public final class d implements j {
    private final j vG;
    /* access modifiers changed from: private */
    public final long wE;

    public d(long j, j jVar) {
        this.wE = j;
        this.vG = jVar;
    }

    public x y(int i, int i2) {
        return this.vG.y(i, i2);
    }

    public void ig() {
        this.vG.ig();
    }

    public void a(final v vVar) {
        this.vG.a(new v() {
            public boolean hU() {
                return vVar.hU();
            }

            public long dd() {
                return vVar.dd();
            }

            public v.a ai(long j) {
                v.a ai = vVar.ai(j);
                return new v.a(new w(ai.uQ.rJ, ai.uQ.uc + d.this.wE), new w(ai.uR.rJ, ai.uR.uc + d.this.wE));
            }
        });
    }
}
