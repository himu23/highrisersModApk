package com.applovin.exoplayer2;

import android.os.Looper;
import android.util.Pair;
import android.view.SurfaceView;
import android.view.TextureView;
import com.applovin.exoplayer2.ah;
import com.applovin.exoplayer2.an;
import com.applovin.exoplayer2.ao;
import com.applovin.exoplayer2.ba;
import com.applovin.exoplayer2.h.ad;
import com.applovin.exoplayer2.h.p;
import com.applovin.exoplayer2.h.z;
import com.applovin.exoplayer2.j.h;
import com.applovin.exoplayer2.j.j;
import com.applovin.exoplayer2.j.k;
import com.applovin.exoplayer2.k.d;
import com.applovin.exoplayer2.l.ai;
import com.applovin.exoplayer2.l.o;
import com.applovin.exoplayer2.l.p;
import com.applovin.exoplayer2.q;
import com.applovin.exoplayer2.s;
import com.ironsource.m2;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArraySet;

final class r extends d {
    private z C;
    final an.a bA;
    private final ar[] bB;
    private final j bC;
    private final o bD;
    private final s.e bE;
    private final s bF;
    private final p<an.b> bG;
    private final CopyOnWriteArraySet<q.a> bH;
    private final ba.a bI;
    private final List<a> bJ;
    private final boolean bK;
    private final com.applovin.exoplayer2.h.r bL;
    private final com.applovin.exoplayer2.a.a bM;
    private final Looper bN;
    private final d bO;
    private final long bP;
    private final long bQ;
    private final com.applovin.exoplayer2.l.d bR;
    private int bS;
    private boolean bT;
    private int bU;
    private int bV;
    private boolean bW;
    private int bX;
    private av bY;
    private boolean bZ;
    final k bz;
    private an.a ca;
    private ac cb;
    private ac cc;
    private al cd;
    private int ce;
    private int cf;
    private long cg;

    public void a(SurfaceView surfaceView) {
    }

    public void a(TextureView textureView) {
    }

    public an.a aA() {
        return this.ca;
    }

    public int aF() {
        return this.bS;
    }

    public boolean aG() {
        return this.bT;
    }

    public long aH() {
        return this.bP;
    }

    public long aI() {
        return this.bQ;
    }

    public long aJ() {
        return 3000;
    }

    public ac aW() {
        return this.cb;
    }

    public Looper az() {
        return this.bN;
    }

    public void b(SurfaceView surfaceView) {
    }

    public void b(TextureView textureView) {
    }

