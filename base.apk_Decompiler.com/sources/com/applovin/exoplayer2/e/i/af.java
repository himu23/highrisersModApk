package com.applovin.exoplayer2.e.i;

import com.applovin.exoplayer2.e.b;
import com.applovin.exoplayer2.e.i.ad;
import com.applovin.exoplayer2.e.j;
import com.applovin.exoplayer2.e.x;
import com.applovin.exoplayer2.l.a;
import com.applovin.exoplayer2.l.y;
import com.applovin.exoplayer2.v;
import java.util.List;

final class af {
    private final x[] CX;
    private final List<v> zN;

    public af(List<v> list) {
        this.zN = list;
        this.CX = new x[list.size()];
    }

    public void a(j jVar, ad.d dVar) {
        for (int i = 0; i < this.CX.length; i++) {
            dVar.jy();
            x y = jVar.y(dVar.jz(), 3);
            v vVar = this.zN.get(i);
            String str = vVar.dz;
            boolean z = "application/cea-608".equals(str) || "application/cea-708".equals(str);
            a.checkArgument(z, "Invalid closed caption mime type provided: " + str);
            y.j(new v.a().g(dVar.jA()).m(str).E(vVar.dr).j(vVar.dq).S(vVar.dQ).c(vVar.dB).bT());
            this.CX[i] = y;
        }
    }

    public void a(long j, y yVar) {
        if (yVar.pj() >= 9) {
            int px = yVar.px();
            int px2 = yVar.px();
            int po = yVar.po();
            if (px == 434 && px2 == 1195456820 && po == 3) {
                b.b(j, yVar, this.CX);
            }
        }
    }
}
