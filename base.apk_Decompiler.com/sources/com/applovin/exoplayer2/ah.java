package com.applovin.exoplayer2;

import android.os.Handler;
import com.applovin.exoplayer2.d.g;
import com.applovin.exoplayer2.h.j;
import com.applovin.exoplayer2.h.k;
import com.applovin.exoplayer2.h.l;
import com.applovin.exoplayer2.h.m;
import com.applovin.exoplayer2.h.n;
import com.applovin.exoplayer2.h.p;
import com.applovin.exoplayer2.h.q;
import com.applovin.exoplayer2.h.z;
import com.applovin.exoplayer2.k.aa;
import com.applovin.exoplayer2.l.ai;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.IdentityHashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

final class ah {
    private z C = new z.a(0);
    private final List<c> cM = new ArrayList();
    private final IdentityHashMap<n, c> fU = new IdentityHashMap<>();
    private final Map<Object, c> fV = new HashMap();
    private final d fW;
    /* access modifiers changed from: private */
    public final q.a fX;
    /* access modifiers changed from: private */
    public final g.a fY;
    private final HashMap<c, b> fZ;
    private final Set<c> ga;
    private boolean gb;
    private aa gc;

    public interface d {
        void bi();
    }

    public boolean cw() {
        return this.gb;
    }

    public ah(d dVar, com.applovin.exoplayer2.a.a aVar, Handler handler) {
        this.fW = dVar;
        q.a aVar2 = new q.a();
        this.fX = aVar2;
        g.a aVar3 = new g.a();
        this.fY = aVar3;
        this.fZ = new HashMap<>();
        this.ga = new HashSet();
        if (aVar != null) {
            aVar2.a(handler, (q) aVar);
            aVar3.a(handler, (g) aVar);
        }
    }

    public ba a(List<c> list, z zVar) {
        d(0, this.cM.size());
        return a(this.cM.size(), list, zVar);
    }

    public ba a(int i, List<c> list, z zVar) {
        if (!list.isEmpty()) {
            this.C = zVar;
            for (int i2 = i; i2 < list.size() + i; i2++) {
                c cVar = list.get(i2 - i);
                if (i2 > 0) {
                    c cVar2 = this.cM.get(i2 - 1);
                    cVar.U(cVar2.gk + cVar2.gi.bf().cP());
                } else {
                    cVar.U(0);
                }
                e(i2, cVar.gi.bf().cP());
                this.cM.add(i2, cVar);
                this.fV.put(cVar.ch, cVar);
                if (this.gb) {
                    c(cVar);
                    if (this.fU.isEmpty()) {
                        this.ga.add(cVar);
                    } else {
                        b(cVar);
                    }
                }
            }
        }
        return cy();
    }

    public ba c(int i, int i2, z zVar) {
        com.applovin.exoplayer2.l.a.checkArgument(i >= 0 && i <= i2 && i2 <= cx());
        this.C = zVar;
        d(i, i2);
        return cy();
    }

    public ba a(int i, int i2, int i3, z zVar) {
        com.applovin.exoplayer2.l.a.checkArgument(i >= 0 && i <= i2 && i2 <= cx() && i3 >= 0);
        this.C = zVar;
        if (i == i2 || i == i3) {
            return cy();
        }
        int min = Math.min(i, i3);
        int max = Math.max(((i2 - i) + i3) - 1, i2 - 1);
        int i4 = this.cM.get(min).gk;
        ai.a(this.cM, i, i2, i3);
        while (min <= max) {
            c cVar = this.cM.get(min);
            cVar.gk = i4;
            i4 += cVar.gi.bf().cP();
            min++;
        }
        return cy();
    }

    public int cx() {
        return this.cM.size();
    }

    public ba b(z zVar) {
        int cx = cx();
        if (zVar.lG() != cx) {
            zVar = zVar.lJ().E(0, cx);
        }
        this.C = zVar;
        return cy();
    }

