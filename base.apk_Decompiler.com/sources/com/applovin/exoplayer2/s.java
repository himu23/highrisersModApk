package com.applovin.exoplayer2;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import android.util.Pair;
import com.applovin.exoplayer2.ab;
import com.applovin.exoplayer2.ah;
import com.applovin.exoplayer2.ao;
import com.applovin.exoplayer2.ar;
import com.applovin.exoplayer2.ba;
import com.applovin.exoplayer2.common.a.aq;
import com.applovin.exoplayer2.common.a.s;
import com.applovin.exoplayer2.common.base.Supplier;
import com.applovin.exoplayer2.d.f;
import com.applovin.exoplayer2.g.a;
import com.applovin.exoplayer2.h.ad;
import com.applovin.exoplayer2.h.n;
import com.applovin.exoplayer2.h.p;
import com.applovin.exoplayer2.h.x;
import com.applovin.exoplayer2.h.z;
import com.applovin.exoplayer2.j.j;
import com.applovin.exoplayer2.j.k;
import com.applovin.exoplayer2.l.ai;
import com.applovin.exoplayer2.l.o;
import com.applovin.exoplayer2.l.q;
import com.applovin.exoplayer2.m;
import com.google.android.gms.auth.api.proxy.AuthApiStatusCodes;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;

final class s implements Handler.Callback, ah.d, ao.a, n.a, j.a, m.a {
    private final ba.c U;
    private final long aT;
    private final boolean aU;
    private final ar[] bB;
    private final j bC;
    private final e bE;
    private final ba.a bI;
    private final com.applovin.exoplayer2.k.d bO;
    private final com.applovin.exoplayer2.l.d bR;
    private int bS;
    private boolean bT;
    private av bY;
    private final k bz;
    private boolean cA;
    private boolean cB;
    /* access modifiers changed from: private */
    public boolean cC;
    private boolean cD;
    private int cE;
    private g cF;
    private long cG;
    private int cH;
    private boolean cI;
    private p cJ;
    private long cK;
    private al cd;
    private final Set<ar> cj;
    private final as[] ck;
    private final aa cl;
    /* access modifiers changed from: private */
    public final o cm;
    private final HandlerThread cn;
    private final Looper co;
    private final m cp;
    private final ArrayList<c> cq;
    private final af cr;
    private final ah cs;
    private final z ct;
    private final long cu;
    private d cv;
    private boolean cw;
    private boolean cx;
    private boolean cy;
    private boolean cz;

    private static class b {
        public final z C;
        public final int cP;
        public final int cQ;
        public final int cR;
    }

    public interface e {
        void onPlaybackInfoUpdate(d dVar);
    }

    private void a(av avVar) {
        this.bY = avVar;
    }

    public Looper bh() {
        return this.co;
    }

    public void j(long j) {
        this.cK = j;
    }

    public static final class d {
        /* access modifiers changed from: private */
        public boolean cW;
        public int cX;
        public boolean cY;
        public int cZ;
        public al cd;
        public boolean da;
        public int db;

        public void d(al alVar) {
            this.cW |= this.cd != alVar;
            this.cd = alVar;
        }

        public void x(int i) {
            this.cW |= i > 0;
            this.cX += i;
        }

        public void z(int i) {
            this.cW = true;
            this.da = true;
            this.db = i;
        }

        public d(al alVar) {
            this.cd = alVar;
        }

        public void y(int i) {
            boolean z = true;
            if (!this.cY || this.cZ == 5) {
                this.cW = true;
                this.cY = true;
                this.cZ = i;
                return;
            }
            if (i != 5) {
                z = false;
            }
            com.applovin.exoplayer2.l.a.checkArgument(z);
        }
    }

    public s(ar[] arVarArr, j jVar, k kVar, aa aaVar, com.applovin.exoplayer2.k.d dVar, int i, boolean z, com.applovin.exoplayer2.a.a aVar, av avVar, z zVar, long j, boolean z2, Looper looper, com.applovin.exoplayer2.l.d dVar2, e eVar) {
        ar[] arVarArr2 = arVarArr;
        com.applovin.exoplayer2.k.d dVar3 = dVar;
        com.applovin.exoplayer2.a.a aVar2 = aVar;
        long j2 = j;
        com.applovin.exoplayer2.l.d dVar4 = dVar2;
        this.bE = eVar;
        this.bB = arVarArr2;
        this.bC = jVar;
        this.bz = kVar;
        this.cl = aaVar;
        this.bO = dVar3;
        this.bS = i;
        this.bT = z;
        this.bY = avVar;
        this.ct = zVar;
        this.cu = j2;
        this.cK = j2;
        this.cx = z2;
        this.bR = dVar4;
        this.aT = aaVar.as();
        this.aU = aaVar.at();
        al a2 = al.a(kVar);
        this.cd = a2;
        this.cv = new d(a2);
        this.ck = new as[arVarArr2.length];
        for (int i2 = 0; i2 < arVarArr2.length; i2++) {
            arVarArr2[i2].p(i2);
            this.ck[i2] = arVarArr2[i2].N();
        }
        this.cp = new m(this, dVar4);
        this.cq = new ArrayList<>();
        this.cj = aq.gT();
        this.U = new ba.c();
        this.bI = new ba.a();
        jVar.a(this, dVar3);
        this.cI = true;
        Handler handler = new Handler(looper);
        this.cr = new af(aVar2, handler);
        this.cs = new ah(this, aVar2, handler);
        HandlerThread handlerThread = new HandlerThread("ExoPlayer:Playback", -16);
        this.cn = handlerThread;
        handlerThread.start();
        Looper looper2 = handlerThread.getLooper();
        this.co = looper2;
        this.cm = dVar4.a(looper2, this);
    }

    public void aD() {
        this.cm.fr(0).oY();
    }

    public void b(boolean z, int i) {
        this.cm.j(1, z ? 1 : 0, i).oY();
    }

    public void u(int i) {
        this.cm.j(11, i, 0).oY();
    }

    public void l(boolean z) {
        this.cm.j(12, z ? 1 : 0, 0).oY();
    }

    public void b(ba baVar, int i, long j) {
        this.cm.c(3, new g(baVar, i, j)).oY();
    }

    public void W() {
        this.cm.fr(6).oY();
    }

    public void a(List<ah.c> list, int i, long j, z zVar) {
        this.cm.c(17, new a(list, zVar, i, j)).oY();
    }

    public void a(int i, int i2, z zVar) {
        this.cm.a(20, i, i2, zVar).oY();
    }

