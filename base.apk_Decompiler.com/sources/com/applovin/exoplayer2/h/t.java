package com.applovin.exoplayer2.h;

import android.net.Uri;
import android.os.Handler;
import com.applovin.exoplayer2.av;
import com.applovin.exoplayer2.d.g;
import com.applovin.exoplayer2.d.h;
import com.applovin.exoplayer2.e.j;
import com.applovin.exoplayer2.e.v;
import com.applovin.exoplayer2.e.x;
import com.applovin.exoplayer2.h.i;
import com.applovin.exoplayer2.h.n;
import com.applovin.exoplayer2.h.q;
import com.applovin.exoplayer2.h.w;
import com.applovin.exoplayer2.k.i;
import com.applovin.exoplayer2.k.l;
import com.applovin.exoplayer2.k.v;
import com.applovin.exoplayer2.k.w;
import com.applovin.exoplayer2.k.z;
import com.applovin.exoplayer2.l.ai;
import com.applovin.exoplayer2.l.g;
import com.applovin.exoplayer2.l.u;
import com.applovin.exoplayer2.l.y;
import com.applovin.exoplayer2.v;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

final class t implements j, n, w.c, w.a<a>, w.e {
    /* access modifiers changed from: private */
    public static final Map<String, String> LP = lm();
    /* access modifiers changed from: private */
    public static final v LQ = new v.a().g("icy").m("application/x-icy").bT();
    private n.a KS;
    private final i LR;
    private final h LS;
    private final b LT;
    /* access modifiers changed from: private */
    public final long LU;
    private final com.applovin.exoplayer2.k.w LV = new com.applovin.exoplayer2.k.w("ProgressiveMediaPeriod");
    private final s LW;
    private final g LX;
    private final Runnable LY;
    /* access modifiers changed from: private */
    public final Runnable LZ;
    private final com.applovin.exoplayer2.k.b Lu;
    /* access modifiers changed from: private */
    public com.applovin.exoplayer2.g.d.b Ma;
    private w[] Mb;
    private d[] Mc;
    private boolean Md;
    private boolean Me;
    private e Mf;
    private boolean Mg;
    private boolean Mh;
    private int Mi;
    private long Mj;
    private long Mk;
    private boolean Ml;
    private int Mm;
    private boolean Mn;
    private boolean cw;
    private final Uri ef;
    /* access modifiers changed from: private */
    public final String eo;
    private long fH;
    private final q.a fX;
    private final g.a fY;
    private boolean fv;
    private int gn;
    private boolean iO;
    /* access modifiers changed from: private */
    public final Handler jS;
    private final com.applovin.exoplayer2.k.v sm;
    private com.applovin.exoplayer2.e.v vI;
    private long wC;

    interface b {
        void a(long j, boolean z, boolean z2);
    }

    private boolean lk() {
        return this.Mk != -9223372036854775807L;
    }

    public void t(long j) {
    }

