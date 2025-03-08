package com.applovin.exoplayer2.h;

import com.applovin.exoplayer2.ab;
import com.applovin.exoplayer2.d.d;
import com.applovin.exoplayer2.d.h;
import com.applovin.exoplayer2.e.f;
import com.applovin.exoplayer2.e.l;
import com.applovin.exoplayer2.h.p;
import com.applovin.exoplayer2.h.s;
import com.applovin.exoplayer2.h.t;
import com.applovin.exoplayer2.k.aa;
import com.applovin.exoplayer2.k.b;
import com.applovin.exoplayer2.k.i;
import com.applovin.exoplayer2.k.r;
import com.applovin.exoplayer2.k.v;

public final class u extends a implements t.b {
    private final h LS;
    private final i.a Lc;
    private final s.a MA;
    private final v MB;
    private final int MC;
    private boolean MD;
    private long ME;
    private boolean MF;
    private boolean MG;
    private aa MH;
    private final ab.f ea;
    private final ab gL;

    public void kS() {
    }

    public ab kZ() {
        return this.gL;
    }

    public static final class a implements r {
        private final i.a Lc;
        private s.a MA;
        private int MC;
        private com.applovin.exoplayer2.d.i MJ;
        private String eo;
        private Object er;
        private v sm;

        public a(i.a aVar) {
            this(aVar, (l) new f());
        }

        public a(i.a aVar, l lVar) {
            this(aVar, (s.a) new u$a$$ExternalSyntheticLambda0(lVar));
        }

        /* access modifiers changed from: private */
        public static /* synthetic */ s a(l lVar) {
            return new c(lVar);
        }

        public a(i.a aVar, s.a aVar2) {
            this.Lc = aVar;
            this.MA = aVar2;
            this.MJ = new d();
            this.sm = new r();
            this.MC = 1048576;
        }

        public u c(ab abVar) {
            com.applovin.exoplayer2.l.a.checkNotNull(abVar.ea);
            boolean z = true;
            boolean z2 = abVar.ea.er == null && this.er != null;
            if (abVar.ea.eo != null || this.eo == null) {
                z = false;
            }
            if (z2 && z) {
                abVar = abVar.bU().e(this.er).o(this.eo).bV();
            } else if (z2) {
                abVar = abVar.bU().e(this.er).bV();
            } else if (z) {
                abVar = abVar.bU().o(this.eo).bV();
            }
            ab abVar2 = abVar;
            return new u(abVar2, this.Lc, this.MA, this.MJ.a(abVar2), this.sm, this.MC);
        }
    }

    private u(ab abVar, i.a aVar, s.a aVar2, h hVar, v vVar, int i) {
        this.ea = (ab.f) com.applovin.exoplayer2.l.a.checkNotNull(abVar.ea);
        this.gL = abVar;
        this.Lc = aVar;
        this.MA = aVar2;
        this.LS = hVar;
        this.MB = vVar;
        this.MC = i;
        this.MD = true;
        this.ME = -9223372036854775807L;
    }

    /* access modifiers changed from: protected */
    public void b(aa aaVar) {
        this.MH = aaVar;
        this.LS.aD();
        ls();
    }

    public n a(p.a aVar, b bVar, long j) {
        i of = this.Lc.of();
        aa aaVar = this.MH;
        if (aaVar != null) {
            of.c(aaVar);
        }
        return new t(this.ea.ef, of, this.MA.createProgressiveMediaExtractor(), this.LS, f(aVar), this.MB, e(aVar), this, bVar, this.ea.eo, this.MC);
    }

    public void f(n nVar) {
        ((t) nVar).release();
    }

    /* access modifiers changed from: protected */
    public void kJ() {
        this.LS.release();
    }

    public void a(long j, boolean z, boolean z2) {
        if (j == -9223372036854775807L) {
            j = this.ME;
        }
        if (this.MD || this.ME != j || this.MF != z || this.MG != z2) {
            this.ME = j;
            this.MF = z;
            this.MG = z2;
            this.MD = false;
            ls();
        }
    }

    /* JADX WARNING: type inference failed for: r0v2, types: [com.applovin.exoplayer2.h.u$1] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void ls() {
        /*
            r9 = this;
            com.applovin.exoplayer2.h.aa r8 = new com.applovin.exoplayer2.h.aa
            long r1 = r9.ME
            boolean r3 = r9.MF
            r4 = 0
            boolean r5 = r9.MG
            r6 = 0
            com.applovin.exoplayer2.ab r7 = r9.gL
            r0 = r8
            r0.<init>(r1, r3, r4, r5, r6, r7)
            boolean r0 = r9.MD
            if (r0 == 0) goto L_0x001a
            com.applovin.exoplayer2.h.u$1 r0 = new com.applovin.exoplayer2.h.u$1
            r0.<init>(r8)
            r8 = r0
        L_0x001a:
            r9.e((com.applovin.exoplayer2.ba) r8)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.applovin.exoplayer2.h.u.ls():void");
    }
}