    public synchronized void a(ao aoVar) {
        if (!this.cw) {
            if (this.cn.isAlive()) {
                this.cm.c(14, aoVar).oY();
                return;
            }
        }
        q.h("ExoPlayerImplInternal", "Ignoring messages sent after release.");
        aoVar.B(false);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0023, code lost:
        return true;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized boolean bg() {
        /*
            r3 = this;
            monitor-enter(r3)
            boolean r0 = r3.cw     // Catch:{ all -> 0x0025 }
            if (r0 != 0) goto L_0x0022
            android.os.HandlerThread r0 = r3.cn     // Catch:{ all -> 0x0025 }
            boolean r0 = r0.isAlive()     // Catch:{ all -> 0x0025 }
            if (r0 != 0) goto L_0x000e
            goto L_0x0022
        L_0x000e:
            com.applovin.exoplayer2.l.o r0 = r3.cm     // Catch:{ all -> 0x0025 }
            r1 = 7
            r0.fs(r1)     // Catch:{ all -> 0x0025 }
            com.applovin.exoplayer2.s$$ExternalSyntheticLambda1 r0 = new com.applovin.exoplayer2.s$$ExternalSyntheticLambda1     // Catch:{ all -> 0x0025 }
            r0.<init>(r3)     // Catch:{ all -> 0x0025 }
            long r1 = r3.cu     // Catch:{ all -> 0x0025 }
            r3.a((com.applovin.exoplayer2.common.base.Supplier<java.lang.Boolean>) r0, (long) r1)     // Catch:{ all -> 0x0025 }
            boolean r0 = r3.cw     // Catch:{ all -> 0x0025 }
            monitor-exit(r3)
            return r0
        L_0x0022:
            monitor-exit(r3)
            r0 = 1
            return r0
        L_0x0025:
            r0 = move-exception
            monitor-exit(r3)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.applovin.exoplayer2.s.bg():boolean");
    }

    /* access modifiers changed from: private */
    public /* synthetic */ Boolean bO() {
        return Boolean.valueOf(this.cw);
    }

    public void bi() {
        this.cm.fs(22);
    }

    public void a(n nVar) {
        this.cm.c(8, nVar).oY();
    }

    /* renamed from: b */
    public void a(n nVar) {
        this.cm.c(9, nVar).oY();
    }

    public void b(am amVar) {
        this.cm.c(16, amVar).oY();
    }

    public boolean handleMessage(Message message) {
        ad cs2;
        int i = 1000;
        try {
            switch (message.what) {
                case 0:
                    bk();
                    break;
                case 1:
                    a(message.arg1 != 0, message.arg2, true, 1);
                    break;
                case 2:
                    br();
                    break;
                case 3:
                    a((g) message.obj);
                    break;
                case 4:
                    c((am) message.obj);
                    break;
                case 5:
                    a((av) message.obj);
                    break;
                case 6:
                    b(false, true);
                    break;
                case 7:
                    bt();
                    return true;
                case 8:
                    c((n) message.obj);
                    break;
                case 9:
                    d((n) message.obj);
                    break;
                case 10:
                    bu();
                    break;
                case 11:
                    w(message.arg1);
                    break;
                case 12:
                    p(message.arg1 != 0);
                    break;
                case 13:
                    a(message.arg1 != 0, (AtomicBoolean) message.obj);
                    break;
                case 14:
                    b((ao) message.obj);
                    break;
                case 15:
                    d((ao) message.obj);
                    break;
                case 16:
                    a((am) message.obj, false);
                    break;
                case 17:
                    a((a) message.obj);
                    break;
                case 18:
                    a((a) message.obj, message.arg1);
                    break;
                case 19:
                    a((b) message.obj);
                    break;
                case 20:
                    b(message.arg1, message.arg2, (z) message.obj);
                    break;
                case 21:
                    a((z) message.obj);
                    break;
                case 22:
                    bl();
                    break;
                case 23:
                    n(message.arg1 != 0);
                    break;
                case 24:
                    o(message.arg1 == 1);
                    break;
                case 25:
                    bo();
                    break;
                default:
                    return false;
            }
        } catch (p e2) {
            e = e2;
            if (e.bs == 1 && (cs2 = this.cr.cs()) != null) {
                e = e.a((com.applovin.exoplayer2.h.o) cs2.fx.fE);
            }
            if (!e.by || this.cJ != null) {
                p pVar = this.cJ;
                if (pVar != null) {
                    pVar.addSuppressed(e);
                    e = this.cJ;
                }
                q.c("ExoPlayerImplInternal", "Playback error", e);
                b(true, false);
                this.cd = this.cd.a(e);
            } else {
                q.b("ExoPlayerImplInternal", "Recoverable renderer error", e);
                this.cJ = e;
                o oVar = this.cm;
                oVar.a(oVar.c(25, e));
            }
        } catch (f.a e3) {
            b((IOException) e3, e3.errorCode);
        } catch (ai e4) {
            if (e4.gn == 1) {
                i = e4.gm ? 3001 : 3003;
            } else if (e4.gn == 4) {
                i = e4.gm ? 3002 : AuthApiStatusCodes.AUTH_TOKEN_ERROR;
            }
            b((IOException) e4, i);
        } catch (com.applovin.exoplayer2.k.j e5) {
            b((IOException) e5, e5.tA);
        } catch (com.applovin.exoplayer2.h.b e6) {
            b((IOException) e6, 1002);
        } catch (IOException e7) {
            b(e7, 2000);
        } catch (RuntimeException e8) {
            if ((e8 instanceof IllegalStateException) || (e8 instanceof IllegalArgumentException)) {
                i = 1004;
            }
            p a2 = p.a(e8, i);
            q.c("ExoPlayerImplInternal", "Playback error", a2);
            b(true, false);
            this.cd = this.cd.a(a2);
        }
        bj();
        return true;
    }

    private void b(IOException iOException, int i) {
        p a2 = p.a(iOException, i);
        ad cr2 = this.cr.cr();
        if (cr2 != null) {
            a2 = a2.a((com.applovin.exoplayer2.h.o) cr2.fx.fE);
        }
        q.c("ExoPlayerImplInternal", "Playback error", a2);
        b(false, false);
        this.cd = this.cd.a(a2);
    }

    private synchronized void a(Supplier<Boolean> supplier, long j) {
        long oK = this.bR.oK() + j;
        boolean z = false;
        while (!supplier.get().booleanValue() && j > 0) {
            try {
                this.bR.oM();
                wait(j);
            } catch (InterruptedException unused) {
                z = true;
            }
            j = oK - this.bR.oK();
        }
        if (z) {
            Thread.currentThread().interrupt();
        }
    }

    private void v(int i) {
        if (this.cd.gs != i) {
            this.cd = this.cd.W(i);
        }
    }

    private void bj() {
        this.cv.d(this.cd);
        if (this.cv.cW) {
            this.bE.onPlaybackInfoUpdate(this.cv);
            this.cv = new d(this.cd);
        }
    }

    private void bk() {
        this.cv.x(1);
        a(false, false, false, true);
        this.cl.ap();
        v(this.cd.ci.isEmpty() ? 4 : 2);
        this.cs.a(this.bO.od());
        this.cm.fs(2);
    }

    private void a(a aVar) throws p {
        this.cv.x(1);
        if (aVar.cN != -1) {
            this.cF = new g(new ap(aVar.cM, aVar.C), aVar.cN, aVar.cO);
        }
        a(this.cs.a((List<ah.c>) aVar.cM, aVar.C), false);
    }

    private void a(a aVar, int i) throws p {
        this.cv.x(1);
        ah ahVar = this.cs;
        if (i == -1) {
            i = ahVar.cx();
        }
        a(ahVar.a(i, (List<ah.c>) aVar.cM, aVar.C), false);
    }

    private void a(b bVar) throws p {
        this.cv.x(1);
        a(this.cs.a(bVar.cP, bVar.cQ, bVar.cR, bVar.C), false);
    }

    private void b(int i, int i2, z zVar) throws p {
        this.cv.x(1);
        a(this.cs.c(i, i2, zVar), false);
    }

    private void bl() throws p {
        a(this.cs.cy(), true);
    }

    private void a(z zVar) throws p {
        this.cv.x(1);
        a(this.cs.b(zVar), false);
    }

    private void m(boolean z) {
        for (ad cr2 = this.cr.cr(); cr2 != null; cr2 = cr2.ci()) {
            for (com.applovin.exoplayer2.j.d dVar : cr2.ck().VE) {
                if (dVar != null) {
                    dVar.am(z);
                }
            }
        }
    }

    private void a(boolean z, int i, boolean z2, int i2) throws p {
        this.cv.x(z2 ? 1 : 0);
        this.cv.z(i2);
        this.cd = this.cd.c(z, i);
        this.cz = false;
        m(z);
        if (!bN()) {
            bn();
            bp();
        } else if (this.cd.gs == 3) {
            bm();
            this.cm.fs(2);
        } else if (this.cd.gs == 2) {
            this.cm.fs(2);
        }
    }

    private void n(boolean z) throws p {
        this.cx = z;
        bE();
        if (this.cy && this.cr.cs() != this.cr.cr()) {
            q(true);
            s(false);
        }
    }

    private void o(boolean z) {
        if (z != this.cD) {
            this.cD = z;
            int i = this.cd.gs;
            if (z || i == 4 || i == 1) {
                this.cd = this.cd.u(z);
            } else {
                this.cm.fs(2);
            }
        }
    }

    private void w(int i) throws p {
        this.bS = i;
        if (!this.cr.a(this.cd.ci, i)) {
            q(true);
        }
        s(false);
    }

    private void p(boolean z) throws p {
        this.bT = z;
        if (!this.cr.b(this.cd.ci, z)) {
            q(true);
        }
        s(false);
    }

    private void q(boolean z) throws p {
        p.a aVar = this.cr.cr().fx.fE;
        long a2 = a(aVar, this.cd.cO, true, false);
        if (a2 != this.cd.cO) {
            this.cd = a(aVar, a2, this.cd.de, this.cd.gr, z, 5);
        }
    }

    private void bm() throws p {
        this.cz = false;
        this.cp.start();
        for (ar arVar : this.bB) {
            if (e(arVar)) {
                arVar.start();
            }
        }
    }

    private void bn() throws p {
        this.cp.W();
        for (ar arVar : this.bB) {
            if (e(arVar)) {
                c(arVar);
            }
        }
    }

    private void bo() throws p {
        q(true);
    }

    private void bp() throws p {
        ad cr2 = this.cr.cr();
        if (cr2 != null) {
            long kN = cr2.fv ? cr2.ft.kN() : -9223372036854775807L;
            if (kN != -9223372036854775807L) {
                l(kN);
                if (kN != this.cd.cO) {
                    this.cd = a(this.cd.dc, kN, this.cd.de, kN, true, 5);
                }
            } else {
                long f2 = this.cp.f(cr2 != this.cr.cs());
                this.cG = f2;
                long r = cr2.r(f2);
                e(this.cd.cO, r);
                this.cd.cO = r;
            }
            this.cd.gA = this.cr.cq().cg();
            this.cd.gB = bM();
            if (this.cd.gw && this.cd.gs == 3 && a(this.cd.ci, this.cd.dc) && this.cd.gy.gD == 1.0f) {
                float a2 = this.ct.a(bs(), bM());
                if (this.cp.av().gD != a2) {
                    this.cp.a(this.cd.gy.f(a2));
                    a(this.cd.gy, this.cp.av().gD, false, false);
                }
            }
        }
    }

    private void bq() {
        for (ad cr2 = this.cr.cr(); cr2 != null; cr2 = cr2.ci()) {
            for (com.applovin.exoplayer2.j.d dVar : cr2.ck().VE) {
                if (dVar != null) {
                    dVar.no();
                }
            }
        }
    }

    private void br() throws p, IOException {
        boolean z;
        boolean z2;
        boolean z3;
        long oL = this.bR.oL();
        by();
        if (this.cd.gs == 1 || this.cd.gs == 4) {
            this.cm.ft(2);
            return;
        }
        ad cr2 = this.cr.cr();
        if (cr2 == null) {
            c(oL, 10);
            return;
        }
        com.applovin.exoplayer2.l.ah.bg("doSomeWork");
        bp();
        if (cr2.fv) {
            long elapsedRealtime = SystemClock.elapsedRealtime() * 1000;
            cr2.ft.d(this.cd.cO - this.aT, this.aU);
            int i = 0;
            z2 = true;
            z = true;
            while (true) {
                ar[] arVarArr = this.bB;
                if (i >= arVarArr.length) {
                    break;
                }
                ar arVar = arVarArr[i];
                if (e(arVar)) {
                    arVar.g(this.cG, elapsedRealtime);
                    z2 = z2 && arVar.cR();
                    boolean z4 = cr2.fu[i] != arVar.Q();
                    boolean z5 = z4 || (!z4 && arVar.R()) || arVar.isReady() || arVar.cR();
                    z = z && z5;
                    if (!z5) {
                        arVar.V();
                    }
                }
                i++;
            }
        } else {
            cr2.ft.kM();
            z2 = true;
            z = true;
        }
        long j = cr2.fx.fH;
        boolean z6 = z2 && cr2.fv && (j == -9223372036854775807L || j <= this.cd.cO);
        if (z6 && this.cy) {
            this.cy = false;
            a(false, this.cd.gx, false, 5);
        }
        if (z6 && cr2.fx.fL) {
            v(4);
            bn();
        } else if (this.cd.gs == 2 && r(z)) {
            v(3);
            this.cJ = null;
            if (bN()) {
                bm();
            }
        } else if (this.cd.gs == 3 && (this.cE != 0 ? !z : !bw())) {
            this.cz = bN();
            v(2);
            if (this.cz) {
                bq();
                this.ct.al();
            }
            bn();
        }
        if (this.cd.gs == 2) {
            int i2 = 0;
            while (true) {
                ar[] arVarArr2 = this.bB;
                if (i2 >= arVarArr2.length) {
                    break;
                }
                if (e(arVarArr2[i2]) && this.bB[i2].Q() == cr2.fu[i2]) {
                    this.bB[i2].V();
                }
                i2++;
            }
            if (!this.cd.aW && this.cd.gB < 500000 && bJ()) {
                throw new IllegalStateException("Playback stuck buffering and not loading");
            }
        }
        if (this.cD != this.cd.cD) {
            this.cd = this.cd.u(this.cD);
        }
        if ((!bN() || this.cd.gs != 3) && this.cd.gs != 2) {
            if (this.cE == 0 || this.cd.gs == 4) {
                this.cm.ft(2);
            } else {
                c(oL, 1000);
            }
            z3 = false;
        } else {
            z3 = !d(oL, 10);
        }
        if (this.cd.gz != z3) {
            this.cd = this.cd.v(z3);
        }
        this.cC = false;
        com.applovin.exoplayer2.l.ah.pV();
    }

    private long bs() {
        return a(this.cd.ci, this.cd.dc.gM, this.cd.cO);
    }

    private long a(ba baVar, Object obj, long j) {
        baVar.a(baVar.a(obj, this.bI).cN, this.U);
        if (this.U.iK == -9223372036854775807L || !this.U.dn() || !this.U.iN) {
            return -9223372036854775807L;
        }
        return h.g(this.U.dm() - this.U.iK) - (j + this.bI.df());
    }

    private boolean a(ba baVar, p.a aVar) {
        if (aVar.la() || baVar.isEmpty()) {
            return false;
        }
        baVar.a(baVar.a(aVar.gM, this.bI).cN, this.U);
        if (!this.U.dn() || !this.U.iN || this.U.iK == -9223372036854775807L) {
            return false;
        }
        return true;
    }

    private void c(long j, long j2) {
        this.cm.ft(2);
        this.cm.k(2, j + j2);
    }

    private boolean d(long j, long j2) {
        if (this.cD && this.cC) {
            return false;
        }
        c(j, j2);
        return true;
    }

    /* JADX WARNING: Removed duplicated region for block: B:23:0x00ab A[Catch:{ all -> 0x0152 }] */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x00ae A[Catch:{ all -> 0x0152 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void a(com.applovin.exoplayer2.s.g r20) throws com.applovin.exoplayer2.p {
        /*
            r19 = this;
            r11 = r19
            r0 = r20
            com.applovin.exoplayer2.s$d r1 = r11.cv
            r8 = 1
            r1.x(r8)
            com.applovin.exoplayer2.al r1 = r11.cd
            com.applovin.exoplayer2.ba r1 = r1.ci
            r3 = 1
            int r4 = r11.bS
            boolean r5 = r11.bT
            com.applovin.exoplayer2.ba$c r6 = r11.U
            com.applovin.exoplayer2.ba$a r7 = r11.bI
            r2 = r20
            android.util.Pair r1 = a((com.applovin.exoplayer2.ba) r1, (com.applovin.exoplayer2.s.g) r2, (boolean) r3, (int) r4, (boolean) r5, (com.applovin.exoplayer2.ba.c) r6, (com.applovin.exoplayer2.ba.a) r7)
            r2 = 0
            r4 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            r6 = 0
            if (r1 != 0) goto L_0x004b
            com.applovin.exoplayer2.al r7 = r11.cd
            com.applovin.exoplayer2.ba r7 = r7.ci
            android.util.Pair r7 = r11.a((com.applovin.exoplayer2.ba) r7)
            java.lang.Object r9 = r7.first
            com.applovin.exoplayer2.h.p$a r9 = (com.applovin.exoplayer2.h.p.a) r9
            java.lang.Object r7 = r7.second
            java.lang.Long r7 = (java.lang.Long) r7
            long r12 = r7.longValue()
            com.applovin.exoplayer2.al r7 = r11.cd
            com.applovin.exoplayer2.ba r7 = r7.ci
            boolean r7 = r7.isEmpty()
            r7 = r7 ^ r8
            r10 = r7
            r17 = r4
        L_0x0047:
            r4 = r12
            r12 = r17
            goto L_0x00a1
        L_0x004b:
            java.lang.Object r7 = r1.first
            java.lang.Object r9 = r1.second
            java.lang.Long r9 = (java.lang.Long) r9
            long r12 = r9.longValue()
            long r9 = r0.di
            int r14 = (r9 > r4 ? 1 : (r9 == r4 ? 0 : -1))
            if (r14 != 0) goto L_0x005d
            r9 = r4
            goto L_0x005e
        L_0x005d:
            r9 = r12
        L_0x005e:
            com.applovin.exoplayer2.af r14 = r11.cr
            com.applovin.exoplayer2.al r15 = r11.cd
            com.applovin.exoplayer2.ba r15 = r15.ci
            com.applovin.exoplayer2.h.p$a r7 = r14.b(r15, r7, r12)
            boolean r14 = r7.la()
            if (r14 == 0) goto L_0x0093
            com.applovin.exoplayer2.al r4 = r11.cd
            com.applovin.exoplayer2.ba r4 = r4.ci
            java.lang.Object r5 = r7.gM
            com.applovin.exoplayer2.ba$a r12 = r11.bI
            r4.a((java.lang.Object) r5, (com.applovin.exoplayer2.ba.a) r12)
            com.applovin.exoplayer2.ba$a r4 = r11.bI
            int r5 = r7.gP
            int r4 = r4.am(r5)
            int r5 = r7.gQ
            if (r4 != r5) goto L_0x008d
            com.applovin.exoplayer2.ba$a r4 = r11.bI
            long r4 = r4.di()
            r12 = r4
            goto L_0x008e
        L_0x008d:
            r12 = r2
        L_0x008e:
            r4 = r12
            r12 = r9
            r10 = 1
            r9 = r7
            goto L_0x00a1
        L_0x0093:
            long r14 = r0.di
            int r16 = (r14 > r4 ? 1 : (r14 == r4 ? 0 : -1))
            if (r16 != 0) goto L_0x009b
            r4 = 1
            goto L_0x009c
        L_0x009b:
            r4 = 0
        L_0x009c:
            r17 = r9
            r10 = r4
            r9 = r7
            goto L_0x0047
        L_0x00a1:
            com.applovin.exoplayer2.al r7 = r11.cd     // Catch:{ all -> 0x0152 }
            com.applovin.exoplayer2.ba r7 = r7.ci     // Catch:{ all -> 0x0152 }
            boolean r7 = r7.isEmpty()     // Catch:{ all -> 0x0152 }
            if (r7 == 0) goto L_0x00ae
            r11.cF = r0     // Catch:{ all -> 0x0152 }
            goto L_0x00bd
        L_0x00ae:
            r0 = 4
            if (r1 != 0) goto L_0x00c0
            com.applovin.exoplayer2.al r1 = r11.cd     // Catch:{ all -> 0x0152 }
            int r1 = r1.gs     // Catch:{ all -> 0x0152 }
            if (r1 == r8) goto L_0x00ba
            r11.v(r0)     // Catch:{ all -> 0x0152 }
        L_0x00ba:
            r11.a((boolean) r6, (boolean) r8, (boolean) r6, (boolean) r8)     // Catch:{ all -> 0x0152 }
        L_0x00bd:
            r7 = r4
            goto L_0x013f
        L_0x00c0:
            com.applovin.exoplayer2.al r1 = r11.cd     // Catch:{ all -> 0x0152 }
            com.applovin.exoplayer2.h.p$a r1 = r1.dc     // Catch:{ all -> 0x0152 }
            boolean r1 = r9.equals(r1)     // Catch:{ all -> 0x0152 }
            if (r1 == 0) goto L_0x0115
            com.applovin.exoplayer2.af r1 = r11.cr     // Catch:{ all -> 0x0152 }
            com.applovin.exoplayer2.ad r1 = r1.cr()     // Catch:{ all -> 0x0152 }
            if (r1 == 0) goto L_0x00e3
            boolean r7 = r1.fv     // Catch:{ all -> 0x0152 }
            if (r7 == 0) goto L_0x00e3
            int r7 = (r4 > r2 ? 1 : (r4 == r2 ? 0 : -1))
            if (r7 == 0) goto L_0x00e3
            com.applovin.exoplayer2.h.n r1 = r1.ft     // Catch:{ all -> 0x0152 }
            com.applovin.exoplayer2.av r2 = r11.bY     // Catch:{ all -> 0x0152 }
            long r1 = r1.a((long) r4, (com.applovin.exoplayer2.av) r2)     // Catch:{ all -> 0x0152 }
            goto L_0x00e4
        L_0x00e3:
            r1 = r4
        L_0x00e4:
            long r14 = com.applovin.exoplayer2.h.f(r1)     // Catch:{ all -> 0x0152 }
            com.applovin.exoplayer2.al r3 = r11.cd     // Catch:{ all -> 0x0152 }
            long r6 = r3.cO     // Catch:{ all -> 0x0152 }
            long r6 = com.applovin.exoplayer2.h.f(r6)     // Catch:{ all -> 0x0152 }
            int r3 = (r14 > r6 ? 1 : (r14 == r6 ? 0 : -1))
            if (r3 != 0) goto L_0x0116
            com.applovin.exoplayer2.al r3 = r11.cd     // Catch:{ all -> 0x0152 }
            int r3 = r3.gs     // Catch:{ all -> 0x0152 }
            r6 = 2
            if (r3 == r6) goto L_0x0102
            com.applovin.exoplayer2.al r3 = r11.cd     // Catch:{ all -> 0x0152 }
            int r3 = r3.gs     // Catch:{ all -> 0x0152 }
            r6 = 3
            if (r3 != r6) goto L_0x0116
        L_0x0102:
            com.applovin.exoplayer2.al r0 = r11.cd     // Catch:{ all -> 0x0152 }
            long r7 = r0.cO     // Catch:{ all -> 0x0152 }
            r0 = 2
            r1 = r19
            r2 = r9
            r3 = r7
            r5 = r12
            r9 = r10
            r10 = r0
            com.applovin.exoplayer2.al r0 = r1.a(r2, r3, r5, r7, r9, r10)
            r11.cd = r0
            return
        L_0x0115:
            r1 = r4
        L_0x0116:
            com.applovin.exoplayer2.al r3 = r11.cd     // Catch:{ all -> 0x0152 }
            int r3 = r3.gs     // Catch:{ all -> 0x0152 }
            if (r3 != r0) goto L_0x011e
            r0 = 1
            goto L_0x011f
        L_0x011e:
            r0 = 0
        L_0x011f:
            long r14 = r11.a((com.applovin.exoplayer2.h.p.a) r9, (long) r1, (boolean) r0)     // Catch:{ all -> 0x0152 }
            int r0 = (r4 > r14 ? 1 : (r4 == r14 ? 0 : -1))
            if (r0 == 0) goto L_0x0128
            goto L_0x0129
        L_0x0128:
            r8 = 0
        L_0x0129:
            r8 = r8 | r10
            com.applovin.exoplayer2.al r0 = r11.cd     // Catch:{ all -> 0x014e }
            com.applovin.exoplayer2.ba r2 = r0.ci     // Catch:{ all -> 0x014e }
            com.applovin.exoplayer2.al r0 = r11.cd     // Catch:{ all -> 0x014e }
            com.applovin.exoplayer2.ba r4 = r0.ci     // Catch:{ all -> 0x014e }
            com.applovin.exoplayer2.al r0 = r11.cd     // Catch:{ all -> 0x014e }
            com.applovin.exoplayer2.h.p$a r5 = r0.dc     // Catch:{ all -> 0x014e }
            r1 = r19
            r3 = r9
            r6 = r12
            r1.a(r2, r3, r4, r5, r6)     // Catch:{ all -> 0x014e }
            r10 = r8
            r7 = r14
        L_0x013f:
            r0 = 2
            r1 = r19
            r2 = r9
            r3 = r7
            r5 = r12
            r9 = r10
            r10 = r0
            com.applovin.exoplayer2.al r0 = r1.a(r2, r3, r5, r7, r9, r10)
            r11.cd = r0
            return
        L_0x014e:
            r0 = move-exception
            r10 = r8
            r7 = r14
            goto L_0x0154
        L_0x0152:
            r0 = move-exception
            r7 = r4
        L_0x0154:
            r14 = 2
            r1 = r19
            r2 = r9
            r3 = r7
            r5 = r12
            r9 = r10
            r10 = r14
            com.applovin.exoplayer2.al r1 = r1.a(r2, r3, r5, r7, r9, r10)
            r11.cd = r1
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.applovin.exoplayer2.s.a(com.applovin.exoplayer2.s$g):void");
    }

    private long a(p.a aVar, long j, boolean z) throws p {
        return a(aVar, j, this.cr.cr() != this.cr.cs(), z);
    }

    private long a(p.a aVar, long j, boolean z, boolean z2) throws p {
        bn();
        this.cz = false;
        if (z2 || this.cd.gs == 3) {
            v(2);
        }
        ad cr2 = this.cr.cr();
        ad adVar = cr2;
        while (adVar != null && !aVar.equals(adVar.fx.fE)) {
            adVar = adVar.ci();
        }
        if (z || cr2 != adVar || (adVar != null && adVar.q(j) < 0)) {
            for (ar d2 : this.bB) {
                d(d2);
            }
            if (adVar != null) {
                while (this.cr.cr() != adVar) {
                    this.cr.cu();
                }
                this.cr.b(adVar);
                adVar.s(0);
                bL();
            }
        }
        if (adVar != null) {
            this.cr.b(adVar);
            if (!adVar.fv) {
                adVar.fx = adVar.fx.v(j);
            } else if (adVar.fw) {
                long aQ = adVar.ft.aQ(j);
                adVar.ft.d(aQ - this.aT, this.aU);
                j = aQ;
            }
            l(j);
            bH();
        } else {
            this.cr.clear();
            l(j);
        }
        s(false);
        this.cm.fs(2);
        return j;
    }

    private void l(long j) throws p {
        ad cr2 = this.cr.cr();
        if (cr2 != null) {
            j = cr2.q(j);
        }
        this.cG = j;
        this.cp.d(j);
        for (ar arVar : this.bB) {
            if (e(arVar)) {
                arVar.d(this.cG);
            }
        }
        bv();
    }

    private void c(am amVar) throws p {
        this.cp.a(amVar);
        a(this.cp.av(), true);
    }

    private void a(boolean z, AtomicBoolean atomicBoolean) {
        if (this.cB != z) {
            this.cB = z;
            if (!z) {
                for (ar arVar : this.bB) {
                    if (!e(arVar) && this.cj.remove(arVar)) {
                        arVar.Y();
                    }
                }
            }
        }
        if (atomicBoolean != null) {
            synchronized (this) {
                atomicBoolean.set(true);
                notifyAll();
            }
        }
    }

    private void b(boolean z, boolean z2) {
        a(z || !this.cB, false, true, false);
        this.cv.x(z2 ? 1 : 0);
        this.cl.ab();
        v(1);
    }

    private void bt() {
        a(true, false, true, false);
        this.cl.aq();
        v(1);
        this.cn.quit();
        synchronized (this) {
            this.cw = true;
            notifyAll();
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:34:0x00c6  */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x00d0  */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x00d3  */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x00db  */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x00de  */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x00e6  */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x00eb  */
    /* JADX WARNING: Removed duplicated region for block: B:49:0x011b  */
    /* JADX WARNING: Removed duplicated region for block: B:58:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void a(boolean r35, boolean r36, boolean r37, boolean r38) {
        /*
            r34 = this;
            r1 = r34
            com.applovin.exoplayer2.l.o r0 = r1.cm
            r2 = 2
            r0.ft(r2)
            r2 = 0
            r1.cJ = r2
            r3 = 0
            r1.cz = r3
            com.applovin.exoplayer2.m r0 = r1.cp
            r0.W()
            r4 = 0
            r1.cG = r4
            com.applovin.exoplayer2.ar[] r4 = r1.bB
            int r5 = r4.length
            r6 = 0
        L_0x001b:
            java.lang.String r7 = "ExoPlayerImplInternal"
            if (r6 >= r5) goto L_0x0030
            r0 = r4[r6]
            r1.d((com.applovin.exoplayer2.ar) r0)     // Catch:{ p -> 0x0027, RuntimeException -> 0x0025 }
            goto L_0x002d
        L_0x0025:
            r0 = move-exception
            goto L_0x0028
        L_0x0027:
            r0 = move-exception
        L_0x0028:
            java.lang.String r8 = "Disable failed."
            com.applovin.exoplayer2.l.q.c(r7, r8, r0)
        L_0x002d:
            int r6 = r6 + 1
            goto L_0x001b
        L_0x0030:
            if (r35 == 0) goto L_0x0050
            com.applovin.exoplayer2.ar[] r4 = r1.bB
            int r5 = r4.length
            r6 = 0
        L_0x0036:
            if (r6 >= r5) goto L_0x0050
            r0 = r4[r6]
            java.util.Set<com.applovin.exoplayer2.ar> r8 = r1.cj
            boolean r8 = r8.remove(r0)
            if (r8 == 0) goto L_0x004d
            r0.Y()     // Catch:{ RuntimeException -> 0x0046 }
            goto L_0x004d
        L_0x0046:
            r0 = move-exception
            r8 = r0
            java.lang.String r0 = "Reset failed."
            com.applovin.exoplayer2.l.q.c(r7, r0, r8)
        L_0x004d:
            int r6 = r6 + 1
            goto L_0x0036
        L_0x0050:
            r1.cE = r3
            com.applovin.exoplayer2.al r0 = r1.cd
            com.applovin.exoplayer2.h.p$a r0 = r0.dc
            com.applovin.exoplayer2.al r4 = r1.cd
            long r4 = r4.cO
            com.applovin.exoplayer2.al r6 = r1.cd
            com.applovin.exoplayer2.h.p$a r6 = r6.dc
            boolean r6 = r6.la()
            if (r6 != 0) goto L_0x0074
            com.applovin.exoplayer2.al r6 = r1.cd
            com.applovin.exoplayer2.ba$a r7 = r1.bI
            boolean r6 = a((com.applovin.exoplayer2.al) r6, (com.applovin.exoplayer2.ba.a) r7)
            if (r6 == 0) goto L_0x006f
            goto L_0x0074
        L_0x006f:
            com.applovin.exoplayer2.al r6 = r1.cd
            long r6 = r6.cO
            goto L_0x0078
        L_0x0074:
            com.applovin.exoplayer2.al r6 = r1.cd
            long r6 = r6.de
        L_0x0078:
            if (r36 == 0) goto L_0x00ac
            r1.cF = r2
            com.applovin.exoplayer2.al r0 = r1.cd
            com.applovin.exoplayer2.ba r0 = r0.ci
            android.util.Pair r0 = r1.a((com.applovin.exoplayer2.ba) r0)
            java.lang.Object r4 = r0.first
            com.applovin.exoplayer2.h.p$a r4 = (com.applovin.exoplayer2.h.p.a) r4
            java.lang.Object r0 = r0.second
            java.lang.Long r0 = (java.lang.Long) r0
            long r5 = r0.longValue()
            com.applovin.exoplayer2.al r0 = r1.cd
            com.applovin.exoplayer2.h.p$a r0 = r0.dc
            boolean r0 = r4.equals(r0)
            r7 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            if (r0 != 0) goto L_0x00a6
            r0 = 1
            r22 = r4
            r30 = r5
            r12 = r7
            goto L_0x00b2
        L_0x00a6:
            r22 = r4
            r30 = r5
            r12 = r7
            goto L_0x00b1
        L_0x00ac:
            r22 = r0
            r30 = r4
            r12 = r6
        L_0x00b1:
            r0 = 0
        L_0x00b2:
            com.applovin.exoplayer2.af r4 = r1.cr
            r4.clear()
            r1.cA = r3
            com.applovin.exoplayer2.al r3 = new com.applovin.exoplayer2.al
            com.applovin.exoplayer2.al r4 = r1.cd
            com.applovin.exoplayer2.ba r10 = r4.ci
            com.applovin.exoplayer2.al r4 = r1.cd
            int r4 = r4.gs
            if (r38 == 0) goto L_0x00c6
            goto L_0x00ca
        L_0x00c6:
            com.applovin.exoplayer2.al r2 = r1.cd
            com.applovin.exoplayer2.p r2 = r2.gt
        L_0x00ca:
            r17 = r2
            r18 = 0
            if (r0 == 0) goto L_0x00d3
            com.applovin.exoplayer2.h.ad r2 = com.applovin.exoplayer2.h.ad.NG
            goto L_0x00d7
        L_0x00d3:
            com.applovin.exoplayer2.al r2 = r1.cd
            com.applovin.exoplayer2.h.ad r2 = r2.fB
        L_0x00d7:
            r19 = r2
            if (r0 == 0) goto L_0x00de
            com.applovin.exoplayer2.j.k r2 = r1.bz
            goto L_0x00e2
        L_0x00de:
            com.applovin.exoplayer2.al r2 = r1.cd
            com.applovin.exoplayer2.j.k r2 = r2.fC
        L_0x00e2:
            r20 = r2
            if (r0 == 0) goto L_0x00eb
            com.applovin.exoplayer2.common.a.s r0 = com.applovin.exoplayer2.common.a.s.ga()
            goto L_0x00ef
        L_0x00eb:
            com.applovin.exoplayer2.al r0 = r1.cd
            java.util.List<com.applovin.exoplayer2.g.a> r0 = r0.gu
        L_0x00ef:
            r21 = r0
            com.applovin.exoplayer2.al r0 = r1.cd
            boolean r0 = r0.gw
            r23 = r0
            com.applovin.exoplayer2.al r0 = r1.cd
            int r0 = r0.gx
            r24 = r0
            com.applovin.exoplayer2.al r0 = r1.cd
            com.applovin.exoplayer2.am r0 = r0.gy
            r25 = r0
            r28 = 0
            boolean r0 = r1.cD
            r32 = r0
            r33 = 0
            r9 = r3
            r11 = r22
            r14 = r30
            r16 = r4
            r26 = r30
            r9.<init>(r10, r11, r12, r14, r16, r17, r18, r19, r20, r21, r22, r23, r24, r25, r26, r28, r30, r32, r33)
            r1.cd = r3
            if (r37 == 0) goto L_0x0120
            com.applovin.exoplayer2.ah r0 = r1.cs
            r0.release()
        L_0x0120:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.applovin.exoplayer2.s.a(boolean, boolean, boolean, boolean):void");
    }

    private Pair<p.a, Long> a(ba baVar) {
        long j = 0;
        if (baVar.isEmpty()) {
            return Pair.create(al.cB(), 0L);
        }
        ba baVar2 = baVar;
        Pair<Object, Long> a2 = baVar2.a(this.U, this.bI, baVar.d(this.bT), -9223372036854775807L);
        p.a b2 = this.cr.b(baVar, a2.first, 0);
        long longValue = ((Long) a2.second).longValue();
        if (b2.la()) {
            baVar.a(b2.gM, this.bI);
            if (b2.gQ == this.bI.am(b2.gP)) {
                j = this.bI.di();
            }
            longValue = j;
        }
        return Pair.create(b2, Long.valueOf(longValue));
    }

    private void b(ao aoVar) throws p {
        if (aoVar.cJ() == -9223372036854775807L) {
            c(aoVar);
        } else if (this.cd.ci.isEmpty()) {
            this.cq.add(new c(aoVar));
        } else {
            c cVar = new c(aoVar);
            if (a(cVar, this.cd.ci, this.cd.ci, this.bS, this.bT, this.U, this.bI)) {
                this.cq.add(cVar);
                Collections.sort(this.cq);
                return;
            }
            aoVar.B(false);
        }
    }

    private void c(ao aoVar) throws p {
        if (aoVar.cI() == this.co) {
            e(aoVar);
            if (this.cd.gs == 3 || this.cd.gs == 2) {
                this.cm.fs(2);
                return;
            }
            return;
        }
        this.cm.c(15, aoVar).oY();
    }

    private void d(ao aoVar) {
        Looper cI2 = aoVar.cI();
        if (!cI2.getThread().isAlive()) {
            q.h("TAG", "Trying to send message on a dead thread.");
            aoVar.B(false);
            return;
        }
        this.bR.a(cI2, (Handler.Callback) null).e(new s$$ExternalSyntheticLambda0(this, aoVar));
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void f(ao aoVar) {
        try {
            e(aoVar);
        } catch (p e2) {
            q.c("ExoPlayerImplInternal", "Unexpected error delivering message on external thread.", e2);
            throw new RuntimeException(e2);
        }
    }

    private void e(ao aoVar) throws p {
        if (!aoVar.cN()) {
            try {
                aoVar.cF().a(aoVar.cG(), aoVar.cH());
            } finally {
                aoVar.B(true);
            }
        }
    }

    private void b(ba baVar, ba baVar2) {
        if (!baVar.isEmpty() || !baVar2.isEmpty()) {
            for (int size = this.cq.size() - 1; size >= 0; size--) {
                if (!a(this.cq.get(size), baVar, baVar2, this.bS, this.bT, this.U, this.bI)) {
                    this.cq.get(size).cS.B(false);
                    this.cq.remove(size);
                }
            }
            Collections.sort(this.cq);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:36:0x0091  */
    /* JADX WARNING: Removed duplicated region for block: B:48:0x00ba A[SYNTHETIC, Splitter:B:48:0x00ba] */
    /* JADX WARNING: Removed duplicated region for block: B:88:0x00a4 A[EDGE_INSN: B:74:0x00a4->B:88:0x00a4 ?: BREAK  
    EDGE_INSN: B:76:0x00a4->B:88:0x00a4 ?: BREAK  
    EDGE_INSN: B:77:0x00a4->B:88:0x00a4 ?: BREAK  
    EDGE_INSN: B:78:0x00a4->B:88:0x00a4 ?: BREAK  , SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void e(long r9, long r11) throws com.applovin.exoplayer2.p {
        /*
            r8 = this;
            java.util.ArrayList<com.applovin.exoplayer2.s$c> r0 = r8.cq
            boolean r0 = r0.isEmpty()
            if (r0 != 0) goto L_0x0104
            com.applovin.exoplayer2.al r0 = r8.cd
            com.applovin.exoplayer2.h.p$a r0 = r0.dc
            boolean r0 = r0.la()
            if (r0 == 0) goto L_0x0014
            goto L_0x0104
        L_0x0014:
            boolean r0 = r8.cI
            if (r0 == 0) goto L_0x001e
            r0 = 1
            long r9 = r9 - r0
            r0 = 0
            r8.cI = r0
        L_0x001e:
            com.applovin.exoplayer2.al r0 = r8.cd
            com.applovin.exoplayer2.ba r0 = r0.ci
            com.applovin.exoplayer2.al r1 = r8.cd
            com.applovin.exoplayer2.h.p$a r1 = r1.dc
            java.lang.Object r1 = r1.gM
            int r0 = r0.c((java.lang.Object) r1)
            int r1 = r8.cH
            java.util.ArrayList<com.applovin.exoplayer2.s$c> r2 = r8.cq
            int r2 = r2.size()
            int r1 = java.lang.Math.min(r1, r2)
            r2 = 0
            if (r1 <= 0) goto L_0x0046
            java.util.ArrayList<com.applovin.exoplayer2.s$c> r3 = r8.cq
            int r4 = r1 + -1
            java.lang.Object r3 = r3.get(r4)
            com.applovin.exoplayer2.s$c r3 = (com.applovin.exoplayer2.s.c) r3
            goto L_0x0047
        L_0x0046:
            r3 = r2
        L_0x0047:
            if (r3 == 0) goto L_0x006b
            int r4 = r3.cT
            if (r4 > r0) goto L_0x0057
            int r4 = r3.cT
            if (r4 != r0) goto L_0x006b
            long r3 = r3.cU
            int r5 = (r3 > r9 ? 1 : (r3 == r9 ? 0 : -1))
            if (r5 <= 0) goto L_0x006b
        L_0x0057:
            int r3 = r1 + -1
            if (r3 <= 0) goto L_0x0066
            java.util.ArrayList<com.applovin.exoplayer2.s$c> r4 = r8.cq
            int r1 = r1 + -2
            java.lang.Object r1 = r4.get(r1)
            com.applovin.exoplayer2.s$c r1 = (com.applovin.exoplayer2.s.c) r1
            goto L_0x0067
        L_0x0066:
            r1 = r2
        L_0x0067:
            r7 = r3
            r3 = r1
            r1 = r7
            goto L_0x0047
        L_0x006b:
            java.util.ArrayList<com.applovin.exoplayer2.s$c> r3 = r8.cq
            int r3 = r3.size()
            if (r1 >= r3) goto L_0x007c
            java.util.ArrayList<com.applovin.exoplayer2.s$c> r3 = r8.cq
            java.lang.Object r3 = r3.get(r1)
            com.applovin.exoplayer2.s$c r3 = (com.applovin.exoplayer2.s.c) r3
            goto L_0x007d
        L_0x007c:
            r3 = r2
        L_0x007d:
            if (r3 == 0) goto L_0x00a4
            java.lang.Object r4 = r3.cV
            if (r4 == 0) goto L_0x00a4
            int r4 = r3.cT
            if (r4 < r0) goto L_0x0091
            int r4 = r3.cT
            if (r4 != r0) goto L_0x00a4
            long r4 = r3.cU
            int r6 = (r4 > r9 ? 1 : (r4 == r9 ? 0 : -1))
            if (r6 > 0) goto L_0x00a4
        L_0x0091:
            int r1 = r1 + 1
            java.util.ArrayList<com.applovin.exoplayer2.s$c> r3 = r8.cq
            int r3 = r3.size()
            if (r1 >= r3) goto L_0x007c
            java.util.ArrayList<com.applovin.exoplayer2.s$c> r3 = r8.cq
            java.lang.Object r3 = r3.get(r1)
            com.applovin.exoplayer2.s$c r3 = (com.applovin.exoplayer2.s.c) r3
            goto L_0x007d
        L_0x00a4:
            if (r3 == 0) goto L_0x0102
            java.lang.Object r4 = r3.cV
            if (r4 == 0) goto L_0x0102
            int r4 = r3.cT
            if (r4 != r0) goto L_0x0102
            long r4 = r3.cU
            int r6 = (r4 > r9 ? 1 : (r4 == r9 ? 0 : -1))
            if (r6 <= 0) goto L_0x0102
            long r4 = r3.cU
            int r6 = (r4 > r11 ? 1 : (r4 == r11 ? 0 : -1))
            if (r6 > 0) goto L_0x0102
            com.applovin.exoplayer2.ao r4 = r3.cS     // Catch:{ all -> 0x00eb }
            r8.c((com.applovin.exoplayer2.ao) r4)     // Catch:{ all -> 0x00eb }
            com.applovin.exoplayer2.ao r4 = r3.cS
            boolean r4 = r4.cL()
            if (r4 != 0) goto L_0x00d3
            com.applovin.exoplayer2.ao r3 = r3.cS
            boolean r3 = r3.cN()
            if (r3 == 0) goto L_0x00d0
            goto L_0x00d3
        L_0x00d0:
            int r1 = r1 + 1
            goto L_0x00d8
        L_0x00d3:
            java.util.ArrayList<com.applovin.exoplayer2.s$c> r3 = r8.cq
            r3.remove(r1)
        L_0x00d8:
            java.util.ArrayList<com.applovin.exoplayer2.s$c> r3 = r8.cq
            int r3 = r3.size()
            if (r1 >= r3) goto L_0x00e9
            java.util.ArrayList<com.applovin.exoplayer2.s$c> r3 = r8.cq
            java.lang.Object r3 = r3.get(r1)
            com.applovin.exoplayer2.s$c r3 = (com.applovin.exoplayer2.s.c) r3
            goto L_0x00a4
        L_0x00e9:
            r3 = r2
            goto L_0x00a4
        L_0x00eb:
            r9 = move-exception
            com.applovin.exoplayer2.ao r10 = r3.cS
            boolean r10 = r10.cL()
            if (r10 != 0) goto L_0x00fc
            com.applovin.exoplayer2.ao r10 = r3.cS
            boolean r10 = r10.cN()
            if (r10 == 0) goto L_0x0101
        L_0x00fc:
            java.util.ArrayList<com.applovin.exoplayer2.s$c> r10 = r8.cq
            r10.remove(r1)
        L_0x0101:
            throw r9
        L_0x0102:
            r8.cH = r1
        L_0x0104:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.applovin.exoplayer2.s.e(long, long):void");
    }

    private void c(ar arVar) throws p {
        if (arVar.P() == 2) {
            arVar.W();
        }
    }

    private void d(ar arVar) throws p {
        if (e(arVar)) {
            this.cp.b(arVar);
            c(arVar);
            arVar.X();
            this.cE--;
        }
    }

    private void bu() throws p {
        float f2 = this.cp.av().gD;
        ad cr2 = this.cr.cr();
        ad cs2 = this.cr.cs();
        boolean z = true;
        while (cr2 != null && cr2.fv) {
            k b2 = cr2.b(f2, this.cd.ci);
            if (!b2.b(cr2.ck())) {
                if (z) {
                    ad cr3 = this.cr.cr();
                    boolean b3 = this.cr.b(cr3);
                    boolean[] zArr = new boolean[this.bB.length];
                    long a2 = cr3.a(b2, this.cd.cO, b3, zArr);
                    boolean z2 = (this.cd.gs == 4 || a2 == this.cd.cO) ? false : true;
                    ad adVar = cr3;
                    boolean[] zArr2 = zArr;
                    this.cd = a(this.cd.dc, a2, this.cd.de, this.cd.gr, z2, 5);
                    if (z2) {
                        l(a2);
                    }
                    boolean[] zArr3 = new boolean[this.bB.length];
                    int i = 0;
                    while (true) {
                        ar[] arVarArr = this.bB;
                        if (i >= arVarArr.length) {
                            break;
                        }
                        ar arVar = arVarArr[i];
                        zArr3[i] = e(arVar);
                        x xVar = adVar.fu[i];
                        if (zArr3[i]) {
                            if (xVar != arVar.Q()) {
                                d(arVar);
                            } else if (zArr2[i]) {
                                arVar.d(this.cG);
                            }
                        }
                        i++;
                    }
                    a(zArr3);
                } else {
                    this.cr.b(cr2);
                    if (cr2.fv) {
                        cr2.a(b2, Math.max(cr2.fx.fF, cr2.r(this.cG)), false);
                    }
                }
                s(true);
                if (this.cd.gs != 4) {
                    bH();
                    bp();
                    this.cm.fs(2);
                    return;
                }
                return;
            }
            if (cr2 == cs2) {
                z = false;
            }
            cr2 = cr2.ci();
        }
    }

    private void c(float f2) {
        for (ad cr2 = this.cr.cr(); cr2 != null; cr2 = cr2.ci()) {
            for (com.applovin.exoplayer2.j.d dVar : cr2.ck().VE) {
                if (dVar != null) {
                    dVar.v(f2);
                }
            }
        }
    }

    private void bv() {
        for (ad cr2 = this.cr.cr(); cr2 != null; cr2 = cr2.ci()) {
            for (com.applovin.exoplayer2.j.d dVar : cr2.ck().VE) {
                if (dVar != null) {
                    dVar.nn();
                }
            }
        }
    }

    private boolean r(boolean z) {
        if (this.cE == 0) {
            return bw();
        }
        if (!z) {
            return false;
        }
        if (!this.cd.aW) {
            return true;
        }
        long am = a(this.cd.ci, this.cr.cr().fx.fE) ? this.ct.am() : -9223372036854775807L;
        ad cq2 = this.cr.cq();
        boolean z2 = cq2.cf() && cq2.fx.fL;
        boolean z3 = cq2.fx.fE.la() && !cq2.fv;
        if (z2 || z3 || this.cl.a(bM(), this.cp.av().gD, this.cz, am)) {
            return true;
        }
        return false;
    }

    private boolean bw() {
        ad cr2 = this.cr.cr();
        long j = cr2.fx.fH;
        return cr2.fv && (j == -9223372036854775807L || this.cd.cO < j || !bN());
    }

    /* JADX WARNING: Removed duplicated region for block: B:66:0x013b  */
    /* JADX WARNING: Removed duplicated region for block: B:73:0x015e A[ADDED_TO_REGION] */
    /* JADX WARNING: Removed duplicated region for block: B:82:0x0180  */
    /* JADX WARNING: Removed duplicated region for block: B:86:0x01aa  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void a(com.applovin.exoplayer2.ba r25, boolean r26) throws com.applovin.exoplayer2.p {
        /*
            r24 = this;
            r11 = r24
            r12 = r25
            com.applovin.exoplayer2.al r2 = r11.cd
            com.applovin.exoplayer2.s$g r3 = r11.cF
            com.applovin.exoplayer2.af r4 = r11.cr
            int r5 = r11.bS
            boolean r6 = r11.bT
            com.applovin.exoplayer2.ba$c r7 = r11.U
            com.applovin.exoplayer2.ba$a r8 = r11.bI
            r1 = r25
            com.applovin.exoplayer2.s$f r7 = a(r1, r2, r3, r4, r5, r6, r7, r8)
            com.applovin.exoplayer2.h.p$a r8 = r7.dc
            long r9 = r7.de
            boolean r0 = r7.df
            long r13 = r7.dd
            com.applovin.exoplayer2.al r1 = r11.cd
            com.applovin.exoplayer2.h.p$a r1 = r1.dc
            boolean r1 = r1.equals(r8)
            r15 = 1
            r5 = 0
            if (r1 == 0) goto L_0x0038
            com.applovin.exoplayer2.al r1 = r11.cd
            long r1 = r1.cO
            int r3 = (r13 > r1 ? 1 : (r13 == r1 ? 0 : -1))
            if (r3 == 0) goto L_0x0035
            goto L_0x0038
        L_0x0035:
            r16 = 0
            goto L_0x003a
        L_0x0038:
            r16 = 1
        L_0x003a:
            r17 = 3
            r6 = 0
            r18 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            r4 = 4
            boolean r1 = r7.dg     // Catch:{ all -> 0x012b }
            if (r1 == 0) goto L_0x0053
            com.applovin.exoplayer2.al r1 = r11.cd     // Catch:{ all -> 0x012b }
            int r1 = r1.gs     // Catch:{ all -> 0x012b }
            if (r1 == r15) goto L_0x0050
            r11.v(r4)     // Catch:{ all -> 0x012b }
        L_0x0050:
            r11.a((boolean) r5, (boolean) r5, (boolean) r5, (boolean) r15)     // Catch:{ all -> 0x012b }
        L_0x0053:
            if (r16 != 0) goto L_0x0075
            com.applovin.exoplayer2.af r1 = r11.cr     // Catch:{ all -> 0x006f }
            long r3 = r11.cG     // Catch:{ all -> 0x006f }
            long r21 = r24.bx()     // Catch:{ all -> 0x006f }
            r2 = r25
            r15 = -1
            r20 = 4
            r15 = 0
            r5 = r21
            boolean r0 = r1.a((com.applovin.exoplayer2.ba) r2, (long) r3, (long) r5)     // Catch:{ all -> 0x0128 }
            if (r0 != 0) goto L_0x00a7
            r11.q(r15)     // Catch:{ all -> 0x0128 }
            goto L_0x00a7
        L_0x006f:
            r0 = move-exception
            r15 = 0
            r20 = 4
            goto L_0x0129
        L_0x0075:
            r15 = 0
            r20 = 4
            boolean r1 = r25.isEmpty()     // Catch:{ all -> 0x0128 }
            if (r1 != 0) goto L_0x00a7
            com.applovin.exoplayer2.af r1 = r11.cr     // Catch:{ all -> 0x0128 }
            com.applovin.exoplayer2.ad r1 = r1.cr()     // Catch:{ all -> 0x0128 }
        L_0x0084:
            if (r1 == 0) goto L_0x00a2
            com.applovin.exoplayer2.ae r2 = r1.fx     // Catch:{ all -> 0x0128 }
            com.applovin.exoplayer2.h.p$a r2 = r2.fE     // Catch:{ all -> 0x0128 }
            boolean r2 = r2.equals(r8)     // Catch:{ all -> 0x0128 }
            if (r2 == 0) goto L_0x009d
            com.applovin.exoplayer2.af r2 = r11.cr     // Catch:{ all -> 0x0128 }
            com.applovin.exoplayer2.ae r3 = r1.fx     // Catch:{ all -> 0x0128 }
            com.applovin.exoplayer2.ae r2 = r2.a((com.applovin.exoplayer2.ba) r12, (com.applovin.exoplayer2.ae) r3)     // Catch:{ all -> 0x0128 }
            r1.fx = r2     // Catch:{ all -> 0x0128 }
            r1.cl()     // Catch:{ all -> 0x0128 }
        L_0x009d:
            com.applovin.exoplayer2.ad r1 = r1.ci()     // Catch:{ all -> 0x0128 }
            goto L_0x0084
        L_0x00a2:
            long r0 = r11.a((com.applovin.exoplayer2.h.p.a) r8, (long) r13, (boolean) r0)     // Catch:{ all -> 0x0128 }
            r13 = r0
        L_0x00a7:
            com.applovin.exoplayer2.al r0 = r11.cd
            com.applovin.exoplayer2.ba r4 = r0.ci
            com.applovin.exoplayer2.al r0 = r11.cd
            com.applovin.exoplayer2.h.p$a r5 = r0.dc
            boolean r0 = r7.dh
            if (r0 == 0) goto L_0x00b5
            r6 = r13
            goto L_0x00b7
        L_0x00b5:
            r6 = r18
        L_0x00b7:
            r1 = r24
            r2 = r25
            r3 = r8
            r1.a(r2, r3, r4, r5, r6)
            if (r16 != 0) goto L_0x00c9
            com.applovin.exoplayer2.al r0 = r11.cd
            long r0 = r0.de
            int r2 = (r9 > r0 ? 1 : (r9 == r0 ? 0 : -1))
            if (r2 == 0) goto L_0x0109
        L_0x00c9:
            com.applovin.exoplayer2.al r0 = r11.cd
            com.applovin.exoplayer2.h.p$a r0 = r0.dc
            java.lang.Object r0 = r0.gM
            com.applovin.exoplayer2.al r1 = r11.cd
            com.applovin.exoplayer2.ba r1 = r1.ci
            if (r16 == 0) goto L_0x00ea
            if (r26 == 0) goto L_0x00ea
            boolean r2 = r1.isEmpty()
            if (r2 != 0) goto L_0x00ea
            com.applovin.exoplayer2.ba$a r2 = r11.bI
            com.applovin.exoplayer2.ba$a r1 = r1.a((java.lang.Object) r0, (com.applovin.exoplayer2.ba.a) r2)
            boolean r1 = r1.iz
            if (r1 != 0) goto L_0x00ea
            r23 = 1
            goto L_0x00ec
        L_0x00ea:
            r23 = 0
        L_0x00ec:
            com.applovin.exoplayer2.al r1 = r11.cd
            long r5 = r1.gr
            int r0 = r12.c((java.lang.Object) r0)
            r1 = -1
            if (r0 != r1) goto L_0x00f9
            r17 = 4
        L_0x00f9:
            r1 = r24
            r2 = r8
            r3 = r13
            r7 = r5
            r5 = r9
            r9 = r23
            r10 = r17
            com.applovin.exoplayer2.al r0 = r1.a(r2, r3, r5, r7, r9, r10)
            r11.cd = r0
        L_0x0109:
            r24.bE()
            com.applovin.exoplayer2.al r0 = r11.cd
            com.applovin.exoplayer2.ba r0 = r0.ci
            r11.b((com.applovin.exoplayer2.ba) r12, (com.applovin.exoplayer2.ba) r0)
            com.applovin.exoplayer2.al r0 = r11.cd
            com.applovin.exoplayer2.al r0 = r0.c(r12)
            r11.cd = r0
            boolean r0 = r25.isEmpty()
            if (r0 != 0) goto L_0x0124
            r6 = 0
            r11.cF = r6
        L_0x0124:
            r11.s(r15)
            return
        L_0x0128:
            r0 = move-exception
        L_0x0129:
            r6 = 0
            goto L_0x012f
        L_0x012b:
            r0 = move-exception
            r15 = 0
            r20 = 4
        L_0x012f:
            com.applovin.exoplayer2.al r1 = r11.cd
            com.applovin.exoplayer2.ba r4 = r1.ci
            com.applovin.exoplayer2.al r1 = r11.cd
            com.applovin.exoplayer2.h.p$a r5 = r1.dc
            boolean r1 = r7.dh
            if (r1 == 0) goto L_0x013d
            r18 = r13
        L_0x013d:
            r1 = r24
            r2 = r25
            r3 = r8
            r15 = r6
            r6 = r18
            r1.a(r2, r3, r4, r5, r6)
            if (r16 != 0) goto L_0x0152
            com.applovin.exoplayer2.al r1 = r11.cd
            long r1 = r1.de
            int r3 = (r9 > r1 ? 1 : (r9 == r1 ? 0 : -1))
            if (r3 == 0) goto L_0x0192
        L_0x0152:
            com.applovin.exoplayer2.al r1 = r11.cd
            com.applovin.exoplayer2.h.p$a r1 = r1.dc
            java.lang.Object r1 = r1.gM
            com.applovin.exoplayer2.al r2 = r11.cd
            com.applovin.exoplayer2.ba r2 = r2.ci
            if (r16 == 0) goto L_0x0173
            if (r26 == 0) goto L_0x0173
            boolean r3 = r2.isEmpty()
            if (r3 != 0) goto L_0x0173
            com.applovin.exoplayer2.ba$a r3 = r11.bI
            com.applovin.exoplayer2.ba$a r2 = r2.a((java.lang.Object) r1, (com.applovin.exoplayer2.ba.a) r3)
            boolean r2 = r2.iz
            if (r2 != 0) goto L_0x0173
            r23 = 1
            goto L_0x0175
        L_0x0173:
            r23 = 0
        L_0x0175:
            com.applovin.exoplayer2.al r2 = r11.cd
            long r5 = r2.gr
            int r1 = r12.c((java.lang.Object) r1)
            r2 = -1
            if (r1 != r2) goto L_0x0182
            r17 = 4
        L_0x0182:
            r1 = r24
            r2 = r8
            r3 = r13
            r7 = r5
            r5 = r9
            r9 = r23
            r10 = r17
            com.applovin.exoplayer2.al r1 = r1.a(r2, r3, r5, r7, r9, r10)
            r11.cd = r1
        L_0x0192:
            r24.bE()
            com.applovin.exoplayer2.al r1 = r11.cd
            com.applovin.exoplayer2.ba r1 = r1.ci
            r11.b((com.applovin.exoplayer2.ba) r12, (com.applovin.exoplayer2.ba) r1)
            com.applovin.exoplayer2.al r1 = r11.cd
            com.applovin.exoplayer2.al r1 = r1.c(r12)
            r11.cd = r1
            boolean r1 = r25.isEmpty()
            if (r1 != 0) goto L_0x01ac
            r11.cF = r15
        L_0x01ac:
            r1 = 0
            r11.s(r1)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.applovin.exoplayer2.s.a(com.applovin.exoplayer2.ba, boolean):void");
    }

    private void a(ba baVar, p.a aVar, ba baVar2, p.a aVar2, long j) {
        if (!baVar.isEmpty() && a(baVar, aVar)) {
            baVar.a(baVar.a(aVar.gM, this.bI).cN, this.U);
            this.ct.a((ab.e) ai.R(this.U.eb));
            if (j != -9223372036854775807L) {
                this.ct.h(a(baVar, aVar.gM, j));
                return;
            }
            if (!ai.r(!baVar2.isEmpty() ? baVar2.a(baVar2.a(aVar2.gM, this.bI).cN, this.U).ch : null, this.U.ch)) {
                this.ct.h(-9223372036854775807L);
            }
        } else if (this.cp.av().gD != this.cd.gy.gD) {
            this.cp.a(this.cd.gy);
        }
    }

    private long bx() {
        ad cs2 = this.cr.cs();
        if (cs2 == null) {
            return 0;
        }
        long cd2 = cs2.cd();
        if (!cs2.fv) {
            return cd2;
        }
        int i = 0;
        while (true) {
            ar[] arVarArr = this.bB;
            if (i >= arVarArr.length) {
                return cd2;
            }
            if (e(arVarArr[i]) && this.bB[i].Q() == cs2.fu[i]) {
                long S = this.bB[i].S();
                if (S == Long.MIN_VALUE) {
                    return Long.MIN_VALUE;
                }
                cd2 = Math.max(S, cd2);
            }
            i++;
        }
    }

    private void by() throws p, IOException {
        if (!this.cd.ci.isEmpty() && this.cs.cw()) {
            bz();
            bA();
            bB();
            bD();
        }
    }

    private void bz() throws p {
        ae a2;
        this.cr.t(this.cG);
        if (this.cr.cp() && (a2 = this.cr.a(this.cG, this.cd)) != null) {
            ad a3 = this.cr.a(this.ck, this.bC, this.cl.ar(), this.cs, a2, this.bz);
            a3.ft.a((n.a) this, a2.fF);
            if (this.cr.cr() == a3) {
                l(a3.ce());
            }
            s(false);
        }
        if (this.cA) {
            this.cA = bJ();
            bK();
            return;
        }
        bH();
    }

    private void bA() {
        ad cs2 = this.cr.cs();
        if (cs2 != null) {
            int i = 0;
            if (cs2.ci() == null || this.cy) {
                if (cs2.fx.fL || this.cy) {
                    while (true) {
                        ar[] arVarArr = this.bB;
                        if (i < arVarArr.length) {
                            ar arVar = arVarArr[i];
                            x xVar = cs2.fu[i];
                            if (xVar != null && arVar.Q() == xVar && arVar.R()) {
                                a(arVar, (cs2.fx.fH == -9223372036854775807L || cs2.fx.fH == Long.MIN_VALUE) ? -9223372036854775807L : cs2.cd() + cs2.fx.fH);
                            }
                            i++;
                        } else {
                            return;
                        }
                    }
                }
            } else if (bG()) {
                if (cs2.ci().fv || this.cG >= cs2.ci().ce()) {
                    k ck2 = cs2.ck();
                    ad ct2 = this.cr.ct();
                    k ck3 = ct2.ck();
                    if (!ct2.fv || ct2.ft.kN() == -9223372036854775807L) {
                        for (int i2 = 0; i2 < this.bB.length; i2++) {
                            boolean eW = ck2.eW(i2);
                            boolean eW2 = ck3.eW(i2);
                            if (eW && !this.bB[i2].U()) {
                                boolean z = this.ck[i2].M() == -2;
                                at atVar = ck2.VD[i2];
                                at atVar2 = ck3.VD[i2];
                                if (!eW2 || !atVar2.equals(atVar) || z) {
                                    a(this.bB[i2], ct2.ce());
                                }
                            }
                        }
                        return;
                    }
                    m(ct2.ce());
                }
            }
        }
    }

    private void bB() throws p {
        ad cs2 = this.cr.cs();
        if (cs2 != null && this.cr.cr() != cs2 && !cs2.fy && bC()) {
            bL();
        }
    }

    private boolean bC() throws p {
        ad cs2 = this.cr.cs();
        k ck2 = cs2.ck();
        int i = 0;
        boolean z = false;
        while (true) {
            ar[] arVarArr = this.bB;
            if (i >= arVarArr.length) {
                return !z;
            }
            ar arVar = arVarArr[i];
            if (e(arVar)) {
                boolean z2 = arVar.Q() != cs2.fu[i];
                if (!ck2.eW(i) || z2) {
                    if (!arVar.U()) {
                        arVar.a(a(ck2.VE[i]), cs2.fu[i], cs2.ce(), cs2.cd());
                    } else if (arVar.cR()) {
                        d(arVar);
                    } else {
                        z = true;
                    }
                }
            }
            i++;
        }
    }

    private void bD() throws p {
        boolean z = false;
        while (bF()) {
            if (z) {
                bj();
            }
            ad cr2 = this.cr.cr();
            ad cu2 = this.cr.cu();
            al a2 = a(cu2.fx.fE, cu2.fx.fF, cu2.fx.de, cu2.fx.fF, true, 0);
            this.cd = a2;
            a(a2.ci, cu2.fx.fE, this.cd.ci, cr2.fx.fE, -9223372036854775807L);
            bE();
            bp();
            z = true;
        }
    }

    private void bE() {
        ad cr2 = this.cr.cr();
        this.cy = cr2 != null && cr2.fx.fK && this.cx;
    }

    private boolean bF() {
        ad cr2;
        ad ci;
        if (bN() && !this.cy && (cr2 = this.cr.cr()) != null && (ci = cr2.ci()) != null && this.cG >= ci.ce() && ci.fy) {
            return true;
        }
        return false;
    }

    private boolean bG() {
        ad cs2 = this.cr.cs();
        if (!cs2.fv) {
            return false;
        }
        int i = 0;
        while (true) {
            ar[] arVarArr = this.bB;
            if (i >= arVarArr.length) {
                return true;
            }
            ar arVar = arVarArr[i];
            x xVar = cs2.fu[i];
            if (arVar.Q() != xVar || (xVar != null && !arVar.R() && !a(arVar, cs2))) {
                return false;
            }
            i++;
        }
        return false;
    }

    private boolean a(ar arVar, ad adVar) {
        ad ci = adVar.ci();
        return adVar.fx.fI && ci.fv && ((arVar instanceof com.applovin.exoplayer2.i.m) || arVar.S() >= ci.ce());
    }

    private void m(long j) {
        for (ar arVar : this.bB) {
            if (arVar.Q() != null) {
                a(arVar, j);
            }
        }
    }

    private void a(ar arVar, long j) {
        arVar.T();
        if (arVar instanceof com.applovin.exoplayer2.i.m) {
            ((com.applovin.exoplayer2.i.m) arVar).bg(j);
        }
    }

    private void c(n nVar) throws p {
        if (this.cr.e(nVar)) {
            ad cq2 = this.cr.cq();
            cq2.a(this.cp.av().gD, this.cd.ci);
            a(cq2.cj(), cq2.ck());
            if (cq2 == this.cr.cr()) {
                l(cq2.fx.fF);
                bL();
                this.cd = a(this.cd.dc, cq2.fx.fF, this.cd.de, cq2.fx.fF, false, 5);
            }
            bH();
        }
    }

    private void d(n nVar) {
        if (this.cr.e(nVar)) {
            this.cr.t(this.cG);
            bH();
        }
    }

    private void a(am amVar, boolean z) throws p {
        a(amVar, amVar.gD, true, z);
    }

    private void a(am amVar, float f2, boolean z, boolean z2) throws p {
        if (z) {
            if (z2) {
                this.cv.x(1);
            }
            this.cd = this.cd.d(amVar);
        }
        c(amVar.gD);
        for (ar arVar : this.bB) {
            if (arVar != null) {
                arVar.a(f2, amVar.gD);
            }
        }
    }

    private void bH() {
        boolean bI2 = bI();
        this.cA = bI2;
        if (bI2) {
            this.cr.cq().u(this.cG);
        }
        bK();
    }

    private boolean bI() {
        long j;
        if (!bJ()) {
            return false;
        }
        ad cq2 = this.cr.cq();
        long n = n(cq2.ch());
        if (cq2 == this.cr.cr()) {
            j = cq2.r(this.cG);
        } else {
            j = cq2.r(this.cG) - cq2.fx.fF;
        }
        return this.cl.b(j, n, this.cp.av().gD);
    }

    private boolean bJ() {
        ad cq2 = this.cr.cq();
        if (cq2 == null || cq2.ch() == Long.MIN_VALUE) {
            return false;
        }
        return true;
    }

    private void bK() {
        ad cq2 = this.cr.cq();
        boolean z = this.cA || (cq2 != null && cq2.ft.kO());
        if (z != this.cd.aW) {
            this.cd = this.cd.t(z);
        }
    }

    private al a(p.a aVar, long j, long j2, long j3, boolean z, int i) {
        com.applovin.exoplayer2.common.a.s<com.applovin.exoplayer2.g.a> sVar;
        k kVar;
        ad adVar;
        ad adVar2;
        k kVar2;
        p.a aVar2 = aVar;
        long j4 = j2;
        this.cI = this.cI || j != this.cd.cO || !aVar.equals(this.cd.dc);
        bE();
        ad adVar3 = this.cd.fB;
        k kVar3 = this.cd.fC;
        List list = this.cd.gu;
        if (this.cs.cw()) {
            ad cr2 = this.cr.cr();
            if (cr2 == null) {
                adVar2 = ad.NG;
            } else {
                adVar2 = cr2.cj();
            }
            if (cr2 == null) {
                kVar2 = this.bz;
            } else {
                kVar2 = cr2.ck();
            }
            com.applovin.exoplayer2.common.a.s<com.applovin.exoplayer2.g.a> a2 = a(kVar2.VE);
            if (!(cr2 == null || cr2.fx.de == j4)) {
                cr2.fx = cr2.fx.w(j4);
            }
            adVar = adVar2;
            kVar = kVar2;
            sVar = a2;
        } else {
            if (!aVar.equals(this.cd.dc)) {
                adVar3 = ad.NG;
                kVar3 = this.bz;
                list = com.applovin.exoplayer2.common.a.s.ga();
            }
            adVar = adVar3;
            kVar = kVar3;
            sVar = list;
        }
        if (z) {
            this.cv.y(i);
        }
        return this.cd.a(aVar, j, j2, j3, bM(), adVar, kVar, sVar);
    }

    private com.applovin.exoplayer2.common.a.s<com.applovin.exoplayer2.g.a> a(com.applovin.exoplayer2.j.d[] dVarArr) {
        s.a aVar = new s.a();
        boolean z = false;
        for (com.applovin.exoplayer2.j.d dVar : dVarArr) {
            if (dVar != null) {
                v dZ = dVar.dZ(0);
                if (dZ.dx == null) {
                    aVar.t(new com.applovin.exoplayer2.g.a(new a.C0047a[0]));
                } else {
                    aVar.t(dZ.dx);
                    z = true;
                }
            }
        }
        return z ? aVar.gd() : com.applovin.exoplayer2.common.a.s.ga();
    }

    private void bL() throws p {
        a(new boolean[this.bB.length]);
    }

    private void a(boolean[] zArr) throws p {
        ad cs2 = this.cr.cs();
        k ck2 = cs2.ck();
        for (int i = 0; i < this.bB.length; i++) {
            if (!ck2.eW(i) && this.cj.remove(this.bB[i])) {
                this.bB[i].Y();
            }
        }
        for (int i2 = 0; i2 < this.bB.length; i2++) {
            if (ck2.eW(i2)) {
                c(i2, zArr[i2]);
            }
        }
        cs2.fy = true;
    }

    private void c(int i, boolean z) throws p {
        ar arVar = this.bB[i];
        if (!e(arVar)) {
            ad cs2 = this.cr.cs();
            boolean z2 = cs2 == this.cr.cr();
            k ck2 = cs2.ck();
            at atVar = ck2.VD[i];
            v[] a2 = a(ck2.VE[i]);
            boolean z3 = bN() && this.cd.gs == 3;
            boolean z4 = !z && z3;
            this.cE++;
            this.cj.add(arVar);
            arVar.a(atVar, a2, cs2.fu[i], this.cG, z4, z2, cs2.ce(), cs2.cd());
            arVar.a(11, new ar.a() {
                public void o(long j) {
                    if (j >= 2000) {
                        boolean unused = s.this.cC = true;
                    }
                }

                public void bP() {
                    s.this.cm.fs(2);
                }
            });
            this.cp.a(arVar);
            if (z3) {
                arVar.start();
            }
        }
    }

    private void s(boolean z) {
        long j;
        ad cq2 = this.cr.cq();
        p.a aVar = cq2 == null ? this.cd.dc : cq2.fx.fE;
        boolean z2 = !this.cd.gv.equals(aVar);
        if (z2) {
            this.cd = this.cd.b(aVar);
        }
        al alVar = this.cd;
        if (cq2 == null) {
            j = alVar.cO;
        } else {
            j = cq2.cg();
        }
        alVar.gA = j;
        this.cd.gB = bM();
        if ((z2 || z) && cq2 != null && cq2.fv) {
            a(cq2.cj(), cq2.ck());
        }
    }

    private long bM() {
        return n(this.cd.gA);
    }

    private long n(long j) {
        ad cq2 = this.cr.cq();
        if (cq2 == null) {
            return 0;
        }
        return Math.max(0, j - cq2.r(this.cG));
    }

    private void a(ad adVar, k kVar) {
        this.cl.a(this.bB, adVar, kVar.VE);
    }

    private boolean bN() {
        return this.cd.gw && this.cd.gx == 0;
    }

    private static f a(ba baVar, al alVar, g gVar, af afVar, int i, boolean z, ba.c cVar, ba.a aVar) {
        long j;
        boolean z2;
        boolean z3;
        boolean z4;
        int i2;
        p.a aVar2;
        int i3;
        long j2;
        long j3;
        af afVar2;
        long j4;
        long j5;
        int i4;
        boolean z5;
        int i5;
        int i6;
        boolean z6;
        boolean z7;
        boolean z8;
        ba baVar2 = baVar;
        al alVar2 = alVar;
        g gVar2 = gVar;
        boolean z9 = z;
        ba.a aVar3 = aVar;
        if (baVar.isEmpty()) {
            return new f(al.cB(), 0, -9223372036854775807L, false, true, false);
        }
        p.a aVar4 = alVar2.dc;
        Object obj = aVar4.gM;
        boolean a2 = a(alVar2, aVar3);
        if (alVar2.dc.la() || a2) {
            j = alVar2.de;
        } else {
            j = alVar2.cO;
        }
        long j6 = j;
        boolean z10 = false;
        if (gVar2 != null) {
            p.a aVar5 = aVar4;
            i2 = -1;
            Pair<Object, Long> a3 = a(baVar, gVar, true, i, z, cVar, aVar);
            if (a3 == null) {
                i6 = baVar2.d(z9);
                j2 = j6;
                z8 = false;
                z7 = false;
                z6 = true;
            } else {
                if (gVar2.di == -9223372036854775807L) {
                    i6 = baVar2.a(a3.first, aVar3).cN;
                    j2 = j6;
                    z8 = false;
                } else {
                    obj = a3.first;
                    j2 = ((Long) a3.second).longValue();
                    z8 = true;
                    i6 = -1;
                }
                z7 = alVar2.gs == 4;
                z6 = false;
            }
            ba.c cVar2 = cVar;
            z2 = z8;
            z4 = z7;
            z3 = z6;
            i3 = i6;
            aVar2 = aVar5;
        } else {
            p.a aVar6 = aVar4;
            i2 = -1;
            if (alVar2.ci.isEmpty()) {
                i4 = baVar2.d(z9);
            } else if (baVar2.c(obj) == -1) {
                Object a4 = a(cVar, aVar, i, z, obj, alVar2.ci, baVar);
                if (a4 == null) {
                    i5 = baVar2.d(z9);
                    z5 = true;
                } else {
                    i5 = baVar2.a(a4, aVar3).cN;
                    z5 = false;
                }
                ba.c cVar3 = cVar;
                i3 = i5;
                z3 = z5;
                j4 = j6;
                aVar2 = aVar6;
                z4 = false;
                z2 = false;
            } else if (j6 == -9223372036854775807L) {
                i4 = baVar2.a(obj, aVar3).cN;
            } else if (a2) {
                aVar2 = aVar6;
                alVar2.ci.a(aVar2.gM, aVar3);
                if (alVar2.ci.a(aVar3.cN, cVar).iQ == alVar2.ci.c(aVar2.gM)) {
                    Pair<Object, Long> a5 = baVar.a(cVar, aVar, baVar2.a(obj, aVar3).cN, j6 + aVar.df());
                    obj = a5.first;
                    j5 = ((Long) a5.second).longValue();
                } else {
                    j5 = j6;
                }
                i3 = -1;
                z4 = false;
                z3 = false;
                z2 = true;
            } else {
                ba.c cVar4 = cVar;
                aVar2 = aVar6;
                j4 = j6;
                i3 = -1;
                z4 = false;
                z3 = false;
                z2 = false;
            }
            ba.c cVar5 = cVar;
            i3 = i4;
            j4 = j6;
            aVar2 = aVar6;
            z4 = false;
            z3 = false;
            z2 = false;
        }
        if (i3 != i2) {
            Pair<Object, Long> a6 = baVar.a(cVar, aVar, i3, -9223372036854775807L);
            obj = a6.first;
            j2 = ((Long) a6.second).longValue();
            afVar2 = afVar;
            j3 = -9223372036854775807L;
        } else {
            afVar2 = afVar;
            j3 = j2;
        }
        p.a b2 = afVar2.b(baVar2, obj, j2);
        boolean z11 = b2.LM == i2 || (aVar2.LM != i2 && b2.gP >= aVar2.LM);
        boolean equals = aVar2.gM.equals(obj);
        boolean z12 = equals && !aVar2.la() && !b2.la() && z11;
        baVar2.a(obj, aVar3);
        if (equals && !a2 && j6 == j3 && ((b2.la() && aVar3.ap(b2.gP)) || (aVar2.la() && aVar3.ap(aVar2.gP)))) {
            z10 = true;
        }
        if (z12 || z10) {
            b2 = aVar2;
        }
        if (b2.la()) {
            if (b2.equals(aVar2)) {
                j2 = alVar2.cO;
            } else {
                baVar2.a(b2.gM, aVar3);
                j2 = b2.gQ == aVar3.am(b2.gP) ? aVar.di() : 0;
            }
        }
        return new f(b2, j2, j3, z4, z3, z2);
    }

    private static boolean a(al alVar, ba.a aVar) {
        p.a aVar2 = alVar.dc;
        ba baVar = alVar.ci;
        return baVar.isEmpty() || baVar.a(aVar2.gM, aVar).iz;
    }

    private static boolean a(c cVar, ba baVar, ba baVar2, int i, boolean z, ba.c cVar2, ba.a aVar) {
        long j;
        c cVar3 = cVar;
        ba baVar3 = baVar;
        ba baVar4 = baVar2;
        ba.c cVar4 = cVar2;
        ba.a aVar2 = aVar;
        if (cVar3.cV == null) {
            if (cVar3.cS.cJ() == Long.MIN_VALUE) {
                j = -9223372036854775807L;
            } else {
                j = h.g(cVar3.cS.cJ());
            }
            Pair<Object, Long> a2 = a(baVar, new g(cVar3.cS.bf(), cVar3.cS.cK(), j), false, i, z, cVar2, aVar);
            if (a2 == null) {
                return false;
            }
            cVar.a(baVar3.c(a2.first), ((Long) a2.second).longValue(), a2.first);
            if (cVar3.cS.cJ() == Long.MIN_VALUE) {
                a(baVar3, cVar, cVar4, aVar2);
            }
            return true;
        }
        int c2 = baVar3.c(cVar3.cV);
        if (c2 == -1) {
            return false;
        }
        if (cVar3.cS.cJ() == Long.MIN_VALUE) {
            a(baVar3, cVar, cVar4, aVar2);
            return true;
        }
        cVar3.cT = c2;
        baVar4.a(cVar3.cV, aVar2);
        if (aVar2.iz && baVar4.a(aVar2.cN, cVar4).iQ == baVar4.c(cVar3.cV)) {
            long df = cVar3.cU + aVar.df();
            Pair<Object, Long> a3 = baVar.a(cVar2, aVar, baVar3.a(cVar3.cV, aVar2).cN, df);
            cVar.a(baVar3.c(a3.first), ((Long) a3.second).longValue(), a3.first);
        }
        return true;
    }

    private static void a(ba baVar, c cVar, ba.c cVar2, ba.a aVar) {
        int i = baVar.a(baVar.a(cVar.cV, aVar).cN, cVar2).iR;
        cVar.a(i, aVar.fH != -9223372036854775807L ? aVar.fH - 1 : Long.MAX_VALUE, baVar.a(i, aVar, true).ch);
    }

    private static Pair<Object, Long> a(ba baVar, g gVar, boolean z, int i, boolean z2, ba.c cVar, ba.a aVar) {
        Object a2;
        ba baVar2 = baVar;
        g gVar2 = gVar;
        ba.a aVar2 = aVar;
        ba baVar3 = gVar2.ci;
        if (baVar.isEmpty()) {
            return null;
        }
        ba baVar4 = baVar3.isEmpty() ? baVar2 : baVar3;
        try {
            Pair<Object, Long> a3 = baVar4.a(cVar, aVar, gVar2.cN, gVar2.di);
            if (baVar.equals(baVar4)) {
                return a3;
            }
            if (baVar.c(a3.first) == -1) {
                ba.c cVar2 = cVar;
                if (z && (a2 = a(cVar, aVar, i, z2, a3.first, baVar4, baVar)) != null) {
                    return baVar.a(cVar, aVar, baVar.a(a2, aVar2).cN, -9223372036854775807L);
                }
                return null;
            } else if (!baVar4.a(a3.first, aVar2).iz || baVar4.a(aVar2.cN, cVar).iQ != baVar4.c(a3.first)) {
                return a3;
            } else {
                return baVar.a(cVar, aVar, baVar.a(a3.first, aVar2).cN, gVar2.di);
            }
        } catch (IndexOutOfBoundsException unused) {
        }
    }

    static Object a(ba.c cVar, ba.a aVar, int i, boolean z, Object obj, ba baVar, ba baVar2) {
        int c2 = baVar.c(obj);
        int cQ = baVar.cQ();
        int i2 = c2;
        int i3 = -1;
        for (int i4 = 0; i4 < cQ && i3 == -1; i4++) {
            i2 = baVar.a(i2, aVar, cVar, i, z);
            if (i2 == -1) {
                break;
            }
            i3 = baVar2.c(baVar.b(i2));
        }
        if (i3 == -1) {
            return null;
        }
        return baVar2.b(i3);
    }

    private static v[] a(com.applovin.exoplayer2.j.d dVar) {
        int kD = dVar != null ? dVar.kD() : 0;
        v[] vVarArr = new v[kD];
        for (int i = 0; i < kD; i++) {
            vVarArr[i] = dVar.dZ(i);
        }
        return vVarArr;
    }

    private static boolean e(ar arVar) {
        return arVar.P() != 0;
    }

    private static final class g {
        public final int cN;
        public final ba ci;
        public final long di;

        public g(ba baVar, int i, long j) {
            this.ci = baVar;
            this.cN = i;
            this.di = j;
        }
    }

    private static final class f {
        public final p.a dc;
        public final long dd;
        public final long de;
        public final boolean df;
        public final boolean dg;
        public final boolean dh;

        public f(p.a aVar, long j, long j2, boolean z, boolean z2, boolean z3) {
            this.dc = aVar;
            this.dd = j;
            this.de = j2;
            this.df = z;
            this.dg = z2;
            this.dh = z3;
        }
    }

    private static final class c implements Comparable<c> {
        public final ao cS;
        public int cT;
        public long cU;
        public Object cV;

        public void a(int i, long j, Object obj) {
            this.cT = i;
            this.cU = j;
            this.cV = obj;
        }

        public c(ao aoVar) {
            this.cS = aoVar;
        }

        /* renamed from: a */
        public int compareTo(c cVar) {
            Object obj = this.cV;
            if ((obj == null) != (cVar.cV == null)) {
                return obj != null ? -1 : 1;
            }
            if (obj == null) {
                return 0;
            }
            int i = this.cT - cVar.cT;
            if (i != 0) {
                return i;
            }
            return ai.B(this.cU, cVar.cU);
        }
    }

    private static final class a {
        /* access modifiers changed from: private */
        public final z C;
        /* access modifiers changed from: private */
        public final List<ah.c> cM;
        /* access modifiers changed from: private */
        public final int cN;
        /* access modifiers changed from: private */
        public final long cO;

        private a(List<ah.c> list, z zVar, int i, long j) {
            this.cM = list;
            this.C = zVar;
            this.cN = i;
            this.cO = j;
        }
    }
}
