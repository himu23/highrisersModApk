package com.applovin.exoplayer2.d;

import com.applovin.exoplayer2.ab;
import com.applovin.exoplayer2.common.a.ax;
import com.applovin.exoplayer2.d.c;
import com.applovin.exoplayer2.k.q;
import com.applovin.exoplayer2.k.t;
import com.applovin.exoplayer2.l.a;
import com.applovin.exoplayer2.l.ai;
import java.util.Map;

public final class d implements i {
    private ab.d eL;
    private final Object rT = new Object();
    private h sY;
    private t.b sZ;
    private String ta;

    public h a(ab abVar) {
        h hVar;
        a.checkNotNull(abVar.ea);
        ab.d dVar = abVar.ea.eL;
        if (dVar == null || ai.acV < 18) {
            return h.ti;
        }
        synchronized (this.rT) {
            if (!ai.r(dVar, this.eL)) {
                this.eL = dVar;
                this.sY = b(dVar);
            }
            hVar = (h) a.checkNotNull(this.sY);
        }
        return hVar;
    }

    private h b(ab.d dVar) {
        t.b bVar = this.sZ;
        if (bVar == null) {
            bVar = new q.a().aO(this.ta);
        }
        p pVar = new p(dVar.ez == null ? null : dVar.ez.toString(), dVar.eD, bVar);
        ax<Map.Entry<String, String>> fU = dVar.eA.entrySet().iterator();
        while (fU.hasNext()) {
            Map.Entry next = fU.next();
            pVar.c((String) next.getKey(), (String) next.getValue());
        }
        c a = new c.a().a(dVar.ey, o.tq).K(dVar.eB).L(dVar.eC).e(com.applovin.exoplayer2.common.b.c.f(dVar.eE)).a(pVar);
        a.a(0, dVar.bW());
        return a;
    }
}