    public t(Uri uri, i iVar, s sVar, h hVar, g.a aVar, com.applovin.exoplayer2.k.v vVar, q.a aVar2, b bVar, com.applovin.exoplayer2.k.b bVar2, String str, int i) {
        this.ef = uri;
        this.LR = iVar;
        this.LS = hVar;
        this.fY = aVar;
        this.sm = vVar;
        this.fX = aVar2;
        this.LT = bVar;
        this.Lu = bVar2;
        this.eo = str;
        this.LU = (long) i;
        this.LW = sVar;
        this.LX = new com.applovin.exoplayer2.l.g();
        this.LY = new t$$ExternalSyntheticLambda1(this);
        this.LZ = new t$$ExternalSyntheticLambda2(this);
        this.jS = ai.pX();
        this.Mc = new d[0];
        this.Mb = new w[0];
        this.Mk = -9223372036854775807L;
        this.wC = -1;
        this.fH = -9223372036854775807L;
        this.gn = 1;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void ln() {
        if (!this.cw) {
            ((n.a) com.applovin.exoplayer2.l.a.checkNotNull(this.KS)).a(this);
        }
    }

    public void release() {
        if (this.fv) {
            for (w lx : this.Mb) {
                lx.lx();
            }
        }
        this.LV.a((w.e) this);
        this.jS.removeCallbacksAndMessages((Object) null);
        this.KS = null;
        this.cw = true;
    }

    public void ld() {
        for (w release : this.Mb) {
            release.release();
        }
        this.LW.release();
    }

    public void a(n.a aVar, long j) {
        this.KS = aVar;
        this.LX.oN();
        lh();
    }

    public void kM() throws IOException {
        kR();
        if (this.Mn && !this.fv) {
            throw com.applovin.exoplayer2.ai.c("Loading finished before preparation is complete.", (Throwable) null);
        }
    }

    public ad cj() {
        ll();
        return this.Mf.Mw;
    }

    public long a(com.applovin.exoplayer2.j.d[] dVarArr, boolean[] zArr, x[] xVarArr, boolean[] zArr2, long j) {
        com.applovin.exoplayer2.j.d dVar;
        ll();
        ad adVar = this.Mf.Mw;
        boolean[] zArr3 = this.Mf.My;
        int i = this.Mi;
        int i2 = 0;
        for (int i3 = 0; i3 < dVarArr.length; i3++) {
            c cVar = xVarArr[i3];
            if (cVar != null && (dVarArr[i3] == null || !zArr[i3])) {
                int a2 = cVar.track;
                com.applovin.exoplayer2.l.a.checkState(zArr3[a2]);
                this.Mi--;
                zArr3[a2] = false;
                xVarArr[i3] = null;
            }
        }
        boolean z = !this.Mg ? j != 0 : i == 0;
        for (int i4 = 0; i4 < dVarArr.length; i4++) {
            if (xVarArr[i4] == null && (dVar = dVarArr[i4]) != null) {
                com.applovin.exoplayer2.l.a.checkState(dVar.kD() == 1);
                com.applovin.exoplayer2.l.a.checkState(dVar.eP(0) == 0);
                int a3 = adVar.a(dVar.nf());
                com.applovin.exoplayer2.l.a.checkState(!zArr3[a3]);
                this.Mi++;
                zArr3[a3] = true;
                xVarArr[i4] = new c(a3);
                zArr2[i4] = true;
                if (!z) {
                    w wVar = this.Mb[a3];
                    z = !wVar.e(j, true) && wVar.ly() != 0;
                }
            }
        }
        if (this.Mi == 0) {
            this.Ml = false;
            this.Mh = false;
            if (this.LV.kO()) {
                w[] wVarArr = this.Mb;
                int length = wVarArr.length;
                while (i2 < length) {
                    wVarArr[i2].lC();
                    i2++;
                }
                this.LV.oB();
            } else {
                w[] wVarArr2 = this.Mb;
                int length2 = wVarArr2.length;
                while (i2 < length2) {
                    wVarArr2[i2].Y();
                    i2++;
                }
            }
        } else if (z) {
            j = aQ(j);
            while (i2 < xVarArr.length) {
                if (xVarArr[i2] != null) {
                    zArr2[i2] = true;
                }
                i2++;
            }
        }
        this.Mg = true;
        return j;
    }

    public void d(long j, boolean z) {
        ll();
        if (!lk()) {
            boolean[] zArr = this.Mf.My;
            int length = this.Mb.length;
            for (int i = 0; i < length; i++) {
                this.Mb[i].b(j, z, zArr[i]);
            }
        }
    }

    public boolean aR(long j) {
        if (this.Mn || this.LV.oz() || this.Ml) {
            return false;
        }
        if (this.fv && this.Mi == 0) {
            return false;
        }
        boolean oN = this.LX.oN();
        if (this.LV.kO()) {
            return oN;
        }
        lh();
        return true;
    }

    public boolean kO() {
        return this.LV.kO() && this.LX.hB();
    }

    public long ch() {
        if (this.Mi == 0) {
            return Long.MIN_VALUE;
        }
        return cg();
    }

    public long kN() {
        if (!this.Mh) {
            return -9223372036854775807L;
        }
        if (!this.Mn && li() <= this.Mm) {
            return -9223372036854775807L;
        }
        this.Mh = false;
        return this.Mj;
    }

    public long cg() {
        long j;
        ll();
        boolean[] zArr = this.Mf.Mx;
        if (this.Mn) {
            return Long.MIN_VALUE;
        }
        if (lk()) {
            return this.Mk;
        }
        if (this.Me) {
            int length = this.Mb.length;
            j = Long.MAX_VALUE;
            for (int i = 0; i < length; i++) {
                if (zArr[i] && !this.Mb[i].lB()) {
                    j = Math.min(j, this.Mb[i].lj());
                }
            }
        } else {
            j = Long.MAX_VALUE;
        }
        if (j == Long.MAX_VALUE) {
            j = lj();
        }
        return j == Long.MIN_VALUE ? this.Mj : j;
    }

    public long aQ(long j) {
        ll();
        boolean[] zArr = this.Mf.Mx;
        if (!this.vI.hU()) {
            j = 0;
        }
        int i = 0;
        this.Mh = false;
        this.Mj = j;
        if (lk()) {
            this.Mk = j;
            return j;
        } else if (this.gn != 7 && a(zArr, j)) {
            return j;
        } else {
            this.Ml = false;
            this.Mk = j;
            this.Mn = false;
            if (this.LV.kO()) {
                w[] wVarArr = this.Mb;
                int length = wVarArr.length;
                while (i < length) {
                    wVarArr[i].lC();
                    i++;
                }
                this.LV.oB();
            } else {
                this.LV.oA();
                w[] wVarArr2 = this.Mb;
                int length2 = wVarArr2.length;
                while (i < length2) {
                    wVarArr2[i].Y();
                    i++;
                }
            }
            return j;
        }
    }

    public long a(long j, av avVar) {
        ll();
        if (!this.vI.hU()) {
            return 0;
        }
        v.a ai = this.vI.ai(j);
        return avVar.a(j, ai.uQ.rJ, ai.uR.rJ);
    }

    /* access modifiers changed from: package-private */
    public boolean dJ(int i) {
        return !le() && this.Mb[i].Q(this.Mn);
    }

    /* access modifiers changed from: package-private */
    public void dK(int i) throws IOException {
        this.Mb[i].kR();
        kR();
    }

    /* access modifiers changed from: package-private */
    public void kR() throws IOException {
        this.LV.dK(this.sm.fl(this.gn));
    }

    /* access modifiers changed from: package-private */
    public int a(int i, com.applovin.exoplayer2.w wVar, com.applovin.exoplayer2.c.g gVar, int i2) {
        if (le()) {
            return -3;
        }
        dL(i);
        int a2 = this.Mb[i].a(wVar, gVar, i2, this.Mn);
        if (a2 == -3) {
            dM(i);
        }
        return a2;
    }

    /* access modifiers changed from: package-private */
    public int j(int i, long j) {
        if (le()) {
            return 0;
        }
        dL(i);
        w wVar = this.Mb[i];
        int f = wVar.f(j, this.Mn);
        wVar.dP(f);
        if (f == 0) {
            dM(i);
        }
        return f;
    }

    private void dL(int i) {
        ll();
        boolean[] zArr = this.Mf.Mz;
        if (!zArr[i]) {
            com.applovin.exoplayer2.v dZ = this.Mf.Mw.eb(i).dZ(0);
            this.fX.a(u.ba(dZ.dz), dZ, 0, (Object) null, this.Mj);
            zArr[i] = true;
        }
    }

    private void dM(int i) {
        ll();
        boolean[] zArr = this.Mf.Mx;
        if (this.Ml && zArr[i]) {
            if (!this.Mb[i].Q(false)) {
                this.Mk = 0;
                this.Ml = false;
                this.Mh = true;
                this.Mj = 0;
                this.Mm = 0;
                for (w Y : this.Mb) {
                    Y.Y();
                }
                ((n.a) com.applovin.exoplayer2.l.a.checkNotNull(this.KS)).a(this);
            }
        }
    }

    private boolean le() {
        return this.Mh || lk();
    }

    public void a(a aVar, long j, long j2) {
        com.applovin.exoplayer2.e.v vVar;
        if (this.fH == -9223372036854775807L && (vVar = this.vI) != null) {
            boolean hU = vVar.hU();
            long lj = lj();
            long j3 = lj == Long.MIN_VALUE ? 0 : lj + 10000;
            this.fH = j3;
            this.LT.a(j3, hU, this.iO);
        }
        z b2 = aVar.Mo;
        j jVar = new j(aVar.Lq, aVar.tw, b2.oI(), b2.oJ(), j, j2, b2.oH());
        this.sm.bm(aVar.Lq);
        this.fX.b(jVar, 1, -1, (com.applovin.exoplayer2.v) null, 0, (Object) null, aVar.tL, this.fH);
        a(aVar);
        this.Mn = true;
        ((n.a) com.applovin.exoplayer2.l.a.checkNotNull(this.KS)).a(this);
    }

    public void a(a aVar, long j, long j2, boolean z) {
        z b2 = aVar.Mo;
        j jVar = new j(aVar.Lq, aVar.tw, b2.oI(), b2.oJ(), j, j2, b2.oH());
        this.sm.bm(aVar.Lq);
        this.fX.c(jVar, 1, -1, (com.applovin.exoplayer2.v) null, 0, (Object) null, aVar.tL, this.fH);
        if (!z) {
            a(aVar);
            for (w Y : this.Mb) {
                Y.Y();
            }
            if (this.Mi > 0) {
                ((n.a) com.applovin.exoplayer2.l.a.checkNotNull(this.KS)).a(this);
            }
        }
    }

    public w.b a(a aVar, long j, long j2, IOException iOException, int i) {
        w.b bVar;
        a aVar2;
        boolean z;
        a(aVar);
        z b2 = aVar.Mo;
        j jVar = new j(aVar.Lq, aVar.tw, b2.oI(), b2.oJ(), j, j2, b2.oH());
        long a2 = this.sm.a(new v.a(jVar, new m(1, -1, (com.applovin.exoplayer2.v) null, 0, (Object) null, com.applovin.exoplayer2.h.f(aVar.tL), com.applovin.exoplayer2.h.f(this.fH)), iOException, i));
        if (a2 == -9223372036854775807L) {
            bVar = com.applovin.exoplayer2.k.w.aaY;
            a aVar3 = aVar;
        } else {
            int li = li();
            if (li > this.Mm) {
                aVar2 = aVar;
                z = true;
            } else {
                z = false;
                aVar2 = aVar;
            }
            if (a(aVar2, li)) {
                bVar = com.applovin.exoplayer2.k.w.c(z, a2);
            } else {
                bVar = com.applovin.exoplayer2.k.w.aaX;
            }
        }
        boolean z2 = !bVar.oC();
        this.fX.a(jVar, 1, -1, (com.applovin.exoplayer2.v) null, 0, (Object) null, aVar.tL, this.fH, iOException, z2);
        if (z2) {
            this.sm.bm(aVar.Lq);
        }
        return bVar;
    }

    public x y(int i, int i2) {
        return a(new d(i, false));
    }

    public void ig() {
        this.Md = true;
        this.jS.post(this.LY);
    }

    public void a(com.applovin.exoplayer2.e.v vVar) {
        this.jS.post(new t$$ExternalSyntheticLambda0(this, vVar));
    }

    /* access modifiers changed from: package-private */
    public x lf() {
        return a(new d(0, true));
    }

    public void t(com.applovin.exoplayer2.v vVar) {
        this.jS.post(this.LY);
    }

    private x a(d dVar) {
        int length = this.Mb.length;
        for (int i = 0; i < length; i++) {
            if (dVar.equals(this.Mc[i])) {
                return this.Mb[i];
            }
        }
        w a2 = w.a(this.Lu, this.jS.getLooper(), this.LS, this.fY);
        a2.a((w.c) this);
        int i2 = length + 1;
        d[] dVarArr = (d[]) Arrays.copyOf(this.Mc, i2);
        dVarArr[length] = dVar;
        this.Mc = (d[]) ai.g((T[]) dVarArr);
        w[] wVarArr = (w[]) Arrays.copyOf(this.Mb, i2);
        wVarArr[length] = a2;
        this.Mb = (w[]) ai.g((T[]) wVarArr);
        return a2;
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public void c(com.applovin.exoplayer2.e.v vVar) {
        this.vI = this.Ma == null ? vVar : new v.b(-9223372036854775807L);
        this.fH = vVar.dd();
        int i = 1;
        boolean z = this.wC == -1 && vVar.dd() == -9223372036854775807L;
        this.iO = z;
        if (z) {
            i = 7;
        }
        this.gn = i;
        this.LT.a(this.fH, vVar.hU(), this.iO);
        if (!this.fv) {
            lg();
        }
    }

    /* access modifiers changed from: private */
    public void lg() {
        com.applovin.exoplayer2.g.a aVar;
        if (!this.cw && !this.fv && this.Md && this.vI != null) {
            w[] wVarArr = this.Mb;
            int length = wVarArr.length;
            int i = 0;
            while (i < length) {
                if (wVarArr[i].lz() != null) {
                    i++;
                } else {
                    return;
                }
            }
            this.LX.oO();
            int length2 = this.Mb.length;
            ac[] acVarArr = new ac[length2];
            boolean[] zArr = new boolean[length2];
            for (int i2 = 0; i2 < length2; i2++) {
                com.applovin.exoplayer2.v vVar = (com.applovin.exoplayer2.v) com.applovin.exoplayer2.l.a.checkNotNull(this.Mb[i2].lz());
                String str = vVar.dz;
                boolean aW = u.aW(str);
                boolean z = aW || u.aX(str);
                zArr[i2] = z;
                this.Me = z | this.Me;
                com.applovin.exoplayer2.g.d.b bVar = this.Ma;
                if (bVar != null) {
                    if (aW || this.Mc[i2].Mv) {
                        com.applovin.exoplayer2.g.a aVar2 = vVar.dx;
                        if (aVar2 == null) {
                            aVar = new com.applovin.exoplayer2.g.a(bVar);
                        } else {
                            aVar = aVar2.b(bVar);
                        }
                        vVar = vVar.bR().b(aVar).bT();
                    }
                    if (aW && vVar.dt == -1 && vVar.du == -1 && bVar.dv != -1) {
                        vVar = vVar.bR().G(bVar.dv).bT();
                    }
                }
                acVarArr[i2] = new ac(vVar.B(this.LS.g(vVar)));
            }
            this.Mf = new e(new ad(acVarArr), zArr);
            this.fv = true;
            ((n.a) com.applovin.exoplayer2.l.a.checkNotNull(this.KS)).a(this);
        }
    }

    private void a(a aVar) {
        if (this.wC == -1) {
            this.wC = aVar.wC;
        }
    }

    private void lh() {
        a aVar = new a(this.ef, this.LR, this.LW, this, this.LX);
        if (this.fv) {
            com.applovin.exoplayer2.l.a.checkState(lk());
            long j = this.fH;
            if (j == -9223372036854775807L || this.Mk <= j) {
                aVar.w(((com.applovin.exoplayer2.e.v) com.applovin.exoplayer2.l.a.checkNotNull(this.vI)).ai(this.Mk).uQ.uc, this.Mk);
                for (w ba : this.Mb) {
                    ba.ba(this.Mk);
                }
                this.Mk = -9223372036854775807L;
            } else {
                this.Mn = true;
                this.Mk = -9223372036854775807L;
                return;
            }
        }
        this.Mm = li();
        this.fX.a(new j(aVar.Lq, aVar.tw, this.LV.a(aVar, this, this.sm.fl(this.gn))), 1, -1, (com.applovin.exoplayer2.v) null, 0, (Object) null, aVar.tL, this.fH);
    }

    private boolean a(a aVar, int i) {
        com.applovin.exoplayer2.e.v vVar;
        if (this.wC == -1 && ((vVar = this.vI) == null || vVar.dd() == -9223372036854775807L)) {
            if (!this.fv || le()) {
                this.Mh = this.fv;
                this.Mj = 0;
                this.Mm = 0;
                for (w Y : this.Mb) {
                    Y.Y();
                }
                aVar.w(0, 0);
                return true;
            }
            this.Ml = true;
            return false;
        }
        this.Mm = i;
        return true;
    }

    private boolean a(boolean[] zArr, long j) {
        int length = this.Mb.length;
        for (int i = 0; i < length; i++) {
            if (!this.Mb[i].e(j, false) && (zArr[i] || !this.Me)) {
                return false;
            }
        }
        return true;
    }

    private int li() {
        int i = 0;
        for (w lw : this.Mb) {
            i += lw.lw();
        }
        return i;
    }

    /* access modifiers changed from: private */
    public long lj() {
        long j = Long.MIN_VALUE;
        for (w lj : this.Mb) {
            j = Math.max(j, lj.lj());
        }
        return j;
    }

    private void ll() {
        com.applovin.exoplayer2.l.a.checkState(this.fv);
        com.applovin.exoplayer2.l.a.checkNotNull(this.Mf);
        com.applovin.exoplayer2.l.a.checkNotNull(this.vI);
    }

    private final class c implements x {
        /* access modifiers changed from: private */
        public final int track;

        public c(int i) {
            this.track = i;
        }

        public boolean isReady() {
            return t.this.dJ(this.track);
        }

        public void kR() throws IOException {
            t.this.dK(this.track);
        }

        public int b(com.applovin.exoplayer2.w wVar, com.applovin.exoplayer2.c.g gVar, int i) {
            return t.this.a(this.track, wVar, gVar, i);
        }

        public int aS(long j) {
            return t.this.j(this.track, j);
        }
    }

    final class a implements i.a, w.d {
        private final s LW;
        private final com.applovin.exoplayer2.l.g LX;
        /* access modifiers changed from: private */
        public final long Lq = j.kV();
        /* access modifiers changed from: private */
        public final z Mo;
        private final com.applovin.exoplayer2.e.u Mp = new com.applovin.exoplayer2.e.u();
        private volatile boolean Mq;
        private boolean Mr = true;
        private x Ms;
        private boolean Mt;
        private final Uri ef;
        /* access modifiers changed from: private */
        public long tL;
        /* access modifiers changed from: private */
        public l tw = aX(0);
        private final j vG;
        /* access modifiers changed from: private */
        public long wC = -1;

        public void lq() {
            this.Mq = true;
        }

        public a(Uri uri, com.applovin.exoplayer2.k.i iVar, s sVar, j jVar, com.applovin.exoplayer2.l.g gVar) {
            this.ef = uri;
            this.Mo = new z(iVar);
            this.LW = sVar;
            this.vG = jVar;
            this.LX = gVar;
        }

        public void lr() throws IOException {
            int i = 0;
            while (i == 0 && !this.Mq) {
                try {
                    long j = this.Mp.uc;
                    l aX = aX(j);
                    this.tw = aX;
                    long a = this.Mo.a(aX);
                    this.wC = a;
                    if (a != -1) {
                        this.wC = a + j;
                    }
                    com.applovin.exoplayer2.g.d.b unused = t.this.Ma = com.applovin.exoplayer2.g.d.b.c(this.Mo.kT());
                    com.applovin.exoplayer2.k.g gVar = this.Mo;
                    if (!(t.this.Ma == null || t.this.Ma.JD == -1)) {
                        gVar = new i(this.Mo, t.this.Ma.JD, this);
                        x lf = t.this.lf();
                        this.Ms = lf;
                        lf.j(t.LQ);
                    }
                    s sVar = this.LW;
                    Uri uri = this.ef;
                    Map<String, List<String>> kT = this.Mo.kT();
                    long j2 = this.wC;
                    long j3 = j;
                    sVar.a(gVar, uri, kT, j, j2, this.vG);
                    if (t.this.Ma != null) {
                        this.LW.kK();
                    }
                    if (this.Mr) {
                        this.LW.o(j3, this.tL);
                        this.Mr = false;
                    }
                    while (true) {
                        long j4 = j3;
                        while (i == 0 && !this.Mq) {
                            this.LX.oP();
                            i = this.LW.a(this.Mp);
                            j3 = this.LW.kL();
                            if (j3 > t.this.LU + j4) {
                                this.LX.oO();
                                t.this.jS.post(t.this.LZ);
                            }
                        }
                    }
                    if (i == 1) {
                        i = 0;
                    } else if (this.LW.kL() != -1) {
                        this.Mp.uc = this.LW.kL();
                    }
                    ai.b((com.applovin.exoplayer2.k.i) this.Mo);
                } catch (InterruptedException unused2) {
                    throw new InterruptedIOException();
                } catch (Throwable th) {
                    if (!(i == 1 || this.LW.kL() == -1)) {
                        this.Mp.uc = this.LW.kL();
                    }
                    ai.b((com.applovin.exoplayer2.k.i) this.Mo);
                    throw th;
                }
            }
        }

        public void ab(y yVar) {
            long max = !this.Mt ? this.tL : Math.max(t.this.lj(), this.tL);
            int pj = yVar.pj();
            x xVar = (x) com.applovin.exoplayer2.l.a.checkNotNull(this.Ms);
            xVar.c(yVar, pj);
            xVar.a(max, 1, pj, 0, (x.a) null);
            this.Mt = true;
        }

        private l aX(long j) {
            return new l.a().e(this.ef).bl(j).aL(t.this.eo).fi(6).d(t.LP).oj();
        }

        /* access modifiers changed from: private */
        public void w(long j, long j2) {
            this.Mp.uc = j;
            this.tL = j2;
            this.Mr = true;
            this.Mt = false;
        }
    }

    private static final class e {
        public final ad Mw;
        public final boolean[] Mx;
        public final boolean[] My;
        public final boolean[] Mz;

        public e(ad adVar, boolean[] zArr) {
            this.Mw = adVar;
            this.Mx = zArr;
            this.My = new boolean[adVar.fR];
            this.Mz = new boolean[adVar.fR];
        }
    }

    private static final class d {
        public final boolean Mv;
        public final int zD;

        public int hashCode() {
            return (this.zD * 31) + (this.Mv ? 1 : 0);
        }

        public d(int i, boolean z) {
            this.zD = i;
            this.Mv = z;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            d dVar = (d) obj;
            if (this.zD == dVar.zD && this.Mv == dVar.Mv) {
                return true;
            }
            return false;
        }
    }

    private static Map<String, String> lm() {
        HashMap hashMap = new HashMap();
        hashMap.put("Icy-MetaData", "1");
        return Collections.unmodifiableMap(hashMap);
    }
}