    public void a(aa aaVar) {
        com.applovin.exoplayer2.l.a.checkState(!this.gb);
        this.gc = aaVar;
        for (int i = 0; i < this.cM.size(); i++) {
            c cVar = this.cM.get(i);
            c(cVar);
            this.ga.add(cVar);
        }
        this.gb = true;
    }

    public n a(p.a aVar, com.applovin.exoplayer2.k.b bVar, long j) {
        Object f = f(aVar.gM);
        p.a H = aVar.G(g(aVar.gM));
        c cVar = (c) com.applovin.exoplayer2.l.a.checkNotNull(this.fV.get(f));
        a(cVar);
        cVar.gj.add(H);
        k b2 = cVar.gi.a(H, bVar, j);
        this.fU.put(b2, cVar);
        cz();
        return b2;
    }

    public void f(n nVar) {
        c cVar = (c) com.applovin.exoplayer2.l.a.checkNotNull(this.fU.remove(nVar));
        cVar.gi.f(nVar);
        cVar.gj.remove(((k) nVar).fE);
        if (!this.fU.isEmpty()) {
            cz();
        }
        d(cVar);
    }

    public void release() {
        for (b next : this.fZ.values()) {
            try {
                next.gf.c(next.gg);
            } catch (RuntimeException e) {
                com.applovin.exoplayer2.l.q.c("MediaSourceList", "Failed to release child source.", e);
            }
            next.gf.a((q) next.gh);
            next.gf.f((g) next.gh);
        }
        this.fZ.clear();
        this.ga.clear();
        this.gb = false;
    }

    public ba cy() {
        if (this.cM.isEmpty()) {
            return ba.iw;
        }
        int i = 0;
        for (int i2 = 0; i2 < this.cM.size(); i2++) {
            c cVar = this.cM.get(i2);
            cVar.gk = i;
            i += cVar.gi.bf().cP();
        }
        return new ap(this.cM, this.C);
    }

    private void a(c cVar) {
        this.ga.add(cVar);
        b bVar = this.fZ.get(cVar);
        if (bVar != null) {
            bVar.gf.a(bVar.gg);
        }
    }

    private void cz() {
        Iterator<c> it = this.ga.iterator();
        while (it.hasNext()) {
            c next = it.next();
            if (next.gj.isEmpty()) {
                b(next);
                it.remove();
            }
        }
    }

    private void b(c cVar) {
        b bVar = this.fZ.get(cVar);
        if (bVar != null) {
            bVar.gf.b(bVar.gg);
        }
    }

    private void d(int i, int i2) {
        for (int i3 = i2 - 1; i3 >= i; i3--) {
            c remove = this.cM.remove(i3);
            this.fV.remove(remove.ch);
            e(i3, -remove.gi.bf().cP());
            remove.gl = true;
            if (this.gb) {
                d(remove);
            }
        }
    }

    private void e(int i, int i2) {
        while (i < this.cM.size()) {
            this.cM.get(i).gk += i2;
            i++;
        }
    }

    /* access modifiers changed from: private */
    public static p.a a(c cVar, p.a aVar) {
        for (int i = 0; i < cVar.gj.size(); i++) {
            if (cVar.gj.get(i).LL == aVar.LL) {
                return aVar.G(a(cVar, aVar.gM));
            }
        }
        return null;
    }

    /* access modifiers changed from: private */
    public static int a(c cVar, int i) {
        return i + cVar.gk;
    }

