package com.applovin.exoplayer2.e.i;

import com.applovin.exoplayer2.e.b;
import com.applovin.exoplayer2.e.i.ad;
import com.applovin.exoplayer2.e.j;
import com.applovin.exoplayer2.e.x;
import com.applovin.exoplayer2.l.a;
import com.applovin.exoplayer2.l.y;
import com.applovin.exoplayer2.v;
import java.util.List;

public final class z {
    private final x[] CX;
    private final List<v> zN;

    public z(List<v> list) {
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
            y.j(new v.a().g(vVar.f8do != null ? vVar.f8do : dVar.jA()).m(str).E(vVar.dr).j(vVar.dq).S(vVar.dQ).c(vVar.dB).bT());
            this.CX[i] = y;
        }
    }

    public void a(long j, y yVar) {
        b.a(j, yVar, this.CX);
    }
}
