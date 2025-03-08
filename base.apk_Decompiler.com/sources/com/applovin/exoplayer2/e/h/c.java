package com.applovin.exoplayer2.e.h;

import com.applovin.exoplayer2.ai;
import com.applovin.exoplayer2.e.h;
import com.applovin.exoplayer2.e.i;
import com.applovin.exoplayer2.e.j;
import com.applovin.exoplayer2.e.l;
import com.applovin.exoplayer2.e.u;
import com.applovin.exoplayer2.e.x;
import com.applovin.exoplayer2.l.a;
import com.applovin.exoplayer2.l.y;
import java.io.IOException;

public class c implements h {
    public static final l vq = new c$$ExternalSyntheticLambda0();
    private j BG;
    private boolean BH;
    private h Bu;

    public void a(j jVar) {
        this.BG = jVar;
    }

    public void release() {
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ h[] ih() {
        return new h[]{new c()};
    }

    public boolean a(i iVar) throws IOException {
        try {
            return R(iVar);
        } catch (ai unused) {
            return false;
        }
    }

    public void o(long j, long j2) {
        h hVar = this.Bu;
        if (hVar != null) {
            hVar.o(j, j2);
        }
    }

    public int b(i iVar, u uVar) throws IOException {
        a.N(this.BG);
        if (this.Bu == null) {
            if (R(iVar)) {
                iVar.ic();
            } else {
                throw ai.c("Failed to determine bitstream type", (Throwable) null);
            }
        }
        if (!this.BH) {
            x y = this.BG.y(0, 1);
            this.BG.ig();
            this.Bu.a(this.BG, y);
            this.BH = true;
        }
        return this.Bu.b(iVar, uVar);
    }

    private boolean R(i iVar) throws IOException {
        e eVar = new e();
        if (eVar.f(iVar, true) && (eVar.bs & 2) == 2) {
            int min = Math.min(eVar.BU, 8);
            y yVar = new y(min);
            iVar.c(yVar.hO(), 0, min);
            if (b.F(I(yVar))) {
                this.Bu = new b();
            } else if (i.F(I(yVar))) {
                this.Bu = new i();
            } else if (g.F(I(yVar))) {
                this.Bu = new g();
            }
            return true;
        }
        return false;
    }

    private static y I(y yVar) {
        yVar.fx(0);
        return yVar;
    }
}
