package com.applovin.exoplayer2.h;

import android.os.Handler;
import com.applovin.exoplayer2.ba;
import com.applovin.exoplayer2.d.g;
import com.applovin.exoplayer2.h.p;
import com.applovin.exoplayer2.h.q;
import com.applovin.exoplayer2.k.aa;
import com.applovin.exoplayer2.l.ai;
import java.io.IOException;
import java.util.HashMap;

public abstract class e<T> extends a {
    private Handler I;
    private final HashMap<T, b<T>> fZ = new HashMap<>();
    private aa gc;

    /* access modifiers changed from: protected */
    public p.a a(T t, p.a aVar) {
        return aVar;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public abstract void b(T t, p pVar, ba baVar);

    /* access modifiers changed from: protected */
    public long b(T t, long j) {
        return j;
    }

    /* access modifiers changed from: protected */
    public int c(T t, int i) {
        return i;
    }

    protected e() {
    }

    /* access modifiers changed from: protected */
    public void b(aa aaVar) {
        this.gc = aaVar;
        this.I = ai.pX();
    }

    public void kS() throws IOException {
        for (b<T> bVar : this.fZ.values()) {
            bVar.gf.kS();
        }
    }

    /* access modifiers changed from: protected */
    public void kH() {
        for (b next : this.fZ.values()) {
            next.gf.a(next.gg);
        }
    }

    /* access modifiers changed from: protected */
    public void kI() {
        for (b next : this.fZ.values()) {
            next.gf.b(next.gg);
        }
    }

    /* access modifiers changed from: protected */
    public void kJ() {
        for (b next : this.fZ.values()) {
            next.gf.c(next.gg);
            next.gf.a((q) next.Lb);
            next.gf.f((g) next.Lb);
        }
        this.fZ.clear();
    }

    /* access modifiers changed from: protected */
    public final void a(T t, p pVar) {
        com.applovin.exoplayer2.l.a.checkArgument(!this.fZ.containsKey(t));
        e$$ExternalSyntheticLambda0 e__externalsyntheticlambda0 = new e$$ExternalSyntheticLambda0(this, t);
        a aVar = new a(t);
        this.fZ.put(t, new b(pVar, e__externalsyntheticlambda0, aVar));
        pVar.a((Handler) com.applovin.exoplayer2.l.a.checkNotNull(this.I), (q) aVar);
        pVar.b((Handler) com.applovin.exoplayer2.l.a.checkNotNull(this.I), aVar);
        pVar.a((p.b) e__externalsyntheticlambda0, this.gc);
        if (!isEnabled()) {
            pVar.b(e__externalsyntheticlambda0);
        }
    }

    private static final class b<T> {
        public final e<T>.a Lb;
        public final p gf;
        public final p.b gg;

        public b(p pVar, p.b bVar, e<T>.a aVar) {
            this.gf = pVar;
            this.gg = bVar;
            this.Lb = aVar;
        }
    }

    private final class a implements g, q {
        private q.a fX;
        private g.a fY;
        private final T ix;

        public /* synthetic */ void g(int i, p.a aVar) {
            g.CC.$default$g(this, i, aVar);
        }

        public a(T t) {
            this.fX = e.this.e((p.a) null);
            this.fY = e.this.f((p.a) null);
            this.ix = t;
        }

        public void a(int i, p.a aVar, j jVar, m mVar) {
            if (e(i, aVar)) {
                this.fX.a(jVar, a(mVar));
            }
        }

        public void b(int i, p.a aVar, j jVar, m mVar) {
            if (e(i, aVar)) {
                this.fX.b(jVar, a(mVar));
            }
        }

        public void c(int i, p.a aVar, j jVar, m mVar) {
            if (e(i, aVar)) {
                this.fX.c(jVar, a(mVar));
            }
        }

        public void a(int i, p.a aVar, j jVar, m mVar, IOException iOException, boolean z) {
            if (e(i, aVar)) {
                this.fX.a(jVar, a(mVar), iOException, z);
            }
        }

        public void a(int i, p.a aVar, m mVar) {
            if (e(i, aVar)) {
                this.fX.b(a(mVar));
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
                aVar2 = e.this.a(this.ix, aVar);
                if (aVar2 == null) {
                    return false;
                }
            } else {
                aVar2 = null;
            }
            int c = e.this.c(this.ix, i);
            if (this.fX.cN != c || !ai.r(this.fX.jj, aVar2)) {
                this.fX = e.this.a(c, aVar2, 0);
            }
            if (this.fY.cN == c && ai.r(this.fY.jj, aVar2)) {
                return true;
            }
            this.fY = e.this.i(c, aVar2);
            return true;
        }

        private m a(m mVar) {
            long b = e.this.b(this.ix, mVar.LJ);
            long b2 = e.this.b(this.ix, mVar.LK);
            if (b == mVar.LJ && b2 == mVar.LK) {
                return mVar;
            }
            return new m(mVar.gn, mVar.V, mVar.LG, mVar.LH, mVar.LI, b, b2);
        }
    }
}