    private void c(c cVar) {
        l lVar = cVar.gi;
        ah$$ExternalSyntheticLambda0 ah__externalsyntheticlambda0 = new ah$$ExternalSyntheticLambda0(this);
        a aVar = new a(cVar);
        this.fZ.put(cVar, new b(lVar, ah__externalsyntheticlambda0, aVar));
        lVar.a(ai.pY(), (q) aVar);
        lVar.b(ai.pY(), aVar);
        lVar.a((p.b) ah__externalsyntheticlambda0, this.gc);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void a(p pVar, ba baVar) {
        this.fW.bi();
    }

    private void d(c cVar) {
        if (cVar.gl && cVar.gj.isEmpty()) {
            b bVar = (b) com.applovin.exoplayer2.l.a.checkNotNull(this.fZ.remove(cVar));
            bVar.gf.c(bVar.gg);
            bVar.gf.a((q) bVar.gh);
            bVar.gf.f((g) bVar.gh);
            this.ga.remove(cVar);
        }
    }

    private static Object f(Object obj) {
        return ap.a(obj);
    }

    private static Object g(Object obj) {
        return ap.b(obj);
    }

    private static Object a(c cVar, Object obj) {
        return ap.a(cVar.ch, obj);
    }

    static final class c implements ag {
        public final Object ch = new Object();
        public final l gi;
        public final List<p.a> gj = new ArrayList();
        public int gk;
        public boolean gl;

        public Object be() {
            return this.ch;
        }

        public c(p pVar, boolean z) {
            this.gi = new l(pVar, z);
        }

        public void U(int i) {
            this.gk = i;
            this.gl = false;
            this.gj.clear();
        }

        public ba bf() {
            return this.gi.bf();
        }
    }

    private static final class b {
        public final p gf;
        public final p.b gg;
        public final a gh;

        public b(p pVar, p.b bVar, a aVar) {
            this.gf = pVar;
            this.gg = bVar;
            this.gh = aVar;
        }
    }

    private final class a implements g, q {
        private q.a fX;
        private g.a fY;
        private final c gd;

        public /* synthetic */ void g(int i, p.a aVar) {
            g.CC.$default$g(this, i, aVar);
        }

        public a(c cVar) {
            this.fX = ah.this.fX;
            this.fY = ah.this.fY;
            this.gd = cVar;
        }

        public void a(int i, p.a aVar, j jVar, m mVar) {
            if (e(i, aVar)) {
                this.fX.a(jVar, mVar);
            }
        }

        public void b(int i, p.a aVar, j jVar, m mVar) {
            if (e(i, aVar)) {
                this.fX.b(jVar, mVar);
            }
        }

        public void c(int i, p.a aVar, j jVar, m mVar) {
            if (e(i, aVar)) {
                this.fX.c(jVar, mVar);
            }
        }

        public void a(int i, p.a aVar, j jVar, m mVar, IOException iOException, boolean z) {
            if (e(i, aVar)) {
                this.fX.a(jVar, mVar, iOException, z);
            }
        }

        public void a(int i, p.a aVar, m mVar) {
            if (e(i, aVar)) {
                this.fX.b(mVar);
            }
        }

        public void a(int i, p.a aVar, int i2) {
            if (e(i, aVar)) {
                this.fY.bF(i2);
            }
        }

        public void a(int i, p.a aVar) {
            if (e(i, aVar)) {
                this.fY.hG();
            }
        }

        public void a(int i, p.a aVar, Exception exc) {
            if (e(i, aVar)) {
                this.fY.j(exc);
            }
        }

        public void b(int i, p.a aVar) {
            if (e(i, aVar)) {
                this.fY.hH();
            }
        }

        public void c(int i, p.a aVar) {
            if (e(i, aVar)) {
                this.fY.hI();
            }
        }

        public void d(int i, p.a aVar) {
            if (e(i, aVar)) {
                this.fY.hJ();
            }
        }

        private boolean e(int i, p.a aVar) {
            p.a aVar2;
            if (aVar != null) {
                aVar2 = ah.a(this.gd, aVar);
                if (aVar2 == null) {
                    return false;
                }
            } else {
                aVar2 = null;
            }
            int b = ah.a(this.gd, i);
            if (this.fX.cN != b || !ai.r(this.fX.jj, aVar2)) {
                this.fX = ah.this.fX.b(b, aVar2, 0);
            }
            if (this.fY.cN == b && ai.r(this.fY.jj, aVar2)) {
                return true;
            }
            this.fY = ah.this.fY.h(b, aVar2);
            return true;
        }
    }
}