    /* JADX WARNING: type inference failed for: r38v0, types: [com.applovin.exoplayer2.an] */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public r(com.applovin.exoplayer2.ar[] r20, com.applovin.exoplayer2.j.j r21, com.applovin.exoplayer2.h.r r22, com.applovin.exoplayer2.aa r23, com.applovin.exoplayer2.k.d r24, com.applovin.exoplayer2.a.a r25, boolean r26, com.applovin.exoplayer2.av r27, long r28, long r30, com.applovin.exoplayer2.z r32, long r33, boolean r35, com.applovin.exoplayer2.l.d r36, android.os.Looper r37, com.applovin.exoplayer2.an r38, com.applovin.exoplayer2.an.a r39) {
        /*
            r19 = this;
            r0 = r19
            r2 = r20
            r6 = r24
            r9 = r25
            r15 = r36
            r14 = r37
            r19.<init>()
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            java.lang.String r3 = "Init "
            r1.<init>(r3)
            int r3 = java.lang.System.identityHashCode(r19)
            java.lang.String r3 = java.lang.Integer.toHexString(r3)
            r1.append(r3)
            java.lang.String r3 = " [ExoPlayerLib/2.15.1] ["
            r1.append(r3)
            java.lang.String r3 = com.applovin.exoplayer2.l.ai.acZ
            r1.append(r3)
            java.lang.String r3 = "]"
            r1.append(r3)
            java.lang.String r1 = r1.toString()
            java.lang.String r3 = "ExoPlayerImpl"
            com.applovin.exoplayer2.l.q.g(r3, r1)
            int r1 = r2.length
            r3 = 0
            if (r1 <= 0) goto L_0x003f
            r1 = 1
            goto L_0x0040
        L_0x003f:
            r1 = 0
        L_0x0040:
            com.applovin.exoplayer2.l.a.checkState(r1)
            java.lang.Object r1 = com.applovin.exoplayer2.l.a.checkNotNull(r20)
            com.applovin.exoplayer2.ar[] r1 = (com.applovin.exoplayer2.ar[]) r1
            r0.bB = r1
            java.lang.Object r1 = com.applovin.exoplayer2.l.a.checkNotNull(r21)
            com.applovin.exoplayer2.j.j r1 = (com.applovin.exoplayer2.j.j) r1
            r0.bC = r1
            r1 = r22
            r0.bL = r1
            r0.bO = r6
            r0.bM = r9
            r1 = r26
            r0.bK = r1
            r10 = r27
            r0.bY = r10
            r4 = r28
            r0.bP = r4
            r4 = r30
            r0.bQ = r4
            r12 = r35
            r0.bZ = r12
            r0.bN = r14
            r0.bR = r15
            r0.bS = r3
            if (r38 == 0) goto L_0x007a
            r1 = r38
            goto L_0x007b
        L_0x007a:
            r1 = r0
        L_0x007b:
            com.applovin.exoplayer2.l.p r4 = new com.applovin.exoplayer2.l.p
            com.applovin.exoplayer2.r$$ExternalSyntheticLambda13 r5 = new com.applovin.exoplayer2.r$$ExternalSyntheticLambda13
            r5.<init>(r1)
            r4.<init>(r14, r15, r5)
            r0.bG = r4
            java.util.concurrent.CopyOnWriteArraySet r4 = new java.util.concurrent.CopyOnWriteArraySet
            r4.<init>()
            r0.bH = r4
            java.util.ArrayList r4 = new java.util.ArrayList
            r4.<init>()
            r0.bJ = r4
            com.applovin.exoplayer2.h.z$a r4 = new com.applovin.exoplayer2.h.z$a
            r4.<init>(r3)
            r0.C = r4
            com.applovin.exoplayer2.j.k r4 = new com.applovin.exoplayer2.j.k
            int r3 = r2.length
            com.applovin.exoplayer2.at[] r3 = new com.applovin.exoplayer2.at[r3]
            int r5 = r2.length
            com.applovin.exoplayer2.j.d[] r5 = new com.applovin.exoplayer2.j.d[r5]
            r7 = 0
            r4.<init>(r3, r5, r7)
            r0.bz = r4
            com.applovin.exoplayer2.ba$a r3 = new com.applovin.exoplayer2.ba$a
            r3.<init>()
            r0.bI = r3
            com.applovin.exoplayer2.an$a$a r3 = new com.applovin.exoplayer2.an$a$a
            r3.<init>()
            r5 = 10
            int[] r5 = new int[r5]
            r5 = {1, 2, 12, 13, 14, 15, 16, 17, 18, 19} // fill-array
            com.applovin.exoplayer2.an$a$a r3 = r3.a(r5)
            r5 = 28
            boolean r8 = r21.nh()
            com.applovin.exoplayer2.an$a$a r3 = r3.d(r5, r8)
            r5 = r39
            com.applovin.exoplayer2.an$a$a r3 = r3.c(r5)
            com.applovin.exoplayer2.an$a r3 = r3.cC()
            r0.bA = r3
            com.applovin.exoplayer2.an$a$a r5 = new com.applovin.exoplayer2.an$a$a
            r5.<init>()
            com.applovin.exoplayer2.an$a$a r3 = r5.c(r3)
            r5 = 3
            com.applovin.exoplayer2.an$a$a r3 = r3.Y(r5)
            r5 = 9
            com.applovin.exoplayer2.an$a$a r3 = r3.Y(r5)
            com.applovin.exoplayer2.an$a r3 = r3.cC()
            r0.ca = r3
            com.applovin.exoplayer2.ac r3 = com.applovin.exoplayer2.ac.eM
            r0.cb = r3
            com.applovin.exoplayer2.ac r3 = com.applovin.exoplayer2.ac.eM
            r0.cc = r3
            r3 = -1
            r0.ce = r3
            com.applovin.exoplayer2.l.o r3 = r15.a(r14, r7)
            r0.bD = r3
            com.applovin.exoplayer2.r$$ExternalSyntheticLambda14 r13 = new com.applovin.exoplayer2.r$$ExternalSyntheticLambda14
            r13.<init>(r0)
            r0.bE = r13
            com.applovin.exoplayer2.al r3 = com.applovin.exoplayer2.al.a((com.applovin.exoplayer2.j.k) r4)
            r0.cd = r3
            if (r9 == 0) goto L_0x011f
            r9.a((com.applovin.exoplayer2.an) r1, (android.os.Looper) r14)
            r0.a((com.applovin.exoplayer2.an.d) r9)
            android.os.Handler r1 = new android.os.Handler
            r1.<init>(r14)
            r6.a(r1, r9)
        L_0x011f:
            com.applovin.exoplayer2.s r11 = new com.applovin.exoplayer2.s
            r1 = r11
            int r7 = r0.bS
            boolean r8 = r0.bT
            r2 = r20
            r3 = r21
            r5 = r23
            r6 = r24
            r9 = r25
            r10 = r27
            r18 = r11
            r11 = r32
            r17 = r13
            r12 = r33
            r14 = r35
            r15 = r37
            r16 = r36
            r1.<init>(r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r14, r15, r16, r17)
            r1 = r18
            r0.bF = r1
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.applovin.exoplayer2.r.<init>(com.applovin.exoplayer2.ar[], com.applovin.exoplayer2.j.j, com.applovin.exoplayer2.h.r, com.applovin.exoplayer2.aa, com.applovin.exoplayer2.k.d, com.applovin.exoplayer2.a.a, boolean, com.applovin.exoplayer2.av, long, long, com.applovin.exoplayer2.z, long, boolean, com.applovin.exoplayer2.l.d, android.os.Looper, com.applovin.exoplayer2.an, com.applovin.exoplayer2.an$a):void");
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void b(s.d dVar) {
        this.bD.e(new r$$ExternalSyntheticLambda11(this, dVar));
    }

    public void j(long j) {
        this.bF.j(j);
    }

    public boolean ay() {
        return this.cd.gz;
    }

    public void a(an.d dVar) {
        a((an.b) dVar);
    }

    public void b(an.d dVar) {
        b((an.b) dVar);
    }

    public void a(an.b bVar) {
        this.bG.add(bVar);
    }

    public void b(an.b bVar) {
        this.bG.O(bVar);
    }

    public void a(q.a aVar) {
        this.bH.add(aVar);
    }

    public int aB() {
        return this.cd.gs;
    }

    public int aC() {
        return this.cd.gx;
    }

    /* renamed from: aw */
    public p ax() {
        return this.cd.gt;
    }

    public void aD() {
        if (this.cd.gs == 1) {
            al a2 = this.cd.a((p) null);
            al W = a2.W(a2.ci.isEmpty() ? 4 : 2);
            this.bU++;
            this.bF.aD();
            a(W, 1, 1, false, false, 5, -9223372036854775807L, -1);
        }
    }

    public void a(com.applovin.exoplayer2.h.p pVar) {
        b((List<com.applovin.exoplayer2.h.p>) Collections.singletonList(pVar));
    }

    public void b(List<com.applovin.exoplayer2.h.p> list) {
        a(list, true);
    }

    public void a(List<com.applovin.exoplayer2.h.p> list, boolean z) {
        a(list, -1, -9223372036854775807L, z);
    }

    public void k(boolean z) {
        a(z, 0, 1);
    }

    public void a(boolean z, int i, int i2) {
        if (this.cd.gw != z || this.cd.gx != i) {
            this.bU++;
            al c = this.cd.c(z, i);
            this.bF.b(z, i);
            a(c, 0, i2, false, false, 5, -9223372036854775807L, -1);
        }
    }

    public boolean aE() {
        return this.cd.gw;
    }

    public void u(int i) {
        if (this.bS != i) {
            this.bS = i;
            this.bF.u(i);
            this.bG.a(8, new r$$ExternalSyntheticLambda8(i));
            bb();
            this.bG.oZ();
        }
    }

    public void l(boolean z) {
        if (this.bT != z) {
            this.bT = z;
            this.bF.l(z);
            this.bG.a(9, new r$$ExternalSyntheticLambda9(z));
            bb();
            this.bG.oZ();
        }
    }

    public void a(int i, long j) {
        int i2 = i;
        long j2 = j;
        ba baVar = this.cd.ci;
        if (i2 < 0 || (!baVar.isEmpty() && i2 >= baVar.cP())) {
            throw new y(baVar, i, j2);
        }
        int i3 = 1;
        this.bU++;
        if (aP()) {
            com.applovin.exoplayer2.l.q.h("ExoPlayerImpl", "seekTo ignored because an ad is playing");
            s.d dVar = new s.d(this.cd);
            dVar.x(1);
            this.bE.onPlaybackInfoUpdate(dVar);
            return;
        }
        if (aB() != 1) {
            i3 = 2;
        }
        int aL = aL();
        al a2 = a(this.cd.W(i3), baVar, a(baVar, i, j2));
        this.bF.b(baVar, i, h.g(j));
        a(a2, 0, 1, true, true, 1, a(a2), aL);
    }

    public am av() {
        return this.cd.gy;
    }

    public void a(boolean z, p pVar) {
        al alVar;
        if (z) {
            alVar = b(0, this.bJ.size()).a((p) null);
        } else {
            al alVar2 = this.cd;
            alVar = alVar2.b(alVar2.dc);
            alVar.gA = alVar.cO;
            alVar.gB = 0;
        }
        al W = alVar.W(1);
        if (pVar != null) {
            W = W.a(pVar);
        }
        al alVar3 = W;
        this.bU++;
        this.bF.W();
        a(alVar3, 0, 1, false, alVar3.ci.isEmpty() && !this.cd.ci.isEmpty(), 4, a(alVar3), -1);
    }

    public void release() {
        com.applovin.exoplayer2.l.q.g("ExoPlayerImpl", "Release " + Integer.toHexString(System.identityHashCode(this)) + " [ExoPlayerLib/2.15.1] [" + ai.acZ + "] [" + t.bQ() + m2.i.e);
        if (!this.bF.bg()) {
            this.bG.b(10, new r$$ExternalSyntheticLambda0());
        }
        this.bG.release();
        this.bD.Q((Object) null);
        com.applovin.exoplayer2.a.a aVar = this.bM;
        if (aVar != null) {
            this.bO.a(aVar);
        }
        al W = this.cd.W(1);
        this.cd = W;
        al b = W.b(W.dc);
        this.cd = b;
        b.gA = b.cO;
        this.cd.gB = 0;
    }

    public ao a(ao.b bVar) {
        return new ao(this.bF, bVar, this.cd.ci, aL(), this.bR, this.bF.bh());
    }

    public int aK() {
        if (this.cd.ci.isEmpty()) {
            return this.cf;
        }
        return this.cd.ci.c(this.cd.dc.gM);
    }

    public int aL() {
        int ba = ba();
        if (ba == -1) {
            return 0;
        }
        return ba;
    }

    public long aM() {
        if (!aP()) {
            return K();
        }
        p.a aVar = this.cd.dc;
        this.cd.ci.a(aVar.gM, this.bI);
        return h.f(this.bI.i(aVar.gP, aVar.gQ));
    }

    public long aN() {
        return h.f(a(this.cd));
    }

    public long aO() {
        return h.f(this.cd.gB);
    }

    public boolean aP() {
        return this.cd.dc.la();
    }

    public int aQ() {
        if (aP()) {
            return this.cd.dc.gP;
        }
        return -1;
    }

    public int aR() {
        if (aP()) {
            return this.cd.dc.gQ;
        }
        return -1;
    }

    public long aS() {
        if (!aP()) {
            return aN();
        }
        this.cd.ci.a(this.cd.dc.gM, this.bI);
        if (this.cd.de == -9223372036854775807L) {
            return this.cd.ci.a(aL(), this.U).dj();
        }
        return this.bI.de() + h.f(this.cd.de);
    }

    public long aT() {
        if (this.cd.ci.isEmpty()) {
            return this.cg;
        }
        if (this.cd.gv.LL != this.cd.dc.LL) {
            return this.cd.ci.a(aL(), this.U).dl();
        }
        long j = this.cd.gA;
        if (this.cd.gv.la()) {
            ba.a a2 = this.cd.ci.a(this.cd.gv.gM, this.bI);
            long al = a2.al(this.cd.gv.gP);
            j = al == Long.MIN_VALUE ? a2.fH : al;
        }
        return h.f(a(this.cd.ci, this.cd.gv, j));
    }

    public ad aU() {
        return this.cd.fB;
    }

    public h aV() {
        return new h(this.cd.fC.VE);
    }

    public void a(com.applovin.exoplayer2.g.a aVar) {
        ac cc2 = this.cb.cb().c(aVar).cc();
        if (!cc2.equals(this.cb)) {
            this.cb = cc2;
            this.bG.b(14, new r$$ExternalSyntheticLambda12(this));
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void d(an.b bVar) {
        bVar.a(this.cb);
    }

    public ba aX() {
        return this.cd.ci;
    }

    public com.applovin.exoplayer2.m.o aY() {
        return com.applovin.exoplayer2.m.o.afk;
    }

    /* renamed from: aZ */
    public com.applovin.exoplayer2.common.a.s<com.applovin.exoplayer2.i.a> bd() {
        return com.applovin.exoplayer2.common.a.s.ga();
    }

    private int ba() {
        if (this.cd.ci.isEmpty()) {
            return this.ce;
        }
        return this.cd.ci.a(this.cd.dc.gM, this.bI).cN;
    }

    private long a(al alVar) {
        if (alVar.ci.isEmpty()) {
            return h.g(this.cg);
        }
        if (alVar.dc.la()) {
            return alVar.cO;
        }
        return a(alVar.ci, alVar.dc, alVar.cO);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void c(s.d dVar) {
        long j;
        boolean z;
        this.bU -= dVar.cX;
        boolean z2 = true;
        if (dVar.cY) {
            this.bV = dVar.cZ;
            this.bW = true;
        }
        if (dVar.da) {
            this.bX = dVar.db;
        }
        if (this.bU == 0) {
            ba baVar = dVar.cd.ci;
            if (!this.cd.ci.isEmpty() && baVar.isEmpty()) {
                this.ce = -1;
                this.cg = 0;
                this.cf = 0;
            }
            if (!baVar.isEmpty()) {
                List<ba> cO = ((ap) baVar).cO();
                com.applovin.exoplayer2.l.a.checkState(cO.size() == this.bJ.size());
                for (int i = 0; i < cO.size(); i++) {
                    ba unused = this.bJ.get(i).ci = cO.get(i);
                }
            }
            long j2 = -9223372036854775807L;
            if (this.bW) {
                if (dVar.cd.dc.equals(this.cd.dc) && dVar.cd.gr == this.cd.cO) {
                    z2 = false;
                }
                if (z2) {
                    if (baVar.isEmpty() || dVar.cd.dc.la()) {
                        j2 = dVar.cd.gr;
                    } else {
                        j2 = a(baVar, dVar.cd.dc, dVar.cd.gr);
                    }
                }
                j = j2;
                z = z2;
            } else {
                j = -9223372036854775807L;
                z = false;
            }
            this.bW = false;
            a(dVar.cd, 1, this.bX, false, z, this.bV, j, -1);
        }
    }

    private void a(al alVar, int i, int i2, boolean z, boolean z2, int i3, long j, int i4) {
        al alVar2 = alVar;
        int i5 = i3;
        al alVar3 = this.cd;
        this.cd = alVar2;
        Pair<Boolean, Integer> a2 = a(alVar, alVar3, z2, i3, !alVar3.ci.equals(alVar2.ci));
        boolean booleanValue = ((Boolean) a2.first).booleanValue();
        int intValue = ((Integer) a2.second).intValue();
        ac acVar = this.cb;
        ab abVar = null;
        if (booleanValue) {
            if (!alVar2.ci.isEmpty()) {
                abVar = alVar2.ci.a(alVar2.ci.a(alVar2.dc.gM, this.bI).cN, this.U).gL;
            }
            acVar = abVar != null ? abVar.cb : ac.eM;
        }
        if (!alVar3.gu.equals(alVar2.gu)) {
            acVar = acVar.cb().d(alVar2.gu).cc();
        }
        boolean z3 = !acVar.equals(this.cb);
        this.cb = acVar;
        if (!alVar3.ci.equals(alVar2.ci)) {
            int i6 = i;
            this.bG.a(0, new r$$ExternalSyntheticLambda15(alVar, i));
        }
        if (z2) {
            this.bG.a(11, new r$$ExternalSyntheticLambda21(i5, a(i5, alVar3, i4), k(j)));
        }
        if (booleanValue) {
            this.bG.a(1, new r$$ExternalSyntheticLambda22(abVar, intValue));
        }
        if (alVar3.gt != alVar2.gt) {
            this.bG.a(10, new r$$ExternalSyntheticLambda1(alVar));
            if (alVar2.gt != null) {
                this.bG.a(10, new r$$ExternalSyntheticLambda2(alVar));
            }
        }
        if (alVar3.fC != alVar2.fC) {
            this.bC.J(alVar2.fC.VF);
            this.bG.a(2, new r$$ExternalSyntheticLambda3(alVar, new h(alVar2.fC.VE)));
        }
        if (z3) {
            this.bG.a(14, new r$$ExternalSyntheticLambda4(this.cb));
        }
        if (alVar3.aW != alVar2.aW) {
            this.bG.a(3, new r$$ExternalSyntheticLambda5(alVar));
        }
        if (!(alVar3.gs == alVar2.gs && alVar3.gw == alVar2.gw)) {
            this.bG.a(-1, new r$$ExternalSyntheticLambda6(alVar));
        }
        if (alVar3.gs != alVar2.gs) {
            this.bG.a(4, new r$$ExternalSyntheticLambda7(alVar));
        }
        if (alVar3.gw != alVar2.gw) {
            this.bG.a(5, new r$$ExternalSyntheticLambda16(alVar, i2));
        }
        if (alVar3.gx != alVar2.gx) {
            this.bG.a(6, new r$$ExternalSyntheticLambda17(alVar));
        }
        if (c(alVar3) != c(alVar)) {
            this.bG.a(7, new r$$ExternalSyntheticLambda18(alVar));
        }
        if (!alVar3.gy.equals(alVar2.gy)) {
            this.bG.a(12, new r$$ExternalSyntheticLambda19(alVar));
        }
        if (z) {
            this.bG.a(-1, new r$$ExternalSyntheticLambda20());
        }
        bb();
        this.bG.oZ();
        if (alVar3.cD != alVar2.cD) {
            Iterator<q.a> it = this.bH.iterator();
            while (it.hasNext()) {
                it.next().i(alVar2.cD);
            }
        }
        if (alVar3.gz != alVar2.gz) {
            Iterator<q.a> it2 = this.bH.iterator();
            while (it2.hasNext()) {
                it2.next().j(alVar2.gz);
            }
        }
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ void a(int i, an.e eVar, an.e eVar2, an.b bVar) {
        bVar.ac(i);
        bVar.a(eVar, eVar2, i);
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ void f(al alVar, an.b bVar) {
        bVar.x(alVar.aW);
        bVar.w(alVar.aW);
    }

    private an.e a(int i, al alVar, int i2) {
        int i3;
        Object obj;
        ab abVar;
        int i4;
        Object obj2;
        long j;
        long j2;
        al alVar2 = alVar;
        ba.a aVar = new ba.a();
        if (!alVar2.ci.isEmpty()) {
            Object obj3 = alVar2.dc.gM;
            alVar2.ci.a(obj3, aVar);
            int i5 = aVar.cN;
            int c = alVar2.ci.c(obj3);
            Object obj4 = alVar2.ci.a(i5, this.U).ch;
            abVar = this.U.gL;
            obj = obj3;
            i3 = c;
            obj2 = obj4;
            i4 = i5;
        } else {
            i4 = i2;
            obj2 = null;
            abVar = null;
            obj = null;
            i3 = -1;
        }
        if (i == 0) {
            j = aVar.iy + aVar.fH;
            if (alVar2.dc.la()) {
                j = aVar.i(alVar2.dc.gP, alVar2.dc.gQ);
                j2 = b(alVar);
                return new an.e(obj2, i4, abVar, obj, i3, h.f(j), h.f(j2), alVar2.dc.gP, alVar2.dc.gQ);
            } else if (alVar2.dc.LM != -1 && this.cd.dc.la()) {
                j = b(this.cd);
            }
        } else if (alVar2.dc.la()) {
            j = alVar2.cO;
            j2 = b(alVar);
            return new an.e(obj2, i4, abVar, obj, i3, h.f(j), h.f(j2), alVar2.dc.gP, alVar2.dc.gQ);
        } else {
            j = aVar.iy + alVar2.cO;
        }
        j2 = j;
        return new an.e(obj2, i4, abVar, obj, i3, h.f(j), h.f(j2), alVar2.dc.gP, alVar2.dc.gQ);
    }

    private an.e k(long j) {
        int i;
        Object obj;
        ab abVar;
        Object obj2;
        int aL = aL();
        if (!this.cd.ci.isEmpty()) {
            Object obj3 = this.cd.dc.gM;
            this.cd.ci.a(obj3, this.bI);
            i = this.cd.ci.c(obj3);
            obj2 = this.cd.ci.a(aL, this.U).ch;
            abVar = this.U.gL;
            obj = obj3;
        } else {
            obj2 = null;
            abVar = null;
            obj = null;
            i = -1;
        }
        long f = h.f(j);
        return new an.e(obj2, aL, abVar, obj, i, f, this.cd.dc.la() ? h.f(b(this.cd)) : f, this.cd.dc.gP, this.cd.dc.gQ);
    }

    private static long b(al alVar) {
        ba.c cVar = new ba.c();
        ba.a aVar = new ba.a();
        alVar.ci.a(alVar.dc.gM, aVar);
        if (alVar.de == -9223372036854775807L) {
            return alVar.ci.a(aVar.cN, cVar).dk();
        }
        return aVar.df() + alVar.de;
    }

    private Pair<Boolean, Integer> a(al alVar, al alVar2, boolean z, int i, boolean z2) {
        ba baVar = alVar2.ci;
        ba baVar2 = alVar.ci;
        if (baVar2.isEmpty() && baVar.isEmpty()) {
            return new Pair<>(false, -1);
        }
        int i2 = 3;
        if (baVar2.isEmpty() != baVar.isEmpty()) {
            return new Pair<>(true, 3);
        }
        if (!baVar.a(baVar.a(alVar2.dc.gM, this.bI).cN, this.U).ch.equals(baVar2.a(baVar2.a(alVar.dc.gM, this.bI).cN, this.U).ch)) {
            if (z && i == 0) {
                i2 = 1;
            } else if (z && i == 1) {
                i2 = 2;
            } else if (!z2) {
                throw new IllegalStateException();
            }
            return new Pair<>(true, Integer.valueOf(i2));
        } else if (!z || i != 0 || alVar2.dc.LL >= alVar.dc.LL) {
            return new Pair<>(false, -1);
        } else {
            return new Pair<>(true, 0);
        }
    }

    private void bb() {
        an.a aVar = this.ca;
        an.a a2 = a(this.bA);
        this.ca = a2;
        if (!a2.equals(aVar)) {
            this.bG.a(13, new r$$ExternalSyntheticLambda10(this));
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void c(an.b bVar) {
        bVar.d(this.ca);
    }

    private void a(List<com.applovin.exoplayer2.h.p> list, int i, long j, boolean z) {
        int i2;
        long j2;
        int i3 = i;
        int ba = ba();
        long aN = aN();
        boolean z2 = true;
        this.bU++;
        if (!this.bJ.isEmpty()) {
            c(0, this.bJ.size());
        }
        List<ah.c> a2 = a(0, list);
        ba bc = bc();
        if (bc.isEmpty() || i3 < bc.cP()) {
            long j3 = j;
            if (z) {
                j2 = -9223372036854775807L;
                i2 = bc.d(this.bT);
            } else if (i3 == -1) {
                i2 = ba;
                j2 = aN;
            } else {
                i2 = i3;
                j2 = j3;
            }
            al a3 = a(this.cd, bc, a(bc, i2, j2));
            int i4 = a3.gs;
            if (!(i2 == -1 || a3.gs == 1)) {
                i4 = (bc.isEmpty() || i2 >= bc.cP()) ? 4 : 2;
            }
            al W = a3.W(i4);
            this.bF.a(a2, i2, h.g(j2), this.C);
            if (this.cd.dc.gM.equals(W.dc.gM) || this.cd.ci.isEmpty()) {
                z2 = false;
            }
            a(W, 0, 1, false, z2, 4, a(W), -1);
            return;
        }
        throw new y(bc, i3, j);
    }

    private List<ah.c> a(int i, List<com.applovin.exoplayer2.h.p> list) {
        ArrayList arrayList = new ArrayList();
        for (int i2 = 0; i2 < list.size(); i2++) {
            ah.c cVar = new ah.c(list.get(i2), this.bK);
            arrayList.add(cVar);
            this.bJ.add(i2 + i, new a(cVar.ch, cVar.gi.bf()));
        }
        this.C = this.C.E(i, arrayList.size());
        return arrayList;
    }

    private al b(int i, int i2) {
        com.applovin.exoplayer2.l.a.checkArgument(i >= 0 && i2 >= i && i2 <= this.bJ.size());
        int aL = aL();
        ba aX = aX();
        int size = this.bJ.size();
        this.bU++;
        c(i, i2);
        ba bc = bc();
        al a2 = a(this.cd, bc, a(aX, bc));
        if (a2.gs != 1 && a2.gs != 4 && i < i2 && i2 == size && aL >= a2.ci.cP()) {
            a2 = a2.W(4);
        }
        this.bF.a(i, i2, this.C);
        return a2;
    }

    private void c(int i, int i2) {
        for (int i3 = i2 - 1; i3 >= i; i3--) {
            this.bJ.remove(i3);
        }
        this.C = this.C.F(i, i2);
    }

    private ba bc() {
        return new ap(this.bJ, this.C);
    }

    private al a(al alVar, ba baVar, Pair<Object, Long> pair) {
        k kVar;
        List list;
        int i;
        long j;
        ba baVar2 = baVar;
        Pair<Object, Long> pair2 = pair;
        com.applovin.exoplayer2.l.a.checkArgument(baVar.isEmpty() || pair2 != null);
        ba baVar3 = alVar.ci;
        al c = alVar.c(baVar);
        if (baVar.isEmpty()) {
            p.a cB = al.cB();
            long g = h.g(this.cg);
            al b = c.a(cB, g, g, g, 0, ad.NG, this.bz, com.applovin.exoplayer2.common.a.s.ga()).b(cB);
            b.gA = b.cO;
            return b;
        }
        Object obj = c.dc.gM;
        boolean z = !obj.equals(((Pair) ai.R(pair)).first);
        p.a aVar = z ? new p.a(pair2.first) : c.dc;
        long longValue = ((Long) pair2.second).longValue();
        long g2 = h.g(aS());
        if (!baVar3.isEmpty()) {
            g2 -= baVar3.a(obj, this.bI).df();
        }
        if (z || longValue < g2) {
            p.a aVar2 = aVar;
            com.applovin.exoplayer2.l.a.checkState(!aVar2.la());
            ad adVar = z ? ad.NG : c.fB;
            p.a aVar3 = aVar2;
            if (z) {
                kVar = this.bz;
            } else {
                kVar = c.fC;
            }
            k kVar2 = kVar;
            if (z) {
                list = com.applovin.exoplayer2.common.a.s.ga();
            } else {
                list = c.gu;
            }
            al b2 = c.a(aVar3, longValue, longValue, longValue, 0, adVar, kVar2, list).b(aVar3);
            b2.gA = longValue;
            return b2;
        }
        if (i == 0) {
            int c2 = baVar2.c(c.gv.gM);
            if (c2 == -1 || baVar2.a(c2, this.bI).cN != baVar2.a(aVar.gM, this.bI).cN) {
                baVar2.a(aVar.gM, this.bI);
                if (aVar.la()) {
                    j = this.bI.i(aVar.gP, aVar.gQ);
                } else {
                    j = this.bI.fH;
                }
                c = c.a(aVar, c.cO, c.cO, c.gr, j - c.cO, c.fB, c.fC, c.gu).b(aVar);
                c.gA = j;
            }
        } else {
            p.a aVar4 = aVar;
            com.applovin.exoplayer2.l.a.checkState(!aVar4.la());
            long max = Math.max(0, c.gB - (longValue - g2));
            long j2 = c.gA;
            if (c.gv.equals(c.dc)) {
                j2 = longValue + max;
            }
            c = c.a(aVar4, longValue, longValue, longValue, max, c.fB, c.fC, c.gu);
            c.gA = j2;
        }
        return c;
    }

    private Pair<Object, Long> a(ba baVar, ba baVar2) {
        long aS = aS();
        int i = -1;
        if (baVar.isEmpty() || baVar2.isEmpty()) {
            boolean z = !baVar.isEmpty() && baVar2.isEmpty();
            if (!z) {
                i = ba();
            }
            if (z) {
                aS = -9223372036854775807L;
            }
            return a(baVar2, i, aS);
        }
        Pair<Object, Long> a2 = baVar.a(this.U, this.bI, aL(), h.g(aS));
        Object obj = ((Pair) ai.R(a2)).first;
        if (baVar2.c(obj) != -1) {
            return a2;
        }
        Object a3 = s.a(this.U, this.bI, this.bS, this.bT, obj, baVar, baVar2);
        if (a3 == null) {
            return a(baVar2, -1, -9223372036854775807L);
        }
        baVar2.a(a3, this.bI);
        return a(baVar2, this.bI.cN, baVar2.a(this.bI.cN, this.U).dj());
    }

    private Pair<Object, Long> a(ba baVar, int i, long j) {
        if (baVar.isEmpty()) {
            this.ce = i;
            if (j == -9223372036854775807L) {
                j = 0;
            }
            this.cg = j;
            this.cf = 0;
            return null;
        }
        if (i == -1 || i >= baVar.cP()) {
            i = baVar.d(this.bT);
            j = baVar.a(i, this.U).dj();
        }
        return baVar.a(this.U, this.bI, i, h.g(j));
    }

    private long a(ba baVar, p.a aVar, long j) {
        baVar.a(aVar.gM, this.bI);
        return j + this.bI.df();
    }

    private static boolean c(al alVar) {
        return alVar.gs == 3 && alVar.gw && alVar.gx == 0;
    }

    private static final class a implements ag {
        private final Object ch;
        /* access modifiers changed from: private */
        public ba ci;

        public Object be() {
            return this.ch;
        }

        public ba bf() {
            return this.ci;
        }

        public a(Object obj, ba baVar) {
            this.ch = obj;
            this.ci = baVar;
        }
    }
}
